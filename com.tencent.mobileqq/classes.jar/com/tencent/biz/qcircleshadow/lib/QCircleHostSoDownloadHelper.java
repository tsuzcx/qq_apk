package com.tencent.biz.qcircleshadow.lib;

import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQCirclrModuleDownloadListener;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneService;

public class QCircleHostSoDownloadHelper
{
  public static boolean checkIfNeedUpdate(String paramString)
  {
    return QCircleServiceImpl.getQZoneService().checkIfNeedUpdate(paramString);
  }
  
  public static void downloadModule(String paramString, IQCirclrModuleDownloadListener paramIQCirclrModuleDownloadListener)
  {
    QCircleServiceImpl.getQZoneService().downloadModule(paramString, paramIQCirclrModuleDownloadListener);
  }
  
  public static String getModuleFilePath(String paramString)
  {
    return QCircleServiceImpl.getQZoneService().getModuleFilePath(paramString);
  }
  
  public static String getRecordUrl(String paramString)
  {
    return QCircleServiceImpl.getQZoneService().getRecordUrl(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostSoDownloadHelper
 * JD-Core Version:    0.7.0.1
 */