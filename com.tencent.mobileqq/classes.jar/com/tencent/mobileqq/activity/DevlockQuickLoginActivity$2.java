package com.tencent.mobileqq.activity;

import android.graphics.drawable.Drawable;
import aoot;
import com.tencent.mobileqq.app.QQAppInterface;

class DevlockQuickLoginActivity$2
  implements Runnable
{
  DevlockQuickLoginActivity$2(DevlockQuickLoginActivity paramDevlockQuickLoginActivity) {}
  
  public void run()
  {
    if (this.this$0.app == null) {
      return;
    }
    Object localObject = this.this$0.app.getCurrentAccountUin();
    localObject = aoot.a(this.this$0.app, 3, (String)localObject);
    this.this$0.runOnUiThread(new DevlockQuickLoginActivity.2.1(this, (Drawable)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockQuickLoginActivity.2
 * JD-Core Version:    0.7.0.1
 */