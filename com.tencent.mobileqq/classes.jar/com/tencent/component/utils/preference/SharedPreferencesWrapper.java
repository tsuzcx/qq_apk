package com.tencent.component.utils.preference;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import java.util.Map;
import java.util.Set;

public class SharedPreferencesWrapper
  implements SharedPreferences
{
  private final KeyGenerator mKeyGenerator;
  private final SharedPreferences mWrappedPreferences;
  
  public SharedPreferencesWrapper(SharedPreferences paramSharedPreferences)
  {
    this(paramSharedPreferences, null);
  }
  
  public SharedPreferencesWrapper(SharedPreferences paramSharedPreferences, KeyGenerator paramKeyGenerator)
  {
    this.mWrappedPreferences = paramSharedPreferences;
    this.mKeyGenerator = paramKeyGenerator;
  }
  
  private String generateKey(String paramString)
  {
    KeyGenerator localKeyGenerator = this.mKeyGenerator;
    String str = paramString;
    if (localKeyGenerator != null) {
      str = localKeyGenerator.generate(paramString);
    }
    return str;
  }
  
  public boolean contains(String paramString)
  {
    return this.mWrappedPreferences.contains(generateKey(paramString));
  }
  
  public SharedPreferences.Editor edit()
  {
    return this.mWrappedPreferences.edit();
  }
  
  public Map<String, ?> getAll()
  {
    return this.mWrappedPreferences.getAll();
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return this.mWrappedPreferences.getBoolean(generateKey(paramString), paramBoolean);
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    return this.mWrappedPreferences.getFloat(generateKey(paramString), paramFloat);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return this.mWrappedPreferences.getInt(generateKey(paramString), paramInt);
  }
  
  public final KeyGenerator getKeyGenerator()
  {
    return this.mKeyGenerator;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    return this.mWrappedPreferences.getLong(generateKey(paramString), paramLong);
  }
  
  public String getString(String paramString1, String paramString2)
  {
    return this.mWrappedPreferences.getString(generateKey(paramString1), paramString2);
  }
  
  @SuppressLint({"NewApi"})
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    return this.mWrappedPreferences.getStringSet(generateKey(paramString), paramSet);
  }
  
  public final SharedPreferences getWrappedSharedPreferences()
  {
    return this.mWrappedPreferences;
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    this.mWrappedPreferences.registerOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    this.mWrappedPreferences.unregisterOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.utils.preference.SharedPreferencesWrapper
 * JD-Core Version:    0.7.0.1
 */