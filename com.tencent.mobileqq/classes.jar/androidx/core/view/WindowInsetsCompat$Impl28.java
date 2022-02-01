package androidx.core.view;

import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Objects;

@RequiresApi(28)
class WindowInsetsCompat$Impl28
  extends WindowInsetsCompat.Impl21
{
  WindowInsetsCompat$Impl28(@NonNull WindowInsetsCompat paramWindowInsetsCompat, @NonNull WindowInsets paramWindowInsets)
  {
    super(paramWindowInsetsCompat, paramWindowInsets);
  }
  
  WindowInsetsCompat$Impl28(@NonNull WindowInsetsCompat paramWindowInsetsCompat, @NonNull Impl28 paramImpl28)
  {
    super(paramWindowInsetsCompat, paramImpl28);
  }
  
  @NonNull
  WindowInsetsCompat consumeDisplayCutout()
  {
    return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeDisplayCutout());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Impl28)) {
      return false;
    }
    paramObject = (Impl28)paramObject;
    return Objects.equals(this.mPlatformInsets, paramObject.mPlatformInsets);
  }
  
  @Nullable
  DisplayCutoutCompat getDisplayCutout()
  {
    return DisplayCutoutCompat.wrap(this.mPlatformInsets.getDisplayCutout());
  }
  
  public int hashCode()
  {
    return this.mPlatformInsets.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.WindowInsetsCompat.Impl28
 * JD-Core Version:    0.7.0.1
 */