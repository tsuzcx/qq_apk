package com.tencent.biz.game;

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
import android.net.wifi.WifiManager;
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
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.apiproxy.QQMusicClient;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troopplugin.PluginJumpManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webview.swift.JsWebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.VipComicUiInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.URLUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class SensorAPIJavaScript
  extends JsWebViewPlugin
{
  protected static MSFToWebViewConnector a;
  protected final byte a;
  protected final int a;
  protected Activity a;
  protected SensorManager a;
  protected MediaRecorder a;
  protected SoundPool a;
  protected Handler a;
  protected SensorAPIJavaScript.QQSensorEventListener a;
  TroopMemberApiClient a;
  protected Object a;
  protected String a;
  protected WeakReference<WebView> a;
  protected HashMap<String, Integer> a;
  protected boolean a;
  protected final byte b;
  protected final int b;
  protected SensorAPIJavaScript.QQSensorEventListener b;
  protected String b;
  protected boolean b;
  protected final byte c;
  protected final int c;
  protected SensorAPIJavaScript.QQSensorEventListener c;
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
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Byte = 0;
    this.jdField_b_of_type_Byte = 1;
    this.jdField_c_of_type_Byte = 2;
    this.jdField_a_of_type_Int = 8000;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  }
  
  private void a()
  {
    if (Looper.myLooper() == null) {
      Looper.prepare();
    }
    this.jdField_a_of_type_AndroidOsHandler = new SensorAPIJavaScript.2(this);
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
    String str1 = Build.MODEL;
    String str2 = Build.VERSION.RELEASE;
    String str3 = Build.FINGERPRINT;
    String str4 = Build.VERSION.INCREMENTAL;
    try
    {
      localObject = UserAction.getQIMEI();
      paramString = (String)localObject;
    }
    catch (Exception localException)
    {
      Object localObject;
      label27:
      label244:
      break label27;
    }
    if (QLog.isColorLevel()) {
      QLog.e(paramString, 2, "get QIMEI fail");
    }
    paramString = "";
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("model", str1);
      ((JSONObject)localObject).put("systemName", "android");
      ((JSONObject)localObject).put("systemVersion", str2);
      ((JSONObject)localObject).put("isMobileQQ", true);
      ((JSONObject)localObject).put("identifier", MobileInfoUtil.getImei());
      ((JSONObject)localObject).put("fingerprint", str3);
      ((JSONObject)localObject).put("incremental", str4);
      ((JSONObject)localObject).put("macAddress", MobileInfoUtil.getLocalMacAddress());
      ((JSONObject)localObject).put("androidID", Settings.Secure.getString(CommonDataAdapter.a().a().getContentResolver(), "android_id"));
      ((JSONObject)localObject).put("imsi", MobileInfoUtil.getImsi());
      ((JSONObject)localObject).put("qimei", paramString);
      ((JSONObject)localObject).put("totalMemory", String.valueOf(DeviceInfoUtil.a()));
      ((JSONObject)localObject).put("availableMemory", String.valueOf(DeviceInfoUtil.e()));
      ((JSONObject)localObject).put("cpuType", DeviceInfoUtil.g());
      ((JSONObject)localObject).put("cpuNum", DeviceInfoUtil.b());
      ((JSONObject)localObject).put("cpuFreq", DeviceInfoUtil.b());
      ((JSONObject)localObject).put("msfImei", MsfSdkUtils.getIMEIForMain("bussiness_id_customize_online_status"));
      paramString = ((JSONObject)localObject).toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      break label244;
    }
    return "{}";
  }
  
  public static MSFToWebViewConnector getMsfToWebViewConnector()
  {
    return jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector;
  }
  
  public static void returnToAio(TroopMemberApiClient paramTroopMemberApiClient, Activity paramActivity, String paramString, boolean paramBoolean)
  {
    if (paramTroopMemberApiClient == null) {
      return;
    }
    paramTroopMemberApiClient.f(new SensorAPIJavaScript.6(paramActivity, paramBoolean, paramString));
  }
  
  /* Error */
  protected final int a()
  {
    // Byte code:
    //   0: invokestatic 330	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: astore_1
    //   4: new 332	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   11: astore_2
    //   12: aload_2
    //   13: ldc_w 335
    //   16: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload_2
    //   21: ldc_w 341
    //   24: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_1
    //   29: aload_2
    //   30: invokevirtual 342	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokevirtual 346	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   36: astore_3
    //   37: aload_3
    //   38: invokevirtual 352	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   41: astore_1
    //   42: new 354	java/io/BufferedReader
    //   45: dup
    //   46: new 356	java/io/InputStreamReader
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 359	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   54: invokespecial 362	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   57: astore_2
    //   58: new 364	java/lang/StringBuffer
    //   61: dup
    //   62: invokespecial 365	java/lang/StringBuffer:<init>	()V
    //   65: astore 4
    //   67: aload_2
    //   68: invokevirtual 368	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   71: astore 5
    //   73: aload 5
    //   75: ifnull +14 -> 89
    //   78: aload 4
    //   80: aload 5
    //   82: invokevirtual 371	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   85: pop
    //   86: goto -19 -> 67
    //   89: invokestatic 374	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   92: ifeq +44 -> 136
    //   95: new 332	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   102: astore 5
    //   104: aload 5
    //   106: ldc_w 376
    //   109: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 5
    //   115: aload 4
    //   117: invokevirtual 377	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   120: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: ldc_w 379
    //   127: iconst_4
    //   128: aload 5
    //   130: invokevirtual 342	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 381	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: aload_3
    //   137: invokevirtual 384	java/lang/Process:waitFor	()I
    //   140: ifne +73 -> 213
    //   143: invokestatic 374	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   146: ifeq +38 -> 184
    //   149: new 332	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   156: astore_3
    //   157: aload_3
    //   158: ldc_w 386
    //   161: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_3
    //   166: ldc_w 388
    //   169: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: ldc_w 379
    //   176: iconst_4
    //   177: aload_3
    //   178: invokevirtual 342	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 381	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload_2
    //   185: invokevirtual 391	java/io/BufferedReader:close	()V
    //   188: goto +8 -> 196
    //   191: astore_2
    //   192: aload_2
    //   193: invokevirtual 392	java/io/IOException:printStackTrace	()V
    //   196: aload_1
    //   197: ifnull +14 -> 211
    //   200: aload_1
    //   201: invokevirtual 395	java/io/InputStream:close	()V
    //   204: iconst_0
    //   205: ireturn
    //   206: astore_1
    //   207: aload_1
    //   208: invokevirtual 392	java/io/IOException:printStackTrace	()V
    //   211: iconst_0
    //   212: ireturn
    //   213: invokestatic 374	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   216: ifeq +38 -> 254
    //   219: new 332	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   226: astore_3
    //   227: aload_3
    //   228: ldc_w 386
    //   231: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_3
    //   236: ldc_w 397
    //   239: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: ldc_w 379
    //   246: iconst_4
    //   247: aload_3
    //   248: invokevirtual 342	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 381	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: aload_2
    //   255: invokevirtual 391	java/io/BufferedReader:close	()V
    //   258: goto +8 -> 266
    //   261: astore_2
    //   262: aload_2
    //   263: invokevirtual 392	java/io/IOException:printStackTrace	()V
    //   266: aload_1
    //   267: ifnull +183 -> 450
    //   270: aload_1
    //   271: invokevirtual 395	java/io/InputStream:close	()V
    //   274: goto +176 -> 450
    //   277: astore_2
    //   278: aconst_null
    //   279: astore_3
    //   280: goto +179 -> 459
    //   283: aconst_null
    //   284: astore_2
    //   285: goto +20 -> 305
    //   288: aconst_null
    //   289: astore_2
    //   290: goto +87 -> 377
    //   293: astore_2
    //   294: aconst_null
    //   295: astore_1
    //   296: aload_1
    //   297: astore_3
    //   298: goto +161 -> 459
    //   301: aconst_null
    //   302: astore_1
    //   303: aload_1
    //   304: astore_2
    //   305: invokestatic 374	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   308: ifeq +38 -> 346
    //   311: new 332	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   318: astore_3
    //   319: aload_3
    //   320: ldc_w 386
    //   323: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload_3
    //   328: ldc_w 399
    //   331: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: ldc_w 379
    //   338: iconst_4
    //   339: aload_3
    //   340: invokevirtual 342	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 381	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: aload_2
    //   347: ifnull +15 -> 362
    //   350: aload_2
    //   351: invokevirtual 391	java/io/BufferedReader:close	()V
    //   354: goto +8 -> 362
    //   357: astore_2
    //   358: aload_2
    //   359: invokevirtual 392	java/io/IOException:printStackTrace	()V
    //   362: aload_1
    //   363: ifnull +87 -> 450
    //   366: aload_1
    //   367: invokevirtual 395	java/io/InputStream:close	()V
    //   370: goto +80 -> 450
    //   373: aconst_null
    //   374: astore_1
    //   375: aload_1
    //   376: astore_2
    //   377: invokestatic 374	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   380: ifeq +38 -> 418
    //   383: new 332	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   390: astore_3
    //   391: aload_3
    //   392: ldc_w 386
    //   395: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload_3
    //   400: ldc_w 401
    //   403: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: ldc_w 379
    //   410: iconst_4
    //   411: aload_3
    //   412: invokevirtual 342	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 381	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: aload_2
    //   419: ifnull +15 -> 434
    //   422: aload_2
    //   423: invokevirtual 391	java/io/BufferedReader:close	()V
    //   426: goto +8 -> 434
    //   429: astore_2
    //   430: aload_2
    //   431: invokevirtual 392	java/io/IOException:printStackTrace	()V
    //   434: aload_1
    //   435: ifnull +15 -> 450
    //   438: aload_1
    //   439: invokevirtual 395	java/io/InputStream:close	()V
    //   442: goto +8 -> 450
    //   445: astore_1
    //   446: aload_1
    //   447: invokevirtual 392	java/io/IOException:printStackTrace	()V
    //   450: iconst_1
    //   451: ireturn
    //   452: astore 4
    //   454: aload_2
    //   455: astore_3
    //   456: aload 4
    //   458: astore_2
    //   459: invokestatic 374	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   462: ifeq +40 -> 502
    //   465: new 332	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   472: astore 4
    //   474: aload 4
    //   476: ldc_w 386
    //   479: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload 4
    //   485: aconst_null
    //   486: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: ldc_w 379
    //   493: iconst_4
    //   494: aload 4
    //   496: invokevirtual 342	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 381	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   502: aload_3
    //   503: ifnull +15 -> 518
    //   506: aload_3
    //   507: invokevirtual 391	java/io/BufferedReader:close	()V
    //   510: goto +8 -> 518
    //   513: astore_3
    //   514: aload_3
    //   515: invokevirtual 392	java/io/IOException:printStackTrace	()V
    //   518: aload_1
    //   519: ifnull +15 -> 534
    //   522: aload_1
    //   523: invokevirtual 395	java/io/InputStream:close	()V
    //   526: goto +8 -> 534
    //   529: astore_1
    //   530: aload_1
    //   531: invokevirtual 392	java/io/IOException:printStackTrace	()V
    //   534: goto +5 -> 539
    //   537: aload_2
    //   538: athrow
    //   539: goto -2 -> 537
    //   542: astore_1
    //   543: goto -170 -> 373
    //   546: astore_1
    //   547: goto -246 -> 301
    //   550: astore_2
    //   551: goto -263 -> 288
    //   554: astore_2
    //   555: goto -272 -> 283
    //   558: astore_3
    //   559: goto -182 -> 377
    //   562: astore_3
    //   563: goto -258 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	566	0	this	SensorAPIJavaScript
    //   3	198	1	localObject1	Object
    //   206	65	1	localIOException1	java.io.IOException
    //   295	144	1	localObject2	Object
    //   445	78	1	localIOException2	java.io.IOException
    //   529	2	1	localIOException3	java.io.IOException
    //   542	1	1	localIOException4	java.io.IOException
    //   546	1	1	localInterruptedException1	java.lang.InterruptedException
    //   11	174	2	localObject3	Object
    //   191	64	2	localIOException5	java.io.IOException
    //   261	2	2	localIOException6	java.io.IOException
    //   277	1	2	localObject4	Object
    //   284	6	2	localObject5	Object
    //   293	1	2	localObject6	Object
    //   304	47	2	localObject7	Object
    //   357	2	2	localIOException7	java.io.IOException
    //   376	47	2	localObject8	Object
    //   429	26	2	localIOException8	java.io.IOException
    //   458	80	2	localObject9	Object
    //   550	1	2	localIOException9	java.io.IOException
    //   554	1	2	localInterruptedException2	java.lang.InterruptedException
    //   36	471	3	localObject10	Object
    //   513	2	3	localIOException10	java.io.IOException
    //   558	1	3	localIOException11	java.io.IOException
    //   562	1	3	localInterruptedException3	java.lang.InterruptedException
    //   65	51	4	localStringBuffer	java.lang.StringBuffer
    //   452	5	4	localObject11	Object
    //   472	23	4	localStringBuilder	StringBuilder
    //   71	58	5	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   184	188	191	java/io/IOException
    //   200	204	206	java/io/IOException
    //   254	258	261	java/io/IOException
    //   42	58	277	finally
    //   0	42	293	finally
    //   350	354	357	java/io/IOException
    //   422	426	429	java/io/IOException
    //   270	274	445	java/io/IOException
    //   366	370	445	java/io/IOException
    //   438	442	445	java/io/IOException
    //   58	67	452	finally
    //   67	73	452	finally
    //   78	86	452	finally
    //   89	136	452	finally
    //   136	143	452	finally
    //   506	510	513	java/io/IOException
    //   522	526	529	java/io/IOException
    //   0	42	542	java/io/IOException
    //   0	42	546	java/lang/InterruptedException
    //   42	58	550	java/io/IOException
    //   42	58	554	java/lang/InterruptedException
    //   58	67	558	java/io/IOException
    //   67	73	558	java/io/IOException
    //   78	86	558	java/io/IOException
    //   89	136	558	java/io/IOException
    //   136	143	558	java/io/IOException
    //   58	67	562	java/lang/InterruptedException
    //   67	73	562	java/lang/InterruptedException
    //   78	86	562	java/lang/InterruptedException
    //   89	136	562	java/lang/InterruptedException
    //   136	143	562	java/lang/InterruptedException
  }
  
  void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SensorApi", 4, "start checkWifiStatus");
    }
    new SensorAPIJavaScript.11(this, this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), paramString).start();
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    HtmlOffline.a(paramString1, this.mRuntime.a(), new SensorAPIJavaScript.8(this, paramString2), false);
  }
  
  public void connectToWiFi(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      try
      {
        String str1 = localJSONObject.getString("ssid");
        String str2 = localJSONObject.getString("type");
        String str3 = localJSONObject.getString("callback");
        try
        {
          paramString = localJSONObject.getString("password");
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          paramString = "";
        }
        boolean bool;
        try
        {
          bool = localJSONObject.getBoolean("isHidden");
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          bool = false;
        }
        if (this.jdField_c_of_type_Boolean)
        {
          callJs(str3, new String[] { "4" });
          return;
        }
        if (!TextUtils.isEmpty(str3))
        {
          if (this.jdField_a_of_type_AndroidAppActivity == null) {
            return;
          }
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
          {
            WifiManager localWifiManager = (WifiManager)this.jdField_a_of_type_AndroidAppActivity.getApplicationContext().getSystemService("wifi");
            if (localWifiManager == null)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("SensorApi", 4, "No WifiManager available from device");
              }
              callJs(str3, new String[] { "2" });
              return;
            }
            this.jdField_c_of_type_Boolean = true;
            new SensorAPIJavaScript.10(this, str2, str1, paramString, bool, localWifiManager, str3).start();
            return;
          }
          callJs(str3, new String[] { "3" });
        }
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
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
    if (!TextUtils.isEmpty(paramString1))
    {
      if (paramString1.length() > 10) {
        return;
      }
      paramString2 = new ArrayList();
      paramString2.add(paramString1);
      paramString2 = new HashMap(paramString2.size());
      paramString2.put(paramString1, "0");
      HtmlOffline.a(this.mRuntime.a(), paramString2, new SensorAPIJavaScript.7(this, paramString4), true, true, false);
    }
  }
  
  public final String getClientInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"qqVersion\":\"");
    localStringBuilder.append(qqVersion());
    localStringBuilder.append("\",\"qqBuild\":\"");
    localStringBuilder.append("5295");
    localStringBuilder.append("\"}");
    return localStringBuilder.toString();
  }
  
  public boolean getCurrentSong(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    try
    {
      paramString = new JSONObject(paramString);
      paramString = paramString.optString("callback");
      if (TextUtils.isEmpty(paramString)) {
        return true;
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().c(new SensorAPIJavaScript.14(this, paramString));
      return true;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "getCurrentSong json err");
      }
    }
    return true;
  }
  
  public final String getDeviceInfo()
  {
    return getDeviceInfoEx(this.TAG);
  }
  
  protected String getNameSpace()
  {
    return "qbizApi";
  }
  
  public JSONObject getNetworkInfo()
  {
    int i1 = HttpUtil.getNetWorkType();
    String str = HttpUtil.getNetWorkTypeByStr();
    Object localObject = DeviceInfoUtil.b();
    boolean bool = TextUtils.isEmpty((CharSequence)localObject);
    int n = 3;
    if ((!bool) && (((String)localObject).length() > 5) && (((String)localObject).startsWith("460")))
    {
      localObject = ((String)localObject).substring(3, 5);
      if ((!((String)localObject).equals("00")) && (!((String)localObject).equals("02")) && (!((String)localObject).equals("04")) && (!((String)localObject).equals("07")))
      {
        if ((!((String)localObject).equals("01")) && (!((String)localObject).equals("06")) && (!((String)localObject).equals("09")))
        {
          m = n;
          if (((String)localObject).equals("03")) {
            break label197;
          }
          if (((String)localObject).equals("05"))
          {
            m = n;
            break label197;
          }
          if (((String)localObject).equals("20"))
          {
            m = 4;
            break label197;
          }
        }
        else
        {
          m = 2;
          break label197;
        }
      }
      else
      {
        m = 1;
        break label197;
      }
    }
    int m = 0;
    label197:
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
      localJSONException.printStackTrace();
    }
    return localObject;
  }
  
  public int getNetworkType()
  {
    return HttpUtil.getNetWorkType();
  }
  
  public boolean getPlayMode(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    try
    {
      paramString = new JSONObject(paramString);
      paramString = paramString.optString("callback");
      if (TextUtils.isEmpty(paramString)) {
        return true;
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().b(new SensorAPIJavaScript.13(this, paramString));
      return true;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "getPlayMode json err");
      }
    }
    return true;
  }
  
  public boolean getPlayState(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    try
    {
      paramString = new JSONObject(paramString);
      paramString = paramString.optString("callback");
      if (TextUtils.isEmpty(paramString)) {
        return true;
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().a(new SensorAPIJavaScript.12(this, paramString));
      return true;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "getPlayState json err");
      }
    }
    return true;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 4L;
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
    paramString1 = HtmlOffline.a(paramString1);
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
      if (paramInt != 0) {
        break label66;
      }
      str = "success";
      break label36;
      if (paramInt == 5) {
        str = "had update ";
      }
    }
    for (;;)
    {
      label36:
      callJs(this.jdField_a_of_type_JavaLangString, new String[] { Integer.toString(paramInt), Util.a(str) });
      return true;
      return false;
      label66:
      if (paramInt == 1)
      {
        str = "param error";
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
    if (paramInt != -1) {
      return;
    }
    if ((paramByte == 1) && (paramIntent != null) && (paramIntent.getBooleanExtra("closeSpecialLogic", false)))
    {
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      Activity localActivity = this.mRuntime.a();
      if (localActivity != null)
      {
        localActivity.setResult(-1, paramIntent);
        localActivity.finish();
      }
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    a();
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
    if (this.mRuntime.a() != null) {
      this.jdField_b_of_type_JavaLangString = this.mRuntime.a().getCurrentAccountUin();
    }
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
  }
  
  public void onDestroy()
  {
    release();
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.mRuntime.a());
  }
  
  public final void openLinkInNewWebView(String paramString1, String paramString2)
  {
    PluginJumpManager.getInstance().updateConfig(((QBaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime());
    PluginJumpManager.getInstance().loadConfig();
    if (PluginJumpManager.getInstance().openView(this.jdField_a_of_type_AndroidAppActivity, paramString1, paramString2)) {
      return;
    }
    Bundle localBundle1;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      Bundle localBundle2 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
      if (localBundle2 == null)
      {
        localBundle1 = new Bundle();
      }
      else
      {
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
      }
    }
    try
    {
      m = Integer.valueOf(paramString2).intValue();
    }
    catch (Exception paramString2)
    {
      int m;
      label154:
      break label154;
    }
    m = 0;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m == 3)
          {
            localBundle1.putBoolean("hide_more_button", true);
            localBundle1.putBoolean("hide_operation_bar", false);
            localBundle1.putString("webStyle", "");
          }
        }
        else
        {
          localBundle1.putBoolean("hide_more_button", false);
          localBundle1.putBoolean("hide_operation_bar", false);
          localBundle1.putString("webStyle", "");
        }
      }
      else
      {
        localBundle1.putBoolean("hide_more_button", true);
        localBundle1.putBoolean("hide_operation_bar", true);
      }
    }
    else
    {
      localBundle1.putBoolean("hide_more_button", false);
      localBundle1.putBoolean("hide_operation_bar", true);
    }
    paramString2 = this.jdField_a_of_type_AndroidAppActivity;
    paramString2 = new Intent(paramString2, paramString2.getClass());
    paramString2.putExtras(localBundle1);
    paramString2.putExtra("url", paramString1);
    paramString2.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramString2.setFlags(0);
    paramString1 = this.mRuntime.a(this.mRuntime.a());
    if ((paramString1 != null) && ((paramString1 instanceof WebUiUtils.WebUiMethodInterface)))
    {
      paramString1 = ((WebUiUtils.WebUiMethodInterface)paramString1).getCurrentUrl();
      if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("closeSpecialLogic")) && (URLUtil.a(URLUtil.a(paramString1), "closeSpecialLogic", 0) != 0)) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
    if (this.jdField_a_of_type_Boolean)
    {
      startActivityForResult(paramString2, (byte)1);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramString2, 100);
  }
  
  public boolean pausePlayMusic()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().a();
    return true;
  }
  
  public final void phoneVibrate(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.valueOf(paramString).longValue();
      l1 = l2;
    }
    catch (Exception paramString)
    {
      label22:
      break label22;
    }
    paramString = (Vibrator)this.jdField_a_of_type_AndroidAppActivity.getSystemService("vibrator");
    if (paramString == null) {
      return;
    }
    paramString.vibrate(l1);
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(8)
  public boolean playVoice(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidMediaSoundPool == null) {
      this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(10, 3, 0);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    int m;
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString2))
    {
      if (!preloadVoice(paramString1, paramString2, null)) {
        return false;
      }
      if (Build.VERSION.SDK_INT >= 8)
      {
        this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new SensorAPIJavaScript.3(this, paramString2));
      }
      else
      {
        m = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2)).intValue();
        paramString1 = this.jdField_a_of_type_AndroidOsHandler;
        if (paramString1 != null) {
          paramString1.postDelayed(new SensorAPIJavaScript.4(this, m, paramString2), 200L);
        }
      }
    }
    else
    {
      m = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2)).intValue();
      if (this.jdField_a_of_type_AndroidMediaSoundPool.play(m, 1.0F, 1.0F, 0, 0, 1.0F) == 0)
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("play failure url=");
          paramString1.append(paramString2);
          QLog.d("SensorApi", 2, paramString1.toString());
        }
        return false;
      }
    }
    return true;
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(8)
  public boolean preloadVoice(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString3 = this.jdField_a_of_type_JavaUtilHashMap;
      if ((paramString3 != null) && (paramString3.containsKey(paramString2))) {
        return false;
      }
      paramString3 = new StringBuilder();
      paramString3.append(Environment.getExternalStorageDirectory().getAbsolutePath());
      paramString3.append(File.separator);
      paramString3.toString();
      paramString3 = new StringBuilder();
      paramString3.append(OfflineEnvHelper.b());
      paramString3.append(paramString1);
      paramString3.append('/');
      paramString1 = Uri.parse(paramString2).getScheme();
      if (paramString1 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("://");
        paramString1 = localStringBuilder.toString();
      }
      else
      {
        paramString1 = "";
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
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("load failure url=");
          paramString1.append(paramString2);
          QLog.d("SensorApi", 2, paramString1.toString());
        }
        return false;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString2, Integer.valueOf(m));
      return true;
    }
    return false;
  }
  
  public final String qqVersion()
  {
    try
    {
      Object localObject = this.mRuntime.a(this.mRuntime.a());
      if ((localObject != null) && ((localObject instanceof WebUiUtils.VipComicUiInterface))) {
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
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (WebView)((WeakReference)localObject).get();
      if (localObject != null) {
        ((WebView)localObject).loadUrl(((WebView)localObject).getUrl());
      }
    }
  }
  
  public void release()
  {
    Object localObject = this.jdField_a_of_type_AndroidMediaSoundPool;
    if (localObject != null)
    {
      ((SoundPool)localObject).release();
      this.jdField_a_of_type_AndroidMediaSoundPool = null;
    }
    localObject = jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector;
    if (localObject != null)
    {
      ((MSFToWebViewConnector)localObject).a();
      jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector = null;
    }
    stopAccelerometer();
    stopCompass();
    stopListen();
    stopLight();
    localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null) {
      ((WeakReference)localObject).clear();
    }
    localObject = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
    if (localObject != null) {
      ((TroopMemberApiClient)localObject).b();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public boolean resumePlayMusic()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().b();
    return true;
  }
  
  public void returnToAIO()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append("_");
    localStringBuilder.append(Build.MODEL);
    if ("Meizu_M040".equals(localStringBuilder.toString()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Sensor", 2, "meizu mx2 returnToAIO");
      }
      new Handler().postDelayed(new SensorAPIJavaScript.5(this), 400L);
    }
    else
    {
      returnToAio(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient, this.jdField_a_of_type_AndroidAppActivity, "", false);
    }
    if (QLog.isColorLevel()) {
      QLog.i("SensorAPIJavaScript", 2, String.format("returnToAIO mBrowserActivity=[%s]", new Object[] { this.jdField_a_of_type_AndroidAppActivity }));
    }
  }
  
  public void sendFunnyFace(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      int m = Integer.parseInt(paramString5);
      paramString1 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
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
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    try
    {
      paramString = new JSONObject(paramString);
      int m = paramString.optInt("mode", -1);
      if (m == -1) {
        return true;
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().a(m);
      return true;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "setPlayMode json err");
      }
    }
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
      if (this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener != null) {
        stopAccelerometer();
      }
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener = new SensorAPIJavaScript.QQSensorEventListener(this, (byte)0, paramString);
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener, (Sensor)localObject, 0);
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
      if (this.jdField_c_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener != null) {
        stopCompass();
      }
      this.jdField_c_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener = new SensorAPIJavaScript.QQSensorEventListener(this, (byte)2, paramString);
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_c_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener, (Sensor)localObject, 0);
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
      if (this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener != null) {
        stopLight();
      }
      this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener = new SensorAPIJavaScript.QQSensorEventListener(this, (byte)1, paramString);
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener, (Sensor)localObject, 0);
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
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if ((localActivity instanceof AppActivity))
    {
      ((AppActivity)localActivity).requestPermissions(new SensorAPIJavaScript.1(this, paramString), 1, new String[] { "android.permission.RECORD_AUDIO" });
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
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().a(paramString);
      return true;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel())
      {
        String str = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("playQQMusic err:");
        localStringBuilder.append(paramString);
        QLog.i(str, 2, localStringBuilder.toString());
      }
      localJSONException.printStackTrace();
    }
    return true;
  }
  
  public void startSyncData(String paramString1, String paramString2)
  {
    if (jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector == null) {
      jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector = new MSFToWebViewConnector();
    }
    AppInterface localAppInterface = this.mRuntime.a();
    if (localAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SensorApi", 2, "appRuntime is null");
      }
      return;
    }
    jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector.a(paramString1, paramString2, localAppInterface, this.jdField_a_of_type_AndroidAppActivity, new SensorAPIJavaScript.9(this));
  }
  
  public final void stopAccelerometer()
  {
    SensorManager localSensorManager = this.jdField_a_of_type_AndroidHardwareSensorManager;
    if (localSensorManager != null)
    {
      SensorAPIJavaScript.QQSensorEventListener localQQSensorEventListener = this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener;
      if (localQQSensorEventListener != null)
      {
        localSensorManager.unregisterListener(localQQSensorEventListener);
        this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener = null;
      }
    }
  }
  
  public void stopCompass()
  {
    SensorManager localSensorManager = this.jdField_a_of_type_AndroidHardwareSensorManager;
    if (localSensorManager != null)
    {
      SensorAPIJavaScript.QQSensorEventListener localQQSensorEventListener = this.jdField_c_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener;
      if (localQQSensorEventListener != null)
      {
        localSensorManager.unregisterListener(localQQSensorEventListener);
        this.jdField_c_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener = null;
      }
    }
  }
  
  public final void stopLight()
  {
    SensorManager localSensorManager = this.jdField_a_of_type_AndroidHardwareSensorManager;
    if (localSensorManager != null)
    {
      SensorAPIJavaScript.QQSensorEventListener localQQSensorEventListener = this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener;
      if (localQQSensorEventListener != null)
      {
        localSensorManager.unregisterListener(localQQSensorEventListener);
        this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener = null;
      }
    }
  }
  
  public final void stopListen()
  {
    MediaRecorder localMediaRecorder = this.jdField_a_of_type_AndroidMediaMediaRecorder;
    if (localMediaRecorder != null)
    {
      localMediaRecorder.release();
      this.jdField_a_of_type_AndroidMediaMediaRecorder = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(291);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean stopPlayMusic()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().c();
    return true;
  }
  
  public void stopSyncData()
  {
    MSFToWebViewConnector localMSFToWebViewConnector = jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector;
    if (localMSFToWebViewConnector != null) {
      localMSFToWebViewConnector.a();
    }
    jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector = null;
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
    Object localObject = this.jdField_a_of_type_AndroidMediaMediaRecorder;
    if (localObject != null)
    {
      int m = (int)(Math.log10(((MediaRecorder)localObject).getMaxAmplitude()) * 20.0D);
      if (!TextUtils.isEmpty(paramString))
      {
        callJs(paramString, new String[] { "true", Integer.toString(m) });
        localObject = new Message();
        ((Message)localObject).what = 291;
        ((Message)localObject).obj = paramString;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, this.l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript
 * JD-Core Version:    0.7.0.1
 */