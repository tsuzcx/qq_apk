package com.tencent.mobileqq.activity;

import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;

class ContactBindedActivity$2
  extends ScaleAnimation
{
  ContactBindedActivity$2(ContactBindedActivity paramContactBindedActivity, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, float paramFloat5, int paramInt2, float paramFloat6)
  {
    super(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramFloat5, paramInt2, paramFloat6);
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (paramTransformation == null) {
      return;
    }
    super.applyTransformation(paramFloat, paramTransformation);
    paramTransformation.setAlpha(paramFloat * 1.0F + 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ContactBindedActivity.2
 * JD-Core Version:    0.7.0.1
 */