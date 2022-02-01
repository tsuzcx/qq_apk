package com.tencent.mobileqq.activity.springfestival.entry.ui;

import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

class SpringNomalPendantHolder$1
  implements ValueAnimation.AnimationUpdateListener<Float>
{
  SpringNomalPendantHolder$1(SpringNomalPendantHolder paramSpringNomalPendantHolder) {}
  
  public void a(ValueAnimation<Float> paramValueAnimation, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    this.a.D = paramFloat1.floatValue();
    this.a.C = (1.07F - (paramFloat1.floatValue() - 1.0F));
    if (this.a.g != null)
    {
      this.a.g.j = paramFloat1.floatValue();
      this.a.g.i = this.a.C;
    }
    paramValueAnimation = this.a;
    paramValueAnimation.b((int)(paramValueAnimation.l * paramFloat1.floatValue()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.ui.SpringNomalPendantHolder.1
 * JD-Core Version:    0.7.0.1
 */