package com.tencent.mobileqq.activity.qwallet;

import Override;
import albw;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import anvx;
import bgyr;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class TenpayJumpActivity
  extends BaseActivity
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
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
      int j = paramContext.getResources().getDimensionPixelSize(2131299080);
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
          a(anvx.a(2131714223));
          finish();
          return;
        }
        if (!this.jdField_a_of_type_JavaLangString.equals(str1))
        {
          a(anvx.a(2131714224));
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
        albw.a(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.e, 1L, 0, "scanTransferLimmitQR", "", "");
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
    paramString5.append(bgyr.a());
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
    StatisticCollector.getInstance(BaseApplication.getContext()).reportToPCliOper(this.app, paramString5.toString());
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
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
        paramBundle = ContactUtils.getFriendShowName(this.app, this.g);
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
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iload_1
    //   1: ldc_w 390
    //   4: if_icmpne +63 -> 67
    //   7: new 208	android/content/Intent
    //   10: dup
    //   11: invokespecial 209	android/content/Intent:<init>	()V
    //   14: astore 5
    //   16: aload 5
    //   18: ldc 186
    //   20: aload_0
    //   21: getfield 211	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:d	Ljava/lang/String;
    //   24: invokevirtual 215	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   27: pop
    //   28: aload 5
    //   30: ldc 217
    //   32: iconst_5
    //   33: invokevirtual 220	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   36: pop
    //   37: aload_3
    //   38: ifnull +17 -> 55
    //   41: aload 5
    //   43: ldc 222
    //   45: aload_3
    //   46: ldc 222
    //   48: invokevirtual 343	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   51: invokevirtual 215	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   54: pop
    //   55: aload_0
    //   56: iconst_m1
    //   57: aload 5
    //   59: invokevirtual 226	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:setResult	(ILandroid/content/Intent;)V
    //   62: aload_0
    //   63: invokevirtual 167	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:finish	()V
    //   66: return
    //   67: aload_3
    //   68: ifnull -2 -> 66
    //   71: iload_2
    //   72: iconst_m1
    //   73: if_icmpne -7 -> 66
    //   76: aload_3
    //   77: ldc 222
    //   79: invokevirtual 343	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore_3
    //   83: aload_3
    //   84: ifnull +154 -> 238
    //   87: aload_3
    //   88: invokevirtual 115	java/lang/String:length	()I
    //   91: ifle +147 -> 238
    //   94: new 28	org/json/JSONObject
    //   97: dup
    //   98: aload_3
    //   99: invokespecial 348	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   102: astore_3
    //   103: aload_3
    //   104: ifnull +147 -> 251
    //   107: aload_3
    //   108: ldc_w 392
    //   111: invokevirtual 353	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: pop
    //   115: aload_3
    //   116: ldc 206
    //   118: iconst_m1
    //   119: invokevirtual 395	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   122: istore 4
    //   124: aload_3
    //   125: ldc_w 397
    //   128: invokevirtual 353	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: astore_3
    //   132: iload 4
    //   134: istore_2
    //   135: aload_3
    //   136: ifnull +115 -> 251
    //   139: iload 4
    //   141: istore_2
    //   142: aload_3
    //   143: invokevirtual 115	java/lang/String:length	()I
    //   146: ifle +105 -> 251
    //   149: new 28	org/json/JSONObject
    //   152: dup
    //   153: aload_3
    //   154: invokespecial 348	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   157: astore_3
    //   158: iload 4
    //   160: istore_2
    //   161: iload_2
    //   162: ifne +379 -> 541
    //   165: aload_3
    //   166: ifnull +375 -> 541
    //   169: iload_1
    //   170: tableswitch	default:+18 -> 188, 5:+19->189
    //   189: aload_3
    //   190: ldc_w 399
    //   193: invokevirtual 401	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   196: pop
    //   197: aload_3
    //   198: ldc_w 403
    //   201: invokevirtual 353	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   204: astore 6
    //   206: aload_0
    //   207: getfield 357	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:g	Ljava/lang/String;
    //   210: aload 6
    //   212: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: ifne +41 -> 256
    //   218: aload_0
    //   219: ldc_w 404
    //   222: invokestatic 161	anvx:a	(I)Ljava/lang/String;
    //   225: invokevirtual 164	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:a	(Ljava/lang/CharSequence;)V
    //   228: aload_0
    //   229: invokevirtual 167	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:finish	()V
    //   232: return
    //   233: astore_3
    //   234: aload_3
    //   235: invokevirtual 71	java/lang/Exception:printStackTrace	()V
    //   238: aconst_null
    //   239: astore_3
    //   240: goto -137 -> 103
    //   243: astore_3
    //   244: aload_3
    //   245: invokevirtual 71	java/lang/Exception:printStackTrace	()V
    //   248: iload 4
    //   250: istore_2
    //   251: aconst_null
    //   252: astore_3
    //   253: goto -92 -> 161
    //   256: aload_3
    //   257: ldc_w 406
    //   260: invokevirtual 353	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   263: astore 7
    //   265: aload_3
    //   266: ldc_w 408
    //   269: invokevirtual 353	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   272: pop
    //   273: aload_0
    //   274: aload_3
    //   275: ldc_w 410
    //   278: invokevirtual 353	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   281: ldc_w 412
    //   284: ldc_w 414
    //   287: invokevirtual 416	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   290: astore 8
    //   292: aload_3
    //   293: ldc_w 418
    //   296: invokevirtual 353	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   299: astore_3
    //   300: aload_0
    //   301: getfield 193	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   304: aload_0
    //   305: getfield 357	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:g	Ljava/lang/String;
    //   308: invokestatic 377	com/tencent/mobileqq/utils/ContactUtils:getFriendShowName	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   311: astore 5
    //   313: aload 5
    //   315: invokestatic 103	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   318: ifne +239 -> 557
    //   321: aload 5
    //   323: aload_0
    //   324: getfield 357	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:g	Ljava/lang/String;
    //   327: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   330: ifne +227 -> 557
    //   333: aload 5
    //   335: astore_3
    //   336: aload_3
    //   337: invokestatic 103	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   340: ifne +17 -> 357
    //   343: aload_3
    //   344: astore 5
    //   346: aload_3
    //   347: aload_0
    //   348: getfield 357	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:g	Ljava/lang/String;
    //   351: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   354: ifeq +9 -> 363
    //   357: aload_0
    //   358: getfield 361	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:h	Ljava/lang/String;
    //   361: astore 5
    //   363: new 208	android/content/Intent
    //   366: dup
    //   367: invokespecial 209	android/content/Intent:<init>	()V
    //   370: astore_3
    //   371: aload_3
    //   372: ldc_w 337
    //   375: aload_0
    //   376: getfield 43	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:jdField_a_of_type_Int	I
    //   379: invokevirtual 220	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   382: pop
    //   383: new 28	org/json/JSONObject
    //   386: dup
    //   387: invokespecial 29	org/json/JSONObject:<init>	()V
    //   390: astore 9
    //   392: aload 9
    //   394: ldc_w 420
    //   397: aload 6
    //   399: invokevirtual 37	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   402: pop
    //   403: aload 9
    //   405: ldc_w 422
    //   408: aload 5
    //   410: invokevirtual 37	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   413: pop
    //   414: aload 9
    //   416: ldc_w 406
    //   419: aload 7
    //   421: invokevirtual 37	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   424: pop
    //   425: aload 9
    //   427: ldc_w 424
    //   430: ldc 105
    //   432: invokevirtual 37	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   435: pop
    //   436: aload 9
    //   438: ldc_w 426
    //   441: aload_0
    //   442: getfield 371	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:i	Ljava/lang/String;
    //   445: invokevirtual 37	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   448: pop
    //   449: aload 9
    //   451: ldc_w 428
    //   454: aload 8
    //   456: ldc_w 430
    //   459: invokestatic 433	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   462: invokevirtual 37	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   465: pop
    //   466: aload_3
    //   467: ldc 52
    //   469: aload 9
    //   471: invokevirtual 56	org/json/JSONObject:toString	()Ljava/lang/String;
    //   474: invokevirtual 215	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   477: pop
    //   478: aload_3
    //   479: ldc_w 345
    //   482: aload_0
    //   483: getfield 50	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:e	Ljava/lang/String;
    //   486: invokevirtual 215	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   489: pop
    //   490: aload_3
    //   491: ldc 186
    //   493: aload_0
    //   494: getfield 211	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:d	Ljava/lang/String;
    //   497: invokevirtual 215	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   500: pop
    //   501: aload_3
    //   502: ldc_w 435
    //   505: iconst_1
    //   506: invokevirtual 438	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   509: pop
    //   510: aload_3
    //   511: aload_0
    //   512: getfield 237	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   515: ldc_w 440
    //   518: invokevirtual 444	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   521: pop
    //   522: aload_0
    //   523: aload_3
    //   524: ldc_w 390
    //   527: invokevirtual 448	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   530: return
    //   531: astore 5
    //   533: aload 5
    //   535: invokevirtual 449	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   538: goto -72 -> 466
    //   541: aload_0
    //   542: iconst_m1
    //   543: aconst_null
    //   544: invokevirtual 67	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:a	(ILandroid/os/Bundle;)V
    //   547: aload_0
    //   548: invokevirtual 167	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:finish	()V
    //   551: return
    //   552: astore 5
    //   554: goto -88 -> 466
    //   557: goto -221 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	560	0	this	TenpayJumpActivity
    //   0	560	1	paramInt1	int
    //   0	560	2	paramInt2	int
    //   0	560	3	paramIntent	Intent
    //   122	127	4	j	int
    //   14	395	5	localObject	Object
    //   531	3	5	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   552	1	5	localJSONException	JSONException
    //   204	194	6	str1	String
    //   263	157	7	str2	String
    //   290	165	8	str3	String
    //   390	80	9	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   94	103	233	java/lang/Exception
    //   149	158	243	java/lang/Exception
    //   392	466	531	java/io/UnsupportedEncodingException
    //   392	466	552	org/json/JSONException
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TenpayJumpActivity
 * JD-Core Version:    0.7.0.1
 */