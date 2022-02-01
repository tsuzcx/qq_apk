package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import androidx.annotation.Nullable;

public abstract interface TintableCompoundDrawablesView
{
  @Nullable
  public abstract ColorStateList getSupportCompoundDrawablesTintList();
  
  @Nullable
  public abstract PorterDuff.Mode getSupportCompoundDrawablesTintMode();
  
  public abstract void setSupportCompoundDrawablesTintList(@Nullable ColorStateList paramColorStateList);
  
  public abstract void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode paramMode);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.widget.TintableCompoundDrawablesView
 * JD-Core Version:    0.7.0.1
 */