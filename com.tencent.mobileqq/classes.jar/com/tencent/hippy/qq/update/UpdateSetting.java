package com.tencent.hippy.qq.update;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UpdateSetting
{
  static volatile UpdateSetting INSTANCE;
  SharedPreferences mSharedPreferences;
  
  private UpdateSetting()
  {
    initSharedPreferences();
  }
  
  public static UpdateSetting getInstance()
  {
    if (INSTANCE == null) {}
    try
    {
      if (INSTANCE == null) {
        INSTANCE = new UpdateSetting();
      }
      return INSTANCE;
    }
    finally {}
  }
  
  private void initSharedPreferences()
  {
    this.mSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("hippyConfig", 4);
  }
  
  public Map<String, Integer> getAllModuleVersion()
  {
    if (this.mSharedPreferences == null) {
      initSharedPreferences();
    }
    HashMap localHashMap = new HashMap();
    if (this.mSharedPreferences != null)
    {
      Map localMap = this.mSharedPreferences.getAll();
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((localMap.get(str) instanceof Integer)) {
          localHashMap.put(str, (Integer)localMap.get(str));
        }
      }
    }
    return localHashMap;
  }
  
  public boolean getCDNUpdateFlag()
  {
    boolean bool = false;
    if (this.mSharedPreferences == null) {
      initSharedPreferences();
    }
    if (this.mSharedPreferences != null) {
      bool = this.mSharedPreferences.getBoolean("cdnUpdate", false);
    }
    return bool;
  }
  
  public int getModuleVersion(String paramString)
  {
    if (this.mSharedPreferences == null) {
      initSharedPreferences();
    }
    if (this.mSharedPreferences != null) {}
    for (int i = this.mSharedPreferences.getInt(paramString, -1);; i = -1)
    {
      if ((i != -1) && (!HippyQQFileUtil.getModuleIndex(paramString, i).exists()))
      {
        if (this.mSharedPreferences != null) {
          this.mSharedPreferences.edit().putInt(paramString, -1);
        }
        return -1;
      }
      return i;
    }
  }
  
  public boolean isModuleVersionFileExists(String paramString, int paramInt)
  {
    if (this.mSharedPreferences == null) {
      initSharedPreferences();
    }
    if (paramInt < 0) {}
    do
    {
      return false;
      paramString = HippyQQFileUtil.getModuleIndex(paramString, paramInt);
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return true;
  }
  
  public void setCDNUpdateFlag(boolean paramBoolean)
  {
    if (this.mSharedPreferences == null) {
      initSharedPreferences();
    }
    if (this.mSharedPreferences != null) {
      this.mSharedPreferences.edit().putBoolean("cdnUpdate", paramBoolean).apply();
    }
  }
  
  public void setModuleVersion(String paramString, int paramInt)
  {
    if (this.mSharedPreferences == null) {
      initSharedPreferences();
    }
    if (this.mSharedPreferences != null) {
      this.mSharedPreferences.edit().putInt(paramString, paramInt).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.update.UpdateSetting
 * JD-Core Version:    0.7.0.1
 */