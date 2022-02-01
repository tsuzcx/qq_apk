package com.tencent.aelight.camera.aioeditor.share.impl;

import android.app.Activity;
import com.tencent.mobileqq.widget.QQProgressDialog;

class AIOShareHelperImpl$6
  implements Runnable
{
  AIOShareHelperImpl$6(AIOShareHelperImpl paramAIOShareHelperImpl, Activity paramActivity) {}
  
  public void run()
  {
    Activity localActivity = this.a;
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      if ((AIOShareHelperImpl.access$000(this.this$0) != null) && (AIOShareHelperImpl.access$000(this.this$0).isShowing())) {
        return;
      }
      AIOShareHelperImpl.access$002(this.this$0, new QQProgressDialog(this.a));
      AIOShareHelperImpl.access$000(this.this$0).c(2131693895);
      AIOShareHelperImpl.access$000(this.this$0).show();
      return;
    }
    AIOShareHelperImpl.access$002(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.share.impl.AIOShareHelperImpl.6
 * JD-Core Version:    0.7.0.1
 */