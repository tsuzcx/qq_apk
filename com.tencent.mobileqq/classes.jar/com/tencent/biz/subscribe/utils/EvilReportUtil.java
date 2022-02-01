package com.tencent.biz.subscribe.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;
import java.net.URLEncoder;
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
    localStringBuilder.append("_").append(paramEvilReportParams.b);
    localStringBuilder.append("_").append(paramEvilReportParams.h);
    localStringBuilder.append("_").append(a(paramString));
    paramString = MD5.a(localStringBuilder.toString());
    localStringBuilder = new StringBuilder().append(paramEvilReportParams.d);
    localStringBuilder.append("_").append(paramEvilReportParams.k);
    localStringBuilder.append("_").append(paramEvilReportParams.l);
    localStringBuilder.append("_").append(paramEvilReportParams.m);
    localStringBuilder.append("_").append(paramEvilReportParams.n);
    localStringBuilder.append("_").append(paramEvilReportParams.o);
    localStringBuilder.append("_").append(paramEvilReportParams.p);
    localStringBuilder.append("_").append(paramEvilReportParams.q);
    localStringBuilder.append("_").append(paramString);
    return MD5.a(localStringBuilder.toString());
  }
  
  private static String a(String paramString)
  {
    try
    {
      paramString = Base64.decode(paramString, 0);
      SecretKeySpec localSecretKeySpec = new SecretKeySpec("d41d8cd98f00b204e9800998ecf8427e".getBytes(), "AES");
      Cipher localCipher = Cipher.getInstance("AES/ECB/NoPadding");
      localCipher.init(2, localSecretKeySpec);
      paramString = new String(localCipher.doFinal(paramString), "utf-8");
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.e("EvilReportUtil", 1, "decrypt key error! " + paramString);
    }
    return "";
  }
  
  public static void a(Context paramContext, EvilReportUtil.EvilReportParams paramEvilReportParams)
  {
    if ((paramContext == null) || (paramEvilReportParams == null))
    {
      QLog.d("QCircleEvilReport", 1, "context or reportParam is empty");
      return;
    }
    Request localRequest = new Request.Builder().url("https://jubao.qq.com/uniform_impeach/impeach_cryptokey").build();
    new OkHttpClient().newCall(localRequest).enqueue(new EvilReportUtil.1(paramContext, paramEvilReportParams));
  }
  
  private static void b(Context paramContext, EvilReportUtil.EvilReportParams paramEvilReportParams, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://jubao.qq.com/uniform_impeach/impeach_entry");
    localStringBuilder.append("?system=").append(paramEvilReportParams.a);
    localStringBuilder.append("&version=").append(paramEvilReportParams.b);
    localStringBuilder.append("&uintype=").append(paramEvilReportParams.c);
    localStringBuilder.append("&eviluin=").append(paramEvilReportParams.d);
    localStringBuilder.append("&appname=").append(paramEvilReportParams.e);
    localStringBuilder.append("&appid=").append(paramEvilReportParams.f);
    localStringBuilder.append("&subapp=").append(paramEvilReportParams.g);
    localStringBuilder.append("&scene=").append(paramEvilReportParams.h);
    localStringBuilder.append("&buddyflag=").append(paramEvilReportParams.i);
    localStringBuilder.append("&contentid=").append(paramEvilReportParams.j);
    localStringBuilder.append("&srv_para=").append(paramEvilReportParams.k);
    localStringBuilder.append("&text_evidence=").append(paramEvilReportParams.l);
    localStringBuilder.append("&img_evidence=").append(URLEncoder.encode(paramEvilReportParams.m));
    localStringBuilder.append("&url_evidence=").append(paramEvilReportParams.n);
    localStringBuilder.append("&video_evidence=").append(URLEncoder.encode(paramEvilReportParams.o));
    localStringBuilder.append("&file_evidence=").append(paramEvilReportParams.p);
    localStringBuilder.append("&audio_evidence=").append(paramEvilReportParams.q);
    localStringBuilder.append("&user_input_param=").append(paramEvilReportParams.r);
    localStringBuilder.append("&groupid=").append(paramEvilReportParams.s);
    localStringBuilder.append("&cryptograph=").append(a(paramEvilReportParams, paramString));
    paramEvilReportParams = new Intent();
    paramEvilReportParams.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserDelegationActivity");
    paramEvilReportParams.putExtra("url", localStringBuilder.toString());
    if (!(paramContext instanceof Activity)) {
      paramEvilReportParams.addFlags(268435456);
    }
    paramContext.startActivity(paramEvilReportParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.EvilReportUtil
 * JD-Core Version:    0.7.0.1
 */