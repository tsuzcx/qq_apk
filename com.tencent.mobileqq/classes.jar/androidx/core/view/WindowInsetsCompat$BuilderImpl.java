package androidx.core.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;

class WindowInsetsCompat$BuilderImpl
{
  private final WindowInsetsCompat mInsets;
  
  WindowInsetsCompat$BuilderImpl()
  {
    this(new WindowInsetsCompat((WindowInsetsCompat)null));
  }
  
  WindowInsetsCompat$BuilderImpl(@NonNull WindowInsetsCompat paramWindowInsetsCompat)
  {
    this.mInsets = paramWindowInsetsCompat;
  }
  
  @NonNull
  WindowInsetsCompat build()
  {
    return this.mInsets;
  }
  
  void setDisplayCutout(@Nullable DisplayCutoutCompat paramDisplayCutoutCompat) {}
  
  void setMandatorySystemGestureInsets(@NonNull Insets paramInsets) {}
  
  void setStableInsets(@NonNull Insets paramInsets) {}
  
  void setSystemGestureInsets(@NonNull Insets paramInsets) {}
  
  void setSystemWindowInsets(@NonNull Insets paramInsets) {}
  
  void setTappableElementInsets(@NonNull Insets paramInsets) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.WindowInsetsCompat.BuilderImpl
 * JD-Core Version:    0.7.0.1
 */