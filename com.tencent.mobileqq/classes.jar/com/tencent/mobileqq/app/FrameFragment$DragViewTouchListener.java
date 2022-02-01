package com.tencent.mobileqq.app;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.qroute.QRoute;

public class FrameFragment$DragViewTouchListener
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if ((i != 1) && (i != 3)) {
        return false;
      }
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).onTouchDragChange(true);
      return false;
    }
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).onTouchDragChange(false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener
 * JD-Core Version:    0.7.0.1
 */