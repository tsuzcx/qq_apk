package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Dialog;
import com.tencent.biz.qqstory.support.logging.SLog;

class AbsVideoInfoWidget$3
  implements Runnable
{
  AbsVideoInfoWidget$3(AbsVideoInfoWidget paramAbsVideoInfoWidget) {}
  
  public void run()
  {
    if (this.this$0.j != null) {
      try
      {
        this.this$0.j.dismiss();
        return;
      }
      catch (Exception localException)
      {
        SLog.b(this.this$0.i, "dismiss dialog error :%s", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget.3
 * JD-Core Version:    0.7.0.1
 */