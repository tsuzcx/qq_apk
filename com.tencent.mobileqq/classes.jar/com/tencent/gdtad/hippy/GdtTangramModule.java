package com.tencent.gdtad.hippy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.jsbridge.GdtBaseHalfScreenFragmentForJs;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

@HippyNativeModule(name="GdtTangramModule")
public class GdtTangramModule
  extends HippyNativeModuleBase
{
  private static final String TAG = "GdtTangramModule";
  public static ConcurrentHashMap<String, Promise> sHippyAsyncCallbackHashMap = new ConcurrentHashMap();
  private static ConcurrentHashMap<String, GdtTangramModule.GdtTangramModuleAdLoaderListener> sLoadAdRequestMap = new ConcurrentHashMap();
  private final String KEY_CODE = "code";
  private GdtAppReceiver hippyReceiver;
  
  public GdtTangramModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  public static void onHippyAsyncCallback(String paramString, HashMap<String, Object> paramHashMap)
  {
    paramString = (Promise)sHippyAsyncCallbackHashMap.remove(paramString);
    if (paramString == null)
    {
      QLog.i("GdtTangramModule", 1, "onHippyAsyncCallback callback is null");
      return;
    }
    HippyMap localHippyMap = new HippyMap();
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        localHippyMap.pushObject((String)localEntry.getKey(), localEntry.getValue());
      }
    }
    paramString.resolve(localHippyMap);
  }
  
  public static void removeRequest(String paramString)
  {
    ConcurrentHashMap localConcurrentHashMap = sLoadAdRequestMap;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.remove(paramString);
    }
  }
  
  public void destroy()
  {
    super.destroy();
    Object localObject = this.hippyReceiver;
    if (localObject != null)
    {
      ((GdtAppReceiver)localObject).unregister(BaseApplication.getContext().getApplicationContext());
      this.hippyReceiver = null;
    }
    localObject = sLoadAdRequestMap;
    if (localObject != null) {
      ((ConcurrentHashMap)localObject).clear();
    }
    localObject = sHippyAsyncCallbackHashMap;
    if (localObject != null) {
      ((ConcurrentHashMap)localObject).clear();
    }
  }
  
  @HippyMethod(name="getDeviceInfo")
  public void getDeviceInfo(HippyMap paramHippyMap, Promise paramPromise)
  {
    AdLog.i("GdtTangramModule", "getDeviceInfo");
    HippyMap localHippyMap = new HippyMap();
    for (;;)
    {
      try
      {
        paramHippyMap = paramHippyMap.toJSONObject().getString("businessIdForAidTicketAndTaidTicket");
        Object localObject = new GdtDeviceInfoHelper.Params();
        ((GdtDeviceInfoHelper.Params)localObject).a = paramHippyMap;
        paramHippyMap = GdtDeviceInfoHelper.a(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject);
        if (paramHippyMap == null) {
          break label154;
        }
        paramHippyMap = paramHippyMap.a;
        paramHippyMap = GdtJsonPbUtil.a(paramHippyMap);
        if (paramHippyMap == null)
        {
          localHippyMap.pushInt("code", 999);
        }
        else
        {
          localHippyMap.pushInt("code", 0);
          localObject = new JSONObject();
          ((JSONObject)localObject).put("deviceInfo", paramHippyMap);
          localHippyMap.pushJSONObject((JSONObject)localObject);
        }
      }
      catch (JSONException paramHippyMap)
      {
        AdLog.e("GdtTangramModule", "getDeviceInfo error ", paramHippyMap);
        localHippyMap.pushInt("code", 999);
      }
      if (paramPromise != null)
      {
        paramPromise.resolve(localHippyMap);
        return;
      }
      AdLog.e("GdtTangramModule", "getDeviceInfo promise is null");
      return;
      label154:
      paramHippyMap = null;
    }
  }
  
  @HippyMethod(name="handleClick")
  public void handleClick(HippyMap paramHippyMap, Promise paramPromise)
  {
    AdLog.i("GdtTangramModule", "handleClick");
    GdtHandler.Params localParams;
    if (paramHippyMap == null)
    {
      AdLog.e("GdtTangramModule", "handleClick params invalid");
    }
    else
    {
      localParams = new GdtHandler.Params();
      paramHippyMap = paramHippyMap.toJSONObject();
      if (JSONObject.NULL.equals(paramHippyMap))
      {
        AdLog.e("GdtTangramModule", "handleClick paramJSON invalid");
      }
      else if (!GdtHandler.a(localParams, paramHippyMap.toString()))
      {
        AdLog.e("GdtTangramModule", "handleClick fillOptions failed");
      }
      else
      {
        localParams.c = BaseApplicationImpl.sProcessId;
        localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(QBaseActivity.sTopActivity);
        if (this.hippyReceiver == null)
        {
          this.hippyReceiver = new GdtAppReceiver();
          this.hippyReceiver.register(BaseApplication.getContext().getApplicationContext());
        }
        localParams.b = new WeakReference(this.hippyReceiver);
        localParams.jdField_a_of_type_JavaLangClass = GdtBaseHalfScreenFragmentForJs.class;
      }
    }
    for (;;)
    {
      try
      {
        paramHippyMap = paramHippyMap.getJSONObject("options");
        if (TextUtils.isEmpty(paramHippyMap.getString("refSid"))) {
          break label235;
        }
        paramHippyMap = paramHippyMap.getString("refSid");
        localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
        localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", paramHippyMap);
      }
      catch (JSONException paramHippyMap)
      {
        paramHippyMap.printStackTrace();
      }
      GdtHandler.a(localParams);
      if (paramPromise != null)
      {
        paramPromise.resolve(null);
        return;
      }
      AdLog.e("GdtTangramModule", "handleClick promise is null");
      return;
      label235:
      paramHippyMap = null;
    }
  }
  
  @HippyMethod(name="loadAd")
  public void loadAd(HippyMap paramHippyMap, Promise paramPromise)
  {
    AdLog.i("GdtTangramModule", "loadAd");
    Object localObject = new HippyMap();
    if ((paramHippyMap != null) && (paramHippyMap.toJSONObject() != null) && (!JSONObject.NULL.equals(paramHippyMap.toJSONObject())))
    {
      paramHippyMap = paramHippyMap.toJSONObject();
      AdLog.i("GdtTangramModule", paramHippyMap.toString());
      localObject = new GdtTangramModule.GdtTangramModuleAdLoaderListener(paramPromise);
      sLoadAdRequestMap.put(paramPromise.getCallId(), localObject);
      paramPromise = new GdtAdLoader.Session();
      paramPromise.a = ((qq_ad_get.QQAdGet)GdtJsonPbUtil.a(new qq_ad_get.QQAdGet(), paramHippyMap));
      new GdtAdLoader(paramPromise, new WeakReference(localObject)).a(new WeakReference(BaseApplication.getContext()));
      return;
    }
    ((HippyMap)localObject).pushInt("code", 997);
    paramPromise.resolve(localObject);
  }
  
  @HippyMethod(name="openMotiveVideoAd")
  public void openMotiveVideoAd(HippyMap paramHippyMap, Promise paramPromise)
  {
    AdLog.i("GdtTangramModule", "openMotiveVideoAd");
    if (paramPromise == null) {
      AdLog.e("GdtTangramModule", "openMotiveVideoAd promise is null");
    }
    Object localObject1 = new HippyMap();
    try
    {
      int i = paramHippyMap.getInt("orientation");
      int j = paramHippyMap.getInt("rewardTime");
      String str = paramHippyMap.getMap("adInfo").toJSONObject().toString();
      Object localObject2 = (qq_ad_get.QQAdGetRsp.AdInfo)GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(str));
      str = paramHippyMap.getString("rewardText");
      localObject2 = GdtUtil.a((qq_ad_get.QQAdGetRsp.AdInfo)localObject2, GdtUtil.a(i));
      if (localObject2 != null)
      {
        QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
        if (localQBaseActivity != null)
        {
          Intent localIntent = localQBaseActivity.getIntent();
          if (localIntent != null)
          {
            localObject1 = localIntent.getStringExtra("big_brother_ref_source_key");
            paramHippyMap = (HippyMap)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramHippyMap = localIntent.getStringExtra("big_brother_source_key");
            }
            ((GdtMotiveVideoPageData)localObject2).refId = paramHippyMap;
          }
        }
        if (j > 0) {
          ((GdtMotiveVideoPageData)localObject2).setVideoCountDown(j);
        }
        if (!TextUtils.isEmpty(str)) {
          ((GdtMotiveVideoPageData)localObject2).setRewardText(str);
        }
        if (paramPromise != null)
        {
          ((GdtMotiveVideoPageData)localObject2).setHippyAsyncCallbackId(paramPromise.getCallId());
          sHippyAsyncCallbackHashMap.put(paramPromise.getCallId(), paramPromise);
        }
        ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.a(localQBaseActivity, (GdtMotiveVideoPageData)localObject2));
      }
      return;
    }
    catch (Exception paramHippyMap)
    {
      AdLog.e("GdtTangramModule", "openMotiveVideoAd error ", paramHippyMap);
      ((HippyMap)localObject1).pushInt("code", 998);
      if (paramPromise != null) {
        paramPromise.reject(localObject1);
      }
    }
  }
  
  @HippyMethod(name="preLoadAfterAdLoaded")
  public void preLoadAfterAdLoaded(HippyMap paramHippyMap, Promise paramPromise)
  {
    AdLog.i("GdtTangramModule", "preLoadAfterAdLoaded");
    if (paramHippyMap != null)
    {
      paramHippyMap = paramHippyMap.toJSONObject();
      try
      {
        paramHippyMap = paramHippyMap.getJSONObject("adInfo");
        paramHippyMap = (qq_ad_get.QQAdGetRsp.AdInfo)GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramHippyMap);
        paramHippyMap = new GdtAd(paramHippyMap);
        if (paramHippyMap.isValid()) {
          GdtPreLoader.a().a(paramHippyMap);
        }
      }
      catch (JSONException paramHippyMap)
      {
        AdLog.e("GdtTangramModule", "preLoadAfterAdLoaded error,", paramHippyMap);
      }
    }
    if (paramPromise != null)
    {
      paramPromise.resolve(null);
      return;
    }
    AdLog.e("GdtTangramModule", "preLoadAfterAdLoaded promise is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.hippy.GdtTangramModule
 * JD-Core Version:    0.7.0.1
 */