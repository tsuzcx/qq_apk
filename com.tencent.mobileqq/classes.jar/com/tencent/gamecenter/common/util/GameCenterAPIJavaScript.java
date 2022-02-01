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
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.gamecenter.media.DanmakuHost.Item;
import com.tencent.mobileqq.gamecenter.media.DanmakuLayout;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoManager;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.gamecenter.msgInfo.GameCenterSessionInfo;
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
  public static String EVENT_UPDATE_SESSION_INFO = "gameCenter_sessionChanged";
  public static String EVENT_UPDATE_UNREAD_CNT = "gameCenter_newMsgCountChanged";
  public static String METHOD_GET_REQUEST_INFO = "getRequestData";
  public static String METHOD_GET_SESSION_INFO = "getSessionData";
  public static String METHOD_GET_UNREAD_TOTAL = "getNewMsgCount";
  public static String METHOD_OPEN_AIO = "clickCommonSession";
  public static String METHOD_OPEN_QQPLAYER_AIO = "openQQPlayerAio";
  public static String METHOD_TOGGLE_CHANGE = "setSwitch";
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
    Object localObject;
    int i;
    if (paramBundle != null)
    {
      localObject = (GameCenterSessionInfo)paramBundle.getParcelable("key_game_msg");
      i = paramBundle.getInt("key_msg_change_type");
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("[onReceive] type:");
        paramBundle.append(i);
        paramBundle.append(",info:");
        paramBundle.append(localObject);
        QLog.d("GCApi", 0, paramBundle.toString());
      }
      paramBundle = new JSONArray();
      if (localObject != null) {
        paramBundle.put(((GameCenterSessionInfo)localObject).a());
      }
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("session", paramBundle);
      ((JSONObject)localObject).put("eventType", i);
      ((JSONObject)localObject).put("ret", 0);
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("[onReceive] gameCenterMsg: ");
        paramBundle.append(((JSONObject)localObject).toString());
        QLog.d("GCApi", 2, paramBundle.toString());
      }
      return localObject;
    }
    catch (Exception paramBundle)
    {
      label166:
      break label166;
    }
    return null;
  }
  
  public static JSONObject parseGameMessageUnreadCount(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("key_msg_unread_cnt");
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("[onReceive] cnt:");
        paramBundle.append(i);
        QLog.d("GCApi", 2, paramBundle.toString());
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
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString1);
      localStringBuilder2.append("&&");
      localStringBuilder2.append(paramString1);
      localStringBuilder2.append("(");
      localStringBuilder2.append(localJSONObject.toString());
      localStringBuilder2.append(");");
      super.callJs(localStringBuilder2.toString());
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GCApi", 2, localException.getMessage());
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("callbackId->");
      localStringBuilder1.append(paramString1);
      localStringBuilder1.append(" errorMsg: ");
      localStringBuilder1.append(paramString2);
      QLog.e("GCApi", 2, localStringBuilder1.toString());
    }
  }
  
  void callbackJS(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", paramInt);
      localJSONObject.put("msg", paramString2);
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("(");
      paramString2.append(localJSONObject.toString());
      paramString2.append(");");
      super.callJs(paramString2.toString());
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("callbackId->");
        paramString2.append(paramString1);
        paramString2.append(" callbackOk");
        paramString2.append(localJSONObject.toString());
        QLog.d("GCApi", 2, paramString2.toString());
        return;
      }
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GCApi", 2, paramString1.getMessage());
      }
    }
  }
  
  void callbackOk(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ret", 0);
      localJSONObject.put("msg", "");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("&&");
      localStringBuilder.append(paramString);
      localStringBuilder.append("(");
      localStringBuilder.append(localJSONObject.toString());
      localStringBuilder.append(");");
      super.callJs(localStringBuilder.toString());
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("callbackId->");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" callbackOk");
        localStringBuilder.append(localJSONObject.toString());
        QLog.d("GCApi", 2, localStringBuilder.toString());
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GCApi", 2, paramString.getMessage());
      }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearDanmuData Err:");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.d("GCApi", 1, localStringBuilder.toString());
      return -1;
    }
    return 0;
  }
  
  /* Error */
  public int createVideo(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: invokestatic 284	com/tencent/mobileqq/qqvideoplatform/api/QQVideoPlaySDKManager:a	()Z
    //   3: ifne +54 -> 57
    //   6: aload_0
    //   7: getfield 288	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   10: ifnull +45 -> 55
    //   13: aload_0
    //   14: getfield 288	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   17: invokevirtual 293	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   20: ifnull +35 -> 55
    //   23: aload_0
    //   24: getfield 288	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   27: invokevirtual 293	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   30: invokevirtual 299	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   33: ifnonnull +5 -> 38
    //   36: iconst_m1
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 288	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   42: invokevirtual 293	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   45: invokevirtual 299	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   48: aconst_null
    //   49: invokestatic 302	com/tencent/mobileqq/qqvideoplatform/api/QQVideoPlaySDKManager:a	(Landroid/content/Context;Lcom/tencent/mobileqq/videoplatform/SDKInitListener;)V
    //   52: goto +5 -> 57
    //   55: iconst_m1
    //   56: ireturn
    //   57: aload_1
    //   58: ldc_w 304
    //   61: invokevirtual 242	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   64: istore 4
    //   66: aload_1
    //   67: ldc_w 306
    //   70: invokevirtual 242	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   73: istore 5
    //   75: aload_1
    //   76: ldc_w 308
    //   79: invokevirtual 242	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   82: istore 9
    //   84: aload_1
    //   85: ldc_w 310
    //   88: invokevirtual 242	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   91: istore 10
    //   93: aload_1
    //   94: ldc_w 312
    //   97: invokevirtual 316	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 17
    //   102: aload_1
    //   103: ldc_w 318
    //   106: invokevirtual 316	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   109: astore 18
    //   111: aload_1
    //   112: ldc_w 320
    //   115: invokevirtual 316	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   118: astore 22
    //   120: aload_1
    //   121: ldc_w 322
    //   124: invokevirtual 242	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   127: istore 6
    //   129: aload_1
    //   130: ldc_w 324
    //   133: invokevirtual 242	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   136: iconst_1
    //   137: if_icmpne +839 -> 976
    //   140: iconst_1
    //   141: istore 14
    //   143: goto +3 -> 146
    //   146: aload_1
    //   147: ldc_w 326
    //   150: invokevirtual 242	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   153: iconst_1
    //   154: if_icmpne +828 -> 982
    //   157: iconst_1
    //   158: istore 15
    //   160: goto +3 -> 163
    //   163: aload_1
    //   164: ldc_w 328
    //   167: invokevirtual 316	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   170: astore 23
    //   172: aload_1
    //   173: ldc_w 330
    //   176: invokevirtual 242	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   179: istore 7
    //   181: aload_1
    //   182: ldc_w 332
    //   185: invokevirtual 242	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   188: istore 8
    //   190: aload_1
    //   191: ldc_w 334
    //   194: invokevirtual 242	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   197: istore 11
    //   199: aload_1
    //   200: ldc_w 336
    //   203: invokevirtual 316	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore 24
    //   208: aload_1
    //   209: ldc_w 338
    //   212: invokevirtual 316	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   215: astore 25
    //   217: aload_1
    //   218: ldc_w 340
    //   221: invokevirtual 316	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   224: astore 26
    //   226: aload_1
    //   227: ldc_w 342
    //   230: invokevirtual 316	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   233: astore 27
    //   235: aload_1
    //   236: ldc_w 344
    //   239: invokevirtual 316	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   242: astore 28
    //   244: aload_1
    //   245: ldc_w 346
    //   248: aconst_null
    //   249: invokevirtual 349	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   252: astore 19
    //   254: aload_1
    //   255: ldc_w 351
    //   258: aconst_null
    //   259: invokevirtual 349	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   262: astore 20
    //   264: aload_1
    //   265: ldc_w 353
    //   268: aconst_null
    //   269: invokevirtual 349	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   272: astore 21
    //   274: aload_1
    //   275: ldc_w 355
    //   278: iconst_0
    //   279: invokevirtual 358	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   282: istore 12
    //   284: aload_1
    //   285: ldc_w 360
    //   288: iconst_0
    //   289: invokevirtual 358	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   292: istore 13
    //   294: aload_1
    //   295: ldc_w 362
    //   298: iconst_0
    //   299: invokevirtual 366	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   302: istore 16
    //   304: aload_1
    //   305: ldc_w 368
    //   308: ldc 79
    //   310: invokevirtual 349	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   313: astore_1
    //   314: aload_1
    //   315: invokestatic 374	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   318: pop
    //   319: invokestatic 380	com/tencent/mobileqq/app/FontSettingManager:getFontLevel	()F
    //   322: ldc_w 381
    //   325: fdiv
    //   326: fstore_2
    //   327: fload_2
    //   328: fconst_0
    //   329: fcmpl
    //   330: ifeq +658 -> 988
    //   333: invokestatic 385	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()F
    //   336: fload_2
    //   337: fdiv
    //   338: fstore_2
    //   339: goto +3 -> 342
    //   342: fload_2
    //   343: fstore_3
    //   344: fload_2
    //   345: fconst_0
    //   346: fcmpl
    //   347: ifne +7 -> 354
    //   350: invokestatic 385	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()F
    //   353: fstore_3
    //   354: aload_0
    //   355: getfield 100	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoContainer	Landroid/widget/FrameLayout;
    //   358: invokevirtual 391	android/widget/FrameLayout:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   361: checkcast 393	android/widget/RelativeLayout$LayoutParams
    //   364: astore_1
    //   365: aload_1
    //   366: iload 12
    //   368: i2f
    //   369: fload_3
    //   370: fmul
    //   371: f2i
    //   372: putfield 397	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   375: aload_1
    //   376: iload 13
    //   378: i2f
    //   379: fload_3
    //   380: fmul
    //   381: f2i
    //   382: putfield 400	android/widget/RelativeLayout$LayoutParams:bottomMargin	I
    //   385: aload_0
    //   386: getfield 100	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoContainer	Landroid/widget/FrameLayout;
    //   389: aload_1
    //   390: invokevirtual 404	android/widget/FrameLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   393: new 406	android/widget/FrameLayout$LayoutParams
    //   396: dup
    //   397: iload 9
    //   399: i2f
    //   400: fload_3
    //   401: fmul
    //   402: f2i
    //   403: iload 10
    //   405: i2f
    //   406: fload_3
    //   407: fmul
    //   408: f2i
    //   409: invokespecial 409	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   412: astore 30
    //   414: aload 30
    //   416: iload 4
    //   418: iload 12
    //   420: isub
    //   421: i2f
    //   422: fload_3
    //   423: fmul
    //   424: f2i
    //   425: putfield 410	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   428: aload 30
    //   430: iload 5
    //   432: i2f
    //   433: fload_3
    //   434: fmul
    //   435: f2i
    //   436: putfield 413	android/widget/FrameLayout$LayoutParams:leftMargin	I
    //   439: new 263	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController
    //   442: dup
    //   443: aload_0
    //   444: getfield 288	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   447: invokevirtual 416	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   450: invokespecial 419	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:<init>	(Landroid/content/Context;)V
    //   453: astore_1
    //   454: aload_1
    //   455: ldc_w 420
    //   458: invokevirtual 424	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setBackgroundColor	(I)V
    //   461: iload 16
    //   463: ifeq +28 -> 491
    //   466: getstatic 429	android/os/Build$VERSION:SDK_INT	I
    //   469: bipush 21
    //   471: if_icmplt +20 -> 491
    //   474: aload_1
    //   475: new 431	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$4
    //   478: dup
    //   479: aload_0
    //   480: invokespecial 434	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$4:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   483: invokevirtual 438	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setOutlineProvider	(Landroid/view/ViewOutlineProvider;)V
    //   486: aload_1
    //   487: iconst_1
    //   488: invokevirtual 442	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setClipToOutline	(Z)V
    //   491: aload_1
    //   492: invokevirtual 445	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:enableFullScreenSwitch	()V
    //   495: aload_1
    //   496: invokevirtual 448	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:enableVolumeSwitch	()V
    //   499: aload_1
    //   500: iload 7
    //   502: invokevirtual 451	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setDanmakuSwitch	(I)V
    //   505: aload_1
    //   506: iload 11
    //   508: invokevirtual 454	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setUIStyle	(I)V
    //   511: new 387	android/widget/FrameLayout
    //   514: dup
    //   515: aload_0
    //   516: getfield 288	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   519: invokevirtual 416	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   522: invokespecial 455	android/widget/FrameLayout:<init>	(Landroid/content/Context;)V
    //   525: astore 29
    //   527: aload_1
    //   528: aload 29
    //   530: new 406	android/widget/FrameLayout$LayoutParams
    //   533: dup
    //   534: iconst_m1
    //   535: iconst_m1
    //   536: invokespecial 409	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   539: invokevirtual 459	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   542: aload_0
    //   543: getfield 100	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoContainer	Landroid/widget/FrameLayout;
    //   546: aload_1
    //   547: aload 30
    //   549: invokevirtual 460	android/widget/FrameLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   552: aload_0
    //   553: getfield 288	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   556: invokevirtual 463	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   559: checkcast 465	com/tencent/biz/ui/TouchWebView
    //   562: checkcast 465	com/tencent/biz/ui/TouchWebView
    //   565: aload_0
    //   566: getfield 467	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mScrollChangedListener	Lcom/tencent/biz/ui/TouchWebView$OnScrollChangedListener;
    //   569: invokevirtual 471	com/tencent/biz/ui/TouchWebView:setOnScrollChangedListener	(Lcom/tencent/biz/ui/TouchWebView$OnScrollChangedListener;)V
    //   572: new 141	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   579: astore 30
    //   581: aload 30
    //   583: aload 17
    //   585: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload 30
    //   591: aload 18
    //   593: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: aload 30
    //   599: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokevirtual 477	java/lang/String:hashCode	()I
    //   605: invokestatic 483	java/lang/Math:abs	(I)I
    //   608: istore 9
    //   610: aload_1
    //   611: iload 9
    //   613: invokevirtual 486	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setVideoId	(I)V
    //   616: new 258	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo
    //   619: dup
    //   620: aload_1
    //   621: aload 29
    //   623: new 83	java/util/HashMap
    //   626: dup
    //   627: invokespecial 84	java/util/HashMap:<init>	()V
    //   630: invokespecial 489	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:<init>	(Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController;Landroid/widget/FrameLayout;Ljava/util/Map;)V
    //   633: astore 29
    //   635: aload 29
    //   637: aload 17
    //   639: putfield 491	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   642: aload 29
    //   644: iload 15
    //   646: putfield 493	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:jdField_b_of_type_Boolean	Z
    //   649: aload 29
    //   651: iload 5
    //   653: putfield 496	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:jdField_c_of_type_Int	I
    //   656: aload 29
    //   658: iload 4
    //   660: putfield 498	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:jdField_b_of_type_Int	I
    //   663: aload 29
    //   665: iload 9
    //   667: putfield 500	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:jdField_a_of_type_Int	I
    //   670: aload 29
    //   672: iload 6
    //   674: putfield 502	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:jdField_d_of_type_Int	I
    //   677: aload 29
    //   679: aload 22
    //   681: putfield 504	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   684: aload 29
    //   686: iload 14
    //   688: putfield 506	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:jdField_a_of_type_Boolean	Z
    //   691: iload 7
    //   693: iconst_2
    //   694: if_icmpne +299 -> 993
    //   697: iconst_1
    //   698: istore 16
    //   700: goto +3 -> 703
    //   703: aload 29
    //   705: iload 16
    //   707: putfield 508	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:jdField_d_of_type_Boolean	Z
    //   710: aload 29
    //   712: aload 23
    //   714: putfield 510	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   717: aload 29
    //   719: aload 24
    //   721: putfield 512	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:e	Ljava/lang/String;
    //   724: aload 29
    //   726: aload 26
    //   728: putfield 515	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:g	Ljava/lang/String;
    //   731: aload 29
    //   733: aload 25
    //   735: putfield 518	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:f	Ljava/lang/String;
    //   738: aload 29
    //   740: aload 27
    //   742: putfield 521	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:h	Ljava/lang/String;
    //   745: aload 29
    //   747: aload 28
    //   749: putfield 524	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:i	Ljava/lang/String;
    //   752: aload 29
    //   754: aload 19
    //   756: putfield 527	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:j	Ljava/lang/String;
    //   759: aload 29
    //   761: aload 21
    //   763: putfield 530	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:k	Ljava/lang/String;
    //   766: aload 29
    //   768: aload 20
    //   770: putfield 533	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$VideoViewInfo:l	Ljava/lang/String;
    //   773: aload_0
    //   774: getfield 86	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoViewMap	Ljava/util/Map;
    //   777: iload 9
    //   779: invokestatic 248	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   782: aload 29
    //   784: invokeinterface 536 3 0
    //   789: pop
    //   790: new 538	com/tencent/mobileqq/gamecenter/data/FeedsItemData
    //   793: dup
    //   794: invokespecial 539	com/tencent/mobileqq/gamecenter/data/FeedsItemData:<init>	()V
    //   797: astore 22
    //   799: aload 22
    //   801: aload 17
    //   803: putfield 542	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoVid	Ljava/lang/String;
    //   806: iload 6
    //   808: iconst_1
    //   809: if_icmpne +12 -> 821
    //   812: aload 22
    //   814: iconst_2
    //   815: putfield 545	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
    //   818: goto +9 -> 827
    //   821: aload 22
    //   823: iconst_1
    //   824: putfield 545	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
    //   827: aload 22
    //   829: iload 8
    //   831: putfield 548	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoDuration	I
    //   834: aload 22
    //   836: aload 18
    //   838: putfield 551	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoUrl	Ljava/lang/String;
    //   841: aload_1
    //   842: aload 22
    //   844: iconst_1
    //   845: invokevirtual 555	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setData	(Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;I)V
    //   848: iload 15
    //   850: ifeq +7 -> 857
    //   853: aload_1
    //   854: invokevirtual 557	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:autoPlay	()V
    //   857: iload 14
    //   859: ifeq +8 -> 867
    //   862: aload_1
    //   863: iconst_1
    //   864: invokevirtual 560	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setMute	(Z)V
    //   867: aload_1
    //   868: new 562	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$5
    //   871: dup
    //   872: aload_0
    //   873: invokespecial 563	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$5:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   876: invokevirtual 567	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setVideoStatusChangerListener	(Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController$VideoStatusChangeListener;)V
    //   879: aload 19
    //   881: ifnull +15 -> 896
    //   884: aload_1
    //   885: new 569	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$6
    //   888: dup
    //   889: aload_0
    //   890: invokespecial 570	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$6:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   893: invokevirtual 574	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setOnProgressChangeListener	(Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController$OnProgressChangeListener;)V
    //   896: aload 21
    //   898: ifnull +15 -> 913
    //   901: aload_1
    //   902: new 576	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$7
    //   905: dup
    //   906: aload_0
    //   907: invokespecial 577	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$7:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   910: invokevirtual 581	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setOnSeekListener	(Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController$OnSeekListener;)V
    //   913: aload 20
    //   915: ifnull +15 -> 930
    //   918: aload_1
    //   919: new 583	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$8
    //   922: dup
    //   923: aload_0
    //   924: invokespecial 584	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$8:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   927: invokevirtual 588	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setOnDanmakuChangeListener	(Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController$OnDanmakuChangeListener;)V
    //   930: iload 9
    //   932: ireturn
    //   933: astore_1
    //   934: new 141	java/lang/StringBuilder
    //   937: dup
    //   938: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   941: astore 17
    //   943: aload 17
    //   945: ldc_w 590
    //   948: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: pop
    //   952: aload 17
    //   954: aload_1
    //   955: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   958: pop
    //   959: ldc 53
    //   961: iconst_1
    //   962: aload 17
    //   964: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   967: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   970: iconst_m1
    //   971: ireturn
    //   972: astore_1
    //   973: goto -654 -> 319
    //   976: iconst_0
    //   977: istore 14
    //   979: goto -833 -> 146
    //   982: iconst_0
    //   983: istore 15
    //   985: goto -822 -> 163
    //   988: fconst_0
    //   989: fstore_2
    //   990: goto -648 -> 342
    //   993: iconst_0
    //   994: istore 16
    //   996: goto -293 -> 703
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	999	0	this	GameCenterAPIJavaScript
    //   0	999	1	paramJSONObject	JSONObject
    //   326	664	2	f1	float
    //   343	91	3	f2	float
    //   64	595	4	i	int
    //   73	579	5	j	int
    //   127	683	6	k	int
    //   179	516	7	m	int
    //   188	642	8	n	int
    //   82	849	9	i1	int
    //   91	313	10	i2	int
    //   197	310	11	i3	int
    //   282	139	12	i4	int
    //   292	85	13	i5	int
    //   141	837	14	bool1	boolean
    //   158	826	15	bool2	boolean
    //   302	693	16	bool3	boolean
    //   100	863	17	localObject1	Object
    //   109	728	18	str1	String
    //   252	628	19	str2	String
    //   262	652	20	str3	String
    //   272	625	21	str4	String
    //   118	725	22	localObject2	Object
    //   170	543	23	str5	String
    //   206	514	24	str6	String
    //   215	519	25	str7	String
    //   224	503	26	str8	String
    //   233	508	27	str9	String
    //   242	506	28	str10	String
    //   525	258	29	localObject3	Object
    //   412	186	30	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   57	140	933	java/lang/Exception
    //   146	157	933	java/lang/Exception
    //   163	314	933	java/lang/Exception
    //   319	327	933	java/lang/Exception
    //   333	339	933	java/lang/Exception
    //   350	354	933	java/lang/Exception
    //   354	461	933	java/lang/Exception
    //   466	491	933	java/lang/Exception
    //   491	691	933	java/lang/Exception
    //   703	806	933	java/lang/Exception
    //   812	818	933	java/lang/Exception
    //   821	827	933	java/lang/Exception
    //   827	848	933	java/lang/Exception
    //   853	857	933	java/lang/Exception
    //   862	867	933	java/lang/Exception
    //   867	879	933	java/lang/Exception
    //   884	896	933	java/lang/Exception
    //   901	913	933	java/lang/Exception
    //   918	930	933	java/lang/Exception
    //   314	319	972	java/lang/Exception
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
        localObject = (View)paramJSONObject.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(j));
        paramJSONObject.jdField_a_of_type_AndroidWidgetFrameLayout.removeView((View)localObject);
        paramJSONObject.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(j));
        return 0;
      }
      QLog.e("GCApi", 1, "[setText] Err: not find videoPlayer");
      return -1;
    }
    catch (Exception paramJSONObject)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setText Err:");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.d("GCApi", 1, ((StringBuilder)localObject).toString());
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
        localObject = (View)paramJSONObject.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(j));
        paramJSONObject.jdField_a_of_type_AndroidWidgetFrameLayout.removeView((View)localObject);
        paramJSONObject.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(j));
        return 0;
      }
      QLog.e("GCApi", 1, "[setText] Err: not find videoPlayer");
      return -1;
    }
    catch (Exception paramJSONObject)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setText Err:");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.d("GCApi", 1, ((StringBuilder)localObject).toString());
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
      return 0;
    }
    catch (Exception paramJSONObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[destoryVideo] Err:");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.d("GCApi", 1, localStringBuilder.toString());
    }
    return -1;
  }
  
  public String getOpenidBatch(String paramString)
  {
    Context localContext = this.mContext;
    if ((localContext instanceof GameCenterActivity)) {
      return GameCenterActivity.httpRequest(localContext, "https://cgi.connect.qq.com/api/get_openids_by_appids", paramString, this.uin);
    }
    return "";
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getProgress Err:");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.d("GCApi", 1, localStringBuilder.toString());
    }
    return -1L;
  }
  
  public String getReportPublicData()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    try
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("");
      localStringBuilder2.append(MobileInfoUtil.getImei());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append("|");
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("");
      localStringBuilder2.append(MobileInfoUtil.getLocalMacAddress());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append("|");
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("");
      localStringBuilder2.append(GCCommon.a(this.mContext.getApplicationContext()));
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append("|");
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("");
      localStringBuilder2.append(Build.MODEL);
      localStringBuilder1.append(localStringBuilder2.toString());
      return localStringBuilder1.toString();
    }
    catch (Exception localException) {}
    return "";
  }
  
  public String getReportPublicHighData()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    try
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("");
      localStringBuilder2.append(GCCommon.b());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append("|");
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("");
      localStringBuilder2.append(APNUtil.a(this.mContext.getApplicationContext()));
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append("|");
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("");
      localStringBuilder2.append(Build.VERSION.RELEASE);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append("|");
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("");
      localStringBuilder2.append(CommonDataAdapter.a().d());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append("|");
      localStringBuilder1.append(AppSetting.a());
      localStringBuilder1.append("|");
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(this.dm.widthPixels);
      localStringBuilder2.append(" * ");
      localStringBuilder2.append(this.dm.heightPixels);
      localStringBuilder1.append(localStringBuilder2.toString());
      return localStringBuilder1.toString();
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getProgress Err:");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.d("GCApi", 1, localStringBuilder.toString());
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
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool)
    {
      paramString1 = new StringBuilder();
      paramString1.append("[handleJsRequest] method:");
      paramString1.append(paramString3);
      paramString1.append("params:");
      paramString1.append(paramVarArgs[0]);
      QLog.d("GCApi", 2, paramString1.toString());
    }
    if ("GCApi".equals(paramString2))
    {
      paramString1 = null;
      if (METHOD_GET_SESSION_INFO.equals(paramString3)) {
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramString3 = paramString2.optString("callback");
          this.mReqBundle.clear();
          this.mReqBundle.putInt("dataType", paramString2.optInt("dataType", 0));
          super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_get_session_info", paramString3, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
      } else if (METHOD_GET_REQUEST_INFO.equals(paramString3)) {
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramString3 = paramString2.optString("callback");
          this.mReqBundle.clear();
          this.mReqBundle.putString("gameId", paramString2.optString("gameId", ""));
          super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_get_request_info", paramString3, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
      } else if (METHOD_OPEN_AIO.equals(paramString3)) {
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramString3 = paramString2.optString("callback");
          this.mReqBundle.clear();
          this.mReqBundle.putString("sessionId", paramString2.optString("sessionId", ""));
          super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_open_aio", paramString3, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
      } else if (METHOD_GET_UNREAD_TOTAL.equals(paramString3)) {
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]).optString("callback");
          this.mReqBundle.clear();
          super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_get_unread_total", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
      } else if (METHOD_TOGGLE_CHANGE.equals(paramString3)) {
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramString3 = paramString2.optString("callback");
          this.mReqBundle.clear();
          this.mReqBundle.putString("gameId", paramString2.optString("gameId", ""));
          this.mReqBundle.putInt("switchType", paramString2.optInt("switchType", -1));
          this.mReqBundle.putInt("value", paramString2.optInt("value", -1));
          super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_toggle_changed", paramString3, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
      } else if (!"createVideo".equals(paramString3)) {}
    }
    for (;;)
    {
      int j;
      try
      {
        paramString3 = new JSONObject(paramVarArgs[0]);
        paramString2 = paramString3.optString("callback");
        j = createVideo(paramString3);
        if (j <= 0) {
          break label3198;
        }
        paramString3 = new JSONObject();
        paramString3.put("ret", i);
        paramString3.put("id", j);
        paramVarArgs = new StringBuilder();
        paramVarArgs.append(paramString2);
        paramVarArgs.append("(");
        paramVarArgs.append(paramString3.toString());
        paramVarArgs.append(");");
        super.callJs(paramVarArgs.toString());
      }
      catch (JSONException paramString2)
      {
        paramString2.printStackTrace();
      }
      if ("destoryVideo".equals(paramString3)) {
        try
        {
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramString2 = paramString3.optString("callback");
          i = destoryVideo(paramString3);
          paramString3 = new JSONObject();
          paramString3.put("ret", i);
          paramVarArgs = new StringBuilder();
          paramVarArgs.append(paramString2);
          paramVarArgs.append("(");
          paramVarArgs.append(paramString3.toString());
          paramVarArgs.append(");");
          super.callJs(paramVarArgs.toString());
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
      } else if ("playVideo".equals(paramString3)) {
        try
        {
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramString2 = paramString3.optString("callback");
          i = playVideo(paramString3);
          paramString3 = new JSONObject();
          paramString3.put("ret", i);
          paramVarArgs = new StringBuilder();
          paramVarArgs.append(paramString2);
          paramVarArgs.append("(");
          paramVarArgs.append(paramString3.toString());
          paramVarArgs.append(");");
          super.callJs(paramVarArgs.toString());
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
      } else if ("pauseVideo".equals(paramString3)) {
        try
        {
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramString2 = paramString3.optString("callback");
          i = pauseVideo(paramString3);
          paramString3 = new JSONObject();
          paramString3.put("ret", i);
          paramVarArgs = new StringBuilder();
          paramVarArgs.append(paramString2);
          paramVarArgs.append("(");
          paramVarArgs.append(paramString3.toString());
          paramVarArgs.append(");");
          super.callJs(paramVarArgs.toString());
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
      } else if ("stopVideo".equals(paramString3)) {
        try
        {
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramString2 = paramString3.optString("callback");
          i = stopVideo(paramString3);
          paramString3 = new JSONObject();
          paramString3.put("ret", i);
          paramVarArgs = new StringBuilder();
          paramVarArgs.append(paramString2);
          paramVarArgs.append("(");
          paramVarArgs.append(paramString3.toString());
          paramVarArgs.append(");");
          super.callJs(paramVarArgs.toString());
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
      } else if ("setPosition".equals(paramString3)) {
        try
        {
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramString2 = paramString3.optString("callback");
          i = setPosition(paramString3);
          paramString3 = new JSONObject();
          paramString3.put("ret", i);
          paramVarArgs = new StringBuilder();
          paramVarArgs.append(paramString2);
          paramVarArgs.append("(");
          paramVarArgs.append(paramString3.toString());
          paramVarArgs.append(");");
          super.callJs(paramVarArgs.toString());
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
      } else if ("setFlag".equals(paramString3)) {
        try
        {
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramString2 = paramString3.optString("callback");
          i = setFlag(paramString3);
          paramString3 = new JSONObject();
          paramString3.put("ret", 0);
          paramString3.put("pid", i);
          paramVarArgs = new StringBuilder();
          paramVarArgs.append(paramString2);
          paramVarArgs.append("(");
          paramVarArgs.append(paramString3.toString());
          paramVarArgs.append(");");
          super.callJs(paramVarArgs.toString());
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
      } else if ("delFlag".equals(paramString3)) {
        try
        {
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramString2 = paramString3.optString("callback");
          i = delFlag(paramString3);
          paramString3 = new JSONObject();
          paramString3.put("ret", i);
          paramVarArgs = new StringBuilder();
          paramVarArgs.append(paramString2);
          paramVarArgs.append("(");
          paramVarArgs.append(paramString3.toString());
          paramVarArgs.append(");");
          super.callJs(paramVarArgs.toString());
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
      } else if ("setText".equals(paramString3)) {
        try
        {
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramString2 = paramString3.optString("callback");
          i = setText(paramString3);
          paramString3 = new JSONObject();
          paramString3.put("ret", 0);
          paramString3.put("pid", i);
          paramVarArgs = new StringBuilder();
          paramVarArgs.append(paramString2);
          paramVarArgs.append("(");
          paramVarArgs.append(paramString3.toString());
          paramVarArgs.append(");");
          super.callJs(paramVarArgs.toString());
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
      } else if ("delText".equals(paramString3)) {
        try
        {
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramString2 = paramString3.optString("callback");
          i = delText(paramString3);
          paramString3 = new JSONObject();
          paramString3.put("ret", i);
          paramVarArgs = new StringBuilder();
          paramVarArgs.append(paramString2);
          paramVarArgs.append("(");
          paramVarArgs.append(paramString3.toString());
          paramVarArgs.append(");");
          super.callJs(paramVarArgs.toString());
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
      } else if ("setFullScreen".equals(paramString3)) {
        try
        {
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramString2 = paramString3.optString("callback");
          i = setFullScreen(paramString3);
          paramString3 = new JSONObject();
          paramString3.put("ret", i);
          paramVarArgs = new StringBuilder();
          paramVarArgs.append(paramString2);
          paramVarArgs.append("(");
          paramVarArgs.append(paramString3.toString());
          paramVarArgs.append(");");
          super.callJs(paramVarArgs.toString());
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
      } else if ("setMute".equals(paramString3)) {
        try
        {
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramString2 = paramString3.optString("callback");
          i = setMute(paramString3);
          paramString3 = new JSONObject();
          paramString3.put("ret", i);
          paramVarArgs = new StringBuilder();
          paramVarArgs.append(paramString2);
          paramVarArgs.append("(");
          paramVarArgs.append(paramString3.toString());
          paramVarArgs.append(");");
          super.callJs(paramVarArgs.toString());
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
      } else if ("getProgress".equals(paramString3)) {
        try
        {
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramString2 = paramString3.optString("callback");
          long l1 = getProgress(paramString3);
          long l2 = getTotalDuration(paramString3);
          paramString3 = new JSONObject();
          paramString3.put("ret", 0);
          paramString3.put("current", l1);
          paramString3.put("total", l2);
          paramVarArgs = new StringBuilder();
          paramVarArgs.append(paramString2);
          paramVarArgs.append("(");
          paramVarArgs.append(paramString3.toString());
          paramVarArgs.append(");");
          super.callJs(paramVarArgs.toString());
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
      } else if ("setDanmuViewProperty".equals(paramString3)) {
        try
        {
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramString2 = paramString3.optString("callback");
          i = setDanmuViewProperty(paramString3);
          paramString3 = new JSONObject();
          paramString3.put("ret", i);
          paramVarArgs = new StringBuilder();
          paramVarArgs.append(paramString2);
          paramVarArgs.append("(");
          paramVarArgs.append(paramString3.toString());
          paramVarArgs.append(");");
          super.callJs(paramVarArgs.toString());
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
      } else if ("setDanmuData".equals(paramString3)) {
        try
        {
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramString2 = paramString3.optString("callback");
          i = setDanmuData(paramString3);
          paramString3 = new JSONObject();
          paramString3.put("ret", i);
          paramVarArgs = new StringBuilder();
          paramVarArgs.append(paramString2);
          paramVarArgs.append("(");
          paramVarArgs.append(paramString3.toString());
          paramVarArgs.append(");");
          super.callJs(paramVarArgs.toString());
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
      } else if ("clearDanmu".equals(paramString3)) {
        try
        {
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramString2 = paramString3.optString("callback");
          i = clearDanmu(paramString3);
          paramString3 = new JSONObject();
          paramString3.put("ret", i);
          paramVarArgs = new StringBuilder();
          paramVarArgs.append(paramString2);
          paramVarArgs.append("(");
          paramVarArgs.append(paramString3.toString());
          paramVarArgs.append(");");
          super.callJs(paramVarArgs.toString());
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
      } else if (("getOpenidBatch".equals(paramString3)) && (paramVarArgs.length == 1)) {
        paramString1 = getOpenidBatch(paramVarArgs[0]);
      } else if (("showWarningToast".equals(paramString3)) && (paramVarArgs.length == 1)) {
        showWarningToast(paramVarArgs[0]);
      } else if ("getUin".equals(paramString3)) {
        paramString1 = this.uin;
      } else if (("setTitleLoading".equals(paramString3)) && (paramVarArgs.length == 1)) {
        setTitleLoading(paramVarArgs[0]);
      } else if ("getReportPublicData".equals(paramString3)) {
        paramString1 = getReportPublicData();
      } else if ("getReportPublicHighData".equals(paramString3)) {
        paramString1 = getReportPublicHighData();
      } else if (("reportAction".equals(paramString3)) && (paramVarArgs.length == 3)) {
        reportAction(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
      } else if ("getVersionName".equals(paramString3)) {
        paramString1 = getVersionName();
      } else if (("startToAuthorized".equals(paramString3)) && (paramVarArgs.length == 1)) {
        startToAuthorized(paramVarArgs[0]);
      } else if (METHOD_OPEN_QQPLAYER_AIO.equals(paramString3)) {
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramString3 = paramString2.optString("callback");
          this.mReqBundle.clear();
          this.mReqBundle.putString("fromRoleId", paramString2.optString("fromRoleId", ""));
          this.mReqBundle.putString("fromOpenId", paramString2.optString("fromOpenId", ""));
          this.mReqBundle.putString("toRoleId", paramString2.optString("toRoleId", ""));
          this.mReqBundle.putString("toOpenId", paramString2.optString("toOpenId", ""));
          this.mReqBundle.putString("fromTinyId", paramString2.optString("fromTinyId", ""));
          this.mReqBundle.putString("toTinyId", paramString2.optString("toTinyId", ""));
          this.mReqBundle.putLong("gameAppId", paramString2.optLong("gameAppId", 0L));
          this.mReqBundle.putInt("windowFlag", paramString2.optInt("windowFlag", 0));
          this.mReqBundle.putString("topGrayText", paramString2.optString("topGrayText", ""));
          this.mReqBundle.putString("sig", paramString2.optString("sig", ""));
          this.mReqBundle.putInt("fromPage", paramString2.optInt("fromPage"));
          super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_open_qqplayer_aio", paramString3, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
      } else {
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramVarArgs = paramString2.optString("callback");
          handleScreenShotMethod(paramString3, paramString2.optJSONObject("data"), paramVarArgs);
        }
        catch (JSONException paramString2)
        {
          paramString3 = new StringBuilder();
          paramString3.append("handleScreenShotMethod e=");
          paramString3.append(paramString2.toString());
          QLog.e("GCApi", 1, paramString3.toString());
        }
      }
      if ((paramJsBridgeListener != null) && (paramString1 != null)) {
        paramJsBridgeListener.a(paramString1);
      }
      return true;
      return false;
      label3198:
      i = j;
    }
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
  
  protected void onCreate()
  {
    super.onCreate();
    this.mReqBundle = new Bundle();
    this.dm = new DisplayMetrics();
    this.mContext = this.mRuntime.a();
    Object localObject = this.mContext;
    if (localObject != null) {
      ((Activity)localObject).getWindowManager().getDefaultDisplay().getMetrics(this.dm);
    }
    if (this.mRuntime.a() != null) {
      this.uin = this.mRuntime.a().getCurrentAccountUin();
    }
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("action_qgame_messgae_change");
    ((IntentFilter)localObject).addAction("action_qgame_unread_change");
    BaseApplicationImpl.getApplication().registerReceiver(this.mMsgReceiver, (IntentFilter)localObject);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mMsgReceiver != null) {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.mMsgReceiver);
    }
    GameCenterVideoManager.a().a();
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    super.onResponse(paramBundle);
    if (paramBundle != null)
    {
      Object localObject2 = paramBundle.getString("cmd");
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[onResponse] cmd:");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.d("GCApi", 1, ((StringBuilder)localObject1).toString());
      }
      int i = paramBundle.getInt("respkey", 0);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[onResponse] respkey:");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append("，key:");
        ((StringBuilder)localObject1).append(this.mOnRemoteResp.key);
        QLog.d("GCApi", 1, ((StringBuilder)localObject1).toString());
      }
      if (i == this.mOnRemoteResp.key)
      {
        localObject1 = paramBundle.getString("callbackid");
        paramBundle = paramBundle.getBundle("response");
        if ((localObject2 != null) && (paramBundle != null))
        {
          Object localObject3 = this.mRuntime.a();
          if ((localObject3 != null) && (!this.isDestroy) && (!((Activity)localObject3).isFinishing())) {
            try
            {
              boolean bool = "ipc_cmd_gamecenter_get_session_info".equals(localObject2);
              if (bool)
              {
                i = paramBundle.getInt("result");
                paramBundle = paramBundle.getString("data");
                localObject2 = new JSONObject(paramBundle);
                ((JSONObject)localObject2).put("ret", i);
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append((String)localObject1);
                ((StringBuilder)localObject3).append("&&");
                ((StringBuilder)localObject3).append((String)localObject1);
                ((StringBuilder)localObject3).append("(");
                ((StringBuilder)localObject3).append(((JSONObject)localObject2).toString());
                ((StringBuilder)localObject3).append(");");
                super.callJs(((StringBuilder)localObject3).toString());
                if (!QLog.isColorLevel()) {
                  return;
                }
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("ipc_cmd_gamecenter_get_session_info onResponse dataStr is:");
                ((StringBuilder)localObject2).append(paramBundle);
                QLog.d("GCApi", 2, ((StringBuilder)localObject2).toString());
                return;
              }
              bool = "ipc_cmd_gamecenter_get_request_info".equals(localObject2);
              if (bool)
              {
                i = paramBundle.getInt("result");
                paramBundle = paramBundle.getString("data");
                localObject2 = new JSONObject(paramBundle);
                ((JSONObject)localObject2).put("ret", i);
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append((String)localObject1);
                ((StringBuilder)localObject3).append("&&");
                ((StringBuilder)localObject3).append((String)localObject1);
                ((StringBuilder)localObject3).append("(");
                ((StringBuilder)localObject3).append(((JSONObject)localObject2).toString());
                ((StringBuilder)localObject3).append(");");
                super.callJs(((StringBuilder)localObject3).toString());
                if (!QLog.isColorLevel()) {
                  return;
                }
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("ipc_cmd_gamecenter_get_request_info onResponse dataStr is:");
                ((StringBuilder)localObject2).append(paramBundle);
                QLog.d("GCApi", 2, ((StringBuilder)localObject2).toString());
                return;
              }
              if ("ipc_cmd_gamecenter_open_aio".equals(localObject2))
              {
                i = paramBundle.getInt("result", -1);
                paramBundle = new JSONObject();
                paramBundle.put("ret", i);
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append((String)localObject1);
                ((StringBuilder)localObject2).append("&&");
                ((StringBuilder)localObject2).append((String)localObject1);
                ((StringBuilder)localObject2).append("(");
                ((StringBuilder)localObject2).append(paramBundle.toString());
                ((StringBuilder)localObject2).append(");");
                super.callJs(((StringBuilder)localObject2).toString());
                return;
              }
              if ("ipc_cmd_gamecenter_get_unread_total".equals(localObject2))
              {
                i = paramBundle.getInt("result");
                localObject2 = new JSONObject();
                ((JSONObject)localObject2).put("ret", i);
                ((JSONObject)localObject2).put("newMsgCount", paramBundle.getInt("cnt"));
                paramBundle = new StringBuilder();
                paramBundle.append((String)localObject1);
                paramBundle.append("&&");
                paramBundle.append((String)localObject1);
                paramBundle.append("(");
                paramBundle.append(((JSONObject)localObject2).toString());
                paramBundle.append(");");
                super.callJs(paramBundle.toString());
                if (!QLog.isColorLevel()) {
                  return;
                }
                paramBundle = new StringBuilder();
                paramBundle.append("ipc_cmd_gamecenter_get_request_info onResponse dataStr is:");
                paramBundle.append(((JSONObject)localObject2).toString());
                QLog.d("GCApi", 2, paramBundle.toString());
                return;
              }
              if ("ipc_cmd_gamecenter_toggle_changed".equals(localObject2))
              {
                callbackOk((String)localObject1);
                return;
              }
              if (!"ipc_cmd_gamecenter_open_qqplayer_aio".equals(localObject2)) {
                return;
              }
              i = paramBundle.getInt("result", -1);
              paramBundle = new JSONObject();
              paramBundle.put("ret", i);
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append("&&");
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append("(");
              ((StringBuilder)localObject2).append(paramBundle.toString());
              ((StringBuilder)localObject2).append(");");
              super.callJs(((StringBuilder)localObject2).toString());
              return;
            }
            catch (Throwable paramBundle)
            {
              if (QLog.isColorLevel()) {
                QLog.e("GCApi", 2, paramBundle.getMessage());
              }
              callbackError((String)localObject1, "-2000");
              return;
            }
          } else {
            callbackError((String)localObject1, "-1000");
          }
        }
      }
    }
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    RefreshView localRefreshView = (RefreshView)this.mRuntime.a().findViewById(2131381085);
    this.mVideoContainer = new GameCenterAPIJavaScript.2(this, this.mRuntime.a(), paramCustomWebView);
    localRefreshView.addView(this.mVideoContainer, localLayoutParams);
    paramCustomWebView = (TouchWebView)this.mRuntime.a();
    this.mVideoContainer.scrollBy(0, paramCustomWebView.mTotalYoffset);
    this.mScrollChangedListener = new GameCenterAPIJavaScript.3(this);
    paramCustomWebView = this.mRuntime.a();
    if ((paramCustomWebView instanceof GameCenterActivity)) {
      ((GameCenterActivity)paramCustomWebView).setOnScrollChangedListener(this.mScrollChangedListener);
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
      return 0;
    }
    catch (Exception paramJSONObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pauseVideo Err:");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.d("GCApi", 1, localStringBuilder.toString());
    }
    return -1;
  }
  
  public int playVideo(JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playVideo JSONObject: ");
    localStringBuilder.append(paramJSONObject.toString());
    QLog.d("GCApi", 4, localStringBuilder.toString());
    try
    {
      int i = paramJSONObject.optInt("id");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null) {
        ((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.play();
      } else {
        QLog.e("GCApi", 1, "[playVideo] Err: not find videoPlayer");
      }
      return 0;
    }
    catch (Exception paramJSONObject)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("playVideo Err:");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.d("GCApi", 1, localStringBuilder.toString());
    }
    return -1;
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
          localObject = ((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
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
            ((GameCenterVideoViewController)localObject).getDanmakuLayout().a(arrayOfItem);
            return 0;
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
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setDanmuData Err:");
        ((StringBuilder)localObject).append(paramJSONObject.toString());
        QLog.d("GCApi", 1, ((StringBuilder)localObject).toString());
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
        localObject = ((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
        i = paramJSONObject.optInt("topDist");
        int j = paramJSONObject.optInt("bottomDist");
        if (!paramJSONObject.has("topDist")) {
          i = ((GameCenterVideoViewController)localObject).getDanmakuLayout().getPaddingTop();
        }
        if (!paramJSONObject.has("bottomDist")) {
          j = ((GameCenterVideoViewController)localObject).getDanmakuLayout().getPaddingBottom();
        }
        ((GameCenterVideoViewController)localObject).getDanmakuLayout().setPadding(0, i, 0, j);
        if (paramJSONObject.has("lineSpacing")) {
          ((GameCenterVideoViewController)localObject).getDanmakuLayout().setLineSpacing(paramJSONObject.optInt("lineSpacing"));
        }
        if (paramJSONObject.has("fontSize"))
        {
          ((GameCenterVideoViewController)localObject).getDanmakuLayout().setTextSize(paramJSONObject.optInt("fontSize"));
          return 0;
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setDanmuViewProperty Err:");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.d("GCApi", 1, ((StringBuilder)localObject).toString());
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
        localObject = ((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_AndroidWidgetFrameLayout;
        URLImageView localURLImageView = new URLImageView(this.mContext);
        float f = this.mRuntime.a().getResources().getDisplayMetrics().density;
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)(m * f), (int)(n * f));
        localLayoutParams.topMargin = ((int)(j * f));
        localLayoutParams.leftMargin = ((int)(k * f));
        ((FrameLayout)localObject).addView(localURLImageView, localLayoutParams);
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setFlag Err:");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.d("GCApi", 1, ((StringBuilder)localObject).toString());
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
      else
      {
        QLog.e("GCApi", 1, "[setFullScreen] Err: not find videoPlayer");
        return -1;
      }
    }
    catch (Exception paramJSONObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFullScreen Err:");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.d("GCApi", 1, localStringBuilder.toString());
      return -1;
    }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMute Err:");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.d("GCApi", 1, localStringBuilder.toString());
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
        localObject = (FrameLayout.LayoutParams)paramJSONObject.getLayoutParams();
        float f = this.mRuntime.a().getResources().getDisplayMetrics().density;
        ((FrameLayout.LayoutParams)localObject).topMargin = ((int)((j - m) * f));
        ((FrameLayout.LayoutParams)localObject).leftMargin = ((int)(f * (k - n)));
        paramJSONObject.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return 0;
      }
      QLog.e("GCApi", 1, "[setPostion] Err: not find videoPlayer");
      return 0;
    }
    catch (Exception paramJSONObject)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setPostion Err:");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.d("GCApi", 1, ((StringBuilder)localObject).toString());
    }
    return -1;
  }
  
  public int setText(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      int j = paramJSONObject.optInt("y");
      int k = paramJSONObject.optInt("x");
      int m = paramJSONObject.optInt("fontsize", 10);
      localObject = paramJSONObject.optString("color");
      String str = paramJSONObject.optString("txt");
      boolean bool = paramJSONObject.optBoolean("border", false);
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        paramJSONObject = ((GameCenterAPIJavaScript.VideoViewInfo)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_AndroidWidgetFrameLayout;
        TextView localTextView = new TextView(this.mContext);
        if (bool) {
          localTextView.setBackgroundResource(2130840174);
        }
        float f = this.mRuntime.a().getResources().getDisplayMetrics().density;
        localTextView.setPadding(AIOUtils.b(3.0F, this.mContext.getResources()), AIOUtils.b(3.0F, this.mContext.getResources()), AIOUtils.b(3.0F, this.mContext.getResources()), AIOUtils.b(3.0F, this.mContext.getResources()));
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setText Err:");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.d("GCApi", 1, ((StringBuilder)localObject).toString());
    }
    return -1;
  }
  
  public void setTitleLoading(String paramString)
  {
    if ((this.mContext instanceof GameCenterActivity)) {
      try
      {
        int i;
        if ("true".equals(paramString))
        {
          i = 1;
        }
        else
        {
          if (!"false".equals(paramString)) {
            break label77;
          }
          i = 0;
        }
        if (i != 0)
        {
          ((GameCenterActivity)this.mContext).gcHandler.sendEmptyMessage(2003);
          return;
        }
        ((GameCenterActivity)this.mContext).gcHandler.sendEmptyMessage(2004);
        return;
        label77:
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
    Object localObject = this.mContext;
    if ((localObject instanceof GameCenterActivity)) {
      try
      {
        localObject = Message.obtain(((GameCenterActivity)localObject).gcHandler);
        ((Message)localObject).what = 2006;
        ((Message)localObject).obj = paramString;
        ((GameCenterActivity)this.mContext).gcHandler.sendMessage((Message)localObject);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
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
      localJSONException.printStackTrace();
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
      return 0;
    }
    catch (Exception paramJSONObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopVideo Err:");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.d("GCApi", 1, localStringBuilder.toString());
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.GameCenterAPIJavaScript
 * JD-Core Version:    0.7.0.1
 */