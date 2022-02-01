package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

class UnlimitedBladeWorks$7
  implements Runnable
{
  UnlimitedBladeWorks$7(UnlimitedBladeWorks paramUnlimitedBladeWorks, Activity paramActivity) {}
  
  public void run()
  {
    if (((Build.VERSION.SDK_INT > 16) && (this.a.isDestroyed())) || (this.a.isFinishing())) {
      return;
    }
    View localView = ((ViewGroup)this.a.getWindow().getDecorView()).getChildAt(0).findViewById(2131427887);
    if (localView != null) {
      localView.clearAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks.7
 * JD-Core Version:    0.7.0.1
 */