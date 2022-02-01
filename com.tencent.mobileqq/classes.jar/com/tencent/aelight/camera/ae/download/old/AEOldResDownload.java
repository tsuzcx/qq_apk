package com.tencent.aelight.camera.ae.download.old;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.download.old.api.AEOldResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.INet_ShortVideoResource;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.SVConfigItem;
import java.util.List;
import java.util.List<Ldov.com.qq.im.ae.download.old.AEOldShortVideoResManager.SVConfigItem;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AEOldResDownload
{
  private static Map<String, AEOldShortVideoResManager.SVConfigItem> a = new ConcurrentHashMap();
  
  public static void a(@NonNull AEOldResInfo paramAEOldResInfo, @NonNull List<AEOldShortVideoResManager.SVConfigItem> paramList, @NonNull AEOldShortVideoResManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    ThreadManager.excute(new AEOldResDownload.1(paramAEOldResInfo, paramList, paramINet_ShortVideoResource), 128, null, false);
  }
  
  private static void c(@NonNull AEOldResInfo paramAEOldResInfo, @NonNull List<AEOldShortVideoResManager.SVConfigItem> paramList, @NonNull AEOldShortVideoResManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    if (Build.VERSION.SDK_INT >= 15)
    {
      AEQLog.b("AEOldResDownload", "support isNeon");
      int i = 0;
      while (i < paramList.size())
      {
        localObject = (AEOldShortVideoResManager.SVConfigItem)paramList.get(i);
        if ((((AEOldShortVideoResManager.SVConfigItem)localObject).name.startsWith(paramAEOldResInfo.b)) && (((AEOldShortVideoResManager.SVConfigItem)localObject).versionCode == paramAEOldResInfo.c))
        {
          paramList = (List<AEOldShortVideoResManager.SVConfigItem>)localObject;
          break label81;
        }
        i += 1;
      }
      paramList = null;
      label81:
      if (paramList == null)
      {
        AEQLog.d("AEOldResDownload", "[realDownloadResource EROOR]");
        paramINet_ShortVideoResource.a("", -101, null);
        return;
      }
      int j = AEOldResUtil.a(paramAEOldResInfo.a);
      int k = Integer.valueOf(paramList.name.substring(paramAEOldResInfo.b.length())).intValue();
      i = 1;
      if (j >= k) {
        if (TextUtils.isEmpty(AEOldResUtil.a(paramAEOldResInfo)))
        {
          AEQLog.d("AEOldResDownload", "[realDownloadResourceInternal] local exist but finalPath is null");
        }
        else if (TextUtils.isEmpty(AEOldResUtil.c(paramAEOldResInfo)))
        {
          AEQLog.d("AEOldResDownload", "[realDownloadResourceInternal] local exist but unzipPath is null");
        }
        else
        {
          AEQLog.d("AEOldResDownload", "[realDownloadResource info] local exist");
          paramList = paramList.name;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramAEOldResInfo.b);
          ((StringBuilder)localObject).append(j);
          paramINet_ShortVideoResource.a(paramList, 1, AEOldResUtil.a(((StringBuilder)localObject).toString()));
          return;
        }
      }
      Object localObject = new HttpNetReq();
      ((HttpNetReq)localObject).mCallback = new AEOldResDownload.2(paramINet_ShortVideoResource, paramAEOldResInfo);
      if ((VideoEnvironment64BitUtils.checkIs64bit()) && (paramList.check64BitReady())) {
        ((HttpNetReq)localObject).mReqUrl = paramList.arm64v8a_url;
      } else {
        ((HttpNetReq)localObject).mReqUrl = paramList.armv7a_url;
      }
      ((HttpNetReq)localObject).mHttpMethod = 0;
      paramAEOldResInfo = new StringBuilder();
      paramAEOldResInfo.append(AEOldResUtil.c());
      paramAEOldResInfo.append(paramList.name);
      ((HttpNetReq)localObject).mOutPath = paramAEOldResInfo.toString();
      ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
      ((HttpNetReq)localObject).bAcceptNegativeContentLength = true;
      ((HttpNetReq)localObject).setUserData(paramList.name);
      paramAEOldResInfo = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if ((paramAEOldResInfo != null) && (paramAEOldResInfo.isLogin()) && (paramAEOldResInfo.getManager(QQManagerFactory.MGR_NET_ENGINE) != null))
      {
        paramAEOldResInfo = (IHttpEngineService)paramAEOldResInfo.getRuntimeService(IHttpEngineService.class, "all");
        if (paramAEOldResInfo != null)
        {
          paramAEOldResInfo.sendReq((NetReq)localObject);
          i = 0;
        }
      }
      if (i != 0)
      {
        AEQLog.d("AEOldResDownload", "[realDownloadResourceInternal] need new DownLoadEngine");
        paramAEOldResInfo = new HttpCommunicator(4);
        paramAEOldResInfo.start();
        new HttpEngineServiceImpl(paramAEOldResInfo, false).sendReq((NetReq)localObject);
      }
      a.put(paramList.name, paramList);
      return;
    }
    AEQLog.d("AEOldResDownload", "Neon is not Support");
    paramINet_ShortVideoResource.a("", -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.old.AEOldResDownload
 * JD-Core Version:    0.7.0.1
 */