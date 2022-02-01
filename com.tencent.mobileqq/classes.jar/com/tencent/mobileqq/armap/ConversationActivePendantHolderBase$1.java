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
    this.a.b = paramFloat1.floatValue();
    this.a.jdField_a_of_type_Float = (1.1F - (paramFloat1.floatValue() - 1.0F));
    if (!this.a.jdField_a_of_type_Boolean) {
      this.a.a((int)(this.a.d * paramFloat1.floatValue()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ConversationActivePendantHolderBase.1
 * JD-Core Version:    0.7.0.1
 */