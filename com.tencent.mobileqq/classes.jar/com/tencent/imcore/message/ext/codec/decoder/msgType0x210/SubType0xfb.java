package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.now.enter.NowHongbaoPushManager;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList.MsgBody;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList.NowPushMsg;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class SubType0xfb
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xfb");
    }
    try
    {
      Object localObject = new NowPushMsgList.MsgBody();
      if (paramOnLinePushMessageProcessor.b(paramMsgType0x210))
      {
        ((NowPushMsgList.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
        paramMsgType0x210 = ((NowPushMsgList.MsgBody)localObject).rpt_now_push_msg.get().iterator();
        while (paramMsgType0x210.hasNext())
        {
          localObject = (NowPushMsgList.NowPushMsg)paramMsgType0x210.next();
          ((NowHongbaoPushManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.NOW_HONG_BAO_PUSH_MANAGER)).a((NowPushMsgList.NowPushMsg)localObject);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onLinePush receive 0x210_0xfb ");
            localStringBuilder.append(((NowPushMsgList.NowPushMsg)localObject).uint32_switch.get());
            localStringBuilder.append("  uint32_task_id ");
            localStringBuilder.append(((NowPushMsgList.NowPushMsg)localObject).uint32_task_id.get());
            localStringBuilder.append("  uint32_type ");
            localStringBuilder.append(((NowPushMsgList.NowPushMsg)localObject).uint32_type.get());
            localStringBuilder.append("  uint64_start_time ");
            localStringBuilder.append(((NowPushMsgList.NowPushMsg)localObject).uint64_start_time.get());
            localStringBuilder.append("  uint64_end_time ");
            localStringBuilder.append(((NowPushMsgList.NowPushMsg)localObject).uint64_end_time.get());
            QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
          }
        }
      }
      return;
    }
    catch (Exception paramOnLinePushMessageProcessor)
    {
      paramMsgType0x210 = new StringBuilder();
      paramMsgType0x210.append("[msg0x210.uSubMsgType == 0xfb], errInfo->");
      paramMsgType0x210.append(paramOnLinePushMessageProcessor.getMessage());
      QLog.e("Q.msg.BaseMessageProcessor", 1, paramMsgType0x210.toString());
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xfb
 * JD-Core Version:    0.7.0.1
 */