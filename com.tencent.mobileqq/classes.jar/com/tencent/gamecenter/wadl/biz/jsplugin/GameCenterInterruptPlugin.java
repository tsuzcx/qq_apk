package com.tencent.gamecenter.wadl.biz.jsplugin;

import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;

public class GameCenterInterruptPlugin
  extends WebViewPlugin
{
  public GameCenterInterruptPlugin()
  {
    QLog.d("Wadl_GameCenterInterruptPlugin", 1, "GameCenterInterruptPlugin init");
    this.mPluginNameSpace = "gameCenter";
    QRoute.api(IQQGameConfigService.class);
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 3L;
  }
  
  /* Error */
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +653 -> 654
    //   4: aload_1
    //   5: ldc 45
    //   7: invokevirtual 51	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   10: ifne +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: ldc 26
    //   17: invokestatic 32	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   20: checkcast 26	com/tencent/gamecenter/wadl/api/IQQGameConfigService
    //   23: ldc 53
    //   25: invokeinterface 57 2 0
    //   30: checkcast 59	com/tencent/gamecenter/wadl/biz/entity/WadlCommConfig
    //   33: astore 5
    //   35: aconst_null
    //   36: astore_3
    //   37: aconst_null
    //   38: astore 4
    //   40: aload 5
    //   42: ifnull +620 -> 662
    //   45: aload 5
    //   47: aload_1
    //   48: invokevirtual 63	com/tencent/gamecenter/wadl/biz/entity/WadlCommConfig:a	(Ljava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/ApkInfo;
    //   51: astore_2
    //   52: goto +3 -> 55
    //   55: new 65	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   62: astore 6
    //   64: aload 6
    //   66: ldc 68
    //   68: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 6
    //   74: aload_1
    //   75: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 6
    //   81: ldc 74
    //   83: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 6
    //   89: aload_2
    //   90: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: ldc 10
    //   96: iconst_1
    //   97: aload 6
    //   99: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 18	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload_2
    //   106: ifnull +456 -> 562
    //   109: invokestatic 87	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   112: aload_2
    //   113: getfield 92	com/tencent/gamecenter/wadl/biz/entity/ApkInfo:c	Ljava/lang/String;
    //   116: invokestatic 97	com/tencent/mobileqq/utils/PackageUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   119: ifeq +6 -> 125
    //   122: goto +440 -> 562
    //   125: new 65	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   132: astore_3
    //   133: aload_3
    //   134: ldc 99
    //   136: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload_3
    //   141: aload_2
    //   142: getfield 101	com/tencent/gamecenter/wadl/biz/entity/ApkInfo:d	Ljava/lang/String;
    //   145: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_3
    //   150: ldc 103
    //   152: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_3
    //   157: aload_2
    //   158: getfield 92	com/tencent/gamecenter/wadl/biz/entity/ApkInfo:c	Ljava/lang/String;
    //   161: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_3
    //   166: ldc 105
    //   168: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_3
    //   173: aload_2
    //   174: getfield 107	com/tencent/gamecenter/wadl/biz/entity/ApkInfo:a	Ljava/lang/String;
    //   177: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_3
    //   182: ldc 109
    //   184: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_3
    //   189: aload_2
    //   190: getfield 112	com/tencent/gamecenter/wadl/biz/entity/ApkInfo:b	Ljava/lang/String;
    //   193: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_3
    //   198: ldc 114
    //   200: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_3
    //   205: aload_1
    //   206: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: ldc 10
    //   212: iconst_1
    //   213: aload_3
    //   214: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 117	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_0
    //   221: getfield 121	com/tencent/gamecenter/wadl/biz/jsplugin/GameCenterInterruptPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   224: ifnull +443 -> 667
    //   227: aload_0
    //   228: getfield 121	com/tencent/gamecenter/wadl/biz/jsplugin/GameCenterInterruptPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   231: invokevirtual 126	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   234: astore_1
    //   235: aload_0
    //   236: getfield 121	com/tencent/gamecenter/wadl/biz/jsplugin/GameCenterInterruptPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   239: invokevirtual 129	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   242: astore_3
    //   243: goto +3 -> 246
    //   246: aload_3
    //   247: ifnull +407 -> 654
    //   250: aload_1
    //   251: ifnull +9 -> 260
    //   254: aload_1
    //   255: invokevirtual 135	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   258: astore 4
    //   260: aload 4
    //   262: invokestatic 140	com/tencent/gamecenter/wadl/util/GameCenterUtil:a	(Landroid/content/Intent;)Lcom/tencent/util/Pair;
    //   265: astore 6
    //   267: new 65	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   274: astore_1
    //   275: aload_1
    //   276: ldc 142
    //   278: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload_1
    //   283: aload_3
    //   284: invokevirtual 147	com/tencent/biz/pubaccount/CustomWebView:getOriginalUrl	()Ljava/lang/String;
    //   287: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_1
    //   292: ldc 149
    //   294: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload_1
    //   299: aload 6
    //   301: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload_1
    //   306: ldc 114
    //   308: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload_1
    //   313: aload_3
    //   314: invokevirtual 152	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   317: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: ldc 10
    //   323: iconst_1
    //   324: aload_1
    //   325: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 117	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: aload_3
    //   332: invokevirtual 152	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   335: astore_1
    //   336: aload_1
    //   337: astore 4
    //   339: aload_1
    //   340: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   343: ifeq +9 -> 352
    //   346: aload_3
    //   347: invokevirtual 147	com/tencent/biz/pubaccount/CustomWebView:getOriginalUrl	()Ljava/lang/String;
    //   350: astore 4
    //   352: new 159	com/tencent/gamecenter/wadl/biz/entity/WadlParams
    //   355: dup
    //   356: aload_2
    //   357: getfield 107	com/tencent/gamecenter/wadl/biz/entity/ApkInfo:a	Ljava/lang/String;
    //   360: aload_2
    //   361: getfield 92	com/tencent/gamecenter/wadl/biz/entity/ApkInfo:c	Ljava/lang/String;
    //   364: invokespecial 162	com/tencent/gamecenter/wadl/biz/entity/WadlParams:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   367: astore_1
    //   368: aload_1
    //   369: iconst_2
    //   370: putfield 165	com/tencent/gamecenter/wadl/biz/entity/WadlParams:b	I
    //   373: aload_1
    //   374: iconst_0
    //   375: putfield 168	com/tencent/gamecenter/wadl/biz/entity/WadlParams:a	Z
    //   378: aload_1
    //   379: aload_2
    //   380: getfield 101	com/tencent/gamecenter/wadl/biz/entity/ApkInfo:d	Ljava/lang/String;
    //   383: putfield 169	com/tencent/gamecenter/wadl/biz/entity/WadlParams:c	Ljava/lang/String;
    //   386: aload_1
    //   387: aload_2
    //   388: getfield 112	com/tencent/gamecenter/wadl/biz/entity/ApkInfo:b	Ljava/lang/String;
    //   391: putfield 172	com/tencent/gamecenter/wadl/biz/entity/WadlParams:j	Ljava/lang/String;
    //   394: aload_1
    //   395: aload_2
    //   396: getfield 175	com/tencent/gamecenter/wadl/biz/entity/ApkInfo:e	Ljava/lang/String;
    //   399: putfield 176	com/tencent/gamecenter/wadl/biz/entity/WadlParams:e	Ljava/lang/String;
    //   402: aload_1
    //   403: ldc 178
    //   405: putfield 181	com/tencent/gamecenter/wadl/biz/entity/WadlParams:l	Ljava/lang/String;
    //   408: aload_1
    //   409: bipush 6
    //   411: putfield 183	com/tencent/gamecenter/wadl/biz/entity/WadlParams:d	I
    //   414: aload_1
    //   415: aload 4
    //   417: putfield 186	com/tencent/gamecenter/wadl/biz/entity/WadlParams:m	Ljava/lang/String;
    //   420: invokestatic 191	com/tencent/gamecenter/wadl/util/WadlProxyServiceUtil:a	()Lcom/tencent/gamecenter/wadl/util/WadlProxyServiceWrap;
    //   423: aload_1
    //   424: invokevirtual 196	com/tencent/gamecenter/wadl/util/WadlProxyServiceWrap:b	(Lcom/tencent/gamecenter/wadl/biz/entity/WadlParams;)V
    //   427: aload 5
    //   429: ifnull +245 -> 674
    //   432: aload 5
    //   434: getfield 197	com/tencent/gamecenter/wadl/biz/entity/WadlCommConfig:c	Ljava/lang/String;
    //   437: astore_1
    //   438: goto +3 -> 441
    //   441: aload_1
    //   442: astore 5
    //   444: aload_1
    //   445: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   448: ifeq +7 -> 455
    //   451: ldc 199
    //   453: astore 5
    //   455: aload_3
    //   456: aload 5
    //   458: invokevirtual 203	com/tencent/biz/pubaccount/CustomWebView:loadUrl	(Ljava/lang/String;)V
    //   461: new 205	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder
    //   464: dup
    //   465: invokespecial 206	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:<init>	()V
    //   468: ldc 208
    //   470: invokevirtual 211	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(Ljava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   473: ldc 213
    //   475: invokevirtual 216	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:h	(Ljava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   478: ldc 218
    //   480: invokevirtual 220	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:c	(Ljava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   483: aload_2
    //   484: getfield 107	com/tencent/gamecenter/wadl/biz/entity/ApkInfo:a	Ljava/lang/String;
    //   487: invokevirtual 222	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:b	(Ljava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   490: iconst_1
    //   491: ldc 224
    //   493: invokevirtual 227	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   496: bipush 11
    //   498: ldc 229
    //   500: invokevirtual 227	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   503: bipush 12
    //   505: ldc 231
    //   507: invokevirtual 227	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   510: iconst_2
    //   511: aload 6
    //   513: getfield 237	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   516: invokestatic 241	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   519: invokevirtual 227	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   522: iconst_3
    //   523: aload 6
    //   525: getfield 244	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   528: checkcast 47	java/lang/String
    //   531: invokevirtual 227	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   534: iconst_4
    //   535: aload_2
    //   536: getfield 101	com/tencent/gamecenter/wadl/biz/entity/ApkInfo:d	Ljava/lang/String;
    //   539: invokevirtual 227	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   542: iconst_5
    //   543: aload_2
    //   544: getfield 175	com/tencent/gamecenter/wadl/biz/entity/ApkInfo:e	Ljava/lang/String;
    //   547: invokevirtual 227	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   550: bipush 6
    //   552: aload 4
    //   554: invokevirtual 227	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	(ILjava/lang/String;)Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder;
    //   557: invokevirtual 246	com/tencent/gamecenter/wadl/biz/entity/WadlReportBuilder:a	()V
    //   560: iconst_1
    //   561: ireturn
    //   562: invokestatic 251	com/tencent/gamecenter/wadl/biz/entity/WadlReportInfo:a	()Lcom/tencent/gamecenter/wadl/biz/entity/WadlReportInfo;
    //   565: astore 4
    //   567: new 253	java/net/URL
    //   570: dup
    //   571: aload_1
    //   572: invokespecial 255	java/net/URL:<init>	(Ljava/lang/String;)V
    //   575: invokevirtual 258	java/net/URL:getHost	()Ljava/lang/String;
    //   578: astore_2
    //   579: aload 4
    //   581: aload_1
    //   582: putfield 261	com/tencent/gamecenter/wadl/biz/entity/WadlReportInfo:f	Ljava/lang/String;
    //   585: aload 4
    //   587: aload_2
    //   588: putfield 264	com/tencent/gamecenter/wadl/biz/entity/WadlReportInfo:g	Ljava/lang/String;
    //   591: ldc_w 266
    //   594: invokestatic 32	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   597: checkcast 266	com/tencent/gamecenter/wadl/api/IQQGameReportService
    //   600: ldc_w 268
    //   603: ldc_w 270
    //   606: aload 4
    //   608: ldc_w 272
    //   611: invokeinterface 276 5 0
    //   616: iconst_0
    //   617: ireturn
    //   618: astore_1
    //   619: new 65	java/lang/StringBuilder
    //   622: dup
    //   623: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   626: astore_2
    //   627: aload_2
    //   628: ldc_w 278
    //   631: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload_2
    //   636: aload_1
    //   637: invokevirtual 279	java/lang/Exception:toString	()Ljava/lang/String;
    //   640: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: ldc 10
    //   646: iconst_1
    //   647: aload_2
    //   648: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   654: iconst_0
    //   655: ireturn
    //   656: astore_2
    //   657: aload_3
    //   658: astore_2
    //   659: goto -80 -> 579
    //   662: aconst_null
    //   663: astore_2
    //   664: goto -609 -> 55
    //   667: aconst_null
    //   668: astore_1
    //   669: aload_1
    //   670: astore_3
    //   671: goto -425 -> 246
    //   674: ldc 199
    //   676: astore_1
    //   677: goto -236 -> 441
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	680	0	this	GameCenterInterruptPlugin
    //   0	680	1	paramString1	String
    //   0	680	2	paramString2	String
    //   36	635	3	localObject1	java.lang.Object
    //   38	569	4	localObject2	java.lang.Object
    //   33	424	5	localObject3	java.lang.Object
    //   62	462	6	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   4	13	618	java/lang/Exception
    //   15	35	618	java/lang/Exception
    //   45	52	618	java/lang/Exception
    //   55	105	618	java/lang/Exception
    //   109	122	618	java/lang/Exception
    //   125	243	618	java/lang/Exception
    //   254	260	618	java/lang/Exception
    //   260	336	618	java/lang/Exception
    //   339	352	618	java/lang/Exception
    //   352	427	618	java/lang/Exception
    //   432	438	618	java/lang/Exception
    //   444	451	618	java/lang/Exception
    //   455	560	618	java/lang/Exception
    //   562	567	618	java/lang/Exception
    //   567	579	618	java/lang/Exception
    //   579	616	618	java/lang/Exception
    //   567	579	656	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.jsplugin.GameCenterInterruptPlugin
 * JD-Core Version:    0.7.0.1
 */