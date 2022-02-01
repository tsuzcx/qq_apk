package com.tencent.liteav.renderer;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.view.TextureView;
import com.tencent.liteav.basic.log.TXCLog;

public class d
{
  private TextureView a;
  private Handler b;
  private int c = 0;
  private int d = 0;
  private int e = 640;
  private int f = 480;
  private int g = 0;
  private int h = 0;
  private int i = 1;
  private int j = 0;
  private float k = 1.0F;
  private int l = 0;
  
  public d(TextureView paramTextureView)
  {
    this.a = paramTextureView;
    this.c = paramTextureView.getWidth();
    this.d = paramTextureView.getHeight();
    this.b = new Handler(paramTextureView.getContext().getMainLooper());
  }
  
  private void a()
  {
    try
    {
      a(new d.3(this));
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCTextureViewWrapper", "adjust video size failed.", localException);
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      return;
    }
    this.b.post(paramRunnable);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if ((this.a != null) && (paramInt1 != 0))
    {
      if (paramInt2 == 0) {
        return;
      }
      int m = this.c;
      if (m != 0)
      {
        int n = this.d;
        if (n == 0) {
          return;
        }
        double d1 = paramInt2;
        double d2 = paramInt1;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        d2 = m;
        Double.isNaN(d2);
        if (n > (int)(d2 * d1))
        {
          this.g = m;
          d2 = m;
          Double.isNaN(d2);
          this.h = ((int)(d2 * d1));
        }
        else
        {
          d2 = n;
          Double.isNaN(d2);
          this.g = ((int)(d2 / d1));
          this.h = n;
        }
        paramInt1 = this.c;
        paramInt2 = this.g;
        float f1 = (paramInt1 - paramInt2) / 2.0F;
        m = this.d;
        n = this.h;
        float f2 = (m - n) / 2.0F;
        float f3 = paramInt2 / paramInt1;
        float f4 = n / m;
        Matrix localMatrix = new Matrix();
        this.a.getTransform(localMatrix);
        localMatrix.setScale(f3, f4);
        localMatrix.postTranslate(f1, f2);
        this.a.setTransform(localMatrix);
        this.a.requestLayout();
      }
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.b.post(new d.1(this, paramInt));
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCTextureViewWrapper", "set render mode failed", localException);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("vrender: set view size:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt2);
    TXCLog.w("TXCTextureViewWrapper", localStringBuilder.toString());
    this.c = paramInt1;
    this.d = paramInt2;
    a();
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.b.post(new d.4(this, paramBoolean));
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCTextureViewWrapper", "set mirror failed.", localException);
    }
  }
  
  public void b(int paramInt)
  {
    this.i = paramInt;
    if (this.a != null)
    {
      float f2 = 1.0F;
      float f1;
      if (paramInt == 1)
      {
        paramInt = this.j;
        f1 = f2;
        if (paramInt == 0) {
          break label248;
        }
        if (paramInt == 180)
        {
          f1 = f2;
        }
        else if (paramInt != 270)
        {
          f1 = f2;
          if (paramInt != 90) {}
        }
        else
        {
          paramInt = this.g;
          if (paramInt != 0)
          {
            int m = this.h;
            if (m == 0) {
              return;
            }
            f1 = this.d / paramInt;
            f2 = this.c / m;
            if (f1 > f2) {
              f1 = f2;
            }
          }
        }
      }
      for (;;)
      {
        break;
        break;
        return;
        f1 = f2;
        if (paramInt == 0) {
          if (this.g != 0)
          {
            if (this.h == 0) {
              return;
            }
            paramInt = this.j;
            float f3;
            if ((paramInt != 0) && (paramInt != 180))
            {
              if (paramInt != 270)
              {
                f1 = f2;
                if (paramInt != 90) {
                  break;
                }
              }
              else
              {
                f2 = this.d / this.g;
                f3 = this.c / this.h;
                f1 = f2;
                if (f2 >= f3) {
                  break;
                }
              }
            }
            else {
              for (f1 = f3;; f1 = f3)
              {
                break;
                f2 = this.d / this.h;
                f3 = this.c / this.g;
                f1 = f2;
                if (f2 >= f3) {
                  break;
                }
              }
            }
          }
          else
          {
            return;
          }
        }
      }
      label248:
      f2 = f1;
      if (this.k < 0.0F) {
        f2 = -f1;
      }
      this.a.setScaleX(f2);
      this.a.setScaleY(Math.abs(f2));
      this.k = f2;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("vrender: set video size:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt2);
    TXCLog.w("TXCTextureViewWrapper", localStringBuilder.toString());
    this.e = paramInt1;
    this.f = paramInt2;
    a();
  }
  
  public void c(int paramInt)
  {
    try
    {
      this.b.post(new d.2(this, paramInt));
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCTextureViewWrapper", "set render rotation failed.", localException);
    }
  }
  
  public void d(int paramInt)
  {
    paramInt %= 360;
    this.j = paramInt;
    if (this.a != null)
    {
      float f2 = 1.0F;
      float f1;
      float f3;
      if ((paramInt != 0) && (paramInt != 180))
      {
        if (paramInt != 270)
        {
          f1 = f2;
          if (paramInt != 90) {}
        }
        else if (this.g != 0)
        {
          if (this.h == 0) {
            return;
          }
          this.a.setRotation(360 - paramInt);
          f3 = this.d / this.g;
          float f4 = this.c / this.h;
          paramInt = this.i;
          if (paramInt == 1) {
            if (f3 <= f4) {}
          }
          for (;;)
          {
            f1 = f4;
            break;
            do
            {
              f1 = f3;
              break;
              f1 = f2;
              if (paramInt != 0) {
                break;
              }
            } while (f3 >= f4);
          }
        }
      }
      else
      {
        this.a.setRotation(360 - paramInt);
        paramInt = this.i;
        if (paramInt == 1)
        {
          f1 = f2;
        }
        else
        {
          f1 = f2;
          if (paramInt == 0)
          {
            paramInt = this.g;
            if (paramInt != 0)
            {
              int m = this.h;
              if (m == 0) {
                return;
              }
              f2 = this.d / m;
              f3 = this.c / paramInt;
              f1 = f2;
              if (f2 < f3) {
                f1 = f3;
              }
            }
            else
            {
              return;
            }
          }
        }
      }
      f2 = f1;
      if (this.k < 0.0F) {
        f2 = -f1;
      }
      this.a.setScaleX(f2);
      this.a.setScaleY(Math.abs(f2));
      this.k = f2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.d
 * JD-Core Version:    0.7.0.1
 */