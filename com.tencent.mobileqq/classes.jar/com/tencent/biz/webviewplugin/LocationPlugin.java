package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LocationPlugin
  extends WebViewPlugin
{
  public LocationPlugin()
  {
    this.mPluginNameSpace = "location";
  }
  
  private void a(SosoLbsInfo paramSosoLbsInfo, String paramString)
  {
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("lat", paramSosoLbsInfo.mLocation.mLat02);
        localJSONObject1.put("lon", paramSosoLbsInfo.mLocation.mLon02);
        localJSONObject1.put("nation", b(paramSosoLbsInfo.mLocation.nation));
        localJSONObject1.put("province", b(paramSosoLbsInfo.mLocation.province));
        localJSONObject1.put("city", b(paramSosoLbsInfo.mLocation.city));
        localJSONObject1.put("adcode", b(paramSosoLbsInfo.mLocation.cityCode));
        localJSONObject1.put("district", b(paramSosoLbsInfo.mLocation.district));
        localJSONObject1.put("town", b(paramSosoLbsInfo.mLocation.town));
        localJSONObject1.put("village", b(paramSosoLbsInfo.mLocation.village));
        localJSONObject1.put("street", b(paramSosoLbsInfo.mLocation.street));
        localJSONObject1.put("streetNo", b(paramSosoLbsInfo.mLocation.streetNo));
        Object localObject = paramSosoLbsInfo.mLocation.poi;
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          paramSosoLbsInfo = new JSONArray();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            TencentPoi localTencentPoi = (TencentPoi)((Iterator)localObject).next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("name", b(localTencentPoi.getName()));
            localJSONObject2.put("addr", b(localTencentPoi.getAddress()));
            localJSONObject2.put("distance", localTencentPoi.getDistance());
            localJSONObject2.put("catalog", b(localTencentPoi.getCatalog()));
            localJSONObject2.put("lat", localTencentPoi.getLatitude());
            localJSONObject2.put("lon", localTencentPoi.getLongitude());
            paramSosoLbsInfo.put(localJSONObject2);
          }
          localJSONObject1.put("pois", paramSosoLbsInfo);
        }
        callJs(paramString, new String[] { "0", localJSONObject1.toString() });
        return;
      }
      catch (Exception paramSosoLbsInfo)
      {
        QLog.e("LocationPlugin", 1, "onLocationFinish Failed!", paramSosoLbsInfo);
        callJs(paramString, new String[] { "-5", "{}" });
        return;
      }
    }
    callJs(paramString, new String[] { "-4", "{}" });
  }
  
  private String b(String paramString)
  {
    if ((paramString != null) && (!"Unknown".equals(paramString))) {
      return paramString;
    }
    return "";
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getPois:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("LocationPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if (this.mRuntime.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("LocationPlugin", 2, "getWebView()==null, return");
      }
      return;
    }
    Activity localActivity = this.mRuntime.d();
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      localObject = paramString;
      if (paramString.charAt(0) == '{') {
        try
        {
          paramString = new JSONObject(paramString);
          localObject = paramString.getString("callback");
          paramString.optLong("allowCacheTime", 0L);
        }
        catch (JSONException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.w("LocationPlugin", 2, "getLocation exception:", paramString);
          }
          return;
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if ((localActivity instanceof AppActivity))
        {
          paramString = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("webview");
          if ((paramString != null) && (paramString.mLocation != null) && (paramString.mLocation.poi != null) && (paramString.mLocation.poi.size() > 0))
          {
            a(paramString, (String)localObject);
            return;
          }
          ((AppActivity)localActivity).requestPermissions(new LocationPlugin.1(this, (String)localObject), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
          return;
        }
        callJs((String)localObject, new String[] { "-4", "{}" });
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("LocationPlugin", 2, "context==null || isFinishing, return");
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramJsBridgeListener = paramVarArgs[0];
    if ("getLocationWithPoi".equals(paramString3)) {
      a(paramJsBridgeListener);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.LocationPlugin
 * JD-Core Version:    0.7.0.1
 */