package com.tencent.gamecenter.common.util;

import acil;
import acim;
import acin;
import acio;
import acir;
import acis;
import aciy;
import agej;
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
import aser;
import asev;
import bdmc;
import bioy;
import bjjo;
import bjts;
import bjve;
import bjxd;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.HashMap;
import java.util.Map;
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
  private acir mMsgReceiver = new acir(this, null);
  public Bundle mReqBundle;
  private TouchWebView.OnScrollChangedListener mScrollChangedListener;
  private FrameLayout mVideoContainer;
  private Map<Integer, acis> mVideoViewMap = new HashMap();
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
    //   0: invokestatic 200	bapg:a	()Z
    //   3: ifne +49 -> 52
    //   6: aload_0
    //   7: getfield 204	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbioy;
    //   10: ifnull +26 -> 36
    //   13: aload_0
    //   14: getfield 204	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbioy;
    //   17: invokevirtual 209	bioy:a	()Lcom/tencent/common/app/AppInterface;
    //   20: ifnull +16 -> 36
    //   23: aload_0
    //   24: getfield 204	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbioy;
    //   27: invokevirtual 209	bioy:a	()Lcom/tencent/common/app/AppInterface;
    //   30: invokevirtual 215	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   33: ifnonnull +5 -> 38
    //   36: iconst_m1
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 204	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbioy;
    //   42: invokevirtual 209	bioy:a	()Lcom/tencent/common/app/AppInterface;
    //   45: invokevirtual 215	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   48: aconst_null
    //   49: invokestatic 218	bapg:a	(Landroid/app/Application;Lcom/tencent/mobileqq/videoplatform/SDKInitListener;)V
    //   52: aload_1
    //   53: ldc 220
    //   55: invokevirtual 224	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   58: istore 5
    //   60: aload_1
    //   61: ldc 226
    //   63: invokevirtual 224	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   66: istore 6
    //   68: aload_1
    //   69: ldc 228
    //   71: invokevirtual 224	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   74: istore 8
    //   76: aload_1
    //   77: ldc 230
    //   79: invokevirtual 224	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   82: istore 9
    //   84: aload_1
    //   85: ldc 232
    //   87: invokevirtual 236	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore 14
    //   92: aload_1
    //   93: ldc 238
    //   95: invokevirtual 236	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   98: astore 15
    //   100: aload_1
    //   101: ldc 240
    //   103: invokevirtual 236	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   106: astore 16
    //   108: aload_1
    //   109: ldc 242
    //   111: invokevirtual 224	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   114: istore 7
    //   116: aload_1
    //   117: ldc 244
    //   119: invokevirtual 224	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   122: iconst_1
    //   123: if_icmpne +618 -> 741
    //   126: iconst_1
    //   127: istore 4
    //   129: aload_1
    //   130: ldc 246
    //   132: invokevirtual 224	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   135: iconst_1
    //   136: if_icmpne +611 -> 747
    //   139: iconst_1
    //   140: istore 12
    //   142: aload_1
    //   143: ldc 248
    //   145: invokevirtual 236	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   148: astore 17
    //   150: aload_1
    //   151: ldc 250
    //   153: invokevirtual 236	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   156: astore 18
    //   158: aload_1
    //   159: ldc 252
    //   161: invokevirtual 236	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   164: astore 19
    //   166: aload_1
    //   167: ldc 254
    //   169: invokevirtual 236	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   172: astore 20
    //   174: aload_1
    //   175: ldc_w 256
    //   178: invokevirtual 236	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   181: astore 21
    //   183: aload_1
    //   184: ldc_w 258
    //   187: invokevirtual 236	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   190: astore 22
    //   192: aload_1
    //   193: ldc_w 260
    //   196: iconst_0
    //   197: invokevirtual 263	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   200: istore 10
    //   202: aload_1
    //   203: ldc_w 265
    //   206: iconst_0
    //   207: invokevirtual 263	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   210: istore 11
    //   212: aload_1
    //   213: ldc_w 267
    //   216: iconst_0
    //   217: invokevirtual 271	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   220: istore 13
    //   222: aload_1
    //   223: ldc_w 273
    //   226: ldc 91
    //   228: invokevirtual 276	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   231: astore_1
    //   232: aload_1
    //   233: invokestatic 282	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   236: pop
    //   237: invokestatic 287	anxh:a	()F
    //   240: ldc_w 288
    //   243: fdiv
    //   244: fstore_3
    //   245: fconst_0
    //   246: fstore_2
    //   247: fload_3
    //   248: fconst_0
    //   249: fcmpl
    //   250: ifeq +9 -> 259
    //   253: invokestatic 291	bhlo:a	()F
    //   256: fload_3
    //   257: fdiv
    //   258: fstore_2
    //   259: fload_2
    //   260: fconst_0
    //   261: fcmpl
    //   262: ifne +504 -> 766
    //   265: invokestatic 291	bhlo:a	()F
    //   268: fstore_2
    //   269: aload_0
    //   270: getfield 114	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoContainer	Landroid/widget/FrameLayout;
    //   273: invokevirtual 297	android/widget/FrameLayout:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   276: checkcast 299	android/widget/RelativeLayout$LayoutParams
    //   279: astore_1
    //   280: aload_1
    //   281: iload 10
    //   283: i2f
    //   284: fload_2
    //   285: fmul
    //   286: f2i
    //   287: putfield 303	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   290: aload_1
    //   291: iload 11
    //   293: i2f
    //   294: fload_2
    //   295: fmul
    //   296: f2i
    //   297: putfield 306	android/widget/RelativeLayout$LayoutParams:bottomMargin	I
    //   300: aload_0
    //   301: getfield 114	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoContainer	Landroid/widget/FrameLayout;
    //   304: aload_1
    //   305: invokevirtual 310	android/widget/FrameLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   308: new 312	android/widget/FrameLayout$LayoutParams
    //   311: dup
    //   312: iload 8
    //   314: i2f
    //   315: fload_2
    //   316: fmul
    //   317: f2i
    //   318: iload 9
    //   320: i2f
    //   321: fload_2
    //   322: fmul
    //   323: f2i
    //   324: invokespecial 315	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   327: astore 23
    //   329: aload 23
    //   331: iload 5
    //   333: iload 10
    //   335: isub
    //   336: i2f
    //   337: fload_2
    //   338: fmul
    //   339: f2i
    //   340: putfield 316	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   343: aload 23
    //   345: fload_2
    //   346: iload 6
    //   348: i2f
    //   349: fmul
    //   350: f2i
    //   351: putfield 319	android/widget/FrameLayout$LayoutParams:leftMargin	I
    //   354: new 321	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController
    //   357: dup
    //   358: aload_0
    //   359: getfield 204	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbioy;
    //   362: invokevirtual 324	bioy:a	()Landroid/app/Activity;
    //   365: invokespecial 327	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:<init>	(Landroid/content/Context;)V
    //   368: astore_1
    //   369: aload_1
    //   370: ldc_w 328
    //   373: invokevirtual 332	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setBackgroundColor	(I)V
    //   376: iload 13
    //   378: ifeq +28 -> 406
    //   381: getstatic 337	android/os/Build$VERSION:SDK_INT	I
    //   384: bipush 21
    //   386: if_icmplt +20 -> 406
    //   389: aload_1
    //   390: new 339	acip
    //   393: dup
    //   394: aload_0
    //   395: invokespecial 342	acip:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   398: invokevirtual 346	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setOutlineProvider	(Landroid/view/ViewOutlineProvider;)V
    //   401: aload_1
    //   402: iconst_1
    //   403: invokevirtual 350	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setClipToOutline	(Z)V
    //   406: aload_1
    //   407: invokevirtual 353	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:n	()V
    //   410: aload_1
    //   411: invokevirtual 356	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:o	()V
    //   414: new 293	android/widget/FrameLayout
    //   417: dup
    //   418: aload_0
    //   419: getfield 204	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbioy;
    //   422: invokevirtual 324	bioy:a	()Landroid/app/Activity;
    //   425: invokespecial 357	android/widget/FrameLayout:<init>	(Landroid/content/Context;)V
    //   428: astore 24
    //   430: aload_1
    //   431: aload 24
    //   433: new 312	android/widget/FrameLayout$LayoutParams
    //   436: dup
    //   437: iconst_m1
    //   438: iconst_m1
    //   439: invokespecial 315	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   442: invokevirtual 361	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   445: aload_0
    //   446: getfield 114	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoContainer	Landroid/widget/FrameLayout;
    //   449: aload_1
    //   450: aload 23
    //   452: invokevirtual 362	android/widget/FrameLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   455: aload_0
    //   456: getfield 204	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbioy;
    //   459: invokevirtual 365	bioy:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   462: checkcast 367	com/tencent/biz/ui/TouchWebView
    //   465: checkcast 367	com/tencent/biz/ui/TouchWebView
    //   468: aload_0
    //   469: getfield 369	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mScrollChangedListener	Lcom/tencent/biz/ui/TouchWebView$OnScrollChangedListener;
    //   472: invokevirtual 373	com/tencent/biz/ui/TouchWebView:setOnScrollChangedListener	(Lcom/tencent/biz/ui/TouchWebView$OnScrollChangedListener;)V
    //   475: new 147	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   482: aload 14
    //   484: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: aload 15
    //   489: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokevirtual 379	java/lang/String:hashCode	()I
    //   498: invokestatic 385	java/lang/Math:abs	(I)I
    //   501: istore 8
    //   503: aload_1
    //   504: iload 8
    //   506: invokevirtual 388	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setVideoId	(I)V
    //   509: new 390	acis
    //   512: dup
    //   513: aload_1
    //   514: aload 24
    //   516: new 95	java/util/HashMap
    //   519: dup
    //   520: invokespecial 96	java/util/HashMap:<init>	()V
    //   523: invokespecial 393	acis:<init>	(Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController;Landroid/widget/FrameLayout;Ljava/util/Map;)V
    //   526: astore 23
    //   528: aload 23
    //   530: aload 14
    //   532: putfield 395	acis:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   535: aload 23
    //   537: iload 12
    //   539: putfield 398	acis:jdField_b_of_type_Boolean	Z
    //   542: aload 23
    //   544: iload 6
    //   546: putfield 401	acis:jdField_c_of_type_Int	I
    //   549: aload 23
    //   551: iload 5
    //   553: putfield 403	acis:jdField_b_of_type_Int	I
    //   556: aload 23
    //   558: iload 8
    //   560: putfield 405	acis:jdField_a_of_type_Int	I
    //   563: aload 23
    //   565: iload 7
    //   567: putfield 407	acis:jdField_d_of_type_Int	I
    //   570: aload 23
    //   572: aload 16
    //   574: putfield 409	acis:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   577: aload 23
    //   579: aload 17
    //   581: putfield 411	acis:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   584: aload 23
    //   586: aload 18
    //   588: putfield 413	acis:e	Ljava/lang/String;
    //   591: aload 23
    //   593: aload 20
    //   595: putfield 416	acis:g	Ljava/lang/String;
    //   598: aload 23
    //   600: aload 19
    //   602: putfield 419	acis:f	Ljava/lang/String;
    //   605: aload 23
    //   607: aload 21
    //   609: putfield 422	acis:h	Ljava/lang/String;
    //   612: aload 23
    //   614: aload 22
    //   616: putfield 425	acis:i	Ljava/lang/String;
    //   619: aload_0
    //   620: getfield 98	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoViewMap	Ljava/util/Map;
    //   623: iload 8
    //   625: invokestatic 431	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   628: aload 23
    //   630: invokeinterface 436 3 0
    //   635: pop
    //   636: new 438	com/tencent/mobileqq/gamecenter/data/FeedsItemData
    //   639: dup
    //   640: invokespecial 439	com/tencent/mobileqq/gamecenter/data/FeedsItemData:<init>	()V
    //   643: astore 16
    //   645: aload 16
    //   647: aload 14
    //   649: putfield 442	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoVid	Ljava/lang/String;
    //   652: iload 7
    //   654: iconst_1
    //   655: if_icmpne +98 -> 753
    //   658: aload 16
    //   660: iconst_2
    //   661: putfield 445	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
    //   664: aload 16
    //   666: aload 15
    //   668: putfield 448	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoUrl	Ljava/lang/String;
    //   671: aload_1
    //   672: aload 16
    //   674: iconst_1
    //   675: invokevirtual 452	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setData	(Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;I)V
    //   678: iload 12
    //   680: ifeq +7 -> 687
    //   683: aload_1
    //   684: invokevirtual 454	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:f	()V
    //   687: iload 4
    //   689: ifeq +8 -> 697
    //   692: aload_1
    //   693: iconst_1
    //   694: invokevirtual 457	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setMute	(Z)V
    //   697: aload_1
    //   698: new 459	aciq
    //   701: dup
    //   702: aload_0
    //   703: invokespecial 460	aciq:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   706: invokevirtual 464	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setVideoStatusChangerListener	(Lavla;)V
    //   709: iload 8
    //   711: ireturn
    //   712: astore_1
    //   713: ldc 36
    //   715: iconst_1
    //   716: new 147	java/lang/StringBuilder
    //   719: dup
    //   720: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   723: ldc_w 466
    //   726: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: aload_1
    //   730: invokevirtual 469	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   733: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   736: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   739: iconst_m1
    //   740: ireturn
    //   741: iconst_0
    //   742: istore 4
    //   744: goto -615 -> 129
    //   747: iconst_0
    //   748: istore 12
    //   750: goto -608 -> 142
    //   753: aload 16
    //   755: iconst_1
    //   756: putfield 445	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
    //   759: goto -95 -> 664
    //   762: astore_1
    //   763: goto -526 -> 237
    //   766: goto -497 -> 269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	769	0	this	GameCenterAPIJavaScript
    //   0	769	1	paramJSONObject	JSONObject
    //   246	100	2	f1	float
    //   244	13	3	f2	float
    //   127	616	4	i	int
    //   58	494	5	j	int
    //   66	479	6	k	int
    //   114	542	7	m	int
    //   74	636	8	n	int
    //   82	237	9	i1	int
    //   200	136	10	i2	int
    //   210	82	11	i3	int
    //   140	609	12	bool1	boolean
    //   220	157	13	bool2	boolean
    //   90	558	14	str1	String
    //   98	569	15	str2	String
    //   106	648	16	localObject1	Object
    //   148	432	17	str3	String
    //   156	431	18	str4	String
    //   164	437	19	str5	String
    //   172	422	20	str6	String
    //   181	427	21	str7	String
    //   190	425	22	str8	String
    //   327	302	23	localObject2	Object
    //   428	87	24	localFrameLayout	FrameLayout
    // Exception table:
    //   from	to	target	type
    //   52	126	712	java/lang/Exception
    //   129	139	712	java/lang/Exception
    //   142	232	712	java/lang/Exception
    //   237	245	712	java/lang/Exception
    //   253	259	712	java/lang/Exception
    //   265	269	712	java/lang/Exception
    //   269	376	712	java/lang/Exception
    //   381	406	712	java/lang/Exception
    //   406	652	712	java/lang/Exception
    //   658	664	712	java/lang/Exception
    //   664	678	712	java/lang/Exception
    //   683	687	712	java/lang/Exception
    //   692	697	712	java/lang/Exception
    //   697	709	712	java/lang/Exception
    //   753	759	712	java/lang/Exception
    //   232	237	762	java/lang/Exception
  }
  
  public int delFlag(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      int j = paramJSONObject.optInt("pid");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        paramJSONObject = (acis)this.mVideoViewMap.get(Integer.valueOf(i));
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
        paramJSONObject = (acis)this.mVideoViewMap.get(Integer.valueOf(i));
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
        paramJSONObject = ((acis)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
        paramJSONObject.i();
        paramJSONObject.l();
        this.mVideoContainer.removeView(paramJSONObject);
        this.mVideoContainer.removeView(((acis)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_AndroidWidgetFrameLayout);
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
        return ((acis)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.a();
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
      localStringBuilder.append("" + bjve.c());
      localStringBuilder.append("|");
      localStringBuilder.append("" + bjve.a());
      localStringBuilder.append("|");
      localStringBuilder.append("" + acil.a(this.mContext.getApplicationContext()));
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
      localStringBuilder.append("" + acil.b());
      localStringBuilder.append("|");
      localStringBuilder.append("" + bjts.a(this.mContext.getApplicationContext()));
      localStringBuilder.append("|");
      localStringBuilder.append("" + Build.VERSION.RELEASE);
      localStringBuilder.append("|");
      localStringBuilder.append("" + bjjo.a().d());
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
        return ((acis)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.b();
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
      String str = bjjo.a().d();
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
          super.sendRemoteReq(asev.a("ipc_cmd_gamecenter_get_session_info", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
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
            super.sendRemoteReq(asev.a("ipc_cmd_gamecenter_get_request_info", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
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
            super.sendRemoteReq(asev.a("ipc_cmd_gamecenter_open_aio", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
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
            super.sendRemoteReq(asev.a("ipc_cmd_gamecenter_get_unread_total", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
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
            super.sendRemoteReq(asev.a("ipc_cmd_gamecenter_toggle_changed", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
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
    paramString2 = new acim(this, paramString2);
    if ("shotScreen".equals(paramString1))
    {
      aciy.a().a(this.mRuntime.a(), paramJSONObject.optString("key"), paramString2);
      return true;
    }
    if ("removeMask".equals(paramString1))
    {
      aciy.a().a(this.mRuntime.a(), paramString2);
      return true;
    }
    if ("delImg".equals(paramString1))
    {
      aciy.a().a(paramString2);
      return true;
    }
    if ("closeSwitch".equals(paramString1))
    {
      aciy.a().b(paramString2);
      return true;
    }
    if ("openSwitch".equals(paramString1))
    {
      aciy.a().c(paramString2);
      return true;
    }
    if ("queryInfo".equals(paramString1))
    {
      aciy.a().a(paramJSONObject.optString("key"), paramString2);
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
    RefreshView localRefreshView = (RefreshView)this.mRuntime.a().findViewById(2131381335);
    this.mVideoContainer = new acin(this, this.mRuntime.a(), paramCustomWebView);
    localRefreshView.addView(this.mVideoContainer, localLayoutParams);
    paramCustomWebView = (TouchWebView)this.mRuntime.a();
    this.mVideoContainer.scrollBy(0, paramCustomWebView.mTotalYoffset);
    this.mScrollChangedListener = new acio(this);
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
        ((acis)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.h();
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
        ((acis)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.d();
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
    bdmc.a(BaseApplication.getContext()).a(this.mRuntime.a(), this.uin, paramString1, paramString2, 0, 1, paramString3, null, null, null, null);
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
        FrameLayout localFrameLayout = ((acis)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_AndroidWidgetFrameLayout;
        URLImageView localURLImageView = new URLImageView(this.mContext);
        float f = this.mRuntime.a().getResources().getDisplayMetrics().density;
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)(m * f), (int)(n * f));
        localLayoutParams.topMargin = ((int)(j * f));
        localLayoutParams.leftMargin = ((int)(k * f));
        localFrameLayout.addView(localURLImageView, localLayoutParams);
        j = localURLImageView.hashCode();
        ((acis)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(j), localURLImageView);
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
        paramJSONObject = ((acis)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
        if (bool) {
          paramJSONObject.b();
        } else {
          paramJSONObject.c();
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
        ((acis)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.setMute(bool);
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
        paramJSONObject = ((acis)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
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
        paramJSONObject = ((acis)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_AndroidWidgetFrameLayout;
        TextView localTextView = new TextView(this.mContext);
        if (bool) {
          localTextView.setBackgroundResource(2130840163);
        }
        float f = this.mRuntime.a().getResources().getDisplayMetrics().density;
        localTextView.setPadding(agej.a(3.0F, this.mContext.getResources()), agej.a(3.0F, this.mContext.getResources()), agej.a(3.0F, this.mContext.getResources()), agej.a(3.0F, this.mContext.getResources()));
        localTextView.setText(str);
        localTextView.setTextSize(m);
        localTextView.setTextColor(Color.parseColor((String)localObject));
        m = localTextView.hashCode();
        localObject = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject).topMargin = ((int)(j * f));
        ((FrameLayout.LayoutParams)localObject).leftMargin = ((int)(k * f));
        paramJSONObject.addView(localTextView, (ViewGroup.LayoutParams)localObject);
        ((acis)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(m), localTextView);
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
    bjxd.a().a(paramString, null, (Activity)this.mContext);
  }
  
  public int stopVideo(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null) {
        ((acis)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.i();
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