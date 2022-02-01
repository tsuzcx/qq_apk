package androidx.core.view;

import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;

@RequiresApi(29)
class WindowInsetsCompat$Impl29
  extends WindowInsetsCompat.Impl28
{
  private Insets mMandatorySystemGestureInsets = null;
  private Insets mSystemGestureInsets = null;
  private Insets mTappableElementInsets = null;
  
  WindowInsetsCompat$Impl29(@NonNull WindowInsetsCompat paramWindowInsetsCompat, @NonNull WindowInsets paramWindowInsets)
  {
    super(paramWindowInsetsCompat, paramWindowInsets);
  }
  
  WindowInsetsCompat$Impl29(@NonNull WindowInsetsCompat paramWindowInsetsCompat, @NonNull Impl29 paramImpl29)
  {
    super(paramWindowInsetsCompat, paramImpl29);
  }
  
  @NonNull
  Insets getMandatorySystemGestureInsets()
  {
    if (this.mMandatorySystemGestureInsets == null) {
      this.mMandatorySystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getMandatorySystemGestureInsets());
    }
    return this.mMandatorySystemGestureInsets;
  }
  
  @NonNull
  Insets getSystemGestureInsets()
  {
    if (this.mSystemGestureInsets == null) {
      this.mSystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getSystemGestureInsets());
    }
    return this.mSystemGestureInsets;
  }
  
  @NonNull
  Insets getTappableElementInsets()
  {
    if (this.mTappableElementInsets == null) {
      this.mTappableElementInsets = Insets.toCompatInsets(this.mPlatformInsets.getTappableElementInsets());
    }
    return this.mTappableElementInsets;
  }
  
  @NonNull
  WindowInsetsCompat inset(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.inset(paramInt1, paramInt2, paramInt3, paramInt4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.WindowInsetsCompat.Impl29
 * JD-Core Version:    0.7.0.1
 */