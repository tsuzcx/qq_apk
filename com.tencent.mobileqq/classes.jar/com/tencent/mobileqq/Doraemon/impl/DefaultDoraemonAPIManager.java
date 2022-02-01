package com.tencent.mobileqq.Doraemon.impl;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIConfig;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.DoraemonAPIModule;
import com.tencent.mobileqq.Doraemon.IDoraemonApi;
import com.tencent.mobileqq.Doraemon.UserPermission;
import com.tencent.mobileqq.Doraemon.manifest.D;
import com.tencent.mobileqq.Doraemon.manifest.D.manifest.common_apis;
import com.tencent.mobileqq.app.HardCodeUtil;
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
  protected MiniAppInfo a;
  private String jdField_c_of_type_JavaLangString;
  private Map<String, Integer> jdField_c_of_type_JavaUtilMap = new HashMap();
  private String d;
  private String e;
  private String f;
  
  public DefaultDoraemonAPIManager(Activity paramActivity, int paramInt, String paramString)
  {
    super(paramActivity, paramInt, paramString);
    paramActivity = new StringBuilder();
    paramActivity.append("doraemon_user_permission_");
    paramActivity.append(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
    this.jdField_c_of_type_JavaLangString = paramActivity.toString();
  }
  
  private int a(UserPermission paramUserPermission)
  {
    Object localObject2 = (Integer)this.jdField_c_of_type_JavaUtilMap.get(paramUserPermission.jdField_a_of_type_JavaLangString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = BaseApplication.getContext().getSharedPreferences(this.jdField_c_of_type_JavaLangString, 4);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramUserPermission.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("_2");
      if (((SharedPreferences)localObject1).getLong(((StringBuilder)localObject2).toString(), 0L) > NetConnInfoCenter.getServerTimeMillis()) {
        localObject1 = Integer.valueOf(2);
      } else {
        localObject1 = Integer.valueOf(0);
      }
      this.jdField_c_of_type_JavaUtilMap.put(paramUserPermission.jdField_a_of_type_JavaLangString, localObject1);
    }
    return ((Integer)localObject1).intValue();
  }
  
  private void a(UserPermission paramUserPermission, int paramInt)
  {
    if (2 == paramInt)
    {
      long l = NetConnInfoCenter.getServerTimeMillis();
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(this.jdField_c_of_type_JavaLangString, 4).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append("_");
      localStringBuilder.append(paramUserPermission.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("_2");
      localEditor.putLong(localStringBuilder.toString(), l + 2592000000L).apply();
    }
    this.jdField_c_of_type_JavaUtilMap.put(paramUserPermission.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt));
  }
  
  public MiniAppInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo;
  }
  
  public String a()
  {
    String str2 = this.e;
    String str1 = str2;
    if (str2 == null) {
      str1 = MobileQQ.getContext().getPackageName();
    }
    return str1;
  }
  
  protected Map<String, APIConfig> a()
  {
    return D.manifest.common_apis.a();
  }
  
  protected void a(APIConfig paramAPIConfig, JSONObject paramJSONObject, APICallback paramAPICallback)
  {
    int i = paramAPIConfig.b;
    if (i != 0)
    {
      Object localObject1;
      if (i != 1)
      {
        if (i != 2)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("unsupport auth type ");
          ((StringBuilder)localObject1).append(paramAPIConfig.b);
          QLog.i("DoraemonOpenAPI.apiMgr", 1, ((StringBuilder)localObject1).toString());
          a(6, paramAPIConfig, paramJSONObject, paramAPICallback);
          return;
        }
        localObject1 = a((Class)D.a.get("login"), false);
        if (this.jdField_a_of_type_ComTencentMobileqqDoraemonIDoraemonApi.isLogin((DoraemonAPIModule)localObject1))
        {
          a(0, paramAPIConfig, paramJSONObject, paramAPICallback);
          return;
        }
        QLog.i("DoraemonOpenAPI.apiMgr", 1, "not login");
        a(5, paramAPIConfig, paramJSONObject, paramAPICallback);
        return;
      }
      UserPermission localUserPermission = DefaultDoraemonAppInfoHelper.a().a(paramAPIConfig.jdField_a_of_type_JavaLangString);
      if (localUserPermission == null)
      {
        a(1, paramAPIConfig, paramJSONObject, paramAPICallback);
        return;
      }
      i = a(localUserPermission);
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
      MiniAppInfo localMiniAppInfo = a();
      if (localMiniAppInfo == null) {
        localObject1 = null;
      } else {
        localObject1 = localMiniAppInfo.b;
      }
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = HardCodeUtil.a(2131694660);
      }
      if (localMiniAppInfo == null) {
        localObject1 = null;
      } else {
        localObject1 = localMiniAppInfo.jdField_c_of_type_JavaLangString;
      }
      a((String)localObject2, (String)localObject1, BaseApplication.getContext().getResources().getString(2131694659, new Object[] { localObject2 }), localUserPermission.b, HardCodeUtil.a(2131720390), new DefaultDoraemonAPIManager.2(this, localUserPermission, paramAPIConfig, paramJSONObject, paramAPICallback), HardCodeUtil.a(2131720400), new DefaultDoraemonAPIManager.3(this, localUserPermission, paramAPIConfig, paramJSONObject, paramAPICallback), new DefaultDoraemonAPIManager.4(this, localUserPermission, paramAPIConfig, paramJSONObject, paramAPICallback));
      return;
    }
    a(0, paramAPIConfig, paramJSONObject, paramAPICallback);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
  }
  
  protected void c()
  {
    DefaultDoraemonAppInfoHelper.a().a(this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.d, this.e, this.f, new DefaultDoraemonAPIManager.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAPIManager
 * JD-Core Version:    0.7.0.1
 */