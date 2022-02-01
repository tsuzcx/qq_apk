package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendsManager;
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
    Object localObject = (FriendsManager)this.this$0.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Card localCard = ((FriendsManager)localObject).a(this.this$0.app.getCurrentAccountUin());
    if (localCard != null)
    {
      localCard.isHidePrettyGroutIdentity = (this.a ^ true);
      if (!((FriendsManager)localObject).a(localCard))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGetPrettyOwnerFlag save card flag=");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append(" failed");
        QLog.e("vip_pretty.Q.security", 1, ((StringBuilder)localObject).toString());
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetPrettyOwnerFlag save card flag=");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" success");
      QLog.e("vip_pretty.Q.security", 1, ((StringBuilder)localObject).toString());
      return;
    }
    QLog.e("vip_pretty.Q.security", 1, "onGetPrettyOwnerFlag save card failed because card is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.14
 * JD-Core Version:    0.7.0.1
 */