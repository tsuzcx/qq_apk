package com.bumptech.glide.request.target;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.NonNull;

final class FixedSizeDrawable$State
  extends Drawable.ConstantState
{
  final int a;
  final int b;
  private final Drawable.ConstantState c;
  
  FixedSizeDrawable$State(Drawable.ConstantState paramConstantState, int paramInt1, int paramInt2)
  {
    this.c = paramConstantState;
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  FixedSizeDrawable$State(State paramState)
  {
    this(paramState.c, paramState.a, paramState.b);
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  @NonNull
  public Drawable newDrawable()
  {
    return new FixedSizeDrawable(this, this.c.newDrawable());
  }
  
  @NonNull
  public Drawable newDrawable(Resources paramResources)
  {
    return new FixedSizeDrawable(this, this.c.newDrawable(paramResources));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.target.FixedSizeDrawable.State
 * JD-Core Version:    0.7.0.1
 */