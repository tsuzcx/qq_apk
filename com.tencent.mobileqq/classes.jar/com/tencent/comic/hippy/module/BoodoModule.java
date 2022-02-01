package com.tencent.comic.hippy.module;

import android.app.Activity;
import com.tencent.comic.api.hippy.BoodoModuleProxy;
import com.tencent.comic.api.hippy.IBoodoModule;
import com.tencent.comic.hippy.BoodoHippyBirdge;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.module.QQBaseWebIpcModule;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

@HippyNativeModule(name="BoodoModule")
public class BoodoModule
  extends QQBaseWebIpcModule
  implements IBoodoModule
{
  static final String CLASSNAME = "BoodoModule";
  private static final String TAG = "BoodoModule";
  private BoodoModuleProxy mModuleProxy;
  
  public BoodoModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
    QLog.i("BoodoModule", 1, "BoodoModule init");
  }
  
  private void checkInitModule()
  {
    if (this.mModuleProxy == null) {
      this.mModuleProxy = BoodoHippyBirdge.createBoodoModuleImp();
    }
    BoodoModuleProxy localBoodoModuleProxy = this.mModuleProxy;
  }
  
  public void destroy()
  {
    super.destroy();
    QLog.d("HippyQQComicModule", 2, "HippyQQComicModule destroy");
    com.tencent.comic.data.VipComicDataHelper.r = false;
  }
  
  public void doPromiseCallback(Promise paramPromise, int paramInt, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", paramInt);
      localJSONObject.put("message", paramString);
      doPromiseCallback(paramPromise, localJSONObject);
      return;
    }
    catch (JSONException paramPromise)
    {
      QLog.e("BoodoModule", 1, paramPromise, new Object[0]);
    }
  }
  
  public void doPromiseCallback(Promise paramPromise, JSONObject paramJSONObject)
  {
    if ((paramPromise != null) && (paramPromise.isCallback()))
    {
      Object localObject = new HippyMap();
      ((HippyMap)localObject).pushJSONObject(paramJSONObject);
      paramPromise.resolve(localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doPromiseCallback promise:");
        ((StringBuilder)localObject).append(paramPromise.getCallId());
        ((StringBuilder)localObject).append(" jsonObject:");
        ((StringBuilder)localObject).append(paramJSONObject);
        QLog.d("BoodoModule", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  @HippyMethod(name="downloadComic")
  public void downloadComic(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null)
    {
      if (paramHippyMap != null) {
        paramHippyMap = paramHippyMap.toJSONObject();
      } else {
        paramHippyMap = new JSONObject();
      }
      this.mModuleProxy.callModule(this, "downloadComic", paramHippyMap, paramPromise);
    }
  }
  
  public Activity getActivity()
  {
    return super.getActivity();
  }
  
  @HippyMethod(name="getDownloadList")
  public void getDownloadList(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null)
    {
      if (paramHippyMap != null) {
        paramHippyMap = paramHippyMap.toJSONObject();
      } else {
        paramHippyMap = new JSONObject();
      }
      this.mModuleProxy.callModule(this, "getDownloadList", paramHippyMap, paramPromise);
    }
  }
  
  public HippyEngine getHippyEngine()
  {
    HippyQQEngine localHippyQQEngine = getHippyQQEngine();
    if (localHippyQQEngine != null) {
      return localHippyQQEngine.getHippyEngine();
    }
    return null;
  }
  
  @HippyMethod(name="getPageTrace")
  public void getPageTrace(Promise paramPromise)
  {
    checkInitModule();
    BoodoModuleProxy localBoodoModuleProxy = this.mModuleProxy;
    if (localBoodoModuleProxy != null) {
      localBoodoModuleProxy.callModule(this, "getPageTrace", null, paramPromise);
    }
  }
  
  @HippyMethod(name="getReportInfo")
  public void getReportInfo(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null)
    {
      if (paramHippyMap != null) {
        paramHippyMap = paramHippyMap.toJSONObject();
      } else {
        paramHippyMap = new JSONObject();
      }
      this.mModuleProxy.callModule(this, "getReportInfo", paramHippyMap, paramPromise);
    }
  }
  
  @HippyMethod(name="mainTabAppear")
  public void mainTabAppear(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    com.tencent.comic.data.VipComicDataHelper.r = true;
    QLog.i("BoodoModule", 1, "mainTabAppear has been called");
    if (this.mModuleProxy != null)
    {
      if (paramHippyMap != null) {
        paramHippyMap = paramHippyMap.toJSONObject();
      } else {
        paramHippyMap = new JSONObject();
      }
      this.mModuleProxy.callModule(this, "mainTabAppear", paramHippyMap, paramPromise);
    }
  }
  
  @HippyMethod(name="modifyDownloadStatus")
  public void modifyDownloadStatus(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null)
    {
      if (paramHippyMap != null) {
        paramHippyMap = paramHippyMap.toJSONObject();
      } else {
        paramHippyMap = new JSONObject();
      }
      this.mModuleProxy.callModule(this, "modifyDownloadStatus", paramHippyMap, paramPromise);
    }
  }
  
  @HippyMethod(name="notifyWebStatus")
  public void notifyWebStatus(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null)
    {
      if (paramHippyMap != null) {
        paramHippyMap = paramHippyMap.toJSONObject();
      } else {
        paramHippyMap = new JSONObject();
      }
      this.mModuleProxy.callModule(this, "notifyWebStatus", paramHippyMap, paramPromise);
    }
  }
  
  @HippyMethod(name="openComicIntro")
  public void openComicIntro(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null)
    {
      if (paramHippyMap != null) {
        paramHippyMap = paramHippyMap.toJSONObject();
      } else {
        paramHippyMap = new JSONObject();
      }
      this.mModuleProxy.callModule(this, "openComicIntro", paramHippyMap, paramPromise);
    }
  }
  
  @HippyMethod(name="openDownloadDetail")
  public void openDownloadDetail(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null)
    {
      if (paramHippyMap != null) {
        paramHippyMap = paramHippyMap.toJSONObject();
      } else {
        paramHippyMap = new JSONObject();
      }
      this.mModuleProxy.callModule(this, "openDownloadDetail", paramHippyMap, paramPromise);
    }
  }
  
  @HippyMethod(name="openVideoAdv")
  public void openVideoAdv(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null)
    {
      if (paramHippyMap != null) {
        paramHippyMap = paramHippyMap.toJSONObject();
      } else {
        paramHippyMap = new JSONObject();
      }
      this.mModuleProxy.callModule(this, "openVideoAdv", paramHippyMap, paramPromise);
    }
  }
  
  @HippyMethod(name="popPage")
  public void popPage()
  {
    checkInitModule();
    BoodoModuleProxy localBoodoModuleProxy = this.mModuleProxy;
    if (localBoodoModuleProxy != null) {
      localBoodoModuleProxy.callModule(this, "popPage", null, null);
    }
  }
  
  @HippyMethod(name="pushPage")
  public void pushPage(HippyMap paramHippyMap)
  {
    checkInitModule();
    if (this.mModuleProxy != null)
    {
      if (paramHippyMap != null) {
        paramHippyMap = paramHippyMap.toJSONObject();
      } else {
        paramHippyMap = new JSONObject();
      }
      this.mModuleProxy.callModule(this, "pushPage", paramHippyMap, null);
    }
  }
  
  @HippyMethod(name="pushPageStack")
  public void pushPageStack(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null)
    {
      if (paramHippyMap != null) {
        paramHippyMap = paramHippyMap.toJSONObject();
      } else {
        paramHippyMap = new JSONObject();
      }
      this.mModuleProxy.callModule(this, "pushPageStack", paramHippyMap, paramPromise);
    }
  }
  
  @HippyMethod(name="queryDownloadProgress")
  public void queryDownloadProgress(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null)
    {
      if (paramHippyMap != null) {
        paramHippyMap = paramHippyMap.toJSONObject();
      } else {
        paramHippyMap = new JSONObject();
      }
      this.mModuleProxy.callModule(this, "queryDownloadProgress", paramHippyMap, paramPromise);
    }
  }
  
  @HippyMethod(name="report")
  public void report(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null)
    {
      if (paramHippyMap != null) {
        paramHippyMap = paramHippyMap.toJSONObject();
      } else {
        paramHippyMap = new JSONObject();
      }
      this.mModuleProxy.callModule(this, "report", paramHippyMap, paramPromise);
    }
  }
  
  @HippyMethod(name="reportDC01327")
  public void reportDC01327(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null)
    {
      if (paramHippyMap != null) {
        paramHippyMap = paramHippyMap.toJSONObject();
      } else {
        paramHippyMap = new JSONObject();
      }
      this.mModuleProxy.callModule(this, "reportDC01327", paramHippyMap, null);
    }
  }
  
  @HippyMethod(name="startRead")
  public void startRead(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null)
    {
      if (paramHippyMap != null) {
        paramHippyMap = paramHippyMap.toJSONObject();
      } else {
        paramHippyMap = new JSONObject();
      }
      this.mModuleProxy.callModule(this, "startRead", paramHippyMap, paramPromise);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.hippy.module.BoodoModule
 * JD-Core Version:    0.7.0.1
 */