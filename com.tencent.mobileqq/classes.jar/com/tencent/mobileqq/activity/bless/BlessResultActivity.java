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
  int jdField_a_of_type_Int;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  BlessResultActivity.VideoInfo jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo;
  BlessResultActivity.VideoUploadTask jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask;
  TroopBarShortVideoUploadUtil.OnUploadVideoListener jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener = new BlessResultActivity.2(this);
  MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  String jdField_b_of_type_JavaLangString;
  String c;
  private int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  String jdField_e_of_type_JavaLangString;
  String f;
  String g;
  String h;
  String i;
  String j;
  
  public static TroopBarShortVideoUploadUtil.ApplyUploadRsp a(Bundle paramBundle, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return a(paramBundle, paramString1, paramString2, paramString3, paramBoolean, "https://c.v.qq.com/openfvupready?g_tk=");
  }
  
  public static TroopBarShortVideoUploadUtil.ApplyUploadRsp a(Bundle paramBundle, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    long l = System.currentTimeMillis();
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
      paramString1.add(new BasicNameValuePair("sha", HexUtil.bytes2HexStr(FileManagerUtil.a(str1))));
      paramString1.add(new BasicNameValuePair("md5", HexUtil.bytes2HexStr(FileManagerUtil.d(str1))));
      if (QLog.isColorLevel())
      {
        paramString3 = new StringBuilder();
        paramString3.append("applyUpload() getMessageDigest time = ");
        paramString3.append(System.currentTimeMillis() - l);
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
        paramString1.append(System.currentTimeMillis() - l);
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
      int m = localObject2.length;
      int k = 0;
      while (k < m)
      {
        localObject2[k].delete();
        k += 1;
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
    //   0: invokestatic 58	java/lang/System:currentTimeMillis	()J
    //   3: lstore 8
    //   5: aload_0
    //   6: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +1584 -> 1593
    //   12: aload_0
    //   13: invokestatic 125	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   16: ifne +6 -> 22
    //   19: goto +1574 -> 1593
    //   22: aload_1
    //   23: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +1527 -> 1553
    //   29: aload_1
    //   30: invokestatic 125	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   33: ifne +6 -> 39
    //   36: goto +1517 -> 1553
    //   39: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +140 -> 182
    //   45: new 82	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   52: astore 12
    //   54: aload 12
    //   56: ldc_w 352
    //   59: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 12
    //   65: aload_0
    //   66: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 12
    //   72: ldc_w 354
    //   75: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 12
    //   81: aload_1
    //   82: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 12
    //   88: ldc_w 356
    //   91: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 12
    //   97: aload_1
    //   98: invokestatic 103	com/tencent/mobileqq/utils/FileUtils:getFileSizes	(Ljava/lang/String;)J
    //   101: invokevirtual 106	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 12
    //   107: ldc_w 358
    //   110: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 12
    //   116: aload_2
    //   117: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 12
    //   123: ldc_w 360
    //   126: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 12
    //   132: aload_3
    //   133: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 12
    //   139: ldc_w 362
    //   142: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 12
    //   148: aload 4
    //   150: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 12
    //   156: ldc_w 364
    //   159: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload 12
    //   165: aload 5
    //   167: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: ldc 108
    //   173: iconst_2
    //   174: aload 12
    //   176: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: invokestatic 370	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   185: invokevirtual 371	java/util/UUID:toString	()Ljava/lang/String;
    //   188: astore 13
    //   190: new 82	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   197: astore 12
    //   199: aload 12
    //   201: ldc_w 373
    //   204: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 12
    //   210: aload_3
    //   211: invokestatic 140	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil:a	(Ljava/lang/String;)I
    //   214: invokestatic 144	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   217: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: new 146	org/apache/http/client/methods/HttpPost
    //   224: dup
    //   225: aload 12
    //   227: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokespecial 149	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   233: astore 12
    //   235: aload 12
    //   237: ldc 151
    //   239: ldc 153
    //   241: invokevirtual 157	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload 12
    //   246: ldc 159
    //   248: ldc 161
    //   250: invokevirtual 157	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload 12
    //   255: ldc 163
    //   257: ldc 165
    //   259: invokevirtual 157	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload 12
    //   264: ldc 167
    //   266: ldc 169
    //   268: invokevirtual 157	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload 12
    //   273: ldc 171
    //   275: ldc 173
    //   277: invokevirtual 157	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: new 82	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   287: astore 14
    //   289: aload 14
    //   291: ldc 175
    //   293: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload 14
    //   299: aload_3
    //   300: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload 14
    //   306: ldc 177
    //   308: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 14
    //   314: aload_2
    //   315: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 12
    //   321: ldc 179
    //   323: aload 14
    //   325: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokevirtual 157	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: aload 12
    //   333: ldc 181
    //   335: ldc 183
    //   337: invokevirtual 157	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   340: new 82	java/lang/StringBuilder
    //   343: dup
    //   344: ldc_w 375
    //   347: invokespecial 376	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   350: astore_2
    //   351: aload_2
    //   352: aload 13
    //   354: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 12
    //   360: ldc_w 378
    //   363: aload_2
    //   364: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokevirtual 157	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: new 62	android/os/Bundle
    //   373: dup
    //   374: invokespecial 379	android/os/Bundle:<init>	()V
    //   377: astore_2
    //   378: aload_2
    //   379: ldc 190
    //   381: aload 6
    //   383: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   386: aload_2
    //   387: ldc 74
    //   389: aload 4
    //   391: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   394: aload_2
    //   395: ldc_w 384
    //   398: aload 5
    //   400: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   403: aload_2
    //   404: ldc 200
    //   406: aload_0
    //   407: invokestatic 103	com/tencent/mobileqq/utils/FileUtils:getFileSizes	(Ljava/lang/String;)J
    //   410: invokestatic 203	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   413: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   416: aload_2
    //   417: ldc 205
    //   419: aload_0
    //   420: invokestatic 210	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)[B
    //   423: invokestatic 216	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   426: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   429: aload_2
    //   430: ldc 218
    //   432: aload_0
    //   433: invokestatic 220	com/tencent/mobileqq/filemanager/util/FileManagerUtil:d	(Ljava/lang/String;)[B
    //   436: invokestatic 216	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   439: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   445: ifeq +40 -> 485
    //   448: new 82	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   455: astore_0
    //   456: aload_0
    //   457: ldc_w 386
    //   460: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aload_0
    //   465: invokestatic 58	java/lang/System:currentTimeMillis	()J
    //   468: lload 8
    //   470: lsub
    //   471: invokevirtual 106	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: ldc 108
    //   477: iconst_2
    //   478: aload_0
    //   479: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   485: aload_2
    //   486: ldc 224
    //   488: ldc 226
    //   490: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   493: aload_2
    //   494: ldc 228
    //   496: aload_3
    //   497: invokestatic 140	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil:a	(Ljava/lang/String;)I
    //   500: invokestatic 144	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   503: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   506: aload_2
    //   507: ldc 230
    //   509: ldc 232
    //   511: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: aload_2
    //   515: ldc_w 388
    //   518: ldc_w 390
    //   521: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   524: aload_2
    //   525: ldc_w 392
    //   528: ldc_w 394
    //   531: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   534: aload_2
    //   535: ldc_w 396
    //   538: ldc_w 398
    //   541: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   544: aload_2
    //   545: ldc_w 400
    //   548: ldc_w 402
    //   551: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   554: aload_2
    //   555: ldc_w 404
    //   558: ldc_w 406
    //   561: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   564: aload_2
    //   565: ldc_w 408
    //   568: ldc_w 410
    //   571: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   574: aload_2
    //   575: ldc_w 412
    //   578: ldc_w 414
    //   581: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: aload_2
    //   585: ldc_w 416
    //   588: ldc_w 418
    //   591: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   594: aload_2
    //   595: ldc_w 420
    //   598: ldc_w 422
    //   601: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   604: aload_2
    //   605: ldc_w 424
    //   608: ldc_w 426
    //   611: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   614: aload_2
    //   615: ldc_w 428
    //   618: ldc_w 426
    //   621: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   624: aload_2
    //   625: ldc_w 430
    //   628: ldc_w 432
    //   631: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   634: aload_2
    //   635: ldc_w 434
    //   638: ldc_w 436
    //   641: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   644: aload_2
    //   645: ldc_w 438
    //   648: ldc 236
    //   650: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   653: aload_2
    //   654: ldc_w 440
    //   657: ldc_w 442
    //   660: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   663: aload_2
    //   664: ldc_w 444
    //   667: ldc_w 446
    //   670: invokevirtual 382	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   673: new 448	java/io/ByteArrayOutputStream
    //   676: dup
    //   677: invokespecial 449	java/io/ByteArrayOutputStream:<init>	()V
    //   680: astore_3
    //   681: new 329	java/io/File
    //   684: dup
    //   685: aload_1
    //   686: invokespecial 330	java/io/File:<init>	(Ljava/lang/String;)V
    //   689: astore_0
    //   690: aload_2
    //   691: invokevirtual 453	android/os/Bundle:keySet	()Ljava/util/Set;
    //   694: invokeinterface 459 1 0
    //   699: astore 4
    //   701: aload 4
    //   703: invokeinterface 464 1 0
    //   708: istore 10
    //   710: iload 10
    //   712: ifeq +164 -> 876
    //   715: aload 4
    //   717: invokeinterface 468 1 0
    //   722: checkcast 131	java/lang/String
    //   725: astore 5
    //   727: aload_2
    //   728: aload 5
    //   730: invokevirtual 66	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   733: astore 6
    //   735: aload 6
    //   737: ifnonnull +6 -> 743
    //   740: goto -39 -> 701
    //   743: new 82	java/lang/StringBuilder
    //   746: dup
    //   747: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   750: astore 14
    //   752: aload 14
    //   754: ldc_w 470
    //   757: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: pop
    //   761: aload 14
    //   763: ldc_w 472
    //   766: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: pop
    //   770: aload 14
    //   772: aload 13
    //   774: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: pop
    //   778: aload 14
    //   780: ldc_w 470
    //   783: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: aload_3
    //   788: aload 14
    //   790: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   793: invokevirtual 476	java/lang/String:getBytes	()[B
    //   796: invokevirtual 480	java/io/ByteArrayOutputStream:write	([B)V
    //   799: new 82	java/lang/StringBuilder
    //   802: dup
    //   803: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   806: astore 14
    //   808: aload 14
    //   810: ldc_w 482
    //   813: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: pop
    //   817: aload 14
    //   819: aload 5
    //   821: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: pop
    //   825: aload 14
    //   827: ldc_w 484
    //   830: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: pop
    //   834: aload 14
    //   836: ldc_w 470
    //   839: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: pop
    //   843: aload 14
    //   845: ldc_w 470
    //   848: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: pop
    //   852: aload_3
    //   853: aload 14
    //   855: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   858: invokevirtual 476	java/lang/String:getBytes	()[B
    //   861: invokevirtual 480	java/io/ByteArrayOutputStream:write	([B)V
    //   864: aload_3
    //   865: aload 6
    //   867: invokevirtual 476	java/lang/String:getBytes	()[B
    //   870: invokevirtual 480	java/io/ByteArrayOutputStream:write	([B)V
    //   873: goto -172 -> 701
    //   876: new 82	java/lang/StringBuilder
    //   879: dup
    //   880: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   883: astore_2
    //   884: aload_2
    //   885: ldc_w 470
    //   888: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: pop
    //   892: aload_2
    //   893: ldc_w 472
    //   896: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: pop
    //   900: aload_2
    //   901: aload 13
    //   903: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: pop
    //   907: aload_2
    //   908: ldc_w 470
    //   911: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: pop
    //   915: aload_3
    //   916: aload_2
    //   917: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   920: invokevirtual 476	java/lang/String:getBytes	()[B
    //   923: invokevirtual 480	java/io/ByteArrayOutputStream:write	([B)V
    //   926: new 82	java/lang/StringBuilder
    //   929: dup
    //   930: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   933: astore_2
    //   934: aload_2
    //   935: ldc_w 486
    //   938: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: pop
    //   942: aload_2
    //   943: aload_0
    //   944: invokevirtual 489	java/io/File:getName	()Ljava/lang/String;
    //   947: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: pop
    //   951: aload_2
    //   952: ldc_w 484
    //   955: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: pop
    //   959: aload_2
    //   960: ldc_w 470
    //   963: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: pop
    //   967: aload_3
    //   968: aload_2
    //   969: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   972: invokevirtual 476	java/lang/String:getBytes	()[B
    //   975: invokevirtual 480	java/io/ByteArrayOutputStream:write	([B)V
    //   978: new 82	java/lang/StringBuilder
    //   981: dup
    //   982: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   985: astore_0
    //   986: aload_0
    //   987: ldc_w 491
    //   990: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: pop
    //   994: aload_0
    //   995: ldc_w 470
    //   998: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: pop
    //   1002: aload_0
    //   1003: ldc_w 470
    //   1006: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: pop
    //   1010: aload_3
    //   1011: aload_0
    //   1012: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1015: invokevirtual 476	java/lang/String:getBytes	()[B
    //   1018: invokevirtual 480	java/io/ByteArrayOutputStream:write	([B)V
    //   1021: new 493	java/io/FileInputStream
    //   1024: dup
    //   1025: aload_1
    //   1026: invokespecial 494	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   1029: astore_1
    //   1030: aload_1
    //   1031: invokevirtual 498	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   1034: invokevirtual 502	java/nio/channels/FileChannel:size	()J
    //   1037: l2i
    //   1038: newarray byte
    //   1040: astore_0
    //   1041: aload_1
    //   1042: aload_0
    //   1043: invokevirtual 506	java/io/FileInputStream:read	([B)I
    //   1046: pop
    //   1047: aload_3
    //   1048: aload_0
    //   1049: invokevirtual 480	java/io/ByteArrayOutputStream:write	([B)V
    //   1052: new 82	java/lang/StringBuilder
    //   1055: dup
    //   1056: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   1059: astore_0
    //   1060: aload_0
    //   1061: ldc_w 470
    //   1064: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: pop
    //   1068: aload_0
    //   1069: ldc_w 472
    //   1072: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1075: pop
    //   1076: aload_0
    //   1077: aload 13
    //   1079: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1082: pop
    //   1083: aload_0
    //   1084: ldc_w 472
    //   1087: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: pop
    //   1091: aload_0
    //   1092: ldc_w 470
    //   1095: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: pop
    //   1099: aload_3
    //   1100: aload_0
    //   1101: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1104: invokevirtual 476	java/lang/String:getBytes	()[B
    //   1107: invokevirtual 480	java/io/ByteArrayOutputStream:write	([B)V
    //   1110: aload_3
    //   1111: invokevirtual 509	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1114: astore_0
    //   1115: aload_3
    //   1116: invokevirtual 511	java/io/ByteArrayOutputStream:close	()V
    //   1119: aload_1
    //   1120: invokevirtual 512	java/io/FileInputStream:close	()V
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
    //   1148: invokevirtual 515	java/io/IOException:printStackTrace	()V
    //   1151: aload_3
    //   1152: invokevirtual 511	java/io/ByteArrayOutputStream:close	()V
    //   1155: aload_0
    //   1156: ifnull +7 -> 1163
    //   1159: aload_0
    //   1160: invokevirtual 512	java/io/FileInputStream:close	()V
    //   1163: aconst_null
    //   1164: astore_0
    //   1165: new 517	org/apache/http/entity/ByteArrayEntity
    //   1168: dup
    //   1169: aload_0
    //   1170: invokespecial 519	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   1173: astore_0
    //   1174: aload 12
    //   1176: aload_0
    //   1177: invokevirtual 247	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   1180: new 521	org/apache/http/params/BasicHttpParams
    //   1183: dup
    //   1184: invokespecial 522	org/apache/http/params/BasicHttpParams:<init>	()V
    //   1187: astore_0
    //   1188: aload_0
    //   1189: sipush 10000
    //   1192: invokestatic 528	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   1195: aload_0
    //   1196: sipush 10000
    //   1199: invokestatic 531	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   1202: new 249	org/apache/http/impl/client/DefaultHttpClient
    //   1205: dup
    //   1206: aload_0
    //   1207: invokespecial 534	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   1210: aload 12
    //   1212: invokevirtual 254	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   1215: astore_0
    //   1216: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1219: ifeq +45 -> 1264
    //   1222: new 82	java/lang/StringBuilder
    //   1225: dup
    //   1226: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   1229: astore_1
    //   1230: aload_1
    //   1231: ldc_w 536
    //   1234: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: pop
    //   1238: aload_1
    //   1239: aload_0
    //   1240: invokeinterface 260 1 0
    //   1245: invokeinterface 266 1 0
    //   1250: invokevirtual 539	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1253: pop
    //   1254: ldc 108
    //   1256: iconst_2
    //   1257: aload_1
    //   1258: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1261: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1264: aload_0
    //   1265: invokeinterface 260 1 0
    //   1270: invokeinterface 266 1 0
    //   1275: istore 7
    //   1277: iconst_1
    //   1278: istore 10
    //   1280: iload 7
    //   1282: sipush 200
    //   1285: if_icmpne +185 -> 1470
    //   1288: aload_0
    //   1289: invokeinterface 270 1 0
    //   1294: invokestatic 275	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   1297: astore_0
    //   1298: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1301: ifeq +35 -> 1336
    //   1304: new 82	java/lang/StringBuilder
    //   1307: dup
    //   1308: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   1311: astore_1
    //   1312: aload_1
    //   1313: ldc_w 541
    //   1316: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1319: pop
    //   1320: aload_1
    //   1321: aload_0
    //   1322: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: pop
    //   1326: ldc 108
    //   1328: iconst_2
    //   1329: aload_1
    //   1330: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1333: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1336: aload_0
    //   1337: aload_0
    //   1338: ldc_w 277
    //   1341: invokevirtual 280	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1344: aload_0
    //   1345: ldc_w 282
    //   1348: invokevirtual 285	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1351: iconst_1
    //   1352: iadd
    //   1353: invokevirtual 289	java/lang/String:substring	(II)Ljava/lang/String;
    //   1356: astore_0
    //   1357: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1360: ifeq +35 -> 1395
    //   1363: new 82	java/lang/StringBuilder
    //   1366: dup
    //   1367: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   1370: astore_1
    //   1371: aload_1
    //   1372: ldc_w 543
    //   1375: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: pop
    //   1379: aload_1
    //   1380: aload_0
    //   1381: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1384: pop
    //   1385: ldc 108
    //   1387: iconst_2
    //   1388: aload_1
    //   1389: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1392: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1395: new 293	org/json/JSONObject
    //   1398: dup
    //   1399: aload_0
    //   1400: invokespecial 294	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1403: ldc_w 296
    //   1406: ldc_w 297
    //   1409: invokevirtual 300	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1412: ldc_w 302
    //   1415: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1418: istore 11
    //   1420: iload 11
    //   1422: ifeq +48 -> 1470
    //   1425: goto +48 -> 1473
    //   1428: astore_0
    //   1429: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1432: ifeq +38 -> 1470
    //   1435: new 82	java/lang/StringBuilder
    //   1438: dup
    //   1439: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   1442: astore_1
    //   1443: aload_1
    //   1444: ldc_w 545
    //   1447: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1450: pop
    //   1451: aload_1
    //   1452: aload_0
    //   1453: invokestatic 314	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1456: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1459: pop
    //   1460: ldc 108
    //   1462: iconst_2
    //   1463: aload_1
    //   1464: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1467: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1470: iconst_0
    //   1471: istore 10
    //   1473: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1476: ifeq +55 -> 1531
    //   1479: new 82	java/lang/StringBuilder
    //   1482: dup
    //   1483: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   1486: astore_0
    //   1487: aload_0
    //   1488: ldc_w 547
    //   1491: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1494: pop
    //   1495: aload_0
    //   1496: invokestatic 58	java/lang/System:currentTimeMillis	()J
    //   1499: lload 8
    //   1501: lsub
    //   1502: invokevirtual 106	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1505: pop
    //   1506: aload_0
    //   1507: ldc_w 549
    //   1510: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1513: pop
    //   1514: aload_0
    //   1515: iload 10
    //   1517: invokevirtual 552	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1520: pop
    //   1521: ldc 108
    //   1523: iconst_2
    //   1524: aload_0
    //   1525: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1528: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1531: iload 10
    //   1533: ireturn
    //   1534: astore_2
    //   1535: aload_0
    //   1536: astore_1
    //   1537: aload_2
    //   1538: astore_0
    //   1539: aload_3
    //   1540: invokevirtual 511	java/io/ByteArrayOutputStream:close	()V
    //   1543: aload_1
    //   1544: ifnull +7 -> 1551
    //   1547: aload_1
    //   1548: invokevirtual 512	java/io/FileInputStream:close	()V
    //   1551: aload_0
    //   1552: athrow
    //   1553: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1556: ifeq +35 -> 1591
    //   1559: new 82	java/lang/StringBuilder
    //   1562: dup
    //   1563: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   1566: astore_0
    //   1567: aload_0
    //   1568: ldc_w 554
    //   1571: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1574: pop
    //   1575: aload_0
    //   1576: aload_1
    //   1577: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1580: pop
    //   1581: ldc 108
    //   1583: iconst_2
    //   1584: aload_0
    //   1585: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1588: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1591: iconst_0
    //   1592: ireturn
    //   1593: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1596: ifeq +35 -> 1631
    //   1599: new 82	java/lang/StringBuilder
    //   1602: dup
    //   1603: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   1606: astore_1
    //   1607: aload_1
    //   1608: ldc_w 556
    //   1611: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1614: pop
    //   1615: aload_1
    //   1616: aload_0
    //   1617: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1620: pop
    //   1621: ldc 108
    //   1623: iconst_2
    //   1624: aload_1
    //   1625: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1628: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   1275	11	7	k	int
    //   3	1497	8	l	long
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
  
  private void g()
  {
    ((ImmersiveTitleBar2)findViewById(2131378881)).setVisibility(4);
    findViewById(2131369233).setVisibility(8);
    findViewById(2131369202).setOnClickListener(this);
    TextView localTextView = (TextView)findViewById(2131379598);
    int k = this.jdField_d_of_type_Int;
    String str;
    if (k != 1)
    {
      if (k != 2) {
        str = "";
      } else {
        str = getString(2131690665);
      }
    }
    else {
      str = getString(2131690681);
    }
    localTextView.setText(String.format(getString(2131690680), new Object[] { Integer.valueOf(this.jdField_e_of_type_Int) }));
    if (this.jdField_e_of_type_Int > 10) {
      ((TextView)findViewById(2131363675)).setText(String.format(getString(2131690672), new Object[] { Integer.valueOf(10) }));
    }
    if (this.jdField_d_of_type_Int == 2)
    {
      findViewById(2131376738).setVisibility(0);
      ((TextView)findViewById(2131379876)).setText(String.format(getString(2131690677), new Object[] { str }));
      findViewById(2131379829).setOnClickListener(this);
      findViewById(2131379693).setOnClickListener(this);
    }
  }
  
  void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask;
    if ((localObject != null) && ((((BlessResultActivity.VideoUploadTask)localObject).b()) || (this.jdField_a_of_type_Boolean)))
    {
      b();
      return;
    }
    localObject = this.app.getCurrentUin();
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask = new BlessResultActivity.VideoUploadTask(this, (String)localObject, ((TicketManager)this.app.getManager(2)).getSkey((String)localObject), this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1003, 120000L);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask, 8, null, false);
  }
  
  void a(int paramInt)
  {
    c();
    this.jdField_b_of_type_Int = paramInt;
    Object localObject = this.jdField_b_of_type_JavaLangString;
    if ((localObject != null) && (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_e_of_type_JavaLangString != null) && (this.f != null))
    {
      localObject = new File((String)localObject);
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if ((((File)localObject).exists()) && (localFile.exists()))
      {
        if ((((File)localObject).isFile()) && (localFile.isFile()))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("share last uploaded ptv. mPtvPath=");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject).append(" ,mSnapImagePath=");
            ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
            ((StringBuilder)localObject).append(" ,mPtvUuid=");
            ((StringBuilder)localObject).append(this.jdField_e_of_type_JavaLangString);
            ((StringBuilder)localObject).append(" ,mPtvMd5=");
            ((StringBuilder)localObject).append(this.f);
            QLog.d("BlessResultActivity", 2, ((StringBuilder)localObject).toString());
          }
          this.g = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(this.jdField_e_of_type_JavaLangString, this.f);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("share url :");
            ((StringBuilder)localObject).append(this.g);
            QLog.d("BlessResultActivity", 2, ((StringBuilder)localObject).toString());
          }
          if (this.jdField_b_of_type_Int == 1)
          {
            b();
            return;
          }
          ThreadManager.post(new BlessResultActivity.1(this, this.jdField_b_of_type_JavaLangString), 8, null, false);
          return;
        }
        QQToast.a(this, 2131692436, 0).a();
        d();
        return;
      }
      QQToast.a(this, 2131692434, 0).a();
      d();
      return;
    }
    QQToast.a(this, 2131692434, 0).a();
    d();
  }
  
  String b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.e());
    ((StringBuilder)localObject).append("&vid=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("&nickname=");
    paramString = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(Base64Util.encodeToString(this.app.getCurrentNickname().getBytes(), 2));
    localObject = ((StringBuilder)localObject).toString();
    paramString = (String)localObject;
    if (this.jdField_a_of_type_Int > 0)
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append("&template=");
      paramString.append(this.jdField_a_of_type_Int);
      paramString = paramString.toString();
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
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
      {
        d();
      }
      else
      {
        this.jdField_a_of_type_AndroidAppProgressDialog = new ReportProgressDialog(this, 2131756189);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559561);
        ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131372646)).setText(2131716656);
      }
      if (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558716);
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(false);
    paramBundle = getIntent();
    this.jdField_d_of_type_Int = paramBundle.getIntExtra("param_method", 1);
    this.jdField_e_of_type_Int = paramBundle.getIntExtra("param_count", 0);
    if (this.jdField_d_of_type_Int == 2)
    {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("param_ptv_path");
      this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("param_snap_path");
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("param_ptv_id", -1);
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("param_share_title");
      this.jdField_e_of_type_JavaLangString = paramBundle.getStringExtra("param_ptv_uuid");
      this.f = paramBundle.getStringExtra("param_ptv_md5");
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("mp4: ");
        paramBundle.append(this.jdField_a_of_type_JavaLangString);
        paramBundle.append(", image:");
        paramBundle.append(this.jdField_b_of_type_JavaLangString);
        QLog.d("BlessResultActivity", 2, paramBundle.toString());
      }
      WXShareHelper.a().a(this);
    }
    this.jdField_a_of_type_Float = 0.48F;
    this.jdField_c_of_type_Int = 2;
    g();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_d_of_type_Int == 2)
    {
      WXShareHelper.a().b(this);
      BlessResultActivity.VideoUploadTask localVideoUploadTask = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask;
      if ((localVideoUploadTask != null) && (localVideoUploadTask.b())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask.a();
      }
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
      str = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(true);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = getString(2131690676);
      }
    }
    str = String.format(getString(2131690675), new Object[] { this.app.getCurrentNickname() });
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shareToQzone: shareLink:");
      ((StringBuilder)localObject).append(this.g);
      QLog.i("BlessResultActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  void f()
  {
    int k;
    if (!WXShareHelper.a().a()) {
      k = 2131720478;
    } else if (!WXShareHelper.a().b()) {
      k = 2131720479;
    } else {
      k = -1;
    }
    if (k != -1)
    {
      QQToast.a(this, getString(k), 0).a();
      return;
    }
    this.h = String.valueOf(System.currentTimeMillis());
    Object localObject1 = null;
    Object localObject2;
    try
    {
      localObject2 = BitmapFactory.decodeFile(this.jdField_b_of_type_JavaLangString);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getBitmapByPath OOM, fileName: ");
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
        QLog.e("BlessResultActivity", 2, ((StringBuilder)localObject2).toString(), localOutOfMemoryError);
        localObject2 = localObject1;
      }
    }
    String str = this.jdField_c_of_type_JavaLangString;
    localObject1 = str;
    if (TextUtils.isEmpty(str))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(false);
      localObject1 = str;
      if (TextUtils.isEmpty(str)) {
        localObject1 = getString(2131690676);
      }
    }
    str = String.format(getString(2131690675), new Object[] { this.app.getCurrentNickname() });
    WXShareHelper.a().c(this.h, (String)localObject1, (Bitmap)localObject2, str, this.g);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("shareToFriendCircle.transaction: ");
      ((StringBuilder)localObject1).append(this.h);
      ((StringBuilder)localObject1).append(", shareLink:");
      ((StringBuilder)localObject1).append(this.g);
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
        this.jdField_b_of_type_JavaLangString = ((String)paramMessage.obj);
      }
      b();
      return false;
    case 1003: 
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask;
      if ((paramMessage != null) && (paramMessage.b())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask.a();
      }
      d();
      QQToast.a(this, 1, 2131719009, 0).a();
    case 1002: 
      return true;
    case 1001: 
      this.i = this.jdField_a_of_type_JavaLangString;
      this.j = this.jdField_d_of_type_JavaLangString;
      paramMessage = getSharedPreferences("bless_ptv_upload", 0).edit();
      localObject = getCurrentAccountUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bless_ptv_path");
      localStringBuilder.append((String)localObject);
      paramMessage.putString(localStringBuilder.toString(), this.i);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("bless_vid");
      localStringBuilder.append((String)localObject);
      paramMessage.putString(localStringBuilder.toString(), this.j);
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
    int k = paramView.getId();
    if (k != 2131369202)
    {
      if (k != 2131379693)
      {
        if (k == 2131379829) {
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
    String str = this.h;
    if (str != null)
    {
      if (!str.equals(paramBaseResp.transaction)) {
        return;
      }
      int k = paramBaseResp.errCode;
      if (k != -2)
      {
        if (k != 0)
        {
          QQToast.a(this, 1, getString(2131719009), 0).a();
          return;
        }
        QQToast.a(this, 2, getString(2131719027), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessResultActivity
 * JD-Core Version:    0.7.0.1
 */