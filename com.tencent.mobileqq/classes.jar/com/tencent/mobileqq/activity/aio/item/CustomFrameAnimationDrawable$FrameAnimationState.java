package com.tencent.mobileqq.activity.aio.item;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.NonNull;
import java.util.ArrayList;

public final class CustomFrameAnimationDrawable$FrameAnimationState
  extends Drawable.ConstantState
{
  final Paint a = new Paint(6);
  public ArrayList<CustomFrameAnimationDrawable.OneFrame> b = new ArrayList();
  int c = -1;
  boolean d = false;
  int e = 160;
  public ArrayList<Bitmap> f = new ArrayList();
  boolean g = false;
  boolean h = true;
  boolean i = false;
  int j = 0;
  int k = 0;
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  @NonNull
  public Drawable newDrawable()
  {
    return new CustomFrameAnimationDrawable(this, null, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new CustomFrameAnimationDrawable(this, paramResources, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.FrameAnimationState
 * JD-Core Version:    0.7.0.1
 */