package com.tencent.biz.pubaccount.weishi_new;

import NS_KING_PUBLIC.stAuth;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.util.ThreeDes;
import cooperation.qzone.LocalMultiProcConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class WSQQConnectAuthManager
{
  private static int jdField_a_of_type_Int;
  private static volatile WSQQConnectAuthManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSQQConnectAuthManager;
  private DoraemonAPIManager jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager;
  private Map<Long, WSQQConnectAuthManager.WSQQConnectData> jdField_a_of_type_JavaUtilMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  
  private WSQQConnectAuthManager()
  {
    a();
  }
  
  private Activity a()
  {
    Activity localActivity;
    if (SplashActivity.sWeakInstance != null) {
      localActivity = (Activity)SplashActivity.sWeakInstance.get();
    } else {
      localActivity = null;
    }
    Object localObject = localActivity;
    if (localActivity == null) {
      localObject = BaseActivity.sTopActivity;
    }
    return localObject;
  }
  
  private WSQQConnectAuthManager.WSQQConnectData a()
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap != null) {
      return (WSQQConnectAuthManager.WSQQConnectData)localMap.get(Long.valueOf(WeishiUtils.a()));
    }
    return null;
  }
  
  public static WSQQConnectAuthManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSQQConnectAuthManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSQQConnectAuthManager == null) {
          jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSQQConnectAuthManager = new WSQQConnectAuthManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSQQConnectAuthManager;
  }
  
  private void a(JSONObject paramJSONObject)
  {
    jdField_a_of_type_Int = 0;
    String str = paramJSONObject.optString("openid");
    paramJSONObject = paramJSONObject.optString("access_token");
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramJSONObject))) {
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(WeishiUtils.a()), new WSQQConnectAuthManager.WSQQConnectData(str, paramJSONObject));
    }
    str = ThreeDes.a(str, WeishiUtils.a());
    paramJSONObject = ThreeDes.a(paramJSONObject, WeishiUtils.a());
    LocalMultiProcConfig.putString4Uin("key_qq_connect_open_id", str, WeishiUtils.a());
    LocalMultiProcConfig.putString4Uin("key_qq_connect_access_token", paramJSONObject, WeishiUtils.a());
    LocalMultiProcConfig.putLong4Uin("key_qq_connect_auth_time", System.currentTimeMillis(), WeishiUtils.a());
  }
  
  private boolean a()
  {
    try
    {
      long l1 = WeishiUtils.a();
      Object localObject1 = this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(l1));
      if (localObject1 != null) {
        return true;
      }
      long l2 = System.currentTimeMillis();
      long l3 = LocalMultiProcConfig.getLong4Uin("key_qq_connect_auth_time", 0L, l1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("now qq connect auth time diff (sec) = ");
      l2 -= l3;
      ((StringBuilder)localObject1).append(l2 / 1000L);
      WSLog.e("WSQQConnectAuthManager", ((StringBuilder)localObject1).toString());
      if (l2 > 1728000000L) {
        return false;
      }
      localObject1 = LocalMultiProcConfig.getString4Uin("key_qq_connect_open_id", "", l1);
      String str1 = LocalMultiProcConfig.getString4Uin("key_qq_connect_access_token", "", l1);
      String str2 = ThreeDes.b((String)localObject1, WeishiUtils.a());
      String str3 = ThreeDes.b(str1, WeishiUtils.a());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("use sp openId and accessToken encrypted:");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" , ");
      localStringBuilder.append(str1);
      localStringBuilder.append(", decrypt:");
      localStringBuilder.append(str2);
      localStringBuilder.append(" , ");
      localStringBuilder.append(str3);
      WSLog.f("weishi-828", localStringBuilder.toString());
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
      {
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(WeishiUtils.a()), new WSQQConnectAuthManager.WSQQConnectData(str2, str3));
        return true;
      }
      return false;
    }
    finally {}
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      ((IDoraemonService)QRoute.api(IDoraemonService.class)).prepare();
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager = ((IDoraemonService)QRoute.api(IDoraemonService.class)).createAPIManager(a(), 6, String.valueOf(1101083114));
      DoraemonAPIManager localDoraemonAPIManager = this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager;
      if (localDoraemonAPIManager != null) {
        localDoraemonAPIManager.a("loginSilent", null, new WSQQConnectAuthManager.1(this));
      }
    }
  }
  
  private void d()
  {
    jdField_a_of_type_Int += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("authRetry: ");
    localStringBuilder.append(jdField_a_of_type_Int);
    WSLog.g("WSQQConnectAuthManager", localStringBuilder.toString());
    if (jdField_a_of_type_Int >= 3)
    {
      jdField_a_of_type_Int = 0;
      return;
    }
    c();
  }
  
  @NotNull
  public stAuth a(String paramString1, String paramString2, boolean paramBoolean)
  {
    WSQQConnectAuthManager.WSQQConnectData localWSQQConnectData = a();
    if (localWSQQConnectData != null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("use memory openId and accessToken");
      paramString1.append(localWSQQConnectData.a);
      paramString1.append(" , ");
      paramString1.append(localWSQQConnectData.b);
      WSLog.f("weishi-828", paramString1.toString());
      return new stAuth(1, localWSQQConnectData.a, localWSQQConnectData.b);
    }
    if (a())
    {
      localWSQQConnectData = a();
      if (localWSQQConnectData != null)
      {
        paramString1 = new StringBuilder();
        paramString1.append("use memory openId and accessToken");
        paramString1.append(localWSQQConnectData.a);
        paramString1.append(" , ");
        paramString1.append(localWSQQConnectData.b);
        WSLog.f("weishi-828", paramString1.toString());
        return new stAuth(1, localWSQQConnectData.a, localWSQQConnectData.b);
      }
    }
    WSLog.g("weishi-828", "未获取到openId和accessToken，使用了兜底方案");
    if (paramBoolean) {
      c();
    }
    return new stAuth(2, paramString1, paramString2);
  }
  
  public void a()
  {
    if (!a()) {
      c();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSQQConnectAuthManager
 * JD-Core Version:    0.7.0.1
 */