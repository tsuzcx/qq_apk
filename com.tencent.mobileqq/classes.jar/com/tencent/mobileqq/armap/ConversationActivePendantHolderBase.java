package com.tencent.mobileqq.armap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.portal.BaseAnimHolder;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.qphone.base.util.QLog;

public class ConversationActivePendantHolderBase
  extends BaseAnimHolder
{
  public long a;
  public Context a;
  public View a;
  private Interpolator a;
  public boolean a;
  public long b;
  protected RectF b;
  public int d = 0;
  public int e = 2;
  public int f = 0;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  
  public ConversationActivePendantHolderBase(View paramView)
  {
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 1L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
  }
  
  private void a()
  {
    a(this.d);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = 1L;
    this.e = 2;
  }
  
  private void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public RectF a(int paramInt)
  {
    return null;
  }
  
  public void a(int paramInt)
  {
    int j = paramInt;
    if (this.jdField_a_of_type_Boolean) {
      j = (int)(paramInt + this.d * (this.jdField_b_of_type_Float - 1.0F));
    }
    this.k = j;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    this.d = paramInt2;
  }
  
  public void a(int paramInt, long paramLong)
  {
    int j = this.d;
    this.i = j;
    this.h = (j + paramInt);
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new DecelerateInterpolator();
    this.e = 1;
    a(paramLong);
  }
  
  protected void a(Canvas paramCanvas) {}
  
  public boolean a(Canvas paramCanvas)
  {
    d();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.g);
    a(paramCanvas);
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    boolean bool2 = false;
    boolean bool1;
    if (localDrawable != null) {
      bool1 = super.a(paramCanvas);
    } else {
      bool1 = false;
    }
    b(paramCanvas);
    paramCanvas.restore();
    if ((this.jdField_a_of_type_Boolean) || (bool1)) {
      bool2 = true;
    }
    return bool2;
  }
  
  public RectF b(int paramInt)
  {
    RectF localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
    float f1 = this.j;
    float f2 = this.k;
    float f3 = paramInt;
    localRectF.set(f1 - 0.0F, f2 - 0.0F - f3, this.j + this.l + 0.0F, this.k + this.m + 0.0F - f3);
    return this.jdField_b_of_type_AndroidGraphicsRectF;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConvActivePendantHolderBase", 2, "stopActiveSanHua stopAnimation");
    }
    super.b();
    a();
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  protected void b(Canvas paramCanvas) {}
  
  public void c() {}
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    float f2 = (float)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long) * 1.0F / (float)this.jdField_b_of_type_Long;
    Interpolator localInterpolator = this.jdField_a_of_type_AndroidViewAnimationInterpolator;
    float f1;
    if (localInterpolator != null) {
      f1 = localInterpolator.getInterpolation(f2);
    } else {
      f1 = f2;
    }
    int j = this.i;
    a((int)(j + (this.h - j) * f1));
    if (f2 > 0.99D)
    {
      j = this.e;
      if (j != 1)
      {
        if (j != 3)
        {
          a();
          return;
        }
        this.e = 2;
        return;
      }
      this.e = 3;
      e();
    }
  }
  
  public void e()
  {
    this.i = this.k;
    this.h = this.d;
    this.e = 3;
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new ConversationActivePendantHolderBase.BounceInterpolatorX(this);
    a(1500L);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConvActivePendantHolderBase", 2, "startActiveSanHua scale");
    }
    ValueAnimation localValueAnimation = new ValueAnimation(Float.valueOf(1.0F), Float.valueOf(1.1F), new ConversationActivePendantHolderBase.1(this));
    localValueAnimation.setDuration(500L);
    localValueAnimation.setRepeatCount(-1);
    localValueAnimation.setRepeatMode(2);
    a(localValueAnimation);
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ConversationActivePendantHolderBase
 * JD-Core Version:    0.7.0.1
 */