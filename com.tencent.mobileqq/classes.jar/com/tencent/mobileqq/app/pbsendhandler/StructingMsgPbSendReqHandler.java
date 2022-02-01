package com.tencent.mobileqq.app.pbsendhandler;

import com.tencent.biz.pubaccount.util.ShareStructLongMessageManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import msf.msgsvc.msg_ctrl.MsgCtrl;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.im_msg_body.RichText;

public class StructingMsgPbSendReqHandler
  implements IPbSendReqHandler
{
  private void a(MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    if ((paramPbSendMsgReq != null) && ((paramMessageRecord instanceof MessageForStructing)))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if ((paramMessageRecord.structingMsg != null) && (ShareStructLongMessageManager.a(paramMessageRecord.structingMsg)))
      {
        paramMessageRecord = new msg_ctrl.MsgCtrl();
        paramMessageRecord.msg_flag.set(4);
        paramPbSendMsgReq.msg_ctrl.set(paramMessageRecord);
      }
    }
  }
  
  public msg_svc.PbSendMsgReq a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, int paramInt, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    a(paramMessageRecord, paramPbSendMsgReq);
    return paramPbSendMsgReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.pbsendhandler.StructingMsgPbSendReqHandler
 * JD-Core Version:    0.7.0.1
 */