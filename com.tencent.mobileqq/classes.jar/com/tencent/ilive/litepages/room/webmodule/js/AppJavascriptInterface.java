package com.tencent.ilive.litepages.room.webmodule.js;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowConfigServiceInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.utils.NetworkUtil;
import com.tencent.falco.utils.SPUtil;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.base.event.ModuleEventInterface;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.interfaces.RoomPageActionInterface;
import com.tencent.ilive.litepages.room.webmodule.event.ClearLuxuryQueueEvent;
import com.tencent.ilive.litepages.room.webmodule.event.ContentLoadedEvent;
import com.tencent.ilive.litepages.room.webmodule.event.LiteShowLuxuryAnimationEvent;
import com.tencent.ilive.litepages.room.webmodule.event.LoadHtmlSuccessEvent;
import com.tencent.ilive.litepages.room.webmodule.event.LoadRoomInfoErrorEvent;
import com.tencent.ilive.litepages.room.webmodule.event.PreloadLuxuryAnimationEvent;
import com.tencent.ilive.litepages.room.webmodule.event.ScreenModeEvent;
import com.tencent.ilive.litepages.room.webmodule.event.ScrollByWebEvent;
import com.tencent.ilive.litepages.room.webmodule.event.ShowKeyboardRoomEvent;
import com.tencent.ilive.litepages.room.webmodule.event.StopLuxuryAnimationPlayEvent;
import com.tencent.ilive.litepages.room.webmodule.event.WebviewTransmitEvent;
import com.tencent.ilive.litepages.room.webmodule.js.interfaces.BaseLiteAppJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.NewJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.model.RoomExtInfo;
import com.tencent.ilive.pages.room.events.RoomCloseEvent;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.ilivesdk.avplayerservice_interface.PlayerParams;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveWatchMediaInfo;
import com.tencent.ilivesdk.webcomponent.dialog.HalfSizeWebviewDialog;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppJavascriptInterface
  extends BaseLiteAppJavascriptInterface
{
  private static final int HIGH_DEFINITION = 1;
  private static final int LOW_DEFINITION = 3;
  private static final int NWAVERR_VIDEO_PULL_ARRIVE = 9;
  private static final int NWAVERR_VIDEO_RECONN_FAILED = 4;
  private static final int STANDARD_DEFINITION = 2;
  private static final int SUPER_DEFINITION = 0;
  private static final String TAG = "AppJavascriptInterface";
  private AVPlayerBuilderServiceInterface avPlayerService;
  private HalfSizeWebviewDialog halfSizeWebviewDialog;
  private RoomServiceInterface roomService;
  private View rootView;
  
  public AppJavascriptInterface(Context paramContext, View paramView, JsBizAdapter paramJsBizAdapter)
  {
    super(paramContext, paramJsBizAdapter);
    if (paramJsBizAdapter.getModuleRoomEngine() != null)
    {
      this.avPlayerService = ((AVPlayerBuilderServiceInterface)paramJsBizAdapter.getModuleRoomEngine().getService(AVPlayerBuilderServiceInterface.class));
      this.roomService = ((RoomServiceInterface)paramJsBizAdapter.getModuleRoomEngine().getService(RoomServiceInterface.class));
    }
    this.rootView = paramView;
  }
  
  @NewJavascriptInterface
  public void addHistory(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("title");
    str = (String)paramMap.get("jump_url");
    paramMap = (String)paramMap.get("cover");
  }
  
  @NewJavascriptInterface
  public void beginDraw(Map<String, String> paramMap)
  {
    Log.d("AppJavascriptInterface", "AppJavascriptInterface beginDraw js fun");
    paramMap = new ScrollByWebEvent();
    paramMap.scrollByWeb = true;
    postEvent(paramMap);
  }
  
  @NewJavascriptInterface
  public void changeVideoRate(Map<String, String> paramMap)
  {
    if ((this.roomService == null) || (this.avPlayerService == null)) {
      return;
    }
    int i = Integer.parseInt((String)paramMap.get("rate"));
    String str = (String)paramMap.get("callback");
    this.avPlayerService.stopPlay();
    this.avPlayerService.resetPlayer();
    PlayerParams localPlayerParams = new PlayerParams();
    if (i == 0) {
      paramMap = this.roomService.getLiveInfo().watchMediaInfo.mUrl;
    }
    for (;;)
    {
      Log.d("AppJavascriptInterface", "changeVideoRate rate = " + i + " url = " + paramMap);
      localPlayerParams.url = paramMap;
      this.avPlayerService.setParams(localPlayerParams);
      this.avPlayerService.setPlayerSurface();
      this.avPlayerService.preparePlay();
      this.avPlayerService.startPlay();
      callJsFunctionByNative(str, null);
      return;
      if (i == 1) {
        paramMap = this.roomService.getLiveInfo().watchMediaInfo.mUrlHigh;
      } else if (i == 2) {
        paramMap = this.roomService.getLiveInfo().watchMediaInfo.mUrlLow;
      } else if (i == 3) {
        paramMap = this.roomService.getLiveInfo().watchMediaInfo.mUrlLowest;
      } else {
        paramMap = this.roomService.getLiveInfo().watchMediaInfo.mUrl;
      }
    }
  }
  
  @NewJavascriptInterface
  public void checkcertificated(Map<String, String> paramMap) {}
  
  @NewJavascriptInterface
  public void clearDynamicEffectQueue(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    getJsBizAdapter().getLogger().i("AppJavascriptInterface", "LiteLuxuryGift clearDynamicEffectQueue =\n  " + paramMap.toString(), new Object[0]);
    getJsBizAdapter().getModuleEvent().post(new ClearLuxuryQueueEvent());
  }
  
  @NewJavascriptInterface
  public void close(Map<String, String> paramMap)
  {
    Log.d("AppJavascriptInterface", "AppJavascriptInterface close js fun");
    postEvent(new RoomCloseEvent());
  }
  
  @NewJavascriptInterface
  public void closePendantWebview(Map<String, String> paramMap)
  {
    Log.d("AppJavascriptInterface", "AppJavascriptInterface closePendantWebview js fun");
    this.halfSizeWebviewDialog.dismiss();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", paramMap.get("url"));
      callJsFunctionByNative("__PENDANT_WEBVIEW_CLOSE", localJSONObject);
      return;
    }
    catch (JSONException paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  @NewJavascriptInterface
  public void contentLoaded(Map<String, String> paramMap)
  {
    Log.d("AppJavascriptInterface", "AppJavascriptInterface contentLoaded js fun");
    Object localObject1 = new ContentLoadedEvent();
    ((ContentLoadedEvent)localObject1).mContentLoaded = true;
    postEvent((ModuleEventInterface)localObject1);
    Object localObject2;
    if (paramMap != null)
    {
      localObject1 = (String)paramMap.get("program_id");
      localObject2 = (String)paramMap.get("state");
      String str1 = (String)paramMap.get("ilive_type");
      String str2 = (String)paramMap.get("followed");
      String str3 = (String)paramMap.get("anchor_uid");
      logI("AppJavascriptInterface", "AppJavascriptInterface contentLoaded programId = " + (String)localObject1 + ", state = " + (String)localObject2 + ", ilive_type = " + str1 + ", followed = " + str2 + ", anchor_uid = " + str3);
      localObject1 = new RoomExtInfo((String)localObject1, (String)localObject2, str1, str2, str3);
      if (getJsBizAdapter() != null) {
        getJsBizAdapter().onGetRoomInfo((RoomExtInfo)localObject1);
      }
    }
    paramMap = (String)paramMap.get("callback");
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("ab_token", "");
      ((JSONObject)localObject1).put("kingCard", 0);
      ((JSONObject)localObject1).put("statusBarHeight", UIUtil.getStatusBarHeight(this.mContext));
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("result", localObject1);
      callJsFunctionByNative(paramMap, (JSONObject)localObject2);
      return;
    }
    catch (JSONException paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  @NewJavascriptInterface
  public void doShare(Map<String, String> paramMap)
  {
    Log.d("AppJavascriptInterface", "AppJavascriptInterface doShare js fun");
  }
  
  @NewJavascriptInterface
  public void endDraw(Map<String, String> paramMap)
  {
    Log.d("AppJavascriptInterface", "AppJavascriptInterface endDraw js fun");
    paramMap = new ScrollByWebEvent();
    paramMap.scrollByWeb = false;
    postEvent(paramMap);
  }
  
  @NewJavascriptInterface
  public void getClientScreenMode(Map<String, String> paramMap)
  {
    Log.d("AppJavascriptInterface", "AppJavascriptInterface getClientScreenMode js fun");
    if (this.avPlayerService == null) {
      return;
    }
    int i = this.avPlayerService.getVideoHeight();
    int j = this.avPlayerService.getVideoWidth();
    if ((i > 0) && (j > 0) && (i < j)) {}
    for (i = 1;; i = 0)
    {
      paramMap = new Rect();
      this.rootView.getGlobalVisibleRect(paramMap);
      Rect localRect = this.avPlayerService.getDisplayViewRect();
      j = localRect.height();
      int k = localRect.top;
      int m = paramMap.top;
      j = (int)UIUtil.px2dp(this.mContext, k - m + j);
      logI("AppJavascriptInterface", "getClientScreenMode screenmode = " + i + " topMarginDp = " + j + " this = " + this);
      try
      {
        paramMap = new JSONObject();
        paramMap.put("screenmode", i);
        paramMap.put("bottom", j);
        callJsFunctionByNative("__WEBVIEW_CLIENTSCREENMODE", paramMap);
        return;
      }
      catch (JSONException paramMap)
      {
        paramMap.printStackTrace();
        return;
      }
    }
  }
  
  @NewJavascriptInterface
  public void getLittleWindowStatus(Map<String, String> paramMap)
  {
    paramMap = SPUtil.get(this.mContext, "nowlive_config").getString("status", "1");
    logI("AppJavascriptInterface", "getLittleWindowStatus status = " + paramMap);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("status", paramMap);
      callJsFunctionByNative("__WEBVIEW_LITTLE_WINDOW_STATUS", localJSONObject);
      return;
    }
    catch (JSONException paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  public String getName()
  {
    return "app";
  }
  
  @NewJavascriptInterface
  public void getNetworkType(Map<String, String> paramMap)
  {
    int i = NetworkUtil.getNetworkType(this.mContext);
    String str1 = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", i);
      String str2 = str1;
      if (paramMap != null)
      {
        str2 = str1;
        if (paramMap.size() > 0)
        {
          Iterator localIterator = paramMap.keySet().iterator();
          for (;;)
          {
            str2 = str1;
            if (!localIterator.hasNext()) {
              break;
            }
            str1 = (String)paramMap.get((String)localIterator.next());
          }
        }
      }
      callJsFunctionByNative(str2, localJSONObject);
      return;
    }
    catch (JSONException paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  @NewJavascriptInterface
  public void isAppInstalled(Map<String, String> paramMap)
  {
    Object localObject = (String)paramMap.get("identifier");
    String str = (String)paramMap.get("callback");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      logE("AppJavascriptInterface", "packageName is Null");
      return;
    }
    paramMap = null;
    try
    {
      localObject = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);
      paramMap = (Map<String, String>)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        paramMap = "";
        int i = 0;
      }
    }
    if (paramMap != null)
    {
      i = 1;
      paramMap = paramMap.versionName;
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("installed", i);
        ((JSONObject)localObject).put("version", paramMap);
        paramMap = new JSONObject();
        paramMap.put("code", 0);
        paramMap.put("result", localObject);
        callJsFunctionByNative(str, paramMap);
        return;
      }
      catch (JSONException paramMap)
      {
        paramMap.printStackTrace();
        return;
      }
    }
  }
  
  @NewJavascriptInterface
  public void loadFailed(Map<String, String> paramMap)
  {
    Log.d("AppJavascriptInterface", "AppJavascriptInterface loadFailed js fun");
    LoadRoomInfoErrorEvent localLoadRoomInfoErrorEvent = new LoadRoomInfoErrorEvent();
    localLoadRoomInfoErrorEvent.errCode = ((String)paramMap.get("errCode"));
    postEvent(localLoadRoomInfoErrorEvent);
  }
  
  @NewJavascriptInterface
  public void loadInputViewPlaceholder(Map<String, String> paramMap)
  {
    Log.d("AppJavascriptInterface", "AppJavascriptInterface loadInputViewPlaceholder js fun");
  }
  
  @NewJavascriptInterface
  public void loadLiveVerticalGuideUserCommentData(Map<String, String> paramMap)
  {
    Log.d("AppJavascriptInterface", "AppJavascriptInterface loadLiveVerticalGuideUserCommentData js fun");
  }
  
  @NewJavascriptInterface
  public void loadSucc(Map<String, String> paramMap)
  {
    Log.d("AppJavascriptInterface", "AppJavascriptInterface loadSucc js fun");
    postEvent(new LoadHtmlSuccessEvent());
  }
  
  @NewJavascriptInterface
  public void navigateToMiniProgram(Map<String, String> paramMap)
  {
    Log.i("AppJavascriptInterface", "navigateToMiniProgram");
  }
  
  public void onJsCreate() {}
  
  public void onJsDestroy()
  {
    if (this.halfSizeWebviewDialog != null) {
      this.halfSizeWebviewDialog.dismiss();
    }
  }
  
  @NewJavascriptInterface
  public void onReConnect(Map<String, String> paramMap)
  {
    Log.d("AppJavascriptInterface", "AppJavascriptInterface onReConnect js fun");
    if (this.avPlayerService == null) {
      return;
    }
    paramMap = new JSONObject();
    if ((!NetworkUtil.isNetworkAvailable(this.mContext)) || (this.avPlayerService.isPaused())) {
      try
      {
        paramMap.put("state", String.valueOf(4));
        callJsFunctionByNative("__WEBVIEW_CLIENTAVSTATE", paramMap);
        return;
      }
      catch (JSONException paramMap)
      {
        paramMap.printStackTrace();
        return;
      }
    }
    this.avPlayerService.startPlay();
    try
    {
      paramMap.put("state", String.valueOf(9));
      callJsFunctionByNative("__WEBVIEW_CLIENTAVSTATE", paramMap);
      return;
    }
    catch (JSONException paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  @NewJavascriptInterface
  public void onSubscribeChanged(Map<String, String> paramMap)
  {
    if (getJsBizAdapter() == null) {
      return;
    }
    paramMap = (String)paramMap.get("state");
    logI("AppJavascriptInterface", "onSubscribeChanged state = " + paramMap);
    if ("1".equals(paramMap))
    {
      getJsBizAdapter().onSubscribeStateChanged(true);
      return;
    }
    getJsBizAdapter().onSubscribeStateChanged(false);
  }
  
  @NewJavascriptInterface
  public void openLoginPage(Map<String, String> paramMap)
  {
    logI("AppJavascriptInterface", "AppJavascriptInterface openLoginPage js fun");
  }
  
  @NewJavascriptInterface
  public void openPendantWebview(Map<String, String> paramMap)
  {
    Log.d("AppJavascriptInterface", "AppJavascriptInterface openPendantWebview js fun");
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showTitleBar", false);
    localBundle.putString("url", (String)paramMap.get("url"));
    localBundle.putBoolean("isLandscape", false);
    localBundle.putFloat("dimAmount", 0.0F);
    localBundle.putBoolean("leftClickClose", true);
    localBundle.putBoolean("plantCookieWhenResume", true);
    localBundle.putInt("height", UIUtil.dp2px(this.mContext, Float.parseFloat((String)paramMap.get("height"))));
    this.halfSizeWebviewDialog = new HalfSizeWebviewDialog();
    this.halfSizeWebviewDialog.setArguments(localBundle);
    this.halfSizeWebviewDialog.setOnDismissListener(new AppJavascriptInterface.1(this, paramMap));
    this.halfSizeWebviewDialog.show(((FragmentActivity)this.mContext).getSupportFragmentManager(), "");
  }
  
  @NewJavascriptInterface
  public void preloadDynamicEffectResource(Map<String, String> paramMap)
  {
    if (paramMap == null) {}
    do
    {
      return;
      getJsBizAdapter().getLogger().i("AppJavascriptInterface", "preloadDynamicEffectResource =\n  " + paramMap.toString(), new Object[0]);
      paramMap = (String)paramMap.get("gift_list");
    } while (TextUtils.isEmpty(paramMap));
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      try
      {
        paramMap = new JSONArray(paramMap);
        localArrayList = new ArrayList();
        i = 0;
        if (i < paramMap.length())
        {
          String str = paramMap.optString(i);
          if (TextUtils.isEmpty(str)) {
            break label178;
          }
          localArrayList.add(str);
          break label178;
        }
        if (localArrayList.size() == 0)
        {
          getJsBizAdapter().getLogger().i("AppJavascriptInterface", "LiteLuxuryGift preloadDynamicEffectResource parse effectId null", new Object[0]);
          return;
        }
      }
      catch (JSONException paramMap)
      {
        paramMap.printStackTrace();
        return;
      }
      getJsBizAdapter().getModuleEvent().post(new PreloadLuxuryAnimationEvent(localArrayList));
      return;
      label178:
      i += 1;
    }
  }
  
  @NewJavascriptInterface
  public void setLittleWindowStatus(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("status");
    logI("AppJavascriptInterface", "setLittleWindowStatus status = " + paramMap);
    SPUtil.get(this.mContext, "nowlive_config").putString("status", paramMap);
    FloatWindowConfigServiceInterface localFloatWindowConfigServiceInterface = (FloatWindowConfigServiceInterface)BizEngineMgr.getInstance().getLiveEngine().getService(FloatWindowConfigServiceInterface.class);
    if (paramMap.equals("1")) {}
    for (boolean bool = true;; bool = false)
    {
      localFloatWindowConfigServiceInterface.setFloatWindowEnabledOnce(bool);
      return;
    }
  }
  
  @NewJavascriptInterface
  public void setScreenMode(Map<String, String> paramMap)
  {
    if (getJsBizAdapter() == null) {
      return;
    }
    paramMap = (String)paramMap.get("mode");
    int i;
    if (TextUtils.isEmpty(paramMap))
    {
      i = 1;
      if (i != 1) {
        break label85;
      }
    }
    label85:
    for (boolean bool = true;; bool = false)
    {
      if (getJsBizAdapter().getRoomPageAction() != null) {
        getJsBizAdapter().getRoomPageAction().setRequestedOrientation(bool);
      }
      postEvent(new ScreenModeEvent(bool));
      return;
      i = Integer.parseInt(paramMap);
      break;
    }
  }
  
  @NewJavascriptInterface
  public void showDynamicEffect(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    String str1 = (String)paramMap.get("native_username");
    String str2 = (String)paramMap.get("effectid");
    String str3 = (String)paramMap.get("native_anchorname");
    str3 = (String)paramMap.get("native_is_anchor");
    str3 = (String)paramMap.get("native_combo_count");
    str3 = (String)paramMap.get("serial_id");
    str3 = (String)paramMap.get("isCar");
    str3 = (String)paramMap.get("native_userid");
    str3 = (String)paramMap.get("native_gift_id");
    String str4 = (String)paramMap.get("native_comment");
    str4 = (String)paramMap.get("native_anchorid");
    str4 = (String)paramMap.get("native_url");
    LiteShowLuxuryAnimationEvent localLiteShowLuxuryAnimationEvent = new LiteShowLuxuryAnimationEvent();
    localLiteShowLuxuryAnimationEvent.giftType = 104;
    localLiteShowLuxuryAnimationEvent.giftid = Long.parseLong(str3);
    localLiteShowLuxuryAnimationEvent.effectId = str2;
    localLiteShowLuxuryAnimationEvent.uName = str1;
    localLiteShowLuxuryAnimationEvent.headUrl = str4;
    getJsBizAdapter().getLogger().i("AppJavascriptInterface", "LiteLuxuryGift showDynamicEffect params =\n  " + paramMap.toString(), new Object[0]);
    getJsBizAdapter().getModuleEvent().post(localLiteShowLuxuryAnimationEvent);
  }
  
  @NewJavascriptInterface
  public void showKeyboard(Map<String, String> paramMap)
  {
    Log.d("AppJavascriptInterface", "AppJavascriptInterface showKeyboard js fun");
    postEvent(new ShowKeyboardRoomEvent());
  }
  
  @NewJavascriptInterface
  public void stopDynamicEffect(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    getJsBizAdapter().getLogger().i("AppJavascriptInterface", "LiteLuxuryGift stopDynamicEffect =\n  " + paramMap.toString(), new Object[0]);
    getJsBizAdapter().getModuleEvent().post(new StopLuxuryAnimationPlayEvent());
  }
  
  @NewJavascriptInterface
  public void transferBetweenWebviews(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("action");
    paramMap = (String)paramMap.get("callback");
    getJsBizAdapter().getModuleEvent().post(new WebviewTransmitEvent(str, paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.js.AppJavascriptInterface
 * JD-Core Version:    0.7.0.1
 */