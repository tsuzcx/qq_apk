package com.tencent.mobileqq.activity.phone;

import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqpim.QQPimGetTipsInfoIPC.IGetQQPimTipsCallBack;
import cooperation.qqpim.QQPimTipsInfo;
import cooperation.qqpim.QQPimTipsInfoHelper;

class ContactListView$5
  implements QQPimGetTipsInfoIPC.IGetQQPimTipsCallBack
{
  ContactListView$5(ContactListView paramContactListView) {}
  
  public void a(QQPimTipsInfo paramQQPimTipsInfo)
  {
    if (paramQQPimTipsInfo == null) {
      return;
    }
    QLog.i("ContactListView", 2, "getQQPimTips() callback ");
    QQPimTipsInfoHelper.b(this.a.getContext(), paramQQPimTipsInfo);
    Message localMessage = new Message();
    localMessage.what = 6;
    localMessage.obj = paramQQPimTipsInfo;
    this.a.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.ContactListView.5
 * JD-Core Version:    0.7.0.1
 */