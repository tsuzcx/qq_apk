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
    Log.d(null, "path: value=" + paramFloat + ", x=" + f1 + ", y=" + f2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.animator.AnimationBuilder.4
 * JD-Core Version:    0.7.0.1
 */