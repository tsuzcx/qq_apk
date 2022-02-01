package com.tencent.gamecenter.common.util;

import abeu;
import abev;
import abew;
import abex;
import abfa;
import abfb;
import abfg;
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
import aqyp;
import aqyt;
import atxz;
import bgve;
import bhpc;
import bhzh;
import biaq;
import bicl;
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
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
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
  public static String EVENT_UPDATE_UNREAD_CNT;
  public static String METHOD_GET_REQUEST_INFO;
  public static String METHOD_GET_SESSION_INFO = "getSessionData";
  public static String METHOD_GET_UNREAD_TOTAL;
  public static String METHOD_OPEN_AIO = "clickCommonSession";
  public static String METHOD_TOGGLE_CHANGE = "setSwitch";
  public static final String OPEN_SWITCH = "openSwitch";
  public static final String QUERY_INFO = "queryInfo";
  public static final String REMOVE_MASK = "removeMask";
  public static final String SHOT_SCREEN = "shotScreen";
  public static final String TAG = "GCApi";
  private static boolean mIsInited;
  private String CALLBACK_UPDATE_SESSION = "";
  private DisplayMetrics dm;
  private Context mContext;
  private abfa mMsgReceiver = new abfa(this, null);
  public Bundle mReqBundle;
  private TouchWebView.OnScrollChangedListener mScrollChangedListener;
  private FrameLayout mVideoContainer;
  private Map<Integer, abfb> mVideoViewMap = new HashMap();
  private String uin = "";
  
  static
  {
    METHOD_GET_REQUEST_INFO = "getRequestData";
    METHOD_GET_UNREAD_TOTAL = "getNewMsgCount";
    EVENT_UPDATE_UNREAD_CNT = "gameCenter_newMsgCountChanged";
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
  
  public void callbackJS(String paramString1, int paramInt, String paramString2)
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
  
  /* Error */
  public int createVideo(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: invokestatic 255	azjl:a	()Z
    //   3: ifne +49 -> 52
    //   6: aload_0
    //   7: getfield 259	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbgve;
    //   10: ifnull +26 -> 36
    //   13: aload_0
    //   14: getfield 259	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbgve;
    //   17: invokevirtual 264	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   20: ifnull +16 -> 36
    //   23: aload_0
    //   24: getfield 259	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbgve;
    //   27: invokevirtual 264	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   30: invokevirtual 270	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   33: ifnonnull +5 -> 38
    //   36: iconst_m1
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 259	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbgve;
    //   42: invokevirtual 264	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   45: invokevirtual 270	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   48: aconst_null
    //   49: invokestatic 273	azjl:a	(Landroid/content/Context;Lcom/tencent/mobileqq/videoplatform/SDKInitListener;)V
    //   52: aload_1
    //   53: ldc_w 275
    //   56: invokevirtual 278	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   59: istore 5
    //   61: aload_1
    //   62: ldc_w 280
    //   65: invokevirtual 278	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   68: istore 6
    //   70: aload_1
    //   71: ldc_w 282
    //   74: invokevirtual 278	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   77: istore 8
    //   79: aload_1
    //   80: ldc_w 284
    //   83: invokevirtual 278	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   86: istore 9
    //   88: aload_1
    //   89: ldc_w 286
    //   92: invokevirtual 290	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   95: astore 14
    //   97: aload_1
    //   98: ldc_w 292
    //   101: invokevirtual 290	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore 15
    //   106: aload_1
    //   107: ldc_w 294
    //   110: invokevirtual 290	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   113: astore 16
    //   115: aload_1
    //   116: ldc_w 296
    //   119: invokevirtual 278	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   122: istore 7
    //   124: aload_1
    //   125: ldc_w 298
    //   128: invokevirtual 278	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   131: iconst_1
    //   132: if_icmpne +623 -> 755
    //   135: iconst_1
    //   136: istore 4
    //   138: aload_1
    //   139: ldc_w 300
    //   142: invokevirtual 278	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   145: iconst_1
    //   146: if_icmpne +615 -> 761
    //   149: iconst_1
    //   150: istore 12
    //   152: aload_1
    //   153: ldc_w 302
    //   156: invokevirtual 290	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   159: astore 17
    //   161: aload_1
    //   162: ldc_w 304
    //   165: invokevirtual 290	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   168: astore 18
    //   170: aload_1
    //   171: ldc_w 306
    //   174: invokevirtual 290	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   177: astore 19
    //   179: aload_1
    //   180: ldc_w 308
    //   183: invokevirtual 290	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   186: astore 20
    //   188: aload_1
    //   189: ldc_w 310
    //   192: invokevirtual 290	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   195: astore 21
    //   197: aload_1
    //   198: ldc_w 312
    //   201: invokevirtual 290	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   204: astore 22
    //   206: aload_1
    //   207: ldc_w 314
    //   210: iconst_0
    //   211: invokevirtual 317	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   214: istore 10
    //   216: aload_1
    //   217: ldc_w 319
    //   220: iconst_0
    //   221: invokevirtual 317	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   224: istore 11
    //   226: aload_1
    //   227: ldc_w 321
    //   230: iconst_0
    //   231: invokevirtual 325	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   234: istore 13
    //   236: aload_1
    //   237: ldc_w 327
    //   240: ldc 91
    //   242: invokevirtual 330	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   245: astore_1
    //   246: aload_1
    //   247: invokestatic 336	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   250: pop
    //   251: invokestatic 342	com/tencent/mobileqq/app/FontSettingManager:getFontLevel	()F
    //   254: ldc_w 343
    //   257: fdiv
    //   258: fstore_3
    //   259: fconst_0
    //   260: fstore_2
    //   261: fload_3
    //   262: fconst_0
    //   263: fcmpl
    //   264: ifeq +9 -> 273
    //   267: invokestatic 348	com/tencent/mobileqq/utils/DeviceInfoUtil:getDesity	()F
    //   270: fload_3
    //   271: fdiv
    //   272: fstore_2
    //   273: fload_2
    //   274: fconst_0
    //   275: fcmpl
    //   276: ifne +504 -> 780
    //   279: invokestatic 348	com/tencent/mobileqq/utils/DeviceInfoUtil:getDesity	()F
    //   282: fstore_2
    //   283: aload_0
    //   284: getfield 114	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoContainer	Landroid/widget/FrameLayout;
    //   287: invokevirtual 354	android/widget/FrameLayout:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   290: checkcast 356	android/widget/RelativeLayout$LayoutParams
    //   293: astore_1
    //   294: aload_1
    //   295: iload 10
    //   297: i2f
    //   298: fload_2
    //   299: fmul
    //   300: f2i
    //   301: putfield 360	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   304: aload_1
    //   305: iload 11
    //   307: i2f
    //   308: fload_2
    //   309: fmul
    //   310: f2i
    //   311: putfield 363	android/widget/RelativeLayout$LayoutParams:bottomMargin	I
    //   314: aload_0
    //   315: getfield 114	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoContainer	Landroid/widget/FrameLayout;
    //   318: aload_1
    //   319: invokevirtual 367	android/widget/FrameLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   322: new 369	android/widget/FrameLayout$LayoutParams
    //   325: dup
    //   326: iload 8
    //   328: i2f
    //   329: fload_2
    //   330: fmul
    //   331: f2i
    //   332: iload 9
    //   334: i2f
    //   335: fload_2
    //   336: fmul
    //   337: f2i
    //   338: invokespecial 372	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   341: astore 23
    //   343: aload 23
    //   345: iload 5
    //   347: iload 10
    //   349: isub
    //   350: i2f
    //   351: fload_2
    //   352: fmul
    //   353: f2i
    //   354: putfield 373	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   357: aload 23
    //   359: fload_2
    //   360: iload 6
    //   362: i2f
    //   363: fmul
    //   364: f2i
    //   365: putfield 376	android/widget/FrameLayout$LayoutParams:leftMargin	I
    //   368: new 378	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController
    //   371: dup
    //   372: aload_0
    //   373: getfield 259	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbgve;
    //   376: invokevirtual 381	bgve:a	()Landroid/app/Activity;
    //   379: invokespecial 384	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:<init>	(Landroid/content/Context;)V
    //   382: astore_1
    //   383: aload_1
    //   384: ldc_w 385
    //   387: invokevirtual 389	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setBackgroundColor	(I)V
    //   390: iload 13
    //   392: ifeq +28 -> 420
    //   395: getstatic 394	android/os/Build$VERSION:SDK_INT	I
    //   398: bipush 21
    //   400: if_icmplt +20 -> 420
    //   403: aload_1
    //   404: new 396	abey
    //   407: dup
    //   408: aload_0
    //   409: invokespecial 399	abey:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   412: invokevirtual 403	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setOutlineProvider	(Landroid/view/ViewOutlineProvider;)V
    //   415: aload_1
    //   416: iconst_1
    //   417: invokevirtual 407	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setClipToOutline	(Z)V
    //   420: aload_1
    //   421: invokevirtual 410	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:enableFullScreenSwitch	()V
    //   424: aload_1
    //   425: invokevirtual 413	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:enableVolumeSwitch	()V
    //   428: new 350	android/widget/FrameLayout
    //   431: dup
    //   432: aload_0
    //   433: getfield 259	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbgve;
    //   436: invokevirtual 381	bgve:a	()Landroid/app/Activity;
    //   439: invokespecial 414	android/widget/FrameLayout:<init>	(Landroid/content/Context;)V
    //   442: astore 24
    //   444: aload_1
    //   445: aload 24
    //   447: new 369	android/widget/FrameLayout$LayoutParams
    //   450: dup
    //   451: iconst_m1
    //   452: iconst_m1
    //   453: invokespecial 372	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   456: invokevirtual 418	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   459: aload_0
    //   460: getfield 114	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoContainer	Landroid/widget/FrameLayout;
    //   463: aload_1
    //   464: aload 23
    //   466: invokevirtual 419	android/widget/FrameLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   469: aload_0
    //   470: getfield 259	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbgve;
    //   473: invokevirtual 422	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   476: checkcast 424	com/tencent/biz/ui/TouchWebView
    //   479: checkcast 424	com/tencent/biz/ui/TouchWebView
    //   482: aload_0
    //   483: getfield 426	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mScrollChangedListener	Lcom/tencent/biz/ui/TouchWebView$OnScrollChangedListener;
    //   486: invokevirtual 430	com/tencent/biz/ui/TouchWebView:setOnScrollChangedListener	(Lcom/tencent/biz/ui/TouchWebView$OnScrollChangedListener;)V
    //   489: new 155	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   496: aload 14
    //   498: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: aload 15
    //   503: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokevirtual 436	java/lang/String:hashCode	()I
    //   512: invokestatic 442	java/lang/Math:abs	(I)I
    //   515: istore 8
    //   517: aload_1
    //   518: iload 8
    //   520: invokevirtual 445	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setVideoId	(I)V
    //   523: new 447	abfb
    //   526: dup
    //   527: aload_1
    //   528: aload 24
    //   530: new 95	java/util/HashMap
    //   533: dup
    //   534: invokespecial 96	java/util/HashMap:<init>	()V
    //   537: invokespecial 450	abfb:<init>	(Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController;Landroid/widget/FrameLayout;Ljava/util/Map;)V
    //   540: astore 23
    //   542: aload 23
    //   544: aload 14
    //   546: putfield 452	abfb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   549: aload 23
    //   551: iload 12
    //   553: putfield 455	abfb:jdField_b_of_type_Boolean	Z
    //   556: aload 23
    //   558: iload 6
    //   560: putfield 458	abfb:jdField_c_of_type_Int	I
    //   563: aload 23
    //   565: iload 5
    //   567: putfield 460	abfb:jdField_b_of_type_Int	I
    //   570: aload 23
    //   572: iload 8
    //   574: putfield 462	abfb:jdField_a_of_type_Int	I
    //   577: aload 23
    //   579: iload 7
    //   581: putfield 464	abfb:jdField_d_of_type_Int	I
    //   584: aload 23
    //   586: aload 16
    //   588: putfield 466	abfb:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   591: aload 23
    //   593: aload 17
    //   595: putfield 468	abfb:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   598: aload 23
    //   600: aload 18
    //   602: putfield 470	abfb:e	Ljava/lang/String;
    //   605: aload 23
    //   607: aload 20
    //   609: putfield 473	abfb:g	Ljava/lang/String;
    //   612: aload 23
    //   614: aload 19
    //   616: putfield 476	abfb:f	Ljava/lang/String;
    //   619: aload 23
    //   621: aload 21
    //   623: putfield 479	abfb:h	Ljava/lang/String;
    //   626: aload 23
    //   628: aload 22
    //   630: putfield 482	abfb:i	Ljava/lang/String;
    //   633: aload_0
    //   634: getfield 98	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoViewMap	Ljava/util/Map;
    //   637: iload 8
    //   639: invokestatic 488	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   642: aload 23
    //   644: invokeinterface 493 3 0
    //   649: pop
    //   650: new 495	com/tencent/mobileqq/gamecenter/data/FeedsItemData
    //   653: dup
    //   654: invokespecial 496	com/tencent/mobileqq/gamecenter/data/FeedsItemData:<init>	()V
    //   657: astore 16
    //   659: aload 16
    //   661: aload 14
    //   663: putfield 499	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoVid	Ljava/lang/String;
    //   666: iload 7
    //   668: iconst_1
    //   669: if_icmpne +98 -> 767
    //   672: aload 16
    //   674: iconst_2
    //   675: putfield 502	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
    //   678: aload 16
    //   680: aload 15
    //   682: putfield 505	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoUrl	Ljava/lang/String;
    //   685: aload_1
    //   686: aload 16
    //   688: iconst_1
    //   689: invokevirtual 509	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setData	(Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;I)V
    //   692: iload 12
    //   694: ifeq +7 -> 701
    //   697: aload_1
    //   698: invokevirtual 511	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:autoPlay	()V
    //   701: iload 4
    //   703: ifeq +8 -> 711
    //   706: aload_1
    //   707: iconst_1
    //   708: invokevirtual 514	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setMute	(Z)V
    //   711: aload_1
    //   712: new 516	abez
    //   715: dup
    //   716: aload_0
    //   717: invokespecial 517	abez:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   720: invokevirtual 521	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setVideoStatusChangerListener	(Latya;)V
    //   723: iload 8
    //   725: ireturn
    //   726: astore_1
    //   727: ldc 36
    //   729: iconst_1
    //   730: new 155	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   737: ldc_w 523
    //   740: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: aload_1
    //   744: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   747: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   750: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   753: iconst_m1
    //   754: ireturn
    //   755: iconst_0
    //   756: istore 4
    //   758: goto -620 -> 138
    //   761: iconst_0
    //   762: istore 12
    //   764: goto -612 -> 152
    //   767: aload 16
    //   769: iconst_1
    //   770: putfield 502	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
    //   773: goto -95 -> 678
    //   776: astore_1
    //   777: goto -526 -> 251
    //   780: goto -497 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	783	0	this	GameCenterAPIJavaScript
    //   0	783	1	paramJSONObject	JSONObject
    //   260	100	2	f1	float
    //   258	13	3	f2	float
    //   136	621	4	i	int
    //   59	507	5	j	int
    //   68	491	6	k	int
    //   122	548	7	m	int
    //   77	647	8	n	int
    //   86	247	9	i1	int
    //   214	136	10	i2	int
    //   224	82	11	i3	int
    //   150	613	12	bool1	boolean
    //   234	157	13	bool2	boolean
    //   95	567	14	str1	String
    //   104	577	15	str2	String
    //   113	655	16	localObject1	Object
    //   159	435	17	str3	String
    //   168	433	18	str4	String
    //   177	438	19	str5	String
    //   186	422	20	str6	String
    //   195	427	21	str7	String
    //   204	425	22	str8	String
    //   341	302	23	localObject2	Object
    //   442	87	24	localFrameLayout	FrameLayout
    // Exception table:
    //   from	to	target	type
    //   52	135	726	java/lang/Exception
    //   138	149	726	java/lang/Exception
    //   152	246	726	java/lang/Exception
    //   251	259	726	java/lang/Exception
    //   267	273	726	java/lang/Exception
    //   279	283	726	java/lang/Exception
    //   283	390	726	java/lang/Exception
    //   395	420	726	java/lang/Exception
    //   420	666	726	java/lang/Exception
    //   672	678	726	java/lang/Exception
    //   678	692	726	java/lang/Exception
    //   697	701	726	java/lang/Exception
    //   706	711	726	java/lang/Exception
    //   711	723	726	java/lang/Exception
    //   767	773	726	java/lang/Exception
    //   246	251	776	java/lang/Exception
  }
  
  public int delFlag(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      int j = paramJSONObject.optInt("pid");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        paramJSONObject = (abfb)this.mVideoViewMap.get(Integer.valueOf(i));
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
        paramJSONObject = (abfb)this.mVideoViewMap.get(Integer.valueOf(i));
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
        paramJSONObject = ((abfb)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
        paramJSONObject.stop();
        paramJSONObject.release();
        this.mVideoContainer.removeView(paramJSONObject);
        this.mVideoContainer.removeView(((abfb)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_AndroidWidgetFrameLayout);
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
        return ((abfb)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.getCurrentPostion();
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
      localStringBuilder.append("" + biaq.c());
      localStringBuilder.append("|");
      localStringBuilder.append("" + biaq.a());
      localStringBuilder.append("|");
      localStringBuilder.append("" + abeu.a(this.mContext.getApplicationContext()));
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
      localStringBuilder.append("" + abeu.b());
      localStringBuilder.append("|");
      localStringBuilder.append("" + bhzh.a(this.mContext.getApplicationContext()));
      localStringBuilder.append("|");
      localStringBuilder.append("" + Build.VERSION.RELEASE);
      localStringBuilder.append("|");
      localStringBuilder.append("" + bhpc.a().d());
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
        return ((abfb)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.getDuration();
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
      String str = bhpc.a().d();
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
          super.sendRemoteReq(aqyt.a("ipc_cmd_gamecenter_get_session_info", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
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
            super.sendRemoteReq(aqyt.a("ipc_cmd_gamecenter_get_request_info", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
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
            super.sendRemoteReq(aqyt.a("ipc_cmd_gamecenter_open_aio", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
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
            super.sendRemoteReq(aqyt.a("ipc_cmd_gamecenter_get_unread_total", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
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
            super.sendRemoteReq(aqyt.a("ipc_cmd_gamecenter_toggle_changed", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
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
    paramString2 = new abev(this, paramString2);
    if ("shotScreen".equals(paramString1))
    {
      abfg.a().a(this.mRuntime.a(), paramJSONObject.optString("key"), paramString2);
      return true;
    }
    if ("removeMask".equals(paramString1))
    {
      abfg.a().a(this.mRuntime.a(), paramString2);
      return true;
    }
    if ("delImg".equals(paramString1))
    {
      abfg.a().a(paramString2);
      return true;
    }
    if ("closeSwitch".equals(paramString1))
    {
      abfg.a().b(paramString2);
      return true;
    }
    if ("openSwitch".equals(paramString1))
    {
      abfg.a().c(paramString2);
      return true;
    }
    if ("queryInfo".equals(paramString1))
    {
      abfg.a().a(paramJSONObject.optString("key"), paramString2);
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
    atxz.a().a();
  }
  
  public void onResponse(Bundle paramBundle)
  {
    super.onResponse(paramBundle);
    Object localObject;
    int i;
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
    } while (!"ipc_cmd_gamecenter_toggle_changed".equals(localObject));
    callbackOk(str);
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    RefreshView localRefreshView = (RefreshView)this.mRuntime.a().findViewById(2131381053);
    this.mVideoContainer = new abew(this, this.mRuntime.a(), paramCustomWebView);
    localRefreshView.addView(this.mVideoContainer, localLayoutParams);
    paramCustomWebView = (TouchWebView)this.mRuntime.a();
    this.mVideoContainer.scrollBy(0, paramCustomWebView.mTotalYoffset);
    this.mScrollChangedListener = new abex(this);
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
        ((abfb)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.pause();
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
        ((abfb)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.play();
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
        FrameLayout localFrameLayout = ((abfb)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_AndroidWidgetFrameLayout;
        URLImageView localURLImageView = new URLImageView(this.mContext);
        float f = this.mRuntime.a().getResources().getDisplayMetrics().density;
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)(m * f), (int)(n * f));
        localLayoutParams.topMargin = ((int)(j * f));
        localLayoutParams.leftMargin = ((int)(k * f));
        localFrameLayout.addView(localURLImageView, localLayoutParams);
        j = localURLImageView.hashCode();
        ((abfb)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(j), localURLImageView);
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
        paramJSONObject = ((abfb)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
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
        ((abfb)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.setMute(bool);
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
        paramJSONObject = ((abfb)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
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
        paramJSONObject = ((abfb)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_AndroidWidgetFrameLayout;
        TextView localTextView = new TextView(this.mContext);
        if (bool) {
          localTextView.setBackgroundResource(2130840200);
        }
        float f = this.mRuntime.a().getResources().getDisplayMetrics().density;
        localTextView.setPadding(AIOUtils.dp2px(3.0F, this.mContext.getResources()), AIOUtils.dp2px(3.0F, this.mContext.getResources()), AIOUtils.dp2px(3.0F, this.mContext.getResources()), AIOUtils.dp2px(3.0F, this.mContext.getResources()));
        localTextView.setText(str);
        localTextView.setTextSize(m);
        localTextView.setTextColor(Color.parseColor((String)localObject));
        m = localTextView.hashCode();
        localObject = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject).topMargin = ((int)(j * f));
        ((FrameLayout.LayoutParams)localObject).leftMargin = ((int)(k * f));
        paramJSONObject.addView(localTextView, (ViewGroup.LayoutParams)localObject);
        ((abfb)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(m), localTextView);
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
    bicl.a().a(paramString, null, (Activity)this.mContext);
  }
  
  public int stopVideo(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null) {
        ((abfb)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.stop();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.GameCenterAPIJavaScript
 * JD-Core Version:    0.7.0.1
 */