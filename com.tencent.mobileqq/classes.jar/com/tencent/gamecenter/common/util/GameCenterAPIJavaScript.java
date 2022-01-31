package com.tencent.gamecenter.common.util;

import aciy;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION;
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
import awrn;
import bbac;
import bbtm;
import bcdn;
import bcez;
import bchb;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import yfa;
import yfb;
import yfc;
import yfd;
import yfh;
import yfn;

public class GameCenterAPIJavaScript
  extends WebViewPlugin
{
  public static final String APPKEY_PLAYER = "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==";
  public static final String CLOSE_SWITCH = "closeSwitch";
  public static final String DEL_IMG = "delImg";
  public static final String OPEN_SWITCH = "openSwitch";
  public static final String QUERY_INFO = "queryInfo";
  public static final String REMOVE_MASK = "removeMask";
  public static final String SHOT_SCREEN = "shotScreen";
  public static final String TAG = "GCApi";
  private static boolean mIsInited;
  private DisplayMetrics dm;
  private Context mContext;
  private TouchWebView.OnScrollChangedListener mScrollChangedListener;
  private FrameLayout mVideoContainer;
  private Map<Integer, yfh> mVideoViewMap = new HashMap();
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
  
  /* Error */
  public int createVideo(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 140	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbbac;
    //   4: invokevirtual 146	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   7: invokevirtual 152	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   10: invokestatic 156	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:isInstalled	(Landroid/content/Context;)Z
    //   13: ifne +28 -> 41
    //   16: aload_0
    //   17: invokespecial 158	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:initVideoSDK	()V
    //   20: aload_0
    //   21: getfield 140	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbbac;
    //   24: invokevirtual 146	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   27: invokevirtual 152	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   30: new 160	yfe
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 163	yfe:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   38: invokestatic 167	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:installPlugin	(Landroid/content/Context;Lcom/tencent/qqlive/mediaplayer/api/TVK_SDKMgr$InstallListener;)V
    //   41: aload_1
    //   42: ldc 169
    //   44: invokevirtual 173	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   47: istore 5
    //   49: aload_1
    //   50: ldc 175
    //   52: invokevirtual 173	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   55: istore 6
    //   57: aload_1
    //   58: ldc 177
    //   60: invokevirtual 173	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   63: istore 8
    //   65: aload_1
    //   66: ldc 179
    //   68: invokevirtual 173	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   71: istore 9
    //   73: aload_1
    //   74: ldc 181
    //   76: invokevirtual 185	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   79: astore 14
    //   81: aload_1
    //   82: ldc 187
    //   84: invokevirtual 185	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   87: astore 15
    //   89: aload_1
    //   90: ldc 189
    //   92: invokevirtual 185	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   95: astore 16
    //   97: aload_1
    //   98: ldc 191
    //   100: invokevirtual 173	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   103: istore 7
    //   105: aload_1
    //   106: ldc 193
    //   108: invokevirtual 173	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   111: iconst_1
    //   112: if_icmpne +627 -> 739
    //   115: iconst_1
    //   116: istore 4
    //   118: aload_1
    //   119: ldc 195
    //   121: invokevirtual 173	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   124: iconst_1
    //   125: if_icmpne +620 -> 745
    //   128: iconst_1
    //   129: istore 12
    //   131: aload_1
    //   132: ldc 197
    //   134: invokevirtual 185	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   137: astore 17
    //   139: aload_1
    //   140: ldc 199
    //   142: invokevirtual 185	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   145: astore 18
    //   147: aload_1
    //   148: ldc 201
    //   150: invokevirtual 185	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   153: astore 19
    //   155: aload_1
    //   156: ldc 203
    //   158: invokevirtual 185	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   161: astore 20
    //   163: aload_1
    //   164: ldc 205
    //   166: invokevirtual 185	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   169: astore 21
    //   171: aload_1
    //   172: ldc 207
    //   174: invokevirtual 185	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   177: astore 22
    //   179: aload_1
    //   180: ldc 209
    //   182: iconst_0
    //   183: invokevirtual 212	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   186: istore 10
    //   188: aload_1
    //   189: ldc 214
    //   191: iconst_0
    //   192: invokevirtual 212	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   195: istore 11
    //   197: aload_1
    //   198: ldc 216
    //   200: iconst_0
    //   201: invokevirtual 220	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   204: istore 13
    //   206: aload_1
    //   207: ldc 222
    //   209: ldc 49
    //   211: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   214: astore_1
    //   215: aload_1
    //   216: invokestatic 231	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   219: pop
    //   220: invokestatic 236	ajia:a	()F
    //   223: ldc 237
    //   225: fdiv
    //   226: fstore_3
    //   227: fconst_0
    //   228: fstore_2
    //   229: fload_3
    //   230: fconst_0
    //   231: fcmpl
    //   232: ifeq +9 -> 241
    //   235: invokestatic 240	babp:a	()F
    //   238: fload_3
    //   239: fdiv
    //   240: fstore_2
    //   241: fload_2
    //   242: fconst_0
    //   243: fcmpl
    //   244: ifne +492 -> 736
    //   247: invokestatic 240	babp:a	()F
    //   250: fstore_2
    //   251: aload_0
    //   252: getfield 64	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoContainer	Landroid/widget/FrameLayout;
    //   255: invokevirtual 246	android/widget/FrameLayout:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   258: checkcast 248	android/widget/RelativeLayout$LayoutParams
    //   261: astore_1
    //   262: aload_1
    //   263: iload 10
    //   265: i2f
    //   266: fload_2
    //   267: fmul
    //   268: f2i
    //   269: putfield 252	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   272: aload_1
    //   273: iload 11
    //   275: i2f
    //   276: fload_2
    //   277: fmul
    //   278: f2i
    //   279: putfield 255	android/widget/RelativeLayout$LayoutParams:bottomMargin	I
    //   282: aload_0
    //   283: getfield 64	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoContainer	Landroid/widget/FrameLayout;
    //   286: aload_1
    //   287: invokevirtual 259	android/widget/FrameLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   290: new 261	android/widget/FrameLayout$LayoutParams
    //   293: dup
    //   294: iload 8
    //   296: i2f
    //   297: fload_2
    //   298: fmul
    //   299: f2i
    //   300: iload 9
    //   302: i2f
    //   303: fload_2
    //   304: fmul
    //   305: f2i
    //   306: invokespecial 264	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   309: astore 23
    //   311: aload 23
    //   313: iload 5
    //   315: iload 10
    //   317: isub
    //   318: i2f
    //   319: fload_2
    //   320: fmul
    //   321: f2i
    //   322: putfield 265	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   325: aload 23
    //   327: fload_2
    //   328: iload 6
    //   330: i2f
    //   331: fmul
    //   332: f2i
    //   333: putfield 268	android/widget/FrameLayout$LayoutParams:leftMargin	I
    //   336: new 270	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController
    //   339: dup
    //   340: aload_0
    //   341: getfield 140	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbbac;
    //   344: invokevirtual 273	bbac:a	()Landroid/app/Activity;
    //   347: invokespecial 276	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:<init>	(Landroid/content/Context;)V
    //   350: astore_1
    //   351: aload_1
    //   352: ldc_w 277
    //   355: invokevirtual 281	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setBackgroundColor	(I)V
    //   358: iload 13
    //   360: ifeq +28 -> 388
    //   363: getstatic 286	android/os/Build$VERSION:SDK_INT	I
    //   366: bipush 21
    //   368: if_icmplt +20 -> 388
    //   371: aload_1
    //   372: new 288	yff
    //   375: dup
    //   376: aload_0
    //   377: invokespecial 289	yff:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   380: invokevirtual 293	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setOutlineProvider	(Landroid/view/ViewOutlineProvider;)V
    //   383: aload_1
    //   384: iconst_1
    //   385: invokevirtual 297	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setClipToOutline	(Z)V
    //   388: aload_1
    //   389: invokevirtual 300	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:n	()V
    //   392: aload_1
    //   393: invokevirtual 303	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:o	()V
    //   396: new 242	android/widget/FrameLayout
    //   399: dup
    //   400: aload_0
    //   401: getfield 140	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbbac;
    //   404: invokevirtual 273	bbac:a	()Landroid/app/Activity;
    //   407: invokespecial 304	android/widget/FrameLayout:<init>	(Landroid/content/Context;)V
    //   410: astore 24
    //   412: aload_1
    //   413: aload 24
    //   415: new 261	android/widget/FrameLayout$LayoutParams
    //   418: dup
    //   419: iconst_m1
    //   420: iconst_m1
    //   421: invokespecial 264	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   424: invokevirtual 308	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   427: aload_0
    //   428: getfield 64	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoContainer	Landroid/widget/FrameLayout;
    //   431: aload_1
    //   432: aload 23
    //   434: invokevirtual 309	android/widget/FrameLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   437: aload_0
    //   438: getfield 140	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lbbac;
    //   441: invokevirtual 312	bbac:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   444: checkcast 314	com/tencent/biz/ui/TouchWebView
    //   447: checkcast 314	com/tencent/biz/ui/TouchWebView
    //   450: aload_0
    //   451: getfield 316	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mScrollChangedListener	Lcom/tencent/biz/ui/TouchWebView$OnScrollChangedListener;
    //   454: invokevirtual 320	com/tencent/biz/ui/TouchWebView:setOnScrollChangedListener	(Lcom/tencent/biz/ui/TouchWebView$OnScrollChangedListener;)V
    //   457: new 97	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   464: aload 14
    //   466: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload 15
    //   471: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokevirtual 326	java/lang/String:hashCode	()I
    //   480: invokestatic 332	java/lang/Math:abs	(I)I
    //   483: istore 8
    //   485: aload_1
    //   486: iload 8
    //   488: invokevirtual 335	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setVideoId	(I)V
    //   491: new 337	yfh
    //   494: dup
    //   495: aload_1
    //   496: aload 24
    //   498: new 53	java/util/HashMap
    //   501: dup
    //   502: invokespecial 54	java/util/HashMap:<init>	()V
    //   505: invokespecial 340	yfh:<init>	(Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController;Landroid/widget/FrameLayout;Ljava/util/Map;)V
    //   508: astore 23
    //   510: aload 23
    //   512: aload 14
    //   514: putfield 342	yfh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   517: aload 23
    //   519: iload 12
    //   521: putfield 345	yfh:jdField_b_of_type_Boolean	Z
    //   524: aload 23
    //   526: iload 6
    //   528: putfield 348	yfh:jdField_c_of_type_Int	I
    //   531: aload 23
    //   533: iload 5
    //   535: putfield 350	yfh:jdField_b_of_type_Int	I
    //   538: aload 23
    //   540: iload 8
    //   542: putfield 352	yfh:jdField_a_of_type_Int	I
    //   545: aload 23
    //   547: iload 7
    //   549: putfield 354	yfh:jdField_d_of_type_Int	I
    //   552: aload 23
    //   554: aload 16
    //   556: putfield 356	yfh:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   559: aload 23
    //   561: aload 17
    //   563: putfield 358	yfh:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   566: aload 23
    //   568: aload 18
    //   570: putfield 360	yfh:e	Ljava/lang/String;
    //   573: aload 23
    //   575: aload 20
    //   577: putfield 363	yfh:g	Ljava/lang/String;
    //   580: aload 23
    //   582: aload 19
    //   584: putfield 366	yfh:f	Ljava/lang/String;
    //   587: aload 23
    //   589: aload 21
    //   591: putfield 369	yfh:h	Ljava/lang/String;
    //   594: aload 23
    //   596: aload 22
    //   598: putfield 372	yfh:i	Ljava/lang/String;
    //   601: aload_0
    //   602: getfield 56	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoViewMap	Ljava/util/Map;
    //   605: iload 8
    //   607: invokestatic 378	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   610: aload 23
    //   612: invokeinterface 383 3 0
    //   617: pop
    //   618: new 385	com/tencent/mobileqq/gamecenter/data/FeedsItemData
    //   621: dup
    //   622: invokespecial 386	com/tencent/mobileqq/gamecenter/data/FeedsItemData:<init>	()V
    //   625: astore 16
    //   627: aload 16
    //   629: aload 14
    //   631: putfield 389	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoVid	Ljava/lang/String;
    //   634: iload 7
    //   636: iconst_1
    //   637: if_icmpne +57 -> 694
    //   640: aload 16
    //   642: iconst_2
    //   643: putfield 392	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
    //   646: aload 16
    //   648: aload 15
    //   650: putfield 395	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoUrl	Ljava/lang/String;
    //   653: aload_1
    //   654: aload 16
    //   656: iconst_1
    //   657: invokevirtual 399	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setData	(Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;I)V
    //   660: iload 12
    //   662: ifeq +7 -> 669
    //   665: aload_1
    //   666: invokevirtual 401	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:f	()V
    //   669: iload 4
    //   671: ifeq +8 -> 679
    //   674: aload_1
    //   675: iconst_1
    //   676: invokevirtual 404	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setMute	(Z)V
    //   679: aload_1
    //   680: new 406	yfg
    //   683: dup
    //   684: aload_0
    //   685: invokespecial 407	yfg:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   688: invokevirtual 411	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setVideoStatusChangerListener	(Lapym;)V
    //   691: iload 8
    //   693: ireturn
    //   694: aload 16
    //   696: iconst_1
    //   697: putfield 392	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
    //   700: goto -54 -> 646
    //   703: astore_1
    //   704: ldc 29
    //   706: iconst_1
    //   707: new 97	java/lang/StringBuilder
    //   710: dup
    //   711: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   714: ldc_w 413
    //   717: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: aload_1
    //   721: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   724: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   727: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   730: iconst_m1
    //   731: ireturn
    //   732: astore_1
    //   733: goto -513 -> 220
    //   736: goto -485 -> 251
    //   739: iconst_0
    //   740: istore 4
    //   742: goto -624 -> 118
    //   745: iconst_0
    //   746: istore 12
    //   748: goto -617 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	751	0	this	GameCenterAPIJavaScript
    //   0	751	1	paramJSONObject	JSONObject
    //   228	100	2	f1	float
    //   226	13	3	f2	float
    //   116	625	4	i	int
    //   47	487	5	j	int
    //   55	472	6	k	int
    //   103	535	7	m	int
    //   63	629	8	n	int
    //   71	230	9	i1	int
    //   186	132	10	i2	int
    //   195	79	11	i3	int
    //   129	618	12	bool1	boolean
    //   204	155	13	bool2	boolean
    //   79	551	14	str1	String
    //   87	562	15	str2	String
    //   95	600	16	localObject1	Object
    //   137	425	17	str3	String
    //   145	424	18	str4	String
    //   153	430	19	str5	String
    //   161	415	20	str6	String
    //   169	421	21	str7	String
    //   177	420	22	str8	String
    //   309	302	23	localObject2	Object
    //   410	87	24	localFrameLayout	FrameLayout
    // Exception table:
    //   from	to	target	type
    //   41	115	703	java/lang/Exception
    //   118	128	703	java/lang/Exception
    //   131	215	703	java/lang/Exception
    //   220	227	703	java/lang/Exception
    //   235	241	703	java/lang/Exception
    //   247	251	703	java/lang/Exception
    //   251	358	703	java/lang/Exception
    //   363	388	703	java/lang/Exception
    //   388	634	703	java/lang/Exception
    //   640	646	703	java/lang/Exception
    //   646	660	703	java/lang/Exception
    //   665	669	703	java/lang/Exception
    //   674	679	703	java/lang/Exception
    //   679	691	703	java/lang/Exception
    //   694	700	703	java/lang/Exception
    //   215	220	732	java/lang/Exception
  }
  
  public int delFlag(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      int j = paramJSONObject.optInt("pid");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        paramJSONObject = (yfh)this.mVideoViewMap.get(Integer.valueOf(i));
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
        paramJSONObject = (yfh)this.mVideoViewMap.get(Integer.valueOf(i));
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
        paramJSONObject = ((yfh)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
        paramJSONObject.i();
        paramJSONObject.l();
        this.mVideoContainer.removeView(paramJSONObject);
        this.mVideoContainer.removeView(((yfh)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_AndroidWidgetFrameLayout);
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
      str = GameCenterActivity.a(this.mContext, "http://cgi.connect.qq.com/api/get_openids_by_appids", paramString, this.uin);
    }
    return str;
  }
  
  public long getProgress(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null) {
        return ((yfh)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.a();
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
      localStringBuilder.append("" + bcez.c());
      localStringBuilder.append("|");
      localStringBuilder.append("" + bcez.a());
      localStringBuilder.append("|");
      localStringBuilder.append("" + yfa.a(this.mContext.getApplicationContext()));
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
      localStringBuilder.append("" + yfa.b());
      localStringBuilder.append("|");
      localStringBuilder.append("" + bcdn.a(this.mContext.getApplicationContext()));
      localStringBuilder.append("|");
      localStringBuilder.append("" + Build.VERSION.RELEASE);
      localStringBuilder.append("|");
      localStringBuilder.append("" + bbtm.a().d());
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
        return ((yfh)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.b();
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
      String str = bbtm.a().d();
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
      if ("createVideo".equals(paramString3)) {}
      for (;;)
      {
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramString1 = paramString2.optString("callback");
          j = createVideo(paramString2);
          if (j <= 0) {
            continue;
          }
          paramString2 = new JSONObject();
          paramString2.put("ret", i);
          paramString2.put("id", j);
          super.callJs(paramString1 + "(" + paramString2.toString() + ");");
          paramString1 = null;
        }
        catch (JSONException paramString1)
        {
          int j;
          paramString1.printStackTrace();
          paramString1 = null;
          continue;
        }
        if ((paramJsBridgeListener != null) && (paramString1 != null)) {
          paramJsBridgeListener.a(paramString1);
        }
        return true;
        i = j;
        continue;
        if ("destoryVideo".equals(paramString3))
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
    paramString2 = new yfb(this, paramString2);
    if ("shotScreen".equals(paramString1))
    {
      yfn.a().a(this.mRuntime.a(), paramJSONObject.optString("key"), paramString2);
      return true;
    }
    if ("removeMask".equals(paramString1))
    {
      yfn.a().a(this.mRuntime.a(), paramString2);
      return true;
    }
    if ("delImg".equals(paramString1))
    {
      yfn.a().a(paramString2);
      return true;
    }
    if ("closeSwitch".equals(paramString1))
    {
      yfn.a().b(paramString2);
      return true;
    }
    if ("openSwitch".equals(paramString1))
    {
      yfn.a().c(paramString2);
      return true;
    }
    if ("queryInfo".equals(paramString1))
    {
      yfn.a().a(paramJSONObject.optString("key"), paramString2);
      return true;
    }
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.dm = new DisplayMetrics();
    this.mContext = this.mRuntime.a();
    if (this.mContext != null) {
      ((Activity)this.mContext).getWindowManager().getDefaultDisplay().getMetrics(this.dm);
    }
    if (this.mRuntime.a() != null) {
      this.uin = this.mRuntime.a().getCurrentAccountUin();
    }
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    RefreshView localRefreshView = (RefreshView)this.mRuntime.a().findViewById(2131313572);
    this.mVideoContainer = new yfc(this, this.mRuntime.a(), paramCustomWebView);
    localRefreshView.addView(this.mVideoContainer, localLayoutParams);
    paramCustomWebView = (TouchWebView)this.mRuntime.a();
    this.mVideoContainer.scrollBy(0, paramCustomWebView.mTotalYoffset);
    this.mScrollChangedListener = new yfd(this);
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
        ((yfh)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.h();
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
        ((yfh)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.d();
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
    awrn.a(BaseApplication.getContext()).a(this.mRuntime.a(), this.uin, paramString1, paramString2, 0, 1, paramString3, null, null, null, null);
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
        FrameLayout localFrameLayout = ((yfh)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_AndroidWidgetFrameLayout;
        URLImageView localURLImageView = new URLImageView(this.mContext);
        float f = this.mRuntime.a().getResources().getDisplayMetrics().density;
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)(m * f), (int)(n * f));
        localLayoutParams.topMargin = ((int)(j * f));
        localLayoutParams.leftMargin = ((int)(k * f));
        localFrameLayout.addView(localURLImageView, localLayoutParams);
        j = localURLImageView.hashCode();
        ((yfh)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(j), localURLImageView);
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
        paramJSONObject = ((yfh)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
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
        ((yfh)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.setMute(bool);
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
        paramJSONObject = ((yfh)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
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
        paramJSONObject = ((yfh)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_AndroidWidgetFrameLayout;
        TextView localTextView = new TextView(this.mContext);
        if (bool) {
          localTextView.setBackgroundResource(2130839602);
        }
        float f = this.mRuntime.a().getResources().getDisplayMetrics().density;
        localTextView.setPadding(aciy.a(3.0F, this.mContext.getResources()), aciy.a(3.0F, this.mContext.getResources()), aciy.a(3.0F, this.mContext.getResources()), aciy.a(3.0F, this.mContext.getResources()));
        localTextView.setText(str);
        localTextView.setTextSize(m);
        localTextView.setTextColor(Color.parseColor((String)localObject));
        m = localTextView.hashCode();
        localObject = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject).topMargin = ((int)(j * f));
        ((FrameLayout.LayoutParams)localObject).leftMargin = ((int)(k * f));
        paramJSONObject.addView(localTextView, (ViewGroup.LayoutParams)localObject);
        ((yfh)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(m), localTextView);
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
    bchb.a().a(paramString, null, (Activity)this.mContext);
  }
  
  public int stopVideo(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null) {
        ((yfh)this.mVideoViewMap.get(Integer.valueOf(i))).jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.i();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.GameCenterAPIJavaScript
 * JD-Core Version:    0.7.0.1
 */