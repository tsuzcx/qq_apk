package com.tencent.android.gldrawable.api;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/api/IGLDrawable;", "Landroid/graphics/drawable/Drawable;", "()V", "getResID", "", "isRecyclyed", "", "onTouch", "", "x", "", "y", "recycle", "setDrawArea", "x0", "y0", "x1", "y1", "setLockWH", "b", "api_release"}, k=1, mv={1, 1, 16})
public abstract class IGLDrawable
  extends Drawable
{
  @NotNull
  public abstract String getResID();
  
  public abstract boolean isRecyclyed();
  
  public abstract void onTouch(float paramFloat1, float paramFloat2);
  
  public abstract void recycle();
  
  public abstract void setDrawArea(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract void setLockWH(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.IGLDrawable
 * JD-Core Version:    0.7.0.1
 */