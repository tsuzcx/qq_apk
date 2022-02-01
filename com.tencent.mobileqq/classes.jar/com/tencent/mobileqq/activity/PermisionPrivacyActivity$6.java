package com.tencent.mobileqq.activity;

import anvk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.ArrayList;

class PermisionPrivacyActivity$6
  implements Runnable
{
  PermisionPrivacyActivity$6(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void run()
  {
    ArrayList localArrayList = ((anvk)this.this$0.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a();
    if ((localArrayList == null) || (localArrayList.isEmpty())) {}
    for (int i = 0;; i = localArrayList.size())
    {
      PermisionPrivacyActivity.a(this.this$0, i);
      this.this$0.runOnUiThread(new PermisionPrivacyActivity.6.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.6
 * JD-Core Version:    0.7.0.1
 */