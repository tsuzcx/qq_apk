package androidx.core.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import java.util.Objects;

public class WindowInsetsCompat
{
  private final Object mInsets;
  
  public WindowInsetsCompat(WindowInsetsCompat paramWindowInsetsCompat)
  {
    if (Build.VERSION.SDK_INT >= 20)
    {
      if (paramWindowInsetsCompat == null) {}
      for (paramWindowInsetsCompat = localObject;; paramWindowInsetsCompat = new WindowInsets((WindowInsets)paramWindowInsetsCompat.mInsets))
      {
        this.mInsets = paramWindowInsetsCompat;
        return;
      }
    }
    this.mInsets = null;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  @VisibleForTesting
  WindowInsetsCompat(@Nullable Object paramObject)
  {
    this.mInsets = paramObject;
  }
  
  @NonNull
  @RequiresApi(20)
  public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets paramWindowInsets)
  {
    return new WindowInsetsCompat(Objects.requireNonNull(paramWindowInsets));
  }
  
  public WindowInsetsCompat consumeDisplayCutout()
  {
    WindowInsetsCompat localWindowInsetsCompat = this;
    if (Build.VERSION.SDK_INT >= 28) {
      localWindowInsetsCompat = new WindowInsetsCompat(((WindowInsets)this.mInsets).consumeDisplayCutout());
    }
    return localWindowInsetsCompat;
  }
  
  public WindowInsetsCompat consumeStableInsets()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new WindowInsetsCompat(((WindowInsets)this.mInsets).consumeStableInsets());
    }
    return null;
  }
  
  public WindowInsetsCompat consumeSystemWindowInsets()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return new WindowInsetsCompat(((WindowInsets)this.mInsets).consumeSystemWindowInsets());
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof WindowInsetsCompat)) {
      return false;
    }
    paramObject = (WindowInsetsCompat)paramObject;
    return ObjectsCompat.equals(this.mInsets, paramObject.mInsets);
  }
  
  @Nullable
  public DisplayCutoutCompat getDisplayCutout()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return DisplayCutoutCompat.wrap(((WindowInsets)this.mInsets).getDisplayCutout());
    }
    return null;
  }
  
  @NonNull
  public Insets getMandatorySystemGestureInsets()
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return Insets.wrap(((WindowInsets)this.mInsets).getMandatorySystemGestureInsets());
    }
    return getSystemWindowInsets();
  }
  
  public int getStableInsetBottom()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((WindowInsets)this.mInsets).getStableInsetBottom();
    }
    return 0;
  }
  
  public int getStableInsetLeft()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((WindowInsets)this.mInsets).getStableInsetLeft();
    }
    return 0;
  }
  
  public int getStableInsetRight()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((WindowInsets)this.mInsets).getStableInsetRight();
    }
    return 0;
  }
  
  public int getStableInsetTop()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((WindowInsets)this.mInsets).getStableInsetTop();
    }
    return 0;
  }
  
  @NonNull
  public Insets getStableInsets()
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return Insets.wrap(((WindowInsets)this.mInsets).getStableInsets());
    }
    return Insets.of(getStableInsetLeft(), getStableInsetTop(), getStableInsetRight(), getStableInsetBottom());
  }
  
  @NonNull
  public Insets getSystemGestureInsets()
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return Insets.wrap(((WindowInsets)this.mInsets).getSystemGestureInsets());
    }
    return getSystemWindowInsets();
  }
  
  public int getSystemWindowInsetBottom()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.mInsets).getSystemWindowInsetBottom();
    }
    return 0;
  }
  
  public int getSystemWindowInsetLeft()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.mInsets).getSystemWindowInsetLeft();
    }
    return 0;
  }
  
  public int getSystemWindowInsetRight()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.mInsets).getSystemWindowInsetRight();
    }
    return 0;
  }
  
  public int getSystemWindowInsetTop()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.mInsets).getSystemWindowInsetTop();
    }
    return 0;
  }
  
  @NonNull
  public Insets getSystemWindowInsets()
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return Insets.wrap(((WindowInsets)this.mInsets).getSystemWindowInsets());
    }
    return Insets.of(getSystemWindowInsetLeft(), getSystemWindowInsetTop(), getSystemWindowInsetRight(), getSystemWindowInsetBottom());
  }
  
  @NonNull
  public Insets getTappableElementInsets()
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return Insets.wrap(((WindowInsets)this.mInsets).getTappableElementInsets());
    }
    return getSystemWindowInsets();
  }
  
  public boolean hasInsets()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.mInsets).hasInsets();
    }
    return false;
  }
  
  public boolean hasStableInsets()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((WindowInsets)this.mInsets).hasStableInsets();
    }
    return false;
  }
  
  public boolean hasSystemWindowInsets()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.mInsets).hasSystemWindowInsets();
    }
    return false;
  }
  
  public int hashCode()
  {
    if (this.mInsets == null) {
      return 0;
    }
    return this.mInsets.hashCode();
  }
  
  public boolean isConsumed()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((WindowInsets)this.mInsets).isConsumed();
    }
    return false;
  }
  
  public boolean isRound()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.mInsets).isRound();
    }
    return false;
  }
  
  public WindowInsetsCompat replaceSystemWindowInsets(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return new WindowInsetsCompat(((WindowInsets)this.mInsets).replaceSystemWindowInsets(paramInt1, paramInt2, paramInt3, paramInt4));
    }
    return null;
  }
  
  public WindowInsetsCompat replaceSystemWindowInsets(Rect paramRect)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new WindowInsetsCompat(((WindowInsets)this.mInsets).replaceSystemWindowInsets(paramRect));
    }
    return null;
  }
  
  @Nullable
  @RequiresApi(20)
  public WindowInsets toWindowInsets()
  {
    return (WindowInsets)this.mInsets;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.view.WindowInsetsCompat
 * JD-Core Version:    0.7.0.1
 */