package com.tencent.hippy.qq.api;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForMultiProcess;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QPublicFragmentActivityLandscape;
import com.tencent.mobileqq.activity.QPublicFragmentActivityLandscapeForMultiProcess;
import com.tencent.mobileqq.activity.QPublicFragmentActivityLandscapeForTool;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityForMultiProcess;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityForTool;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityLandscape;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityLandscapeForMultiProcess;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityLandscapeForTool;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.common.HippyMap;
import java.util.HashMap;
import org.json.JSONObject;

public class OpenHippyInfo
{
  public static final String EXTRA_KEY_BUNDLE_NAME = "bundleName";
  public static final String EXTRA_KEY_BUNDLE_URL = "bundleUrl";
  public static final String EXTRA_KEY_DOMAIN = "domain";
  public static final String EXTRA_KEY_ERROR_URL = "errorUrl";
  public static final String EXTRA_KEY_FRAMEWORK = "framework";
  public static final String EXTRA_KEY_FROM = "from";
  public static final String EXTRA_KEY_IS_ANIMATED = "isAnimated";
  public static final String EXTRA_KEY_IS_DISABLE_PRELOAD = "isDisablePreload";
  public static final String EXTRA_KEY_IS_ENABLE_RIGHT_FLING = "isEnbaleRightFling";
  private static final String EXTRA_KEY_IS_IN_TOOL_PROCESS = "isInToolProcess";
  public static final String EXTRA_KEY_IS_LANDSCAPE_SCREEN = "isLandscapeScreen";
  public static final String EXTRA_KEY_IS_PREDRAW = "isPredraw";
  public static final String EXTRA_KEY_IS_PREDRAW_WHEN_CLOSED = "isPredrawWhenClosed";
  public static final String EXTRA_KEY_IS_PRELOAD = "isPreload";
  public static final String EXTRA_KEY_IS_PRELOAD_WHEN_CLOSED = "isPreloadWhenClosed";
  public static final String EXTRA_KEY_IS_STATUSBAR_DARKFONT = "isStatusBarDarkFont";
  public static final String EXTRA_KEY_IS_TRANSPARENT = "isTransparent";
  public static final String EXTRA_KEY_JS_PARAM_MAP = "js_param_map";
  public static final String EXTRA_KEY_PAGE_URL = "url";
  public static final String EXTRA_KEY_PARAMS = "params";
  public static final String EXTRA_KEY_PROCESS_NAME = "processName";
  public static final String PROCESS_NAME_LOCAL = "local";
  public static final String PROCESS_NAME_MAIN = "main";
  public static final String PROCESS_NAME_TOOL = "tool";
  public static final String TAG = "HippyAccessHelper";
  public Class<? extends QPublicFragmentActivity> activityClass;
  public String bundleName = null;
  public String bundleUrl = null;
  public String domain = null;
  public String errorUrl = null;
  public Class<? extends QPublicBaseFragment> fragmentClass;
  public String framework = null;
  public String from = null;
  public boolean isAnimated = false;
  public boolean isDisablePreload = false;
  public boolean isEnbaleRightFling = false;
  private boolean isInToolProcess = false;
  public boolean isLandscapeScreen = false;
  public boolean isPredraw = false;
  public boolean isPredrawWhenClosed = false;
  public boolean isPreload = false;
  public boolean isPreloadFromExitPage = false;
  public boolean isPreloadWhenClosed = false;
  public boolean isStatusBarDarkFont = false;
  public boolean isTransparent = false;
  public SerializableMap mExtraMap;
  public String processName = null;
  public String url = null;
  
  public OpenHippyInfo() {}
  
  public OpenHippyInfo(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    this.bundleName = paramBundle.getString("bundleName");
    this.domain = paramBundle.getString("domain");
    this.url = paramBundle.getString("url");
    this.errorUrl = paramBundle.getString("errorUrl");
    this.isPreload = paramBundle.getBoolean("isPreload");
    this.isPreloadWhenClosed = paramBundle.getBoolean("isPreloadWhenClosed");
    this.isPredraw = paramBundle.getBoolean("isPredraw");
    this.isPredrawWhenClosed = paramBundle.getBoolean("isPredrawWhenClosed");
    this.isDisablePreload = paramBundle.getBoolean("isDisablePreload");
    this.isAnimated = paramBundle.getBoolean("isAnimated");
    this.isTransparent = paramBundle.getBoolean("isTransparent");
    this.isStatusBarDarkFont = paramBundle.getBoolean("isStatusBarDarkFont");
    this.processName = paramBundle.getString("processName");
    this.isInToolProcess = paramBundle.getBoolean("isInToolProcess");
    this.isLandscapeScreen = paramBundle.getBoolean("isLandscapeScreen");
    this.mExtraMap = ((SerializableMap)paramBundle.getSerializable("js_param_map"));
    this.isEnbaleRightFling = paramBundle.getBoolean("isEnbaleRightFling");
    this.from = paramBundle.getString("from");
    this.bundleUrl = paramBundle.getString("bundleUrl");
    this.framework = paramBundle.getString("framework");
  }
  
  public OpenHippyInfo(HippyMap paramHippyMap)
  {
    if (paramHippyMap == null) {
      return;
    }
    this.bundleName = paramHippyMap.getString("bundleName");
    this.domain = paramHippyMap.getString("domain");
    this.url = paramHippyMap.getString("url");
    this.errorUrl = paramHippyMap.getString("errorUrl");
    this.isPreload = paramHippyMap.getBoolean("isPreload");
    this.isPreloadWhenClosed = paramHippyMap.getBoolean("isPreloadWhenClosed");
    this.isPredraw = paramHippyMap.getBoolean("isPredraw");
    this.isPredrawWhenClosed = paramHippyMap.getBoolean("isPredrawWhenClosed");
    this.isDisablePreload = paramHippyMap.getBoolean("isDisablePreload");
    this.isAnimated = paramHippyMap.getBoolean("isAnimated");
    this.isTransparent = paramHippyMap.getBoolean("isTransparent");
    this.isStatusBarDarkFont = paramHippyMap.getBoolean("isStatusBarDarkFont");
    this.processName = paramHippyMap.getString("processName");
    this.isInToolProcess = paramHippyMap.getBoolean("isInToolProcess");
    this.isLandscapeScreen = paramHippyMap.getBoolean("isLandscapeScreen");
    this.isEnbaleRightFling = paramHippyMap.getBoolean("isEnbaleRightFling");
    this.from = paramHippyMap.getString("from");
    this.bundleUrl = paramHippyMap.getString("bundleUrl");
    this.framework = paramHippyMap.getString("framework");
  }
  
  public OpenHippyInfo(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    this.bundleName = ((String)paramHashMap.get("bundleName"));
    this.domain = ((String)paramHashMap.get("domain"));
    this.url = ((String)paramHashMap.get("url"));
    this.errorUrl = ((String)paramHashMap.get("errorUrl"));
    this.isPreload = Boolean.parseBoolean((String)paramHashMap.get("isPreload"));
    this.isPreloadWhenClosed = Boolean.parseBoolean((String)paramHashMap.get("isPreloadWhenClosed"));
    this.isPredraw = Boolean.parseBoolean((String)paramHashMap.get("isPredraw"));
    this.isPredrawWhenClosed = Boolean.parseBoolean((String)paramHashMap.get("isPredrawWhenClosed"));
    this.isDisablePreload = Boolean.parseBoolean((String)paramHashMap.get("isDisablePreload"));
    this.isAnimated = Boolean.parseBoolean((String)paramHashMap.get("isAnimated"));
    this.isTransparent = Boolean.parseBoolean((String)paramHashMap.get("isTransparent"));
    this.isStatusBarDarkFont = Boolean.parseBoolean((String)paramHashMap.get("isStatusBarDarkFont"));
    this.processName = ((String)paramHashMap.get("processName"));
    this.isInToolProcess = Boolean.parseBoolean((String)paramHashMap.get("isInToolProcess"));
    this.isLandscapeScreen = Boolean.parseBoolean((String)paramHashMap.get("isLandscapeScreen"));
    this.isEnbaleRightFling = Boolean.parseBoolean((String)paramHashMap.get("isEnbaleRightFling"));
    this.from = ((String)paramHashMap.get("from"));
    this.bundleUrl = ((String)paramHashMap.get("bundleUrl"));
    this.framework = ((String)paramHashMap.get("framework"));
  }
  
  public OpenHippyInfo(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.bundleName = paramJSONObject.optString("bundleName");
    this.domain = paramJSONObject.optString("domain");
    this.url = paramJSONObject.optString("url");
    this.errorUrl = paramJSONObject.optString("errorUrl");
    this.isPreload = paramJSONObject.optBoolean("isPreload");
    this.isPreloadWhenClosed = paramJSONObject.optBoolean("isPreloadWhenClosed");
    this.isPredraw = paramJSONObject.optBoolean("isPredraw");
    this.isPredrawWhenClosed = paramJSONObject.optBoolean("isPredrawWhenClosed");
    this.isDisablePreload = paramJSONObject.optBoolean("isDisablePreload");
    this.isAnimated = paramJSONObject.optBoolean("isAnimated");
    this.isTransparent = paramJSONObject.optBoolean("isTransparent");
    this.isStatusBarDarkFont = paramJSONObject.optBoolean("isStatusBarDarkFont");
    this.processName = paramJSONObject.optString("processName");
    this.isInToolProcess = paramJSONObject.optBoolean("isInToolProcess");
    this.isLandscapeScreen = paramJSONObject.optBoolean("isLandscapeScreen");
    this.isEnbaleRightFling = paramJSONObject.optBoolean("isEnbaleRightFling");
    this.from = paramJSONObject.optString("from");
    this.bundleUrl = paramJSONObject.optString("bundleUrl");
    this.framework = paramJSONObject.optString("framework");
  }
  
  private Class<? extends QPublicFragmentActivity> getMainProcessStartActivityClass()
  {
    if (this.isTransparent)
    {
      if (this.isLandscapeScreen) {
        return QPublicTransFragmentActivityLandscape.class;
      }
      return QPublicTransFragmentActivity.class;
    }
    if (this.isLandscapeScreen) {
      return QPublicFragmentActivityLandscape.class;
    }
    return QPublicFragmentActivity.class;
  }
  
  private Class<? extends QPublicFragmentActivity> getMultiProcessStartActivityClass()
  {
    if (this.isTransparent)
    {
      if (this.isLandscapeScreen) {
        return QPublicTransFragmentActivityLandscapeForMultiProcess.class;
      }
      return QPublicTransFragmentActivityForMultiProcess.class;
    }
    if (this.isLandscapeScreen) {
      return QPublicFragmentActivityLandscapeForMultiProcess.class;
    }
    return QPublicFragmentActivityForMultiProcess.class;
  }
  
  private Class<? extends QPublicFragmentActivity> getToolProcessStartActivityClass()
  {
    if (this.isTransparent)
    {
      if (this.isLandscapeScreen) {
        return QPublicTransFragmentActivityLandscapeForTool.class;
      }
      return QPublicTransFragmentActivityForTool.class;
    }
    if (this.isLandscapeScreen) {
      return QPublicFragmentActivityLandscapeForTool.class;
    }
    return QPublicFragmentActivityForTool.class;
  }
  
  public boolean checkData()
  {
    return (!TextUtils.isEmpty(this.bundleName)) || (getProcessName() == null);
  }
  
  public String getProcessName()
  {
    if (!TextUtils.isEmpty(this.processName))
    {
      if ((!this.processName.equals("main")) && (!this.processName.equals("tool")) && (!this.processName.equals("local"))) {
        return null;
      }
      return this.processName;
    }
    if (this.isInToolProcess) {
      return "tool";
    }
    return "main";
  }
  
  public Class<? extends QPublicFragmentActivity> getStartActivityClass()
  {
    Object localObject = this.activityClass;
    if (localObject != null) {
      return localObject;
    }
    localObject = getProcessName();
    if ("main".equals(localObject)) {
      return getMainProcessStartActivityClass();
    }
    if ("tool".equals(localObject)) {
      return getToolProcessStartActivityClass();
    }
    if ("local".equals(localObject)) {
      return getMultiProcessStartActivityClass();
    }
    return null;
  }
  
  public Class<? extends QPublicBaseFragment> getStartFragmentClass()
  {
    Class localClass = this.fragmentClass;
    if (localClass != null) {
      return localClass;
    }
    return CommonHippyFragment.class;
  }
  
  public boolean openHippy(Context paramContext)
  {
    if (!checkData()) {
      return false;
    }
    if ((!this.isPreload) && (!this.isPredraw)) {
      return ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).openHippyPage(paramContext, this);
    }
    return ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).checkAndPreloadHippyPage(this);
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("bundleName", this.bundleName);
    localBundle.putString("domain", this.domain);
    localBundle.putString("url", this.url);
    localBundle.putString("errorUrl", this.errorUrl);
    localBundle.putBoolean("isPreload", this.isPreload);
    localBundle.putBoolean("isPreloadWhenClosed", this.isPreloadWhenClosed);
    localBundle.putBoolean("isPredraw", this.isPredraw);
    localBundle.putBoolean("isPredrawWhenClosed", this.isPredrawWhenClosed);
    localBundle.putBoolean("isDisablePreload", this.isDisablePreload);
    localBundle.putBoolean("isAnimated", this.isAnimated);
    localBundle.putBoolean("isTransparent", this.isTransparent);
    localBundle.putBoolean("isStatusBarDarkFont", this.isStatusBarDarkFont);
    localBundle.putString("processName", this.processName);
    localBundle.putBoolean("isInToolProcess", this.isInToolProcess);
    localBundle.putBoolean("isLandscapeScreen", this.isLandscapeScreen);
    localBundle.putSerializable("js_param_map", this.mExtraMap);
    localBundle.putBoolean("isEnbaleRightFling", this.isEnbaleRightFling);
    localBundle.putString("from", this.from);
    localBundle.putString("bundleUrl", this.bundleUrl);
    localBundle.putString("framework", this.framework);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.api.OpenHippyInfo
 * JD-Core Version:    0.7.0.1
 */