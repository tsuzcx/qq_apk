package com.tencent.mobileqq.armap;

import abcn;
import abco;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
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
  public int a;
  public long a;
  public Context a;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  public View a;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  public boolean a;
  public int b;
  public long b;
  public int c;
  public int d;
  public int e;
  
  public ConversationActivePendantHolderBase(View paramView)
  {
    this.jdField_b_of_type_Int = 2;
    this.jdField_b_of_type_Long = 1L;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
  }
  
  private void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void f()
  {
    b(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = 1L;
    this.jdField_b_of_type_Int = 2;
  }
  
  public RectF a(int paramInt)
  {
    float f = this.h / 4;
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.f - f, this.g - f + this.c - paramInt, this.f + this.h + f, f + (this.g + this.i) + this.c - paramInt);
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.e = this.jdField_a_of_type_Int;
    this.d = (this.jdField_a_of_type_Int + paramInt);
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new DecelerateInterpolator();
    this.jdField_b_of_type_Int = 1;
    a(paramLong);
  }
  
  public void a(Canvas paramCanvas) {}
  
  public boolean a(Canvas paramCanvas)
  {
    boolean bool2 = false;
    d();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.c);
    a(paramCanvas);
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {}
    for (boolean bool1 = super.a(paramCanvas);; bool1 = false)
    {
      b(paramCanvas);
      paramCanvas.restore();
      if ((this.jdField_a_of_type_Boolean) || (bool1)) {
        bool2 = true;
      }
      return bool2;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConvActivePendantHolderBase", 2, "startActiveSanHua scale");
    }
    ValueAnimation localValueAnimation = new ValueAnimation(Float.valueOf(1.0F), Float.valueOf(1.1F), new abcn(this));
    localValueAnimation.setDuration(500L);
    localValueAnimation.setRepeatCount(-1);
    localValueAnimation.setRepeatMode(2);
    a(localValueAnimation);
  }
  
  public void b(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_Boolean) {
      i = (int)(paramInt + this.jdField_a_of_type_Int * (this.jdField_b_of_type_Float - 1.0F));
    }
    this.g = i;
  }
  
  public void b(Canvas paramCanvas) {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConvActivePendantHolderBase", 2, "stopActiveSanHua stopAnimation");
    }
    super.c();
    f();
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    float f2 = (float)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long) * 1.0F / (float)this.jdField_b_of_type_Long;
    if (this.jdField_a_of_type_AndroidViewAnimationInterpolator != null) {}
    for (float f1 = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f2);; f1 = f2)
    {
      float f3 = this.e;
      b((int)(f1 * (this.d - this.e) + f3));
      if (f2 <= 0.99D) {
        break;
      }
      switch (this.jdField_b_of_type_Int)
      {
      case 2: 
      default: 
        f();
        return;
      case 1: 
        this.jdField_b_of_type_Int = 3;
        e();
        return;
      }
      this.jdField_b_of_type_Int = 2;
      return;
    }
  }
  
  public void e()
  {
    this.e = this.g;
    this.d = this.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new abco(this);
    a(1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ConversationActivePendantHolderBase
 * JD-Core Version:    0.7.0.1
 */