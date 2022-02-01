package com.tencent.imcore.message.core.codec;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.im_msg_body.RichText;

public abstract interface CreatePbSendReqFromMessageCallback
{
  public abstract im_msg_body.RichText a(MessageRecord paramMessageRecord, AppInterface paramAppInterface);
  
  public abstract void a(MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, AppInterface paramAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.core.codec.CreatePbSendReqFromMessageCallback
 * JD-Core Version:    0.7.0.1
 */