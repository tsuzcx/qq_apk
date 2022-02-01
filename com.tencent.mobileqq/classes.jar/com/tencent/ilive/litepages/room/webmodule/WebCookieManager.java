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
    if (paramContext == null) {
      return;
    }
    Object localObject = paramContext.getCookie(paramString);
    if (localObject != null)
    {
      localObject = ((String)localObject).split(";");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = localObject[i].split("=");
        Iterator localIterator = getDomainSet(paramString).iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(arrayOfString[0]);
          localStringBuilder.append("=; Expires=Wed, 31 Dec 2015 23:59:59 GMT");
          paramContext.setCookie(str, localStringBuilder.toString());
        }
        i += 1;
      }
      paramContext.removeExpiredCookie();
      CookieSyncManager.getInstance().sync();
    }
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(";Domain=");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(";Path=/;");
    localObject1 = ((StringBuilder)localObject1).toString();
    paramString = (AppGeneralInfoService)BizEngineMgr.getInstance().getLiveEngine().getService(AppGeneralInfoService.class);
    int i = NetworkUtil.getNetworkType(this.mContext);
    Object localObject2 = AppInfoUtil.getVersionName(this.mContext);
    String str = paramString.getAppId();
    int j = paramString.getClientType();
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "__client_type", Integer.valueOf(j), localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "sdkver", "2.0.0", localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "platform", "Android", localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "installsrc", Integer.valueOf(j), localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "networktype", Integer.valueOf(i), localObject1 }));
    Locale localLocale = Locale.ENGLISH;
    paramString = "";
    localArrayList.add(String.format(localLocale, "%s=%s%s", new Object[] { "program_id", "", localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "guid", "", localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "qbid", "", localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "appversion", localObject2, localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%S", new Object[] { "appid", str, localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "__client_build", "", localObject1 }));
    localObject2 = ((LoginServiceInterface)this.mUserEngine.getService(LoginServiceInterface.class)).getLoginInfo();
    if (localObject2 == null) {
      return localArrayList;
    }
    long l2 = ((LoginInfo)localObject2).uid;
    long l1;
    if (((LoginInfo)localObject2).tinyid != 0L) {
      l1 = ((LoginInfo)localObject2).tinyid;
    } else {
      l1 = l2;
    }
    str = HexUtil.bytesToHexString(((LoginInfo)localObject2).a2);
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "ilive_uin", Long.valueOf(l2), localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "ilive_tinyid", Long.valueOf(l1), localObject1 }));
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "ilive_a2", str, localObject1 }));
    if (!((LoginServiceInterface)this.mUserEngine.getService(LoginServiceInterface.class)).isGuest())
    {
      i = WebCookieManager.1.$SwitchMap$com$tencent$falco$base$libapi$login$LoginType[localObject2.loginType.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            i = 3;
          } else {
            i = 2;
          }
        }
        else {
          i = 1;
        }
      }
      else {
        i = 0;
      }
      if (((LoginInfo)localObject2).loginType == LoginType.QQ)
      {
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_id", ((LoginInfo)localObject2).openId, localObject1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_key", ((LoginInfo)localObject2).access_token, localObject1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "original_id_type", Integer.valueOf(1), localObject1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "original_key_type", Integer.valueOf(37), localObject1 }));
        localObject2 = Locale.ENGLISH;
        if (this.mUserEngine.getLoginRequest() != null) {
          paramString = this.mUserEngine.getLoginRequest().appid;
        }
        localArrayList.add(String.format((Locale)localObject2, "%s=%s%s", new Object[] { "original_auth_appid", paramString, localObject1 }));
      }
      else if (((LoginInfo)localObject2).loginType == LoginType.WX)
      {
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_id", ((LoginInfo)localObject2).openId, localObject1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_key", ((LoginInfo)localObject2).access_token, localObject1 }));
        localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "original_id_type", Integer.valueOf(2), localObject1 }));
        localObject2 = Locale.ENGLISH;
        if (this.mUserEngine.getLoginRequest() != null) {
          paramString = this.mUserEngine.getLoginRequest().appid;
        }
        localArrayList.add(String.format((Locale)localObject2, "%s=%s%s", new Object[] { "original_auth_appid", paramString, localObject1 }));
      }
    }
    else
    {
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "uin", "", localObject1 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "skey", "", localObject1 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_id", ((LoginInfo)localObject2).openId, localObject1 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_key", ((LoginInfo)localObject2).access_token, localObject1 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_id_type", "", localObject1 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_key_type", "", localObject1 }));
      localArrayList.add(String.format(Locale.ENGLISH, "%s=%s%s", new Object[] { "original_auth_appid", "", localObject1 }));
      i = 3;
    }
    localArrayList.add(String.format(Locale.ENGLISH, "%s=%d%s", new Object[] { "uin_type", Integer.valueOf(i), localObject1 }));
    return localArrayList;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.WebCookieManager
 * JD-Core Version:    0.7.0.1
 */