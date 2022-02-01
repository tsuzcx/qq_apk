package com.tencent.ad.tangram.views.canvas.components.picture;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.ad.tangram.util.AdUIUtils;

class b$b
  implements View.OnTouchListener
{
  private int ALLOW_CLICK_MOVE = 3;
  private int action_down_x = 0;
  private int action_down_y = 0;
  private Runnable clickRunnable;
  
  public b$b(Runnable paramRunnable, Resources paramResources)
  {
    this.clickRunnable = paramRunnable;
    this.ALLOW_CLICK_MOVE = AdUIUtils.dp2px(3.0F, paramResources);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int i = (int)paramMotionEvent.getY();
    int k = paramMotionEvent.getAction();
    if (k != 0)
    {
      if (k == 1)
      {
        j = Math.abs(j - this.action_down_x);
        i = Math.abs(i - this.action_down_y);
        k = this.ALLOW_CLICK_MOVE;
        if ((j < k) && (i < k))
        {
          paramView = this.clickRunnable;
          if (paramView != null) {
            paramView.run();
          }
        }
      }
      return false;
    }
    this.action_down_x = j;
    this.action_down_y = i;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.picture.b.b
 * JD-Core Version:    0.7.0.1
 */