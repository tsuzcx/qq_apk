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
  private static volatile WSQQConnectAuthManager a;
  private static int e;
  private DoraemonAPIManager b;
  private Map<Long, WSQQConnectAuthManager.WSQQConnectData> c = new HashMap();
  private volatile boolean d;
  
  private WSQQConnectAuthManager()
  {
    b();
  }
  
  public static WSQQConnectAuthManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new WSQQConnectAuthManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(JSONObject paramJSONObject)
  {
    e = 0;
    String str = paramJSONObject.optString("openid");
    paramJSONObject = paramJSONObject.optString("access_token");
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramJSONObject))) {
      this.c.put(Long.valueOf(WeishiUtils.b()), new WSQQConnectAuthManager.WSQQConnectData(str, paramJSONObject));
    }
    str = ThreeDes.a(str, WeishiUtils.c());
    paramJSONObject = ThreeDes.a(paramJSONObject, WeishiUtils.c());
    LocalMultiProcConfig.putString4Uin("key_qq_connect_open_id", str, WeishiUtils.b());
    LocalMultiProcConfig.putString4Uin("key_qq_connect_access_token", paramJSONObject, WeishiUtils.b());
    LocalMultiProcConfig.putLong4Uin("key_qq_connect_auth_time", System.currentTimeMillis(), WeishiUtils.b());
  }
  
  private boolean e()
  {
    try
    {
      long l1 = WeishiUtils.b();
      Object localObject1 = this.c.get(Long.valueOf(l1));
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
      String str2 = ThreeDes.b((String)localObject1, WeishiUtils.c());
      String str3 = ThreeDes.b(str1, WeishiUtils.c());
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
        this.c.put(Long.valueOf(WeishiUtils.b()), new WSQQConnectAuthManager.WSQQConnectData(str2, str3));
        return true;
      }
      return false;
    }
    finally {}
  }
  
  private Activity f()
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
  
  private void g()
  {
    if (!this.d)
    {
      this.d = true;
      ((IDoraemonService)QRoute.api(IDoraemonService.class)).prepare();
      this.b = ((IDoraemonService)QRoute.api(IDoraemonService.class)).createAPIManager(f(), 6, String.valueOf(1101083114));
      DoraemonAPIManager localDoraemonAPIManager = this.b;
      if (localDoraemonAPIManager != null) {
        localDoraemonAPIManager.a("loginSilent", null, new WSQQConnectAuthManager.1(this));
      }
    }
  }
  
  private void h()
  {
    e += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("authRetry: ");
    localStringBuilder.append(e);
    WSLog.g("WSQQConnectAuthManager", localStringBuilder.toString());
    if (e >= 3)
    {
      e = 0;
      return;
    }
    g();
  }
  
  private WSQQConnectAuthManager.WSQQConnectData i()
  {
    Map localMap = this.c;
    if (localMap != null) {
      return (WSQQConnectAuthManager.WSQQConnectData)localMap.get(Long.valueOf(WeishiUtils.b()));
    }
    return null;
  }
  
  @NotNull
  public stAuth a(String paramString1, String paramString2, boolean paramBoolean)
  {
    WSQQConnectAuthManager.WSQQConnectData localWSQQConnectData = i();
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
    if (e())
    {
      localWSQQConnectData = i();
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
      g();
    }
    return new stAuth(2, paramString1, paramString2);
  }
  
  public void b()
  {
    if (!e()) {
      g();
    }
  }
  
  public WSQQConnectAuthManager.WSQQConnectData c()
  {
    long l = WeishiUtils.b();
    Object localObject2 = i();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = LocalMultiProcConfig.getString4Uin("key_qq_connect_open_id", "", l);
      localObject2 = LocalMultiProcConfig.getString4Uin("key_qq_connect_access_token", "", l);
      localObject1 = new WSQQConnectAuthManager.WSQQConnectData(ThreeDes.b((String)localObject1, WeishiUtils.c()), ThreeDes.b((String)localObject2, WeishiUtils.c()));
    }
    return localObject1;
  }
  
  public void d()
  {
    this.d = false;
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSQQConnectAuthManager
 * JD-Core Version:    0.7.0.1
 */