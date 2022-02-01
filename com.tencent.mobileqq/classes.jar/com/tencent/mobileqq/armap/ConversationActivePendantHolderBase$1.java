package com.tencent.mobileqq.armap;

import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

class ConversationActivePendantHolderBase$1
  implements ValueAnimation.AnimationUpdateListener<Float>
{
  ConversationActivePendantHolderBase$1(ConversationActivePendantHolderBase paramConversationActivePendantHolderBase) {}
  
  public void a(ValueAnimation<Float> paramValueAnimation, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    this.a.D = paramFloat1.floatValue();
    this.a.C = (1.1F - (paramFloat1.floatValue() - 1.0F));
    if (!this.a.t)
    {
      paramValueAnimation = this.a;
      paramValueAnimation.b((int)(paramValueAnimation.l * paramFloat1.floatValue()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ConversationActivePendantHolderBase.1
 * JD-Core Version:    0.7.0.1
 */