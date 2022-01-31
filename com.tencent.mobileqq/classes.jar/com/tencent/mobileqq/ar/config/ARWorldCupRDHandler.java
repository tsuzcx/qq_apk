package com.tencent.mobileqq.ar.config;

import aaqx;
import android.text.TextUtils;
import com.tencent.mobileqq.armap.ResDownloadHandler.DefaultRDHandler;
import com.tencent.mobileqq.armap.ResDownloadManager.DownloadParam;
import com.tencent.mobileqq.precover.PrecoverUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;

public class ARWorldCupRDHandler
  extends ResDownloadHandler.DefaultRDHandler
{
  public String a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    paramDownloadParam = (aaqx)paramDownloadParam.a;
    paramDownloadParam = WorldCupMgr.b(paramDownloadParam.a, paramDownloadParam.b);
    if (AudioHelper.e()) {
      QLog.w("WorldCupMgr", 1, "getUnzipDirPath, path[" + paramDownloadParam + "]");
    }
    return paramDownloadParam;
  }
  
  public boolean a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    aaqx localaaqx = (aaqx)paramDownloadParam.a;
    localaaqx.c = 0;
    boolean bool1 = super.a(paramDownloadParam);
    String str1 = "ARWorldCupRDHandler, needDownload[" + bool1 + "], zipItem[" + localaaqx;
    String str4;
    File localFile;
    boolean bool2;
    String str3;
    if (bool1)
    {
      str4 = PrecoverUtils.a("20180426_803_worldcup", localaaqx.b);
      localFile = new File(str4);
      bool2 = localFile.exists();
      str3 = str1 + "], prePath[" + str4 + "], exists[" + bool2;
      if (!bool2) {}
    }
    for (;;)
    {
      String str2;
      try
      {
        str1 = MD5FileUtil.a(localFile);
        str3 = str3 + "], preMd5[" + str1;
        if (TextUtils.equals(localaaqx.b, str1))
        {
          str1 = str3 + "], 匹配";
          bool2 = FileUtils.d(str4, b(paramDownloadParam));
          bool1 = super.a(paramDownloadParam);
          paramDownloadParam = str1 + ", copyFile[" + bool2 + "], reCheck[" + bool1 + "]";
          if (!bool1) {
            localaaqx.c = 1;
          }
          QLog.w("WorldCupMgr", 1, paramDownloadParam);
          return bool1;
        }
      }
      catch (Exception localException)
      {
        str2 = "Exception";
        continue;
        paramDownloadParam = str3 + "], 不匹配";
        continue;
      }
      paramDownloadParam = str3;
      continue;
      paramDownloadParam = str2;
    }
  }
  
  public boolean a(ResDownloadManager.DownloadParam paramDownloadParam, boolean paramBoolean)
  {
    return false;
  }
  
  public String b(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    paramDownloadParam = (aaqx)paramDownloadParam.a;
    paramDownloadParam = WorldCupMgr.a(paramDownloadParam.a, paramDownloadParam.b);
    if (AudioHelper.e()) {
      QLog.w("WorldCupMgr", 1, "getDownloadPath, path[" + paramDownloadParam + "]");
    }
    return paramDownloadParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.config.ARWorldCupRDHandler
 * JD-Core Version:    0.7.0.1
 */