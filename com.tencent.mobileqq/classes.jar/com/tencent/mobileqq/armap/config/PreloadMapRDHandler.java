package com.tencent.mobileqq.armap.config;

import com.tencent.mobileqq.armap.ResDownloadHandler.RDHandler;
import com.tencent.mobileqq.armap.ResDownloadManager.DownloadParam;
import com.tencent.mobileqq.armap.utils.ARResUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PreloadMapRDHandler
  implements ResDownloadHandler.RDHandler
{
  public String a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    return "";
  }
  
  public boolean a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    return !c(paramDownloadParam);
  }
  
  public boolean a(ResDownloadManager.DownloadParam paramDownloadParam, boolean paramBoolean)
  {
    return true;
  }
  
  public String b(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    if ((paramDownloadParam != null) && ((paramDownloadParam.jdField_a_of_type_JavaLangObject instanceof PreloadMapRDHandler.UserData))) {
      return ARResUtil.a(((PreloadMapRDHandler.UserData)paramDownloadParam.jdField_a_of_type_JavaLangObject).a);
    }
    return "";
  }
  
  public boolean b(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    return true;
  }
  
  public boolean c(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    if (paramDownloadParam.jdField_a_of_type_Boolean) {}
    for (paramDownloadParam = a(paramDownloadParam);; paramDownloadParam = b(paramDownloadParam))
    {
      boolean bool = new File(paramDownloadParam).exists();
      if (QLog.isColorLevel()) {
        QLog.d("PreloadMapRDHandler", 2, "PreloadMapRDHandler needDownload.file exist|" + bool + "|" + paramDownloadParam);
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.config.PreloadMapRDHandler
 * JD-Core Version:    0.7.0.1
 */