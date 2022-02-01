package com.tencent.mobileqq.app.pbsendhandler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_ctrl.MsgCtrl;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.im_msg_body.RichText;

public class PicMsgPbSendReqHandler
  implements IPbSendReqHandler
{
  private void a(MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      paramMessageRecord = (MessageForPic)paramMessageRecord;
      if ((paramMessageRecord.msgCtrl != null) && (paramPbSendMsgReq != null))
      {
        paramPbSendMsgReq.msg_ctrl.set(paramMessageRecord.msgCtrl);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandlerUtils", 2, "set msg_crl for MessageForPic");
        }
      }
    }
  }
  
  public msg_svc.PbSendMsgReq a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, int paramInt, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    a(paramMessageRecord, paramPbSendMsgReq);
    return paramPbSendMsgReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.pbsendhandler.PicMsgPbSendReqHandler
 * JD-Core Version:    0.7.0.1
 */