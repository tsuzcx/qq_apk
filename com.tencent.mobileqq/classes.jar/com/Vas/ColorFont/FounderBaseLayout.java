package com.Vas.ColorFont;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.view.animation.LinearInterpolator;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.TextGraphMap;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public abstract class FounderBaseLayout
{
  public Bitmap o;
  public int[] p = { -1, -1 };
  public ETFont q;
  public ValueAnimator r;
  public int s;
  protected Canvas t = new Canvas();
  
  public abstract int a(int paramInt1, int paramInt2, TextGraphMap paramTextGraphMap);
  
  protected void a()
  {
    this.r = ValueAnimator.ofInt(new int[] { 0, this.p[0] });
    ValueAnimator localValueAnimator = this.r;
    int[] arrayOfInt = this.p;
    localValueAnimator.setDuration(arrayOfInt[0] * arrayOfInt[1]);
    this.r.setRepeatCount(0);
    this.r.setInterpolator(new LinearInterpolator());
  }
  
  public void a(boolean paramBoolean)
  {
    this.s = 0;
    this.q.mShouldDisplayAnimation = false;
    if (this.r != null)
    {
      FastColorFontLog.a("FounderBaseLayout", "StopAnimation......");
      this.r.cancel();
    }
  }
  
  public abstract boolean a(Canvas paramCanvas);
  
  public abstract int[] a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, ETFont paramETFont);
  
  public abstract void b();
  
  protected void c()
  {
    if (this.t == null) {
      this.t = new Canvas();
    }
    this.t.setBitmap(this.o);
    this.t.drawColor(0, PorterDuff.Mode.CLEAR);
  }
  
  protected boolean d(int paramInt1, int paramInt2)
  {
    try
    {
      if (this.o == null) {
        this.o = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      } else if ((paramInt1 > this.o.getWidth()) || (paramInt2 > this.o.getHeight()) || ((paramInt1 << 1 < this.o.getWidth()) && (paramInt2 << 1 < this.o.getHeight()))) {
        this.o = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      }
      return true;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FounderColorLayout#createNewWordBitmapIfNeed w=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" h=");
      localStringBuilder.append(paramInt2);
      QLog.e("FounderBaseLayout", 2, localStringBuilder.toString(), localOutOfMemoryError);
    }
    return false;
  }
  
  public void e()
  {
    FastColorFontLog.a("FounderBaseLayout", "release....");
    Object localObject = this.o;
    if (localObject != null)
    {
      ((Bitmap)localObject).recycle();
      this.o = null;
    }
    localObject = this.r;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.r = null;
    }
    this.t = null;
  }
  
  protected String f()
  {
    if (FastColorFontHelper.a) {
      return getClass().getSimpleName();
    }
    return "BaseLayout";
  }
  
  public void g()
  {
    Object localObject = this.r;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning()) && (this.s > 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PauseAnimation...... animInfo:");
      ((StringBuilder)localObject).append(Arrays.toString(this.p));
      ((StringBuilder)localObject).append("  frameIndex:");
      ((StringBuilder)localObject).append(this.s);
      FastColorFontLog.a("FounderBaseLayout", ((StringBuilder)localObject).toString());
      this.r.cancel();
      this.q.mShouldDisplayAnimation = false;
    }
  }
  
  public void h()
  {
    if (this.q != null)
    {
      Object localObject = this.p;
      if (localObject[0] > 0)
      {
        if (localObject[1] <= 0) {
          return;
        }
        localObject = this.r;
        if ((localObject != null) && (!((ValueAnimator)localObject).isRunning()))
        {
          int i = this.s;
          if ((i > 0) && (i < this.p[0]))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("RestartAnimation...... animInfo:");
            ((StringBuilder)localObject).append(Arrays.toString(this.p));
            ((StringBuilder)localObject).append("  frameIndex:");
            ((StringBuilder)localObject).append(this.s);
            FastColorFontLog.a("FounderBaseLayout", ((StringBuilder)localObject).toString());
            this.q.mShouldDisplayAnimation = true;
            this.r.setIntValues(new int[] { this.s, this.p[0] });
            localObject = this.r;
            int[] arrayOfInt = this.p;
            ((ValueAnimator)localObject).setDuration((arrayOfInt[0] - this.s) * arrayOfInt[1]);
            this.r.start();
          }
        }
      }
    }
  }
  
  public void i()
  {
    this.q.mShouldDisplayAnimation = true;
    ValueAnimator localValueAnimator = this.r;
    if (localValueAnimator == null)
    {
      a();
      this.r.start();
      return;
    }
    if (!localValueAnimator.isRunning())
    {
      this.r.setIntValues(new int[] { this.p[0] });
      localValueAnimator = this.r;
      int[] arrayOfInt = this.p;
      localValueAnimator.setDuration(arrayOfInt[0] * arrayOfInt[1]);
      this.r.start();
    }
  }
  
  public void j()
  {
    a(true);
    this.r = null;
    this.s = 0;
    int[] arrayOfInt = this.p;
    arrayOfInt[0] = -1;
    arrayOfInt[1] = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.FounderBaseLayout
 * JD-Core Version:    0.7.0.1
 */