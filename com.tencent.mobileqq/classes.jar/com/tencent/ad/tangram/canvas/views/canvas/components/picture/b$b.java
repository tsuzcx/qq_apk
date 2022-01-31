package com.tencent.ad.tangram.canvas.views.canvas.components.picture;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.ad.tangram.canvas.views.a;

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
    this.ALLOW_CLICK_MOVE = a.dp2px(3.0F, paramResources);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int i = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      this.action_down_x = j;
      this.action_down_y = i;
      return true;
      j = Math.abs(j - this.action_down_x);
      i = Math.abs(i - this.action_down_y);
      if ((j < this.ALLOW_CLICK_MOVE) && (i < this.ALLOW_CLICK_MOVE) && (this.clickRunnable != null)) {
        this.clickRunnable.run();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.picture.b.b
 * JD-Core Version:    0.7.0.1
 */