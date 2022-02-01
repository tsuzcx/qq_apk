package com.tencent.mobileqq.app;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.MultiMsgAssist;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.RichText;

public abstract interface MessageHandlerUtils$Callback
{
  public abstract long a(long paramLong, msg_comm.UinPairMsg paramUinPairMsg, AppInterface paramAppInterface);
  
  public abstract String a(AppInterface paramAppInterface, String paramString1, String paramString2);
  
  public abstract void a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq);
  
  public abstract void a(Object paramObject, msg_svc.MultiMsgAssist paramMultiMsgAssist);
  
  public abstract boolean a(MessageRecord paramMessageRecord);
  
  public abstract boolean a(MessageRecord paramMessageRecord, im_msg_body.GeneralFlags paramGeneralFlags);
  
  public abstract Object[] a(MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, int paramInt);
  
  public abstract boolean b(MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandlerUtils.Callback
 * JD-Core Version:    0.7.0.1
 */