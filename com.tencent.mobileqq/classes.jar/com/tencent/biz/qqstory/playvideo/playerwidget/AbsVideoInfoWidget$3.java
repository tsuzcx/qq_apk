package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Dialog;
import wxe;

class AbsVideoInfoWidget$3
  implements Runnable
{
  AbsVideoInfoWidget$3(AbsVideoInfoWidget paramAbsVideoInfoWidget) {}
  
  public void run()
  {
    if (this.this$0.a != null) {}
    try
    {
      this.this$0.a.dismiss();
      return;
    }
    catch (Exception localException)
    {
      wxe.b(this.this$0.b, "dismiss dialog error :%s", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget.3
 * JD-Core Version:    0.7.0.1
 */