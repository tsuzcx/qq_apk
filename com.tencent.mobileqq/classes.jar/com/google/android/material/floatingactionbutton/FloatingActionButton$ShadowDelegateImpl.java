package com.google.android.material.floatingactionbutton;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.google.android.material.shadow.ShadowViewDelegate;

class FloatingActionButton$ShadowDelegateImpl
  implements ShadowViewDelegate
{
  FloatingActionButton$ShadowDelegateImpl(FloatingActionButton paramFloatingActionButton) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.b.set(paramInt1, paramInt2, paramInt3, paramInt4);
    FloatingActionButton localFloatingActionButton = this.a;
    localFloatingActionButton.setPadding(paramInt1 + FloatingActionButton.a(localFloatingActionButton), paramInt2 + FloatingActionButton.a(this.a), paramInt3 + FloatingActionButton.a(this.a), paramInt4 + FloatingActionButton.a(this.a));
  }
  
  public void a(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      FloatingActionButton.a(this.a, paramDrawable);
    }
  }
  
  public boolean a()
  {
    return this.a.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButton.ShadowDelegateImpl
 * JD-Core Version:    0.7.0.1
 */