package com.tencent.hippy.qq.update;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;

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
    if (INSTANCE == null) {
      try
      {
        if (INSTANCE == null) {
          INSTANCE = new UpdateSetting();
        }
      }
      finally {}
    }
    return INSTANCE;
  }
  
  private void initSharedPreferences()
  {
    this.mSharedPreferences = MobileQQ.getContext().getSharedPreferences("hippyConfig", 4);
  }
  
  public Map<String, Integer> getAllModuleVersion()
  {
    if (this.mSharedPreferences == null) {
      initSharedPreferences();
    }
    HashMap localHashMap = new HashMap();
    Object localObject = this.mSharedPreferences;
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).getAll();
      Iterator localIterator = ((Map)localObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((((Map)localObject).get(str) instanceof Integer)) {
          localHashMap.put(str, (Integer)((Map)localObject).get(str));
        }
      }
    }
    return localHashMap;
  }
  
  public boolean getCDNUpdateFlag()
  {
    if (this.mSharedPreferences == null) {
      initSharedPreferences();
    }
    SharedPreferences localSharedPreferences = this.mSharedPreferences;
    boolean bool = false;
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("cdnUpdate", false);
    }
    return bool;
  }
  
  public int getModuleVersion(String paramString)
  {
    if (this.mSharedPreferences == null) {
      initSharedPreferences();
    }
    SharedPreferences localSharedPreferences = this.mSharedPreferences;
    int i;
    if (localSharedPreferences != null) {
      i = localSharedPreferences.getInt(paramString, -1);
    } else {
      i = -1;
    }
    int j = i;
    if (i != -1)
    {
      j = i;
      if (!HippyQQFileUtil.getModuleIndex(paramString, i).exists())
      {
        localSharedPreferences = this.mSharedPreferences;
        if (localSharedPreferences != null) {
          localSharedPreferences.edit().putInt(paramString, -1).commit();
        }
        j = -1;
      }
    }
    return j;
  }
  
  public boolean isModuleVersionFileExists(String paramString, int paramInt)
  {
    if (this.mSharedPreferences == null) {
      initSharedPreferences();
    }
    boolean bool2 = false;
    if (paramInt < 0) {
      return false;
    }
    paramString = HippyQQFileUtil.getModuleIndex(paramString, paramInt);
    boolean bool1 = bool2;
    if (paramString.exists())
    {
      bool1 = bool2;
      if (paramString.length() > 0L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void setCDNUpdateFlag(boolean paramBoolean)
  {
    if (this.mSharedPreferences == null) {
      initSharedPreferences();
    }
    SharedPreferences localSharedPreferences = this.mSharedPreferences;
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("cdnUpdate", paramBoolean).apply();
    }
  }
  
  public void setModuleVersion(String paramString, int paramInt)
  {
    if (this.mSharedPreferences == null) {
      initSharedPreferences();
    }
    SharedPreferences localSharedPreferences = this.mSharedPreferences;
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt(paramString, paramInt).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.UpdateSetting
 * JD-Core Version:    0.7.0.1
 */