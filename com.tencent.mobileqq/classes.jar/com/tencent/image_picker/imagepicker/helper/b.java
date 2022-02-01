package com.tencent.image_picker.imagepicker.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class b
{
  private Context a;
  
  public b(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void a(String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.a).edit();
    localEditor.putBoolean(paramString, true);
    localEditor.apply();
  }
  
  public boolean b(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(this.a).getBoolean(paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image_picker.imagepicker.helper.b
 * JD-Core Version:    0.7.0.1
 */