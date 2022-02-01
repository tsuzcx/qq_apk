package com.tencent.biz.subscribe.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;
import java.net.URLEncoder;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;

public class EvilReportUtil
{
  private static String a(EvilReportUtil.EvilReportParams paramEvilReportParams, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramEvilReportParams.a);
    localStringBuilder.append("_");
    localStringBuilder.append(paramEvilReportParams.b);
    localStringBuilder.append("_");
    localStringBuilder.append(paramEvilReportParams.h);
    localStringBuilder.append("_");
    localStringBuilder.append(a(paramString));
    paramString = MD5.a(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramEvilReportParams.d);
    localStringBuilder.append("_");
    localStringBuilder.append(paramEvilReportParams.k);
    localStringBuilder.append("_");
    localStringBuilder.append(paramEvilReportParams.l);
    localStringBuilder.append("_");
    localStringBuilder.append(paramEvilReportParams.m);
    localStringBuilder.append("_");
    localStringBuilder.append(paramEvilReportParams.n);
    localStringBuilder.append("_");
    localStringBuilder.append(paramEvilReportParams.o);
    localStringBuilder.append("_");
    localStringBuilder.append(paramEvilReportParams.p);
    localStringBuilder.append("_");
    localStringBuilder.append(paramEvilReportParams.q);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return MD5.a(localStringBuilder.toString());
  }
  
  private static String a(String paramString)
  {
    try
    {
      paramString = Base64.decode(paramString, 0);
      localObject = new SecretKeySpec("d41d8cd98f00b204e9800998ecf8427e".getBytes(), "AES");
      Cipher localCipher = Cipher.getInstance("AES/ECB/NoPadding");
      localCipher.init(2, (Key)localObject);
      paramString = new String(localCipher.doFinal(paramString), "utf-8");
      return paramString;
    }
    catch (Throwable paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decrypt key error! ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("EvilReportUtil", 1, ((StringBuilder)localObject).toString());
    }
    return "";
  }
  
  public static void a(Context paramContext, EvilReportUtil.EvilReportParams paramEvilReportParams)
  {
    if ((paramContext != null) && (paramEvilReportParams != null))
    {
      Request localRequest = new Request.Builder().url("https://jubao.qq.com/uniform_impeach/impeach_cryptokey").build();
      new OkHttpClient().newCall(localRequest).enqueue(new EvilReportUtil.1(paramContext, paramEvilReportParams));
      return;
    }
    QLog.d("QCircleEvilReport", 1, "context or reportParam is empty");
  }
  
  private static void b(Context paramContext, EvilReportUtil.EvilReportParams paramEvilReportParams, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://jubao.qq.com/uniform_impeach/impeach_entry");
    localStringBuilder.append("?system=");
    localStringBuilder.append(paramEvilReportParams.a);
    localStringBuilder.append("&version=");
    localStringBuilder.append(paramEvilReportParams.b);
    localStringBuilder.append("&uintype=");
    localStringBuilder.append(paramEvilReportParams.c);
    localStringBuilder.append("&eviluin=");
    localStringBuilder.append(paramEvilReportParams.d);
    localStringBuilder.append("&appname=");
    localStringBuilder.append(paramEvilReportParams.e);
    localStringBuilder.append("&appid=");
    localStringBuilder.append(paramEvilReportParams.f);
    localStringBuilder.append("&subapp=");
    localStringBuilder.append(paramEvilReportParams.g);
    localStringBuilder.append("&scene=");
    localStringBuilder.append(paramEvilReportParams.h);
    localStringBuilder.append("&buddyflag=");
    localStringBuilder.append(paramEvilReportParams.i);
    localStringBuilder.append("&contentid=");
    localStringBuilder.append(paramEvilReportParams.j);
    localStringBuilder.append("&srv_para=");
    localStringBuilder.append(paramEvilReportParams.k);
    localStringBuilder.append("&text_evidence=");
    localStringBuilder.append(paramEvilReportParams.l);
    localStringBuilder.append("&img_evidence=");
    localStringBuilder.append(URLEncoder.encode(paramEvilReportParams.m));
    localStringBuilder.append("&url_evidence=");
    localStringBuilder.append(paramEvilReportParams.n);
    localStringBuilder.append("&video_evidence=");
    localStringBuilder.append(URLEncoder.encode(paramEvilReportParams.o));
    localStringBuilder.append("&file_evidence=");
    localStringBuilder.append(paramEvilReportParams.p);
    localStringBuilder.append("&audio_evidence=");
    localStringBuilder.append(paramEvilReportParams.q);
    localStringBuilder.append("&user_input_param=");
    localStringBuilder.append(paramEvilReportParams.r);
    localStringBuilder.append("&groupid=");
    localStringBuilder.append(paramEvilReportParams.s);
    localStringBuilder.append("&cryptograph=");
    localStringBuilder.append(a(paramEvilReportParams, paramString));
    paramEvilReportParams = new Intent();
    paramEvilReportParams.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserDelegationActivity");
    paramEvilReportParams.putExtra("url", localStringBuilder.toString());
    if (!(paramContext instanceof Activity)) {
      paramEvilReportParams.addFlags(268435456);
    }
    paramContext.startActivity(paramEvilReportParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.EvilReportUtil
 * JD-Core Version:    0.7.0.1
 */