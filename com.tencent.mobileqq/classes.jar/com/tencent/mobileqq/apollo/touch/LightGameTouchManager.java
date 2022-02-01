package com.tencent.mobileqq.apollo.touch;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.apollo.model.ApolloSkeletonBounding;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderDriver;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderRunner;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

@Deprecated
public class LightGameTouchManager
  implements ICMTouchManager
{
  private LightGameTouchManager.TouchEvent a = new LightGameTouchManager.TouchEvent();
  private View b;
  private IRenderRunner c;
  private ApolloRender d;
  private ApolloRenderDriver e;
  
  public LightGameTouchManager(View paramView, IRenderRunner paramIRenderRunner, ApolloRender paramApolloRender, ApolloRenderDriver paramApolloRenderDriver)
  {
    this.c = paramIRenderRunner;
    this.b = paramView;
    this.d = paramApolloRender;
    this.e = paramApolloRenderDriver;
    a();
  }
  
  private void a()
  {
    if (this.a != null)
    {
      int i = 0;
      while (i < 4)
      {
        this.a.a[i] = 0.0F;
        this.a.b[i] = 0.0F;
        this.a.c[i] = 0;
        this.a.d[i] = 0;
        i += 1;
      }
    }
  }
  
  private void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    try
    {
      if ((this.e != null) && (this.e.b != null)) {
        this.e.b.execScriptString("mainTicker.paused = false;");
      }
      ApolloSurfaceView.nativeTouchInput(this.d.getSavaWrapper().mDirector, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfInt1, paramArrayOfInt2);
      return;
    }
    catch (Throwable paramArrayOfFloat1)
    {
      paramArrayOfFloat2 = new StringBuilder();
      paramArrayOfFloat2.append("send touch event err e=");
      paramArrayOfFloat2.append(paramArrayOfFloat1.toString());
      QLog.e("[cmshow]LightGameTouchManager", 1, paramArrayOfFloat2.toString());
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if (this.a.e >= 4) {
      return;
    }
    int i = paramMotionEvent.getAction();
    int j = 0;
    if ((i & 0xFF) == 5) {
      i = paramMotionEvent.getActionIndex();
    } else {
      i = 0;
    }
    this.a.a[this.a.e] = paramMotionEvent.getX(i);
    this.a.b[this.a.e] = (this.b.getMeasuredHeight() - paramMotionEvent.getY(i));
    this.a.c[this.a.e] = 2;
    this.a.d[this.a.e] = paramMotionEvent.getPointerId(i);
    Object localObject = this.a;
    ((LightGameTouchManager.TouchEvent)localObject).e += 1;
    if (this.a.e <= 0) {
      return;
    }
    localObject = new float[this.a.e];
    float[] arrayOfFloat = new float[this.a.e];
    int[] arrayOfInt1 = new int[this.a.e];
    int[] arrayOfInt2 = new int[this.a.e];
    i = j;
    while (i < this.a.e)
    {
      localObject[i] = this.a.a[i];
      arrayOfFloat[i] = this.a.b[i];
      arrayOfInt1[i] = this.a.c[i];
      arrayOfInt2[i] = this.a.d[i];
      i += 1;
    }
    this.c.runRenderTask(new LightGameTouchManager.1(this, (float[])localObject, arrayOfFloat, arrayOfInt1, arrayOfInt2));
    paramMotionEvent.recycle();
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    try
    {
      i = paramMotionEvent.getAction();
      k = 0;
      if ((i & 0xFF) != 6) {
        break label528;
      }
      i = paramMotionEvent.getActionIndex();
      j = i;
      if ((paramMotionEvent.getAction() & 0xFF) != 1) {
        break label533;
      }
      j = -1;
    }
    catch (Throwable localThrowable)
    {
      int k;
      int j;
      label45:
      Object localObject;
      float[] arrayOfFloat;
      int[] arrayOfInt1;
      int[] arrayOfInt2;
      paramMotionEvent.recycle();
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("send touch event err e=");
      paramMotionEvent.append(localThrowable.toString());
      QLog.e("[cmshow]LightGameTouchManager", 1, paramMotionEvent.toString());
      return;
    }
    if (i < this.a.e)
    {
      if (j == -1)
      {
        this.a.c[i] = 1;
        break label538;
      }
      if (paramMotionEvent.getPointerId(j) != this.a.d[i]) {
        break label538;
      }
      this.a.a[i] = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.a.d[i]));
      this.a.b[i] = (this.b.getMeasuredHeight() - paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.a.d[i])));
      this.a.c[i] = 1;
    }
    if (this.a.e <= 0) {
      return;
    }
    localObject = new float[this.a.e];
    arrayOfFloat = new float[this.a.e];
    arrayOfInt1 = new int[this.a.e];
    arrayOfInt2 = new int[this.a.e];
    int i = 0;
    for (;;)
    {
      if (i < this.a.e)
      {
        localObject[i] = this.a.a[i];
        arrayOfFloat[i] = this.a.b[i];
        arrayOfInt1[i] = this.a.c[i];
        arrayOfInt2[i] = this.a.d[i];
        i += 1;
      }
      else
      {
        this.c.runRenderTask(new LightGameTouchManager.2(this, (float[])localObject, arrayOfFloat, arrayOfInt1, arrayOfInt2));
        i = k;
        if (j == -1)
        {
          this.a.e = 0;
          return;
        }
      }
    }
    for (;;)
    {
      if (i < this.a.e)
      {
        if (this.a.c[i] != 1) {
          break label545;
        }
        while (i < this.a.e - 1)
        {
          localObject = this.a.a;
          arrayOfFloat = this.a.a;
          j = i + 1;
          localObject[i] = arrayOfFloat[j];
          this.a.b[i] = this.a.b[j];
          this.a.c[i] = this.a.c[j];
          this.a.d[i] = this.a.d[j];
          i = j;
        }
        localObject = this.a;
        ((LightGameTouchManager.TouchEvent)localObject).e -= 1;
      }
      paramMotionEvent.recycle();
      return;
      label528:
      i = 0;
      break;
      label533:
      i = 0;
      break label45;
      label538:
      i += 1;
      break label45;
      label545:
      i += 1;
    }
  }
  
  private void d(MotionEvent paramMotionEvent)
  {
    int j = 0;
    int i = 0;
    while ((i < this.a.e) && (i <= paramMotionEvent.getPointerCount() - 1) && (i < 4))
    {
      int k = paramMotionEvent.findPointerIndex(this.a.d[i]);
      if ((k > paramMotionEvent.getPointerCount() - 1) || (k < 0)) {
        break;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("move event index =");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(",event.count=");
        ((StringBuilder)localObject).append(paramMotionEvent.getPointerCount());
        QLog.d("[cmshow]LightGameTouchManager", 2, ((StringBuilder)localObject).toString());
      }
      if ((paramMotionEvent.getX(k) != this.a.a[i]) || (paramMotionEvent.getY(k) != this.a.b[i]))
      {
        this.a.a[i] = paramMotionEvent.getX(k);
        this.a.b[i] = (this.b.getMeasuredHeight() - paramMotionEvent.getY(k));
        this.a.c[i] = 3;
      }
      i += 1;
    }
    if (this.a.e <= 0) {
      return;
    }
    Object localObject = new float[this.a.e];
    float[] arrayOfFloat = new float[this.a.e];
    int[] arrayOfInt1 = new int[this.a.e];
    int[] arrayOfInt2 = new int[this.a.e];
    i = j;
    while (i < this.a.e)
    {
      localObject[i] = this.a.a[i];
      arrayOfFloat[i] = this.a.b[i];
      arrayOfInt1[i] = this.a.c[i];
      arrayOfInt2[i] = this.a.d[i];
      i += 1;
    }
    this.c.runRenderTask(new LightGameTouchManager.3(this, (float[])localObject, arrayOfFloat, arrayOfInt1, arrayOfInt2));
    paramMotionEvent.recycle();
  }
  
  public void a(ApolloSkeletonBounding paramApolloSkeletonBounding, int paramInt) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    try
    {
      int i = paramMotionEvent.getAction() & 0xFF;
      if (i != 0)
      {
        if (i != 1) {
          if (i != 2)
          {
            if (i != 3) {
              if (i != 5)
              {
                if (i != 6) {
                  return true;
                }
              }
              else
              {
                b(MotionEvent.obtain(paramMotionEvent));
                return true;
              }
            }
          }
          else
          {
            if (this.b.getParent() != null) {
              this.b.getParent().requestDisallowInterceptTouchEvent(true);
            }
            d(MotionEvent.obtain(paramMotionEvent));
            return true;
          }
        }
        c(MotionEvent.obtain(paramMotionEvent));
        return true;
      }
      if (this.a.e >= 4)
      {
        QLog.e("[cmshow]LightGameTouchManager", 1, "touch down is over 4");
        return true;
      }
      b(MotionEvent.obtain(paramMotionEvent));
      return true;
    }
    catch (Throwable paramMotionEvent)
    {
      this.a.e = 0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("touch event err e=");
      localStringBuilder.append(paramMotionEvent.toString());
      QLog.e("[cmshow]LightGameTouchManager", 2, localStringBuilder.toString());
    }
    return true;
  }
  
  public List<ApolloSkeletonBounding> b()
  {
    return null;
  }
  
  public void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.touch.LightGameTouchManager
 * JD-Core Version:    0.7.0.1
 */