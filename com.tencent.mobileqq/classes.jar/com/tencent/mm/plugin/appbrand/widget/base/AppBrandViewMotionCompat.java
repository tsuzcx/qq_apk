package com.tencent.mm.plugin.appbrand.widget.base;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.tencent.luggage.wxa.qz.o;

public final class AppBrandViewMotionCompat
{
  private static MotionEvent.PointerCoords[] a;
  private static MotionEvent.PointerProperties[] b;
  private static int[] c;
  
  @TargetApi(5)
  public static int a(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getPointerCount();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j |= 1 << paramMotionEvent.getPointerId(i);
      i += 1;
    }
    return j;
  }
  
  @TargetApi(14)
  @UiThread
  public static MotionEvent a(MotionEvent paramMotionEvent, int paramInt)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      int i3 = paramMotionEvent.getPointerCount();
      a(i3);
      MotionEvent.PointerProperties[] arrayOfPointerProperties = b;
      MotionEvent.PointerCoords[] arrayOfPointerCoords = a;
      int[] arrayOfInt = c;
      int i1 = paramMotionEvent.getAction();
      int i2 = i1 & 0xFF;
      int k = 0;
      int j = -1;
      int m;
      int n;
      for (int i = 0;; i = m)
      {
        m = 1;
        if (k >= i3) {
          break;
        }
        paramMotionEvent.getPointerProperties(k, arrayOfPointerProperties[i]);
        n = j;
        m = i;
        if ((1 << arrayOfPointerProperties[i].id & paramInt) != 0)
        {
          if (k == (0xFF00 & i1) >> 8) {
            j = i;
          }
          arrayOfInt[i] = k;
          m = i + 1;
          n = j;
        }
        k += 1;
        j = n;
      }
      if (i != 0)
      {
        if ((i2 != 5) && (i2 != 6))
        {
          paramInt = i1;
        }
        else if (j < 0)
        {
          paramInt = 2;
        }
        else if (i == 1)
        {
          paramInt = m;
          if (i2 == 5) {
            paramInt = 0;
          }
        }
        else
        {
          paramInt = j << 8 | i2;
        }
        MotionEvent localMotionEvent1 = null;
        k = paramMotionEvent.getHistorySize();
        m = 0;
        j = i;
        i = m;
        for (;;)
        {
          MotionEvent localMotionEvent2 = paramMotionEvent;
          if (i > k) {
            break;
          }
          if (i == k) {
            m = -2147483648;
          } else {
            m = i;
          }
          n = 0;
          while (n < j)
          {
            localMotionEvent2.getHistoricalPointerCoords(arrayOfInt[n], m, arrayOfPointerCoords[n]);
            n += 1;
          }
          long l = localMotionEvent2.getHistoricalEventTime(m);
          if (i == 0)
          {
            localMotionEvent1 = MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), paramInt, j, arrayOfPointerProperties, arrayOfPointerCoords, paramMotionEvent.getMetaState(), paramMotionEvent.getButtonState(), paramMotionEvent.getXPrecision(), paramMotionEvent.getYPrecision(), paramMotionEvent.getDeviceId(), paramMotionEvent.getEdgeFlags(), paramMotionEvent.getSource(), paramMotionEvent.getFlags());
            localMotionEvent1.offsetLocation(localMotionEvent1.getX() - localMotionEvent1.getRawX(), localMotionEvent1.getY() - localMotionEvent1.getRawY());
          }
          else
          {
            localMotionEvent1.addBatch(l, arrayOfPointerCoords, 0);
          }
          i += 1;
        }
        return localMotionEvent1;
      }
      throw new IllegalArgumentException("idBits did not match any ids in the event");
    }
    paramMotionEvent = new RuntimeException("Should be called on main-thread");
    for (;;)
    {
      throw paramMotionEvent;
    }
  }
  
  private static void a(int paramInt)
  {
    MotionEvent.PointerCoords[] arrayOfPointerCoords = a;
    if ((arrayOfPointerCoords == null) || (arrayOfPointerCoords.length < paramInt))
    {
      arrayOfPointerCoords = a;
      int i;
      if (arrayOfPointerCoords != null) {
        i = arrayOfPointerCoords.length;
      } else {
        i = 8;
      }
      while (i < paramInt) {
        i *= 2;
      }
      a = b(i);
      b = c(i);
      c = new int[i];
    }
  }
  
  public static boolean a(View paramView)
  {
    return (paramView != null) && ((paramView instanceof c)) && (((c)paramView).a());
  }
  
  @TargetApi(11)
  public static boolean a(ViewGroup paramViewGroup, float paramFloat1, float paramFloat2, View paramView, PointF paramPointF)
  {
    float[] arrayOfFloat = new float[2];
    float[] tmp7_5 = arrayOfFloat;
    tmp7_5[0] = 0.0F;
    float[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 0.0F;
    tmp11_7;
    arrayOfFloat[0] = (paramFloat1 + (paramViewGroup.getScrollX() - paramView.getLeft()));
    arrayOfFloat[1] = (paramFloat2 + (paramViewGroup.getScrollY() - paramView.getTop()));
    paramViewGroup = paramView.getMatrix();
    if (!paramViewGroup.isIdentity())
    {
      paramViewGroup.invert(paramViewGroup);
      paramViewGroup.mapPoints(arrayOfFloat);
    }
    boolean bool;
    if ((arrayOfFloat[0] >= 0.0F) && (arrayOfFloat[1] >= 0.0F) && (arrayOfFloat[0] < paramView.getRight() - paramView.getLeft()) && (arrayOfFloat[1] < paramView.getBottom() - paramView.getTop())) {
      bool = true;
    } else {
      bool = false;
    }
    if ((bool) && (paramPointF != null)) {
      paramPointF.set(arrayOfFloat[0], arrayOfFloat[1]);
    }
    return bool;
  }
  
  public static boolean b(@NonNull View paramView)
  {
    return (paramView.getVisibility() == 0) || (paramView.getAnimation() != null);
  }
  
  private static MotionEvent.PointerCoords[] b(int paramInt)
  {
    MotionEvent.PointerCoords[] arrayOfPointerCoords = new MotionEvent.PointerCoords[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfPointerCoords[i] = new MotionEvent.PointerCoords();
      i += 1;
    }
    return arrayOfPointerCoords;
  }
  
  @TargetApi(11)
  public static boolean c(View paramView)
  {
    return paramView.getMatrix().isIdentity();
  }
  
  private static MotionEvent.PointerProperties[] c(int paramInt)
  {
    MotionEvent.PointerProperties[] arrayOfPointerProperties = new MotionEvent.PointerProperties[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfPointerProperties[i] = new MotionEvent.PointerProperties();
      i += 1;
    }
    return arrayOfPointerProperties;
  }
  
  public static Matrix d(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    Matrix localMatrix2 = (Matrix)paramView.getTag(2131428660);
    Matrix localMatrix1 = localMatrix2;
    if (localMatrix2 == null)
    {
      localMatrix1 = new Matrix();
      paramView.setTag(2131428660, localMatrix1);
    }
    paramView.getMatrix().invert(localMatrix1);
    return localMatrix1;
  }
  
  @TargetApi(11)
  @Keep
  static boolean dispatchTransformedTouchEvent(ViewGroup paramViewGroup, MotionEvent paramMotionEvent, boolean paramBoolean, View paramView, int paramInt)
  {
    if (paramViewGroup != null)
    {
      if (paramMotionEvent == null) {
        return false;
      }
      int i = paramMotionEvent.getAction();
      if ((!paramBoolean) && (i != 3))
      {
        i = a(paramMotionEvent);
        paramInt &= i;
        if (paramInt == 0) {
          return false;
        }
        if (paramInt == i)
        {
          if ((paramView != null) && (!c(paramView)))
          {
            paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
            break label141;
          }
          if (paramView == null) {
            return false;
          }
          float f1 = paramViewGroup.getScrollX() - paramView.getLeft();
          float f2 = paramViewGroup.getScrollY() - paramView.getTop();
          paramMotionEvent.offsetLocation(f1, f2);
          paramBoolean = paramView.dispatchTouchEvent(paramMotionEvent);
          paramMotionEvent.offsetLocation(-f1, -f2);
          return paramBoolean;
        }
        try
        {
          paramMotionEvent = a(paramMotionEvent, paramInt);
          label141:
          if (paramView == null) {
            return false;
          }
          paramMotionEvent.offsetLocation(paramViewGroup.getScrollX() - paramView.getLeft(), paramViewGroup.getScrollY() - paramView.getTop());
          if (!c(paramView))
          {
            paramViewGroup = paramView.getMatrix();
            paramViewGroup.invert(paramViewGroup);
            paramMotionEvent.transform(paramViewGroup);
          }
          paramBoolean = paramView.dispatchTouchEvent(paramMotionEvent);
          paramMotionEvent.recycle();
          return paramBoolean;
        }
        catch (IllegalArgumentException paramViewGroup)
        {
          o.c("MicroMsg.AppBrandViewMotionCompat", "dispatchTransformedTouchEvent e=%s", new Object[] { paramViewGroup.getMessage() });
          return false;
        }
      }
      paramMotionEvent.setAction(3);
      if (paramView == null) {
        return false;
      }
      paramBoolean = paramView.dispatchTouchEvent(paramMotionEvent);
      paramMotionEvent.setAction(i);
      return paramBoolean;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat
 * JD-Core Version:    0.7.0.1
 */