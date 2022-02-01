package com.tencent.mobileqq.activity.bless;

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
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil;
import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.ApplyUploadRsp;
import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.OnUploadVideoListener;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.util.MqqWeakReferenceHandler;
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
  implements Handler.Callback, View.OnClickListener, WXShareHelper.WXShareListener
{
  MqqWeakReferenceHandler a;
  String b;
  String c;
  int d;
  String e;
  String f;
  String g;
  String h;
  ProgressDialog i;
  BlessResultActivity.VideoInfo j;
  BlessResultActivity.VideoUploadTask k;
  boolean l = false;
  String m;
  int n = 0;
  String o;
  String p;
  String q;
  TroopBarShortVideoUploadUtil.OnUploadVideoListener r = new BlessResultActivity.2(this);
  private int w;
  private int x;
  
  public static TroopBarShortVideoUploadUtil.ApplyUploadRsp a(Bundle paramBundle, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return a(paramBundle, paramString1, paramString2, paramString3, paramBoolean, "https://c.v.qq.com/openfvupready?g_tk=");
  }
  
  public static TroopBarShortVideoUploadUtil.ApplyUploadRsp a(Bundle paramBundle, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    long l1 = System.currentTimeMillis();
    String str2 = paramBundle.getString("title");
    String str3 = paramBundle.getString("tags");
    String str4 = paramBundle.getString("cat");
    String str1 = paramBundle.getString("file_path");
    paramBundle = paramBundle.getString("vid");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("applyUpload title = ");
      localStringBuilder.append(str2);
      localStringBuilder.append(", tags = ");
      localStringBuilder.append(str3);
      localStringBuilder.append(", cat = ");
      localStringBuilder.append(str4);
      localStringBuilder.append(", filePath = ");
      localStringBuilder.append(str1);
      localStringBuilder.append(", size = ");
      localStringBuilder.append(FileUtils.getFileSizes(str1));
      QLog.d("BlessResultActivity", 2, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(str1)) && (FileUtils.fileExists(str1)))
    {
      if (paramBoolean) {
        paramString4.replaceFirst("http", "https");
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString4);
      localStringBuilder.append(String.valueOf(TroopBarShortVideoUploadUtil.a(paramString2)));
      paramString4 = new HttpPost(localStringBuilder.toString());
      paramString4.setHeader("Accept", "Accept text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
      paramString4.setHeader("Accept-Charset", "utf-8;q=0.7,*;q=0.7");
      paramString4.setHeader("Accept-Encoding", "gzip, deflate");
      paramString4.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
      paramString4.setHeader("Connection", "close");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("skey=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(";uin=");
      localStringBuilder.append(paramString1);
      paramString4.setHeader("Cookie", localStringBuilder.toString());
      paramString4.setHeader("Referer", "https://c.v.qq.com");
      paramString1 = new ArrayList();
      paramString1.add(new BasicNameValuePair("bid", paramString3));
      paramString1.add(new BasicNameValuePair("title", str2));
      paramString1.add(new BasicNameValuePair("tags", str3));
      paramString1.add(new BasicNameValuePair("cat", str4));
      paramString1.add(new BasicNameValuePair("size", String.valueOf(FileUtils.getFileSizes(str1))));
      paramString1.add(new BasicNameValuePair("sha", HexUtil.bytes2HexStr(FileManagerUtil.d(str1))));
      paramString1.add(new BasicNameValuePair("md5", HexUtil.bytes2HexStr(FileManagerUtil.g(str1))));
      if (QLog.isColorLevel())
      {
        paramString3 = new StringBuilder();
        paramString3.append("applyUpload() getMessageDigest time = ");
        paramString3.append(System.currentTimeMillis() - l1);
        QLog.d("BlessResultActivity", 2, paramString3.toString());
      }
      paramString1.add(new BasicNameValuePair("platform", "android"));
      paramString1.add(new BasicNameValuePair("g_tk", String.valueOf(TroopBarShortVideoUploadUtil.a(paramString2))));
      paramString1.add(new BasicNameValuePair("otype", "json"));
      if (!TextUtils.isEmpty(paramBundle))
      {
        paramString1.add(new BasicNameValuePair("vid", paramBundle));
        paramString1.add(new BasicNameValuePair("continue", "1"));
      }
      try
      {
        paramString4.setEntity(new UrlEncodedFormEntity(paramString1, "UTF-8"));
        paramBundle = new DefaultHttpClient().execute(paramString4);
        if (paramBundle.getStatusLine().getStatusCode() == 200)
        {
          paramBundle = EntityUtils.toString(paramBundle.getEntity());
          paramBundle = paramBundle.substring(paramBundle.indexOf("{"), paramBundle.lastIndexOf("}") + 1);
          if (QLog.isColorLevel())
          {
            paramString1 = new StringBuilder();
            paramString1.append("applyUpload result = ");
            paramString1.append(paramBundle);
            QLog.d("BlessResultActivity", 2, paramString1.toString());
          }
          paramBundle = new JSONObject(paramBundle);
          if (paramBundle.optString("s", "f").equals("o")) {
            paramBundle = new TroopBarShortVideoUploadUtil.ApplyUploadRsp(paramBundle);
          }
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BlessResultActivity", 2, QLog.getStackTraceString(paramBundle));
        }
        paramBundle = null;
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("applyUpload time: ");
        paramString1.append(System.currentTimeMillis() - l1);
        QLog.d("BlessResultActivity", 2, paramString1.toString());
      }
      return paramBundle;
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("!!!!!!!applyUpload filePath = ");
      paramBundle.append(str1);
      QLog.e("BlessResultActivity", 2, paramBundle.toString());
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject1).append("bless/thumb/");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new File((String)localObject1);
    if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()) && (((File)localObject2).listFiles().length > 0))
    {
      localObject2 = ((File)localObject2).listFiles();
      int i2 = localObject2.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localObject2[i1].delete();
        i1 += 1;
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(paramString.substring(paramString.lastIndexOf("/")));
    return ((StringBuilder)localObject2).toString();
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    // Byte code:
    //   0: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   3: lstore 8
    //   5: aload_0
    //   6: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +1584 -> 1593
    //   12: aload_0
    //   13: invokestatic 135	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   16: ifne +6 -> 22
    //   19: goto +1574 -> 1593
    //   22: aload_1
    //   23: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +1527 -> 1553
    //   29: aload_1
    //   30: invokestatic 135	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   33: ifne +6 -> 39
    //   36: goto +1517 -> 1553
    //   39: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +140 -> 182
    //   45: new 92	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   52: astore 12
    //   54: aload 12
    //   56: ldc_w 361
    //   59: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 12
    //   65: aload_0
    //   66: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 12
    //   72: ldc_w 363
    //   75: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 12
    //   81: aload_1
    //   82: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 12
    //   88: ldc_w 365
    //   91: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 12
    //   97: aload_1
    //   98: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:getFileSizes	(Ljava/lang/String;)J
    //   101: invokevirtual 116	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 12
    //   107: ldc_w 367
    //   110: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 12
    //   116: aload_2
    //   117: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 12
    //   123: ldc_w 369
    //   126: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 12
    //   132: aload_3
    //   133: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 12
    //   139: ldc_w 371
    //   142: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 12
    //   148: aload 4
    //   150: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 12
    //   156: ldc_w 373
    //   159: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload 12
    //   165: aload 5
    //   167: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: ldc 118
    //   173: iconst_2
    //   174: aload 12
    //   176: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: invokestatic 379	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   185: invokevirtual 380	java/util/UUID:toString	()Ljava/lang/String;
    //   188: astore 13
    //   190: new 92	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   197: astore 12
    //   199: aload 12
    //   201: ldc_w 382
    //   204: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 12
    //   210: aload_3
    //   211: invokestatic 150	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil:a	(Ljava/lang/String;)I
    //   214: invokestatic 154	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   217: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: new 156	org/apache/http/client/methods/HttpPost
    //   224: dup
    //   225: aload 12
    //   227: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokespecial 159	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   233: astore 12
    //   235: aload 12
    //   237: ldc 161
    //   239: ldc 163
    //   241: invokevirtual 167	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload 12
    //   246: ldc 169
    //   248: ldc 171
    //   250: invokevirtual 167	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload 12
    //   255: ldc 173
    //   257: ldc 175
    //   259: invokevirtual 167	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload 12
    //   264: ldc 177
    //   266: ldc 179
    //   268: invokevirtual 167	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload 12
    //   273: ldc 181
    //   275: ldc 183
    //   277: invokevirtual 167	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: new 92	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   287: astore 14
    //   289: aload 14
    //   291: ldc 185
    //   293: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload 14
    //   299: aload_3
    //   300: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload 14
    //   306: ldc 187
    //   308: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 14
    //   314: aload_2
    //   315: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 12
    //   321: ldc 189
    //   323: aload 14
    //   325: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokevirtual 167	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: aload 12
    //   333: ldc 191
    //   335: ldc 193
    //   337: invokevirtual 167	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   340: new 92	java/lang/StringBuilder
    //   343: dup
    //   344: ldc_w 384
    //   347: invokespecial 385	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   350: astore_2
    //   351: aload_2
    //   352: aload 13
    //   354: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 12
    //   360: ldc_w 387
    //   363: aload_2
    //   364: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokevirtual 167	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: new 72	android/os/Bundle
    //   373: dup
    //   374: invokespecial 388	android/os/Bundle:<init>	()V
    //   377: astore_2
    //   378: aload_2
    //   379: ldc 200
    //   381: aload 6
    //   383: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   386: aload_2
    //   387: ldc 84
    //   389: aload 4
    //   391: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   394: aload_2
    //   395: ldc_w 393
    //   398: aload 5
    //   400: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   403: aload_2
    //   404: ldc 210
    //   406: aload_0
    //   407: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:getFileSizes	(Ljava/lang/String;)J
    //   410: invokestatic 213	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   413: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   416: aload_2
    //   417: ldc 215
    //   419: aload_0
    //   420: invokestatic 220	com/tencent/mobileqq/filemanager/util/FileManagerUtil:d	(Ljava/lang/String;)[B
    //   423: invokestatic 226	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   426: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   429: aload_2
    //   430: ldc 228
    //   432: aload_0
    //   433: invokestatic 230	com/tencent/mobileqq/filemanager/util/FileManagerUtil:g	(Ljava/lang/String;)[B
    //   436: invokestatic 226	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   439: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   445: ifeq +40 -> 485
    //   448: new 92	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   455: astore_0
    //   456: aload_0
    //   457: ldc_w 395
    //   460: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aload_0
    //   465: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   468: lload 8
    //   470: lsub
    //   471: invokevirtual 116	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: ldc 118
    //   477: iconst_2
    //   478: aload_0
    //   479: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   485: aload_2
    //   486: ldc 234
    //   488: ldc 236
    //   490: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   493: aload_2
    //   494: ldc 238
    //   496: aload_3
    //   497: invokestatic 150	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil:a	(Ljava/lang/String;)I
    //   500: invokestatic 154	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   503: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   506: aload_2
    //   507: ldc 240
    //   509: ldc 242
    //   511: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: aload_2
    //   515: ldc_w 397
    //   518: ldc_w 399
    //   521: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   524: aload_2
    //   525: ldc_w 401
    //   528: ldc_w 403
    //   531: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   534: aload_2
    //   535: ldc_w 405
    //   538: ldc_w 407
    //   541: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   544: aload_2
    //   545: ldc_w 409
    //   548: ldc_w 411
    //   551: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   554: aload_2
    //   555: ldc_w 413
    //   558: ldc_w 415
    //   561: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   564: aload_2
    //   565: ldc_w 417
    //   568: ldc_w 419
    //   571: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   574: aload_2
    //   575: ldc_w 421
    //   578: ldc_w 423
    //   581: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: aload_2
    //   585: ldc_w 425
    //   588: ldc_w 427
    //   591: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   594: aload_2
    //   595: ldc_w 429
    //   598: ldc_w 431
    //   601: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   604: aload_2
    //   605: ldc_w 433
    //   608: ldc_w 435
    //   611: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   614: aload_2
    //   615: ldc_w 437
    //   618: ldc_w 435
    //   621: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   624: aload_2
    //   625: ldc_w 439
    //   628: ldc_w 441
    //   631: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   634: aload_2
    //   635: ldc_w 443
    //   638: ldc_w 445
    //   641: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   644: aload_2
    //   645: ldc_w 447
    //   648: ldc 246
    //   650: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   653: aload_2
    //   654: ldc_w 449
    //   657: ldc_w 451
    //   660: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   663: aload_2
    //   664: ldc_w 453
    //   667: ldc_w 455
    //   670: invokevirtual 391	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   673: new 457	java/io/ByteArrayOutputStream
    //   676: dup
    //   677: invokespecial 458	java/io/ByteArrayOutputStream:<init>	()V
    //   680: astore_3
    //   681: new 338	java/io/File
    //   684: dup
    //   685: aload_1
    //   686: invokespecial 339	java/io/File:<init>	(Ljava/lang/String;)V
    //   689: astore_0
    //   690: aload_2
    //   691: invokevirtual 462	android/os/Bundle:keySet	()Ljava/util/Set;
    //   694: invokeinterface 468 1 0
    //   699: astore 4
    //   701: aload 4
    //   703: invokeinterface 473 1 0
    //   708: istore 10
    //   710: iload 10
    //   712: ifeq +164 -> 876
    //   715: aload 4
    //   717: invokeinterface 477 1 0
    //   722: checkcast 141	java/lang/String
    //   725: astore 5
    //   727: aload_2
    //   728: aload 5
    //   730: invokevirtual 76	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   733: astore 6
    //   735: aload 6
    //   737: ifnonnull +6 -> 743
    //   740: goto -39 -> 701
    //   743: new 92	java/lang/StringBuilder
    //   746: dup
    //   747: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   750: astore 14
    //   752: aload 14
    //   754: ldc_w 479
    //   757: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: pop
    //   761: aload 14
    //   763: ldc_w 481
    //   766: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: pop
    //   770: aload 14
    //   772: aload 13
    //   774: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: pop
    //   778: aload 14
    //   780: ldc_w 479
    //   783: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: aload_3
    //   788: aload 14
    //   790: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   793: invokevirtual 485	java/lang/String:getBytes	()[B
    //   796: invokevirtual 489	java/io/ByteArrayOutputStream:write	([B)V
    //   799: new 92	java/lang/StringBuilder
    //   802: dup
    //   803: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   806: astore 14
    //   808: aload 14
    //   810: ldc_w 491
    //   813: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: pop
    //   817: aload 14
    //   819: aload 5
    //   821: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: pop
    //   825: aload 14
    //   827: ldc_w 493
    //   830: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: pop
    //   834: aload 14
    //   836: ldc_w 479
    //   839: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: pop
    //   843: aload 14
    //   845: ldc_w 479
    //   848: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: pop
    //   852: aload_3
    //   853: aload 14
    //   855: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   858: invokevirtual 485	java/lang/String:getBytes	()[B
    //   861: invokevirtual 489	java/io/ByteArrayOutputStream:write	([B)V
    //   864: aload_3
    //   865: aload 6
    //   867: invokevirtual 485	java/lang/String:getBytes	()[B
    //   870: invokevirtual 489	java/io/ByteArrayOutputStream:write	([B)V
    //   873: goto -172 -> 701
    //   876: new 92	java/lang/StringBuilder
    //   879: dup
    //   880: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   883: astore_2
    //   884: aload_2
    //   885: ldc_w 479
    //   888: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: pop
    //   892: aload_2
    //   893: ldc_w 481
    //   896: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: pop
    //   900: aload_2
    //   901: aload 13
    //   903: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: pop
    //   907: aload_2
    //   908: ldc_w 479
    //   911: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: pop
    //   915: aload_3
    //   916: aload_2
    //   917: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   920: invokevirtual 485	java/lang/String:getBytes	()[B
    //   923: invokevirtual 489	java/io/ByteArrayOutputStream:write	([B)V
    //   926: new 92	java/lang/StringBuilder
    //   929: dup
    //   930: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   933: astore_2
    //   934: aload_2
    //   935: ldc_w 495
    //   938: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: pop
    //   942: aload_2
    //   943: aload_0
    //   944: invokevirtual 498	java/io/File:getName	()Ljava/lang/String;
    //   947: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: pop
    //   951: aload_2
    //   952: ldc_w 493
    //   955: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: pop
    //   959: aload_2
    //   960: ldc_w 479
    //   963: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: pop
    //   967: aload_3
    //   968: aload_2
    //   969: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   972: invokevirtual 485	java/lang/String:getBytes	()[B
    //   975: invokevirtual 489	java/io/ByteArrayOutputStream:write	([B)V
    //   978: new 92	java/lang/StringBuilder
    //   981: dup
    //   982: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   985: astore_0
    //   986: aload_0
    //   987: ldc_w 500
    //   990: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: pop
    //   994: aload_0
    //   995: ldc_w 479
    //   998: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: pop
    //   1002: aload_0
    //   1003: ldc_w 479
    //   1006: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: pop
    //   1010: aload_3
    //   1011: aload_0
    //   1012: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1015: invokevirtual 485	java/lang/String:getBytes	()[B
    //   1018: invokevirtual 489	java/io/ByteArrayOutputStream:write	([B)V
    //   1021: new 502	java/io/FileInputStream
    //   1024: dup
    //   1025: aload_1
    //   1026: invokespecial 503	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   1029: astore_1
    //   1030: aload_1
    //   1031: invokevirtual 507	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   1034: invokevirtual 511	java/nio/channels/FileChannel:size	()J
    //   1037: l2i
    //   1038: newarray byte
    //   1040: astore_0
    //   1041: aload_1
    //   1042: aload_0
    //   1043: invokevirtual 515	java/io/FileInputStream:read	([B)I
    //   1046: pop
    //   1047: aload_3
    //   1048: aload_0
    //   1049: invokevirtual 489	java/io/ByteArrayOutputStream:write	([B)V
    //   1052: new 92	java/lang/StringBuilder
    //   1055: dup
    //   1056: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   1059: astore_0
    //   1060: aload_0
    //   1061: ldc_w 479
    //   1064: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: pop
    //   1068: aload_0
    //   1069: ldc_w 481
    //   1072: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1075: pop
    //   1076: aload_0
    //   1077: aload 13
    //   1079: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1082: pop
    //   1083: aload_0
    //   1084: ldc_w 481
    //   1087: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: pop
    //   1091: aload_0
    //   1092: ldc_w 479
    //   1095: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: pop
    //   1099: aload_3
    //   1100: aload_0
    //   1101: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1104: invokevirtual 485	java/lang/String:getBytes	()[B
    //   1107: invokevirtual 489	java/io/ByteArrayOutputStream:write	([B)V
    //   1110: aload_3
    //   1111: invokevirtual 518	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1114: astore_0
    //   1115: aload_3
    //   1116: invokevirtual 520	java/io/ByteArrayOutputStream:close	()V
    //   1119: aload_1
    //   1120: invokevirtual 521	java/io/FileInputStream:close	()V
    //   1123: goto +42 -> 1165
    //   1126: astore_0
    //   1127: goto +412 -> 1539
    //   1130: astore_2
    //   1131: aload_1
    //   1132: astore_0
    //   1133: aload_2
    //   1134: astore_1
    //   1135: goto +12 -> 1147
    //   1138: astore_0
    //   1139: aconst_null
    //   1140: astore_1
    //   1141: goto +398 -> 1539
    //   1144: astore_1
    //   1145: aconst_null
    //   1146: astore_0
    //   1147: aload_1
    //   1148: invokevirtual 524	java/io/IOException:printStackTrace	()V
    //   1151: aload_3
    //   1152: invokevirtual 520	java/io/ByteArrayOutputStream:close	()V
    //   1155: aload_0
    //   1156: ifnull +7 -> 1163
    //   1159: aload_0
    //   1160: invokevirtual 521	java/io/FileInputStream:close	()V
    //   1163: aconst_null
    //   1164: astore_0
    //   1165: new 526	org/apache/http/entity/ByteArrayEntity
    //   1168: dup
    //   1169: aload_0
    //   1170: invokespecial 528	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   1173: astore_0
    //   1174: aload 12
    //   1176: aload_0
    //   1177: invokevirtual 257	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   1180: new 530	org/apache/http/params/BasicHttpParams
    //   1183: dup
    //   1184: invokespecial 531	org/apache/http/params/BasicHttpParams:<init>	()V
    //   1187: astore_0
    //   1188: aload_0
    //   1189: sipush 10000
    //   1192: invokestatic 537	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   1195: aload_0
    //   1196: sipush 10000
    //   1199: invokestatic 540	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   1202: new 259	org/apache/http/impl/client/DefaultHttpClient
    //   1205: dup
    //   1206: aload_0
    //   1207: invokespecial 543	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   1210: aload 12
    //   1212: invokevirtual 264	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   1215: astore_0
    //   1216: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1219: ifeq +45 -> 1264
    //   1222: new 92	java/lang/StringBuilder
    //   1225: dup
    //   1226: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   1229: astore_1
    //   1230: aload_1
    //   1231: ldc_w 545
    //   1234: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: pop
    //   1238: aload_1
    //   1239: aload_0
    //   1240: invokeinterface 270 1 0
    //   1245: invokeinterface 276 1 0
    //   1250: invokevirtual 548	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1253: pop
    //   1254: ldc 118
    //   1256: iconst_2
    //   1257: aload_1
    //   1258: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1261: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1264: aload_0
    //   1265: invokeinterface 270 1 0
    //   1270: invokeinterface 276 1 0
    //   1275: istore 7
    //   1277: iconst_1
    //   1278: istore 10
    //   1280: iload 7
    //   1282: sipush 200
    //   1285: if_icmpne +185 -> 1470
    //   1288: aload_0
    //   1289: invokeinterface 280 1 0
    //   1294: invokestatic 285	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   1297: astore_0
    //   1298: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1301: ifeq +35 -> 1336
    //   1304: new 92	java/lang/StringBuilder
    //   1307: dup
    //   1308: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   1311: astore_1
    //   1312: aload_1
    //   1313: ldc_w 550
    //   1316: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1319: pop
    //   1320: aload_1
    //   1321: aload_0
    //   1322: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: pop
    //   1326: ldc 118
    //   1328: iconst_2
    //   1329: aload_1
    //   1330: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1333: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1336: aload_0
    //   1337: aload_0
    //   1338: ldc_w 287
    //   1341: invokevirtual 290	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1344: aload_0
    //   1345: ldc_w 292
    //   1348: invokevirtual 295	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1351: iconst_1
    //   1352: iadd
    //   1353: invokevirtual 299	java/lang/String:substring	(II)Ljava/lang/String;
    //   1356: astore_0
    //   1357: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1360: ifeq +35 -> 1395
    //   1363: new 92	java/lang/StringBuilder
    //   1366: dup
    //   1367: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   1370: astore_1
    //   1371: aload_1
    //   1372: ldc_w 552
    //   1375: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: pop
    //   1379: aload_1
    //   1380: aload_0
    //   1381: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1384: pop
    //   1385: ldc 118
    //   1387: iconst_2
    //   1388: aload_1
    //   1389: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1392: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1395: new 303	org/json/JSONObject
    //   1398: dup
    //   1399: aload_0
    //   1400: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1403: ldc_w 306
    //   1406: ldc_w 307
    //   1409: invokevirtual 310	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1412: ldc_w 311
    //   1415: invokevirtual 314	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1418: istore 11
    //   1420: iload 11
    //   1422: ifeq +48 -> 1470
    //   1425: goto +48 -> 1473
    //   1428: astore_0
    //   1429: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1432: ifeq +38 -> 1470
    //   1435: new 92	java/lang/StringBuilder
    //   1438: dup
    //   1439: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   1442: astore_1
    //   1443: aload_1
    //   1444: ldc_w 554
    //   1447: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1450: pop
    //   1451: aload_1
    //   1452: aload_0
    //   1453: invokestatic 323	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1456: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1459: pop
    //   1460: ldc 118
    //   1462: iconst_2
    //   1463: aload_1
    //   1464: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1467: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1470: iconst_0
    //   1471: istore 10
    //   1473: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1476: ifeq +55 -> 1531
    //   1479: new 92	java/lang/StringBuilder
    //   1482: dup
    //   1483: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   1486: astore_0
    //   1487: aload_0
    //   1488: ldc_w 556
    //   1491: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1494: pop
    //   1495: aload_0
    //   1496: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   1499: lload 8
    //   1501: lsub
    //   1502: invokevirtual 116	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1505: pop
    //   1506: aload_0
    //   1507: ldc_w 558
    //   1510: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1513: pop
    //   1514: aload_0
    //   1515: iload 10
    //   1517: invokevirtual 561	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1520: pop
    //   1521: ldc 118
    //   1523: iconst_2
    //   1524: aload_0
    //   1525: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1528: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1531: iload 10
    //   1533: ireturn
    //   1534: astore_2
    //   1535: aload_0
    //   1536: astore_1
    //   1537: aload_2
    //   1538: astore_0
    //   1539: aload_3
    //   1540: invokevirtual 520	java/io/ByteArrayOutputStream:close	()V
    //   1543: aload_1
    //   1544: ifnull +7 -> 1551
    //   1547: aload_1
    //   1548: invokevirtual 521	java/io/FileInputStream:close	()V
    //   1551: aload_0
    //   1552: athrow
    //   1553: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1556: ifeq +35 -> 1591
    //   1559: new 92	java/lang/StringBuilder
    //   1562: dup
    //   1563: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   1566: astore_0
    //   1567: aload_0
    //   1568: ldc_w 563
    //   1571: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1574: pop
    //   1575: aload_0
    //   1576: aload_1
    //   1577: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1580: pop
    //   1581: ldc 118
    //   1583: iconst_2
    //   1584: aload_0
    //   1585: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1588: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1591: iconst_0
    //   1592: ireturn
    //   1593: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1596: ifeq +35 -> 1631
    //   1599: new 92	java/lang/StringBuilder
    //   1602: dup
    //   1603: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   1606: astore_1
    //   1607: aload_1
    //   1608: ldc_w 565
    //   1611: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1614: pop
    //   1615: aload_1
    //   1616: aload_0
    //   1617: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1620: pop
    //   1621: ldc 118
    //   1623: iconst_2
    //   1624: aload_1
    //   1625: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1628: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1631: iconst_0
    //   1632: ireturn
    //   1633: astore_2
    //   1634: goto -515 -> 1119
    //   1637: astore_1
    //   1638: goto -473 -> 1165
    //   1641: astore_1
    //   1642: goto -487 -> 1155
    //   1645: astore_0
    //   1646: goto -483 -> 1163
    //   1649: astore_2
    //   1650: goto -107 -> 1543
    //   1653: astore_1
    //   1654: goto -103 -> 1551
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1657	0	paramString1	String
    //   0	1657	1	paramString2	String
    //   0	1657	2	paramString3	String
    //   0	1657	3	paramString4	String
    //   0	1657	4	paramString5	String
    //   0	1657	5	paramString6	String
    //   0	1657	6	paramString7	String
    //   1275	11	7	i1	int
    //   3	1497	8	l1	long
    //   708	824	10	bool1	boolean
    //   1418	3	11	bool2	boolean
    //   52	1159	12	localObject	Object
    //   188	890	13	str	String
    //   287	567	14	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   1030	1115	1126	finally
    //   1030	1115	1130	java/io/IOException
    //   690	701	1138	finally
    //   701	710	1138	finally
    //   715	735	1138	finally
    //   743	873	1138	finally
    //   876	1030	1138	finally
    //   690	701	1144	java/io/IOException
    //   701	710	1144	java/io/IOException
    //   715	735	1144	java/io/IOException
    //   743	873	1144	java/io/IOException
    //   876	1030	1144	java/io/IOException
    //   1174	1264	1428	java/lang/Exception
    //   1264	1277	1428	java/lang/Exception
    //   1288	1336	1428	java/lang/Exception
    //   1336	1395	1428	java/lang/Exception
    //   1395	1420	1428	java/lang/Exception
    //   1147	1151	1534	finally
    //   1115	1119	1633	java/io/IOException
    //   1119	1123	1637	java/io/IOException
    //   1151	1155	1641	java/io/IOException
    //   1159	1163	1645	java/io/IOException
    //   1539	1543	1649	java/io/IOException
    //   1547	1551	1653	java/io/IOException
  }
  
  private void h()
  {
    ((ImmersiveTitleBar2)findViewById(2131447582)).setVisibility(4);
    findViewById(2131436211).setVisibility(8);
    findViewById(2131436180).setOnClickListener(this);
    TextView localTextView = (TextView)findViewById(2131448356);
    int i1 = this.w;
    String str;
    if (i1 != 1)
    {
      if (i1 != 2) {
        str = "";
      } else {
        str = getString(2131887580);
      }
    }
    else {
      str = getString(2131887596);
    }
    localTextView.setText(String.format(getString(2131887595), new Object[] { Integer.valueOf(this.x) }));
    if (this.x > 10) {
      ((TextView)findViewById(2131429588)).setText(String.format(getString(2131887587), new Object[] { Integer.valueOf(10) }));
    }
    if (this.w == 2)
    {
      findViewById(2131445026).setVisibility(0);
      ((TextView)findViewById(2131448744)).setText(String.format(getString(2131887592), new Object[] { str }));
      findViewById(2131448675).setOnClickListener(this);
      findViewById(2131448476).setOnClickListener(this);
    }
  }
  
  void a()
  {
    Object localObject = this.k;
    if ((localObject != null) && ((((BlessResultActivity.VideoUploadTask)localObject).c()) || (this.l)))
    {
      b();
      return;
    }
    localObject = this.app.getCurrentUin();
    this.k = new BlessResultActivity.VideoUploadTask(this, (String)localObject, ((TicketManager)this.app.getManager(2)).getSkey((String)localObject), this.j, this.r);
    this.a.sendEmptyMessageDelayed(1003, 120000L);
    ThreadManager.post(this.k, 8, null, false);
  }
  
  void a(int paramInt)
  {
    c();
    this.n = paramInt;
    Object localObject = this.c;
    if ((localObject != null) && (this.b != null) && (this.g != null) && (this.h != null))
    {
      localObject = new File((String)localObject);
      File localFile = new File(this.b);
      if ((((File)localObject).exists()) && (localFile.exists()))
      {
        if ((((File)localObject).isFile()) && (localFile.isFile()))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("share last uploaded ptv. mPtvPath=");
            ((StringBuilder)localObject).append(this.b);
            ((StringBuilder)localObject).append(" ,mSnapImagePath=");
            ((StringBuilder)localObject).append(this.c);
            ((StringBuilder)localObject).append(" ,mPtvUuid=");
            ((StringBuilder)localObject).append(this.g);
            ((StringBuilder)localObject).append(" ,mPtvMd5=");
            ((StringBuilder)localObject).append(this.h);
            QLog.d("BlessResultActivity", 2, ((StringBuilder)localObject).toString());
          }
          this.m = this.t.a(this.g, this.h);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("share url :");
            ((StringBuilder)localObject).append(this.m);
            QLog.d("BlessResultActivity", 2, ((StringBuilder)localObject).toString());
          }
          if (this.n == 1)
          {
            b();
            return;
          }
          ThreadManager.post(new BlessResultActivity.1(this, this.c), 8, null, false);
          return;
        }
        QQToast.makeText(this, 2131889424, 0).show();
        d();
        return;
      }
      QQToast.makeText(this, 2131889422, 0).show();
      d();
      return;
    }
    QQToast.makeText(this, 2131889422, 0).show();
    d();
  }
  
  String b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.t.J());
    ((StringBuilder)localObject).append("&vid=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("&nickname=");
    paramString = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(Base64Util.encodeToString(this.app.getCurrentNickname().getBytes(), 2));
    localObject = ((StringBuilder)localObject).toString();
    paramString = (String)localObject;
    if (this.d > 0)
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append("&template=");
      paramString.append(this.d);
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  void b()
  {
    d();
    if (this.n == 1)
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
      if (this.i != null)
      {
        d();
      }
      else
      {
        this.i = new ReportProgressDialog(this, 2131953338);
        this.i.setCancelable(false);
        this.i.show();
        this.i.setContentView(2131625585);
        ((TextView)this.i.findViewById(2131440191)).setText(2131914119);
      }
      if (!this.i.isShowing())
      {
        this.i.show();
        return;
      }
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
      if (this.i != null) {
        this.i.dismiss();
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131624333);
    this.t.k();
    this.t.a(false);
    paramBundle = getIntent();
    this.w = paramBundle.getIntExtra("param_method", 1);
    this.x = paramBundle.getIntExtra("param_count", 0);
    if (this.w == 2)
    {
      this.a = new MqqWeakReferenceHandler(this);
      this.b = paramBundle.getStringExtra("param_ptv_path");
      this.c = paramBundle.getStringExtra("param_snap_path");
      this.d = paramBundle.getIntExtra("param_ptv_id", -1);
      this.e = paramBundle.getStringExtra("param_share_title");
      this.g = paramBundle.getStringExtra("param_ptv_uuid");
      this.h = paramBundle.getStringExtra("param_ptv_md5");
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("mp4: ");
        paramBundle.append(this.b);
        paramBundle.append(", image:");
        paramBundle.append(this.c);
        QLog.d("BlessResultActivity", 2, paramBundle.toString());
      }
      WXShareHelper.a().a(this);
    }
    this.u = 0.48F;
    this.v = 2;
    h();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.w == 2)
    {
      WXShareHelper.a().b(this);
      BlessResultActivity.VideoUploadTask localVideoUploadTask = this.k;
      if ((localVideoUploadTask != null) && (localVideoUploadTask.c())) {
        this.k.a();
      }
    }
  }
  
  void e()
  {
    Object localObject = this.c;
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localArrayList.add(localObject);
    }
    String str = this.e;
    localObject = str;
    if (TextUtils.isEmpty(str))
    {
      str = this.t.d(true);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = getString(2131887591);
      }
    }
    str = String.format(getString(2131887590), new Object[] { this.app.getCurrentNickname() });
    Bundle localBundle = new Bundle();
    localBundle.putString("title", (String)localObject);
    localBundle.putString("desc", str);
    localBundle.putLong("req_share_id", 0L);
    localBundle.putString("detail_url", this.m);
    localBundle.putString("url", this.m);
    localBundle.putStringArrayList("image_url", localArrayList);
    localBundle.putString("troop_wording", (String)localObject);
    localBundle.putString("bizname", "StarBlessLink");
    QZoneShareManager.jumpToQzoneShare(this.app, this, localBundle, null);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shareToQzone: shareLink:");
      ((StringBuilder)localObject).append(this.m);
      QLog.i("BlessResultActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  void f()
  {
    int i1;
    if (!WXShareHelper.a().b()) {
      i1 = 2131918154;
    } else if (!WXShareHelper.a().c()) {
      i1 = 2131918155;
    } else {
      i1 = -1;
    }
    if (i1 != -1)
    {
      QQToast.makeText(this, getString(i1), 0).show();
      return;
    }
    this.o = String.valueOf(System.currentTimeMillis());
    Object localObject1 = null;
    Object localObject2;
    try
    {
      localObject2 = BitmapFactory.decodeFile(this.c);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getBitmapByPath OOM, fileName: ");
        ((StringBuilder)localObject2).append(this.c);
        QLog.e("BlessResultActivity", 2, ((StringBuilder)localObject2).toString(), localOutOfMemoryError);
        localObject2 = localObject1;
      }
    }
    String str = this.e;
    localObject1 = str;
    if (TextUtils.isEmpty(str))
    {
      str = this.t.d(false);
      localObject1 = str;
      if (TextUtils.isEmpty(str)) {
        localObject1 = getString(2131887591);
      }
    }
    str = String.format(getString(2131887590), new Object[] { this.app.getCurrentNickname() });
    WXShareHelper.a().c(this.o, (String)localObject1, (Bitmap)localObject2, str, this.m);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("shareToFriendCircle.transaction: ");
      ((StringBuilder)localObject1).append(this.o);
      ((StringBuilder)localObject1).append(", shareLink:");
      ((StringBuilder)localObject1).append(this.m);
      QLog.i("BlessResultActivity", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleMessage,msg.what = ");
      ((StringBuilder)localObject).append(paramMessage.what);
      QLog.d("BlessResultActivity", 2, ((StringBuilder)localObject).toString());
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1004: 
      if (((paramMessage.obj instanceof String)) && (!TextUtils.isEmpty((String)paramMessage.obj))) {
        this.c = ((String)paramMessage.obj);
      }
      b();
      return false;
    case 1003: 
      paramMessage = this.k;
      if ((paramMessage != null) && (paramMessage.c())) {
        this.k.a();
      }
      d();
      QQToast.makeText(this, 1, 2131916544, 0).show();
    case 1002: 
      return true;
    case 1001: 
      this.p = this.b;
      this.q = this.f;
      paramMessage = getSharedPreferences("bless_ptv_upload", 0).edit();
      localObject = getCurrentAccountUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bless_ptv_path");
      localStringBuilder.append((String)localObject);
      paramMessage.putString(localStringBuilder.toString(), this.p);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("bless_vid");
      localStringBuilder.append((String)localObject);
      paramMessage.putString(localStringBuilder.toString(), this.q);
      paramMessage.commit();
      b();
      return true;
    }
    a();
    return true;
  }
  
  protected boolean onBackEvent()
  {
    Intent localIntent = new Intent(this, BlessActivity.class);
    localIntent.setFlags(67108864);
    startActivity(localIntent);
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131436180)
    {
      if (i1 != 2131448476)
      {
        if (i1 == 2131448675) {
          a(1);
        }
      }
      else {
        a(2);
      }
      super.onClick(paramView);
    }
    else
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    String str = this.o;
    if (str != null)
    {
      if (!str.equals(paramBaseResp.transaction)) {
        return;
      }
      int i1 = paramBaseResp.errCode;
      if (i1 != -2)
      {
        if (i1 != 0)
        {
          QQToast.makeText(this, 1, getString(2131916544), 0).show();
          return;
        }
        QQToast.makeText(this, 2, getString(2131916563), 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessResultActivity
 * JD-Core Version:    0.7.0.1
 */