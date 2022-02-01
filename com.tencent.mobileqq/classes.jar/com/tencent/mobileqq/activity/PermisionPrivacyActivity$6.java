package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.ArrayList;

class PermisionPrivacyActivity$6
  implements Runnable
{
  PermisionPrivacyActivity$6(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void run()
  {
    ArrayList localArrayList = ((FriendsManager)this.this$0.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a();
    int i;
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      i = localArrayList.size();
    } else {
      i = 0;
    }
    PermisionPrivacyActivity.a(this.this$0, i);
    this.this$0.runOnUiThread(new PermisionPrivacyActivity.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.6
 * JD-Core Version:    0.7.0.1
 */