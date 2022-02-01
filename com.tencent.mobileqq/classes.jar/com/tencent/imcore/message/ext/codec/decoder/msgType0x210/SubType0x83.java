package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x83.SubMsgType0x83.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x83.SubMsgType0x83.MsgParams;

public class SubType0x83
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x83");
    }
    Object localObject = new SubMsgType0x83.MsgBody();
    try
    {
      ((SubMsgType0x83.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      if (!((SubMsgType0x83.MsgBody)localObject).uint64_group_id.has())
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x83 : msg has not uint64_group_id");
        }
        return;
      }
      if (((SubMsgType0x83.MsgBody)localObject).rpt_msg_params.has())
      {
        paramArrayOfByte = ((SubMsgType0x83.MsgBody)localObject).rpt_msg_params;
        boolean bool = ((SubMsgType0x83.MsgBody)localObject).uint64_seq.has();
        long l2 = -1L;
        long l1;
        if (bool) {
          l1 = ((SubMsgType0x83.MsgBody)localObject).uint64_seq.get();
        } else {
          l1 = -1L;
        }
        if (((SubMsgType0x83.MsgBody)localObject).uint64_group_id.has()) {
          l2 = ((SubMsgType0x83.MsgBody)localObject).uint64_group_id.get();
        }
        int i = 0;
        while (i < paramArrayOfByte.size())
        {
          localObject = (SubMsgType0x83.MsgParams)paramArrayOfByte.get(i);
          if ((localObject != null) && (((SubMsgType0x83.MsgParams)localObject).uint32_type.has()))
          {
            int j = ((SubMsgType0x83.MsgParams)localObject).uint32_type.get();
            a((QQAppInterface)paramOnLinePushMessageProcessor.a(), l1, l2, (SubMsgType0x83.MsgParams)localObject, j);
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramOnLinePushMessageProcessor)
    {
      label205:
      break label205;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x83 : fail to parse submsgtype0x83.");
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, SubMsgType0x83.MsgParams paramMsgParams, int paramInt)
  {
    Object localObject;
    if ((paramInt >= 2001) && (paramInt <= 3000)) {
      if ((paramMsgParams.str_data.has()) && (paramMsgParams.uint64_from_uin.has()))
      {
        if (!paramMsgParams.uint64_to_uin.has()) {
          return;
        }
        localObject = paramMsgParams.str_data.get();
      }
    }
    try
    {
      i = new JSONObject((String)localObject).getInt("count");
      paramQQAppInterface.getGAudioHandler().a(paramInt, paramMsgParams.uint64_from_uin.get(), paramMsgParams.uint64_to_uin.get(), i, paramLong1, paramLong2);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      int i;
      return;
    }
    return;
    if (paramInt == 1005)
    {
      if ((paramMsgParams.str_data.has()) && (paramMsgParams.uint64_from_uin.has()))
      {
        if (!paramMsgParams.uint64_to_uin.has()) {
          return;
        }
        localObject = paramMsgParams.str_data.get();
        localObject = new JSONObject((String)localObject);
        paramInt = ((JSONObject)localObject).optInt("enable");
        i = ((JSONObject)localObject).optInt("level");
        paramQQAppInterface.getGAudioHandler().a(paramMsgParams.uint32_type.get(), paramMsgParams.uint64_from_uin.get(), paramMsgParams.uint64_to_uin.get(), paramInt, i, paramLong1, paramLong2);
        return;
      }
      return;
    }
    if (paramInt == 1010)
    {
      if (!paramMsgParams.bytes_data.has()) {
        return;
      }
      paramMsgParams = new String(paramMsgParams.bytes_data.get().toByteArray());
      paramMsgParams = new JSONObject(paramMsgParams);
      if (paramMsgParams.getInt("sndRank") == 0) {
        break label324;
      }
      paramInt = 1;
    }
    for (;;)
    {
      boolean bool = paramMsgParams.getBoolean("rank_changed");
      if ((paramInt != 0) && (bool)) {
        paramQQAppInterface.getGAudioHandler().a(paramLong2);
      }
      return;
      label324:
      paramInt = 0;
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x83
 * JD-Core Version:    0.7.0.1
 */