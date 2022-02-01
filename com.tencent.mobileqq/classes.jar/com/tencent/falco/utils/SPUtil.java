package com.tencent.falco.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class SPUtil
{
  private static final String DEFAULT = "default";
  private SharedPreferences.Editor editor;
  private boolean isApplyMode = false;
  private SharedPreferences sharedPreferences;
  
  private SPUtil(Context paramContext, String paramString)
  {
    if ("default".equals(paramString)) {
      this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    } else {
      this.sharedPreferences = paramContext.getSharedPreferences(paramString, 0);
    }
    this.editor = this.sharedPreferences.edit();
  }
  
  public static SPUtil get(Context paramContext, String paramString)
  {
    return new SPUtil(paramContext, paramString);
  }
  
  private void save()
  {
    if (this.isApplyMode)
    {
      this.editor.apply();
      return;
    }
    this.editor.commit();
  }
  
  public SPUtil applyMode()
  {
    this.isApplyMode = true;
    return this;
  }
  
  public void clear()
  {
    this.editor.clear();
    save();
  }
  
  public void commit()
  {
    this.editor.commit();
  }
  
  public void delete(String paramString)
  {
    this.editor.remove(paramString);
    save();
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return this.sharedPreferences.getBoolean(paramString, paramBoolean);
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    return this.sharedPreferences.getFloat(paramString, paramFloat);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return this.sharedPreferences.getInt(paramString, paramInt);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    return this.sharedPreferences.getLong(paramString, paramLong);
  }
  
  public String getString(String paramString1, String paramString2)
  {
    return this.sharedPreferences.getString(paramString1, paramString2);
  }
  
  public SPUtil putBoolean(String paramString, boolean paramBoolean)
  {
    this.editor.putBoolean(paramString, paramBoolean);
    save();
    return this;
  }
  
  public SPUtil putFloat(String paramString, float paramFloat)
  {
    this.editor.putFloat(paramString, paramFloat);
    save();
    return this;
  }
  
  public SPUtil putInt(String paramString, int paramInt)
  {
    this.editor.putInt(paramString, paramInt);
    save();
    return this;
  }
  
  public SPUtil putLong(String paramString, long paramLong)
  {
    this.editor.putLong(paramString, paramLong);
    save();
    return this;
  }
  
  public SPUtil putString(String paramString1, String paramString2)
  {
    this.editor.putString(paramString1, paramString2);
    save();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.utils.SPUtil
 * JD-Core Version:    0.7.0.1
 */