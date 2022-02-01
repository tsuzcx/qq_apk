package com.tencent.mobileqq.app;

import com.tencent.widget.immersive.ImmersiveUtils;

public class QBaseActivity$StatusBarCorrectTask
  implements Runnable
{
  public QBaseActivity$StatusBarCorrectTask(QBaseActivity paramQBaseActivity) {}
  
  public void run()
  {
    if (ImmersiveUtils.correctStatusBarHeight(this.this$0.getWindow())) {
      this.this$0.recreate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QBaseActivity.StatusBarCorrectTask
 * JD-Core Version:    0.7.0.1
 */