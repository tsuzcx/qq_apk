import android.content.Context;
import android.net.Proxy;
import android.net.Uri;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.params.HttpParams;

public class bdmn
{
  private static final Uri a = Uri.parse("content://telephony/carriers/preferapn");
  
  /* Error */
  private static bdmo a(Context paramContext)
  {
    // Byte code:
    //   0: new 24	bdmo
    //   3: dup
    //   4: invokespecial 27	bdmo:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: invokevirtual 33	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: getstatic 18	bdmn:a	Landroid/net/Uri;
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: invokevirtual 39	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore_1
    //   24: aload_1
    //   25: astore_0
    //   26: aload_1
    //   27: invokeinterface 45 1 0
    //   32: pop
    //   33: aload_1
    //   34: astore_0
    //   35: aload_1
    //   36: aload_1
    //   37: ldc 47
    //   39: invokeinterface 51 2 0
    //   44: invokeinterface 55 2 0
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull +286 -> 337
    //   54: aload_1
    //   55: astore_0
    //   56: aload_2
    //   57: invokevirtual 61	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   60: astore_2
    //   61: aload_1
    //   62: astore_0
    //   63: aload_1
    //   64: aload_1
    //   65: ldc 63
    //   67: invokeinterface 51 2 0
    //   72: invokeinterface 55 2 0
    //   77: astore 6
    //   79: aload_1
    //   80: astore_0
    //   81: aload_1
    //   82: aload_1
    //   83: ldc 65
    //   85: invokeinterface 51 2 0
    //   90: invokeinterface 55 2 0
    //   95: astore 4
    //   97: aload 4
    //   99: astore_3
    //   100: aload 4
    //   102: ifnull +11 -> 113
    //   105: aload_1
    //   106: astore_0
    //   107: aload 4
    //   109: invokevirtual 61	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   112: astore_3
    //   113: aload_1
    //   114: astore_0
    //   115: aload_1
    //   116: invokeinterface 68 1 0
    //   121: aload_2
    //   122: ifnull +61 -> 183
    //   125: aload_1
    //   126: astore_0
    //   127: aload_2
    //   128: invokevirtual 72	java/lang/String:length	()I
    //   131: ifle +52 -> 183
    //   134: aload_1
    //   135: astore_0
    //   136: aload 6
    //   138: invokestatic 78	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   141: invokevirtual 81	java/lang/Integer:intValue	()I
    //   144: ifle +39 -> 183
    //   147: aload_1
    //   148: astore_0
    //   149: aload 5
    //   151: aload_2
    //   152: putfield 84	bdmo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   155: aload_1
    //   156: astore_0
    //   157: aload 5
    //   159: aload 6
    //   161: invokestatic 78	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   164: invokevirtual 81	java/lang/Integer:intValue	()I
    //   167: putfield 87	bdmo:jdField_a_of_type_Int	I
    //   170: aload_1
    //   171: ifnull +9 -> 180
    //   174: aload_1
    //   175: invokeinterface 68 1 0
    //   180: aload 5
    //   182: areturn
    //   183: aload_3
    //   184: ifnull +55 -> 239
    //   187: aload_1
    //   188: astore_0
    //   189: aload_3
    //   190: ldc 89
    //   192: invokevirtual 93	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   195: ifeq +44 -> 239
    //   198: aload_1
    //   199: astore_0
    //   200: aload 5
    //   202: ldc 95
    //   204: putfield 84	bdmo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   207: aload_1
    //   208: astore_0
    //   209: aload 5
    //   211: bipush 80
    //   213: putfield 87	bdmo:jdField_a_of_type_Int	I
    //   216: goto -46 -> 170
    //   219: astore_2
    //   220: aload_1
    //   221: astore_0
    //   222: aload_2
    //   223: invokevirtual 98	java/lang/Exception:printStackTrace	()V
    //   226: aload_1
    //   227: ifnull +9 -> 236
    //   230: aload_1
    //   231: invokeinterface 68 1 0
    //   236: aload 5
    //   238: areturn
    //   239: aload_3
    //   240: ifnull +49 -> 289
    //   243: aload_1
    //   244: astore_0
    //   245: aload_3
    //   246: ldc 100
    //   248: invokevirtual 93	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   251: ifeq +38 -> 289
    //   254: aload_1
    //   255: astore_0
    //   256: aload 5
    //   258: ldc 102
    //   260: putfield 84	bdmo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   263: aload_1
    //   264: astore_0
    //   265: aload 5
    //   267: bipush 80
    //   269: putfield 87	bdmo:jdField_a_of_type_Int	I
    //   272: goto -102 -> 170
    //   275: astore_1
    //   276: aload_0
    //   277: ifnull +9 -> 286
    //   280: aload_0
    //   281: invokeinterface 68 1 0
    //   286: aload 5
    //   288: areturn
    //   289: aload_3
    //   290: ifnull -120 -> 170
    //   293: aload_1
    //   294: astore_0
    //   295: aload_3
    //   296: ldc 104
    //   298: invokevirtual 93	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   301: ifeq -131 -> 170
    //   304: aload_1
    //   305: astore_0
    //   306: aload 5
    //   308: ldc 102
    //   310: putfield 84	bdmo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   313: aload_1
    //   314: astore_0
    //   315: aload 5
    //   317: bipush 80
    //   319: putfield 87	bdmo:jdField_a_of_type_Int	I
    //   322: goto -152 -> 170
    //   325: astore_0
    //   326: aconst_null
    //   327: astore_0
    //   328: goto -52 -> 276
    //   331: astore_2
    //   332: aconst_null
    //   333: astore_1
    //   334: goto -114 -> 220
    //   337: goto -276 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	paramContext	Context
    //   23	241	1	localCursor	android.database.Cursor
    //   275	39	1	localObject1	Object
    //   333	1	1	localObject2	Object
    //   49	103	2	str1	String
    //   219	4	2	localException1	java.lang.Exception
    //   331	1	2	localException2	java.lang.Exception
    //   99	197	3	str2	String
    //   95	13	4	str3	String
    //   7	309	5	localbdmo	bdmo
    //   77	83	6	str4	String
    // Exception table:
    //   from	to	target	type
    //   26	33	219	java/lang/Exception
    //   35	50	219	java/lang/Exception
    //   56	61	219	java/lang/Exception
    //   63	79	219	java/lang/Exception
    //   81	97	219	java/lang/Exception
    //   107	113	219	java/lang/Exception
    //   115	121	219	java/lang/Exception
    //   127	134	219	java/lang/Exception
    //   136	147	219	java/lang/Exception
    //   149	155	219	java/lang/Exception
    //   157	170	219	java/lang/Exception
    //   189	198	219	java/lang/Exception
    //   200	207	219	java/lang/Exception
    //   209	216	219	java/lang/Exception
    //   245	254	219	java/lang/Exception
    //   256	263	219	java/lang/Exception
    //   265	272	219	java/lang/Exception
    //   295	304	219	java/lang/Exception
    //   306	313	219	java/lang/Exception
    //   315	322	219	java/lang/Exception
    //   26	33	275	finally
    //   35	50	275	finally
    //   56	61	275	finally
    //   63	79	275	finally
    //   81	97	275	finally
    //   107	113	275	finally
    //   115	121	275	finally
    //   127	134	275	finally
    //   136	147	275	finally
    //   149	155	275	finally
    //   157	170	275	finally
    //   189	198	275	finally
    //   200	207	275	finally
    //   209	216	275	finally
    //   222	226	275	finally
    //   245	254	275	finally
    //   256	263	275	finally
    //   265	272	275	finally
    //   295	304	275	finally
    //   306	313	275	finally
    //   315	322	275	finally
    //   9	24	325	finally
    //   9	24	331	java/lang/Exception
  }
  
  private static String a(Context paramContext)
  {
    String str2 = "";
    String str1;
    int i;
    if (paramContext == null)
    {
      str1 = Proxy.getDefaultHost();
      i = Proxy.getDefaultPort();
    }
    for (;;)
    {
      paramContext = str2;
      if (str1 != null)
      {
        paramContext = str2;
        if (str1.trim().length() > 0) {
          paramContext = str1 + ":" + i;
        }
      }
      return paramContext;
      if (!AppNetConnInfo.isMobileConn()) {
        break;
      }
      str1 = Proxy.getHost(paramContext);
      int j = Proxy.getPort(paramContext);
      if ((str1 != null) && (str1.trim().length() != 0))
      {
        i = j;
        if (j > 0) {}
      }
      else
      {
        str1 = Proxy.getDefaultHost();
        j = Proxy.getDefaultPort();
        if ((str1 != null) && (str1.trim().length() != 0))
        {
          i = j;
          if (j > 0) {}
        }
        else
        {
          paramContext = a(paramContext);
          str1 = paramContext.jdField_a_of_type_JavaLangString;
          i = paramContext.jdField_a_of_type_Int;
        }
      }
    }
    return null;
  }
  
  /* Error */
  public static String a(Context paramContext, double paramDouble1, double paramDouble2, int paramInt, HttpClient paramHttpClient)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 120	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   10: ldc 154
    //   12: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: dload_1
    //   16: invokevirtual 157	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   19: ldc 159
    //   21: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: dload_3
    //   25: invokevirtual 157	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   28: ldc 161
    //   30: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore 6
    //   38: new 163	org/apache/http/params/BasicHttpParams
    //   41: dup
    //   42: invokespecial 164	org/apache/http/params/BasicHttpParams:<init>	()V
    //   45: astore 7
    //   47: aload 7
    //   49: ldc2_w 165
    //   52: invokestatic 172	org/apache/http/conn/params/ConnManagerParams:setTimeout	(Lorg/apache/http/params/HttpParams;J)V
    //   55: aload 7
    //   57: new 174	org/apache/http/conn/params/ConnPerRouteBean
    //   60: dup
    //   61: bipush 10
    //   63: invokespecial 177	org/apache/http/conn/params/ConnPerRouteBean:<init>	(I)V
    //   66: invokestatic 181	org/apache/http/conn/params/ConnManagerParams:setMaxConnectionsPerRoute	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/params/ConnPerRoute;)V
    //   69: aload 7
    //   71: bipush 10
    //   73: invokestatic 185	org/apache/http/conn/params/ConnManagerParams:setMaxTotalConnections	(Lorg/apache/http/params/HttpParams;I)V
    //   76: aload 7
    //   78: sipush 10000
    //   81: invokestatic 190	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   84: aload 7
    //   86: sipush 20000
    //   89: invokestatic 193	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   92: aload 7
    //   94: iconst_1
    //   95: invokestatic 197	org/apache/http/params/HttpConnectionParams:setTcpNoDelay	(Lorg/apache/http/params/HttpParams;Z)V
    //   98: aload 7
    //   100: sipush 8192
    //   103: invokestatic 200	org/apache/http/params/HttpConnectionParams:setSocketBufferSize	(Lorg/apache/http/params/HttpParams;I)V
    //   106: aload 7
    //   108: getstatic 206	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   111: invokestatic 212	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   114: aload 7
    //   116: ldc 214
    //   118: invokestatic 218	org/apache/http/params/HttpProtocolParams:setUserAgent	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   121: new 220	org/apache/http/impl/client/DefaultHttpClient
    //   124: dup
    //   125: aload 7
    //   127: invokespecial 223	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   130: astore 7
    //   132: aload_0
    //   133: aload 7
    //   135: invokestatic 226	bdmn:a	(Landroid/content/Context;Lorg/apache/http/client/HttpClient;)V
    //   138: new 228	java/io/InputStreamReader
    //   141: dup
    //   142: aload 7
    //   144: new 230	org/apache/http/client/methods/HttpGet
    //   147: dup
    //   148: aload 6
    //   150: invokespecial 233	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   153: invokeinterface 239 2 0
    //   158: invokeinterface 245 1 0
    //   163: invokeinterface 251 1 0
    //   168: invokespecial 254	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   171: astore 6
    //   173: new 256	java/io/BufferedReader
    //   176: dup
    //   177: aload 6
    //   179: invokespecial 259	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   182: astore 11
    //   184: ldc 107
    //   186: astore_0
    //   187: aload 6
    //   189: astore 7
    //   191: aload 11
    //   193: astore 8
    //   195: aload 11
    //   197: invokevirtual 262	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   200: astore 9
    //   202: aload 9
    //   204: ifnull +38 -> 242
    //   207: aload 6
    //   209: astore 7
    //   211: aload 11
    //   213: astore 8
    //   215: new 120	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   222: aload_0
    //   223: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload 9
    //   228: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: astore 9
    //   236: aload 9
    //   238: astore_0
    //   239: goto -52 -> 187
    //   242: aload 6
    //   244: ifnull +8 -> 252
    //   247: aload 6
    //   249: invokevirtual 263	java/io/InputStreamReader:close	()V
    //   252: aload_0
    //   253: astore 7
    //   255: aload 11
    //   257: ifnull +11 -> 268
    //   260: aload 11
    //   262: invokevirtual 264	java/io/BufferedReader:close	()V
    //   265: aload_0
    //   266: astore 7
    //   268: new 266	org/json/JSONObject
    //   271: dup
    //   272: aload 7
    //   274: invokespecial 267	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   277: ldc_w 269
    //   280: invokevirtual 273	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   283: astore_0
    //   284: aload_0
    //   285: iconst_0
    //   286: invokevirtual 279	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   289: astore 7
    //   291: ldc 107
    //   293: astore 6
    //   295: aload 6
    //   297: astore_0
    //   298: aload 7
    //   300: ifnull +12 -> 312
    //   303: aload 7
    //   305: ldc_w 281
    //   308: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   311: astore_0
    //   312: aload_0
    //   313: ldc_w 285
    //   316: invokestatic 289	alud:a	(I)Ljava/lang/String;
    //   319: invokevirtual 292	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   322: istore 5
    //   324: aload_0
    //   325: astore 6
    //   327: iload 5
    //   329: iflt +15 -> 344
    //   332: aload_0
    //   333: iconst_0
    //   334: iload 5
    //   336: invokevirtual 296	java/lang/String:substring	(II)Ljava/lang/String;
    //   339: invokevirtual 118	java/lang/String:trim	()Ljava/lang/String;
    //   342: astore 6
    //   344: aload 6
    //   346: areturn
    //   347: astore 6
    //   349: aload 6
    //   351: invokevirtual 297	java/io/IOException:printStackTrace	()V
    //   354: aload_0
    //   355: astore 7
    //   357: goto -89 -> 268
    //   360: astore 9
    //   362: aconst_null
    //   363: astore 10
    //   365: aconst_null
    //   366: astore 6
    //   368: ldc 107
    //   370: astore_0
    //   371: aload 10
    //   373: astore 7
    //   375: aload 6
    //   377: astore 8
    //   379: aload 9
    //   381: invokevirtual 297	java/io/IOException:printStackTrace	()V
    //   384: aload 10
    //   386: ifnull +8 -> 394
    //   389: aload 10
    //   391: invokevirtual 263	java/io/InputStreamReader:close	()V
    //   394: aload_0
    //   395: astore 7
    //   397: aload 6
    //   399: ifnull -131 -> 268
    //   402: aload 6
    //   404: invokevirtual 264	java/io/BufferedReader:close	()V
    //   407: aload_0
    //   408: astore 7
    //   410: goto -142 -> 268
    //   413: astore 6
    //   415: aload 6
    //   417: invokevirtual 297	java/io/IOException:printStackTrace	()V
    //   420: aload_0
    //   421: astore 7
    //   423: goto -155 -> 268
    //   426: astore_0
    //   427: aconst_null
    //   428: astore 6
    //   430: aload 6
    //   432: ifnull +8 -> 440
    //   435: aload 6
    //   437: invokevirtual 263	java/io/InputStreamReader:close	()V
    //   440: aload 8
    //   442: ifnull +8 -> 450
    //   445: aload 8
    //   447: invokevirtual 264	java/io/BufferedReader:close	()V
    //   450: aload_0
    //   451: athrow
    //   452: astore 6
    //   454: aload 6
    //   456: invokevirtual 297	java/io/IOException:printStackTrace	()V
    //   459: goto -9 -> 450
    //   462: astore_0
    //   463: ldc 107
    //   465: areturn
    //   466: astore_0
    //   467: aload_0
    //   468: invokevirtual 298	org/json/JSONException:printStackTrace	()V
    //   471: aload 6
    //   473: astore_0
    //   474: goto -162 -> 312
    //   477: astore_0
    //   478: goto -48 -> 430
    //   481: astore_0
    //   482: aload 7
    //   484: astore 6
    //   486: goto -56 -> 430
    //   489: astore 9
    //   491: aconst_null
    //   492: astore 7
    //   494: ldc 107
    //   496: astore_0
    //   497: aload 6
    //   499: astore 10
    //   501: aload 7
    //   503: astore 6
    //   505: goto -134 -> 371
    //   508: astore 9
    //   510: aload 6
    //   512: astore 10
    //   514: aload 11
    //   516: astore 6
    //   518: goto -147 -> 371
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	521	0	paramContext	Context
    //   0	521	1	paramDouble1	double
    //   0	521	3	paramDouble2	double
    //   0	521	5	paramInt	int
    //   0	521	6	paramHttpClient	HttpClient
    //   45	457	7	localObject1	Object
    //   1	445	8	localObject2	Object
    //   200	37	9	str	String
    //   360	20	9	localIOException1	java.io.IOException
    //   489	1	9	localIOException2	java.io.IOException
    //   508	1	9	localIOException3	java.io.IOException
    //   363	150	10	localHttpClient	HttpClient
    //   182	333	11	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   247	252	347	java/io/IOException
    //   260	265	347	java/io/IOException
    //   138	173	360	java/io/IOException
    //   389	394	413	java/io/IOException
    //   402	407	413	java/io/IOException
    //   138	173	426	finally
    //   435	440	452	java/io/IOException
    //   445	450	452	java/io/IOException
    //   268	284	462	org/json/JSONException
    //   303	312	466	org/json/JSONException
    //   173	184	477	finally
    //   195	202	481	finally
    //   215	236	481	finally
    //   379	384	481	finally
    //   173	184	489	java/io/IOException
    //   195	202	508	java/io/IOException
    //   215	236	508	java/io/IOException
  }
  
  public static void a(Context paramContext, HttpClient paramHttpClient)
  {
    paramHttpClient.getParams().removeParameter("http.route.default-proxy");
    paramContext = a(paramContext);
    if ((paramContext != null) && (paramContext.length() > 0))
    {
      paramContext = paramContext.split(":");
      if ((paramContext != null) && (paramContext.length == 2))
      {
        paramContext = new HttpHost(paramContext[0], Integer.valueOf(paramContext[1]).intValue());
        paramHttpClient.getParams().setParameter("http.route.default-proxy", paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdmn
 * JD-Core Version:    0.7.0.1
 */