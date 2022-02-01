package com.bumptech.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

public class DrawableCrossFadeTransition
  implements Transition<Drawable>
{
  private final int a;
  private final boolean b;
  
  public DrawableCrossFadeTransition(int paramInt, boolean paramBoolean)
  {
    this.a = paramInt;
    this.b = paramBoolean;
  }
  
  public boolean a(Drawable paramDrawable, Transition.ViewAdapter paramViewAdapter)
  {
    Drawable localDrawable = paramViewAdapter.b();
    Object localObject = localDrawable;
    if (localDrawable == null) {
      localObject = new ColorDrawable(0);
    }
    paramDrawable = new TransitionDrawable(new Drawable[] { localObject, paramDrawable });
    paramDrawable.setCrossFadeEnabled(this.b);
    paramDrawable.startTransition(this.a);
    paramViewAdapter.e(paramDrawable);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.transition.DrawableCrossFadeTransition
 * JD-Core Version:    0.7.0.1
 */