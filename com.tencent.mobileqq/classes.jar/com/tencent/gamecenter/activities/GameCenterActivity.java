package com.tencent.gamecenter.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.apollo.statistics.trace.api.ITraceReportHelper;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoManager;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.CrashStepStatsEntry;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;

@RoutePage(desc="手游中心Activity", path="/base/activity/GameCenterActivity")
public class GameCenterActivity
  extends QQBrowserActivity
  implements Handler.Callback, SDKInitListener
{
  public static final int ERROR_STEP_1 = 1201;
  public static final int ERROR_STEP_11 = 1211;
  public static final int ERROR_STEP_12 = 1212;
  public static final int ERROR_STEP_2 = 1202;
  public static final int ERROR_STEP_Detected = 1213;
  public static final int FEATURE_ID = 123;
  public static final int GAMECENTER_WV = 5127;
  public static final int MSG_HIDE_TITLE_LOADING = 2004;
  public static final int MSG_SHOW_TITLE_LOADING = 2003;
  public static final int MSG_SHOW_TOAST = 2006;
  public static final int RECENT_PLAY_WV = 3;
  public static final int SPAN_ID = 1;
  public static final String TAG = "GameCenterActivity";
  private static int sActivityNum;
  private Drawable ad;
  public Handler gcHandler = null;
  private boolean isFinish = false;
  private boolean mIsNeedMiniMsg;
  private boolean mIsNeedMiniMsgParsed;
  private TouchWebView.OnScrollChangedListener mListener;
  private Drawable[] mOldDrawables;
  private int mOldPadding;
  
  public GameCenterActivity()
  {
    this.mFragmentClass = GameCenterActivity.GameCenterFragment.class;
  }
  
  private void handlePushReport()
  {
    Intent localIntent = getIntent();
    if ((localIntent != null) && (localIntent.getIntExtra("game_msg_enter_from", 0) == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterActivity", 2, "handlePushReport() called");
      }
      localIntent.removeExtra("game_msg_enter_from");
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).report(10004, 2);
    }
  }
  
  public static String httpRequest(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appids", paramString2);
    paramString2 = new StringBuilder();
    paramString2.append("uin=");
    paramString2.append(paramString3);
    paramString2 = paramString2.toString();
    paramString3 = new Bundle();
    paramString3.putString("Cookie", paramString2);
    try
    {
      paramContext = HttpUtil.openUrl(paramContext, paramString1, "POST", localBundle, paramString3);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("httpRequest: result:");
        paramString1.append(paramContext);
        QLog.i("GameCenter", 2, paramString1.toString());
      }
      return paramContext;
    }
    catch (IOException paramContext)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("httpRequest:");
        paramString1.append(paramContext.getMessage());
        QLog.i("GameCenter", 2, paramString1.toString());
      }
      return "{'ret': -105, 'data' : 'httpRequest::Http no response.'}";
      if (QLog.isColorLevel()) {
        QLog.i("GameCenter", 2, "httpRequest:ClientProtocolException");
      }
      return "{'ret': -104, 'data' : 'httpRequest:ClientProtocolException'}";
    }
    catch (ClientProtocolException paramContext)
    {
      label152:
      break label152;
    }
  }
  
  public static boolean isContainsGameUrl(String paramString)
  {
    if (SwiftBrowserStatistics.CrashStepStatsEntry.a == null) {
      parseTraceUrl();
    }
    List localList = SwiftBrowserStatistics.CrashStepStatsEntry.a;
    if (!TextUtils.isEmpty(paramString))
    {
      if (localList == null) {
        return false;
      }
      int i = 0;
      while (i < localList.size())
      {
        if (paramString.contains((CharSequence)localList.get(i))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static void parseTraceUrl()
  {
    Object localObject2 = BaseApplicationImpl.sApplication.getSharedPreferences("game_center_sp_mutiprocess", 4);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 != null) && (((AppRuntime)localObject1).getLongAccountUin() != 0L)) {
      localObject1 = ((AppRuntime)localObject1).getAccount();
    } else {
      localObject1 = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("trace_url_keyword");
    localStringBuilder.append((String)localObject1);
    localObject1 = ((SharedPreferences)localObject2).getString(localStringBuilder.toString(), "");
    SwiftBrowserStatistics.CrashStepStatsEntry.a = new ArrayList();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("parseTraceUrl:");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.d("GameCenterActivity", 1, ((StringBuilder)localObject2).toString());
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    try
    {
      localObject1 = new JSONArray((String)localObject1);
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2 = (String)((JSONArray)localObject1).opt(i);
        SwiftBrowserStatistics.CrashStepStatsEntry.a.add(localObject2);
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("GameCenterActivity", 1, "parseTraceUrl:", localException);
    }
  }
  
  public static void reportDetectedBlankScreen(String paramString, int paramInt)
  {
    int i = paramString.indexOf('?');
    if (i <= 0) {
      i = paramString.length();
    }
    paramString = paramString.substring(0, i);
    if (!isContainsGameUrl(paramString)) {
      return;
    }
    ((ITraceReportHelper)QRoute.api(ITraceReportHelper.class)).endSpan(123, paramString, 1, 1213, new Object[] { "current DetectedBlankScreen status:", Integer.valueOf(paramInt) });
  }
  
  public static void reportStep(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!isContainsGameUrl(paramString)) {
      return;
    }
    Object localObject = paramString.split("\\?");
    int i;
    if (localObject.length >= 2)
    {
      HashMap localHashMap = new HashMap();
      StoryShareEncryptHelper.a(localObject[1], localHashMap);
      localObject = (String)localHashMap.get("ADTAG");
      if ("10001".equals(localObject))
      {
        if (paramBoolean2) {
          i = 1;
        } else {
          i = 2;
        }
      }
      else {
        i = 0;
      }
      if ((!"gzh".equals(localObject)) && (!"fwh".equals(localObject)) && (!"fuwuhao".equals(localObject)) && (!"76902".equals(localObject))) {
        break label162;
      }
      if (paramBoolean2) {
        i = 3;
      } else {
        i = 4;
      }
    }
    else
    {
      i = 0;
    }
    label162:
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterActivity", 2, new Object[] { "reportStep step:", Integer.valueOf(paramInt), ",url:", paramString, ",hasRed:", Boolean.valueOf(paramBoolean2) });
    }
    localObject = (ITraceReportHelper)QRoute.api(ITraceReportHelper.class);
    if (paramInt == 1)
    {
      ((ITraceReportHelper)localObject).beginTrace(123, null, paramString);
      ((ITraceReportHelper)localObject).beginSpan(123, paramString, 1);
    }
    if (paramInt == 13)
    {
      ((ITraceReportHelper)localObject).addTraceData(123, null, paramString, new int[] { i });
      ((ITraceReportHelper)localObject).endSpan(123, paramString, 1, 0, new Object[0]);
      ((ITraceReportHelper)localObject).endTrace(123, paramString);
      return;
    }
    if (!paramBoolean1) {
      return;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 11)
        {
          if (paramInt != 12) {
            i = -100;
          } else {
            i = 1212;
          }
        }
        else {
          i = 1211;
        }
      }
      else {
        i = 1202;
      }
    }
    else {
      i = 1201;
    }
    ((ITraceReportHelper)localObject).endSpan(123, paramString, 1, i, new Object[] { "current step:", Integer.valueOf(paramInt) });
  }
  
  private boolean startTitleProgress()
  {
    Object localObject = getCurrentWebViewFragment();
    if (localObject == null) {
      return false;
    }
    localObject = ((WebViewFragment)localObject).getSwiftTitleUI().b;
    if (localObject == null) {
      return false;
    }
    if (this.ad == null)
    {
      this.ad = super.getResources().getDrawable(2130839404);
      this.mOldDrawables = ((TextView)localObject).getCompoundDrawables();
      this.mOldPadding = ((TextView)localObject).getCompoundDrawablePadding();
      ((TextView)localObject).setCompoundDrawablePadding(10);
      Drawable localDrawable = this.ad;
      Drawable[] arrayOfDrawable = this.mOldDrawables;
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(localDrawable, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      ((Animatable)this.ad).start();
      return true;
    }
    return false;
  }
  
  private boolean stopTitleProgress()
  {
    Object localObject1 = getCurrentWebViewFragment();
    if (localObject1 == null) {
      return false;
    }
    localObject1 = ((WebViewFragment)localObject1).getSwiftTitleUI().b;
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = this.ad;
    if (localObject2 != null)
    {
      ((Animatable)localObject2).stop();
      this.ad = null;
      ((TextView)localObject1).setCompoundDrawablePadding(this.mOldPadding);
      localObject2 = this.mOldDrawables;
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(localObject2[0], localObject2[1], localObject2[2], localObject2[3]);
      return true;
    }
    return false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    sActivityNum += 1;
    handlePushReport();
    QQVideoPlaySDKManager.a(BaseApplicationImpl.getApplication(), this);
    return super.doOnCreate(paramBundle);
  }
  
  protected void doOnDestroy()
  {
    this.isFinish = true;
    Handler localHandler = this.gcHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.gcHandler = null;
    }
    VideoPlaySDKManager.getInstance().removeSDKInstalledListener(this);
    super.doOnDestroy();
    sActivityNum -= 1;
    if (sActivityNum <= 0) {
      MiniMsgIPCClient.getInstance().clearBusiness(8);
    }
  }
  
  protected MiniMsgUserParam getMiniMsgUserParam()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 8;
    localMiniMsgUserParam.accessType = 0;
    localMiniMsgUserParam.entryType = 0;
    localMiniMsgUserParam.positionX = -1;
    localMiniMsgUserParam.positionY = -1;
    localMiniMsgUserParam.colorType = 0;
    localMiniMsgUserParam.filterMsgType = 0;
    return localMiniMsgUserParam;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.isFinish) {
      return true;
    }
    int i = paramMessage.what;
    if (i != 2003)
    {
      if (i != 2004)
      {
        if (i != 2006) {
          return true;
        }
        Toast.makeText(BaseApplicationImpl.getApplication(), (String)paramMessage.obj, 0).show();
        return true;
      }
      stopTitleProgress();
      return true;
    }
    startTitleProgress();
    this.gcHandler.sendEmptyMessageDelayed(2004, 45000L);
    return true;
  }
  
  public boolean isNeedMiniMsg()
  {
    Intent localIntent;
    Uri localUri;
    if (!this.mIsNeedMiniMsgParsed)
    {
      localIntent = getIntent();
      localUri = null;
      if (localIntent == null) {}
    }
    try
    {
      localUri = Uri.parse(localIntent.getStringExtra("url"));
      if (localUri != null) {
        this.mIsNeedMiniMsg = "1".equals(localUri.getQueryParameter("gc_mini_floating"));
      }
    }
    catch (Exception localException)
    {
      label50:
      break label50;
    }
    this.mIsNeedMiniMsgParsed = true;
    return this.mIsNeedMiniMsg;
  }
  
  public boolean onBackEvent()
  {
    GameCenterVideoViewController localGameCenterVideoViewController = GameCenterVideoManager.a().a();
    if ((localGameCenterVideoViewController != null) && (localGameCenterVideoViewController.isFullScreenMode()))
    {
      localGameCenterVideoViewController.exitFullScreen();
      return true;
    }
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if ((paramWebView instanceof TouchWebView)) {
      ((TouchWebView)paramWebView).setOnScrollChangedListener(this.mListener);
    }
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQVideo Inited:");
      localStringBuilder.append(paramBoolean);
      QLog.d("GameCenterActivity", 1, localStringBuilder.toString());
    }
  }
  
  public void setOnScrollChangedListener(TouchWebView.OnScrollChangedListener paramOnScrollChangedListener)
  {
    this.mListener = paramOnScrollChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.activities.GameCenterActivity
 * JD-Core Version:    0.7.0.1
 */