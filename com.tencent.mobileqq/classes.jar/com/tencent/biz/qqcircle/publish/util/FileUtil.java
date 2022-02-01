package com.tencent.biz.qqcircle.publish.util;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import com.tencent.biz.qcircleshadow.lib.variation.HostFileUtils;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class FileUtil
{
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      return false;
    }
    try
    {
      paramString1 = new File(paramString1);
      if (!paramString1.exists())
      {
        QLog.e("[QcirclePublish]FileUtil", 1, "srcFile not exists, SaveFileToQqAlbum failed.");
        return false;
      }
      Object localObject = new File(paramString2);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      if (((File)localObject).exists())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append(paramString3);
        paramString2 = new File(((StringBuilder)localObject).toString());
        HostFileUtils.copyFile(paramString1, paramString2);
        paramString1 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(paramString2));
        QCircleApplication.APP.sendBroadcast(paramString1);
        return true;
      }
      QLog.e("[QcirclePublish]FileUtil", 1, "mkdirs failed, SaveFileToQqAlbum failed.");
      return true;
    }
    catch (Throwable paramString1)
    {
      QLog.e("[QcirclePublish]FileUtil", 1, "saveFileToQqAlbum failed:", paramString1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.util.FileUtil
 * JD-Core Version:    0.7.0.1
 */