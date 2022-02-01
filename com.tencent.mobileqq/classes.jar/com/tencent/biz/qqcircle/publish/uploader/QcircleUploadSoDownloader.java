package com.tencent.biz.qqcircle.publish.uploader;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AppSetting;
import com.tencent.biz.qcircleshadow.lib.variation.HostFileUtils;
import com.tencent.biz.qqcircle.publish.uploader.service.QcircleAlphaConfig;
import com.tencent.biz.qqcircle.publish.util.MD5Util;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class QcircleUploadSoDownloader
{
  private static int a = 5;
  private static File b = QCircleApplication.APP.getDir("qzoneupload", 0);
  private static volatile boolean c = false;
  private static boolean d = false;
  
  private boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("md5.json");
    localObject1 = new File(((StringBuilder)localObject1).toString());
    if (!((File)localObject1).exists()) {
      return false;
    }
    try
    {
      localObject1 = HostFileUtils.readFileContent((File)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return false;
      }
      JSONArray localJSONArray = new JSONObject((String)localObject1).getJSONArray("so_lib");
      int i = 0;
      boolean bool = false;
      while (i < localJSONArray.length())
      {
        Object localObject2 = (JSONObject)localJSONArray.get(i);
        localObject1 = ((JSONObject)localObject2).getString("name");
        localObject2 = ((JSONObject)localObject2).getString("md5");
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append(File.separator);
        ((StringBuilder)localObject3).append((String)localObject1);
        localObject3 = new File(((StringBuilder)localObject3).toString());
        if (!((File)localObject3).exists())
        {
          paramString = new StringBuilder();
          paramString.append("so not exists ");
          paramString.append((String)localObject1);
          QLog.d("[upload2]QcircleUploadSoDownloader", 1, paramString.toString());
          break;
        }
        String str = MD5Util.a((File)localObject3);
        QLog.d("[upload2]QcircleUploadSoDownloader", 1, new Object[] { "src md5 : ", str, " dst md5 : ", localObject2, " file size :", Long.valueOf(((File)localObject3).length()), " file : ", localObject1 });
        if ((str != null) && (!str.equals(localObject2))) {
          break;
        }
        int j = localJSONArray.length();
        if (i == j - 1) {
          bool = true;
        }
        i += 1;
      }
      return bool;
    }
    catch (Exception paramString)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkSoMd5 error : ");
      ((StringBuilder)localObject1).append(paramString.getMessage());
      QLog.d("[upload2]QcircleUploadSoDownloader", 1, ((StringBuilder)localObject1).toString());
    }
    return false;
  }
  
  private void c(String paramString)
  {
    SharedPreferences localSharedPreferences = QCircleApplication.APP.getSharedPreferences("qzone_upload_so", 0);
    String str = "";
    if (localSharedPreferences != null) {
      str = localSharedPreferences.getString("upload_so_ver", "");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last ver ");
    localStringBuilder.append(str);
    localStringBuilder.append(" curUrl:");
    localStringBuilder.append(paramString);
    QLog.d("[upload2]QcircleUploadSoDownloader", 1, localStringBuilder.toString());
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if (str.equals(paramString)) {
      return;
    }
    if (localSharedPreferences != null)
    {
      localSharedPreferences.edit().remove(str);
      localSharedPreferences.edit().remove("upload_so_ver");
    }
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saveSoDownloadState ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("[upload2]QcircleUploadSoDownloader", 1, ((StringBuilder)localObject).toString());
    localObject = QCircleApplication.APP.getSharedPreferences("qzone_upload_so", 0);
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putBoolean("upload_so_download_success", paramBoolean).commit();
    }
  }
  
  private boolean c()
  {
    Object localObject = QCircleApplication.APP;
    boolean bool = false;
    localObject = ((Application)localObject).getSharedPreferences("qzone_upload_so", 0);
    if (localObject != null) {
      bool = ((SharedPreferences)localObject).getBoolean("upload_so_download_success", false);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getSoDownloadState ");
    ((StringBuilder)localObject).append(bool);
    QLog.d("[upload2]QcircleUploadSoDownloader", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  private int d()
  {
    Object localObject = QCircleApplication.APP.getSharedPreferences("qzone_upload_so", 0);
    if (localObject != null)
    {
      String str = ((SharedPreferences)localObject).getString("upload_so_ver", "");
      int i = ((SharedPreferences)localObject).getInt(str, 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getRetryCnt ver ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" cnt:");
      ((StringBuilder)localObject).append(i);
      QLog.d("[upload2]QcircleUploadSoDownloader", 1, ((StringBuilder)localObject).toString());
      return i;
    }
    QLog.d("[upload2]QcircleUploadSoDownloader", 1, "getRetryCnt 0");
    return 0;
  }
  
  private void d(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("recordRetryCnt ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("[upload2]QcircleUploadSoDownloader", 1, ((StringBuilder)localObject).toString());
    c(paramString);
    localObject = QCircleApplication.APP.getSharedPreferences("qzone_upload_so", 0);
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((SharedPreferences)localObject).getString("upload_so_ver", ""))) {
        ((SharedPreferences)localObject).edit().putString("upload_so_ver", paramString).commit();
      }
      int i = ((SharedPreferences)localObject).getInt(paramString, 0);
      ((SharedPreferences)localObject).edit().putInt(paramString, i + 1).commit();
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 238	com/tencent/biz/qcircleshadow/lib/QCircleHostConstants$QzoneModuleConst:QZONE_MODULE_UPLOAD_SO	()Ljava/lang/String;
    //   5: invokestatic 243	com/tencent/biz/qcircleshadow/lib/QCircleHostSoDownloadHelper:checkIfNeedUpdate	(Ljava/lang/String;)Z
    //   8: istore_2
    //   9: aload_0
    //   10: invokespecial 245	com/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader:c	()Z
    //   13: istore_3
    //   14: new 52	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   21: astore 4
    //   23: aload 4
    //   25: ldc 247
    //   27: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 4
    //   33: iload_2
    //   34: invokevirtual 193	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 4
    //   40: ldc 249
    //   42: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 4
    //   48: iload_3
    //   49: invokevirtual 193	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 4
    //   55: ldc 251
    //   57: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 4
    //   63: getstatic 34	com/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader:d	Z
    //   66: invokevirtual 193	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 4
    //   72: ldc 253
    //   74: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 4
    //   80: invokestatic 258	android/os/Process:myPid	()I
    //   83: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: ldc 119
    //   89: iconst_1
    //   90: aload 4
    //   92: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: iload_2
    //   99: ifne +34 -> 133
    //   102: iload_3
    //   103: ifeq +30 -> 133
    //   106: ldc 119
    //   108: iconst_1
    //   109: ldc_w 260
    //   112: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: iconst_0
    //   116: putstatic 32	com/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader:c	Z
    //   119: new 262	com/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader$1
    //   122: dup
    //   123: aload_0
    //   124: invokespecial 265	com/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader$1:<init>	(Lcom/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader;)V
    //   127: invokestatic 271	com/tencent/biz/richframework/delegate/impl/RFThreadManager:execute	(Ljava/lang/Runnable;)V
    //   130: aload_0
    //   131: monitorexit
    //   132: return
    //   133: getstatic 34	com/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader:d	Z
    //   136: istore_2
    //   137: iload_2
    //   138: ifeq +6 -> 144
    //   141: aload_0
    //   142: monitorexit
    //   143: return
    //   144: ldc 119
    //   146: iconst_1
    //   147: ldc_w 273
    //   150: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: iconst_1
    //   154: putstatic 34	com/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader:d	Z
    //   157: iconst_0
    //   158: putstatic 32	com/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader:c	Z
    //   161: aload_0
    //   162: iconst_0
    //   163: invokespecial 42	com/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader:c	(Z)V
    //   166: invokestatic 238	com/tencent/biz/qcircleshadow/lib/QCircleHostConstants$QzoneModuleConst:QZONE_MODULE_UPLOAD_SO	()Ljava/lang/String;
    //   169: invokestatic 276	com/tencent/biz/qcircleshadow/lib/QCircleHostSoDownloadHelper:getRecordUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   172: astore 4
    //   174: invokestatic 238	com/tencent/biz/qcircleshadow/lib/QCircleHostConstants$QzoneModuleConst:QZONE_MODULE_UPLOAD_SO	()Ljava/lang/String;
    //   177: invokestatic 279	com/tencent/biz/qcircleshadow/lib/QCircleHostSoDownloadHelper:getModuleFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   180: astore 5
    //   182: aload 4
    //   184: ifnonnull +14 -> 198
    //   187: iconst_0
    //   188: putstatic 34	com/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader:d	Z
    //   191: iconst_0
    //   192: putstatic 32	com/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader:c	Z
    //   195: aload_0
    //   196: monitorexit
    //   197: return
    //   198: aload_0
    //   199: invokespecial 281	com/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader:d	()I
    //   202: istore_1
    //   203: iload_1
    //   204: getstatic 283	com/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader:a	I
    //   207: iconst_2
    //   208: idiv
    //   209: if_icmple +27 -> 236
    //   212: iload_1
    //   213: getstatic 283	com/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader:a	I
    //   216: if_icmpge +20 -> 236
    //   219: new 59	java/io/File
    //   222: dup
    //   223: aload 5
    //   225: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   228: astore 5
    //   230: aload 5
    //   232: invokevirtual 286	java/io/File:delete	()Z
    //   235: pop
    //   236: iload_1
    //   237: getstatic 283	com/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader:a	I
    //   240: if_icmple +49 -> 289
    //   243: new 52	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   250: astore 4
    //   252: aload 4
    //   254: ldc_w 288
    //   257: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload 4
    //   263: aload_0
    //   264: invokespecial 281	com/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader:d	()I
    //   267: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: ldc 119
    //   273: iconst_1
    //   274: aload 4
    //   276: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: iconst_0
    //   283: putstatic 34	com/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader:d	Z
    //   286: aload_0
    //   287: monitorexit
    //   288: return
    //   289: aload_0
    //   290: aload 4
    //   292: invokespecial 290	com/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader:d	(Ljava/lang/String;)V
    //   295: invokestatic 238	com/tencent/biz/qcircleshadow/lib/QCircleHostConstants$QzoneModuleConst:QZONE_MODULE_UPLOAD_SO	()Ljava/lang/String;
    //   298: new 292	com/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader$2
    //   301: dup
    //   302: aload_0
    //   303: invokespecial 293	com/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader$2:<init>	(Lcom/tencent/biz/qqcircle/publish/uploader/QcircleUploadSoDownloader;)V
    //   306: invokestatic 297	com/tencent/biz/qcircleshadow/lib/QCircleHostSoDownloadHelper:downloadModule	(Ljava/lang/String;Lcom/tencent/mobileqq/qcircle/tempapi/api/IQCirclrModuleDownloadListener;)V
    //   309: aload_0
    //   310: monitorexit
    //   311: return
    //   312: astore 4
    //   314: aload_0
    //   315: monitorexit
    //   316: aload 4
    //   318: athrow
    //   319: astore 5
    //   321: goto -85 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	this	QcircleUploadSoDownloader
    //   202	39	1	i	int
    //   8	130	2	bool1	boolean
    //   13	90	3	bool2	boolean
    //   21	270	4	localObject1	Object
    //   312	5	4	localObject2	Object
    //   180	51	5	localObject3	Object
    //   319	1	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	98	312	finally
    //   106	130	312	finally
    //   133	137	312	finally
    //   144	182	312	finally
    //   187	195	312	finally
    //   198	230	312	finally
    //   230	236	312	finally
    //   236	286	312	finally
    //   289	309	312	finally
    //   230	236	319	java/lang/Exception
  }
  
  public boolean a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (!QCircleHostConstants._AppSetting.isDebugVersion()) {
          break label400;
        }
        i = 1;
        i = QcircleAlphaConfig.a().a("QzoneUploadSetting", "UploadEnableDownloadSo", i);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("upload so enableLoadSo ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" useDownloadedSo ");
        ((StringBuilder)localObject).append(c);
        QLog.d("[upload2]QcircleUploadSoDownloader", 1, ((StringBuilder)localObject).toString());
        if (i != 1) {
          c = false;
        }
        bool = c();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("upload so getSoDownloadState ");
        ((StringBuilder)localObject).append(bool);
        QLog.d("[upload2]QcircleUploadSoDownloader", 1, ((StringBuilder)localObject).toString());
        if (!bool) {
          c = false;
        }
        if (c)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(b.getAbsolutePath());
          ((StringBuilder)localObject).append(File.separator);
          ((StringBuilder)localObject).append("lib");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(".so");
          localObject = new File(((StringBuilder)localObject).toString());
          bool = ((File)localObject).exists();
          if (bool) {
            try
            {
              System.load(((File)localObject).getAbsolutePath());
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("upload so load downloaded so ");
              ((StringBuilder)localObject).append(paramString);
              QLog.d("[upload2]QcircleUploadSoDownloader", 1, ((StringBuilder)localObject).toString());
              return true;
            }
            catch (Throwable paramString)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("load downloaded so fail:");
              ((StringBuilder)localObject).append(paramString.getMessage());
              QLog.d("[upload2]QcircleUploadSoDownloader", 1, ((StringBuilder)localObject).toString());
              c = false;
              c(false);
            }
          }
        }
      }
      finally {}
      try
      {
        b.delete();
      }
      catch (Exception paramString)
      {
        continue;
      }
      c = false;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloaded upload so not exists:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("[upload2]QcircleUploadSoDownloader", 1, ((StringBuilder)localObject).toString());
      c(false);
      b.delete();
      boolean bool = c;
      return bool;
      label400:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.uploader.QcircleUploadSoDownloader
 * JD-Core Version:    0.7.0.1
 */