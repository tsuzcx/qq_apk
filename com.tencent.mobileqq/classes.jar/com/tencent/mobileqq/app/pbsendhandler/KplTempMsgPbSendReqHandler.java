package com.tencent.mobileqq.app.pbsendhandler;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.im_msg_body.RichText;

public class KplTempMsgPbSendReqHandler
  implements IPbSendReqHandler
{
  private void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "get kpl global flag");
      }
      paramMessageRecord.saveExtInfoToExtStr("msg_ext_key", "Y");
      String str = paramMessageRecord.frienduin;
      int i = paramMessageRecord.istroop;
      long l = paramMessageRecord.uniseq;
      paramQQAppInterface.getMessageFacade().a(str, i, l, "extStr", paramMessageRecord.extStr);
      paramQQAppInterface.getMessageFacade().a(str, i, l, "extLong", Integer.valueOf(paramMessageRecord.extLong));
    }
  }
  
  public msg_svc.PbSendMsgReq a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, int paramInt, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    a((QQAppInterface)paramAppInterface, paramMessageRecord);
    return paramPbSendMsgReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.pbsendhandler.KplTempMsgPbSendReqHandler
 * JD-Core Version:    0.7.0.1
 */