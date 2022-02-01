package com.tencent.mobileqq.antiphing;

import android.content.Context;
import android.net.ConnectivityManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.impl.client.DefaultHttpClient;

public class DownloadFileHelper
{
  public static ConnectivityManager a;
  public static DefaultHttpClient a;
  public Context a;
  
  public DownloadFileHelper(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  /* Error */
  private void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore 5
    //   3: aload_2
    //   4: ldc 26
    //   6: invokevirtual 32	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   9: ifne +34 -> 43
    //   12: new 34	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   19: astore 5
    //   21: aload 5
    //   23: aload_2
    //   24: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload 5
    //   30: ldc 26
    //   32: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 5
    //   38: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: astore 5
    //   43: sipush 4096
    //   46: newarray byte
    //   48: astore 8
    //   50: new 45	com/tencent/commonsdk/zip/QZipFile
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 48	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   58: astore 9
    //   60: aload 9
    //   62: invokevirtual 52	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   65: astore 10
    //   67: aload 10
    //   69: invokeinterface 58 1 0
    //   74: istore 4
    //   76: iload 4
    //   78: ifeq +325 -> 403
    //   81: aconst_null
    //   82: astore 6
    //   84: aconst_null
    //   85: astore 7
    //   87: aconst_null
    //   88: astore_1
    //   89: aload 10
    //   91: invokeinterface 62 1 0
    //   96: checkcast 64	java/util/zip/ZipEntry
    //   99: astore 11
    //   101: aload 9
    //   103: aload 11
    //   105: invokevirtual 68	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   108: astore_2
    //   109: aload 11
    //   111: invokevirtual 71	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   114: ldc 73
    //   116: invokevirtual 77	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   119: istore 4
    //   121: iload 4
    //   123: ifeq +22 -> 145
    //   126: aload_2
    //   127: ifnull -60 -> 67
    //   130: aload_2
    //   131: invokevirtual 82	java/io/InputStream:close	()V
    //   134: goto -67 -> 67
    //   137: astore_1
    //   138: aload_1
    //   139: invokevirtual 85	java/lang/Throwable:printStackTrace	()V
    //   142: goto -75 -> 67
    //   145: new 34	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   152: astore 12
    //   154: aload 12
    //   156: aload 5
    //   158: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 12
    //   164: aload 11
    //   166: invokevirtual 71	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   169: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: new 87	java/io/File
    //   176: dup
    //   177: aload 12
    //   179: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   185: astore 12
    //   187: aload 11
    //   189: invokevirtual 91	java/util/zip/ZipEntry:isDirectory	()Z
    //   192: ifeq +12 -> 204
    //   195: aload 12
    //   197: invokevirtual 94	java/io/File:mkdirs	()Z
    //   200: pop
    //   201: goto +53 -> 254
    //   204: aload 12
    //   206: invokevirtual 98	java/io/File:getParentFile	()Ljava/io/File;
    //   209: astore_1
    //   210: aload_1
    //   211: invokevirtual 101	java/io/File:exists	()Z
    //   214: ifne +8 -> 222
    //   217: aload_1
    //   218: invokevirtual 94	java/io/File:mkdirs	()Z
    //   221: pop
    //   222: new 103	java/io/FileOutputStream
    //   225: dup
    //   226: aload 12
    //   228: invokespecial 106	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   231: astore_1
    //   232: aload_2
    //   233: aload 8
    //   235: invokevirtual 110	java/io/InputStream:read	([B)I
    //   238: istore_3
    //   239: iload_3
    //   240: ifle +14 -> 254
    //   243: aload_1
    //   244: aload 8
    //   246: iconst_0
    //   247: iload_3
    //   248: invokevirtual 114	java/io/FileOutputStream:write	([BII)V
    //   251: goto -19 -> 232
    //   254: aload_1
    //   255: ifnull +15 -> 270
    //   258: aload_1
    //   259: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   262: goto +8 -> 270
    //   265: astore_1
    //   266: aload_1
    //   267: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   270: aload_2
    //   271: ifnull -204 -> 67
    //   274: aload_2
    //   275: invokevirtual 82	java/io/InputStream:close	()V
    //   278: goto -211 -> 67
    //   281: astore_1
    //   282: goto -144 -> 138
    //   285: astore 6
    //   287: aload_1
    //   288: astore 5
    //   290: aload 6
    //   292: astore_1
    //   293: goto +27 -> 320
    //   296: goto +67 -> 363
    //   299: astore_1
    //   300: aload 6
    //   302: astore 5
    //   304: goto +16 -> 320
    //   307: aload 7
    //   309: astore_1
    //   310: goto +53 -> 363
    //   313: astore_1
    //   314: aconst_null
    //   315: astore_2
    //   316: aload 6
    //   318: astore 5
    //   320: aload 5
    //   322: ifnull +18 -> 340
    //   325: aload 5
    //   327: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   330: goto +10 -> 340
    //   333: astore 5
    //   335: aload 5
    //   337: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   340: aload_2
    //   341: ifnull +15 -> 356
    //   344: aload_2
    //   345: invokevirtual 82	java/io/InputStream:close	()V
    //   348: goto +8 -> 356
    //   351: astore_2
    //   352: aload_2
    //   353: invokevirtual 85	java/lang/Throwable:printStackTrace	()V
    //   356: aload_1
    //   357: athrow
    //   358: aconst_null
    //   359: astore_2
    //   360: aload 7
    //   362: astore_1
    //   363: aload_1
    //   364: ifnull +15 -> 379
    //   367: aload_1
    //   368: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   371: goto +8 -> 379
    //   374: astore_1
    //   375: aload_1
    //   376: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   379: aload_2
    //   380: ifnull -313 -> 67
    //   383: aload_2
    //   384: invokevirtual 82	java/io/InputStream:close	()V
    //   387: goto -320 -> 67
    //   390: astore_1
    //   391: goto -253 -> 138
    //   394: astore_1
    //   395: goto +9 -> 404
    //   398: astore_1
    //   399: aload_1
    //   400: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   403: return
    //   404: goto +5 -> 409
    //   407: aload_1
    //   408: athrow
    //   409: goto -2 -> 407
    //   412: astore_1
    //   413: return
    //   414: astore_1
    //   415: goto -57 -> 358
    //   418: astore_1
    //   419: goto -112 -> 307
    //   422: astore 6
    //   424: goto -128 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	this	DownloadFileHelper
    //   0	427	1	paramString1	String
    //   0	427	2	paramString2	String
    //   238	10	3	i	int
    //   74	48	4	bool	boolean
    //   1	325	5	localObject1	Object
    //   333	3	5	localIOException1	java.io.IOException
    //   82	1	6	localObject2	Object
    //   285	32	6	localObject3	Object
    //   422	1	6	localIOException2	java.io.IOException
    //   85	276	7	localObject4	Object
    //   48	197	8	arrayOfByte	byte[]
    //   58	44	9	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   65	25	10	localEnumeration	java.util.Enumeration
    //   99	89	11	localZipEntry	java.util.zip.ZipEntry
    //   152	75	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   130	134	137	java/lang/Throwable
    //   258	262	265	java/io/IOException
    //   274	278	281	java/lang/Throwable
    //   232	239	285	finally
    //   243	251	285	finally
    //   109	121	299	finally
    //   145	201	299	finally
    //   204	222	299	finally
    //   222	232	299	finally
    //   89	109	313	finally
    //   325	330	333	java/io/IOException
    //   344	348	351	java/lang/Throwable
    //   367	371	374	java/io/IOException
    //   383	387	390	java/lang/Throwable
    //   50	67	394	finally
    //   67	76	394	finally
    //   130	134	394	finally
    //   138	142	394	finally
    //   258	262	394	finally
    //   266	270	394	finally
    //   274	278	394	finally
    //   325	330	394	finally
    //   335	340	394	finally
    //   344	348	394	finally
    //   352	356	394	finally
    //   356	358	394	finally
    //   367	371	394	finally
    //   375	379	394	finally
    //   383	387	394	finally
    //   399	403	394	finally
    //   50	67	398	java/io/IOException
    //   67	76	398	java/io/IOException
    //   130	134	398	java/io/IOException
    //   138	142	398	java/io/IOException
    //   266	270	398	java/io/IOException
    //   274	278	398	java/io/IOException
    //   335	340	398	java/io/IOException
    //   344	348	398	java/io/IOException
    //   352	356	398	java/io/IOException
    //   356	358	398	java/io/IOException
    //   375	379	398	java/io/IOException
    //   383	387	398	java/io/IOException
    //   50	67	412	java/lang/Exception
    //   67	76	412	java/lang/Exception
    //   130	134	412	java/lang/Exception
    //   138	142	412	java/lang/Exception
    //   258	262	412	java/lang/Exception
    //   266	270	412	java/lang/Exception
    //   274	278	412	java/lang/Exception
    //   325	330	412	java/lang/Exception
    //   335	340	412	java/lang/Exception
    //   344	348	412	java/lang/Exception
    //   352	356	412	java/lang/Exception
    //   356	358	412	java/lang/Exception
    //   367	371	412	java/lang/Exception
    //   375	379	412	java/lang/Exception
    //   383	387	412	java/lang/Exception
    //   89	109	414	java/io/IOException
    //   109	121	418	java/io/IOException
    //   145	201	418	java/io/IOException
    //   204	222	418	java/io/IOException
    //   222	232	418	java/io/IOException
    //   232	239	422	java/io/IOException
    //   243	251	422	java/io/IOException
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (AppNetConnInfo.isNetSupport())
    {
      if (paramString2 == null) {
        return false;
      }
      try
      {
        paramString1 = new URL(paramString1);
        return a(paramString1, paramString2, paramString3, paramBoolean);
      }
      catch (MalformedURLException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return false;
  }
  
  /* Error */
  public boolean a(URL paramURL, String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore 11
    //   3: iload 4
    //   5: ifne +63 -> 68
    //   8: new 34	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   15: astore_2
    //   16: aload_2
    //   17: aload 11
    //   19: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_2
    //   24: ldc 135
    //   26: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_2
    //   31: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore 14
    //   36: new 87	java/io/File
    //   39: dup
    //   40: aload 14
    //   42: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore 12
    //   47: new 87	java/io/File
    //   50: dup
    //   51: aload 11
    //   53: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: astore 13
    //   58: aload 11
    //   60: astore_2
    //   61: aload 14
    //   63: astore 11
    //   65: goto +114 -> 179
    //   68: aload_2
    //   69: invokevirtual 138	java/lang/String:trim	()Ljava/lang/String;
    //   72: astore 11
    //   74: aload 11
    //   76: astore_2
    //   77: aload 11
    //   79: ldc 26
    //   81: invokevirtual 32	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   84: ifne +43 -> 127
    //   87: aload 11
    //   89: astore_2
    //   90: aload 11
    //   92: ldc 140
    //   94: invokevirtual 32	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   97: ifne +30 -> 127
    //   100: new 34	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   107: astore_2
    //   108: aload_2
    //   109: aload 11
    //   111: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_2
    //   116: ldc 26
    //   118: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_2
    //   123: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore_2
    //   127: new 34	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   134: astore 11
    //   136: aload 11
    //   138: aload_2
    //   139: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 11
    //   145: ldc 142
    //   147: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 11
    //   153: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: astore 11
    //   158: new 87	java/io/File
    //   161: dup
    //   162: aload 11
    //   164: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   167: astore 12
    //   169: new 87	java/io/File
    //   172: dup
    //   173: aload_2
    //   174: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   177: astore 13
    //   179: aload 12
    //   181: invokevirtual 101	java/io/File:exists	()Z
    //   184: istore 8
    //   186: iconst_0
    //   187: istore 7
    //   189: iload 8
    //   191: ifeq +13 -> 204
    //   194: aload 12
    //   196: invokevirtual 145	java/io/File:delete	()Z
    //   199: ifne +5 -> 204
    //   202: iconst_0
    //   203: ireturn
    //   204: aload 12
    //   206: invokevirtual 98	java/io/File:getParentFile	()Ljava/io/File;
    //   209: astore 14
    //   211: aload 14
    //   213: ifnull +17 -> 230
    //   216: aload 14
    //   218: invokevirtual 101	java/io/File:exists	()Z
    //   221: ifne +9 -> 230
    //   224: aload 14
    //   226: invokevirtual 94	java/io/File:mkdirs	()Z
    //   229: pop
    //   230: aload_1
    //   231: invokevirtual 146	java/net/URL:toString	()Ljava/lang/String;
    //   234: astore 15
    //   236: new 148	org/apache/http/client/methods/HttpGet
    //   239: dup
    //   240: aload 15
    //   242: invokespecial 149	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   245: astore 14
    //   247: goto +17 -> 264
    //   250: new 148	org/apache/http/client/methods/HttpGet
    //   253: dup
    //   254: aload 15
    //   256: invokestatic 155	com/tencent/mobileqq/utils/HttpDownloadUtil:getEscapeSequence	(Ljava/lang/String;)Ljava/lang/String;
    //   259: invokespecial 149	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   262: astore 14
    //   264: new 157	org/apache/http/params/BasicHttpParams
    //   267: dup
    //   268: invokespecial 158	org/apache/http/params/BasicHttpParams:<init>	()V
    //   271: astore 16
    //   273: invokestatic 163	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   276: astore 17
    //   278: invokestatic 167	android/net/Proxy:getDefaultPort	()I
    //   281: istore 5
    //   283: invokestatic 170	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:isMobileConn	()Z
    //   286: istore 8
    //   288: invokestatic 174	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   291: astore 15
    //   293: aload 15
    //   295: ifnull +13 -> 308
    //   298: aload 15
    //   300: invokevirtual 179	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   303: astore 15
    //   305: goto +6 -> 311
    //   308: aconst_null
    //   309: astore 15
    //   311: iload 8
    //   313: ifeq +49 -> 362
    //   316: aload 15
    //   318: ifnull +13 -> 331
    //   321: aload 15
    //   323: ldc 181
    //   325: invokevirtual 32	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   328: ifeq +34 -> 362
    //   331: aload 17
    //   333: ifnull +29 -> 362
    //   336: iload 5
    //   338: ifle +24 -> 362
    //   341: aload 16
    //   343: ldc 183
    //   345: new 185	org/apache/http/HttpHost
    //   348: dup
    //   349: aload 17
    //   351: iload 5
    //   353: invokespecial 188	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   356: invokeinterface 194 3 0
    //   361: pop
    //   362: iload 8
    //   364: ifeq +28 -> 392
    //   367: sipush 20000
    //   370: istore 5
    //   372: ldc 195
    //   374: istore 6
    //   376: aload 16
    //   378: ldc 197
    //   380: sipush 2048
    //   383: invokeinterface 201 3 0
    //   388: pop
    //   389: goto +26 -> 415
    //   392: sipush 10000
    //   395: istore 5
    //   397: sipush 30000
    //   400: istore 6
    //   402: aload 16
    //   404: ldc 197
    //   406: sipush 4096
    //   409: invokeinterface 201 3 0
    //   414: pop
    //   415: aload 16
    //   417: ldc 203
    //   419: iload 5
    //   421: invokestatic 209	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   424: invokeinterface 194 3 0
    //   429: pop
    //   430: aload 16
    //   432: ldc 211
    //   434: iload 6
    //   436: invokestatic 209	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   439: invokeinterface 194 3 0
    //   444: pop
    //   445: aload 14
    //   447: aload 16
    //   449: invokevirtual 215	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   452: iconst_0
    //   453: istore 8
    //   455: iload 7
    //   457: istore 5
    //   459: iload 5
    //   461: iconst_1
    //   462: if_icmpne +20 -> 482
    //   465: aload 16
    //   467: ldc 183
    //   469: invokeinterface 218 2 0
    //   474: pop
    //   475: aload 14
    //   477: aload 16
    //   479: invokevirtual 215	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   482: iload 5
    //   484: iconst_1
    //   485: iadd
    //   486: istore 6
    //   488: new 157	org/apache/http/params/BasicHttpParams
    //   491: dup
    //   492: invokespecial 158	org/apache/http/params/BasicHttpParams:<init>	()V
    //   495: astore 15
    //   497: aload 15
    //   499: getstatic 224	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   502: invokestatic 230	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   505: aload 15
    //   507: ldc 232
    //   509: invokestatic 236	org/apache/http/params/HttpProtocolParams:setContentCharset	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   512: aload 15
    //   514: iconst_1
    //   515: invokestatic 240	org/apache/http/params/HttpProtocolParams:setUseExpectContinue	(Lorg/apache/http/params/HttpParams;Z)V
    //   518: new 242	org/apache/http/conn/scheme/SchemeRegistry
    //   521: dup
    //   522: invokespecial 243	org/apache/http/conn/scheme/SchemeRegistry:<init>	()V
    //   525: astore 17
    //   527: aload 17
    //   529: new 245	org/apache/http/conn/scheme/Scheme
    //   532: dup
    //   533: ldc 247
    //   535: invokestatic 253	org/apache/http/conn/scheme/PlainSocketFactory:getSocketFactory	()Lorg/apache/http/conn/scheme/PlainSocketFactory;
    //   538: bipush 80
    //   540: invokespecial 256	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   543: invokevirtual 260	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   546: pop
    //   547: new 262	org/apache/http/impl/client/DefaultHttpClient
    //   550: dup
    //   551: new 264	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager
    //   554: dup
    //   555: aload 15
    //   557: aload 17
    //   559: invokespecial 267	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager:<init>	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V
    //   562: aload 15
    //   564: invokespecial 270	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    //   567: putstatic 272	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   570: getstatic 272	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   573: new 274	org/apache/http/impl/client/DefaultHttpRequestRetryHandler
    //   576: dup
    //   577: invokespecial 275	org/apache/http/impl/client/DefaultHttpRequestRetryHandler:<init>	()V
    //   580: invokevirtual 279	org/apache/http/impl/client/DefaultHttpClient:setHttpRequestRetryHandler	(Lorg/apache/http/client/HttpRequestRetryHandler;)V
    //   583: getstatic 272	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   586: new 185	org/apache/http/HttpHost
    //   589: dup
    //   590: aload_1
    //   591: invokevirtual 282	java/net/URL:getHost	()Ljava/lang/String;
    //   594: invokespecial 283	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   597: aload 14
    //   599: invokevirtual 287	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   602: astore 15
    //   604: sipush 200
    //   607: aload 15
    //   609: invokeinterface 293 1 0
    //   614: invokeinterface 298 1 0
    //   619: if_icmpne +208 -> 827
    //   622: aload 15
    //   624: invokeinterface 302 1 0
    //   629: astore 15
    //   631: aload 15
    //   633: invokeinterface 308 1 0
    //   638: pop2
    //   639: new 103	java/io/FileOutputStream
    //   642: dup
    //   643: aload 12
    //   645: invokespecial 106	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   648: astore 17
    //   650: aload 15
    //   652: aload 17
    //   654: invokeinterface 312 2 0
    //   659: aload 12
    //   661: invokevirtual 315	java/io/File:length	()J
    //   664: pop2
    //   665: aload 12
    //   667: invokestatic 320	java/lang/System:currentTimeMillis	()J
    //   670: invokevirtual 324	java/io/File:setLastModified	(J)Z
    //   673: pop
    //   674: aload 17
    //   676: invokevirtual 327	java/io/OutputStream:close	()V
    //   679: aload 11
    //   681: invokestatic 332	com/tencent/open/base/MD5Utils:encodeFileHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   684: aload_3
    //   685: invokevirtual 335	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   688: istore 9
    //   690: iload 9
    //   692: ifeq +82 -> 774
    //   695: ldc_w 337
    //   698: iconst_1
    //   699: ldc_w 339
    //   702: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   705: iload 4
    //   707: iconst_1
    //   708: if_icmpne +26 -> 734
    //   711: ldc_w 337
    //   714: iconst_2
    //   715: ldc_w 347
    //   718: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   721: aload_0
    //   722: aload 11
    //   724: aload_2
    //   725: invokespecial 349	com/tencent/mobileqq/antiphing/DownloadFileHelper:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   728: iconst_1
    //   729: istore 8
    //   731: goto +235 -> 966
    //   734: ldc_w 337
    //   737: iconst_2
    //   738: ldc_w 351
    //   741: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   744: aload 13
    //   746: invokevirtual 101	java/io/File:exists	()Z
    //   749: ifeq +9 -> 758
    //   752: aload 13
    //   754: invokevirtual 145	java/io/File:delete	()Z
    //   757: pop
    //   758: aload 12
    //   760: aload 13
    //   762: invokevirtual 355	java/io/File:renameTo	(Ljava/io/File;)Z
    //   765: istore 9
    //   767: iload 9
    //   769: istore 8
    //   771: goto +195 -> 966
    //   774: ldc_w 337
    //   777: iconst_1
    //   778: ldc_w 357
    //   781: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   784: getstatic 272	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   787: astore_1
    //   788: iload 8
    //   790: istore 10
    //   792: aload_1
    //   793: ifnull +126 -> 919
    //   796: goto +106 -> 902
    //   799: astore_1
    //   800: goto +4 -> 804
    //   803: astore_1
    //   804: aload_1
    //   805: invokevirtual 358	java/lang/Exception:printStackTrace	()V
    //   808: getstatic 272	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   811: astore_1
    //   812: iload 8
    //   814: istore 10
    //   816: aload_1
    //   817: ifnull +102 -> 919
    //   820: goto +82 -> 902
    //   823: astore_1
    //   824: goto +62 -> 886
    //   827: iload 8
    //   829: istore 9
    //   831: getstatic 272	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   834: astore 15
    //   836: aload 15
    //   838: ifnull +17 -> 855
    //   841: aload 15
    //   843: invokevirtual 362	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   846: invokeinterface 367 1 0
    //   851: aconst_null
    //   852: putstatic 272	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   855: iload 9
    //   857: istore 10
    //   859: iload 9
    //   861: ifne +58 -> 919
    //   864: iload 6
    //   866: istore 5
    //   868: iload 9
    //   870: istore 8
    //   872: iload 6
    //   874: iconst_2
    //   875: if_icmplt -416 -> 459
    //   878: iload 9
    //   880: ireturn
    //   881: astore_1
    //   882: goto +44 -> 926
    //   885: astore_1
    //   886: aload_1
    //   887: invokevirtual 358	java/lang/Exception:printStackTrace	()V
    //   890: getstatic 272	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   893: astore_1
    //   894: iload 8
    //   896: istore 10
    //   898: aload_1
    //   899: ifnull +20 -> 919
    //   902: aload_1
    //   903: invokevirtual 362	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   906: invokeinterface 367 1 0
    //   911: aconst_null
    //   912: putstatic 272	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   915: iload 8
    //   917: istore 10
    //   919: iload 10
    //   921: ireturn
    //   922: astore_1
    //   923: goto -41 -> 882
    //   926: getstatic 272	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   929: astore_2
    //   930: aload_2
    //   931: ifnull +16 -> 947
    //   934: aload_2
    //   935: invokevirtual 362	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   938: invokeinterface 367 1 0
    //   943: aconst_null
    //   944: putstatic 272	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   947: aload_1
    //   948: athrow
    //   949: iconst_0
    //   950: ireturn
    //   951: iconst_0
    //   952: ireturn
    //   953: astore_1
    //   954: goto -3 -> 951
    //   957: astore 14
    //   959: goto -709 -> 250
    //   962: astore_1
    //   963: goto -14 -> 949
    //   966: iload 8
    //   968: istore 9
    //   970: goto -139 -> 831
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	973	0	this	DownloadFileHelper
    //   0	973	1	paramURL	URL
    //   0	973	2	paramString1	String
    //   0	973	3	paramString2	String
    //   0	973	4	paramBoolean	boolean
    //   281	586	5	i	int
    //   374	502	6	j	int
    //   187	269	7	k	int
    //   184	783	8	bool1	boolean
    //   688	281	9	bool2	boolean
    //   790	130	10	bool3	boolean
    //   1	722	11	localObject1	Object
    //   45	714	12	localFile1	java.io.File
    //   56	705	13	localFile2	java.io.File
    //   34	564	14	localObject2	Object
    //   957	1	14	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   234	608	15	localObject3	Object
    //   271	207	16	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   276	399	17	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   721	728	799	java/lang/Exception
    //   734	758	799	java/lang/Exception
    //   758	767	799	java/lang/Exception
    //   774	784	799	java/lang/Exception
    //   639	690	803	java/lang/Exception
    //   695	705	803	java/lang/Exception
    //   711	721	803	java/lang/Exception
    //   804	808	823	java/lang/Exception
    //   488	639	881	finally
    //   639	690	881	finally
    //   695	705	881	finally
    //   711	721	881	finally
    //   488	639	885	java/lang/Exception
    //   721	728	922	finally
    //   734	758	922	finally
    //   758	767	922	finally
    //   774	784	922	finally
    //   804	808	922	finally
    //   886	890	922	finally
    //   204	211	953	java/lang/Exception
    //   216	230	953	java/lang/Exception
    //   236	247	957	java/lang/IllegalArgumentException
    //   250	264	962	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.antiphing.DownloadFileHelper
 * JD-Core Version:    0.7.0.1
 */