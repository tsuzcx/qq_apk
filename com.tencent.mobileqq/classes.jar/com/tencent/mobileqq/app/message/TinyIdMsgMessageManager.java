package com.tencent.mobileqq.app.message;

import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class TinyIdMsgMessageManager
  extends C2CMessageManager
{
  public TinyIdMsgMessageManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, MsgPool paramMsgPool)
  {
    super(paramQQAppInterface, paramQQMessageFacade, paramMsgPool);
    if (QLog.isColorLevel()) {
      QLog.d("TinyIdMsgMessageManager", 2, "TinyIdMsgMessageManager() called with: app = [" + paramQQAppInterface + "], msgFacade = [" + paramQQMessageFacade + "], msgPool = [" + paramMsgPool + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.TinyIdMsgMessageManager
 * JD-Core Version:    0.7.0.1
 */