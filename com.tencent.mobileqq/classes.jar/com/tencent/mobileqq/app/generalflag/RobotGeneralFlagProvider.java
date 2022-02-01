package com.tencent.mobileqq.app.generalflag;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class RobotGeneralFlagProvider
  implements IGeneralFlagProvider
{
  public boolean[] a(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2, MessageRecord paramMessageRecord, generalflags.ResvAttr paramResvAttr, msg_svc.PbSendMsgReq paramPbSendMsgReq, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    paramAppInterface = paramMessageRecord.getExtInfoFromExtStr("robot_news_class_id");
    try
    {
      paramResvAttr.uint32_bot_message_class_id.set(Integer.parseInt(paramAppInterface));
      label20:
      return new boolean[] { paramBoolean1, paramBoolean2 };
    }
    catch (Exception paramAppInterface)
    {
      break label20;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.generalflag.RobotGeneralFlagProvider
 * JD-Core Version:    0.7.0.1
 */