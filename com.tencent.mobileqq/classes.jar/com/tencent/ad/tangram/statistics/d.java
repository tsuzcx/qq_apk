package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.os.Looper;
import android.util.Base64;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForSdkMsg;
import com.tencent.ad.tangram.settings.AdSettingsManager;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class d
{
  private static final String CIPHER_ALGORITHM = String.format("AES/%s/PKCS7Padding", new Object[] { "ECB" });
  private static final String KEY_ALGORITHM = "AES";
  private static final byte[] MAGIC = { 91, -62 };
  private static final byte MAJER_VERSION = 1;
  private static final byte MINOR_VERSION = 2;
  public static final int MSG_CODE_RELATION_TARGET_MATCH = 1006;
  private static final String MSG_KEY_BUSINESS = "biz";
  private static final String MSG_KEY_PLACEMENTINFO = "plc";
  private static final String SDK_SERVER_MSG_URL = "https://sdk.e.qq.com/msg";
  private static final String TAG = "AdReporterForMsg";
  
  private static JSONObject buildBizData(Ad paramAd, int paramInt, JSONObject paramJSONObject)
  {
    if ((paramAd != null) && (paramAd.isValid()) && (paramJSONObject != null))
    {
      paramAd = new JSONObject();
      paramAd.putOpt("code", Integer.valueOf(paramInt));
      paramAd.putOpt("threadid", "");
      paramAd.putOpt("data", paramJSONObject);
      return paramAd;
    }
    return null;
  }
  
  private static JSONObject buildPlacementInfo(Ad paramAd)
  {
    if ((paramAd != null) && (paramAd.isValid()))
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.putOpt("posid", paramAd.getPosId());
      localJSONObject.putOpt("adtype", Integer.valueOf(0));
      return localJSONObject;
    }
    return null;
  }
  
  private static byte[] getCryptoKey(WeakReference<Context> paramWeakReference)
  {
    paramWeakReference = AdSettingsManager.INSTANCE.getCache();
    if (paramWeakReference != null)
    {
      paramWeakReference = paramWeakReference.settingsForSdkMsg.key;
      if ((paramWeakReference != null) && (paramWeakReference.length() > 8)) {
        try
        {
          paramWeakReference = Base64.decode(paramWeakReference.substring(8, paramWeakReference.length() - 1), 0);
          return paramWeakReference;
        }
        catch (Throwable paramWeakReference)
        {
          AdLog.e("AdReporterForMsg", "getCryptoKey", paramWeakReference);
        }
      }
    }
    return null;
  }
  
  private static AdHttp.Params getRequestParams(String paramString, byte[] paramArrayOfByte)
  {
    AdHttp.Params localParams = new AdHttp.Params();
    localParams.setUrl(paramString);
    localParams.method = "POST";
    localParams.contentType = "application/x-www-form-urlencoded";
    localParams.requestData = paramArrayOfByte;
    return localParams;
  }
  
  /* Error */
  public static byte[] pack(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +210 -> 211
    //   4: aload_0
    //   5: arraylength
    //   6: ifgt +5 -> 11
    //   9: aload_0
    //   10: areturn
    //   11: new 166	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: invokespecial 167	java/io/ByteArrayOutputStream:<init>	()V
    //   18: astore 4
    //   20: new 169	com/tencent/ad/tangram/util/a$a
    //   23: dup
    //   24: invokespecial 170	com/tencent/ad/tangram/util/a$a:<init>	()V
    //   27: astore 5
    //   29: aload 5
    //   31: ldc 9
    //   33: putfield 173	com/tencent/ad/tangram/util/a$a:keyAlgorithm	Ljava/lang/String;
    //   36: aload 5
    //   38: getstatic 49	com/tencent/ad/tangram/statistics/d:CIPHER_ALGORITHM	Ljava/lang/String;
    //   41: putfield 176	com/tencent/ad/tangram/util/a$a:cipherAlgorithm	Ljava/lang/String;
    //   44: aload 5
    //   46: aload_1
    //   47: putfield 178	com/tencent/ad/tangram/util/a$a:key	[B
    //   50: aconst_null
    //   51: astore_3
    //   52: new 180	java/io/DataOutputStream
    //   55: dup
    //   56: aload 4
    //   58: invokespecial 183	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   61: astore_2
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: getstatic 37	com/tencent/ad/tangram/statistics/d:MAGIC	[B
    //   68: invokevirtual 187	java/io/DataOutputStream:write	([B)V
    //   71: aload_2
    //   72: astore_1
    //   73: aload_2
    //   74: iconst_1
    //   75: invokevirtual 191	java/io/DataOutputStream:writeByte	(I)V
    //   78: aload_2
    //   79: astore_1
    //   80: aload_2
    //   81: iconst_2
    //   82: invokevirtual 191	java/io/DataOutputStream:writeByte	(I)V
    //   85: aload_2
    //   86: astore_1
    //   87: aload_2
    //   88: aload 5
    //   90: aload_0
    //   91: invokestatic 197	com/tencent/ad/tangram/util/c:compress	([B)[B
    //   94: invokestatic 203	com/tencent/ad/tangram/util/a:encrypt	(Lcom/tencent/ad/tangram/util/a$a;[B)[B
    //   97: invokevirtual 187	java/io/DataOutputStream:write	([B)V
    //   100: aload_2
    //   101: astore_1
    //   102: aload 4
    //   104: invokevirtual 207	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   107: astore_0
    //   108: aload_0
    //   109: astore_1
    //   110: aload_2
    //   111: invokevirtual 210	java/io/DataOutputStream:close	()V
    //   114: aload_0
    //   115: astore_1
    //   116: aload 4
    //   118: invokevirtual 211	java/io/ByteArrayOutputStream:close	()V
    //   121: aload_0
    //   122: areturn
    //   123: astore_0
    //   124: ldc 31
    //   126: ldc 213
    //   128: aload_0
    //   129: invokestatic 138	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   132: aload_1
    //   133: areturn
    //   134: astore_0
    //   135: goto +49 -> 184
    //   138: astore_1
    //   139: aload_2
    //   140: astore_0
    //   141: aload_1
    //   142: astore_2
    //   143: goto +12 -> 155
    //   146: astore_0
    //   147: aconst_null
    //   148: astore_1
    //   149: goto +35 -> 184
    //   152: astore_2
    //   153: aconst_null
    //   154: astore_0
    //   155: aload_0
    //   156: astore_1
    //   157: ldc 31
    //   159: ldc 215
    //   161: aload_2
    //   162: invokestatic 138	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   165: aload_0
    //   166: ifnull +9 -> 175
    //   169: aload_3
    //   170: astore_1
    //   171: aload_0
    //   172: invokevirtual 210	java/io/DataOutputStream:close	()V
    //   175: aload_3
    //   176: astore_1
    //   177: aload 4
    //   179: invokevirtual 211	java/io/ByteArrayOutputStream:close	()V
    //   182: aconst_null
    //   183: areturn
    //   184: aload_1
    //   185: ifnull +7 -> 192
    //   188: aload_1
    //   189: invokevirtual 210	java/io/DataOutputStream:close	()V
    //   192: aload 4
    //   194: invokevirtual 211	java/io/ByteArrayOutputStream:close	()V
    //   197: goto +12 -> 209
    //   200: astore_1
    //   201: ldc 31
    //   203: ldc 213
    //   205: aload_1
    //   206: invokestatic 138	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   209: aload_0
    //   210: athrow
    //   211: aload_0
    //   212: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramArrayOfByte1	byte[]
    //   0	213	1	paramArrayOfByte2	byte[]
    //   61	82	2	localObject1	Object
    //   152	10	2	localThrowable	Throwable
    //   51	125	3	localObject2	Object
    //   18	175	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   27	62	5	locala	com.tencent.ad.tangram.util.a.a
    // Exception table:
    //   from	to	target	type
    //   110	114	123	java/lang/Throwable
    //   116	121	123	java/lang/Throwable
    //   171	175	123	java/lang/Throwable
    //   177	182	123	java/lang/Throwable
    //   64	71	134	finally
    //   73	78	134	finally
    //   80	85	134	finally
    //   87	100	134	finally
    //   102	108	134	finally
    //   157	165	134	finally
    //   64	71	138	java/lang/Throwable
    //   73	78	138	java/lang/Throwable
    //   80	85	138	java/lang/Throwable
    //   87	100	138	java/lang/Throwable
    //   102	108	138	java/lang/Throwable
    //   52	62	146	finally
    //   52	62	152	java/lang/Throwable
    //   188	192	200	java/lang/Throwable
    //   192	197	200	java/lang/Throwable
  }
  
  public static void reportMsg(WeakReference<Context> paramWeakReference, Ad paramAd, int paramInt, JSONObject paramJSONObject)
  {
    AdLog.i("AdReporterForMsg", String.format("reportMsg code: %d", new Object[] { Integer.valueOf(paramInt) }));
    byte[] arrayOfByte = getCryptoKey(paramWeakReference);
    if (arrayOfByte == null)
    {
      AdLog.e("AdReporterForMsg", "reportMsg crypto key empty");
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      AdLog.e("AdReporterForMsg", "reportMsg could not run on main thread");
      return;
    }
    Object localObject2 = null;
    Object localObject1;
    if (paramWeakReference != null) {
      localObject1 = (Context)paramWeakReference.get();
    } else {
      localObject1 = null;
    }
    a.reportForSdkMsgStatisticsStart((Context)localObject1, paramAd, "https://sdk.e.qq.com/msg");
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).putOpt("plc", buildPlacementInfo(paramAd));
      ((JSONObject)localObject1).putOpt("biz", buildBizData(paramAd, paramInt, paramJSONObject));
      localObject1 = getRequestParams("https://sdk.e.qq.com/msg", pack(((JSONObject)localObject1).toString().getBytes("UTF-8"), arrayOfByte));
      AdHttp.send((AdHttp.Params)localObject1);
      paramJSONObject = localObject2;
      if (paramWeakReference != null) {
        paramJSONObject = (Context)paramWeakReference.get();
      }
      a.reportForSdkMsgStatisticsEnd(paramJSONObject, paramAd, (AdHttp.Params)localObject1);
      return;
    }
    catch (Throwable paramWeakReference)
    {
      AdLog.e("AdReporterForMsg", "reportMsg error, req params construct error.", paramWeakReference);
    }
  }
  
  /* Error */
  @android.annotation.TargetApi(9)
  public static byte[] unpack(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +321 -> 322
    //   4: aload_0
    //   5: arraylength
    //   6: iconst_4
    //   7: if_icmpge +6 -> 13
    //   10: goto +312 -> 322
    //   13: new 169	com/tencent/ad/tangram/util/a$a
    //   16: dup
    //   17: invokespecial 170	com/tencent/ad/tangram/util/a$a:<init>	()V
    //   20: astore 7
    //   22: aload 7
    //   24: ldc 9
    //   26: putfield 173	com/tencent/ad/tangram/util/a$a:keyAlgorithm	Ljava/lang/String;
    //   29: aload 7
    //   31: getstatic 49	com/tencent/ad/tangram/statistics/d:CIPHER_ALGORITHM	Ljava/lang/String;
    //   34: putfield 176	com/tencent/ad/tangram/util/a$a:cipherAlgorithm	Ljava/lang/String;
    //   37: aload 7
    //   39: aload_1
    //   40: putfield 178	com/tencent/ad/tangram/util/a$a:key	[B
    //   43: aconst_null
    //   44: astore 5
    //   46: aconst_null
    //   47: astore 6
    //   49: new 290	java/io/ByteArrayInputStream
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 292	java/io/ByteArrayInputStream:<init>	([B)V
    //   57: astore_1
    //   58: new 294	java/io/DataInputStream
    //   61: dup
    //   62: aload_1
    //   63: invokespecial 297	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: astore 4
    //   68: aload_1
    //   69: astore_2
    //   70: aload 4
    //   72: astore_3
    //   73: iconst_4
    //   74: newarray byte
    //   76: astore 8
    //   78: aload_1
    //   79: astore_2
    //   80: aload 4
    //   82: astore_3
    //   83: aload 4
    //   85: aload 8
    //   87: invokevirtual 301	java/io/DataInputStream:read	([B)I
    //   90: pop
    //   91: aload_1
    //   92: astore_2
    //   93: aload 4
    //   95: astore_3
    //   96: getstatic 37	com/tencent/ad/tangram/statistics/d:MAGIC	[B
    //   99: iconst_0
    //   100: baload
    //   101: aload 8
    //   103: iconst_0
    //   104: baload
    //   105: if_icmpne +63 -> 168
    //   108: aload_1
    //   109: astore_2
    //   110: aload 4
    //   112: astore_3
    //   113: getstatic 37	com/tencent/ad/tangram/statistics/d:MAGIC	[B
    //   116: iconst_1
    //   117: baload
    //   118: aload 8
    //   120: iconst_1
    //   121: baload
    //   122: if_icmpne +46 -> 168
    //   125: iconst_1
    //   126: aload 8
    //   128: iconst_2
    //   129: baload
    //   130: if_icmpne +38 -> 168
    //   133: iconst_2
    //   134: aload 8
    //   136: iconst_3
    //   137: baload
    //   138: if_icmpeq +6 -> 144
    //   141: goto +27 -> 168
    //   144: aload_1
    //   145: astore_2
    //   146: aload 4
    //   148: astore_3
    //   149: aload 7
    //   151: aload_0
    //   152: iconst_4
    //   153: aload_0
    //   154: arraylength
    //   155: invokestatic 307	java/util/Arrays:copyOfRange	([BII)[B
    //   158: invokestatic 310	com/tencent/ad/tangram/util/a:decrypt	(Lcom/tencent/ad/tangram/util/a$a;[B)[B
    //   161: invokestatic 313	com/tencent/ad/tangram/util/c:decompress	([B)[B
    //   164: astore_0
    //   165: goto +19 -> 184
    //   168: aload_1
    //   169: astore_2
    //   170: aload 4
    //   172: astore_3
    //   173: ldc 31
    //   175: ldc_w 315
    //   178: invokestatic 229	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload 6
    //   183: astore_0
    //   184: aload_0
    //   185: astore_2
    //   186: aload_1
    //   187: invokevirtual 316	java/io/ByteArrayInputStream:close	()V
    //   190: aload_0
    //   191: astore_2
    //   192: aload 4
    //   194: invokevirtual 317	java/io/DataInputStream:close	()V
    //   197: aload_0
    //   198: areturn
    //   199: astore_0
    //   200: ldc 31
    //   202: ldc_w 318
    //   205: aload_0
    //   206: invokestatic 138	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   209: aload_2
    //   210: areturn
    //   211: astore_2
    //   212: aload 4
    //   214: astore_0
    //   215: aload_2
    //   216: astore 4
    //   218: goto +30 -> 248
    //   221: astore_0
    //   222: aconst_null
    //   223: astore_3
    //   224: goto +65 -> 289
    //   227: astore 4
    //   229: aconst_null
    //   230: astore_0
    //   231: goto +17 -> 248
    //   234: astore_0
    //   235: aconst_null
    //   236: astore_1
    //   237: aload_1
    //   238: astore_3
    //   239: goto +50 -> 289
    //   242: astore 4
    //   244: aconst_null
    //   245: astore_1
    //   246: aload_1
    //   247: astore_0
    //   248: aload_1
    //   249: astore_2
    //   250: aload_0
    //   251: astore_3
    //   252: ldc 31
    //   254: ldc_w 320
    //   257: aload 4
    //   259: invokestatic 138	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   262: aload_1
    //   263: ifnull +10 -> 273
    //   266: aload 5
    //   268: astore_2
    //   269: aload_1
    //   270: invokevirtual 316	java/io/ByteArrayInputStream:close	()V
    //   273: aload_0
    //   274: ifnull +10 -> 284
    //   277: aload 5
    //   279: astore_2
    //   280: aload_0
    //   281: invokevirtual 317	java/io/DataInputStream:close	()V
    //   284: aconst_null
    //   285: areturn
    //   286: astore_0
    //   287: aload_2
    //   288: astore_1
    //   289: aload_1
    //   290: ifnull +10 -> 300
    //   293: aload_1
    //   294: invokevirtual 316	java/io/ByteArrayInputStream:close	()V
    //   297: goto +3 -> 300
    //   300: aload_3
    //   301: ifnull +19 -> 320
    //   304: aload_3
    //   305: invokevirtual 317	java/io/DataInputStream:close	()V
    //   308: goto +12 -> 320
    //   311: ldc 31
    //   313: ldc_w 318
    //   316: aload_1
    //   317: invokestatic 138	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   320: aload_0
    //   321: athrow
    //   322: ldc 31
    //   324: ldc_w 322
    //   327: invokestatic 229	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: aload_0
    //   331: areturn
    //   332: astore_1
    //   333: goto -22 -> 311
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	paramArrayOfByte1	byte[]
    //   0	336	1	paramArrayOfByte2	byte[]
    //   69	141	2	arrayOfByte1	byte[]
    //   211	5	2	localThrowable1	Throwable
    //   249	39	2	localObject1	Object
    //   72	233	3	localObject2	Object
    //   66	151	4	localObject3	Object
    //   227	1	4	localThrowable2	Throwable
    //   242	16	4	localThrowable3	Throwable
    //   44	234	5	localObject4	Object
    //   47	135	6	localObject5	Object
    //   20	130	7	locala	com.tencent.ad.tangram.util.a.a
    //   76	59	8	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   186	190	199	java/lang/Throwable
    //   192	197	199	java/lang/Throwable
    //   269	273	199	java/lang/Throwable
    //   280	284	199	java/lang/Throwable
    //   73	78	211	java/lang/Throwable
    //   83	91	211	java/lang/Throwable
    //   96	108	211	java/lang/Throwable
    //   113	125	211	java/lang/Throwable
    //   149	165	211	java/lang/Throwable
    //   173	181	211	java/lang/Throwable
    //   58	68	221	finally
    //   58	68	227	java/lang/Throwable
    //   49	58	234	finally
    //   49	58	242	java/lang/Throwable
    //   73	78	286	finally
    //   83	91	286	finally
    //   96	108	286	finally
    //   113	125	286	finally
    //   149	165	286	finally
    //   173	181	286	finally
    //   252	262	286	finally
    //   293	297	332	java/lang/Throwable
    //   304	308	332	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.d
 * JD-Core Version:    0.7.0.1
 */