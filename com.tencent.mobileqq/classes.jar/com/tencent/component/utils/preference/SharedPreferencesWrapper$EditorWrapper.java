package com.tencent.component.utils.preference;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;
import java.util.Set;

class SharedPreferencesWrapper$EditorWrapper
  implements SharedPreferences.Editor
{
  private final KeyGenerator mKeyGenerator;
  private final SharedPreferences.Editor mWrappedEditor;
  
  public SharedPreferencesWrapper$EditorWrapper(SharedPreferences.Editor paramEditor)
  {
    this(paramEditor, null);
  }
  
  public SharedPreferencesWrapper$EditorWrapper(SharedPreferences.Editor paramEditor, KeyGenerator paramKeyGenerator)
  {
    this.mWrappedEditor = paramEditor;
    this.mKeyGenerator = paramKeyGenerator;
  }
  
  private String generateKey(String paramString)
  {
    KeyGenerator localKeyGenerator = this.mKeyGenerator;
    if (localKeyGenerator != null) {
      return localKeyGenerator.generate(paramString);
    }
    return null;
  }
  
  @SuppressLint({"NewApi"})
  public void apply()
  {
    this.mWrappedEditor.apply();
  }
  
  public SharedPreferences.Editor clear()
  {
    this.mWrappedEditor.clear();
    return this;
  }
  
  public boolean commit()
  {
    return this.mWrappedEditor.commit();
  }
  
  public final KeyGenerator getKeyGenerator()
  {
    return this.mKeyGenerator;
  }
  
  public final SharedPreferences.Editor getWrappedEditor()
  {
    return this.mWrappedEditor;
  }
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    this.mWrappedEditor.putBoolean(generateKey(paramString), paramBoolean);
    return this;
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    this.mWrappedEditor.putFloat(generateKey(paramString), paramFloat);
    return this;
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    this.mWrappedEditor.putInt(generateKey(paramString), paramInt);
    return this;
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    this.mWrappedEditor.putLong(generateKey(paramString), paramLong);
    return this;
  }
  
  public SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    this.mWrappedEditor.putString(generateKey(paramString1), paramString2);
    return this;
  }
  
  @SuppressLint({"NewApi"})
  public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
  {
    this.mWrappedEditor.putStringSet(generateKey(paramString), paramSet);
    return this;
  }
  
  public SharedPreferences.Editor remove(String paramString)
  {
    this.mWrappedEditor.remove(generateKey(paramString));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.utils.preference.SharedPreferencesWrapper.EditorWrapper
 * JD-Core Version:    0.7.0.1
 */