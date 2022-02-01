package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x117.submsgtype0x117.MsgBody;

public class SubType0x117
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject = new submsgtype0x117.MsgBody();
    try
    {
      ((submsgtype0x117.MsgBody)localObject).mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    List localList = ((submsgtype0x117.MsgBody)localObject).rpt_uint32_moudle_id.get();
    long l = ((submsgtype0x117.MsgBody)localObject).uint64_uin.get();
    if ((localList != null) && (localList.size() != 0))
    {
      paramArrayOfByte = new StringBuilder(HardCodeUtil.a(2131707842));
      paramArrayOfByte.append(l);
      localObject = localList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        int i = ((Integer)((Iterator)localObject).next()).intValue();
        if (i == 92) {
          paramArrayOfByte.append("|音视频");
        } else if (i == 93) {
          paramArrayOfByte.append("|双人");
        } else if (i == 94) {
          paramArrayOfByte.append("|多人");
        }
      }
      paramArrayOfByte.append("】");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleMsgType0x210SuMsgType0x117 音视频测试环境push");
        ((StringBuilder)localObject).append(paramArrayOfByte.toString());
        QLog.d("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SuMsgType0x117 音视频测试环境push,moudleIds==null || moudleIds.size()== 0");
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x117
 * JD-Core Version:    0.7.0.1
 */