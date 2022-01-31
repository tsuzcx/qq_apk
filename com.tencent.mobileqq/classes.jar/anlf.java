import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.QQSchemeHandler.1;
import com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.QQSchemeHandler.2;
import com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.QQSchemeHandler.3;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class anlf
  implements anld
{
  private void a(String paramString1, String paramString2)
  {
    Map localMap;
    try
    {
      QLog.i("QQSchemeHandler", 1, "handleTogether " + paramString1 + paramString2);
      paramString1 = bhsz.a(paramString1);
      localMap = anla.a(new JSONObject(paramString2));
      Object localObject = localMap.get("type");
      if ((localObject == null) || (!(localObject instanceof String))) {
        break label165;
      }
      paramString2 = ((String)localObject).toLowerCase();
      if ("watch".equals(paramString2))
      {
        a(localMap, paramString1);
        return;
      }
      if ("sing".equals(paramString2))
      {
        b(localMap, paramString1);
        return;
      }
    }
    catch (Exception paramString1)
    {
      QLog.e("QQSchemeHandler", 1, paramString1, new Object[0]);
      return;
    }
    if ("listen".equals(paramString2))
    {
      c(localMap, paramString1);
      return;
    }
    QLog.i("QQSchemeHandler", 1, "handleTogether type no support" + paramString2);
    return;
    label165:
    QLog.i("QQSchemeHandler", 1, "handleTogether metaJson error" + paramString2);
  }
  
  private void a(Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    paramMap = new ArkAppSchemeCenter.QQSchemeHandler.1(this, paramMap, paramMap1);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManagerV2.getUIHandlerV2().post(paramMap);
      return;
    }
    paramMap.run();
  }
  
  private void b(Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    paramMap = new ArkAppSchemeCenter.QQSchemeHandler.2(this, paramMap, paramMap1);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManagerV2.getUIHandlerV2().post(paramMap);
      return;
    }
    paramMap.run();
  }
  
  private void c(Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    paramMap = new ArkAppSchemeCenter.QQSchemeHandler.3(this, paramMap, paramMap1);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManagerV2.getUIHandlerV2().post(paramMap);
      return;
    }
    paramMap.run();
  }
  
  protected QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  protected void a(String paramString)
  {
    String str1 = null;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    String str2;
    String str3;
    if ((localBaseActivity instanceof FragmentActivity))
    {
      str2 = "";
      str3 = "";
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (!localJSONObject.has("lat")) {
          break label196;
        }
        paramString = localJSONObject.getString("lat");
        if (localJSONObject.has("lon")) {
          str1 = localJSONObject.getString("lon");
        }
        if (localJSONObject.has("title")) {
          str2 = localJSONObject.getString("title");
        }
        if (localJSONObject.has("loc")) {
          str3 = localJSONObject.getString("loc");
        }
        if ((paramString == null) || (str1 == null)) {
          return;
        }
      }
      catch (JSONException paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ArkApp", 1, "QQ.showQMapView parameter error: " + paramString.getMessage());
        return;
      }
      paramString = bdib.a(a(), localBaseActivity, String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=%s&lon=%s&title=%s&loc=%s&dpid=null", new Object[] { paramString, str1, str2, str3 }));
      if (paramString != null)
      {
        paramString.c();
        return;
        label196:
        paramString = null;
      }
    }
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
  {
    // Byte code:
    //   0: lload 4
    //   2: lconst_0
    //   3: lcmp
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_1
    //   10: ldc 202
    //   12: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +66 -> 81
    //   18: getstatic 151	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   21: instanceof 153
    //   24: ifeq +55 -> 79
    //   27: getstatic 151	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   30: checkcast 153	android/support/v4/app/FragmentActivity
    //   33: invokevirtual 206	android/support/v4/app/FragmentActivity:getSupportFragmentManager	()Landroid/support/v4/app/FragmentManager;
    //   36: ldc 208
    //   38: invokevirtual 213	java/lang/Class:getName	()Ljava/lang/String;
    //   41: invokevirtual 219	android/support/v4/app/FragmentManager:findFragmentByTag	(Ljava/lang/String;)Landroid/support/v4/app/Fragment;
    //   44: checkcast 208	com/tencent/mobileqq/activity/ChatFragment
    //   47: checkcast 208	com/tencent/mobileqq/activity/ChatFragment
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull +27 -> 79
    //   55: aload_1
    //   56: invokevirtual 222	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +18 -> 79
    //   64: aload_1
    //   65: instanceof 224
    //   68: ifeq +11 -> 79
    //   71: aload_1
    //   72: checkcast 224	agti
    //   75: aload_2
    //   76: invokevirtual 227	agti:f	(Ljava/lang/String;)V
    //   79: iconst_1
    //   80: ireturn
    //   81: aload_1
    //   82: ldc 229
    //   84: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   87: ifeq +10 -> 97
    //   90: aload_0
    //   91: aload_2
    //   92: invokevirtual 231	anlf:a	(Ljava/lang/String;)V
    //   95: iconst_1
    //   96: ireturn
    //   97: ldc 233
    //   99: aload_1
    //   100: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   103: ifeq +31 -> 134
    //   106: aload_0
    //   107: invokevirtual 184	anlf:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   110: astore_1
    //   111: aload_1
    //   112: ifnull +20 -> 132
    //   115: aload_1
    //   116: sipush 153
    //   119: invokevirtual 237	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   122: checkcast 239	aknx
    //   125: invokevirtual 242	aknx:a	()Laknv;
    //   128: aload_2
    //   129: invokevirtual 245	aknv:a	(Ljava/lang/String;)V
    //   132: iconst_1
    //   133: ireturn
    //   134: ldc 247
    //   136: aload_1
    //   137: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   140: ifeq +125 -> 265
    //   143: new 43	org/json/JSONObject
    //   146: dup
    //   147: aload_2
    //   148: invokespecial 46	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   151: astore_1
    //   152: aload_1
    //   153: ldc 249
    //   155: invokevirtual 253	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   158: lstore 4
    //   160: aload_1
    //   161: ldc 255
    //   163: invokevirtual 253	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   166: lstore 7
    //   168: aload_1
    //   169: ldc_w 257
    //   172: invokevirtual 260	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   175: astore_1
    //   176: aload_0
    //   177: invokevirtual 184	anlf:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   180: astore_2
    //   181: aload_2
    //   182: ifnull +37 -> 219
    //   185: aload_2
    //   186: bipush 20
    //   188: invokevirtual 263	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   191: checkcast 265	amdu
    //   194: new 19	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   201: lload 4
    //   203: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   206: ldc 155
    //   208: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: lload 7
    //   216: invokevirtual 271	amdu:b	(Ljava/lang/String;J)V
    //   219: ldc_w 273
    //   222: ldc_w 275
    //   225: ldc_w 277
    //   228: iconst_1
    //   229: iconst_0
    //   230: iconst_1
    //   231: anewarray 61	java/lang/String
    //   234: dup
    //   235: iconst_0
    //   236: lload 4
    //   238: invokestatic 281	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   241: aastore
    //   242: invokestatic 286	bdes:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   245: getstatic 151	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   248: aload_1
    //   249: iconst_1
    //   250: invokestatic 291	nxu:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   253: iconst_0
    //   254: ireturn
    //   255: astore_2
    //   256: aconst_null
    //   257: astore_1
    //   258: aload_2
    //   259: invokevirtual 294	org/json/JSONException:printStackTrace	()V
    //   262: goto -17 -> 245
    //   265: ldc_w 296
    //   268: aload_1
    //   269: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   272: ifeq +13 -> 285
    //   275: invokestatic 301	anlr:a	()Lanlr;
    //   278: aload_2
    //   279: invokevirtual 302	anlr:a	(Ljava/lang/String;)V
    //   282: goto -29 -> 253
    //   285: ldc_w 304
    //   288: aload_1
    //   289: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   292: ifeq +43 -> 335
    //   295: aload_2
    //   296: invokestatic 305	bdes:a	(Ljava/lang/String;)V
    //   299: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq -49 -> 253
    //   305: ldc_w 307
    //   308: iconst_2
    //   309: new 19	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   316: ldc_w 309
    //   319: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_2
    //   323: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 312	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: goto -79 -> 253
    //   335: ldc_w 314
    //   338: aload_1
    //   339: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   342: ifeq +156 -> 498
    //   345: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   348: ifeq +30 -> 378
    //   351: ldc_w 316
    //   354: iconst_2
    //   355: new 19	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   362: ldc_w 318
    //   365: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: aload_2
    //   369: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 36	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: aload_0
    //   379: invokevirtual 184	anlf:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   382: astore_1
    //   383: aload_1
    //   384: ifnull -131 -> 253
    //   387: aload_1
    //   388: sipush 312
    //   391: invokevirtual 237	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   394: checkcast 320	axjs
    //   397: astore_1
    //   398: aload_1
    //   399: aload_2
    //   400: invokevirtual 321	axjs:a	(Ljava/lang/String;)V
    //   403: aload_1
    //   404: aload_2
    //   405: invokevirtual 324	axjs:a	(Ljava/lang/String;)Laosg;
    //   408: astore_1
    //   409: aload_1
    //   410: ifnull +53 -> 463
    //   413: aload_1
    //   414: getfield 329	aosg:b	Ljava/lang/String;
    //   417: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   420: ifne +43 -> 463
    //   423: invokestatic 340	bkfe:a	()Lbkfe;
    //   426: invokevirtual 342	bkfe:a	()Z
    //   429: ifeq +34 -> 463
    //   432: invokestatic 347	bkey:a	()Lbkey;
    //   435: invokevirtual 349	bkey:b	()V
    //   438: invokestatic 347	bkey:a	()Lbkey;
    //   441: invokevirtual 351	bkey:a	()V
    //   444: ldc_w 353
    //   447: iconst_1
    //   448: aconst_null
    //   449: invokestatic 358	bfxg:a	(Ljava/lang/String;ZLbfxf;)V
    //   452: invokestatic 340	bkfe:a	()Lbkfe;
    //   455: aload_1
    //   456: aconst_null
    //   457: invokevirtual 361	bkfe:a	(Laosg;Lbkej;)V
    //   460: goto -207 -> 253
    //   463: ldc_w 316
    //   466: iconst_1
    //   467: new 19	java/lang/StringBuilder
    //   470: dup
    //   471: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   474: ldc_w 363
    //   477: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: invokestatic 340	bkfe:a	()Lbkfe;
    //   483: invokevirtual 342	bkfe:a	()Z
    //   486: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   489: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 36	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   495: goto -242 -> 253
    //   498: ldc_w 368
    //   501: aload_1
    //   502: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   505: ifeq +206 -> 711
    //   508: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   511: ifeq +30 -> 541
    //   514: ldc_w 316
    //   517: iconst_2
    //   518: new 19	java/lang/StringBuilder
    //   521: dup
    //   522: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   525: ldc_w 370
    //   528: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: aload_2
    //   532: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 36	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   541: aload_0
    //   542: invokevirtual 184	anlf:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   545: astore_1
    //   546: aload_1
    //   547: ifnull -294 -> 253
    //   550: aload_1
    //   551: sipush 312
    //   554: invokevirtual 237	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   557: checkcast 320	axjs
    //   560: astore_3
    //   561: aload_3
    //   562: aload_2
    //   563: invokevirtual 324	axjs:a	(Ljava/lang/String;)Laosg;
    //   566: astore_1
    //   567: aload_1
    //   568: ifnull +103 -> 671
    //   571: aload_1
    //   572: getfield 329	aosg:b	Ljava/lang/String;
    //   575: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   578: ifne +93 -> 671
    //   581: invokestatic 340	bkfe:a	()Lbkfe;
    //   584: invokevirtual 342	bkfe:a	()Z
    //   587: ifeq +84 -> 671
    //   590: sipush 600
    //   593: invokestatic 373	bkey:a	(I)Z
    //   596: ifeq +62 -> 658
    //   599: new 375	android/content/Intent
    //   602: dup
    //   603: getstatic 151	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   606: ldc_w 377
    //   609: invokespecial 380	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   612: astore_2
    //   613: aload_2
    //   614: ldc_w 382
    //   617: aload_1
    //   618: getfield 329	aosg:b	Ljava/lang/String;
    //   621: invokevirtual 386	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   624: pop
    //   625: aload_2
    //   626: ldc_w 388
    //   629: aload_1
    //   630: getfield 390	aosg:c	Ljava/lang/String;
    //   633: invokevirtual 386	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   636: pop
    //   637: aload_2
    //   638: ldc_w 392
    //   641: ldc_w 394
    //   644: invokevirtual 386	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   647: pop
    //   648: getstatic 151	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   651: aload_2
    //   652: invokevirtual 398	com/tencent/mobileqq/app/BaseActivity:startActivity	(Landroid/content/Intent;)V
    //   655: goto -402 -> 253
    //   658: ldc_w 316
    //   661: iconst_1
    //   662: ldc_w 400
    //   665: invokestatic 36	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   668: goto -415 -> 253
    //   671: ldc_w 316
    //   674: iconst_1
    //   675: new 19	java/lang/StringBuilder
    //   678: dup
    //   679: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   682: ldc_w 402
    //   685: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: invokestatic 340	bkfe:a	()Lbkfe;
    //   691: invokevirtual 342	bkfe:a	()Z
    //   694: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   697: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokestatic 36	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   703: aload_3
    //   704: aload_2
    //   705: invokevirtual 404	axjs:b	(Ljava/lang/String;)V
    //   708: goto -455 -> 253
    //   711: aload_1
    //   712: ldc_w 406
    //   715: invokevirtual 409	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   718: ifeq -465 -> 253
    //   721: aload_0
    //   722: aload_1
    //   723: aload_2
    //   724: invokespecial 411	anlf:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   727: iconst_1
    //   728: ireturn
    //   729: astore_2
    //   730: goto -472 -> 258
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	733	0	this	anlf
    //   0	733	1	paramString1	String
    //   0	733	2	paramString2	String
    //   0	733	3	paramJSONObject	JSONObject
    //   0	733	4	paramLong	long
    //   0	733	6	paramString3	String
    //   166	49	7	l	long
    // Exception table:
    //   from	to	target	type
    //   143	176	255	org/json/JSONException
    //   176	181	729	org/json/JSONException
    //   185	219	729	org/json/JSONException
    //   219	245	729	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anlf
 * JD-Core Version:    0.7.0.1
 */