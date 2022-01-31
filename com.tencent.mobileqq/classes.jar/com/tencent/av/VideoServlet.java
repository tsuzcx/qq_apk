package com.tencent.av;

import SharpSvrPack.MultiVideoMsg;
import SharpSvrPack.SharpVideoMsg;
import VideoSvrPack.VideoCallMsg;
import android.content.Intent;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.report.AVReport;
import com.tencent.av.report.AVReport.ReceiverNodeStage;
import com.tencent.av.report.AVReport.SenderNodeStage;
import com.tencent.av.report.VideoConnRateReport;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
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
import java.util.Map;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
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
  
  private long a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    for (;;)
    {
      return 0L;
      try
      {
        long l = CharacterUtil.a(paramString);
        if (l >= 10000L) {
          return l;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return 0L;
  }
  
  private void a(MultiVideoMsg paramMultiVideoMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoServlet", 2, "sendMultiVideoAck, seq: " + paramMultiVideoMsg.msg_seq + ", videoMsg.type:" + paramMultiVideoMsg.type + ", videoMsg.from_uin:" + paramMultiVideoMsg.from_uin + ", videoMsg.to_uin.get(0):" + paramMultiVideoMsg.to_uin.get(0) + ", +videoMsg.to_uin.size():" + paramMultiVideoMsg.to_uin.size());
    }
    NewIntent localNewIntent = new NewIntent(this.a.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 9);
    localNewIntent.putExtra("ver", paramMultiVideoMsg.ver);
    localNewIntent.putExtra("type", paramMultiVideoMsg.type);
    localNewIntent.putExtra("cscmd", paramMultiVideoMsg.csCmd);
    localNewIntent.putExtra("subcmd", paramMultiVideoMsg.subCmd);
    localNewIntent.putExtra("from_uin", paramMultiVideoMsg.from_uin);
    localNewIntent.putExtra("to_uin", (Serializable)paramMultiVideoMsg.to_uin.get(0));
    localNewIntent.putExtra("video_buff", paramMultiVideoMsg.video_buff);
    localNewIntent.putExtra("msg_seq", paramMultiVideoMsg.msg_seq);
    localNewIntent.putExtra("msg_uid", paramMultiVideoMsg.msg_uid);
    localNewIntent.putExtra("msg_type", paramMultiVideoMsg.msg_type);
    localNewIntent.putExtra("msg_time", paramMultiVideoMsg.msg_time);
    localNewIntent.putExtra("erroMsg", "success");
    service(localNewIntent);
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent != null)
    {
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
    }
    for (;;)
    {
      ((VideoAppInterface)getAppRuntime()).a(paramIntent, paramFromServiceMsg);
      return;
      paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
    }
  }
  
  public static long[] a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    Object localObject1;
    long l3;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("parseVideoMsgSubServiceTypeAndRoomID,").append(paramString2).append(" parseSubType:").append(paramString1).append(", buff.len=");
      if (paramArrayOfByte == null)
      {
        i = 0;
        QLog.d("VideoServlet", 2, i);
      }
    }
    else
    {
      j = -1;
      l3 = -1L;
      if (!"SharpSvr.c2sack".equalsIgnoreCase(paramString1)) {
        break label484;
      }
      localObject1 = new hd_video.RspBody();
      if (paramArrayOfByte == null) {
        break label407;
      }
    }
    for (;;)
    {
      int k;
      try
      {
        localObject1 = (hd_video.RspBody)((hd_video.RspBody)localObject1).mergeFrom(paramArrayOfByte);
        if (((hd_video.RspBody)localObject1).msg_video_head.has())
        {
          localObject1 = (hd_video.VideoHead)((hd_video.RspBody)localObject1).msg_video_head.get();
          j = ((hd_video.VideoHead)localObject1).enum_body_type.get();
          l2 = ((hd_video.VideoHead)localObject1).uint64_uin.get();
          if (((hd_video.VideoHead)localObject1).int32_sub_service_type.has()) {
            i = ((hd_video.VideoHead)localObject1).int32_sub_service_type.get();
          }
        }
      }
      catch (Exception localException1)
      {
        j = -1;
        l2 = -1L;
      }
      try
      {
        k = ((hd_video.VideoHead)localObject1).uint32_seq.get();
        l1 = ((hd_video.VideoHead)localObject1).uint64_room_id.get();
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          Object localObject2;
          l2 = -1L;
          j = i;
        }
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoServlet", 2, paramString2 + " bodyType=" + j + ", subServiceType=" + i + ", uin=" + l2 + ", seq=" + k + ", roomId=" + l1);
        }
        l2 = i;
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder().append("parseVideoMsgSubServiceTypeAndRoomID,").append(paramString2).append(" parseSubType = ").append(paramString1).append(", buff.len = ");
          if (paramArrayOfByte != null) {
            break label933;
          }
          j = 0;
          QLog.d("VideoServlet", 2, j + ",subServiceType = " + i + ",roomId = " + l1);
        }
        return new long[] { l2, l1 };
      }
      catch (Exception localException4)
      {
        l2 = l1;
        j = i;
        break label427;
      }
      i = paramArrayOfByte.length;
      break;
      i = -1;
      continue;
      if (QLog.isColorLevel()) {
        QLog.e("VideoServlet", 2, paramString2 + " head not exist");
      }
      label407:
      i = -1;
      l1 = -1L;
      continue;
      label427:
      l1 = l2;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.e("VideoServlet", 2, paramString2 + " invalid format:" + localException1.toString());
        l1 = l2;
        i = j;
        continue;
        label484:
        i = j;
        l1 = l3;
        if ("SharpSvr.s2c".equalsIgnoreCase(paramString1))
        {
          localObject2 = new hd_video.MsgBody();
          i = j;
          l1 = l3;
          if (paramArrayOfByte != null)
          {
            k = j;
            l2 = l3;
            for (;;)
            {
              try
              {
                localObject2 = (hd_video.MsgBody)((hd_video.MsgBody)localObject2).mergeFrom(paramArrayOfByte);
                k = j;
                l2 = l3;
                if (!((hd_video.MsgBody)localObject2).msg_video_head.has()) {
                  break label868;
                }
                k = j;
                l2 = l3;
                localObject2 = (hd_video.VideoHead)((hd_video.MsgBody)localObject2).msg_video_head.get();
                k = j;
                l2 = l3;
                int m = ((hd_video.VideoHead)localObject2).enum_body_type.get();
                k = j;
                l2 = l3;
                long l4 = ((hd_video.VideoHead)localObject2).uint64_uin.get();
                k = j;
                l2 = l3;
                if (!((hd_video.VideoHead)localObject2).int32_sub_service_type.has()) {
                  break label862;
                }
                k = j;
                l2 = l3;
                j = ((hd_video.VideoHead)localObject2).int32_sub_service_type.get();
                k = j;
                l2 = l3;
                int n = ((hd_video.VideoHead)localObject2).uint32_seq.get();
                k = j;
                l2 = l3;
                l3 = ((hd_video.VideoHead)localObject2).uint64_room_id.get();
                i = j;
                l1 = l3;
                k = j;
                l2 = l3;
                if (!QLog.isColorLevel()) {
                  break;
                }
                k = j;
                l2 = l3;
                QLog.d("VideoServlet", 2, paramString2 + " bodyType=" + m + ", subServiceType=" + j + ", uin=" + l4 + ", seq=" + n + ", roomId=" + l3);
                i = j;
                l1 = l3;
              }
              catch (Exception localException2)
              {
                i = k;
                l1 = l2;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("VideoServlet", 2, paramString2 + " invalid format:" + localException2.toString());
              i = k;
              l1 = l2;
              break;
              label862:
              j = -1;
            }
            label868:
            i = j;
            l1 = l3;
            k = j;
            l2 = l3;
            if (QLog.isColorLevel())
            {
              k = j;
              l2 = l3;
              QLog.e("VideoServlet", 2, paramString2 + " head not exist");
              i = j;
              l1 = l3;
              continue;
              label933:
              j = paramArrayOfByte.length;
            }
          }
        }
      }
    }
  }
  
  private void c(SharpVideoMsg paramSharpVideoMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoServlet", 2, "sendSharpVideoAck, seq: " + paramSharpVideoMsg.msg_seq + ", videoMsg.type:" + paramSharpVideoMsg.type + ", videoMsg.from_uin:" + paramSharpVideoMsg.from_uin + ", videoMsg.to_uin.get(0):" + paramSharpVideoMsg.to_uin.get(0) + ", +videoMsg.to_uin.size():" + paramSharpVideoMsg.to_uin.size());
    }
    NewIntent localNewIntent = new NewIntent(this.a.getApplication(), VideoServlet.class);
    localNewIntent.setWithouLogin(true);
    localNewIntent.putExtra("reqType", 5);
    localNewIntent.putExtra("ver", paramSharpVideoMsg.ver);
    localNewIntent.putExtra("type", paramSharpVideoMsg.type);
    localNewIntent.putExtra("from_uin", paramSharpVideoMsg.from_uin);
    localNewIntent.putExtra("to_uin", (Serializable)paramSharpVideoMsg.to_uin.get(0));
    localNewIntent.putExtra("video_buff", paramSharpVideoMsg.video_buff);
    localNewIntent.putExtra("msg_seq", paramSharpVideoMsg.msg_seq);
    localNewIntent.putExtra("msg_uid", paramSharpVideoMsg.msg_uid);
    localNewIntent.putExtra("msg_type", paramSharpVideoMsg.msg_type);
    localNewIntent.putExtra("msg_time", paramSharpVideoMsg.msg_time);
    localNewIntent.putExtra("terminal_type", paramSharpVideoMsg.call_type);
    localNewIntent.putExtra("erroMsg", "success");
    service(localNewIntent);
  }
  
  int a()
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
  
  void a(SharpVideoMsg paramSharpVideoMsg)
  {
    boolean bool = false;
    byte[] arrayOfByte = paramSharpVideoMsg.video_buff;
    long l1 = paramSharpVideoMsg.from_uin;
    long l2 = ((Long)paramSharpVideoMsg.to_uin.get(0)).longValue();
    Friends localFriends = (Friends)((VideoAppInterface)getAppRuntime()).getEntityManagerFactory(null).createEntityManager().a(Friends.class, String.valueOf(l1));
    Object localObject;
    if (localFriends != null)
    {
      localObject = localFriends.getFriendNick();
      bool = localFriends.isFriend();
      Bundle localBundle = new Bundle();
      localBundle.putString("uin", String.valueOf(l2));
      localBundle.putString("fromUin", CharacterUtil.a(l1));
      localBundle.putByteArray("buffer", arrayOfByte);
      localBundle.putLong("time", paramSharpVideoMsg.msg_time);
      localBundle.putString("name", (String)localObject);
      localBundle.putBoolean("isFriend", bool);
      this.a.a().c(localBundle);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("handleSharpVideoMessage, friendName[").append((String)localObject).append("], friendRemark[");
        if (localFriends != null) {
          break label244;
        }
      }
    }
    label244:
    for (paramSharpVideoMsg = "";; paramSharpVideoMsg = localFriends.remark)
    {
      QLog.w("VideoServlet", 1, paramSharpVideoMsg + "], isFriend[" + bool + "]");
      return;
      localObject = CharacterUtil.a(l1);
      break;
    }
  }
  
  void b(SharpVideoMsg paramSharpVideoMsg)
  {
    paramSharpVideoMsg = paramSharpVideoMsg.video_buff;
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("buffer", paramSharpVideoMsg);
    this.a.a().d(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("VideoServlet", 2, "handle Sharp Video c2s Ack Message OK");
    }
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "VideoSvc.Send", "VideoCCSvc.Adaptation", "SharpSvr.c2sack", "SharpSvr.s2c", "MultiVideo.c2sack", "MultiVideo.s2c" };
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.a = ((VideoAppInterface)getAppRuntime());
    VideoConnRateReport.a().jdField_a_of_type_Boolean = true;
    VideoConnRateReport.a().jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {}
    label1271:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            String str = paramFromServiceMsg.getServiceCmd();
            QLog.d("VideoServlet", 1, "--video-- onReceive msf cmd = " + str + ",request = " + paramIntent + "|" + Thread.currentThread().getId());
            if ("SharpSvr.c2s".equalsIgnoreCase(str)) {
              ReportController.b(null, "CliOper", "", "", "0X80088B1", "0X80088B1", 0, 0, "", "", "", "");
            }
            int i;
            Object localObject;
            if (paramIntent != null)
            {
              if (MsfMsgUtil.getGatewayIpMsg(null).getServiceCmd().equalsIgnoreCase(str))
              {
                paramIntent = (String)paramFromServiceMsg.getAttribute(MsfMsgUtil.getGatewayIpMsg(null).getServiceCmd());
                if (paramIntent != null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("VideoServlet", 2, "parse getGatewayIpMsg Ok " + paramIntent + " cmd " + str);
                  }
                  this.a.a().g(paramIntent, 0);
                }
              }
              else if ("OidbSvc.0x625".equalsIgnoreCase(str))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive");
                }
                if (paramFromServiceMsg.isSuccess())
                {
                  try
                  {
                    i = paramFromServiceMsg.getWupBuffer().length - 4;
                    paramIntent = new byte[i];
                    PkgTools.a(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
                    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
                    paramFromServiceMsg.mergeFrom(paramIntent);
                    if (paramFromServiceMsg.uint32_result.get() != 0)
                    {
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive uint32_result = " + paramFromServiceMsg.uint32_result.get());
                      return;
                    }
                  }
                  catch (Exception paramIntent)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive Exception!");
                    }
                    paramIntent.printStackTrace();
                    return;
                  }
                  if (paramFromServiceMsg.bytes_bodybuffer.has())
                  {
                    paramIntent = new Oidb_0x625.Open2Tiny_RspBody();
                    paramIntent.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
                    paramIntent = paramIntent.msg_tinyid_rsp_info.get();
                    if (QLog.isColorLevel()) {
                      QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive list = " + paramIntent.toString());
                    }
                  }
                }
                else if (QLog.isColorLevel())
                {
                  QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive not success!");
                }
              }
              else if ("OidbSvc.0xa02".equalsIgnoreCase(str))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive");
                }
                if (paramFromServiceMsg.isSuccess())
                {
                  try
                  {
                    i = paramFromServiceMsg.getWupBuffer().length - 4;
                    paramIntent = new byte[i];
                    PkgTools.a(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
                    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
                    paramFromServiceMsg.mergeFrom(paramIntent);
                    if (paramFromServiceMsg.uint32_result.get() != 0)
                    {
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive uint32_result = " + paramFromServiceMsg.uint32_result.get());
                      return;
                    }
                  }
                  catch (Exception paramIntent)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive Exception!");
                    }
                    paramIntent.printStackTrace();
                    return;
                  }
                  if (paramFromServiceMsg.bytes_bodybuffer.has())
                  {
                    paramIntent = new cmd0xa02.RspBody();
                    paramIntent.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
                    paramIntent = paramIntent.rpt_tinyid2useracc_info.get();
                    if (QLog.isColorLevel()) {
                      QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive list = " + paramIntent.toString());
                    }
                    new ArrayList();
                    paramIntent = PstnUtils.a(paramIntent);
                    this.a.a().c(paramIntent);
                  }
                }
                else if (QLog.isColorLevel())
                {
                  QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive not success!");
                }
              }
              else
              {
                a(paramIntent, paramFromServiceMsg);
                Bundle localBundle = paramIntent.getExtras();
                byte[] arrayOfByte = localBundle.getByteArray("vMsg");
                localObject = "null";
                paramIntent = (Intent)localObject;
                if (arrayOfByte != null)
                {
                  paramIntent = (Intent)localObject;
                  if (arrayOfByte.length > 2) {
                    paramIntent = String.valueOf(arrayOfByte[2]);
                  }
                }
                if (QLog.isColorLevel()) {
                  QLog.d("VideoServlet", 2, "handleRecieveMsg: cmd = " + str + ", friendUin = " + localBundle.getLong("toUin") + ", buffer[2] = " + paramIntent + ", result = " + String.valueOf(paramFromServiceMsg.isSuccess()));
                }
              }
            }
            else if (!"VideoSvc.Send".equalsIgnoreCase(str))
            {
              long l1;
              if ("SharpSvr.s2c".equalsIgnoreCase(str))
              {
                paramIntent = (SharpVideoMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "SharpVideoMsg", new SharpVideoMsg());
                l1 = System.currentTimeMillis();
                localObject = a(paramIntent.video_buff, "SharpSvr.s2c", "--video--");
                i = (int)localObject[0];
                long l2 = localObject[1];
                QLog.w("VideoServlet", 1, "avideo onReceive[CMD_SHARPVIDEO_S2C] seq[" + paramIntent.msg_seq + "], msg_type[" + paramIntent.msg_type + "], type[" + paramIntent.type + "], serviceType[" + i + "], roomId[" + l2 + "]|" + l1);
                if (i != 1013)
                {
                  if (paramIntent.msg_type == 3L)
                  {
                    this.a.a().b(209, String.valueOf(paramIntent.from_uin));
                    this.a.a().b(200, String.valueOf(paramIntent.from_uin));
                    if (this.a.a().a() != 0) {
                      break label1271;
                    }
                    this.a.a().b(205, String.valueOf(paramIntent.from_uin));
                    if (!VideoConnRateReport.a().jdField_b_of_type_Boolean) {
                      VideoConnRateReport.a().a(paramIntent.msg_seq);
                    }
                    VideoConnRateReport.a().a("eVideoRecvInviteMsg", 3L, paramIntent.msg_seq, ((Long)paramIntent.to_uin.get(0)).longValue(), paramIntent.from_uin, 0);
                    localObject = paramIntent.msg_seq + "-" + paramIntent.msg_uid;
                    this.a.a(paramIntent.from_uin, (String)localObject, MessageCache.a());
                    if (!this.a.c) {
                      break label1294;
                    }
                    this.a.c = false;
                  }
                  for (;;)
                  {
                    this.a.d = true;
                    VideoNodeManager.a(l2, 35);
                    c(paramIntent);
                    if ((!AVReport.a().jdField_a_of_type_Boolean) && (AVReport.a().jdField_a_of_type_ComTencentAvReportAVReport$ReceiverNodeStage != AVReport.ReceiverNodeStage.other) && (paramFromServiceMsg.getAttributes() != null))
                    {
                      paramFromServiceMsg = paramFromServiceMsg.getAttributes().get("__timestamp_net2msf_boot");
                      if (paramFromServiceMsg != null) {
                        AVReport.a().q = ((Long)paramFromServiceMsg).longValue();
                      }
                    }
                    a(paramIntent);
                    return;
                    this.a.a().b(204, String.valueOf(paramIntent.from_uin));
                    break;
                    VideoNodeManager.a(l2);
                  }
                }
              }
              else
              {
                if ("SharpSvr.c2sack".equalsIgnoreCase(str))
                {
                  if ((AVReport.a().jdField_a_of_type_Boolean) && (paramFromServiceMsg.getAttributes() != null))
                  {
                    if (AVReport.a().jdField_a_of_type_ComTencentAvReportAVReport$SenderNodeStage != AVReport.SenderNodeStage.SendAVRoomReq) {
                      break label1628;
                    }
                    paramIntent = paramFromServiceMsg.getAttributes().get("__timestamp_net2msf_boot");
                    if (paramIntent != null) {
                      AVReport.a().d = ((Long)paramIntent).longValue();
                    }
                    paramIntent = paramFromServiceMsg.getAttributes().get("__timestamp_msf2net_boot_sharp_c2s");
                    if (paramIntent != null) {
                      AVReport.a().c = ((Long)paramIntent).longValue();
                    }
                  }
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("VideoServlet", 2, "Receive sharp video message c2s ack,cmd=SharpSvr.c2sack");
                    }
                    paramIntent = (SharpVideoMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "SharpVideoMsg", new SharpVideoMsg());
                    paramFromServiceMsg = a(paramIntent.video_buff, "SharpSvr.c2sack", "--video--");
                    i = (int)paramFromServiceMsg[0];
                    l1 = paramFromServiceMsg[1];
                    QLog.w("VideoServlet", 1, "avideo onReceive[c2s ack], seq[" + paramIntent.msg_seq + "], msg_type[" + paramIntent.msg_type + "], type[" + paramIntent.type + "], serviceType[" + i + "], roomId[" + l1 + "]");
                    if (i == 1013) {
                      break;
                    }
                    if (paramIntent.msg_type == 2L)
                    {
                      paramFromServiceMsg = SessionMgr.a().a();
                      if (paramFromServiceMsg != null)
                      {
                        paramFromServiceMsg.j = l1;
                        if (QLog.isColorLevel()) {
                          QLog.d("VideoServlet", 2, "avideo onReceive set sessioninfo roomid ,id = " + l1);
                        }
                        ((VideoNodeReporter)this.a.a(4)).a(l1);
                      }
                    }
                    b(paramIntent);
                    return;
                    if (AVReport.a().jdField_a_of_type_ComTencentAvReportAVReport$SenderNodeStage == AVReport.SenderNodeStage.SendRequestReq)
                    {
                      AVReport.a().jdField_a_of_type_ComTencentAvReportAVReport$SenderNodeStage = AVReport.SenderNodeStage.other;
                      paramIntent = paramFromServiceMsg.getAttributes().get("__timestamp_msf2net_boot_sharp_c2s");
                      if (paramIntent != null) {
                        AVReport.a().g = ((Long)paramIntent).longValue();
                      }
                    }
                  }
                }
                if ("MultiVideo.s2c".equalsIgnoreCase(str))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("VideoServlet", 2, "Receive multi video message s2c ,cmd=MultiVideo.s2c");
                  }
                  paramIntent = (MultiVideoMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "MultiVideoMsg", new MultiVideoMsg());
                  a(paramIntent);
                  this.a.a().b(paramIntent.video_buff);
                  return;
                }
                if ("MultiVideo.c2sack".equalsIgnoreCase(str))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("VideoServlet", 2, "Receive multi video message c2s ack,cmd=MultiVideo.c2sack");
                  }
                  paramIntent = (MultiVideoMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "MultiVideoMsg", new MultiVideoMsg());
                  this.a.a().c(paramIntent.video_buff);
                  return;
                }
                if ("OidbSvc.0x625".equalsIgnoreCase(str))
                {
                  if (paramFromServiceMsg.isSuccess())
                  {
                    try
                    {
                      paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
                      paramIntent = new byte[paramFromServiceMsg.getInt() - 4];
                      paramFromServiceMsg.get(paramIntent);
                      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
                      paramFromServiceMsg.mergeFrom(paramIntent);
                      if (paramFromServiceMsg.uint32_result.get() != 0)
                      {
                        if (!QLog.isColorLevel()) {
                          continue;
                        }
                        QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive uint32_result = " + paramFromServiceMsg.uint32_result.get());
                        return;
                      }
                    }
                    catch (Exception paramIntent)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive Exception!");
                      }
                      paramIntent.printStackTrace();
                      return;
                    }
                    if (paramFromServiceMsg.bytes_bodybuffer.has())
                    {
                      paramIntent = new Oidb_0x625.Open2Tiny_RspBody();
                      paramIntent.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
                      paramIntent = paramIntent.msg_tinyid_rsp_info.get();
                      if (QLog.isColorLevel()) {
                        QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive list = " + paramIntent.toString());
                      }
                    }
                  }
                  else if (QLog.isColorLevel())
                  {
                    QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive not success!");
                  }
                }
                else
                {
                  if (!"OidbSvc.0xa02".equalsIgnoreCase(str)) {
                    break label2262;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive");
                  }
                  if (!paramFromServiceMsg.isSuccess()) {
                    break label2246;
                  }
                  try
                  {
                    i = paramFromServiceMsg.getWupBuffer().length - 4;
                    paramIntent = new byte[i];
                    PkgTools.a(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
                    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
                    paramFromServiceMsg.mergeFrom(paramIntent);
                    if (paramFromServiceMsg.uint32_result.get() != 0)
                    {
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive uint32_result = " + paramFromServiceMsg.uint32_result.get());
                    }
                  }
                  catch (Exception paramIntent)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive Exception!");
                    }
                    paramIntent.printStackTrace();
                    return;
                  }
                }
              }
            }
          }
        } while (!paramFromServiceMsg.bytes_bodybuffer.has());
        paramIntent = new Oidb_0x626.Tiny2Open_RspBody();
        paramIntent.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramIntent = paramIntent.msg_openid_rsp_info.get();
      } while (!QLog.isColorLevel());
      QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive list = " + paramIntent.toString());
      return;
    } while (!QLog.isColorLevel());
    label1294:
    label1628:
    QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive not success!");
    label2246:
    return;
    label2262:
    a(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getExtras();
    if (localObject1 == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            i = ((Bundle)localObject1).getInt("reqType", -1);
            QLog.d("VideoServlet", 1, "--video-- onSend sharp video message reqType:" + i + "|" + Thread.currentThread().getId());
            switch (i)
            {
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 16: 
            case 17: 
            default: 
              paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
              if (QLog.isColorLevel()) {
                QLog.d("VideoServlet", 2, " onSend " + paramIntent);
              }
              break;
            }
          } while (paramIntent == null);
          QLog.d("VideoServlet", 2, " onSend " + paramIntent.getServiceCmd());
          paramPacket.setSSOCommand(paramIntent.getServiceCmd());
          paramPacket.putSendData(paramIntent.getWupBuffer());
          paramPacket.setTimeout(paramIntent.getTimeout());
          paramPacket.setAttributes(paramIntent.getAttributes());
        } while (paramIntent.isNeedCallback());
        paramPacket.setNoResponse();
        return;
        paramPacket.setServantName("VideoSvc");
        paramPacket.setFuncName("SendVideoMsg");
        paramPacket.setSSOCommand("VideoCCSvc.Adaptation");
        paramIntent = new VideoCallMsg();
        paramIntent.ver = 1;
        paramIntent.type = 1;
        paramIntent.lUin = a(((Bundle)localObject1).getString("selfuin"));
        paramIntent.lPeerUin = ((Bundle)localObject1).getLong("toUin");
        paramIntent.uDateTime = ((int)(System.currentTimeMillis() / 1000L));
        paramIntent.cVerifyType = 0;
        paramIntent.uSeqId = 0;
        paramIntent.uSessionId = 0;
        paramIntent.vMsg = ((Bundle)localObject1).getByteArray("vMsg");
        paramPacket.addRequestPacket("VideoCallMsg", paramIntent);
        return;
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
        paramIntent.from_uin = a(String.valueOf(((Bundle)localObject1).getLong("selfuin")));
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
        paramPacket = new ToServiceMsg(null, this.a.getCurrentAccountUin(), "SharpSvr.s2cack");
        paramPacket.setMsfCommand(MsfCommand.sendVideoAck);
        paramPacket.setNeedCallback(false);
        localObject2 = new SharpVideoMsg();
        ((SharpVideoMsg)localObject2).ver = ((Bundle)localObject1).getByte("ver");
        ((SharpVideoMsg)localObject2).type = ((Bundle)localObject1).getByte("type");
        ((SharpVideoMsg)localObject2).from_uin = a(String.valueOf(((Bundle)localObject1).getLong("from_uin")));
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Long.valueOf(((Bundle)localObject1).getLong("to_uin")));
        ((SharpVideoMsg)localObject2).to_uin = localArrayList;
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
        if (((SharpVideoMsg)localObject2).msg_type == 3L)
        {
          VideoConnRateReport.a().a("eVideoSendACK", ((SharpVideoMsg)localObject2).msg_type, ((SharpVideoMsg)localObject2).msg_seq, ((Long)((SharpVideoMsg)localObject2).to_uin.get(0)).longValue(), ((SharpVideoMsg)localObject2).from_uin, 0);
          VideoConnRateReport.a().b();
        }
        if (QLog.isColorLevel()) {
          QLog.i("VideoServlet", 2, "send sharp s2c ack message,cmd=s2cack seq:" + ((SharpVideoMsg)localObject2).msg_seq + " type:" + ((SharpVideoMsg)localObject2).msg_type);
        }
        sendToMSF(paramIntent, paramPacket);
        return;
        paramIntent = new StrupBuff();
        paramIntent.prefix = "";
        localObject2 = new ArrayList();
        localObject1 = ((Bundle)localObject1).getString("vMsg");
        if (localObject1 != null) {}
        try
        {
          ((ArrayList)localObject2).add(((String)localObject1).getBytes("utf-8"));
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
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
        paramPacket = MsfMsgUtil.getGatewayIpMsg(null);
        paramPacket.setTimeout(30000L);
        paramPacket.setNeedCallback(true);
        paramPacket.setNeedRemindSlowNetwork(false);
        paramPacket.setAppId(this.a.getAppid());
        sendToMSF(paramIntent, paramPacket);
        return;
        paramPacket.setServantName("MultiVideo");
        paramPacket.setFuncName("MultiVideoMsg");
        paramPacket.setSSOCommand("MultiVideo.c2s");
        paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(true));
        paramIntent = new MultiVideoMsg();
        paramIntent.ver = ((Bundle)localObject1).getByte("ver");
        paramIntent.type = ((Bundle)localObject1).getByte("type");
        paramIntent.csCmd = ((Bundle)localObject1).getShort("cscmd");
        paramIntent.from_uin = a(String.valueOf(((Bundle)localObject1).getLong("from_uin")));
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(Long.valueOf(((Bundle)localObject1).getLong("toUin")));
        paramIntent.to_uin = ((ArrayList)localObject2);
        paramIntent.msg_time = ((Bundle)localObject1).getLong("msg_time");
        paramIntent.msg_type = ((Bundle)localObject1).getLong("msg_type");
        paramIntent.msg_seq = ((Bundle)localObject1).getLong("msg_seq");
        paramIntent.msg_uid = ((Bundle)localObject1).getLong("msg_uid");
        paramIntent.video_buff = ((Bundle)localObject1).getByteArray("vMsg");
        paramPacket.addRequestPacket("MultiVideoMsg", paramIntent);
        return;
        paramPacket.setServantName("MultiVideo");
        paramPacket.setFuncName("MultiVideos2cack");
        paramPacket.setSSOCommand("MultiVideo.s2cack");
        paramIntent = new MultiVideoMsg();
        paramIntent.ver = ((Bundle)localObject1).getByte("ver");
        paramIntent.type = ((Bundle)localObject1).getByte("type");
        paramIntent.csCmd = ((Bundle)localObject1).getShort("cscmd");
        paramIntent.subCmd = ((Bundle)localObject1).getShort("subcmd");
        paramIntent.from_uin = a(String.valueOf(((Bundle)localObject1).getLong("from_uin")));
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
        PkgTools.a((byte[])localObject1, 0, paramIntent.length + 4);
        PkgTools.a((byte[])localObject1, 4, paramIntent, paramIntent.length);
        paramPacket.setSSOCommand("OidbSvc.0x625");
        paramPacket.putSendData((byte[])localObject1);
      } while (!QLog.isColorLevel());
      QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onSend");
      return;
      paramIntent = new cmd0xa02.ReqBody();
      localObject1 = (ArrayList)((Bundle)localObject1).getSerializable("tinyid_list");
      int i = 0;
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
      PkgTools.a((byte[])localObject1, 0, paramIntent.length + 4);
      PkgTools.a((byte[])localObject1, 4, paramIntent, paramIntent.length);
      paramPacket.setSSOCommand("OidbSvc.0xa02");
      paramPacket.putSendData((byte[])localObject1);
    } while (!QLog.isColorLevel());
    QLog.d("VideoServlet", 2, "CMD_OIDB_0xA02 onSend");
    return;
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
    paramIntent.from_uin = a(String.valueOf(((Bundle)localObject1).getLong("selfuin")));
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(Long.valueOf(((Bundle)localObject1).getLong("toUin")));
    paramIntent.to_uin = ((ArrayList)localObject2);
    paramIntent.msg_time = 0L;
    paramIntent.msg_type = 0L;
    paramIntent.msg_seq = 0L;
    paramIntent.msg_uid = 0L;
    paramIntent.video_buff = ((Bundle)localObject1).getByteArray("vMsg");
    paramPacket.addRequestPacket("SharpVideoMsg", paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.VideoServlet
 * JD-Core Version:    0.7.0.1
 */