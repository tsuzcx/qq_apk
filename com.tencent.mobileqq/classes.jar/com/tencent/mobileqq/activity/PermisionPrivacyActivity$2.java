package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class PermisionPrivacyActivity$2
  implements Runnable
{
  PermisionPrivacyActivity$2(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void run()
  {
    boolean bool = ((FriendsManager)this.this$0.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.this$0.app.getCurrentAccountUin()).medalSwitchDisable;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PermisionPrivacyActivity initUI medalSwitchDisable = ");
      localStringBuilder.append(bool);
      QLog.d("Q.security", 2, localStringBuilder.toString());
    }
    this.this$0.runOnUiThread(new PermisionPrivacyActivity.2.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.2
 * JD-Core Version:    0.7.0.1
 */