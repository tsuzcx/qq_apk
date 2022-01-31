package com.tencent.mobileqq.activity;

import ajjj;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

class PermisionPrivacyActivity$5
  implements Runnable
{
  PermisionPrivacyActivity$5(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void run()
  {
    ArrayList localArrayList = ((ajjj)this.this$0.app.getManager(51)).a();
    if ((localArrayList == null) || (localArrayList.isEmpty())) {}
    for (int i = 0;; i = localArrayList.size())
    {
      PermisionPrivacyActivity.a(this.this$0, i);
      this.this$0.runOnUiThread(new PermisionPrivacyActivity.5.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.5
 * JD-Core Version:    0.7.0.1
 */