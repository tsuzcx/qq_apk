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
import com.tencent.mobileqq.app.BaseActivity;
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
import kmz;
import kna;
import knb;
import knc;
import knd;
import kne;
import knf;
import kng;
import knh;
import kni;
import knj;
import knk;
import org.json.JSONException;
import org.json.JSONObject;

public class SensorAPIJavaScript
  extends JsWebViewPlugin
{
  public static MSFToWebViewConnector a;
  protected final byte a;
  protected final int a;
  public Activity a;
  protected SensorManager a;
  protected MediaRecorder a;
  public SoundPool a;
  public Handler a;
  protected SensorAPIJavaScript.QQSensorEventListener a;
  public TroopMemberApiClient a;
  protected Object a;
  public String a;
  public WeakReference a;
  protected HashMap a;
  protected boolean a;
  protected final byte b;
  protected final int b;
  protected SensorAPIJavaScript.QQSensorEventListener b;
  protected String b;
  protected boolean b;
  protected final byte c;
  protected final int c;
  protected SensorAPIJavaScript.QQSensorEventListener c;
  public boolean c;
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
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  }
  
  private void a()
  {
    if (Looper.myLooper() == null) {
      Looper.prepare();
    }
    this.jdField_a_of_type_AndroidOsHandler = new kmz(this);
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
    paramTroopMemberApiClient.f(new knh(paramActivity, paramBoolean, paramString));
  }
  
  /* Error */
  public final int a()
  {
    // Byte code:
    //   0: invokestatic 120	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: new 122	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   10: ldc 125
    //   12: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: ldc 131
    //   17: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokevirtual 139	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   26: astore 4
    //   28: aload 4
    //   30: invokevirtual 145	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   33: astore_2
    //   34: new 147	java/io/BufferedReader
    //   37: dup
    //   38: new 149	java/io/InputStreamReader
    //   41: dup
    //   42: aload_2
    //   43: invokespecial 152	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   46: invokespecial 155	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   49: astore_3
    //   50: new 157	java/lang/StringBuffer
    //   53: dup
    //   54: invokespecial 158	java/lang/StringBuffer:<init>	()V
    //   57: astore 5
    //   59: aload_3
    //   60: invokevirtual 161	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   63: astore 6
    //   65: aload 6
    //   67: ifnull +76 -> 143
    //   70: aload 5
    //   72: aload 6
    //   74: invokevirtual 164	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   77: pop
    //   78: goto -19 -> 59
    //   81: astore 4
    //   83: aload_3
    //   84: astore 4
    //   86: aload_2
    //   87: astore_3
    //   88: aload 4
    //   90: astore_2
    //   91: invokestatic 170	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   94: ifeq +29 -> 123
    //   97: ldc 172
    //   99: iconst_4
    //   100: new 122	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   107: ldc 174
    //   109: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc 176
    //   114: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 182	java/io/BufferedReader:close	()V
    //   131: aload_3
    //   132: ifnull +7 -> 139
    //   135: aload_3
    //   136: invokevirtual 185	java/io/InputStream:close	()V
    //   139: iconst_1
    //   140: istore_1
    //   141: iload_1
    //   142: ireturn
    //   143: invokestatic 170	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   146: ifeq +32 -> 178
    //   149: ldc 172
    //   151: iconst_4
    //   152: new 122	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   159: ldc 187
    //   161: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload 5
    //   166: invokevirtual 188	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   169: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: aload 4
    //   180: invokevirtual 191	java/lang/Process:waitFor	()I
    //   183: ifne +70 -> 253
    //   186: iconst_0
    //   187: istore_1
    //   188: invokestatic 170	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   191: ifeq +29 -> 220
    //   194: ldc 172
    //   196: iconst_4
    //   197: new 122	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   204: ldc 174
    //   206: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc 193
    //   211: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_3
    //   221: ifnull +7 -> 228
    //   224: aload_3
    //   225: invokevirtual 182	java/io/BufferedReader:close	()V
    //   228: aload_2
    //   229: ifnull -88 -> 141
    //   232: aload_2
    //   233: invokevirtual 185	java/io/InputStream:close	()V
    //   236: iconst_0
    //   237: ireturn
    //   238: astore_2
    //   239: aload_2
    //   240: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   243: iconst_0
    //   244: ireturn
    //   245: astore_3
    //   246: aload_3
    //   247: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   250: goto -22 -> 228
    //   253: invokestatic 170	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   256: ifeq +29 -> 285
    //   259: ldc 172
    //   261: iconst_4
    //   262: new 122	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   269: ldc 174
    //   271: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc 198
    //   276: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: aload_3
    //   286: ifnull +7 -> 293
    //   289: aload_3
    //   290: invokevirtual 182	java/io/BufferedReader:close	()V
    //   293: aload_2
    //   294: ifnull -155 -> 139
    //   297: aload_2
    //   298: invokevirtual 185	java/io/InputStream:close	()V
    //   301: goto -162 -> 139
    //   304: astore_2
    //   305: aload_2
    //   306: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   309: goto -170 -> 139
    //   312: astore_3
    //   313: aload_3
    //   314: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   317: goto -24 -> 293
    //   320: astore_2
    //   321: aload_2
    //   322: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   325: goto -194 -> 131
    //   328: astore_2
    //   329: aload_2
    //   330: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   333: goto -194 -> 139
    //   336: astore_2
    //   337: aconst_null
    //   338: astore_3
    //   339: aconst_null
    //   340: astore_2
    //   341: invokestatic 170	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   344: ifeq +29 -> 373
    //   347: ldc 172
    //   349: iconst_4
    //   350: new 122	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   357: ldc 174
    //   359: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: ldc 200
    //   364: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: aload_3
    //   374: ifnull +7 -> 381
    //   377: aload_3
    //   378: invokevirtual 182	java/io/BufferedReader:close	()V
    //   381: aload_2
    //   382: ifnull -243 -> 139
    //   385: aload_2
    //   386: invokevirtual 185	java/io/InputStream:close	()V
    //   389: goto -250 -> 139
    //   392: astore_2
    //   393: aload_2
    //   394: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   397: goto -258 -> 139
    //   400: astore_3
    //   401: aload_3
    //   402: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   405: goto -24 -> 381
    //   408: astore 4
    //   410: aconst_null
    //   411: astore_3
    //   412: aconst_null
    //   413: astore_2
    //   414: invokestatic 170	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   417: ifeq +28 -> 445
    //   420: ldc 172
    //   422: iconst_4
    //   423: new 122	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   430: ldc 174
    //   432: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aconst_null
    //   436: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: aload_3
    //   446: ifnull +7 -> 453
    //   449: aload_3
    //   450: invokevirtual 182	java/io/BufferedReader:close	()V
    //   453: aload_2
    //   454: ifnull +7 -> 461
    //   457: aload_2
    //   458: invokevirtual 185	java/io/InputStream:close	()V
    //   461: aload 4
    //   463: athrow
    //   464: astore_3
    //   465: aload_3
    //   466: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   469: goto -16 -> 453
    //   472: astore_2
    //   473: aload_2
    //   474: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   477: goto -16 -> 461
    //   480: astore 4
    //   482: aconst_null
    //   483: astore_3
    //   484: goto -70 -> 414
    //   487: astore 4
    //   489: goto -75 -> 414
    //   492: astore_3
    //   493: aconst_null
    //   494: astore_3
    //   495: goto -154 -> 341
    //   498: astore 4
    //   500: goto -159 -> 341
    //   503: astore_2
    //   504: aconst_null
    //   505: astore_2
    //   506: aconst_null
    //   507: astore_3
    //   508: goto -417 -> 91
    //   511: astore_3
    //   512: aconst_null
    //   513: astore 4
    //   515: aload_2
    //   516: astore_3
    //   517: aload 4
    //   519: astore_2
    //   520: goto -429 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	this	SensorAPIJavaScript
    //   140	48	1	m	int
    //   33	200	2	localObject1	Object
    //   238	60	2	localIOException1	java.io.IOException
    //   304	2	2	localIOException2	java.io.IOException
    //   320	2	2	localIOException3	java.io.IOException
    //   328	2	2	localIOException4	java.io.IOException
    //   336	1	2	localInterruptedException1	java.lang.InterruptedException
    //   340	46	2	localObject2	Object
    //   392	2	2	localIOException5	java.io.IOException
    //   413	45	2	localObject3	Object
    //   472	2	2	localIOException6	java.io.IOException
    //   503	1	2	localIOException7	java.io.IOException
    //   505	15	2	localObject4	Object
    //   49	176	3	localObject5	Object
    //   245	45	3	localIOException8	java.io.IOException
    //   312	2	3	localIOException9	java.io.IOException
    //   338	40	3	localObject6	Object
    //   400	2	3	localIOException10	java.io.IOException
    //   411	39	3	localObject7	Object
    //   464	2	3	localIOException11	java.io.IOException
    //   483	1	3	localObject8	Object
    //   492	1	3	localInterruptedException2	java.lang.InterruptedException
    //   494	14	3	localObject9	Object
    //   511	1	3	localIOException12	java.io.IOException
    //   516	1	3	localObject10	Object
    //   26	3	4	localProcess	java.lang.Process
    //   81	1	4	localIOException13	java.io.IOException
    //   84	95	4	localObject11	Object
    //   408	54	4	localObject12	Object
    //   480	1	4	localObject13	Object
    //   487	1	4	localObject14	Object
    //   498	1	4	localInterruptedException3	java.lang.InterruptedException
    //   513	5	4	localObject15	Object
    //   57	108	5	localStringBuffer	java.lang.StringBuffer
    //   63	10	6	str	String
    // Exception table:
    //   from	to	target	type
    //   50	59	81	java/io/IOException
    //   59	65	81	java/io/IOException
    //   70	78	81	java/io/IOException
    //   143	178	81	java/io/IOException
    //   178	186	81	java/io/IOException
    //   232	236	238	java/io/IOException
    //   224	228	245	java/io/IOException
    //   297	301	304	java/io/IOException
    //   289	293	312	java/io/IOException
    //   127	131	320	java/io/IOException
    //   135	139	328	java/io/IOException
    //   0	34	336	java/lang/InterruptedException
    //   385	389	392	java/io/IOException
    //   377	381	400	java/io/IOException
    //   0	34	408	finally
    //   449	453	464	java/io/IOException
    //   457	461	472	java/io/IOException
    //   34	50	480	finally
    //   50	59	487	finally
    //   59	65	487	finally
    //   70	78	487	finally
    //   143	178	487	finally
    //   178	186	487	finally
    //   34	50	492	java/lang/InterruptedException
    //   50	59	498	java/lang/InterruptedException
    //   59	65	498	java/lang/InterruptedException
    //   70	78	498	java/lang/InterruptedException
    //   143	178	498	java/lang/InterruptedException
    //   178	186	498	java/lang/InterruptedException
    //   0	34	503	java/io/IOException
    //   34	50	511	java/io/IOException
  }
  
  public void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SensorApi", 4, "start checkWifiStatus");
    }
    new kna(this, this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), paramString).start();
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    HtmlOffline.a(paramString1, this.mRuntime.a(), new knj(this, paramString2), false);
  }
  
  /* Error */
  public void connectToWiFi(String paramString)
  {
    // Byte code:
    //   0: ldc 47
    //   2: astore_3
    //   3: new 249	org/json/JSONObject
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 251	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11: astore 7
    //   13: aload 7
    //   15: ldc 253
    //   17: invokevirtual 257	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   20: astore 4
    //   22: aload 7
    //   24: ldc_w 259
    //   27: invokevirtual 257	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore 5
    //   32: aload 7
    //   34: ldc_w 261
    //   37: invokevirtual 257	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   40: astore 6
    //   42: aload 7
    //   44: ldc_w 263
    //   47: invokevirtual 257	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore_1
    //   51: aload 7
    //   53: ldc_w 265
    //   56: invokevirtual 269	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   59: istore_2
    //   60: aload_0
    //   61: getfield 271	com/tencent/biz/game/SensorAPIJavaScript:jdField_c_of_type_Boolean	Z
    //   64: ifeq +52 -> 116
    //   67: aload_0
    //   68: aload 6
    //   70: iconst_1
    //   71: anewarray 273	java/lang/String
    //   74: dup
    //   75: iconst_0
    //   76: ldc_w 275
    //   79: aastore
    //   80: invokevirtual 279	com/tencent/biz/game/SensorAPIJavaScript:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   83: return
    //   84: astore_1
    //   85: aload_1
    //   86: invokevirtual 280	org/json/JSONException:printStackTrace	()V
    //   89: return
    //   90: astore_1
    //   91: aload_1
    //   92: invokevirtual 280	org/json/JSONException:printStackTrace	()V
    //   95: return
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 280	org/json/JSONException:printStackTrace	()V
    //   101: aload_3
    //   102: astore_1
    //   103: goto -52 -> 51
    //   106: astore_3
    //   107: aload_3
    //   108: invokevirtual 280	org/json/JSONException:printStackTrace	()V
    //   111: iconst_0
    //   112: istore_2
    //   113: goto -53 -> 60
    //   116: aload 6
    //   118: invokestatic 286	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   121: ifne -38 -> 83
    //   124: aload_0
    //   125: getfield 209	com/tencent/biz/game/SensorAPIJavaScript:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   128: ifnull -45 -> 83
    //   131: aload 4
    //   133: invokestatic 286	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   136: ifne +11 -> 147
    //   139: aload 5
    //   141: invokestatic 286	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifeq +20 -> 164
    //   147: aload_0
    //   148: aload 6
    //   150: iconst_1
    //   151: anewarray 273	java/lang/String
    //   154: dup
    //   155: iconst_0
    //   156: ldc_w 288
    //   159: aastore
    //   160: invokevirtual 279	com/tencent/biz/game/SensorAPIJavaScript:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   163: return
    //   164: aload_0
    //   165: getfield 209	com/tencent/biz/game/SensorAPIJavaScript:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   168: invokevirtual 215	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   171: ldc_w 290
    //   174: invokevirtual 296	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   177: checkcast 298	android/net/wifi/WifiManager
    //   180: astore_3
    //   181: aload_3
    //   182: ifnonnull +35 -> 217
    //   185: invokestatic 170	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   188: ifeq +12 -> 200
    //   191: ldc 172
    //   193: iconst_4
    //   194: ldc_w 300
    //   197: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: aload_0
    //   201: aload 6
    //   203: iconst_1
    //   204: anewarray 273	java/lang/String
    //   207: dup
    //   208: iconst_0
    //   209: ldc_w 302
    //   212: aastore
    //   213: invokevirtual 279	com/tencent/biz/game/SensorAPIJavaScript:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   216: return
    //   217: aload_0
    //   218: iconst_1
    //   219: putfield 271	com/tencent/biz/game/SensorAPIJavaScript:jdField_c_of_type_Boolean	Z
    //   222: new 304	knm
    //   225: dup
    //   226: aload_0
    //   227: aload 5
    //   229: aload 4
    //   231: aload_1
    //   232: iload_2
    //   233: aload_3
    //   234: aload 6
    //   236: invokespecial 307	knm:<init>	(Lcom/tencent/biz/game/SensorAPIJavaScript;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/net/wifi/WifiManager;Ljava/lang/String;)V
    //   239: invokevirtual 223	java/lang/Thread:start	()V
    //   242: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	SensorAPIJavaScript
    //   0	243	1	paramString	String
    //   59	174	2	bool	boolean
    //   2	100	3	str1	String
    //   106	2	3	localJSONException	JSONException
    //   180	54	3	localWifiManager	android.net.wifi.WifiManager
    //   20	210	4	str2	String
    //   30	198	5	str3	String
    //   40	195	6	str4	String
    //   11	41	7	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   3	13	84	org/json/JSONException
    //   13	42	90	org/json/JSONException
    //   42	51	96	org/json/JSONException
    //   51	60	106	org/json/JSONException
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
    HtmlOffline.a(this.mRuntime.a(), paramString2, new kni(this, paramString4), true, true, false);
  }
  
  public final String getClientInfo()
  {
    return "{\"qqVersion\":\"" + qqVersion() + "\",\"qqBuild\":\"" + "3525" + "\"}";
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
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().c(new knd(this, paramString));
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
    String str2 = Build.MODEL;
    String str3 = Build.VERSION.RELEASE;
    String str4 = Build.FINGERPRINT;
    String str5 = Build.VERSION.INCREMENTAL;
    Object localObject2 = "";
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
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("model", str2);
          ((JSONObject)localObject2).put("systemName", "android");
          ((JSONObject)localObject2).put("systemVersion", str3);
          ((JSONObject)localObject2).put("isMobileQQ", true);
          ((JSONObject)localObject2).put("identifier", MobileInfoUtil.c());
          ((JSONObject)localObject2).put("fingerprint", str4);
          ((JSONObject)localObject2).put("incremental", str5);
          ((JSONObject)localObject2).put("macAddress", MobileInfoUtil.a());
          ((JSONObject)localObject2).put("androidID", Settings.Secure.getString(CommonDataAdapter.a().a().getContentResolver(), "android_id"));
          ((JSONObject)localObject2).put("imsi", MobileInfoUtil.d());
          ((JSONObject)localObject2).put("qimei", str1);
          ((JSONObject)localObject2).put("totalMemory", String.valueOf(DeviceInfoUtil.e()));
          ((JSONObject)localObject2).put("availableMemory", String.valueOf(DeviceInfoUtil.f()));
          ((JSONObject)localObject2).put("cpuType", DeviceInfoUtil.h());
          ((JSONObject)localObject2).put("cpuNum", DeviceInfoUtil.b());
          ((JSONObject)localObject2).put("cpuFreq", DeviceInfoUtil.a());
          String str1 = ((JSONObject)localObject2).toString();
          return str1;
        }
        catch (JSONException localJSONException) {}
        localException = localException;
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.e(this.TAG, 2, "get QIMEI fail");
          localObject1 = localObject2;
        }
      }
    }
    return "{}";
  }
  
  protected String getNameSpace()
  {
    return "qbizApi";
  }
  
  public JSONObject getNetworkInfo()
  {
    int i1 = HttpUtil.a();
    String str = HttpUtil.a();
    int n = 0;
    Object localObject = DeviceInfoUtil.b();
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
    return HttpUtil.a();
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
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().b(new knc(this, paramString));
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
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().a(new knb(this, paramString));
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
  
  public boolean handleEvent(String paramString, long paramLong, Map paramMap)
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
      if (paramInt == 0) {
        str = "success";
      }
    }
    for (;;)
    {
      callJs(this.jdField_a_of_type_JavaLangString, new String[] { Integer.toString(paramInt), Util.a(str) });
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
          if ((paramString1 != null) && ((paramString1 instanceof WebUiUtils.WebUiMethodInterface)))
          {
            paramString1 = ((WebUiUtils.WebUiMethodInterface)paramString1).b();
            if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("closeSpecialLogic")) && (URLUtil.a(URLUtil.a(paramString1), "closeSpecialLogic", 0) != 0)) {
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
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().a();
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
        this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new kne(this, paramString2));
      }
      int m;
      do
      {
        for (;;)
        {
          return true;
          m = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2)).intValue();
          if (this.jdField_a_of_type_AndroidOsHandler != null) {
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new knf(this, m, paramString2), 200L);
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
    paramString3.append(OfflineEnvHelper.b());
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
    if (jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector != null)
    {
      jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector.a();
      jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector = null;
    }
    stopAccelerometer();
    stopCompass();
    stopListen();
    stopLight();
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
    }
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
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
    if ("Meizu_M040".equals(Build.MANUFACTURER + "_" + Build.MODEL))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Sensor", 2, "meizu mx2 returnToAIO");
      }
      new Handler().postDelayed(new kng(this), 400L);
      return;
    }
    returnToAio(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient, this.jdField_a_of_type_AndroidAppActivity, "", false);
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
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().a(m);
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
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "playQQMusic err:" + paramString);
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
    jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector.a(paramString1, paramString2, localAppInterface, this.jdField_a_of_type_AndroidAppActivity, new knk(this));
  }
  
  public final void stopAccelerometer()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener != null))
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener);
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener = null;
    }
  }
  
  public void stopCompass()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_c_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener != null))
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_c_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener);
      this.jdField_c_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener = null;
    }
  }
  
  public final void stopLight()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener != null))
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener);
      this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener = null;
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
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().c();
    return true;
  }
  
  public void stopSyncData()
  {
    if (jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector != null) {
      jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript
 * JD-Core Version:    0.7.0.1
 */