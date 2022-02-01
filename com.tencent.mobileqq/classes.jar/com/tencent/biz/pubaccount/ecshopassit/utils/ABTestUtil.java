package com.tencent.biz.pubaccount.ecshopassit.utils;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.ABTestInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ABTestUtil
{
  private static final String[] a = { "exp_qqshop_tabbar" };
  
  public static ABTestInfo a(String paramString)
  {
    return (ABTestInfo)a().get(paramString);
  }
  
  public static Map<String, ABTestInfo> a()
  {
    HashMap localHashMap = new HashMap();
    try
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (localObject != null)
      {
        localObject = SharedPreferencesUtil.a((AppRuntime)localObject, "ab_test_info_" + ((AppRuntime)localObject).getAccount());
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          a(localHashMap, (String)localObject);
        }
      }
      return localHashMap;
    }
    catch (Exception localException)
    {
      QLog.e("Ecshop_ABTestUtil", 1, localException, new Object[0]);
    }
    return localHashMap;
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    AppRuntime localAppRuntime;
    do
    {
      return;
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    } while (localAppRuntime == null);
    SharedPreferencesUtil.a(localAppRuntime, "ab_test_info_" + localAppRuntime.getAccount(), paramString);
  }
  
  private static void a(Map<String, ABTestInfo> paramMap, String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("MBucketTest");
      String[] arrayOfString = a;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        paramMap.put(str, ABTestInfo.a(paramString.optJSONObject(str)));
        i += 1;
      }
      return;
    }
    catch (Exception paramMap)
    {
      QLog.e("Ecshop_ABTestUtil", 1, paramMap, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.utils.ABTestUtil
 * JD-Core Version:    0.7.0.1
 */