package com.tencent.ilive.uicomponent.floatwindowcomponent;

import android.app.Activity;
import android.util.Log;
import android.view.WindowManager.LayoutParams;
import com.tencent.falco.base.floatwindow.widget.LiveFloatWindowManager;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.UIUtil;

class FloatWindowComponentImpl$3
  implements Runnable
{
  FloatWindowComponentImpl$3(FloatWindowComponentImpl paramFloatWindowComponentImpl) {}
  
  public void run()
  {
    WindowManager.LayoutParams localLayoutParams = LiveFloatWindowManager.getInstance().getParams("FloatWindowComponentImpl");
    if ((localLayoutParams != null) && (FloatWindowComponentImpl.access$400(this.this$0) != null))
    {
      int i = localLayoutParams.x;
      Log.d("FloatWindowComponent", "viewApp.getX()=" + i);
      if (i > UIUtil.getScreenWidth(FloatWindowComponentImpl.access$400(this.this$0).getApplicationContext()))
      {
        i = LiveFloatWindowManager.getInstance().getWidth("FloatWindowComponentImpl");
        localLayoutParams.x = (UIUtil.getScreenWidth(FloatWindowComponentImpl.access$400(this.this$0).getApplicationContext()) - i);
        LiveFloatWindowManager.getInstance().updateParams("FloatWindowComponentImpl", localLayoutParams);
      }
    }
    ThreadCenter.postDelayedUITask(this.this$0, this.this$0.loacationRunnable, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.floatwindowcomponent.FloatWindowComponentImpl.3
 * JD-Core Version:    0.7.0.1
 */