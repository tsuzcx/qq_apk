package com.tencent.mobileqq.activity.bless;

import Override;
import aipw;
import aipz;
import aiqc;
import aiqd;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import aodo;
import auea;
import bcrn;
import bfgr;
import bfgs;
import bfgt;
import bhcu;
import biyn;
import bkyc;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.TicketManager;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class BlessResultActivity
  extends BlessTypeActivity
  implements Handler.Callback, View.OnClickListener, biyn
{
  int jdField_a_of_type_Int;
  public aiqd a;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private aodo jdField_a_of_type_Aodo;
  bfgt jdField_a_of_type_Bfgt = new aiqc(this);
  public bkyc a;
  BlessResultActivity.VideoUploadTask jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask;
  String jdField_a_of_type_JavaLangString;
  public boolean a;
  int jdField_b_of_type_Int = 0;
  String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  public String d;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  String jdField_e_of_type_JavaLangString;
  String f;
  public String g;
  String h;
  String i;
  String j;
  
  public BlessResultActivity()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static bfgs a(Bundle paramBundle, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return a(paramBundle, paramString1, paramString2, paramString3, paramBoolean, "https://c.v.qq.com/openfvupready?g_tk=");
  }
  
  public static bfgs a(Bundle paramBundle, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    long l = System.currentTimeMillis();
    String str1 = paramBundle.getString("title");
    String str2 = paramBundle.getString("tags");
    String str3 = paramBundle.getString("cat");
    String str4 = paramBundle.getString("file_path");
    paramBundle = paramBundle.getString("vid");
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "applyUpload title = " + str1 + ", tags = " + str2 + ", cat = " + str3 + ", filePath = " + str4 + ", size = " + FileUtils.getFileSizes(str4));
    }
    if ((TextUtils.isEmpty(str4)) || (!FileUtils.fileExists(str4)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("BlessResultActivity", 2, "!!!!!!!applyUpload filePath = " + str4);
      }
      paramString1 = null;
    }
    do
    {
      return paramString1;
      if (paramBoolean) {
        paramString4.replaceFirst("http", "https");
      }
      paramString4 = new HttpPost(paramString4 + String.valueOf(bfgr.a(paramString2)));
      paramString4.setHeader("Accept", "Accept text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
      paramString4.setHeader("Accept-Charset", "utf-8;q=0.7,*;q=0.7");
      paramString4.setHeader("Accept-Encoding", "gzip, deflate");
      paramString4.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
      paramString4.setHeader("Connection", "close");
      paramString4.setHeader("Cookie", "skey=" + paramString2 + ";uin=" + paramString1);
      paramString4.setHeader("Referer", "https://c.v.qq.com");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new BasicNameValuePair("bid", paramString3));
      localArrayList.add(new BasicNameValuePair("title", str1));
      localArrayList.add(new BasicNameValuePair("tags", str2));
      localArrayList.add(new BasicNameValuePair("cat", str3));
      localArrayList.add(new BasicNameValuePair("size", String.valueOf(FileUtils.getFileSizes(str4))));
      localArrayList.add(new BasicNameValuePair("sha", HexUtil.bytes2HexStr(auea.a(str4))));
      localArrayList.add(new BasicNameValuePair("md5", HexUtil.bytes2HexStr(auea.e(str4))));
      if (QLog.isColorLevel()) {
        QLog.d("BlessResultActivity", 2, "applyUpload() getMessageDigest time = " + (System.currentTimeMillis() - l));
      }
      localArrayList.add(new BasicNameValuePair("platform", "android"));
      localArrayList.add(new BasicNameValuePair("g_tk", String.valueOf(bfgr.a(paramString2))));
      localArrayList.add(new BasicNameValuePair("otype", "json"));
      if (!TextUtils.isEmpty(paramBundle))
      {
        localArrayList.add(new BasicNameValuePair("vid", paramBundle));
        localArrayList.add(new BasicNameValuePair("continue", "1"));
      }
      paramString1 = null;
      try
      {
        paramString4.setEntity(new UrlEncodedFormEntity(localArrayList, "UTF-8"));
        paramBundle = new DefaultHttpClient().execute(paramString4);
        if (paramBundle.getStatusLine().getStatusCode() != 200) {
          break;
        }
        paramBundle = EntityUtils.toString(paramBundle.getEntity());
        paramBundle = paramBundle.substring(paramBundle.indexOf("{"), paramBundle.lastIndexOf("}") + 1);
        if (QLog.isColorLevel()) {
          QLog.d("BlessResultActivity", 2, "applyUpload result = " + paramBundle);
        }
        paramBundle = new JSONObject(paramBundle);
        if (!paramBundle.optString("s", "f").equals("o")) {
          break;
        }
        paramBundle = new bfgs(paramBundle);
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          paramBundle = paramString1;
          if (QLog.isColorLevel())
          {
            QLog.d("BlessResultActivity", 2, QLog.getStackTraceString(paramString2));
            paramBundle = paramString1;
            continue;
            paramBundle = null;
          }
        }
      }
      paramString1 = paramBundle;
    } while (!QLog.isColorLevel());
    QLog.d("BlessResultActivity", 2, "applyUpload time: " + (System.currentTimeMillis() - l));
    return paramBundle;
  }
  
  public static String a(String paramString)
  {
    String str = AppConstants.SDCARD_PATH + "bless/thumb/";
    Object localObject = new File(str);
    if ((localObject != null) && (((File)localObject).exists()) && (((File)localObject).isDirectory()) && (((File)localObject).listFiles().length > 0))
    {
      localObject = ((File)localObject).listFiles();
      int m = localObject.length;
      int k = 0;
      while (k < m)
      {
        localObject[k].delete();
        k += 1;
      }
    }
    return str + paramString.substring(paramString.lastIndexOf("/"));
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    // Byte code:
    //   0: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   3: lstore 7
    //   5: aload_0
    //   6: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +10 -> 19
    //   12: aload_0
    //   13: invokestatic 128	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   16: ifne +37 -> 53
    //   19: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +29 -> 51
    //   25: ldc 85
    //   27: iconst_2
    //   28: new 87	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 355
    //   38: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_0
    //   42: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: iconst_0
    //   52: ireturn
    //   53: aload_1
    //   54: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +10 -> 67
    //   60: aload_1
    //   61: invokestatic 128	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   64: ifne +37 -> 101
    //   67: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq -19 -> 51
    //   73: ldc 85
    //   75: iconst_2
    //   76: new 87	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   83: ldc_w 357
    //   86: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_1
    //   90: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: iconst_0
    //   100: ireturn
    //   101: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq +94 -> 198
    //   107: ldc 85
    //   109: iconst_2
    //   110: new 87	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 359
    //   120: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_0
    //   124: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc_w 361
    //   130: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_1
    //   134: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc_w 363
    //   140: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: invokestatic 108	com/tencent/mobileqq/utils/FileUtils:getFileSizes	(Ljava/lang/String;)J
    //   147: invokevirtual 111	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   150: ldc_w 365
    //   153: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_2
    //   157: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc_w 367
    //   163: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_3
    //   167: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc_w 369
    //   173: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload 4
    //   178: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: ldc_w 371
    //   184: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 5
    //   189: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: invokestatic 377	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   201: invokevirtual 378	java/util/UUID:toString	()Ljava/lang/String;
    //   204: astore 12
    //   206: new 144	org/apache/http/client/methods/HttpPost
    //   209: dup
    //   210: new 87	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   217: ldc_w 380
    //   220: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_3
    //   224: invokestatic 149	bfgr:a	(Ljava/lang/String;)I
    //   227: invokestatic 153	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   230: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokespecial 156	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   239: astore 11
    //   241: aload 11
    //   243: ldc 158
    //   245: ldc 160
    //   247: invokevirtual 164	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload 11
    //   252: ldc 166
    //   254: ldc 168
    //   256: invokevirtual 164	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload 11
    //   261: ldc 170
    //   263: ldc 172
    //   265: invokevirtual 164	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload 11
    //   270: ldc 174
    //   272: ldc 176
    //   274: invokevirtual 164	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: aload 11
    //   279: ldc 178
    //   281: ldc 180
    //   283: invokevirtual 164	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: aload 11
    //   288: ldc 182
    //   290: new 87	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   297: ldc 184
    //   299: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_3
    //   303: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: ldc 186
    //   308: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload_2
    //   312: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokevirtual 164	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: aload 11
    //   323: ldc 188
    //   325: ldc 190
    //   327: invokevirtual 164	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: aload 11
    //   332: ldc_w 382
    //   335: new 87	java/lang/StringBuilder
    //   338: dup
    //   339: ldc_w 384
    //   342: invokespecial 385	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   345: aload 12
    //   347: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokevirtual 164	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: new 65	android/os/Bundle
    //   359: dup
    //   360: invokespecial 386	android/os/Bundle:<init>	()V
    //   363: astore 13
    //   365: aload 13
    //   367: ldc 197
    //   369: aload 6
    //   371: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   374: aload 13
    //   376: ldc 77
    //   378: aload 4
    //   380: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload 13
    //   385: ldc_w 391
    //   388: aload 5
    //   390: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   393: aload 13
    //   395: ldc 207
    //   397: aload_0
    //   398: invokestatic 108	com/tencent/mobileqq/utils/FileUtils:getFileSizes	(Ljava/lang/String;)J
    //   401: invokestatic 210	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   404: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   407: aload 13
    //   409: ldc 212
    //   411: aload_0
    //   412: invokestatic 217	auea:a	(Ljava/lang/String;)[B
    //   415: invokestatic 223	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   418: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   421: aload 13
    //   423: ldc 225
    //   425: aload_0
    //   426: invokestatic 227	auea:e	(Ljava/lang/String;)[B
    //   429: invokestatic 223	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   432: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   435: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   438: ifeq +34 -> 472
    //   441: ldc 85
    //   443: iconst_2
    //   444: new 87	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   451: ldc_w 393
    //   454: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   460: lload 7
    //   462: lsub
    //   463: invokevirtual 111	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   466: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   472: aload 13
    //   474: ldc 231
    //   476: ldc 233
    //   478: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   481: aload 13
    //   483: ldc 235
    //   485: aload_3
    //   486: invokestatic 149	bfgr:a	(Ljava/lang/String;)I
    //   489: invokestatic 153	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   492: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   495: aload 13
    //   497: ldc 237
    //   499: ldc 239
    //   501: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   504: aload 13
    //   506: ldc_w 395
    //   509: ldc_w 397
    //   512: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   515: aload 13
    //   517: ldc_w 399
    //   520: ldc_w 401
    //   523: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   526: aload 13
    //   528: ldc_w 403
    //   531: ldc_w 405
    //   534: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   537: aload 13
    //   539: ldc_w 407
    //   542: ldc_w 409
    //   545: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   548: aload 13
    //   550: ldc_w 411
    //   553: ldc_w 413
    //   556: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   559: aload 13
    //   561: ldc_w 415
    //   564: ldc_w 417
    //   567: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   570: aload 13
    //   572: ldc_w 419
    //   575: ldc_w 421
    //   578: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   581: aload 13
    //   583: ldc_w 423
    //   586: ldc_w 425
    //   589: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   592: aload 13
    //   594: ldc_w 427
    //   597: ldc_w 429
    //   600: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   603: aload 13
    //   605: ldc_w 431
    //   608: ldc_w 433
    //   611: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   614: aload 13
    //   616: ldc_w 435
    //   619: ldc_w 433
    //   622: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   625: aload 13
    //   627: ldc_w 437
    //   630: ldc_w 439
    //   633: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: aload 13
    //   638: ldc_w 441
    //   641: ldc_w 443
    //   644: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   647: aload 13
    //   649: ldc_w 445
    //   652: ldc 243
    //   654: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   657: aload 13
    //   659: ldc_w 447
    //   662: ldc_w 449
    //   665: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   668: aload 13
    //   670: ldc_w 451
    //   673: ldc_w 453
    //   676: invokevirtual 389	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   679: new 455	java/io/ByteArrayOutputStream
    //   682: dup
    //   683: invokespecial 456	java/io/ByteArrayOutputStream:<init>	()V
    //   686: astore 4
    //   688: aconst_null
    //   689: astore_3
    //   690: aconst_null
    //   691: astore_2
    //   692: new 332	java/io/File
    //   695: dup
    //   696: aload_1
    //   697: invokespecial 333	java/io/File:<init>	(Ljava/lang/String;)V
    //   700: astore 5
    //   702: aload_3
    //   703: astore_0
    //   704: aload 13
    //   706: invokevirtual 460	android/os/Bundle:keySet	()Ljava/util/Set;
    //   709: invokeinterface 466 1 0
    //   714: astore 6
    //   716: aload_3
    //   717: astore_0
    //   718: aload 6
    //   720: invokeinterface 471 1 0
    //   725: ifeq +460 -> 1185
    //   728: aload_3
    //   729: astore_0
    //   730: aload 6
    //   732: invokeinterface 475 1 0
    //   737: checkcast 138	java/lang/String
    //   740: astore 14
    //   742: aload_3
    //   743: astore_0
    //   744: aload 13
    //   746: aload 14
    //   748: invokevirtual 69	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   751: astore 15
    //   753: aload 15
    //   755: ifnull -39 -> 716
    //   758: aload_3
    //   759: astore_0
    //   760: aload 4
    //   762: new 87	java/lang/StringBuilder
    //   765: dup
    //   766: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   769: ldc_w 477
    //   772: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: ldc_w 479
    //   778: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: aload 12
    //   783: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: ldc_w 477
    //   789: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   795: invokevirtual 483	java/lang/String:getBytes	()[B
    //   798: invokevirtual 487	java/io/ByteArrayOutputStream:write	([B)V
    //   801: aload_3
    //   802: astore_0
    //   803: aload 4
    //   805: new 87	java/lang/StringBuilder
    //   808: dup
    //   809: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   812: ldc_w 489
    //   815: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: aload 14
    //   820: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: ldc_w 491
    //   826: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: ldc_w 477
    //   832: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: ldc_w 477
    //   838: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   844: invokevirtual 483	java/lang/String:getBytes	()[B
    //   847: invokevirtual 487	java/io/ByteArrayOutputStream:write	([B)V
    //   850: aload_3
    //   851: astore_0
    //   852: aload 4
    //   854: aload 15
    //   856: invokevirtual 483	java/lang/String:getBytes	()[B
    //   859: invokevirtual 487	java/io/ByteArrayOutputStream:write	([B)V
    //   862: goto -146 -> 716
    //   865: astore_0
    //   866: aload_2
    //   867: astore_1
    //   868: aload_0
    //   869: astore_2
    //   870: aload_1
    //   871: astore_0
    //   872: aload_2
    //   873: invokevirtual 494	java/io/IOException:printStackTrace	()V
    //   876: aload 4
    //   878: ifnull +8 -> 886
    //   881: aload 4
    //   883: invokevirtual 496	java/io/ByteArrayOutputStream:close	()V
    //   886: aload_1
    //   887: ifnull +654 -> 1541
    //   890: aload_1
    //   891: invokevirtual 499	java/io/FileInputStream:close	()V
    //   894: aconst_null
    //   895: astore_0
    //   896: new 501	org/apache/http/entity/ByteArrayEntity
    //   899: dup
    //   900: aload_0
    //   901: invokespecial 503	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   904: astore_0
    //   905: aload 11
    //   907: aload_0
    //   908: invokevirtual 254	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   911: new 505	org/apache/http/params/BasicHttpParams
    //   914: dup
    //   915: invokespecial 506	org/apache/http/params/BasicHttpParams:<init>	()V
    //   918: astore_0
    //   919: aload_0
    //   920: sipush 10000
    //   923: invokestatic 512	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   926: aload_0
    //   927: sipush 10000
    //   930: invokestatic 515	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   933: new 256	org/apache/http/impl/client/DefaultHttpClient
    //   936: dup
    //   937: aload_0
    //   938: invokespecial 518	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   941: aload 11
    //   943: invokevirtual 261	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   946: astore_0
    //   947: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   950: ifeq +39 -> 989
    //   953: ldc 85
    //   955: iconst_2
    //   956: new 87	java/lang/StringBuilder
    //   959: dup
    //   960: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   963: ldc_w 520
    //   966: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: aload_0
    //   970: invokeinterface 267 1 0
    //   975: invokeinterface 273 1 0
    //   980: invokevirtual 523	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   983: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   986: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   989: aload_0
    //   990: invokeinterface 267 1 0
    //   995: invokeinterface 273 1 0
    //   1000: sipush 200
    //   1003: if_icmpne +532 -> 1535
    //   1006: aload_0
    //   1007: invokeinterface 277 1 0
    //   1012: invokestatic 282	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   1015: astore_0
    //   1016: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1019: ifeq +29 -> 1048
    //   1022: ldc 85
    //   1024: iconst_2
    //   1025: new 87	java/lang/StringBuilder
    //   1028: dup
    //   1029: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   1032: ldc_w 525
    //   1035: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: aload_0
    //   1039: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1045: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1048: aload_0
    //   1049: aload_0
    //   1050: ldc_w 284
    //   1053: invokevirtual 287	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1056: aload_0
    //   1057: ldc_w 289
    //   1060: invokevirtual 292	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1063: iconst_1
    //   1064: iadd
    //   1065: invokevirtual 296	java/lang/String:substring	(II)Ljava/lang/String;
    //   1068: astore_0
    //   1069: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1072: ifeq +29 -> 1101
    //   1075: ldc 85
    //   1077: iconst_2
    //   1078: new 87	java/lang/StringBuilder
    //   1081: dup
    //   1082: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   1085: ldc_w 527
    //   1088: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: aload_0
    //   1092: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1098: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1101: new 300	org/json/JSONObject
    //   1104: dup
    //   1105: aload_0
    //   1106: invokespecial 301	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1109: ldc_w 303
    //   1112: ldc_w 304
    //   1115: invokevirtual 307	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1118: ldc_w 309
    //   1121: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1124: istore 9
    //   1126: iload 9
    //   1128: ifeq +407 -> 1535
    //   1131: iconst_1
    //   1132: istore 9
    //   1134: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1137: ifeq +45 -> 1182
    //   1140: ldc 85
    //   1142: iconst_2
    //   1143: new 87	java/lang/StringBuilder
    //   1146: dup
    //   1147: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   1150: ldc_w 529
    //   1153: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1156: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   1159: lload 7
    //   1161: lsub
    //   1162: invokevirtual 111	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1165: ldc_w 531
    //   1168: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1171: iload 9
    //   1173: invokevirtual 534	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1176: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1179: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1182: iload 9
    //   1184: ireturn
    //   1185: aload_3
    //   1186: astore_0
    //   1187: aload 4
    //   1189: new 87	java/lang/StringBuilder
    //   1192: dup
    //   1193: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   1196: ldc_w 477
    //   1199: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1202: ldc_w 479
    //   1205: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: aload 12
    //   1210: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: ldc_w 477
    //   1216: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1222: invokevirtual 483	java/lang/String:getBytes	()[B
    //   1225: invokevirtual 487	java/io/ByteArrayOutputStream:write	([B)V
    //   1228: aload_3
    //   1229: astore_0
    //   1230: aload 4
    //   1232: new 87	java/lang/StringBuilder
    //   1235: dup
    //   1236: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   1239: ldc_w 536
    //   1242: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: aload 5
    //   1247: invokevirtual 539	java/io/File:getName	()Ljava/lang/String;
    //   1250: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1253: ldc_w 491
    //   1256: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: ldc_w 477
    //   1262: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1265: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1268: invokevirtual 483	java/lang/String:getBytes	()[B
    //   1271: invokevirtual 487	java/io/ByteArrayOutputStream:write	([B)V
    //   1274: aload_3
    //   1275: astore_0
    //   1276: aload 4
    //   1278: new 87	java/lang/StringBuilder
    //   1281: dup
    //   1282: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   1285: ldc_w 541
    //   1288: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1291: ldc_w 477
    //   1294: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1297: ldc_w 477
    //   1300: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1303: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1306: invokevirtual 483	java/lang/String:getBytes	()[B
    //   1309: invokevirtual 487	java/io/ByteArrayOutputStream:write	([B)V
    //   1312: aload_3
    //   1313: astore_0
    //   1314: new 498	java/io/FileInputStream
    //   1317: dup
    //   1318: aload_1
    //   1319: invokespecial 542	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   1322: astore_1
    //   1323: aload_1
    //   1324: invokevirtual 546	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   1327: invokevirtual 550	java/nio/channels/FileChannel:size	()J
    //   1330: l2i
    //   1331: newarray byte
    //   1333: astore_0
    //   1334: aload_1
    //   1335: aload_0
    //   1336: invokevirtual 554	java/io/FileInputStream:read	([B)I
    //   1339: pop
    //   1340: aload 4
    //   1342: aload_0
    //   1343: invokevirtual 487	java/io/ByteArrayOutputStream:write	([B)V
    //   1346: aload 4
    //   1348: new 87	java/lang/StringBuilder
    //   1351: dup
    //   1352: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   1355: ldc_w 477
    //   1358: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: ldc_w 479
    //   1364: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1367: aload 12
    //   1369: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1372: ldc_w 479
    //   1375: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: ldc_w 477
    //   1381: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1384: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1387: invokevirtual 483	java/lang/String:getBytes	()[B
    //   1390: invokevirtual 487	java/io/ByteArrayOutputStream:write	([B)V
    //   1393: aload 4
    //   1395: invokevirtual 557	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1398: astore_2
    //   1399: aload 4
    //   1401: ifnull +8 -> 1409
    //   1404: aload 4
    //   1406: invokevirtual 496	java/io/ByteArrayOutputStream:close	()V
    //   1409: aload_2
    //   1410: astore_0
    //   1411: aload_1
    //   1412: ifnull -516 -> 896
    //   1415: aload_1
    //   1416: invokevirtual 499	java/io/FileInputStream:close	()V
    //   1419: aload_2
    //   1420: astore_0
    //   1421: goto -525 -> 896
    //   1424: astore_0
    //   1425: aload_2
    //   1426: astore_0
    //   1427: goto -531 -> 896
    //   1430: astore_0
    //   1431: aconst_null
    //   1432: astore_0
    //   1433: goto -537 -> 896
    //   1436: astore_2
    //   1437: aload_0
    //   1438: astore_1
    //   1439: aload_2
    //   1440: astore_0
    //   1441: aload 4
    //   1443: ifnull +8 -> 1451
    //   1446: aload 4
    //   1448: invokevirtual 496	java/io/ByteArrayOutputStream:close	()V
    //   1451: aload_1
    //   1452: ifnull +7 -> 1459
    //   1455: aload_1
    //   1456: invokevirtual 499	java/io/FileInputStream:close	()V
    //   1459: aload_0
    //   1460: athrow
    //   1461: astore_0
    //   1462: iconst_0
    //   1463: istore 10
    //   1465: iload 10
    //   1467: istore 9
    //   1469: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1472: ifeq -338 -> 1134
    //   1475: ldc 85
    //   1477: iconst_2
    //   1478: new 87	java/lang/StringBuilder
    //   1481: dup
    //   1482: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   1485: ldc_w 559
    //   1488: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1491: aload_0
    //   1492: invokestatic 323	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1495: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1498: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1501: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1504: iload 10
    //   1506: istore 9
    //   1508: goto -374 -> 1134
    //   1511: astore_0
    //   1512: goto -103 -> 1409
    //   1515: astore_0
    //   1516: goto -630 -> 886
    //   1519: astore_2
    //   1520: goto -69 -> 1451
    //   1523: astore_1
    //   1524: goto -65 -> 1459
    //   1527: astore_0
    //   1528: goto -87 -> 1441
    //   1531: astore_2
    //   1532: goto -662 -> 870
    //   1535: iconst_0
    //   1536: istore 9
    //   1538: goto -404 -> 1134
    //   1541: aconst_null
    //   1542: astore_0
    //   1543: goto -647 -> 896
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1546	0	paramString1	String
    //   0	1546	1	paramString2	String
    //   0	1546	2	paramString3	String
    //   0	1546	3	paramString4	String
    //   0	1546	4	paramString5	String
    //   0	1546	5	paramString6	String
    //   0	1546	6	paramString7	String
    //   3	1157	7	l	long
    //   1124	413	9	bool1	boolean
    //   1463	42	10	bool2	boolean
    //   239	703	11	localHttpPost	HttpPost
    //   204	1164	12	str1	String
    //   363	382	13	localBundle	Bundle
    //   740	79	14	str2	String
    //   751	104	15	str3	String
    // Exception table:
    //   from	to	target	type
    //   704	716	865	java/io/IOException
    //   718	728	865	java/io/IOException
    //   730	742	865	java/io/IOException
    //   744	753	865	java/io/IOException
    //   760	801	865	java/io/IOException
    //   803	850	865	java/io/IOException
    //   852	862	865	java/io/IOException
    //   1187	1228	865	java/io/IOException
    //   1230	1274	865	java/io/IOException
    //   1276	1312	865	java/io/IOException
    //   1314	1323	865	java/io/IOException
    //   1415	1419	1424	java/io/IOException
    //   890	894	1430	java/io/IOException
    //   704	716	1436	finally
    //   718	728	1436	finally
    //   730	742	1436	finally
    //   744	753	1436	finally
    //   760	801	1436	finally
    //   803	850	1436	finally
    //   852	862	1436	finally
    //   872	876	1436	finally
    //   1187	1228	1436	finally
    //   1230	1274	1436	finally
    //   1276	1312	1436	finally
    //   1314	1323	1436	finally
    //   905	989	1461	java/lang/Exception
    //   989	1048	1461	java/lang/Exception
    //   1048	1101	1461	java/lang/Exception
    //   1101	1126	1461	java/lang/Exception
    //   1404	1409	1511	java/io/IOException
    //   881	886	1515	java/io/IOException
    //   1446	1451	1519	java/io/IOException
    //   1455	1459	1523	java/io/IOException
    //   1323	1399	1527	finally
    //   1323	1399	1531	java/io/IOException
  }
  
  private void g()
  {
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra(bcrn.h, false);
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Aodo = new aipz(this);
    this.app.addObserver(this.jdField_a_of_type_Aodo);
  }
  
  private void h()
  {
    ((ImmersiveTitleBar2)findViewById(2131379099)).setVisibility(4);
    findViewById(2131369262).setVisibility(8);
    findViewById(2131369231).setOnClickListener(this);
    TextView localTextView = (TextView)findViewById(2131379858);
    String str = "";
    switch (this.jdField_d_of_type_Int)
    {
    }
    for (;;)
    {
      localTextView.setText(String.format(getString(2131690650), new Object[] { Integer.valueOf(this.jdField_e_of_type_Int) }));
      if (this.jdField_e_of_type_Int > 10) {
        ((TextView)findViewById(2131363652)).setText(String.format(getString(2131690642), new Object[] { Integer.valueOf(10) }));
      }
      if (this.jdField_d_of_type_Int == 2)
      {
        findViewById(2131376874).setVisibility(0);
        ((TextView)findViewById(2131380156)).setText(String.format(getString(2131690647), new Object[] { str }));
        findViewById(2131380096).setOnClickListener(this);
        findViewById(2131379944).setOnClickListener(this);
      }
      return;
      str = getString(2131690651);
      continue;
      str = getString(2131690635);
    }
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask == null) || ((!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask.b()) && (!this.jdField_a_of_type_Boolean)))
    {
      String str = this.app.getCurrentUin();
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask = new BlessResultActivity.VideoUploadTask(this, str, ((TicketManager)this.app.getManager(2)).getSkey(str), this.jdField_a_of_type_Aiqd, this.jdField_a_of_type_Bfgt);
      this.jdField_a_of_type_Bkyc.sendEmptyMessageDelayed(1003, 120000L);
      ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask, 8, null, false);
      return;
    }
    b();
  }
  
  void a(int paramInt)
  {
    c();
    this.jdField_b_of_type_Int = paramInt;
    if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString == null) || (this.jdField_e_of_type_JavaLangString == null) || (this.f == null))
    {
      QQToast.a(this, 2131692366, 0).a();
      d();
      return;
    }
    File localFile1 = new File(this.jdField_b_of_type_JavaLangString);
    File localFile2 = new File(this.jdField_a_of_type_JavaLangString);
    if ((!localFile1.exists()) || (!localFile2.exists()))
    {
      QQToast.a(this, 2131692366, 0).a();
      d();
      return;
    }
    if ((!localFile1.isFile()) || (!localFile2.isFile()))
    {
      QQToast.a(this, 2131692368, 0).a();
      d();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "share last uploaded ptv. mPtvPath=" + this.jdField_a_of_type_JavaLangString + " ,mSnapImagePath=" + this.jdField_b_of_type_JavaLangString + " ,mPtvUuid=" + this.jdField_e_of_type_JavaLangString + " ,mPtvMd5=" + this.f);
    }
    this.g = this.jdField_a_of_type_Aipw.a(this.jdField_e_of_type_JavaLangString, this.f);
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "share url :" + this.g);
    }
    if (this.jdField_b_of_type_Int == 1)
    {
      b();
      return;
    }
    ThreadManager.post(new BlessResultActivity.3(this, this.jdField_b_of_type_JavaLangString), 8, null, false);
  }
  
  public String b(String paramString)
  {
    paramString = this.jdField_a_of_type_Aipw.e() + "&vid=" + paramString + "&nickname=";
    String str = paramString + bhcu.encodeToString(this.app.getCurrentNickname().getBytes(), 2);
    paramString = str;
    if (this.jdField_a_of_type_Int > 0) {
      paramString = str + "&template=" + this.jdField_a_of_type_Int;
    }
    return paramString;
  }
  
  void b()
  {
    d();
    if (this.jdField_b_of_type_Int == 1)
    {
      e();
      return;
    }
    f();
  }
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("BlessResultActivity", 2, "showProgressDialog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        d();
      }
      while (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ReportProgressDialog(this, 2131755829);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559607);
        ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131372740)).setText(2131716508);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BlessResultActivity", 2, "showProgressDialog", localThrowable);
      }
    }
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.e("BlessResultActivity", 2, "cancelProgressDialog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    onBackEvent();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558776);
    this.jdField_a_of_type_Aipw.b();
    this.jdField_a_of_type_Aipw.a(false);
    paramBundle = getIntent();
    this.jdField_d_of_type_Int = paramBundle.getIntExtra("param_method", 1);
    this.jdField_e_of_type_Int = paramBundle.getIntExtra("param_count", 0);
    if (this.jdField_d_of_type_Int == 2)
    {
      this.jdField_a_of_type_Bkyc = new bkyc(this);
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("param_ptv_path");
      this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("param_snap_path");
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("param_ptv_id", -1);
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("param_share_title");
      this.jdField_e_of_type_JavaLangString = paramBundle.getStringExtra("param_ptv_uuid");
      this.f = paramBundle.getStringExtra("param_ptv_md5");
      if (QLog.isColorLevel()) {
        QLog.d("BlessResultActivity", 2, "mp4: " + this.jdField_a_of_type_JavaLangString + ", image:" + this.jdField_b_of_type_JavaLangString);
      }
      WXShareHelper.a().a(this);
    }
    this.jdField_a_of_type_Float = 0.48F;
    this.jdField_c_of_type_Int = 2;
    h();
    g();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_d_of_type_Int == 2)
    {
      WXShareHelper.a().b(this);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask.b())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask.a();
      }
    }
    if (this.jdField_a_of_type_Aodo != null) {
      this.app.removeObserver(this.jdField_a_of_type_Aodo);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = true;
      ThreadManager.post(new BlessResultActivity.2(this), 8, null, false);
    }
  }
  
  void e()
  {
    Object localObject = this.jdField_b_of_type_JavaLangString;
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localArrayList.add(localObject);
    }
    String str = this.jdField_c_of_type_JavaLangString;
    localObject = str;
    if (TextUtils.isEmpty(str))
    {
      str = this.jdField_a_of_type_Aipw.a(true);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = getString(2131690646);
      }
    }
    str = String.format(getString(2131690645), new Object[] { this.app.getCurrentNickname() });
    Bundle localBundle = new Bundle();
    localBundle.putString("title", (String)localObject);
    localBundle.putString("desc", str);
    localBundle.putLong("req_share_id", 0L);
    localBundle.putString("detail_url", this.g);
    localBundle.putString("url", this.g);
    localBundle.putStringArrayList("image_url", localArrayList);
    localBundle.putString("troop_wording", (String)localObject);
    localBundle.putString("bizname", "StarBlessLink");
    QZoneShareManager.jumpToQzoneShare(this.app, this, localBundle, null);
    if (QLog.isColorLevel()) {
      QLog.i("BlessResultActivity", 2, "shareToQzone: shareLink:" + this.g);
    }
  }
  
  void f()
  {
    int k;
    if (!WXShareHelper.a().a()) {
      k = 2131720175;
    }
    for (;;)
    {
      if (k != -1) {
        QQToast.a(this, getString(k), 0).a();
      }
      for (;;)
      {
        return;
        if (!WXShareHelper.a().b())
        {
          k = 2131720176;
          break;
          this.h = String.valueOf(System.currentTimeMillis());
          Object localObject1 = null;
          try
          {
            localObject2 = BitmapFactory.decodeFile(this.jdField_b_of_type_JavaLangString);
            String str = this.jdField_c_of_type_JavaLangString;
            localObject1 = str;
            if (TextUtils.isEmpty(str))
            {
              str = this.jdField_a_of_type_Aipw.a(false);
              localObject1 = str;
              if (TextUtils.isEmpty(str)) {
                localObject1 = getString(2131690646);
              }
            }
            str = String.format(getString(2131690645), new Object[] { this.app.getCurrentNickname() });
            WXShareHelper.a().c(this.h, (String)localObject1, (Bitmap)localObject2, str, this.g);
            if (QLog.isColorLevel())
            {
              QLog.i("BlessResultActivity", 2, "shareToFriendCircle.transaction: " + this.h + ", shareLink:" + this.g);
              return;
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            for (;;)
            {
              Object localObject2 = localObject1;
              if (QLog.isColorLevel())
              {
                QLog.e("BlessResultActivity", 2, "getBitmapByPath OOM, fileName: " + this.jdField_b_of_type_JavaLangString, localOutOfMemoryError);
                localObject2 = localObject1;
              }
            }
          }
        }
      }
      k = -1;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "handleMessage,msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      bool = false;
      return bool;
      a();
      return true;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask.b())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask.a();
      }
      d();
      QQToast.a(this, 1, 2131718766, 0).a();
      return true;
      this.i = this.jdField_a_of_type_JavaLangString;
      this.j = this.jdField_d_of_type_JavaLangString;
      paramMessage = getSharedPreferences("bless_ptv_upload", 0).edit();
      String str = getCurrentAccountUin();
      paramMessage.putString("bless_ptv_path" + str, this.i);
      paramMessage.putString("bless_vid" + str, this.j);
      paramMessage.commit();
      b();
      return true;
      if (((paramMessage.obj instanceof String)) && (!TextUtils.isEmpty((String)paramMessage.obj))) {
        this.jdField_b_of_type_JavaLangString = ((String)paramMessage.obj);
      }
      b();
    }
  }
  
  public boolean onBackEvent()
  {
    Intent localIntent = new Intent(this, BlessActivity.class);
    localIntent.setFlags(67108864);
    startActivity(localIntent);
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        Intent localIntent = new Intent(this, SplashActivity.class);
        localIntent.setFlags(67108864);
        startActivity(localIntent);
      }
      a(1);
      continue;
      a(2);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((this.h == null) || (!this.h.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QQToast.a(this, 1, getString(2131718766), 0).a();
      return;
    }
    QQToast.a(this, 2, getString(2131718784), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessResultActivity
 * JD-Core Version:    0.7.0.1
 */