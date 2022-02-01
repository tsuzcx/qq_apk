package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x6b.SubMsgType0x6b.MsgBody;

public class SubType0x6b
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Push_PCActive_Notice", 2, "get notice from handleC2COnlinePushMsg0x210Resp");
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PCActive", 2, "recv pcactive notice push");
      }
      localMsgBody = new SubMsgType0x6b.MsgBody();
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      l = localMsgBody.uint64_to_uin.get();
      paramMsgType0x210 = paramOnLinePushMessageProcessor.a().getAccount();
      localObject1 = BaseApplicationImpl.getApplication();
      localObject2 = Long.toString(l);
      localObject4 = null;
      if (!SettingCloneUtil.readValue((Context)localObject1, (String)localObject2, null, "qqsetting_pcactive_key", false))
      {
        bool = Long.toString(l).equals(paramMsgType0x210);
        if (!bool) {}
      }
    }
    catch (InvalidProtocolBufferMicroException paramMsgType0x210)
    {
      SubMsgType0x6b.MsgBody localMsgBody;
      long l;
      Object localObject1;
      Object localObject2;
      Object localObject4;
      boolean bool;
      MsgType0x210 localMsgType0x210;
      Object localObject3;
      label241:
      label247:
      paramMsgType0x210.printStackTrace();
      paramOnLinePushMessageProcessor.a(8013, false, new Object[] { "", "", "", "" });
    }
    try
    {
      bool = localMsgBody.bytes_tips_content.has();
      if (bool) {
        paramMsgType0x210 = new String(localMsgBody.bytes_tips_content.get().toByteArray(), "utf-8");
      } else {
        paramMsgType0x210 = null;
      }
    }
    catch (Exception paramMsgType0x210)
    {
      break label247;
    }
    try
    {
      if (localMsgBody.bytes_yes_text.has()) {
        localObject1 = new String(localMsgBody.bytes_yes_text.get().toByteArray(), "utf-8");
      } else {
        localObject1 = null;
      }
      localObject2 = localObject4;
      localMsgType0x210 = paramMsgType0x210;
      localObject3 = localObject1;
    }
    catch (Exception localException1)
    {
      break label241;
    }
    try
    {
      if (!localMsgBody.bytes_no_text.has()) {
        break label288;
      }
      localObject2 = new String(localMsgBody.bytes_no_text.get().toByteArray(), "utf-8");
      localMsgType0x210 = paramMsgType0x210;
      localObject3 = localObject1;
    }
    catch (Exception localException2)
    {
      break label252;
    }
    localObject1 = null;
    break label252;
    paramMsgType0x210 = null;
    localObject1 = paramMsgType0x210;
    label252:
    localObject2 = localObject4;
    localMsgType0x210 = paramMsgType0x210;
    localObject3 = localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("Push_PCActive_Notice", 2, "failed to parse msg0x210.SubMsgType0x6b");
      localObject3 = localObject1;
      localMsgType0x210 = paramMsgType0x210;
      localObject2 = localObject4;
    }
    label288:
    BaseApplicationImpl.getApplication().setPCActiveNotice(Long.toString(l), localMsgType0x210, (String)localObject2, localObject3);
    paramOnLinePushMessageProcessor.a(8013, true, new Object[] { Long.toString(l), localMsgType0x210, localObject2, localObject3 });
    break label395;
    if (QLog.isColorLevel()) {
      QLog.d("Push_PCActive_Notice", 2, "swtich closed or uin cannot be matched");
    }
    label395:
    MessageProtoCodec.a(paramMsgInfo.lFromUin, paramMsgInfo.shMsgSeq, paramMsgInfo.lMsgUid, paramMsgInfo.shMsgType, paramOnLinePushMessageProcessor.a());
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x6b
 * JD-Core Version:    0.7.0.1
 */