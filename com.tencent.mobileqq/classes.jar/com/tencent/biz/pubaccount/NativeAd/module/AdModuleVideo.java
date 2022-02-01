package com.tencent.biz.pubaccount.NativeAd.module;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class AdModuleVideo
  extends AdModuleBase
{
  public String p;
  public long q;
  public String r;
  public int s;
  public String t;
  public AdModuleVideo.AdAppInfo u;
  
  public static AdModuleVideo a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    AdModuleVideo localAdModuleVideo = new AdModuleVideo();
    try
    {
      Object localObject = paramJSONObject.optJSONObject("video");
      if (localObject != null)
      {
        localAdModuleVideo.r = ((JSONObject)localObject).optString("coverUrl");
        localAdModuleVideo.p = ((JSONObject)localObject).optString("videoUrl");
        if (TextUtils.isEmpty(localAdModuleVideo.p))
        {
          if (!QLog.isColorLevel()) {
            break label196;
          }
          QLog.d("AdModuleVideo", 2, "video url is null");
          return null;
        }
      }
      localAdModuleVideo.q = paramJSONObject.optLong("duration");
      localAdModuleVideo.s = paramJSONObject.optInt("mixType");
      localAdModuleVideo.t = paramJSONObject.optString("linkUrl");
      paramJSONObject = paramJSONObject.optString("appInfo");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        paramJSONObject = new JSONObject(paramJSONObject);
        localObject = new AdModuleVideo.AdAppInfo();
        ((AdModuleVideo.AdAppInfo)localObject).a = paramJSONObject.optString("appid");
        ((AdModuleVideo.AdAppInfo)localObject).b = paramJSONObject.optString("scheme");
        ((AdModuleVideo.AdAppInfo)localObject).c = paramJSONObject.optString("packageName");
        ((AdModuleVideo.AdAppInfo)localObject).d = paramJSONObject.optString("androidDownloadUrl");
        ((AdModuleVideo.AdAppInfo)localObject).e = paramJSONObject.optString("appName");
        localAdModuleVideo.u = ((AdModuleVideo.AdAppInfo)localObject);
      }
      return localAdModuleVideo;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return null;
    }
    label196:
    return null;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.module.AdModuleVideo
 * JD-Core Version:    0.7.0.1
 */