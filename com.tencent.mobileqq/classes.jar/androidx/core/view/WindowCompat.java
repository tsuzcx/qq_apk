package androidx.core.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;

public final class WindowCompat
{
  public static final int FEATURE_ACTION_BAR = 8;
  public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
  public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
  
  @NonNull
  public static <T extends View> T requireViewById(@NonNull Window paramWindow, @IdRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramWindow.requireViewById(paramInt);
    }
    paramWindow = paramWindow.findViewById(paramInt);
    if (paramWindow != null) {
      return paramWindow;
    }
    throw new IllegalArgumentException("ID does not reference a View inside this Window");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.WindowCompat
 * JD-Core Version:    0.7.0.1
 */