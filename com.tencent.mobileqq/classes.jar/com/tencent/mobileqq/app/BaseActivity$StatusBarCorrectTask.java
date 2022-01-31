package com.tencent.mobileqq.app;

import com.tencent.widget.immersive.ImmersiveUtils;

public class BaseActivity$StatusBarCorrectTask
  implements Runnable
{
  public BaseActivity$StatusBarCorrectTask(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    if (ImmersiveUtils.a(this.this$0.getWindow())) {
      this.this$0.recreate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity.StatusBarCorrectTask
 * JD-Core Version:    0.7.0.1
 */