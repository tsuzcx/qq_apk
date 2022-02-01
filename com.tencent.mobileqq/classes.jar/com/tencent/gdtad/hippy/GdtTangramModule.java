package com.tencent.gdtad.hippy;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.jsbridge.GdtBaseHalfScreenFragmentForJs;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForJS;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import mqq.app.Foreground;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

@HippyNativeModule(name="GdtTangramModule")
public class GdtTangramModule
  extends HippyNativeModuleBase
{
  private static final String TAG = "GdtTangramModule";
  private GdtAppReceiver hippyReceiver;
  private GdtTangramModule.GdtTangramModuleAdLoaderListener listener;
  
  public GdtTangramModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  public void destroy()
  {
    super.destroy();
    if (this.hippyReceiver != null)
    {
      this.hippyReceiver.unregister(BaseApplication.getContext().getApplicationContext());
      this.hippyReceiver = null;
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
        localObject = new GdtDeviceInfoHelper.Params();
        ((GdtDeviceInfoHelper.Params)localObject).a = paramHippyMap;
        paramHippyMap = GdtDeviceInfoHelper.a(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject);
        if (paramHippyMap == null) {
          continue;
        }
        paramHippyMap = paramHippyMap.a;
        paramHippyMap = GdtJsonPbUtil.a(paramHippyMap);
        if (paramHippyMap != null) {
          continue;
        }
        localHippyMap.pushInt("code", 999);
      }
      catch (JSONException paramHippyMap)
      {
        Object localObject;
        AdLog.e("GdtTangramModule", "getDeviceInfo error ", paramHippyMap);
        localHippyMap.pushInt("code", 999);
        continue;
        AdLog.e("GdtTangramModule", "getDeviceInfo promise is null");
      }
      if (paramPromise == null) {
        continue;
      }
      paramPromise.resolve(localHippyMap);
      return;
      paramHippyMap = null;
      continue;
      localHippyMap.pushInt("code", 0);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("deviceInfo", paramHippyMap);
      localHippyMap.pushJSONObject((JSONObject)localObject);
    }
  }
  
  @HippyMethod(name="handleClick")
  public void handleClick(HippyMap paramHippyMap, Promise paramPromise)
  {
    AdLog.i("GdtTangramModule", "handleClick");
    if (paramHippyMap == null) {
      AdLog.e("GdtTangramModule", "handleClick params invalid");
    }
    while (paramPromise != null)
    {
      paramPromise.resolve(null);
      return;
      GdtHandler.Params localParams = new GdtHandler.Params();
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
        localParams.jdField_c_of_type_Int = BaseApplicationImpl.sProcessId;
        localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(Foreground.getTopActivity());
        if (this.hippyReceiver == null)
        {
          this.hippyReceiver = new GdtAppReceiver();
          this.hippyReceiver.register(BaseApplication.getContext().getApplicationContext());
        }
        localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.hippyReceiver);
        localParams.jdField_a_of_type_JavaLangClass = GdtVideoCeilingFragmentForJS.class;
        localParams.jdField_b_of_type_JavaLangClass = GdtCanvasFragmentForJS.class;
        localParams.jdField_c_of_type_JavaLangClass = GdtBaseHalfScreenFragmentForJs.class;
        for (;;)
        {
          try
          {
            paramHippyMap = paramHippyMap.getJSONObject("options");
            if (TextUtils.isEmpty(paramHippyMap.getString("refSid"))) {
              continue;
            }
            paramHippyMap = paramHippyMap.getString("refSid");
            localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
            localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", paramHippyMap);
          }
          catch (JSONException paramHippyMap)
          {
            paramHippyMap.printStackTrace();
            continue;
          }
          GdtHandler.a(localParams);
          break;
          paramHippyMap = null;
        }
      }
    }
    AdLog.e("GdtTangramModule", "handleClick promise is null");
  }
  
  @HippyMethod(name="loadAd")
  public void loadAd(HippyMap paramHippyMap, Promise paramPromise)
  {
    AdLog.i("GdtTangramModule", "loadAd");
    HippyMap localHippyMap = new HippyMap();
    if ((paramHippyMap == null) || (paramHippyMap.toJSONObject() == null) || (JSONObject.NULL.equals(paramHippyMap.toJSONObject())))
    {
      localHippyMap.pushInt("code", 997);
      paramPromise.resolve(localHippyMap);
      return;
    }
    paramHippyMap = paramHippyMap.toJSONObject();
    AdLog.i("GdtTangramModule", paramHippyMap.toString());
    this.listener = new GdtTangramModule.GdtTangramModuleAdLoaderListener(new WeakReference(paramPromise));
    paramPromise = new GdtAdLoader.Session();
    paramPromise.a = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGet(), paramHippyMap)));
    new GdtAdLoader(paramPromise, new WeakReference(this.listener)).a(new WeakReference(BaseApplication.getContext()));
  }
  
  @HippyMethod(name="preLoadAfterAdLoaded")
  public void preLoadAfterAdLoaded(HippyMap paramHippyMap, Promise paramPromise)
  {
    AdLog.i("GdtTangramModule", "preLoadAfterAdLoaded");
    if (paramHippyMap == null) {}
    while (paramPromise != null)
    {
      paramPromise.resolve(null);
      return;
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
    AdLog.e("GdtTangramModule", "preLoadAfterAdLoaded promise is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.hippy.GdtTangramModule
 * JD-Core Version:    0.7.0.1
 */