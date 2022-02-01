package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import androidx.annotation.Nullable;

public abstract interface TintableCompoundButton
{
  @Nullable
  public abstract ColorStateList getSupportButtonTintList();
  
  @Nullable
  public abstract PorterDuff.Mode getSupportButtonTintMode();
  
  public abstract void setSupportButtonTintList(@Nullable ColorStateList paramColorStateList);
  
  public abstract void setSupportButtonTintMode(@Nullable PorterDuff.Mode paramMode);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.widget.TintableCompoundButton
 * JD-Core Version:    0.7.0.1
 */