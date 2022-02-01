package com.tencent.hippy.qq.offline;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.webviewplugin.OfflineWebResManager;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class HippyOfflineAssist
{
  public static final String TAG = "HippyOfflineAssist";
  public static OfflineWebResManager mOfflineResManager;
  
  private static AppInterface getApp()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (MobileQQ.sProcessId == 7)
    {
      localAppRuntime = localAppRuntime.getAppRuntime("modular_web");
      if ((localAppRuntime instanceof AppInterface)) {
        return (AppInterface)localAppRuntime;
      }
    }
    else if ((localAppRuntime instanceof AppInterface))
    {
      return (AppInterface)localAppRuntime;
    }
    return null;
  }
  
  /* Error */
  protected static String getOfflineResFromDatabase(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +591 -> 594
    //   6: new 53	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   13: astore 11
    //   15: aload 11
    //   17: ldc 56
    //   19: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 11
    //   25: aload_0
    //   26: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 8
    //   32: iconst_2
    //   33: aload 11
    //   35: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: goto +3 -> 44
    //   44: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   47: lstore_2
    //   48: getstatic 80	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   51: ifnull +42 -> 93
    //   54: getstatic 80	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   57: aload_1
    //   58: invokevirtual 86	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   61: ifeq +32 -> 93
    //   64: getstatic 80	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   67: aload_1
    //   68: invokevirtual 90	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast 92	java/lang/String
    //   74: astore 12
    //   76: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +518 -> 597
    //   82: ldc 8
    //   84: iconst_2
    //   85: ldc 94
    //   87: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: goto +507 -> 597
    //   93: new 53	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   100: astore 11
    //   102: aload 11
    //   104: aload_1
    //   105: invokestatic 99	com/tencent/biz/common/offline/OfflineEnvHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   108: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 11
    //   114: aload_1
    //   115: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 11
    //   121: ldc 101
    //   123: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 11
    //   129: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore 11
    //   134: new 103	java/io/File
    //   137: dup
    //   138: aload 11
    //   140: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   143: invokevirtual 109	java/io/File:exists	()Z
    //   146: istore 10
    //   148: iload 10
    //   150: ifne +5 -> 155
    //   153: aconst_null
    //   154: areturn
    //   155: new 111	java/io/BufferedInputStream
    //   158: dup
    //   159: new 113	java/io/FileInputStream
    //   162: dup
    //   163: aload 11
    //   165: invokespecial 114	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   168: invokespecial 117	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   171: astore 11
    //   173: aload 11
    //   175: astore 12
    //   177: aload 11
    //   179: invokestatic 122	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   182: astore 14
    //   184: aload 11
    //   186: astore 12
    //   188: getstatic 80	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   191: aload_1
    //   192: aload 14
    //   194: invokevirtual 126	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   197: pop
    //   198: aload 14
    //   200: astore_1
    //   201: aload 11
    //   203: astore 13
    //   205: aload 11
    //   207: astore 12
    //   209: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +22 -> 234
    //   215: aload 11
    //   217: astore 12
    //   219: ldc 8
    //   221: iconst_2
    //   222: ldc 128
    //   224: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: aload 11
    //   229: astore 13
    //   231: aload 14
    //   233: astore_1
    //   234: aload 13
    //   236: invokevirtual 131	java/io/BufferedInputStream:close	()V
    //   239: aload_1
    //   240: astore 12
    //   242: goto +62 -> 304
    //   245: astore 13
    //   247: aload 14
    //   249: astore_1
    //   250: goto +24 -> 274
    //   253: astore 13
    //   255: aconst_null
    //   256: astore_1
    //   257: goto +17 -> 274
    //   260: astore_0
    //   261: aconst_null
    //   262: astore 12
    //   264: goto +306 -> 570
    //   267: astore 13
    //   269: aconst_null
    //   270: astore_1
    //   271: aload_1
    //   272: astore 11
    //   274: aload 11
    //   276: astore 12
    //   278: ldc 8
    //   280: iconst_1
    //   281: aload 13
    //   283: invokevirtual 134	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   286: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: aload_1
    //   290: astore 12
    //   292: aload 11
    //   294: ifnull +10 -> 304
    //   297: aload 11
    //   299: astore 13
    //   301: goto -67 -> 234
    //   304: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   307: lstore 4
    //   309: aload 12
    //   311: invokestatic 143	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   314: ifeq +5 -> 319
    //   317: aconst_null
    //   318: areturn
    //   319: new 145	org/json/JSONObject
    //   322: dup
    //   323: aload 12
    //   325: invokespecial 146	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   328: aload_0
    //   329: invokestatic 148	com/tencent/biz/common/offline/HtmlOffline:d	(Ljava/lang/String;)Ljava/lang/String;
    //   332: invokevirtual 151	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   335: astore_1
    //   336: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   339: lstore 6
    //   341: invokestatic 153	com/tencent/hippy/qq/offline/HippyOfflineAssist:getApp	()Lcom/tencent/common/app/AppInterface;
    //   344: astore 11
    //   346: aload 11
    //   348: ifnonnull +5 -> 353
    //   351: aconst_null
    //   352: areturn
    //   353: getstatic 155	com/tencent/hippy/qq/offline/HippyOfflineAssist:mOfflineResManager	Lcom/tencent/biz/webviewplugin/OfflineWebResManager;
    //   356: ifnonnull +15 -> 371
    //   359: new 157	com/tencent/biz/webviewplugin/OfflineWebResManager
    //   362: dup
    //   363: aload 11
    //   365: invokespecial 160	com/tencent/biz/webviewplugin/OfflineWebResManager:<init>	(Lcom/tencent/common/app/AppInterface;)V
    //   368: putstatic 155	com/tencent/hippy/qq/offline/HippyOfflineAssist:mOfflineResManager	Lcom/tencent/biz/webviewplugin/OfflineWebResManager;
    //   371: getstatic 155	com/tencent/hippy/qq/offline/HippyOfflineAssist:mOfflineResManager	Lcom/tencent/biz/webviewplugin/OfflineWebResManager;
    //   374: aload_1
    //   375: invokevirtual 163	com/tencent/biz/webviewplugin/OfflineWebResManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/OfflineWebRes;
    //   378: astore_1
    //   379: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   382: lstore 8
    //   384: aload_1
    //   385: ifnonnull +5 -> 390
    //   388: aconst_null
    //   389: areturn
    //   390: new 103	java/io/File
    //   393: dup
    //   394: invokestatic 169	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   397: invokevirtual 173	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   400: ldc 175
    //   402: invokespecial 178	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   405: astore 11
    //   407: aload 11
    //   409: invokevirtual 109	java/io/File:exists	()Z
    //   412: ifne +13 -> 425
    //   415: aload 11
    //   417: invokevirtual 181	java/io/File:mkdirs	()Z
    //   420: ifne +5 -> 425
    //   423: aconst_null
    //   424: areturn
    //   425: new 103	java/io/File
    //   428: dup
    //   429: aload 11
    //   431: aload_1
    //   432: getfield 186	com/tencent/mobileqq/data/OfflineWebRes:hashName	Ljava/lang/String;
    //   435: invokespecial 178	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   438: astore_1
    //   439: aload_1
    //   440: invokevirtual 109	java/io/File:exists	()Z
    //   443: ifeq +157 -> 600
    //   446: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   449: ifeq +116 -> 565
    //   452: new 53	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   459: astore 11
    //   461: aload 11
    //   463: ldc 188
    //   465: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload 11
    //   471: lload 4
    //   473: lload_2
    //   474: lsub
    //   475: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload 11
    //   481: ldc 193
    //   483: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload 11
    //   489: lload 6
    //   491: lload 4
    //   493: lsub
    //   494: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload 11
    //   500: ldc 195
    //   502: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload 11
    //   508: lload 8
    //   510: lload 6
    //   512: lsub
    //   513: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: aload 11
    //   519: ldc 197
    //   521: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: aload 11
    //   527: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   530: lload_2
    //   531: lsub
    //   532: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: aload 11
    //   538: ldc 199
    //   540: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload 11
    //   546: aload_0
    //   547: invokestatic 148	com/tencent/biz/common/offline/HtmlOffline:d	(Ljava/lang/String;)Ljava/lang/String;
    //   550: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: ldc 8
    //   556: iconst_2
    //   557: aload 11
    //   559: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   565: aload_1
    //   566: invokevirtual 202	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   569: areturn
    //   570: aload 12
    //   572: ifnull +8 -> 580
    //   575: aload 12
    //   577: invokevirtual 131	java/io/BufferedInputStream:close	()V
    //   580: aload_0
    //   581: athrow
    //   582: astore_0
    //   583: ldc 8
    //   585: iconst_1
    //   586: ldc 204
    //   588: aload_0
    //   589: invokestatic 207	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   592: aconst_null
    //   593: areturn
    //   594: goto -550 -> 44
    //   597: goto -293 -> 304
    //   600: aconst_null
    //   601: areturn
    //   602: astore_0
    //   603: goto -33 -> 570
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	606	0	paramString1	String
    //   0	606	1	paramString2	String
    //   47	484	2	l1	long
    //   307	185	4	l2	long
    //   339	172	6	l3	long
    //   382	127	8	l4	long
    //   146	3	10	bool	boolean
    //   13	545	11	localObject1	Object
    //   74	502	12	localObject2	Object
    //   203	32	13	localObject3	Object
    //   245	1	13	localException1	java.lang.Exception
    //   253	1	13	localException2	java.lang.Exception
    //   267	15	13	localException3	java.lang.Exception
    //   299	1	13	localObject4	Object
    //   182	66	14	str	String
    // Exception table:
    //   from	to	target	type
    //   188	198	245	java/lang/Exception
    //   209	215	245	java/lang/Exception
    //   219	227	245	java/lang/Exception
    //   177	184	253	java/lang/Exception
    //   155	173	260	finally
    //   155	173	267	java/lang/Exception
    //   0	41	582	java/lang/Exception
    //   44	90	582	java/lang/Exception
    //   93	148	582	java/lang/Exception
    //   234	239	582	java/lang/Exception
    //   304	317	582	java/lang/Exception
    //   319	346	582	java/lang/Exception
    //   353	371	582	java/lang/Exception
    //   371	384	582	java/lang/Exception
    //   390	423	582	java/lang/Exception
    //   425	565	582	java/lang/Exception
    //   565	570	582	java/lang/Exception
    //   575	580	582	java/lang/Exception
    //   580	582	582	java/lang/Exception
    //   177	184	602	finally
    //   188	198	602	finally
    //   209	215	602	finally
    //   219	227	602	finally
    //   278	289	602	finally
  }
  
  private static String getOfflineResFromSdcard(String paramString1, String paramString2)
  {
    paramString1 = HtmlOffline.d(paramString1);
    Object localObject = OfflineEnvHelper.a(paramString2);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString2);
    paramString2 = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramString1);
    paramString1 = ((StringBuilder)localObject).toString();
    paramString2 = new File(paramString1);
    if (paramString2.exists())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[getOfflineResFromSdcard],realPath:");
        ((StringBuilder)localObject).append(paramString1);
        QLog.d("HippyOfflineAssist", 2, ((StringBuilder)localObject).toString());
      }
      return paramString2.getAbsolutePath();
    }
    return null;
  }
  
  public static String getOfflineResPath(String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[getOfflineResPath],url:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("HippyOfflineAssist", 2, ((StringBuilder)localObject1).toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http")))
    {
      String str = Uri.parse(paramString).getQueryParameter("_bid");
      if (TextUtils.isEmpty(str))
      {
        QLog.i("HippyOfflineAssist", 1, "[getOfflineResPath], businessId NOT exist.");
        return null;
      }
      localObject1 = getApp();
      if (localObject1 == null) {
        return null;
      }
      HtmlOffline.a(paramString, (AppRuntime)localObject1);
      Object localObject2 = getOfflineResFromDatabase(paramString, str);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = getOfflineResFromSdcard(paramString, str);
      }
      OfflineWebResManager.a(paramString);
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("bid", str);
      ((HashMap)localObject2).put("url", paramString);
      ((HashMap)localObject2).put("version", HtmlOffline.a(str));
      int i;
      if (localObject1 == null) {
        i = -1;
      } else {
        i = 0;
      }
      ((HashMap)localObject2).put("ret", String.valueOf(i));
      HippyReporter.reportToDengTa("hippy_offlinePack", (Map)localObject2, false);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("[getOfflineResPath] ends, path:");
        paramString.append((String)localObject1);
        QLog.d("HippyOfflineAssist", 2, paramString.toString());
      }
      return localObject1;
    }
    QLog.i("HippyOfflineAssist", 1, "[getOfflineResPath], illegal url.");
    return null;
  }
  
  public static void updateUrl()
  {
    OfflineWebResManager localOfflineWebResManager = mOfflineResManager;
    if (localOfflineWebResManager != null) {
      localOfflineWebResManager.a(5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.offline.HippyOfflineAssist
 * JD-Core Version:    0.7.0.1
 */