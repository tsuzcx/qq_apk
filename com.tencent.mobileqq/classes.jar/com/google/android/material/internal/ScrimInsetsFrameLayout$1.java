package com.google.android.material.internal;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

class ScrimInsetsFrameLayout$1
  implements OnApplyWindowInsetsListener
{
  ScrimInsetsFrameLayout$1(ScrimInsetsFrameLayout paramScrimInsetsFrameLayout) {}
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, @NonNull WindowInsetsCompat paramWindowInsetsCompat)
  {
    if (this.a.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.a.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
    this.a.jdField_a_of_type_AndroidGraphicsRect.set(paramWindowInsetsCompat.getSystemWindowInsetLeft(), paramWindowInsetsCompat.getSystemWindowInsetTop(), paramWindowInsetsCompat.getSystemWindowInsetRight(), paramWindowInsetsCompat.getSystemWindowInsetBottom());
    this.a.a(paramWindowInsetsCompat);
    paramView = this.a;
    boolean bool;
    if ((paramWindowInsetsCompat.hasSystemWindowInsets()) && (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {
      bool = false;
    } else {
      bool = true;
    }
    paramView.setWillNotDraw(bool);
    ViewCompat.postInvalidateOnAnimation(this.a);
    return paramWindowInsetsCompat.consumeSystemWindowInsets();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.ScrimInsetsFrameLayout.1
 * JD-Core Version:    0.7.0.1
 */