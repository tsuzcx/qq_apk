package com.tencent.hippy.qq.module.gamecenter;

import abet;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import bftf;
import bide;
import bifs;
import bifx;
import bldr;
import bldt;
import bldu;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@HippyNativeModule(name="QQWadlModule")
public class QQWadlModule
  extends QQBaseModule
{
  static final String TAG = "QQWadlModule";
  private volatile bldr mWadlCallback;
  private final bifs mWadlJsBridgeCall = new bifs(null, null);
  
  public QQWadlModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private void sendEvent(String paramString, Object paramObject)
  {
    ((EventDispatcher)this.mContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(paramString, paramObject);
  }
  
  public static HippyMap toHippyMap(WadlResult paramWadlResult)
  {
    HippyMap localHippyMap = new HippyMap();
    if ((paramWadlResult != null) && (paramWadlResult.a != null))
    {
      WadlParams localWadlParams = paramWadlResult.a;
      localHippyMap.pushString("appid", localWadlParams.jdField_a_of_type_JavaLangString);
      localHippyMap.pushInt("state", bifx.a(paramWadlResult.b));
      localHippyMap.pushInt("pro", paramWadlResult.d);
      localHippyMap.pushString("packagename", localWadlParams.f);
      localHippyMap.pushInt("ismyapp", 0);
      localHippyMap.pushInt("download_from", 0);
      localHippyMap.pushInt("realDownloadType", 0);
      localHippyMap.pushString("via", localWadlParams.l);
      localHippyMap.pushInt("writecodestate", 0);
      localHippyMap.pushString("extraInfo", localWadlParams.o);
      localHippyMap.pushBoolean("isAutoInstallBySDK", localWadlParams.a(1));
      localHippyMap.pushBoolean("isRes", localWadlParams.jdField_a_of_type_Boolean);
      int i = bifx.b(paramWadlResult.c);
      localHippyMap.pushInt("errorCode", i);
      localHippyMap.pushString("errorMsg", bifx.a(i));
    }
    return localHippyMap;
  }
  
  @HippyMethod(name="checkUpdate")
  public void checkUpdate(String paramString1, String paramString2, Promise paramPromise)
  {
    if (paramPromise == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQWadlModule", 2, "checkUpdate params=" + paramString1 + ",guid=" + paramString2);
    }
    try
    {
      Object localObject = new JSONObject(paramString1);
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = ((JSONObject)localObject).optString("guid");
      }
      paramString2 = new ArrayList();
      localObject = ((JSONObject)localObject).optJSONArray("packageNames");
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          paramString2.add(((JSONArray)localObject).getString(i));
          i += 1;
        }
      }
      bide.a().a(new QQWadlModule.CheckUpdateCallback(paramString1, paramPromise));
      bide.a().a(paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      QLog.e("QQWadlModule", 1, paramString1, new Object[0]);
    }
  }
  
  @HippyMethod(name="deleteDownload")
  public void deleteDownload(String paramString)
  {
    QLog.i("QQWadlModule", 1, "deleteDownload appid=" + paramString);
    bldt.a().c(0, paramString);
  }
  
  public void destroy()
  {
    super.destroy();
    unregisterListener();
  }
  
  @HippyMethod(name="doDownloadAction")
  public void doDownloadAction(String paramString, Promise paramPromise)
  {
    int i = this.mWadlJsBridgeCall.a(paramString, false, 0, "");
    QLog.i("QQWadlModule", 1, "doDownloadAction jsonParams=" + paramString + ", result=" + i);
    if (paramPromise != null) {
      paramPromise.resolve(Integer.valueOf(i));
    }
  }
  
  @HippyMethod(name="getAvailableBytes")
  public void getAvailableBytes(Promise paramPromise)
  {
    if (paramPromise != null) {}
    try
    {
      paramPromise.resolve(Long.valueOf(bftf.b()));
      return;
    }
    catch (Exception localException)
    {
      paramPromise.resolve(Integer.valueOf(0));
    }
  }
  
  @HippyMethod(name="getInstalledAppVersionCode")
  public void getInstalledAppVersionCode(String paramString1, String paramString2, Promise paramPromise)
  {
    if (paramPromise == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQWadlModule", 2, new Object[] { "getInstalledAppVersionCode packageNameJsonStr=", paramString1, ",guid=", paramString2 });
    }
    String str1 = paramString2;
    try
    {
      Object localObject1 = new JSONObject(paramString1);
      paramString1 = paramString2;
      str1 = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        str1 = paramString2;
        paramString1 = ((JSONObject)localObject1).optString("guid");
      }
      str1 = paramString1;
      JSONArray localJSONArray2 = ((JSONObject)localObject1).optJSONArray("packageNames");
      str1 = paramString1;
      JSONArray localJSONArray1 = new JSONArray();
      if (localJSONArray2 != null)
      {
        int i = 0;
        for (;;)
        {
          str1 = paramString1;
          if (i >= localJSONArray2.length()) {
            break;
          }
          str1 = paramString1;
          String str3 = localJSONArray2.getString(i);
          str1 = paramString1;
          Object localObject2 = abet.a(str3);
          String str2 = "";
          localObject1 = "";
          paramString2 = "";
          if (localObject2 != null)
          {
            str1 = paramString1;
            str2 = String.valueOf(((PackageInfo)localObject2).versionCode);
            str1 = paramString1;
            localObject1 = ((PackageInfo)localObject2).versionName;
            str1 = paramString1;
            paramString2 = abet.d(abet.c(str3));
          }
          str1 = paramString1;
          localObject2 = new JSONObject();
          str1 = paramString1;
          ((JSONObject)localObject2).put("packageName", str3);
          str1 = paramString1;
          ((JSONObject)localObject2).put("versionCode", str2);
          str1 = paramString1;
          ((JSONObject)localObject2).put("versionName", localObject1);
          str1 = paramString1;
          ((JSONObject)localObject2).put("channel", paramString2);
          str1 = paramString1;
          localJSONArray1.put(localObject2);
          i += 1;
        }
      }
      str1 = paramString1;
      paramString2 = new HippyMap();
      str1 = paramString1;
      paramString2.pushString("guid", paramString1);
      str1 = paramString1;
      paramString2.pushInt("r", 0);
      str1 = paramString1;
      paramString2.pushString("data", localJSONArray1.toString());
      str1 = paramString1;
      paramPromise.resolve(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1 = new HippyMap();
      paramString1.pushString("guid", str1);
      paramString1.pushInt("r", -1);
      paramPromise.resolve(paramString1);
    }
  }
  
  @HippyMethod(name="getQueryDownloadAction")
  public void getQueryDownloadAction(String paramString, Promise paramPromise)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("QQWadlModule", 2, new Object[] { "getQueryDownloadAction, jsonParams=", paramString });
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("infolist");
        int j = paramString.length();
        paramPromise = new ArrayList();
        if (i < j)
        {
          String str = paramString.getJSONObject(i).optString("appid");
          if (TextUtils.isEmpty(str)) {
            break label123;
          }
          paramPromise.add(str);
        }
      }
      catch (Exception paramString)
      {
        QLog.e("QQWadlModule", 1, "query getQueryDownloadAction>>>", paramString);
        return;
      }
      if (paramPromise.size() > 0)
      {
        bldt.a().a(paramPromise);
        return;
        label123:
        i += 1;
      }
    }
  }
  
  @HippyMethod(name="queryAllDownloadTask")
  public void queryAllDownloadTask()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQWadlModule", 2, "queryAllDownloadTask");
    }
    bldt.a().b();
  }
  
  @HippyMethod(name="registerListener")
  public void registerListener()
  {
    if (this.mWadlCallback == null)
    {
      this.mWadlCallback = new QQWadlModule.1(this);
      bldt.a().a(this.mWadlCallback);
    }
  }
  
  @HippyMethod(name="unregisterListener")
  public void unregisterListener()
  {
    if (this.mWadlCallback != null)
    {
      bldt.a().b(this.mWadlCallback);
      this.mWadlCallback = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.gamecenter.QQWadlModule
 * JD-Core Version:    0.7.0.1
 */