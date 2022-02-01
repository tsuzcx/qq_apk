package com.tencent.biz.videostory.animator;

import android.graphics.PathMeasure;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;

class AnimationBuilder$4
  implements AnimationListener.Update
{
  public void a(View paramView, float paramFloat)
  {
    float[] arrayOfFloat = new float[2];
    this.a.getPosTan(paramFloat, arrayOfFloat, null);
    float f1 = arrayOfFloat[0];
    float f2 = arrayOfFloat[1];
    ViewCompat.setX(paramView, f1);
    ViewCompat.setY(paramView, f2);
    paramView = new StringBuilder();
    paramView.append("path: value=");
    paramView.append(paramFloat);
    paramView.append(", x=");
    paramView.append(f1);
    paramView.append(", y=");
    paramView.append(f2);
    Log.d(null, paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.animator.AnimationBuilder.4
 * JD-Core Version:    0.7.0.1
 */