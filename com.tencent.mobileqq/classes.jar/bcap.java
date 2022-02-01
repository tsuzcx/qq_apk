import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.data.PushRecommend;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList.MsgBody;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList.NowPushMsg;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import org.jetbrains.annotations.Nullable;
import tencent.im.apollo_push_msgInfo.STPushMsgElem;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msgrevoke.msgrevoke_userdef.UinTypeUserDef;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.MsgInfo;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.ReqBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x104.submsgtype0x104.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x119.SubMsgType0x119.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x9b.SubMsgType0x9b.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.AddFriendSource;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.PersonMayKnow;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.PushPeopleMayKnowV2;
import tencent.im.s2c.msgtype0x210.submsgtype0xcb.SubMsgType0xcb.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xe8.submsgtype0xe8.MsgBody;

public class bcap
  implements bbzr
{
  private acww<Integer, bcba> a = new acwx();
  
  public bcap()
  {
    a();
  }
  
  private MessageRecord a(MessageHandler paramMessageHandler, byte[] paramArrayOfByte, msg_comm.Msg paramMsg)
  {
    SubMsgType0xcb.MsgBody localMsgBody = new SubMsgType0xcb.MsgBody();
    for (;;)
    {
      try
      {
        localMsgBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (MessageForNearbyLiveTip)bbzh.a(-2053);
        if (localMsgBody.uint32_anchor_status.get() == 1)
        {
          bool = true;
          paramArrayOfByte.isLiving = bool;
          paramArrayOfByte.jumpingUrl = localMsgBody.bytes_jump_schema.get().toStringUtf8();
          paramArrayOfByte.msg = localMsgBody.bytes_live_wording.get().toStringUtf8();
          paramArrayOfByte.headUrl = localMsgBody.bytes_anchor_head_url.get().toStringUtf8();
          paramArrayOfByte.nickName = localMsgBody.bytes_anchor_nickname.get().toStringUtf8();
          paramArrayOfByte.liveEndWording = localMsgBody.bytes_live_end_wording.get().toStringUtf8();
          paramArrayOfByte.c2cMsgWording = localMsgBody.bytes_c2c_msg_wording.get().toStringUtf8();
          paramArrayOfByte.startLiveWordingType = localMsgBody.uint32_live_wording_type.get();
          paramArrayOfByte.endLiveWordingType = localMsgBody.uint32_end_wording_type.get();
          long l1 = paramMsg.msg_head.from_uin.get();
          int i = paramMsg.msg_head.msg_seq.get();
          long l2 = paramMsg.msg_head.msg_uid.get();
          int j = paramMsg.msg_head.msg_type.get();
          paramArrayOfByte.time = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
          paramArrayOfByte.msgseq = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
          paramArrayOfByte.shmsgseq = i;
          paramArrayOfByte.msgUid = l2;
          paramArrayOfByte.selfuin = paramMessageHandler.app.getCurrentAccountUin();
          paramArrayOfByte.istroop = 1001;
          paramArrayOfByte.senderuin = String.valueOf(anhk.g + l1);
          paramArrayOfByte.frienduin = String.valueOf(anhk.g + l1);
          paramArrayOfByte.getBytes();
          bbzf.a(paramMessageHandler, l1, i, l2, j);
          if (QLog.isColorLevel())
          {
            paramMessageHandler = new StringBuilder();
            paramMessageHandler.append("status=").append(paramArrayOfByte.isLiving).append("jumpingUrl=").append(paramArrayOfByte.jumpingUrl).append("liveWording=").append(paramArrayOfByte.msg).append("headUrl").append(paramArrayOfByte.headUrl).append("nickName").append(paramArrayOfByte.nickName).append("startLiveWordingType=").append(localMsgBody.uint32_live_wording_type.get()).append("endLiveWordingType=").append(localMsgBody.uint32_end_wording_type.get());
            QLog.i("MsgType0x210Decoder", 2, paramMessageHandler.toString());
          }
          bcst.b(null, "dc00899", "grp_lbs", "", "msg_box", "view_live_message", 0, 0, "", "", "", "");
          return paramArrayOfByte;
        }
      }
      catch (InvalidProtocolBufferMicroException paramMessageHandler)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgType0x210Decoder", 2, "decodeNearbyLiveTipMsg decode failed" + paramMessageHandler.toString());
        }
        return null;
      }
      boolean bool = false;
    }
  }
  
  @Nullable
  static msg_comm.MsgType0x210 a(msg_comm.Msg paramMsg)
  {
    Object localObject = new msg_comm.MsgType0x210();
    try
    {
      paramMsg = (msg_comm.MsgType0x210)((msg_comm.MsgType0x210)localObject).mergeFrom(((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray());
      if (paramMsg == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MsgType0x210Decoder", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 is null.");
        }
        localObject = null;
        return localObject;
      }
    }
    catch (Exception paramMsg)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("MsgType0x210Decoder", 2, "<---decodeC2CMsgPkg_MsgType0x210 : failed.", paramMsg);
          }
          paramMsg = null;
        }
        if (!paramMsg.sub_msg_type.has()) {
          break;
        }
        localObject = paramMsg;
      } while (paramMsg.msg_content.has());
      if (QLog.isColorLevel()) {
        QLog.e("MsgType0x210Decoder", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 require more info: hasType:" + paramMsg.sub_msg_type.has() + ",hasMsgContent:" + paramMsg.msg_content.has());
      }
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Submsgtype0x8a.ReqBody paramReqBody, long paramLong, boolean paramBoolean)
  {
    int i = 0;
    long l = 0L;
    Object localObject1 = (ArrayList)paramReqBody.msg_info.get();
    Object localObject2 = new msgrevoke_userdef.UinTypeUserDef();
    Object localObject3;
    boolean bool;
    try
    {
      ((msgrevoke_userdef.UinTypeUserDef)localObject2).mergeFrom(paramReqBody.bytes_reserved.get().toByteArray());
      int j = ((msgrevoke_userdef.UinTypeUserDef)localObject2).uint32_from_uin_type.get();
      if (j == 1)
      {
        i = 1000;
        l = ((msgrevoke_userdef.UinTypeUserDef)localObject2).uint64_from_group_code.get();
      }
      for (;;)
      {
        localObject2 = new ArrayList();
        paramReqBody = ((ArrayList)localObject1).iterator();
        for (;;)
        {
          if (!paramReqBody.hasNext()) {
            break label367;
          }
          localObject1 = (Submsgtype0x8a.MsgInfo)paramReqBody.next();
          localObject3 = new RevokeMsgInfo();
          ((RevokeMsgInfo)localObject3).jdField_a_of_type_Int = i;
          ((RevokeMsgInfo)localObject3).jdField_b_of_type_JavaLangString = String.valueOf(((Submsgtype0x8a.MsgInfo)localObject1).uint64_from_uin.get());
          ((RevokeMsgInfo)localObject3).jdField_a_of_type_JavaLangString = String.valueOf(((Submsgtype0x8a.MsgInfo)localObject1).uint64_to_uin.get());
          ((RevokeMsgInfo)localObject3).jdField_d_of_type_JavaLangString = String.valueOf(l);
          ((RevokeMsgInfo)localObject3).jdField_a_of_type_Long = ((short)((Submsgtype0x8a.MsgInfo)localObject1).uint32_msg_seq.get());
          ((RevokeMsgInfo)localObject3).jdField_b_of_type_Long = ((Submsgtype0x8a.MsgInfo)localObject1).uint64_msg_uid.get();
          ((RevokeMsgInfo)localObject3).jdField_c_of_type_Long = ((Submsgtype0x8a.MsgInfo)localObject1).uint64_msg_time.get();
          ((RevokeMsgInfo)localObject3).jdField_b_of_type_Int = ((Submsgtype0x8a.MsgInfo)localObject1).uint32_div_seq.get();
          ((RevokeMsgInfo)localObject3).jdField_c_of_type_Int = ((Submsgtype0x8a.MsgInfo)localObject1).uint32_pkg_num.get();
          ((RevokeMsgInfo)localObject3).jdField_d_of_type_Int = ((Submsgtype0x8a.MsgInfo)localObject1).uint32_pkg_index.get();
          if ((((Submsgtype0x8a.MsgInfo)localObject1).uint32_flag.get() & 0x8) != 0) {
            break;
          }
          bool = true;
          ((RevokeMsgInfo)localObject3).jdField_a_of_type_Boolean = bool;
          ((ArrayList)localObject2).add(localObject3);
          if (QLog.isColorLevel()) {
            QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b msg," + ((RevokeMsgInfo)localObject3).toString());
          }
        }
        if (j == 2)
        {
          i = 1004;
          l = ((msgrevoke_userdef.UinTypeUserDef)localObject2).uint64_from_group_code.get();
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b msg, prase uintypeUserdef error");
      }
    }
    label814:
    for (;;)
    {
      bool = false;
      break;
      label367:
      if (!paramBoolean)
      {
        paramQQAppInterface.a().a((ArrayList)localObject2, false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b subaccount msg");
      }
      if (!((ArrayList)localObject2).isEmpty())
      {
        String str1 = Long.toString(paramLong);
        String str2 = paramQQAppInterface.getCurrentAccountUin();
        bdeh localbdeh = (bdeh)paramQQAppInterface.getManager(61);
        if (localbdeh != null)
        {
          List localList = localbdeh.a(str1);
          paramReqBody = null;
          localObject1 = null;
          Iterator localIterator1 = ((ArrayList)localObject2).iterator();
          if (localIterator1.hasNext())
          {
            localObject2 = (RevokeMsgInfo)localIterator1.next();
            Iterator localIterator2 = localList.iterator();
            while (localIterator2.hasNext())
            {
              localObject3 = (SubAccountMessage)localIterator2.next();
              if ((((RevokeMsgInfo)localObject2).jdField_a_of_type_Long == ((SubAccountMessage)localObject3).shmsgseq) && (((RevokeMsgInfo)localObject2).jdField_b_of_type_Long == ((SubAccountMessage)localObject3).msgUid))
              {
                localObject1 = localObject3;
                paramReqBody = (Submsgtype0x8a.ReqBody)localObject2;
              }
            }
          }
          for (;;)
          {
            break;
            if (paramReqBody == null) {
              break label814;
            }
            localObject2 = anni.a(2131705440);
            localObject3 = (SubAccountMessage)((SubAccountMessage)localObject1).deepCopyByReflect();
            ((SubAccountMessage)localObject3).msg = ((String)localObject2).concat(BaseApplicationImpl.getApplication().getString(2131693851));
            ((SubAccountMessage)localObject3).unreadNum = Math.max(0, ((SubAccountMessage)localObject1).unreadNum - 1);
            ((SubAccountMessage)localObject3).time = paramReqBody.jdField_c_of_type_Long;
            ((SubAccountMessage)localObject3).needNotify = paramQQAppInterface.isBackground_Pause;
            ((SubAccountMessage)localObject3).mTimeString = bgsu.a(((SubAccountMessage)localObject3).time * 1000L, true, bddy.jdField_a_of_type_JavaLangString);
            ((SubAccountMessage)localObject3).mEmoRecentMsg = new bdnt(((SubAccountMessage)localObject3).msg, 0);
            if (localbdeh != null) {
              localbdeh.b((SubAccountMessage)localObject3);
            }
            bddy.a(paramQQAppInterface, str1, 6);
            paramReqBody = ((SubAccountMessage)localObject3).convertToMessageRecord();
            paramReqBody.istroop = 7000;
            paramReqBody.frienduin = str1;
            paramQQAppInterface.a().d(paramReqBody.frienduin, paramReqBody.istroop, -1);
            if (localbdeh != null) {
              localbdeh.c(str1);
            }
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).add(paramReqBody);
            paramQQAppInterface.a().a((ArrayList)localObject1, str2, false, false, true);
            paramQQAppInterface.E();
            paramReqBody = new bdei();
            paramReqBody.jdField_b_of_type_JavaLangString = str2;
            paramReqBody.jdField_c_of_type_JavaLangString = str1;
            paramReqBody.jdField_c_of_type_Boolean = true;
            paramReqBody.d = true;
            paramReqBody.jdField_a_of_type_Int = 0;
            paramQQAppInterface.a().a().a(8003, true, paramReqBody);
            return;
          }
        }
      }
    }
  }
  
  protected void a()
  {
    this.a.a(Integer.valueOf(0), bcam.class);
    this.a.a(Integer.valueOf(38), bcbd.class);
    this.a.a(Integer.valueOf(48), bcax.class);
    this.a.a(Integer.valueOf(61), bcay.class);
    this.a.a(Integer.valueOf(63), bcat.class);
    this.a.a(Integer.valueOf(78), bcbb.class);
    this.a.a(Integer.valueOf(81), bcan.class);
    this.a.a(Integer.valueOf(102), bcas.class);
    this.a.a(Integer.valueOf(103), bcaq.class);
    this.a.a(Integer.valueOf(107), bcar.class);
    this.a.a(Integer.valueOf(110), bcav.class);
    this.a.a(Integer.valueOf(111), bcbe.class);
    this.a.a(Integer.valueOf(114), bcau.class);
    this.a.a(Integer.valueOf(118), bcal.class);
    this.a.a(Integer.valueOf(124), bcaw.class);
    this.a.a(Integer.valueOf(177), bcbc.class);
    this.a.a(Integer.valueOf(296), bcao.class);
    this.a.a(Integer.valueOf(311), bcao.class);
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bbyn parambbyn)
  {
    if (parambbyn.d) {
      break label8;
    }
    label8:
    Object localObject1;
    int i;
    do
    {
      do
      {
        do
        {
          long l1;
          long l2;
          int j;
          do
          {
            for (;;)
            {
              return;
              if ((paramMsg.msg_body.has()) && (((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()))
              {
                bool = parambbyn.d;
                localObject1 = a(paramMsg);
                if (localObject1 == null) {
                  break;
                }
                i = ((msg_comm.MsgType0x210)localObject1).sub_msg_type.get();
                if (QLog.isColorLevel()) {
                  QLog.d("MsgType0x210Decoder", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 type:" + i);
                }
                Object localObject2 = (bcba)this.a.a(Integer.valueOf(i));
                if (localObject2 != null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("MsgType0x210Decoder", 2, "subType=" + i + ", decoder=" + localObject2);
                  }
                  ((bcba)localObject2).a((msg_comm.MsgType0x210)localObject1, paramMsg, paramList, parambbyn, paramMessageHandler);
                }
                switch (i)
                {
                default: 
                  return;
                case 135: 
                case 141: 
                  try
                  {
                    paramList = new SubMsgType0x87.MsgBody();
                    paramList.mergeFrom(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
                    if (paramList.rpt_msg_msg_notify.has()) {
                      aixz.a(paramMessageHandler.app, paramList);
                    }
                    bbzf.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
                    return;
                  }
                  catch (Exception paramList)
                  {
                    for (;;)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.e("MsgType0x210Decoder", 2, "offline push parse 0x210 subtype 0x87 msg error", paramList);
                      }
                    }
                  }
                case 138: 
                case 139: 
                  if (!bool)
                  {
                    paramMsg = new Submsgtype0x8a.ReqBody();
                    try
                    {
                      paramMsg.mergeFrom(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
                      a(paramMessageHandler.app, paramMsg, 0L, false);
                      return;
                    }
                    catch (Exception paramMessageHandler) {}
                    if (QLog.isColorLevel())
                    {
                      QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b offline msg, prase reqBody error");
                      return;
                    }
                  }
                  break;
                case 155: 
                  paramList = new SubMsgType0x9b.MsgBody();
                  try
                  {
                    paramList.mergeFrom(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
                    bbzf.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
                    return;
                  }
                  catch (InvalidProtocolBufferMicroException paramMessageHandler)
                  {
                    paramMessageHandler.printStackTrace();
                    return;
                  }
                case 170: 
                  if (QLog.isColorLevel()) {
                    QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xaa receive 0xaa push message");
                  }
                  paramList = new SubMsgType0xaa.MsgBody();
                  try
                  {
                    paramList.mergeFrom(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
                    ((auwj)paramMessageHandler.app.getManager(156)).a(paramList, true);
                    bbzf.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
                    return;
                  }
                  catch (Exception parambbyn)
                  {
                    for (;;)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xaa, prase msgBody error");
                      }
                    }
                  }
                case 174: 
                  if (QLog.isColorLevel()) {
                    QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xae receive 0xae push message");
                  }
                  paramList = new SubMsgType0xae.MsgBody();
                  try
                  {
                    paramList.mergeFrom(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
                    if ((paramList.uint32_type.has()) && (paramList.uint32_type.get() == 2))
                    {
                      l1 = paramList.msg_persons_may_know.fixed32_timestamp.get();
                      if (QLog.isColorLevel()) {
                        QLog.d("MsgType0x210Decoder", 2, "handlePushRecommend receive push time=" + l1);
                      }
                      parambbyn = paramList.msg_persons_may_know.rpt_msg_friend_list.get();
                      if ((parambbyn != null) && (parambbyn.size() > 0))
                      {
                        paramList = new ArrayList(parambbyn.size());
                        parambbyn = parambbyn.iterator();
                        while (parambbyn.hasNext())
                        {
                          localObject1 = (SubMsgType0xae.PersonMayKnow)parambbyn.next();
                          localObject2 = new PushRecommend();
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).uint64_uin.has()) {
                            ((PushRecommend)localObject2).uin = Long.toString(((SubMsgType0xae.PersonMayKnow)localObject1).uint64_uin.get());
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).bytes_name.has()) {
                            ((PushRecommend)localObject2).nick = new String(((SubMsgType0xae.PersonMayKnow)localObject1).bytes_name.get().toByteArray());
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).uint32_age.has()) {
                            ((PushRecommend)localObject2).age = ((short)((SubMsgType0xae.PersonMayKnow)localObject1).uint32_age.get());
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).uint32_sex.has()) {
                            ((PushRecommend)localObject2).gender = ((short)((SubMsgType0xae.PersonMayKnow)localObject1).uint32_sex.get());
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).bytes_main_reason.has()) {
                            ((PushRecommend)localObject2).recommendReason = new String(((SubMsgType0xae.PersonMayKnow)localObject1).bytes_main_reason.get().toByteArray());
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).bytes_alghrithm.has()) {
                            ((PushRecommend)localObject2).algBuffer = ((SubMsgType0xae.PersonMayKnow)localObject1).bytes_alghrithm.get().toByteArray();
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).bytes_soure_reason.has()) {
                            ((PushRecommend)localObject2).sourceReason = new String(((SubMsgType0xae.PersonMayKnow)localObject1).bytes_soure_reason.get().toByteArray());
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).uint32_source.has()) {
                            ((PushRecommend)localObject2).fromSource = ((SubMsgType0xae.PersonMayKnow)localObject1).uint32_source.get();
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).msg_android_source.has())
                          {
                            SubMsgType0xae.AddFriendSource localAddFriendSource = (SubMsgType0xae.AddFriendSource)((SubMsgType0xae.PersonMayKnow)localObject1).msg_android_source.get();
                            if (localAddFriendSource != null)
                            {
                              if (localAddFriendSource.uint32_source.has()) {
                                ((PushRecommend)localObject2).sourceId = localAddFriendSource.uint32_source.get();
                              }
                              if (localAddFriendSource.uint32_sub_source.has()) {
                                ((PushRecommend)localObject2).subSourceId = localAddFriendSource.uint32_sub_source.get();
                              }
                            }
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).bytes_msg.has()) {
                            ((PushRecommend)localObject2).wzryVerifyStr = new String(((SubMsgType0xae.PersonMayKnow)localObject1).bytes_msg.get().toByteArray());
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).uint32_game_source.has()) {
                            ((PushRecommend)localObject2).wzrySourceId = ((SubMsgType0xae.PersonMayKnow)localObject1).uint32_game_source.get();
                          }
                          if (((SubMsgType0xae.PersonMayKnow)localObject1).bytes_role_name.has()) {
                            ((PushRecommend)localObject2).wzryGameNick = new String(((SubMsgType0xae.PersonMayKnow)localObject1).bytes_role_name.get().toByteArray());
                          }
                          ((PushRecommend)localObject2).timestamp = l1;
                          paramList.add(localObject2);
                        }
                      }
                    }
                    if (!QLog.isColorLevel()) {}
                  }
                  catch (Exception paramList)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("MayknowRecommendManager", 2, "recv 0x210_0xae, prase msgBody error");
                    }
                    bbzf.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
                    return;
                  }
                case 179: 
                  QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xb3 receive 0xaa push message");
                  paramMsg = ((acwk)paramMessageHandler.a("businessbase_processor")).a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
                  if (!TextUtils.isEmpty(paramMsg))
                  {
                    bool = ((anmw)paramMessageHandler.app.getManager(51)).b(paramMsg);
                    if (QLog.isColorLevel()) {
                      QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xb3 isFriend=" + bool + ", uin=" + paramMsg);
                    }
                    if (!bool)
                    {
                      QLog.d("MsgType0x210Decoder", 1, "handleMsgType0x210SubMsgType0xb3 not friend, getDetail");
                      ((FriendListHandler)paramMessageHandler.app.a(1)).a(paramMsg);
                      return;
                    }
                  }
                  break;
                case 197: 
                  if (QLog.isColorLevel()) {
                    QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xc5 receive 0xc5 push message");
                  }
                  ((acwk)paramMessageHandler.a("businessbase_processor")).a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray(), paramMsg.msg_head.msg_time.get());
                  bbzf.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
                  return;
                case 238: 
                  if (QLog.isColorLevel()) {
                    QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xee receive 0xee push message");
                  }
                  ((acwk)paramMessageHandler.a("businessbase_processor")).b(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray(), paramMsg.msg_head.msg_time.get());
                  bbzf.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
                  return;
                case 249: 
                  paramList = (acwk)paramMessageHandler.a("businessbase_processor");
                  parambbyn = new MsgInfo();
                  parambbyn.lFromUin = paramMsg.msg_head.from_uin.get();
                  parambbyn.shMsgSeq = ((short)paramMsg.msg_head.msg_seq.get());
                  parambbyn.uMsgTime = paramMsg.msg_head.msg_time.get();
                  parambbyn.uRealMsgTime = paramMsg.msg_head.msg_time.get();
                  parambbyn.lMsgUid = paramMsg.msg_head.msg_uid.get();
                  parambbyn.shMsgType = ((short)paramMsg.msg_head.msg_type.get());
                  paramList.a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray(), 2, parambbyn);
                  bbzf.a(paramMessageHandler, parambbyn.lFromUin, parambbyn.shMsgSeq, parambbyn.lMsgUid, parambbyn.shMsgType);
                  return;
                case 258: 
                  if (QLog.isColorLevel()) {
                    QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210_0x102 offline ");
                  }
                  bbzf.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
                  return;
                case 253: 
                  paramList = (acwk)paramMessageHandler.a("businessbase_processor");
                  parambbyn = new MsgInfo();
                  parambbyn.lFromUin = paramMsg.msg_head.from_uin.get();
                  parambbyn.shMsgSeq = ((short)paramMsg.msg_head.msg_seq.get());
                  parambbyn.uMsgTime = paramMsg.msg_head.msg_time.get();
                  parambbyn.uRealMsgTime = paramMsg.msg_head.msg_time.get();
                  parambbyn.lMsgUid = paramMsg.msg_head.msg_uid.get();
                  parambbyn.shMsgType = ((short)paramMsg.msg_head.msg_type.get());
                  paramList.a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray(), 2);
                  bbzf.a(paramMessageHandler, parambbyn.lFromUin, parambbyn.shMsgSeq, parambbyn.lMsgUid, parambbyn.shMsgType);
                  return;
                case 199: 
                  if (QLog.isColorLevel()) {
                    QLog.d("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7  push message");
                  }
                  l1 = paramMsg.msg_head.from_uin.get();
                  i = paramMsg.msg_head.msg_seq.get();
                  l2 = paramMsg.msg_head.msg_uid.get();
                  j = paramMsg.msg_head.msg_type.get();
                  int k = paramMsg.msg_head.msg_time.get();
                  paramMsg = new aofx(l1, i, l2, j, k, false);
                  ((acwk)paramMessageHandler.a("businessbase_processor")).a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray(), paramMsg);
                  bbzf.a(paramMessageHandler, l1, i, l2, j);
                  return;
                case 203: 
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.nearby.tag_nearby_live_tip", 4, "decodeC2CMsgPkg_MsgType0x210 receive 0xcb push message");
                  }
                  paramList = a(paramMessageHandler, ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray(), paramMsg);
                  if ((paramList != null) && (!anqc.a(paramMessageHandler.app, paramList, true)) && (paramList.msgtype == -2053))
                  {
                    paramMsg = (MessageForNearbyLiveTip)paramList;
                    if ((MessageForNearbyLiveTip.isHuayangTip(paramMsg.jumpingUrl)) && (!MessageForNearbyLiveTip.isSupportHuayangBusinessType(paramMsg.jumpingUrl)))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.i("Q.nearby.tag_nearby_live_tip", 2, "decodeC2CMsgPkg_MsgType0x210 discard a not support huayang tips message, jumpUrl=" + paramMsg.jumpingUrl);
                      }
                    }
                    else
                    {
                      if (paramMsg.isLiving)
                      {
                        paramMessageHandler.app.a().a(paramList, paramMessageHandler.app.getCurrentAccountUin());
                        return;
                      }
                      parambbyn = paramMessageHandler.app.a().a(paramMsg.frienduin, paramMsg.istroop);
                      if (parambbyn != null)
                      {
                        paramMessageHandler.app.a().a(paramMsg.frienduin, paramMsg.istroop, parambbyn.uniseq, paramMsg.msgData);
                        paramList = new ArrayList();
                        paramList.add(paramMsg);
                        paramMessageHandler.app.a().e(paramList);
                        return;
                      }
                      paramMessageHandler.app.a().a(paramList, paramMessageHandler.app.getCurrentAccountUin());
                      return;
                    }
                  }
                  break;
                case 254: 
                  if (QLog.isColorLevel()) {
                    QLog.i("MsgType0x210Decoder", 2, "MessageProtoCodec,decodeC2CMsgPkg_MsgType0x210 receive 0xfe push message");
                  }
                  l1 = paramMsg.msg_head.from_uin.get();
                  i = paramMsg.msg_head.msg_seq.get();
                  l2 = paramMsg.msg_head.msg_uid.get();
                  j = paramMsg.msg_head.msg_type.get();
                  ((MsgBoxInterFollowManager)paramMessageHandler.app.getManager(202)).decode0xfeInteractAndFollowMsg(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
                  bbzf.a(paramMessageHandler, l1, i, l2, j);
                  return;
                case 215: 
                  if (QLog.isColorLevel()) {
                    QLog.i("MsgType0x210Decoder", 2, "MessageProtoCodec,decodeC2CMsgPkg_MsgType0x210 receive 0xd7 push message");
                  }
                  l1 = paramMsg.msg_head.from_uin.get();
                  i = paramMsg.msg_head.msg_seq.get();
                  l2 = paramMsg.msg_head.msg_uid.get();
                  j = paramMsg.msg_head.msg_type.get();
                  ((MsgBoxInterFollowManager)paramMessageHandler.app.getManager(202)).decode0xd7InteractAndFollowMsg(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
                  bbzf.a(paramMessageHandler, l1, i, l2, j);
                  return;
                case 220: 
                  if (QLog.isColorLevel()) {
                    QLog.i("MsgType0x210Decoder", 2, "MessageProtoCodec,decodeC2CMsgPkg_MsgType0x210 receive 0xdc push message");
                  }
                  paramList = (amhd)paramMessageHandler.app.getManager(153);
                  if (paramList != null) {
                    paramList.a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
                  }
                  bbzf.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
                  return;
                case 232: 
                  QLog.d("ApolloPushManager", 1, "recv action push message 0x210_0xe8, [C2C.offline]");
                  try
                  {
                    paramMsg = new submsgtype0xe8.MsgBody();
                    paramMsg.mergeFrom(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
                    if (paramMsg.msg_item.has())
                    {
                      paramMsg = (apollo_push_msgInfo.STPushMsgElem)paramMsg.msg_item.get();
                      if (paramMessageHandler.app != null)
                      {
                        paramMessageHandler = (amhy)paramMessageHandler.app.getManager(227);
                        paramMessageHandler.a(0, paramMsg);
                        paramMessageHandler.c(paramMsg);
                        paramMessageHandler.b(paramMsg);
                        return;
                      }
                    }
                  }
                  catch (Exception paramMessageHandler)
                  {
                    paramMessageHandler.printStackTrace();
                    QLog.e("ApolloPushManager", 1, "[msg0x210.uSubMsgType == 0xe8], errInfo->" + paramMessageHandler.getMessage());
                    return;
                  }
                }
              }
            }
            if (QLog.isColorLevel()) {
              QLog.i("MsgType0x210Decoder", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: AIO Feed offline messageRecord: 0xf4");
            }
            l1 = paramMsg.msg_head.from_uin.get();
            paramMsg = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
            paramMessageHandler = (wfe)paramMessageHandler.app.getManager(253);
            paramMessageHandler.a(paramMessageHandler.a(paramMsg, String.valueOf(l1)));
            return;
            if (QLog.isColorLevel()) {
              QLog.i("MsgType0x210Decoder", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: 0xfb");
            }
            try
            {
              paramList = new NowPushMsgList.MsgBody();
              paramList.mergeFrom(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
              paramList = paramList.rpt_now_push_msg.get().iterator();
              while (paramList.hasNext())
              {
                parambbyn = (NowPushMsgList.NowPushMsg)paramList.next();
                if (paramMessageHandler.app != null) {
                  ((aycq)paramMessageHandler.app.getManager(266)).b(parambbyn);
                }
                if (QLog.isColorLevel()) {
                  QLog.d("MsgType0x210Decoder", 2, "decodeC2CMsgPkg_MsgType0x210 0xfb " + parambbyn.uint32_switch.get() + "  uint32_task_id " + parambbyn.uint32_task_id.get() + "  uint32_type " + parambbyn.uint32_type.get() + "  uint64_start_time " + parambbyn.uint64_start_time.get() + "  uint64_end_time " + parambbyn.uint64_end_time.get() + " app=" + paramMessageHandler.app);
                }
              }
              bbzf.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
            }
            catch (Exception paramMessageHandler)
            {
              QLog.e("MsgType0x210Decoder", 1, "[msg0x210.uSubMsgType == 0xfb], errInfo->" + paramMessageHandler.getMessage());
              return;
            }
            return;
            if (QLog.isColorLevel()) {
              QLog.i("MsgType0x210Decoder", 2, "offline push decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x111");
            }
            try
            {
              paramList = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
              anpk.a(paramMessageHandler.app, paramList);
              bbzf.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
              return;
            }
            catch (Exception paramMessageHandler)
            {
              QLog.e("MsgType0x210Decoder", 1, "[msg0x210.uSubMsgType == 0x111], errInfo->" + paramMessageHandler.getMessage());
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.i("MsgType0x210Decoder", 2, "offline push decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x11e");
            }
            try
            {
              paramList = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
              parambbyn = (FriendListHandler)paramMessageHandler.app.a(1);
              if (parambbyn != null) {
                parambbyn.a(paramList);
              }
              bbzf.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
              return;
            }
            catch (Exception paramMessageHandler)
            {
              QLog.e("MsgType0x210Decoder", 1, "[msg0x210.uSubMsgType == 0x11e], errInfo->" + paramMessageHandler.getMessage());
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.d("MsgType0x210Decoder", 2, "offline push decodeC2CMsgPkg_MsgType0x210 invoked, info: 0x11f");
            }
            paramList = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
            avto.a(paramMessageHandler.app, paramList, paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_time.get(), true);
            bbzf.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
            return;
            if (QLog.isColorLevel()) {
              QLog.d("MsgType0x210Decoder", 2, "offline push decodeC2CMsgPkg_MsgType0x127 invoked, info: 0x127");
            }
            paramList = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
            parambbyn = ((bdrb)paramMessageHandler.app.getManager(339)).a(4);
            if (parambbyn != null) {
              parambbyn.a(paramMessageHandler.app, paramList, paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_time.get(), true);
            }
            bbzf.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
            return;
            if (QLog.isColorLevel()) {
              QLog.i("MsgType0x210Decoder", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x100");
            }
          } while (paramMessageHandler.app == null);
          paramList = arkq.a(paramMessageHandler.app, ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray(), paramMsg);
          paramMessageHandler.app.a().a(paramList, paramMessageHandler.app.getCurrentAccountUin());
          bbzf.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0x104  push message");
          }
          try
          {
            l1 = paramMsg.msg_head.from_uin.get();
            i = paramMsg.msg_head.msg_seq.get();
            l2 = paramMsg.msg_head.msg_uid.get();
            j = paramMsg.msg_head.msg_type.get();
            paramMsg = new submsgtype0x104.MsgBody();
            paramMsg.mergeFrom(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
            paramMessageHandler.app.a().a().a(paramMsg);
            bbzf.a(paramMessageHandler, l1, i, l2, j);
            return;
          }
          catch (Exception paramMessageHandler) {}
        } while (!QLog.isColorLevel());
        QLog.i("MsgType0x210Decoder", 2, "onLinePush receive 0x210_0x104 wrong:" + paramMessageHandler.toString());
        return;
        if (QLog.isColorLevel()) {
          QLog.i("MsgType0x210Decoder", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x108");
        }
      } while (paramMessageHandler.app == null);
      paramList = arlu.a(paramMessageHandler.app, ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray(), paramMsg);
      paramMessageHandler.app.a().a(paramList, paramMessageHandler.app.getCurrentAccountUin());
      bbzf.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      return;
    } while (!QLog.isColorLevel());
    QLog.d("MsgType0x210Decoder", 2, "submsgtype0x116 decodeC2CMsgPkg_MsgType0x210 receive 0x116 push message");
    return;
    paramList = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x210Decoder", 2, "troopFormLog offLinePush receive submsgtype0x119 decodeC2CMsgPkg_MsgType0x210 receive 0x119 push message");
    }
    try
    {
      parambbyn = new SubMsgType0x119.MsgBody();
      parambbyn.mergeFrom(paramList);
      if (!bdjg.a(paramMsg.msg_head.msg_seq.get()))
      {
        bdjg.a(paramMessageHandler.app, parambbyn);
        QLog.d("MsgType0x210Decoder", 1, "troopFormLog isPushMessageDuplicated ");
      }
      bbzf.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      return;
    }
    catch (Exception paramMessageHandler)
    {
      QLog.e("MsgType0x210Decoder", 1, "troopFormLog offLinePush receive submsgtype0x119 decodeC2CMsgPkg_MsgType0x210 receive 0x119 push message, errInfo->" + paramMessageHandler.getMessage());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x210Decoder", 2, "handleC2COfflinePushMsgGrayTip subType = " + i);
    }
    paramList = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
    parambbyn = new MsgInfo();
    parambbyn.lFromUin = paramMsg.msg_head.from_uin.get();
    parambbyn.shMsgSeq = ((short)paramMsg.msg_head.msg_seq.get());
    parambbyn.uMsgTime = paramMsg.msg_head.msg_time.get();
    parambbyn.uRealMsgTime = paramMsg.msg_head.msg_time.get();
    parambbyn.lMsgUid = paramMsg.msg_head.msg_uid.get();
    parambbyn.shMsgType = ((short)paramMsg.msg_head.msg_type.get());
    paramMessageHandler = paramMessageHandler.app;
    if (i == 290) {}
    for (boolean bool = true;; bool = false)
    {
      auxd.a(paramMessageHandler, paramList, parambbyn, bool);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MsgType0x210Decoder", 2, "offline push decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x133");
    }
    try
    {
      paramList = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
      parambbyn = (aiug)paramMessageHandler.app.a(169);
      if (parambbyn != null) {
        parambbyn.a(paramList);
      }
      bbzf.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      return;
    }
    catch (Exception paramMessageHandler)
    {
      QLog.e("MsgType0x210Decoder", 1, "[msg0x210.uSubMsgType == 0x133], errInfo->" + paramMessageHandler.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcap
 * JD-Core Version:    0.7.0.1
 */