import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class bkcy
{
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    int j = 1;
    long l1 = System.currentTimeMillis();
    int i;
    boolean bool;
    if (ShortVideoTrimmer.a(paramContext, 0, 0))
    {
      Object localObject = ShortVideoTrimmer.a(paramString1);
      i = j;
      if (localObject != null)
      {
        i = j;
        if (((azlf)localObject).jdField_a_of_type_Boolean)
        {
          if (Build.VERSION.SDK_INT < 18) {
            break label347;
          }
          i = azhc.a(paramContext);
          if (((i & 0x1) <= 0) || ((i & 0x2) <= 0)) {
            break label333;
          }
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: isHWCodecSupported = " + bool);
          }
          if (!bool) {
            break label347;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: Try to compress using MediaCodec");
          }
          File localFile = new File(paramString1);
          localObject = new bkcz(paramString2, (int)(((azlf)localObject).b * 1024L), (int)((azlf)localObject).jdField_a_of_type_Long);
          if ((!new azlu().a(localFile, (azlv)localObject, true)) || (((bkcz)localObject).a != null)) {
            break label339;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: compress completed using MediaCodec");
          }
          i = 0;
          label199:
          if (i == 0) {
            break label419;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: Try to compress using ShortVideoTrimmer.compressVideo");
          }
          i = ShortVideoTrimmer.a(paramContext, paramString1, paramString2);
          if (i != 0) {
            break label352;
          }
          QLog.d("TroopHomeworkHelper", 1, "CompressTask, step:compress completed using ShortVideoTrimmer.compressVideo");
        }
      }
    }
    label419:
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      long l3 = new File(paramString1).length();
      long l4 = new File(paramString2).length();
      if (QLog.isColorLevel()) {
        QLog.d("TroopHomeworkHelper", 2, "CompressTask，step: ShortVideoTrimmer compress ret = " + i + ", cost:" + (l2 - l1) + "ms, fileSourceSize=" + l3 + ", fileTargetSize=" + l4);
      }
      return i;
      label333:
      bool = false;
      break;
      label339:
      QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: compress failed using MediaCodecr");
      label347:
      i = -1;
      break label199;
      try
      {
        label352:
        paramContext = new File(paramString2);
        if (paramContext.exists()) {
          paramContext.delete();
        }
        QLog.d("TroopHomeworkHelper", 1, "CompressTask, step:compress failed using ShortVideoTrimmer.compressVideo, ret = " + i);
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
      QLog.e("TroopHomeworkHelper", 2, "CompressTask，step: ShortVideoTrimmer init failure, ignore compress");
      return -1;
    }
  }
  
  /* Error */
  public static int a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 6
    //   12: aload_0
    //   13: ldc 149
    //   15: invokevirtual 155	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   18: astore 9
    //   20: aload 9
    //   22: ldc 157
    //   24: invokevirtual 161	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore_0
    //   28: aload 9
    //   30: ldc 163
    //   32: invokevirtual 161	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore 8
    //   37: aload 9
    //   39: ldc 165
    //   41: invokevirtual 161	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore 9
    //   46: new 167	java/net/URL
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 168	java/net/URL:<init>	(Ljava/lang/String;)V
    //   54: invokevirtual 172	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   57: checkcast 174	java/net/HttpURLConnection
    //   60: astore_0
    //   61: aload_0
    //   62: sipush 30000
    //   65: invokevirtual 178	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   68: aload_0
    //   69: sipush 30000
    //   72: invokevirtual 181	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   75: aload_0
    //   76: iconst_1
    //   77: invokevirtual 185	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   80: aload_0
    //   81: iconst_1
    //   82: invokevirtual 188	java/net/HttpURLConnection:setDoInput	(Z)V
    //   85: aload_0
    //   86: iconst_0
    //   87: invokevirtual 191	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   90: aload_0
    //   91: ldc 193
    //   93: invokevirtual 196	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   96: aload_0
    //   97: ldc 198
    //   99: ldc 200
    //   101: invokevirtual 204	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_0
    //   105: ldc 206
    //   107: aload 8
    //   109: invokevirtual 204	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_0
    //   113: ldc 208
    //   115: aload 9
    //   117: invokevirtual 204	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_0
    //   121: ldc 210
    //   123: ldc 212
    //   125: invokevirtual 204	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_0
    //   129: ldc 214
    //   131: aload_2
    //   132: invokevirtual 204	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: new 216	java/io/DataOutputStream
    //   138: dup
    //   139: aload_0
    //   140: invokevirtual 220	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   143: invokespecial 223	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   146: astore_2
    //   147: new 73	java/io/File
    //   150: dup
    //   151: aload_1
    //   152: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   155: astore 5
    //   157: new 225	java/io/BufferedInputStream
    //   160: dup
    //   161: new 225	java/io/BufferedInputStream
    //   164: dup
    //   165: new 227	java/io/FileInputStream
    //   168: dup
    //   169: aload 5
    //   171: invokespecial 230	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   174: invokespecial 233	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   177: invokespecial 233	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   180: astore_1
    //   181: sipush 3072
    //   184: newarray byte
    //   186: astore 8
    //   188: aload_1
    //   189: aload 8
    //   191: invokevirtual 237	java/io/BufferedInputStream:read	([B)I
    //   194: istore_3
    //   195: iload_3
    //   196: iconst_m1
    //   197: if_icmpeq +99 -> 296
    //   200: aload_2
    //   201: aload 8
    //   203: iconst_0
    //   204: iload_3
    //   205: invokevirtual 241	java/io/DataOutputStream:write	([BII)V
    //   208: goto -20 -> 188
    //   211: astore 8
    //   213: ldc 46
    //   215: iconst_2
    //   216: new 48	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   223: ldc 243
    //   225: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload 5
    //   230: invokevirtual 109	java/io/File:length	()J
    //   233: invokevirtual 119	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   236: ldc 245
    //   238: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload 5
    //   243: invokevirtual 248	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   246: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: aload_2
    //   256: invokevirtual 251	java/io/DataOutputStream:flush	()V
    //   259: aload_2
    //   260: invokevirtual 254	java/io/DataOutputStream:close	()V
    //   263: aload_0
    //   264: invokevirtual 257	java/net/HttpURLConnection:disconnect	()V
    //   267: aload_2
    //   268: astore 5
    //   270: aload_1
    //   271: invokevirtual 258	java/io/BufferedInputStream:close	()V
    //   274: iconst_0
    //   275: ifeq +11 -> 286
    //   278: new 260	java/lang/NullPointerException
    //   281: dup
    //   282: invokespecial 261	java/lang/NullPointerException:<init>	()V
    //   285: athrow
    //   286: aload_2
    //   287: ifnull +7 -> 294
    //   290: aload_2
    //   291: invokevirtual 254	java/io/DataOutputStream:close	()V
    //   294: iconst_m1
    //   295: ireturn
    //   296: aload_1
    //   297: invokevirtual 258	java/io/BufferedInputStream:close	()V
    //   300: new 263	java/lang/StringBuffer
    //   303: dup
    //   304: invokespecial 264	java/lang/StringBuffer:<init>	()V
    //   307: astore 5
    //   309: new 266	java/io/BufferedReader
    //   312: dup
    //   313: new 268	java/io/InputStreamReader
    //   316: dup
    //   317: aload_0
    //   318: invokevirtual 272	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   321: invokespecial 273	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   324: invokespecial 276	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   327: astore 4
    //   329: aload 4
    //   331: invokevirtual 279	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   334: astore_1
    //   335: aload_1
    //   336: ifnull +129 -> 465
    //   339: aload 5
    //   341: aload_1
    //   342: invokevirtual 282	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   345: ldc_w 284
    //   348: invokevirtual 282	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   351: pop
    //   352: goto -23 -> 329
    //   355: astore 4
    //   357: aload_0
    //   358: astore_1
    //   359: aload_2
    //   360: astore_0
    //   361: aload 4
    //   363: astore_2
    //   364: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   367: ifeq +13 -> 380
    //   370: ldc 46
    //   372: iconst_2
    //   373: ldc_w 286
    //   376: aload_2
    //   377: invokestatic 289	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   380: aload_1
    //   381: ifnull +7 -> 388
    //   384: aload_1
    //   385: invokevirtual 257	java/net/HttpURLConnection:disconnect	()V
    //   388: aload_0
    //   389: ifnull +259 -> 648
    //   392: aload_0
    //   393: invokevirtual 254	java/io/DataOutputStream:close	()V
    //   396: iconst_m1
    //   397: istore_3
    //   398: iload_3
    //   399: ireturn
    //   400: astore 4
    //   402: aload_1
    //   403: invokevirtual 258	java/io/BufferedInputStream:close	()V
    //   406: aload 4
    //   408: athrow
    //   409: astore 4
    //   411: aload_0
    //   412: astore_1
    //   413: aload 4
    //   415: astore_0
    //   416: aload_2
    //   417: astore 5
    //   419: aload_1
    //   420: astore 4
    //   422: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq +19 -> 444
    //   428: aload_2
    //   429: astore 5
    //   431: aload_1
    //   432: astore 4
    //   434: ldc 46
    //   436: iconst_2
    //   437: ldc_w 286
    //   440: aload_0
    //   441: invokestatic 289	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   444: aload_1
    //   445: ifnull +7 -> 452
    //   448: aload_1
    //   449: invokevirtual 257	java/net/HttpURLConnection:disconnect	()V
    //   452: aload_2
    //   453: ifnull +195 -> 648
    //   456: aload_2
    //   457: invokevirtual 254	java/io/DataOutputStream:close	()V
    //   460: iconst_m1
    //   461: istore_3
    //   462: goto -64 -> 398
    //   465: aload 5
    //   467: invokevirtual 290	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   470: pop
    //   471: aload 4
    //   473: invokevirtual 291	java/io/BufferedReader:close	()V
    //   476: aload_0
    //   477: ifnull +7 -> 484
    //   480: aload_0
    //   481: invokevirtual 257	java/net/HttpURLConnection:disconnect	()V
    //   484: aload_2
    //   485: ifnull +168 -> 653
    //   488: aload_2
    //   489: invokevirtual 254	java/io/DataOutputStream:close	()V
    //   492: iconst_0
    //   493: istore_3
    //   494: goto -96 -> 398
    //   497: astore_0
    //   498: iconst_0
    //   499: istore_3
    //   500: goto -102 -> 398
    //   503: astore_0
    //   504: iconst_m1
    //   505: istore_3
    //   506: goto -108 -> 398
    //   509: astore_0
    //   510: iconst_m1
    //   511: istore_3
    //   512: goto -114 -> 398
    //   515: astore_0
    //   516: aconst_null
    //   517: astore_2
    //   518: aload 5
    //   520: astore_1
    //   521: aload_1
    //   522: ifnull +7 -> 529
    //   525: aload_1
    //   526: invokevirtual 257	java/net/HttpURLConnection:disconnect	()V
    //   529: aload_2
    //   530: ifnull +7 -> 537
    //   533: aload_2
    //   534: invokevirtual 254	java/io/DataOutputStream:close	()V
    //   537: aload_0
    //   538: athrow
    //   539: astore_0
    //   540: iconst_m1
    //   541: ireturn
    //   542: astore_1
    //   543: goto -6 -> 537
    //   546: astore 4
    //   548: aconst_null
    //   549: astore_2
    //   550: aload_0
    //   551: astore_1
    //   552: aload 4
    //   554: astore_0
    //   555: goto -34 -> 521
    //   558: astore 4
    //   560: aload_0
    //   561: astore_1
    //   562: aload 4
    //   564: astore_0
    //   565: goto -44 -> 521
    //   568: astore_0
    //   569: aload 5
    //   571: astore_2
    //   572: aload 4
    //   574: astore_1
    //   575: goto -54 -> 521
    //   578: astore 4
    //   580: aload_0
    //   581: astore_2
    //   582: aload 4
    //   584: astore_0
    //   585: goto -64 -> 521
    //   588: astore_0
    //   589: aconst_null
    //   590: astore_2
    //   591: aload 7
    //   593: astore_1
    //   594: goto -178 -> 416
    //   597: astore 4
    //   599: aconst_null
    //   600: astore_2
    //   601: aload_0
    //   602: astore_1
    //   603: aload 4
    //   605: astore_0
    //   606: goto -190 -> 416
    //   609: astore_0
    //   610: aload 7
    //   612: astore_1
    //   613: goto -197 -> 416
    //   616: astore_2
    //   617: aconst_null
    //   618: astore_0
    //   619: aload 6
    //   621: astore_1
    //   622: goto -258 -> 364
    //   625: astore_2
    //   626: aconst_null
    //   627: astore 4
    //   629: aload_0
    //   630: astore_1
    //   631: aload 4
    //   633: astore_0
    //   634: goto -270 -> 364
    //   637: astore_1
    //   638: aload_2
    //   639: astore_0
    //   640: aload_1
    //   641: astore_2
    //   642: aload 6
    //   644: astore_1
    //   645: goto -281 -> 364
    //   648: iconst_m1
    //   649: istore_3
    //   650: goto -252 -> 398
    //   653: iconst_0
    //   654: istore_3
    //   655: goto -257 -> 398
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	658	0	paramJSONObject	JSONObject
    //   0	658	1	paramString1	String
    //   0	658	2	paramString2	String
    //   194	461	3	i	int
    //   7	323	4	localBufferedReader	java.io.BufferedReader
    //   355	7	4	localException	Exception
    //   400	7	4	localObject1	Object
    //   409	5	4	localOutOfMemoryError1	OutOfMemoryError
    //   420	52	4	str	String
    //   546	7	4	localObject2	Object
    //   558	15	4	localObject3	Object
    //   578	5	4	localObject4	Object
    //   597	7	4	localOutOfMemoryError2	OutOfMemoryError
    //   627	5	4	localObject5	Object
    //   4	566	5	localObject6	Object
    //   10	633	6	localObject7	Object
    //   1	610	7	localObject8	Object
    //   35	167	8	localObject9	Object
    //   211	1	8	localOutOfMemoryError3	OutOfMemoryError
    //   18	98	9	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   188	195	211	java/lang/OutOfMemoryError
    //   200	208	211	java/lang/OutOfMemoryError
    //   147	188	355	java/lang/Exception
    //   296	329	355	java/lang/Exception
    //   329	335	355	java/lang/Exception
    //   339	352	355	java/lang/Exception
    //   402	409	355	java/lang/Exception
    //   465	476	355	java/lang/Exception
    //   188	195	400	finally
    //   200	208	400	finally
    //   213	267	400	finally
    //   147	188	409	java/lang/OutOfMemoryError
    //   296	329	409	java/lang/OutOfMemoryError
    //   329	335	409	java/lang/OutOfMemoryError
    //   339	352	409	java/lang/OutOfMemoryError
    //   402	409	409	java/lang/OutOfMemoryError
    //   465	476	409	java/lang/OutOfMemoryError
    //   488	492	497	java/io/IOException
    //   392	396	503	java/io/IOException
    //   456	460	509	java/io/IOException
    //   46	61	515	finally
    //   290	294	539	java/io/IOException
    //   533	537	542	java/io/IOException
    //   61	147	546	finally
    //   147	188	558	finally
    //   296	329	558	finally
    //   329	335	558	finally
    //   339	352	558	finally
    //   402	409	558	finally
    //   465	476	558	finally
    //   270	274	568	finally
    //   422	428	568	finally
    //   434	444	568	finally
    //   364	380	578	finally
    //   46	61	588	java/lang/OutOfMemoryError
    //   61	147	597	java/lang/OutOfMemoryError
    //   270	274	609	java/lang/OutOfMemoryError
    //   46	61	616	java/lang/Exception
    //   61	147	625	java/lang/Exception
    //   270	274	637	java/lang/Exception
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokestatic 293	bkcy:b	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore 6
    //   9: new 73	java/io/File
    //   12: dup
    //   13: aload 6
    //   15: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore 4
    //   20: aload 4
    //   22: invokevirtual 128	java/io/File:exists	()Z
    //   25: ifne +27 -> 52
    //   28: aload 4
    //   30: invokevirtual 297	java/io/File:getParentFile	()Ljava/io/File;
    //   33: astore_2
    //   34: aload_2
    //   35: invokevirtual 128	java/io/File:exists	()Z
    //   38: ifne +8 -> 46
    //   41: aload_2
    //   42: invokevirtual 300	java/io/File:mkdirs	()Z
    //   45: pop
    //   46: aload 4
    //   48: invokevirtual 303	java/io/File:createNewFile	()Z
    //   51: pop
    //   52: new 167	java/net/URL
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 168	java/net/URL:<init>	(Ljava/lang/String;)V
    //   60: invokevirtual 172	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   63: checkcast 174	java/net/HttpURLConnection
    //   66: astore_2
    //   67: aload_2
    //   68: sipush 5000
    //   71: invokevirtual 178	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   74: aload_2
    //   75: sipush 30000
    //   78: invokevirtual 181	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   81: aload_2
    //   82: ldc_w 305
    //   85: invokevirtual 196	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   88: aload_2
    //   89: ldc 198
    //   91: ldc 200
    //   93: invokevirtual 204	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_2
    //   97: invokevirtual 272	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   100: astore_3
    //   101: new 307	java/io/FileOutputStream
    //   104: dup
    //   105: aload 4
    //   107: iconst_1
    //   108: invokespecial 310	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   111: astore 4
    //   113: sipush 1024
    //   116: newarray byte
    //   118: astore 5
    //   120: aload_3
    //   121: aload 5
    //   123: invokevirtual 313	java/io/InputStream:read	([B)I
    //   126: istore_1
    //   127: iload_1
    //   128: iconst_m1
    //   129: if_icmpeq +91 -> 220
    //   132: aload 4
    //   134: aload 5
    //   136: iconst_0
    //   137: iload_1
    //   138: invokevirtual 314	java/io/FileOutputStream:write	([BII)V
    //   141: goto -21 -> 120
    //   144: astore 5
    //   146: aload 4
    //   148: astore 5
    //   150: aload_2
    //   151: astore 4
    //   153: aload_3
    //   154: astore_2
    //   155: aload 5
    //   157: astore_3
    //   158: ldc_w 316
    //   161: iconst_2
    //   162: new 48	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 318
    //   172: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_0
    //   176: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: aload 4
    //   187: ifnull +8 -> 195
    //   190: aload 4
    //   192: invokevirtual 257	java/net/HttpURLConnection:disconnect	()V
    //   195: aload_2
    //   196: ifnull +7 -> 203
    //   199: aload_2
    //   200: invokevirtual 319	java/io/InputStream:close	()V
    //   203: aload_3
    //   204: ifnull +7 -> 211
    //   207: aload_3
    //   208: invokevirtual 320	java/io/FileOutputStream:close	()V
    //   211: aconst_null
    //   212: areturn
    //   213: astore_0
    //   214: aload_0
    //   215: invokevirtual 321	java/io/IOException:printStackTrace	()V
    //   218: aconst_null
    //   219: areturn
    //   220: aload_2
    //   221: ifnull +7 -> 228
    //   224: aload_2
    //   225: invokevirtual 257	java/net/HttpURLConnection:disconnect	()V
    //   228: aload_3
    //   229: ifnull +7 -> 236
    //   232: aload_3
    //   233: invokevirtual 319	java/io/InputStream:close	()V
    //   236: aload 4
    //   238: ifnull +8 -> 246
    //   241: aload 4
    //   243: invokevirtual 320	java/io/FileOutputStream:close	()V
    //   246: aload 6
    //   248: areturn
    //   249: astore_0
    //   250: aconst_null
    //   251: astore_2
    //   252: aconst_null
    //   253: astore 4
    //   255: aload 5
    //   257: astore_3
    //   258: aload 4
    //   260: ifnull +8 -> 268
    //   263: aload 4
    //   265: invokevirtual 257	java/net/HttpURLConnection:disconnect	()V
    //   268: aload_2
    //   269: ifnull +7 -> 276
    //   272: aload_2
    //   273: invokevirtual 319	java/io/InputStream:close	()V
    //   276: aload_3
    //   277: ifnull +7 -> 284
    //   280: aload_3
    //   281: invokevirtual 320	java/io/FileOutputStream:close	()V
    //   284: aload_0
    //   285: athrow
    //   286: astore_0
    //   287: goto -51 -> 236
    //   290: astore_0
    //   291: goto -45 -> 246
    //   294: astore_0
    //   295: goto -92 -> 203
    //   298: astore_0
    //   299: goto -88 -> 211
    //   302: astore_2
    //   303: goto -27 -> 276
    //   306: astore_2
    //   307: goto -23 -> 284
    //   310: astore_0
    //   311: aload_2
    //   312: astore 4
    //   314: aconst_null
    //   315: astore_2
    //   316: aload 5
    //   318: astore_3
    //   319: goto -61 -> 258
    //   322: astore_0
    //   323: aload_2
    //   324: astore 4
    //   326: aload_3
    //   327: astore_2
    //   328: aload 5
    //   330: astore_3
    //   331: goto -73 -> 258
    //   334: astore_0
    //   335: aload_3
    //   336: astore 5
    //   338: aload_2
    //   339: astore 6
    //   341: aload 4
    //   343: astore_3
    //   344: aload 5
    //   346: astore_2
    //   347: aload 6
    //   349: astore 4
    //   351: goto -93 -> 258
    //   354: astore_0
    //   355: goto -97 -> 258
    //   358: astore_2
    //   359: aconst_null
    //   360: astore_3
    //   361: aconst_null
    //   362: astore_2
    //   363: aconst_null
    //   364: astore 4
    //   366: goto -208 -> 158
    //   369: astore_3
    //   370: aconst_null
    //   371: astore 5
    //   373: aload_2
    //   374: astore 4
    //   376: aconst_null
    //   377: astore_3
    //   378: aload 5
    //   380: astore_2
    //   381: goto -223 -> 158
    //   384: astore 4
    //   386: aload_3
    //   387: astore 4
    //   389: aload_2
    //   390: astore 5
    //   392: aconst_null
    //   393: astore_3
    //   394: aload 4
    //   396: astore_2
    //   397: aload 5
    //   399: astore 4
    //   401: goto -243 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	paramString	String
    //   126	12	1	i	int
    //   33	240	2	localObject1	Object
    //   302	1	2	localIOException1	IOException
    //   306	6	2	localIOException2	IOException
    //   315	32	2	localObject2	Object
    //   358	1	2	localException1	Exception
    //   362	35	2	localObject3	Object
    //   100	261	3	localObject4	Object
    //   369	1	3	localException2	Exception
    //   377	17	3	localObject5	Object
    //   18	357	4	localObject6	Object
    //   384	1	4	localException3	Exception
    //   387	13	4	localObject7	Object
    //   1	134	5	arrayOfByte	byte[]
    //   144	1	5	localException4	Exception
    //   148	250	5	localObject8	Object
    //   7	341	6	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   113	120	144	java/lang/Exception
    //   120	127	144	java/lang/Exception
    //   132	141	144	java/lang/Exception
    //   46	52	213	java/io/IOException
    //   52	67	249	finally
    //   232	236	286	java/io/IOException
    //   241	246	290	java/io/IOException
    //   199	203	294	java/io/IOException
    //   207	211	298	java/io/IOException
    //   272	276	302	java/io/IOException
    //   280	284	306	java/io/IOException
    //   67	101	310	finally
    //   101	113	322	finally
    //   113	120	334	finally
    //   120	127	334	finally
    //   132	141	334	finally
    //   158	185	354	finally
    //   52	67	358	java/lang/Exception
    //   67	101	369	java/lang/Exception
    //   101	113	384	java/lang/Exception
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: new 167	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 168	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 172	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 174	java/net/HttpURLConnection
    //   20: astore 7
    //   22: aload 7
    //   24: sipush 5000
    //   27: invokevirtual 178	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   30: aload 7
    //   32: sipush 30000
    //   35: invokevirtual 181	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   38: aload 7
    //   40: iconst_1
    //   41: invokevirtual 185	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   44: aload 7
    //   46: iconst_1
    //   47: invokevirtual 188	java/net/HttpURLConnection:setDoInput	(Z)V
    //   50: aload 7
    //   52: iconst_0
    //   53: invokevirtual 191	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   56: aload 7
    //   58: ldc_w 324
    //   61: invokevirtual 196	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   64: aload 7
    //   66: ldc 198
    //   68: ldc 200
    //   70: invokevirtual 204	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload 7
    //   75: ldc 210
    //   77: new 48	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 326
    //   87: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc_w 328
    //   93: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokevirtual 204	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload 7
    //   104: ldc_w 330
    //   107: new 48	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 332
    //   117: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_2
    //   121: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc_w 334
    //   127: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_3
    //   131: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokevirtual 204	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: new 216	java/io/DataOutputStream
    //   143: dup
    //   144: aload 7
    //   146: invokevirtual 220	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   149: invokespecial 223	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   152: astore_2
    //   153: new 263	java/lang/StringBuffer
    //   156: dup
    //   157: invokespecial 264	java/lang/StringBuffer:<init>	()V
    //   160: astore 11
    //   162: aload 11
    //   164: ldc_w 336
    //   167: invokevirtual 282	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   170: ldc_w 338
    //   173: invokevirtual 282	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   176: ldc_w 328
    //   179: invokevirtual 282	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   182: ldc_w 336
    //   185: invokevirtual 282	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   188: pop
    //   189: aload 11
    //   191: ldc_w 340
    //   194: invokevirtual 282	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   197: pop
    //   198: aload 11
    //   200: new 48	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 342
    //   210: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: lload 4
    //   215: invokevirtual 119	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   218: ldc_w 342
    //   221: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokevirtual 282	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   230: pop
    //   231: aload_2
    //   232: aload 11
    //   234: invokevirtual 290	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   237: invokevirtual 348	java/lang/String:getBytes	()[B
    //   240: invokevirtual 353	java/io/OutputStream:write	([B)V
    //   243: aload 11
    //   245: iconst_0
    //   246: invokevirtual 356	java/lang/StringBuffer:setLength	(I)V
    //   249: aload 11
    //   251: ldc_w 336
    //   254: invokevirtual 282	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   257: ldc_w 338
    //   260: invokevirtual 282	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   263: ldc_w 328
    //   266: invokevirtual 282	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   269: ldc_w 336
    //   272: invokevirtual 282	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   275: pop
    //   276: aload 11
    //   278: new 48	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   285: ldc_w 358
    //   288: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload_1
    //   292: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc_w 360
    //   298: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokevirtual 282	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   307: pop
    //   308: aconst_null
    //   309: astore_3
    //   310: aload_1
    //   311: ldc_w 362
    //   314: invokevirtual 366	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   317: ifeq +7 -> 324
    //   320: ldc_w 368
    //   323: astore_3
    //   324: aload_3
    //   325: ifnull +533 -> 858
    //   328: aload_3
    //   329: astore 8
    //   331: aload_3
    //   332: ldc_w 370
    //   335: invokevirtual 374	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   338: ifeq +6 -> 344
    //   341: goto +517 -> 858
    //   344: aload 11
    //   346: new 48	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   353: ldc_w 376
    //   356: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload 8
    //   361: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: ldc_w 378
    //   367: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokevirtual 282	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   376: pop
    //   377: aload_2
    //   378: aload 11
    //   380: invokevirtual 290	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   383: invokevirtual 348	java/lang/String:getBytes	()[B
    //   386: invokevirtual 353	java/io/OutputStream:write	([B)V
    //   389: new 380	java/io/DataInputStream
    //   392: dup
    //   393: new 227	java/io/FileInputStream
    //   396: dup
    //   397: aload_1
    //   398: invokespecial 381	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   401: invokespecial 382	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   404: astore_1
    //   405: sipush 1024
    //   408: newarray byte
    //   410: astore_3
    //   411: aload_1
    //   412: aload_3
    //   413: invokevirtual 383	java/io/DataInputStream:read	([B)I
    //   416: istore 6
    //   418: iload 6
    //   420: iconst_m1
    //   421: if_icmpeq +92 -> 513
    //   424: aload_2
    //   425: aload_3
    //   426: iconst_0
    //   427: iload 6
    //   429: invokevirtual 384	java/io/OutputStream:write	([BII)V
    //   432: goto -21 -> 411
    //   435: astore_3
    //   436: aload 7
    //   438: astore_3
    //   439: aconst_null
    //   440: astore 8
    //   442: aload_2
    //   443: astore 7
    //   445: aload_1
    //   446: astore_2
    //   447: aload 8
    //   449: astore_1
    //   450: ldc_w 316
    //   453: iconst_2
    //   454: new 48	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   461: ldc_w 386
    //   464: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload_0
    //   468: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   477: aload_3
    //   478: ifnull +7 -> 485
    //   481: aload_3
    //   482: invokevirtual 257	java/net/HttpURLConnection:disconnect	()V
    //   485: aload_2
    //   486: ifnull +7 -> 493
    //   489: aload_2
    //   490: invokevirtual 387	java/io/DataInputStream:close	()V
    //   493: aload 7
    //   495: ifnull +8 -> 503
    //   498: aload 7
    //   500: invokevirtual 388	java/io/OutputStream:close	()V
    //   503: aload_1
    //   504: ifnull +349 -> 853
    //   507: aload_1
    //   508: invokevirtual 291	java/io/BufferedReader:close	()V
    //   511: aconst_null
    //   512: areturn
    //   513: aload_2
    //   514: new 48	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   521: ldc_w 390
    //   524: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: ldc_w 328
    //   530: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: ldc_w 392
    //   536: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokevirtual 348	java/lang/String:getBytes	()[B
    //   545: invokevirtual 353	java/io/OutputStream:write	([B)V
    //   548: aload_2
    //   549: invokevirtual 393	java/io/OutputStream:flush	()V
    //   552: aload 11
    //   554: iconst_0
    //   555: invokevirtual 356	java/lang/StringBuffer:setLength	(I)V
    //   558: new 266	java/io/BufferedReader
    //   561: dup
    //   562: new 268	java/io/InputStreamReader
    //   565: dup
    //   566: aload 7
    //   568: invokevirtual 272	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   571: invokespecial 273	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   574: invokespecial 276	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   577: astore_3
    //   578: aload_3
    //   579: invokevirtual 279	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   582: astore 8
    //   584: aload 8
    //   586: ifnull +20 -> 606
    //   589: aload 11
    //   591: aload 8
    //   593: invokevirtual 282	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   596: ldc_w 284
    //   599: invokevirtual 282	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   602: pop
    //   603: goto -25 -> 578
    //   606: aload 11
    //   608: invokevirtual 290	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   611: astore 8
    //   613: aload 7
    //   615: ifnull +8 -> 623
    //   618: aload 7
    //   620: invokevirtual 257	java/net/HttpURLConnection:disconnect	()V
    //   623: aload_1
    //   624: ifnull +7 -> 631
    //   627: aload_1
    //   628: invokevirtual 387	java/io/DataInputStream:close	()V
    //   631: aload_2
    //   632: ifnull +7 -> 639
    //   635: aload_2
    //   636: invokevirtual 388	java/io/OutputStream:close	()V
    //   639: aload_3
    //   640: ifnull +215 -> 855
    //   643: aload_3
    //   644: invokevirtual 291	java/io/BufferedReader:close	()V
    //   647: aload 8
    //   649: areturn
    //   650: astore_0
    //   651: aload 8
    //   653: areturn
    //   654: astore_0
    //   655: aconst_null
    //   656: areturn
    //   657: astore_0
    //   658: aconst_null
    //   659: astore_3
    //   660: aconst_null
    //   661: astore_2
    //   662: aload 10
    //   664: astore_1
    //   665: aload 9
    //   667: astore 7
    //   669: aload_3
    //   670: ifnull +7 -> 677
    //   673: aload_3
    //   674: invokevirtual 257	java/net/HttpURLConnection:disconnect	()V
    //   677: aload_1
    //   678: ifnull +7 -> 685
    //   681: aload_1
    //   682: invokevirtual 387	java/io/DataInputStream:close	()V
    //   685: aload_2
    //   686: ifnull +7 -> 693
    //   689: aload_2
    //   690: invokevirtual 388	java/io/OutputStream:close	()V
    //   693: aload 7
    //   695: ifnull +8 -> 703
    //   698: aload 7
    //   700: invokevirtual 291	java/io/BufferedReader:close	()V
    //   703: aload_0
    //   704: athrow
    //   705: astore_0
    //   706: goto -75 -> 631
    //   709: astore_0
    //   710: goto -71 -> 639
    //   713: astore_0
    //   714: goto -221 -> 493
    //   717: astore_0
    //   718: goto -215 -> 503
    //   721: astore_1
    //   722: goto -37 -> 685
    //   725: astore_1
    //   726: goto -33 -> 693
    //   729: astore_1
    //   730: goto -27 -> 703
    //   733: astore_0
    //   734: aconst_null
    //   735: astore_2
    //   736: aload 7
    //   738: astore_3
    //   739: aload 9
    //   741: astore 7
    //   743: aload 10
    //   745: astore_1
    //   746: goto -77 -> 669
    //   749: astore_0
    //   750: aload 7
    //   752: astore_3
    //   753: aload 9
    //   755: astore 7
    //   757: aload 10
    //   759: astore_1
    //   760: goto -91 -> 669
    //   763: astore_0
    //   764: aload 7
    //   766: astore_3
    //   767: aload 9
    //   769: astore 7
    //   771: goto -102 -> 669
    //   774: astore_0
    //   775: aload 7
    //   777: astore 8
    //   779: aload_3
    //   780: astore 7
    //   782: aload 8
    //   784: astore_3
    //   785: goto -116 -> 669
    //   788: astore_0
    //   789: aload 7
    //   791: astore 8
    //   793: aload_1
    //   794: astore 7
    //   796: aload_2
    //   797: astore_1
    //   798: aload 8
    //   800: astore_2
    //   801: goto -132 -> 669
    //   804: astore_1
    //   805: aconst_null
    //   806: astore_1
    //   807: aconst_null
    //   808: astore_2
    //   809: aconst_null
    //   810: astore 7
    //   812: aconst_null
    //   813: astore_3
    //   814: goto -364 -> 450
    //   817: astore_1
    //   818: aconst_null
    //   819: astore_2
    //   820: aconst_null
    //   821: astore 8
    //   823: aload 7
    //   825: astore_3
    //   826: aconst_null
    //   827: astore_1
    //   828: aload 8
    //   830: astore 7
    //   832: goto -382 -> 450
    //   835: astore_1
    //   836: aload 7
    //   838: astore_3
    //   839: aconst_null
    //   840: astore_1
    //   841: aconst_null
    //   842: astore 8
    //   844: aload_2
    //   845: astore 7
    //   847: aload 8
    //   849: astore_2
    //   850: goto -400 -> 450
    //   853: aconst_null
    //   854: areturn
    //   855: aload 8
    //   857: areturn
    //   858: ldc 212
    //   860: astore 8
    //   862: goto -518 -> 344
    //   865: astore 8
    //   867: aload_1
    //   868: astore 9
    //   870: aload 7
    //   872: astore 8
    //   874: aload_3
    //   875: astore_1
    //   876: aload_2
    //   877: astore 7
    //   879: aload 9
    //   881: astore_2
    //   882: aload 8
    //   884: astore_3
    //   885: goto -435 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	888	0	paramString1	String
    //   0	888	1	paramString2	String
    //   0	888	2	paramString3	String
    //   0	888	3	paramString4	String
    //   0	888	4	paramLong	long
    //   416	12	6	i	int
    //   20	858	7	localObject1	Object
    //   329	532	8	localObject2	Object
    //   865	1	8	localException	Exception
    //   872	11	8	localObject3	Object
    //   4	876	9	str	String
    //   1	757	10	localObject4	Object
    //   160	447	11	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   405	411	435	java/lang/Exception
    //   411	418	435	java/lang/Exception
    //   424	432	435	java/lang/Exception
    //   513	578	435	java/lang/Exception
    //   643	647	650	java/io/IOException
    //   507	511	654	java/io/IOException
    //   6	22	657	finally
    //   627	631	705	java/io/IOException
    //   635	639	709	java/io/IOException
    //   489	493	713	java/io/IOException
    //   498	503	717	java/io/IOException
    //   681	685	721	java/io/IOException
    //   689	693	725	java/io/IOException
    //   698	703	729	java/io/IOException
    //   22	153	733	finally
    //   153	308	749	finally
    //   310	320	749	finally
    //   331	341	749	finally
    //   344	405	749	finally
    //   405	411	763	finally
    //   411	418	763	finally
    //   424	432	763	finally
    //   513	578	763	finally
    //   578	584	774	finally
    //   589	603	774	finally
    //   606	613	774	finally
    //   450	477	788	finally
    //   6	22	804	java/lang/Exception
    //   22	153	817	java/lang/Exception
    //   153	308	835	java/lang/Exception
    //   310	320	835	java/lang/Exception
    //   331	341	835	java/lang/Exception
    //   344	405	835	java/lang/Exception
    //   578	584	865	java/lang/Exception
    //   589	603	865	java/lang/Exception
    //   606	613	865	java/lang/Exception
  }
  
  private static JSONObject a(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle1, Bundle paramBundle2)
  {
    try
    {
      paramString = ndb.a(paramAppRuntime.getApplication().getApplicationContext(), paramString, paramBundle1, paramBundle2);
      paramAppRuntime = paramString;
      if (paramString == null) {
        paramAppRuntime = "";
      }
      paramAppRuntime = new JSONObject(paramAppRuntime);
      return paramAppRuntime;
    }
    catch (IOException paramAppRuntime)
    {
      QLog.w("TroopHomeworkHelper", 2, paramAppRuntime.getMessage(), paramAppRuntime);
      return null;
    }
    catch (JSONException paramAppRuntime)
    {
      QLog.w("TroopHomeworkHelper", 2, paramAppRuntime.getMessage(), paramAppRuntime);
      return null;
    }
    catch (OutOfMemoryError paramAppRuntime)
    {
      QLog.w("TroopHomeworkHelper", 2, paramAppRuntime.getMessage(), paramAppRuntime);
    }
    return null;
  }
  
  public static JSONObject a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3)
  {
    String str = paramAppRuntime.getAccount();
    Object localObject = (TicketManager)paramAppRuntime.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(paramAppRuntime.getAccount());; localObject = null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("filename", paramString1);
      localBundle.putString("gc", paramString2);
      localBundle.putString("file_sha1", paramString3);
      localBundle.putString("bkn", String.valueOf(bcpx.b((String)localObject)));
      paramString1 = new Bundle();
      paramString1.putString("Cookie", "uin=" + str + ";skey=" + (String)localObject);
      if (bkcw.a().a()) {
        return a(paramAppRuntime, "https://qun.qq.com/cgi-bin/grouphw/upload_auth/put", localBundle, paramString1);
      }
      return b(paramAppRuntime, "https://qun.qq.com/cgi-bin/grouphw/upload_auth/put", localBundle, paramString1);
    }
  }
  
  public static String b(String paramString)
  {
    Object localObject = alof.bt;
    long l = System.currentTimeMillis();
    String str = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date(l));
    localObject = new StringBuilder((String)localObject).append("stream").append(str);
    if (paramString.toLowerCase().endsWith(".slk")) {
      ((StringBuilder)localObject).append(".slk");
    }
    for (;;)
    {
      return bdzf.a(((StringBuilder)localObject).toString());
      ((StringBuilder)localObject).append(".amr");
    }
  }
  
  private static JSONObject b(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle1, Bundle paramBundle2)
  {
    int i;
    try
    {
      String str = ndd.a(paramAppRuntime.getApplication().getApplicationContext(), paramString, "GET", paramBundle1, paramBundle2);
      Object localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      localObject1 = new JSONObject((String)localObject1);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      i = 1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException = localJSONException;
      QLog.w("TroopHomeworkHelper", 2, localJSONException.getMessage(), localJSONException);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.w("TroopHomeworkHelper", 2, localOutOfMemoryError.getMessage(), localOutOfMemoryError);
    }
    finally
    {
      i = 0;
    }
    if (i != 0)
    {
      QLog.e("TroopHomeworkHelper", 2, "getCosUploadByHttpClient io error, use getCosUploadByHttpURLConnection again");
      a(paramAppRuntime, paramString, paramBundle1, paramBundle2);
    }
    throw localObject2;
    return null;
  }
  
  public static JSONObject b(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3)
  {
    String str = paramAppRuntime.getAccount();
    Object localObject = (TicketManager)paramAppRuntime.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(paramAppRuntime.getAccount());; localObject = null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("filename", paramString1);
      localBundle.putString("gc", paramString2);
      localBundle.putString("positions", paramString3);
      localBundle.putString("bkn", String.valueOf(bcpx.b((String)localObject)));
      paramString1 = new Bundle();
      paramString1.putString("Cookie", "uin=" + str + ";skey=" + (String)localObject);
      if (bkcw.a().a()) {
        return a(paramAppRuntime, "https://qun.qq.com/cgi-bin/grouphw/upload_append", localBundle, paramString1);
      }
      return b(paramAppRuntime, "https://qun.qq.com/cgi-bin/grouphw/upload_append", localBundle, paramString1);
    }
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    long l2;
    do
    {
      do
      {
        return null;
        paramString = new File(paramString);
      } while (!paramString.exists());
      l2 = paramString.length();
    } while (l2 == 0L);
    paramString = new StringBuilder();
    for (long l1 = 0L; l1 < l2; l1 += 1048576L)
    {
      paramString.append(l1 + ",");
      if (l2 - l1 <= 4096L) {
        break;
      }
    }
    paramString.deleteCharAt(paramString.length() - 1);
    return paramString.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkcy
 * JD-Core Version:    0.7.0.1
 */