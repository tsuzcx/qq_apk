package com.tencent.mobileqq.armap;

import com.tencent.mobileqq.armap.utils.ARResUtil;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ResDownloadHandler$DefaultRDHandler
  implements ResDownloadHandler.RDHandler
{
  public final String a;
  
  public ResDownloadHandler$DefaultRDHandler()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ResDownloadHandler.a);
    localStringBuilder.append(".");
    localStringBuilder.append(getClass().getSimpleName());
    this.a = localStringBuilder.toString();
  }
  
  public static final String a(String paramString1, String paramString2)
  {
    paramString2 = new StringBuilder();
    paramString2.append(ARResUtil.a());
    paramString2.append(File.separator);
    paramString2.append("_res/");
    paramString2.append(paramString1);
    return paramString2.toString();
  }
  
  public boolean a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    String str = c(paramDownloadParam);
    try
    {
      boolean bool = new File(str).exists();
      if (QLog.isColorLevel())
      {
        localObject = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("needDownload.file exist|");
        localStringBuilder.append(bool);
        localStringBuilder.append("|");
        localStringBuilder.append(paramDownloadParam);
        localStringBuilder.append("|");
        localStringBuilder.append(str);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if (!bool) {
        return true;
      }
    }
    catch (Throwable paramDownloadParam)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        str = this.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isNeedDownload.exception happen.e=");
        ((StringBuilder)localObject).append(paramDownloadParam.getMessage());
        QLog.i(str, 2, ((StringBuilder)localObject).toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ARResUtil.a());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("_res/");
    localStringBuilder.append(paramDownloadParam.c);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public String c(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    return a(paramDownloadParam.c, paramDownloadParam.d);
  }
  
  public boolean d(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    String str1 = PortalUtils.a(c(paramDownloadParam));
    if (!paramDownloadParam.c.equalsIgnoreCase(str1))
    {
      if (QLog.isColorLevel())
      {
        String str2 = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkDownloadFile.verify failed|");
        localStringBuilder.append(str1);
        localStringBuilder.append("|");
        localStringBuilder.append(paramDownloadParam);
        QLog.i(str2, 1, localStringBuilder.toString());
      }
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ResDownloadHandler.DefaultRDHandler
 * JD-Core Version:    0.7.0.1
 */