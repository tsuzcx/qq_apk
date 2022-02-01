package com.tencent.biz.pubaccount.weishi_new;

import NS_KING_PUBLIC.stAuth;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.DoraemonOpenAPI;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.util.ThreeDes;
import cooperation.qzone.LocalMultiProcConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class WSQQConnectAuthManager
{
  private static int jdField_a_of_type_Int = 0;
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
    Activity localActivity = null;
    if (SplashActivity.sWeakInstance != null) {
      localActivity = (Activity)SplashActivity.sWeakInstance.get();
    }
    Object localObject = localActivity;
    if (localActivity == null) {
      localObject = BaseActivity.sTopActivity;
    }
    return localObject;
  }
  
  private WSQQConnectAuthManager.WSQQConnectData a()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      return (WSQQConnectAuthManager.WSQQConnectData)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(WeishiUtils.a()));
    }
    return null;
  }
  
  public static WSQQConnectAuthManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSQQConnectAuthManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSQQConnectAuthManager == null) {
        jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSQQConnectAuthManager = new WSQQConnectAuthManager();
      }
      return jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSQQConnectAuthManager;
    }
    finally {}
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
    boolean bool = true;
    for (;;)
    {
      try
      {
        long l1 = WeishiUtils.a();
        Object localObject1 = this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(l1));
        if (localObject1 != null) {
          return bool;
        }
        long l2 = System.currentTimeMillis();
        long l3 = LocalMultiProcConfig.getLong4Uin("key_qq_connect_auth_time", 0L, l1);
        WSLog.e("WSQQConnectAuthManager", "now qq connect auth time diff (sec) = " + (l2 - l3) / 1000L);
        if (l2 - l3 > 1728000000L)
        {
          bool = false;
        }
        else
        {
          localObject1 = LocalMultiProcConfig.getString4Uin("key_qq_connect_open_id", "", l1);
          String str1 = LocalMultiProcConfig.getString4Uin("key_qq_connect_access_token", "", l1);
          String str2 = ThreeDes.b((String)localObject1, WeishiUtils.a());
          String str3 = ThreeDes.b(str1, WeishiUtils.a());
          WSLog.f("weishi-828", "use sp openId and accessToken encrypted:" + (String)localObject1 + " , " + str1 + ", decrypt:" + str2 + " , " + str3);
          if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3))) {
            this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(WeishiUtils.a()), new WSQQConnectAuthManager.WSQQConnectData(str2, str3));
          } else {
            bool = false;
          }
        }
      }
      finally {}
    }
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      DoraemonOpenAPI.a();
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager = DoraemonOpenAPI.a(a(), 6, String.valueOf(1101083114));
      if (this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("loginSilent", null, new WSQQConnectAuthManager.1(this));
      }
    }
  }
  
  private void d()
  {
    jdField_a_of_type_Int += 1;
    WSLog.g("WSQQConnectAuthManager", "authRetry: " + jdField_a_of_type_Int);
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
      WSLog.f("weishi-828", "use memory openId and accessToken" + localWSQQConnectData.a + " , " + localWSQQConnectData.b);
      return new stAuth(1, localWSQQConnectData.a, localWSQQConnectData.b);
    }
    if (a())
    {
      localWSQQConnectData = a();
      if (localWSQQConnectData != null)
      {
        WSLog.f("weishi-828", "use memory openId and accessToken" + localWSQQConnectData.a + " , " + localWSQQConnectData.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSQQConnectAuthManager
 * JD-Core Version:    0.7.0.1
 */