package com.tencent.hippy.qq.module.boodo;

import android.app.Activity;
import android.content.Intent;
import com.tencent.hippy.qq.module.QQBaseWebIpcModule;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicJumpActivity;
import cooperation.comic.utils.BoodoHippyBirdge;
import org.json.JSONException;
import org.json.JSONObject;

@HippyNativeModule(name="BoodoModule")
public class BoodoModule
  extends QQBaseWebIpcModule
{
  static final String CLASSNAME = "BoodoModule";
  private static final String TAG = "BoodoModule";
  public static boolean isInMainTab = false;
  private BoodoModuleProxy mModuleProxy;
  
  public BoodoModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
    QLog.i("BoodoModule", 1, "BoodoModule init");
  }
  
  private void checkInitModule()
  {
    if (this.mModuleProxy == null) {
      this.mModuleProxy = BoodoHippyBirdge.a();
    }
    if (this.mModuleProxy == null) {}
  }
  
  public static void test(Activity paramActivity)
  {
    try
    {
      Intent localIntent = new Intent(paramActivity, VipComicJumpActivity.class);
      JSONObject localJSONObject = new JSONObject("{\"leftViewText\":\"动态\",\"jumpto\":\"com.qqcomic.activity.reader.VipComicPortraitReadingActivity\",\"comic\":{\"comicID\":\"505430\",\"comicPageOffset\":0,\"comicSectionID\":\"19\",\"comicPageID\":\"1161\",\"returnToDetail\":false}}");
      localJSONObject.put("jumpto", "com.qqcomic.activity.reader.VipComicPortraitReadingActivity");
      localIntent.putExtra("options", localJSONObject.toString());
      localIntent.putExtra("click_start_time", System.currentTimeMillis());
      paramActivity.startActivity(localIntent);
      return;
    }
    catch (Throwable paramActivity)
    {
      QLog.e("BoodoModule", 1, paramActivity, new Object[0]);
    }
  }
  
  public void destroy()
  {
    super.destroy();
    QLog.d("HippyQQComicModule", 2, "HippyQQComicModule destroy");
    isInMainTab = false;
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
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushJSONObject(paramJSONObject);
      paramPromise.resolve(localHippyMap);
      if (QLog.isColorLevel()) {
        QLog.d("BoodoModule", 1, "doPromiseCallback promise:" + paramPromise.getCallId() + " jsonObject:" + paramJSONObject);
      }
    }
  }
  
  @HippyMethod(name="downloadComic")
  public void downloadComic(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null) {
      if (paramHippyMap == null) {
        break label35;
      }
    }
    label35:
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mModuleProxy.callModule(this, "downloadComic", paramHippyMap, paramPromise);
      return;
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
    if (this.mModuleProxy != null) {
      if (paramHippyMap == null) {
        break label35;
      }
    }
    label35:
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mModuleProxy.callModule(this, "getDownloadList", paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="getPageTrace")
  public void getPageTrace(Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null) {
      this.mModuleProxy.callModule(this, "getPageTrace", null, paramPromise);
    }
  }
  
  @HippyMethod(name="getReportInfo")
  public void getReportInfo(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null) {
      if (paramHippyMap == null) {
        break label35;
      }
    }
    label35:
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mModuleProxy.callModule(this, "getReportInfo", paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="mainTabAppear")
  public void mainTabAppear(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    isInMainTab = true;
    QLog.i("BoodoModule", 1, "mainTabAppear has been called");
    if (this.mModuleProxy != null) {
      if (paramHippyMap == null) {
        break label47;
      }
    }
    label47:
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mModuleProxy.callModule(this, "mainTabAppear", paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="modifyDownloadStatus")
  public void modifyDownloadStatus(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null) {
      if (paramHippyMap == null) {
        break label35;
      }
    }
    label35:
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mModuleProxy.callModule(this, "modifyDownloadStatus", paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="openComicIntro")
  public void openComicIntro(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null) {
      if (paramHippyMap == null) {
        break label35;
      }
    }
    label35:
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mModuleProxy.callModule(this, "openComicIntro", paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="openDownloadDetail")
  public void openDownloadDetail(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null) {
      if (paramHippyMap == null) {
        break label35;
      }
    }
    label35:
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mModuleProxy.callModule(this, "openDownloadDetail", paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="popPage")
  public void popPage()
  {
    checkInitModule();
    if (this.mModuleProxy != null) {
      this.mModuleProxy.callModule(this, "popPage", null, null);
    }
  }
  
  @HippyMethod(name="pushPage")
  public void pushPage(HippyMap paramHippyMap)
  {
    checkInitModule();
    if (this.mModuleProxy != null) {
      if (paramHippyMap == null) {
        break label35;
      }
    }
    label35:
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mModuleProxy.callModule(this, "pushPage", paramHippyMap, null);
      return;
    }
  }
  
  @HippyMethod(name="pushPageStack")
  public void pushPageStack(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null) {
      if (paramHippyMap == null) {
        break label35;
      }
    }
    label35:
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mModuleProxy.callModule(this, "pushPageStack", paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="queryDownloadProgress")
  public void queryDownloadProgress(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null) {
      if (paramHippyMap == null) {
        break label35;
      }
    }
    label35:
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mModuleProxy.callModule(this, "queryDownloadProgress", paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="report")
  public void report(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null) {
      if (paramHippyMap == null) {
        break label35;
      }
    }
    label35:
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mModuleProxy.callModule(this, "report", paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="reportDC01327")
  public void reportDC01327(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null) {
      if (paramHippyMap == null) {
        break label35;
      }
    }
    label35:
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mModuleProxy.callModule(this, "reportDC01327", paramHippyMap, null);
      return;
    }
  }
  
  @HippyMethod(name="startRead")
  public void startRead(HippyMap paramHippyMap, Promise paramPromise)
  {
    checkInitModule();
    if (this.mModuleProxy != null) {
      if (paramHippyMap == null) {
        break label35;
      }
    }
    label35:
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mModuleProxy.callModule(this, "startRead", paramHippyMap, paramPromise);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.boodo.BoodoModule
 * JD-Core Version:    0.7.0.1
 */