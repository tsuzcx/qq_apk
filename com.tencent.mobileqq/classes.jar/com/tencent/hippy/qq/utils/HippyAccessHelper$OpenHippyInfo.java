package com.tencent.hippy.qq.utils;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mtt.hippy.common.HippyMap;
import java.util.HashMap;
import org.json.JSONObject;

public class HippyAccessHelper$OpenHippyInfo
{
  public String bundleName = null;
  public String bundleUrl = null;
  public String errorUrl = null;
  public String framework = null;
  public String from = null;
  public boolean isAnimated = false;
  public boolean isDisablePreload = false;
  public boolean isEnbaleRightFling = false;
  public boolean isInToolProcess = false;
  public boolean isPredraw = false;
  public boolean isPredrawWhenClosed = false;
  public boolean isPreload = false;
  public boolean isPreloadWhenClosed = false;
  public boolean isStatusBarDarkFont = false;
  public boolean isTransparent = false;
  public SerializableMap mExtraMap;
  public String url = null;
  
  public HippyAccessHelper$OpenHippyInfo() {}
  
  public HippyAccessHelper$OpenHippyInfo(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    this.bundleName = paramBundle.getString("bundleName");
    this.url = paramBundle.getString("url");
    this.errorUrl = paramBundle.getString("errorUrl");
    this.isPreload = paramBundle.getBoolean("isPreload");
    this.isPreloadWhenClosed = paramBundle.getBoolean("isPreloadWhenClosed");
    this.isPredraw = paramBundle.getBoolean("isPredraw");
    this.isPredrawWhenClosed = paramBundle.getBoolean("isPredrawWhenClosed");
    this.isDisablePreload = paramBundle.getBoolean("isDisablePreload");
    this.isAnimated = paramBundle.getBoolean("isAnimated");
    this.isTransparent = paramBundle.getBoolean("isTrasparent");
    this.isStatusBarDarkFont = paramBundle.getBoolean("isStatusBarDarkFont");
    this.isInToolProcess = paramBundle.getBoolean("isInToolProcess");
    this.mExtraMap = ((SerializableMap)paramBundle.getSerializable("js_param_map"));
    this.isEnbaleRightFling = paramBundle.getBoolean("isEnbaleRightFling");
    this.from = paramBundle.getString("from");
    this.bundleUrl = paramBundle.getString("bundleUrl");
    this.framework = paramBundle.getString("framework");
  }
  
  public HippyAccessHelper$OpenHippyInfo(HippyMap paramHippyMap)
  {
    if (paramHippyMap == null) {
      return;
    }
    this.bundleName = paramHippyMap.getString("bundleName");
    this.url = paramHippyMap.getString("url");
    this.errorUrl = paramHippyMap.getString("errorUrl");
    this.isPreload = paramHippyMap.getBoolean("isPreload");
    this.isPreloadWhenClosed = paramHippyMap.getBoolean("isPreloadWhenClosed");
    this.isPredraw = paramHippyMap.getBoolean("isPredraw");
    this.isPredrawWhenClosed = paramHippyMap.getBoolean("isPredrawWhenClosed");
    this.isDisablePreload = paramHippyMap.getBoolean("isDisablePreload");
    this.isAnimated = paramHippyMap.getBoolean("isAnimated");
    this.isTransparent = paramHippyMap.getBoolean("isTrasparent");
    this.isStatusBarDarkFont = paramHippyMap.getBoolean("isStatusBarDarkFont");
    this.isInToolProcess = paramHippyMap.getBoolean("isInToolProcess");
    this.isEnbaleRightFling = paramHippyMap.getBoolean("isEnbaleRightFling");
    this.from = paramHippyMap.getString("from");
    this.bundleUrl = paramHippyMap.getString("bundleUrl");
    this.framework = paramHippyMap.getString("framework");
  }
  
  public HippyAccessHelper$OpenHippyInfo(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    this.bundleName = ((String)paramHashMap.get("bundleName"));
    this.url = ((String)paramHashMap.get("url"));
    this.errorUrl = ((String)paramHashMap.get("errorUrl"));
    this.isPreload = Boolean.parseBoolean((String)paramHashMap.get("isPreload"));
    this.isPreloadWhenClosed = Boolean.parseBoolean((String)paramHashMap.get("isPreloadWhenClosed"));
    this.isPredraw = Boolean.parseBoolean((String)paramHashMap.get("isPredraw"));
    this.isPredrawWhenClosed = Boolean.parseBoolean((String)paramHashMap.get("isPredrawWhenClosed"));
    this.isDisablePreload = Boolean.parseBoolean((String)paramHashMap.get("isDisablePreload"));
    this.isAnimated = Boolean.parseBoolean((String)paramHashMap.get("isAnimated"));
    this.isTransparent = Boolean.parseBoolean((String)paramHashMap.get("isTrasparent"));
    this.isStatusBarDarkFont = Boolean.parseBoolean((String)paramHashMap.get("isStatusBarDarkFont"));
    this.isInToolProcess = Boolean.parseBoolean((String)paramHashMap.get("isInToolProcess"));
    this.isEnbaleRightFling = Boolean.parseBoolean((String)paramHashMap.get("isEnbaleRightFling"));
    this.from = ((String)paramHashMap.get("from"));
    this.bundleUrl = ((String)paramHashMap.get("bundleUrl"));
    this.framework = ((String)paramHashMap.get("framework"));
  }
  
  public HippyAccessHelper$OpenHippyInfo(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.bundleName = paramJSONObject.optString("bundleName");
    this.url = paramJSONObject.optString("url");
    this.errorUrl = paramJSONObject.optString("errorUrl");
    this.isPreload = paramJSONObject.optBoolean("isPreload");
    this.isPreloadWhenClosed = paramJSONObject.optBoolean("isPreloadWhenClosed");
    this.isPredraw = paramJSONObject.optBoolean("isPredraw");
    this.isPredrawWhenClosed = paramJSONObject.optBoolean("isPredrawWhenClosed");
    this.isDisablePreload = paramJSONObject.optBoolean("isDisablePreload");
    this.isAnimated = paramJSONObject.optBoolean("isAnimated");
    this.isTransparent = paramJSONObject.optBoolean("isTrasparent");
    this.isStatusBarDarkFont = paramJSONObject.optBoolean("isStatusBarDarkFont");
    this.isInToolProcess = paramJSONObject.optBoolean("isInToolProcess");
    this.isEnbaleRightFling = paramJSONObject.optBoolean("isEnbaleRightFling");
    this.from = paramJSONObject.optString("from");
    this.bundleUrl = paramJSONObject.optString("bundleUrl");
    this.framework = paramJSONObject.optString("framework");
  }
  
  private boolean checkData()
  {
    return !TextUtils.isEmpty(this.bundleName);
  }
  
  public boolean openHippy(Context paramContext)
  {
    if (!checkData()) {
      return false;
    }
    if ((this.isPreload) || (this.isPredraw)) {
      return HippyAccessHelper.checkAndPreloadHippyPage(this);
    }
    return HippyAccessHelper.openHippyPage(paramContext, this);
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("bundleName", this.bundleName);
    localBundle.putString("url", this.url);
    localBundle.putString("errorUrl", this.errorUrl);
    localBundle.putBoolean("isPreload", this.isPreload);
    localBundle.putBoolean("isPreloadWhenClosed", this.isPreloadWhenClosed);
    localBundle.putBoolean("isPredraw", this.isPredraw);
    localBundle.putBoolean("isPredrawWhenClosed", this.isPredrawWhenClosed);
    localBundle.putBoolean("isDisablePreload", this.isDisablePreload);
    localBundle.putBoolean("isAnimated", this.isAnimated);
    localBundle.putBoolean("isTrasparent", this.isTransparent);
    localBundle.putBoolean("isStatusBarDarkFont", this.isStatusBarDarkFont);
    localBundle.putBoolean("isInToolProcess", this.isInToolProcess);
    localBundle.putSerializable("js_param_map", this.mExtraMap);
    localBundle.putBoolean("isEnbaleRightFling", this.isEnbaleRightFling);
    localBundle.putString("from", this.from);
    localBundle.putString("bundleUrl", this.bundleUrl);
    localBundle.putString("framework", this.framework);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.HippyAccessHelper.OpenHippyInfo
 * JD-Core Version:    0.7.0.1
 */