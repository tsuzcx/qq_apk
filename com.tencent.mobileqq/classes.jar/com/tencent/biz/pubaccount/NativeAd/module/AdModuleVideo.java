package com.tencent.biz.pubaccount.NativeAd.module;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class AdModuleVideo
  extends AdModuleBase
{
  public long a;
  public AdModuleVideo.AdAppInfo a;
  public int d;
  public String d;
  public String e;
  public String f;
  
  public static AdModuleVideo a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    AdModuleVideo localAdModuleVideo;
    Object localObject;
    for (;;)
    {
      return null;
      localAdModuleVideo = new AdModuleVideo();
      try
      {
        localObject = paramJSONObject.optJSONObject("video");
        if (localObject != null)
        {
          localAdModuleVideo.e = ((JSONObject)localObject).optString("coverUrl");
          localAdModuleVideo.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("videoUrl");
          if (TextUtils.isEmpty(localAdModuleVideo.jdField_d_of_type_JavaLangString))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("AdModuleVideo", 2, "video url is null");
            return null;
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return null;
      }
    }
    localAdModuleVideo.jdField_a_of_type_Long = paramJSONObject.optLong("duration");
    localAdModuleVideo.jdField_d_of_type_Int = paramJSONObject.optInt("mixType");
    localAdModuleVideo.f = paramJSONObject.optString("linkUrl");
    paramJSONObject = paramJSONObject.optString("appInfo");
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramJSONObject = new JSONObject(paramJSONObject);
      localObject = new AdModuleVideo.AdAppInfo();
      ((AdModuleVideo.AdAppInfo)localObject).a = paramJSONObject.optString("appid");
      ((AdModuleVideo.AdAppInfo)localObject).b = paramJSONObject.optString("scheme");
      ((AdModuleVideo.AdAppInfo)localObject).c = paramJSONObject.optString("packageName");
      ((AdModuleVideo.AdAppInfo)localObject).jdField_d_of_type_JavaLangString = paramJSONObject.optString("androidDownloadUrl");
      ((AdModuleVideo.AdAppInfo)localObject).e = paramJSONObject.optString("appName");
      localAdModuleVideo.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo$AdAppInfo = ((AdModuleVideo.AdAppInfo)localObject);
    }
    return localAdModuleVideo;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.module.AdModuleVideo
 * JD-Core Version:    0.7.0.1
 */