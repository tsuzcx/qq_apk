package com.tencent.aelight.camera.ae.download;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AEMaterialDownloader
{
  private static final String a = "AEMaterialDownloader";
  
  public static void a(AppInterface paramAppInterface, AEMaterialMetaData paramAEMaterialMetaData, String paramString, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener)
  {
    if (paramAEMaterialMetaData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "startDownloadMaterial is null");
      }
      return;
    }
    b(paramAppInterface, paramAEMaterialMetaData, paramString, paramMaterialDownloadListener);
  }
  
  private static void b(AppInterface paramAppInterface, AEMaterialMetaData paramAEMaterialMetaData, String paramString, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener)
  {
    if (paramAEMaterialMetaData != null)
    {
      if (paramAppInterface == null) {
        return;
      }
      paramAEMaterialMetaData.a = System.currentTimeMillis();
      paramAEMaterialMetaData.f = true;
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = new AEMaterialDownloader.DownloadListener(paramAEMaterialMetaData, paramString, paramMaterialDownloadListener);
      localHttpNetReq.mReqUrl = paramAEMaterialMetaData.n;
      localHttpNetReq.mHttpMethod = 0;
      if (paramAEMaterialMetaData.p == null)
      {
        paramAppInterface = a;
        paramString = new StringBuilder();
        paramString.append("startDownloadMaterial fail, info.name is null, url:");
        paramString.append(paramAEMaterialMetaData.n);
        QLog.i(paramAppInterface, 1, paramString.toString());
        return;
      }
      localHttpNetReq.mOutPath = new File(paramString, paramAEMaterialMetaData.p).getPath();
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
      localHttpNetReq.mExcuteTimeLimit = 60000L;
      try
      {
        ((IHttpEngineService)paramAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          paramAppInterface.printStackTrace();
        }
      }
      localHttpNetReq.mCallback.onUpdateProgeress(localHttpNetReq, 1L, 100L);
      if (QLog.isColorLevel())
      {
        paramAppInterface = a;
        paramString = new StringBuilder();
        paramString.append("startDownloadMaterial url: ");
        paramString.append(paramAEMaterialMetaData.n);
        QLog.i(paramAppInterface, 2, paramString.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.AEMaterialDownloader
 * JD-Core Version:    0.7.0.1
 */