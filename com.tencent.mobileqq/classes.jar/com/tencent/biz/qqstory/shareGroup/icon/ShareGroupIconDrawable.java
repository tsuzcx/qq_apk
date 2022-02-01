package com.tencent.biz.qqstory.shareGroup.icon;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

class ShareGroupIconDrawable
  extends Drawable
{
  private String a = "story.icon.ShareGroupIconDrawable";
  private ShareGroupDrawableState b;
  private Drawable c;
  private Drawable d;
  private ShareGroupDrawableState.CallBack e = new ShareGroupIconDrawable.1(this);
  
  ShareGroupIconDrawable(@NonNull ShareGroupDrawableState paramShareGroupDrawableState, @NonNull Drawable paramDrawable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("[");
    localStringBuilder.append(System.identityHashCode(paramShareGroupDrawableState));
    localStringBuilder.append(".");
    localStringBuilder.append(System.identityHashCode(this));
    localStringBuilder.append("]");
    this.a = localStringBuilder.toString();
    this.b = paramShareGroupDrawableState;
    this.b.a(this.e);
    this.c = paramDrawable;
    this.d = paramDrawable;
    paramShareGroupDrawableState = this.b.e();
    if (paramShareGroupDrawableState != null) {
      a(paramShareGroupDrawableState);
    }
  }
  
  private void a(@NonNull Drawable paramDrawable)
  {
    IconLog.a(this.a, "updateCurrentDrawable view:%s drawable: %s", getCallback(), paramDrawable);
    if (paramDrawable != this.d)
    {
      paramDrawable.setBounds(getBounds());
      paramDrawable.setVisible(isVisible(), true);
      paramDrawable.setState(getState());
      paramDrawable.setLevel(getLevel());
      paramDrawable.setCallback(getCallback());
      if (Build.VERSION.SDK_INT >= 19) {
        paramDrawable.setAlpha(getAlpha());
      }
      Drawable localDrawable = this.d;
      this.d = paramDrawable;
      if (localDrawable != null) {
        localDrawable.setCallback(null);
      }
      invalidateSelf();
    }
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    this.d.draw(paramCanvas);
    this.b.d();
  }
  
  public int getOpacity()
  {
    return this.d.getOpacity();
  }
  
  public boolean getPadding(@NonNull Rect paramRect)
  {
    return this.d.getPadding(paramRect);
  }
  
  @NonNull
  public Drawable mutate()
  {
    this.d.mutate();
    return super.mutate();
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.d.setBounds(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    this.d.setLevel(paramInt);
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    this.d.setState(paramArrayOfInt);
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.d.setAlpha(paramInt);
  }
  
  public void setColorFilter(int paramInt, @NonNull PorterDuff.Mode paramMode)
  {
    super.setColorFilter(paramInt, paramMode);
    this.d.setColorFilter(paramInt, paramMode);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.d.setColorFilter(paramColorFilter);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    this.d.setVisible(paramBoolean1, paramBoolean2);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconDrawable
 * JD-Core Version:    0.7.0.1
 */