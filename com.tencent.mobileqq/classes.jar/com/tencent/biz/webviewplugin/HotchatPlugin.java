package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class HotchatPlugin
  extends WebViewPlugin
{
  public static final String a;
  protected static final int[] a;
  public static final String b;
  protected static final int[] b;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  private OnRemoteRespObserver jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver = new HotchatPlugin.6(this);
  protected PopupMenuDialog a;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131705662);
    jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131705660);
    jdField_a_of_type_ArrayOfInt = new int[] { 2131720052, 2131698959 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130843872, 2130843868 };
  }
  
  public HotchatPlugin()
  {
    this.mPluginNameSpace = "hotchat";
  }
  
  public void a(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfInt.length)
    {
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.id = i;
      localMenuItem.title = localActivity.getString(jdField_a_of_type_ArrayOfInt[i]);
      localMenuItem.contentDescription = localMenuItem.title;
      localMenuItem.iconId = jdField_b_of_type_ArrayOfInt[i];
      localArrayList.add(localMenuItem);
      i += 1;
    }
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog == null) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.build(localActivity, localArrayList, new HotchatPlugin.7(this, paramString));
    }
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing())
    {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
      return;
    }
    paramString = localActivity.findViewById(2131376636);
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(paramString, paramString.getWidth() - localActivity.getResources().getDimensionPixelSize(2131298902) - localActivity.getResources().getDimensionPixelSize(2131298898), localActivity.getResources().getDimensionPixelSize(2131298899));
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +51 -> 54
    //   6: new 168	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   13: astore_1
    //   14: aload_1
    //   15: ldc 171
    //   17: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_1
    //   22: aload 4
    //   24: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_1
    //   29: ldc 177
    //   31: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_1
    //   36: aload 5
    //   38: iconst_0
    //   39: aaload
    //   40: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: ldc 179
    //   46: iconst_2
    //   47: aload_1
    //   48: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: ldc 62
    //   56: aload_3
    //   57: invokevirtual 193	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   60: ifeq +2378 -> 2438
    //   63: ldc 195
    //   65: aload 4
    //   67: invokevirtual 198	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: istore 10
    //   72: aconst_null
    //   73: astore 14
    //   75: aconst_null
    //   76: astore_1
    //   77: aconst_null
    //   78: astore 15
    //   80: aconst_null
    //   81: astore 13
    //   83: aconst_null
    //   84: astore_2
    //   85: aconst_null
    //   86: astore 11
    //   88: aconst_null
    //   89: astore 12
    //   91: iconst_1
    //   92: istore 9
    //   94: iload 10
    //   96: ifeq +171 -> 267
    //   99: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +35 -> 137
    //   105: new 168	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   112: astore_1
    //   113: aload_1
    //   114: ldc 195
    //   116: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_1
    //   121: aload 5
    //   123: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: ldc 179
    //   129: iconst_2
    //   130: aload_1
    //   131: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 204	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aload 5
    //   139: ifnull +126 -> 265
    //   142: aload 5
    //   144: arraylength
    //   145: ifle +120 -> 265
    //   148: new 206	org/json/JSONObject
    //   151: dup
    //   152: aload 5
    //   154: iconst_0
    //   155: aaload
    //   156: invokespecial 208	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   159: ldc 210
    //   161: invokevirtual 214	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   164: astore_1
    //   165: aload_0
    //   166: getfield 72	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   169: invokevirtual 77	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   172: astore_2
    //   173: aload_2
    //   174: ifnull +91 -> 265
    //   177: aload_2
    //   178: instanceof 216
    //   181: ifeq +84 -> 265
    //   184: aload_2
    //   185: checkcast 216	com/tencent/mobileqq/activity/INearbyActivity
    //   188: invokeinterface 220 1 0
    //   193: checkcast 222	com/tencent/mobileqq/fragment/NearbyBaseFragment
    //   196: astore_3
    //   197: aload_3
    //   198: ifnull +67 -> 265
    //   201: aload_3
    //   202: instanceof 224
    //   205: ifeq +60 -> 265
    //   208: aload_1
    //   209: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   212: ifeq +15 -> 227
    //   215: aload_3
    //   216: checkcast 224	com/tencent/mobileqq/activity/IHotChatFragment
    //   219: aconst_null
    //   220: invokeinterface 233 2 0
    //   225: iconst_1
    //   226: ireturn
    //   227: aload_3
    //   228: checkcast 224	com/tencent/mobileqq/activity/IHotChatFragment
    //   231: new 235	com/tencent/biz/webviewplugin/HotchatPlugin$1
    //   234: dup
    //   235: aload_0
    //   236: aload_1
    //   237: aload_2
    //   238: invokespecial 238	com/tencent/biz/webviewplugin/HotchatPlugin$1:<init>	(Lcom/tencent/biz/webviewplugin/HotchatPlugin;Ljava/lang/String;Landroid/app/Activity;)V
    //   241: invokeinterface 233 2 0
    //   246: iconst_1
    //   247: ireturn
    //   248: astore_1
    //   249: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   252: ifeq +13 -> 265
    //   255: ldc 179
    //   257: iconst_2
    //   258: aload_1
    //   259: invokevirtual 241	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   262: invokestatic 204	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: iconst_1
    //   266: ireturn
    //   267: ldc 243
    //   269: aload 4
    //   271: invokevirtual 193	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   274: ifeq +30 -> 304
    //   277: aload 5
    //   279: ifnull +23 -> 302
    //   282: aload 5
    //   284: arraylength
    //   285: ifle +17 -> 302
    //   288: aload_0
    //   289: getfield 72	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   292: invokevirtual 77	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   295: aload 5
    //   297: iconst_0
    //   298: aaload
    //   299: invokestatic 248	com/tencent/mobileqq/dating/NearbyTransitActivity:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   302: iconst_1
    //   303: ireturn
    //   304: ldc 250
    //   306: aload 4
    //   308: invokevirtual 198	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   311: ifeq +24 -> 335
    //   314: aload_0
    //   315: getfield 72	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   318: invokevirtual 77	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   321: new 252	android/content/Intent
    //   324: dup
    //   325: ldc 254
    //   327: invokespecial 255	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   330: invokevirtual 259	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   333: iconst_0
    //   334: ireturn
    //   335: ldc_w 261
    //   338: aload 4
    //   340: invokevirtual 198	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   343: ifeq +49 -> 392
    //   346: aload 5
    //   348: iconst_0
    //   349: aaload
    //   350: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   353: ifne +2085 -> 2438
    //   356: new 252	android/content/Intent
    //   359: dup
    //   360: ldc_w 263
    //   363: invokespecial 255	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   366: astore_1
    //   367: aload_1
    //   368: ldc_w 265
    //   371: aload 5
    //   373: iconst_0
    //   374: aaload
    //   375: invokevirtual 269	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   378: pop
    //   379: aload_0
    //   380: getfield 72	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   383: invokevirtual 77	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   386: aload_1
    //   387: invokevirtual 259	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   390: iconst_0
    //   391: ireturn
    //   392: ldc_w 271
    //   395: aload 4
    //   397: invokevirtual 193	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   400: ifeq +22 -> 422
    //   403: invokestatic 277	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   406: new 279	com/tencent/biz/webviewplugin/HotchatPlugin$2
    //   409: dup
    //   410: aload_0
    //   411: aload 5
    //   413: invokespecial 282	com/tencent/biz/webviewplugin/HotchatPlugin$2:<init>	(Lcom/tencent/biz/webviewplugin/HotchatPlugin;[Ljava/lang/String;)V
    //   416: invokevirtual 288	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   419: pop
    //   420: iconst_0
    //   421: ireturn
    //   422: ldc_w 290
    //   425: aload 4
    //   427: invokevirtual 193	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   430: istore 10
    //   432: ldc_w 292
    //   435: astore_3
    //   436: iload 10
    //   438: ifeq +161 -> 599
    //   441: ldc_w 294
    //   444: invokestatic 300	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   447: checkcast 294	com/tencent/mobileqq/nearby/api/INearbySPUtil
    //   450: aload_0
    //   451: getfield 72	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   454: invokevirtual 303	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   457: invokevirtual 308	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   460: ldc_w 310
    //   463: iconst_0
    //   464: invokestatic 316	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   467: invokeinterface 320 4 0
    //   472: checkcast 312	java/lang/Boolean
    //   475: invokevirtual 323	java/lang/Boolean:booleanValue	()Z
    //   478: istore 9
    //   480: aload 12
    //   482: astore_1
    //   483: aload 5
    //   485: ifnull +40 -> 525
    //   488: aload 12
    //   490: astore_1
    //   491: aload 5
    //   493: arraylength
    //   494: ifle +31 -> 525
    //   497: new 206	org/json/JSONObject
    //   500: dup
    //   501: aload 5
    //   503: iconst_0
    //   504: aaload
    //   505: invokespecial 208	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   508: ldc 210
    //   510: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   513: astore_1
    //   514: goto +11 -> 525
    //   517: astore_1
    //   518: aload_1
    //   519: invokevirtual 328	org/json/JSONException:printStackTrace	()V
    //   522: aload 12
    //   524: astore_1
    //   525: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   528: ifeq +35 -> 563
    //   531: new 168	java/lang/StringBuilder
    //   534: dup
    //   535: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   538: astore_2
    //   539: aload_2
    //   540: ldc_w 330
    //   543: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: aload_2
    //   548: aload_1
    //   549: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: pop
    //   553: ldc 179
    //   555: iconst_2
    //   556: aload_2
    //   557: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   563: aload_1
    //   564: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   567: ifne +1871 -> 2438
    //   570: iload 9
    //   572: ifeq +8 -> 580
    //   575: aload_3
    //   576: astore_2
    //   577: goto +7 -> 584
    //   580: ldc_w 332
    //   583: astore_2
    //   584: aload_0
    //   585: aload_1
    //   586: iconst_1
    //   587: anewarray 189	java/lang/String
    //   590: dup
    //   591: iconst_0
    //   592: aload_2
    //   593: aastore
    //   594: invokevirtual 336	com/tencent/biz/webviewplugin/HotchatPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   597: iconst_0
    //   598: ireturn
    //   599: ldc_w 338
    //   602: aload 4
    //   604: invokevirtual 193	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   607: ifeq +261 -> 868
    //   610: aload 5
    //   612: ifnull +99 -> 711
    //   615: aload 5
    //   617: arraylength
    //   618: ifle +93 -> 711
    //   621: new 206	org/json/JSONObject
    //   624: dup
    //   625: aload 5
    //   627: iconst_0
    //   628: aaload
    //   629: invokespecial 208	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   632: astore 4
    //   634: aload 4
    //   636: ldc 210
    //   638: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   641: astore_2
    //   642: aload 14
    //   644: astore_1
    //   645: aload 4
    //   647: ldc_w 340
    //   650: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   653: astore_3
    //   654: aload_3
    //   655: astore_1
    //   656: aload_3
    //   657: invokestatic 345	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   660: astore_3
    //   661: aload_3
    //   662: astore_1
    //   663: aload 4
    //   665: ldc_w 347
    //   668: invokevirtual 351	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   671: istore 6
    //   673: iload 6
    //   675: ifne +6 -> 681
    //   678: iconst_0
    //   679: istore 9
    //   681: aload_2
    //   682: astore_1
    //   683: aload_3
    //   684: astore_2
    //   685: goto +34 -> 719
    //   688: astore 4
    //   690: aload_2
    //   691: astore_3
    //   692: aload_1
    //   693: astore_2
    //   694: aload_3
    //   695: astore_1
    //   696: goto +7 -> 703
    //   699: astore 4
    //   701: aconst_null
    //   702: astore_2
    //   703: aload 4
    //   705: invokevirtual 328	org/json/JSONException:printStackTrace	()V
    //   708: goto +8 -> 716
    //   711: aconst_null
    //   712: astore_2
    //   713: aload 15
    //   715: astore_1
    //   716: iconst_0
    //   717: istore 9
    //   719: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   722: ifeq +64 -> 786
    //   725: new 168	java/lang/StringBuilder
    //   728: dup
    //   729: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   732: astore_3
    //   733: aload_3
    //   734: ldc_w 330
    //   737: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: pop
    //   741: aload_3
    //   742: aload_1
    //   743: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: pop
    //   747: aload_3
    //   748: ldc_w 353
    //   751: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: pop
    //   755: aload_3
    //   756: aload_2
    //   757: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: pop
    //   761: aload_3
    //   762: ldc_w 355
    //   765: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: pop
    //   769: aload_3
    //   770: iload 9
    //   772: invokevirtual 358	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   775: pop
    //   776: ldc 179
    //   778: iconst_2
    //   779: aload_3
    //   780: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   783: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   786: aload_2
    //   787: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   790: ifne +1648 -> 2438
    //   793: aload_1
    //   794: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   797: ifne +1641 -> 2438
    //   800: new 360	android/os/Bundle
    //   803: dup
    //   804: invokespecial 361	android/os/Bundle:<init>	()V
    //   807: astore_3
    //   808: aload_3
    //   809: ldc_w 363
    //   812: aload_2
    //   813: invokevirtual 367	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   816: aload_3
    //   817: ldc_w 369
    //   820: ldc_w 338
    //   823: invokevirtual 367	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   826: aload_3
    //   827: ldc_w 371
    //   830: iload 9
    //   832: invokevirtual 375	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   835: ldc_w 377
    //   838: aload_1
    //   839: aload_0
    //   840: getfield 60	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver	Lcom/tencent/mobileqq/emosm/OnRemoteRespObserver;
    //   843: getfield 382	com/tencent/mobileqq/emosm/OnRemoteRespObserver:key	I
    //   846: aload_3
    //   847: invokestatic 387	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   850: astore_1
    //   851: ldc_w 389
    //   854: invokestatic 300	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   857: checkcast 389	com/tencent/mobileqq/emosm/api/IWebIPCOperatorApi
    //   860: aload_1
    //   861: invokeinterface 393 2 0
    //   866: iconst_0
    //   867: ireturn
    //   868: ldc_w 395
    //   871: aload 4
    //   873: invokevirtual 193	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   876: ifeq +304 -> 1180
    //   879: aload_0
    //   880: getfield 72	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   883: invokevirtual 303	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   886: astore 12
    //   888: aload 5
    //   890: ifnull +93 -> 983
    //   893: aload 5
    //   895: arraylength
    //   896: ifle +87 -> 983
    //   899: new 206	org/json/JSONObject
    //   902: dup
    //   903: aload 5
    //   905: iconst_0
    //   906: aaload
    //   907: invokespecial 208	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   910: astore 4
    //   912: aload 4
    //   914: ldc_w 397
    //   917: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   920: astore_3
    //   921: aload 13
    //   923: astore_1
    //   924: aload 4
    //   926: ldc_w 399
    //   929: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   932: astore_2
    //   933: aload_2
    //   934: astore_1
    //   935: aload 4
    //   937: ldc_w 401
    //   940: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   943: astore 4
    //   945: aload 4
    //   947: astore_1
    //   948: goto +44 -> 992
    //   951: astore 4
    //   953: aload_3
    //   954: astore_2
    //   955: aload 4
    //   957: astore_3
    //   958: goto +6 -> 964
    //   961: astore_3
    //   962: aconst_null
    //   963: astore_1
    //   964: aload_3
    //   965: invokevirtual 402	java/lang/Exception:printStackTrace	()V
    //   968: ldc_w 404
    //   971: astore 4
    //   973: aload_2
    //   974: astore_3
    //   975: aload_1
    //   976: astore_2
    //   977: aload 4
    //   979: astore_1
    //   980: goto +12 -> 992
    //   983: ldc_w 404
    //   986: astore_1
    //   987: aconst_null
    //   988: astore_3
    //   989: aload 11
    //   991: astore_2
    //   992: aload 12
    //   994: ifnull +112 -> 1106
    //   997: aload_2
    //   998: ifnull +108 -> 1106
    //   1001: aload_3
    //   1002: ifnull +104 -> 1106
    //   1005: ldc_w 406
    //   1008: aload_3
    //   1009: invokevirtual 198	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1012: ifeq +63 -> 1075
    //   1015: ldc_w 294
    //   1018: invokestatic 300	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1021: checkcast 294	com/tencent/mobileqq/nearby/api/INearbySPUtil
    //   1024: aload 12
    //   1026: invokevirtual 409	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1029: ldc_w 411
    //   1032: aload_2
    //   1033: invokeinterface 415 4 0
    //   1038: pop
    //   1039: ldc_w 294
    //   1042: invokestatic 300	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1045: checkcast 294	com/tencent/mobileqq/nearby/api/INearbySPUtil
    //   1048: aload 12
    //   1050: invokevirtual 409	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1053: ldc_w 417
    //   1056: ldc_w 404
    //   1059: aload_1
    //   1060: invokevirtual 420	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1063: invokestatic 316	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1066: invokeinterface 415 4 0
    //   1071: pop
    //   1072: goto +34 -> 1106
    //   1075: aload_2
    //   1076: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1079: ifne +27 -> 1106
    //   1082: ldc_w 294
    //   1085: invokestatic 300	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1088: checkcast 294	com/tencent/mobileqq/nearby/api/INearbySPUtil
    //   1091: aload 12
    //   1093: invokevirtual 409	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1096: ldc_w 422
    //   1099: aload_2
    //   1100: invokeinterface 415 4 0
    //   1105: pop
    //   1106: invokestatic 426	com/tencent/mobileqq/nearby/NearbyUtils:b	()Z
    //   1109: ifeq +1329 -> 2438
    //   1112: aload 5
    //   1114: ifnull +21 -> 1135
    //   1117: aload 5
    //   1119: arraylength
    //   1120: ifne +6 -> 1126
    //   1123: goto +12 -> 1135
    //   1126: aload 5
    //   1128: iconst_0
    //   1129: aaload
    //   1130: astore 4
    //   1132: goto +8 -> 1140
    //   1135: ldc_w 428
    //   1138: astore 4
    //   1140: ldc 179
    //   1142: bipush 6
    //   1144: anewarray 430	java/lang/Object
    //   1147: dup
    //   1148: iconst_0
    //   1149: ldc_w 395
    //   1152: aastore
    //   1153: dup
    //   1154: iconst_1
    //   1155: aload 12
    //   1157: aastore
    //   1158: dup
    //   1159: iconst_2
    //   1160: aload_3
    //   1161: aastore
    //   1162: dup
    //   1163: iconst_3
    //   1164: aload_2
    //   1165: aastore
    //   1166: dup
    //   1167: iconst_4
    //   1168: aload_1
    //   1169: aastore
    //   1170: dup
    //   1171: iconst_5
    //   1172: aload 4
    //   1174: aastore
    //   1175: invokestatic 433	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1178: iconst_0
    //   1179: ireturn
    //   1180: ldc_w 435
    //   1183: aload 4
    //   1185: invokevirtual 193	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1188: ifeq +279 -> 1467
    //   1191: aload_0
    //   1192: getfield 72	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1195: invokevirtual 303	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1198: astore 4
    //   1200: aload 5
    //   1202: ifnull +117 -> 1319
    //   1205: aload 5
    //   1207: arraylength
    //   1208: ifle +111 -> 1319
    //   1211: new 206	org/json/JSONObject
    //   1214: dup
    //   1215: aload 5
    //   1217: iconst_0
    //   1218: aaload
    //   1219: invokespecial 208	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1222: astore_2
    //   1223: aload_2
    //   1224: ldc_w 437
    //   1227: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1230: astore_1
    //   1231: aload_2
    //   1232: ldc_w 439
    //   1235: invokevirtual 351	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1238: istore 7
    //   1240: aload_2
    //   1241: ldc_w 441
    //   1244: invokevirtual 351	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1247: istore 6
    //   1249: aload_2
    //   1250: ldc 210
    //   1252: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1255: astore_3
    //   1256: aload_1
    //   1257: astore_2
    //   1258: iload 6
    //   1260: istore 8
    //   1262: aload_3
    //   1263: astore_1
    //   1264: iload 7
    //   1266: istore 6
    //   1268: iload 8
    //   1270: istore 7
    //   1272: goto +57 -> 1329
    //   1275: astore_2
    //   1276: goto +20 -> 1296
    //   1279: astore_2
    //   1280: goto +13 -> 1293
    //   1283: astore_2
    //   1284: goto +6 -> 1290
    //   1287: astore_2
    //   1288: aconst_null
    //   1289: astore_1
    //   1290: iconst_0
    //   1291: istore 7
    //   1293: iconst_0
    //   1294: istore 6
    //   1296: aload_2
    //   1297: invokevirtual 402	java/lang/Exception:printStackTrace	()V
    //   1300: aload_1
    //   1301: astore_2
    //   1302: iload 6
    //   1304: istore 8
    //   1306: aconst_null
    //   1307: astore_1
    //   1308: iload 7
    //   1310: istore 6
    //   1312: iload 8
    //   1314: istore 7
    //   1316: goto +13 -> 1329
    //   1319: aconst_null
    //   1320: astore_1
    //   1321: aload_1
    //   1322: astore_2
    //   1323: iconst_0
    //   1324: istore 6
    //   1326: iconst_0
    //   1327: istore 7
    //   1329: aload_2
    //   1330: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1333: ifeq +75 -> 1408
    //   1336: new 206	org/json/JSONObject
    //   1339: dup
    //   1340: invokespecial 442	org/json/JSONObject:<init>	()V
    //   1343: astore_3
    //   1344: aload_3
    //   1345: ldc_w 444
    //   1348: iconst_m1
    //   1349: invokevirtual 448	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1352: pop
    //   1353: aload_3
    //   1354: ldc_w 450
    //   1357: ldc_w 452
    //   1360: invokevirtual 455	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1363: pop
    //   1364: aload_3
    //   1365: ldc_w 457
    //   1368: ldc_w 459
    //   1371: invokevirtual 455	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1374: pop
    //   1375: aload_3
    //   1376: invokevirtual 460	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1379: astore_3
    //   1380: goto +12 -> 1392
    //   1383: astore_3
    //   1384: aload_3
    //   1385: invokevirtual 402	java/lang/Exception:printStackTrace	()V
    //   1388: ldc_w 452
    //   1391: astore_3
    //   1392: aload_0
    //   1393: aload_1
    //   1394: iconst_1
    //   1395: anewarray 189	java/lang/String
    //   1398: dup
    //   1399: iconst_0
    //   1400: aload_3
    //   1401: aastore
    //   1402: invokevirtual 336	com/tencent/biz/webviewplugin/HotchatPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1405: goto +15 -> 1420
    //   1408: aload 4
    //   1410: iload 6
    //   1412: iload 7
    //   1414: aload_2
    //   1415: aload_0
    //   1416: aload_1
    //   1417: invokestatic 465	com/tencent/mobileqq/nearby/NearbyAlumniServletUtils:a	(Lcom/tencent/common/app/AppInterface;IILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V
    //   1420: invokestatic 426	com/tencent/mobileqq/nearby/NearbyUtils:b	()Z
    //   1423: ifeq +1015 -> 2438
    //   1426: ldc 179
    //   1428: iconst_5
    //   1429: anewarray 430	java/lang/Object
    //   1432: dup
    //   1433: iconst_0
    //   1434: ldc_w 435
    //   1437: aastore
    //   1438: dup
    //   1439: iconst_1
    //   1440: iload 6
    //   1442: invokestatic 470	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1445: aastore
    //   1446: dup
    //   1447: iconst_2
    //   1448: iload 7
    //   1450: invokestatic 470	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1453: aastore
    //   1454: dup
    //   1455: iconst_3
    //   1456: aload_2
    //   1457: aastore
    //   1458: dup
    //   1459: iconst_4
    //   1460: aload_1
    //   1461: aastore
    //   1462: invokestatic 433	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1465: iconst_0
    //   1466: ireturn
    //   1467: ldc_w 472
    //   1470: aload 4
    //   1472: invokevirtual 198	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1475: ifeq +133 -> 1608
    //   1478: aload 5
    //   1480: ifnull +126 -> 1606
    //   1483: aload 5
    //   1485: arraylength
    //   1486: ifle +120 -> 1606
    //   1489: new 206	org/json/JSONObject
    //   1492: dup
    //   1493: aload 5
    //   1495: iconst_0
    //   1496: aaload
    //   1497: invokespecial 208	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1500: ldc 210
    //   1502: invokevirtual 214	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1505: astore_1
    //   1506: aload_0
    //   1507: getfield 72	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1510: invokevirtual 77	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1513: astore_2
    //   1514: aload_2
    //   1515: ifnull +91 -> 1606
    //   1518: aload_2
    //   1519: instanceof 216
    //   1522: ifeq +84 -> 1606
    //   1525: aload_2
    //   1526: checkcast 216	com/tencent/mobileqq/activity/INearbyActivity
    //   1529: invokeinterface 220 1 0
    //   1534: checkcast 222	com/tencent/mobileqq/fragment/NearbyBaseFragment
    //   1537: astore_3
    //   1538: aload_3
    //   1539: ifnull +67 -> 1606
    //   1542: aload_3
    //   1543: instanceof 224
    //   1546: ifeq +60 -> 1606
    //   1549: aload_1
    //   1550: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1553: ifeq +15 -> 1568
    //   1556: aload_3
    //   1557: checkcast 224	com/tencent/mobileqq/activity/IHotChatFragment
    //   1560: aconst_null
    //   1561: invokeinterface 233 2 0
    //   1566: iconst_1
    //   1567: ireturn
    //   1568: aload_3
    //   1569: checkcast 224	com/tencent/mobileqq/activity/IHotChatFragment
    //   1572: new 474	com/tencent/biz/webviewplugin/HotchatPlugin$3
    //   1575: dup
    //   1576: aload_0
    //   1577: aload_1
    //   1578: aload_2
    //   1579: invokespecial 475	com/tencent/biz/webviewplugin/HotchatPlugin$3:<init>	(Lcom/tencent/biz/webviewplugin/HotchatPlugin;Ljava/lang/String;Landroid/app/Activity;)V
    //   1582: invokeinterface 233 2 0
    //   1587: iconst_1
    //   1588: ireturn
    //   1589: astore_1
    //   1590: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1593: ifeq +13 -> 1606
    //   1596: ldc 179
    //   1598: iconst_2
    //   1599: aload_1
    //   1600: invokevirtual 241	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1603: invokestatic 204	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1606: iconst_1
    //   1607: ireturn
    //   1608: ldc_w 477
    //   1611: aload 4
    //   1613: invokevirtual 193	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1616: ifeq +171 -> 1787
    //   1619: aload 5
    //   1621: ifnull +817 -> 2438
    //   1624: aload 5
    //   1626: arraylength
    //   1627: ifle +811 -> 2438
    //   1630: new 206	org/json/JSONObject
    //   1633: dup
    //   1634: aload 5
    //   1636: iconst_0
    //   1637: aaload
    //   1638: invokespecial 208	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1641: astore_1
    //   1642: aload_1
    //   1643: ldc_w 479
    //   1646: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1649: astore_3
    //   1650: aload_1
    //   1651: ldc_w 481
    //   1654: invokevirtual 485	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1657: astore 4
    //   1659: iconst_0
    //   1660: istore 6
    //   1662: iload 6
    //   1664: aload 4
    //   1666: invokevirtual 490	org/json/JSONArray:length	()I
    //   1669: if_icmpge +769 -> 2438
    //   1672: aload 4
    //   1674: iload 6
    //   1676: invokevirtual 494	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   1679: checkcast 206	org/json/JSONObject
    //   1682: astore_1
    //   1683: aload_1
    //   1684: ldc_w 496
    //   1687: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1690: astore 5
    //   1692: aload_1
    //   1693: ldc_w 498
    //   1696: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1699: astore_2
    //   1700: aload_1
    //   1701: ldc_w 500
    //   1704: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1707: astore 11
    //   1709: aload_2
    //   1710: astore_1
    //   1711: aload_2
    //   1712: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1715: ifeq +26 -> 1741
    //   1718: aload_2
    //   1719: astore_1
    //   1720: aload 5
    //   1722: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1725: ifne +16 -> 1741
    //   1728: aload_0
    //   1729: getfield 44	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1732: aload 5
    //   1734: invokevirtual 503	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1737: checkcast 189	java/lang/String
    //   1740: astore_1
    //   1741: aload_1
    //   1742: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1745: ifne +14 -> 1759
    //   1748: aload_0
    //   1749: getfield 46	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1752: aload_3
    //   1753: aload_1
    //   1754: aload 11
    //   1756: invokevirtual 508	com/tencent/biz/troop/TroopMemberApiClient:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1759: iload 6
    //   1761: iconst_1
    //   1762: iadd
    //   1763: istore 6
    //   1765: goto -103 -> 1662
    //   1768: astore_1
    //   1769: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1772: ifeq +666 -> 2438
    //   1775: ldc 179
    //   1777: iconst_2
    //   1778: aload_1
    //   1779: invokevirtual 241	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1782: invokestatic 204	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1785: iconst_0
    //   1786: ireturn
    //   1787: ldc_w 510
    //   1790: aload 4
    //   1792: invokevirtual 193	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1795: ifeq +88 -> 1883
    //   1798: aload 5
    //   1800: ifnull +638 -> 2438
    //   1803: aload 5
    //   1805: arraylength
    //   1806: ifle +632 -> 2438
    //   1809: new 206	org/json/JSONObject
    //   1812: dup
    //   1813: aload 5
    //   1815: iconst_0
    //   1816: aaload
    //   1817: invokespecial 208	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1820: astore_3
    //   1821: aload_3
    //   1822: ldc 210
    //   1824: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1827: astore_1
    //   1828: aload_3
    //   1829: ldc_w 479
    //   1832: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1835: astore_2
    //   1836: aload_3
    //   1837: ldc_w 512
    //   1840: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1843: astore_3
    //   1844: aload_0
    //   1845: getfield 46	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1848: aload_2
    //   1849: aload_3
    //   1850: new 514	com/tencent/biz/webviewplugin/HotchatPlugin$4
    //   1853: dup
    //   1854: aload_0
    //   1855: aload_1
    //   1856: invokespecial 515	com/tencent/biz/webviewplugin/HotchatPlugin$4:<init>	(Lcom/tencent/biz/webviewplugin/HotchatPlugin;Ljava/lang/String;)V
    //   1859: invokevirtual 519	com/tencent/biz/troop/TroopMemberApiClient:c	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi$Callback;)V
    //   1862: iconst_0
    //   1863: ireturn
    //   1864: astore_1
    //   1865: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1868: ifeq +570 -> 2438
    //   1871: ldc 179
    //   1873: iconst_2
    //   1874: aload_1
    //   1875: invokevirtual 241	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1878: invokestatic 204	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1881: iconst_0
    //   1882: ireturn
    //   1883: ldc_w 521
    //   1886: aload 4
    //   1888: invokevirtual 193	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1891: ifeq +126 -> 2017
    //   1894: new 79	java/util/ArrayList
    //   1897: dup
    //   1898: invokespecial 80	java/util/ArrayList:<init>	()V
    //   1901: astore_1
    //   1902: aload 5
    //   1904: ifnull +534 -> 2438
    //   1907: aload 5
    //   1909: arraylength
    //   1910: ifle +528 -> 2438
    //   1913: new 206	org/json/JSONObject
    //   1916: dup
    //   1917: aload 5
    //   1919: iconst_0
    //   1920: aaload
    //   1921: invokespecial 208	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1924: astore_2
    //   1925: aload_2
    //   1926: ldc 210
    //   1928: invokevirtual 214	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1931: pop
    //   1932: aload_2
    //   1933: ldc_w 479
    //   1936: invokevirtual 214	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1939: pop
    //   1940: aload_2
    //   1941: ldc_w 523
    //   1944: invokevirtual 485	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1947: astore_2
    //   1948: iconst_0
    //   1949: istore 6
    //   1951: iload 6
    //   1953: aload_2
    //   1954: invokevirtual 490	org/json/JSONArray:length	()I
    //   1957: if_icmpge +23 -> 1980
    //   1960: aload_1
    //   1961: aload_2
    //   1962: iload 6
    //   1964: invokevirtual 524	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1967: invokevirtual 525	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1970: pop
    //   1971: iload 6
    //   1973: iconst_1
    //   1974: iadd
    //   1975: istore 6
    //   1977: goto -26 -> 1951
    //   1980: aload_0
    //   1981: getfield 46	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1984: aload_1
    //   1985: new 527	com/tencent/biz/webviewplugin/HotchatPlugin$5
    //   1988: dup
    //   1989: aload_0
    //   1990: invokespecial 528	com/tencent/biz/webviewplugin/HotchatPlugin$5:<init>	(Lcom/tencent/biz/webviewplugin/HotchatPlugin;)V
    //   1993: invokevirtual 531	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/util/ArrayList;Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi$Callback;)V
    //   1996: iconst_0
    //   1997: ireturn
    //   1998: astore_1
    //   1999: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2002: ifeq +436 -> 2438
    //   2005: ldc 179
    //   2007: iconst_2
    //   2008: aload_1
    //   2009: invokevirtual 241	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2012: invokestatic 204	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2015: iconst_0
    //   2016: ireturn
    //   2017: ldc_w 533
    //   2020: aload 4
    //   2022: invokevirtual 193	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2025: ifeq +60 -> 2085
    //   2028: aload 5
    //   2030: ifnull +408 -> 2438
    //   2033: aload 5
    //   2035: arraylength
    //   2036: ifle +402 -> 2438
    //   2039: new 206	org/json/JSONObject
    //   2042: dup
    //   2043: aload 5
    //   2045: iconst_0
    //   2046: aaload
    //   2047: invokespecial 208	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2050: ldc_w 479
    //   2053: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2056: pop
    //   2057: aload_0
    //   2058: getfield 44	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2061: invokevirtual 536	java/util/HashMap:clear	()V
    //   2064: iconst_0
    //   2065: ireturn
    //   2066: astore_1
    //   2067: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2070: ifeq +368 -> 2438
    //   2073: ldc 179
    //   2075: iconst_2
    //   2076: aload_1
    //   2077: invokevirtual 241	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2080: invokestatic 204	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2083: iconst_0
    //   2084: ireturn
    //   2085: ldc_w 538
    //   2088: aload 4
    //   2090: invokevirtual 193	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2093: ifeq +73 -> 2166
    //   2096: aload_0
    //   2097: getfield 72	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2100: invokevirtual 77	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2103: astore_1
    //   2104: aload 5
    //   2106: ifnull +332 -> 2438
    //   2109: aload 5
    //   2111: arraylength
    //   2112: ifle +326 -> 2438
    //   2115: new 206	org/json/JSONObject
    //   2118: dup
    //   2119: aload 5
    //   2121: iconst_0
    //   2122: aaload
    //   2123: invokespecial 208	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2126: ldc_w 479
    //   2129: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2132: astore_2
    //   2133: aload_0
    //   2134: getfield 46	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   2137: aload_2
    //   2138: invokevirtual 540	com/tencent/biz/troop/TroopMemberApiClient:d	(Ljava/lang/String;)V
    //   2141: aload_1
    //   2142: invokevirtual 543	android/app/Activity:finish	()V
    //   2145: iconst_0
    //   2146: ireturn
    //   2147: astore_1
    //   2148: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2151: ifeq +287 -> 2438
    //   2154: ldc 179
    //   2156: iconst_2
    //   2157: aload_1
    //   2158: invokevirtual 241	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2161: invokestatic 204	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2164: iconst_0
    //   2165: ireturn
    //   2166: ldc_w 545
    //   2169: aload 4
    //   2171: invokevirtual 193	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2174: ifeq +231 -> 2405
    //   2177: aload 5
    //   2179: ifnull +259 -> 2438
    //   2182: aload 5
    //   2184: arraylength
    //   2185: ifle +253 -> 2438
    //   2188: new 206	org/json/JSONObject
    //   2191: dup
    //   2192: aload 5
    //   2194: iconst_0
    //   2195: aaload
    //   2196: invokespecial 208	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2199: astore_1
    //   2200: aload_0
    //   2201: getfield 72	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2204: invokevirtual 77	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2207: astore_3
    //   2208: aload_1
    //   2209: ldc_w 547
    //   2212: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2215: astore 4
    //   2217: aload_1
    //   2218: ldc_w 498
    //   2221: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2224: astore_2
    //   2225: aload_1
    //   2226: ldc_w 496
    //   2229: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2232: astore 11
    //   2234: aload_1
    //   2235: ldc_w 500
    //   2238: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2241: astore 5
    //   2243: aload_1
    //   2244: ldc_w 479
    //   2247: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2250: astore 12
    //   2252: aload_2
    //   2253: astore_1
    //   2254: aload_2
    //   2255: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2258: ifeq +26 -> 2284
    //   2261: aload_2
    //   2262: astore_1
    //   2263: aload 11
    //   2265: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2268: ifne +16 -> 2284
    //   2271: aload_0
    //   2272: getfield 44	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2275: aload 11
    //   2277: invokevirtual 503	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2280: checkcast 189	java/lang/String
    //   2283: astore_1
    //   2284: aload_1
    //   2285: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2288: ifeq +19 -> 2307
    //   2291: invokestatic 553	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2294: getstatic 27	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2297: iconst_0
    //   2298: invokestatic 558	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   2301: invokevirtual 561	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   2304: pop
    //   2305: iconst_0
    //   2306: ireturn
    //   2307: aload 4
    //   2309: ldc_w 332
    //   2312: invokevirtual 198	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2315: ifeq +19 -> 2334
    //   2318: aload_0
    //   2319: getfield 46	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   2322: aload 12
    //   2324: aload_1
    //   2325: invokevirtual 564	com/tencent/biz/troop/TroopMemberApiClient:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   2328: aload_3
    //   2329: invokevirtual 543	android/app/Activity:finish	()V
    //   2332: iconst_0
    //   2333: ireturn
    //   2334: aload 4
    //   2336: ldc_w 292
    //   2339: invokevirtual 198	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2342: ifeq +21 -> 2363
    //   2345: aload_0
    //   2346: getfield 46	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   2349: aload 12
    //   2351: aload_1
    //   2352: aload 5
    //   2354: invokevirtual 566	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2357: aload_3
    //   2358: invokevirtual 543	android/app/Activity:finish	()V
    //   2361: iconst_0
    //   2362: ireturn
    //   2363: aload 4
    //   2365: ldc_w 568
    //   2368: invokevirtual 198	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2371: ifeq +67 -> 2438
    //   2374: aload_0
    //   2375: getfield 46	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   2378: aload 12
    //   2380: aload_1
    //   2381: invokevirtual 571	com/tencent/biz/troop/TroopMemberApiClient:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   2384: iconst_0
    //   2385: ireturn
    //   2386: astore_1
    //   2387: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2390: ifeq +48 -> 2438
    //   2393: ldc 179
    //   2395: iconst_2
    //   2396: aload_1
    //   2397: invokevirtual 241	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2400: invokestatic 204	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2403: iconst_0
    //   2404: ireturn
    //   2405: new 168	java/lang/StringBuilder
    //   2408: dup
    //   2409: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   2412: astore_1
    //   2413: aload_1
    //   2414: ldc_w 573
    //   2417: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2420: pop
    //   2421: aload_1
    //   2422: aload 4
    //   2424: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2427: pop
    //   2428: ldc 179
    //   2430: iconst_1
    //   2431: aload_1
    //   2432: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2435: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2438: iconst_0
    //   2439: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2440	0	this	HotchatPlugin
    //   0	2440	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2440	2	paramString1	String
    //   0	2440	3	paramString2	String
    //   0	2440	4	paramString3	String
    //   0	2440	5	paramVarArgs	String[]
    //   671	1305	6	i	int
    //   1238	211	7	j	int
    //   1260	53	8	k	int
    //   92	739	9	bool1	boolean
    //   70	367	10	bool2	boolean
    //   86	2190	11	str	String
    //   89	2290	12	localObject1	java.lang.Object
    //   81	841	13	localObject2	java.lang.Object
    //   73	570	14	localObject3	java.lang.Object
    //   78	636	15	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   148	173	248	org/json/JSONException
    //   177	197	248	org/json/JSONException
    //   201	225	248	org/json/JSONException
    //   227	246	248	org/json/JSONException
    //   497	514	517	org/json/JSONException
    //   645	654	688	org/json/JSONException
    //   656	661	688	org/json/JSONException
    //   663	673	688	org/json/JSONException
    //   621	642	699	org/json/JSONException
    //   924	933	951	java/lang/Exception
    //   935	945	951	java/lang/Exception
    //   899	921	961	java/lang/Exception
    //   1249	1256	1275	java/lang/Exception
    //   1240	1249	1279	java/lang/Exception
    //   1231	1240	1283	java/lang/Exception
    //   1211	1231	1287	java/lang/Exception
    //   1336	1380	1383	java/lang/Exception
    //   1489	1514	1589	org/json/JSONException
    //   1518	1538	1589	org/json/JSONException
    //   1542	1566	1589	org/json/JSONException
    //   1568	1587	1589	org/json/JSONException
    //   1630	1659	1768	org/json/JSONException
    //   1662	1709	1768	org/json/JSONException
    //   1711	1718	1768	org/json/JSONException
    //   1720	1741	1768	org/json/JSONException
    //   1741	1759	1768	org/json/JSONException
    //   1809	1862	1864	org/json/JSONException
    //   1913	1948	1998	org/json/JSONException
    //   1951	1971	1998	org/json/JSONException
    //   1980	1996	1998	org/json/JSONException
    //   2039	2064	2066	org/json/JSONException
    //   2115	2145	2147	org/json/JSONException
    //   2188	2252	2386	org/json/JSONException
    //   2254	2261	2386	org/json/JSONException
    //   2263	2284	2386	org/json/JSONException
    //   2284	2305	2386	org/json/JSONException
    //   2307	2332	2386	org/json/JSONException
    //   2334	2361	2386	org/json/JSONException
    //   2363	2384	2386	org/json/JSONException
  }
  
  protected void onCreate()
  {
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
  }
  
  protected void onDestroy()
  {
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.HotchatPlugin
 * JD-Core Version:    0.7.0.1
 */