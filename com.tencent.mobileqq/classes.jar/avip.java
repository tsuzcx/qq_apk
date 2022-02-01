import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class avip
  extends WebViewPlugin
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  protected aanz a;
  protected BroadcastReceiver a;
  protected Context a;
  private Handler jdField_a_of_type_AndroidOsHandler = new avir(this, Looper.getMainLooper());
  protected String a;
  private int b;
  protected String b;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  
  public avip()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aviq(this);
    this.mPluginNameSpace = "huayang";
  }
  
  public static String a(String paramString)
  {
    return "com.tencent.mobileqq.intervideo.huayang.downloadPreLoad" + paramString;
  }
  
  private JSONObject a(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("state", Integer.valueOf(paramInt));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  private void a()
  {
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HuayangJsPlugin", 2, paramString);
    }
  }
  
  public static boolean a(String paramString)
  {
    return TextUtils.equals(paramString, "com.tencent.od");
  }
  
  public static String b(String paramString)
  {
    return "com.tencent.mobileqq.intervideo.backPressed" + paramString;
  }
  
  public static boolean b(String paramString)
  {
    return TextUtils.equals(paramString, "com.tencent.huayang");
  }
  
  public static String c(String paramString)
  {
    return "com.tencent.mobileqq.intervideo.userCacheState" + paramString;
  }
  
  public static String d(String paramString)
  {
    return "com.tencent.mobileqq.huayang.launcher" + paramString;
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 43
    //   2: aload_3
    //   3: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifne +14 -> 20
    //   9: ldc 148
    //   11: aload_3
    //   12: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifne +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: new 58	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   27: ldc 150
    //   29: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload 4
    //   34: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 152
    //   39: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: astore_2
    //   43: aload 5
    //   45: ifnull +299 -> 344
    //   48: aload 5
    //   50: arraylength
    //   51: ifle +293 -> 344
    //   54: aload 5
    //   56: iconst_0
    //   57: aaload
    //   58: astore_1
    //   59: aload_0
    //   60: aload_2
    //   61: aload_1
    //   62: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokespecial 107	avip:a	(Ljava/lang/String;)V
    //   71: ldc 154
    //   73: aload 4
    //   75: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: ifeq +510 -> 588
    //   81: ldc 156
    //   83: invokestatic 159	avjb:a	(Ljava/lang/String;)V
    //   86: aconst_null
    //   87: astore 4
    //   89: aconst_null
    //   90: astore 8
    //   92: aconst_null
    //   93: astore 9
    //   95: aconst_null
    //   96: astore 10
    //   98: aload 8
    //   100: astore_3
    //   101: aload 9
    //   103: astore_2
    //   104: aload 10
    //   106: astore_1
    //   107: aload 5
    //   109: ifnull +351 -> 460
    //   112: aload 8
    //   114: astore_3
    //   115: aload 9
    //   117: astore_2
    //   118: aload 10
    //   120: astore_1
    //   121: aload 5
    //   123: arraylength
    //   124: ifle +336 -> 460
    //   127: aload 4
    //   129: astore_1
    //   130: new 74	org/json/JSONObject
    //   133: dup
    //   134: aload 5
    //   136: iconst_0
    //   137: aaload
    //   138: invokespecial 161	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   141: astore 5
    //   143: aload 4
    //   145: astore_1
    //   146: aload 5
    //   148: ldc 163
    //   150: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   153: astore_3
    //   154: aload_3
    //   155: astore_1
    //   156: aload 5
    //   158: ldc 168
    //   160: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   163: astore_2
    //   164: aload_2
    //   165: astore_1
    //   166: aload_0
    //   167: aload 5
    //   169: ldc 170
    //   171: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   174: putfield 172	avip:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   177: aload_0
    //   178: aload 5
    //   180: ldc 174
    //   182: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   185: putfield 55	avip:d	Ljava/lang/String;
    //   188: aload_0
    //   189: aload 5
    //   191: ldc 176
    //   193: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   196: putfield 178	avip:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   199: aload 5
    //   201: ldc 180
    //   203: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore 4
    //   208: aload_0
    //   209: aload 5
    //   211: ldc 182
    //   213: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   216: putfield 184	avip:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   219: aload 5
    //   221: ldc 186
    //   223: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   226: astore_2
    //   227: aload 5
    //   229: ldc 188
    //   231: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   234: astore 8
    //   236: aload 5
    //   238: ldc 190
    //   240: invokevirtual 194	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   243: i2l
    //   244: lstore 6
    //   246: aload 8
    //   248: invokestatic 198	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   251: ifne +99 -> 350
    //   254: new 200	android/content/Intent
    //   257: dup
    //   258: aload_0
    //   259: getfield 97	avip:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   262: ldc 202
    //   264: invokespecial 205	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   267: astore_2
    //   268: aload_2
    //   269: ldc 190
    //   271: lload 6
    //   273: invokevirtual 209	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   276: pop
    //   277: aload_2
    //   278: ldc 211
    //   280: aload_0
    //   281: getfield 184	avip:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   284: invokevirtual 214	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   287: pop
    //   288: aload_2
    //   289: ldc 176
    //   291: aload_0
    //   292: getfield 178	avip:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   295: invokevirtual 214	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   298: pop
    //   299: aload_2
    //   300: ldc 180
    //   302: aload 4
    //   304: invokevirtual 214	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   307: pop
    //   308: aload_2
    //   309: ldc 174
    //   311: aload_0
    //   312: getfield 55	avip:d	Ljava/lang/String;
    //   315: invokevirtual 214	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   318: pop
    //   319: aload_2
    //   320: ldc 168
    //   322: aload_1
    //   323: invokevirtual 214	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   326: pop
    //   327: aload_2
    //   328: ldc 215
    //   330: invokevirtual 219	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   333: pop
    //   334: aload_0
    //   335: getfield 97	avip:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   338: aload_2
    //   339: invokevirtual 223	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   342: iconst_1
    //   343: ireturn
    //   344: ldc 225
    //   346: astore_1
    //   347: goto -288 -> 59
    //   350: aload_0
    //   351: getfield 97	avip:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   354: aload_0
    //   355: getfield 184	avip:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   358: aload_2
    //   359: invokestatic 230	avjc:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   362: aload_1
    //   363: astore_2
    //   364: aload_1
    //   365: ifnull +10 -> 375
    //   368: aload_1
    //   369: ldc 232
    //   371: invokestatic 238	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   374: astore_2
    //   375: aload 4
    //   377: astore_1
    //   378: aload_0
    //   379: getfield 178	avip:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   382: invokestatic 198	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   385: ifeq +9 -> 394
    //   388: aload_0
    //   389: ldc 133
    //   391: putfield 178	avip:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   394: new 240	android/content/IntentFilter
    //   397: dup
    //   398: aload_0
    //   399: getfield 178	avip:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   402: invokestatic 242	avip:a	(Ljava/lang/String;)Ljava/lang/String;
    //   405: invokespecial 243	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   408: astore 4
    //   410: aload 4
    //   412: aload_0
    //   413: getfield 178	avip:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   416: invokestatic 245	avip:b	(Ljava/lang/String;)Ljava/lang/String;
    //   419: invokevirtual 248	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   422: aload 4
    //   424: aload_0
    //   425: getfield 178	avip:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   428: invokestatic 250	avip:c	(Ljava/lang/String;)Ljava/lang/String;
    //   431: invokevirtual 248	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   434: aload 4
    //   436: aload_0
    //   437: getfield 178	avip:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   440: invokestatic 252	avip:d	(Ljava/lang/String;)Ljava/lang/String;
    //   443: invokevirtual 248	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   446: aload_0
    //   447: getfield 97	avip:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   450: aload_0
    //   451: getfield 28	avip:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   454: aload 4
    //   456: invokevirtual 256	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   459: pop
    //   460: aload_0
    //   461: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   464: putfield 264	avip:jdField_a_of_type_Long	J
    //   467: aload_0
    //   468: getfield 266	avip:jdField_a_of_type_Aanz	Laanz;
    //   471: aload_0
    //   472: getfield 184	avip:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   475: aload_3
    //   476: aload_2
    //   477: aload_0
    //   478: getfield 55	avip:d	Ljava/lang/String;
    //   481: aload_0
    //   482: getfield 178	avip:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   485: aload_1
    //   486: invokevirtual 271	aanz:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   489: ldc 43
    //   491: ldc_w 273
    //   494: aload_0
    //   495: getfield 51	avip:jdField_b_of_type_Int	I
    //   498: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   501: aload_0
    //   502: getfield 264	avip:jdField_a_of_type_Long	J
    //   505: lsub
    //   506: l2i
    //   507: iconst_4
    //   508: anewarray 143	java/lang/String
    //   511: dup
    //   512: iconst_0
    //   513: aload_0
    //   514: getfield 55	avip:d	Ljava/lang/String;
    //   517: aastore
    //   518: dup
    //   519: iconst_1
    //   520: aconst_null
    //   521: aastore
    //   522: dup
    //   523: iconst_2
    //   524: aload_0
    //   525: getfield 178	avip:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   528: aastore
    //   529: dup
    //   530: iconst_3
    //   531: ldc_w 275
    //   534: aastore
    //   535: invokestatic 280	yqu:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   538: iconst_1
    //   539: ireturn
    //   540: astore_2
    //   541: aload_2
    //   542: invokevirtual 281	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   545: aconst_null
    //   546: astore_2
    //   547: goto -172 -> 375
    //   550: astore 4
    //   552: aconst_null
    //   553: astore_2
    //   554: aconst_null
    //   555: astore 5
    //   557: aload_1
    //   558: astore_3
    //   559: aload 5
    //   561: astore_1
    //   562: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   565: ifeq +15 -> 580
    //   568: ldc 115
    //   570: iconst_2
    //   571: aload 4
    //   573: iconst_0
    //   574: anewarray 283	java/lang/Object
    //   577: invokestatic 287	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   580: aload 4
    //   582: invokestatic 292	avik:a	(Ljava/lang/Throwable;)V
    //   585: goto -207 -> 378
    //   588: ldc_w 294
    //   591: aload 4
    //   593: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   596: ifeq +153 -> 749
    //   599: aload_0
    //   600: getfield 266	avip:jdField_a_of_type_Aanz	Laanz;
    //   603: aload_0
    //   604: getfield 178	avip:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   607: aload_0
    //   608: getfield 184	avip:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   611: invokevirtual 297	aanz:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   614: aload_0
    //   615: getfield 178	avip:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   618: invokestatic 299	avip:a	(Ljava/lang/String;)Z
    //   621: ifeq +67 -> 688
    //   624: ldc_w 301
    //   627: invokestatic 159	avjb:a	(Ljava/lang/String;)V
    //   630: aload_0
    //   631: invokespecial 303	avip:a	()V
    //   634: ldc 43
    //   636: ldc_w 294
    //   639: aload_0
    //   640: getfield 51	avip:jdField_b_of_type_Int	I
    //   643: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   646: aload_0
    //   647: getfield 264	avip:jdField_a_of_type_Long	J
    //   650: lsub
    //   651: l2i
    //   652: iconst_4
    //   653: anewarray 143	java/lang/String
    //   656: dup
    //   657: iconst_0
    //   658: aload_0
    //   659: getfield 21	avip:jdField_a_of_type_Int	I
    //   662: invokestatic 306	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   665: aastore
    //   666: dup
    //   667: iconst_1
    //   668: aconst_null
    //   669: aastore
    //   670: dup
    //   671: iconst_2
    //   672: aload_0
    //   673: getfield 178	avip:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   676: aastore
    //   677: dup
    //   678: iconst_3
    //   679: ldc_w 275
    //   682: aastore
    //   683: invokestatic 280	yqu:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   686: iconst_0
    //   687: ireturn
    //   688: aload_0
    //   689: getfield 178	avip:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   692: invokestatic 308	avip:b	(Ljava/lang/String;)Z
    //   695: ifeq +12 -> 707
    //   698: ldc_w 310
    //   701: invokestatic 159	avjb:a	(Ljava/lang/String;)V
    //   704: goto -74 -> 630
    //   707: getstatic 313	avjc:a	Ljava/util/Map;
    //   710: aload_0
    //   711: getfield 184	avip:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   714: invokeinterface 319 2 0
    //   719: ifnull -89 -> 630
    //   722: getstatic 313	avjc:a	Ljava/util/Map;
    //   725: aload_0
    //   726: getfield 184	avip:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   729: invokeinterface 319 2 0
    //   734: checkcast 227	avjc
    //   737: getfield 322	avjc:h	I
    //   740: invokestatic 306	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   743: invokestatic 324	avjb:b	(Ljava/lang/String;)V
    //   746: goto -116 -> 630
    //   749: ldc_w 326
    //   752: aload 4
    //   754: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   757: ifeq -71 -> 686
    //   760: new 200	android/content/Intent
    //   763: dup
    //   764: aload_0
    //   765: getfield 97	avip:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   768: ldc 202
    //   770: invokespecial 205	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   773: astore_1
    //   774: aload_1
    //   775: ldc 215
    //   777: invokevirtual 219	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   780: pop
    //   781: aload_1
    //   782: ldc_w 328
    //   785: aload 5
    //   787: iconst_0
    //   788: aaload
    //   789: invokevirtual 214	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   792: pop
    //   793: aload_1
    //   794: ldc_w 330
    //   797: iconst_1
    //   798: invokevirtual 333	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   801: pop
    //   802: aload_0
    //   803: getfield 97	avip:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   806: aload_1
    //   807: invokevirtual 223	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   810: goto -124 -> 686
    //   813: astore 4
    //   815: aload_1
    //   816: astore_2
    //   817: aconst_null
    //   818: astore_1
    //   819: goto -257 -> 562
    //   822: astore 5
    //   824: aload_1
    //   825: astore_2
    //   826: aload 4
    //   828: astore_1
    //   829: aload 5
    //   831: astore 4
    //   833: goto -271 -> 562
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	836	0	this	avip
    //   0	836	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	836	2	paramString1	String
    //   0	836	3	paramString2	String
    //   0	836	4	paramString3	String
    //   0	836	5	paramVarArgs	String[]
    //   244	28	6	l	long
    //   90	157	8	str	String
    //   93	23	9	localObject1	java.lang.Object
    //   96	23	10	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   368	375	540	java/io/UnsupportedEncodingException
    //   130	143	550	org/json/JSONException
    //   146	154	550	org/json/JSONException
    //   156	164	550	org/json/JSONException
    //   166	208	813	org/json/JSONException
    //   208	342	822	org/json/JSONException
    //   350	362	822	org/json/JSONException
    //   368	375	822	org/json/JSONException
    //   541	545	822	org/json/JSONException
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_Aanz = aanz.a();
    this.jdField_a_of_type_Aanz.a();
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a().getApplicationContext();
    a(" onCreate");
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Aanz != null)
    {
      this.jdField_a_of_type_Aanz.c(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_Aanz.b();
    }
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("HuayangJsPlugin", 2, " onDestroy");
    }
    avjb.a("2597860");
    a();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avip
 * JD-Core Version:    0.7.0.1
 */