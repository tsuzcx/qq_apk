package androidx.core.content.res;

import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;

public final class ResourcesCompat$ThemeCompat
{
  public static void rebase(@NonNull Resources.Theme paramTheme)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      ResourcesCompat.ThemeCompat.ImplApi29.rebase(paramTheme);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      ResourcesCompat.ThemeCompat.ImplApi23.rebase(paramTheme);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.content.res.ResourcesCompat.ThemeCompat
 * JD-Core Version:    0.7.0.1
 */