package androidx.core.view;

import android.graphics.Rect;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class ViewCompat$Api21Impl
{
  static WindowInsetsCompat computeSystemWindowInsets(@NonNull View paramView, @NonNull WindowInsetsCompat paramWindowInsetsCompat, @NonNull Rect paramRect)
  {
    WindowInsets localWindowInsets = paramWindowInsetsCompat.toWindowInsets();
    if (localWindowInsets != null) {
      return WindowInsetsCompat.toWindowInsetsCompat(paramView.computeSystemWindowInsets(localWindowInsets, paramRect));
    }
    paramRect.setEmpty();
    return paramWindowInsetsCompat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.ViewCompat.Api21Impl
 * JD-Core Version:    0.7.0.1
 */