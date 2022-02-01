package com.tencent.av;

import SharpSvrPack.MultiVideoMsg;
import SharpSvrPack.SharpVideoMsg;
import VideoSvrPack.VideoCallMsg;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.MessageHandler;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.chatroom.ChatRoomMng;
import com.tencent.av.gaudio.Memberinfo;
import com.tencent.av.report.AVReport;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.QAVNotificationUtil;
import com.tencent.av.utils.SeqUtil;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.report.StrupBuff;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.os.MqqHandler;
import tencent.im.cs.longconn.hd_video.MsgBody;
import tencent.im.cs.longconn.hd_video.RspBody;
import tencent.im.cs.longconn.hd_video.VideoHead;
import tencent.im.oidb.cmd0x625.Oidb_0x625.Open2Tiny_ReqBody;
import tencent.im.oidb.cmd0x625.Oidb_0x625.Open2Tiny_RspBody;
import tencent.im.oidb.cmd0x625.Oidb_0x625.OpenIDInfoReq;
import tencent.im.oidb.cmd0x626.Oidb_0x626.Tiny2Open_RspBody;
import tencent.im.oidb.cmd0xa02.cmd0xa02.ReqBody;
import tencent.im.oidb.cmd0xa02.cmd0xa02.RspBody;
import tencent.im.oidb.cmd0xa02.cmd0xa02.TinyID;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class VideoServlet
  extends MSFServlet
{
  private VideoAppInterface a;
  private final List<IVideoServant> b = new ArrayList(2);
  
  public VideoServlet()
  {
    this.b.add(new MultiVideoServant());
  }
  
  private int a()
  {
    if (AudioUtil.a() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoServlet", 2, "phone ring mode is slient");
      }
      return 1;
    }
    return 0;
  }
  
  private void a(MultiVideoMsg paramMultiVideoMsg)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendMultiVideoAck, seq: ");
      ((StringBuilder)localObject).append(paramMultiVideoMsg.msg_seq);
      ((StringBuilder)localObject).append(", videoMsg.type:");
      ((StringBuilder)localObject).append(paramMultiVideoMsg.type);
      ((StringBuilder)localObject).append(", videoMsg.from_uin:");
      ((StringBuilder)localObject).append(paramMultiVideoMsg.from_uin);
      ((StringBuilder)localObject).append(", videoMsg.to_uin.get(0):");
      ((StringBuilder)localObject).append(paramMultiVideoMsg.to_uin.get(0));
      ((StringBuilder)localObject).append(", +videoMsg.to_uin.size():");
      ((StringBuilder)localObject).append(paramMultiVideoMsg.to_uin.size());
      QLog.d("VideoServlet", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new NewIntent(this.a.getApplication(), VideoServlet.class);
    ((NewIntent)localObject).putExtra("reqType", 9);
    ((NewIntent)localObject).putExtra("ver", paramMultiVideoMsg.ver);
    ((NewIntent)localObject).putExtra("type", paramMultiVideoMsg.type);
    ((NewIntent)localObject).putExtra("cscmd", paramMultiVideoMsg.csCmd);
    ((NewIntent)localObject).putExtra("subcmd", paramMultiVideoMsg.subCmd);
    ((NewIntent)localObject).putExtra("from_uin", paramMultiVideoMsg.from_uin);
    ((NewIntent)localObject).putExtra("to_uin", (Serializable)paramMultiVideoMsg.to_uin.get(0));
    ((NewIntent)localObject).putExtra("video_buff", paramMultiVideoMsg.video_buff);
    ((NewIntent)localObject).putExtra("msg_seq", paramMultiVideoMsg.msg_seq);
    ((NewIntent)localObject).putExtra("msg_uid", paramMultiVideoMsg.msg_uid);
    ((NewIntent)localObject).putExtra("msg_type", paramMultiVideoMsg.msg_type);
    ((NewIntent)localObject).putExtra("msg_time", paramMultiVideoMsg.msg_time);
    ((NewIntent)localObject).putExtra("erroMsg", "success");
    service((Intent)localObject);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    QLog.w("VideoServlet", 1, "showNotification() enter");
    if (paramArrayOfByte == null)
    {
      QLog.w("VideoServlet", 1, "showNotification() return ! video_buff = null");
      return;
    }
    paramArrayOfByte = VideoPackageUtils.a(paramArrayOfByte);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.a()))
    {
      VideoNodeManager.a(34);
      QAVNotificationUtil.a("VideoServlet", SessionMgr.a(3, String.valueOf(paramArrayOfByte.h), new int[0]), this.a, paramArrayOfByte);
      return;
    }
    QLog.w("VideoServlet", 1, "showNotification() return ! videoPacket == null && videoPacket is not isRequestMsg");
  }
  
  public static long[] a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    Object localObject1;
    int i;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parseVideoMsgSubServiceTypeAndRoomID,");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(" parseSubType:");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", buff.len=");
      if (paramArrayOfByte == null) {
        i = 0;
      } else {
        i = paramArrayOfByte.length;
      }
      ((StringBuilder)localObject1).append(i);
      QLog.d("VideoServlet", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject4;
    int k;
    long l1;
    label476:
    Object localObject2;
    label818:
    Object localObject3;
    if ("SharpSvr.c2sack".equalsIgnoreCase(paramString1))
    {
      localObject1 = new hd_video.RspBody();
      if (paramArrayOfByte != null)
      {
        try
        {
          localObject1 = (hd_video.RspBody)((hd_video.RspBody)localObject1).mergeFrom(paramArrayOfByte);
          if (((hd_video.RspBody)localObject1).msg_video_head.has())
          {
            localObject1 = (hd_video.VideoHead)((hd_video.RspBody)localObject1).msg_video_head.get();
            j = ((hd_video.VideoHead)localObject1).enum_body_type.get();
            localObject4 = ((hd_video.VideoHead)localObject1).uint64_uin;
            try
            {
              l2 = ((PBUInt64Field)localObject4).get();
              if (((hd_video.VideoHead)localObject1).int32_sub_service_type.has()) {
                i = ((hd_video.VideoHead)localObject1).int32_sub_service_type.get();
              } else {
                i = -1;
              }
              try
              {
                k = ((hd_video.VideoHead)localObject1).uint32_seq.get();
                l1 = ((hd_video.VideoHead)localObject1).uint64_room_id.get();
                try
                {
                  if (QLog.isColorLevel())
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append(paramString2);
                    ((StringBuilder)localObject1).append(" bodyType=");
                    ((StringBuilder)localObject1).append(j);
                    ((StringBuilder)localObject1).append(", subServiceType=");
                    ((StringBuilder)localObject1).append(i);
                    ((StringBuilder)localObject1).append(", uin=");
                    ((StringBuilder)localObject1).append(l2);
                    ((StringBuilder)localObject1).append(", seq=");
                    ((StringBuilder)localObject1).append(k);
                    ((StringBuilder)localObject1).append(", roomId=");
                    ((StringBuilder)localObject1).append(l1);
                    localObject1 = ((StringBuilder)localObject1).toString();
                    try
                    {
                      QLog.d("VideoServlet", 2, (String)localObject1);
                    }
                    catch (Exception localException1) {}
                  }
                }
                catch (Exception localException2) {}
              }
              catch (Exception localException3)
              {
                l1 = -1L;
              }
              try
              {
                if (!QLog.isColorLevel()) {
                  break label476;
                }
                StringBuilder localStringBuilder1 = new StringBuilder();
                localStringBuilder1.append(paramString2);
                localStringBuilder1.append(" head not exist");
                QLog.e("VideoServlet", 2, localStringBuilder1.toString());
              }
              catch (Exception localException5) {}
            }
            catch (Exception localException4) {}
          }
          l1 = -1L;
        }
        catch (Exception localException6) {}
        i = -1;
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(paramString2);
          ((StringBuilder)localObject4).append(" invalid format:");
          ((StringBuilder)localObject4).append(localException6.toString());
          QLog.e("VideoServlet", 2, ((StringBuilder)localObject4).toString());
        }
      }
      else
      {
        i = -1;
        l1 = -1L;
      }
      localObject2 = "VideoServlet";
    }
    else if ("SharpSvr.s2c".equalsIgnoreCase(paramString1))
    {
      localObject2 = new hd_video.MsgBody();
      if (paramArrayOfByte != null)
      {
        try
        {
          localObject2 = (hd_video.MsgBody)((hd_video.MsgBody)localObject2).mergeFrom(paramArrayOfByte);
          if (((hd_video.MsgBody)localObject2).msg_video_head.has())
          {
            localObject2 = (hd_video.VideoHead)((hd_video.MsgBody)localObject2).msg_video_head.get();
            j = ((hd_video.VideoHead)localObject2).enum_body_type.get();
            l2 = ((hd_video.VideoHead)localObject2).uint64_uin.get();
            if (((hd_video.VideoHead)localObject2).int32_sub_service_type.has()) {
              i = ((hd_video.VideoHead)localObject2).int32_sub_service_type.get();
            } else {
              i = -1;
            }
            try
            {
              k = ((hd_video.VideoHead)localObject2).uint32_seq.get();
              localObject2 = ((hd_video.VideoHead)localObject2).uint64_room_id;
              try
              {
                l1 = ((PBUInt64Field)localObject2).get();
                try
                {
                  if (QLog.isColorLevel())
                  {
                    localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append(paramString2);
                    ((StringBuilder)localObject2).append(" bodyType=");
                    ((StringBuilder)localObject2).append(j);
                    ((StringBuilder)localObject2).append(", subServiceType=");
                    ((StringBuilder)localObject2).append(i);
                    ((StringBuilder)localObject2).append(", uin=");
                    ((StringBuilder)localObject2).append(l2);
                    ((StringBuilder)localObject2).append(", seq=");
                    ((StringBuilder)localObject2).append(k);
                    ((StringBuilder)localObject2).append(", roomId=");
                    ((StringBuilder)localObject2).append(l1);
                    localObject2 = ((StringBuilder)localObject2).toString();
                    try
                    {
                      QLog.d("VideoServlet", 2, (String)localObject2);
                    }
                    catch (Exception localException7) {}
                  }
                }
                catch (Exception localException8) {}
              }
              catch (Exception localException9)
              {
                break label818;
              }
              try
              {
                if (!QLog.isColorLevel()) {
                  break label890;
                }
                StringBuilder localStringBuilder2 = new StringBuilder();
                localStringBuilder2.append(paramString2);
                localStringBuilder2.append(" head not exist");
                QLog.e("VideoServlet", 2, localStringBuilder2.toString());
              }
              catch (Exception localException11) {}
            }
            catch (Exception localException10) {}
          }
          i = -1;
        }
        catch (Exception localException12) {}
        l1 = -1L;
        localObject4 = "VideoServlet";
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder3 = new StringBuilder();
          localStringBuilder3.append(paramString2);
          localStringBuilder3.append(" invalid format:");
          localStringBuilder3.append(localException12.toString());
          QLog.e("VideoServlet", 2, localStringBuilder3.toString());
        }
        localObject3 = localObject4;
      }
      else
      {
        label890:
        l1 = -1L;
        i = -1;
        localObject3 = "VideoServlet";
      }
    }
    else
    {
      localObject3 = "VideoServlet";
      l1 = -1L;
      i = -1;
    }
    long l2 = i;
    int j = 0;
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("parseVideoMsgSubServiceTypeAndRoomID,");
      ((StringBuilder)localObject4).append(paramString2);
      ((StringBuilder)localObject4).append(" parseSubType = ");
      ((StringBuilder)localObject4).append(paramString1);
      ((StringBuilder)localObject4).append(", buff.len = ");
      if (paramArrayOfByte != null) {
        j = paramArrayOfByte.length;
      }
      ((StringBuilder)localObject4).append(j);
      ((StringBuilder)localObject4).append(",subServiceType = ");
      ((StringBuilder)localObject4).append(i);
      ((StringBuilder)localObject4).append(",roomId = ");
      ((StringBuilder)localObject4).append(l1);
      QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
    }
    return new long[] { l2, l1 };
  }
  
  private long b(String paramString)
  {
    long l = 0L;
    if (paramString != null) {
      if (paramString.length() <= 0) {
        return 0L;
      }
    }
    try
    {
      l = CharacterUtil.b(paramString);
      if (l < 10000L) {
        return 0L;
      }
      return l;
    }
    catch (NumberFormatException paramString) {}
    return 0L;
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    AudioHelper.a("onRspGroupVideoInviteMemberMsgMsg", paramIntent.getExtras());
    int i = paramFromServiceMsg.getWupBuffer().length - 4;
    Object localObject = new byte[i];
    PkgTools.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    for (;;)
    {
      try
      {
        ReqGroupVideo.RspGetInvitedMemberList localRspGetInvitedMemberList = new ReqGroupVideo.RspGetInvitedMemberList();
        localRspGetInvitedMemberList.mergeFrom((byte[])localObject);
        paramFromServiceMsg = (common.ErrorInfo)localRspGetInvitedMemberList.result.get();
        i = MessageHandler.a(paramFromServiceMsg);
        if (paramFromServiceMsg.bytes_errmsg.has())
        {
          paramFromServiceMsg = paramFromServiceMsg.bytes_errmsg.get().toStringUtf8();
          long l1 = localRspGetInvitedMemberList.uint64_group.get();
          long l2 = localRspGetInvitedMemberList.uint64_room_id.get();
          localObject = new ArrayList();
          int k = i;
          if (localRspGetInvitedMemberList.rpt_member_list.has())
          {
            int j = 0;
            k = i;
            if (j < localRspGetInvitedMemberList.rpt_member_list.size())
            {
              ReqGroupVideo.MemberInfo localMemberInfo = (ReqGroupVideo.MemberInfo)((ReqGroupVideo.MemberInfo)localRspGetInvitedMemberList.rpt_member_list.get(j)).get();
              ((ArrayList)localObject).add(new Memberinfo(localMemberInfo.uint64_member_uin.get(), localMemberInfo.uint32_invite_timestamp.get()));
              j += 1;
              continue;
            }
          }
          boolean bool = paramIntent.getBooleanExtra("requestInviteMemberMode", true);
          if ((this.a instanceof VideoAppInterface))
          {
            paramIntent = this.a;
            if (!bool) {
              paramIntent.b().b(l1, l2, (ArrayList)localObject);
            } else {
              this.a.a(new Object[] { Integer.valueOf(709), Long.valueOf(l1), Long.valueOf(l2), localObject });
            }
          }
          else
          {
            this.a.a(new Object[] { Integer.valueOf(708), Long.valueOf(l1), Long.valueOf(l2), localObject });
          }
          paramIntent = new StringBuilder();
          paramIntent.append("onRspGroupVideoInviteMemberMsgMsg, uint32_errcode[");
          paramIntent.append(k);
          paramIntent.append("], bytes_errmsg[");
          paramIntent.append(paramFromServiceMsg);
          paramIntent.append("]groupID=");
          paramIntent.append(l1);
          paramIntent.append(",uint64_roomId=");
          paramIntent.append(l2);
          paramIntent.append(",single = ");
          paramIntent.append(bool);
          paramIntent.append(",inviteListSize =");
          paramIntent.append(localRspGetInvitedMemberList.rpt_member_list.size());
          QLog.w("VideoServlet", 1, paramIntent.toString());
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.w("VideoServlet", 1, "onRspGroupVideoInviteMemberMsgMsg, Exception", paramIntent);
        return;
      }
      paramFromServiceMsg = "";
    }
  }
  
  private void b(Packet paramPacket, Bundle paramBundle)
  {
    paramPacket.setServantName("MultiVideo");
    paramPacket.setFuncName("MultiVideoMsg");
    paramPacket.setSSOCommand("MultiVideo.c2s");
    paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(true));
    MultiVideoMsg localMultiVideoMsg = new MultiVideoMsg();
    localMultiVideoMsg.ver = paramBundle.getByte("ver");
    localMultiVideoMsg.type = paramBundle.getByte("type");
    localMultiVideoMsg.csCmd = paramBundle.getShort("cscmd");
    localMultiVideoMsg.from_uin = b(String.valueOf(paramBundle.getLong("from_uin")));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramBundle.getLong("toUin")));
    localMultiVideoMsg.to_uin = localArrayList;
    localMultiVideoMsg.msg_time = paramBundle.getLong("msg_time");
    localMultiVideoMsg.msg_type = paramBundle.getLong("msg_type");
    localMultiVideoMsg.msg_seq = paramBundle.getLong("msg_seq");
    localMultiVideoMsg.msg_uid = paramBundle.getLong("msg_uid");
    localMultiVideoMsg.video_buff = paramBundle.getByteArray("vMsg");
    paramPacket.addRequestPacket("MultiVideoMsg", localMultiVideoMsg);
  }
  
  private void c(SharpVideoMsg paramSharpVideoMsg)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendSharpVideoAck, seq: ");
      ((StringBuilder)localObject).append(paramSharpVideoMsg.msg_seq);
      ((StringBuilder)localObject).append(", videoMsg.type:");
      ((StringBuilder)localObject).append(paramSharpVideoMsg.type);
      ((StringBuilder)localObject).append(", videoMsg.from_uin:");
      ((StringBuilder)localObject).append(paramSharpVideoMsg.from_uin);
      ((StringBuilder)localObject).append(", videoMsg.to_uin.get(0):");
      ((StringBuilder)localObject).append(paramSharpVideoMsg.to_uin.get(0));
      ((StringBuilder)localObject).append(", +videoMsg.to_uin.size():");
      ((StringBuilder)localObject).append(paramSharpVideoMsg.to_uin.size());
      QLog.d("VideoServlet", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new NewIntent(this.a.getApplication(), VideoServlet.class);
    ((NewIntent)localObject).setWithouLogin(true);
    ((NewIntent)localObject).putExtra("reqType", 5);
    ((NewIntent)localObject).putExtra("ver", paramSharpVideoMsg.ver);
    ((NewIntent)localObject).putExtra("type", paramSharpVideoMsg.type);
    ((NewIntent)localObject).putExtra("from_uin", paramSharpVideoMsg.from_uin);
    ((NewIntent)localObject).putExtra("to_uin", (Serializable)paramSharpVideoMsg.to_uin.get(0));
    ((NewIntent)localObject).putExtra("video_buff", paramSharpVideoMsg.video_buff);
    ((NewIntent)localObject).putExtra("msg_seq", paramSharpVideoMsg.msg_seq);
    ((NewIntent)localObject).putExtra("msg_uid", paramSharpVideoMsg.msg_uid);
    ((NewIntent)localObject).putExtra("msg_type", paramSharpVideoMsg.msg_type);
    ((NewIntent)localObject).putExtra("msg_time", paramSharpVideoMsg.msg_time);
    ((NewIntent)localObject).putExtra("terminal_type", paramSharpVideoMsg.call_type);
    ((NewIntent)localObject).putExtra("erroMsg", "success");
    service((Intent)localObject);
  }
  
  private void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    AudioHelper.a("onRspGroupVideoTerminateMsg", paramIntent.getExtras());
    int i = paramFromServiceMsg.getWupBuffer().length - 4;
    paramIntent = new byte[i];
    PkgTools.copyData(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new ReqGroupVideo.RspGroupVideoTerminate();
        paramFromServiceMsg.mergeFrom(paramIntent);
        paramIntent = (common.ErrorInfo)paramFromServiceMsg.result.get();
        i = MessageHandler.a(paramIntent);
        if (paramIntent.bytes_errmsg.has())
        {
          paramIntent = paramIntent.bytes_errmsg.get().toStringUtf8();
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("onRspGroupVideoTerminateMsg, errorCode[");
          paramFromServiceMsg.append(i);
          paramFromServiceMsg.append("], errorMsg[");
          paramFromServiceMsg.append(paramIntent);
          paramFromServiceMsg.append("]");
          QLog.w("VideoServlet", 1, paramFromServiceMsg.toString());
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.w("VideoServlet", 1, "onRspGroupVideoTerminateMsg, Exception", paramIntent);
        return;
      }
      paramIntent = "";
    }
  }
  
  private void c(Packet paramPacket, Bundle paramBundle)
  {
    AudioHelper.a("inviteMember_msg", paramBundle);
    paramPacket.setServantName("MultiVideo");
    paramPacket.setFuncName("MultiVideoMsg");
    paramPacket.setSSOCommand("QQRTCSvc.group_video_invite_list");
    paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(true));
    long l1 = paramBundle.getLong("groupuin");
    long l2 = paramBundle.getLong("groupcode");
    paramBundle = new ReqGroupVideo.ReqGetInvitedMemberList();
    paramBundle.uint64_group.set(l1);
    paramBundle.uint64_room_id.set(l2);
    paramPacket.putSendData(WupUtil.a(paramBundle.toByteArray()));
  }
  
  private void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent != null)
    {
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
    }
    else
    {
      paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
    }
    ((VideoAppInterface)getAppRuntime()).receiveToService(paramIntent, paramFromServiceMsg);
  }
  
  private void d(Packet paramPacket, Bundle paramBundle)
  {
    AudioHelper.a("reqGroupVideoTerminateMsg", paramBundle);
    paramPacket.setServantName("MultiVideo");
    paramPacket.setFuncName("MultiVideoMsg");
    paramPacket.setSSOCommand("QQRTCSvc.group_video_terminate_msg");
    paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(true));
    long l1 = paramBundle.getLong("selfuin");
    long l2 = paramBundle.getLong("groupuin");
    long l3 = paramBundle.getLong("groupcode");
    paramBundle = new ReqGroupVideo.ReqGroupVideoTerminate();
    paramBundle.uint64_operator.set(l1);
    paramBundle.uint64_group.set(l2);
    paramBundle.uint64_room_id.set(l3);
    paramPacket.putSendData(WupUtil.a(paramBundle.toByteArray()));
  }
  
  public IVideoServant a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    Iterator localIterator = this.b.iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (IVideoServant)localIterator.next();
    } while ((localObject1 == null) || (!((IVideoServant)localObject1).a(paramString)));
    return localObject1;
  }
  
  void a(int paramInt, Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    AudioHelper.a("onRspVideoCodecMsg", paramIntent.getExtras());
    paramInt = paramFromServiceMsg.getWupBuffer().length - 4;
    if ((paramFromServiceMsg.isSuccess()) && (paramInt > 0))
    {
      localObject = new byte[paramInt];
      PkgTools.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, paramInt);
      paramFromServiceMsg = (FromServiceMsg)localObject;
    }
    else
    {
      paramFromServiceMsg = null;
    }
    if (paramFromServiceMsg == null)
    {
      AudioHelper.a("onRspVideoCodecMsg fail", paramIntent.getExtras());
      return;
    }
    Object localObject = new HardWareCodecSSO.ConfigRsp();
    try
    {
      ((HardWareCodecSSO.ConfigRsp)localObject).mergeFrom(paramFromServiceMsg);
      ThreadManager.getSubThreadHandler().post(new VideoServlet.1(this, (HardWareCodecSSO.ConfigRsp)localObject));
      return;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      paramFromServiceMsg.printStackTrace();
      AudioHelper.a("onRspVideoCodecMsg InvalidProtocolBufferMicroException", paramIntent.getExtras());
    }
  }
  
  void a(SharpVideoMsg paramSharpVideoMsg)
  {
    Object localObject = paramSharpVideoMsg.video_buff;
    long l1 = paramSharpVideoMsg.from_uin;
    long l2 = ((Long)paramSharpVideoMsg.to_uin.get(0)).longValue();
    Friends localFriends = (Friends)((VideoAppInterface)getAppRuntime()).getEntityManagerFactory(null).createEntityManager().find(Friends.class, String.valueOf(l1));
    String str;
    boolean bool;
    if (localFriends != null)
    {
      str = localFriends.getFriendNick();
      bool = localFriends.isFriend();
    }
    else
    {
      str = CharacterUtil.a(l1);
      bool = false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", String.valueOf(l2));
    localBundle.putString("fromUin", CharacterUtil.a(l1));
    localBundle.putByteArray("buffer", (byte[])localObject);
    localBundle.putLong("time", paramSharpVideoMsg.msg_time);
    localBundle.putString("name", str);
    localBundle.putBoolean("isFriend", bool);
    this.a.b().n.receiveSharpVideoMsg(localBundle);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleSharpVideoMessage, friendName[");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("], friendRemark[");
      if (localFriends == null) {
        paramSharpVideoMsg = "";
      } else {
        paramSharpVideoMsg = localFriends.remark;
      }
      ((StringBuilder)localObject).append(paramSharpVideoMsg);
      ((StringBuilder)localObject).append("], isFriend[");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("]");
      QLog.w("VideoServlet", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = paramFromServiceMsg.getServiceCmd();
    if (MsfMsgUtil.getGatewayIpMsg(null).getServiceCmd().equalsIgnoreCase((String)localObject))
    {
      paramIntent = (String)paramFromServiceMsg.getAttribute(MsfMsgUtil.getGatewayIpMsg(null).getServiceCmd());
      if (paramIntent != null)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("parse getGatewayIpMsg Ok ");
          paramFromServiceMsg.append(paramIntent);
          paramFromServiceMsg.append(" cmd ");
          paramFromServiceMsg.append((String)localObject);
          QLog.d("VideoServlet", 2, paramFromServiceMsg.toString());
        }
        this.a.b().d(paramIntent, 0);
      }
    }
    else if (MsfMsgUtil.getSetConnStatusMsg(null, 0).getServiceCmd().equalsIgnoreCase((String)localObject))
    {
      paramIntent = (Integer)paramFromServiceMsg.getAttribute("status");
      if (QLog.isColorLevel()) {
        QLog.d("VideoServlet", 2, String.format("onReceive SetConnStatusMsg status=%s", new Object[] { paramIntent }));
      }
      if (paramIntent != null)
      {
        paramFromServiceMsg = this.a.c();
        if (paramFromServiceMsg != null) {
          paramFromServiceMsg.a(paramIntent.intValue());
        }
      }
    }
    else
    {
      int i;
      if ("OidbSvc.0x625".equalsIgnoreCase((String)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive");
        }
        if (paramFromServiceMsg.isSuccess()) {
          try
          {
            i = paramFromServiceMsg.getWupBuffer().length - 4;
            localObject = new byte[i];
            PkgTools.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
            paramIntent = new oidb_sso.OIDBSSOPkg();
            paramIntent.mergeFrom((byte[])localObject);
            if (paramIntent.uint32_result.get() != 0)
            {
              if (!QLog.isColorLevel()) {
                return;
              }
              paramFromServiceMsg = new StringBuilder();
              paramFromServiceMsg.append("CMD_OIDB_0x625 onReceive uint32_result = ");
              paramFromServiceMsg.append(paramIntent.uint32_result.get());
              QLog.d("VideoServlet", 2, paramFromServiceMsg.toString());
              return;
            }
            if (!paramIntent.bytes_bodybuffer.has()) {
              return;
            }
            paramFromServiceMsg = new Oidb_0x625.Open2Tiny_RspBody();
            paramFromServiceMsg.mergeFrom(paramIntent.bytes_bodybuffer.get().toByteArray());
            paramIntent = paramFromServiceMsg.msg_tinyid_rsp_info.get();
            if (!QLog.isColorLevel()) {
              return;
            }
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("CMD_OIDB_0x625 onReceive list = ");
            paramFromServiceMsg.append(paramIntent.toString());
            QLog.d("VideoServlet", 2, paramFromServiceMsg.toString());
            return;
          }
          catch (Exception paramIntent)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive Exception!");
            }
            paramIntent.printStackTrace();
            return;
          }
        } else if (QLog.isColorLevel()) {
          QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive not success!");
        }
      }
      else if ("OidbSvc.0xa02".equalsIgnoreCase((String)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive");
        }
        if (paramFromServiceMsg.isSuccess()) {
          try
          {
            i = paramFromServiceMsg.getWupBuffer().length - 4;
            localObject = new byte[i];
            PkgTools.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
            paramIntent = new oidb_sso.OIDBSSOPkg();
            paramIntent.mergeFrom((byte[])localObject);
            if (paramIntent.uint32_result.get() != 0)
            {
              if (!QLog.isColorLevel()) {
                return;
              }
              paramFromServiceMsg = new StringBuilder();
              paramFromServiceMsg.append("CMD_OIDB_0x626 onReceive uint32_result = ");
              paramFromServiceMsg.append(paramIntent.uint32_result.get());
              QLog.d("VideoServlet", 2, paramFromServiceMsg.toString());
              return;
            }
            if (!paramIntent.bytes_bodybuffer.has()) {
              return;
            }
            paramFromServiceMsg = new cmd0xa02.RspBody();
            paramFromServiceMsg.mergeFrom(paramIntent.bytes_bodybuffer.get().toByteArray());
            paramIntent = paramFromServiceMsg.rpt_tinyid2useracc_info.get();
            if (QLog.isColorLevel())
            {
              paramFromServiceMsg = new StringBuilder();
              paramFromServiceMsg.append("CMD_OIDB_0x626 onReceive list = ");
              paramFromServiceMsg.append(paramIntent.toString());
              QLog.d("VideoServlet", 2, paramFromServiceMsg.toString());
            }
            new ArrayList();
            paramIntent = PstnUtils.a(paramIntent);
            this.a.b().b(paramIntent);
            return;
          }
          catch (Exception paramIntent)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive Exception!");
            }
            paramIntent.printStackTrace();
            return;
          }
        } else if (QLog.isColorLevel()) {
          QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive not success!");
        }
      }
      else
      {
        if ("QQRTCSvc.echo".equalsIgnoreCase((String)localObject))
        {
          boolean bool = paramFromServiceMsg.isSuccess();
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("CMD_QQRTCSVC_ECHO onReceive isSuccess = ");
            paramIntent.append(bool);
            QLog.d("VideoServlet", 2, paramIntent.toString());
          }
          this.a.b().u(bool);
          return;
        }
        if ("QQRTCSvc.group_video_terminate_msg".equalsIgnoreCase((String)localObject))
        {
          c(paramIntent, paramFromServiceMsg);
          return;
        }
        if ("QQRTCSvc.group_video_invite_list".equalsIgnoreCase((String)localObject))
        {
          b(paramIntent, paramFromServiceMsg);
          return;
        }
        if ("CliLogSvc.UploadReq".equals(localObject))
        {
          ClientLogReport.instance().handleServerResp(paramIntent, paramFromServiceMsg);
          return;
        }
        if ("QQRTCSvc.chatroom_get_msg".equalsIgnoreCase((String)localObject))
        {
          a((String)localObject, paramIntent, paramFromServiceMsg);
          return;
        }
        if ("QQRTCSvc.chatroom_send_msg".equalsIgnoreCase((String)localObject))
        {
          a((String)localObject, paramIntent, paramFromServiceMsg);
          return;
        }
        if ("QQRTCSvc.query_codec_config".equalsIgnoreCase((String)localObject))
        {
          a(23, paramIntent, paramFromServiceMsg);
          return;
        }
        d(paramIntent, paramFromServiceMsg);
        Bundle localBundle = paramIntent.getExtras();
        paramIntent = localBundle.getByteArray("vMsg");
        if ((paramIntent != null) && (paramIntent.length > 2)) {
          paramIntent = String.valueOf(paramIntent[2]);
        } else {
          paramIntent = "null";
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleRecieveMsg: cmd = ");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(", friendUin = ");
          localStringBuilder.append(localBundle.getLong("toUin"));
          localStringBuilder.append(", buffer[2] = ");
          localStringBuilder.append(paramIntent);
          localStringBuilder.append(", result = ");
          localStringBuilder.append(String.valueOf(paramFromServiceMsg.isSuccess()));
          QLog.d("VideoServlet", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  void a(String paramString, Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    AudioHelper.a("onRspChatRoom", paramIntent.getExtras());
    int i = paramFromServiceMsg.getWupBuffer().length - 4;
    byte[] arrayOfByte;
    if ((paramFromServiceMsg.isSuccess()) && (i > 0))
    {
      arrayOfByte = new byte[i];
      PkgTools.copyData(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    else
    {
      arrayOfByte = null;
    }
    ChatRoomMng localChatRoomMng = this.a.A();
    if (localChatRoomMng != null) {
      localChatRoomMng.a(paramString, paramFromServiceMsg.isSuccess(), paramFromServiceMsg.getResultCode(), paramIntent, arrayOfByte);
    }
  }
  
  void a(String paramString, Packet paramPacket, Bundle paramBundle)
  {
    AudioHelper.a("reqVideoCodecMsg", paramBundle);
    paramPacket.setServantName("trpc.qqrtc.sharpsvrconfig.Config");
    paramPacket.setFuncName("GetConfig");
    paramPacket.setSSOCommand(paramString);
    paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(true));
    paramPacket.setTimeout(10000L);
    paramString = paramBundle.getByteArray("vMsg");
    if (paramString != null) {
      paramPacket.putSendData(WupUtil.a(paramString));
    }
  }
  
  void a(Packet paramPacket, Bundle paramBundle)
  {
    AudioHelper.a("reqChatRoom", paramBundle);
    String str = paramBundle.getString("ssoCmd");
    IVideoServant localIVideoServant = a(str);
    if (localIVideoServant != null)
    {
      paramPacket.setServantName(localIVideoServant.a());
      paramPacket.setFuncName(localIVideoServant.b());
    }
    paramPacket.setSSOCommand(str);
    paramPacket.setTimeout(10000L);
    paramBundle = paramBundle.getByteArray("vMsg");
    if (paramBundle != null) {
      paramPacket.putSendData(WupUtil.a(paramBundle));
    }
  }
  
  void b(SharpVideoMsg paramSharpVideoMsg)
  {
    paramSharpVideoMsg = paramSharpVideoMsg.video_buff;
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("buffer", paramSharpVideoMsg);
    this.a.b().n.receiveSharpVideoAck(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("VideoServlet", 2, "handle Sharp Video c2s Ack Message OK");
    }
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "VideoCCSvc.Adaptation", "SharpSvr.c2sack", "SharpSvr.s2c", "MultiVideo.c2sack", "MultiVideo.s2c" };
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.a = ((VideoAppInterface)getAppRuntime());
    this.a.y = System.currentTimeMillis();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return;
    }
    String str = paramFromServiceMsg.getServiceCmd();
    long l1 = 0L;
    if (paramIntent != null) {
      l1 = SeqUtil.a(paramIntent);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceive, cmd[");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append("], request[");
    boolean bool;
    if (paramIntent != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append("], currentThread[");
    ((StringBuilder)localObject).append(Thread.currentThread().getId());
    ((StringBuilder)localObject).append("]");
    QLog.w("VideoServlet", 1, ((StringBuilder)localObject).toString());
    if ("SharpSvr.c2s".equalsIgnoreCase(str)) {
      ReportController.b(null, "CliOper", "", "", "0X80088B1", "0X80088B1", 0, 0, "", "", "", "");
    }
    if (paramIntent != null)
    {
      a(paramIntent, paramFromServiceMsg);
      return;
    }
    int i;
    if ("SharpSvr.s2c".equalsIgnoreCase(str))
    {
      paramIntent = (SharpVideoMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "SharpVideoMsg", new SharpVideoMsg());
      l1 = System.currentTimeMillis();
      localObject = a(paramIntent.video_buff, "SharpSvr.s2c", "--video--");
      i = (int)localObject[0];
      long l2 = localObject[1];
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("avideo onReceive[CMD_SHARPVIDEO_S2C] seq[");
      ((StringBuilder)localObject).append(paramIntent.msg_seq);
      ((StringBuilder)localObject).append("], msg_type[");
      ((StringBuilder)localObject).append(paramIntent.msg_type);
      ((StringBuilder)localObject).append("], type[");
      ((StringBuilder)localObject).append(paramIntent.type);
      ((StringBuilder)localObject).append("], serviceType[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("], roomId[");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("]|");
      ((StringBuilder)localObject).append(l1);
      QLog.w("VideoServlet", 1, ((StringBuilder)localObject).toString());
      if (i == 1013) {
        return;
      }
      if (paramIntent.msg_type == 3L)
      {
        VideoUtils.a("Video:Servlet", 5000L);
        a(paramIntent.video_buff);
        this.a.b().a(209, String.valueOf(paramIntent.from_uin));
        this.a.b().a(200, String.valueOf(paramIntent.from_uin));
        if (this.a.b().o() == 0) {
          this.a.b().a(205, String.valueOf(paramIntent.from_uin));
        } else {
          this.a.b().a(204, String.valueOf(paramIntent.from_uin));
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramIntent.msg_seq);
        ((StringBuilder)localObject).append("-");
        ((StringBuilder)localObject).append(paramIntent.msg_uid);
        localObject = ((StringBuilder)localObject).toString();
        this.a.a(paramIntent.from_uin, (String)localObject, MessageCache.c());
        if (this.a.i) {
          this.a.i = false;
        } else {
          VideoNodeManager.a(l2);
        }
        this.a.j = true;
        VideoNodeManager.a(l2, 35);
        localObject = paramFromServiceMsg.getAttribute("__timestamp_net2msf");
        if (localObject != null)
        {
          l1 = ((Long)localObject).longValue();
          this.a.b().b(String.valueOf(paramIntent.from_uin), l1);
        }
      }
      try
      {
        localObject = VideoPackageUtils.a(paramIntent.video_buff);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<-- onReceive() cmd = ");
        localStringBuilder.append(str);
        localStringBuilder.append(" , msg_type = ");
        localStringBuilder.append(paramIntent.msg_type);
        localStringBuilder.append(", bodyType = ");
        localStringBuilder.append(((VideoPackageUtils.VideoPacket)localObject).d);
        QLog.w("tagSharpSvr", 1, localStringBuilder.toString());
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      c(paramIntent);
      if ((!AVReport.a().d) && (AVReport.a().c != 1) && (paramFromServiceMsg.getAttributes() != null))
      {
        paramFromServiceMsg = paramFromServiceMsg.getAttributes().get("__timestamp_net2msf_boot");
        if (paramFromServiceMsg != null) {
          AVReport.a().u = ((Long)paramFromServiceMsg).longValue();
        }
      }
      a(paramIntent);
      return;
    }
    if ("SharpSvr.c2sack".equalsIgnoreCase(localException))
    {
      if ((AVReport.a().d) && (paramFromServiceMsg.getAttributes() != null)) {
        if (AVReport.a().b == 0)
        {
          paramIntent = paramFromServiceMsg.getAttributes().get("__timestamp_net2msf_boot");
          if (paramIntent != null) {
            AVReport.a().h = ((Long)paramIntent).longValue();
          }
          paramIntent = paramFromServiceMsg.getAttributes().get("__timestamp_msf2net_boot_sharp_c2s");
          if (paramIntent != null) {
            AVReport.a().g = ((Long)paramIntent).longValue();
          }
        }
        else if (AVReport.a().b == 2)
        {
          AVReport.a().b = 4;
          paramIntent = paramFromServiceMsg.getAttributes().get("__timestamp_msf2net_boot_sharp_c2s");
          if (paramIntent != null) {
            AVReport.a().k = ((Long)paramIntent).longValue();
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoServlet", 2, "Receive sharp video message c2s ack,cmd=SharpSvr.c2sack");
      }
      paramIntent = (SharpVideoMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "SharpVideoMsg", new SharpVideoMsg());
      paramFromServiceMsg = a(paramIntent.video_buff, "SharpSvr.c2sack", "--video--");
      i = (int)paramFromServiceMsg[0];
      l1 = paramFromServiceMsg[1];
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("avideo onReceive[c2s ack], seq[");
      paramFromServiceMsg.append(paramIntent.msg_seq);
      paramFromServiceMsg.append("], msg_type[");
      paramFromServiceMsg.append(paramIntent.msg_type);
      paramFromServiceMsg.append("], type[");
      paramFromServiceMsg.append(paramIntent.type);
      paramFromServiceMsg.append("], serviceType[");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append("], roomId[");
      paramFromServiceMsg.append(l1);
      paramFromServiceMsg.append("]");
      QLog.w("VideoServlet", 1, paramFromServiceMsg.toString());
      if (i == 1013) {
        return;
      }
      if (paramIntent.msg_type == 2L)
      {
        paramFromServiceMsg = SessionMgr.a().b();
        if (paramFromServiceMsg != null)
        {
          paramFromServiceMsg.e(l1);
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("avideo onReceive set sessioninfo roomid ,id = ");
            paramFromServiceMsg.append(l1);
            QLog.d("VideoServlet", 2, paramFromServiceMsg.toString());
          }
          ((VideoNodeReporter)this.a.c(4)).a(l1);
        }
      }
      try
      {
        paramFromServiceMsg = VideoPackageUtils.a(paramIntent.video_buff);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<-- onReceive() cmd = ");
        ((StringBuilder)localObject).append(localException);
        ((StringBuilder)localObject).append(" , msg_type = ");
        ((StringBuilder)localObject).append(paramIntent.msg_type);
        ((StringBuilder)localObject).append(", bodyType = ");
        ((StringBuilder)localObject).append(paramFromServiceMsg.d);
        QLog.w("tagSharpSvr", 1, ((StringBuilder)localObject).toString());
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
      }
      b(paramIntent);
      return;
    }
    if ("MultiVideo.s2c".equalsIgnoreCase(localException))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoServlet", 2, "Receive multi video message s2c ,cmd=MultiVideo.s2c");
      }
      paramIntent = (MultiVideoMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "MultiVideoMsg", new MultiVideoMsg());
      a(paramIntent);
      paramFromServiceMsg = new Bundle();
      paramFromServiceMsg.putByteArray("buffer", paramIntent.video_buff);
      this.a.b().n.receiveMultiVideoMsg(paramFromServiceMsg);
      return;
    }
    if ("MultiVideo.c2sack".equalsIgnoreCase(localException))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoServlet", 2, "Receive multi video message c2s ack,cmd=MultiVideo.c2sack");
      }
      paramIntent = (MultiVideoMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "MultiVideoMsg", new MultiVideoMsg());
      paramFromServiceMsg = new Bundle();
      paramFromServiceMsg.putByteArray("buffer", paramIntent.video_buff);
      this.a.b().n.receiveMultiVideoAck(paramFromServiceMsg);
      return;
    }
    if ("OidbSvc.0x625".equalsIgnoreCase(localException))
    {
      if (paramFromServiceMsg.isSuccess()) {
        try
        {
          paramIntent = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
          paramFromServiceMsg = new byte[paramIntent.getInt() - 4];
          paramIntent.get(paramFromServiceMsg);
          paramIntent = new oidb_sso.OIDBSSOPkg();
          paramIntent.mergeFrom(paramFromServiceMsg);
          if (paramIntent.uint32_result.get() != 0)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("CMD_OIDB_0x625 onReceive uint32_result = ");
            paramFromServiceMsg.append(paramIntent.uint32_result.get());
            QLog.d("VideoServlet", 2, paramFromServiceMsg.toString());
            return;
          }
          if (!paramIntent.bytes_bodybuffer.has()) {
            return;
          }
          paramFromServiceMsg = new Oidb_0x625.Open2Tiny_RspBody();
          paramFromServiceMsg.mergeFrom(paramIntent.bytes_bodybuffer.get().toByteArray());
          paramIntent = paramFromServiceMsg.msg_tinyid_rsp_info.get();
          if (!QLog.isColorLevel()) {
            return;
          }
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("CMD_OIDB_0x625 onReceive list = ");
          paramFromServiceMsg.append(paramIntent.toString());
          QLog.d("VideoServlet", 2, paramFromServiceMsg.toString());
          return;
        }
        catch (Exception paramIntent)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive Exception!");
          }
          paramIntent.printStackTrace();
          return;
        }
      } else if (QLog.isColorLevel()) {
        QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive not success!");
      }
    }
    else if ("OidbSvc.0xa02".equalsIgnoreCase(localException))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive");
      }
      if (paramFromServiceMsg.isSuccess()) {
        try
        {
          i = paramFromServiceMsg.getWupBuffer().length - 4;
          byte[] arrayOfByte = new byte[i];
          PkgTools.copyData(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
          paramIntent = new oidb_sso.OIDBSSOPkg();
          paramIntent.mergeFrom(arrayOfByte);
          if (paramIntent.uint32_result.get() != 0)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("CMD_OIDB_0x626 onReceive uint32_result = ");
            paramFromServiceMsg.append(paramIntent.uint32_result.get());
            QLog.d("VideoServlet", 2, paramFromServiceMsg.toString());
            return;
          }
          if (!paramIntent.bytes_bodybuffer.has()) {
            return;
          }
          paramFromServiceMsg = new Oidb_0x626.Tiny2Open_RspBody();
          paramFromServiceMsg.mergeFrom(paramIntent.bytes_bodybuffer.get().toByteArray());
          paramIntent = paramFromServiceMsg.msg_openid_rsp_info.get();
          if (!QLog.isColorLevel()) {
            return;
          }
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("CMD_OIDB_0x626 onReceive list = ");
          paramFromServiceMsg.append(paramIntent.toString());
          QLog.d("VideoServlet", 2, paramFromServiceMsg.toString());
          return;
        }
        catch (Exception paramIntent)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive Exception!");
          }
          paramIntent.printStackTrace();
          return;
        }
      } else if (QLog.isColorLevel()) {
        QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive not success!");
      }
    }
    else
    {
      d(paramIntent, paramFromServiceMsg);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getExtras();
    if (localObject1 == null) {
      return;
    }
    long l2 = SeqUtil.a(paramIntent);
    long l1 = l2;
    if (l2 == 0L)
    {
      l1 = AudioHelper.c();
      SeqUtil.a(paramIntent, l1);
    }
    int i = ((Bundle)localObject1).getInt("reqType", -1);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onSend, reqType[");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append("]");
    QLog.w("VideoServlet", 1, ((StringBuilder)localObject2).toString());
    StringBuilder localStringBuilder;
    switch (i)
    {
    case 11: 
    case 16: 
    case 17: 
    case 22: 
    default: 
      localObject1 = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      if (!QLog.isColorLevel()) {
        break label2275;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onSend, toMsg[");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append("], cmd[");
      if (localObject1 != null) {
        break label2242;
      }
      paramIntent = "null";
      break;
    case 23: 
      a("QQRTCSvc.query_codec_config", paramPacket, (Bundle)localObject1);
      return;
    case 21: 
      a(paramPacket, (Bundle)localObject1);
      return;
    case 20: 
      paramPacket.setSSOCommand("QQRTCSvc.echo");
      paramPacket.setTimeout(10000L);
      if (QLog.isColorLevel()) {
        QLog.d("VideoServlet", 2, "onSend with cmd: CMD_QQRTCSVC_ECHO");
      }
      paramPacket.putSendData(WupUtil.a(((Bundle)localObject1).getByteArray("vMsg")));
      return;
    case 19: 
      boolean bool = ((Bundle)localObject1).getBoolean("keepAlive");
      if (QLog.isColorLevel()) {
        QLog.d("VideoServlet", 2, String.format("onSend keepProcessAliveMsg keepAlive=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      paramPacket = MsfMsgUtil.keepProcessAliveMsg(null, bool);
      paramPacket.setNeedRemindSlowNetwork(false);
      paramPacket.setAppId(this.a.getAppid());
      sendToMSF(paramIntent, paramPacket);
      return;
    case 18: 
      if (QLog.isColorLevel()) {
        QLog.d("VideoServlet", 2, "=====send sharp SharpSvr.c2s!!!! 0xc2=====");
      }
      paramPacket.setServantName("SharpSvr");
      paramPacket.setFuncName("c2s");
      paramPacket.setSSOCommand("SharpSvr.c2s");
      paramPacket.setNoResponse();
      paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(true));
      paramIntent = new SharpVideoMsg();
      paramIntent.ver = 1;
      paramIntent.type = -62;
      paramIntent.from_uin = b(String.valueOf(((Bundle)localObject1).getLong("selfuin")));
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(Long.valueOf(((Bundle)localObject1).getLong("toUin")));
      paramIntent.to_uin = ((ArrayList)localObject2);
      paramIntent.msg_time = 0L;
      paramIntent.msg_type = 0L;
      paramIntent.msg_seq = 0L;
      paramIntent.msg_uid = 0L;
      paramIntent.video_buff = ((Bundle)localObject1).getByteArray("vMsg");
      paramPacket.addRequestPacket("SharpVideoMsg", paramIntent);
      return;
    case 15: 
      paramIntent = new cmd0xa02.ReqBody();
      localObject1 = (ArrayList)((Bundle)localObject1).getSerializable("tinyid_list");
      i = 0;
      while (i < ((ArrayList)localObject1).size())
      {
        localObject2 = new cmd0xa02.TinyID();
        ((cmd0xa02.TinyID)localObject2).uint64_tinyid.set(((Long)((ArrayList)localObject1).get(i)).longValue());
        paramIntent.rpt_tinyid.add((MessageMicro)localObject2);
        i += 1;
      }
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2562);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
      paramIntent = ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray();
      localObject1 = new byte[paramIntent.length + 4];
      PkgTools.dWord2Byte((byte[])localObject1, 0, paramIntent.length + 4);
      PkgTools.copyData((byte[])localObject1, 4, paramIntent, paramIntent.length);
      paramPacket.setSSOCommand("OidbSvc.0xa02");
      paramPacket.putSendData((byte[])localObject1);
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("VideoServlet", 2, "CMD_OIDB_0xA02 onSend");
      return;
    case 14: 
      paramIntent = new Oidb_0x625.Open2Tiny_ReqBody();
      localObject1 = (ArrayList)((Bundle)localObject1).getSerializable("openid_list");
      i = 0;
      while (i < ((ArrayList)localObject1).size())
      {
        localObject2 = new Oidb_0x625.OpenIDInfoReq();
        ((Oidb_0x625.OpenIDInfoReq)localObject2).bytes_openid.set(ByteStringMicro.copyFromUtf8((String)((ArrayList)localObject1).get(i)));
        ((Oidb_0x625.OpenIDInfoReq)localObject2).uint32_acounttype.set(101);
        ((Oidb_0x625.OpenIDInfoReq)localObject2).uint32_appid.set(1600000144);
        paramIntent.msg_openid_req_info.add((MessageMicro)localObject2);
        i += 1;
      }
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1573);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
      paramIntent = ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray();
      localObject1 = new byte[paramIntent.length + 4];
      PkgTools.dWord2Byte((byte[])localObject1, 0, paramIntent.length + 4);
      PkgTools.copyData((byte[])localObject1, 4, paramIntent, paramIntent.length);
      paramPacket.setSSOCommand("OidbSvc.0x625");
      paramPacket.putSendData((byte[])localObject1);
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onSend");
      return;
    case 13: 
      paramIntent.putExtra("requestInviteMemberMode", ((Bundle)localObject1).getBoolean("selfuin"));
      c(paramPacket, (Bundle)localObject1);
      return;
    case 12: 
      d(paramPacket, (Bundle)localObject1);
      return;
    case 10: 
      i = ((Bundle)localObject1).getInt("status");
      if (QLog.isColorLevel()) {
        QLog.d("VideoServlet", 2, String.format("onSend SetConnStatusMsg status=%s", new Object[] { Integer.valueOf(i) }));
      }
      paramPacket = MsfMsgUtil.getSetConnStatusMsg(null, i);
      paramPacket.setTimeout(30000L);
      paramPacket.setNeedCallback(true);
      paramPacket.setNeedRemindSlowNetwork(false);
      paramPacket.setAppId(this.a.getAppid());
      sendToMSF(paramIntent, paramPacket);
      return;
    case 9: 
      paramPacket.setServantName("MultiVideo");
      paramPacket.setFuncName("MultiVideos2cack");
      paramPacket.setSSOCommand("MultiVideo.s2cack");
      paramIntent = new MultiVideoMsg();
      paramIntent.ver = ((Bundle)localObject1).getByte("ver");
      paramIntent.type = ((Bundle)localObject1).getByte("type");
      paramIntent.csCmd = ((Bundle)localObject1).getShort("cscmd");
      paramIntent.subCmd = ((Bundle)localObject1).getShort("subcmd");
      paramIntent.from_uin = b(String.valueOf(((Bundle)localObject1).getLong("from_uin")));
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(Long.valueOf(((Bundle)localObject1).getLong("to_uin")));
      paramIntent.to_uin = ((ArrayList)localObject2);
      paramIntent.msg_time = ((Bundle)localObject1).getLong("msg_time");
      paramIntent.msg_type = ((Bundle)localObject1).getLong("msg_type");
      paramIntent.msg_seq = ((Bundle)localObject1).getLong("msg_seq");
      paramIntent.msg_uid = ((Bundle)localObject1).getLong("msg_uid");
      paramIntent.video_buff = ((Bundle)localObject1).getByteArray("video_buff");
      paramPacket.addRequestPacket("MultiVideoMsg", paramIntent);
      return;
    case 8: 
      b(paramPacket, (Bundle)localObject1);
      return;
    case 7: 
      paramPacket = MsfMsgUtil.getGatewayIpMsg(null);
      paramPacket.setTimeout(30000L);
      paramPacket.setNeedCallback(true);
      paramPacket.setNeedRemindSlowNetwork(false);
      paramPacket.setAppId(this.a.getAppid());
      sendToMSF(paramIntent, paramPacket);
      return;
    case 6: 
      paramIntent = new StrupBuff();
      paramIntent.prefix = "";
      localObject2 = new ArrayList();
      localObject1 = ((Bundle)localObject1).getString("vMsg");
      if (localObject1 != null) {
        try
        {
          ((ArrayList)localObject2).add(((String)localObject1).getBytes("utf-8"));
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
      }
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("custom_set", localObject2);
      paramIntent.logstring = new HashMap((Map)localObject1);
      paramIntent.encoding = 2;
      paramPacket.setSSOCommand("CliLogSvc.UploadReq");
      paramPacket.setServantName("QQService.CliLogSvc.MainServantObj");
      paramPacket.setFuncName("UploadReq");
      paramPacket.addRequestPacket("Data", paramIntent);
      paramPacket.setNoResponse();
      return;
    case 5: 
      paramPacket = new ToServiceMsg(null, this.a.getCurrentAccountUin(), "SharpSvr.s2cack");
      paramPacket.setMsfCommand(MsfCommand.sendVideoAck);
      paramPacket.setNeedCallback(false);
      localObject2 = new SharpVideoMsg();
      ((SharpVideoMsg)localObject2).ver = ((Bundle)localObject1).getByte("ver");
      ((SharpVideoMsg)localObject2).type = ((Bundle)localObject1).getByte("type");
      ((SharpVideoMsg)localObject2).from_uin = b(String.valueOf(((Bundle)localObject1).getLong("from_uin")));
      Object localObject3 = new ArrayList();
      ((ArrayList)localObject3).add(Long.valueOf(((Bundle)localObject1).getLong("to_uin")));
      ((SharpVideoMsg)localObject2).to_uin = ((ArrayList)localObject3);
      ((SharpVideoMsg)localObject2).msg_time = ((Bundle)localObject1).getLong("msg_time");
      ((SharpVideoMsg)localObject2).msg_type = ((Bundle)localObject1).getLong("msg_type");
      ((SharpVideoMsg)localObject2).msg_seq = ((Bundle)localObject1).getLong("msg_seq");
      ((SharpVideoMsg)localObject2).msg_uid = ((Bundle)localObject1).getLong("msg_uid");
      ((SharpVideoMsg)localObject2).video_buff = ((Bundle)localObject1).getByteArray("video_buff");
      ((SharpVideoMsg)localObject2).call_type = ((Bundle)localObject1).getShort("terminal_type");
      ((SharpVideoMsg)localObject2).client_state = a();
      localObject1 = new UniPacket();
      ((UniPacket)localObject1).setServantName("SharpSvr");
      ((UniPacket)localObject1).setFuncName("s2cack");
      ((UniPacket)localObject1).put("SharpVideoMsg", localObject2);
      paramPacket.putWupBuffer(((UniPacket)localObject1).encode());
      paramPacket.addAttribute("stype", Long.valueOf(((SharpVideoMsg)localObject2).msg_type));
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("send sharp s2c ack message,cmd=s2cack seq:");
        ((StringBuilder)localObject1).append(((SharpVideoMsg)localObject2).msg_seq);
        ((StringBuilder)localObject1).append(" type:");
        ((StringBuilder)localObject1).append(((SharpVideoMsg)localObject2).msg_type);
        QLog.i("VideoServlet", 2, ((StringBuilder)localObject1).toString());
      }
      try
      {
        localObject1 = VideoPackageUtils.a(((SharpVideoMsg)localObject2).video_buff);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("--> onSend() cmd = SharpSvr.s2cack , msg_type = ");
        ((StringBuilder)localObject3).append(((SharpVideoMsg)localObject2).msg_type);
        ((StringBuilder)localObject3).append(", bodyType = ");
        ((StringBuilder)localObject3).append(((VideoPackageUtils.VideoPacket)localObject1).d);
        QLog.w("tagSharpSvr", 1, ((StringBuilder)localObject3).toString());
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      sendToMSF(paramIntent, paramPacket);
      return;
    case 4: 
      ReportController.b(null, "CliOper", "", "", "0X80088B0", "0X80088B0", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("VideoServlet", 2, "=====send sharp SharpSvr.c2s!!!!=====");
      }
      paramPacket.setServantName("SharpSvr");
      paramPacket.setFuncName("c2s");
      paramPacket.setSSOCommand("SharpSvr.c2s");
      paramPacket.setNoResponse();
      paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(true));
      paramIntent = new SharpVideoMsg();
      paramIntent.ver = 1;
      paramIntent.type = 1;
      paramIntent.from_uin = b(String.valueOf(localException.getLong("selfuin")));
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(Long.valueOf(localException.getLong("toUin")));
      paramIntent.to_uin = ((ArrayList)localObject2);
      paramIntent.msg_time = 0L;
      paramIntent.msg_type = 0L;
      paramIntent.msg_seq = 0L;
      paramIntent.msg_uid = 0L;
      paramIntent.video_buff = localException.getByteArray("vMsg");
      paramPacket.addRequestPacket("SharpVideoMsg", paramIntent);
      try
      {
        paramPacket = VideoPackageUtils.a(paramIntent.video_buff);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("--> onSend() cmd = SharpSvr.c2s , msg_type = ");
        localStringBuilder.append(paramIntent.msg_type);
        localStringBuilder.append(", bodyType = ");
        localStringBuilder.append(paramPacket.d);
        QLog.w("tagSharpSvr", 1, localStringBuilder.toString());
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
    }
    paramPacket.setServantName("VideoSvc");
    paramPacket.setFuncName("SendVideoMsg");
    paramPacket.setSSOCommand("VideoCCSvc.Adaptation");
    paramIntent = new VideoCallMsg();
    paramIntent.ver = 1;
    paramIntent.type = 1;
    paramIntent.lUin = b(localStringBuilder.getString("selfuin"));
    paramIntent.lPeerUin = localStringBuilder.getLong("toUin");
    paramIntent.uDateTime = ((int)(System.currentTimeMillis() / 1000L));
    paramIntent.cVerifyType = 0;
    paramIntent.uSeqId = 0;
    paramIntent.uSessionId = 0;
    paramIntent.vMsg = localStringBuilder.getByteArray("vMsg");
    paramPacket.addRequestPacket("VideoCallMsg", paramIntent);
    return;
    label2242:
    paramIntent = localStringBuilder.getServiceCmd();
    ((StringBuilder)localObject2).append(paramIntent);
    ((StringBuilder)localObject2).append("]");
    QLog.d("VideoServlet", 2, ((StringBuilder)localObject2).toString());
    label2275:
    if (localStringBuilder != null)
    {
      paramIntent = a(localStringBuilder.getServiceCmd());
      if (paramIntent != null)
      {
        paramPacket.setServantName(paramIntent.a());
        paramPacket.setFuncName(paramIntent.b());
      }
      paramPacket.setSSOCommand(localStringBuilder.getServiceCmd());
      paramPacket.putSendData(localStringBuilder.getWupBuffer());
      paramPacket.setTimeout(localStringBuilder.getTimeout());
      paramPacket.setAttributes(localStringBuilder.getAttributes());
      if (!localStringBuilder.isNeedCallback()) {
        paramPacket.setNoResponse();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoServlet
 * JD-Core Version:    0.7.0.1
 */