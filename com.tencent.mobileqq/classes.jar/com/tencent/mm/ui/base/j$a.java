package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;

class j$a
  extends FrameLayout
{
  j$a(j paramj, Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (getKeyDispatcherState() == null) {
        return super.dispatchKeyEvent(paramKeyEvent);
      }
      KeyEvent.DispatcherState localDispatcherState;
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        localDispatcherState = getKeyDispatcherState();
        if (localDispatcherState != null) {
          localDispatcherState.startTracking(paramKeyEvent, this);
        }
        return true;
      }
      if (paramKeyEvent.getAction() == 1)
      {
        localDispatcherState = getKeyDispatcherState();
        if ((localDispatcherState != null) && (localDispatcherState.isTracking(paramKeyEvent)) && (!paramKeyEvent.isCanceled()))
        {
          this.a.dismiss();
          return true;
        }
      }
      return super.dispatchKeyEvent(paramKeyEvent);
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((j.a(this.a) != null) && (j.a(this.a).onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    return super.onCreateDrawableState(paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    if ((paramMotionEvent.getAction() == 0) && ((i < 0) || (i >= getWidth()) || (j < 0) || (j >= getHeight())))
    {
      this.a.dismiss();
      return true;
    }
    if (paramMotionEvent.getAction() == 4)
    {
      this.a.dismiss();
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void sendAccessibilityEvent(int paramInt)
  {
    if (getChildCount() == 1) {
      getChildAt(0).sendAccessibilityEvent(paramInt);
    } else {
      super.sendAccessibilityEvent(paramInt);
    }
    super.sendAccessibilityEvent(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.j.a
 * JD-Core Version:    0.7.0.1
 */