package com.tencent.mobileqq.Doraemon.impl;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIConfig;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.AppInfo;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.UserPermission;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule;
import com.tencent.mobileqq.Doraemon.manifest.D.manifest.common_apis;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import riw;
import rix;
import riy;
import riz;

public class DefaultDoraemonAPIManager
  extends DoraemonAPIManager
{
  private AppInfo a;
  private Map c = new HashMap();
  
  public DefaultDoraemonAPIManager(Activity paramActivity, int paramInt, String paramString)
  {
    super(paramActivity, paramInt, paramString);
  }
  
  private int a(UserPermission paramUserPermission)
  {
    paramUserPermission = (Integer)this.c.get(this.jdField_a_of_type_JavaLangString + "_" + paramUserPermission.jdField_a_of_type_JavaLangString);
    if (paramUserPermission == null) {
      return 0;
    }
    return paramUserPermission.intValue();
  }
  
  private void a(UserPermission paramUserPermission, int paramInt)
  {
    this.c.put(this.jdField_a_of_type_JavaLangString + "_" + paramUserPermission.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt));
  }
  
  public AppInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDoraemonAppInfo;
  }
  
  protected Map a()
  {
    return D.manifest.common_apis.a();
  }
  
  protected void a(APIConfig paramAPIConfig, APIParam paramAPIParam, APICallback paramAPICallback)
  {
    switch (paramAPIConfig.b)
    {
    default: 
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "unsupport auth type " + paramAPIConfig.b);
      a(6, paramAPIConfig, paramAPIParam, paramAPICallback);
      return;
    case 0: 
      a(0, paramAPIConfig, paramAPIParam, paramAPICallback);
      return;
    case 1: 
      UserPermission localUserPermission = DefaultDoraemonAppInfoHelper.a().a(paramAPIConfig.jdField_a_of_type_JavaLangString);
      if (localUserPermission == null)
      {
        a(1, paramAPIConfig, paramAPIParam, paramAPICallback);
        return;
      }
      int i = a(localUserPermission);
      if (i == 1)
      {
        a(4, paramAPIConfig, paramAPIParam, paramAPICallback);
        return;
      }
      if (i == 2)
      {
        a(0, paramAPIConfig, paramAPIParam, paramAPICallback);
        return;
      }
      localObject1 = a();
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((AppInfo)localObject1).b)
      {
        Object localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = "[未知应用]";
        }
        a("用户授权", (String)localObject2 + "申请以下权限:" + localUserPermission.b, "允许", new rix(this, localUserPermission, paramAPIConfig, paramAPIParam, paramAPICallback), "拒绝", new riy(this, localUserPermission, paramAPIConfig, paramAPIParam, paramAPICallback), new riz(this, localUserPermission, paramAPIConfig, paramAPIParam, paramAPICallback));
        return;
      }
    }
    Object localObject1 = (UserInfoModule)a(UserInfoModule.class, false);
    if ((localObject1 != null) && (((UserInfoModule)localObject1).a()))
    {
      a(0, paramAPIConfig, paramAPIParam, paramAPICallback);
      return;
    }
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "not login");
    a(5, paramAPIConfig, paramAPIParam, paramAPICallback);
  }
  
  protected void b()
  {
    DefaultDoraemonAppInfoHelper.a().a(this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, new riw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAPIManager
 * JD-Core Version:    0.7.0.1
 */