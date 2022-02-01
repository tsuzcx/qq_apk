package com.tencent.biz.subscribe.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import bjkz;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import cooperation.qzone.util.QZLog;
import java.net.URLEncoder;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;

public class EvilReportUtil
{
  private static final String AES_DECYPT_KEY = "d41d8cd98f00b204e9800998ecf8427e";
  private static final String ECB_CHIPER_ALGRITHUM = "AES/ECB/NoPadding";
  private static final String ENCRYPTED_KEY_DEFUALT = "Jbq0Dm55FudiaTa26UjP071XduhCyIKRYaK6MCcYzZA";
  private static final String EVIL_REPORT_URL = "https://jubao.qq.com/uniform_impeach/impeach_entry";
  private static final String GET_EVIL_REPORT_ENCRYPTED_KEY_URL = "https://jubao.qq.com/uniform_impeach/impeach_cryptokey";
  private static final String KEY_ALGRITHM = "AES";
  private static final String TAG = "EvilReportUtil";
  
  private static String decryptKey(String paramString)
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
      QZLog.e("EvilReportUtil", "decrypt key error! " + paramString);
    }
    return "";
  }
  
  public static void doEvilReport(Context paramContext, EvilReportUtil.EvilReportParams paramEvilReportParams)
  {
    if ((paramContext == null) || (paramEvilReportParams == null)) {
      return;
    }
    Request localRequest = new Request.Builder().url("https://jubao.qq.com/uniform_impeach/impeach_cryptokey").build();
    new OkHttpClient().newCall(localRequest).enqueue(new EvilReportUtil.1(paramContext, paramEvilReportParams));
  }
  
  private static String generateCryptoGraph(EvilReportUtil.EvilReportParams paramEvilReportParams, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramEvilReportParams.system);
    localStringBuilder.append("_").append(paramEvilReportParams.version);
    localStringBuilder.append("_").append(paramEvilReportParams.scene);
    localStringBuilder.append("_").append(decryptKey(paramString));
    paramString = bjkz.a(localStringBuilder.toString());
    localStringBuilder = new StringBuilder().append(paramEvilReportParams.eviluin);
    localStringBuilder.append("_").append(paramEvilReportParams.srv_para);
    localStringBuilder.append("_").append(paramEvilReportParams.text_evidence);
    localStringBuilder.append("_").append(paramEvilReportParams.img_evidence);
    localStringBuilder.append("_").append(paramEvilReportParams.url_evidence);
    localStringBuilder.append("_").append(paramEvilReportParams.video_evidence);
    localStringBuilder.append("_").append(paramEvilReportParams.file_evidence);
    localStringBuilder.append("_").append(paramEvilReportParams.audio_evidence);
    localStringBuilder.append("_").append(paramString);
    return bjkz.a(localStringBuilder.toString());
  }
  
  private static void navigateToEvilReportPage(Context paramContext, EvilReportUtil.EvilReportParams paramEvilReportParams, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://jubao.qq.com/uniform_impeach/impeach_entry");
    localStringBuilder.append("?system=").append(paramEvilReportParams.system);
    localStringBuilder.append("&version=").append(paramEvilReportParams.version);
    localStringBuilder.append("&uintype=").append(paramEvilReportParams.uintype);
    localStringBuilder.append("&eviluin=").append(paramEvilReportParams.eviluin);
    localStringBuilder.append("&appname=").append(paramEvilReportParams.appname);
    localStringBuilder.append("&appid=").append(paramEvilReportParams.appid);
    localStringBuilder.append("&subapp=").append(paramEvilReportParams.subapp);
    localStringBuilder.append("&scene=").append(paramEvilReportParams.scene);
    localStringBuilder.append("&buddyflag=").append(paramEvilReportParams.buddyflag);
    localStringBuilder.append("&contentid=").append(paramEvilReportParams.contentid);
    localStringBuilder.append("&srv_para=").append(paramEvilReportParams.srv_para);
    localStringBuilder.append("&text_evidence=").append(paramEvilReportParams.text_evidence);
    localStringBuilder.append("&img_evidence=").append(URLEncoder.encode(paramEvilReportParams.img_evidence));
    localStringBuilder.append("&url_evidence=").append(paramEvilReportParams.url_evidence);
    localStringBuilder.append("&video_evidence=").append(URLEncoder.encode(paramEvilReportParams.video_evidence));
    localStringBuilder.append("&file_evidence=").append(paramEvilReportParams.file_evidence);
    localStringBuilder.append("&audio_evidence=").append(paramEvilReportParams.audio_evidence);
    localStringBuilder.append("&user_input_param=").append(paramEvilReportParams.user_input_param);
    localStringBuilder.append("&groupid=").append(paramEvilReportParams.groupid);
    localStringBuilder.append("&cryptograph=").append(generateCryptoGraph(paramEvilReportParams, paramString));
    paramEvilReportParams = new Intent(paramContext, QQBrowserDelegationActivity.class);
    paramEvilReportParams.putExtra("url", localStringBuilder.toString());
    paramContext.startActivity(paramEvilReportParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.EvilReportUtil
 * JD-Core Version:    0.7.0.1
 */