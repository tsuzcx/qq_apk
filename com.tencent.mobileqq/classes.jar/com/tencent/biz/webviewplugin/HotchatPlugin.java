package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import pbi;
import pbj;

public class HotchatPlugin
  extends WebViewPlugin
{
  protected static final int[] a;
  protected static final int[] b = { 2130841312, 2130841308 };
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  private Client.onRemoteRespObserver jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver = new pbi(this);
  protected PopupMenuDialog a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131429688, 2131429689 };
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
      localMenuItem.jdField_a_of_type_Int = i;
      localMenuItem.jdField_a_of_type_JavaLangString = localActivity.getString(jdField_a_of_type_ArrayOfInt[i]);
      localMenuItem.c = localMenuItem.jdField_a_of_type_JavaLangString;
      localMenuItem.b = b[i];
      localArrayList.add(localMenuItem);
      i += 1;
    }
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog == null) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(localActivity, localArrayList, new pbj(this, paramString));
    }
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing())
    {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
      return;
    }
    paramString = localActivity.findViewById(2131363244);
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(paramString, paramString.getWidth() - localActivity.getResources().getDimensionPixelSize(2131558949) - localActivity.getResources().getDimensionPixelSize(2131558953), localActivity.getResources().getDimensionPixelSize(2131558954));
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +41 -> 44
    //   6: ldc 153
    //   8: iconst_2
    //   9: new 155	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   16: ldc 158
    //   18: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload 4
    //   23: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 164
    //   28: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload 5
    //   33: iconst_0
    //   34: aaload
    //   35: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: ldc 49
    //   46: aload_3
    //   47: invokevirtual 178	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   50: ifeq +235 -> 285
    //   53: ldc 180
    //   55: aload 4
    //   57: invokevirtual 183	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   60: ifeq +159 -> 219
    //   63: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +29 -> 95
    //   69: ldc 153
    //   71: iconst_2
    //   72: new 155	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   79: ldc 180
    //   81: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 5
    //   86: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 189	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aload 5
    //   97: ifnull +2338 -> 2435
    //   100: aload 5
    //   102: arraylength
    //   103: ifle +2332 -> 2435
    //   106: new 191	org/json/JSONObject
    //   109: dup
    //   110: aload 5
    //   112: iconst_0
    //   113: aaload
    //   114: invokespecial 193	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   117: ldc 195
    //   119: invokevirtual 199	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   122: astore_1
    //   123: aload_0
    //   124: getfield 60	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   127: invokevirtual 65	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   130: astore_2
    //   131: aload_2
    //   132: ifnull +2303 -> 2435
    //   135: aload_2
    //   136: instanceof 201
    //   139: ifeq +2296 -> 2435
    //   142: aload_2
    //   143: checkcast 201	com/tencent/mobileqq/activity/NearbyActivity
    //   146: invokevirtual 204	com/tencent/mobileqq/activity/NearbyActivity:a	()Lcom/tencent/mobileqq/fragment/HotChatFragment;
    //   149: astore_3
    //   150: aload_3
    //   151: ifnull +2284 -> 2435
    //   154: aload_3
    //   155: instanceof 206
    //   158: ifeq +2277 -> 2435
    //   161: aload_1
    //   162: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   165: ifeq +14 -> 179
    //   168: aload_3
    //   169: checkcast 206	com/tencent/mobileqq/fragment/HotChatFragment
    //   172: aconst_null
    //   173: invokevirtual 215	com/tencent/mobileqq/fragment/HotChatFragment:a	(Landroid/view/View$OnClickListener;)V
    //   176: goto +2259 -> 2435
    //   179: aload_3
    //   180: checkcast 206	com/tencent/mobileqq/fragment/HotChatFragment
    //   183: new 217	pbd
    //   186: dup
    //   187: aload_0
    //   188: aload_1
    //   189: aload_2
    //   190: invokespecial 220	pbd:<init>	(Lcom/tencent/biz/webviewplugin/HotchatPlugin;Ljava/lang/String;Landroid/app/Activity;)V
    //   193: invokevirtual 215	com/tencent/mobileqq/fragment/HotChatFragment:a	(Landroid/view/View$OnClickListener;)V
    //   196: goto +2239 -> 2435
    //   199: astore_1
    //   200: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   203: ifeq +2232 -> 2435
    //   206: ldc 153
    //   208: iconst_2
    //   209: aload_1
    //   210: invokevirtual 223	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   213: invokestatic 189	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: goto +2219 -> 2435
    //   219: ldc 225
    //   221: aload 4
    //   223: invokevirtual 178	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   226: ifeq +30 -> 256
    //   229: aload 5
    //   231: ifnull +23 -> 254
    //   234: aload 5
    //   236: arraylength
    //   237: ifle +17 -> 254
    //   240: aload_0
    //   241: getfield 60	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   244: invokevirtual 65	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   247: aload 5
    //   249: iconst_0
    //   250: aaload
    //   251: invokestatic 230	com/tencent/mobileqq/dating/NearbyTransitActivity:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   254: iconst_1
    //   255: ireturn
    //   256: ldc 232
    //   258: aload 4
    //   260: invokevirtual 183	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   263: ifeq +24 -> 287
    //   266: aload_0
    //   267: getfield 60	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   270: invokevirtual 65	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   273: new 234	android/content/Intent
    //   276: dup
    //   277: ldc 236
    //   279: invokespecial 237	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   282: invokevirtual 241	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   285: iconst_0
    //   286: ireturn
    //   287: ldc 243
    //   289: aload 4
    //   291: invokevirtual 183	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   294: ifeq +48 -> 342
    //   297: aload 5
    //   299: iconst_0
    //   300: aaload
    //   301: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   304: ifne -19 -> 285
    //   307: new 234	android/content/Intent
    //   310: dup
    //   311: ldc 245
    //   313: invokespecial 237	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   316: astore_1
    //   317: aload_1
    //   318: ldc 247
    //   320: aload 5
    //   322: iconst_0
    //   323: aaload
    //   324: invokevirtual 251	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   327: pop
    //   328: aload_0
    //   329: getfield 60	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   332: invokevirtual 65	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   335: aload_1
    //   336: invokevirtual 241	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   339: goto -54 -> 285
    //   342: ldc 253
    //   344: aload 4
    //   346: invokevirtual 178	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   349: ifeq +23 -> 372
    //   352: invokestatic 259	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   355: new 261	pbe
    //   358: dup
    //   359: aload_0
    //   360: aload 5
    //   362: invokespecial 264	pbe:<init>	(Lcom/tencent/biz/webviewplugin/HotchatPlugin;[Ljava/lang/String;)V
    //   365: invokevirtual 270	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   368: pop
    //   369: goto -84 -> 285
    //   372: ldc_w 272
    //   375: aload 4
    //   377: invokevirtual 178	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   380: ifeq +146 -> 526
    //   383: aload_0
    //   384: getfield 60	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   387: invokevirtual 275	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   390: invokevirtual 280	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   393: ldc_w 282
    //   396: iconst_0
    //   397: invokestatic 288	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   400: invokestatic 293	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   403: checkcast 284	java/lang/Boolean
    //   406: invokevirtual 296	java/lang/Boolean:booleanValue	()Z
    //   409: istore 12
    //   411: aconst_null
    //   412: astore_2
    //   413: aload_2
    //   414: astore_1
    //   415: aload 5
    //   417: ifnull +28 -> 445
    //   420: aload_2
    //   421: astore_1
    //   422: aload 5
    //   424: arraylength
    //   425: ifle +20 -> 445
    //   428: new 191	org/json/JSONObject
    //   431: dup
    //   432: aload 5
    //   434: iconst_0
    //   435: aaload
    //   436: invokespecial 193	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   439: ldc 195
    //   441: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   444: astore_1
    //   445: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   448: ifeq +29 -> 477
    //   451: ldc 153
    //   453: iconst_2
    //   454: new 155	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   461: ldc_w 300
    //   464: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload_1
    //   468: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   477: aload_1
    //   478: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   481: ifne -196 -> 285
    //   484: iload 12
    //   486: ifeq +33 -> 519
    //   489: ldc_w 302
    //   492: astore_2
    //   493: aload_0
    //   494: aload_1
    //   495: iconst_1
    //   496: anewarray 174	java/lang/String
    //   499: dup
    //   500: iconst_0
    //   501: aload_2
    //   502: aastore
    //   503: invokevirtual 306	com/tencent/biz/webviewplugin/HotchatPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   506: goto -221 -> 285
    //   509: astore_1
    //   510: aload_1
    //   511: invokevirtual 309	org/json/JSONException:printStackTrace	()V
    //   514: aload_2
    //   515: astore_1
    //   516: goto -71 -> 445
    //   519: ldc_w 311
    //   522: astore_2
    //   523: goto -30 -> 493
    //   526: ldc_w 313
    //   529: aload 4
    //   531: invokevirtual 178	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   534: ifeq +282 -> 816
    //   537: aconst_null
    //   538: astore 14
    //   540: aconst_null
    //   541: astore_3
    //   542: aconst_null
    //   543: astore 4
    //   545: aconst_null
    //   546: astore 15
    //   548: iconst_0
    //   549: istore 13
    //   551: iload 13
    //   553: istore 12
    //   555: aload 15
    //   557: astore_2
    //   558: aload_3
    //   559: astore_1
    //   560: aload 5
    //   562: ifnull +101 -> 663
    //   565: iload 13
    //   567: istore 12
    //   569: aload 15
    //   571: astore_2
    //   572: aload_3
    //   573: astore_1
    //   574: aload 5
    //   576: arraylength
    //   577: ifle +86 -> 663
    //   580: aload 4
    //   582: astore_2
    //   583: aload 14
    //   585: astore_3
    //   586: new 191	org/json/JSONObject
    //   589: dup
    //   590: aload 5
    //   592: iconst_0
    //   593: aaload
    //   594: invokespecial 193	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   597: astore 5
    //   599: aload 4
    //   601: astore_2
    //   602: aload 14
    //   604: astore_3
    //   605: aload 5
    //   607: ldc 195
    //   609: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   612: astore_1
    //   613: aload 4
    //   615: astore_2
    //   616: aload_1
    //   617: astore_3
    //   618: aload 5
    //   620: ldc_w 315
    //   623: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   626: astore 4
    //   628: aload 4
    //   630: invokestatic 320	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   633: astore_2
    //   634: aload_2
    //   635: astore 4
    //   637: aload 4
    //   639: astore_2
    //   640: aload_1
    //   641: astore_3
    //   642: aload 5
    //   644: ldc_w 322
    //   647: invokevirtual 326	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   650: istore 6
    //   652: iload 6
    //   654: ifne +137 -> 791
    //   657: iconst_0
    //   658: istore 12
    //   660: aload 4
    //   662: astore_2
    //   663: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   666: ifeq +50 -> 716
    //   669: ldc 153
    //   671: iconst_2
    //   672: new 155	java/lang/StringBuilder
    //   675: dup
    //   676: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   679: ldc_w 300
    //   682: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: aload_1
    //   686: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: ldc_w 328
    //   692: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: aload_2
    //   696: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: ldc_w 330
    //   702: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: iload 12
    //   707: invokevirtual 333	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   710: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   713: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   716: aload_2
    //   717: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   720: ifne -435 -> 285
    //   723: aload_1
    //   724: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   727: ifne -442 -> 285
    //   730: new 335	android/os/Bundle
    //   733: dup
    //   734: invokespecial 336	android/os/Bundle:<init>	()V
    //   737: astore_3
    //   738: aload_3
    //   739: ldc_w 338
    //   742: aload_2
    //   743: invokevirtual 342	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   746: aload_3
    //   747: ldc_w 344
    //   750: ldc_w 313
    //   753: invokevirtual 342	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   756: aload_3
    //   757: ldc_w 346
    //   760: iload 12
    //   762: invokevirtual 350	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   765: ldc_w 352
    //   768: aload_1
    //   769: aload_0
    //   770: getfield 47	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   773: getfield 357	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   776: aload_3
    //   777: invokestatic 362	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   780: astore_1
    //   781: invokestatic 367	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   784: aload_1
    //   785: invokevirtual 370	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	(Landroid/os/Bundle;)V
    //   788: goto -503 -> 285
    //   791: iconst_1
    //   792: istore 12
    //   794: aload 4
    //   796: astore_2
    //   797: goto -134 -> 663
    //   800: astore 4
    //   802: aload_3
    //   803: astore_1
    //   804: aload 4
    //   806: invokevirtual 309	org/json/JSONException:printStackTrace	()V
    //   809: iload 13
    //   811: istore 12
    //   813: goto -150 -> 663
    //   816: ldc_w 372
    //   819: aload 4
    //   821: invokevirtual 178	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   824: ifeq +281 -> 1105
    //   827: aload_0
    //   828: getfield 60	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   831: invokevirtual 275	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   834: astore 16
    //   836: aconst_null
    //   837: astore 14
    //   839: aconst_null
    //   840: astore_3
    //   841: aconst_null
    //   842: astore 15
    //   844: aconst_null
    //   845: astore 4
    //   847: aload 15
    //   849: astore_1
    //   850: aload 14
    //   852: astore_2
    //   853: aload 5
    //   855: ifnull +211 -> 1066
    //   858: aload 15
    //   860: astore_1
    //   861: aload 14
    //   863: astore_2
    //   864: aload 5
    //   866: arraylength
    //   867: ifle +199 -> 1066
    //   870: aload 4
    //   872: astore_1
    //   873: aload_3
    //   874: astore_2
    //   875: new 191	org/json/JSONObject
    //   878: dup
    //   879: aload 5
    //   881: iconst_0
    //   882: aaload
    //   883: invokespecial 193	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   886: astore 14
    //   888: aload 4
    //   890: astore_1
    //   891: aload_3
    //   892: astore_2
    //   893: aload 14
    //   895: ldc_w 374
    //   898: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   901: astore_3
    //   902: aload 4
    //   904: astore_1
    //   905: aload_3
    //   906: astore_2
    //   907: aload 14
    //   909: ldc_w 376
    //   912: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   915: astore 4
    //   917: aload 4
    //   919: astore_1
    //   920: aload_3
    //   921: astore_2
    //   922: aload 14
    //   924: ldc_w 378
    //   927: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   930: astore 14
    //   932: aload_3
    //   933: astore_2
    //   934: aload 4
    //   936: astore_1
    //   937: aload 14
    //   939: astore_3
    //   940: aload 16
    //   942: ifnull +56 -> 998
    //   945: aload_1
    //   946: ifnull +52 -> 998
    //   949: aload_2
    //   950: ifnull +48 -> 998
    //   953: ldc_w 380
    //   956: aload_2
    //   957: invokevirtual 183	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   960: ifeq +113 -> 1073
    //   963: aload 16
    //   965: invokevirtual 383	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   968: ldc_w 385
    //   971: aload_1
    //   972: invokestatic 388	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   975: pop
    //   976: aload 16
    //   978: invokevirtual 383	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   981: ldc_w 390
    //   984: ldc_w 392
    //   987: aload_3
    //   988: invokevirtual 395	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   991: invokestatic 288	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   994: invokestatic 388	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   997: pop
    //   998: invokestatic 399	com/tencent/mobileqq/nearby/NearbyUtils:b	()Z
    //   1001: ifeq -716 -> 285
    //   1004: aload 5
    //   1006: ifnull +9 -> 1015
    //   1009: aload 5
    //   1011: arraylength
    //   1012: ifne +84 -> 1096
    //   1015: ldc_w 401
    //   1018: astore 4
    //   1020: ldc 153
    //   1022: bipush 6
    //   1024: anewarray 403	java/lang/Object
    //   1027: dup
    //   1028: iconst_0
    //   1029: ldc_w 372
    //   1032: aastore
    //   1033: dup
    //   1034: iconst_1
    //   1035: aload 16
    //   1037: aastore
    //   1038: dup
    //   1039: iconst_2
    //   1040: aload_2
    //   1041: aastore
    //   1042: dup
    //   1043: iconst_3
    //   1044: aload_1
    //   1045: aastore
    //   1046: dup
    //   1047: iconst_4
    //   1048: aload_3
    //   1049: aastore
    //   1050: dup
    //   1051: iconst_5
    //   1052: aload 4
    //   1054: aastore
    //   1055: invokestatic 406	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1058: goto -773 -> 285
    //   1061: astore_3
    //   1062: aload_3
    //   1063: invokevirtual 407	java/lang/Exception:printStackTrace	()V
    //   1066: ldc_w 392
    //   1069: astore_3
    //   1070: goto -130 -> 940
    //   1073: aload_1
    //   1074: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1077: ifne -79 -> 998
    //   1080: aload 16
    //   1082: invokevirtual 383	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1085: ldc_w 409
    //   1088: aload_1
    //   1089: invokestatic 388	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   1092: pop
    //   1093: goto -95 -> 998
    //   1096: aload 5
    //   1098: iconst_0
    //   1099: aaload
    //   1100: astore 4
    //   1102: goto -82 -> 1020
    //   1105: ldc_w 411
    //   1108: aload 4
    //   1110: invokevirtual 178	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1113: ifeq +337 -> 1450
    //   1116: aload_0
    //   1117: getfield 60	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1120: invokevirtual 275	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1123: astore 15
    //   1125: iconst_0
    //   1126: istore 8
    //   1128: iconst_0
    //   1129: istore 10
    //   1131: iconst_0
    //   1132: istore 9
    //   1134: iconst_0
    //   1135: istore 11
    //   1137: aconst_null
    //   1138: astore_3
    //   1139: aconst_null
    //   1140: astore 14
    //   1142: aconst_null
    //   1143: astore 4
    //   1145: iload 10
    //   1147: istore 6
    //   1149: iload 11
    //   1151: istore 7
    //   1153: aload 14
    //   1155: astore_1
    //   1156: aload 4
    //   1158: astore_2
    //   1159: aload 5
    //   1161: ifnull +128 -> 1289
    //   1164: iload 10
    //   1166: istore 6
    //   1168: iload 11
    //   1170: istore 7
    //   1172: aload 14
    //   1174: astore_1
    //   1175: aload 4
    //   1177: astore_2
    //   1178: aload 5
    //   1180: arraylength
    //   1181: ifle +108 -> 1289
    //   1184: iload 8
    //   1186: istore 6
    //   1188: iload 9
    //   1190: istore 7
    //   1192: aload_3
    //   1193: astore_1
    //   1194: new 191	org/json/JSONObject
    //   1197: dup
    //   1198: aload 5
    //   1200: iconst_0
    //   1201: aaload
    //   1202: invokespecial 193	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1205: astore_2
    //   1206: iload 8
    //   1208: istore 6
    //   1210: iload 9
    //   1212: istore 7
    //   1214: aload_3
    //   1215: astore_1
    //   1216: aload_2
    //   1217: ldc_w 413
    //   1220: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1223: astore_3
    //   1224: iload 8
    //   1226: istore 6
    //   1228: iload 9
    //   1230: istore 7
    //   1232: aload_3
    //   1233: astore_1
    //   1234: aload_2
    //   1235: ldc_w 415
    //   1238: invokevirtual 326	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1241: istore 8
    //   1243: iload 8
    //   1245: istore 6
    //   1247: iload 9
    //   1249: istore 7
    //   1251: aload_3
    //   1252: astore_1
    //   1253: aload_2
    //   1254: ldc_w 417
    //   1257: invokevirtual 326	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1260: istore 9
    //   1262: iload 8
    //   1264: istore 6
    //   1266: iload 9
    //   1268: istore 7
    //   1270: aload_3
    //   1271: astore_1
    //   1272: aload_2
    //   1273: ldc 195
    //   1275: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1278: astore_2
    //   1279: aload_3
    //   1280: astore_1
    //   1281: iload 9
    //   1283: istore 7
    //   1285: iload 8
    //   1287: istore 6
    //   1289: aload_1
    //   1290: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1293: ifeq +142 -> 1435
    //   1296: ldc_w 419
    //   1299: astore_3
    //   1300: new 191	org/json/JSONObject
    //   1303: dup
    //   1304: invokespecial 420	org/json/JSONObject:<init>	()V
    //   1307: astore 4
    //   1309: aload 4
    //   1311: ldc_w 422
    //   1314: iconst_m1
    //   1315: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1318: pop
    //   1319: aload 4
    //   1321: ldc_w 428
    //   1324: ldc_w 419
    //   1327: invokevirtual 431	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1330: pop
    //   1331: aload 4
    //   1333: ldc_w 433
    //   1336: ldc_w 435
    //   1339: invokevirtual 431	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1342: pop
    //   1343: aload 4
    //   1345: invokevirtual 436	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1348: astore 4
    //   1350: aload 4
    //   1352: astore_3
    //   1353: aload_0
    //   1354: aload_2
    //   1355: iconst_1
    //   1356: anewarray 174	java/lang/String
    //   1359: dup
    //   1360: iconst_0
    //   1361: aload_3
    //   1362: aastore
    //   1363: invokevirtual 306	com/tencent/biz/webviewplugin/HotchatPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1366: invokestatic 399	com/tencent/mobileqq/nearby/NearbyUtils:b	()Z
    //   1369: ifeq -1084 -> 285
    //   1372: ldc 153
    //   1374: iconst_5
    //   1375: anewarray 403	java/lang/Object
    //   1378: dup
    //   1379: iconst_0
    //   1380: ldc_w 411
    //   1383: aastore
    //   1384: dup
    //   1385: iconst_1
    //   1386: iload 6
    //   1388: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1391: aastore
    //   1392: dup
    //   1393: iconst_2
    //   1394: iload 7
    //   1396: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1399: aastore
    //   1400: dup
    //   1401: iconst_3
    //   1402: aload_1
    //   1403: aastore
    //   1404: dup
    //   1405: iconst_4
    //   1406: aload_2
    //   1407: aastore
    //   1408: invokestatic 406	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1411: goto -1126 -> 285
    //   1414: astore_2
    //   1415: aload_2
    //   1416: invokevirtual 407	java/lang/Exception:printStackTrace	()V
    //   1419: aload 4
    //   1421: astore_2
    //   1422: goto -133 -> 1289
    //   1425: astore 4
    //   1427: aload 4
    //   1429: invokevirtual 407	java/lang/Exception:printStackTrace	()V
    //   1432: goto -79 -> 1353
    //   1435: aload 15
    //   1437: iload 6
    //   1439: iload 7
    //   1441: aload_1
    //   1442: aload_0
    //   1443: aload_2
    //   1444: invokestatic 446	com/tencent/mobileqq/nearby/NearbyAlumniServlet:a	(Lcom/tencent/common/app/AppInterface;IILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V
    //   1447: goto -81 -> 1366
    //   1450: ldc_w 448
    //   1453: aload 4
    //   1455: invokevirtual 183	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1458: ifeq +127 -> 1585
    //   1461: aload 5
    //   1463: ifnull +974 -> 2437
    //   1466: aload 5
    //   1468: arraylength
    //   1469: ifle +968 -> 2437
    //   1472: new 191	org/json/JSONObject
    //   1475: dup
    //   1476: aload 5
    //   1478: iconst_0
    //   1479: aaload
    //   1480: invokespecial 193	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1483: ldc 195
    //   1485: invokevirtual 199	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1488: astore_1
    //   1489: aload_0
    //   1490: getfield 60	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1493: invokevirtual 65	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1496: astore_2
    //   1497: aload_2
    //   1498: ifnull +939 -> 2437
    //   1501: aload_2
    //   1502: instanceof 201
    //   1505: ifeq +932 -> 2437
    //   1508: aload_2
    //   1509: checkcast 201	com/tencent/mobileqq/activity/NearbyActivity
    //   1512: invokevirtual 204	com/tencent/mobileqq/activity/NearbyActivity:a	()Lcom/tencent/mobileqq/fragment/HotChatFragment;
    //   1515: astore_3
    //   1516: aload_3
    //   1517: ifnull +920 -> 2437
    //   1520: aload_3
    //   1521: instanceof 206
    //   1524: ifeq +913 -> 2437
    //   1527: aload_1
    //   1528: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1531: ifeq +14 -> 1545
    //   1534: aload_3
    //   1535: checkcast 206	com/tencent/mobileqq/fragment/HotChatFragment
    //   1538: aconst_null
    //   1539: invokevirtual 215	com/tencent/mobileqq/fragment/HotChatFragment:a	(Landroid/view/View$OnClickListener;)V
    //   1542: goto +895 -> 2437
    //   1545: aload_3
    //   1546: checkcast 206	com/tencent/mobileqq/fragment/HotChatFragment
    //   1549: new 450	pbf
    //   1552: dup
    //   1553: aload_0
    //   1554: aload_1
    //   1555: aload_2
    //   1556: invokespecial 451	pbf:<init>	(Lcom/tencent/biz/webviewplugin/HotchatPlugin;Ljava/lang/String;Landroid/app/Activity;)V
    //   1559: invokevirtual 215	com/tencent/mobileqq/fragment/HotChatFragment:a	(Landroid/view/View$OnClickListener;)V
    //   1562: goto +875 -> 2437
    //   1565: astore_1
    //   1566: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1569: ifeq +868 -> 2437
    //   1572: ldc 153
    //   1574: iconst_2
    //   1575: aload_1
    //   1576: invokevirtual 223	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1579: invokestatic 189	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1582: goto +855 -> 2437
    //   1585: ldc_w 453
    //   1588: aload 4
    //   1590: invokevirtual 178	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1593: ifeq +169 -> 1762
    //   1596: aload 5
    //   1598: ifnull -1313 -> 285
    //   1601: aload 5
    //   1603: arraylength
    //   1604: ifle -1319 -> 285
    //   1607: new 191	org/json/JSONObject
    //   1610: dup
    //   1611: aload 5
    //   1613: iconst_0
    //   1614: aaload
    //   1615: invokespecial 193	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1618: astore_1
    //   1619: aload_1
    //   1620: ldc_w 455
    //   1623: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1626: astore_2
    //   1627: aload_1
    //   1628: ldc_w 457
    //   1631: invokevirtual 461	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1634: astore_3
    //   1635: iconst_0
    //   1636: istore 6
    //   1638: iload 6
    //   1640: aload_3
    //   1641: invokevirtual 466	org/json/JSONArray:length	()I
    //   1644: if_icmpge -1359 -> 285
    //   1647: aload_3
    //   1648: iload 6
    //   1650: invokevirtual 470	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   1653: checkcast 191	org/json/JSONObject
    //   1656: astore 4
    //   1658: aload 4
    //   1660: ldc_w 472
    //   1663: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1666: astore 5
    //   1668: aload 4
    //   1670: ldc_w 474
    //   1673: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1676: astore_1
    //   1677: aload 4
    //   1679: ldc_w 476
    //   1682: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1685: astore 4
    //   1687: aload_1
    //   1688: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1691: ifeq +741 -> 2432
    //   1694: aload 5
    //   1696: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1699: ifne +733 -> 2432
    //   1702: aload_0
    //   1703: getfield 31	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1706: aload 5
    //   1708: invokevirtual 479	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1711: checkcast 174	java/lang/String
    //   1714: astore_1
    //   1715: aload_1
    //   1716: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1719: ifne +14 -> 1733
    //   1722: aload_0
    //   1723: getfield 33	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1726: aload_2
    //   1727: aload_1
    //   1728: aload 4
    //   1730: invokevirtual 484	com/tencent/biz/troop/TroopMemberApiClient:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1733: iload 6
    //   1735: iconst_1
    //   1736: iadd
    //   1737: istore 6
    //   1739: goto -101 -> 1638
    //   1742: astore_1
    //   1743: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1746: ifeq -1461 -> 285
    //   1749: ldc 153
    //   1751: iconst_2
    //   1752: aload_1
    //   1753: invokevirtual 223	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1756: invokestatic 189	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1759: goto -1474 -> 285
    //   1762: ldc_w 486
    //   1765: aload 4
    //   1767: invokevirtual 178	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1770: ifeq +90 -> 1860
    //   1773: aload 5
    //   1775: ifnull -1490 -> 285
    //   1778: aload 5
    //   1780: arraylength
    //   1781: ifle -1496 -> 285
    //   1784: new 191	org/json/JSONObject
    //   1787: dup
    //   1788: aload 5
    //   1790: iconst_0
    //   1791: aaload
    //   1792: invokespecial 193	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1795: astore_3
    //   1796: aload_3
    //   1797: ldc 195
    //   1799: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1802: astore_1
    //   1803: aload_3
    //   1804: ldc_w 455
    //   1807: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1810: astore_2
    //   1811: aload_3
    //   1812: ldc_w 488
    //   1815: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1818: astore_3
    //   1819: aload_0
    //   1820: getfield 33	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1823: aload_2
    //   1824: aload_3
    //   1825: new 490	pbg
    //   1828: dup
    //   1829: aload_0
    //   1830: aload_1
    //   1831: invokespecial 491	pbg:<init>	(Lcom/tencent/biz/webviewplugin/HotchatPlugin;Ljava/lang/String;)V
    //   1834: invokevirtual 494	com/tencent/biz/troop/TroopMemberApiClient:d	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/troop/TroopMemberApiClient$Callback;)V
    //   1837: goto -1552 -> 285
    //   1840: astore_1
    //   1841: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1844: ifeq -1559 -> 285
    //   1847: ldc 153
    //   1849: iconst_2
    //   1850: aload_1
    //   1851: invokevirtual 223	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1854: invokestatic 189	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1857: goto -1572 -> 285
    //   1860: ldc_w 496
    //   1863: aload 4
    //   1865: invokevirtual 178	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1868: ifeq +128 -> 1996
    //   1871: new 67	java/util/ArrayList
    //   1874: dup
    //   1875: invokespecial 68	java/util/ArrayList:<init>	()V
    //   1878: astore_1
    //   1879: aload 5
    //   1881: ifnull -1596 -> 285
    //   1884: aload 5
    //   1886: arraylength
    //   1887: ifle -1602 -> 285
    //   1890: new 191	org/json/JSONObject
    //   1893: dup
    //   1894: aload 5
    //   1896: iconst_0
    //   1897: aaload
    //   1898: invokespecial 193	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1901: astore_2
    //   1902: aload_2
    //   1903: ldc 195
    //   1905: invokevirtual 199	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1908: pop
    //   1909: aload_2
    //   1910: ldc_w 455
    //   1913: invokevirtual 199	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1916: pop
    //   1917: aload_2
    //   1918: ldc_w 498
    //   1921: invokevirtual 461	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1924: astore_2
    //   1925: iconst_0
    //   1926: istore 6
    //   1928: iload 6
    //   1930: aload_2
    //   1931: invokevirtual 466	org/json/JSONArray:length	()I
    //   1934: if_icmpge +23 -> 1957
    //   1937: aload_1
    //   1938: aload_2
    //   1939: iload 6
    //   1941: invokevirtual 499	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1944: invokevirtual 500	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1947: pop
    //   1948: iload 6
    //   1950: iconst_1
    //   1951: iadd
    //   1952: istore 6
    //   1954: goto -26 -> 1928
    //   1957: aload_0
    //   1958: getfield 33	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1961: aload_1
    //   1962: new 502	pbh
    //   1965: dup
    //   1966: aload_0
    //   1967: invokespecial 503	pbh:<init>	(Lcom/tencent/biz/webviewplugin/HotchatPlugin;)V
    //   1970: invokevirtual 506	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/util/ArrayList;Lcom/tencent/biz/troop/TroopMemberApiClient$Callback;)V
    //   1973: goto -1688 -> 285
    //   1976: astore_1
    //   1977: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1980: ifeq -1695 -> 285
    //   1983: ldc 153
    //   1985: iconst_2
    //   1986: aload_1
    //   1987: invokevirtual 223	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1990: invokestatic 189	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1993: goto -1708 -> 285
    //   1996: ldc_w 508
    //   1999: aload 4
    //   2001: invokevirtual 178	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2004: ifeq +62 -> 2066
    //   2007: aload 5
    //   2009: ifnull -1724 -> 285
    //   2012: aload 5
    //   2014: arraylength
    //   2015: ifle -1730 -> 285
    //   2018: new 191	org/json/JSONObject
    //   2021: dup
    //   2022: aload 5
    //   2024: iconst_0
    //   2025: aaload
    //   2026: invokespecial 193	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2029: ldc_w 455
    //   2032: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2035: pop
    //   2036: aload_0
    //   2037: getfield 31	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2040: invokevirtual 511	java/util/HashMap:clear	()V
    //   2043: goto -1758 -> 285
    //   2046: astore_1
    //   2047: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2050: ifeq -1765 -> 285
    //   2053: ldc 153
    //   2055: iconst_2
    //   2056: aload_1
    //   2057: invokevirtual 223	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2060: invokestatic 189	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2063: goto -1778 -> 285
    //   2066: ldc_w 513
    //   2069: aload 4
    //   2071: invokevirtual 178	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2074: ifeq +75 -> 2149
    //   2077: aload_0
    //   2078: getfield 60	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2081: invokevirtual 65	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2084: astore_1
    //   2085: aload 5
    //   2087: ifnull -1802 -> 285
    //   2090: aload 5
    //   2092: arraylength
    //   2093: ifle -1808 -> 285
    //   2096: new 191	org/json/JSONObject
    //   2099: dup
    //   2100: aload 5
    //   2102: iconst_0
    //   2103: aaload
    //   2104: invokespecial 193	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2107: ldc_w 455
    //   2110: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2113: astore_2
    //   2114: aload_0
    //   2115: getfield 33	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   2118: aload_2
    //   2119: invokevirtual 516	com/tencent/biz/troop/TroopMemberApiClient:e	(Ljava/lang/String;)V
    //   2122: aload_1
    //   2123: invokevirtual 519	android/app/Activity:finish	()V
    //   2126: goto -1841 -> 285
    //   2129: astore_1
    //   2130: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2133: ifeq -1848 -> 285
    //   2136: ldc 153
    //   2138: iconst_2
    //   2139: aload_1
    //   2140: invokevirtual 223	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2143: invokestatic 189	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2146: goto -1861 -> 285
    //   2149: ldc_w 521
    //   2152: aload 4
    //   2154: invokevirtual 178	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2157: ifeq +235 -> 2392
    //   2160: aload 5
    //   2162: ifnull -1877 -> 285
    //   2165: aload 5
    //   2167: arraylength
    //   2168: ifle -1883 -> 285
    //   2171: new 191	org/json/JSONObject
    //   2174: dup
    //   2175: aload 5
    //   2177: iconst_0
    //   2178: aaload
    //   2179: invokespecial 193	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2182: astore_1
    //   2183: aload_0
    //   2184: getfield 60	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2187: invokevirtual 65	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2190: astore_3
    //   2191: aload_1
    //   2192: ldc_w 523
    //   2195: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2198: astore 4
    //   2200: aload_1
    //   2201: ldc_w 474
    //   2204: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2207: astore_2
    //   2208: aload_1
    //   2209: ldc_w 472
    //   2212: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2215: astore 14
    //   2217: aload_1
    //   2218: ldc_w 476
    //   2221: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2224: astore 5
    //   2226: aload_1
    //   2227: ldc_w 455
    //   2230: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2233: astore 15
    //   2235: aload_2
    //   2236: astore_1
    //   2237: aload_2
    //   2238: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2241: ifeq +26 -> 2267
    //   2244: aload_2
    //   2245: astore_1
    //   2246: aload 14
    //   2248: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2251: ifne +16 -> 2267
    //   2254: aload_0
    //   2255: getfield 31	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2258: aload 14
    //   2260: invokevirtual 479	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2263: checkcast 174	java/lang/String
    //   2266: astore_1
    //   2267: aload_1
    //   2268: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2271: ifeq +19 -> 2290
    //   2274: invokestatic 529	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2277: ldc_w 531
    //   2280: iconst_0
    //   2281: invokestatic 536	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   2284: invokevirtual 539	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   2287: pop
    //   2288: iconst_0
    //   2289: ireturn
    //   2290: aload 4
    //   2292: ldc_w 311
    //   2295: invokevirtual 183	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2298: ifeq +40 -> 2338
    //   2301: aload_0
    //   2302: getfield 33	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   2305: aload 15
    //   2307: aload_1
    //   2308: invokevirtual 541	com/tencent/biz/troop/TroopMemberApiClient:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2311: aload_3
    //   2312: invokevirtual 519	android/app/Activity:finish	()V
    //   2315: goto -2030 -> 285
    //   2318: astore_1
    //   2319: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2322: ifeq -2037 -> 285
    //   2325: ldc 153
    //   2327: iconst_2
    //   2328: aload_1
    //   2329: invokevirtual 223	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2332: invokestatic 189	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2335: goto -2050 -> 285
    //   2338: aload 4
    //   2340: ldc_w 302
    //   2343: invokevirtual 183	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2346: ifeq +22 -> 2368
    //   2349: aload_0
    //   2350: getfield 33	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   2353: aload 15
    //   2355: aload_1
    //   2356: aload 5
    //   2358: invokevirtual 543	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2361: aload_3
    //   2362: invokevirtual 519	android/app/Activity:finish	()V
    //   2365: goto -2080 -> 285
    //   2368: aload 4
    //   2370: ldc_w 545
    //   2373: invokevirtual 183	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2376: ifeq -2091 -> 285
    //   2379: aload_0
    //   2380: getfield 33	com/tencent/biz/webviewplugin/HotchatPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   2383: aload 15
    //   2385: aload_1
    //   2386: invokevirtual 548	com/tencent/biz/troop/TroopMemberApiClient:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   2389: goto -2104 -> 285
    //   2392: ldc 153
    //   2394: iconst_1
    //   2395: new 155	java/lang/StringBuilder
    //   2398: dup
    //   2399: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   2402: ldc_w 550
    //   2405: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2408: aload 4
    //   2410: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2413: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2416: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2419: goto -2134 -> 285
    //   2422: astore_3
    //   2423: aload 4
    //   2425: astore_2
    //   2426: aload_3
    //   2427: astore 4
    //   2429: goto -1625 -> 804
    //   2432: goto -717 -> 1715
    //   2435: iconst_1
    //   2436: ireturn
    //   2437: iconst_1
    //   2438: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2439	0	this	HotchatPlugin
    //   0	2439	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2439	2	paramString1	String
    //   0	2439	3	paramString2	String
    //   0	2439	4	paramString3	String
    //   0	2439	5	paramVarArgs	String[]
    //   650	1303	6	i	int
    //   1151	289	7	j	int
    //   1126	160	8	k	int
    //   1132	150	9	m	int
    //   1129	36	10	n	int
    //   1135	34	11	i1	int
    //   409	403	12	bool1	boolean
    //   549	261	13	bool2	boolean
    //   538	1721	14	localObject1	java.lang.Object
    //   546	1838	15	localObject2	java.lang.Object
    //   834	247	16	localAppInterface	com.tencent.common.app.AppInterface
    // Exception table:
    //   from	to	target	type
    //   106	131	199	org/json/JSONException
    //   135	150	199	org/json/JSONException
    //   154	176	199	org/json/JSONException
    //   179	196	199	org/json/JSONException
    //   428	445	509	org/json/JSONException
    //   586	599	800	org/json/JSONException
    //   605	613	800	org/json/JSONException
    //   618	628	800	org/json/JSONException
    //   642	652	800	org/json/JSONException
    //   875	888	1061	java/lang/Exception
    //   893	902	1061	java/lang/Exception
    //   907	917	1061	java/lang/Exception
    //   922	932	1061	java/lang/Exception
    //   1194	1206	1414	java/lang/Exception
    //   1216	1224	1414	java/lang/Exception
    //   1234	1243	1414	java/lang/Exception
    //   1253	1262	1414	java/lang/Exception
    //   1272	1279	1414	java/lang/Exception
    //   1300	1350	1425	java/lang/Exception
    //   1472	1497	1565	org/json/JSONException
    //   1501	1516	1565	org/json/JSONException
    //   1520	1542	1565	org/json/JSONException
    //   1545	1562	1565	org/json/JSONException
    //   1607	1635	1742	org/json/JSONException
    //   1638	1715	1742	org/json/JSONException
    //   1715	1733	1742	org/json/JSONException
    //   1784	1837	1840	org/json/JSONException
    //   1890	1925	1976	org/json/JSONException
    //   1928	1948	1976	org/json/JSONException
    //   1957	1973	1976	org/json/JSONException
    //   2018	2043	2046	org/json/JSONException
    //   2096	2126	2129	org/json/JSONException
    //   2171	2235	2318	org/json/JSONException
    //   2237	2244	2318	org/json/JSONException
    //   2246	2267	2318	org/json/JSONException
    //   2267	2288	2318	org/json/JSONException
    //   2290	2315	2318	org/json/JSONException
    //   2338	2365	2318	org/json/JSONException
    //   2368	2389	2318	org/json/JSONException
    //   628	634	2422	org/json/JSONException
  }
  
  protected void onCreate()
  {
    WebIPCOperator.a().a(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
  }
  
  protected void onDestroy()
  {
    WebIPCOperator.a().b(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.HotchatPlugin
 * JD-Core Version:    0.7.0.1
 */