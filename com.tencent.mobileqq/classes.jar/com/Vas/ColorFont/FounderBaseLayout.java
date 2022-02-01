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
  public ValueAnimator a;
  public Bitmap a;
  protected Canvas a;
  public ETFont a;
  public int e;
  public int[] i = { -1, -1 };
  
  public FounderBaseLayout()
  {
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
  }
  
  public abstract int a(int paramInt1, int paramInt2, TextGraphMap paramTextGraphMap);
  
  protected String a()
  {
    if (FastColorFontHelper.a) {
      return getClass().getSimpleName();
    }
    return "BaseLayout";
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.i[0] });
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    int[] arrayOfInt = this.i;
    localValueAnimator.setDuration(arrayOfInt[0] * arrayOfInt[1]);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(0);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = 0;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation = false;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      FastColorFontLog.a("FounderBaseLayout", "StopAnimation......");
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  protected boolean a(int paramInt1, int paramInt2)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      } else if ((paramInt1 > this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) || (paramInt2 > this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) || ((paramInt1 << 1 < this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) && (paramInt2 << 1 < this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()))) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
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
  
  public abstract boolean a(Canvas paramCanvas);
  
  public abstract int[] a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, ETFont paramETFont);
  
  public abstract void b();
  
  protected void c()
  {
    if (this.jdField_a_of_type_AndroidGraphicsCanvas == null) {
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
  }
  
  public void e()
  {
    FastColorFontLog.a("FounderBaseLayout", "release....");
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject != null)
    {
      ((Bitmap)localObject).recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas = null;
  }
  
  public void f()
  {
    Object localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning()) && (this.e > 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PauseAnimation...... animInfo:");
      ((StringBuilder)localObject).append(Arrays.toString(this.i));
      ((StringBuilder)localObject).append("  frameIndex:");
      ((StringBuilder)localObject).append(this.e);
      FastColorFontLog.a("FounderBaseLayout", ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation = false;
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null)
    {
      Object localObject = this.i;
      if (localObject[0] > 0)
      {
        if (localObject[1] <= 0) {
          return;
        }
        localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
        if ((localObject != null) && (!((ValueAnimator)localObject).isRunning()))
        {
          int j = this.e;
          if ((j > 0) && (j < this.i[0]))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("RestartAnimation...... animInfo:");
            ((StringBuilder)localObject).append(Arrays.toString(this.i));
            ((StringBuilder)localObject).append("  frameIndex:");
            ((StringBuilder)localObject).append(this.e);
            FastColorFontLog.a("FounderBaseLayout", ((StringBuilder)localObject).toString());
            this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation = true;
            this.jdField_a_of_type_AndroidAnimationValueAnimator.setIntValues(new int[] { this.e, this.i[0] });
            localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
            int[] arrayOfInt = this.i;
            ((ValueAnimator)localObject).setDuration((arrayOfInt[0] - this.e) * arrayOfInt[1]);
            this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
          }
        }
      }
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation = true;
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator == null)
    {
      a();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
    }
    if (!localValueAnimator.isRunning())
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setIntValues(new int[] { this.i[0] });
      localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
      int[] arrayOfInt = this.i;
      localValueAnimator.setDuration(arrayOfInt[0] * arrayOfInt[1]);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  public void i()
  {
    a(true);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.e = 0;
    int[] arrayOfInt = this.i;
    arrayOfInt[0] = -1;
    arrayOfInt[1] = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.FounderBaseLayout
 * JD-Core Version:    0.7.0.1
 */