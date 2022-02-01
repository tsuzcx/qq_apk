package com.tencent.mobileqq.abtest;

import adhi;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import bctj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mtt.abtestsdk.ABTestApi;
import com.tencent.mtt.abtestsdk.entity.ABTestConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public final class ABTestController
{
  private static ABTestController jdField_a_of_type_ComTencentMobileqqAbtestABTestController = new ABTestController();
  private LruCache<String, adhi> jdField_a_of_type_AndroidUtilLruCache;
  private bctj jdField_a_of_type_Bctj;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static ABTestController a()
  {
    return jdField_a_of_type_ComTencentMobileqqAbtestABTestController;
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ABTestController", 2, paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public adhi a(@NonNull String paramString)
  {
    Object localObject;
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject = BaseApplicationImpl.getApplication();
      a((BaseApplicationImpl)localObject, ((BaseApplicationImpl)localObject).getRuntime().getAccount());
    }
    String str = paramString.trim();
    paramString = (adhi)this.jdField_a_of_type_AndroidUtilLruCache.get(str);
    if (paramString != null) {}
    do
    {
      return paramString;
      localObject = new adhi(str);
      paramString = (String)localObject;
    } while (!((adhi)localObject).a());
    this.jdField_a_of_type_AndroidUtilLruCache.put(str, localObject);
    return localObject;
  }
  
  public void a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    a("ABTestController, only available in debug version.");
    if (TextUtils.isEmpty(paramString)) {}
    for (Object localObject = paramBaseApplicationImpl.getRuntime().getAccount();; localObject = paramString)
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      this.jdField_a_of_type_AndroidUtilLruCache = new LruCache(20);
      this.jdField_a_of_type_Bctj = bctj.a(paramBaseApplicationImpl);
      a("start initialize ABTestApi SDK, uinAccount:" + paramString);
      long l = System.currentTimeMillis();
      localObject = new ABTestConfig();
      ((ABTestConfig)localObject).setEnv("RELEASE");
      ((ABTestConfig)localObject).setAppId("505");
      ((ABTestConfig)localObject).setAppKey("e8c0653fea13f91bf3c48159f7c24f78");
      ((ABTestConfig)localObject).setPlatform("android");
      ((ABTestConfig)localObject).setGuid(paramString);
      ABTestApi.init(paramBaseApplicationImpl, (ABTestConfig)localObject);
      this.jdField_a_of_type_Boolean = true;
      a("ABTestController", "abtest api init cost:" + (System.currentTimeMillis() - l));
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, ABTestController.EvtType paramEvtType, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("eventUserId", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("eventGrayId", paramString2);
    localHashMap.put("layerName", paramString1);
    localHashMap.put("eventType", paramEvtType.name());
    localHashMap.put("eventName", paramString3);
    a("report AbtestEvtExpose:" + localHashMap.toString());
    this.jdField_a_of_type_Bctj.a(this.jdField_a_of_type_JavaLangString, "AbtestEvtExpose", true, 0L, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.abtest.ABTestController
 * JD-Core Version:    0.7.0.1
 */