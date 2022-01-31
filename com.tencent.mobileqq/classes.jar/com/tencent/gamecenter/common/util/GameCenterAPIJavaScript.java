package com.tencent.gamecenter.common.util;

import aacu;
import aacv;
import aacw;
import aacx;
import aadb;
import aadc;
import aadi;
import aekt;
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
import aphy;
import apic;
import azmz;
import becq;
import bexd;
import bfhb;
import bfin;
import bfko;
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
  private aadb mMsgReceiver = new aadb(this, null);
  public Bundle mReqBundle;
  private TouchWebView.OnScrollChangedListener mScrollChangedListener;
  private FrameLayout mVideoContainer;
  private Map<Integer, aadc> mVideoViewMap = new HashMap();
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
    //   0: aload_0
    //   1: getfield 199	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbecq;
    //   4: invokevirtual 205	becq:a	()Lcom/tencent/common/app/AppInterface;
    //   7: invokevirtual 211	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   10: invokestatic 215	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:isInstalled	(Landroid/content/Context;)Z
    //   13: ifne +28 -> 41
    //   16: aload_0
    //   17: invokespecial 217	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:initVideoSDK	()V
    //   20: aload_0
    //   21: getfield 199	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbecq;
    //   24: invokevirtual 205	becq:a	()Lcom/tencent/common/app/AppInterface;
    //   27: invokevirtual 211	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   30: new 219	aacy
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 222	aacy:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   38: invokestatic 226	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:installPlugin	(Landroid/content/Context;Lcom/tencent/qqlive/mediaplayer/api/TVK_SDKMgr$InstallListener;)V
    //   41: aload_1
    //   42: ldc 228
    //   44: invokevirtual 232	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   47: istore 5
    //   49: aload_1
    //   50: ldc 234
    //   52: invokevirtual 232	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   55: istore 6
    //   57: aload_1
    //   58: ldc 236
    //   60: invokevirtual 232	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   63: istore 8
    //   65: aload_1
    //   66: ldc 238
    //   68: invokevirtual 232	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   71: istore 9
    //   73: aload_1
    //   74: ldc 240
    //   76: invokevirtual 244	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   79: astore 14
    //   81: aload_1
    //   82: ldc 246
    //   84: invokevirtual 244	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   87: astore 15
    //   89: aload_1
    //   90: ldc 248
    //   92: invokevirtual 244	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   95: astore 16
    //   97: aload_1
    //   98: ldc 250
    //   100: invokevirtual 232	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   103: istore 7
    //   105: aload_1
    //   106: ldc 252
    //   108: invokevirtual 232	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   111: iconst_1
    //   112: if_icmpne +638 -> 750
    //   115: iconst_1
    //   116: istore 4
    //   118: aload_1
    //   119: ldc 254
    //   121: invokevirtual 232	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   124: iconst_1
    //   125: if_icmpne +631 -> 756
    //   128: iconst_1
    //   129: istore 12
    //   131: aload_1
    //   132: ldc_w 256
    //   135: invokevirtual 244	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   138: astore 17
    //   140: aload_1
    //   141: ldc_w 258
    //   144: invokevirtual 244	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   147: astore 18
    //   149: aload_1
    //   150: ldc_w 260
    //   153: invokevirtual 244	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   156: astore 19
    //   158: aload_1
    //   159: ldc_w 262
    //   162: invokevirtual 244	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   165: astore 20
    //   167: aload_1
    //   168: ldc_w 264
    //   171: invokevirtual 244	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   174: astore 21
    //   176: aload_1
    //   177: ldc_w 266
    //   180: invokevirtual 244	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   183: astore 22
    //   185: aload_1
    //   186: ldc_w 268
    //   189: iconst_0
    //   190: invokevirtual 271	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   193: istore 10
    //   195: aload_1
    //   196: ldc_w 273
    //   199: iconst_0
    //   200: invokevirtual 271	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   203: istore 11
    //   205: aload_1
    //   206: ldc_w 275
    //   209: iconst_0
    //   210: invokevirtual 279	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   213: istore 13
    //   215: aload_1
    //   216: ldc_w 281
    //   219: ldc 91
    //   221: invokevirtual 284	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   224: astore_1
    //   225: aload_1
    //   226: invokestatic 290	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   229: pop
    //   230: invokestatic 295	alnq:a	()F
    //   233: ldc_w 296
    //   236: fdiv
    //   237: fstore_3
    //   238: fconst_0
    //   239: fstore_2
    //   240: fload_3
    //   241: fconst_0
    //   242: fcmpl
    //   243: ifeq +9 -> 252
    //   246: invokestatic 299	bdcb:a	()F
    //   249: fload_3
    //   250: fdiv
    //   251: fstore_2
    //   252: fload_2
    //   253: fconst_0
    //   254: fcmpl
    //   255: ifne +492 -> 747
    //   258: invokestatic 299	bdcb:a	()F
    //   261: fstore_2
    //   262: aload_0
    //   263: getfield 114	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoContainer	Landroid/widget/FrameLayout;
    //   266: invokevirtual 305	android/widget/FrameLayout:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   269: checkcast 307	android/widget/RelativeLayout$LayoutParams
    //   272: astore_1
    //   273: aload_1
    //   274: iload 10
    //   276: i2f
    //   277: fload_2
    //   278: fmul
    //   279: f2i
    //   280: putfield 311	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   283: aload_1
    //   284: iload 11
    //   286: i2f
    //   287: fload_2
    //   288: fmul
    //   289: f2i
    //   290: putfield 314	android/widget/RelativeLayout$LayoutParams:bottomMargin	I
    //   293: aload_0
    //   294: getfield 114	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoContainer	Landroid/widget/FrameLayout;
    //   297: aload_1
    //   298: invokevirtual 318	android/widget/FrameLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   301: new 320	android/widget/FrameLayout$LayoutParams
    //   304: dup
    //   305: iload 8
    //   307: i2f
    //   308: fload_2
    //   309: fmul
    //   310: f2i
    //   311: iload 9
    //   313: i2f
    //   314: fload_2
    //   315: fmul
    //   316: f2i
    //   317: invokespecial 323	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   320: astore 23
    //   322: aload 23
    //   324: iload 5
    //   326: iload 10
    //   328: isub
    //   329: i2f
    //   330: fload_2
    //   331: fmul
    //   332: f2i
    //   333: putfield 324	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   336: aload 23
    //   338: fload_2
    //   339: iload 6
    //   341: i2f
    //   342: fmul
    //   343: f2i
    //   344: putfield 327	android/widget/FrameLayout$LayoutParams:leftMargin	I
    //   347: new 329	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController
    //   350: dup
    //   351: aload_0
    //   352: getfield 199	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbecq;
    //   355: invokevirtual 332	becq:a	()Landroid/app/Activity;
    //   358: invokespecial 335	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:<init>	(Landroid/content/Context;)V
    //   361: astore_1
    //   362: aload_1
    //   363: ldc_w 336
    //   366: invokevirtual 340	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setBackgroundColor	(I)V
    //   369: iload 13
    //   371: ifeq +28 -> 399
    //   374: getstatic 345	android/os/Build$VERSION:SDK_INT	I
    //   377: bipush 21
    //   379: if_icmplt +20 -> 399
    //   382: aload_1
    //   383: new 347	aacz
    //   386: dup
    //   387: aload_0
    //   388: invokespecial 348	aacz:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   391: invokevirtual 352	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setOutlineProvider	(Landroid/view/ViewOutlineProvider;)V
    //   394: aload_1
    //   395: iconst_1
    //   396: invokevirtual 356	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setClipToOutline	(Z)V
    //   399: aload_1
    //   400: invokevirtual 359	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:n	()V
    //   403: aload_1
    //   404: invokevirtual 362	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:o	()V
    //   407: new 301	android/widget/FrameLayout
    //   410: dup
    //   411: aload_0
    //   412: getfield 199	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbecq;
    //   415: invokevirtual 332	becq:a	()Landroid/app/Activity;
    //   418: invokespecial 363	android/widget/FrameLayout:<init>	(Landroid/content/Context;)V
    //   421: astore 24
    //   423: aload_1
    //   424: aload 24
    //   426: new 320	android/widget/FrameLayout$LayoutParams
    //   429: dup
    //   430: iconst_m1
    //   431: iconst_m1
    //   432: invokespecial 323	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   435: invokevirtual 367	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   438: aload_0
    //   439: getfield 114	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoContainer	Landroid/widget/FrameLayout;
    //   442: aload_1
    //   443: aload 23
    //   445: invokevirtual 368	android/widget/FrameLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   448: aload_0
    //   449: getfield 199	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbecq;
    //   452: invokevirtual 371	becq:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   455: checkcast 373	com/tencent/biz/ui/TouchWebView
    //   458: checkcast 373	com/tencent/biz/ui/TouchWebView
    //   461: aload_0
    //   462: getfield 375	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mScrollChangedListener	Lcom/tencent/biz/ui/TouchWebView$OnScrollChangedListener;
    //   465: invokevirtual 379	com/tencent/biz/ui/TouchWebView:setOnScrollChangedListener	(Lcom/tencent/biz/ui/TouchWebView$OnScrollChangedListener;)V
    //   468: new 147	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   475: aload 14
    //   477: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: aload 15
    //   482: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokevirtual 385	java/lang/String:hashCode	()I
    //   491: invokestatic 391	java/lang/Math:abs	(I)I
    //   494: istore 8
    //   496: aload_1
    //   497: iload 8
    //   499: invokevirtual 394	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setVideoId	(I)V
    //   502: new 396	aadc
    //   505: dup
    //   506: aload_1
    //   507: aload 24
    //   509: new 95	java/util/HashMap
    //   512: dup
    //   513: invokespecial 96	java/util/HashMap:<init>	()V
    //   516: invokespecial 399	aadc:<init>	(Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController;Landroid/widget/FrameLayout;Ljava/util/Map;)V
    //   519: astore 23
    //   521: aload 23
    //   523: aload 14
    //   525: putfield 401	aadc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   528: aload 23
    //   530: iload 12
    //   532: putfield 404	aadc:jdField_b_of_type_Boolean	Z
    //   535: aload 23
    //   537: iload 6
    //   539: putfield 407	aadc:jdField_c_of_type_Int	I
    //   542: aload 23
    //   544: iload 5
    //   546: putfield 409	aadc:jdField_b_of_type_Int	I
    //   549: aload 23
    //   551: iload 8
    //   553: putfield 411	aadc:jdField_a_of_type_Int	I
    //   556: aload 23
    //   558: iload 7
    //   560: putfield 413	aadc:jdField_d_of_type_Int	I
    //   563: aload 23
    //   565: aload 16
    //   567: putfield 415	aadc:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   570: aload 23
    //   572: aload 17
    //   574: putfield 417	aadc:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   577: aload 23
    //   579: aload 18
    //   581: putfield 419	aadc:e	Ljava/lang/String;
    //   584: aload 23
    //   586: aload 20
    //   588: putfield 422	aadc:g	Ljava/lang/String;
    //   591: aload 23
    //   593: aload 19
    //   595: putfield 425	aadc:f	Ljava/lang/String;
    //   598: aload 23
    //   600: aload 21
    //   602: putfield 428	aadc:h	Ljava/lang/String;
    //   605: aload 23
    //   607: aload 22
    //   609: putfield 431	aadc:i	Ljava/lang/String;
    //   612: aload_0
    //   613: getfield 98	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoViewMap	Ljava/util/Map;
    //   616: iload 8
    //   618: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   621: aload 23
    //   623: invokeinterface 442 3 0
    //   628: pop
    //   629: new 444	com/tencent/mobileqq/gamecenter/data/FeedsItemData
    //   632: dup
    //   633: invokespecial 445	com/tencent/mobileqq/gamecenter/data/FeedsItemData:<init>	()V
    //   636: astore 16
    //   638: aload 16
    //   640: aload 14
    //   642: putfield 448	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoVid	Ljava/lang/String;
    //   645: iload 7
    //   647: iconst_1
    //   648: if_icmpne +57 -> 705
    //   651: aload 16
    //   653: iconst_2
    //   654: putfield 451	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
    //   657: aload 16
    //   659: aload 15
    //   661: putfield 454	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoUrl	Ljava/lang/String;
    //   664: aload_1
    //   665: aload 16
    //   667: iconst_1
    //   668: invokevirtual 458	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setData	(Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;I)V
    //   671: iload 12
    //   673: ifeq +7 -> 680
    //   676: aload_1
    //   677: invokevirtual 460	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:f	()V
    //   680: iload 4
    //   682: ifeq +8 -> 690
    //   685: aload_1
    //   686: iconst_1
    //   687: invokevirtual 463	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setMute	(Z)V
    //   690: aload_1
    //   691: new 465	aada
    //   694: dup
    //   695: aload_0
    //   696: invokespecial 466	aada:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   699: invokevirtual 470	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setVideoStatusChangerListener	(Lasij;)V
    //   702: iload 8
    //   704: ireturn
    //   705: aload 16
    //   707: iconst_1
    //   708: putfield 451	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
    //   711: goto -54 -> 657
    //   714: astore_1
    //   715: ldc 36
    //   717: iconst_1
    //   718: new 147	java/lang/StringBuilder
    //   721: dup
    //   722: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   725: ldc_w 472
    //   728: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: aload_1
    //   732: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   735: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   741: iconst_m1
    //   742: ireturn
    //   743: astore_1
    //   744: goto -514 -> 230
    //   747: goto -485 -> 262
    //   750: iconst_0
    //   751: istore 4
    //   753: goto -635 -> 118
    //   756: iconst_0
    //   757: istore 12
    //   759: goto -628 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	762	0	this	GameCenterAPIJavaScript
    //   0	762	1	paramJSONObject	JSONObject
    //   239	100	2	f1	float
    //   237	13	3	f2	float
    //   116	636	4	i	int
    //   47	498	5	j	int
    //   55	483	6	k	int
    //   103	546	7	m	int
    //   63	640	8	n	int
    //   71	241	9	i1	int
    //   193	136	10	i2	int
    //   203	82	11	i3	int
    //   129	629	12	bool1	boolean
    //   213	157	13	bool2	boolean
    //   79	562	14	str1	String
    //   87	573	15	str2	String
    //   95	611	16	localObject1	Object
    //   138	435	17	str3	String
    //   147	433	18	str4	String
    //   156	438	19	str5	String
    //   165	422	20	str6	String
    //   174	427	21	str7	String
    //   183	425	22	str8	String
    //   320	302	23	localObject2	Object
    //   421	87	24	localFrameLayout	FrameLayout
    // Exception table:
    //   from	to	target	type
    //   41	115	714	java/lang/Exception
    //   118	128	714	java/lang/Exception
    //   131	225	714	java/lang/Exception
    //   230	238	714	java/lang/Exception
    //   246	252	714	java/lang/Exception
    //   258	262	714	java/lang/Exception
    //   262	369	714	java/lang/Exception
    //   374	399	714	java/lang/Exception
    //   399	645	714	java/lang/Exception
    //   651	657	714	java/lang/Exception
    //   657	671	714	java/lang/Exception
    //   676	680	714	java/lang/Exception
    //   685	690	714	java/lang/Exception
    //   690	702	714	java/lang/Exception
    //   705	711	714	java/lang/Exception
    //   225	230	743	java/lang/Exception
  }
  
  public int delFlag(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      int j = paramJSONObject.optInt("pid");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        paramJSONObject = (aadc)this.mVideoViewMap.get(Integer.valueOf(i));
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
        paramJSONObject = (aadc)this.mVideoViewMap.get(Integer.valueOf(i));
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
        paramJSONObject = ((aadc)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
        paramJSONObject.i();
        paramJSONObject.l();
        this.mVideoContainer.removeView(paramJSONObject);
        this.mVideoContainer.removeView(((aadc)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_AndroidWidgetFrameLayout);
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
        return ((aadc)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.a();
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
      localStringBuilder.append("" + bfin.c());
      localStringBuilder.append("|");
      localStringBuilder.append("" + bfin.a());
      localStringBuilder.append("|");
      localStringBuilder.append("" + aacu.a(this.mContext.getApplicationContext()));
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
      localStringBuilder.append("" + aacu.b());
      localStringBuilder.append("|");
      localStringBuilder.append("" + bfhb.a(this.mContext.getApplicationContext()));
      localStringBuilder.append("|");
      localStringBuilder.append("" + Build.VERSION.RELEASE);
      localStringBuilder.append("|");
      localStringBuilder.append("" + bexd.a().d());
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
        return ((aadc)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.b();
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
      String str = bexd.a().d();
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
          super.sendRemoteReq(apic.a("ipc_cmd_gamecenter_get_session_info", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
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
            super.sendRemoteReq(apic.a("ipc_cmd_gamecenter_get_request_info", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
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
            super.sendRemoteReq(apic.a("ipc_cmd_gamecenter_open_aio", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
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
            super.sendRemoteReq(apic.a("ipc_cmd_gamecenter_get_unread_total", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
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
            super.sendRemoteReq(apic.a("ipc_cmd_gamecenter_toggle_changed", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
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
    paramString2 = new aacv(this, paramString2);
    if ("shotScreen".equals(paramString1))
    {
      aadi.a().a(this.mRuntime.a(), paramJSONObject.optString("key"), paramString2);
      return true;
    }
    if ("removeMask".equals(paramString1))
    {
      aadi.a().a(this.mRuntime.a(), paramString2);
      return true;
    }
    if ("delImg".equals(paramString1))
    {
      aadi.a().a(paramString2);
      return true;
    }
    if ("closeSwitch".equals(paramString1))
    {
      aadi.a().b(paramString2);
      return true;
    }
    if ("openSwitch".equals(paramString1))
    {
      aadi.a().c(paramString2);
      return true;
    }
    if ("queryInfo".equals(paramString1))
    {
      aadi.a().a(paramJSONObject.optString("key"), paramString2);
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
    RefreshView localRefreshView = (RefreshView)this.mRuntime.a().findViewById(2131380127);
    this.mVideoContainer = new aacw(this, this.mRuntime.a(), paramCustomWebView);
    localRefreshView.addView(this.mVideoContainer, localLayoutParams);
    paramCustomWebView = (TouchWebView)this.mRuntime.a();
    this.mVideoContainer.scrollBy(0, paramCustomWebView.mTotalYoffset);
    this.mScrollChangedListener = new aacx(this);
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
        ((aadc)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.h();
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
    try
    {
      int i = paramJSONObject.optInt("id");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null) {
        ((aadc)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.d();
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
    azmz.a(BaseApplication.getContext()).a(this.mRuntime.a(), this.uin, paramString1, paramString2, 0, 1, paramString3, null, null, null, null);
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
        FrameLayout localFrameLayout = ((aadc)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_AndroidWidgetFrameLayout;
        URLImageView localURLImageView = new URLImageView(this.mContext);
        float f = this.mRuntime.a().getResources().getDisplayMetrics().density;
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)(m * f), (int)(n * f));
        localLayoutParams.topMargin = ((int)(j * f));
        localLayoutParams.leftMargin = ((int)(k * f));
        localFrameLayout.addView(localURLImageView, localLayoutParams);
        j = localURLImageView.hashCode();
        ((aadc)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(j), localURLImageView);
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
        paramJSONObject = ((aadc)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
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
        ((aadc)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.setMute(bool);
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
        paramJSONObject = ((aadc)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
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
        paramJSONObject = ((aadc)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_AndroidWidgetFrameLayout;
        TextView localTextView = new TextView(this.mContext);
        if (bool) {
          localTextView.setBackgroundResource(2130839747);
        }
        float f = this.mRuntime.a().getResources().getDisplayMetrics().density;
        localTextView.setPadding(aekt.a(3.0F, this.mContext.getResources()), aekt.a(3.0F, this.mContext.getResources()), aekt.a(3.0F, this.mContext.getResources()), aekt.a(3.0F, this.mContext.getResources()));
        localTextView.setText(str);
        localTextView.setTextSize(m);
        localTextView.setTextColor(Color.parseColor((String)localObject));
        m = localTextView.hashCode();
        localObject = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject).topMargin = ((int)(j * f));
        ((FrameLayout.LayoutParams)localObject).leftMargin = ((int)(k * f));
        paramJSONObject.addView(localTextView, (ViewGroup.LayoutParams)localObject);
        ((aadc)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(m), localTextView);
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
    bfko.a().a(paramString, null, (Activity)this.mContext);
  }
  
  public int stopVideo(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null) {
        ((aadc)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.i();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.GameCenterAPIJavaScript
 * JD-Core Version:    0.7.0.1
 */