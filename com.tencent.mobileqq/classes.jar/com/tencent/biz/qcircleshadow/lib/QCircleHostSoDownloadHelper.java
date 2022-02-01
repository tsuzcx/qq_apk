package com.tencent.biz.qcircleshadow.lib;

import com.tencent.mobileqq.qcircle.tempapi.api.IQCirclrModuleDownloadListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import cooperation.qzone.networkedmodule.QzoneModuleRecord;

public class QCircleHostSoDownloadHelper
{
  public static boolean checkIfNeedUpdate(String paramString)
  {
    return ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).checkIfNeedUpdate(paramString);
  }
  
  public static void downloadModule(String paramString, IQCirclrModuleDownloadListener paramIQCirclrModuleDownloadListener)
  {
    ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).downloadModule(paramString, new QCircleHostSoDownloadHelper.1(paramIQCirclrModuleDownloadListener));
  }
  
  public static String getModuleFilePath(String paramString)
  {
    return ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).getModuleFilePath(paramString);
  }
  
  public static String getRecordUrl(String paramString)
  {
    paramString = ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).getModuleRecord(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.mNewVersion.mUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostSoDownloadHelper
 * JD-Core Version:    0.7.0.1
 */