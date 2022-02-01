package com.tencent.avgame.gamelogic.gameres;

import com.tencent.avgame.gamelogic.gameres.api.IResDownloadManager.DownloadParam;
import com.tencent.avgame.util.ResUtil;
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
  
  public static final String b(String paramString1, String paramString2)
  {
    paramString2 = new StringBuilder();
    paramString2.append(ResUtil.a());
    paramString2.append(File.separator);
    paramString2.append("_res/");
    paramString2.append(paramString1);
    return paramString2.toString();
  }
  
  public String a(IResDownloadManager.DownloadParam paramDownloadParam)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ResUtil.a());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("_res/");
    localStringBuilder.append(paramDownloadParam.b);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public boolean a(IResDownloadManager.DownloadParam paramDownloadParam)
  {
    String str1;
    if (paramDownloadParam.a) {
      str1 = a(paramDownloadParam);
    } else {
      str1 = b(paramDownloadParam);
    }
    boolean bool = new File(str1).exists();
    if (QLog.isColorLevel())
    {
      String str2 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isFileExists|");
      localStringBuilder.append(bool);
      localStringBuilder.append("|");
      localStringBuilder.append(str1);
      localStringBuilder.append("|");
      localStringBuilder.append(paramDownloadParam);
      QLog.i(str2, 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean a(IResDownloadManager.DownloadParam paramDownloadParam, boolean paramBoolean)
  {
    return true;
  }
  
  public String b(IResDownloadManager.DownloadParam paramDownloadParam)
  {
    return b(paramDownloadParam.b, paramDownloadParam.c);
  }
  
  public boolean b(IResDownloadManager.DownloadParam paramDownloadParam)
  {
    String str = b(paramDownloadParam);
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
  
  public boolean c(IResDownloadManager.DownloadParam paramDownloadParam)
  {
    String str1 = ResUtil.b(b(paramDownloadParam));
    if (!paramDownloadParam.b.equalsIgnoreCase(str1))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.ResDownloadHandler.DefaultRDHandler
 * JD-Core Version:    0.7.0.1
 */