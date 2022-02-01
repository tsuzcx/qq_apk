package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.LinkStarDebugProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class SubType0xef
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xef, [linkstar push test]");
    }
    int j = paramMsgType0x210.vProtobuf.length;
    if (j < 6)
    {
      paramMsgType0x210 = new StringBuilder();
      paramMsgType0x210.append("onLinePush receive 0x210_0xef, [linkstar push test]. vProtoBuf.length is ");
      paramMsgType0x210.append(j);
      QLog.d("Q.msg.BaseMessageProcessor", 2, paramMsgType0x210.toString());
      return;
    }
    int i = (paramMsgType0x210.vProtobuf[0] << 4) + paramMsgType0x210.vProtobuf[1];
    byte[] arrayOfByte = new byte[4];
    System.arraycopy(paramMsgType0x210.vProtobuf, 2, arrayOfByte, 0, 4);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLinePush receive 0x210_0xef, [linkstar push test]. msgType=");
      ((StringBuilder)localObject).append(i);
      QLog.d("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.getUIHandler().post(new SubType0xef.1(i));
    if (j > 6)
    {
      j -= 6;
      localObject = new byte[j];
      System.arraycopy(paramMsgType0x210.vProtobuf, 6, localObject, 0, j);
      LinkStarDebugProcessor.a(i, arrayOfByte, (byte[])localObject);
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xef
 * JD-Core Version:    0.7.0.1
 */