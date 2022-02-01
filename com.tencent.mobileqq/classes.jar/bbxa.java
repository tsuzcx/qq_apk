import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.secspy.SecSpyFileManager.1;
import com.tencent.mobileqq.secspy.SecSpyFileManager.2;
import com.tencent.mobileqq.unifiedebug.SnapshotResultReceiver;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x7c.submsgtype0x7c.MsgBody;

public class bbxa
  implements Manager
{
  private static final String d = anni.a(2131712453);
  private static final String e = anni.a(2131712452);
  public Handler a;
  public bgcs a;
  public bgda a;
  public QQAppInterface a;
  private Runnable a;
  public String a;
  public String b = "https://qprostat.imtt.qq.com/";
  public String c = ".mgz";
  
  public bbxa(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "https://logic.content.qq.com/public/file_upload2?";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangRunnable = new SecSpyFileManager.1(this);
    if (paramQQAppInterface.getApplication().getSharedPreferences("x5_proxy_setting", 4).getBoolean("is_in_proxy", false)) {
      ThreadManager.getFileThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  /* Error */
  private void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 101	bbxa:jdField_a_of_type_Bgcs	Lbgcs;
    //   5: aload_1
    //   6: invokevirtual 106	bgcs:b	(Ljava/lang/String;)Ljava/lang/String;
    //   9: invokevirtual 109	bbxa:a	(Ljava/lang/String;)Ljava/io/File;
    //   12: astore 9
    //   14: aload 9
    //   16: ifnull +651 -> 667
    //   19: aload 9
    //   21: invokevirtual 115	java/io/File:exists	()Z
    //   24: ifeq +643 -> 667
    //   27: aload 9
    //   29: invokevirtual 118	java/io/File:isFile	()Z
    //   32: ifeq +635 -> 667
    //   35: aload_0
    //   36: lload_3
    //   37: iconst_2
    //   38: iconst_1
    //   39: anewarray 4	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: aload 9
    //   46: invokevirtual 122	java/io/File:length	()J
    //   49: invokestatic 128	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: aastore
    //   53: invokevirtual 131	bbxa:a	(JI[Ljava/lang/Object;)V
    //   56: aload_0
    //   57: lload_3
    //   58: iconst_3
    //   59: iconst_1
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: bipush 100
    //   67: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: aastore
    //   71: invokevirtual 131	bbxa:a	(JI[Ljava/lang/Object;)V
    //   74: new 138	java/util/HashMap
    //   77: dup
    //   78: invokespecial 139	java/util/HashMap:<init>	()V
    //   81: astore 7
    //   83: aload 7
    //   85: ldc 141
    //   87: aload_2
    //   88: invokeinterface 147 3 0
    //   93: pop
    //   94: aload 7
    //   96: ldc 149
    //   98: ldc 151
    //   100: invokeinterface 147 3 0
    //   105: pop
    //   106: aload 7
    //   108: ldc 153
    //   110: ldc 155
    //   112: invokeinterface 147 3 0
    //   117: pop
    //   118: aload 7
    //   120: ldc 157
    //   122: new 159	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   129: ldc 162
    //   131: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_2
    //   135: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc 168
    //   140: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokeinterface 147 3 0
    //   151: pop
    //   152: aconst_null
    //   153: astore 5
    //   155: new 174	java/net/URL
    //   158: dup
    //   159: aload_0
    //   160: getfield 43	bbxa:b	Ljava/lang/String;
    //   163: invokespecial 177	java/net/URL:<init>	(Ljava/lang/String;)V
    //   166: invokevirtual 181	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   169: checkcast 183	java/net/HttpURLConnection
    //   172: astore_1
    //   173: aload_1
    //   174: iconst_1
    //   175: invokevirtual 187	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   178: aload_1
    //   179: iconst_1
    //   180: invokevirtual 190	java/net/HttpURLConnection:setDoInput	(Z)V
    //   183: aload_1
    //   184: iconst_0
    //   185: invokevirtual 193	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   188: aload_1
    //   189: ldc 195
    //   191: invokevirtual 198	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   194: aload_1
    //   195: ldc 200
    //   197: new 159	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   204: ldc 202
    //   206: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 9
    //   211: invokevirtual 122	java/io/File:length	()J
    //   214: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   217: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokevirtual 209	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload_1
    //   224: ldc 211
    //   226: ldc 213
    //   228: invokevirtual 209	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload_1
    //   232: ldc 215
    //   234: ldc 217
    //   236: invokevirtual 209	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload 7
    //   241: invokeinterface 221 1 0
    //   246: invokeinterface 227 1 0
    //   251: astore_2
    //   252: aload_2
    //   253: invokeinterface 232 1 0
    //   258: ifeq +90 -> 348
    //   261: aload_2
    //   262: invokeinterface 236 1 0
    //   267: checkcast 238	java/lang/String
    //   270: astore 8
    //   272: aload_1
    //   273: aload 8
    //   275: aload 7
    //   277: aload 8
    //   279: invokeinterface 242 2 0
    //   284: checkcast 238	java/lang/String
    //   287: invokevirtual 209	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: goto -38 -> 252
    //   293: astore 5
    //   295: aconst_null
    //   296: astore_2
    //   297: ldc 244
    //   299: iconst_1
    //   300: ldc 246
    //   302: aload 5
    //   304: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   307: aload_0
    //   308: lload_3
    //   309: iconst_m1
    //   310: iconst_1
    //   311: anewarray 4	java/lang/Object
    //   314: dup
    //   315: iconst_0
    //   316: aload 5
    //   318: invokevirtual 254	java/io/IOException:getMessage	()Ljava/lang/String;
    //   321: aastore
    //   322: invokevirtual 131	bbxa:a	(JI[Ljava/lang/Object;)V
    //   325: aload_2
    //   326: ifnull +7 -> 333
    //   329: aload_2
    //   330: invokevirtual 259	java/io/OutputStream:close	()V
    //   333: aload_1
    //   334: ifnull +7 -> 341
    //   337: aload_1
    //   338: invokevirtual 262	java/net/HttpURLConnection:disconnect	()V
    //   341: aload 9
    //   343: invokevirtual 265	java/io/File:delete	()Z
    //   346: pop
    //   347: return
    //   348: aload_1
    //   349: invokevirtual 269	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   352: astore 7
    //   354: sipush 10240
    //   357: newarray byte
    //   359: astore 8
    //   361: new 271	java/io/FileInputStream
    //   364: dup
    //   365: aload 9
    //   367: invokespecial 274	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   370: astore 5
    //   372: aload 5
    //   374: astore_2
    //   375: aload 5
    //   377: aload 8
    //   379: iconst_0
    //   380: sipush 10240
    //   383: invokevirtual 278	java/io/FileInputStream:read	([BII)I
    //   386: istore 6
    //   388: iload 6
    //   390: iconst_m1
    //   391: if_icmpeq +96 -> 487
    //   394: aload 5
    //   396: astore_2
    //   397: aload 7
    //   399: aload 8
    //   401: iconst_0
    //   402: iload 6
    //   404: invokevirtual 282	java/io/OutputStream:write	([BII)V
    //   407: goto -35 -> 372
    //   410: astore 8
    //   412: aload 5
    //   414: astore_2
    //   415: aload_0
    //   416: lload_3
    //   417: iconst_m1
    //   418: iconst_1
    //   419: anewarray 4	java/lang/Object
    //   422: dup
    //   423: iconst_0
    //   424: new 159	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   431: ldc_w 284
    //   434: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload 8
    //   439: invokevirtual 285	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   442: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: aastore
    //   449: invokevirtual 131	bbxa:a	(JI[Ljava/lang/Object;)V
    //   452: aload 5
    //   454: ifnull +8 -> 462
    //   457: aload 5
    //   459: invokevirtual 286	java/io/FileInputStream:close	()V
    //   462: aload 7
    //   464: ifnull +8 -> 472
    //   467: aload 7
    //   469: invokevirtual 259	java/io/OutputStream:close	()V
    //   472: aload_1
    //   473: ifnull -126 -> 347
    //   476: aload_1
    //   477: invokevirtual 262	java/net/HttpURLConnection:disconnect	()V
    //   480: return
    //   481: astore_1
    //   482: aload_1
    //   483: invokevirtual 289	java/io/IOException:printStackTrace	()V
    //   486: return
    //   487: aload 5
    //   489: ifnull +8 -> 497
    //   492: aload 5
    //   494: invokevirtual 286	java/io/FileInputStream:close	()V
    //   497: aload_1
    //   498: invokevirtual 293	java/net/HttpURLConnection:getResponseCode	()I
    //   501: istore 6
    //   503: iload 6
    //   505: sipush 200
    //   508: if_icmpne +106 -> 614
    //   511: aload_0
    //   512: lload_3
    //   513: iconst_0
    //   514: iconst_0
    //   515: anewarray 4	java/lang/Object
    //   518: invokevirtual 131	bbxa:a	(JI[Ljava/lang/Object;)V
    //   521: aload 7
    //   523: ifnull +8 -> 531
    //   526: aload 7
    //   528: invokevirtual 259	java/io/OutputStream:close	()V
    //   531: aload_1
    //   532: ifnull -191 -> 341
    //   535: aload_1
    //   536: invokevirtual 262	java/net/HttpURLConnection:disconnect	()V
    //   539: goto -198 -> 341
    //   542: astore_1
    //   543: aload_1
    //   544: invokevirtual 289	java/io/IOException:printStackTrace	()V
    //   547: goto -206 -> 341
    //   550: astore_2
    //   551: aload_2
    //   552: invokevirtual 289	java/io/IOException:printStackTrace	()V
    //   555: goto -58 -> 497
    //   558: astore_2
    //   559: aload_2
    //   560: invokevirtual 289	java/io/IOException:printStackTrace	()V
    //   563: goto -101 -> 462
    //   566: astore_2
    //   567: aload 7
    //   569: astore 5
    //   571: aload 5
    //   573: ifnull +8 -> 581
    //   576: aload 5
    //   578: invokevirtual 259	java/io/OutputStream:close	()V
    //   581: aload_1
    //   582: ifnull +7 -> 589
    //   585: aload_1
    //   586: invokevirtual 262	java/net/HttpURLConnection:disconnect	()V
    //   589: aload_2
    //   590: athrow
    //   591: astore 5
    //   593: aconst_null
    //   594: astore_2
    //   595: aload_2
    //   596: ifnull +7 -> 603
    //   599: aload_2
    //   600: invokevirtual 286	java/io/FileInputStream:close	()V
    //   603: aload 5
    //   605: athrow
    //   606: astore_2
    //   607: aload_2
    //   608: invokevirtual 289	java/io/IOException:printStackTrace	()V
    //   611: goto -8 -> 603
    //   614: aload_0
    //   615: lload_3
    //   616: iconst_m1
    //   617: iconst_1
    //   618: anewarray 4	java/lang/Object
    //   621: dup
    //   622: iconst_0
    //   623: new 159	java/lang/StringBuilder
    //   626: dup
    //   627: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   630: ldc_w 295
    //   633: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: iload 6
    //   638: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   641: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: aastore
    //   645: invokevirtual 131	bbxa:a	(JI[Ljava/lang/Object;)V
    //   648: goto -127 -> 521
    //   651: astore_1
    //   652: aload_1
    //   653: invokevirtual 289	java/io/IOException:printStackTrace	()V
    //   656: goto -315 -> 341
    //   659: astore_1
    //   660: aload_1
    //   661: invokevirtual 289	java/io/IOException:printStackTrace	()V
    //   664: goto -75 -> 589
    //   667: aload_0
    //   668: lload_3
    //   669: iconst_m1
    //   670: iconst_1
    //   671: anewarray 4	java/lang/Object
    //   674: dup
    //   675: iconst_0
    //   676: ldc_w 300
    //   679: aastore
    //   680: invokevirtual 131	bbxa:a	(JI[Ljava/lang/Object;)V
    //   683: return
    //   684: astore_2
    //   685: aconst_null
    //   686: astore_1
    //   687: goto -116 -> 571
    //   690: astore_2
    //   691: goto -120 -> 571
    //   694: astore 7
    //   696: aload_2
    //   697: astore 5
    //   699: aload 7
    //   701: astore_2
    //   702: goto -131 -> 571
    //   705: astore 5
    //   707: aconst_null
    //   708: astore_1
    //   709: aconst_null
    //   710: astore_2
    //   711: goto -414 -> 297
    //   714: astore 5
    //   716: goto -121 -> 595
    //   719: astore 8
    //   721: aconst_null
    //   722: astore 5
    //   724: goto -312 -> 412
    //   727: astore 5
    //   729: aload 7
    //   731: astore_2
    //   732: goto -435 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	735	0	this	bbxa
    //   0	735	1	paramString1	String
    //   0	735	2	paramString2	String
    //   0	735	3	paramLong	long
    //   0	735	5	paramString3	String
    //   386	251	6	i	int
    //   81	487	7	localObject1	Object
    //   694	36	7	localObject2	Object
    //   270	130	8	localObject3	Object
    //   410	28	8	localException1	Exception
    //   719	1	8	localException2	Exception
    //   12	354	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   173	252	293	java/io/IOException
    //   252	290	293	java/io/IOException
    //   348	354	293	java/io/IOException
    //   375	388	410	java/lang/Exception
    //   397	407	410	java/lang/Exception
    //   467	472	481	java/io/IOException
    //   476	480	481	java/io/IOException
    //   526	531	542	java/io/IOException
    //   535	539	542	java/io/IOException
    //   492	497	550	java/io/IOException
    //   457	462	558	java/io/IOException
    //   354	361	566	finally
    //   457	462	566	finally
    //   492	497	566	finally
    //   497	503	566	finally
    //   511	521	566	finally
    //   551	555	566	finally
    //   559	563	566	finally
    //   599	603	566	finally
    //   603	606	566	finally
    //   607	611	566	finally
    //   614	648	566	finally
    //   361	372	591	finally
    //   599	603	606	java/io/IOException
    //   329	333	651	java/io/IOException
    //   337	341	651	java/io/IOException
    //   576	581	659	java/io/IOException
    //   585	589	659	java/io/IOException
    //   155	173	684	finally
    //   173	252	690	finally
    //   252	290	690	finally
    //   348	354	690	finally
    //   297	325	694	finally
    //   155	173	705	java/io/IOException
    //   375	388	714	finally
    //   397	407	714	finally
    //   415	452	714	finally
    //   361	372	719	java/lang/Exception
    //   354	361	727	java/io/IOException
    //   497	503	727	java/io/IOException
    //   511	521	727	java/io/IOException
    //   551	555	727	java/io/IOException
    //   559	563	727	java/io/IOException
    //   603	606	727	java/io/IOException
    //   607	611	727	java/io/IOException
    //   614	648	727	java/io/IOException
  }
  
  public File a(String paramString)
  {
    Object localObject = paramString;
    String str1;
    String str2;
    try
    {
      if (!paramString.startsWith("/data/data/com.tencent.mobileqq/")) {
        break label305;
      }
      str1 = paramString;
      localObject = paramString;
      if (!paramString.endsWith("/"))
      {
        localObject = paramString;
        str1 = paramString + "/";
      }
      localObject = str1;
      int i = str1.indexOf("/data/data/com.tencent.mobileqq/");
      localObject = str1;
      str2 = str1.substring("/data/data/com.tencent.mobileqq/".length() + i);
      localObject = str1;
      paramString = str2.substring(0, str2.indexOf("/"));
      localObject = str1;
      str2 = str2.substring(str2.indexOf("/") + 1);
      localObject = str1;
      Context localContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
      localObject = str1;
      if (paramString.equals("files"))
      {
        localObject = str1;
        return new File(localContext.getFilesDir(), str2);
      }
      localObject = str1;
      if (paramString.equals("cache"))
      {
        localObject = str1;
        paramString = new File(localContext.getCacheDir(), str2);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SecSpyFileManager", 2, "wrong to parse file from path :" + (String)localObject, paramString);
      }
      paramString.printStackTrace();
      return null;
    }
    localObject = str1;
    if (paramString.startsWith("app_"))
    {
      localObject = str1;
      paramString = paramString.substring("app_".length());
      localObject = str1;
      return new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getDir(paramString, 0), str2);
    }
    localObject = str1;
    return new File(str1);
    label305:
    localObject = paramString;
    if (paramString.startsWith("sdcard/"))
    {
      localObject = paramString;
      str1 = paramString.replace("sdcard/", "");
      localObject = paramString;
      if ("mounted".equals(Environment.getExternalStorageState()))
      {
        localObject = paramString;
        if (Environment.getExternalStorageDirectory().canWrite())
        {
          localObject = paramString;
          return new File(Environment.getExternalStorageDirectory().getPath() + "/" + str1);
        }
      }
    }
    else
    {
      localObject = paramString;
      paramString = new File(paramString);
      return paramString;
    }
    return null;
  }
  
  public String a(TreeMap<String, Object> paramTreeMap, String paramString)
  {
    Iterator localIterator = paramTreeMap.keySet().iterator();
    String str2;
    for (String str1 = ""; localIterator.hasNext(); str1 = str1 + paramTreeMap.get(str2)) {
      str2 = (String)localIterator.next();
    }
    return MD5.toMD5(str1 + paramString);
  }
  
  public List<String> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      String str = paramJSONArray.optString(i);
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public JSONArray a(Collection paramCollection)
  {
    JSONArray localJSONArray = new JSONArray();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localJSONArray.put(paramCollection.next());
    }
    return localJSONArray;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Bgcs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), paramLong);
  }
  
  public void a(long paramLong, int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
    case 1: 
      try
      {
        this.jdField_a_of_type_Bgda.a(paramLong, paramInt, null);
        return;
      }
      catch (JSONException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        return;
      }
    case 2: 
      localJSONObject = new JSONObject();
      if (paramVarArgs.length > 0) {
        localJSONObject.put("sizes", paramVarArgs[0]);
      }
      this.jdField_a_of_type_Bgda.a(paramLong, paramInt, localJSONObject);
      return;
    case 3: 
      localJSONObject = new JSONObject();
      if (paramVarArgs.length > 0) {
        localJSONObject.put("percent", paramVarArgs[0]);
      }
      this.jdField_a_of_type_Bgda.a(paramLong, paramInt, localJSONObject);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    if (paramVarArgs.length > 0) {
      localJSONObject.put("msg", paramVarArgs[0]);
    }
    this.jdField_a_of_type_Bgda.a(paramLong, paramInt, localJSONObject);
  }
  
  public void a(long paramLong, String paramString)
  {
    a(paramLong, -1, new Object[] { paramString });
  }
  
  public void a(long paramLong, String paramString, Map<String, Object> paramMap, List<bgde> paramList)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < paramList.size())
    {
      localJSONArray.put(((bgde)paramList.get(i)).a());
      i += 1;
    }
    try
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, paramMap.get(str));
        continue;
        paramList.clear();
      }
    }
    catch (Exception paramString)
    {
      a(paramLong, -1, new Object[] { paramString.getMessage() });
    }
    for (;;)
    {
      return;
      localJSONObject.put("dns", this.jdField_a_of_type_Bgcs.a());
      localJSONObject.put("ip", this.jdField_a_of_type_Bgcs.d(paramString));
      localJSONObject.put("traceRoute", localJSONArray);
      if (QLog.isColorLevel()) {
        QLog.d("SecSpyFileManager", 2, localJSONObject.toString());
      }
      a(paramLong, localJSONObject);
    }
  }
  
  public void a(long paramLong, JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Bgda.a(paramLong, 0, paramJSONObject);
  }
  
  public void a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    this.jdField_a_of_type_Bgcs.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramString1, paramInt, paramLong1, paramLong2, paramString2);
  }
  
  public void a(String paramString1, long paramLong, String paramString2, boolean paramBoolean)
  {
    File localFile = new File(paramString1);
    if ((localFile.exists()) && (localFile.isFile()))
    {
      a(paramLong, 2, new Object[] { Long.valueOf(localFile.length()) });
      if (!a(paramString1, paramLong, paramString2, false)) {
        break label103;
      }
      if (paramBoolean)
      {
        localFile.delete();
        if (QLog.isColorLevel()) {
          QLog.d("SecSpyFileManager", 2, paramString1 + " delete success");
        }
      }
    }
    return;
    label103:
    a(paramLong, -1, new Object[] { "file upload failed" });
  }
  
  public void a(List<String> paramList, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Bgcs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), paramLong)) {
      b(paramList, paramLong, paramString);
    }
  }
  
  public void a(submsgtype0x7c.MsgBody paramMsgBody, int paramInt)
  {
    if (paramInt < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecSpyFileManager", 2, "retry to max retry number ");
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandler == null)
    {
      HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("SecSpyFile", 0);
      localHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
      this.jdField_a_of_type_Bgcs = new bgcs(new SnapshotResultReceiver(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsHandler));
    }
    if (this.jdField_a_of_type_Bgda == null) {
      this.jdField_a_of_type_Bgda = new bgda(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new SecSpyFileManager.2(this, paramMsgBody, paramInt));
  }
  
  /* Error */
  public boolean a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore_3
    //   8: iconst_0
    //   9: istore 4
    //   11: iconst_0
    //   12: istore 5
    //   14: new 271	java/io/FileInputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 274	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore 6
    //   24: aload_0
    //   25: new 159	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   32: aload_1
    //   33: invokevirtual 552	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   36: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: getfield 47	bbxa:c	Ljava/lang/String;
    //   43: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokevirtual 109	bbxa:a	(Ljava/lang/String;)Ljava/io/File;
    //   52: astore_1
    //   53: aload_1
    //   54: ifnonnull +158 -> 212
    //   57: aload 6
    //   59: ifnull +8 -> 67
    //   62: aload 6
    //   64: invokevirtual 286	java/io/FileInputStream:close	()V
    //   67: aload 6
    //   69: ifnull +8 -> 77
    //   72: aload 6
    //   74: invokevirtual 286	java/io/FileInputStream:close	()V
    //   77: iload 5
    //   79: istore_3
    //   80: iconst_0
    //   81: ifeq +11 -> 92
    //   84: new 554	java/lang/NullPointerException
    //   87: dup
    //   88: invokespecial 555	java/lang/NullPointerException:<init>	()V
    //   91: athrow
    //   92: iload_3
    //   93: ireturn
    //   94: astore_1
    //   95: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq -31 -> 67
    //   101: ldc 244
    //   103: iconst_2
    //   104: ldc_w 557
    //   107: aload_1
    //   108: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   111: goto -44 -> 67
    //   114: astore 7
    //   116: aload 6
    //   118: astore_1
    //   119: aload 8
    //   121: astore 6
    //   123: iload_3
    //   124: istore 4
    //   126: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +14 -> 143
    //   132: ldc 244
    //   134: iconst_2
    //   135: ldc_w 557
    //   138: aload 7
    //   140: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   143: aload_1
    //   144: ifnull +7 -> 151
    //   147: aload_1
    //   148: invokevirtual 286	java/io/FileInputStream:close	()V
    //   151: iload 4
    //   153: istore_3
    //   154: aload 6
    //   156: ifnull -64 -> 92
    //   159: aload 6
    //   161: invokevirtual 560	java/util/zip/GZIPOutputStream:close	()V
    //   164: iload 4
    //   166: ireturn
    //   167: astore_1
    //   168: iload 4
    //   170: istore_3
    //   171: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq -82 -> 92
    //   177: ldc 244
    //   179: iconst_2
    //   180: ldc_w 557
    //   183: aload_1
    //   184: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   187: iload 4
    //   189: ireturn
    //   190: astore_1
    //   191: iload 5
    //   193: istore_3
    //   194: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq -105 -> 92
    //   200: ldc 244
    //   202: iconst_2
    //   203: ldc_w 557
    //   206: aload_1
    //   207: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   210: iconst_0
    //   211: ireturn
    //   212: new 559	java/util/zip/GZIPOutputStream
    //   215: dup
    //   216: new 562	java/io/FileOutputStream
    //   219: dup
    //   220: aload_1
    //   221: invokespecial 563	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   224: invokespecial 566	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   227: astore_1
    //   228: iload 4
    //   230: istore_3
    //   231: sipush 10240
    //   234: newarray byte
    //   236: astore 7
    //   238: iload 4
    //   240: istore_3
    //   241: aload 6
    //   243: aload 7
    //   245: iconst_0
    //   246: sipush 10240
    //   249: invokevirtual 278	java/io/FileInputStream:read	([BII)I
    //   252: istore_2
    //   253: iload_2
    //   254: iconst_m1
    //   255: if_icmpeq +17 -> 272
    //   258: iload 4
    //   260: istore_3
    //   261: aload_1
    //   262: aload 7
    //   264: iconst_0
    //   265: iload_2
    //   266: invokevirtual 567	java/util/zip/GZIPOutputStream:write	([BII)V
    //   269: goto -31 -> 238
    //   272: iconst_1
    //   273: istore_3
    //   274: iconst_1
    //   275: istore 4
    //   277: aload_1
    //   278: invokevirtual 570	java/util/zip/GZIPOutputStream:flush	()V
    //   281: aload 6
    //   283: ifnull +8 -> 291
    //   286: aload 6
    //   288: invokevirtual 286	java/io/FileInputStream:close	()V
    //   291: iload 4
    //   293: istore_3
    //   294: aload_1
    //   295: ifnull -203 -> 92
    //   298: aload_1
    //   299: invokevirtual 560	java/util/zip/GZIPOutputStream:close	()V
    //   302: iconst_1
    //   303: ireturn
    //   304: astore_1
    //   305: iload 4
    //   307: istore_3
    //   308: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq -219 -> 92
    //   314: ldc 244
    //   316: iconst_2
    //   317: ldc_w 557
    //   320: aload_1
    //   321: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   324: iconst_1
    //   325: ireturn
    //   326: astore_1
    //   327: aconst_null
    //   328: astore 6
    //   330: aload 6
    //   332: ifnull +8 -> 340
    //   335: aload 6
    //   337: invokevirtual 286	java/io/FileInputStream:close	()V
    //   340: aload 7
    //   342: ifnull +8 -> 350
    //   345: aload 7
    //   347: invokevirtual 560	java/util/zip/GZIPOutputStream:close	()V
    //   350: aload_1
    //   351: athrow
    //   352: astore 6
    //   354: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq -7 -> 350
    //   360: ldc 244
    //   362: iconst_2
    //   363: ldc_w 557
    //   366: aload 6
    //   368: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   371: goto -21 -> 350
    //   374: astore_1
    //   375: goto -45 -> 330
    //   378: astore 8
    //   380: aload_1
    //   381: astore 7
    //   383: aload 8
    //   385: astore_1
    //   386: goto -56 -> 330
    //   389: astore 7
    //   391: aload_1
    //   392: astore 8
    //   394: aload 7
    //   396: astore_1
    //   397: aload 6
    //   399: astore 7
    //   401: aload 8
    //   403: astore 6
    //   405: goto -75 -> 330
    //   408: astore 7
    //   410: aconst_null
    //   411: astore_1
    //   412: iload_3
    //   413: istore 4
    //   415: aload 8
    //   417: astore 6
    //   419: goto -293 -> 126
    //   422: astore 7
    //   424: aload_1
    //   425: astore 8
    //   427: aload 6
    //   429: astore_1
    //   430: iload_3
    //   431: istore 4
    //   433: aload 8
    //   435: astore 6
    //   437: goto -311 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	this	bbxa
    //   0	440	1	paramFile	File
    //   252	14	2	i	int
    //   7	424	3	bool1	boolean
    //   9	423	4	bool2	boolean
    //   12	180	5	bool3	boolean
    //   22	314	6	localObject1	Object
    //   352	46	6	localException	Exception
    //   403	33	6	localFile1	File
    //   1	1	7	localObject2	Object
    //   114	25	7	localIOException1	java.io.IOException
    //   236	146	7	localObject3	Object
    //   389	6	7	localObject4	Object
    //   399	1	7	localObject5	Object
    //   408	1	7	localIOException2	java.io.IOException
    //   422	1	7	localIOException3	java.io.IOException
    //   4	116	8	localObject6	Object
    //   378	6	8	localObject7	Object
    //   392	42	8	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   62	67	94	java/lang/Exception
    //   24	53	114	java/io/IOException
    //   62	67	114	java/io/IOException
    //   95	111	114	java/io/IOException
    //   212	228	114	java/io/IOException
    //   147	151	167	java/lang/Exception
    //   159	164	167	java/lang/Exception
    //   72	77	190	java/lang/Exception
    //   84	92	190	java/lang/Exception
    //   286	291	304	java/lang/Exception
    //   298	302	304	java/lang/Exception
    //   14	24	326	finally
    //   335	340	352	java/lang/Exception
    //   345	350	352	java/lang/Exception
    //   24	53	374	finally
    //   62	67	374	finally
    //   95	111	374	finally
    //   212	228	374	finally
    //   231	238	378	finally
    //   241	253	378	finally
    //   261	269	378	finally
    //   277	281	378	finally
    //   126	143	389	finally
    //   14	24	408	java/io/IOException
    //   231	238	422	java/io/IOException
    //   241	253	422	java/io/IOException
    //   261	269	422	java/io/IOException
    //   277	281	422	java/io/IOException
  }
  
  /* Error */
  public boolean a(String paramString1, long paramLong, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 413	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aconst_null
    //   10: astore 11
    //   12: aconst_null
    //   13: astore 15
    //   15: aconst_null
    //   16: astore 14
    //   18: new 572	bbxb
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 573	bbxb:<init>	(Lbbxa;)V
    //   26: astore 18
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 109	bbxa:a	(Ljava/lang/String;)Ljava/io/File;
    //   33: astore 16
    //   35: aload 16
    //   37: ifnull +19 -> 56
    //   40: aload 16
    //   42: invokevirtual 115	java/io/File:exists	()Z
    //   45: ifeq +11 -> 56
    //   48: aload 16
    //   50: invokevirtual 118	java/io/File:isFile	()Z
    //   53: ifne +166 -> 219
    //   56: aload_0
    //   57: lload_2
    //   58: iconst_m1
    //   59: iconst_1
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: getstatic 30	bbxa:e	Ljava/lang/String;
    //   68: aastore
    //   69: invokevirtual 131	bbxa:a	(JI[Ljava/lang/Object;)V
    //   72: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +29 -> 104
    //   78: ldc 244
    //   80: iconst_2
    //   81: new 159	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   88: ldc_w 575
    //   91: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_1
    //   95: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 483	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: iconst_0
    //   105: ifeq +11 -> 116
    //   108: new 554	java/lang/NullPointerException
    //   111: dup
    //   112: invokespecial 555	java/lang/NullPointerException:<init>	()V
    //   115: athrow
    //   116: iconst_0
    //   117: ifeq +11 -> 128
    //   120: new 554	java/lang/NullPointerException
    //   123: dup
    //   124: invokespecial 555	java/lang/NullPointerException:<init>	()V
    //   127: athrow
    //   128: iconst_0
    //   129: ifeq +11 -> 140
    //   132: new 554	java/lang/NullPointerException
    //   135: dup
    //   136: invokespecial 555	java/lang/NullPointerException:<init>	()V
    //   139: athrow
    //   140: iload 5
    //   142: ifeq +45 -> 187
    //   145: aload_0
    //   146: new 159	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   153: aload_1
    //   154: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_0
    //   158: getfield 47	bbxa:c	Ljava/lang/String;
    //   161: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokevirtual 109	bbxa:a	(Ljava/lang/String;)Ljava/io/File;
    //   170: astore_1
    //   171: aload_1
    //   172: ifnull +15 -> 187
    //   175: aload_1
    //   176: invokevirtual 115	java/io/File:exists	()Z
    //   179: ifeq +8 -> 187
    //   182: aload_1
    //   183: invokevirtual 265	java/io/File:delete	()Z
    //   186: pop
    //   187: aload 18
    //   189: iconst_1
    //   190: invokestatic 578	bbxb:a	(Lbbxb;Z)Z
    //   193: pop
    //   194: iconst_0
    //   195: ireturn
    //   196: astore_1
    //   197: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +13 -> 213
    //   203: ldc 244
    //   205: iconst_2
    //   206: ldc_w 580
    //   209: aload_1
    //   210: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   213: aload_1
    //   214: invokevirtual 353	java/lang/Exception:printStackTrace	()V
    //   217: iconst_0
    //   218: ireturn
    //   219: invokestatic 584	nlw:a	()I
    //   222: iconst_1
    //   223: if_icmpne +186 -> 409
    //   226: ldc2_w 585
    //   229: lstore 9
    //   231: aload 16
    //   233: invokevirtual 122	java/io/File:length	()J
    //   236: lload 9
    //   238: lcmp
    //   239: ifle +178 -> 417
    //   242: aload_0
    //   243: lload_2
    //   244: iconst_m1
    //   245: iconst_1
    //   246: anewarray 4	java/lang/Object
    //   249: dup
    //   250: iconst_0
    //   251: getstatic 27	bbxa:d	Ljava/lang/String;
    //   254: aastore
    //   255: invokevirtual 131	bbxa:a	(JI[Ljava/lang/Object;)V
    //   258: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq +33 -> 294
    //   264: ldc 244
    //   266: iconst_2
    //   267: new 159	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   274: ldc_w 588
    //   277: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload 16
    //   282: invokevirtual 122	java/io/File:length	()J
    //   285: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   288: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 483	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   294: iconst_0
    //   295: ifeq +11 -> 306
    //   298: new 554	java/lang/NullPointerException
    //   301: dup
    //   302: invokespecial 555	java/lang/NullPointerException:<init>	()V
    //   305: athrow
    //   306: iconst_0
    //   307: ifeq +11 -> 318
    //   310: new 554	java/lang/NullPointerException
    //   313: dup
    //   314: invokespecial 555	java/lang/NullPointerException:<init>	()V
    //   317: athrow
    //   318: iconst_0
    //   319: ifeq +11 -> 330
    //   322: new 554	java/lang/NullPointerException
    //   325: dup
    //   326: invokespecial 555	java/lang/NullPointerException:<init>	()V
    //   329: athrow
    //   330: iload 5
    //   332: ifeq +45 -> 377
    //   335: aload_0
    //   336: new 159	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   343: aload_1
    //   344: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_0
    //   348: getfield 47	bbxa:c	Ljava/lang/String;
    //   351: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokevirtual 109	bbxa:a	(Ljava/lang/String;)Ljava/io/File;
    //   360: astore_1
    //   361: aload_1
    //   362: ifnull +15 -> 377
    //   365: aload_1
    //   366: invokevirtual 115	java/io/File:exists	()Z
    //   369: ifeq +8 -> 377
    //   372: aload_1
    //   373: invokevirtual 265	java/io/File:delete	()Z
    //   376: pop
    //   377: aload 18
    //   379: iconst_1
    //   380: invokestatic 578	bbxb:a	(Lbbxb;Z)Z
    //   383: pop
    //   384: iconst_0
    //   385: ireturn
    //   386: astore_1
    //   387: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   390: ifeq +13 -> 403
    //   393: ldc 244
    //   395: iconst_2
    //   396: ldc_w 580
    //   399: aload_1
    //   400: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   403: aload_1
    //   404: invokevirtual 353	java/lang/Exception:printStackTrace	()V
    //   407: iconst_0
    //   408: ireturn
    //   409: ldc2_w 589
    //   412: lstore 9
    //   414: goto -183 -> 231
    //   417: aload_1
    //   418: aload_1
    //   419: bipush 47
    //   421: invokevirtual 594	java/lang/String:lastIndexOf	(I)I
    //   424: iconst_1
    //   425: iadd
    //   426: invokevirtual 320	java/lang/String:substring	(I)Ljava/lang/String;
    //   429: astore 17
    //   431: aload 17
    //   433: astore 12
    //   435: aload 16
    //   437: astore 13
    //   439: iload 5
    //   441: ifeq +356 -> 797
    //   444: new 159	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   451: aload 17
    //   453: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: ldc_w 596
    //   459: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: astore 12
    //   467: aload_0
    //   468: aload 16
    //   470: invokevirtual 598	bbxa:a	(Ljava/io/File;)Z
    //   473: ifeq +209 -> 682
    //   476: aload_0
    //   477: new 159	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   484: aload_1
    //   485: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload_0
    //   489: getfield 47	bbxa:c	Ljava/lang/String;
    //   492: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: invokevirtual 109	bbxa:a	(Ljava/lang/String;)Ljava/io/File;
    //   501: astore 16
    //   503: aload 16
    //   505: ifnull +23 -> 528
    //   508: aload 16
    //   510: invokevirtual 115	java/io/File:exists	()Z
    //   513: ifeq +15 -> 528
    //   516: aload 16
    //   518: astore 13
    //   520: aload 16
    //   522: invokevirtual 118	java/io/File:isFile	()Z
    //   525: ifne +272 -> 797
    //   528: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   531: ifeq +36 -> 567
    //   534: ldc 244
    //   536: iconst_2
    //   537: new 159	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   544: ldc_w 600
    //   547: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: aload_1
    //   551: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: aload_0
    //   555: getfield 47	bbxa:c	Ljava/lang/String;
    //   558: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 483	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   567: iconst_0
    //   568: ifeq +11 -> 579
    //   571: new 554	java/lang/NullPointerException
    //   574: dup
    //   575: invokespecial 555	java/lang/NullPointerException:<init>	()V
    //   578: athrow
    //   579: iconst_0
    //   580: ifeq +11 -> 591
    //   583: new 554	java/lang/NullPointerException
    //   586: dup
    //   587: invokespecial 555	java/lang/NullPointerException:<init>	()V
    //   590: athrow
    //   591: iconst_0
    //   592: ifeq +11 -> 603
    //   595: new 554	java/lang/NullPointerException
    //   598: dup
    //   599: invokespecial 555	java/lang/NullPointerException:<init>	()V
    //   602: athrow
    //   603: iload 5
    //   605: ifeq +45 -> 650
    //   608: aload_0
    //   609: new 159	java/lang/StringBuilder
    //   612: dup
    //   613: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   616: aload_1
    //   617: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: aload_0
    //   621: getfield 47	bbxa:c	Ljava/lang/String;
    //   624: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokevirtual 109	bbxa:a	(Ljava/lang/String;)Ljava/io/File;
    //   633: astore_1
    //   634: aload_1
    //   635: ifnull +15 -> 650
    //   638: aload_1
    //   639: invokevirtual 115	java/io/File:exists	()Z
    //   642: ifeq +8 -> 650
    //   645: aload_1
    //   646: invokevirtual 265	java/io/File:delete	()Z
    //   649: pop
    //   650: aload 18
    //   652: iconst_1
    //   653: invokestatic 578	bbxb:a	(Lbbxb;Z)Z
    //   656: pop
    //   657: iconst_0
    //   658: ireturn
    //   659: astore_1
    //   660: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   663: ifeq +13 -> 676
    //   666: ldc 244
    //   668: iconst_2
    //   669: ldc_w 580
    //   672: aload_1
    //   673: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   676: aload_1
    //   677: invokevirtual 353	java/lang/Exception:printStackTrace	()V
    //   680: iconst_0
    //   681: ireturn
    //   682: iconst_0
    //   683: ifeq +11 -> 694
    //   686: new 554	java/lang/NullPointerException
    //   689: dup
    //   690: invokespecial 555	java/lang/NullPointerException:<init>	()V
    //   693: athrow
    //   694: iconst_0
    //   695: ifeq +11 -> 706
    //   698: new 554	java/lang/NullPointerException
    //   701: dup
    //   702: invokespecial 555	java/lang/NullPointerException:<init>	()V
    //   705: athrow
    //   706: iconst_0
    //   707: ifeq +11 -> 718
    //   710: new 554	java/lang/NullPointerException
    //   713: dup
    //   714: invokespecial 555	java/lang/NullPointerException:<init>	()V
    //   717: athrow
    //   718: iload 5
    //   720: ifeq +45 -> 765
    //   723: aload_0
    //   724: new 159	java/lang/StringBuilder
    //   727: dup
    //   728: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   731: aload_1
    //   732: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload_0
    //   736: getfield 47	bbxa:c	Ljava/lang/String;
    //   739: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokevirtual 109	bbxa:a	(Ljava/lang/String;)Ljava/io/File;
    //   748: astore_1
    //   749: aload_1
    //   750: ifnull +15 -> 765
    //   753: aload_1
    //   754: invokevirtual 115	java/io/File:exists	()Z
    //   757: ifeq +8 -> 765
    //   760: aload_1
    //   761: invokevirtual 265	java/io/File:delete	()Z
    //   764: pop
    //   765: aload 18
    //   767: iconst_1
    //   768: invokestatic 578	bbxb:a	(Lbbxb;Z)Z
    //   771: pop
    //   772: iconst_0
    //   773: ireturn
    //   774: astore_1
    //   775: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   778: ifeq +13 -> 791
    //   781: ldc 244
    //   783: iconst_2
    //   784: ldc_w 580
    //   787: aload_1
    //   788: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   791: aload_1
    //   792: invokevirtual 353	java/lang/Exception:printStackTrace	()V
    //   795: iconst_0
    //   796: ireturn
    //   797: new 385	java/util/TreeMap
    //   800: dup
    //   801: invokespecial 601	java/util/TreeMap:<init>	()V
    //   804: astore 16
    //   806: aload 16
    //   808: ldc_w 603
    //   811: lload_2
    //   812: invokestatic 128	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   815: invokevirtual 604	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   818: pop
    //   819: aload 16
    //   821: ldc_w 606
    //   824: ldc_w 608
    //   827: invokevirtual 604	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   830: pop
    //   831: aload 16
    //   833: ldc_w 610
    //   836: aload 12
    //   838: invokevirtual 604	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   841: pop
    //   842: aload 16
    //   844: ldc_w 612
    //   847: aload 13
    //   849: invokevirtual 122	java/io/File:length	()J
    //   852: invokestatic 128	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   855: invokevirtual 604	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   858: pop
    //   859: aload 16
    //   861: ldc_w 614
    //   864: iconst_0
    //   865: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   868: invokevirtual 604	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   871: pop
    //   872: aload 16
    //   874: ldc_w 616
    //   877: aload_0
    //   878: aload 16
    //   880: aload 4
    //   882: invokevirtual 618	bbxa:a	(Ljava/util/TreeMap;Ljava/lang/String;)Ljava/lang/String;
    //   885: invokevirtual 604	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   888: pop
    //   889: aload_0
    //   890: getfield 39	bbxa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   893: astore 4
    //   895: aload 16
    //   897: invokevirtual 386	java/util/TreeMap:keySet	()Ljava/util/Set;
    //   900: invokeinterface 227 1 0
    //   905: astore 17
    //   907: aload 17
    //   909: invokeinterface 232 1 0
    //   914: ifeq +62 -> 976
    //   917: aload 17
    //   919: invokeinterface 236 1 0
    //   924: checkcast 238	java/lang/String
    //   927: astore 19
    //   929: new 159	java/lang/StringBuilder
    //   932: dup
    //   933: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   936: aload 4
    //   938: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: aload 19
    //   943: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: ldc_w 620
    //   949: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: aload 16
    //   954: aload 19
    //   956: invokevirtual 387	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   959: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   962: ldc_w 622
    //   965: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   971: astore 4
    //   973: goto -66 -> 907
    //   976: aload 4
    //   978: ldc_w 622
    //   981: invokevirtual 311	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   984: ifeq +1102 -> 2086
    //   987: aload 4
    //   989: iconst_0
    //   990: aload 4
    //   992: invokevirtual 317	java/lang/String:length	()I
    //   995: iconst_1
    //   996: isub
    //   997: invokevirtual 323	java/lang/String:substring	(II)Ljava/lang/String;
    //   1000: astore 4
    //   1002: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1005: ifeq +30 -> 1035
    //   1008: ldc 244
    //   1010: iconst_2
    //   1011: new 159	java/lang/StringBuilder
    //   1014: dup
    //   1015: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   1018: ldc_w 624
    //   1021: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: aload 4
    //   1026: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1032: invokestatic 483	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1035: new 174	java/net/URL
    //   1038: dup
    //   1039: aload 4
    //   1041: invokespecial 177	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1044: invokevirtual 181	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1047: checkcast 183	java/net/HttpURLConnection
    //   1050: astore 4
    //   1052: aload 4
    //   1054: iconst_0
    //   1055: invokevirtual 193	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   1058: aload 4
    //   1060: iconst_1
    //   1061: invokevirtual 187	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   1064: aload_0
    //   1065: getfield 49	bbxa:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1068: iconst_2
    //   1069: invokevirtual 628	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1072: checkcast 630	mqq/app/TicketManagerImpl
    //   1075: astore 11
    //   1077: aload 4
    //   1079: ldc_w 632
    //   1082: new 159	java/lang/StringBuilder
    //   1085: dup
    //   1086: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   1089: ldc_w 634
    //   1092: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: aload_0
    //   1096: getfield 49	bbxa:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1099: invokevirtual 637	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1102: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: ldc_w 639
    //   1108: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1111: aload 11
    //   1113: aload_0
    //   1114: getfield 49	bbxa:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1117: invokevirtual 637	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1120: invokevirtual 642	mqq/app/TicketManagerImpl:getSkey	(Ljava/lang/String;)Ljava/lang/String;
    //   1123: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1129: invokevirtual 209	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1132: aload 4
    //   1134: ldc 195
    //   1136: invokevirtual 198	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   1139: aload 4
    //   1141: ldc_w 644
    //   1144: ldc_w 646
    //   1147: invokevirtual 209	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1150: aload 4
    //   1152: ldc_w 648
    //   1155: ldc_w 650
    //   1158: invokevirtual 209	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1161: aload 4
    //   1163: ldc 211
    //   1165: new 159	java/lang/StringBuilder
    //   1168: dup
    //   1169: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   1172: ldc_w 652
    //   1175: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: ldc_w 654
    //   1181: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1187: invokevirtual 209	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1190: new 656	java/io/DataOutputStream
    //   1193: dup
    //   1194: aload 4
    //   1196: invokevirtual 269	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   1199: invokespecial 657	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1202: astore 11
    //   1204: aload 11
    //   1206: new 159	java/lang/StringBuilder
    //   1209: dup
    //   1210: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   1213: ldc_w 659
    //   1216: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: ldc_w 654
    //   1222: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1225: ldc_w 661
    //   1228: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1234: invokevirtual 664	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   1237: aload 11
    //   1239: new 159	java/lang/StringBuilder
    //   1242: dup
    //   1243: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   1246: ldc_w 666
    //   1249: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: aload 12
    //   1254: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: ldc_w 668
    //   1260: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: ldc_w 661
    //   1266: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1269: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1272: invokevirtual 664	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   1275: aload 11
    //   1277: ldc_w 661
    //   1280: invokevirtual 664	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   1283: new 271	java/io/FileInputStream
    //   1286: dup
    //   1287: aload 13
    //   1289: invokespecial 274	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1292: astore 12
    //   1294: aload 12
    //   1296: invokevirtual 671	java/io/FileInputStream:available	()I
    //   1299: istore 6
    //   1301: iload 6
    //   1303: ldc_w 672
    //   1306: invokestatic 678	java/lang/Math:min	(II)I
    //   1309: istore 7
    //   1311: iload 7
    //   1313: newarray byte
    //   1315: astore 13
    //   1317: aload 18
    //   1319: iload 6
    //   1321: i2f
    //   1322: invokestatic 681	bbxb:a	(Lbbxb;F)F
    //   1325: pop
    //   1326: aload_0
    //   1327: getfield 101	bbxa:jdField_a_of_type_Bgcs	Lbgcs;
    //   1330: invokevirtual 684	bgcs:a	()Landroid/os/Handler;
    //   1333: new 686	com/tencent/mobileqq/secspy/SecSpyFileManager$3
    //   1336: dup
    //   1337: aload_0
    //   1338: aload 18
    //   1340: lload_2
    //   1341: invokespecial 689	com/tencent/mobileqq/secspy/SecSpyFileManager$3:<init>	(Lbbxa;Lbbxb;J)V
    //   1344: ldc2_w 690
    //   1347: invokevirtual 695	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   1350: pop
    //   1351: aload 12
    //   1353: aload 13
    //   1355: iconst_0
    //   1356: iload 7
    //   1358: invokevirtual 278	java/io/FileInputStream:read	([BII)I
    //   1361: istore 6
    //   1363: iload 6
    //   1365: ifle +56 -> 1421
    //   1368: aload 11
    //   1370: aload 13
    //   1372: iconst_0
    //   1373: iload 7
    //   1375: invokevirtual 696	java/io/DataOutputStream:write	([BII)V
    //   1378: aload 18
    //   1380: aload 18
    //   1382: invokestatic 699	bbxb:a	(Lbbxb;)F
    //   1385: iload 6
    //   1387: i2f
    //   1388: fadd
    //   1389: invokestatic 701	bbxb:b	(Lbbxb;F)F
    //   1392: pop
    //   1393: aload 12
    //   1395: invokevirtual 671	java/io/FileInputStream:available	()I
    //   1398: ldc_w 672
    //   1401: invokestatic 678	java/lang/Math:min	(II)I
    //   1404: istore 7
    //   1406: aload 12
    //   1408: aload 13
    //   1410: iconst_0
    //   1411: iload 7
    //   1413: invokevirtual 278	java/io/FileInputStream:read	([BII)I
    //   1416: istore 6
    //   1418: goto -55 -> 1363
    //   1421: aload 11
    //   1423: ldc_w 661
    //   1426: invokevirtual 664	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   1429: aload 11
    //   1431: new 159	java/lang/StringBuilder
    //   1434: dup
    //   1435: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   1438: ldc_w 659
    //   1441: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1444: ldc_w 654
    //   1447: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1450: ldc_w 659
    //   1453: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1456: ldc_w 661
    //   1459: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1462: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1465: invokevirtual 664	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   1468: aload 4
    //   1470: invokevirtual 293	java/net/HttpURLConnection:getResponseCode	()I
    //   1473: istore 6
    //   1475: aload 4
    //   1477: invokevirtual 704	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   1480: astore 13
    //   1482: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1485: ifeq +40 -> 1525
    //   1488: ldc 244
    //   1490: iconst_2
    //   1491: new 159	java/lang/StringBuilder
    //   1494: dup
    //   1495: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   1498: ldc 202
    //   1500: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1503: iload 6
    //   1505: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1508: ldc_w 706
    //   1511: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1514: aload 13
    //   1516: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1519: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1522: invokestatic 483	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1525: aload 11
    //   1527: invokevirtual 707	java/io/DataOutputStream:flush	()V
    //   1530: aload 11
    //   1532: invokevirtual 708	java/io/DataOutputStream:close	()V
    //   1535: aload 12
    //   1537: invokevirtual 286	java/io/FileInputStream:close	()V
    //   1540: iload 6
    //   1542: sipush 200
    //   1545: if_icmpne +535 -> 2080
    //   1548: iconst_1
    //   1549: istore 8
    //   1551: aload 11
    //   1553: ifnull +8 -> 1561
    //   1556: aload 11
    //   1558: invokevirtual 708	java/io/DataOutputStream:close	()V
    //   1561: iconst_0
    //   1562: ifeq +11 -> 1573
    //   1565: new 554	java/lang/NullPointerException
    //   1568: dup
    //   1569: invokespecial 555	java/lang/NullPointerException:<init>	()V
    //   1572: athrow
    //   1573: aload 4
    //   1575: ifnull +8 -> 1583
    //   1578: aload 4
    //   1580: invokevirtual 262	java/net/HttpURLConnection:disconnect	()V
    //   1583: iload 5
    //   1585: ifeq +45 -> 1630
    //   1588: aload_0
    //   1589: new 159	java/lang/StringBuilder
    //   1592: dup
    //   1593: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   1596: aload_1
    //   1597: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1600: aload_0
    //   1601: getfield 47	bbxa:c	Ljava/lang/String;
    //   1604: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1607: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1610: invokevirtual 109	bbxa:a	(Ljava/lang/String;)Ljava/io/File;
    //   1613: astore_1
    //   1614: aload_1
    //   1615: ifnull +15 -> 1630
    //   1618: aload_1
    //   1619: invokevirtual 115	java/io/File:exists	()Z
    //   1622: ifeq +8 -> 1630
    //   1625: aload_1
    //   1626: invokevirtual 265	java/io/File:delete	()Z
    //   1629: pop
    //   1630: aload 18
    //   1632: iconst_1
    //   1633: invokestatic 578	bbxb:a	(Lbbxb;Z)Z
    //   1636: pop
    //   1637: iload 8
    //   1639: ireturn
    //   1640: astore_1
    //   1641: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1644: ifeq +13 -> 1657
    //   1647: ldc 244
    //   1649: iconst_2
    //   1650: ldc_w 580
    //   1653: aload_1
    //   1654: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1657: aload_1
    //   1658: invokevirtual 353	java/lang/Exception:printStackTrace	()V
    //   1661: iload 8
    //   1663: ireturn
    //   1664: astore 13
    //   1666: aconst_null
    //   1667: astore 11
    //   1669: aconst_null
    //   1670: astore 12
    //   1672: aconst_null
    //   1673: astore 4
    //   1675: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1678: ifeq +14 -> 1692
    //   1681: ldc 244
    //   1683: iconst_2
    //   1684: ldc_w 710
    //   1687: aload 13
    //   1689: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1692: aload_0
    //   1693: lload_2
    //   1694: iconst_m1
    //   1695: iconst_1
    //   1696: anewarray 4	java/lang/Object
    //   1699: dup
    //   1700: iconst_0
    //   1701: aload 13
    //   1703: invokevirtual 285	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1706: aastore
    //   1707: invokevirtual 131	bbxa:a	(JI[Ljava/lang/Object;)V
    //   1710: aload 11
    //   1712: ifnull +8 -> 1720
    //   1715: aload 11
    //   1717: invokevirtual 708	java/io/DataOutputStream:close	()V
    //   1720: aload 4
    //   1722: ifnull +8 -> 1730
    //   1725: aload 4
    //   1727: invokevirtual 286	java/io/FileInputStream:close	()V
    //   1730: aload 12
    //   1732: ifnull +8 -> 1740
    //   1735: aload 12
    //   1737: invokevirtual 262	java/net/HttpURLConnection:disconnect	()V
    //   1740: iload 5
    //   1742: ifeq +45 -> 1787
    //   1745: aload_0
    //   1746: new 159	java/lang/StringBuilder
    //   1749: dup
    //   1750: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   1753: aload_1
    //   1754: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1757: aload_0
    //   1758: getfield 47	bbxa:c	Ljava/lang/String;
    //   1761: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1764: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1767: invokevirtual 109	bbxa:a	(Ljava/lang/String;)Ljava/io/File;
    //   1770: astore_1
    //   1771: aload_1
    //   1772: ifnull +15 -> 1787
    //   1775: aload_1
    //   1776: invokevirtual 115	java/io/File:exists	()Z
    //   1779: ifeq +8 -> 1787
    //   1782: aload_1
    //   1783: invokevirtual 265	java/io/File:delete	()Z
    //   1786: pop
    //   1787: aload 18
    //   1789: iconst_1
    //   1790: invokestatic 578	bbxb:a	(Lbbxb;Z)Z
    //   1793: pop
    //   1794: iconst_0
    //   1795: ireturn
    //   1796: astore_1
    //   1797: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1800: ifeq +13 -> 1813
    //   1803: ldc 244
    //   1805: iconst_2
    //   1806: ldc_w 580
    //   1809: aload_1
    //   1810: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1813: aload_1
    //   1814: invokevirtual 353	java/lang/Exception:printStackTrace	()V
    //   1817: iconst_0
    //   1818: ireturn
    //   1819: astore 4
    //   1821: aload 15
    //   1823: astore 12
    //   1825: aload 14
    //   1827: astore 13
    //   1829: aload 12
    //   1831: ifnull +8 -> 1839
    //   1834: aload 12
    //   1836: invokevirtual 708	java/io/DataOutputStream:close	()V
    //   1839: aload 13
    //   1841: ifnull +8 -> 1849
    //   1844: aload 13
    //   1846: invokevirtual 286	java/io/FileInputStream:close	()V
    //   1849: aload 11
    //   1851: ifnull +8 -> 1859
    //   1854: aload 11
    //   1856: invokevirtual 262	java/net/HttpURLConnection:disconnect	()V
    //   1859: iload 5
    //   1861: ifeq +45 -> 1906
    //   1864: aload_0
    //   1865: new 159	java/lang/StringBuilder
    //   1868: dup
    //   1869: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   1872: aload_1
    //   1873: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1876: aload_0
    //   1877: getfield 47	bbxa:c	Ljava/lang/String;
    //   1880: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1883: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1886: invokevirtual 109	bbxa:a	(Ljava/lang/String;)Ljava/io/File;
    //   1889: astore_1
    //   1890: aload_1
    //   1891: ifnull +15 -> 1906
    //   1894: aload_1
    //   1895: invokevirtual 115	java/io/File:exists	()Z
    //   1898: ifeq +8 -> 1906
    //   1901: aload_1
    //   1902: invokevirtual 265	java/io/File:delete	()Z
    //   1905: pop
    //   1906: aload 18
    //   1908: iconst_1
    //   1909: invokestatic 578	bbxb:a	(Lbbxb;Z)Z
    //   1912: pop
    //   1913: aload 4
    //   1915: athrow
    //   1916: astore_1
    //   1917: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1920: ifeq +13 -> 1933
    //   1923: ldc 244
    //   1925: iconst_2
    //   1926: ldc_w 580
    //   1929: aload_1
    //   1930: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1933: aload_1
    //   1934: invokevirtual 353	java/lang/Exception:printStackTrace	()V
    //   1937: goto -24 -> 1913
    //   1940: astore 12
    //   1942: aload 4
    //   1944: astore 11
    //   1946: aload 12
    //   1948: astore 4
    //   1950: aload 14
    //   1952: astore 13
    //   1954: aload 15
    //   1956: astore 12
    //   1958: goto -129 -> 1829
    //   1961: astore 13
    //   1963: aload 11
    //   1965: astore 12
    //   1967: aload 4
    //   1969: astore 11
    //   1971: aload 13
    //   1973: astore 4
    //   1975: aload 14
    //   1977: astore 13
    //   1979: goto -150 -> 1829
    //   1982: astore 14
    //   1984: aload 12
    //   1986: astore 13
    //   1988: aload 11
    //   1990: astore 12
    //   1992: aload 4
    //   1994: astore 11
    //   1996: aload 14
    //   1998: astore 4
    //   2000: goto -171 -> 1829
    //   2003: astore 15
    //   2005: aload 12
    //   2007: astore 13
    //   2009: aload 11
    //   2011: astore 12
    //   2013: aload 4
    //   2015: astore 14
    //   2017: aload 15
    //   2019: astore 4
    //   2021: aload 13
    //   2023: astore 11
    //   2025: aload 14
    //   2027: astore 13
    //   2029: goto -200 -> 1829
    //   2032: astore 13
    //   2034: aconst_null
    //   2035: astore 14
    //   2037: aconst_null
    //   2038: astore 11
    //   2040: aload 4
    //   2042: astore 12
    //   2044: aload 14
    //   2046: astore 4
    //   2048: goto -373 -> 1675
    //   2051: astore 13
    //   2053: aload 4
    //   2055: astore 12
    //   2057: aconst_null
    //   2058: astore 4
    //   2060: goto -385 -> 1675
    //   2063: astore 13
    //   2065: aload 4
    //   2067: astore 14
    //   2069: aload 12
    //   2071: astore 4
    //   2073: aload 14
    //   2075: astore 12
    //   2077: goto -402 -> 1675
    //   2080: iconst_0
    //   2081: istore 8
    //   2083: goto -532 -> 1551
    //   2086: goto -1084 -> 1002
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2089	0	this	bbxa
    //   0	2089	1	paramString1	String
    //   0	2089	2	paramLong	long
    //   0	2089	4	paramString2	String
    //   0	2089	5	paramBoolean	boolean
    //   1299	247	6	i	int
    //   1309	103	7	j	int
    //   1549	533	8	bool	boolean
    //   229	184	9	l	long
    //   10	2029	11	localObject1	Object
    //   433	1402	12	localObject2	Object
    //   1940	7	12	localObject3	Object
    //   1956	120	12	localObject4	Object
    //   437	1078	13	localObject5	Object
    //   1664	38	13	localException1	Exception
    //   1827	126	13	localObject6	Object
    //   1961	11	13	localObject7	Object
    //   1977	51	13	localObject8	Object
    //   2032	1	13	localException2	Exception
    //   2051	1	13	localException3	Exception
    //   2063	1	13	localException4	Exception
    //   16	1960	14	localObject9	Object
    //   1982	15	14	localObject10	Object
    //   2015	59	14	str1	String
    //   13	1942	15	localObject11	Object
    //   2003	15	15	localObject12	Object
    //   33	920	16	localObject13	Object
    //   429	489	17	localObject14	Object
    //   26	1881	18	localbbxb	bbxb
    //   927	28	19	str2	String
    // Exception table:
    //   from	to	target	type
    //   108	116	196	java/lang/Exception
    //   120	128	196	java/lang/Exception
    //   132	140	196	java/lang/Exception
    //   145	171	196	java/lang/Exception
    //   175	187	196	java/lang/Exception
    //   187	194	196	java/lang/Exception
    //   298	306	386	java/lang/Exception
    //   310	318	386	java/lang/Exception
    //   322	330	386	java/lang/Exception
    //   335	361	386	java/lang/Exception
    //   365	377	386	java/lang/Exception
    //   377	384	386	java/lang/Exception
    //   571	579	659	java/lang/Exception
    //   583	591	659	java/lang/Exception
    //   595	603	659	java/lang/Exception
    //   608	634	659	java/lang/Exception
    //   638	650	659	java/lang/Exception
    //   650	657	659	java/lang/Exception
    //   686	694	774	java/lang/Exception
    //   698	706	774	java/lang/Exception
    //   710	718	774	java/lang/Exception
    //   723	749	774	java/lang/Exception
    //   753	765	774	java/lang/Exception
    //   765	772	774	java/lang/Exception
    //   1556	1561	1640	java/lang/Exception
    //   1565	1573	1640	java/lang/Exception
    //   1578	1583	1640	java/lang/Exception
    //   1588	1614	1640	java/lang/Exception
    //   1618	1630	1640	java/lang/Exception
    //   1630	1637	1640	java/lang/Exception
    //   28	35	1664	java/lang/Exception
    //   40	56	1664	java/lang/Exception
    //   56	104	1664	java/lang/Exception
    //   219	226	1664	java/lang/Exception
    //   231	294	1664	java/lang/Exception
    //   417	431	1664	java/lang/Exception
    //   444	503	1664	java/lang/Exception
    //   508	516	1664	java/lang/Exception
    //   520	528	1664	java/lang/Exception
    //   528	567	1664	java/lang/Exception
    //   797	907	1664	java/lang/Exception
    //   907	973	1664	java/lang/Exception
    //   976	1002	1664	java/lang/Exception
    //   1002	1035	1664	java/lang/Exception
    //   1035	1052	1664	java/lang/Exception
    //   1715	1720	1796	java/lang/Exception
    //   1725	1730	1796	java/lang/Exception
    //   1735	1740	1796	java/lang/Exception
    //   1745	1771	1796	java/lang/Exception
    //   1775	1787	1796	java/lang/Exception
    //   1787	1794	1796	java/lang/Exception
    //   28	35	1819	finally
    //   40	56	1819	finally
    //   56	104	1819	finally
    //   219	226	1819	finally
    //   231	294	1819	finally
    //   417	431	1819	finally
    //   444	503	1819	finally
    //   508	516	1819	finally
    //   520	528	1819	finally
    //   528	567	1819	finally
    //   797	907	1819	finally
    //   907	973	1819	finally
    //   976	1002	1819	finally
    //   1002	1035	1819	finally
    //   1035	1052	1819	finally
    //   1834	1839	1916	java/lang/Exception
    //   1844	1849	1916	java/lang/Exception
    //   1854	1859	1916	java/lang/Exception
    //   1864	1890	1916	java/lang/Exception
    //   1894	1906	1916	java/lang/Exception
    //   1906	1913	1916	java/lang/Exception
    //   1052	1204	1940	finally
    //   1204	1294	1961	finally
    //   1294	1363	1982	finally
    //   1368	1418	1982	finally
    //   1421	1525	1982	finally
    //   1525	1540	1982	finally
    //   1675	1692	2003	finally
    //   1692	1710	2003	finally
    //   1052	1204	2032	java/lang/Exception
    //   1204	1294	2051	java/lang/Exception
    //   1294	1363	2063	java/lang/Exception
    //   1368	1418	2063	java/lang/Exception
    //   1421	1525	2063	java/lang/Exception
    //   1525	1540	2063	java/lang/Exception
  }
  
  public void b(List<String> paramList, long paramLong, String paramString)
  {
    a(this.jdField_a_of_type_Bgcs.a(paramList), paramLong, paramString, false);
    bgdc.a(paramList);
    paramList.clear();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxa
 * JD-Core Version:    0.7.0.1
 */