package com.tencent.common.app;

import android.content.SharedPreferences;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager.IAdapter;

class BaseApplicationImpl$4
  implements SharedPreferencesProxyManager.IAdapter
{
  BaseApplicationImpl$4(BaseApplicationImpl paramBaseApplicationImpl) {}
  
  public SharedPreferences getSystemSharedPreferences(String paramString, int paramInt)
  {
    return this.this$0.getSystemSharedPreferences(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.BaseApplicationImpl.4
 * JD-Core Version:    0.7.0.1
 */