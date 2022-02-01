package com.tencent.luggage.wxa.mn;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.kd.f;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;

public class e
{
  public static e.f a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return new e.f(0, arrayOfInt[0], arrayOfInt[1]);
  }
  
  public static void a(ViewGroup paramViewGroup, MotionEvent paramMotionEvent)
  {
    int j = paramViewGroup.getChildCount();
    int i = paramMotionEvent.getActionIndex();
    if (paramViewGroup.isMotionEventSplittingEnabled()) {
      i = 1 << paramMotionEvent.getPointerId(i);
    } else {
      i = -1;
    }
    j -= 1;
    while (j >= 0)
    {
      View localView = paramViewGroup.getChildAt(j);
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((AppBrandViewMotionCompat.b(localView)) && (AppBrandViewMotionCompat.a(paramViewGroup, f1, f2, localView, null)) && (localView.isDuplicateParentStateEnabled()))
      {
        a(paramViewGroup, paramMotionEvent, false, localView, i);
        if (((localView instanceof f)) && (((f)localView).a())) {
          return;
        }
      }
      j -= 1;
    }
  }
  
  public static void a(c paramc, View paramView, a.b paramb)
  {
    if ((paramc != null) && (paramView != null) && (paramb != null))
    {
      paramView.setOnTouchListener(new d.a(paramc, paramb));
      return;
    }
    o.d("MicroMsg.ViewMotionHelper", "setOnTouchListener failed, page or view or keyValueSet is null.");
  }
  
  public static boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    return (paramFloat1 >= 0.0F) && (paramFloat2 >= 0.0F) && (paramFloat1 <= paramView.getWidth()) && (paramFloat2 <= paramView.getHeight());
  }
  
  public static boolean a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = -paramFloat3;
    return (paramFloat1 >= f) && (paramFloat2 >= f) && (paramFloat1 < paramView.getWidth() + paramFloat3) && (paramFloat2 < paramView.getHeight() + paramFloat3);
  }
  
  public static boolean a(ViewGroup paramViewGroup, MotionEvent paramMotionEvent, boolean paramBoolean, View paramView, int paramInt)
  {
    if (paramView == null)
    {
      o.f("MicroMsg.ViewMotionHelper", "child is null.");
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((!paramBoolean) && (i != 3))
    {
      i = AppBrandViewMotionCompat.a(paramMotionEvent);
      paramInt &= i;
      if (paramInt == 0)
      {
        o.f("MicroMsg.ViewMotionHelper", "newPointerIdBits is 0.");
        return false;
      }
      paramBoolean = AppBrandViewMotionCompat.c(paramView);
      if (paramInt == i)
      {
        if (paramBoolean)
        {
          float f1 = paramViewGroup.getScrollX() - paramView.getLeft();
          float f2 = paramViewGroup.getScrollY() - paramView.getTop();
          paramMotionEvent.offsetLocation(f1, f2);
          paramBoolean = paramView.dispatchTouchEvent(paramMotionEvent);
          paramMotionEvent.offsetLocation(-f1, -f2);
          return paramBoolean;
        }
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
      }
      else
      {
        MotionEvent localMotionEvent = AppBrandViewMotionCompat.a(paramMotionEvent, paramInt);
        if (localMotionEvent == null) {
          paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        } else {
          paramMotionEvent = localMotionEvent;
        }
      }
      paramMotionEvent.offsetLocation(paramViewGroup.getScrollX() - paramView.getLeft(), paramViewGroup.getScrollY() - paramView.getTop());
      if (!paramBoolean) {
        paramMotionEvent.transform(AppBrandViewMotionCompat.d(paramView));
      }
      paramBoolean = paramView.dispatchTouchEvent(paramMotionEvent);
      paramMotionEvent.recycle();
      return paramBoolean;
    }
    paramMotionEvent.setAction(3);
    paramBoolean = paramView.dispatchTouchEvent(paramMotionEvent);
    paramMotionEvent.setAction(i);
    return paramBoolean;
  }
  
  public static boolean b(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    for (paramView = paramView.getParent(); (paramView != null) && ((paramView instanceof ViewGroup)); paramView = paramView.getParent()) {
      if (((ViewGroup)paramView).shouldDelayChildPressedState()) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mn.e
 * JD-Core Version:    0.7.0.1
 */