package com.tencent.hippy.qq.update;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

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
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (localBaseApplication != null) {
      this.mSharedPreferences = localBaseApplication.getSharedPreferences("hippyConfig", 0);
    }
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
    int i = -1;
    if (this.mSharedPreferences == null) {
      initSharedPreferences();
    }
    if (this.mSharedPreferences != null) {
      i = this.mSharedPreferences.getInt(paramString, -1);
    }
    return i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.update.UpdateSetting
 * JD-Core Version:    0.7.0.1
 */