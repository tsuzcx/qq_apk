package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x54.submsgtype0x54.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x54.submsgtype0x54.MsgBody.TaskInfo;

public class SubType0x54
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQOperateVoIP", 2, "get voip_tips from handleC2COnlinePushMsg0x210Resp");
    }
    paramQQAppInterface = (ConfigHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
    if (paramQQAppInterface != null)
    {
      submsgtype0x54.MsgBody localMsgBody = new submsgtype0x54.MsgBody();
      try
      {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      }
      catch (InvalidProtocolBufferMicroException paramMsgType0x210)
      {
        paramMsgType0x210.printStackTrace();
      }
      int i = localMsgBody.peer_type.get();
      Object localObject = localMsgBody.task_list.get();
      paramMsgType0x210 = new ArrayList();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          submsgtype0x54.MsgBody.TaskInfo localTaskInfo = (submsgtype0x54.MsgBody.TaskInfo)((Iterator)localObject).next();
          QQOperationViopTipTask localQQOperationViopTipTask = new QQOperationViopTipTask();
          localQQOperationViopTipTask.taskid = localTaskInfo.task_id.get();
          paramMsgType0x210.add(localQQOperationViopTipTask);
        }
      }
      long l = localMsgBody.peer_uin.get();
      if (i == 1) {
        i = 0;
      } else {
        i = 3000;
      }
      paramQQAppInterface.a(String.valueOf(l), i, paramMsgType0x210);
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x54
 * JD-Core Version:    0.7.0.1
 */