package androidx.core.view;

import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;

@RequiresApi(20)
class WindowInsetsCompat$Impl20
  extends WindowInsetsCompat.Impl
{
  @NonNull
  final WindowInsets mPlatformInsets;
  private Insets mSystemWindowInsets = null;
  
  WindowInsetsCompat$Impl20(@NonNull WindowInsetsCompat paramWindowInsetsCompat, @NonNull WindowInsets paramWindowInsets)
  {
    super(paramWindowInsetsCompat);
    this.mPlatformInsets = paramWindowInsets;
  }
  
  WindowInsetsCompat$Impl20(@NonNull WindowInsetsCompat paramWindowInsetsCompat, @NonNull Impl20 paramImpl20)
  {
    this(paramWindowInsetsCompat, new WindowInsets(paramImpl20.mPlatformInsets));
  }
  
  @NonNull
  final Insets getSystemWindowInsets()
  {
    if (this.mSystemWindowInsets == null) {
      this.mSystemWindowInsets = Insets.of(this.mPlatformInsets.getSystemWindowInsetLeft(), this.mPlatformInsets.getSystemWindowInsetTop(), this.mPlatformInsets.getSystemWindowInsetRight(), this.mPlatformInsets.getSystemWindowInsetBottom());
    }
    return this.mSystemWindowInsets;
  }
  
  @NonNull
  WindowInsetsCompat inset(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    WindowInsetsCompat.Builder localBuilder = new WindowInsetsCompat.Builder(WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets));
    localBuilder.setSystemWindowInsets(WindowInsetsCompat.insetInsets(getSystemWindowInsets(), paramInt1, paramInt2, paramInt3, paramInt4));
    localBuilder.setStableInsets(WindowInsetsCompat.insetInsets(getStableInsets(), paramInt1, paramInt2, paramInt3, paramInt4));
    return localBuilder.build();
  }
  
  boolean isRound()
  {
    return this.mPlatformInsets.isRound();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.WindowInsetsCompat.Impl20
 * JD-Core Version:    0.7.0.1
 */