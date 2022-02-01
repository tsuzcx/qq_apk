package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.content.Intent;
import com.tencent.av.VideoPackageUtils;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116.MsgBody;

public class SubType0x116
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    Object localObject = new submsgtype0x116.MsgBody();
    try
    {
      ((submsgtype0x116.MsgBody)localObject).mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      localInvalidProtocolBufferMicroException.printStackTrace();
    }
    long l1 = VideoPackageUtils.a(((submsgtype0x116.MsgBody)localObject).uint32_group_id.get());
    long l2 = VideoPackageUtils.a(((submsgtype0x116.MsgBody)localObject).uint32_room_id.get());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleMsgType0x210SuMsgType0x116 qqMainThread;roomId=");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(";groupId=");
      ((StringBuilder)localObject).append(l1);
      QLog.d("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (paramQQAppInterface != null)
    {
      localObject = new Intent("tencent.video.q2v.GvideoMemInviteUpdate");
      ((Intent)localObject).putExtra("uin", paramQQAppInterface.getCurrentUin());
      ((Intent)localObject).putExtra("groupId", l1);
      ((Intent)localObject).putExtra("roomId", l2);
      ((Intent)localObject).putExtra("pushData", paramArrayOfByte);
      ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
      paramQQAppInterface.getApp().sendBroadcast((Intent)localObject);
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x116
 * JD-Core Version:    0.7.0.1
 */