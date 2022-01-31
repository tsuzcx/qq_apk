package com.tencent.hlyyb.common.a;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Random;

public class f
{
  public int a = 0;
  public String b = "";
  
  public f(int paramInt, String paramString)
  {
    this.a = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.b = str;
  }
  
  public static int a(String paramString, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    paramInt = i;
    if (!"HLConnEvent".equals(paramString))
    {
      paramInt = i;
      if (!"HLSecurityEvent".equals(paramString))
      {
        paramInt = i;
        if (!"HLDisconnEvent".equals(paramString))
        {
          paramInt = i;
          if (!"HLReqRspEvent".equals(paramString))
          {
            paramInt = i;
            if (!"HLHttpAgent".equals(paramString))
            {
              if (!"HLHttpDirect".equals(paramString)) {
                break label79;
              }
              paramInt = i;
            }
          }
        }
      }
    }
    for (;;)
    {
      i = paramInt;
      if (paramInt == 0) {
        i = 100;
      }
      return i;
      label79:
      paramInt = i;
      if (!"HLPushEvent".equals(paramString))
      {
        paramInt = i;
        if (!"B_DLSDK_Result".equals(paramString))
        {
          paramInt = i;
          if (!"HLDownTiny".equals(paramString)) {
            paramInt = -1;
          }
        }
      }
    }
  }
  
  public static long a()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      return i * l;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return -1L;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString1)) {
          break;
        }
        i = paramString1.indexOf("filename=");
        if (-1 == i) {
          break;
        }
        int k = i + 9;
        int j = paramString1.indexOf(";", k);
        i = j;
        if (j == -1) {
          i = paramString1.length();
        }
        paramString1 = paramString1.substring(k, i);
      }
      catch (Exception paramString1)
      {
        try
        {
          int i;
          String str1;
          String str4;
          String str2 = URLDecoder.decode(paramString1, "gbk");
          paramString1 = str2;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2) {}
        paramString1 = paramString1;
        paramString1.printStackTrace();
        return null;
      }
      try
      {
        str1 = URLDecoder.decode(paramString1, "utf-8");
        paramString1 = str1;
        if (TextUtils.isEmpty(paramString1)) {
          break;
        }
        i = paramString1.lastIndexOf("/") + 1;
        if (i <= 0) {
          break label142;
        }
        str1 = paramString1.substring(i);
        str4 = str1;
        if (!TextUtils.isEmpty(str1)) {
          str4 = c(paramString1, paramString2);
        }
        return str4;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1) {}
      continue;
      label142:
      String str3 = paramString1;
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = a(paramString3, paramString4);
    paramString3 = str;
    if (str == null)
    {
      paramString1 = b(paramString1, paramString4);
      paramString3 = paramString1;
      if (paramString1 == null)
      {
        paramString1 = "downloadfile" + paramString4;
        paramString3 = paramString1;
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString3 = paramString1;
          if (paramString2.equalsIgnoreCase("application/vnd.android.package-archive")) {
            paramString3 = paramString1 + ".apk";
          }
        }
      }
    }
    paramString1 = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1 = paramString3.replace("?", "").replace("*", "").replace(":", "").replace("\\", "").replace("/", "").replace("\"", "").replace("<", "").replace(">", "").replace("|", "");
    }
    return paramString1;
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    boolean bool = false;
    int i = a(paramString1, paramInt2, false);
    if (a(i))
    {
      if ((i > 0) && (i < 100)) {
        paramMap1.put("B9", i);
      }
      paramMap1.put("B7", paramInt2);
      paramMap1.put("B1", com.tencent.hlyyb.common.a.e());
      paramMap1.put("B2", com.tencent.hlyyb.common.a.a);
      paramMap1.put("B3", paramInt1);
      paramMap2 = com.tencent.hlyyb.common.a.g();
      if (!TextUtils.isEmpty(paramMap2)) {
        paramMap1.put("B4", paramMap2);
      }
      paramMap2 = a.c();
      if (!TextUtils.isEmpty(paramMap2)) {
        paramMap1.put("B29", paramMap2);
      }
      paramMap1.put("B6", a.b());
      if (!TextUtils.isEmpty(paramString2)) {
        paramMap1.put("B8", paramString2);
      }
      paramMap1.put("D1", com.tencent.hlyyb.common.a.c());
      paramMap1.put("D2", com.tencent.hlyyb.common.a.d());
      if (paramInt2 == 0) {
        bool = true;
      }
      a(paramString1, bool, paramMap1);
    }
  }
  
  /* Error */
  public static void a(String paramString, long paramLong, com.tencent.hlyyb.downloader.d.b paramb, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 238	com/tencent/hlyyb/downloader/d/a/a
    //   3: dup
    //   4: invokespecial 239	com/tencent/hlyyb/downloader/d/a/a:<init>	()V
    //   7: astore 13
    //   9: new 241	com/tencent/hlyyb/downloader/d/a/b
    //   12: dup
    //   13: invokespecial 242	com/tencent/hlyyb/downloader/d/a/b:<init>	()V
    //   16: astore 14
    //   18: aload 14
    //   20: aload_0
    //   21: putfield 243	com/tencent/hlyyb/downloader/d/a/b:a	Ljava/lang/String;
    //   24: aload 14
    //   26: lload_1
    //   27: putfield 246	com/tencent/hlyyb/downloader/d/a/b:c	J
    //   30: iload 5
    //   32: ifeq +481 -> 513
    //   35: iconst_1
    //   36: istore 4
    //   38: aload 14
    //   40: iload 4
    //   42: putfield 248	com/tencent/hlyyb/downloader/d/a/b:b	I
    //   45: aload 14
    //   47: invokevirtual 251	com/tencent/hlyyb/downloader/d/a/b:a	()Ljava/lang/Object;
    //   50: astore 14
    //   52: aload 13
    //   54: getfield 254	com/tencent/hlyyb/downloader/d/a/a:a	Ljava/util/Map;
    //   57: ldc_w 256
    //   60: aload 14
    //   62: invokeinterface 191 3 0
    //   67: pop
    //   68: iconst_0
    //   69: istore 9
    //   71: iconst_0
    //   72: istore 11
    //   74: iconst_0
    //   75: istore 10
    //   77: iconst_0
    //   78: istore 7
    //   80: ldc 17
    //   82: astore 17
    //   84: iconst_0
    //   85: istore 8
    //   87: aconst_null
    //   88: astore 15
    //   90: new 258	java/net/URL
    //   93: dup
    //   94: ldc_w 260
    //   97: invokespecial 261	java/net/URL:<init>	(Ljava/lang/String;)V
    //   100: invokevirtual 265	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   103: checkcast 267	java/net/HttpURLConnection
    //   106: astore 14
    //   108: aload 14
    //   110: ldc_w 269
    //   113: invokevirtual 272	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   116: aload 14
    //   118: sipush 20000
    //   121: invokevirtual 276	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   124: aload 14
    //   126: sipush 20000
    //   129: invokevirtual 279	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   132: aload 14
    //   134: iconst_0
    //   135: invokevirtual 283	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   138: aload 14
    //   140: iconst_1
    //   141: invokevirtual 286	java/net/HttpURLConnection:setDoInput	(Z)V
    //   144: aload 14
    //   146: iconst_1
    //   147: invokevirtual 289	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   150: aload 14
    //   152: iconst_1
    //   153: invokevirtual 292	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   156: aload 14
    //   158: invokevirtual 295	java/net/HttpURLConnection:connect	()V
    //   161: new 297	java/io/DataOutputStream
    //   164: dup
    //   165: aload 14
    //   167: invokevirtual 301	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   170: invokespecial 304	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   173: astore 16
    //   175: iload 7
    //   177: istore 4
    //   179: iload 11
    //   181: istore 6
    //   183: aload 16
    //   185: aload 13
    //   187: invokevirtual 307	com/tencent/hlyyb/downloader/d/a/a:a	()[B
    //   190: invokevirtual 311	java/io/DataOutputStream:write	([B)V
    //   193: iload 7
    //   195: istore 4
    //   197: iload 11
    //   199: istore 6
    //   201: aload 16
    //   203: invokevirtual 314	java/io/DataOutputStream:flush	()V
    //   206: iload 7
    //   208: istore 4
    //   210: iload 11
    //   212: istore 6
    //   214: aload 14
    //   216: invokevirtual 317	java/net/HttpURLConnection:getResponseCode	()I
    //   219: istore 12
    //   221: iload 7
    //   223: istore 4
    //   225: iload 11
    //   227: istore 6
    //   229: aload 14
    //   231: invokevirtual 321	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   234: pop
    //   235: iload 12
    //   237: sipush 200
    //   240: if_icmpne +627 -> 867
    //   243: iload 7
    //   245: istore 4
    //   247: iload 11
    //   249: istore 6
    //   251: aload 14
    //   253: invokevirtual 324	java/net/HttpURLConnection:getContentLength	()I
    //   256: istore 12
    //   258: iload 12
    //   260: ifeq +11 -> 271
    //   263: iload 12
    //   265: ldc_w 325
    //   268: if_icmple +251 -> 519
    //   271: sipush -303
    //   274: istore 6
    //   276: iload 6
    //   278: istore 4
    //   280: new 135	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   287: iload 12
    //   289: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: astore 13
    //   297: aconst_null
    //   298: astore 14
    //   300: aconst_null
    //   301: astore 15
    //   303: sipush -303
    //   306: istore 4
    //   308: aconst_null
    //   309: astore 17
    //   311: aload 17
    //   313: invokestatic 330	com/tencent/hlyyb/common/b/b:a	([B)Z
    //   316: istore 5
    //   318: iload 5
    //   320: ifne +1004 -> 1324
    //   323: new 332	com/tencent/hlyyb/downloader/d/a/c
    //   326: dup
    //   327: new 334	org/json/JSONObject
    //   330: dup
    //   331: new 31	java/lang/String
    //   334: dup
    //   335: aload 17
    //   337: invokespecial 336	java/lang/String:<init>	([B)V
    //   340: invokespecial 337	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   343: ldc_w 339
    //   346: invokevirtual 343	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   349: aload_0
    //   350: invokespecial 346	com/tencent/hlyyb/downloader/d/a/c:<init>	(Lorg/json/JSONObject;Ljava/lang/String;)V
    //   353: astore 17
    //   355: aload 17
    //   357: getfield 349	com/tencent/hlyyb/downloader/d/a/c:a	Z
    //   360: ifeq +471 -> 831
    //   363: aload_3
    //   364: aload 17
    //   366: getfield 352	com/tencent/hlyyb/downloader/d/a/c:g	Ljava/util/List;
    //   369: aload 17
    //   371: getfield 354	com/tencent/hlyyb/downloader/d/a/c:b	J
    //   374: aload 17
    //   376: getfield 356	com/tencent/hlyyb/downloader/d/a/c:c	Ljava/lang/String;
    //   379: aload 17
    //   381: getfield 359	com/tencent/hlyyb/downloader/d/a/c:f	Ljava/util/List;
    //   384: aload 17
    //   386: getfield 361	com/tencent/hlyyb/downloader/d/a/c:e	Ljava/lang/String;
    //   389: invokeinterface 366 7 0
    //   394: iconst_1
    //   395: istore 6
    //   397: aload 13
    //   399: astore 17
    //   401: iload 6
    //   403: ifne +9 -> 412
    //   406: aload_3
    //   407: invokeinterface 368 1 0
    //   412: new 370	java/util/HashMap
    //   415: dup
    //   416: invokespecial 371	java/util/HashMap:<init>	()V
    //   419: astore_3
    //   420: aload_3
    //   421: ldc_w 373
    //   424: aload_0
    //   425: invokestatic 376	com/tencent/hlyyb/common/b/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   428: invokeinterface 191 3 0
    //   433: pop
    //   434: aload_3
    //   435: ldc_w 378
    //   438: ldc_w 380
    //   441: invokeinterface 191 3 0
    //   446: pop
    //   447: aload_3
    //   448: ldc_w 382
    //   451: ldc_w 380
    //   454: invokeinterface 191 3 0
    //   459: pop
    //   460: aload_3
    //   461: ldc_w 384
    //   464: ldc_w 386
    //   467: invokeinterface 191 3 0
    //   472: pop
    //   473: ldc 45
    //   475: invokestatic 388	com/tencent/hlyyb/common/a:b	()I
    //   478: iload 4
    //   480: aload 17
    //   482: aload_3
    //   483: aconst_null
    //   484: invokestatic 390	com/tencent/hlyyb/common/a/f:a	(Ljava/lang/String;IILjava/lang/String;Ljava/util/Map;Ljava/util/Map;)V
    //   487: aload 16
    //   489: invokevirtual 393	java/io/DataOutputStream:close	()V
    //   492: aload 14
    //   494: ifnull +8 -> 502
    //   497: aload 14
    //   499: invokevirtual 396	java/io/DataInputStream:close	()V
    //   502: aload 15
    //   504: ifnull +8 -> 512
    //   507: aload 15
    //   509: invokevirtual 399	java/io/BufferedInputStream:close	()V
    //   512: return
    //   513: iconst_0
    //   514: istore 4
    //   516: goto -478 -> 38
    //   519: iload 12
    //   521: ifge +246 -> 767
    //   524: iload 7
    //   526: istore 4
    //   528: iload 11
    //   530: istore 6
    //   532: ldc_w 401
    //   535: aload 14
    //   537: ldc_w 403
    //   540: invokevirtual 406	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   543: invokevirtual 35	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   546: ifeq +803 -> 1349
    //   549: iload 7
    //   551: istore 4
    //   553: iload 11
    //   555: istore 6
    //   557: new 398	java/io/BufferedInputStream
    //   560: dup
    //   561: aload 14
    //   563: invokevirtual 410	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   566: invokespecial 413	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   569: astore 13
    //   571: iload 9
    //   573: istore 4
    //   575: iload 10
    //   577: istore 6
    //   579: new 415	java/io/ByteArrayOutputStream
    //   582: dup
    //   583: invokespecial 416	java/io/ByteArrayOutputStream:<init>	()V
    //   586: astore 18
    //   588: iload 9
    //   590: istore 4
    //   592: iload 10
    //   594: istore 6
    //   596: sipush 4096
    //   599: newarray byte
    //   601: astore 14
    //   603: iconst_0
    //   604: istore 7
    //   606: iload 9
    //   608: istore 4
    //   610: iload 10
    //   612: istore 6
    //   614: aload 13
    //   616: aload 14
    //   618: invokevirtual 420	java/io/BufferedInputStream:read	([B)I
    //   621: istore 11
    //   623: iload 11
    //   625: iconst_m1
    //   626: if_icmpeq +710 -> 1336
    //   629: iload 9
    //   631: istore 4
    //   633: iload 10
    //   635: istore 6
    //   637: aload 18
    //   639: aload 14
    //   641: iconst_0
    //   642: iload 11
    //   644: invokevirtual 423	java/io/ByteArrayOutputStream:write	([BII)V
    //   647: iload 7
    //   649: iload 11
    //   651: iadd
    //   652: istore 4
    //   654: iload 4
    //   656: istore 7
    //   658: iload 4
    //   660: ldc_w 325
    //   663: if_icmple -57 -> 606
    //   666: sipush -303
    //   669: istore 6
    //   671: iload 6
    //   673: istore 4
    //   675: new 135	java/lang/StringBuilder
    //   678: dup
    //   679: ldc_w 425
    //   682: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   685: ldc_w 325
    //   688: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   691: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: astore 14
    //   696: iconst_0
    //   697: istore 6
    //   699: sipush -303
    //   702: istore 4
    //   704: iload 6
    //   706: ifeq +624 -> 1330
    //   709: aload 18
    //   711: invokevirtual 428	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   714: astore 17
    //   716: aload 18
    //   718: invokevirtual 429	java/io/ByteArrayOutputStream:close	()V
    //   721: aconst_null
    //   722: astore 18
    //   724: aload 13
    //   726: astore 15
    //   728: aload 14
    //   730: astore 13
    //   732: aload 18
    //   734: astore 14
    //   736: goto -425 -> 311
    //   739: astore 15
    //   741: aload 13
    //   743: astore 15
    //   745: aload 14
    //   747: astore 13
    //   749: aload 15
    //   751: astore 14
    //   753: aconst_null
    //   754: astore 18
    //   756: aload 14
    //   758: astore 15
    //   760: aload 18
    //   762: astore 14
    //   764: goto -453 -> 311
    //   767: iload 7
    //   769: istore 4
    //   771: iload 11
    //   773: istore 6
    //   775: iload 12
    //   777: newarray byte
    //   779: astore 18
    //   781: iload 7
    //   783: istore 4
    //   785: iload 11
    //   787: istore 6
    //   789: new 395	java/io/DataInputStream
    //   792: dup
    //   793: aload 14
    //   795: invokevirtual 410	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   798: invokespecial 430	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   801: astore 13
    //   803: aload 13
    //   805: aload 18
    //   807: invokevirtual 433	java/io/DataInputStream:readFully	([B)V
    //   810: aload 13
    //   812: astore 14
    //   814: aconst_null
    //   815: astore 15
    //   817: ldc 17
    //   819: astore 13
    //   821: iconst_0
    //   822: istore 4
    //   824: aload 18
    //   826: astore 17
    //   828: goto -517 -> 311
    //   831: ldc_w 435
    //   834: astore 17
    //   836: iconst_m1
    //   837: istore 4
    //   839: iload 8
    //   841: istore 6
    //   843: goto -442 -> 401
    //   846: astore 17
    //   848: aload 17
    //   850: invokevirtual 82	java/lang/Throwable:printStackTrace	()V
    //   853: iconst_m1
    //   854: istore 4
    //   856: ldc_w 437
    //   859: astore 13
    //   861: iconst_0
    //   862: istore 6
    //   864: goto -467 -> 397
    //   867: aconst_null
    //   868: astore 14
    //   870: aconst_null
    //   871: astore 15
    //   873: iload 12
    //   875: istore 4
    //   877: iload 8
    //   879: istore 6
    //   881: goto -480 -> 401
    //   884: astore 13
    //   886: aconst_null
    //   887: astore 13
    //   889: aconst_null
    //   890: astore 14
    //   892: iconst_0
    //   893: istore 4
    //   895: aload_3
    //   896: invokeinterface 368 1 0
    //   901: new 370	java/util/HashMap
    //   904: dup
    //   905: invokespecial 371	java/util/HashMap:<init>	()V
    //   908: astore_3
    //   909: aload_3
    //   910: ldc_w 373
    //   913: aload_0
    //   914: invokestatic 376	com/tencent/hlyyb/common/b/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   917: invokeinterface 191 3 0
    //   922: pop
    //   923: aload_3
    //   924: ldc_w 378
    //   927: ldc_w 380
    //   930: invokeinterface 191 3 0
    //   935: pop
    //   936: aload_3
    //   937: ldc_w 382
    //   940: ldc_w 380
    //   943: invokeinterface 191 3 0
    //   948: pop
    //   949: aload_3
    //   950: ldc_w 384
    //   953: ldc_w 386
    //   956: invokeinterface 191 3 0
    //   961: pop
    //   962: ldc 45
    //   964: invokestatic 388	com/tencent/hlyyb/common/a:b	()I
    //   967: iload 4
    //   969: aload 17
    //   971: aload_3
    //   972: aconst_null
    //   973: invokestatic 390	com/tencent/hlyyb/common/a/f:a	(Ljava/lang/String;IILjava/lang/String;Ljava/util/Map;Ljava/util/Map;)V
    //   976: aload 14
    //   978: ifnull +8 -> 986
    //   981: aload 14
    //   983: invokevirtual 393	java/io/DataOutputStream:close	()V
    //   986: aload 15
    //   988: ifnull +8 -> 996
    //   991: aload 15
    //   993: invokevirtual 396	java/io/DataInputStream:close	()V
    //   996: aload 13
    //   998: ifnull -486 -> 512
    //   1001: aload 13
    //   1003: invokevirtual 399	java/io/BufferedInputStream:close	()V
    //   1006: return
    //   1007: astore_0
    //   1008: return
    //   1009: astore 13
    //   1011: aconst_null
    //   1012: astore 14
    //   1014: aconst_null
    //   1015: astore 15
    //   1017: aconst_null
    //   1018: astore 16
    //   1020: iconst_0
    //   1021: istore 4
    //   1023: aload_3
    //   1024: invokeinterface 368 1 0
    //   1029: new 370	java/util/HashMap
    //   1032: dup
    //   1033: invokespecial 371	java/util/HashMap:<init>	()V
    //   1036: astore_3
    //   1037: aload_3
    //   1038: ldc_w 373
    //   1041: aload_0
    //   1042: invokestatic 376	com/tencent/hlyyb/common/b/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1045: invokeinterface 191 3 0
    //   1050: pop
    //   1051: aload_3
    //   1052: ldc_w 378
    //   1055: ldc_w 380
    //   1058: invokeinterface 191 3 0
    //   1063: pop
    //   1064: aload_3
    //   1065: ldc_w 382
    //   1068: ldc_w 380
    //   1071: invokeinterface 191 3 0
    //   1076: pop
    //   1077: aload_3
    //   1078: ldc_w 384
    //   1081: ldc_w 386
    //   1084: invokeinterface 191 3 0
    //   1089: pop
    //   1090: ldc 45
    //   1092: invokestatic 388	com/tencent/hlyyb/common/a:b	()I
    //   1095: iload 4
    //   1097: aload 17
    //   1099: aload_3
    //   1100: aconst_null
    //   1101: invokestatic 390	com/tencent/hlyyb/common/a/f:a	(Ljava/lang/String;IILjava/lang/String;Ljava/util/Map;Ljava/util/Map;)V
    //   1104: aload 16
    //   1106: ifnull +8 -> 1114
    //   1109: aload 16
    //   1111: invokevirtual 393	java/io/DataOutputStream:close	()V
    //   1114: aload 14
    //   1116: ifnull +8 -> 1124
    //   1119: aload 14
    //   1121: invokevirtual 396	java/io/DataInputStream:close	()V
    //   1124: aload 15
    //   1126: ifnull +8 -> 1134
    //   1129: aload 15
    //   1131: invokevirtual 399	java/io/BufferedInputStream:close	()V
    //   1134: aload 13
    //   1136: athrow
    //   1137: astore_0
    //   1138: goto -4 -> 1134
    //   1141: astore 13
    //   1143: aconst_null
    //   1144: astore 14
    //   1146: aconst_null
    //   1147: astore 15
    //   1149: goto -126 -> 1023
    //   1152: astore 18
    //   1154: aconst_null
    //   1155: astore 14
    //   1157: aload 13
    //   1159: astore 15
    //   1161: aload 18
    //   1163: astore 13
    //   1165: goto -142 -> 1023
    //   1168: astore 17
    //   1170: aconst_null
    //   1171: astore 18
    //   1173: aload 13
    //   1175: astore 15
    //   1177: aload 17
    //   1179: astore 13
    //   1181: aload 14
    //   1183: astore 17
    //   1185: aload 18
    //   1187: astore 14
    //   1189: goto -166 -> 1023
    //   1192: astore 14
    //   1194: aload 13
    //   1196: astore 15
    //   1198: aconst_null
    //   1199: astore 18
    //   1201: iconst_0
    //   1202: istore 4
    //   1204: aload 14
    //   1206: astore 13
    //   1208: aload 15
    //   1210: astore 14
    //   1212: aload 18
    //   1214: astore 15
    //   1216: goto -193 -> 1023
    //   1219: astore 18
    //   1221: aload 13
    //   1223: astore 17
    //   1225: aload 18
    //   1227: astore 13
    //   1229: goto -206 -> 1023
    //   1232: astore 13
    //   1234: aconst_null
    //   1235: astore 13
    //   1237: aload 16
    //   1239: astore 14
    //   1241: iload 6
    //   1243: istore 4
    //   1245: goto -350 -> 895
    //   1248: astore 14
    //   1250: aload 16
    //   1252: astore 14
    //   1254: iload 6
    //   1256: istore 4
    //   1258: goto -363 -> 895
    //   1261: astore 17
    //   1263: aload 14
    //   1265: astore 17
    //   1267: aload 16
    //   1269: astore 14
    //   1271: goto -376 -> 895
    //   1274: astore 14
    //   1276: aconst_null
    //   1277: astore 18
    //   1279: aload 16
    //   1281: astore 14
    //   1283: iconst_0
    //   1284: istore 4
    //   1286: aload 13
    //   1288: astore 15
    //   1290: aload 18
    //   1292: astore 13
    //   1294: goto -399 -> 895
    //   1297: astore 17
    //   1299: aload 15
    //   1301: astore 18
    //   1303: aload 13
    //   1305: astore 17
    //   1307: aload 14
    //   1309: astore 15
    //   1311: aload 18
    //   1313: astore 13
    //   1315: aload 16
    //   1317: astore 14
    //   1319: goto -424 -> 895
    //   1322: astore_0
    //   1323: return
    //   1324: iconst_0
    //   1325: istore 6
    //   1327: goto -930 -> 397
    //   1330: aconst_null
    //   1331: astore 17
    //   1333: goto -617 -> 716
    //   1336: iconst_1
    //   1337: istore 6
    //   1339: ldc 17
    //   1341: astore 14
    //   1343: iconst_0
    //   1344: istore 4
    //   1346: goto -642 -> 704
    //   1349: aconst_null
    //   1350: astore 14
    //   1352: ldc 17
    //   1354: astore 13
    //   1356: aconst_null
    //   1357: astore 17
    //   1359: iconst_0
    //   1360: istore 4
    //   1362: goto -609 -> 753
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1365	0	paramString	String
    //   0	1365	1	paramLong	long
    //   0	1365	3	paramb	com.tencent.hlyyb.downloader.d.b
    //   0	1365	4	paramInt	int
    //   0	1365	5	paramBoolean	boolean
    //   181	1157	6	i	int
    //   78	704	7	j	int
    //   85	793	8	k	int
    //   69	561	9	m	int
    //   75	559	10	n	int
    //   72	714	11	i1	int
    //   219	655	12	i2	int
    //   7	853	13	localObject1	Object
    //   884	1	13	localThrowable1	Throwable
    //   887	115	13	localObject2	Object
    //   1009	126	13	localObject3	Object
    //   1141	17	13	localObject4	Object
    //   1163	65	13	localObject5	Object
    //   1232	1	13	localThrowable2	Throwable
    //   1235	120	13	localObject6	Object
    //   16	1172	14	localObject7	Object
    //   1192	13	14	localObject8	Object
    //   1210	30	14	localObject9	Object
    //   1248	1	14	localThrowable3	Throwable
    //   1252	18	14	localObject10	Object
    //   1274	1	14	localThrowable4	Throwable
    //   1281	70	14	localObject11	Object
    //   88	639	15	localObject12	Object
    //   739	1	15	localException	Exception
    //   743	567	15	localObject13	Object
    //   173	1143	16	localDataOutputStream	java.io.DataOutputStream
    //   82	753	17	localObject14	Object
    //   846	252	17	localThrowable5	Throwable
    //   1168	10	17	localObject15	Object
    //   1183	41	17	localObject16	Object
    //   1261	1	17	localThrowable6	Throwable
    //   1265	1	17	localObject17	Object
    //   1297	1	17	localThrowable7	Throwable
    //   1305	53	17	localObject18	Object
    //   586	239	18	localObject19	Object
    //   1152	10	18	localObject20	Object
    //   1171	42	18	localObject21	Object
    //   1219	7	18	localObject22	Object
    //   1277	35	18	localObject23	Object
    // Exception table:
    //   from	to	target	type
    //   716	721	739	java/lang/Exception
    //   323	394	846	java/lang/Throwable
    //   90	175	884	java/lang/Throwable
    //   981	986	1007	java/lang/Throwable
    //   991	996	1007	java/lang/Throwable
    //   1001	1006	1007	java/lang/Throwable
    //   90	175	1009	finally
    //   1109	1114	1137	java/lang/Throwable
    //   1119	1124	1137	java/lang/Throwable
    //   1129	1134	1137	java/lang/Throwable
    //   183	193	1141	finally
    //   201	206	1141	finally
    //   214	221	1141	finally
    //   229	235	1141	finally
    //   251	258	1141	finally
    //   280	297	1141	finally
    //   532	549	1141	finally
    //   557	571	1141	finally
    //   775	781	1141	finally
    //   789	803	1141	finally
    //   579	588	1152	finally
    //   596	603	1152	finally
    //   614	623	1152	finally
    //   637	647	1152	finally
    //   675	696	1152	finally
    //   709	716	1168	finally
    //   716	721	1168	finally
    //   803	810	1192	finally
    //   311	318	1219	finally
    //   323	394	1219	finally
    //   848	853	1219	finally
    //   183	193	1232	java/lang/Throwable
    //   201	206	1232	java/lang/Throwable
    //   214	221	1232	java/lang/Throwable
    //   229	235	1232	java/lang/Throwable
    //   251	258	1232	java/lang/Throwable
    //   280	297	1232	java/lang/Throwable
    //   532	549	1232	java/lang/Throwable
    //   557	571	1232	java/lang/Throwable
    //   775	781	1232	java/lang/Throwable
    //   789	803	1232	java/lang/Throwable
    //   579	588	1248	java/lang/Throwable
    //   596	603	1248	java/lang/Throwable
    //   614	623	1248	java/lang/Throwable
    //   637	647	1248	java/lang/Throwable
    //   675	696	1248	java/lang/Throwable
    //   709	716	1261	java/lang/Throwable
    //   716	721	1261	java/lang/Throwable
    //   803	810	1274	java/lang/Throwable
    //   311	318	1297	java/lang/Throwable
    //   848	853	1297	java/lang/Throwable
    //   487	492	1322	java/lang/Throwable
    //   497	502	1322	java/lang/Throwable
    //   507	512	1322	java/lang/Throwable
  }
  
  public static boolean a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 100)) {
      if (new Random().nextInt(100) > paramInt) {}
    }
    while ((paramInt == -1) || (paramInt == 100))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public static boolean a(Exception paramException)
  {
    if ((paramException instanceof IOException))
    {
      paramException = paramException.getMessage();
      if ((paramException != null) && ((paramException.contains("ENOSPC")) || (paramException.contains("No space left on device")))) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  public static boolean a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: new 460	java/net/Socket
    //   8: dup
    //   9: invokespecial 461	java/net/Socket:<init>	()V
    //   12: astore 7
    //   14: aload 7
    //   16: astore 6
    //   18: aload 7
    //   20: new 463	java/net/InetSocketAddress
    //   23: dup
    //   24: aload_0
    //   25: bipush 80
    //   27: invokespecial 466	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   30: sipush 5000
    //   33: invokevirtual 469	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   36: aload 7
    //   38: astore 6
    //   40: aload 7
    //   42: invokevirtual 473	java/net/Socket:isConnected	()Z
    //   45: istore 5
    //   47: iload 5
    //   49: ifeq +5 -> 54
    //   52: iconst_1
    //   53: istore_3
    //   54: aload 7
    //   56: invokevirtual 474	java/net/Socket:close	()V
    //   59: iload_3
    //   60: ireturn
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 82	java/lang/Throwable:printStackTrace	()V
    //   66: iload_3
    //   67: ireturn
    //   68: astore 8
    //   70: aconst_null
    //   71: astore_0
    //   72: aload_0
    //   73: astore 6
    //   75: aload 8
    //   77: invokevirtual 82	java/lang/Throwable:printStackTrace	()V
    //   80: iload 4
    //   82: istore_3
    //   83: aload_0
    //   84: ifnull -25 -> 59
    //   87: aload_0
    //   88: invokevirtual 474	java/net/Socket:close	()V
    //   91: iconst_0
    //   92: ireturn
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 82	java/lang/Throwable:printStackTrace	()V
    //   98: iconst_0
    //   99: ireturn
    //   100: astore_0
    //   101: aconst_null
    //   102: astore 6
    //   104: aload 6
    //   106: ifnull +8 -> 114
    //   109: aload 6
    //   111: invokevirtual 474	java/net/Socket:close	()V
    //   114: aload_0
    //   115: athrow
    //   116: astore 6
    //   118: aload 6
    //   120: invokevirtual 82	java/lang/Throwable:printStackTrace	()V
    //   123: goto -9 -> 114
    //   126: astore_0
    //   127: goto -23 -> 104
    //   130: astore 8
    //   132: aload 7
    //   134: astore_0
    //   135: goto -63 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramString	String
    //   0	138	1	paramInt1	int
    //   0	138	2	paramInt2	int
    //   4	79	3	bool1	boolean
    //   1	80	4	bool2	boolean
    //   45	3	5	bool3	boolean
    //   16	94	6	localObject	Object
    //   116	3	6	localThrowable1	Throwable
    //   12	121	7	localSocket	java.net.Socket
    //   68	8	8	localThrowable2	Throwable
    //   130	1	8	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   54	59	61	java/lang/Throwable
    //   5	14	68	java/lang/Throwable
    //   87	91	93	java/lang/Throwable
    //   5	14	100	finally
    //   109	114	116	java/lang/Throwable
    //   18	36	126	finally
    //   40	47	126	finally
    //   75	80	126	finally
    //   18	36	130	java/lang/Throwable
    //   40	47	130	java/lang/Throwable
  }
  
  public static boolean a(String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    try
    {
      paramBoolean = b(paramString, paramBoolean, paramMap);
      return paramBoolean;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public static long b()
  {
    try
    {
      String str = com.tencent.hlyyb.common.a.a().getFilesDir().getAbsolutePath();
      StatFs localStatFs = new StatFs(str);
      localStatFs.restat(str);
      long l = localStatFs.getAvailableBlocks();
      int i = localStatFs.getBlockSize();
      return i * l;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return -1L;
  }
  
  private static String b(String paramString1, String paramString2)
  {
    String str1 = null;
    for (;;)
    {
      try
      {
        String str2 = Uri.decode(paramString1);
        if (str2 != null)
        {
          int i = str2.indexOf('?');
          paramString1 = str2;
          if (i > 0) {
            paramString1 = str2.substring(0, i);
          }
          if (!paramString1.endsWith("/"))
          {
            i = paramString1.lastIndexOf('/') + 1;
            if (i > 0)
            {
              paramString1 = paramString1.substring(i);
              if (!TextUtils.isEmpty(paramString1)) {
                str1 = c(paramString1, paramString2);
              }
              return str1;
            }
          }
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return null;
      }
      paramString1 = null;
    }
  }
  
  private static boolean b(String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    try
    {
      paramBoolean = UserAction.onUserAction(paramString, paramBoolean, 0L, 0L, paramMap, true);
      return paramBoolean;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  private static String c(String paramString1, String paramString2)
  {
    int i = paramString1.lastIndexOf(".");
    String str3 = "";
    String str2 = str3;
    String str1 = paramString1;
    if (i > 0)
    {
      str2 = str3;
      str1 = paramString1;
      if (paramString1.length() > i + 1)
      {
        str1 = paramString1.substring(0, i);
        str2 = paramString1.substring(i);
      }
    }
    return str1 + paramString2 + str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hlyyb.common.a.f
 * JD-Core Version:    0.7.0.1
 */