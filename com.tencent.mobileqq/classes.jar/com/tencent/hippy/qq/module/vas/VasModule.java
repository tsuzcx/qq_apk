package com.tencent.hippy.qq.module.vas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.module.QQBaseLifecycleModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.hippy.VasFriendInfoHippyHelper;
import com.tencent.mobileqq.vas.hippy.VasHippyFontUtils;
import com.tencent.mobileqq.vas.hippy.VasHippyUtils;
import com.tencent.mobileqq.vas.signature.SignatureEditManager;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@HippyNativeModule(name="VasModule")
public class VasModule
  extends QQBaseLifecycleModule
{
  static final String TAG = "VasModule";
  private final String METHOD_DOWNLOAD_FONT = "downloadFont";
  private final String METHOD_GET_AUTH = "getAuth";
  private final String METHOD_GET_FRIEND_INFO = "getFriendInfo";
  private final String METHOD_JUMP_SIGNATURE_PAGE = "jumpSignaturePage";
  VasFriendInfoHippyHelper mFriendInfoHippyHelper = new VasFriendInfoHippyHelper(getActivity());
  Promise mPromise;
  private ArrayList<String> mWhiteListOfGetFriendInfo = new VasModule.1(this);
  
  public VasModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private boolean isEnableGetAuth(@NotNull String paramString)
  {
    return ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).checkDomainPermission(paramString);
  }
  
  @HippyMethod(name="downloadFont")
  public void downloadFont(HippyArray paramHippyArray, Promise paramPromise)
  {
    VasHippyFontUtils.a(paramHippyArray, paramPromise);
  }
  
  @HippyMethod(name="getAuth")
  public void getAuth(HippyMap paramHippyMap, Promise paramPromise)
  {
    if ((paramHippyMap != null) && (paramHippyMap.size() > 0))
    {
      Object localObject1 = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
      if (localObject1 == null)
      {
        paramPromise.reject("engine is null");
        return;
      }
      if (TextUtils.isEmpty(((HippyQQEngine)localObject1).getModuleName()))
      {
        paramPromise.reject("moduleName is empty");
        return;
      }
      String str = paramHippyMap.getString("domain");
      if (TextUtils.isEmpty(str))
      {
        paramPromise.reject("params domain is empty");
        return;
      }
      if (!isEnableGetAuth(str))
      {
        paramPromise.reject("domain need to be add to whitelist");
        return;
      }
      Object localObject3 = getAppInterface();
      if ((localObject3 != null) && (((AppInterface)localObject3).isLogin()))
      {
        paramHippyMap = ((AppInterface)localObject3).getCurrentAccountUin();
        Object localObject2 = (TicketManager)((AppInterface)localObject3).getManager(2);
        localObject1 = ((TicketManager)localObject2).getSkey(paramHippyMap);
        localObject2 = ((TicketManager)localObject2).getPskey(paramHippyMap, str);
        str = SwiftBrowserCookieMonster.b((AppRuntime)localObject3, str);
        try
        {
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("uin", paramHippyMap);
          ((JSONObject)localObject3).put("p_uin", paramHippyMap);
          ((JSONObject)localObject3).put("skey", localObject1);
          ((JSONObject)localObject3).put("p_skey", localObject2);
          ((JSONObject)localObject3).put("pt4_token", str);
          paramPromise.resolve(((JSONObject)localObject3).toString());
          return;
        }
        catch (Throwable paramHippyMap)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getAuth error = ");
          ((StringBuilder)localObject1).append(paramHippyMap);
          QLog.e("VasModule", 2, ((StringBuilder)localObject1).toString());
        }
      }
      paramPromise.reject("unknown error");
      return;
    }
    paramPromise.reject("params is empty");
  }
  
  @HippyMethod(name="getFriendInfo")
  public void getFriendInfo(HippyMap paramHippyMap, Promise paramPromise)
  {
    Object localObject = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
    if (localObject == null)
    {
      paramPromise.reject(VasHippyUtils.a(-2, "engine is null", null));
      return;
    }
    localObject = ((HippyQQEngine)localObject).getModuleName();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramPromise.reject(VasHippyUtils.a(-3, "moduleName don`t support", null));
      return;
    }
    if (!this.mWhiteListOfGetFriendInfo.contains(localObject))
    {
      paramPromise.reject(VasHippyUtils.a(-3, "moduleName don`t support", null));
      return;
    }
    this.mPromise = paramPromise;
    this.mFriendInfoHippyHelper.a(paramHippyMap, paramPromise);
  }
  
  @HippyMethod(name="jumpSignaturePage")
  public void jumpSignaturePage(HippyMap paramHippyMap, Promise paramPromise)
  {
    int i = paramHippyMap.getInt("templateId");
    int j = paramHippyMap.getInt("fontId");
    Object localObject = paramHippyMap.getString("url");
    paramHippyMap = (HippyMap)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramHippyMap = "https://zb.vip.qq.com/v2/signList?_wvx=2&_wvxBclr=0xffffff&_wwv=4";
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("signUrl", paramHippyMap);
    SignatureEditManager.a(getActivity(), getAppInterface(), 0, "signature_geqian", -1, i, j, (Bundle)localObject);
    paramPromise.resolve("success");
  }
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("onActivityResult requestCode = ");
      paramActivity.append(paramInt1);
      paramActivity.append(" resultCode = ");
      paramActivity.append(paramInt2);
      QLog.i("VasModule", 2, paramActivity.toString());
    }
    paramActivity = this.mPromise;
    if (paramActivity == null)
    {
      QLog.e("VasModule", 2, "mPromise is null");
      return;
    }
    this.mPromise = null;
    if (paramInt2 != -1)
    {
      if (paramInt2 != 0) {
        return;
      }
      paramIntent = this.mFriendInfoHippyHelper;
      if (paramInt1 == 49)
      {
        paramActivity.reject(VasHippyUtils.a(-1, "user choice nobody", null));
        return;
      }
      if (paramInt1 == 50) {
        paramActivity.reject(VasHippyUtils.a(-1, "user choice nobody", null));
      }
    }
    else
    {
      VasFriendInfoHippyHelper localVasFriendInfoHippyHelper = this.mFriendInfoHippyHelper;
      if (paramInt1 == 49) {
        localVasFriendInfoHippyHelper.a(paramIntent, paramActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.vas.VasModule
 * JD-Core Version:    0.7.0.1
 */