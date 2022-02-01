package com.tencent.aelight.camera.ae.download;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AEResDownload
{
  private static Map<String, ShortVideoResourceManager.SVConfigItem> a = new ConcurrentHashMap();
  
  public static void a(@NonNull AEResInfo paramAEResInfo, @NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    ThreadManager.excute(new AEResDownload.1(paramAEResInfo, paramList, paramINet_ShortVideoResource), 128, null, false);
  }
  
  private static void c(@NonNull AEResInfo paramAEResInfo, @NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    if (Build.VERSION.SDK_INT >= 15)
    {
      AEQLog.b("AEResDownload", "support isNeon");
      int i = 0;
      while (i < paramList.size())
      {
        localObject = (ShortVideoResourceManager.SVConfigItem)paramList.get(i);
        if ((((ShortVideoResourceManager.SVConfigItem)localObject).name.startsWith(paramAEResInfo.resPrefix)) && (((ShortVideoResourceManager.SVConfigItem)localObject).versionCode == paramAEResInfo.resVersion))
        {
          paramList = (List<ShortVideoResourceManager.SVConfigItem>)localObject;
          break label81;
        }
        i += 1;
      }
      paramList = null;
      label81:
      if (paramList == null)
      {
        AEQLog.d("AEResDownload", "[realDownloadResource EROOR]");
        paramINet_ShortVideoResource.onDownloadFinish("", -101, null);
        return;
      }
      int j = AEResUtil.a(paramAEResInfo.index);
      int k = Integer.valueOf(paramList.name.substring(paramAEResInfo.resPrefix.length())).intValue();
      i = 1;
      if (j >= k) {
        if (TextUtils.isEmpty(AEResUtil.a(paramAEResInfo)))
        {
          AEQLog.d("AEResDownload", "[realDownloadResourceInternal] local exist but finalPath is null");
        }
        else
        {
          if ((!TextUtils.isEmpty(AEResUtil.b(paramAEResInfo))) && (AEResUtil.d(paramAEResInfo)))
          {
            AEQLog.d("AEResDownload", "[realDownloadResource info] local exist");
            paramList = paramList.name;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramAEResInfo.resPrefix);
            ((StringBuilder)localObject).append(j);
            paramINet_ShortVideoResource.onDownloadFinish(paramList, 1, AEResUtil.a(((StringBuilder)localObject).toString()));
            return;
          }
          AEQLog.d("AEResDownload", "[realDownloadResourceInternal] local exist but unzipPath is null");
        }
      }
      Object localObject = new HttpNetReq();
      ((HttpNetReq)localObject).mCallback = new AEResDownload.2(paramINet_ShortVideoResource, paramAEResInfo);
      if ((VideoEnvironment64BitUtils.checkIs64bit()) && (paramList.check64BitReady())) {
        ((HttpNetReq)localObject).mReqUrl = paramList.arm64v8a_url;
      } else {
        ((HttpNetReq)localObject).mReqUrl = paramList.armv7a_url;
      }
      ((HttpNetReq)localObject).mHttpMethod = 0;
      paramAEResInfo = new StringBuilder();
      paramAEResInfo.append(AEResUtil.d());
      paramAEResInfo.append(paramList.name);
      ((HttpNetReq)localObject).mOutPath = paramAEResInfo.toString();
      ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
      ((HttpNetReq)localObject).bAcceptNegativeContentLength = true;
      ((HttpNetReq)localObject).setUserData(paramList.name);
      paramAEResInfo = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if ((paramAEResInfo != null) && (paramAEResInfo.isLogin()) && (paramAEResInfo.getManager(QQManagerFactory.MGR_NET_ENGINE) != null))
      {
        paramAEResInfo = (IHttpEngineService)paramAEResInfo.getRuntimeService(IHttpEngineService.class, "all");
        if (paramAEResInfo != null)
        {
          paramAEResInfo.sendReq((NetReq)localObject);
          i = 0;
        }
      }
      if (i != 0)
      {
        AEQLog.d("AEResDownload", "[realDownloadResourceInternal] need new DownLoadEngine");
        paramAEResInfo = new HttpCommunicator(4);
        paramAEResInfo.start();
        new HttpEngineServiceImpl(paramAEResInfo, false).sendReq((NetReq)localObject);
      }
      a.put(paramList.name, paramList);
      return;
    }
    AEQLog.d("AEResDownload", "Neon is not Support");
    paramINet_ShortVideoResource.onDownloadFinish("", -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.AEResDownload
 * JD-Core Version:    0.7.0.1
 */