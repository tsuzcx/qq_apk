package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ImageViewCompat
{
  @Nullable
  public static ColorStateList getImageTintList(@NonNull ImageView paramImageView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramImageView.getImageTintList();
    }
    if ((paramImageView instanceof TintableImageSourceView)) {
      return ((TintableImageSourceView)paramImageView).getSupportImageTintList();
    }
    return null;
  }
  
  @Nullable
  public static PorterDuff.Mode getImageTintMode(@NonNull ImageView paramImageView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramImageView.getImageTintMode();
    }
    if ((paramImageView instanceof TintableImageSourceView)) {
      return ((TintableImageSourceView)paramImageView).getSupportImageTintMode();
    }
    return null;
  }
  
  public static void setImageTintList(@NonNull ImageView paramImageView, @Nullable ColorStateList paramColorStateList)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramImageView.setImageTintList(paramColorStateList);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramColorStateList = paramImageView.getDrawable();
        if ((paramColorStateList != null) && (paramImageView.getImageTintList() != null))
        {
          if (paramColorStateList.isStateful()) {
            paramColorStateList.setState(paramImageView.getDrawableState());
          }
          paramImageView.setImageDrawable(paramColorStateList);
        }
      }
    }
    while (!(paramImageView instanceof TintableImageSourceView)) {
      return;
    }
    ((TintableImageSourceView)paramImageView).setSupportImageTintList(paramColorStateList);
  }
  
  public static void setImageTintMode(@NonNull ImageView paramImageView, @Nullable PorterDuff.Mode paramMode)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramImageView.setImageTintMode(paramMode);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramMode = paramImageView.getDrawable();
        if ((paramMode != null) && (paramImageView.getImageTintList() != null))
        {
          if (paramMode.isStateful()) {
            paramMode.setState(paramImageView.getDrawableState());
          }
          paramImageView.setImageDrawable(paramMode);
        }
      }
    }
    while (!(paramImageView instanceof TintableImageSourceView)) {
      return;
    }
    ((TintableImageSourceView)paramImageView).setSupportImageTintMode(paramMode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.widget.ImageViewCompat
 * JD-Core Version:    0.7.0.1
 */