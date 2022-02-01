package androidx.core.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.WindowInsets;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;

public class WindowInsetsCompat
{
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static final WindowInsetsCompat CONSUMED = new WindowInsetsCompat.Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
  private static final String TAG = "WindowInsetsCompat";
  private final WindowInsetsCompat.Impl mImpl;
  
  @RequiresApi(20)
  private WindowInsetsCompat(@NonNull WindowInsets paramWindowInsets)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      this.mImpl = new WindowInsetsCompat.Impl29(this, paramWindowInsets);
      return;
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.mImpl = new WindowInsetsCompat.Impl28(this, paramWindowInsets);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.mImpl = new WindowInsetsCompat.Impl21(this, paramWindowInsets);
      return;
    }
    if (Build.VERSION.SDK_INT >= 20)
    {
      this.mImpl = new WindowInsetsCompat.Impl20(this, paramWindowInsets);
      return;
    }
    this.mImpl = new WindowInsetsCompat.Impl(this);
  }
  
  public WindowInsetsCompat(@Nullable WindowInsetsCompat paramWindowInsetsCompat)
  {
    if (paramWindowInsetsCompat != null)
    {
      paramWindowInsetsCompat = paramWindowInsetsCompat.mImpl;
      if ((Build.VERSION.SDK_INT >= 29) && ((paramWindowInsetsCompat instanceof WindowInsetsCompat.Impl29)))
      {
        this.mImpl = new WindowInsetsCompat.Impl29(this, (WindowInsetsCompat.Impl29)paramWindowInsetsCompat);
        return;
      }
      if ((Build.VERSION.SDK_INT >= 28) && ((paramWindowInsetsCompat instanceof WindowInsetsCompat.Impl28)))
      {
        this.mImpl = new WindowInsetsCompat.Impl28(this, (WindowInsetsCompat.Impl28)paramWindowInsetsCompat);
        return;
      }
      if ((Build.VERSION.SDK_INT >= 21) && ((paramWindowInsetsCompat instanceof WindowInsetsCompat.Impl21)))
      {
        this.mImpl = new WindowInsetsCompat.Impl21(this, (WindowInsetsCompat.Impl21)paramWindowInsetsCompat);
        return;
      }
      if ((Build.VERSION.SDK_INT >= 20) && ((paramWindowInsetsCompat instanceof WindowInsetsCompat.Impl20)))
      {
        this.mImpl = new WindowInsetsCompat.Impl20(this, (WindowInsetsCompat.Impl20)paramWindowInsetsCompat);
        return;
      }
      this.mImpl = new WindowInsetsCompat.Impl(this);
      return;
    }
    this.mImpl = new WindowInsetsCompat.Impl(this);
  }
  
  static Insets insetInsets(Insets paramInsets, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = Math.max(0, paramInsets.left - paramInt1);
    int j = Math.max(0, paramInsets.top - paramInt2);
    int k = Math.max(0, paramInsets.right - paramInt3);
    int m = Math.max(0, paramInsets.bottom - paramInt4);
    if ((i == paramInt1) && (j == paramInt2) && (k == paramInt3) && (m == paramInt4)) {
      return paramInsets;
    }
    return Insets.of(i, j, k, m);
  }
  
  @NonNull
  @RequiresApi(20)
  public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets paramWindowInsets)
  {
    return new WindowInsetsCompat((WindowInsets)Preconditions.checkNotNull(paramWindowInsets));
  }
  
  @NonNull
  public WindowInsetsCompat consumeDisplayCutout()
  {
    return this.mImpl.consumeDisplayCutout();
  }
  
  @NonNull
  public WindowInsetsCompat consumeStableInsets()
  {
    return this.mImpl.consumeStableInsets();
  }
  
  @NonNull
  public WindowInsetsCompat consumeSystemWindowInsets()
  {
    return this.mImpl.consumeSystemWindowInsets();
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
    return ObjectsCompat.equals(this.mImpl, paramObject.mImpl);
  }
  
  @Nullable
  public DisplayCutoutCompat getDisplayCutout()
  {
    return this.mImpl.getDisplayCutout();
  }
  
  @NonNull
  public Insets getMandatorySystemGestureInsets()
  {
    return this.mImpl.getMandatorySystemGestureInsets();
  }
  
  public int getStableInsetBottom()
  {
    return getStableInsets().bottom;
  }
  
  public int getStableInsetLeft()
  {
    return getStableInsets().left;
  }
  
  public int getStableInsetRight()
  {
    return getStableInsets().right;
  }
  
  public int getStableInsetTop()
  {
    return getStableInsets().top;
  }
  
  @NonNull
  public Insets getStableInsets()
  {
    return this.mImpl.getStableInsets();
  }
  
  @NonNull
  public Insets getSystemGestureInsets()
  {
    return this.mImpl.getSystemGestureInsets();
  }
  
  public int getSystemWindowInsetBottom()
  {
    return getSystemWindowInsets().bottom;
  }
  
  public int getSystemWindowInsetLeft()
  {
    return getSystemWindowInsets().left;
  }
  
  public int getSystemWindowInsetRight()
  {
    return getSystemWindowInsets().right;
  }
  
  public int getSystemWindowInsetTop()
  {
    return getSystemWindowInsets().top;
  }
  
  @NonNull
  public Insets getSystemWindowInsets()
  {
    return this.mImpl.getSystemWindowInsets();
  }
  
  @NonNull
  public Insets getTappableElementInsets()
  {
    return this.mImpl.getTappableElementInsets();
  }
  
  public boolean hasInsets()
  {
    return (hasSystemWindowInsets()) || (hasStableInsets()) || (getDisplayCutout() != null) || (!getSystemGestureInsets().equals(Insets.NONE)) || (!getMandatorySystemGestureInsets().equals(Insets.NONE)) || (!getTappableElementInsets().equals(Insets.NONE));
  }
  
  public boolean hasStableInsets()
  {
    return getStableInsets().equals(Insets.NONE) ^ true;
  }
  
  public boolean hasSystemWindowInsets()
  {
    return getSystemWindowInsets().equals(Insets.NONE) ^ true;
  }
  
  public int hashCode()
  {
    WindowInsetsCompat.Impl localImpl = this.mImpl;
    if (localImpl == null) {
      return 0;
    }
    return localImpl.hashCode();
  }
  
  @NonNull
  public WindowInsetsCompat inset(@IntRange(from=0L) int paramInt1, @IntRange(from=0L) int paramInt2, @IntRange(from=0L) int paramInt3, @IntRange(from=0L) int paramInt4)
  {
    return this.mImpl.inset(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @NonNull
  public WindowInsetsCompat inset(@NonNull Insets paramInsets)
  {
    return inset(paramInsets.left, paramInsets.top, paramInsets.right, paramInsets.bottom);
  }
  
  public boolean isConsumed()
  {
    return this.mImpl.isConsumed();
  }
  
  public boolean isRound()
  {
    return this.mImpl.isRound();
  }
  
  @Deprecated
  @NonNull
  public WindowInsetsCompat replaceSystemWindowInsets(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new WindowInsetsCompat.Builder(this).setSystemWindowInsets(Insets.of(paramInt1, paramInt2, paramInt3, paramInt4)).build();
  }
  
  @Deprecated
  @NonNull
  public WindowInsetsCompat replaceSystemWindowInsets(@NonNull Rect paramRect)
  {
    return new WindowInsetsCompat.Builder(this).setSystemWindowInsets(Insets.of(paramRect)).build();
  }
  
  @Nullable
  @RequiresApi(20)
  public WindowInsets toWindowInsets()
  {
    WindowInsetsCompat.Impl localImpl = this.mImpl;
    if ((localImpl instanceof WindowInsetsCompat.Impl20)) {
      return ((WindowInsetsCompat.Impl20)localImpl).mPlatformInsets;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.WindowInsetsCompat
 * JD-Core Version:    0.7.0.1
 */