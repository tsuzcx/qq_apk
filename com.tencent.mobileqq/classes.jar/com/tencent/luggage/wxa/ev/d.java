package com.tencent.luggage.wxa.ev;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.w;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class d
  implements SharedPreferences, SharedPreferences.Editor
{
  w a;
  
  public d(w paramw)
  {
    this.a = paramw;
  }
  
  public void apply()
  {
    this.a.apply();
  }
  
  public SharedPreferences.Editor clear()
  {
    return this.a.clear();
  }
  
  public boolean commit()
  {
    return this.a.commit();
  }
  
  public boolean contains(String paramString)
  {
    return this.a.contains(paramString);
  }
  
  public SharedPreferences.Editor edit()
  {
    return this.a.edit();
  }
  
  public Map<String, ?> getAll()
  {
    HashMap localHashMap = new HashMap();
    String[] arrayOfString = this.a.f();
    if (arrayOfString == null) {
      return localHashMap;
    }
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localHashMap.put(arrayOfString[i], "");
      i += 1;
    }
    return localHashMap;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return this.a.getBoolean(paramString, paramBoolean);
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    return this.a.getFloat(paramString, paramFloat);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return this.a.getInt(paramString, paramInt);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    return this.a.getLong(paramString, paramLong);
  }
  
  @Nullable
  public String getString(String paramString1, @Nullable String paramString2)
  {
    return this.a.getString(paramString1, paramString2);
  }
  
  @Nullable
  public Set<String> getStringSet(String paramString, @Nullable Set<String> paramSet)
  {
    return this.a.getStringSet(paramString, paramSet);
  }
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    return this.a.putBoolean(paramString, paramBoolean);
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    return this.a.putFloat(paramString, paramFloat);
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    return this.a.putInt(paramString, paramInt);
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    return this.a.putLong(paramString, paramLong);
  }
  
  public SharedPreferences.Editor putString(String paramString1, @Nullable String paramString2)
  {
    return this.a.putString(paramString1, paramString2);
  }
  
  public SharedPreferences.Editor putStringSet(String paramString, @Nullable Set<String> paramSet)
  {
    return this.a.putStringSet(paramString, paramSet);
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    this.a.registerOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
  
  public SharedPreferences.Editor remove(String paramString)
  {
    return this.a.remove(paramString);
  }
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    this.a.unregisterOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ev.d
 * JD-Core Version:    0.7.0.1
 */