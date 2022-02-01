package androidx.core.content;

import android.content.SharedPreferences.Editor;
import androidx.annotation.NonNull;

@Deprecated
public final class SharedPreferencesCompat$EditorCompat
{
  private static EditorCompat sInstance;
  private final SharedPreferencesCompat.EditorCompat.Helper mHelper = new SharedPreferencesCompat.EditorCompat.Helper();
  
  @Deprecated
  public static EditorCompat getInstance()
  {
    if (sInstance == null) {
      sInstance = new EditorCompat();
    }
    return sInstance;
  }
  
  @Deprecated
  public void apply(@NonNull SharedPreferences.Editor paramEditor)
  {
    this.mHelper.apply(paramEditor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.content.SharedPreferencesCompat.EditorCompat
 * JD-Core Version:    0.7.0.1
 */