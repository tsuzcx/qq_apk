package com.tencent.mobileqq.activity.qwallet.preload;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;

public class ResDownRecordUtil
{
  public static int a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = a();
    int i = paramInt;
    if (localSharedPreferences != null)
    {
      i = paramInt;
      if (!TextUtils.isEmpty(paramString)) {
        i = localSharedPreferences.getInt("url_down_scene" + paramString, paramInt);
      }
    }
    return i;
  }
  
  private static SharedPreferences a()
  {
    if (BaseApplicationImpl.getApplication() != null) {
      return BaseApplicationImpl.getApplication().getSharedPreferences("qwallet_res_down_record_util", 4);
    }
    return null;
  }
  
  public static void a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = a();
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString))) {
      localSharedPreferences.edit().putInt("url_down_scene" + paramString, paramInt).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.ResDownRecordUtil
 * JD-Core Version:    0.7.0.1
 */