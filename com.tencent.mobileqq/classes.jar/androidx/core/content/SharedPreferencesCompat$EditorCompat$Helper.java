package androidx.core.content;

import android.content.SharedPreferences.Editor;
import androidx.annotation.NonNull;

class SharedPreferencesCompat$EditorCompat$Helper
{
  public void apply(@NonNull SharedPreferences.Editor paramEditor)
  {
    try
    {
      paramEditor.apply();
      return;
    }
    catch (AbstractMethodError localAbstractMethodError)
    {
      label7:
      break label7;
    }
    paramEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.content.SharedPreferencesCompat.EditorCompat.Helper
 * JD-Core Version:    0.7.0.1
 */