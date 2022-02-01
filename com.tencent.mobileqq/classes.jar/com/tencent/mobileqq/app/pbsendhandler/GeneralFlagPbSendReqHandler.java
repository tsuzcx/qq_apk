package com.tencent.mobileqq.app.pbsendhandler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.List;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;

public class GeneralFlagPbSendReqHandler
  implements IPbSendReqHandler
{
  public msg_svc.PbSendMsgReq a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, int paramInt, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    paramAppInterface = MessageHandlerUtils.a(paramAppInterface, paramMessageRecord, paramPbSendMsgReq);
    if ((paramAppInterface != null) && (paramPbSendMsgReq != null))
    {
      paramMessageRecord = (im_msg_body.RichText)((im_msg_body.MsgBody)paramPbSendMsgReq.msg_body.get()).rich_text.get();
      paramRichText = new im_msg_body.Elem();
      paramRichText.general_flags.set(paramAppInterface);
      paramMessageRecord.elems.get().add(paramRichText);
    }
    return paramPbSendMsgReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.pbsendhandler.GeneralFlagPbSendReqHandler
 * JD-Core Version:    0.7.0.1
 */