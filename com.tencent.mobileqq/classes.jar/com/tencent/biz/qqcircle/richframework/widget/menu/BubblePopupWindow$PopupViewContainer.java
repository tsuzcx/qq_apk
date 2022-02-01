package com.tencent.biz.qqcircle.richframework.widget.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

class BubblePopupWindow$PopupViewContainer
  extends FrameLayout
{
  View a = null;
  
  public BubblePopupWindow$PopupViewContainer(BubblePopupWindow paramBubblePopupWindow, Context paramContext)
  {
    super(paramContext);
  }
  
  private View a(View paramView)
  {
    if (paramView.isPressed()) {
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        View localView = a(paramView.getChildAt(i));
        if (localView != null) {
          return localView;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private void a(View paramView1, View paramView2, Rect paramRect)
  {
    if (paramView1 == paramView2) {
      return;
    }
    paramRect.top += paramView1.getTop();
    paramRect.bottom += paramView1.getTop();
    paramRect.left += paramView1.getLeft();
    paramRect.right += paramView1.getLeft();
    a((View)paramView1.getParent(), paramView2, paramRect);
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
          if (BubblePopupWindow.f(this.b) != null) {
            BubblePopupWindow.f(this.b).a();
          }
          this.b.c();
          return true;
        }
      }
      return super.dispatchKeyEvent(paramKeyEvent);
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((BubblePopupWindow.g(this.b) != null) && (BubblePopupWindow.g(this.b).onTouch(this, paramMotionEvent))) {
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (BubblePopupWindow.b(this.b) == null) {
      return bool;
    }
    View localView = a(BubblePopupWindow.h(this.b));
    int i;
    if ((this.a == null) && (localView == null))
    {
      i = 0;
    }
    else
    {
      this.a = localView;
      localView = this.a;
      if (localView != null)
      {
        localView.scrollTo(0, 0);
        this.a.getDrawingRect(BubblePopupWindow.i(this.b));
        a(this.a, BubblePopupWindow.h(this.b), BubblePopupWindow.i(this.b));
        int j;
        if (BubblePopupWindow.i(this.b).left == 0) {
          j = 1;
        } else {
          j = 0;
        }
        int k;
        if (BubblePopupWindow.i(this.b).right == BubblePopupWindow.h(this.b).getWidth())
        {
          i = BubblePopupWindow.b(this.b).getWidth();
          k = 1;
        }
        else
        {
          k = 0;
          i = 0;
        }
        int m;
        if ((j != 0) && (k != 0))
        {
          m = 0;
        }
        else
        {
          this.a.getDrawingRect(BubblePopupWindow.i(this.b));
          a(this.a, BubblePopupWindow.j(this.b), BubblePopupWindow.i(this.b));
          if (j == 0) {
            j = BubblePopupWindow.i(this.b).left;
          } else {
            j = 0;
          }
          m = j;
          if (k == 0)
          {
            i = BubblePopupWindow.i(this.b).right;
            m = j;
          }
        }
        BubblePopupWindow.k(this.b).a(m, i);
        BubblePopupWindow.m(this.b).a(m - BubblePopupWindow.l(this.b).getLeft(), i - BubblePopupWindow.l(this.b).getLeft());
        BubblePopupWindow.o(this.b).a(m - BubblePopupWindow.n(this.b).getLeft(), i - BubblePopupWindow.n(this.b).getLeft());
        i = 0;
      }
      else
      {
        BubblePopupWindow.k(this.b).a(0, 0);
        BubblePopupWindow.m(this.b).a(0, 0);
        BubblePopupWindow.o(this.b).a(0, 0);
        i = 1;
      }
      BubblePopupWindow.j(this.b).invalidate();
    }
    if ((i == 0) && ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)))
    {
      BubblePopupWindow.k(this.b).a(0, 0);
      BubblePopupWindow.m(this.b).a(0, 0);
      BubblePopupWindow.o(this.b).a(0, 0);
      BubblePopupWindow.j(this.b).invalidate();
    }
    return bool;
  }
  
  @TargetApi(8)
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.b.c();
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    if (BubblePopupWindow.e(this.b))
    {
      int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
      View.mergeDrawableStates(arrayOfInt, BubblePopupWindow.d());
      return arrayOfInt;
    }
    return super.onCreateDrawableState(paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    if ((paramMotionEvent.getAction() == 0) && ((i < 0) || (i >= getWidth()) || (j < 0) || (j >= getHeight())))
    {
      this.b.c();
      return true;
    }
    if (paramMotionEvent.getAction() == 4)
    {
      this.b.c();
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void sendAccessibilityEvent(int paramInt)
  {
    if (BubblePopupWindow.h(this.b) != null)
    {
      BubblePopupWindow.h(this.b).sendAccessibilityEvent(paramInt);
      return;
    }
    super.sendAccessibilityEvent(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.menu.BubblePopupWindow.PopupViewContainer
 * JD-Core Version:    0.7.0.1
 */