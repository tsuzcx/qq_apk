import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.business.base.appreport.AppReport.1;
import com.tencent.open.business.base.appreport.AppReport.2;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantbase.common.DownloadSDKConfigManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class bcfc
{
  public static Lock a = new ReentrantLock();
  public static boolean a;
  
  public static Bundle a(Context paramContext, Map<String, String> paramMap, String paramString1, String paramString2)
  {
    paramContext = new Bundle();
    paramContext.putString("platform", bbtm.a().g());
    paramContext.putString("version", bbtm.a().d());
    paramContext.putString("uin", paramString2);
    paramContext.putString("imei", bcez.c());
    paramContext.putString("imsi", bcez.d());
    paramContext.putString("android_id", Settings.Secure.getString(bbtm.a().a().getContentResolver(), "android_id"));
    paramContext.putString("mac_addr", bcez.a());
    paramContext.putString("model_info", Build.MODEL);
    paramContext.putString("resolution", bcez.e());
    paramContext.putString("keystr", bbtm.a().a());
    paramContext.putString("sid", bbtm.a().a());
    paramContext.putString("package", paramMap.values().toString());
    paramContext.putString("type", paramString1);
    return paramContext;
  }
  
  protected static String a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    return a(paramString1, paramInt1, paramString2, paramInt2, "");
  }
  
  public static String a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[\"");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\",");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",\"");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\",");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",\"");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("\"");
    localStringBuilder.append("]");
    bcds.b("AppReport", "message to cgi: " + localStringBuilder.toString());
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static Map<String, String> a(Context paramContext)
  {
    // Byte code:
    //   0: new 156	java/io/File
    //   3: dup
    //   4: new 115	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   11: aload_0
    //   12: invokevirtual 160	android/content/Context:getFilesDir	()Ljava/io/File;
    //   15: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   18: getstatic 166	java/io/File:separator	Ljava/lang/String;
    //   21: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 168
    //   26: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 171	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: invokevirtual 175	java/io/File:exists	()Z
    //   38: ifne +5 -> 43
    //   41: aconst_null
    //   42: areturn
    //   43: getstatic 16	bcfc:a	Ljava/util/concurrent/locks/Lock;
    //   46: invokeinterface 180 1 0
    //   51: aload_0
    //   52: ldc 168
    //   54: invokevirtual 184	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   57: astore 4
    //   59: new 186	java/io/ByteArrayOutputStream
    //   62: dup
    //   63: invokespecial 187	java/io/ByteArrayOutputStream:<init>	()V
    //   66: astore 5
    //   68: aload 5
    //   70: astore 6
    //   72: aload 4
    //   74: astore 7
    //   76: sipush 1024
    //   79: newarray byte
    //   81: astore 8
    //   83: aload 5
    //   85: astore 6
    //   87: aload 4
    //   89: astore 7
    //   91: aload 4
    //   93: aload 8
    //   95: invokevirtual 193	java/io/FileInputStream:read	([B)I
    //   98: istore_1
    //   99: iload_1
    //   100: iconst_m1
    //   101: if_icmpeq +64 -> 165
    //   104: aload 5
    //   106: astore 6
    //   108: aload 4
    //   110: astore 7
    //   112: aload 5
    //   114: aload 8
    //   116: iconst_0
    //   117: iload_1
    //   118: invokevirtual 197	java/io/ByteArrayOutputStream:write	([BII)V
    //   121: goto -38 -> 83
    //   124: astore 6
    //   126: aload 5
    //   128: astore_0
    //   129: aload 6
    //   131: astore 5
    //   133: aload 5
    //   135: invokevirtual 200	java/io/FileNotFoundException:printStackTrace	()V
    //   138: aload 4
    //   140: ifnull +8 -> 148
    //   143: aload 4
    //   145: invokevirtual 203	java/io/FileInputStream:close	()V
    //   148: aload_0
    //   149: ifnull -108 -> 41
    //   152: aload_0
    //   153: invokevirtual 204	java/io/ByteArrayOutputStream:close	()V
    //   156: aconst_null
    //   157: areturn
    //   158: astore_0
    //   159: aload_0
    //   160: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   163: aconst_null
    //   164: areturn
    //   165: aload 5
    //   167: astore 6
    //   169: aload 4
    //   171: astore 7
    //   173: getstatic 16	bcfc:a	Ljava/util/concurrent/locks/Lock;
    //   176: invokeinterface 208 1 0
    //   181: aload 5
    //   183: astore 6
    //   185: aload 4
    //   187: astore 7
    //   189: new 210	java/lang/String
    //   192: dup
    //   193: aload 5
    //   195: invokevirtual 214	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   198: invokespecial 217	java/lang/String:<init>	([B)V
    //   201: invokevirtual 220	java/lang/String:trim	()Ljava/lang/String;
    //   204: astore 8
    //   206: aload 5
    //   208: astore 6
    //   210: aload 4
    //   212: astore 7
    //   214: aload 8
    //   216: invokevirtual 224	java/lang/String:length	()I
    //   219: ifle +617 -> 836
    //   222: aload 5
    //   224: astore 6
    //   226: aload 4
    //   228: astore 7
    //   230: aload 8
    //   232: iconst_0
    //   233: aload 8
    //   235: invokevirtual 224	java/lang/String:length	()I
    //   238: iconst_1
    //   239: isub
    //   240: invokevirtual 228	java/lang/String:substring	(II)Ljava/lang/String;
    //   243: ldc 230
    //   245: invokevirtual 234	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   248: astore 8
    //   250: aload 5
    //   252: astore 6
    //   254: aload 4
    //   256: astore 7
    //   258: new 236	java/util/HashMap
    //   261: dup
    //   262: invokespecial 237	java/util/HashMap:<init>	()V
    //   265: astore 9
    //   267: aload 8
    //   269: ifnull +426 -> 695
    //   272: aload 5
    //   274: astore 6
    //   276: aload 4
    //   278: astore 7
    //   280: aload 8
    //   282: arraylength
    //   283: ifle +412 -> 695
    //   286: aload 5
    //   288: astore 6
    //   290: aload 4
    //   292: astore 7
    //   294: aload 8
    //   296: arraylength
    //   297: istore_2
    //   298: iconst_0
    //   299: istore_1
    //   300: iload_1
    //   301: iload_2
    //   302: if_icmpge +393 -> 695
    //   305: aload 5
    //   307: astore 6
    //   309: aload 4
    //   311: astore 7
    //   313: aload 8
    //   315: iload_1
    //   316: aaload
    //   317: ldc 239
    //   319: invokevirtual 234	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   322: astore 10
    //   324: aload 5
    //   326: astore 6
    //   328: aload 4
    //   330: astore 7
    //   332: aload 10
    //   334: iconst_1
    //   335: aaload
    //   336: invokestatic 245	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   339: istore_3
    //   340: iload_3
    //   341: bipush 8
    //   343: if_icmpne +37 -> 380
    //   346: aload 5
    //   348: astore 6
    //   350: aload 4
    //   352: astore 7
    //   354: aload 9
    //   356: aload 10
    //   358: iconst_0
    //   359: aaload
    //   360: aload 10
    //   362: iconst_0
    //   363: aaload
    //   364: iconst_0
    //   365: ldc 247
    //   367: iload_3
    //   368: invokestatic 249	bcfc:a	(Ljava/lang/String;ILjava/lang/String;I)Ljava/lang/String;
    //   371: invokeinterface 253 3 0
    //   376: pop
    //   377: goto +465 -> 842
    //   380: aload 5
    //   382: astore 6
    //   384: aload 4
    //   386: astore 7
    //   388: aload_0
    //   389: invokevirtual 257	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   392: aload 10
    //   394: iconst_0
    //   395: aaload
    //   396: iconst_0
    //   397: invokevirtual 263	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   400: astore 11
    //   402: aload 5
    //   404: astore 6
    //   406: aload 4
    //   408: astore 7
    //   410: aload 9
    //   412: aload 10
    //   414: iconst_0
    //   415: aaload
    //   416: aload 10
    //   418: iconst_0
    //   419: aaload
    //   420: aload 11
    //   422: getfield 269	android/content/pm/PackageInfo:versionCode	I
    //   425: aload 11
    //   427: getfield 272	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   430: iload_3
    //   431: aload_0
    //   432: aload 10
    //   434: iconst_0
    //   435: aaload
    //   436: invokestatic 277	bcev:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   439: invokestatic 113	bcfc:a	(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   442: invokeinterface 253 3 0
    //   447: pop
    //   448: goto +394 -> 842
    //   451: astore 11
    //   453: aload 5
    //   455: astore 6
    //   457: aload 4
    //   459: astore 7
    //   461: ldc 135
    //   463: new 115	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   470: ldc_w 279
    //   473: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload 10
    //   478: iconst_0
    //   479: aaload
    //   480: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: ldc_w 281
    //   486: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload 11
    //   491: invokevirtual 282	android/content/pm/PackageManager$NameNotFoundException:toString	()Ljava/lang/String;
    //   494: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokestatic 284	bcds:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   503: goto +339 -> 842
    //   506: astore 6
    //   508: aload 5
    //   510: astore_0
    //   511: aload 6
    //   513: astore 5
    //   515: aload_0
    //   516: astore 6
    //   518: aload 4
    //   520: astore 7
    //   522: aload 5
    //   524: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   527: aload 4
    //   529: ifnull +8 -> 537
    //   532: aload 4
    //   534: invokevirtual 203	java/io/FileInputStream:close	()V
    //   537: aload_0
    //   538: ifnull -497 -> 41
    //   541: aload_0
    //   542: invokevirtual 204	java/io/ByteArrayOutputStream:close	()V
    //   545: aconst_null
    //   546: areturn
    //   547: astore_0
    //   548: aload_0
    //   549: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   552: aconst_null
    //   553: areturn
    //   554: astore 11
    //   556: aload 5
    //   558: astore 6
    //   560: aload 4
    //   562: astore 7
    //   564: ldc 135
    //   566: new 115	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   573: ldc_w 286
    //   576: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: aload 10
    //   581: iconst_0
    //   582: aaload
    //   583: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: ldc_w 281
    //   589: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: aload 11
    //   594: invokevirtual 287	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   597: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokestatic 284	bcds:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   606: goto +236 -> 842
    //   609: astore_0
    //   610: aload 7
    //   612: astore 4
    //   614: aload 6
    //   616: astore 5
    //   618: aload 4
    //   620: ifnull +8 -> 628
    //   623: aload 4
    //   625: invokevirtual 203	java/io/FileInputStream:close	()V
    //   628: aload 5
    //   630: ifnull +8 -> 638
    //   633: aload 5
    //   635: invokevirtual 204	java/io/ByteArrayOutputStream:close	()V
    //   638: aload_0
    //   639: athrow
    //   640: astore 11
    //   642: aload 5
    //   644: astore 6
    //   646: aload 4
    //   648: astore 7
    //   650: ldc 135
    //   652: new 115	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   659: ldc_w 286
    //   662: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: aload 10
    //   667: iconst_0
    //   668: aaload
    //   669: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: ldc_w 281
    //   675: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: aload 11
    //   680: invokevirtual 288	java/lang/Exception:toString	()Ljava/lang/String;
    //   683: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   689: invokestatic 284	bcds:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   692: goto +150 -> 842
    //   695: aload 4
    //   697: ifnull +8 -> 705
    //   700: aload 4
    //   702: invokevirtual 203	java/io/FileInputStream:close	()V
    //   705: aload 5
    //   707: ifnull +8 -> 715
    //   710: aload 5
    //   712: invokevirtual 204	java/io/ByteArrayOutputStream:close	()V
    //   715: aload 9
    //   717: areturn
    //   718: astore_0
    //   719: aload_0
    //   720: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   723: goto -18 -> 705
    //   726: astore_0
    //   727: aload_0
    //   728: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   731: goto -16 -> 715
    //   734: astore 4
    //   736: aload 4
    //   738: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   741: goto -593 -> 148
    //   744: astore 4
    //   746: aload 4
    //   748: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   751: goto -214 -> 537
    //   754: astore 4
    //   756: aload 4
    //   758: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   761: goto -133 -> 628
    //   764: astore 4
    //   766: aload 4
    //   768: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   771: goto -133 -> 638
    //   774: astore_0
    //   775: aconst_null
    //   776: astore 5
    //   778: aconst_null
    //   779: astore 4
    //   781: goto -163 -> 618
    //   784: astore_0
    //   785: aconst_null
    //   786: astore 5
    //   788: goto -170 -> 618
    //   791: astore 6
    //   793: aload_0
    //   794: astore 5
    //   796: aload 6
    //   798: astore_0
    //   799: goto -181 -> 618
    //   802: astore 5
    //   804: aconst_null
    //   805: astore_0
    //   806: aconst_null
    //   807: astore 4
    //   809: goto -294 -> 515
    //   812: astore 5
    //   814: aconst_null
    //   815: astore_0
    //   816: goto -301 -> 515
    //   819: astore 5
    //   821: aconst_null
    //   822: astore_0
    //   823: aconst_null
    //   824: astore 4
    //   826: goto -693 -> 133
    //   829: astore 5
    //   831: aconst_null
    //   832: astore_0
    //   833: goto -700 -> 133
    //   836: aconst_null
    //   837: astore 8
    //   839: goto -589 -> 250
    //   842: iload_1
    //   843: iconst_1
    //   844: iadd
    //   845: istore_1
    //   846: goto -546 -> 300
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	849	0	paramContext	Context
    //   98	748	1	i	int
    //   297	6	2	j	int
    //   339	92	3	k	int
    //   57	644	4	localObject1	Object
    //   734	3	4	localIOException1	IOException
    //   744	3	4	localIOException2	IOException
    //   754	3	4	localIOException3	IOException
    //   764	3	4	localIOException4	IOException
    //   779	46	4	localObject2	Object
    //   66	729	5	localObject3	Object
    //   802	1	5	localIOException5	IOException
    //   812	1	5	localIOException6	IOException
    //   819	1	5	localFileNotFoundException1	FileNotFoundException
    //   829	1	5	localFileNotFoundException2	FileNotFoundException
    //   70	37	6	localObject4	Object
    //   124	6	6	localFileNotFoundException3	FileNotFoundException
    //   167	289	6	localObject5	Object
    //   506	6	6	localIOException7	IOException
    //   516	129	6	localObject6	Object
    //   791	6	6	localObject7	Object
    //   74	575	7	localObject8	Object
    //   81	757	8	localObject9	Object
    //   265	451	9	localHashMap	java.util.HashMap
    //   322	344	10	arrayOfString	String[]
    //   400	26	11	localPackageInfo	android.content.pm.PackageInfo
    //   451	39	11	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   554	39	11	localNumberFormatException	java.lang.NumberFormatException
    //   640	39	11	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   76	83	124	java/io/FileNotFoundException
    //   91	99	124	java/io/FileNotFoundException
    //   112	121	124	java/io/FileNotFoundException
    //   173	181	124	java/io/FileNotFoundException
    //   189	206	124	java/io/FileNotFoundException
    //   214	222	124	java/io/FileNotFoundException
    //   230	250	124	java/io/FileNotFoundException
    //   258	267	124	java/io/FileNotFoundException
    //   280	286	124	java/io/FileNotFoundException
    //   294	298	124	java/io/FileNotFoundException
    //   313	324	124	java/io/FileNotFoundException
    //   332	340	124	java/io/FileNotFoundException
    //   354	377	124	java/io/FileNotFoundException
    //   388	402	124	java/io/FileNotFoundException
    //   410	448	124	java/io/FileNotFoundException
    //   461	503	124	java/io/FileNotFoundException
    //   564	606	124	java/io/FileNotFoundException
    //   650	692	124	java/io/FileNotFoundException
    //   152	156	158	java/io/IOException
    //   332	340	451	android/content/pm/PackageManager$NameNotFoundException
    //   354	377	451	android/content/pm/PackageManager$NameNotFoundException
    //   388	402	451	android/content/pm/PackageManager$NameNotFoundException
    //   410	448	451	android/content/pm/PackageManager$NameNotFoundException
    //   76	83	506	java/io/IOException
    //   91	99	506	java/io/IOException
    //   112	121	506	java/io/IOException
    //   173	181	506	java/io/IOException
    //   189	206	506	java/io/IOException
    //   214	222	506	java/io/IOException
    //   230	250	506	java/io/IOException
    //   258	267	506	java/io/IOException
    //   280	286	506	java/io/IOException
    //   294	298	506	java/io/IOException
    //   313	324	506	java/io/IOException
    //   332	340	506	java/io/IOException
    //   354	377	506	java/io/IOException
    //   388	402	506	java/io/IOException
    //   410	448	506	java/io/IOException
    //   461	503	506	java/io/IOException
    //   564	606	506	java/io/IOException
    //   650	692	506	java/io/IOException
    //   541	545	547	java/io/IOException
    //   332	340	554	java/lang/NumberFormatException
    //   354	377	554	java/lang/NumberFormatException
    //   388	402	554	java/lang/NumberFormatException
    //   410	448	554	java/lang/NumberFormatException
    //   76	83	609	finally
    //   91	99	609	finally
    //   112	121	609	finally
    //   173	181	609	finally
    //   189	206	609	finally
    //   214	222	609	finally
    //   230	250	609	finally
    //   258	267	609	finally
    //   280	286	609	finally
    //   294	298	609	finally
    //   313	324	609	finally
    //   332	340	609	finally
    //   354	377	609	finally
    //   388	402	609	finally
    //   410	448	609	finally
    //   461	503	609	finally
    //   522	527	609	finally
    //   564	606	609	finally
    //   650	692	609	finally
    //   332	340	640	java/lang/Exception
    //   354	377	640	java/lang/Exception
    //   388	402	640	java/lang/Exception
    //   410	448	640	java/lang/Exception
    //   700	705	718	java/io/IOException
    //   710	715	726	java/io/IOException
    //   143	148	734	java/io/IOException
    //   532	537	744	java/io/IOException
    //   623	628	754	java/io/IOException
    //   633	638	764	java/io/IOException
    //   43	59	774	finally
    //   59	68	784	finally
    //   133	138	791	finally
    //   43	59	802	java/io/IOException
    //   59	68	812	java/io/IOException
    //   43	59	819	java/io/FileNotFoundException
    //   59	68	829	java/io/FileNotFoundException
  }
  
  public static void a(Context paramContext)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
    localEditor.putLong("app_last_fullReport_success_time", SystemClock.currentThreadTimeMillis());
    localEditor.putBoolean("is_app_last_fullReport_success", true);
    localEditor.putBoolean("is_incremental_report_overflow", false);
    localEditor.commit();
    if (new File(paramContext.getFilesDir() + File.separator + "appcenter_app_report_storage_file.txt").exists())
    {
      a.lock();
      paramContext.deleteFile("appcenter_app_report_storage_file.txt");
      a.unlock();
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    bcds.b("AppReport", "save package <" + paramString + " : " + paramInt + "> to local");
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject4 = null;
    Object localObject2 = localObject4;
    Object localObject3 = localObject5;
    localObject1 = localObject6;
    try
    {
      a.lock();
      localObject2 = localObject4;
      localObject3 = localObject5;
      localObject1 = localObject6;
      paramContext = paramContext.openFileOutput("appcenter_app_report_storage_file.txt", 32768);
      localObject2 = paramContext;
      localObject3 = paramContext;
      localObject1 = paramContext;
      paramContext.write((paramString + ":" + paramInt + ",").getBytes());
      if (paramContext != null) {}
      try
      {
        paramContext.close();
        a.unlock();
        return;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
      try
      {
        ((FileOutputStream)localObject1).close();
        a.unlock();
        throw paramContext;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    catch (FileNotFoundException paramContext)
    {
      localObject1 = localObject2;
      paramContext.printStackTrace();
      if (localObject2 != null) {}
      try
      {
        ((FileOutputStream)localObject2).close();
        a.unlock();
        return;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
    catch (IOException paramContext)
    {
      localObject1 = localObject3;
      paramContext.printStackTrace();
      if (localObject3 != null) {}
      try
      {
        ((FileOutputStream)localObject3).close();
        a.unlock();
        return;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
    finally
    {
      if (localObject1 == null) {}
    }
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, WebView paramWebView, String paramString3)
  {
    if (DownloadSDKConfigManager.canGotoNewAppListPage()) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(new AppReport.1(paramString1, paramInt, paramContext, paramString2, paramWebView, paramString3));
  }
  
  public static void a(Context paramContext, String paramString1, WebView paramWebView, String paramString2, boolean paramBoolean)
  {
    if (DownloadSDKConfigManager.canGotoNewAppListPage()) {
      return;
    }
    new Handler(Looper.getMainLooper()).postDelayed(new AppReport.2(paramContext, paramString1, paramWebView, paramString2, paramBoolean), 60002L);
  }
  
  public static boolean a()
  {
    boolean bool = bcfa.a(bbtm.a().a(), null).b("C_Full_Report");
    bcds.c("AppReport", "<AppReport>, app full report switch : " + bool);
    return bool;
  }
  
  public static boolean a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("appcenter_app_report", 0);
    long l = localSharedPreferences.getLong("full_report_date", 0L);
    int i = localSharedPreferences.getInt("full_report_day_times", 0);
    if (SystemClock.currentThreadTimeMillis() - l > 86400000L)
    {
      paramContext = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
      paramContext.putLong("full_report_date", SystemClock.currentThreadTimeMillis());
      paramContext.putInt("full_report_day_times", 0);
      paramContext.commit();
      return true;
    }
    if (i > 10) {
      return false;
    }
    paramContext = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
    paramContext.putInt("full_report_day_times", i + 1);
    paramContext.commit();
    return true;
  }
  
  public static void b(Context paramContext)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
    localEditor.putBoolean("is_app_last_fullReport_success", false);
    localEditor.commit();
    if (new File(paramContext.getFilesDir() + File.separator + "appcenter_app_report_storage_file.txt").exists())
    {
      a.lock();
      paramContext.deleteFile("appcenter_app_report_storage_file.txt");
      a.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcfc
 * JD-Core Version:    0.7.0.1
 */