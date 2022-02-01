package com.tencent.mobileqq.activity.aio.core;

import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.XEditTextEx;
import mqq.os.MqqHandler;

class TroopChatPie$InputOnGlobalLayoutListener
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private TroopChatPie$InputOnGlobalLayoutListener(TroopChatPie paramTroopChatPie) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.a.Y.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    } else {
      this.a.Y.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    if (!this.a.bN)
    {
      this.a.bN = true;
      ThreadManager.getSubThreadHandler().postDelayed(new TroopChatPie.InputOnGlobalLayoutListener.1(this), 1500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.InputOnGlobalLayoutListener
 * JD-Core Version:    0.7.0.1
 */