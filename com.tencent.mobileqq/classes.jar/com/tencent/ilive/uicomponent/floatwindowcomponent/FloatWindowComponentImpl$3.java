package com.tencent.ilive.uicomponent.floatwindowcomponent;

import android.app.Activity;
import android.util.Log;
import android.view.WindowManager.LayoutParams;
import com.tencent.falco.base.floatwindow.widget.LiveFloatWindowManager;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
import com.tencent.falco.utils.UIUtil;

class FloatWindowComponentImpl$3
  implements Runnable
{
  FloatWindowComponentImpl$3(FloatWindowComponentImpl paramFloatWindowComponentImpl) {}
  
  public void run()
  {
    Object localObject = LiveFloatWindowManager.getInstance().getParams("FloatWindowComponentImpl");
    if ((localObject != null) && (FloatWindowComponentImpl.access$400(this.this$0) != null))
    {
      int i = ((WindowManager.LayoutParams)localObject).x;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("viewApp.getX()=");
      localStringBuilder.append(i);
      Log.d("FloatWindowComponent", localStringBuilder.toString());
      if (i > UIUtil.getScreenWidth(FloatWindowComponentImpl.access$400(this.this$0).getApplicationContext()))
      {
        i = LiveFloatWindowManager.getInstance().getWidth("FloatWindowComponentImpl");
        ((WindowManager.LayoutParams)localObject).x = (UIUtil.getScreenWidth(FloatWindowComponentImpl.access$400(this.this$0).getApplicationContext()) - i);
        LiveFloatWindowManager.getInstance().updateParams("FloatWindowComponentImpl", (WindowManager.LayoutParams)localObject);
      }
    }
    localObject = this.this$0;
    ThreadCenter.postDelayedUITask((ThreadCenter.HandlerKeyable)localObject, ((FloatWindowComponentImpl)localObject).loacationRunnable, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.floatwindowcomponent.FloatWindowComponentImpl.3
 * JD-Core Version:    0.7.0.1
 */