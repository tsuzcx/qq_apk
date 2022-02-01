package androidx.core.view;

import android.view.WindowInsets.Builder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;

@RequiresApi(api=29)
class WindowInsetsCompat$BuilderImpl29
  extends WindowInsetsCompat.BuilderImpl
{
  final WindowInsets.Builder mPlatBuilder;
  
  WindowInsetsCompat$BuilderImpl29()
  {
    this.mPlatBuilder = new WindowInsets.Builder();
  }
  
  WindowInsetsCompat$BuilderImpl29(@NonNull WindowInsetsCompat paramWindowInsetsCompat)
  {
    paramWindowInsetsCompat = paramWindowInsetsCompat.toWindowInsets();
    if (paramWindowInsetsCompat != null) {
      paramWindowInsetsCompat = new WindowInsets.Builder(paramWindowInsetsCompat);
    } else {
      paramWindowInsetsCompat = new WindowInsets.Builder();
    }
    this.mPlatBuilder = paramWindowInsetsCompat;
  }
  
  @NonNull
  WindowInsetsCompat build()
  {
    return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatBuilder.build());
  }
  
  void setDisplayCutout(@Nullable DisplayCutoutCompat paramDisplayCutoutCompat)
  {
    WindowInsets.Builder localBuilder = this.mPlatBuilder;
    if (paramDisplayCutoutCompat != null) {
      paramDisplayCutoutCompat = paramDisplayCutoutCompat.unwrap();
    } else {
      paramDisplayCutoutCompat = null;
    }
    localBuilder.setDisplayCutout(paramDisplayCutoutCompat);
  }
  
  void setMandatorySystemGestureInsets(@NonNull Insets paramInsets)
  {
    this.mPlatBuilder.setMandatorySystemGestureInsets(paramInsets.toPlatformInsets());
  }
  
  void setStableInsets(@NonNull Insets paramInsets)
  {
    this.mPlatBuilder.setStableInsets(paramInsets.toPlatformInsets());
  }
  
  void setSystemGestureInsets(@NonNull Insets paramInsets)
  {
    this.mPlatBuilder.setSystemGestureInsets(paramInsets.toPlatformInsets());
  }
  
  void setSystemWindowInsets(@NonNull Insets paramInsets)
  {
    this.mPlatBuilder.setSystemWindowInsets(paramInsets.toPlatformInsets());
  }
  
  void setTappableElementInsets(@NonNull Insets paramInsets)
  {
    this.mPlatBuilder.setTappableElementInsets(paramInsets.toPlatformInsets());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.WindowInsetsCompat.BuilderImpl29
 * JD-Core Version:    0.7.0.1
 */