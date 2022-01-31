import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.runtime.core.page.BrandPageWebview.5;
import com.tencent.qqmini.sdk.runtime.core.page.BrandPageWebview.7;
import com.tencent.qqmini.sdk.runtime.core.page.PageWebview;
import org.json.JSONException;
import org.json.JSONObject;

public class bfbw
  extends bfbl
  implements behp
{
  private behq jdField_a_of_type_Behq;
  private bekp jdField_a_of_type_Bekp;
  private bfbm jdField_a_of_type_Bfbm = new bfbm(this, 5).a(this.jdField_e_of_type_Bfbq);
  private bfbq jdField_a_of_type_Bfbq = new bfbq(this, Integer.valueOf(1));
  private bfce jdField_a_of_type_Bfce;
  private AppBrandPageContainer jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer;
  private PageWebview jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview;
  private String jdField_a_of_type_JavaLangString;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private bfbm jdField_b_of_type_Bfbm = new bfbm(this, 7).a(this.jdField_f_of_type_Bfbq);
  private bfbq jdField_b_of_type_Bfbq = new bfbq(this, Integer.valueOf(2));
  private String jdField_b_of_type_JavaLangString = "appLaunch";
  private bfbm jdField_c_of_type_Bfbm = new bfbm(this, 9).a(this.jdField_g_of_type_Bfbq);
  private bfbq jdField_c_of_type_Bfbq = new bfbq(this, Integer.valueOf(4));
  private bfbm jdField_d_of_type_Bfbm = new bfbm(this, 11).a(this.jdField_h_of_type_Bfbq);
  private bfbq jdField_d_of_type_Bfbq = new bfbq(this, Integer.valueOf(3));
  private bfbm jdField_e_of_type_Bfbm = new bfbm(this, 13).a(this.jdField_i_of_type_Bfbq);
  private bfbq jdField_e_of_type_Bfbq = new bfbq(this, Integer.valueOf(6));
  private bfbm jdField_f_of_type_Bfbm = new bfbm(this, 15).a(this.j);
  private bfbq jdField_f_of_type_Bfbq = new bfbq(this, Integer.valueOf(8));
  private bfbm jdField_g_of_type_Bfbm = new bfbm(this, 17).a(this.k);
  private bfbq jdField_g_of_type_Bfbq = new bfbq(this, Integer.valueOf(10));
  private bfbm jdField_h_of_type_Bfbm = new bfbm(this, 19).a(this.l);
  private bfbq jdField_h_of_type_Bfbq = new bfbq(this, Integer.valueOf(12));
  private bfbm jdField_i_of_type_Bfbm = new bfbm(this, 21).a(this.m);
  private bfbq jdField_i_of_type_Bfbq = new bfbq(this, Integer.valueOf(14));
  private bfbq j = new bfbq(this, Integer.valueOf(16));
  private bfbq k = new bfbq(this, Integer.valueOf(18));
  private bfbq l = new bfbq(this, Integer.valueOf(20));
  private bfbq m = new bfbq(this, Integer.valueOf(22));
  
  public bfbw(behq parambehq, AppBrandPageContainer paramAppBrandPageContainer)
  {
    this.jdField_a_of_type_Behq = parambehq;
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer = paramAppBrandPageContainer;
    a(this.jdField_a_of_type_Bfbq);
    a();
    e();
    a(this.jdField_b_of_type_Bfbq);
    b();
  }
  
  /* Error */
  private com.tencent.smtt.export.external.interfaces.WebResourceResponse a(com.tencent.smtt.sdk.WebView paramWebView, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_2
    //   4: ldc 131
    //   6: invokevirtual 137	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9: ifeq +245 -> 254
    //   12: aload_2
    //   13: ldc 139
    //   15: invokevirtual 142	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   18: ifeq +236 -> 254
    //   21: invokestatic 147	bekp:c	()Ljava/lang/String;
    //   24: astore_1
    //   25: aload_1
    //   26: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: ifne +532 -> 561
    //   32: aload_0
    //   33: getfield 155	bfbw:jdField_a_of_type_ArrayOfByte	[B
    //   36: ifnull +11 -> 47
    //   39: aload_0
    //   40: getfield 155	bfbw:jdField_a_of_type_ArrayOfByte	[B
    //   43: arraylength
    //   44: ifne +13 -> 57
    //   47: aload_0
    //   48: aload_1
    //   49: ldc 157
    //   51: invokevirtual 161	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   54: putfield 155	bfbw:jdField_a_of_type_ArrayOfByte	[B
    //   57: new 163	java/io/ByteArrayInputStream
    //   60: dup
    //   61: aload_0
    //   62: getfield 155	bfbw:jdField_a_of_type_ArrayOfByte	[B
    //   65: iconst_0
    //   66: aload_0
    //   67: getfield 155	bfbw:jdField_a_of_type_ArrayOfByte	[B
    //   70: arraylength
    //   71: invokespecial 166	java/io/ByteArrayInputStream:<init>	([BII)V
    //   74: astore 5
    //   76: aload 5
    //   78: astore_2
    //   79: new 168	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   82: dup
    //   83: ldc 170
    //   85: ldc 157
    //   87: aload 5
    //   89: invokespecial 173	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   92: astore_1
    //   93: aload 5
    //   95: astore_2
    //   96: new 175	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   103: ldc 178
    //   105: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: astore 6
    //   110: aload 5
    //   112: astore_2
    //   113: aload_0
    //   114: getfield 155	bfbw:jdField_a_of_type_ArrayOfByte	[B
    //   117: ifnull +47 -> 164
    //   120: aload 5
    //   122: astore_2
    //   123: aload_0
    //   124: getfield 155	bfbw:jdField_a_of_type_ArrayOfByte	[B
    //   127: arraylength
    //   128: istore_3
    //   129: aload 5
    //   131: astore_2
    //   132: ldc 184
    //   134: aload 6
    //   136: iload_3
    //   137: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 195	betc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_1
    //   147: astore_2
    //   148: aload 5
    //   150: ifnull +10 -> 160
    //   153: aload 5
    //   155: invokevirtual 198	java/io/ByteArrayInputStream:close	()V
    //   158: aload_1
    //   159: astore_2
    //   160: aload_2
    //   161: astore_1
    //   162: aload_1
    //   163: areturn
    //   164: iconst_0
    //   165: istore_3
    //   166: goto -37 -> 129
    //   169: astore_2
    //   170: aload_2
    //   171: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   174: aload_1
    //   175: astore_2
    //   176: goto -16 -> 160
    //   179: astore 6
    //   181: aconst_null
    //   182: astore 5
    //   184: aconst_null
    //   185: astore_1
    //   186: aload 5
    //   188: astore_2
    //   189: aload 6
    //   191: invokevirtual 202	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   194: aload 5
    //   196: astore_2
    //   197: ldc 184
    //   199: ldc 204
    //   201: aload 6
    //   203: invokestatic 207	betc:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   206: aload_1
    //   207: astore_2
    //   208: aload 5
    //   210: ifnull -50 -> 160
    //   213: aload 5
    //   215: invokevirtual 198	java/io/ByteArrayInputStream:close	()V
    //   218: aload_1
    //   219: astore_2
    //   220: goto -60 -> 160
    //   223: astore_2
    //   224: aload_2
    //   225: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   228: aload_1
    //   229: astore_2
    //   230: goto -70 -> 160
    //   233: astore_1
    //   234: aconst_null
    //   235: astore_2
    //   236: aload_2
    //   237: ifnull +7 -> 244
    //   240: aload_2
    //   241: invokevirtual 198	java/io/ByteArrayInputStream:close	()V
    //   244: aload_1
    //   245: athrow
    //   246: astore_2
    //   247: aload_2
    //   248: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   251: goto -7 -> 244
    //   254: aload_2
    //   255: ldc 131
    //   257: invokevirtual 137	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   260: ifeq +156 -> 416
    //   263: aload 5
    //   265: astore_1
    //   266: aload_0
    //   267: getfield 209	bfbw:jdField_a_of_type_Bekp	Lbekp;
    //   270: ifnull -108 -> 162
    //   273: aload_2
    //   274: invokestatic 213	beli:a	(Ljava/lang/String;)Z
    //   277: ifne +10 -> 287
    //   280: aload_2
    //   281: invokestatic 215	beli:b	(Ljava/lang/String;)Z
    //   284: ifeq +59 -> 343
    //   287: aload_2
    //   288: ldc 131
    //   290: invokevirtual 219	java/lang/String:length	()I
    //   293: invokevirtual 223	java/lang/String:substring	(I)Ljava/lang/String;
    //   296: astore 5
    //   298: aload_2
    //   299: invokestatic 215	beli:b	(Ljava/lang/String;)Z
    //   302: istore 4
    //   304: iload 4
    //   306: ifeq +31 -> 337
    //   309: ldc 225
    //   311: astore_1
    //   312: new 168	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   315: dup
    //   316: aload_1
    //   317: ldc 157
    //   319: aload_0
    //   320: getfield 209	bfbw:jdField_a_of_type_Bekp	Lbekp;
    //   323: aload 5
    //   325: invokevirtual 228	bekp:g	(Ljava/lang/String;)Ljava/lang/String;
    //   328: iload 4
    //   330: invokestatic 231	beli:a	(Ljava/lang/String;Z)Ljava/io/InputStream;
    //   333: invokespecial 173	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   336: areturn
    //   337: ldc 233
    //   339: astore_1
    //   340: goto -28 -> 312
    //   343: aload_2
    //   344: ldc 235
    //   346: invokevirtual 142	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   349: ifne +15 -> 364
    //   352: aload 5
    //   354: astore_1
    //   355: aload_2
    //   356: ldc 237
    //   358: invokevirtual 142	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   361: ifeq -199 -> 162
    //   364: aload_2
    //   365: ldc 131
    //   367: invokevirtual 219	java/lang/String:length	()I
    //   370: invokevirtual 223	java/lang/String:substring	(I)Ljava/lang/String;
    //   373: astore 5
    //   375: aload_2
    //   376: ldc 235
    //   378: invokevirtual 142	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   381: ifeq +29 -> 410
    //   384: ldc 239
    //   386: astore_1
    //   387: new 168	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   390: dup
    //   391: aload_1
    //   392: ldc 157
    //   394: aload_0
    //   395: getfield 209	bfbw:jdField_a_of_type_Bekp	Lbekp;
    //   398: aload 5
    //   400: invokevirtual 228	bekp:g	(Ljava/lang/String;)Ljava/lang/String;
    //   403: invokestatic 242	beli:a	(Ljava/lang/String;)Ljava/io/ByteArrayInputStream;
    //   406: invokespecial 173	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   409: areturn
    //   410: ldc 244
    //   412: astore_1
    //   413: goto -26 -> 387
    //   416: aload 5
    //   418: astore_1
    //   419: aload_2
    //   420: ldc 246
    //   422: invokevirtual 137	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   425: ifeq -263 -> 162
    //   428: aload_2
    //   429: invokestatic 213	beli:a	(Ljava/lang/String;)Z
    //   432: ifne +10 -> 442
    //   435: aload_2
    //   436: invokestatic 215	beli:b	(Ljava/lang/String;)Z
    //   439: ifeq +46 -> 485
    //   442: aload_2
    //   443: invokestatic 215	beli:b	(Ljava/lang/String;)Z
    //   446: istore 4
    //   448: iload 4
    //   450: ifeq +29 -> 479
    //   453: ldc 225
    //   455: astore_1
    //   456: new 168	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   459: dup
    //   460: aload_1
    //   461: ldc 157
    //   463: invokestatic 251	bejl:a	()Lbejl;
    //   466: aload_2
    //   467: invokevirtual 253	bejl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   470: iload 4
    //   472: invokestatic 231	beli:a	(Ljava/lang/String;Z)Ljava/io/InputStream;
    //   475: invokespecial 173	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   478: areturn
    //   479: ldc 233
    //   481: astore_1
    //   482: goto -26 -> 456
    //   485: aload_2
    //   486: ldc 235
    //   488: invokevirtual 142	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   491: ifne +15 -> 506
    //   494: aload 5
    //   496: astore_1
    //   497: aload_2
    //   498: ldc 237
    //   500: invokevirtual 142	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   503: ifeq -341 -> 162
    //   506: aload_2
    //   507: ldc 235
    //   509: invokevirtual 142	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   512: ifeq +27 -> 539
    //   515: ldc 239
    //   517: astore_1
    //   518: new 168	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   521: dup
    //   522: aload_1
    //   523: ldc 157
    //   525: invokestatic 251	bejl:a	()Lbejl;
    //   528: aload_2
    //   529: invokevirtual 253	bejl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   532: invokestatic 242	beli:a	(Ljava/lang/String;)Ljava/io/ByteArrayInputStream;
    //   535: invokespecial 173	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   538: areturn
    //   539: ldc 244
    //   541: astore_1
    //   542: goto -24 -> 518
    //   545: astore_1
    //   546: goto -310 -> 236
    //   549: astore 6
    //   551: aconst_null
    //   552: astore_1
    //   553: goto -367 -> 186
    //   556: astore 6
    //   558: goto -372 -> 186
    //   561: aconst_null
    //   562: astore_2
    //   563: goto -403 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	566	0	this	bfbw
    //   0	566	1	paramWebView	com.tencent.smtt.sdk.WebView
    //   0	566	2	paramString	String
    //   128	38	3	n	int
    //   302	169	4	bool	boolean
    //   1	494	5	localObject	Object
    //   108	27	6	localStringBuilder	java.lang.StringBuilder
    //   179	23	6	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   549	1	6	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   556	1	6	localUnsupportedEncodingException3	java.io.UnsupportedEncodingException
    // Exception table:
    //   from	to	target	type
    //   153	158	169	java/io/IOException
    //   32	47	179	java/io/UnsupportedEncodingException
    //   47	57	179	java/io/UnsupportedEncodingException
    //   57	76	179	java/io/UnsupportedEncodingException
    //   213	218	223	java/io/IOException
    //   32	47	233	finally
    //   47	57	233	finally
    //   57	76	233	finally
    //   240	244	246	java/io/IOException
    //   79	93	545	finally
    //   96	110	545	finally
    //   113	120	545	finally
    //   123	129	545	finally
    //   132	146	545	finally
    //   189	194	545	finally
    //   197	206	545	finally
    //   79	93	549	java/io/UnsupportedEncodingException
    //   96	110	556	java/io/UnsupportedEncodingException
    //   113	120	556	java/io/UnsupportedEncodingException
    //   123	129	556	java/io/UnsupportedEncodingException
    //   132	146	556	java/io/UnsupportedEncodingException
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview = new PageWebview(this.jdField_a_of_type_Behq, this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer);
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview.addJavascriptInterface(this, "WeixinJSCore");
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview.setWebViewClient(new bfbx(this));
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview.setWebChromeClient(new bfby(this));
  }
  
  public PageWebview a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview;
  }
  
  public String a(bekp parambekp)
  {
    if (parambekp == null) {
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", parambekp.d);
      localJSONObject.put("icon", parambekp.e);
      localJSONObject.put("nickname", "testuser");
      parambekp = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s; Object.assign(__qqConfig, __tempConfig); __qqConfig.accountInfo=JSON.parse('%2$s'); __qqConfig.QUA='V1_AND_SQ_8.1.3_0_RDM_B';", new Object[] { parambekp.jdField_b_of_type_JavaLangString, localJSONObject.toString() });
      return parambekp + "if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};";
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public String a(boolean paramBoolean)
  {
    try
    {
      Object localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("USER_DATA_PATH", "qqfile://usr");
      ((JSONObject)localObject).put("env", localJSONObject);
      ((JSONObject)localObject).put("preload", paramBoolean);
      localObject = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = %1$s; Object.assign(__qqConfig, __tempConfig); ", new Object[] { localObject });
      return localObject;
    }
    catch (Exception localException)
    {
      betc.d("BrandPageWebview", "getJsDefaultConfig failed: " + localException);
    }
    return "";
  }
  
  protected void a()
  {
    a(new bfbr(this).a(this.jdField_a_of_type_Bfbq).b(this.jdField_b_of_type_Bfbq).a(Integer.valueOf(3)));
    a(new bfbr(this).a(this.jdField_c_of_type_Bfbq).b(this.jdField_a_of_type_Bfbm).a(Integer.valueOf(5)));
    a(new bfbr(this).a(this.jdField_e_of_type_Bfbq).b(this.jdField_b_of_type_Bfbm).a(Integer.valueOf(6)));
    a(new bfbr(this).a(this.jdField_f_of_type_Bfbq).b(this.jdField_c_of_type_Bfbm).a(Integer.valueOf(7)));
    a(new bfbr(this).a(this.jdField_g_of_type_Bfbq).b(this.jdField_d_of_type_Bfbm).a(Integer.valueOf(8)));
    a(new bfbr(this).a(this.jdField_h_of_type_Bfbq).b(this.jdField_e_of_type_Bfbm).a(Integer.valueOf(9)));
    a(new bfbr(this).a(this.jdField_i_of_type_Bfbq).b(this.jdField_f_of_type_Bfbm).a(Integer.valueOf(10)));
    a(new bfbr(this).a(this.j).b(this.jdField_g_of_type_Bfbm).a(Integer.valueOf(11)));
    a(new bfbr(this).a(this.k).b(this.jdField_h_of_type_Bfbm).a(Integer.valueOf(12)));
    a(new bfbr(this).a(this.l).b(this.jdField_i_of_type_Bfbm).a(Integer.valueOf(13)));
    a(this.jdField_a_of_type_Bfbq);
  }
  
  public void a(int paramInt, String paramString)
  {
    a(String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramString }), null);
  }
  
  public void a(bekp parambekp)
  {
    if (parambekp == null) {
      return;
    }
    this.jdField_a_of_type_Bekp = parambekp;
    String str = a(parambekp);
    this.jdField_d_of_type_Bfbm.a(str);
    b(Integer.valueOf(8));
    this.jdField_c_of_type_Bfbm.a("");
    b(Integer.valueOf(9));
    parambekp = parambekp.d();
    this.jdField_f_of_type_Bfbm.a(parambekp);
    b(Integer.valueOf(10));
  }
  
  public void a(bfbq parambfbq)
  {
    if ((parambfbq == this.m) && (this.jdField_a_of_type_Bfce != null)) {
      this.jdField_a_of_type_Bfce.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview.b());
    }
    bfbq localbfbq = a();
    if (localbfbq == this.jdField_b_of_type_Bfbm) {
      bezi.a(this.jdField_a_of_type_Behq.a(), 18, "0");
    }
    for (;;)
    {
      super.a(parambfbq);
      return;
      if (this.jdField_g_of_type_Bfbq == localbfbq) {
        bezi.a(this.jdField_a_of_type_Behq.a(), 19, "0");
      }
    }
  }
  
  public void a(bfce parambfce)
  {
    this.jdField_a_of_type_Bfce = parambfce;
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview.setPageEventListener(parambfce);
    }
  }
  
  public void a(String paramString, ValueCallback paramValueCallback)
  {
    a(paramString, paramValueCallback, null);
  }
  
  public void a(String paramString1, ValueCallback paramValueCallback, String paramString2)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview != null) {
        this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview.evaluateJavascript(paramString1, bfen.a(paramValueCallback));
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new BrandPageWebview.5(this, paramString1, paramValueCallback));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    paramString2 = this.jdField_a_of_type_Bekp.a().jdField_b_of_type_JavaLangString;
    this.jdField_g_of_type_Bfbm.a(paramString2);
    b(Integer.valueOf(11));
    paramString2 = this.jdField_a_of_type_Bekp.f(paramString1);
    this.jdField_h_of_type_Bfbm.a(paramString2);
    b(Integer.valueOf(12));
    paramString1 = this.jdField_a_of_type_Bekp.b(paramString1);
    this.jdField_i_of_type_Bfbm.a(paramString1);
    b(Integer.valueOf(13));
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer.a() != null) {
      bekz.a(new BrandPageWebview.7(this), 1000L);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    a("WeixinJSBridge.subscribeHandler(\"" + paramString1 + "\"," + paramString2 + "," + paramInt + "," + 0 + ")", null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview != null)
    {
      a(this.jdField_d_of_type_Bfbq);
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview.loadUrl("https://appservice.qq.com/page-frame.html");
    }
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    a("WeixinJSBridge.subscribeHandler(\"" + paramString1 + "\"," + paramString2 + "," + 0 + ",\"" + paramInt + "\")", null);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview != null)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview.removeJavascriptInterface("WeixinJSCore");
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview.destroy();
    }
  }
  
  public void d()
  {
    String str = a(true);
    this.jdField_a_of_type_Bfbm.a(str);
    b(Integer.valueOf(5));
    MiniAppEnv.g().getBaselibLoader().loadBaselib(this.jdField_a_of_type_Behq.a(), new bfca(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfbw
 * JD-Core Version:    0.7.0.1
 */