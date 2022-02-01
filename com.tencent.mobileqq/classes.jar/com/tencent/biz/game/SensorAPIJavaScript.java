package com.tencent.biz.game;

import aasb;
import agej;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaRecorder;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import bhlo;
import bini;
import bioy;
import bitk;
import bits;
import bjjo;
import bjve;
import blhn;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.troopplugin.PluginJumpManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppActivity;
import nlq;
import nmj;
import nmp;
import nnr;
import noe;
import nov;
import noz;
import npa;
import npb;
import npc;
import npd;
import npe;
import npf;
import npg;
import nph;
import npi;
import npj;
import org.json.JSONException;
import org.json.JSONObject;

public class SensorAPIJavaScript
  extends bini
{
  public static nov a;
  protected final byte a;
  protected final int a;
  aasb a;
  public Activity a;
  protected SensorManager a;
  protected MediaRecorder a;
  public SoundPool a;
  public Handler a;
  protected Object a;
  public String a;
  protected WeakReference<WebView> a;
  protected HashMap<String, Integer> a;
  protected npj a;
  protected boolean a;
  protected final byte b;
  protected final int b;
  protected String b;
  protected npj b;
  protected boolean b;
  protected final byte c;
  protected final int c;
  protected npj c;
  protected boolean c;
  protected final int d = 291;
  protected final int e = 0;
  protected final int f = 1;
  protected final int g = 2;
  protected final int h = 3;
  protected final int i = 4;
  protected final int j = 0;
  protected final int k = 1;
  protected int l = 100;
  
  public SensorAPIJavaScript()
  {
    this.jdField_a_of_type_Byte = 0;
    this.jdField_b_of_type_Byte = 1;
    this.jdField_c_of_type_Byte = 2;
    this.jdField_a_of_type_Int = 8000;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_c_of_type_Int = 5;
    this.jdField_a_of_type_Aasb = null;
  }
  
  private void a()
  {
    if (Looper.myLooper() == null) {
      Looper.prepare();
    }
    this.jdField_a_of_type_AndroidOsHandler = new npd(this);
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaRecorder == null) {
      this.jdField_a_of_type_AndroidMediaMediaRecorder = new MediaRecorder();
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioSource(1);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFormat(3);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioEncoder(0);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFile("/dev/null");
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setMaxDuration(600000);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.prepare();
      this.jdField_a_of_type_AndroidMediaMediaRecorder.start();
      updateMicStatus(paramString);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      callJs(paramString, new String[] { "false" });
      this.jdField_a_of_type_AndroidMediaMediaRecorder.release();
      this.jdField_a_of_type_AndroidMediaMediaRecorder = null;
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public static final String getDeviceInfoEx(String paramString)
  {
    String str4 = Build.MODEL;
    String str5 = Build.VERSION.RELEASE;
    String str6 = Build.FINGERPRINT;
    String str7 = Build.VERSION.INCREMENTAL;
    String str3 = "";
    try
    {
      str1 = UserAction.getQIMEI();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          String str1;
          paramString = new JSONObject();
          paramString.put("model", str4);
          paramString.put("systemName", "android");
          paramString.put("systemVersion", str5);
          paramString.put("isMobileQQ", true);
          paramString.put("identifier", bjve.c());
          paramString.put("fingerprint", str6);
          paramString.put("incremental", str7);
          paramString.put("macAddress", bjve.a());
          paramString.put("androidID", Settings.Secure.getString(bjjo.a().a().getContentResolver(), "android_id"));
          paramString.put("imsi", bjve.d());
          paramString.put("qimei", str1);
          paramString.put("totalMemory", String.valueOf(bhlo.d()));
          paramString.put("availableMemory", String.valueOf(bhlo.e()));
          paramString.put("cpuType", bhlo.g());
          paramString.put("cpuNum", bhlo.b());
          paramString.put("cpuFreq", bhlo.a());
          paramString.put("msfImei", MsfSdkUtils.getIMEIForMain("bussiness_id_customize_online_status"));
          paramString = paramString.toString();
          return paramString;
        }
        catch (JSONException paramString) {}
        localException = localException;
        String str2 = str3;
        if (QLog.isColorLevel())
        {
          QLog.e(paramString, 2, "get QIMEI fail");
          str2 = str3;
        }
      }
    }
    return "{}";
  }
  
  public static nov getMsfToWebViewConnector()
  {
    return jdField_a_of_type_Nov;
  }
  
  public static void returnToAio(aasb paramaasb, Activity paramActivity, String paramString, boolean paramBoolean)
  {
    if (paramaasb == null) {
      return;
    }
    paramaasb.g(new npf(paramActivity, paramBoolean, paramString));
  }
  
  /* Error */
  protected final int a()
  {
    // Byte code:
    //   0: invokestatic 323	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: new 325	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 326	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 328
    //   13: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc_w 334
    //   19: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokevirtual 339	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   28: astore 4
    //   30: aload 4
    //   32: invokevirtual 345	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   35: astore_2
    //   36: new 347	java/io/BufferedReader
    //   39: dup
    //   40: new 349	java/io/InputStreamReader
    //   43: dup
    //   44: aload_2
    //   45: invokespecial 352	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   48: invokespecial 355	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   51: astore_3
    //   52: new 357	java/lang/StringBuffer
    //   55: dup
    //   56: invokespecial 358	java/lang/StringBuffer:<init>	()V
    //   59: astore 5
    //   61: aload_3
    //   62: invokevirtual 361	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   65: astore 6
    //   67: aload 6
    //   69: ifnull +79 -> 148
    //   72: aload 5
    //   74: aload 6
    //   76: invokevirtual 364	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   79: pop
    //   80: goto -19 -> 61
    //   83: astore 4
    //   85: aload_3
    //   86: astore 4
    //   88: aload_2
    //   89: astore_3
    //   90: aload 4
    //   92: astore_2
    //   93: invokestatic 367	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   96: ifeq +32 -> 128
    //   99: ldc_w 369
    //   102: iconst_4
    //   103: new 325	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 326	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 371
    //   113: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc_w 373
    //   119: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 375	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aload_2
    //   129: ifnull +7 -> 136
    //   132: aload_2
    //   133: invokevirtual 378	java/io/BufferedReader:close	()V
    //   136: aload_3
    //   137: ifnull +7 -> 144
    //   140: aload_3
    //   141: invokevirtual 381	java/io/InputStream:close	()V
    //   144: iconst_1
    //   145: istore_1
    //   146: iload_1
    //   147: ireturn
    //   148: invokestatic 367	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   151: ifeq +34 -> 185
    //   154: ldc_w 369
    //   157: iconst_4
    //   158: new 325	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 326	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 383
    //   168: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload 5
    //   173: invokevirtual 384	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   176: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 375	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: aload 4
    //   187: invokevirtual 387	java/lang/Process:waitFor	()I
    //   190: ifne +73 -> 263
    //   193: iconst_0
    //   194: istore_1
    //   195: invokestatic 367	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   198: ifeq +32 -> 230
    //   201: ldc_w 369
    //   204: iconst_4
    //   205: new 325	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 326	java/lang/StringBuilder:<init>	()V
    //   212: ldc_w 371
    //   215: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 389
    //   221: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 375	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   230: aload_3
    //   231: ifnull +7 -> 238
    //   234: aload_3
    //   235: invokevirtual 378	java/io/BufferedReader:close	()V
    //   238: aload_2
    //   239: ifnull -93 -> 146
    //   242: aload_2
    //   243: invokevirtual 381	java/io/InputStream:close	()V
    //   246: iconst_0
    //   247: ireturn
    //   248: astore_2
    //   249: aload_2
    //   250: invokevirtual 390	java/io/IOException:printStackTrace	()V
    //   253: iconst_0
    //   254: ireturn
    //   255: astore_3
    //   256: aload_3
    //   257: invokevirtual 390	java/io/IOException:printStackTrace	()V
    //   260: goto -22 -> 238
    //   263: invokestatic 367	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   266: ifeq +32 -> 298
    //   269: ldc_w 369
    //   272: iconst_4
    //   273: new 325	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 326	java/lang/StringBuilder:<init>	()V
    //   280: ldc_w 371
    //   283: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: ldc_w 392
    //   289: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 375	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: aload_3
    //   299: ifnull +7 -> 306
    //   302: aload_3
    //   303: invokevirtual 378	java/io/BufferedReader:close	()V
    //   306: aload_2
    //   307: ifnull -163 -> 144
    //   310: aload_2
    //   311: invokevirtual 381	java/io/InputStream:close	()V
    //   314: goto -170 -> 144
    //   317: astore_2
    //   318: aload_2
    //   319: invokevirtual 390	java/io/IOException:printStackTrace	()V
    //   322: goto -178 -> 144
    //   325: astore_3
    //   326: aload_3
    //   327: invokevirtual 390	java/io/IOException:printStackTrace	()V
    //   330: goto -24 -> 306
    //   333: astore_2
    //   334: aload_2
    //   335: invokevirtual 390	java/io/IOException:printStackTrace	()V
    //   338: goto -202 -> 136
    //   341: astore_2
    //   342: aload_2
    //   343: invokevirtual 390	java/io/IOException:printStackTrace	()V
    //   346: goto -202 -> 144
    //   349: astore_2
    //   350: aconst_null
    //   351: astore_3
    //   352: aconst_null
    //   353: astore_2
    //   354: invokestatic 367	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   357: ifeq +32 -> 389
    //   360: ldc_w 369
    //   363: iconst_4
    //   364: new 325	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 326	java/lang/StringBuilder:<init>	()V
    //   371: ldc_w 371
    //   374: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: ldc_w 394
    //   380: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 375	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   389: aload_3
    //   390: ifnull +7 -> 397
    //   393: aload_3
    //   394: invokevirtual 378	java/io/BufferedReader:close	()V
    //   397: aload_2
    //   398: ifnull -254 -> 144
    //   401: aload_2
    //   402: invokevirtual 381	java/io/InputStream:close	()V
    //   405: goto -261 -> 144
    //   408: astore_2
    //   409: aload_2
    //   410: invokevirtual 390	java/io/IOException:printStackTrace	()V
    //   413: goto -269 -> 144
    //   416: astore_3
    //   417: aload_3
    //   418: invokevirtual 390	java/io/IOException:printStackTrace	()V
    //   421: goto -24 -> 397
    //   424: astore 4
    //   426: aconst_null
    //   427: astore_3
    //   428: aconst_null
    //   429: astore_2
    //   430: invokestatic 367	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   433: ifeq +30 -> 463
    //   436: ldc_w 369
    //   439: iconst_4
    //   440: new 325	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 326	java/lang/StringBuilder:<init>	()V
    //   447: ldc_w 371
    //   450: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aconst_null
    //   454: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: invokestatic 375	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   463: aload_3
    //   464: ifnull +7 -> 471
    //   467: aload_3
    //   468: invokevirtual 378	java/io/BufferedReader:close	()V
    //   471: aload_2
    //   472: ifnull +7 -> 479
    //   475: aload_2
    //   476: invokevirtual 381	java/io/InputStream:close	()V
    //   479: aload 4
    //   481: athrow
    //   482: astore_3
    //   483: aload_3
    //   484: invokevirtual 390	java/io/IOException:printStackTrace	()V
    //   487: goto -16 -> 471
    //   490: astore_2
    //   491: aload_2
    //   492: invokevirtual 390	java/io/IOException:printStackTrace	()V
    //   495: goto -16 -> 479
    //   498: astore 4
    //   500: aconst_null
    //   501: astore_3
    //   502: goto -72 -> 430
    //   505: astore 4
    //   507: goto -77 -> 430
    //   510: astore_3
    //   511: aconst_null
    //   512: astore_3
    //   513: goto -159 -> 354
    //   516: astore 4
    //   518: goto -164 -> 354
    //   521: astore_2
    //   522: aconst_null
    //   523: astore_2
    //   524: aconst_null
    //   525: astore_3
    //   526: goto -433 -> 93
    //   529: astore_3
    //   530: aconst_null
    //   531: astore 4
    //   533: aload_2
    //   534: astore_3
    //   535: aload 4
    //   537: astore_2
    //   538: goto -445 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	541	0	this	SensorAPIJavaScript
    //   145	50	1	m	int
    //   35	208	2	localObject1	Object
    //   248	63	2	localIOException1	java.io.IOException
    //   317	2	2	localIOException2	java.io.IOException
    //   333	2	2	localIOException3	java.io.IOException
    //   341	2	2	localIOException4	java.io.IOException
    //   349	1	2	localInterruptedException1	java.lang.InterruptedException
    //   353	49	2	localObject2	Object
    //   408	2	2	localIOException5	java.io.IOException
    //   429	47	2	localObject3	Object
    //   490	2	2	localIOException6	java.io.IOException
    //   521	1	2	localIOException7	java.io.IOException
    //   523	15	2	localObject4	Object
    //   51	184	3	localObject5	Object
    //   255	48	3	localIOException8	java.io.IOException
    //   325	2	3	localIOException9	java.io.IOException
    //   351	43	3	localObject6	Object
    //   416	2	3	localIOException10	java.io.IOException
    //   427	41	3	localObject7	Object
    //   482	2	3	localIOException11	java.io.IOException
    //   501	1	3	localObject8	Object
    //   510	1	3	localInterruptedException2	java.lang.InterruptedException
    //   512	14	3	localObject9	Object
    //   529	1	3	localIOException12	java.io.IOException
    //   534	1	3	localObject10	Object
    //   28	3	4	localProcess	java.lang.Process
    //   83	1	4	localIOException13	java.io.IOException
    //   86	100	4	localObject11	Object
    //   424	56	4	localObject12	Object
    //   498	1	4	localObject13	Object
    //   505	1	4	localObject14	Object
    //   516	1	4	localInterruptedException3	java.lang.InterruptedException
    //   531	5	4	localObject15	Object
    //   59	113	5	localStringBuffer	java.lang.StringBuffer
    //   65	10	6	str	String
    // Exception table:
    //   from	to	target	type
    //   52	61	83	java/io/IOException
    //   61	67	83	java/io/IOException
    //   72	80	83	java/io/IOException
    //   148	185	83	java/io/IOException
    //   185	193	83	java/io/IOException
    //   242	246	248	java/io/IOException
    //   234	238	255	java/io/IOException
    //   310	314	317	java/io/IOException
    //   302	306	325	java/io/IOException
    //   132	136	333	java/io/IOException
    //   140	144	341	java/io/IOException
    //   0	36	349	java/lang/InterruptedException
    //   401	405	408	java/io/IOException
    //   393	397	416	java/io/IOException
    //   0	36	424	finally
    //   467	471	482	java/io/IOException
    //   475	479	490	java/io/IOException
    //   36	52	498	finally
    //   52	61	505	finally
    //   61	67	505	finally
    //   72	80	505	finally
    //   148	185	505	finally
    //   185	193	505	finally
    //   36	52	510	java/lang/InterruptedException
    //   52	61	516	java/lang/InterruptedException
    //   61	67	516	java/lang/InterruptedException
    //   72	80	516	java/lang/InterruptedException
    //   148	185	516	java/lang/InterruptedException
    //   185	193	516	java/lang/InterruptedException
    //   0	36	521	java/io/IOException
    //   36	52	529	java/io/IOException
  }
  
  public void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SensorApi", 4, "start checkWifiStatus");
    }
    new SensorAPIJavaScript.11(this, this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), paramString).start();
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    nmj.a(paramString1, this.mRuntime.a(), new nph(this, paramString2), false);
  }
  
  /* Error */
  public void connectToWiFi(String paramString)
  {
    // Byte code:
    //   0: ldc 49
    //   2: astore_3
    //   3: new 176	org/json/JSONObject
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 436	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11: astore 7
    //   13: aload 7
    //   15: ldc_w 438
    //   18: invokevirtual 440	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   21: astore 4
    //   23: aload 7
    //   25: ldc_w 442
    //   28: invokevirtual 440	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   31: astore 5
    //   33: aload 7
    //   35: ldc_w 444
    //   38: invokevirtual 440	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   41: astore 6
    //   43: aload 7
    //   45: ldc_w 446
    //   48: invokevirtual 440	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore_1
    //   52: aload 7
    //   54: ldc_w 448
    //   57: invokevirtual 452	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   60: istore_2
    //   61: aload_0
    //   62: getfield 454	com/tencent/biz/game/SensorAPIJavaScript:jdField_c_of_type_Boolean	Z
    //   65: ifeq +52 -> 117
    //   68: aload_0
    //   69: aload 6
    //   71: iconst_1
    //   72: anewarray 137	java/lang/String
    //   75: dup
    //   76: iconst_0
    //   77: ldc_w 456
    //   80: aastore
    //   81: invokevirtual 143	com/tencent/biz/game/SensorAPIJavaScript:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   84: return
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 457	org/json/JSONException:printStackTrace	()V
    //   90: return
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 457	org/json/JSONException:printStackTrace	()V
    //   96: return
    //   97: astore_1
    //   98: aload_1
    //   99: invokevirtual 457	org/json/JSONException:printStackTrace	()V
    //   102: aload_3
    //   103: astore_1
    //   104: goto -52 -> 52
    //   107: astore_3
    //   108: aload_3
    //   109: invokevirtual 457	org/json/JSONException:printStackTrace	()V
    //   112: iconst_0
    //   113: istore_2
    //   114: goto -53 -> 61
    //   117: aload 6
    //   119: invokestatic 463	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   122: ifne -38 -> 84
    //   125: aload_0
    //   126: getfield 402	com/tencent/biz/game/SensorAPIJavaScript:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   129: ifnull -45 -> 84
    //   132: aload 4
    //   134: invokestatic 463	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   137: ifne +11 -> 148
    //   140: aload 5
    //   142: invokestatic 463	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: ifeq +20 -> 165
    //   148: aload_0
    //   149: aload 6
    //   151: iconst_1
    //   152: anewarray 137	java/lang/String
    //   155: dup
    //   156: iconst_0
    //   157: ldc_w 465
    //   160: aastore
    //   161: invokevirtual 143	com/tencent/biz/game/SensorAPIJavaScript:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   164: return
    //   165: aload_0
    //   166: getfield 402	com/tencent/biz/game/SensorAPIJavaScript:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   169: invokevirtual 407	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   172: ldc_w 467
    //   175: invokevirtual 471	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   178: checkcast 473	android/net/wifi/WifiManager
    //   181: astore_3
    //   182: aload_3
    //   183: ifnonnull +36 -> 219
    //   186: invokestatic 367	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   189: ifeq +13 -> 202
    //   192: ldc_w 369
    //   195: iconst_4
    //   196: ldc_w 475
    //   199: invokestatic 398	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: aload_0
    //   203: aload 6
    //   205: iconst_1
    //   206: anewarray 137	java/lang/String
    //   209: dup
    //   210: iconst_0
    //   211: ldc_w 477
    //   214: aastore
    //   215: invokevirtual 143	com/tencent/biz/game/SensorAPIJavaScript:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   218: return
    //   219: aload_0
    //   220: iconst_1
    //   221: putfield 454	com/tencent/biz/game/SensorAPIJavaScript:jdField_c_of_type_Boolean	Z
    //   224: new 479	com/tencent/biz/game/SensorAPIJavaScript$10
    //   227: dup
    //   228: aload_0
    //   229: aload 5
    //   231: aload 4
    //   233: aload_1
    //   234: iload_2
    //   235: aload_3
    //   236: aload 6
    //   238: invokespecial 482	com/tencent/biz/game/SensorAPIJavaScript$10:<init>	(Lcom/tencent/biz/game/SensorAPIJavaScript;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/net/wifi/WifiManager;Ljava/lang/String;)V
    //   241: invokevirtual 413	java/lang/Thread:start	()V
    //   244: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	SensorAPIJavaScript
    //   0	245	1	paramString	String
    //   60	175	2	bool	boolean
    //   2	101	3	str1	String
    //   107	2	3	localJSONException	JSONException
    //   181	55	3	localWifiManager	android.net.wifi.WifiManager
    //   21	211	4	str2	String
    //   31	199	5	str3	String
    //   41	196	6	str4	String
    //   11	42	7	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   3	13	85	org/json/JSONException
    //   13	43	91	org/json/JSONException
    //   43	52	97	org/json/JSONException
    //   52	61	107	org/json/JSONException
  }
  
  public void forceUpdate(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    forceUpdate(paramString1, paramString2, "0", paramString3);
  }
  
  public void forceUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramString1.length() > 10)) {
      return;
    }
    paramString2 = new ArrayList();
    paramString2.add(paramString1);
    paramString2 = new HashMap(paramString2.size());
    paramString2.put(paramString1, "0");
    nmj.a(this.mRuntime.a(), paramString2, new npg(this, paramString4), true, true, false);
  }
  
  public final String getClientInfo()
  {
    return "{\"qqVersion\":\"" + qqVersion() + "\",\"qqBuild\":\"" + "4745" + "\"}";
  }
  
  public boolean getCurrentSong(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return true;
        try
        {
          paramString = new JSONObject(paramString);
          paramString = paramString.optString("callback");
          if (!TextUtils.isEmpty(paramString))
          {
            this.jdField_a_of_type_Aasb.a().c(new npc(this, paramString));
            return true;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "getCurrentSong json err");
    return true;
  }
  
  public final String getDeviceInfo()
  {
    return getDeviceInfoEx(this.TAG);
  }
  
  public String getNameSpace()
  {
    return "qbizApi";
  }
  
  public JSONObject getNetworkInfo()
  {
    int i1 = nnr.a();
    String str = nnr.a();
    int n = 0;
    Object localObject = bhlo.b();
    int m = n;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      m = n;
      if (((String)localObject).length() > 5)
      {
        m = n;
        if (((String)localObject).startsWith("460"))
        {
          localObject = ((String)localObject).substring(3, 5);
          if ((!((String)localObject).equals("00")) && (!((String)localObject).equals("02")) && (!((String)localObject).equals("04")) && (!((String)localObject).equals("07"))) {
            break label148;
          }
          m = 1;
        }
      }
    }
    for (;;)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("type", i1);
        ((JSONObject)localObject).put("radio", str);
        ((JSONObject)localObject).put("carriertype", m);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        label148:
        localJSONException.printStackTrace();
      }
      if ((((String)localObject).equals("01")) || (((String)localObject).equals("06")) || (((String)localObject).equals("09")))
      {
        m = 2;
      }
      else if ((((String)localObject).equals("03")) || (((String)localObject).equals("05")))
      {
        m = 3;
      }
      else
      {
        m = n;
        if (((String)localObject).equals("20")) {
          m = 4;
        }
      }
    }
    return localObject;
  }
  
  public int getNetworkType()
  {
    return nnr.a();
  }
  
  public boolean getPlayMode(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return true;
        try
        {
          paramString = new JSONObject(paramString);
          paramString = paramString.optString("callback");
          if (!TextUtils.isEmpty(paramString))
          {
            this.jdField_a_of_type_Aasb.a().b(new npb(this, paramString));
            return true;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "getPlayMode json err");
    return true;
  }
  
  public boolean getPlayState(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return true;
        try
        {
          paramString = new JSONObject(paramString);
          paramString = paramString.optString("callback");
          if (!TextUtils.isEmpty(paramString))
          {
            this.jdField_a_of_type_Aasb.a().a(new npa(this, paramString));
            return true;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "getPlayState json err");
    return true;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 4L)
    {
      if (paramMap != null) {
        notifyCacheReady(((Integer)paramMap.get("code")).intValue());
      }
      return true;
    }
    return false;
  }
  
  public void isCached(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = nmj.a(paramString1);
    if (TextUtils.isEmpty(paramString1))
    {
      callJs(paramString2, new String[] { "-1" });
      return;
    }
    callJs(paramString2, new String[] { paramString1 });
  }
  
  public final String modelVersion()
  {
    return Build.MODEL;
  }
  
  public boolean notifyCacheReady(int paramInt)
  {
    String str;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      str = "";
      if (paramInt == 0) {
        str = "success";
      }
    }
    for (;;)
    {
      callJs(this.jdField_a_of_type_JavaLangString, new String[] { Integer.toString(paramInt), noe.a(str) });
      return true;
      if (paramInt == 1)
      {
        str = "param error";
        continue;
        if (paramInt == 5)
        {
          str = "had update ";
          continue;
          return false;
        }
      }
      else if (paramInt == 2)
      {
        str = "download error";
      }
      else if (paramInt == 3)
      {
        str = "no sdcard";
      }
      else
      {
        if (paramInt != 4) {
          break;
        }
        str = "other ";
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramInt != -1) {}
    Activity localActivity;
    do
    {
      do
      {
        return;
      } while ((paramByte != 1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("closeSpecialLogic", false)) || (!this.jdField_a_of_type_Boolean));
      localActivity = this.mRuntime.a();
    } while (localActivity == null);
    localActivity.setResult(-1, paramIntent);
    localActivity.finish();
  }
  
  public void onCreate()
  {
    super.onCreate();
    a();
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
    if (this.mRuntime.a() != null) {
      this.jdField_b_of_type_JavaLangString = this.mRuntime.a().getCurrentAccountUin();
    }
    this.jdField_a_of_type_Aasb = aasb.a();
    this.jdField_a_of_type_Aasb.a();
  }
  
  public void onDestroy()
  {
    release();
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.mRuntime.a());
  }
  
  public final void openLinkInNewWebView(String paramString1, String paramString2)
  {
    PluginJumpManager.getInstance().updateConfig(((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime());
    PluginJumpManager.getInstance().loadConfig();
    if (PluginJumpManager.getInstance().openView((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, paramString1, paramString2)) {}
    while ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Bundle localBundle2 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
    Bundle localBundle1;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    try
    {
      for (;;)
      {
        m = Integer.valueOf(paramString2).intValue();
        switch (m)
        {
        default: 
          paramString2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getClass());
          paramString2.putExtras(localBundle1);
          paramString2.putExtra("url", paramString1);
          paramString2.putExtra("startOpenPageTime", System.currentTimeMillis());
          paramString2.setFlags(0);
          paramString1 = this.mRuntime.a(this.mRuntime.a());
          if ((paramString1 != null) && ((paramString1 instanceof bits)))
          {
            paramString1 = ((bits)paramString1).getCurrentUrl();
            if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("closeSpecialLogic")) && (blhn.a(blhn.a(paramString1), "closeSpecialLogic", 0) != 0)) {
              this.jdField_a_of_type_Boolean = true;
            }
          }
          if (!this.jdField_a_of_type_Boolean) {
            break label433;
          }
          startActivityForResult(paramString2, (byte)1);
          return;
          localBundle2.remove("title");
          localBundle2.remove("leftViewText");
          localBundle2.remove("post_data");
          localBundle2.remove("options");
          localBundle1 = localBundle2;
          if (localBundle2.containsKey("startOpenPageTime"))
          {
            localBundle2.putLong("startOpenPageTime", System.currentTimeMillis());
            localBundle1 = localBundle2;
          }
          break;
        }
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        int m = 0;
        continue;
        localBundle1.putBoolean("hide_more_button", false);
        localBundle1.putBoolean("hide_operation_bar", true);
        continue;
        localBundle1.putBoolean("hide_more_button", true);
        localBundle1.putBoolean("hide_operation_bar", true);
        continue;
        localBundle1.putBoolean("hide_more_button", false);
        localBundle1.putBoolean("hide_operation_bar", false);
        localBundle1.putString("webStyle", "");
        continue;
        localBundle1.putBoolean("hide_more_button", true);
        localBundle1.putBoolean("hide_operation_bar", false);
        localBundle1.putString("webStyle", "");
      }
      label433:
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramString2, 100);
    }
  }
  
  public boolean pausePlayMusic()
  {
    this.jdField_a_of_type_Aasb.a().a();
    return true;
  }
  
  public final void phoneVibrate(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        l1 = Long.valueOf(paramString).longValue();
        paramString = (Vibrator)this.jdField_a_of_type_AndroidAppActivity.getSystemService("vibrator");
        if (paramString == null) {
          continue;
        }
        paramString.vibrate(l1);
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          long l1 = 0L;
        }
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(8)
  public boolean playVoice(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      do
      {
        return false;
        if (this.jdField_a_of_type_AndroidMediaSoundPool == null) {
          this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(10, 3, 0);
        }
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString2)) {
          break;
        }
      } while (!preloadVoice(paramString1, paramString2, null));
      if (Build.VERSION.SDK_INT >= 8) {
        this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new npe(this, paramString2));
      }
      int m;
      do
      {
        for (;;)
        {
          return true;
          m = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2)).intValue();
          if (this.jdField_a_of_type_AndroidOsHandler != null) {
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SensorAPIJavaScript.4(this, m, paramString2), 200L);
          }
        }
        m = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2)).intValue();
      } while (this.jdField_a_of_type_AndroidMediaSoundPool.play(m, 1.0F, 1.0F, 0, 0, 1.0F) != 0);
    } while (!QLog.isColorLevel());
    QLog.d("SensorApi", 2, "play failure url=" + paramString2);
    return false;
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(8)
  public boolean preloadVoice(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) || ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString2)))) {
      return false;
    }
    new StringBuilder().append(Environment.getExternalStorageDirectory().getAbsolutePath()).append(File.separator).toString();
    paramString3 = new StringBuilder();
    paramString3.append(nmp.b());
    paramString3.append(paramString1);
    paramString3.append('/');
    String str = Uri.parse(paramString2).getScheme();
    paramString1 = "";
    if (str != null) {
      paramString1 = str + "://";
    }
    if (paramString2.length() >= paramString1.length()) {
      paramString3.append(paramString2.substring(paramString1.length()));
    }
    paramString1 = new File(paramString3.toString());
    if (!paramString1.exists()) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidMediaSoundPool == null) {
      this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(10, 3, 0);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    if (Build.VERSION.SDK_INT >= 8) {
      this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(null);
    }
    int m = this.jdField_a_of_type_AndroidMediaSoundPool.load(paramString1.getAbsolutePath(), 1);
    if (m == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SensorApi", 2, "load failure url=" + paramString2);
      }
      return false;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString2, Integer.valueOf(m));
    return true;
  }
  
  public final String qqVersion()
  {
    try
    {
      Object localObject = this.mRuntime.a(this.mRuntime.a());
      if ((localObject != null) && ((localObject instanceof bitk))) {
        return this.jdField_a_of_type_AndroidAppActivity.getPackageManager().getPackageInfo("com.tencent.mobileqq", 0).versionName;
      }
      localObject = this.jdField_a_of_type_AndroidAppActivity.getPackageManager().getPackageInfo(this.jdField_a_of_type_AndroidAppActivity.getPackageName(), 0).versionName;
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return "";
  }
  
  public void refreshOfflineCache()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      WebView localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localWebView != null) {
        localWebView.loadUrl(localWebView.getUrl());
      }
    }
  }
  
  public void release()
  {
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null)
    {
      this.jdField_a_of_type_AndroidMediaSoundPool.release();
      this.jdField_a_of_type_AndroidMediaSoundPool = null;
    }
    if (jdField_a_of_type_Nov != null)
    {
      jdField_a_of_type_Nov.a();
      jdField_a_of_type_Nov = null;
    }
    stopAccelerometer();
    stopCompass();
    stopListen();
    stopLight();
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
    }
    if (this.jdField_a_of_type_Aasb != null) {
      this.jdField_a_of_type_Aasb.b();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public boolean resumePlayMusic()
  {
    this.jdField_a_of_type_Aasb.a().b();
    return true;
  }
  
  public void returnToAIO()
  {
    if ("Meizu_M040".equals(Build.MANUFACTURER + "_" + Build.MODEL))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Sensor", 2, "meizu mx2 returnToAIO");
      }
      new Handler().postDelayed(new SensorAPIJavaScript.5(this), 400L);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SensorAPIJavaScript", 2, String.format("returnToAIO mBrowserActivity=[%s]", new Object[] { this.jdField_a_of_type_AndroidAppActivity }));
      }
      return;
      returnToAio(this.jdField_a_of_type_Aasb, this.jdField_a_of_type_AndroidAppActivity, "", false);
    }
  }
  
  public void sendFunnyFace(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      int m = Integer.parseInt(paramString5);
      paramString1 = agej.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      paramString1.putExtra("indexOfFunnyFaceClickedInWebview", m);
      paramString2 = this.jdField_a_of_type_AndroidAppActivity.getIntent();
      if (paramString2 != null)
      {
        paramString2 = (SessionInfo)paramString2.getParcelableExtra("sessionInfo");
        if (paramString2 != null)
        {
          ChatActivityUtils.a(paramString2, paramString1);
          paramString1.putExtra("sessionInfo", paramString2);
          this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
        }
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public boolean setPlayMode(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return true;
        try
        {
          paramString = new JSONObject(paramString);
          int m = paramString.optInt("mode", -1);
          if (m != -1)
          {
            this.jdField_a_of_type_Aasb.a().a(m);
            return true;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "setPlayMode json err");
    return true;
  }
  
  public final void startAccelerometer(String paramString)
  {
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor"));
    }
    Object localObject = this.jdField_a_of_type_AndroidHardwareSensorManager.getSensorList(1);
    if (((List)localObject).size() > 0)
    {
      localObject = (Sensor)((List)localObject).get(0);
      if (this.jdField_a_of_type_Npj != null) {
        stopAccelerometer();
      }
      this.jdField_a_of_type_Npj = new npj(this, (byte)0, paramString);
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_Npj, (Sensor)localObject, 0);
      return;
    }
    callJs(paramString, new String[] { "false" });
  }
  
  public final void startCompass(String paramString)
  {
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor"));
    }
    Object localObject = this.jdField_a_of_type_AndroidHardwareSensorManager.getSensorList(3);
    if (((List)localObject).size() > 0)
    {
      localObject = (Sensor)((List)localObject).get(0);
      if (this.jdField_c_of_type_Npj != null) {
        stopCompass();
      }
      this.jdField_c_of_type_Npj = new npj(this, (byte)2, paramString);
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_c_of_type_Npj, (Sensor)localObject, 0);
      return;
    }
    callJs(paramString, new String[] { "false" });
  }
  
  public final void startLight(String paramString)
  {
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor"));
    }
    Object localObject = this.jdField_a_of_type_AndroidHardwareSensorManager.getSensorList(5);
    if (((List)localObject).size() > 0)
    {
      localObject = (Sensor)((List)localObject).get(0);
      if (this.jdField_b_of_type_Npj != null) {
        stopLight();
      }
      this.jdField_b_of_type_Npj = new npj(this, (byte)1, paramString);
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_b_of_type_Npj, (Sensor)localObject, 0);
      return;
    }
    callJs(paramString, new String[] { "false" });
  }
  
  public final void startListen(String paramString)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      callJs(paramString, new String[] { "false" });
      return;
    }
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity))
    {
      ((AppActivity)this.jdField_a_of_type_AndroidAppActivity).requestPermissions(new noz(this, paramString), 1, new String[] { "android.permission.RECORD_AUDIO" });
      return;
    }
    callJs(paramString, new String[] { "false", "{result: -1, msg: 'no record activity'}" });
  }
  
  public boolean startPlayMusic(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    try
    {
      new JSONObject(paramString);
      this.jdField_a_of_type_Aasb.a().a(paramString);
      return true;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "playQQMusic err:" + paramString);
      }
      localJSONException.printStackTrace();
    }
    return true;
  }
  
  public void startSyncData(String paramString1, String paramString2)
  {
    if (jdField_a_of_type_Nov == null) {
      jdField_a_of_type_Nov = new nov();
    }
    AppInterface localAppInterface = this.mRuntime.a();
    if (localAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SensorApi", 2, "appRuntime is null");
      }
      return;
    }
    jdField_a_of_type_Nov.a(paramString1, paramString2, localAppInterface, this.jdField_a_of_type_AndroidAppActivity, new npi(this));
  }
  
  public final void stopAccelerometer()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_a_of_type_Npj != null))
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_Npj);
      this.jdField_a_of_type_Npj = null;
    }
  }
  
  public void stopCompass()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_c_of_type_Npj != null))
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_c_of_type_Npj);
      this.jdField_c_of_type_Npj = null;
    }
  }
  
  public final void stopLight()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_b_of_type_Npj != null))
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_b_of_type_Npj);
      this.jdField_b_of_type_Npj = null;
    }
  }
  
  public final void stopListen()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaRecorder != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.release();
      this.jdField_a_of_type_AndroidMediaMediaRecorder = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(291);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean stopPlayMusic()
  {
    this.jdField_a_of_type_Aasb.a().c();
    return true;
  }
  
  public void stopSyncData()
  {
    if (jdField_a_of_type_Nov != null) {
      jdField_a_of_type_Nov.a();
    }
    jdField_a_of_type_Nov = null;
  }
  
  public final String systemName()
  {
    return "android";
  }
  
  public final String systemVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  public void updateMicStatus(String paramString)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaRecorder != null)
    {
      int m = (int)(Math.log10(this.jdField_a_of_type_AndroidMediaMediaRecorder.getMaxAmplitude()) * 20.0D);
      if (!TextUtils.isEmpty(paramString))
      {
        callJs(paramString, new String[] { "true", Integer.toString(m) });
        Message localMessage = new Message();
        localMessage.what = 291;
        localMessage.obj = paramString;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, this.l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript
 * JD-Core Version:    0.7.0.1
 */