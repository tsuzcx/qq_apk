package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.open.business.base.AppUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

@HippyNativeModule(name="QQDeviceModule")
public class QQDeviceModule
  extends QQBaseModule
{
  static final String CLASSNAME = "QQDeviceModule";
  
  public QQDeviceModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="getClientInfo")
  public void getClientInfo(Promise paramPromise)
  {
    String str = AppUtil.a(BaseApplicationImpl.getContext());
    paramPromise.resolve("{\"qqVersion\":\"" + str + "\",\"qqBuild\":\"" + "5105" + "\"}");
  }
  
  @HippyMethod(name="getDeviceInfo")
  public void getDeviceInfo(Promise paramPromise)
  {
    paramPromise.resolve(SensorAPIJavaScript.getDeviceInfoEx("QQDeviceModule"));
  }
  
  @HippyMethod(name="getGdtDeviceInfo")
  public void getGdtDeviceInfo(HippyMap paramHippyMap, Promise paramPromise)
  {
    Object localObject1 = null;
    if (paramHippyMap != null) {}
    for (;;)
    {
      try
      {
        paramHippyMap = paramHippyMap.getString("businessIdForAidTicketAndTaidTicket");
        if (TextUtils.isEmpty(paramHippyMap))
        {
          paramHippyMap = GdtDeviceInfoHelper.a(BaseApplication.getContext());
          paramHippyMap = GdtJsonPbUtil.a(paramHippyMap);
          if ((paramHippyMap instanceof JSONObject)) {
            paramPromise.resolve(((JSONObject)paramHippyMap).toString());
          }
        }
        else
        {
          Object localObject2 = new GdtDeviceInfoHelper.Params();
          ((GdtDeviceInfoHelper.Params)localObject2).a = paramHippyMap;
          localObject2 = GdtDeviceInfoHelper.a(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject2);
          paramHippyMap = localObject1;
          if (localObject2 == null) {
            continue;
          }
          paramHippyMap = ((GdtDeviceInfoHelper.Result)localObject2).a;
          continue;
        }
        paramHippyMap = null;
      }
      catch (Throwable paramHippyMap)
      {
        QLog.e("QQDeviceModule", 1, "getGdtDeviceInfo e:" + paramHippyMap);
        paramPromise.resolve("");
        return;
      }
    }
  }
  
  @HippyMethod(name="getNetworkType")
  public void getNetworkType(Promise paramPromise)
  {
    paramPromise.resolve(Integer.valueOf(HttpUtil.getNetWorkType()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQDeviceModule
 * JD-Core Version:    0.7.0.1
 */