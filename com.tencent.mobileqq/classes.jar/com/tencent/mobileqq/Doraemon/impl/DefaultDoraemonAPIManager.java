package com.tencent.mobileqq.Doraemon.impl;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIConfig;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.UserPermission;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule;
import com.tencent.mobileqq.Doraemon.manifest.D.manifest.common_apis;
import com.tencent.mobileqq.miniapp.MiniAppInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class DefaultDoraemonAPIManager
  extends DoraemonAPIManager
{
  public MiniAppInfo a;
  private String jdField_c_of_type_JavaLangString = "doraemon_user_permission_" + BaseApplicationImpl.getApplication().getRuntime().getAccount();
  private Map<String, Integer> jdField_c_of_type_JavaUtilMap = new HashMap();
  private String d;
  private String e;
  private String f;
  
  public DefaultDoraemonAPIManager(Activity paramActivity, int paramInt, String paramString)
  {
    super(paramActivity, paramInt, paramString);
  }
  
  private int a(UserPermission paramUserPermission)
  {
    Integer localInteger2 = (Integer)this.jdField_c_of_type_JavaUtilMap.get(paramUserPermission.jdField_a_of_type_JavaLangString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      if (BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_c_of_type_JavaLangString, 4).getLong(this.b + "_" + paramUserPermission.jdField_a_of_type_JavaLangString + "_2", 0L) <= NetConnInfoCenter.getServerTimeMillis()) {
        break label106;
      }
    }
    label106:
    for (localInteger1 = Integer.valueOf(2);; localInteger1 = Integer.valueOf(0))
    {
      this.jdField_c_of_type_JavaUtilMap.put(paramUserPermission.jdField_a_of_type_JavaLangString, localInteger1);
      return localInteger1.intValue();
    }
  }
  
  private void a(UserPermission paramUserPermission, int paramInt)
  {
    if (2 == paramInt)
    {
      long l = NetConnInfoCenter.getServerTimeMillis();
      BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_c_of_type_JavaLangString, 4).edit().putLong(this.b + "_" + paramUserPermission.jdField_a_of_type_JavaLangString + "_2", l + 2592000000L).apply();
    }
    this.jdField_c_of_type_JavaUtilMap.put(paramUserPermission.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt));
  }
  
  public MiniAppInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo;
  }
  
  public String a()
  {
    if (this.e == null) {
      return MobileQQ.getContext().getPackageName();
    }
    return this.e;
  }
  
  public Map<String, APIConfig> a()
  {
    return D.manifest.common_apis.a();
  }
  
  public void a(APIConfig paramAPIConfig, JSONObject paramJSONObject, APICallback paramAPICallback)
  {
    UserPermission localUserPermission;
    Object localObject2;
    Object localObject1;
    switch (paramAPIConfig.b)
    {
    default: 
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "unsupport auth type " + paramAPIConfig.b);
      a(6, paramAPIConfig, paramJSONObject, paramAPICallback);
      return;
    case 0: 
      a(0, paramAPIConfig, paramJSONObject, paramAPICallback);
      return;
    case 1: 
      localUserPermission = DefaultDoraemonAppInfoHelper.a().a(paramAPIConfig.jdField_a_of_type_JavaLangString);
      if (localUserPermission == null)
      {
        a(1, paramAPIConfig, paramJSONObject, paramAPICallback);
        return;
      }
      int i = a(localUserPermission);
      if (i == 1)
      {
        a(4, paramAPIConfig, paramJSONObject, paramAPICallback);
        return;
      }
      if (i == 2)
      {
        a(0, paramAPIConfig, paramJSONObject, paramAPICallback);
        return;
      }
      localObject2 = a();
      if (localObject2 == null)
      {
        localObject1 = null;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label352;
        }
        localObject1 = BaseApplicationImpl.getApplication().getResources().getString(2131694691);
      }
      break;
    }
    label352:
    for (;;)
    {
      if (localObject2 == null) {}
      for (localObject2 = null;; localObject2 = ((MiniAppInfo)localObject2).jdField_c_of_type_JavaLangString)
      {
        a((String)localObject1, (String)localObject2, BaseApplicationImpl.getApplication().getResources().getString(2131694690, new Object[] { localObject1 }), localUserPermission.b, BaseApplicationImpl.getApplication().getResources().getString(2131720671), new DefaultDoraemonAPIManager.2(this, localUserPermission, paramAPIConfig, paramJSONObject, paramAPICallback), BaseApplicationImpl.getApplication().getResources().getString(2131720681), new DefaultDoraemonAPIManager.3(this, localUserPermission, paramAPIConfig, paramJSONObject, paramAPICallback), new DefaultDoraemonAPIManager.4(this, localUserPermission, paramAPIConfig, paramJSONObject, paramAPICallback));
        return;
        localObject1 = ((MiniAppInfo)localObject2).b;
        break;
      }
      localObject1 = (UserInfoModule)a(UserInfoModule.class, false);
      if ((localObject1 != null) && (((UserInfoModule)localObject1).a()))
      {
        a(0, paramAPIConfig, paramJSONObject, paramAPICallback);
        return;
      }
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "not login");
      a(5, paramAPIConfig, paramJSONObject, paramAPICallback);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
  }
  
  public void c()
  {
    DefaultDoraemonAppInfoHelper.a().a(this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.d, this.e, this.f, new DefaultDoraemonAPIManager.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAPIManager
 * JD-Core Version:    0.7.0.1
 */