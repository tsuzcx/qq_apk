package com.tencent.component.utils.preference;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import java.util.Map;
import java.util.Set;
import ply;

public class SharedPreferencesWrapper
  implements SharedPreferences
{
  private final SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private final ply jdField_a_of_type_Ply;
  
  public SharedPreferencesWrapper(SharedPreferences paramSharedPreferences, ply paramply)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramSharedPreferences;
    this.jdField_a_of_type_Ply = paramply;
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (this.jdField_a_of_type_Ply != null) {
      str = this.jdField_a_of_type_Ply.a(paramString);
    }
    return str;
  }
  
  public final SharedPreferences a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  public final ply a()
  {
    return this.jdField_a_of_type_Ply;
  }
  
  public boolean contains(String paramString)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.contains(a(paramString));
  }
  
  public SharedPreferences.Editor edit()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
  }
  
  public Map getAll()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getAll();
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(a(paramString), paramBoolean);
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getFloat(a(paramString), paramFloat);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(a(paramString), paramInt);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(a(paramString), paramLong);
  }
  
  public String getString(String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString(a(paramString1), paramString2);
  }
  
  @SuppressLint({"NewApi"})
  public Set getStringSet(String paramString, Set paramSet)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getStringSet(a(paramString), paramSet);
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.registerOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.unregisterOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.component.utils.preference.SharedPreferencesWrapper
 * JD-Core Version:    0.7.0.1
 */