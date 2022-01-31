package com.tencent.mobileqq.activity;

import aupd;

class PermisionPrivacyActivity$7
  implements Runnable
{
  PermisionPrivacyActivity$7(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void run()
  {
    if (this.this$0.isFinishing()) {}
    int i;
    do
    {
      return;
      i = aupd.a(this.this$0.app);
    } while (this.this$0.isFinishing());
    this.this$0.runOnUiThread(new PermisionPrivacyActivity.7.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.7
 * JD-Core Version:    0.7.0.1
 */