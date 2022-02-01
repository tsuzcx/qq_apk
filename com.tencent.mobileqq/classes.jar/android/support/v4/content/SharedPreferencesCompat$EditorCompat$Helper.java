package android.support.v4.content;

import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;

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
      paramEditor.commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.content.SharedPreferencesCompat.EditorCompat.Helper
 * JD-Core Version:    0.7.0.1
 */