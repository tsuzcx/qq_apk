package com.tencent.biz.pubaccount.readinjoyAd.ad.hippy;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.ReadInJoyAdJumpUtils;
import com.tencent.cmsdk.hippy.api.ITKDAdModule;
import com.tencent.mobileqq.kandian.biz.hippy.api.ITKDHippyBridge;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaAccessHelper;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

public class TkdAdModuleImpl
  implements ITKDAdModule
{
  public static String a = "TkdAdModuleImpl";
  protected SoftReference<HippyEngineContext> a;
  
  private int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int i = Integer.parseInt(paramString);
        return i;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return 9999;
  }
  
  public void MMAOnExpose(String paramString, int paramInt) {}
  
  public void getAccountInfo(Promise paramPromise)
  {
    try
    {
      ((ITKDHippyBridge)QRoute.api(ITKDHippyBridge.class)).getAccountInfo(paramPromise);
      return;
    }
    catch (Exception paramPromise) {}
  }
  
  public void getAppPkgInfo(String paramString, Promise paramPromise)
  {
    paramPromise.resolve("null");
  }
  
  public void getDeviceInfo(Promise paramPromise)
  {
    ((ITKDHippyBridge)QRoute.api(ITKDHippyBridge.class)).getDeviceInfo(paramPromise);
  }
  
  public void getEnv(Promise paramPromise)
  {
    paramPromise.resolve("test");
  }
  
  public void goBack(String paramString, Promise paramPromise)
  {
    paramString = this.jdField_a_of_type_JavaLangRefSoftReference;
    if (paramString == null) {
      return;
    }
    paramString = (HippyEngineContext)paramString.get();
    if (paramString == null) {
      return;
    }
    if ((paramString.getGlobalConfigs() != null) && ((paramString.getGlobalConfigs().getContext() instanceof Activity))) {
      UIThreadUtils.runOnUiThread(new TkdAdModuleImpl.2(this, paramString));
    }
  }
  
  public void init(HippyEngineContext paramHippyEngineContext)
  {
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramHippyEngineContext);
  }
  
  public void isSupportQQMiniGame(Promise paramPromise)
  {
    if (paramPromise == null) {
      return;
    }
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("ret", 0);
    paramPromise.resolve(localHippyMap);
  }
  
  public void loadUrl(String paramString, HippyMap paramHippyMap)
  {
    paramHippyMap = this.jdField_a_of_type_JavaLangRefSoftReference;
    if (paramHippyMap == null) {
      return;
    }
    paramHippyMap = (HippyEngineContext)paramHippyMap.get();
    if (paramHippyMap == null) {
      return;
    }
    if (((IViolaAccessHelper)QRoute.api(IViolaAccessHelper.class)).isViolaUrlFromWeb(paramString)) {
      ((IViolaAccessHelper)QRoute.api(IViolaAccessHelper.class)).startViolaPage(paramHippyMap.getGlobalConfigs().getContext(), "小游戏", ((IViolaAccessHelper)QRoute.api(IViolaAccessHelper.class)).getviolaurlfromweb(paramString), null);
    } else {
      ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToUrl(paramHippyMap.getGlobalConfigs().getContext(), paramString);
    }
    paramHippyMap = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadUrl url:");
    localStringBuilder.append(paramString);
    QLog.d(paramHippyMap, 2, localStringBuilder.toString());
  }
  
  public void openQQMiniGameByLink(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramPromise != null)
    {
      paramPromise = this.jdField_a_of_type_JavaLangRefSoftReference;
      if (paramPromise == null) {
        return;
      }
      paramPromise = (HippyEngineContext)paramPromise.get();
      if (paramPromise == null) {
        return;
      }
      try
      {
        localObject = paramHippyMap.getString("link");
        int i = a(paramHippyMap.getString("refer"));
        paramHippyMap = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("openQQMiniGameByLink link:");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" refer:");
        localStringBuilder.append(i);
        QLog.d(paramHippyMap, 2, localStringBuilder.toString());
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramPromise.getGlobalConfigs().getContext(), (String)localObject, i, null);
        return;
      }
      catch (Exception paramHippyMap)
      {
        paramPromise = jdField_a_of_type_JavaLangString;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openQQMiniGameByLink error : ");
        ((StringBuilder)localObject).append(paramHippyMap.getMessage());
        QLog.d(paramPromise, 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void runApp(String paramString)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("run app params:");
    localStringBuilder.append(paramString);
    QLog.d((String)localObject, 2, localStringBuilder.toString());
    localObject = this.jdField_a_of_type_JavaLangRefSoftReference;
    if (localObject == null) {
      return;
    }
    localObject = (HippyEngineContext)((SoftReference)localObject).get();
    if (localObject == null) {
      return;
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains(":")))
    {
      ReadInJoyAdJumpUtils.a(paramString, (Activity)((HippyEngineContext)localObject).getGlobalConfigs().getContext());
      return;
    }
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = ContextHolder.getAppContext();
        paramString = ((Context)localObject).getPackageManager().getLaunchIntentForPackage(paramString);
        if (paramString != null)
        {
          ((Context)localObject).startActivity(paramString);
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void sendWupRequest(HippyMap paramHippyMap, Promise paramPromise) {}
  
  public void setTitle(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramPromise = this.jdField_a_of_type_JavaLangRefSoftReference;
    if (paramPromise == null) {
      return;
    }
    paramPromise = (HippyEngineContext)paramPromise.get();
    if (paramPromise == null) {
      return;
    }
    UIThreadUtils.runOnUiThread(new TkdAdModuleImpl.3(this, paramHippyMap, paramPromise));
  }
  
  public void showToast(String paramString1, String paramString2, int paramInt, String paramString3, Promise paramPromise)
  {
    UIThreadUtils.runOnUiThread(new TkdAdModuleImpl.1(this, paramString1, paramInt, paramPromise));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.hippy.TkdAdModuleImpl
 * JD-Core Version:    0.7.0.1
 */