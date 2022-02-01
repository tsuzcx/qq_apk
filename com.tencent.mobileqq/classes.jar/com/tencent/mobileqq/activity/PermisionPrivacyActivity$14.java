package com.tencent.mobileqq.activity;

import anvk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class PermisionPrivacyActivity$14
  implements Runnable
{
  PermisionPrivacyActivity$14(PermisionPrivacyActivity paramPermisionPrivacyActivity, boolean paramBoolean) {}
  
  public void run()
  {
    anvk localanvk = (anvk)this.this$0.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Card localCard = localanvk.b(this.this$0.app.getCurrentAccountUin());
    if (localCard != null)
    {
      if (!this.a) {}
      for (boolean bool = true;; bool = false)
      {
        localCard.isHidePrettyGroutIdentity = bool;
        if (localanvk.a(localCard)) {
          break;
        }
        QLog.e("vip_pretty.Q.security", 1, "onGetPrettyOwnerFlag save card flag=" + this.a + " failed");
        return;
      }
      QLog.e("vip_pretty.Q.security", 1, "onGetPrettyOwnerFlag save card flag=" + this.a + " success");
      return;
    }
    QLog.e("vip_pretty.Q.security", 1, "onGetPrettyOwnerFlag save card failed because card is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.14
 * JD-Core Version:    0.7.0.1
 */