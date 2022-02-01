package com.tencent.gamecenter.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.emosm.Client.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.media.DanmakuHost.Item;
import com.tencent.mobileqq.gamecenter.media.DanmakuLayout;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoManager;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GameCenterAPIJavaScript
  extends VasWebviewJsPlugin
{
  public static final String APPKEY_PLAYER = "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==";
  public static final String CLOSE_SWITCH = "closeSwitch";
  public static final String DEL_IMG = "delImg";
  public static String EVENT_UPDATE_SESSION_INFO;
  public static String EVENT_UPDATE_UNREAD_CNT;
  public static String METHOD_GET_REQUEST_INFO;
  public static String METHOD_GET_SESSION_INFO = "getSessionData";
  public static String METHOD_GET_UNREAD_TOTAL;
  public static String METHOD_OPEN_AIO;
  public static String METHOD_OPEN_QQPLAYER_AIO = "openQQPlayerAio";
  public static String METHOD_TOGGLE_CHANGE;
  public static final String OPEN_SWITCH = "openSwitch";
  public static final String QUERY_INFO = "queryInfo";
  public static final String REMOVE_MASK = "removeMask";
  public static final String SHOT_SCREEN = "shotScreen";
  public static final String TAG = "GCApi";
  private static boolean mIsInited;
  private DisplayMetrics dm;
  private Context mContext;
  private GameCenterAPIJavaScript.GameMessageReceiver mMsgReceiver = new GameCenterAPIJavaScript.GameMessageReceiver(this, null);
  public Bundle mReqBundle;
  private TouchWebView.OnScrollChangedListener mScrollChangedListener;
  private FrameLayout mVideoContainer;
  private Map<Integer, GameCenterAPIJavaScript.VideoViewInfo> mVideoViewMap = new HashMap();
  private String uin = "";
  
  static
  {
    METHOD_GET_REQUEST_INFO = "getRequestData";
    METHOD_GET_UNREAD_TOTAL = "getNewMsgCount";
    EVENT_UPDATE_UNREAD_CNT = "gameCenter_newMsgCountChanged";
    EVENT_UPDATE_SESSION_INFO = "gameCenter_sessionChanged";
    METHOD_OPEN_AIO = "clickCommonSession";
    METHOD_TOGGLE_CHANGE = "setSwitch";
  }
  
  public GameCenterAPIJavaScript()
  {
    this.mPluginNameSpace = "GCApi";
  }
  
  private void initVideoSDK()
  {
    try
    {
      if (!mIsInited)
      {
        mIsInited = true;
        TVK_SDKMgr.initSdk(this.mContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      }
      return;
    }
    finally {}
  }
  
  public static JSONObject parseGameMessageChange(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Object localObject = (GameCenterSessionInfo)paramBundle.getParcelable("key_game_msg");
      int i = paramBundle.getInt("key_msg_change_type");
      if (QLog.isColorLevel()) {
        QLog.d("GCApi", 0, "[onReceive] type:" + i + ",info:" + localObject);
      }
      paramBundle = new JSONArray();
      if (localObject != null) {
        paramBundle.put(((GameCenterSessionInfo)localObject).a());
      }
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("session", paramBundle);
        ((JSONObject)localObject).put("eventType", i);
        ((JSONObject)localObject).put("ret", 0);
        if (QLog.isColorLevel()) {
          QLog.d("GCApi", 2, "[onReceive] gameCenterMsg: " + ((JSONObject)localObject).toString());
        }
        return localObject;
      }
      catch (Exception paramBundle) {}
    }
    return null;
  }
  
  public static JSONObject parseGameMessageUnreadCount(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("key_msg_unread_cnt");
      if (QLog.isColorLevel()) {
        QLog.d("GCApi", 2, "[onReceive] cnt:" + i);
      }
      try
      {
        paramBundle = new JSONObject();
        paramBundle.put("newMsgCount", i);
        paramBundle.put("ret", 0);
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        QLog.e("GCApi", 1, paramBundle, new Object[0]);
      }
    }
    return null;
  }
  
  void callbackError(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 1);
      localJSONObject.put("msg", paramString2);
      super.callJs(paramString1 + "&&" + paramString1 + "(" + localJSONObject.toString() + ");");
      if (QLog.isColorLevel()) {
        QLog.e("GCApi", 2, "callbackId->" + paramString1 + " errorMsg: " + paramString2);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("GCApi", 2, localException.getMessage());
        }
      }
    }
  }
  
  void callbackJS(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", paramInt);
      localJSONObject.put("msg", paramString2);
      super.callJs(paramString1 + "(" + localJSONObject.toString() + ");");
      if (QLog.isColorLevel()) {
        QLog.d("GCApi", 2, "callbackId->" + paramString1 + " callbackOk" + localJSONObject.toString());
      }
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("GCApi", 2, paramString1.getMessage());
    }
  }
  
  void callbackOk(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ret", 0);
      localJSONObject.put("msg", "");
      super.callJs(paramString + "&&" + paramString + "(" + localJSONObject.toString() + ");");
      if (QLog.isColorLevel()) {
        QLog.d("GCApi", 2, "callbackId->" + paramString + " callbackOk" + localJSONObject.toString());
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("GCApi", 2, paramString.getMessage());
    }
  }
  
  public int clearDanmu(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        int j = paramJSONObject.optInt("mask");
        paramJSONObject = ((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
        if ((j & 0x1) == 1) {
          paramJSONObject.getDanmakuLayout().a();
        }
        if ((j & 0x2) == 2) {
          paramJSONObject.getDanmakuLayout().b();
        }
      }
      else
      {
        QLog.e("GCApi", 1, "[clearDanmuData] Err: not find videoPlayer");
        return -1;
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "clearDanmuData Err:" + paramJSONObject.toString());
      return -1;
    }
    return 0;
  }
  
  /* Error */
  public int createVideo(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: invokestatic 300	com/tencent/mobileqq/qqvideoplatform/api/QQVideoPlaySDKManager:a	()Z
    //   3: ifne +53 -> 56
    //   6: aload_0
    //   7: getfield 304	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   10: ifnull +26 -> 36
    //   13: aload_0
    //   14: getfield 304	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   17: invokevirtual 309	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   20: ifnull +16 -> 36
    //   23: aload_0
    //   24: getfield 304	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   27: invokevirtual 309	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   30: invokevirtual 315	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   33: ifnonnull +9 -> 42
    //   36: iconst_m1
    //   37: istore 4
    //   39: iload 4
    //   41: ireturn
    //   42: aload_0
    //   43: getfield 304	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   46: invokevirtual 309	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   49: invokevirtual 315	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   52: aconst_null
    //   53: invokestatic 318	com/tencent/mobileqq/qqvideoplatform/api/QQVideoPlaySDKManager:a	(Landroid/content/Context;Lcom/tencent/mobileqq/videoplatform/SDKInitListener;)V
    //   56: aload_1
    //   57: ldc_w 320
    //   60: invokevirtual 258	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   63: istore 4
    //   65: aload_1
    //   66: ldc_w 322
    //   69: invokevirtual 258	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   72: istore 6
    //   74: aload_1
    //   75: ldc_w 324
    //   78: invokevirtual 258	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   81: istore 5
    //   83: aload_1
    //   84: ldc_w 326
    //   87: invokevirtual 258	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   90: istore 10
    //   92: aload_1
    //   93: ldc_w 328
    //   96: invokevirtual 332	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: astore 17
    //   101: aload_1
    //   102: ldc_w 334
    //   105: invokevirtual 332	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   108: astore 18
    //   110: aload_1
    //   111: ldc_w 336
    //   114: invokevirtual 332	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   117: astore 22
    //   119: aload_1
    //   120: ldc_w 338
    //   123: invokevirtual 258	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   126: istore 7
    //   128: aload_1
    //   129: ldc_w 340
    //   132: invokevirtual 258	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   135: iconst_1
    //   136: if_icmpne +798 -> 934
    //   139: iconst_1
    //   140: istore 14
    //   142: aload_1
    //   143: ldc_w 342
    //   146: invokevirtual 258	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   149: iconst_1
    //   150: if_icmpne +790 -> 940
    //   153: iconst_1
    //   154: istore 15
    //   156: aload_1
    //   157: ldc_w 344
    //   160: invokevirtual 332	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   163: astore 23
    //   165: aload_1
    //   166: ldc_w 346
    //   169: invokevirtual 258	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   172: istore 8
    //   174: aload_1
    //   175: ldc_w 348
    //   178: invokevirtual 258	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   181: istore 9
    //   183: aload_1
    //   184: ldc_w 350
    //   187: invokevirtual 258	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   190: istore 11
    //   192: aload_1
    //   193: ldc_w 352
    //   196: invokevirtual 332	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   199: astore 24
    //   201: aload_1
    //   202: ldc_w 354
    //   205: invokevirtual 332	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   208: astore 25
    //   210: aload_1
    //   211: ldc_w 356
    //   214: invokevirtual 332	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   217: astore 26
    //   219: aload_1
    //   220: ldc_w 358
    //   223: invokevirtual 332	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   226: astore 27
    //   228: aload_1
    //   229: ldc_w 360
    //   232: invokevirtual 332	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   235: astore 28
    //   237: aload_1
    //   238: ldc_w 362
    //   241: aconst_null
    //   242: invokevirtual 365	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   245: astore 19
    //   247: aload_1
    //   248: ldc_w 367
    //   251: aconst_null
    //   252: invokevirtual 365	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   255: astore 20
    //   257: aload_1
    //   258: ldc_w 369
    //   261: aconst_null
    //   262: invokevirtual 365	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   265: astore 21
    //   267: aload_1
    //   268: ldc_w 371
    //   271: iconst_0
    //   272: invokevirtual 374	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   275: istore 12
    //   277: aload_1
    //   278: ldc_w 376
    //   281: iconst_0
    //   282: invokevirtual 374	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   285: istore 13
    //   287: aload_1
    //   288: ldc_w 378
    //   291: iconst_0
    //   292: invokevirtual 382	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   295: istore 16
    //   297: aload_1
    //   298: ldc_w 384
    //   301: ldc 95
    //   303: invokevirtual 365	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   306: astore_1
    //   307: aload_1
    //   308: invokestatic 390	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   311: pop
    //   312: invokestatic 396	com/tencent/mobileqq/app/FontSettingManager:getFontLevel	()F
    //   315: ldc_w 397
    //   318: fdiv
    //   319: fstore_3
    //   320: fconst_0
    //   321: fstore_2
    //   322: fload_3
    //   323: fconst_0
    //   324: fcmpl
    //   325: ifeq +9 -> 334
    //   328: invokestatic 401	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()F
    //   331: fload_3
    //   332: fdiv
    //   333: fstore_2
    //   334: fload_2
    //   335: fconst_0
    //   336: fcmpl
    //   337: ifne +628 -> 965
    //   340: invokestatic 401	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()F
    //   343: fstore_2
    //   344: aload_0
    //   345: getfield 116	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoContainer	Landroid/widget/FrameLayout;
    //   348: invokevirtual 407	android/widget/FrameLayout:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   351: checkcast 409	android/widget/RelativeLayout$LayoutParams
    //   354: astore_1
    //   355: aload_1
    //   356: iload 12
    //   358: i2f
    //   359: fload_2
    //   360: fmul
    //   361: f2i
    //   362: putfield 413	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   365: aload_1
    //   366: iload 13
    //   368: i2f
    //   369: fload_2
    //   370: fmul
    //   371: f2i
    //   372: putfield 416	android/widget/RelativeLayout$LayoutParams:bottomMargin	I
    //   375: aload_0
    //   376: getfield 116	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoContainer	Landroid/widget/FrameLayout;
    //   379: aload_1
    //   380: invokevirtual 420	android/widget/FrameLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   383: new 422	android/widget/FrameLayout$LayoutParams
    //   386: dup
    //   387: iload 5
    //   389: i2f
    //   390: fload_2
    //   391: fmul
    //   392: f2i
    //   393: iload 10
    //   395: i2f
    //   396: fload_2
    //   397: fmul
    //   398: f2i
    //   399: invokespecial 425	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   402: astore 29
    //   404: aload 29
    //   406: iload 4
    //   408: iload 12
    //   410: isub
    //   411: i2f
    //   412: fload_2
    //   413: fmul
    //   414: f2i
    //   415: putfield 426	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   418: aload 29
    //   420: fload_2
    //   421: iload 6
    //   423: i2f
    //   424: fmul
    //   425: f2i
    //   426: putfield 429	android/widget/FrameLayout$LayoutParams:leftMargin	I
    //   429: new 279	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController
    //   432: dup
    //   433: aload_0
    //   434: getfield 304	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   437: invokevirtual 432	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   440: invokespecial 435	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:<init>	(Landroid/content/Context;)V
    //   443: astore_1
    //   444: aload_1
    //   445: ldc_w 436
    //   448: invokevirtual 440	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setBackgroundColor	(I)V
    //   451: iload 16
    //   453: ifeq +28 -> 481
    //   456: getstatic 445	android/os/Build$VERSION:SDK_INT	I
    //   459: bipush 21
    //   461: if_icmplt +20 -> 481
    //   464: aload_1
    //   465: new 447	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$4
    //   468: dup
    //   469: aload_0
    //   470: invokespecial 450	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$4:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   473: invokevirtual 454	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setOutlineProvider	(Landroid/view/ViewOutlineProvider;)V
    //   476: aload_1
    //   477: iconst_1
    //   478: invokevirtual 458	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setClipToOutline	(Z)V
    //   481: aload_1
    //   482: invokevirtual 461	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:enableFullScreenSwitch	()V
    //   485: aload_1
    //   486: invokevirtual 464	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:enableVolumeSwitch	()V
    //   489: aload_1
    //   490: iload 8
    //   492: invokevirtual 467	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setDanmakuSwitch	(I)V
    //   495: aload_1
    //   496: iload 11
    //   498: invokevirtual 470	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setUIStyle	(I)V
    //   501: new 403	android/widget/FrameLayout
    //   504: dup
    //   505: aload_0
    //   506: getfield 304	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   509: invokevirtual 432	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   512: invokespecial 471	android/widget/FrameLayout:<init>	(Landroid/content/Context;)V
    //   515: astore 30
    //   517: aload_1
    //   518: aload 30
    //   520: new 422	android/widget/FrameLayout$LayoutParams
    //   523: dup
    //   524: iconst_m1
    //   525: iconst_m1
    //   526: invokespecial 425	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   529: invokevirtual 475	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   532: aload_0
    //   533: getfield 116	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoContainer	Landroid/widget/FrameLayout;
    //   536: aload_1
    //   537: aload 29
    //   539: invokevirtual 476	android/widget/FrameLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   542: aload_0
    //   543: getfield 304	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   546: invokevirtual 479	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   549: checkcast 481	com/tencent/biz/ui/TouchWebView
    //   552: checkcast 481	com/tencent/biz/ui/TouchWebView
    //   555: aload_0
    //   556: getfield 483	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mScrollChangedListener	Lcom/tencent/biz/ui/TouchWebView$OnScrollChangedListener;
    //   559: invokevirtual 487	com/tencent/biz/ui/TouchWebView:setOnScrollChangedListener	(Lcom/tencent/biz/ui/TouchWebView$OnScrollChangedListener;)V
    //   562: new 157	java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   569: aload 17
    //   571: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: aload 18
    //   576: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: invokevirtual 493	java/lang/String:hashCode	()I
    //   585: invokestatic 499	java/lang/Math:abs	(I)I
    //   588: istore 5
    //   590: aload_1
    //   591: iload 5
    //   593: invokevirtual 502	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setVideoId	(I)V
    //   596: new 274	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo
    //   599: dup
    //   600: aload_1
    //   601: aload 30
    //   603: new 99	java/util/HashMap
    //   606: dup
    //   607: invokespecial 100	java/util/HashMap:<init>	()V
    //   610: invokespecial 505	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:<init>	(Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController;Landroid/widget/FrameLayout;Ljava/util/Map;)V
    //   613: astore 29
    //   615: aload 29
    //   617: aload 17
    //   619: putfield 507	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   622: aload 29
    //   624: iload 15
    //   626: putfield 509	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:jdField_b_of_type_Boolean	Z
    //   629: aload 29
    //   631: iload 6
    //   633: putfield 512	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:jdField_c_of_type_Int	I
    //   636: aload 29
    //   638: iload 4
    //   640: putfield 514	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:jdField_b_of_type_Int	I
    //   643: aload 29
    //   645: iload 5
    //   647: putfield 516	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:jdField_a_of_type_Int	I
    //   650: aload 29
    //   652: iload 7
    //   654: putfield 518	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:jdField_d_of_type_Int	I
    //   657: aload 29
    //   659: aload 22
    //   661: putfield 520	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   664: aload 29
    //   666: iload 14
    //   668: putfield 522	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:jdField_a_of_type_Boolean	Z
    //   671: iload 8
    //   673: iconst_2
    //   674: if_icmpne +272 -> 946
    //   677: iconst_1
    //   678: istore 16
    //   680: aload 29
    //   682: iload 16
    //   684: putfield 524	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:jdField_d_of_type_Boolean	Z
    //   687: aload 29
    //   689: aload 23
    //   691: putfield 526	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   694: aload 29
    //   696: aload 24
    //   698: putfield 528	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:e	Ljava/lang/String;
    //   701: aload 29
    //   703: aload 26
    //   705: putfield 531	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:g	Ljava/lang/String;
    //   708: aload 29
    //   710: aload 25
    //   712: putfield 534	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:f	Ljava/lang/String;
    //   715: aload 29
    //   717: aload 27
    //   719: putfield 537	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:h	Ljava/lang/String;
    //   722: aload 29
    //   724: aload 28
    //   726: putfield 540	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:i	Ljava/lang/String;
    //   729: aload 29
    //   731: aload 19
    //   733: putfield 543	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:j	Ljava/lang/String;
    //   736: aload 29
    //   738: aload 21
    //   740: putfield 546	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:k	Ljava/lang/String;
    //   743: aload 29
    //   745: aload 20
    //   747: putfield 549	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:l	Ljava/lang/String;
    //   750: aload_0
    //   751: getfield 102	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoViewMap	Ljava/util/Map;
    //   754: iload 5
    //   756: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   759: aload 29
    //   761: invokeinterface 552 3 0
    //   766: pop
    //   767: new 554	com/tencent/mobileqq/gamecenter/data/FeedsItemData
    //   770: dup
    //   771: invokespecial 555	com/tencent/mobileqq/gamecenter/data/FeedsItemData:<init>	()V
    //   774: astore 22
    //   776: aload 22
    //   778: aload 17
    //   780: putfield 558	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoVid	Ljava/lang/String;
    //   783: iload 7
    //   785: iconst_1
    //   786: if_icmpne +166 -> 952
    //   789: aload 22
    //   791: iconst_2
    //   792: putfield 561	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
    //   795: aload 22
    //   797: iload 9
    //   799: putfield 564	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoDuration	I
    //   802: aload 22
    //   804: aload 18
    //   806: putfield 567	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoUrl	Ljava/lang/String;
    //   809: aload_1
    //   810: aload 22
    //   812: iconst_1
    //   813: invokevirtual 571	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setData	(Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;I)V
    //   816: iload 15
    //   818: ifeq +7 -> 825
    //   821: aload_1
    //   822: invokevirtual 573	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:autoPlay	()V
    //   825: iload 14
    //   827: ifeq +8 -> 835
    //   830: aload_1
    //   831: iconst_1
    //   832: invokevirtual 576	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setMute	(Z)V
    //   835: aload_1
    //   836: new 578	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$5
    //   839: dup
    //   840: aload_0
    //   841: invokespecial 579	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$5:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   844: invokevirtual 583	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setVideoStatusChangerListener	(Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController$VideoStatusChangeListener;)V
    //   847: aload 19
    //   849: ifnull +15 -> 864
    //   852: aload_1
    //   853: new 585	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$6
    //   856: dup
    //   857: aload_0
    //   858: invokespecial 586	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$6:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   861: invokevirtual 590	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setOnProgressChangeListener	(Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController$OnProgressChangeListener;)V
    //   864: aload 21
    //   866: ifnull +15 -> 881
    //   869: aload_1
    //   870: new 592	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$7
    //   873: dup
    //   874: aload_0
    //   875: invokespecial 593	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$7:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   878: invokevirtual 597	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setOnSeekListener	(Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController$OnSeekListener;)V
    //   881: iload 5
    //   883: istore 4
    //   885: aload 20
    //   887: ifnull -848 -> 39
    //   890: aload_1
    //   891: new 599	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$8
    //   894: dup
    //   895: aload_0
    //   896: invokespecial 600	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$8:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   899: invokevirtual 604	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setOnDanmakuChangeListener	(Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController$OnDanmakuChangeListener;)V
    //   902: iload 5
    //   904: ireturn
    //   905: astore_1
    //   906: ldc 37
    //   908: iconst_1
    //   909: new 157	java/lang/StringBuilder
    //   912: dup
    //   913: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   916: ldc_w 606
    //   919: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: aload_1
    //   923: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   926: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   929: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   932: iconst_m1
    //   933: ireturn
    //   934: iconst_0
    //   935: istore 14
    //   937: goto -795 -> 142
    //   940: iconst_0
    //   941: istore 15
    //   943: goto -787 -> 156
    //   946: iconst_0
    //   947: istore 16
    //   949: goto -269 -> 680
    //   952: aload 22
    //   954: iconst_1
    //   955: putfield 561	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
    //   958: goto -163 -> 795
    //   961: astore_1
    //   962: goto -650 -> 312
    //   965: goto -621 -> 344
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	968	0	this	GameCenterAPIJavaScript
    //   0	968	1	paramJSONObject	JSONObject
    //   321	100	2	f1	float
    //   319	13	3	f2	float
    //   37	847	4	i	int
    //   81	822	5	j	int
    //   72	560	6	k	int
    //   126	661	7	m	int
    //   172	503	8	n	int
    //   181	617	9	i1	int
    //   90	304	10	i2	int
    //   190	307	11	i3	int
    //   275	136	12	i4	int
    //   285	82	13	i5	int
    //   140	796	14	bool1	boolean
    //   154	788	15	bool2	boolean
    //   295	653	16	bool3	boolean
    //   99	680	17	str1	String
    //   108	697	18	str2	String
    //   245	603	19	str3	String
    //   255	631	20	str4	String
    //   265	600	21	str5	String
    //   117	836	22	localObject1	Object
    //   163	527	23	str6	String
    //   199	498	24	str7	String
    //   208	503	25	str8	String
    //   217	487	26	str9	String
    //   226	492	27	str10	String
    //   235	490	28	str11	String
    //   402	358	29	localObject2	Object
    //   515	87	30	localFrameLayout	FrameLayout
    // Exception table:
    //   from	to	target	type
    //   56	139	905	java/lang/Exception
    //   142	153	905	java/lang/Exception
    //   156	307	905	java/lang/Exception
    //   312	320	905	java/lang/Exception
    //   328	334	905	java/lang/Exception
    //   340	344	905	java/lang/Exception
    //   344	451	905	java/lang/Exception
    //   456	481	905	java/lang/Exception
    //   481	671	905	java/lang/Exception
    //   680	783	905	java/lang/Exception
    //   789	795	905	java/lang/Exception
    //   795	816	905	java/lang/Exception
    //   821	825	905	java/lang/Exception
    //   830	835	905	java/lang/Exception
    //   835	847	905	java/lang/Exception
    //   852	864	905	java/lang/Exception
    //   869	881	905	java/lang/Exception
    //   890	902	905	java/lang/Exception
    //   952	958	905	java/lang/Exception
    //   307	312	961	java/lang/Exception
  }
  
  public int delFlag(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      int j = paramJSONObject.optInt("pid");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        paramJSONObject = (GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i));
        View localView = (View)paramJSONObject.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(j));
        paramJSONObject.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(localView);
        paramJSONObject.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(j));
        return 0;
      }
      QLog.e("GCApi", 1, "[setText] Err: not find videoPlayer");
      return -1;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "setText Err:" + paramJSONObject.toString());
    }
    return -1;
  }
  
  public int delText(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      int j = paramJSONObject.optInt("pid");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        paramJSONObject = (GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i));
        View localView = (View)paramJSONObject.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(j));
        paramJSONObject.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(localView);
        paramJSONObject.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(j));
        return 0;
      }
      QLog.e("GCApi", 1, "[setText] Err: not find videoPlayer");
      return -1;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "setText Err:" + paramJSONObject.toString());
    }
    return -1;
  }
  
  public int destoryVideo(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        paramJSONObject = ((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
        paramJSONObject.stop();
        paramJSONObject.release();
        this.mVideoContainer.removeView(paramJSONObject);
        this.mVideoContainer.removeView(((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_AndroidWidgetFrameLayout);
        this.mVideoViewMap.remove(Integer.valueOf(i));
      }
      else
      {
        QLog.e("GCApi", 1, "[destoryVideo] Err: not find videoPlayer");
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "[destoryVideo] Err:" + paramJSONObject.toString());
      return -1;
    }
    return 0;
  }
  
  public String getOpenidBatch(String paramString)
  {
    String str = "";
    if ((this.mContext instanceof GameCenterActivity)) {
      str = GameCenterActivity.a(this.mContext, "https://cgi.connect.qq.com/api/get_openids_by_appids", paramString, this.uin);
    }
    return str;
  }
  
  public long getProgress(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null) {
        return ((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.getCurrentPostion();
      }
      QLog.e("GCApi", 1, "[getProgress] Err: not find videoPlayer");
      return -1L;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "getProgress Err:" + paramJSONObject.toString());
    }
    return -1L;
  }
  
  public String getReportPublicData()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append("" + MobileInfoUtil.c());
      localStringBuilder.append("|");
      localStringBuilder.append("" + MobileInfoUtil.a());
      localStringBuilder.append("|");
      localStringBuilder.append("" + GCCommon.a(this.mContext.getApplicationContext()));
      localStringBuilder.append("|");
      localStringBuilder.append("" + Build.MODEL);
      return localStringBuilder.toString();
    }
    catch (Exception localException) {}
    return "";
  }
  
  public String getReportPublicHighData()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append("" + GCCommon.b());
      localStringBuilder.append("|");
      localStringBuilder.append("" + APNUtil.a(this.mContext.getApplicationContext()));
      localStringBuilder.append("|");
      localStringBuilder.append("" + Build.VERSION.RELEASE);
      localStringBuilder.append("|");
      localStringBuilder.append("" + CommonDataAdapter.a().d());
      localStringBuilder.append("|");
      localStringBuilder.append(AppSetting.a());
      localStringBuilder.append("|");
      localStringBuilder.append(this.dm.widthPixels + " * " + this.dm.heightPixels);
      return localStringBuilder.toString();
    }
    catch (Exception localException) {}
    return "";
  }
  
  public long getTotalDuration(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null) {
        return ((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.getDuration();
      }
      QLog.e("GCApi", 1, "[getProgress] Err: not find videoPlayer");
      return -1L;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "getProgress Err:" + paramJSONObject.toString());
    }
    return -1L;
  }
  
  public String getVersionName()
  {
    try
    {
      String str = CommonDataAdapter.a().d();
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "4.3.0";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("GCApi", 2, "[handleJsRequest] method:" + paramString3 + "params:" + paramVarArgs[0]);
    }
    if ("GCApi".equals(paramString2))
    {
      if (METHOD_GET_SESSION_INFO.equals(paramString3)) {}
      for (;;)
      {
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramString2 = paramString1.optString("callback");
          this.mReqBundle.clear();
          this.mReqBundle.putInt("dataType", paramString1.optInt("dataType", 0));
          super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_get_session_info", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
          paramString1 = null;
        }
        catch (JSONException paramString1)
        {
          paramString1.printStackTrace();
          paramString1 = null;
          continue;
        }
        if ((paramJsBridgeListener != null) && (paramString1 != null)) {
          paramJsBridgeListener.a(paramString1);
        }
        return true;
        if (METHOD_GET_REQUEST_INFO.equals(paramString3))
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramString2 = paramString1.optString("callback");
            this.mReqBundle.clear();
            this.mReqBundle.putString("gameId", paramString1.optString("gameId", ""));
            super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_get_request_info", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if (METHOD_OPEN_AIO.equals(paramString3))
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramString2 = paramString1.optString("callback");
            this.mReqBundle.clear();
            this.mReqBundle.putString("sessionId", paramString1.optString("sessionId", ""));
            super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_open_aio", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if (METHOD_GET_UNREAD_TOTAL.equals(paramString3))
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]).optString("callback");
            this.mReqBundle.clear();
            super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_get_unread_total", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if (METHOD_TOGGLE_CHANGE.equals(paramString3))
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramString2 = paramString1.optString("callback");
            this.mReqBundle.clear();
            this.mReqBundle.putString("gameId", paramString1.optString("gameId", ""));
            this.mReqBundle.putInt("switchType", paramString1.optInt("switchType", -1));
            this.mReqBundle.putInt("value", paramString1.optInt("value", -1));
            super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_toggle_changed", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("createVideo".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            int j = createVideo(paramString2);
            if (j > 0) {}
            for (;;)
            {
              paramString2 = new JSONObject();
              paramString2.put("ret", i);
              paramString2.put("id", j);
              super.callJs(paramString1 + "(" + paramString2.toString() + ");");
              paramString1 = null;
              break;
              i = j;
            }
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("destoryVideo".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = destoryVideo(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("playVideo".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = playVideo(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("pauseVideo".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = pauseVideo(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("stopVideo".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = stopVideo(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("setPosition".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = setPosition(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("setFlag".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = setFlag(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", 0);
            paramString2.put("pid", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("delFlag".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = delFlag(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("setText".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = setText(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", 0);
            paramString2.put("pid", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("delText".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = delText(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("setFullScreen".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = setFullScreen(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("setMute".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = setMute(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("getProgress".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            long l1 = getProgress(paramString2);
            long l2 = getTotalDuration(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", 0);
            paramString2.put("current", l1);
            paramString2.put("total", l2);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("setDanmuViewProperty".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = setDanmuViewProperty(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("setDanmuData".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = setDanmuData(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("clearDanmu".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = clearDanmu(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if (("getOpenidBatch".equals(paramString3)) && (paramVarArgs.length == 1))
        {
          paramString1 = getOpenidBatch(paramVarArgs[0]);
        }
        else if (("showWarningToast".equals(paramString3)) && (paramVarArgs.length == 1))
        {
          showWarningToast(paramVarArgs[0]);
          paramString1 = null;
        }
        else if ("getUin".equals(paramString3))
        {
          paramString1 = this.uin;
        }
        else if (("setTitleLoading".equals(paramString3)) && (paramVarArgs.length == 1))
        {
          setTitleLoading(paramVarArgs[0]);
          paramString1 = null;
        }
        else if ("getReportPublicData".equals(paramString3))
        {
          paramString1 = getReportPublicData();
        }
        else if ("getReportPublicHighData".equals(paramString3))
        {
          paramString1 = getReportPublicHighData();
        }
        else if (("reportAction".equals(paramString3)) && (paramVarArgs.length == 3))
        {
          reportAction(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
          paramString1 = null;
        }
        else if ("getVersionName".equals(paramString3))
        {
          paramString1 = getVersionName();
        }
        else if (("startToAuthorized".equals(paramString3)) && (paramVarArgs.length == 1))
        {
          startToAuthorized(paramVarArgs[0]);
          paramString1 = null;
        }
        else if (METHOD_OPEN_QQPLAYER_AIO.equals(paramString3))
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramString2 = paramString1.optString("callback");
            this.mReqBundle.clear();
            this.mReqBundle.putString("fromRoleId", paramString1.optString("fromRoleId", ""));
            this.mReqBundle.putString("fromOpenId", paramString1.optString("fromOpenId", ""));
            this.mReqBundle.putString("toRoleId", paramString1.optString("toRoleId", ""));
            this.mReqBundle.putString("toOpenId", paramString1.optString("toOpenId", ""));
            this.mReqBundle.putString("fromTinyId", paramString1.optString("fromTinyId", ""));
            this.mReqBundle.putString("toTinyId", paramString1.optString("toTinyId", ""));
            this.mReqBundle.putLong("gameAppId", paramString1.optLong("gameAppId", 0L));
            this.mReqBundle.putInt("windowFlag", paramString1.optInt("windowFlag", 0));
            this.mReqBundle.putString("topGrayText", paramString1.optString("topGrayText", ""));
            this.mReqBundle.putString("sig", paramString1.optString("sig", ""));
            this.mReqBundle.putInt("fromPage", paramString1.optInt("fromPage"));
            super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_open_qqplayer_aio", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramString2 = paramString1.optString("callback");
            handleScreenShotMethod(paramString3, paramString1.optJSONObject("data"), paramString2);
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            QLog.e("GCApi", 1, "handleScreenShotMethod e=" + paramString1.toString());
            paramString1 = null;
          }
        }
      }
    }
    return false;
  }
  
  public boolean handleScreenShotMethod(String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    paramString2 = new GameCenterAPIJavaScript.1(this, paramString2);
    if ("shotScreen".equals(paramString1))
    {
      ScreenshotManager.a().a(this.mRuntime.a(), paramJSONObject.optString("key"), paramString2);
      return true;
    }
    if ("removeMask".equals(paramString1))
    {
      ScreenshotManager.a().a(this.mRuntime.a(), paramString2);
      return true;
    }
    if ("delImg".equals(paramString1))
    {
      ScreenshotManager.a().a(paramString2);
      return true;
    }
    if ("closeSwitch".equals(paramString1))
    {
      ScreenshotManager.a().b(paramString2);
      return true;
    }
    if ("openSwitch".equals(paramString1))
    {
      ScreenshotManager.a().c(paramString2);
      return true;
    }
    if ("queryInfo".equals(paramString1))
    {
      ScreenshotManager.a().a(paramJSONObject.optString("key"), paramString2);
      return true;
    }
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mReqBundle = new Bundle();
    this.dm = new DisplayMetrics();
    this.mContext = this.mRuntime.a();
    if (this.mContext != null) {
      ((Activity)this.mContext).getWindowManager().getDefaultDisplay().getMetrics(this.dm);
    }
    if (this.mRuntime.a() != null) {
      this.uin = this.mRuntime.a().getCurrentAccountUin();
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_qgame_messgae_change");
    localIntentFilter.addAction("action_qgame_unread_change");
    BaseApplicationImpl.getApplication().registerReceiver(this.mMsgReceiver, localIntentFilter);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mMsgReceiver != null) {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.mMsgReceiver);
    }
    GameCenterVideoManager.a().a();
  }
  
  public void onResponse(Bundle paramBundle)
  {
    super.onResponse(paramBundle);
    Object localObject;
    String str;
    if (paramBundle != null)
    {
      localObject = paramBundle.getString("cmd");
      if (QLog.isColorLevel()) {
        QLog.d("GCApi", 1, "[onResponse] cmd:" + (String)localObject);
      }
      i = paramBundle.getInt("respkey", 0);
      if (QLog.isColorLevel()) {
        QLog.d("GCApi", 1, "[onResponse] respkey:" + i + "，key:" + this.mOnRemoteResp.key);
      }
      if (i == this.mOnRemoteResp.key)
      {
        str = paramBundle.getString("callbackid");
        paramBundle = paramBundle.getBundle("response");
        if ((localObject != null) && (paramBundle != null))
        {
          Activity localActivity = this.mRuntime.a();
          if ((localActivity != null) && (!this.isDestroy) && (!localActivity.isFinishing())) {
            break label182;
          }
          callbackError(str, "-1000");
        }
      }
    }
    label182:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            try
            {
              if ("ipc_cmd_gamecenter_get_session_info".equals(localObject))
              {
                i = paramBundle.getInt("result");
                paramBundle = paramBundle.getString("data");
                localObject = new JSONObject(paramBundle);
                ((JSONObject)localObject).put("ret", i);
                super.callJs(str + "&&" + str + "(" + ((JSONObject)localObject).toString() + ");");
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("GCApi", 2, "ipc_cmd_gamecenter_get_session_info onResponse dataStr is:" + paramBundle);
              }
            }
            catch (Throwable paramBundle)
            {
              if (QLog.isColorLevel()) {
                QLog.e("GCApi", 2, paramBundle.getMessage());
              }
              callbackError(str, "-2000");
              return;
            }
          }
          if (!"ipc_cmd_gamecenter_get_request_info".equals(localObject)) {
            break;
          }
          i = paramBundle.getInt("result");
          paramBundle = paramBundle.getString("data");
          localObject = new JSONObject(paramBundle);
          ((JSONObject)localObject).put("ret", i);
          super.callJs(str + "&&" + str + "(" + ((JSONObject)localObject).toString() + ");");
        } while (!QLog.isColorLevel());
        QLog.d("GCApi", 2, "ipc_cmd_gamecenter_get_request_info onResponse dataStr is:" + paramBundle);
        return;
        if ("ipc_cmd_gamecenter_open_aio".equals(localObject))
        {
          i = paramBundle.getInt("result", -1);
          paramBundle = new JSONObject();
          paramBundle.put("ret", i);
          super.callJs(str + "&&" + str + "(" + paramBundle.toString() + ");");
          return;
        }
        if (!"ipc_cmd_gamecenter_get_unread_total".equals(localObject)) {
          break;
        }
        i = paramBundle.getInt("result");
        localObject = new JSONObject();
        ((JSONObject)localObject).put("ret", i);
        ((JSONObject)localObject).put("newMsgCount", paramBundle.getInt("cnt"));
        super.callJs(str + "&&" + str + "(" + ((JSONObject)localObject).toString() + ");");
      } while (!QLog.isColorLevel());
      QLog.d("GCApi", 2, "ipc_cmd_gamecenter_get_request_info onResponse dataStr is:" + ((JSONObject)localObject).toString());
      return;
      if ("ipc_cmd_gamecenter_toggle_changed".equals(localObject))
      {
        callbackOk(str);
        return;
      }
    } while (!"ipc_cmd_gamecenter_open_qqplayer_aio".equals(localObject));
    int i = paramBundle.getInt("result", -1);
    paramBundle = new JSONObject();
    paramBundle.put("ret", i);
    super.callJs(str + "&&" + str + "(" + paramBundle.toString() + ");");
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    RefreshView localRefreshView = (RefreshView)this.mRuntime.a().findViewById(2131381873);
    this.mVideoContainer = new GameCenterAPIJavaScript.2(this, this.mRuntime.a(), paramCustomWebView);
    localRefreshView.addView(this.mVideoContainer, localLayoutParams);
    paramCustomWebView = (TouchWebView)this.mRuntime.a();
    this.mVideoContainer.scrollBy(0, paramCustomWebView.mTotalYoffset);
    this.mScrollChangedListener = new GameCenterAPIJavaScript.3(this);
    paramCustomWebView = this.mRuntime.a();
    if ((paramCustomWebView instanceof GameCenterActivity)) {
      ((GameCenterActivity)paramCustomWebView).a(this.mScrollChangedListener);
    }
  }
  
  public int pauseVideo(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        ((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.pause();
        new JSONObject();
      }
      else
      {
        QLog.e("GCApi", 1, "[pauseVideo] Err: not find videoPlayer");
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "pauseVideo Err:" + paramJSONObject.toString());
      return -1;
    }
    return 0;
  }
  
  public int playVideo(JSONObject paramJSONObject)
  {
    QLog.d("GCApi", 4, "playVideo JSONObject: " + paramJSONObject.toString());
    try
    {
      int i = paramJSONObject.optInt("id");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null) {
        ((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.play();
      } else {
        QLog.e("GCApi", 1, "[playVideo] Err: not find videoPlayer");
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "playVideo Err:" + paramJSONObject.toString());
      return -1;
    }
    return 0;
  }
  
  public void reportAction(String paramString1, String paramString2, String paramString3)
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCount(this.mRuntime.a(), this.uin, paramString1, paramString2, 0, 1, paramString3, null, null, null, null);
  }
  
  public int setDanmuData(JSONObject paramJSONObject)
  {
    for (;;)
    {
      int i;
      try
      {
        i = paramJSONObject.optInt("id");
        if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
        {
          GameCenterVideoViewController localGameCenterVideoViewController = ((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
          paramJSONObject = paramJSONObject.optJSONArray("data");
          if (paramJSONObject == null) {
            break;
          }
          DanmakuHost.Item[] arrayOfItem = new DanmakuHost.Item[paramJSONObject.length()];
          i = 0;
          if (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
            if (localJSONObject != null) {
              arrayOfItem[i] = new DanmakuHost.Item(localJSONObject.optString("text"), localJSONObject.optDouble("onScreenTime"), localJSONObject.optDouble("screenDuration"), localJSONObject.optString("fontColor"), localJSONObject.optString("backgroundColor"));
            }
          }
          else
          {
            localGameCenterVideoViewController.getDanmakuLayout().a(arrayOfItem);
            break;
          }
        }
        else
        {
          QLog.e("GCApi", 1, "[setDanmuData] Err: not find videoPlayer");
          return -1;
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.d("GCApi", 1, "setDanmuData Err:" + paramJSONObject.toString());
        return -1;
      }
      i += 1;
    }
    return 0;
  }
  
  public int setDanmuViewProperty(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        GameCenterVideoViewController localGameCenterVideoViewController = ((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
        i = paramJSONObject.optInt("topDist");
        int j = paramJSONObject.optInt("bottomDist");
        if (!paramJSONObject.has("topDist")) {
          i = localGameCenterVideoViewController.getDanmakuLayout().getPaddingTop();
        }
        if (!paramJSONObject.has("bottomDist")) {
          j = localGameCenterVideoViewController.getDanmakuLayout().getPaddingBottom();
        }
        localGameCenterVideoViewController.getDanmakuLayout().setPadding(0, i, 0, j);
        if (paramJSONObject.has("lineSpacing")) {
          localGameCenterVideoViewController.getDanmakuLayout().setLineSpacing(paramJSONObject.optInt("lineSpacing"));
        }
        if (paramJSONObject.has("fontSize")) {
          localGameCenterVideoViewController.getDanmakuLayout().setTextSize(paramJSONObject.optInt("fontSize"));
        }
      }
      else
      {
        QLog.e("GCApi", 1, "[setDanmuViewProperty] Err: not find videoPlayer");
        return -1;
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "setDanmuViewProperty Err:" + paramJSONObject.toString());
      return -1;
    }
    return 0;
  }
  
  public int setFlag(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      int j = paramJSONObject.optInt("y");
      int k = paramJSONObject.optInt("x");
      int m = paramJSONObject.optInt("width");
      int n = paramJSONObject.optInt("height");
      paramJSONObject = paramJSONObject.optString("pic");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        FrameLayout localFrameLayout = ((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_AndroidWidgetFrameLayout;
        URLImageView localURLImageView = new URLImageView(this.mContext);
        float f = this.mRuntime.a().getResources().getDisplayMetrics().density;
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)(m * f), (int)(n * f));
        localLayoutParams.topMargin = ((int)(j * f));
        localLayoutParams.leftMargin = ((int)(k * f));
        localFrameLayout.addView(localURLImageView, localLayoutParams);
        j = localURLImageView.hashCode();
        ((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(j), localURLImageView);
        localURLImageView.setImageURL(paramJSONObject);
        return j;
      }
      QLog.e("GCApi", 1, "[setFlag] Err: not find videoPlayer");
      return -1;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "setFlag Err:" + paramJSONObject.toString());
    }
    return -1;
  }
  
  public int setFullScreen(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      boolean bool = paramJSONObject.optBoolean("fullscreen");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        paramJSONObject = ((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
        if (bool) {
          paramJSONObject.enterFullScreen();
        } else {
          paramJSONObject.exitFullScreen();
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "setFullScreen Err:" + paramJSONObject.toString());
      return -1;
    }
    QLog.e("GCApi", 1, "[setFullScreen] Err: not find videoPlayer");
    return -1;
    return 0;
  }
  
  public int setMute(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      boolean bool = paramJSONObject.optBoolean("mute");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        ((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.setMute(bool);
        return 0;
      }
      QLog.e("GCApi", 1, "[setMute] Err: not find videoPlayer");
      return -1;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "setMute Err:" + paramJSONObject.toString());
    }
    return -1;
  }
  
  public int setPosition(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      int j = paramJSONObject.optInt("y");
      int k = paramJSONObject.optInt("x");
      int m = paramJSONObject.optInt("tabHeight", 0);
      int n = paramJSONObject.optInt("bottomHeight", 0);
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        paramJSONObject = ((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramJSONObject.getLayoutParams();
        float f = this.mRuntime.a().getResources().getDisplayMetrics().density;
        localLayoutParams.topMargin = ((int)((j - m) * f));
        localLayoutParams.leftMargin = ((int)((k - n) * f));
        paramJSONObject.setLayoutParams(localLayoutParams);
      }
      else
      {
        QLog.e("GCApi", 1, "[setPostion] Err: not find videoPlayer");
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "setPostion Err:" + paramJSONObject.toString());
      return -1;
    }
    return 0;
  }
  
  public int setText(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      int j = paramJSONObject.optInt("y");
      int k = paramJSONObject.optInt("x");
      int m = paramJSONObject.optInt("fontsize", 10);
      Object localObject = paramJSONObject.optString("color");
      String str = paramJSONObject.optString("txt");
      boolean bool = paramJSONObject.optBoolean("border", false);
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        paramJSONObject = ((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_AndroidWidgetFrameLayout;
        TextView localTextView = new TextView(this.mContext);
        if (bool) {
          localTextView.setBackgroundResource(2130840315);
        }
        float f = this.mRuntime.a().getResources().getDisplayMetrics().density;
        localTextView.setPadding(AIOUtils.a(3.0F, this.mContext.getResources()), AIOUtils.a(3.0F, this.mContext.getResources()), AIOUtils.a(3.0F, this.mContext.getResources()), AIOUtils.a(3.0F, this.mContext.getResources()));
        localTextView.setText(str);
        localTextView.setTextSize(m);
        localTextView.setTextColor(Color.parseColor((String)localObject));
        m = localTextView.hashCode();
        localObject = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject).topMargin = ((int)(j * f));
        ((FrameLayout.LayoutParams)localObject).leftMargin = ((int)(k * f));
        paramJSONObject.addView(localTextView, (ViewGroup.LayoutParams)localObject);
        ((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(m), localTextView);
        return m;
      }
      QLog.e("GCApi", 1, "[setText] Err: not find videoPlayer");
      return -1;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "setText Err:" + paramJSONObject.toString());
    }
    return -1;
  }
  
  public void setTitleLoading(String paramString)
  {
    if ((this.mContext instanceof GameCenterActivity)) {
      try
      {
        if ("true".equals(paramString)) {}
        for (int i = 1; i != 0; i = 0)
        {
          ((GameCenterActivity)this.mContext).a.sendEmptyMessage(2003);
          return;
          if (!"false".equals(paramString)) {
            return;
          }
        }
        ((GameCenterActivity)this.mContext).a.sendEmptyMessage(2004);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void showWarningToast(String paramString)
  {
    if ((this.mContext instanceof GameCenterActivity)) {}
    try
    {
      Message localMessage = Message.obtain(((GameCenterActivity)this.mContext).a);
      localMessage.what = 2006;
      localMessage.obj = paramString;
      ((GameCenterActivity)this.mContext).a.sendMessage(localMessage);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void startToAuthorized(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      ((JSONObject)localObject).put("uin", this.uin);
      localObject = ((JSONObject)localObject).toString();
      paramString = (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    MyAppApi.a().a(paramString, null, (Activity)this.mContext);
  }
  
  public int stopVideo(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null) {
        ((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.stop();
      } else {
        QLog.e("GCApi", 1, "[stopVideo] Err: not find videoPlayer");
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "stopVideo Err:" + paramJSONObject.toString());
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.GameCenterAPIJavaScript
 * JD-Core Version:    0.7.0.1
 */