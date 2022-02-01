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
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class c
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
    if ((paramAd == null) || (!paramAd.isValid()) || (paramJSONObject == null)) {
      return null;
    }
    paramAd = new JSONObject();
    paramAd.putOpt("code", Integer.valueOf(paramInt));
    paramAd.putOpt("threadid", "");
    paramAd.putOpt("data", paramJSONObject);
    return paramAd;
  }
  
  private static JSONObject buildPlacementInfo(Ad paramAd)
  {
    if ((paramAd == null) || (!paramAd.isValid())) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.putOpt("posid", paramAd.getPosId());
    localJSONObject.putOpt("adtype", Integer.valueOf(0));
    return localJSONObject;
  }
  
  private static byte[] getCryptoKey(WeakReference<Context> paramWeakReference)
  {
    paramWeakReference = AdSettingsUtil.INSTANCE.getSettingsCache((Context)paramWeakReference.get());
    if (paramWeakReference == null) {
      return null;
    }
    paramWeakReference = paramWeakReference.settingsForSdkMsg.key;
    if (paramWeakReference != null)
    {
      if (paramWeakReference.length() <= 8) {
        return null;
      }
      try
      {
        paramWeakReference = Base64.decode(paramWeakReference.substring(8, paramWeakReference.length() - 1), 0);
        return paramWeakReference;
      }
      catch (Throwable paramWeakReference)
      {
        AdLog.e("AdReporterForMsg", "getCryptoKey", paramWeakReference);
        return null;
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
    //   1: ifnull +8 -> 9
    //   4: aload_0
    //   5: arraylength
    //   6: ifgt +5 -> 11
    //   9: aload_0
    //   10: areturn
    //   11: new 174	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: invokespecial 175	java/io/ByteArrayOutputStream:<init>	()V
    //   18: astore 4
    //   20: new 177	com/tencent/ad/tangram/util/a$a
    //   23: dup
    //   24: invokespecial 178	com/tencent/ad/tangram/util/a$a:<init>	()V
    //   27: astore_3
    //   28: aload_3
    //   29: ldc 9
    //   31: putfield 181	com/tencent/ad/tangram/util/a$a:keyAlgorithm	Ljava/lang/String;
    //   34: aload_3
    //   35: getstatic 49	com/tencent/ad/tangram/statistics/c:CIPHER_ALGORITHM	Ljava/lang/String;
    //   38: putfield 184	com/tencent/ad/tangram/util/a$a:cipherAlgorithm	Ljava/lang/String;
    //   41: aload_3
    //   42: aload_1
    //   43: putfield 186	com/tencent/ad/tangram/util/a$a:key	[B
    //   46: new 188	java/io/DataOutputStream
    //   49: dup
    //   50: aload 4
    //   52: invokespecial 191	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   55: astore_2
    //   56: aload_2
    //   57: astore_1
    //   58: aload_2
    //   59: getstatic 37	com/tencent/ad/tangram/statistics/c:MAGIC	[B
    //   62: invokevirtual 195	java/io/DataOutputStream:write	([B)V
    //   65: aload_2
    //   66: astore_1
    //   67: aload_2
    //   68: iconst_1
    //   69: invokevirtual 199	java/io/DataOutputStream:writeByte	(I)V
    //   72: aload_2
    //   73: astore_1
    //   74: aload_2
    //   75: iconst_2
    //   76: invokevirtual 199	java/io/DataOutputStream:writeByte	(I)V
    //   79: aload_2
    //   80: astore_1
    //   81: aload_2
    //   82: aload_3
    //   83: aload_0
    //   84: invokestatic 205	com/tencent/ad/tangram/util/c:compress	([B)[B
    //   87: invokestatic 211	com/tencent/ad/tangram/util/a:encrypt	(Lcom/tencent/ad/tangram/util/a$a;[B)[B
    //   90: invokevirtual 195	java/io/DataOutputStream:write	([B)V
    //   93: aload_2
    //   94: astore_1
    //   95: aload 4
    //   97: invokevirtual 215	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   100: astore_0
    //   101: aload_2
    //   102: ifnull +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 218	java/io/DataOutputStream:close	()V
    //   109: aload 4
    //   111: invokevirtual 219	java/io/ByteArrayOutputStream:close	()V
    //   114: aload_0
    //   115: areturn
    //   116: astore_1
    //   117: ldc 31
    //   119: ldc 221
    //   121: aload_1
    //   122: invokestatic 146	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   125: aload_0
    //   126: areturn
    //   127: astore_3
    //   128: aconst_null
    //   129: astore_0
    //   130: aload_0
    //   131: astore_1
    //   132: ldc 31
    //   134: ldc 223
    //   136: aload_3
    //   137: invokestatic 146	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   140: aload_0
    //   141: ifnull +7 -> 148
    //   144: aload_0
    //   145: invokevirtual 218	java/io/DataOutputStream:close	()V
    //   148: aload 4
    //   150: invokevirtual 219	java/io/ByteArrayOutputStream:close	()V
    //   153: aconst_null
    //   154: areturn
    //   155: astore_0
    //   156: ldc 31
    //   158: ldc 221
    //   160: aload_0
    //   161: invokestatic 146	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   164: aconst_null
    //   165: areturn
    //   166: astore_0
    //   167: aconst_null
    //   168: astore_1
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 218	java/io/DataOutputStream:close	()V
    //   177: aload 4
    //   179: invokevirtual 219	java/io/ByteArrayOutputStream:close	()V
    //   182: aload_0
    //   183: athrow
    //   184: astore_1
    //   185: ldc 31
    //   187: ldc 221
    //   189: aload_1
    //   190: invokestatic 146	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   193: goto -11 -> 182
    //   196: astore_0
    //   197: goto -28 -> 169
    //   200: astore_3
    //   201: aload_2
    //   202: astore_0
    //   203: goto -73 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramArrayOfByte1	byte[]
    //   0	206	1	paramArrayOfByte2	byte[]
    //   55	147	2	localDataOutputStream	java.io.DataOutputStream
    //   27	56	3	locala	com.tencent.ad.tangram.util.a.a
    //   127	10	3	localThrowable1	Throwable
    //   200	1	3	localThrowable2	Throwable
    //   18	160	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   105	109	116	java/lang/Throwable
    //   109	114	116	java/lang/Throwable
    //   46	56	127	java/lang/Throwable
    //   144	148	155	java/lang/Throwable
    //   148	153	155	java/lang/Throwable
    //   46	56	166	finally
    //   173	177	184	java/lang/Throwable
    //   177	182	184	java/lang/Throwable
    //   58	65	196	finally
    //   67	72	196	finally
    //   74	79	196	finally
    //   81	93	196	finally
    //   95	101	196	finally
    //   132	140	196	finally
    //   58	65	200	java/lang/Throwable
    //   67	72	200	java/lang/Throwable
    //   74	79	200	java/lang/Throwable
    //   81	93	200	java/lang/Throwable
    //   95	101	200	java/lang/Throwable
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
    Object localObject;
    if (paramWeakReference != null)
    {
      localObject = (Context)paramWeakReference.get();
      AdReporterForAnalysis.reportForSdkMsgStatisticsStart((Context)localObject, paramAd, "https://sdk.e.qq.com/msg");
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).putOpt("plc", buildPlacementInfo(paramAd));
        ((JSONObject)localObject).putOpt("biz", buildBizData(paramAd, paramInt, paramJSONObject));
        paramJSONObject = getRequestParams("https://sdk.e.qq.com/msg", pack(((JSONObject)localObject).toString().getBytes("UTF-8"), arrayOfByte));
        AdHttp.send(paramJSONObject);
        if (paramWeakReference == null) {
          break label175;
        }
        paramWeakReference = (Context)paramWeakReference.get();
        AdReporterForAnalysis.reportForSdkMsgStatisticsEnd(paramWeakReference, paramAd, paramJSONObject);
        return;
      }
      catch (Throwable paramWeakReference)
      {
        AdLog.e("AdReporterForMsg", "reportMsg error, req params construct error.", paramWeakReference);
        return;
      }
      localObject = null;
      break;
      label175:
      paramWeakReference = null;
    }
  }
  
  /* Error */
  @android.annotation.TargetApi(9)
  public static byte[] unpack(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: ifnull +9 -> 16
    //   10: aload_0
    //   11: arraylength
    //   12: iconst_4
    //   13: if_icmpge +15 -> 28
    //   16: ldc 31
    //   18: ldc_w 290
    //   21: invokestatic 237	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload_0
    //   25: astore_1
    //   26: aload_1
    //   27: areturn
    //   28: new 177	com/tencent/ad/tangram/util/a$a
    //   31: dup
    //   32: invokespecial 178	com/tencent/ad/tangram/util/a$a:<init>	()V
    //   35: astore 7
    //   37: aload 7
    //   39: ldc 9
    //   41: putfield 181	com/tencent/ad/tangram/util/a$a:keyAlgorithm	Ljava/lang/String;
    //   44: aload 7
    //   46: getstatic 49	com/tencent/ad/tangram/statistics/c:CIPHER_ALGORITHM	Ljava/lang/String;
    //   49: putfield 184	com/tencent/ad/tangram/util/a$a:cipherAlgorithm	Ljava/lang/String;
    //   52: aload 7
    //   54: aload_1
    //   55: putfield 186	com/tencent/ad/tangram/util/a$a:key	[B
    //   58: new 292	java/io/ByteArrayInputStream
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 294	java/io/ByteArrayInputStream:<init>	([B)V
    //   66: astore_1
    //   67: new 296	java/io/DataInputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 299	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   75: astore 5
    //   77: aload 5
    //   79: astore_3
    //   80: aload_1
    //   81: astore_2
    //   82: iconst_4
    //   83: newarray byte
    //   85: astore 8
    //   87: aload 5
    //   89: astore_3
    //   90: aload_1
    //   91: astore_2
    //   92: aload 5
    //   94: aload 8
    //   96: invokevirtual 303	java/io/DataInputStream:read	([B)I
    //   99: pop
    //   100: aload 5
    //   102: astore_3
    //   103: aload_1
    //   104: astore_2
    //   105: getstatic 37	com/tencent/ad/tangram/statistics/c:MAGIC	[B
    //   108: iconst_0
    //   109: baload
    //   110: aload 8
    //   112: iconst_0
    //   113: baload
    //   114: if_icmpne +36 -> 150
    //   117: aload 5
    //   119: astore_3
    //   120: aload_1
    //   121: astore_2
    //   122: getstatic 37	com/tencent/ad/tangram/statistics/c:MAGIC	[B
    //   125: iconst_1
    //   126: baload
    //   127: aload 8
    //   129: iconst_1
    //   130: baload
    //   131: if_icmpne +19 -> 150
    //   134: iconst_1
    //   135: aload 8
    //   137: iconst_2
    //   138: baload
    //   139: if_icmpne +11 -> 150
    //   142: iconst_2
    //   143: aload 8
    //   145: iconst_3
    //   146: baload
    //   147: if_icmpeq +53 -> 200
    //   150: aload 5
    //   152: astore_3
    //   153: aload_1
    //   154: astore_2
    //   155: ldc 31
    //   157: ldc_w 305
    //   160: invokestatic 237	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload 4
    //   165: astore_0
    //   166: aload_1
    //   167: ifnull +7 -> 174
    //   170: aload_1
    //   171: invokevirtual 306	java/io/ByteArrayInputStream:close	()V
    //   174: aload_0
    //   175: astore_1
    //   176: aload 5
    //   178: ifnull -152 -> 26
    //   181: aload 5
    //   183: invokevirtual 307	java/io/DataInputStream:close	()V
    //   186: aload_0
    //   187: areturn
    //   188: astore_1
    //   189: ldc 31
    //   191: ldc_w 308
    //   194: aload_1
    //   195: invokestatic 146	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   198: aload_0
    //   199: areturn
    //   200: aload 5
    //   202: astore_3
    //   203: aload_1
    //   204: astore_2
    //   205: aload 7
    //   207: aload_0
    //   208: iconst_4
    //   209: aload_0
    //   210: arraylength
    //   211: invokestatic 314	java/util/Arrays:copyOfRange	([BII)[B
    //   214: invokestatic 317	com/tencent/ad/tangram/util/a:decrypt	(Lcom/tencent/ad/tangram/util/a$a;[B)[B
    //   217: invokestatic 320	com/tencent/ad/tangram/util/c:decompress	([B)[B
    //   220: astore_0
    //   221: goto -55 -> 166
    //   224: astore 4
    //   226: aconst_null
    //   227: astore_0
    //   228: aconst_null
    //   229: astore_1
    //   230: aload_0
    //   231: astore_3
    //   232: aload_1
    //   233: astore_2
    //   234: ldc 31
    //   236: ldc_w 322
    //   239: aload 4
    //   241: invokestatic 146	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   244: aload_1
    //   245: ifnull +7 -> 252
    //   248: aload_1
    //   249: invokevirtual 306	java/io/ByteArrayInputStream:close	()V
    //   252: aload 6
    //   254: astore_1
    //   255: aload_0
    //   256: ifnull -230 -> 26
    //   259: aload_0
    //   260: invokevirtual 307	java/io/DataInputStream:close	()V
    //   263: aconst_null
    //   264: areturn
    //   265: astore_0
    //   266: ldc 31
    //   268: ldc_w 308
    //   271: aload_0
    //   272: invokestatic 146	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   275: aconst_null
    //   276: areturn
    //   277: astore_0
    //   278: aconst_null
    //   279: astore_3
    //   280: aconst_null
    //   281: astore_1
    //   282: aload_1
    //   283: ifnull +7 -> 290
    //   286: aload_1
    //   287: invokevirtual 306	java/io/ByteArrayInputStream:close	()V
    //   290: aload_3
    //   291: ifnull +7 -> 298
    //   294: aload_3
    //   295: invokevirtual 307	java/io/DataInputStream:close	()V
    //   298: aload_0
    //   299: athrow
    //   300: astore_1
    //   301: ldc 31
    //   303: ldc_w 308
    //   306: aload_1
    //   307: invokestatic 146	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   310: goto -12 -> 298
    //   313: astore_0
    //   314: aconst_null
    //   315: astore_3
    //   316: goto -34 -> 282
    //   319: astore_0
    //   320: aload_2
    //   321: astore_1
    //   322: goto -40 -> 282
    //   325: astore 4
    //   327: aconst_null
    //   328: astore_0
    //   329: goto -99 -> 230
    //   332: astore 4
    //   334: aload 5
    //   336: astore_0
    //   337: goto -107 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	paramArrayOfByte1	byte[]
    //   0	340	1	paramArrayOfByte2	byte[]
    //   81	240	2	arrayOfByte1	byte[]
    //   79	237	3	localObject1	Object
    //   1	163	4	localObject2	Object
    //   224	16	4	localThrowable1	Throwable
    //   325	1	4	localThrowable2	Throwable
    //   332	1	4	localThrowable3	Throwable
    //   75	260	5	localDataInputStream	java.io.DataInputStream
    //   4	249	6	localObject3	Object
    //   35	171	7	locala	com.tencent.ad.tangram.util.a.a
    //   85	59	8	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   170	174	188	java/lang/Throwable
    //   181	186	188	java/lang/Throwable
    //   58	67	224	java/lang/Throwable
    //   248	252	265	java/lang/Throwable
    //   259	263	265	java/lang/Throwable
    //   58	67	277	finally
    //   286	290	300	java/lang/Throwable
    //   294	298	300	java/lang/Throwable
    //   67	77	313	finally
    //   82	87	319	finally
    //   92	100	319	finally
    //   105	117	319	finally
    //   122	134	319	finally
    //   155	163	319	finally
    //   205	221	319	finally
    //   234	244	319	finally
    //   67	77	325	java/lang/Throwable
    //   82	87	332	java/lang/Throwable
    //   92	100	332	java/lang/Throwable
    //   105	117	332	java/lang/Throwable
    //   122	134	332	java/lang/Throwable
    //   155	163	332	java/lang/Throwable
    //   205	221	332	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.c
 * JD-Core Version:    0.7.0.1
 */