package com.tencent.mobileqq.activity;

import aloz;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

class PermisionPrivacyActivity$6
  implements Runnable
{
  PermisionPrivacyActivity$6(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void run()
  {
    ArrayList localArrayList = ((aloz)this.this$0.app.getManager(51)).a();
    if ((localArrayList == null) || (localArrayList.isEmpty())) {}
    for (int i = 0;; i = localArrayList.size())
    {
      PermisionPrivacyActivity.a(this.this$0, i);
      this.this$0.runOnUiThread(new PermisionPrivacyActivity.6.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.6
 * JD-Core Version:    0.7.0.1
 */