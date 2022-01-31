package com.tencent.mobileqq.armap;

import com.tencent.mobileqq.armap.utils.ARResUtil;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ResDownloadHandler$DefaultRDHandler
  implements ResDownloadHandler.RDHandler
{
  public final String a = ResDownloadHandler.a + "." + getClass().getSimpleName();
  
  public static final String a(String paramString1, String paramString2)
  {
    return ARResUtil.a() + File.separator + "_res/" + paramString1;
  }
  
  public String a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    return ARResUtil.a() + File.separator + "_res/" + paramDownloadParam.b + File.separator;
  }
  
  public boolean a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    String str = b(paramDownloadParam);
    try
    {
      boolean bool = new File(str).exists();
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "needDownload.file exist|" + bool + "|" + paramDownloadParam + "|" + str);
      }
      if (!bool) {
        return true;
      }
    }
    catch (Throwable paramDownloadParam)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 2, "isNeedDownload.exception happen.e=" + paramDownloadParam.getMessage());
      }
      paramDownloadParam.printStackTrace();
    }
    return false;
  }
  
  public boolean a(ResDownloadManager.DownloadParam paramDownloadParam, boolean paramBoolean)
  {
    return true;
  }
  
  public String b(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    return a(paramDownloadParam.b, paramDownloadParam.c);
  }
  
  public boolean b(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    boolean bool = true;
    String str = PortalUtils.a(b(paramDownloadParam));
    if (!paramDownloadParam.b.equalsIgnoreCase(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 1, "checkDownloadFile.verify failed|" + str + "|" + paramDownloadParam);
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ResDownloadHandler.DefaultRDHandler
 * JD-Core Version:    0.7.0.1
 */