package androidx.core.content;

import android.content.Intent;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;

public final class IntentCompat
{
  public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
  public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
  public static final String EXTRA_START_PLAYBACK = "android.intent.extra.START_PLAYBACK";
  
  @NonNull
  public static Intent makeMainSelectorActivity(@NonNull String paramString1, @NonNull String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 15) {
      return Intent.makeMainSelectorActivity(paramString1, paramString2);
    }
    paramString1 = new Intent(paramString1);
    paramString1.addCategory(paramString2);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.content.IntentCompat
 * JD-Core Version:    0.7.0.1
 */