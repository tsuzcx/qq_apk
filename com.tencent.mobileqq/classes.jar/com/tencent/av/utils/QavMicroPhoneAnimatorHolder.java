package com.tencent.av.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

public final class QavMicroPhoneAnimatorHolder
{
  private Activity a;
  private Drawable b;
  private ClipDrawable c;
  private LayerDrawable d;
  
  public QavMicroPhoneAnimatorHolder(Activity paramActivity)
  {
    this.a = paramActivity;
    b();
  }
  
  private void b()
  {
    this.b = this.a.getResources().getDrawable(2130843037);
    this.c = ((ClipDrawable)this.a.getResources().getDrawable(2130843036));
    this.d = new LayerDrawable(new Drawable[] { this.b, this.c });
    this.d.setLayerInset(0, 0, 0, 0, 0);
    this.d.setLayerInset(1, 0, 0, 0, 0);
    this.d.setBounds(0, 0, this.b.getIntrinsicWidth(), this.b.getIntrinsicHeight());
  }
  
  public Drawable a()
  {
    return this.d;
  }
  
  public void a(int paramInt)
  {
    this.c.setLevel(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.QavMicroPhoneAnimatorHolder
 * JD-Core Version:    0.7.0.1
 */