package androidx.core.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;

class WindowInsetsCompat$Impl
{
  final WindowInsetsCompat mHost;
  
  WindowInsetsCompat$Impl(@NonNull WindowInsetsCompat paramWindowInsetsCompat)
  {
    this.mHost = paramWindowInsetsCompat;
  }
  
  @NonNull
  WindowInsetsCompat consumeDisplayCutout()
  {
    return this.mHost;
  }
  
  @NonNull
  WindowInsetsCompat consumeStableInsets()
  {
    return this.mHost;
  }
  
  @NonNull
  WindowInsetsCompat consumeSystemWindowInsets()
  {
    return this.mHost;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Impl)) {
      return false;
    }
    paramObject = (Impl)paramObject;
    return (isRound() == paramObject.isRound()) && (isConsumed() == paramObject.isConsumed()) && (ObjectsCompat.equals(getSystemWindowInsets(), paramObject.getSystemWindowInsets())) && (ObjectsCompat.equals(getStableInsets(), paramObject.getStableInsets())) && (ObjectsCompat.equals(getDisplayCutout(), paramObject.getDisplayCutout()));
  }
  
  @Nullable
  DisplayCutoutCompat getDisplayCutout()
  {
    return null;
  }
  
  @NonNull
  Insets getMandatorySystemGestureInsets()
  {
    return getSystemWindowInsets();
  }
  
  @NonNull
  Insets getStableInsets()
  {
    return Insets.NONE;
  }
  
  @NonNull
  Insets getSystemGestureInsets()
  {
    return getSystemWindowInsets();
  }
  
  @NonNull
  Insets getSystemWindowInsets()
  {
    return Insets.NONE;
  }
  
  @NonNull
  Insets getTappableElementInsets()
  {
    return getSystemWindowInsets();
  }
  
  public int hashCode()
  {
    return ObjectsCompat.hash(new Object[] { Boolean.valueOf(isRound()), Boolean.valueOf(isConsumed()), getSystemWindowInsets(), getStableInsets(), getDisplayCutout() });
  }
  
  @NonNull
  WindowInsetsCompat inset(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return WindowInsetsCompat.CONSUMED;
  }
  
  boolean isConsumed()
  {
    return false;
  }
  
  boolean isRound()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.WindowInsetsCompat.Impl
 * JD-Core Version:    0.7.0.1
 */