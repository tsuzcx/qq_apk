package com.tencent.mobileqq.apollo.store.webview;

import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.CmShowRscDownloader;
import com.tencent.mobileqq.apollo.res.api.ICmShowRscCacheManager;
import com.tencent.mobileqq.apollo.res.api.ICmShowRscUpdateHandler;
import com.tencent.mobileqq.apollo.res.api.impl.CmShowRscCacheManagerImpl;
import com.tencent.mobileqq.apollo.res.api.impl.CmShowRscCacheManagerImpl.IdolRscItem;
import com.tencent.mobileqq.apollo.res.api.impl.CmShowRscUpdateHandlerImpl;
import com.tencent.mobileqq.apollo.res.api.impl.CmShowRscUpdateHandlerImpl.OnCheckContentListener;
import com.tencent.mobileqq.apollo.utils.ResponseUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloPluginRscLoader
{
  private VasWebviewJsPlugin a;
  private IApolloResManager b;
  private SparseArray<CmShowRscUpdateHandlerImpl.OnCheckContentListener> c = new SparseArray();
  
  public ApolloPluginRscLoader(VasWebviewJsPlugin paramVasWebviewJsPlugin)
  {
    this.a = paramVasWebviewJsPlugin;
    this.b = ApolloResManagerFacade.a.a(Scene.WEB_STORE_OR_GAME);
  }
  
  /* Error */
  @Nullable
  private WebResourceResponse a(String paramString, AppInterface paramAppInterface)
  {
    // Byte code:
    //   0: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +38 -> 41
    //   6: new 53	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: ldc 56
    //   19: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 4
    //   25: aload_1
    //   26: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 62
    //   32: iconst_2
    //   33: aload 4
    //   35: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_1
    //   42: ldc 72
    //   44: ldc 74
    //   46: invokevirtual 80	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   49: astore 8
    //   51: aload 8
    //   53: invokestatic 84	com/tencent/mobileqq/apollo/store/webview/ApolloPluginRscLoader:f	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore 7
    //   58: aload 7
    //   60: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifeq +37 -> 100
    //   66: new 53	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   73: astore_1
    //   74: aload_1
    //   75: ldc 92
    //   77: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_1
    //   82: aload 7
    //   84: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: ldc 62
    //   90: iconst_1
    //   91: aload_1
    //   92: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aconst_null
    //   99: areturn
    //   100: aload 7
    //   102: invokestatic 98	com/tencent/mobileqq/apollo/store/webview/ApolloPluginRscLoader:e	(Ljava/lang/String;)Z
    //   105: ifne +37 -> 142
    //   108: new 53	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   115: astore_1
    //   116: aload_1
    //   117: ldc 92
    //   119: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_1
    //   124: aload 7
    //   126: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: ldc 62
    //   132: iconst_1
    //   133: aload_1
    //   134: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aconst_null
    //   141: areturn
    //   142: aload 8
    //   144: invokestatic 100	com/tencent/mobileqq/apollo/store/webview/ApolloPluginRscLoader:d	(Ljava/lang/String;)Ljava/lang/String;
    //   147: astore_1
    //   148: aload_1
    //   149: astore 4
    //   151: aload_1
    //   152: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   155: ifeq +16 -> 171
    //   158: aload_1
    //   159: astore 4
    //   161: ldc 62
    //   163: iconst_1
    //   164: ldc 102
    //   166: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: aconst_null
    //   170: areturn
    //   171: aload_1
    //   172: astore 4
    //   174: aload_1
    //   175: invokestatic 107	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   178: astore_1
    //   179: aload_1
    //   180: astore 4
    //   182: aload_1
    //   183: invokestatic 112	com/tencent/open/base/MD5Utils:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   186: astore 5
    //   188: aload_1
    //   189: astore 4
    //   191: aload 5
    //   193: astore 6
    //   195: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +126 -> 324
    //   201: new 53	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   208: astore 4
    //   210: aload 4
    //   212: ldc 114
    //   214: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 4
    //   220: aload_1
    //   221: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: ldc 62
    //   227: iconst_2
    //   228: aload 4
    //   230: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload_1
    //   237: astore 4
    //   239: aload 5
    //   241: astore 6
    //   243: goto +81 -> 324
    //   246: astore 6
    //   248: aload 5
    //   250: astore 4
    //   252: aload 6
    //   254: astore 5
    //   256: goto +25 -> 281
    //   259: astore 5
    //   261: aconst_null
    //   262: astore 6
    //   264: aload 4
    //   266: astore_1
    //   267: aload 6
    //   269: astore 4
    //   271: goto +10 -> 281
    //   274: astore 5
    //   276: aconst_null
    //   277: astore_1
    //   278: aload_1
    //   279: astore 4
    //   281: new 53	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   288: astore 6
    //   290: aload 6
    //   292: ldc 116
    //   294: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 6
    //   300: aload 5
    //   302: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: ldc 62
    //   308: iconst_1
    //   309: aload 6
    //   311: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   317: aload 4
    //   319: astore 6
    //   321: aload_1
    //   322: astore 4
    //   324: aload 6
    //   326: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   329: ifeq +5 -> 334
    //   332: aconst_null
    //   333: areturn
    //   334: new 121	java/io/File
    //   337: dup
    //   338: ldc 123
    //   340: invokespecial 126	java/io/File:<init>	(Ljava/lang/String;)V
    //   343: invokevirtual 129	java/io/File:mkdir	()Z
    //   346: pop
    //   347: new 121	java/io/File
    //   350: dup
    //   351: ldc 131
    //   353: invokespecial 126	java/io/File:<init>	(Ljava/lang/String;)V
    //   356: invokevirtual 129	java/io/File:mkdir	()Z
    //   359: pop
    //   360: new 53	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   367: astore_1
    //   368: aload_1
    //   369: ldc 131
    //   371: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload_1
    //   376: aload 6
    //   378: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload_1
    //   383: getstatic 135	java/io/File:separator	Ljava/lang/String;
    //   386: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload_1
    //   391: aload 7
    //   393: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload_1
    //   398: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: astore_1
    //   402: new 121	java/io/File
    //   405: dup
    //   406: aload_1
    //   407: invokespecial 126	java/io/File:<init>	(Ljava/lang/String;)V
    //   410: astore 5
    //   412: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   415: ifeq +38 -> 453
    //   418: new 53	java/lang/StringBuilder
    //   421: dup
    //   422: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   425: astore 6
    //   427: aload 6
    //   429: ldc 137
    //   431: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: aload 6
    //   437: aload_1
    //   438: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: ldc 62
    //   444: iconst_2
    //   445: aload 6
    //   447: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: aload 5
    //   455: invokevirtual 140	java/io/File:exists	()Z
    //   458: istore_3
    //   459: ldc 142
    //   461: astore_1
    //   462: iload_3
    //   463: ifeq +123 -> 586
    //   466: new 53	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   473: astore_2
    //   474: aload_2
    //   475: ldc 144
    //   477: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload_2
    //   482: aload 8
    //   484: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: ldc 62
    //   490: iconst_1
    //   491: aload_2
    //   492: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: aload 7
    //   500: ldc 149
    //   502: invokevirtual 152	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   505: ifeq +6 -> 511
    //   508: goto +6 -> 514
    //   511: ldc 154
    //   513: astore_1
    //   514: new 156	java/io/FileInputStream
    //   517: dup
    //   518: aload 5
    //   520: invokespecial 159	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   523: astore_2
    //   524: new 161	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   527: dup
    //   528: aload_1
    //   529: ldc 163
    //   531: aload_2
    //   532: invokespecial 166	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   535: astore_1
    //   536: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   539: ifeq +41 -> 580
    //   542: new 53	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   549: astore 4
    //   551: aload 4
    //   553: ldc 168
    //   555: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: aload 4
    //   561: aload_2
    //   562: invokevirtual 172	java/io/FileInputStream:available	()I
    //   565: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: ldc 62
    //   571: iconst_2
    //   572: aload 4
    //   574: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   580: aload_1
    //   581: invokestatic 180	com/tencent/mobileqq/apollo/utils/ResponseUtil:a	(Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;)V
    //   584: aload_1
    //   585: areturn
    //   586: aload 8
    //   588: invokestatic 183	com/tencent/mobileqq/apollo/store/webview/ApolloPluginRscLoader:g	(Ljava/lang/String;)Ljava/lang/String;
    //   591: astore 6
    //   593: aload 6
    //   595: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   598: ifeq +13 -> 611
    //   601: ldc 62
    //   603: iconst_1
    //   604: ldc 185
    //   606: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: aconst_null
    //   610: areturn
    //   611: new 53	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   618: astore 8
    //   620: aload 8
    //   622: ldc 187
    //   624: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload 8
    //   630: aload 4
    //   632: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: ldc 62
    //   638: iconst_1
    //   639: aload 8
    //   641: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   647: aload_0
    //   648: getfield 39	com/tencent/mobileqq/apollo/store/webview/ApolloPluginRscLoader:b	Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;
    //   651: invokeinterface 192 1 0
    //   656: aload_2
    //   657: aload 4
    //   659: new 194	com/tencent/mobileqq/apollo/store/webview/ApolloPluginRscLoader$5
    //   662: dup
    //   663: aload_0
    //   664: aload 5
    //   666: aload 6
    //   668: invokespecial 197	com/tencent/mobileqq/apollo/store/webview/ApolloPluginRscLoader$5:<init>	(Lcom/tencent/mobileqq/apollo/store/webview/ApolloPluginRscLoader;Ljava/io/File;Ljava/lang/String;)V
    //   671: invokeinterface 202 4 0
    //   676: new 204	com/tencent/mobileqq/apollo/store/webview/BridgeStream
    //   679: dup
    //   680: aconst_null
    //   681: aconst_null
    //   682: aconst_null
    //   683: invokespecial 207	com/tencent/mobileqq/apollo/store/webview/BridgeStream:<init>	(Lcom/tencent/mobileqq/apollo/store/webview/BridgeStream$IBridgeStreamCallback;Ljava/io/ByteArrayOutputStream;Ljava/io/BufferedInputStream;)V
    //   686: astore_2
    //   687: aload 7
    //   689: ldc 149
    //   691: invokevirtual 152	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   694: ifeq +6 -> 700
    //   697: goto +6 -> 703
    //   700: ldc 154
    //   702: astore_1
    //   703: new 161	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   706: dup
    //   707: aload_1
    //   708: ldc 163
    //   710: aload_2
    //   711: invokespecial 166	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   714: astore_1
    //   715: aload_1
    //   716: invokestatic 180	com/tencent/mobileqq/apollo/utils/ResponseUtil:a	(Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;)V
    //   719: aload_1
    //   720: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	721	0	this	ApolloPluginRscLoader
    //   0	721	1	paramString	String
    //   0	721	2	paramAppInterface	AppInterface
    //   458	5	3	bool	boolean
    //   13	645	4	localObject1	Object
    //   186	69	5	localObject2	Object
    //   259	1	5	localException1	Exception
    //   274	27	5	localException2	Exception
    //   410	255	5	localFile	File
    //   193	49	6	localObject3	Object
    //   246	7	6	localException3	Exception
    //   262	405	6	localObject4	Object
    //   56	632	7	str	String
    //   49	591	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   195	236	246	java/lang/Exception
    //   151	158	259	java/lang/Exception
    //   161	169	259	java/lang/Exception
    //   174	179	259	java/lang/Exception
    //   182	188	259	java/lang/Exception
    //   142	148	274	java/lang/Exception
  }
  
  private JSONObject a(int paramInt1, String paramString, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("resType", paramInt1);
      localJSONObject.put("resId", paramString);
      localJSONObject.put("resultCode", paramInt2);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      QLog.e("[cmshow]ApolloPluginRscLoader", 1, paramString, new Object[0]);
    }
    return localJSONObject;
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      if (this.a == null) {
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", paramInt);
      localJSONObject.put("msg", paramString2);
      VasWebviewJsPlugin localVasWebviewJsPlugin = this.a;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString1);
      localStringBuilder2.append("(");
      localStringBuilder2.append(localJSONObject.toString());
      localStringBuilder2.append(");");
      localVasWebviewJsPlugin.callJs(localStringBuilder2.toString());
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]ApolloPluginRscLoader", 1, localException.getMessage());
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("callbackId->");
      localStringBuilder1.append(paramString1);
      localStringBuilder1.append(" retCode:");
      localStringBuilder1.append(paramInt);
      localStringBuilder1.append(" errorMsg: ");
      localStringBuilder1.append(paramString2);
      QLog.i("[cmshow]ApolloPluginRscLoader", 2, localStringBuilder1.toString());
    }
  }
  
  private void a(int[] paramArrayOfInt, String paramString, JSONArray paramJSONArray)
  {
    QLog.i("[cmshow]ApolloPluginRscLoader", 1, "checkRoomRsc");
    if (paramArrayOfInt == null) {
      return;
    }
    AppInterface localAppInterface = this.a.mRuntime.b();
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    int i = 0;
    int j = 0;
    while (i < paramArrayOfInt.length)
    {
      CmShowRscCacheManagerImpl.IdolRscItem localIdolRscItem = ((CmShowRscCacheManagerImpl)QRoute.api(ICmShowRscCacheManager.class)).getRscItem(8, paramArrayOfInt[i]);
      if (localIdolRscItem == null) {
        j = 1;
      } else {
        localArrayList.add(localIdolRscItem);
      }
      i += 1;
    }
    if (j != 0)
    {
      localArrayList.clear();
      i = paramArrayOfInt.hashCode();
      paramArrayOfInt = new ApolloPluginRscLoader.3(this, i, paramArrayOfInt, localArrayList, localAppInterface, paramJSONArray, paramString);
      this.c.put(i, paramArrayOfInt);
      paramString = (CmShowRscUpdateHandlerImpl)QRoute.api(ICmShowRscUpdateHandler.class);
      paramString.addCheckListener(i, paramArrayOfInt);
      paramString.checkCmShowContentUpdate(localAppInterface, i, true);
      return;
    }
    if (localArrayList.isEmpty())
    {
      i = k;
      while (i < paramArrayOfInt.length)
      {
        paramJSONArray.put(a(8, String.valueOf(paramArrayOfInt[i]), 2));
        i += 1;
      }
      a(paramString, HardCodeUtil.a(2131898743), paramJSONArray);
      return;
    }
    CmShowRscDownloader.a(localAppInterface, "", new ApolloPluginRscLoader.4(this, paramArrayOfInt, paramJSONArray, paramString), localArrayList, false, null);
  }
  
  private byte[] a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      int j;
      int i;
      try
      {
        Object localObject1 = new File(paramString);
        if (!((File)localObject1).exists()) {
          return null;
        }
        localObject1 = ((File)localObject1).listFiles();
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          Object localObject2 = new ArrayList();
          int m = localObject1.length;
          j = 0;
          k = 6;
          String str;
          Object localObject3;
          if (j < m)
          {
            str = localObject1[j];
            localObject3 = str.getName();
            if (paramBoolean)
            {
              i = k;
              if (!((String)localObject3).endsWith("face.json")) {
                break label540;
              }
              i = (int)(k + (((String)localObject3).getBytes().length + 1 + 4 + str.length()));
              ((List)localObject2).add(localObject3);
              break label540;
            }
            if ((!((String)localObject3).endsWith("bin")) && (!((String)localObject3).endsWith("etc")) && (!((String)localObject3).endsWith("png")))
            {
              i = k;
              if (!((String)localObject3).endsWith("pvr")) {
                break label540;
              }
            }
            i = (int)(k + (((String)localObject3).getBytes().length + 1 + 4 + str.length()));
            ((List)localObject2).add(localObject3);
            break label540;
          }
          localObject1 = new ByteArrayOutputStream(k);
          ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 24 & 0xFF);
          ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 16 & 0xFF);
          ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 8 & 0xFF);
          ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 0 & 0xFF);
          ((ByteArrayOutputStream)localObject1).write((byte)paramInt2);
          ((ByteArrayOutputStream)localObject1).write((byte)((List)localObject2).size());
          localObject2 = ((List)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            str = (String)((Iterator)localObject2).next();
            localObject3 = new File(paramString, str);
            paramInt1 = (int)((File)localObject3).length();
            Object localObject4 = FileUtils.readFile(((File)localObject3).getAbsolutePath());
            if (localObject4 != null)
            {
              ((ByteArrayOutputStream)localObject1).write((byte)str.getBytes().length);
              ((ByteArrayOutputStream)localObject1).write(str.getBytes("utf-8"));
              ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 24 & 0xFF);
              ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 16 & 0xFF);
              ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 8 & 0xFF);
              ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 0 & 0xFF);
              ((ByteArrayOutputStream)localObject1).write((byte[])localObject4);
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(" length:");
            ((StringBuilder)localObject4).append(((File)localObject3).length());
            QLog.d("[cmshow]ApolloPluginRscLoader", 2, new Object[] { "getResourceResponse name:", str, ((StringBuilder)localObject4).toString() });
            continue;
          }
          paramString = ((ByteArrayOutputStream)localObject1).toByteArray();
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("[cmshow]ApolloPluginRscLoader", 1, paramString, new Object[0]);
      }
      return null;
      label540:
      j += 1;
      int k = i;
    }
  }
  
  @Nullable
  private WebResourceResponse b(String paramString, AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getApolloRsc resourceUrl:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("[cmshow]ApolloPluginRscLoader", 2, ((StringBuilder)localObject1).toString());
    }
    paramString = paramString.replace("https://cmshow.qq.com/3dresource/Action/", "");
    int i = ApolloUtilImpl.parseToInt(d(paramString));
    Object localObject1 = f(paramString);
    if ((i > 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      if (!e((String)localObject1))
      {
        paramString = new StringBuilder();
        paramString.append("getApolloRsc error rscName:");
        paramString.append((String)localObject1);
        QLog.e("[cmshow]ApolloPluginRscLoader", 1, paramString.toString());
        return null;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = new File((String)localObject2);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getApolloRsc path:");
        localStringBuilder.append((String)localObject2);
        QLog.d("[cmshow]ApolloPluginRscLoader", 2, localStringBuilder.toString());
      }
      if (((File)localObject1).exists())
      {
        paramString = new FileInputStream((File)localObject1);
        paramAppInterface = new WebResourceResponse("application/octet-stream", "utf-8", paramString);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getApolloRsc inputStream.available();:");
          ((StringBuilder)localObject1).append(paramString.available());
          QLog.d("[cmshow]ApolloPluginRscLoader", 2, ((StringBuilder)localObject1).toString());
        }
        ResponseUtil.a(paramAppInterface);
        return paramAppInterface;
      }
      localObject2 = g(paramString);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("getApolloRsc error callbackId is null resourceUrl:");
        paramAppInterface.append(paramString);
        QLog.e("[cmshow]ApolloPluginRscLoader", 1, paramAppInterface.toString());
        return null;
      }
      if (this.b.c(i, 0))
      {
        paramString = new StringBuilder();
        paramString.append(i);
        paramString.append(HardCodeUtil.a(2131898748));
        a((String)localObject2, 1, paramString.toString());
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("getApolloRsc start download actionId:");
        paramString.append(i);
        QLog.d("[cmshow]ApolloPluginRscLoader", 1, paramString.toString());
        this.b.a().b(paramAppInterface, null, new ApolloPluginRscLoader.6(this, (File)localObject1, (String)localObject2), -1, null, i, -1, false);
      }
      paramString = new WebResourceResponse("application/octet-stream", "utf-8", new BridgeStream(null, null, null));
      ResponseUtil.a(paramString);
      return paramString;
    }
    paramString = new StringBuilder();
    paramString.append("getApolloRsc error rscName:");
    paramString.append((String)localObject1);
    paramString.append(" actionId:");
    paramString.append(i);
    QLog.e("[cmshow]ApolloPluginRscLoader", 1, paramString.toString());
    return null;
  }
  
  private WebResourceResponse c(String paramString)
  {
    if (!paramString.contains("https://cmshow.qq.com/3dresource/combination")) {
      return null;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getCombination url:");
    ((StringBuilder)localObject1).append(paramString);
    QLog.i("[cmshow]ApolloPluginRscLoader", 1, ((StringBuilder)localObject1).toString());
    try
    {
      localAppInterface = this.a.mRuntime.b();
      localObject1 = Uri.parse(paramString);
      if (!((Uri)localObject1).isHierarchical()) {
        break label1184;
      }
      localObject2 = ((Uri)localObject1).getQueryParameter("roleId");
      bool2 = TextUtils.isEmpty((CharSequence)localObject2);
      if (bool2) {
        break label1275;
      }
      i = ApolloUtilImpl.parseToInt((String)localObject2);
      bool2 = this.b.b(i) & true;
      QLog.d("[cmshow]ApolloPluginRscLoader", 1, new Object[] { "getCombination roleId:", Integer.valueOf(i), " resExsit:", Boolean.valueOf(bool2) });
      localObject2 = ((Uri)localObject1).getQueryParameter("dressIds");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label1286;
      }
      localObject3 = new JSONArray((String)localObject2);
      if (((JSONArray)localObject3).length() <= 0) {
        break label1286;
      }
      k = ((JSONArray)localObject3).length();
      localObject2 = new int[k];
      j = 0;
      while (j < k)
      {
        localObject2[j] = ((JSONArray)localObject3).optInt(j);
        bool2 &= this.b.a(localObject2[j]);
        j += 1;
      }
      label249:
      str2 = ((Uri)localObject1).getQueryParameter("faceDataUrl");
      str1 = ((Uri)localObject1).getQueryParameter("callbackId");
      if (TextUtils.isEmpty(str2)) {
        break label1292;
      }
      localObject3 = MD5Utils.toMD5(URLDecoder.decode(str2));
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress//face/");
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append(File.separator);
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append(".zip");
      localObject3 = new File(((StringBuilder)localObject4).toString());
      bool2 &= ((File)localObject3).exists();
      label365:
      QLog.d("[cmshow]ApolloPluginRscLoader", 1, new Object[] { "getCombination faceDataUrl:", str2, " resExsit:", Boolean.valueOf(bool2) });
      str3 = ((Uri)localObject1).getQueryParameter("roomIds");
      localArrayList = new ArrayList();
      if (TextUtils.isEmpty(str3)) {
        break label1316;
      }
      localObject4 = new JSONArray(str3);
      if (((JSONArray)localObject4).length() <= 0) {
        break label1316;
      }
      j = ((JSONArray)localObject4).length();
      localObject1 = new int[j];
      k = 0;
      label460:
      if (k >= j) {
        break label1313;
      }
      localObject1[k] = ((JSONArray)localObject4).optInt(k);
      CmShowRscCacheManagerImpl.IdolRscItem localIdolRscItem = ((CmShowRscCacheManagerImpl)QRoute.api(ICmShowRscCacheManager.class)).getRscItem(8, localObject1[k]);
      if ((localIdolRscItem == null) || (!localIdolRscItem.c())) {
        break label1298;
      }
      bool1 = true;
      label518:
      bool2 &= bool1;
      if (localIdolRscItem == null) {
        break label1304;
      }
      localArrayList.add(localIdolRscItem);
    }
    catch (Exception localException1)
    {
      try
      {
        AppInterface localAppInterface;
        int j;
        String str2;
        String str1;
        Object localObject4;
        String str3;
        ArrayList localArrayList;
        label543:
        localObject2 = a(6, str2, 0);
        ((JSONArray)localObject4).put(localObject2);
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          a((int[])localObject1, str1, (JSONArray)localObject4);
        }
        else
        {
          a(str1, HardCodeUtil.a(2131898739), (JSONArray)localObject4);
          break label1184;
          this.b.a().b(localAppInterface, "", new ApolloPluginRscLoader.1(this, (JSONArray)localObject4, (File)localObject3, localAppInterface, str2, (int[])localObject1, str1), i, (int[])localObject2, -1, -1, false);
        }
        localObject1 = ResponseUtil.a();
        ResponseUtil.a((WebResourceResponse)localObject1);
        return localObject1;
      }
      catch (Exception localException2)
      {
        Object localObject2;
        boolean bool2;
        int i;
        Object localObject3;
        int k;
        boolean bool1;
        break label1199;
      }
      localException1 = localException1;
    }
    QLog.d("[cmshow]ApolloPluginRscLoader", 1, new Object[] { "getCombination roomIdStr:", str3, " resExsit:", Boolean.valueOf(bool2) });
    if (bool2)
    {
      localObject1 = new ByteArrayOutputStream();
      if (localObject3 != null)
      {
        localObject3 = a(0, 6, ((File)localObject3).getParent(), true);
        if (localObject3 != null) {
          ((ByteArrayOutputStream)localObject1).write((byte[])localObject3);
        }
      }
      if (i <= 0) {
        break label1322;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append(File.separator);
      localObject3 = a(i, 1, ((StringBuilder)localObject3).toString(), false);
      if (localObject3 == null) {
        break label1322;
      }
      ((ByteArrayOutputStream)localObject1).write((byte[])localObject3);
      break label1322;
      label691:
      if (i >= localObject2.length) {
        break label1339;
      }
      j = localObject2[i];
      localObject2[i] = j;
      QLog.d("[cmshow]ApolloPluginRscLoader", 2, new Object[] { "getCombination dressId:", Integer.valueOf(j) });
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/");
      ((StringBuilder)localObject3).append(j);
      ((StringBuilder)localObject3).append(File.separator);
      localObject3 = a(j, 2, ((StringBuilder)localObject3).toString(), false);
      if (localObject3 == null) {
        break label1332;
      }
      ((ByteArrayOutputStream)localObject1).write((byte[])localObject3);
      break label1332;
    }
    for (;;)
    {
      if (i < localArrayList.size())
      {
        localObject2 = (CmShowRscCacheManagerImpl.IdolRscItem)localArrayList.get(i);
        j = ((CmShowRscCacheManagerImpl.IdolRscItem)localObject2).c;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/room/");
        ((StringBuilder)localObject3).append(((CmShowRscCacheManagerImpl.IdolRscItem)localObject2).c);
        ((StringBuilder)localObject3).append(File.separator);
        localObject2 = a(j, 8, ((StringBuilder)localObject3).toString(), false);
        if (localObject2 != null) {
          ((ByteArrayOutputStream)localObject1).write((byte[])localObject2);
        }
      }
      else
      {
        localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" retBytes:");
        ((StringBuilder)localObject2).append(localObject1.length);
        QLog.d("[cmshow]ApolloPluginRscLoader", 1, new Object[] { "getCombination url:", paramString, ((StringBuilder)localObject2).toString() });
        localObject1 = new WebResourceResponse("application/octet-stream", "utf-8", new ByteArrayInputStream((byte[])localObject1));
        ResponseUtil.a((WebResourceResponse)localObject1);
        return localObject1;
        localObject4 = new JSONArray();
        if ((i <= 0) && ((localObject2 == null) || (localObject2.length <= 0)))
        {
          if ((localObject3 != null) && (!((File)localObject3).exists()))
          {
            this.b.a().a(localAppInterface, str2, new ApolloPluginRscLoader.2(this, str2, (File)localObject3, (JSONArray)localObject4, (int[])localObject1, str1));
            break label1184;
          }
          bool2 = TextUtils.isEmpty(str2);
          if (bool2) {}
        }
        label1184:
        label1199:
        QLog.e("[cmshow]ApolloPluginRscLoader", 1, localException1, new Object[0]);
        WebResourceResponse localWebResourceResponse = ResponseUtil.a();
        ResponseUtil.a(localWebResourceResponse);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getCombination url 解析失败:");
        ((StringBuilder)localObject2).append(paramString);
        QLog.e("[cmshow]ApolloPluginRscLoader", 1, ((StringBuilder)localObject2).toString());
        a(g(paramString), -1, HardCodeUtil.a(2131898753));
        return localWebResourceResponse;
        label1275:
        i = -1;
        bool2 = true;
        break;
        break label249;
        label1286:
        localObject2 = null;
        break label249;
        label1292:
        localObject3 = null;
        break label365;
        label1298:
        bool1 = false;
        break label518;
        label1304:
        k += 1;
        break label460;
        label1313:
        break label543;
        label1316:
        localWebResourceResponse = null;
        break label543;
        label1322:
        if (localObject2 != null)
        {
          i = 0;
          break label691;
          label1332:
          i += 1;
          break label691;
        }
        label1339:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  @Nullable
  private WebResourceResponse c(String paramString, AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getApolloRsc resourceUrl:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("[cmshow]ApolloPluginRscLoader", 2, ((StringBuilder)localObject1).toString());
    }
    paramString = paramString.replace("https://cmshow.qq.com/3dresource/Dress/", "");
    int i = ApolloUtilImpl.parseToInt(d(paramString));
    Object localObject1 = f(paramString);
    if ((i > 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      if (!e((String)localObject1))
      {
        paramString = new StringBuilder();
        paramString.append("getApolloRsc error rscName:");
        paramString.append((String)localObject1);
        QLog.e("[cmshow]ApolloPluginRscLoader", 1, paramString.toString());
        return null;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = new File((String)localObject2);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getApolloRsc path:");
        localStringBuilder.append((String)localObject2);
        QLog.d("[cmshow]ApolloPluginRscLoader", 2, localStringBuilder.toString());
      }
      if (((File)localObject1).exists())
      {
        paramString = new FileInputStream((File)localObject1);
        if (QLog.isColorLevel())
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("getApolloRsc inputStream.available();:");
          paramAppInterface.append(paramString.available());
          QLog.d("[cmshow]ApolloPluginRscLoader", 2, paramAppInterface.toString());
        }
        paramString = new WebResourceResponse("application/octet-stream", "utf-8", paramString);
        ResponseUtil.a(paramString);
        return paramString;
      }
      localObject2 = g(paramString);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("getApolloRsc error callbackId is null resourceUrl:");
        paramAppInterface.append(paramString);
        QLog.e("[cmshow]ApolloPluginRscLoader", 1, paramAppInterface.toString());
        return null;
      }
      if (this.b.a(i))
      {
        paramString = new StringBuilder();
        paramString.append(i);
        paramString.append(HardCodeUtil.a(2131898759));
        a((String)localObject2, 1, paramString.toString());
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("getApolloRsc start download dressId:");
        paramString.append(i);
        QLog.d("[cmshow]ApolloPluginRscLoader", 1, paramString.toString());
        this.b.a().b(paramAppInterface, null, new ApolloPluginRscLoader.7(this, i, (File)localObject1, (String)localObject2), -1, new int[] { i }, -1, -1, false);
      }
      paramString = new WebResourceResponse("application/octet-stream", "utf-8", new BridgeStream(null, null, null));
      ResponseUtil.a(paramString);
      return paramString;
    }
    paramString = new StringBuilder();
    paramString.append("getApolloRsc error rscName:");
    paramString.append((String)localObject1);
    paramString.append(" dressId:");
    paramString.append(i);
    QLog.e("[cmshow]ApolloPluginRscLoader", 1, paramString.toString());
    return null;
  }
  
  @Nullable
  private WebResourceResponse d(String paramString, AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getApolloRsc resourceUrl:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("[cmshow]ApolloPluginRscLoader", 2, ((StringBuilder)localObject1).toString());
    }
    paramString = paramString.replace("https://cmshow.qq.com/3dresource/Role/", "");
    int i = ApolloUtilImpl.parseToInt(d(paramString));
    Object localObject1 = f(paramString);
    if ((i > 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      if (!e((String)localObject1))
      {
        paramString = new StringBuilder();
        paramString.append("getApolloRsc error rscName:");
        paramString.append((String)localObject1);
        QLog.e("[cmshow]ApolloPluginRscLoader", 1, paramString.toString());
        return null;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = new File((String)localObject2);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getApolloRsc path:");
        localStringBuilder.append((String)localObject2);
        QLog.d("[cmshow]ApolloPluginRscLoader", 2, localStringBuilder.toString());
      }
      if (((File)localObject1).exists())
      {
        paramString = new FileInputStream((File)localObject1);
        paramAppInterface = new WebResourceResponse("application/octet-stream", "utf-8", paramString);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getApolloRsc inputStream.available();:");
          ((StringBuilder)localObject1).append(paramString.available());
          QLog.d("[cmshow]ApolloPluginRscLoader", 2, ((StringBuilder)localObject1).toString());
        }
        ResponseUtil.a(paramAppInterface);
        return paramAppInterface;
      }
      localObject2 = g(paramString);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("getApolloRsc error callbackId is null resourceUrl:");
        paramAppInterface.append(paramString);
        QLog.e("[cmshow]ApolloPluginRscLoader", 1, paramAppInterface.toString());
        return null;
      }
      if (this.b.b(i))
      {
        paramString = new StringBuilder();
        paramString.append(i);
        paramString.append(HardCodeUtil.a(2131898747));
        a((String)localObject2, 1, paramString.toString());
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("getApolloRsc start download roleId:");
        paramString.append(i);
        QLog.d("[cmshow]ApolloPluginRscLoader", 1, paramString.toString());
        this.b.a().b(paramAppInterface, null, new ApolloPluginRscLoader.8(this, (File)localObject1, (String)localObject2), i, null, -1, -1, false);
      }
      paramString = new WebResourceResponse("application/octet-stream", "utf-8", new BridgeStream(null, null, null));
      ResponseUtil.a(paramString);
      return paramString;
    }
    paramString = new StringBuilder();
    paramString.append("getApolloRsc error rscName:");
    paramString.append((String)localObject1);
    paramString.append(" roleId:");
    paramString.append(i);
    QLog.e("[cmshow]ApolloPluginRscLoader", 1, paramString.toString());
    return null;
  }
  
  private static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = paramString.indexOf("/");
    if (i > 0) {
      return paramString.substring(0, i);
    }
    return "";
  }
  
  @Nullable
  private WebResourceResponse e(String paramString, AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getApolloRsc resourceUrl:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("[cmshow]ApolloPluginRscLoader", 2, ((StringBuilder)localObject1).toString());
    }
    paramString = paramString.replace("https://cmshow.qq.com/3dresource/Room/", "");
    int i = ApolloUtilImpl.parseToInt(d(paramString));
    Object localObject1 = f(paramString);
    if ((i > 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      if (!e((String)localObject1))
      {
        paramString = new StringBuilder();
        paramString.append("getApolloRsc error rscName:");
        paramString.append((String)localObject1);
        paramString.append(" roomId:");
        paramString.append(i);
        QLog.e("[cmshow]ApolloPluginRscLoader", 1, paramString.toString());
        return null;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/room/");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = new File((String)localObject2);
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getApolloRsc path:");
        ((StringBuilder)localObject3).append((String)localObject2);
        QLog.d("[cmshow]ApolloPluginRscLoader", 2, ((StringBuilder)localObject3).toString());
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getApolloRsc start download roomId:");
      ((StringBuilder)localObject2).append(i);
      QLog.d("[cmshow]ApolloPluginRscLoader", 1, ((StringBuilder)localObject2).toString());
      localObject2 = ((CmShowRscCacheManagerImpl)QRoute.api(ICmShowRscCacheManager.class)).getRscItem(8, i);
      if (localObject2 == null)
      {
        QLog.i("[cmshow]ApolloPluginRscLoader", 1, "idolRscItem == null ");
        int j = ((File)localObject1).hashCode();
        localObject2 = (CmShowRscUpdateHandlerImpl)QRoute.api(ICmShowRscUpdateHandler.class);
        ((CmShowRscUpdateHandlerImpl)localObject2).checkCmShowContentUpdate(paramAppInterface, j, true);
        ((CmShowRscUpdateHandlerImpl)localObject2).addCheckListener(j, new ApolloPluginRscLoader.9(this, i, paramString, paramAppInterface, (File)localObject1));
      }
      else if (((CmShowRscCacheManagerImpl.IdolRscItem)localObject2).c())
      {
        if (((File)localObject1).exists())
        {
          paramString = new FileInputStream((File)localObject1);
          paramAppInterface = new WebResourceResponse("application/octet-stream", "utf-8", paramString);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("getApolloRsc inputStream.available();:");
            ((StringBuilder)localObject1).append(paramString.available());
            QLog.d("[cmshow]ApolloPluginRscLoader", 2, ((StringBuilder)localObject1).toString());
          }
          ResponseUtil.a(paramAppInterface);
          return paramAppInterface;
        }
        paramAppInterface = g(paramString);
        if (TextUtils.isEmpty(paramAppInterface))
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("getApolloRsc error callbackId is null resourceUrl:");
          paramAppInterface.append(paramString);
          QLog.e("[cmshow]ApolloPluginRscLoader", 1, paramAppInterface.toString());
          return null;
        }
        paramString = new StringBuilder();
        paramString.append(i);
        paramString.append(HardCodeUtil.a(2131898738));
        a(paramAppInterface, 1, paramString.toString());
      }
      else
      {
        localObject3 = new ArrayList();
        ((List)localObject3).add(localObject2);
        CmShowRscDownloader.a(paramAppInterface, "", new ApolloPluginRscLoader.10(this, paramString, (File)localObject1, i), (List)localObject3, false, null);
      }
      paramString = new WebResourceResponse("application/octet-stream", "utf-8", new BridgeStream(null, null, null));
      ResponseUtil.a(paramString);
      return paramString;
    }
    paramString = new StringBuilder();
    paramString.append("getApolloRsc error rscName:");
    paramString.append((String)localObject1);
    paramString.append(" roomId:");
    paramString.append(i);
    QLog.e("[cmshow]ApolloPluginRscLoader", 1, paramString.toString());
    return null;
  }
  
  private static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return !paramString.contains("..");
  }
  
  private static String f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = paramString.indexOf("/");
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(i + 1);
    }
    i = str.indexOf("?");
    paramString = str;
    if (i > 0) {
      paramString = str.substring(0, i);
    }
    return paramString;
  }
  
  private static String g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Uri.parse(paramString);
      if (paramString.isHierarchical())
      {
        paramString = paramString.getQueryParameter("callbackId");
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("[cmshow]ApolloPluginRscLoader", 2, paramString, new Object[0]);
    }
    return null;
  }
  
  public WebResourceResponse a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((VasWebviewJsPlugin)localObject).mRuntime == null) {
        return null;
      }
      localObject = this.a.mRuntime.b();
      try
      {
        paramString = paramString.replace("https://open.cmshow.qq.com", "https://cmshow.qq.com");
        WebResourceResponse localWebResourceResponse = c(paramString);
        if (localWebResourceResponse != null)
        {
          ResponseUtil.a(localWebResourceResponse);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getApolloRsc getCombination resourceUrl:");
          ((StringBuilder)localObject).append(paramString);
          QLog.i("[cmshow]ApolloPluginRscLoader", 1, ((StringBuilder)localObject).toString());
          return localWebResourceResponse;
        }
        if (paramString.startsWith("https://cmshow.qq.com/3dresource/Room/")) {
          return e(paramString, (AppInterface)localObject);
        }
        if (paramString.startsWith("https://cmshow.qq.com/3dresource/Role/")) {
          return d(paramString, (AppInterface)localObject);
        }
        if (paramString.startsWith("https://cmshow.qq.com/3dresource/Dress/")) {
          return c(paramString, (AppInterface)localObject);
        }
        if (paramString.startsWith("https://cmshow.qq.com/3dresource/Action/")) {
          return b(paramString, (AppInterface)localObject);
        }
        if (paramString.startsWith("https://cmshow.qq.com/3dresource/FaceData/"))
        {
          paramString = a(paramString, (AppInterface)localObject);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("[cmshow]ApolloPluginRscLoader", 2, paramString, new Object[0]);
      }
    }
    return null;
  }
  
  void a(String paramString1, String paramString2, JSONArray paramJSONArray)
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.a == null) {
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        i = 0;
        localJSONObject.put("result", 0);
        localJSONObject.put("msg", paramString2);
        if (paramJSONArray != null)
        {
          localJSONObject.put("IdStates", paramJSONArray);
          int j = paramJSONArray.length();
          if (i < j)
          {
            paramString2 = paramJSONArray.optJSONObject(i);
            if ((paramString2 == null) || (paramString2.optInt("resultCode") == 0)) {
              break label200;
            }
            localJSONObject.put("result", 2);
          }
        }
        paramString2 = this.a;
        paramJSONArray = new StringBuilder();
        paramJSONArray.append(paramString1);
        paramJSONArray.append("(");
        paramJSONArray.append(localJSONObject.toString());
        paramJSONArray.append(");");
        paramString2.callJs(paramJSONArray.toString());
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("callbackIdStatesResult result:");
          paramString1.append(localJSONObject);
          QLog.i("[cmshow]ApolloPluginRscLoader", 2, paramString1.toString());
          return;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("[cmshow]ApolloPluginRscLoader", 1, paramString1.getMessage());
      }
      return;
      label200:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader
 * JD-Core Version:    0.7.0.1
 */