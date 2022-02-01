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
  public static final String a = HardCodeUtil.a(2131903548);
  public static final String b = HardCodeUtil.a(2131903546);
  protected static final int[] f = { 2131917673, 2131896951 };
  protected static final int[] g = { 2130844827, 2130844823 };
  TroopMemberApiClient c = null;
  AtomicBoolean d = new AtomicBoolean(false);
  protected PopupMenuDialog e;
  private HashMap<String, String> h = new HashMap();
  private OnRemoteRespObserver i = new HotchatPlugin.6(this);
  
  public HotchatPlugin()
  {
    this.mPluginNameSpace = "hotchat";
  }
  
  public void a(String paramString)
  {
    Activity localActivity = this.mRuntime.d();
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    while (j < f.length)
    {
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.id = j;
      localMenuItem.title = localActivity.getString(f[j]);
      localMenuItem.contentDescription = localMenuItem.title;
      localMenuItem.iconId = g[j];
      localArrayList.add(localMenuItem);
      j += 1;
    }
    if (this.e == null) {
      this.e = PopupMenuDialog.build(localActivity, localArrayList, new HotchatPlugin.7(this, paramString));
    }
    if (this.e.isShowing())
    {
      this.e.dismiss();
      return;
    }
    paramString = localActivity.findViewById(2131444897);
    this.e.showAsDropDown(paramString, paramString.getWidth() - localActivity.getResources().getDimensionPixelSize(2131299624) - localActivity.getResources().getDimensionPixelSize(2131299620), localActivity.getResources().getDimensionPixelSize(2131299621));
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +51 -> 54
    //   6: new 175	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   13: astore_1
    //   14: aload_1
    //   15: ldc 178
    //   17: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_1
    //   22: aload 4
    //   24: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_1
    //   29: ldc 184
    //   31: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_1
    //   36: aload 5
    //   38: iconst_0
    //   39: aaload
    //   40: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: ldc 186
    //   46: iconst_2
    //   47: aload_1
    //   48: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: ldc 69
    //   56: aload_3
    //   57: invokevirtual 199	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   60: ifeq +2379 -> 2439
    //   63: ldc 201
    //   65: aload 4
    //   67: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   99: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +35 -> 137
    //   105: new 175	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   112: astore_1
    //   113: aload_1
    //   114: ldc 201
    //   116: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_1
    //   121: aload 5
    //   123: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: ldc 186
    //   129: iconst_2
    //   130: aload_1
    //   131: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 209	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aload 5
    //   139: ifnull +126 -> 265
    //   142: aload 5
    //   144: arraylength
    //   145: ifle +120 -> 265
    //   148: new 211	org/json/JSONObject
    //   151: dup
    //   152: aload 5
    //   154: iconst_0
    //   155: aaload
    //   156: invokespecial 213	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   159: ldc 215
    //   161: invokevirtual 219	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   164: astore_1
    //   165: aload_0
    //   166: getfield 79	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   169: invokevirtual 84	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   172: astore_2
    //   173: aload_2
    //   174: ifnull +91 -> 265
    //   177: aload_2
    //   178: instanceof 221
    //   181: ifeq +84 -> 265
    //   184: aload_2
    //   185: checkcast 221	com/tencent/mobileqq/activity/INearbyActivity
    //   188: invokeinterface 225 1 0
    //   193: checkcast 227	com/tencent/mobileqq/fragment/NearbyBaseFragment
    //   196: astore_3
    //   197: aload_3
    //   198: ifnull +67 -> 265
    //   201: aload_3
    //   202: instanceof 229
    //   205: ifeq +60 -> 265
    //   208: aload_1
    //   209: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   212: ifeq +15 -> 227
    //   215: aload_3
    //   216: checkcast 229	com/tencent/mobileqq/activity/IHotChatFragment
    //   219: aconst_null
    //   220: invokeinterface 238 2 0
    //   225: iconst_1
    //   226: ireturn
    //   227: aload_3
    //   228: checkcast 229	com/tencent/mobileqq/activity/IHotChatFragment
    //   231: new 240	com/tencent/biz/webviewplugin/HotchatPlugin$1
    //   234: dup
    //   235: aload_0
    //   236: aload_1
    //   237: aload_2
    //   238: invokespecial 243	com/tencent/biz/webviewplugin/HotchatPlugin$1:<init>	(Lcom/tencent/biz/webviewplugin/HotchatPlugin;Ljava/lang/String;Landroid/app/Activity;)V
    //   241: invokeinterface 238 2 0
    //   246: iconst_1
    //   247: ireturn
    //   248: astore_1
    //   249: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   252: ifeq +13 -> 265
    //   255: ldc 186
    //   257: iconst_2
    //   258: aload_1
    //   259: invokevirtual 246	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   262: invokestatic 209	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: iconst_1
    //   266: ireturn
    //   267: ldc 248
    //   269: aload 4
    //   271: invokevirtual 199	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   274: ifeq +30 -> 304
    //   277: aload 5
    //   279: ifnull +23 -> 302
    //   282: aload 5
    //   284: arraylength
    //   285: ifle +17 -> 302
    //   288: aload_0
    //   289: getfield 79	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   292: invokevirtual 84	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   295: aload 5
    //   297: iconst_0
    //   298: aaload
    //   299: invokestatic 253	com/tencent/mobileqq/dating/NearbyTransitActivity:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   302: iconst_1
    //   303: ireturn
    //   304: ldc 255
    //   306: aload 4
    //   308: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   311: ifeq +25 -> 336
    //   314: aload_0
    //   315: getfield 79	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   318: invokevirtual 84	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   321: new 257	android/content/Intent
    //   324: dup
    //   325: ldc_w 259
    //   328: invokespecial 260	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   331: invokevirtual 264	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   334: iconst_0
    //   335: ireturn
    //   336: ldc_w 266
    //   339: aload 4
    //   341: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   344: ifeq +49 -> 393
    //   347: aload 5
    //   349: iconst_0
    //   350: aaload
    //   351: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   354: ifne +2085 -> 2439
    //   357: new 257	android/content/Intent
    //   360: dup
    //   361: ldc_w 268
    //   364: invokespecial 260	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   367: astore_1
    //   368: aload_1
    //   369: ldc_w 270
    //   372: aload 5
    //   374: iconst_0
    //   375: aaload
    //   376: invokevirtual 274	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   379: pop
    //   380: aload_0
    //   381: getfield 79	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   384: invokevirtual 84	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   387: aload_1
    //   388: invokevirtual 264	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   391: iconst_0
    //   392: ireturn
    //   393: ldc_w 276
    //   396: aload 4
    //   398: invokevirtual 199	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   401: ifeq +22 -> 423
    //   404: invokestatic 282	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   407: new 284	com/tencent/biz/webviewplugin/HotchatPlugin$2
    //   410: dup
    //   411: aload_0
    //   412: aload 5
    //   414: invokespecial 287	com/tencent/biz/webviewplugin/HotchatPlugin$2:<init>	(Lcom/tencent/biz/webviewplugin/HotchatPlugin;[Ljava/lang/String;)V
    //   417: invokevirtual 293	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   420: pop
    //   421: iconst_0
    //   422: ireturn
    //   423: ldc_w 295
    //   426: aload 4
    //   428: invokevirtual 199	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   431: istore 10
    //   433: ldc_w 297
    //   436: astore_3
    //   437: iload 10
    //   439: ifeq +161 -> 600
    //   442: ldc_w 299
    //   445: invokestatic 305	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   448: checkcast 299	com/tencent/mobileqq/nearby/api/INearbySPUtil
    //   451: aload_0
    //   452: getfield 79	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   455: invokevirtual 308	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   458: invokevirtual 313	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   461: ldc_w 315
    //   464: iconst_0
    //   465: invokestatic 321	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   468: invokeinterface 325 4 0
    //   473: checkcast 317	java/lang/Boolean
    //   476: invokevirtual 328	java/lang/Boolean:booleanValue	()Z
    //   479: istore 9
    //   481: aload 12
    //   483: astore_1
    //   484: aload 5
    //   486: ifnull +40 -> 526
    //   489: aload 12
    //   491: astore_1
    //   492: aload 5
    //   494: arraylength
    //   495: ifle +31 -> 526
    //   498: new 211	org/json/JSONObject
    //   501: dup
    //   502: aload 5
    //   504: iconst_0
    //   505: aaload
    //   506: invokespecial 213	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   509: ldc 215
    //   511: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   514: astore_1
    //   515: goto +11 -> 526
    //   518: astore_1
    //   519: aload_1
    //   520: invokevirtual 333	org/json/JSONException:printStackTrace	()V
    //   523: aload 12
    //   525: astore_1
    //   526: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   529: ifeq +35 -> 564
    //   532: new 175	java/lang/StringBuilder
    //   535: dup
    //   536: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   539: astore_2
    //   540: aload_2
    //   541: ldc_w 335
    //   544: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: aload_2
    //   549: aload_1
    //   550: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: ldc 186
    //   556: iconst_2
    //   557: aload_2
    //   558: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   564: aload_1
    //   565: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   568: ifne +1871 -> 2439
    //   571: iload 9
    //   573: ifeq +8 -> 581
    //   576: aload_3
    //   577: astore_2
    //   578: goto +7 -> 585
    //   581: ldc_w 337
    //   584: astore_2
    //   585: aload_0
    //   586: aload_1
    //   587: iconst_1
    //   588: anewarray 195	java/lang/String
    //   591: dup
    //   592: iconst_0
    //   593: aload_2
    //   594: aastore
    //   595: invokevirtual 341	com/tencent/biz/webviewplugin/HotchatPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   598: iconst_0
    //   599: ireturn
    //   600: ldc_w 343
    //   603: aload 4
    //   605: invokevirtual 199	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   608: ifeq +261 -> 869
    //   611: aload 5
    //   613: ifnull +99 -> 712
    //   616: aload 5
    //   618: arraylength
    //   619: ifle +93 -> 712
    //   622: new 211	org/json/JSONObject
    //   625: dup
    //   626: aload 5
    //   628: iconst_0
    //   629: aaload
    //   630: invokespecial 213	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   633: astore 4
    //   635: aload 4
    //   637: ldc 215
    //   639: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   642: astore_2
    //   643: aload 14
    //   645: astore_1
    //   646: aload 4
    //   648: ldc_w 345
    //   651: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   654: astore_3
    //   655: aload_3
    //   656: astore_1
    //   657: aload_3
    //   658: invokestatic 350	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   661: astore_3
    //   662: aload_3
    //   663: astore_1
    //   664: aload 4
    //   666: ldc_w 352
    //   669: invokevirtual 356	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   672: istore 6
    //   674: iload 6
    //   676: ifne +6 -> 682
    //   679: iconst_0
    //   680: istore 9
    //   682: aload_2
    //   683: astore_1
    //   684: aload_3
    //   685: astore_2
    //   686: goto +34 -> 720
    //   689: astore 4
    //   691: aload_2
    //   692: astore_3
    //   693: aload_1
    //   694: astore_2
    //   695: aload_3
    //   696: astore_1
    //   697: goto +7 -> 704
    //   700: astore 4
    //   702: aconst_null
    //   703: astore_2
    //   704: aload 4
    //   706: invokevirtual 333	org/json/JSONException:printStackTrace	()V
    //   709: goto +8 -> 717
    //   712: aconst_null
    //   713: astore_2
    //   714: aload 15
    //   716: astore_1
    //   717: iconst_0
    //   718: istore 9
    //   720: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   723: ifeq +64 -> 787
    //   726: new 175	java/lang/StringBuilder
    //   729: dup
    //   730: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   733: astore_3
    //   734: aload_3
    //   735: ldc_w 335
    //   738: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: aload_3
    //   743: aload_1
    //   744: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload_3
    //   749: ldc_w 358
    //   752: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: aload_3
    //   757: aload_2
    //   758: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: pop
    //   762: aload_3
    //   763: ldc_w 360
    //   766: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: pop
    //   770: aload_3
    //   771: iload 9
    //   773: invokevirtual 363	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   776: pop
    //   777: ldc 186
    //   779: iconst_2
    //   780: aload_3
    //   781: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   784: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   787: aload_2
    //   788: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   791: ifne +1648 -> 2439
    //   794: aload_1
    //   795: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   798: ifne +1641 -> 2439
    //   801: new 365	android/os/Bundle
    //   804: dup
    //   805: invokespecial 366	android/os/Bundle:<init>	()V
    //   808: astore_3
    //   809: aload_3
    //   810: ldc_w 368
    //   813: aload_2
    //   814: invokevirtual 372	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   817: aload_3
    //   818: ldc_w 374
    //   821: ldc_w 343
    //   824: invokevirtual 372	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   827: aload_3
    //   828: ldc_w 376
    //   831: iload 9
    //   833: invokevirtual 380	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   836: ldc_w 382
    //   839: aload_1
    //   840: aload_0
    //   841: getfield 67	com/tencent/biz/webviewplugin/HotchatPlugin:i	Lcom/tencent/mobileqq/emosm/OnRemoteRespObserver;
    //   844: getfield 387	com/tencent/mobileqq/emosm/OnRemoteRespObserver:key	I
    //   847: aload_3
    //   848: invokestatic 392	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   851: astore_1
    //   852: ldc_w 394
    //   855: invokestatic 305	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   858: checkcast 394	com/tencent/mobileqq/emosm/api/IWebIPCOperatorApi
    //   861: aload_1
    //   862: invokeinterface 398 2 0
    //   867: iconst_0
    //   868: ireturn
    //   869: ldc_w 400
    //   872: aload 4
    //   874: invokevirtual 199	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   877: ifeq +304 -> 1181
    //   880: aload_0
    //   881: getfield 79	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   884: invokevirtual 308	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   887: astore 12
    //   889: aload 5
    //   891: ifnull +93 -> 984
    //   894: aload 5
    //   896: arraylength
    //   897: ifle +87 -> 984
    //   900: new 211	org/json/JSONObject
    //   903: dup
    //   904: aload 5
    //   906: iconst_0
    //   907: aaload
    //   908: invokespecial 213	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   911: astore 4
    //   913: aload 4
    //   915: ldc_w 402
    //   918: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   921: astore_3
    //   922: aload 13
    //   924: astore_1
    //   925: aload 4
    //   927: ldc_w 404
    //   930: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   933: astore_2
    //   934: aload_2
    //   935: astore_1
    //   936: aload 4
    //   938: ldc_w 406
    //   941: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   944: astore 4
    //   946: aload 4
    //   948: astore_1
    //   949: goto +44 -> 993
    //   952: astore 4
    //   954: aload_3
    //   955: astore_2
    //   956: aload 4
    //   958: astore_3
    //   959: goto +6 -> 965
    //   962: astore_3
    //   963: aconst_null
    //   964: astore_1
    //   965: aload_3
    //   966: invokevirtual 407	java/lang/Exception:printStackTrace	()V
    //   969: ldc_w 409
    //   972: astore 4
    //   974: aload_2
    //   975: astore_3
    //   976: aload_1
    //   977: astore_2
    //   978: aload 4
    //   980: astore_1
    //   981: goto +12 -> 993
    //   984: ldc_w 409
    //   987: astore_1
    //   988: aconst_null
    //   989: astore_3
    //   990: aload 11
    //   992: astore_2
    //   993: aload 12
    //   995: ifnull +112 -> 1107
    //   998: aload_2
    //   999: ifnull +108 -> 1107
    //   1002: aload_3
    //   1003: ifnull +104 -> 1107
    //   1006: ldc_w 411
    //   1009: aload_3
    //   1010: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1013: ifeq +63 -> 1076
    //   1016: ldc_w 299
    //   1019: invokestatic 305	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1022: checkcast 299	com/tencent/mobileqq/nearby/api/INearbySPUtil
    //   1025: aload 12
    //   1027: invokevirtual 414	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1030: ldc_w 416
    //   1033: aload_2
    //   1034: invokeinterface 420 4 0
    //   1039: pop
    //   1040: ldc_w 299
    //   1043: invokestatic 305	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1046: checkcast 299	com/tencent/mobileqq/nearby/api/INearbySPUtil
    //   1049: aload 12
    //   1051: invokevirtual 414	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1054: ldc_w 422
    //   1057: ldc_w 409
    //   1060: aload_1
    //   1061: invokevirtual 425	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1064: invokestatic 321	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1067: invokeinterface 420 4 0
    //   1072: pop
    //   1073: goto +34 -> 1107
    //   1076: aload_2
    //   1077: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1080: ifne +27 -> 1107
    //   1083: ldc_w 299
    //   1086: invokestatic 305	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1089: checkcast 299	com/tencent/mobileqq/nearby/api/INearbySPUtil
    //   1092: aload 12
    //   1094: invokevirtual 414	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1097: ldc_w 427
    //   1100: aload_2
    //   1101: invokeinterface 420 4 0
    //   1106: pop
    //   1107: invokestatic 431	com/tencent/mobileqq/nearby/NearbyUtils:b	()Z
    //   1110: ifeq +1329 -> 2439
    //   1113: aload 5
    //   1115: ifnull +21 -> 1136
    //   1118: aload 5
    //   1120: arraylength
    //   1121: ifne +6 -> 1127
    //   1124: goto +12 -> 1136
    //   1127: aload 5
    //   1129: iconst_0
    //   1130: aaload
    //   1131: astore 4
    //   1133: goto +8 -> 1141
    //   1136: ldc_w 433
    //   1139: astore 4
    //   1141: ldc 186
    //   1143: bipush 6
    //   1145: anewarray 435	java/lang/Object
    //   1148: dup
    //   1149: iconst_0
    //   1150: ldc_w 400
    //   1153: aastore
    //   1154: dup
    //   1155: iconst_1
    //   1156: aload 12
    //   1158: aastore
    //   1159: dup
    //   1160: iconst_2
    //   1161: aload_3
    //   1162: aastore
    //   1163: dup
    //   1164: iconst_3
    //   1165: aload_2
    //   1166: aastore
    //   1167: dup
    //   1168: iconst_4
    //   1169: aload_1
    //   1170: aastore
    //   1171: dup
    //   1172: iconst_5
    //   1173: aload 4
    //   1175: aastore
    //   1176: invokestatic 438	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1179: iconst_0
    //   1180: ireturn
    //   1181: ldc_w 440
    //   1184: aload 4
    //   1186: invokevirtual 199	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1189: ifeq +279 -> 1468
    //   1192: aload_0
    //   1193: getfield 79	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1196: invokevirtual 308	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   1199: astore 4
    //   1201: aload 5
    //   1203: ifnull +117 -> 1320
    //   1206: aload 5
    //   1208: arraylength
    //   1209: ifle +111 -> 1320
    //   1212: new 211	org/json/JSONObject
    //   1215: dup
    //   1216: aload 5
    //   1218: iconst_0
    //   1219: aaload
    //   1220: invokespecial 213	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1223: astore_2
    //   1224: aload_2
    //   1225: ldc_w 442
    //   1228: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1231: astore_1
    //   1232: aload_2
    //   1233: ldc_w 444
    //   1236: invokevirtual 356	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1239: istore 7
    //   1241: aload_2
    //   1242: ldc_w 446
    //   1245: invokevirtual 356	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1248: istore 6
    //   1250: aload_2
    //   1251: ldc 215
    //   1253: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1256: astore_3
    //   1257: aload_1
    //   1258: astore_2
    //   1259: iload 6
    //   1261: istore 8
    //   1263: aload_3
    //   1264: astore_1
    //   1265: iload 7
    //   1267: istore 6
    //   1269: iload 8
    //   1271: istore 7
    //   1273: goto +57 -> 1330
    //   1276: astore_2
    //   1277: goto +20 -> 1297
    //   1280: astore_2
    //   1281: goto +13 -> 1294
    //   1284: astore_2
    //   1285: goto +6 -> 1291
    //   1288: astore_2
    //   1289: aconst_null
    //   1290: astore_1
    //   1291: iconst_0
    //   1292: istore 7
    //   1294: iconst_0
    //   1295: istore 6
    //   1297: aload_2
    //   1298: invokevirtual 407	java/lang/Exception:printStackTrace	()V
    //   1301: aload_1
    //   1302: astore_2
    //   1303: iload 6
    //   1305: istore 8
    //   1307: aconst_null
    //   1308: astore_1
    //   1309: iload 7
    //   1311: istore 6
    //   1313: iload 8
    //   1315: istore 7
    //   1317: goto +13 -> 1330
    //   1320: aconst_null
    //   1321: astore_1
    //   1322: aload_1
    //   1323: astore_2
    //   1324: iconst_0
    //   1325: istore 6
    //   1327: iconst_0
    //   1328: istore 7
    //   1330: aload_2
    //   1331: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1334: ifeq +75 -> 1409
    //   1337: new 211	org/json/JSONObject
    //   1340: dup
    //   1341: invokespecial 447	org/json/JSONObject:<init>	()V
    //   1344: astore_3
    //   1345: aload_3
    //   1346: ldc_w 449
    //   1349: iconst_m1
    //   1350: invokevirtual 453	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1353: pop
    //   1354: aload_3
    //   1355: ldc_w 455
    //   1358: ldc_w 457
    //   1361: invokevirtual 460	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1364: pop
    //   1365: aload_3
    //   1366: ldc_w 462
    //   1369: ldc_w 464
    //   1372: invokevirtual 460	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1375: pop
    //   1376: aload_3
    //   1377: invokevirtual 465	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1380: astore_3
    //   1381: goto +12 -> 1393
    //   1384: astore_3
    //   1385: aload_3
    //   1386: invokevirtual 407	java/lang/Exception:printStackTrace	()V
    //   1389: ldc_w 457
    //   1392: astore_3
    //   1393: aload_0
    //   1394: aload_1
    //   1395: iconst_1
    //   1396: anewarray 195	java/lang/String
    //   1399: dup
    //   1400: iconst_0
    //   1401: aload_3
    //   1402: aastore
    //   1403: invokevirtual 341	com/tencent/biz/webviewplugin/HotchatPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1406: goto +15 -> 1421
    //   1409: aload 4
    //   1411: iload 6
    //   1413: iload 7
    //   1415: aload_2
    //   1416: aload_0
    //   1417: aload_1
    //   1418: invokestatic 470	com/tencent/mobileqq/nearby/NearbyAlumniServletUtils:a	(Lcom/tencent/common/app/AppInterface;IILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V
    //   1421: invokestatic 431	com/tencent/mobileqq/nearby/NearbyUtils:b	()Z
    //   1424: ifeq +1015 -> 2439
    //   1427: ldc 186
    //   1429: iconst_5
    //   1430: anewarray 435	java/lang/Object
    //   1433: dup
    //   1434: iconst_0
    //   1435: ldc_w 440
    //   1438: aastore
    //   1439: dup
    //   1440: iconst_1
    //   1441: iload 6
    //   1443: invokestatic 475	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1446: aastore
    //   1447: dup
    //   1448: iconst_2
    //   1449: iload 7
    //   1451: invokestatic 475	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1454: aastore
    //   1455: dup
    //   1456: iconst_3
    //   1457: aload_2
    //   1458: aastore
    //   1459: dup
    //   1460: iconst_4
    //   1461: aload_1
    //   1462: aastore
    //   1463: invokestatic 438	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1466: iconst_0
    //   1467: ireturn
    //   1468: ldc_w 477
    //   1471: aload 4
    //   1473: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1476: ifeq +133 -> 1609
    //   1479: aload 5
    //   1481: ifnull +126 -> 1607
    //   1484: aload 5
    //   1486: arraylength
    //   1487: ifle +120 -> 1607
    //   1490: new 211	org/json/JSONObject
    //   1493: dup
    //   1494: aload 5
    //   1496: iconst_0
    //   1497: aaload
    //   1498: invokespecial 213	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1501: ldc 215
    //   1503: invokevirtual 219	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1506: astore_1
    //   1507: aload_0
    //   1508: getfield 79	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1511: invokevirtual 84	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   1514: astore_2
    //   1515: aload_2
    //   1516: ifnull +91 -> 1607
    //   1519: aload_2
    //   1520: instanceof 221
    //   1523: ifeq +84 -> 1607
    //   1526: aload_2
    //   1527: checkcast 221	com/tencent/mobileqq/activity/INearbyActivity
    //   1530: invokeinterface 225 1 0
    //   1535: checkcast 227	com/tencent/mobileqq/fragment/NearbyBaseFragment
    //   1538: astore_3
    //   1539: aload_3
    //   1540: ifnull +67 -> 1607
    //   1543: aload_3
    //   1544: instanceof 229
    //   1547: ifeq +60 -> 1607
    //   1550: aload_1
    //   1551: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1554: ifeq +15 -> 1569
    //   1557: aload_3
    //   1558: checkcast 229	com/tencent/mobileqq/activity/IHotChatFragment
    //   1561: aconst_null
    //   1562: invokeinterface 238 2 0
    //   1567: iconst_1
    //   1568: ireturn
    //   1569: aload_3
    //   1570: checkcast 229	com/tencent/mobileqq/activity/IHotChatFragment
    //   1573: new 479	com/tencent/biz/webviewplugin/HotchatPlugin$3
    //   1576: dup
    //   1577: aload_0
    //   1578: aload_1
    //   1579: aload_2
    //   1580: invokespecial 480	com/tencent/biz/webviewplugin/HotchatPlugin$3:<init>	(Lcom/tencent/biz/webviewplugin/HotchatPlugin;Ljava/lang/String;Landroid/app/Activity;)V
    //   1583: invokeinterface 238 2 0
    //   1588: iconst_1
    //   1589: ireturn
    //   1590: astore_1
    //   1591: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1594: ifeq +13 -> 1607
    //   1597: ldc 186
    //   1599: iconst_2
    //   1600: aload_1
    //   1601: invokevirtual 246	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1604: invokestatic 209	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1607: iconst_1
    //   1608: ireturn
    //   1609: ldc_w 482
    //   1612: aload 4
    //   1614: invokevirtual 199	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1617: ifeq +171 -> 1788
    //   1620: aload 5
    //   1622: ifnull +817 -> 2439
    //   1625: aload 5
    //   1627: arraylength
    //   1628: ifle +811 -> 2439
    //   1631: new 211	org/json/JSONObject
    //   1634: dup
    //   1635: aload 5
    //   1637: iconst_0
    //   1638: aaload
    //   1639: invokespecial 213	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1642: astore_1
    //   1643: aload_1
    //   1644: ldc_w 484
    //   1647: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1650: astore_3
    //   1651: aload_1
    //   1652: ldc_w 486
    //   1655: invokevirtual 490	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1658: astore 4
    //   1660: iconst_0
    //   1661: istore 6
    //   1663: iload 6
    //   1665: aload 4
    //   1667: invokevirtual 495	org/json/JSONArray:length	()I
    //   1670: if_icmpge +769 -> 2439
    //   1673: aload 4
    //   1675: iload 6
    //   1677: invokevirtual 499	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   1680: checkcast 211	org/json/JSONObject
    //   1683: astore_1
    //   1684: aload_1
    //   1685: ldc_w 501
    //   1688: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1691: astore 5
    //   1693: aload_1
    //   1694: ldc_w 503
    //   1697: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1700: astore_2
    //   1701: aload_1
    //   1702: ldc_w 505
    //   1705: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1708: astore 11
    //   1710: aload_2
    //   1711: astore_1
    //   1712: aload_2
    //   1713: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1716: ifeq +26 -> 1742
    //   1719: aload_2
    //   1720: astore_1
    //   1721: aload 5
    //   1723: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1726: ifne +16 -> 1742
    //   1729: aload_0
    //   1730: getfield 51	com/tencent/biz/webviewplugin/HotchatPlugin:h	Ljava/util/HashMap;
    //   1733: aload 5
    //   1735: invokevirtual 508	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1738: checkcast 195	java/lang/String
    //   1741: astore_1
    //   1742: aload_1
    //   1743: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1746: ifne +14 -> 1760
    //   1749: aload_0
    //   1750: getfield 53	com/tencent/biz/webviewplugin/HotchatPlugin:c	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1753: aload_3
    //   1754: aload_1
    //   1755: aload 11
    //   1757: invokevirtual 513	com/tencent/biz/troop/TroopMemberApiClient:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1760: iload 6
    //   1762: iconst_1
    //   1763: iadd
    //   1764: istore 6
    //   1766: goto -103 -> 1663
    //   1769: astore_1
    //   1770: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1773: ifeq +666 -> 2439
    //   1776: ldc 186
    //   1778: iconst_2
    //   1779: aload_1
    //   1780: invokevirtual 246	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1783: invokestatic 209	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1786: iconst_0
    //   1787: ireturn
    //   1788: ldc_w 515
    //   1791: aload 4
    //   1793: invokevirtual 199	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1796: ifeq +88 -> 1884
    //   1799: aload 5
    //   1801: ifnull +638 -> 2439
    //   1804: aload 5
    //   1806: arraylength
    //   1807: ifle +632 -> 2439
    //   1810: new 211	org/json/JSONObject
    //   1813: dup
    //   1814: aload 5
    //   1816: iconst_0
    //   1817: aaload
    //   1818: invokespecial 213	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1821: astore_3
    //   1822: aload_3
    //   1823: ldc 215
    //   1825: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1828: astore_1
    //   1829: aload_3
    //   1830: ldc_w 484
    //   1833: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1836: astore_2
    //   1837: aload_3
    //   1838: ldc_w 517
    //   1841: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1844: astore_3
    //   1845: aload_0
    //   1846: getfield 53	com/tencent/biz/webviewplugin/HotchatPlugin:c	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1849: aload_2
    //   1850: aload_3
    //   1851: new 519	com/tencent/biz/webviewplugin/HotchatPlugin$4
    //   1854: dup
    //   1855: aload_0
    //   1856: aload_1
    //   1857: invokespecial 520	com/tencent/biz/webviewplugin/HotchatPlugin$4:<init>	(Lcom/tencent/biz/webviewplugin/HotchatPlugin;Ljava/lang/String;)V
    //   1860: invokevirtual 523	com/tencent/biz/troop/TroopMemberApiClient:c	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi$Callback;)V
    //   1863: iconst_0
    //   1864: ireturn
    //   1865: astore_1
    //   1866: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1869: ifeq +570 -> 2439
    //   1872: ldc 186
    //   1874: iconst_2
    //   1875: aload_1
    //   1876: invokevirtual 246	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1879: invokestatic 209	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1882: iconst_0
    //   1883: ireturn
    //   1884: ldc_w 525
    //   1887: aload 4
    //   1889: invokevirtual 199	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1892: ifeq +126 -> 2018
    //   1895: new 86	java/util/ArrayList
    //   1898: dup
    //   1899: invokespecial 87	java/util/ArrayList:<init>	()V
    //   1902: astore_1
    //   1903: aload 5
    //   1905: ifnull +534 -> 2439
    //   1908: aload 5
    //   1910: arraylength
    //   1911: ifle +528 -> 2439
    //   1914: new 211	org/json/JSONObject
    //   1917: dup
    //   1918: aload 5
    //   1920: iconst_0
    //   1921: aaload
    //   1922: invokespecial 213	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1925: astore_2
    //   1926: aload_2
    //   1927: ldc 215
    //   1929: invokevirtual 219	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1932: pop
    //   1933: aload_2
    //   1934: ldc_w 484
    //   1937: invokevirtual 219	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1940: pop
    //   1941: aload_2
    //   1942: ldc_w 527
    //   1945: invokevirtual 490	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1948: astore_2
    //   1949: iconst_0
    //   1950: istore 6
    //   1952: iload 6
    //   1954: aload_2
    //   1955: invokevirtual 495	org/json/JSONArray:length	()I
    //   1958: if_icmpge +23 -> 1981
    //   1961: aload_1
    //   1962: aload_2
    //   1963: iload 6
    //   1965: invokevirtual 528	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1968: invokevirtual 529	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1971: pop
    //   1972: iload 6
    //   1974: iconst_1
    //   1975: iadd
    //   1976: istore 6
    //   1978: goto -26 -> 1952
    //   1981: aload_0
    //   1982: getfield 53	com/tencent/biz/webviewplugin/HotchatPlugin:c	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1985: aload_1
    //   1986: new 531	com/tencent/biz/webviewplugin/HotchatPlugin$5
    //   1989: dup
    //   1990: aload_0
    //   1991: invokespecial 532	com/tencent/biz/webviewplugin/HotchatPlugin$5:<init>	(Lcom/tencent/biz/webviewplugin/HotchatPlugin;)V
    //   1994: invokevirtual 535	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/util/ArrayList;Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi$Callback;)V
    //   1997: iconst_0
    //   1998: ireturn
    //   1999: astore_1
    //   2000: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2003: ifeq +436 -> 2439
    //   2006: ldc 186
    //   2008: iconst_2
    //   2009: aload_1
    //   2010: invokevirtual 246	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2013: invokestatic 209	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2016: iconst_0
    //   2017: ireturn
    //   2018: ldc_w 537
    //   2021: aload 4
    //   2023: invokevirtual 199	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2026: ifeq +60 -> 2086
    //   2029: aload 5
    //   2031: ifnull +408 -> 2439
    //   2034: aload 5
    //   2036: arraylength
    //   2037: ifle +402 -> 2439
    //   2040: new 211	org/json/JSONObject
    //   2043: dup
    //   2044: aload 5
    //   2046: iconst_0
    //   2047: aaload
    //   2048: invokespecial 213	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2051: ldc_w 484
    //   2054: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2057: pop
    //   2058: aload_0
    //   2059: getfield 51	com/tencent/biz/webviewplugin/HotchatPlugin:h	Ljava/util/HashMap;
    //   2062: invokevirtual 540	java/util/HashMap:clear	()V
    //   2065: iconst_0
    //   2066: ireturn
    //   2067: astore_1
    //   2068: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2071: ifeq +368 -> 2439
    //   2074: ldc 186
    //   2076: iconst_2
    //   2077: aload_1
    //   2078: invokevirtual 246	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2081: invokestatic 209	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2084: iconst_0
    //   2085: ireturn
    //   2086: ldc_w 542
    //   2089: aload 4
    //   2091: invokevirtual 199	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2094: ifeq +73 -> 2167
    //   2097: aload_0
    //   2098: getfield 79	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2101: invokevirtual 84	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   2104: astore_1
    //   2105: aload 5
    //   2107: ifnull +332 -> 2439
    //   2110: aload 5
    //   2112: arraylength
    //   2113: ifle +326 -> 2439
    //   2116: new 211	org/json/JSONObject
    //   2119: dup
    //   2120: aload 5
    //   2122: iconst_0
    //   2123: aaload
    //   2124: invokespecial 213	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2127: ldc_w 484
    //   2130: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2133: astore_2
    //   2134: aload_0
    //   2135: getfield 53	com/tencent/biz/webviewplugin/HotchatPlugin:c	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   2138: aload_2
    //   2139: invokevirtual 544	com/tencent/biz/troop/TroopMemberApiClient:d	(Ljava/lang/String;)V
    //   2142: aload_1
    //   2143: invokevirtual 547	android/app/Activity:finish	()V
    //   2146: iconst_0
    //   2147: ireturn
    //   2148: astore_1
    //   2149: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2152: ifeq +287 -> 2439
    //   2155: ldc 186
    //   2157: iconst_2
    //   2158: aload_1
    //   2159: invokevirtual 246	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2162: invokestatic 209	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2165: iconst_0
    //   2166: ireturn
    //   2167: ldc_w 549
    //   2170: aload 4
    //   2172: invokevirtual 199	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2175: ifeq +231 -> 2406
    //   2178: aload 5
    //   2180: ifnull +259 -> 2439
    //   2183: aload 5
    //   2185: arraylength
    //   2186: ifle +253 -> 2439
    //   2189: new 211	org/json/JSONObject
    //   2192: dup
    //   2193: aload 5
    //   2195: iconst_0
    //   2196: aaload
    //   2197: invokespecial 213	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2200: astore_1
    //   2201: aload_0
    //   2202: getfield 79	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2205: invokevirtual 84	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   2208: astore_3
    //   2209: aload_1
    //   2210: ldc_w 551
    //   2213: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2216: astore 4
    //   2218: aload_1
    //   2219: ldc_w 503
    //   2222: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2225: astore_2
    //   2226: aload_1
    //   2227: ldc_w 501
    //   2230: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2233: astore 11
    //   2235: aload_1
    //   2236: ldc_w 505
    //   2239: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2242: astore 5
    //   2244: aload_1
    //   2245: ldc_w 484
    //   2248: invokevirtual 330	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2251: astore 12
    //   2253: aload_2
    //   2254: astore_1
    //   2255: aload_2
    //   2256: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2259: ifeq +26 -> 2285
    //   2262: aload_2
    //   2263: astore_1
    //   2264: aload 11
    //   2266: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2269: ifne +16 -> 2285
    //   2272: aload_0
    //   2273: getfield 51	com/tencent/biz/webviewplugin/HotchatPlugin:h	Ljava/util/HashMap;
    //   2276: aload 11
    //   2278: invokevirtual 508	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2281: checkcast 195	java/lang/String
    //   2284: astore_1
    //   2285: aload_1
    //   2286: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2289: ifeq +19 -> 2308
    //   2292: invokestatic 557	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2295: getstatic 34	com/tencent/biz/webviewplugin/HotchatPlugin:b	Ljava/lang/String;
    //   2298: iconst_0
    //   2299: invokestatic 563	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   2302: invokevirtual 567	com/tencent/mobileqq/widget/QQToast:show	()Landroid/widget/Toast;
    //   2305: pop
    //   2306: iconst_0
    //   2307: ireturn
    //   2308: aload 4
    //   2310: ldc_w 337
    //   2313: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2316: ifeq +19 -> 2335
    //   2319: aload_0
    //   2320: getfield 53	com/tencent/biz/webviewplugin/HotchatPlugin:c	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   2323: aload 12
    //   2325: aload_1
    //   2326: invokevirtual 569	com/tencent/biz/troop/TroopMemberApiClient:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   2329: aload_3
    //   2330: invokevirtual 547	android/app/Activity:finish	()V
    //   2333: iconst_0
    //   2334: ireturn
    //   2335: aload 4
    //   2337: ldc_w 297
    //   2340: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2343: ifeq +21 -> 2364
    //   2346: aload_0
    //   2347: getfield 53	com/tencent/biz/webviewplugin/HotchatPlugin:c	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   2350: aload 12
    //   2352: aload_1
    //   2353: aload 5
    //   2355: invokevirtual 571	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2358: aload_3
    //   2359: invokevirtual 547	android/app/Activity:finish	()V
    //   2362: iconst_0
    //   2363: ireturn
    //   2364: aload 4
    //   2366: ldc_w 573
    //   2369: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2372: ifeq +67 -> 2439
    //   2375: aload_0
    //   2376: getfield 53	com/tencent/biz/webviewplugin/HotchatPlugin:c	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   2379: aload 12
    //   2381: aload_1
    //   2382: invokevirtual 575	com/tencent/biz/troop/TroopMemberApiClient:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   2385: iconst_0
    //   2386: ireturn
    //   2387: astore_1
    //   2388: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2391: ifeq +48 -> 2439
    //   2394: ldc 186
    //   2396: iconst_2
    //   2397: aload_1
    //   2398: invokevirtual 246	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2401: invokestatic 209	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2404: iconst_0
    //   2405: ireturn
    //   2406: new 175	java/lang/StringBuilder
    //   2409: dup
    //   2410: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   2413: astore_1
    //   2414: aload_1
    //   2415: ldc_w 577
    //   2418: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2421: pop
    //   2422: aload_1
    //   2423: aload 4
    //   2425: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2428: pop
    //   2429: ldc 186
    //   2431: iconst_1
    //   2432: aload_1
    //   2433: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2436: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2439: iconst_0
    //   2440: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2441	0	this	HotchatPlugin
    //   0	2441	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2441	2	paramString1	String
    //   0	2441	3	paramString2	String
    //   0	2441	4	paramString3	String
    //   0	2441	5	paramVarArgs	String[]
    //   672	1305	6	j	int
    //   1239	211	7	k	int
    //   1261	53	8	m	int
    //   92	740	9	bool1	boolean
    //   70	368	10	bool2	boolean
    //   86	2191	11	str	String
    //   89	2291	12	localObject1	java.lang.Object
    //   81	842	13	localObject2	java.lang.Object
    //   73	571	14	localObject3	java.lang.Object
    //   78	637	15	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   148	173	248	org/json/JSONException
    //   177	197	248	org/json/JSONException
    //   201	225	248	org/json/JSONException
    //   227	246	248	org/json/JSONException
    //   498	515	518	org/json/JSONException
    //   646	655	689	org/json/JSONException
    //   657	662	689	org/json/JSONException
    //   664	674	689	org/json/JSONException
    //   622	643	700	org/json/JSONException
    //   925	934	952	java/lang/Exception
    //   936	946	952	java/lang/Exception
    //   900	922	962	java/lang/Exception
    //   1250	1257	1276	java/lang/Exception
    //   1241	1250	1280	java/lang/Exception
    //   1232	1241	1284	java/lang/Exception
    //   1212	1232	1288	java/lang/Exception
    //   1337	1381	1384	java/lang/Exception
    //   1490	1515	1590	org/json/JSONException
    //   1519	1539	1590	org/json/JSONException
    //   1543	1567	1590	org/json/JSONException
    //   1569	1588	1590	org/json/JSONException
    //   1631	1660	1769	org/json/JSONException
    //   1663	1710	1769	org/json/JSONException
    //   1712	1719	1769	org/json/JSONException
    //   1721	1742	1769	org/json/JSONException
    //   1742	1760	1769	org/json/JSONException
    //   1810	1863	1865	org/json/JSONException
    //   1914	1949	1999	org/json/JSONException
    //   1952	1972	1999	org/json/JSONException
    //   1981	1997	1999	org/json/JSONException
    //   2040	2065	2067	org/json/JSONException
    //   2116	2146	2148	org/json/JSONException
    //   2189	2253	2387	org/json/JSONException
    //   2255	2262	2387	org/json/JSONException
    //   2264	2285	2387	org/json/JSONException
    //   2285	2306	2387	org/json/JSONException
    //   2308	2333	2387	org/json/JSONException
    //   2335	2362	2387	org/json/JSONException
    //   2364	2385	2387	org/json/JSONException
  }
  
  protected void onCreate()
  {
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.i);
    if (this.d.compareAndSet(false, true))
    {
      this.c = TroopMemberApiClient.a();
      this.c.e();
    }
  }
  
  protected void onDestroy()
  {
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.i);
    if (this.d.get()) {
      this.c.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.HotchatPlugin
 * JD-Core Version:    0.7.0.1
 */