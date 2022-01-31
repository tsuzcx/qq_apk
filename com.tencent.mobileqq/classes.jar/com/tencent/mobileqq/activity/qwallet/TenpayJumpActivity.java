package com.tencent.mobileqq.activity.qwallet;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class TenpayJumpActivity
  extends BaseActivity
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private QWalletPayProgressDialog jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  
  private void a(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("userId", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("viewTag", paramString1);
      localJSONObject.put("comeForm", this.jdField_a_of_type_Int);
      localJSONObject.put("appInfo", this.e);
      localJSONObject.put("extra_data", paramString2);
      PayBridgeActivity.tenpay(this, localJSONObject.toString(), 5, "0");
      return;
    }
    catch (JSONException paramString1)
    {
      a(-1, null);
      paramString1.printStackTrace();
      return;
    }
    catch (Exception paramString1)
    {
      a(-1, null);
      paramString1.printStackTrace();
    }
  }
  
  public int a(Context paramContext)
  {
    try
    {
      int j = paramContext.getResources().getDimensionPixelSize(2131558448);
      float f1 = paramContext.getResources().getDisplayMetrics().density;
      return j - (int)(f1 * 5.0F);
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public String a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1))) {}
    int j;
    int m;
    do
    {
      return "";
      j = paramString1.indexOf(paramString2);
      m = paramString2.length() + j;
      int k = paramString1.indexOf(paramString3, m);
      j = k;
      if (k == -1) {
        j = paramString1.length();
      }
    } while ((m == -1) || (m >= paramString1.length()) || (j == -1));
    return paramString1.substring(m, j);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = new QWalletPayProgressDialog(this);
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject2 = Uri.parse(this.f);
      Object localObject1 = ((Uri)localObject2).getQueryParameter("dy");
      String str1 = ((Uri)localObject2).getQueryParameter("su");
      String str2 = ((Uri)localObject2).getQueryParameter("u");
      localObject2 = URLDecoder.decode(((Uri)localObject2).getQueryParameter("ac"));
      localJSONObject.put("auth_code", localObject2);
      if ("1".equals(localObject1))
      {
        if (this.jdField_a_of_type_JavaLangString.equals(str2))
        {
          a("不能给自己转账！");
          finish();
          return;
        }
        if (!this.jdField_a_of_type_JavaLangString.equals(str1))
        {
          a("无效的二维码！");
          finish();
          return;
        }
        localObject1 = localObject2;
        if (((String)localObject2).startsWith("*")) {
          localObject1 = ((String)localObject2).substring(1, ((String)localObject2).length());
        }
        localJSONObject.put("tokenId", localObject1);
        localJSONObject.put("dy", "1");
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("json", localJSONObject.toString());
        ((Bundle)localObject1).putString("callbackSn", "0");
        PayBridgeActivity.a(this, 9, (Bundle)localObject1);
        QWalletTools.a(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.e, 1L, 0, "scanTransferLimmitQR", "", "");
        return;
      }
      a("verifyqrcode", localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {
      new Bundle();
    }
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("resultCode", paramInt);
      label28:
      Intent localIntent = new Intent();
      localIntent.putExtra("callbackSn", this.d);
      localIntent.putExtra("PayInvokerId", 5);
      localIntent.putExtra("result", paramBundle.toString());
      setResult(-1, localIntent);
      return;
    }
    catch (Exception localException)
    {
      break label28;
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (!isFinishing()) {
      QQToast.a(this, paramCharSequence, 0).b(a(this.jdField_a_of_type_AndroidContentContext));
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    paramString5 = new StringBuilder();
    paramString5.append("Tenpay_mqq");
    paramString5.append("|");
    paramString5.append(paramString1);
    paramString5.append("||");
    paramString5.append(paramInt1);
    paramString5.append("|");
    paramString5.append(paramString2);
    paramString5.append("|0|1|0|android.");
    paramString5.append(6);
    paramString5.append("|");
    paramString5.append(CommonUtil.a());
    paramString5.append("|");
    if ((!TextUtils.isEmpty(paramString3)) || (!TextUtils.isEmpty(paramString4)))
    {
      paramString5.append(paramString3);
      paramString5.append(".");
      paramString5.append(paramString4);
    }
    paramString5.append("|");
    paramString5.append(paramInt2);
    paramString5.append(".");
    if (!TextUtils.isEmpty(this.e)) {
      paramString5.append(this.e.replace("|", ","));
    }
    paramString5.append("|");
    StatisticCollector.a(BaseApplication.getContext()).b(this.app, paramString5.toString());
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setProgressBarIndeterminateVisibility(false);
    setRequestedOrientation(1);
    this.jdField_a_of_type_AndroidContentContext = this;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
        this.b = this.app.getCurrentNickname();
        this.c = "2";
        this.jdField_a_of_type_Int = getIntent().getIntExtra("come_from", 5);
        this.d = getIntent().getStringExtra("callbackSn");
        this.e = getIntent().getStringExtra("app_info");
        paramBundle = new JSONObject(getIntent().getStringExtra("extra_data"));
        this.f = paramBundle.optString("url");
        this.g = paramBundle.optString("uin");
        this.h = paramBundle.optString("name");
        String str = paramBundle.optString("url");
        int j = str.indexOf("&f=");
        paramBundle = str;
        if (j > 0)
        {
          str = str.substring(j + 3);
          j = str.indexOf('&');
          paramBundle = str;
          if (j > 0) {
            paramBundle = str.substring(0, j);
          }
        }
        if (!"wallet".equals(paramBundle)) {
          continue;
        }
        this.i = "1";
        paramBundle = ContactUtils.n(this.app, this.g);
        if ((!TextUtils.isEmpty(paramBundle)) && (!paramBundle.equals(this.g))) {
          this.h = paramBundle;
        }
        a();
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        continue;
      }
      a(this.jdField_a_of_type_JavaLangString, 128, "scan.qrcode.loading", "", "", this.jdField_a_of_type_Int, "");
      return true;
      if ("apw".equals(paramBundle)) {
        this.i = "2";
      }
    }
  }
  
  /* Error */
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iload_1
    //   1: ldc_w 382
    //   4: if_icmpne +63 -> 67
    //   7: new 216	android/content/Intent
    //   10: dup
    //   11: invokespecial 217	android/content/Intent:<init>	()V
    //   14: astore 4
    //   16: aload 4
    //   18: ldc 194
    //   20: aload_0
    //   21: getfield 219	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:d	Ljava/lang/String;
    //   24: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   27: pop
    //   28: aload 4
    //   30: ldc 225
    //   32: iconst_5
    //   33: invokevirtual 228	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   36: pop
    //   37: aload_3
    //   38: ifnull +17 -> 55
    //   41: aload 4
    //   43: ldc 230
    //   45: aload_3
    //   46: ldc 230
    //   48: invokevirtual 334	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   51: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   54: pop
    //   55: aload_0
    //   56: iconst_m1
    //   57: aload 4
    //   59: invokevirtual 234	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:setResult	(ILandroid/content/Intent;)V
    //   62: aload_0
    //   63: invokevirtual 174	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:finish	()V
    //   66: return
    //   67: aload_3
    //   68: ifnull -2 -> 66
    //   71: iload_2
    //   72: iconst_m1
    //   73: if_icmpne -7 -> 66
    //   76: aload_3
    //   77: ldc 230
    //   79: invokevirtual 334	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore_3
    //   83: aload_3
    //   84: ifnull +151 -> 235
    //   87: aload_3
    //   88: invokevirtual 116	java/lang/String:length	()I
    //   91: ifle +144 -> 235
    //   94: new 29	org/json/JSONObject
    //   97: dup
    //   98: aload_3
    //   99: invokespecial 339	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   102: astore_3
    //   103: aload_3
    //   104: ifnull +482 -> 586
    //   107: aload_3
    //   108: ldc_w 384
    //   111: invokevirtual 344	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: astore 4
    //   116: aload_3
    //   117: ldc 214
    //   119: iconst_m1
    //   120: invokevirtual 387	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   123: istore_2
    //   124: aload_3
    //   125: ldc_w 389
    //   128: invokevirtual 344	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: astore_3
    //   132: aload_3
    //   133: ifnull +112 -> 245
    //   136: aload_3
    //   137: invokevirtual 116	java/lang/String:length	()I
    //   140: ifle +105 -> 245
    //   143: new 29	org/json/JSONObject
    //   146: dup
    //   147: aload_3
    //   148: invokespecial 339	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   151: astore_3
    //   152: aload_0
    //   153: getfield 130	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog	Lcooperation/qwallet/plugin/QWalletPayProgressDialog;
    //   156: invokevirtual 392	cooperation/qwallet/plugin/QWalletPayProgressDialog:dismiss	()V
    //   159: iload_2
    //   160: ifne +375 -> 535
    //   163: aload_3
    //   164: ifnull +371 -> 535
    //   167: iload_1
    //   168: tableswitch	default:+20 -> 188, 5:+21->189
    //   189: aload_3
    //   190: ldc_w 394
    //   193: invokevirtual 396	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   196: pop
    //   197: aload_3
    //   198: ldc_w 398
    //   201: invokevirtual 344	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   204: astore 5
    //   206: aload_0
    //   207: getfield 348	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:g	Ljava/lang/String;
    //   210: aload 5
    //   212: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: ifne +35 -> 250
    //   218: aload_0
    //   219: ldc_w 400
    //   222: invokevirtual 171	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:a	(Ljava/lang/CharSequence;)V
    //   225: aload_0
    //   226: invokevirtual 174	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:finish	()V
    //   229: return
    //   230: astore_3
    //   231: aload_3
    //   232: invokevirtual 72	java/lang/Exception:printStackTrace	()V
    //   235: aconst_null
    //   236: astore_3
    //   237: goto -134 -> 103
    //   240: astore_3
    //   241: aload_3
    //   242: invokevirtual 72	java/lang/Exception:printStackTrace	()V
    //   245: aconst_null
    //   246: astore_3
    //   247: goto -95 -> 152
    //   250: aload_3
    //   251: ldc_w 402
    //   254: invokevirtual 344	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   257: astore 6
    //   259: aload_3
    //   260: ldc_w 404
    //   263: invokevirtual 344	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   266: pop
    //   267: aload_0
    //   268: aload_3
    //   269: ldc_w 406
    //   272: invokevirtual 344	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   275: ldc_w 408
    //   278: ldc_w 410
    //   281: invokevirtual 412	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   284: astore 7
    //   286: aload_3
    //   287: ldc_w 414
    //   290: invokevirtual 344	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   293: astore_3
    //   294: aload_0
    //   295: getfield 201	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   298: aload_0
    //   299: getfield 348	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:g	Ljava/lang/String;
    //   302: invokestatic 369	com/tencent/mobileqq/utils/ContactUtils:n	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   305: astore 4
    //   307: aload 4
    //   309: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   312: ifne +271 -> 583
    //   315: aload 4
    //   317: aload_0
    //   318: getfield 348	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:g	Ljava/lang/String;
    //   321: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   324: ifne +259 -> 583
    //   327: aload 4
    //   329: astore_3
    //   330: aload_3
    //   331: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   334: ifne +17 -> 351
    //   337: aload_3
    //   338: astore 4
    //   340: aload_3
    //   341: aload_0
    //   342: getfield 348	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:g	Ljava/lang/String;
    //   345: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   348: ifeq +9 -> 357
    //   351: aload_0
    //   352: getfield 352	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:h	Ljava/lang/String;
    //   355: astore 4
    //   357: new 216	android/content/Intent
    //   360: dup
    //   361: invokespecial 217	android/content/Intent:<init>	()V
    //   364: astore_3
    //   365: aload_3
    //   366: ldc_w 328
    //   369: aload_0
    //   370: getfield 44	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:jdField_a_of_type_Int	I
    //   373: invokevirtual 228	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   376: pop
    //   377: new 29	org/json/JSONObject
    //   380: dup
    //   381: invokespecial 30	org/json/JSONObject:<init>	()V
    //   384: astore 8
    //   386: aload 8
    //   388: ldc_w 416
    //   391: aload 5
    //   393: invokevirtual 38	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   396: pop
    //   397: aload 8
    //   399: ldc_w 418
    //   402: aload 4
    //   404: invokevirtual 38	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   407: pop
    //   408: aload 8
    //   410: ldc_w 402
    //   413: aload 6
    //   415: invokevirtual 38	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   418: pop
    //   419: aload 8
    //   421: ldc_w 420
    //   424: ldc 106
    //   426: invokevirtual 38	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   429: pop
    //   430: aload 8
    //   432: ldc_w 422
    //   435: aload_0
    //   436: getfield 363	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:i	Ljava/lang/String;
    //   439: invokevirtual 38	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   442: pop
    //   443: aload 8
    //   445: ldc_w 424
    //   448: aload 7
    //   450: ldc_w 426
    //   453: invokestatic 429	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   456: invokevirtual 38	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   459: pop
    //   460: aload_3
    //   461: ldc 53
    //   463: aload 8
    //   465: invokevirtual 57	org/json/JSONObject:toString	()Ljava/lang/String;
    //   468: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   471: pop
    //   472: aload_3
    //   473: ldc_w 336
    //   476: aload_0
    //   477: getfield 51	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:e	Ljava/lang/String;
    //   480: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   483: pop
    //   484: aload_3
    //   485: ldc 194
    //   487: aload_0
    //   488: getfield 219	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:d	Ljava/lang/String;
    //   491: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   494: pop
    //   495: aload_3
    //   496: ldc_w 431
    //   499: iconst_1
    //   500: invokevirtual 434	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   503: pop
    //   504: aload_3
    //   505: aload_0
    //   506: getfield 245	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   509: ldc_w 436
    //   512: invokevirtual 440	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   515: pop
    //   516: aload_0
    //   517: aload_3
    //   518: ldc_w 382
    //   521: invokevirtual 444	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   524: return
    //   525: astore 4
    //   527: aload 4
    //   529: invokevirtual 445	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   532: goto -72 -> 460
    //   535: aload_0
    //   536: ldc_w 446
    //   539: invokevirtual 449	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:getString	(I)Ljava/lang/String;
    //   542: astore_3
    //   543: aload 4
    //   545: ifnull +20 -> 565
    //   548: aload_0
    //   549: aload 4
    //   551: invokevirtual 171	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:a	(Ljava/lang/CharSequence;)V
    //   554: aload_0
    //   555: iconst_m1
    //   556: aconst_null
    //   557: invokevirtual 68	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:a	(ILandroid/os/Bundle;)V
    //   560: aload_0
    //   561: invokevirtual 174	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:finish	()V
    //   564: return
    //   565: aload_0
    //   566: aload_3
    //   567: invokevirtual 171	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:a	(Ljava/lang/CharSequence;)V
    //   570: goto -16 -> 554
    //   573: astore 4
    //   575: goto -115 -> 460
    //   578: astore 5
    //   580: goto -421 -> 159
    //   583: goto -253 -> 330
    //   586: aconst_null
    //   587: astore_3
    //   588: aconst_null
    //   589: astore 4
    //   591: goto -439 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	this	TenpayJumpActivity
    //   0	594	1	paramInt1	int
    //   0	594	2	paramInt2	int
    //   0	594	3	paramIntent	Intent
    //   14	389	4	localObject1	Object
    //   525	25	4	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   573	1	4	localJSONException	JSONException
    //   589	1	4	localObject2	Object
    //   204	188	5	str1	String
    //   578	1	5	localException	Exception
    //   257	157	6	str2	String
    //   284	165	7	str3	String
    //   384	80	8	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   94	103	230	java/lang/Exception
    //   143	152	240	java/lang/Exception
    //   386	460	525	java/io/UnsupportedEncodingException
    //   386	460	573	org/json/JSONException
    //   152	159	578	java/lang/Exception
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TenpayJumpActivity
 * JD-Core Version:    0.7.0.1
 */