package androidx.core.view;

import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;

@RequiresApi(21)
class WindowInsetsCompat$Impl21
  extends WindowInsetsCompat.Impl20
{
  private Insets mStableInsets = null;
  
  WindowInsetsCompat$Impl21(@NonNull WindowInsetsCompat paramWindowInsetsCompat, @NonNull WindowInsets paramWindowInsets)
  {
    super(paramWindowInsetsCompat, paramWindowInsets);
  }
  
  WindowInsetsCompat$Impl21(@NonNull WindowInsetsCompat paramWindowInsetsCompat, @NonNull Impl21 paramImpl21)
  {
    super(paramWindowInsetsCompat, paramImpl21);
  }
  
  @NonNull
  WindowInsetsCompat consumeStableInsets()
  {
    return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeStableInsets());
  }
  
  @NonNull
  WindowInsetsCompat consumeSystemWindowInsets()
  {
    return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeSystemWindowInsets());
  }
  
  @NonNull
  final Insets getStableInsets()
  {
    if (this.mStableInsets == null) {
      this.mStableInsets = Insets.of(this.mPlatformInsets.getStableInsetLeft(), this.mPlatformInsets.getStableInsetTop(), this.mPlatformInsets.getStableInsetRight(), this.mPlatformInsets.getStableInsetBottom());
    }
    return this.mStableInsets;
  }
  
  boolean isConsumed()
  {
    return this.mPlatformInsets.isConsumed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.WindowInsetsCompat.Impl21
 * JD-Core Version:    0.7.0.1
 */