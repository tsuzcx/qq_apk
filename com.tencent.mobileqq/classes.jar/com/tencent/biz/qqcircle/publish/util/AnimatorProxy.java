package com.tencent.biz.qqcircle.publish.util;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class AnimatorProxy
  extends Animation
{
  public static final boolean a;
  static final WeakHashMap<View, AnimatorProxy> b = new WeakHashMap();
  final WeakReference<View> c;
  final Camera d;
  boolean e;
  float f;
  float g;
  float h;
  float i;
  float j;
  float k;
  float l;
  float m;
  float n;
  float o;
  
  static
  {
    boolean bool;
    if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 11) {
      bool = true;
    } else {
      bool = false;
    }
    a = bool;
  }
  
  private void a(Matrix paramMatrix, View paramView)
  {
    float f3 = paramView.getWidth();
    float f4 = paramView.getHeight();
    boolean bool = this.e;
    float f1;
    if (bool) {
      f1 = this.g;
    } else {
      f1 = f3 / 2.0F;
    }
    float f2;
    if (bool) {
      f2 = this.h;
    } else {
      f2 = f4 / 2.0F;
    }
    float f5 = this.i;
    float f6 = this.j;
    float f7 = this.k;
    if ((f5 != 0.0F) || (f6 != 0.0F) || (f7 != 0.0F))
    {
      paramView = this.d;
      paramView.save();
      paramView.rotateX(f5);
      paramView.rotateY(f6);
      paramView.rotateZ(-f7);
      paramView.getMatrix(paramMatrix);
      paramView.restore();
      paramMatrix.preTranslate(-f1, -f2);
      paramMatrix.postTranslate(f1, f2);
    }
    f5 = this.l;
    f6 = this.m;
    if ((f5 != 1.0F) || (f6 != 1.0F))
    {
      paramMatrix.postScale(f5, f6);
      paramMatrix.postTranslate(-(f1 / f3) * (f5 * f3 - f3), -(f2 / f4) * (f6 * f4 - f4));
    }
    paramMatrix.postTranslate(this.n, this.o);
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    View localView = (View)this.c.get();
    if (localView != null)
    {
      paramTransformation.setAlpha(this.f);
      a(paramTransformation.getMatrix(), localView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.util.AnimatorProxy
 * JD-Core Version:    0.7.0.1
 */