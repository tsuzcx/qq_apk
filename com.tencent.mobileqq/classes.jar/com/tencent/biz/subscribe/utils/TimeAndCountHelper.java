package com.tencent.biz.subscribe.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import mqq.app.AppRuntime;

public class TimeAndCountHelper
{
  private static volatile TimeAndCountHelper jdField_a_of_type_ComTencentBizSubscribeUtilsTimeAndCountHelper;
  private Map<String, Timer> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static TimeAndCountHelper a()
  {
    if (jdField_a_of_type_ComTencentBizSubscribeUtilsTimeAndCountHelper == null) {
      try
      {
        if (jdField_a_of_type_ComTencentBizSubscribeUtilsTimeAndCountHelper == null) {
          jdField_a_of_type_ComTencentBizSubscribeUtilsTimeAndCountHelper = new TimeAndCountHelper();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentBizSubscribeUtilsTimeAndCountHelper;
  }
  
  private String a(String paramString)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  private void a(Context paramContext, String paramString, TimeAndCountHelper.CountResult paramCountResult)
  {
    paramContext = SubscribeSpUtil.a(paramContext);
    if (paramContext != null)
    {
      int i = paramContext.getInt(a(paramString), 0);
      if (paramCountResult != null) {
        paramCountResult.a(i + 1);
      }
    }
  }
  
  public int a(Context paramContext, String paramString)
  {
    return SubscribeSpUtil.a(paramContext).getInt(a(paramString), 0);
  }
  
  @SuppressLint({"NewApi"})
  public void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = SubscribeSpUtil.a(paramContext);
    SharedPreferences.Editor localEditor = paramContext.edit();
    paramString = a(paramString);
    localEditor.putInt(paramString, paramContext.getInt(paramString, 0) + paramInt);
    localEditor.apply();
  }
  
  public void a(Context paramContext, String paramString, int paramInt, TimeAndCountHelper.CountResult paramCountResult)
  {
    if (paramInt > 0)
    {
      a(paramString);
      Timer localTimer = new Timer();
      localTimer.schedule(new TimeAndCountHelper.1(this, paramContext, paramString, paramCountResult), paramInt);
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localTimer);
      return;
    }
    a(paramContext, paramString, paramCountResult);
  }
  
  public void a(String paramString)
  {
    Timer localTimer = (Timer)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localTimer != null)
    {
      localTimer.cancel();
      localTimer.purge();
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.TimeAndCountHelper
 * JD-Core Version:    0.7.0.1
 */