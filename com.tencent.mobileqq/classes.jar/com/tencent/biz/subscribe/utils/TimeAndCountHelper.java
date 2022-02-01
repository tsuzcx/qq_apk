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
  private static volatile TimeAndCountHelper a;
  private Map<String, Timer> b = new HashMap();
  
  public static TimeAndCountHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new TimeAndCountHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(Context paramContext, String paramString, TimeAndCountHelper.CountResult paramCountResult)
  {
    paramContext = SubscribeSpUtil.a(paramContext);
    if (paramContext != null)
    {
      int i = paramContext.getInt(b(paramString), 0);
      if (paramCountResult != null) {
        paramCountResult.a(i + 1);
      }
    }
  }
  
  private String b(String paramString)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public int a(Context paramContext, String paramString)
  {
    return SubscribeSpUtil.a(paramContext).getInt(b(paramString), 0);
  }
  
  @SuppressLint({"NewApi"})
  public void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = SubscribeSpUtil.a(paramContext);
    SharedPreferences.Editor localEditor = paramContext.edit();
    paramString = b(paramString);
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
      this.b.put(paramString, localTimer);
      return;
    }
    a(paramContext, paramString, paramCountResult);
  }
  
  public void a(String paramString)
  {
    Timer localTimer = (Timer)this.b.get(paramString);
    if (localTimer != null)
    {
      localTimer.cancel();
      localTimer.purge();
      this.b.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.TimeAndCountHelper
 * JD-Core Version:    0.7.0.1
 */