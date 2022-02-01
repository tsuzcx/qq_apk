package com.tencent.ilive.litepages.room.webmodule;

import android.content.Context;
import android.net.Uri;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginRequest;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.login.LoginType;
import com.tencent.falco.utils.AppInfoUtil;
import com.tencent.falco.utils.HexUtil;
import com.tencent.falco.utils.NetworkUtil;
import com.tencent.falco.utils.UriUtil;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class WebCookieManager
{
  private static final String TAG = "WebComponentManager";
  private static WebCookieManager mWebCookieManager = new WebCookieManager();
  private Context mContext;
  private UserEngine mUserEngine = BizEngineMgr.getInstance().getUserEngine();
  
  public static void deleteCookiesForDomain(Context paramContext, String paramString)
  {
    CookieSyncManager.createInstance(paramContext);
    paramContext = CookieManager.getInstance();
    if (paramContext == null) {}
    do
    {
      return;
      localObject = paramContext.getCookie(paramString);
    } while (localObject == null);
    Object localObject = ((String)localObject).split(";");
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = localObject[i].split("=");
      Iterator localIterator = getDomainSet(paramString).iterator();
      while (localIterator.hasNext()) {
        paramContext.setCookie((String)localIterator.next(), arrayOfString[0] + "=; Expires=Wed, 31 Dec 2015 23:59:59 GMT");
      }
      i += 1;
    }
    paramContext.removeExpiredCookie();
    CookieSyncManager.getInstance().sync();
  }
  
  private String getCookieCreator()
  {
    return "";
  }
  
  private static HashSet<String> getDomainSet(String paramString)
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(paramString);
    return localHashSet;
  }
  
  public static WebCookieManager getInstance()
  {
    return mWebCookieManager;
  }
  
  private List<String> writeCookie(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = UriUtil.getTopLevelDomainInLowerCase(paramString);
    String str1 = ";Domain=" + paramString + ";Path=/;";
    paramString = (AppGeneralInfoService)BizEngineMgr.getInstance().getLiveEngine().getService(AppGeneralInfoService.class);
    int i = NetworkUtil.getNetworkType(this.mContext);
    Object localObject = AppInfoUtil.getVersionName(this.mContext);
    String str2 = paramString.getAppId();
    int j = paramString.getClientType();
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "__client_type", Integer.valueOf(j), str1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "sdkver", "2.0.0", str1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "platform", "Android", str1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "installsrc", Integer.valueOf(j), str1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "networktype", Integer.valueOf(i), str1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "program_id", "", str1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "guid", "", str1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "qbid", "", str1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "appversion", localObject, str1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%S", new Object[] { "appid", str2, str1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "__client_build", "", str1 }));
    paramString = ((LoginServiceInterface)this.mUserEngine.getService(LoginServiceInterface.class)).getLoginInfo();
    if (paramString == null) {
      return localArrayList;
    }
    long l2 = paramString.uid;
    long l1;
    if (paramString.tinyid != 0L)
    {
      l1 = paramString.tinyid;
      localObject = HexUtil.bytesToHexString(paramString.a2);
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "ilive_uin", Long.valueOf(l2), str1 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "ilive_tinyid", Long.valueOf(l1), str1 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "ilive_a2", localObject, str1 }));
      if (((LoginServiceInterface)this.mUserEngine.getService(LoginServiceInterface.class)).isGuest()) {
        break label1197;
      }
      switch (WebCookieManager.1.$SwitchMap$com$tencent$falco$base$libapi$login$LoginType[paramString.loginType.ordinal()])
      {
      default: 
        i = 3;
        label706:
        if (paramString.loginType == LoginType.QQ)
        {
          localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_id", paramString.openId, str1 }));
          localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_key", paramString.access_token, str1 }));
          localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "original_id_type", Integer.valueOf(1), str1 }));
          localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "original_key_type", Integer.valueOf(37), str1 }));
          localObject = Locale.ENGLISH;
          if (this.mUserEngine.getLoginRequest() != null)
          {
            paramString = this.mUserEngine.getLoginRequest().appid;
            label895:
            localArrayList.add(String.format((Locale)localObject, "%s=%s%s", new Object[] { "original_auth_appid", paramString, str1 }));
            j = i;
          }
        }
        break;
      }
    }
    for (;;)
    {
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "uin_type", Integer.valueOf(j), str1 }));
      return localArrayList;
      l1 = l2;
      break;
      i = 0;
      break label706;
      i = 1;
      break label706;
      i = 2;
      break label706;
      paramString = "";
      break label895;
      j = i;
      if (paramString.loginType == LoginType.WX)
      {
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_id", paramString.openId, str1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_key", paramString.access_token, str1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "original_id_type", Integer.valueOf(2), str1 }));
        localObject = Locale.ENGLISH;
        if (this.mUserEngine.getLoginRequest() != null) {}
        for (paramString = this.mUserEngine.getLoginRequest().appid;; paramString = "")
        {
          localArrayList.add(String.format((Locale)localObject, "%s=%s%s", new Object[] { "original_auth_appid", paramString, str1 }));
          j = i;
          break;
        }
        label1197:
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "uin", "", str1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "skey", "", str1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_id", paramString.openId, str1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_key", paramString.access_token, str1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_id_type", "", str1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_key_type", "", str1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_auth_appid", "", str1 }));
        j = 3;
      }
    }
  }
  
  public void plant(Context paramContext, String paramString)
  {
    this.mContext = paramContext.getApplicationContext();
    Uri.parse(paramString);
    CookieSyncManager.createInstance(this.mContext);
    paramContext = CookieManager.getInstance();
    paramContext.setAcceptCookie(true);
    Iterator localIterator = writeCookie(paramString).iterator();
    while (localIterator.hasNext()) {
      paramContext.setCookie(paramString, (String)localIterator.next());
    }
    paramContext.removeExpiredCookie();
    CookieSyncManager.getInstance().sync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.WebCookieManager
 * JD-Core Version:    0.7.0.1
 */