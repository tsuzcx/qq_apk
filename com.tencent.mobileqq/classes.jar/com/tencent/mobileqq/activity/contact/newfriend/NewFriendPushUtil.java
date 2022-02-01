package com.tencent.mobileqq.activity.contact.newfriend;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.managers.PushNoticeManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.pushsvr.pushsvrExt.ExtData;
import tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27.ClientReport;
import tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27.PushPlatform;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class NewFriendPushUtil
{
  private static final AtomicInteger a = new AtomicInteger(1);
  
  public static int a(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = MessageForSystemMsg.parseStructMsg(paramMessageRecord.msgData);
    if (paramMessageRecord.msg_type.get() == 1) {
      return paramMessageRecord.msg.sub_type.get();
    }
    return -1;
  }
  
  public static final void a(AppInterface paramAppInterface, long paramLong1, long paramLong2, short paramShort, msg_comm.Msg paramMsg, int paramInt)
  {
    if ((paramShort != 188) && (paramShort != 189)) {
      return;
    }
    Object localObject1 = null;
    Object localObject2 = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (localObject2 != null)
    {
      paramMsg = new StringBuilder();
      paramMsg.append("");
      paramMsg.append(((msg_comm.MsgHead)localObject2).auth_uin.get());
      paramMsg = paramMsg.toString();
      localObject1 = ((msg_comm.MsgHead)localObject2).auth_nick.get();
      localObject2 = ((msg_comm.MsgHead)localObject2).auth_remark.get();
      boolean bool1 = TextUtils.isEmpty(paramMsg);
      boolean bool2 = TextUtils.isEmpty((CharSequence)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        paramMsg = (msg_comm.Msg)localObject2;
      } else if (!bool2) {
        paramMsg = (msg_comm.Msg)localObject1;
      } else if (bool1) {
        paramMsg = String.valueOf(paramLong2);
      }
      localObject1 = paramMsg;
      if (TextUtils.isEmpty(paramMsg)) {
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendPushUtil", 2, String.format(Locale.getDefault(), "handleNewFrdSystemPush [0x%x,%d,%s,%d]", new Object[] { Short.valueOf(paramShort), Long.valueOf(paramLong2), localObject1, Integer.valueOf(paramInt) }));
    }
    localObject2 = new SubMsgType0x27.MsgBody();
    SubMsgType0x27.PushPlatform localPushPlatform = new SubMsgType0x27.PushPlatform();
    SubMsgType0x27.ClientReport localClientReport = new SubMsgType0x27.ClientReport();
    localClientReport.uint32_service_id.set(1005);
    PBStringField localPBStringField = localClientReport.str_content_id;
    if (paramShort == 188) {
      paramMsg = "0xbc";
    } else {
      paramMsg = "0xbd";
    }
    localPBStringField.set(paramMsg);
    ((SubMsgType0x27.MsgBody)localObject2).msg_client_report.set(localClientReport);
    localPushPlatform.uint32_forward_type.set(1);
    localPushPlatform.uint64_from_uin.set(paramLong2);
    paramMsg = String.format(HardCodeUtil.a(2131707522), new Object[] { localObject1 });
    localPushPlatform.str_desc.set(paramMsg);
    localPushPlatform.str_target_url.set(Base64.encodeToString("newfrd_add".getBytes(), 0));
    localPushPlatform.str_title.set(HardCodeUtil.a(2131707523));
    paramMsg = new pushsvrExt.ExtData();
    paramMsg.uint64_to_uin.set(paramLong2);
    paramMsg.str_remark.set(ByteStringMicro.copyFromUtf8((String)localObject1));
    localPushPlatform.bytes_ext_data.set(ByteStringMicro.copyFrom(paramMsg.toByteArray()));
    ((SubMsgType0x27.MsgBody)localObject2).msg_push_platform.set(localPushPlatform);
    ((PushNoticeManager)paramAppInterface.getManager(QQManagerFactory.PUSH_NOTICE_MANAGER)).a((SubMsgType0x27.MsgBody)localObject2, (short)(a.getAndIncrement() % 32767), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendPushUtil
 * JD-Core Version:    0.7.0.1
 */