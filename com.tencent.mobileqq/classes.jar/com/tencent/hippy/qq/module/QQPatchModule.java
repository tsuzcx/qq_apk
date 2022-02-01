package com.tencent.hippy.qq.module;

import com.tencent.hippy.qq.api.IPatchBundleDataHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

@HippyNativeModule(name="QQPatchModule")
public class QQPatchModule
  extends QQBaseLifecycleModule
{
  public static final String CLASSNAME = "QQPatchModule";
  private static final String TAG = "QQPatchModule";
  private HashSet<String> mLoadedBundlePaths = new HashSet();
  
  public QQPatchModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private static void doPromiseCallback(Promise paramPromise, int paramInt, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", paramInt);
      localJSONObject.put("message", paramString);
      doPromiseCallback(paramPromise, localJSONObject);
      return;
    }
    catch (Exception paramPromise)
    {
      QLog.e("QQPatchModule", 1, "doPromiseCallback", paramPromise);
      return;
    }
    catch (JSONException paramPromise)
    {
      QLog.e("QQPatchModule", 1, "doPromiseCallback", paramPromise);
    }
  }
  
  private static void doPromiseCallback(Promise paramPromise, JSONObject paramJSONObject)
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
        QLog.d("QQPatchModule", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void loadPatchFromUrl(String paramString, int paramInt, Promise paramPromise)
  {
    ((IPatchBundleDataHandler)QRoute.api(IPatchBundleDataHandler.class)).loadPatchFromUrl(this.mContext, paramString, paramInt, paramPromise);
  }
  
  public static void promiseSSOData(Promise paramPromise, int paramInt, String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", paramInt);
      localJSONObject.put("message", paramString1);
      localJSONObject.put("data", paramString2);
      doPromiseCallback(paramPromise, localJSONObject);
      return;
    }
    catch (Exception paramPromise)
    {
      QLog.e("QQPatchModule", 1, "promiseSSOData ", paramPromise);
      return;
    }
    catch (JSONException paramPromise)
    {
      QLog.e("QQPatchModule", 1, "promiseSSOData ", paramPromise);
    }
  }
  
  public void destroy()
  {
    super.destroy();
    this.mLoadedBundlePaths.clear();
  }
  
  @HippyMethod(name="getSSOListData")
  public void getSSOListData(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null)
    {
      if (paramPromise == null) {
        return;
      }
      ((IPatchBundleDataHandler)QRoute.api(IPatchBundleDataHandler.class)).getSSOListData(paramHippyMap, paramPromise);
    }
  }
  
  @HippyMethod(name="loadPatchBundle")
  public void loadPatchBundle(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null)
    {
      if (paramPromise == null) {
        return;
      }
      String str = paramHippyMap.getString("url");
      paramHippyMap.getString("bundleName");
      int i = paramHippyMap.getInt("instanceId");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadPatchBundle data:");
        localStringBuilder.append(paramHippyMap);
        QLog.d("QQPatchModule", 2, localStringBuilder.toString());
      }
      loadPatchFromUrl(str, i, paramPromise);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQPatchModule
 * JD-Core Version:    0.7.0.1
 */