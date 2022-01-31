import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.runtime.core.page.BrandPageWebview.5;
import com.tencent.qqmini.sdk.runtime.core.page.BrandPageWebview.7;
import com.tencent.qqmini.sdk.runtime.core.page.PageWebview;
import org.json.JSONException;
import org.json.JSONObject;

public class bhfp
  extends bhfb
  implements bglu
{
  private bglv jdField_a_of_type_Bglv;
  private bgod jdField_a_of_type_Bgod;
  private bhfc jdField_a_of_type_Bhfc = new bhfc(this, 5).a(this.jdField_e_of_type_Bhfg);
  private bhff jdField_a_of_type_Bhff = new bhfu(this);
  private bhfg jdField_a_of_type_Bhfg = new bhfg(this, Integer.valueOf(1));
  private bhfy jdField_a_of_type_Bhfy;
  private AppBrandPageContainer jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer;
  private PageWebview jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview;
  private String jdField_a_of_type_JavaLangString;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private bhfc jdField_b_of_type_Bhfc = new bhfc(this, 7).a(this.jdField_f_of_type_Bhfg);
  private bhfg jdField_b_of_type_Bhfg = new bhfg(this, Integer.valueOf(2));
  private String jdField_b_of_type_JavaLangString = "appLaunch";
  private bhfc jdField_c_of_type_Bhfc = new bhfc(this, 9).a(this.jdField_g_of_type_Bhfg);
  private bhfg jdField_c_of_type_Bhfg = new bhfg(this, Integer.valueOf(4));
  private bhfc jdField_d_of_type_Bhfc = new bhfc(this, 11).a(this.jdField_h_of_type_Bhfg);
  private bhfg jdField_d_of_type_Bhfg = new bhfg(this, Integer.valueOf(3));
  private bhfc jdField_e_of_type_Bhfc = new bhfc(this, 13).a(this.jdField_i_of_type_Bhfg);
  private bhfg jdField_e_of_type_Bhfg = new bhfg(this, Integer.valueOf(6));
  private bhfc jdField_f_of_type_Bhfc = new bhfc(this, 15).a(this.j);
  private bhfg jdField_f_of_type_Bhfg = new bhfg(this, Integer.valueOf(8));
  private bhfc jdField_g_of_type_Bhfc = new bhfc(this, 17).a(this.k);
  private bhfg jdField_g_of_type_Bhfg = new bhfg(this, Integer.valueOf(10));
  private bhfc jdField_h_of_type_Bhfc = new bhfc(this, 19).a(this.l);
  private bhfg jdField_h_of_type_Bhfg = new bhfg(this, Integer.valueOf(12));
  private bhfc jdField_i_of_type_Bhfc = new bhfc(this, 21).a(this.m);
  private bhfg jdField_i_of_type_Bhfg = new bhfg(this, Integer.valueOf(14));
  private bhfg j = new bhfg(this, Integer.valueOf(16));
  private bhfg k = new bhfg(this, Integer.valueOf(18));
  private bhfg l = new bhfg(this, Integer.valueOf(20));
  private bhfg m = new bhfg(this, Integer.valueOf(22));
  
  public bhfp(bglv parambglv, AppBrandPageContainer paramAppBrandPageContainer)
  {
    this.jdField_a_of_type_Bglv = parambglv;
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer = paramAppBrandPageContainer;
    addStateChangeListener(this.jdField_a_of_type_Bhff);
    setCurrState(this.jdField_a_of_type_Bhfg);
    a();
    e();
    setCurrState(this.jdField_b_of_type_Bhfg);
    b();
  }
  
  /* Error */
  private com.tencent.smtt.export.external.interfaces.WebResourceResponse a(com.tencent.smtt.sdk.WebView paramWebView, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_2
    //   4: ldc 144
    //   6: invokevirtual 150	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9: ifeq +245 -> 254
    //   12: aload_2
    //   13: ldc 152
    //   15: invokevirtual 155	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   18: ifeq +236 -> 254
    //   21: invokestatic 160	bgod:c	()Ljava/lang/String;
    //   24: astore_1
    //   25: aload_1
    //   26: invokestatic 166	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: ifne +535 -> 564
    //   32: aload_0
    //   33: getfield 168	bhfp:jdField_a_of_type_ArrayOfByte	[B
    //   36: ifnull +11 -> 47
    //   39: aload_0
    //   40: getfield 168	bhfp:jdField_a_of_type_ArrayOfByte	[B
    //   43: arraylength
    //   44: ifne +13 -> 57
    //   47: aload_0
    //   48: aload_1
    //   49: ldc 170
    //   51: invokevirtual 174	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   54: putfield 168	bhfp:jdField_a_of_type_ArrayOfByte	[B
    //   57: new 176	java/io/ByteArrayInputStream
    //   60: dup
    //   61: aload_0
    //   62: getfield 168	bhfp:jdField_a_of_type_ArrayOfByte	[B
    //   65: iconst_0
    //   66: aload_0
    //   67: getfield 168	bhfp:jdField_a_of_type_ArrayOfByte	[B
    //   70: arraylength
    //   71: invokespecial 179	java/io/ByteArrayInputStream:<init>	([BII)V
    //   74: astore 5
    //   76: aload 5
    //   78: astore_2
    //   79: new 181	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   82: dup
    //   83: ldc 183
    //   85: ldc 170
    //   87: aload 5
    //   89: invokespecial 186	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   92: astore_1
    //   93: aload 5
    //   95: astore_2
    //   96: new 188	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   103: ldc 191
    //   105: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: astore 6
    //   110: aload 5
    //   112: astore_2
    //   113: aload_0
    //   114: getfield 168	bhfp:jdField_a_of_type_ArrayOfByte	[B
    //   117: ifnull +47 -> 164
    //   120: aload 5
    //   122: astore_2
    //   123: aload_0
    //   124: getfield 168	bhfp:jdField_a_of_type_ArrayOfByte	[B
    //   127: arraylength
    //   128: istore_3
    //   129: aload 5
    //   131: astore_2
    //   132: ldc 197
    //   134: aload 6
    //   136: iload_3
    //   137: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 208	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_1
    //   147: astore_2
    //   148: aload 5
    //   150: ifnull +10 -> 160
    //   153: aload 5
    //   155: invokevirtual 211	java/io/ByteArrayInputStream:close	()V
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
    //   171: invokevirtual 214	java/io/IOException:printStackTrace	()V
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
    //   191: invokevirtual 215	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   194: aload 5
    //   196: astore_2
    //   197: ldc 197
    //   199: ldc 217
    //   201: aload 6
    //   203: invokestatic 220	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   206: aload_1
    //   207: astore_2
    //   208: aload 5
    //   210: ifnull -50 -> 160
    //   213: aload 5
    //   215: invokevirtual 211	java/io/ByteArrayInputStream:close	()V
    //   218: aload_1
    //   219: astore_2
    //   220: goto -60 -> 160
    //   223: astore_2
    //   224: aload_2
    //   225: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   228: aload_1
    //   229: astore_2
    //   230: goto -70 -> 160
    //   233: astore_1
    //   234: aconst_null
    //   235: astore_2
    //   236: aload_2
    //   237: ifnull +7 -> 244
    //   240: aload_2
    //   241: invokevirtual 211	java/io/ByteArrayInputStream:close	()V
    //   244: aload_1
    //   245: athrow
    //   246: astore_2
    //   247: aload_2
    //   248: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   251: goto -7 -> 244
    //   254: aload_2
    //   255: ldc 144
    //   257: invokevirtual 150	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   260: ifeq +157 -> 417
    //   263: aload 5
    //   265: astore_1
    //   266: aload_0
    //   267: getfield 222	bhfp:jdField_a_of_type_Bgod	Lbgod;
    //   270: ifnull -108 -> 162
    //   273: aload_2
    //   274: invokestatic 226	bgpe:a	(Ljava/lang/String;)Z
    //   277: ifne +10 -> 287
    //   280: aload_2
    //   281: invokestatic 228	bgpe:b	(Ljava/lang/String;)Z
    //   284: ifeq +59 -> 343
    //   287: aload_2
    //   288: ldc 144
    //   290: invokevirtual 232	java/lang/String:length	()I
    //   293: invokevirtual 236	java/lang/String:substring	(I)Ljava/lang/String;
    //   296: astore 5
    //   298: aload_2
    //   299: invokestatic 228	bgpe:b	(Ljava/lang/String;)Z
    //   302: istore 4
    //   304: iload 4
    //   306: ifeq +31 -> 337
    //   309: ldc 238
    //   311: astore_1
    //   312: new 181	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   315: dup
    //   316: aload_1
    //   317: ldc 170
    //   319: aload_0
    //   320: getfield 222	bhfp:jdField_a_of_type_Bgod	Lbgod;
    //   323: aload 5
    //   325: invokevirtual 242	bgod:getChildFileAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   328: iload 4
    //   330: invokestatic 245	bgpe:a	(Ljava/lang/String;Z)Ljava/io/InputStream;
    //   333: invokespecial 186	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   336: areturn
    //   337: ldc 247
    //   339: astore_1
    //   340: goto -28 -> 312
    //   343: aload_2
    //   344: ldc 249
    //   346: invokevirtual 155	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   349: ifne +15 -> 364
    //   352: aload 5
    //   354: astore_1
    //   355: aload_2
    //   356: ldc 251
    //   358: invokevirtual 155	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   361: ifeq -199 -> 162
    //   364: aload_2
    //   365: ldc 144
    //   367: invokevirtual 232	java/lang/String:length	()I
    //   370: invokevirtual 236	java/lang/String:substring	(I)Ljava/lang/String;
    //   373: astore 5
    //   375: aload_2
    //   376: ldc 249
    //   378: invokevirtual 155	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   381: ifeq +29 -> 410
    //   384: ldc 253
    //   386: astore_1
    //   387: new 181	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   390: dup
    //   391: aload_1
    //   392: ldc 170
    //   394: aload_0
    //   395: getfield 222	bhfp:jdField_a_of_type_Bgod	Lbgod;
    //   398: aload 5
    //   400: invokevirtual 242	bgod:getChildFileAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   403: invokestatic 256	bgpe:a	(Ljava/lang/String;)Ljava/io/ByteArrayInputStream;
    //   406: invokespecial 186	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   409: areturn
    //   410: ldc_w 258
    //   413: astore_1
    //   414: goto -27 -> 387
    //   417: aload 5
    //   419: astore_1
    //   420: aload_2
    //   421: ldc_w 260
    //   424: invokevirtual 150	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   427: ifeq -265 -> 162
    //   430: aload_2
    //   431: invokestatic 226	bgpe:a	(Ljava/lang/String;)Z
    //   434: ifne +10 -> 444
    //   437: aload_2
    //   438: invokestatic 228	bgpe:b	(Ljava/lang/String;)Z
    //   441: ifeq +46 -> 487
    //   444: aload_2
    //   445: invokestatic 228	bgpe:b	(Ljava/lang/String;)Z
    //   448: istore 4
    //   450: iload 4
    //   452: ifeq +29 -> 481
    //   455: ldc 238
    //   457: astore_1
    //   458: new 181	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   461: dup
    //   462: aload_1
    //   463: ldc 170
    //   465: invokestatic 265	bgnt:a	()Lbgnt;
    //   468: aload_2
    //   469: invokevirtual 267	bgnt:a	(Ljava/lang/String;)Ljava/lang/String;
    //   472: iload 4
    //   474: invokestatic 245	bgpe:a	(Ljava/lang/String;Z)Ljava/io/InputStream;
    //   477: invokespecial 186	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   480: areturn
    //   481: ldc 247
    //   483: astore_1
    //   484: goto -26 -> 458
    //   487: aload_2
    //   488: ldc 249
    //   490: invokevirtual 155	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   493: ifne +15 -> 508
    //   496: aload 5
    //   498: astore_1
    //   499: aload_2
    //   500: ldc 251
    //   502: invokevirtual 155	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   505: ifeq -343 -> 162
    //   508: aload_2
    //   509: ldc 249
    //   511: invokevirtual 155	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   514: ifeq +27 -> 541
    //   517: ldc 253
    //   519: astore_1
    //   520: new 181	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   523: dup
    //   524: aload_1
    //   525: ldc 170
    //   527: invokestatic 265	bgnt:a	()Lbgnt;
    //   530: aload_2
    //   531: invokevirtual 267	bgnt:a	(Ljava/lang/String;)Ljava/lang/String;
    //   534: invokestatic 256	bgpe:a	(Ljava/lang/String;)Ljava/io/ByteArrayInputStream;
    //   537: invokespecial 186	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   540: areturn
    //   541: ldc_w 258
    //   544: astore_1
    //   545: goto -25 -> 520
    //   548: astore_1
    //   549: goto -313 -> 236
    //   552: astore 6
    //   554: aconst_null
    //   555: astore_1
    //   556: goto -370 -> 186
    //   559: astore 6
    //   561: goto -375 -> 186
    //   564: aconst_null
    //   565: astore_2
    //   566: goto -406 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	569	0	this	bhfp
    //   0	569	1	paramWebView	com.tencent.smtt.sdk.WebView
    //   0	569	2	paramString	String
    //   128	38	3	n	int
    //   302	171	4	bool	boolean
    //   1	496	5	localObject	Object
    //   108	27	6	localStringBuilder	java.lang.StringBuilder
    //   179	23	6	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   552	1	6	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   559	1	6	localUnsupportedEncodingException3	java.io.UnsupportedEncodingException
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
    //   79	93	548	finally
    //   96	110	548	finally
    //   113	120	548	finally
    //   123	129	548	finally
    //   132	146	548	finally
    //   189	194	548	finally
    //   197	206	548	finally
    //   79	93	552	java/io/UnsupportedEncodingException
    //   96	110	559	java/io/UnsupportedEncodingException
    //   113	120	559	java/io/UnsupportedEncodingException
    //   123	129	559	java/io/UnsupportedEncodingException
    //   132	146	559	java/io/UnsupportedEncodingException
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview = new PageWebview(this.jdField_a_of_type_Bglv, this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer, this);
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview.addJavascriptInterface(this, "WeixinJSCore");
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview.setWebViewClient(new bhfq(this));
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview.setWebChromeClient(new bhfr(this));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview.b();
  }
  
  public PageWebview a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview;
  }
  
  public String a(bgod parambgod)
  {
    if (parambgod == null) {
      return "";
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("appId", parambgod.appId);
      ((JSONObject)localObject).put("icon", parambgod.iconUrl);
      ((JSONObject)localObject).put("nickname", "testuser");
      parambgod = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s; Object.assign(__qqConfig, __tempConfig); __qqConfig.accountInfo=JSON.parse('%2$s'); __qqConfig.QUA='V1_AND_SQ_8.1.3_0_RDM_B';", new Object[] { parambgod.mConfigStr, ((JSONObject)localObject).toString() });
      parambgod = parambgod + "__qqConfig.debug=true;";
      localObject = parambgod + "__qqConfig.XWebVideoMinVersion=045100;";
      parambgod = (bgod)localObject;
      if (a() != null)
      {
        parambgod = (bgod)localObject;
        if (a().a() != null)
        {
          boolean bool = a().a().a();
          parambgod = (bgod)localObject;
          if (bool) {
            parambgod = (String)localObject + "__qqConfig.useXWebVideo=" + bool + ";";
          }
        }
      }
      return parambgod + "if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};";
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
      localObject = (String)localObject + "__qqConfig.useXWebVideo=" + true + ";";
      localObject = (String)localObject + "__qqConfig.XWebVideoMinVersion=045100;";
      QMLog.d("miniapp-embedded", "page enableEmbeddedVideo : true");
      QMLog.d("minisdk-start", "getJsDefaultConfig pageWebview String: " + (String)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      QMLog.e("BrandPageWebview", "getJsDefaultConfig failed: " + localException);
    }
    return "";
  }
  
  protected void a()
  {
    addStateTransfer(new bhfh(this).a(this.jdField_a_of_type_Bhfg).b(this.jdField_b_of_type_Bhfg).a(Integer.valueOf(3)));
    addStateTransfer(new bhfh(this).a(this.jdField_c_of_type_Bhfg).b(this.jdField_a_of_type_Bhfc).a(Integer.valueOf(5)));
    addStateTransfer(new bhfh(this).a(this.jdField_e_of_type_Bhfg).b(this.jdField_b_of_type_Bhfc).a(Integer.valueOf(6)));
    addStateTransfer(new bhfh(this).a(this.jdField_f_of_type_Bhfg).b(this.jdField_c_of_type_Bhfc).a(Integer.valueOf(7)));
    addStateTransfer(new bhfh(this).a(this.jdField_g_of_type_Bhfg).b(this.jdField_d_of_type_Bhfc).a(Integer.valueOf(8)));
    addStateTransfer(new bhfh(this).a(this.jdField_h_of_type_Bhfg).b(this.jdField_e_of_type_Bhfc).a(Integer.valueOf(9)));
    addStateTransfer(new bhfh(this).a(this.jdField_i_of_type_Bhfg).b(this.jdField_f_of_type_Bhfc).a(Integer.valueOf(10)));
    addStateTransfer(new bhfh(this).a(this.j).b(this.jdField_g_of_type_Bhfc).a(Integer.valueOf(11)));
    addStateTransfer(new bhfh(this).a(this.k).b(this.jdField_h_of_type_Bhfc).a(Integer.valueOf(12)));
    addStateTransfer(new bhfh(this).a(this.l).b(this.jdField_i_of_type_Bhfc).a(Integer.valueOf(13)));
    setCurrState(this.jdField_a_of_type_Bhfg);
  }
  
  public void a(int paramInt, String paramString)
  {
    a(String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramString }), null);
  }
  
  public void a(bgod parambgod)
  {
    if (parambgod == null) {
      return;
    }
    this.jdField_a_of_type_Bgod = parambgod;
    String str = a(parambgod);
    this.jdField_d_of_type_Bhfc.a(str);
    appendEvent(Integer.valueOf(8));
    str = AppLoaderFactory.g().getMiniAppEnv().getBaselibLoader().getBaselib().waConsoleJsStr;
    this.jdField_e_of_type_Bhfc.a(str);
    appendEvent(Integer.valueOf(9));
    parambgod = parambgod.d();
    this.jdField_f_of_type_Bhfc.a(parambgod);
    appendEvent(Integer.valueOf(10));
  }
  
  public void a(bhfy parambhfy)
  {
    this.jdField_a_of_type_Bhfy = parambhfy;
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview.setPageEventListener(parambhfy);
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
        this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview.evaluateJavascript(paramString1, bhiq.a(paramValueCallback));
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new BrandPageWebview.5(this, paramString1, paramValueCallback));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    paramString2 = this.jdField_a_of_type_Bgod.a().jdField_b_of_type_JavaLangString;
    this.jdField_g_of_type_Bhfc.a(paramString2);
    appendEvent(Integer.valueOf(11));
    paramString2 = this.jdField_a_of_type_Bgod.e(paramString1);
    this.jdField_h_of_type_Bhfc.a(paramString2);
    appendEvent(Integer.valueOf(12));
    paramString1 = this.jdField_a_of_type_Bgod.b(paramString1);
    this.jdField_i_of_type_Bhfc.a(paramString1);
    appendEvent(Integer.valueOf(13));
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer.a() != null) {
      bgor.a(new BrandPageWebview.7(this), 1000L);
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
      setCurrState(this.jdField_d_of_type_Bhfg);
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
    this.jdField_a_of_type_Bhfc.a(str);
    appendEvent(Integer.valueOf(5));
    AppLoaderFactory.g().getMiniAppEnv().getBaselibLoader().loadBaselib(this.jdField_a_of_type_Bglv.a(), new bhft(this));
  }
  
  public void setCurrState(bhfg parambhfg)
  {
    if ((parambhfg == this.m) && (this.jdField_a_of_type_Bhfy != null)) {
      this.jdField_a_of_type_Bhfy.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebview.b());
    }
    bhfg localbhfg = getCurrState();
    if (localbhfg == this.jdField_b_of_type_Bhfc) {
      bhck.a(this.jdField_a_of_type_Bglv.a(), 18, "0");
    }
    for (;;)
    {
      super.setCurrState(parambhfg);
      return;
      if (this.jdField_g_of_type_Bhfg == localbhfg) {
        bhck.a(this.jdField_a_of_type_Bglv.a(), 19, "0");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhfp
 * JD-Core Version:    0.7.0.1
 */