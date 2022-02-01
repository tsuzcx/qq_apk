package com.tencent.av.so;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class ResDownloadControl
{
  private static volatile ResDownloadControl b;
  private ArrayList<ResDownloadControl.DownloadInfo> a = new ArrayList();
  
  ResDownloadControl()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ResDownloadControl for ");
    localStringBuilder.append(localBaseApplicationImpl.getQQProcessName());
    QLog.i("AVResMgr", 1, localStringBuilder.toString());
  }
  
  public static ResDownloadControl a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new ResDownloadControl();
        }
      }
      finally {}
    }
    return b;
  }
  
  private static void b()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("ACTION_QAV_RES_NEW_CONFIG_NOTIFY");
    localIntent.setPackage(localBaseApplicationImpl.getPackageName());
    localBaseApplicationImpl.sendBroadcast(localIntent);
  }
  
  private static void b(int paramInt1, int paramInt2, ResInfo paramResInfo)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("ACTION_QAV_RES_DOWNLOAD_STATE_NOTIFY");
    localIntent.setPackage(localBaseApplicationImpl.getPackageName());
    localIntent.putExtra("ACTION_FIELD_DOWNLOAD_STATE", paramInt1);
    localIntent.putExtra("ACTION_FIELD_DOWNLOAD_PROGRESS", paramInt2);
    localIntent.putExtra("ACTION_FIELD_RES_MD5", paramResInfo.resMd5);
    localBaseApplicationImpl.sendBroadcast(localIntent);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, ConfigInfo paramConfigInfo)
  {
    if (paramString == null) {
      return;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("handleNewConfig. newConfig = ");
    paramQQAppInterface.append(paramString);
    QLog.i("AVResMgr", 1, paramQQAppInterface.toString());
    ResMgr.e(paramString);
    paramQQAppInterface = ResMgr.b();
    if (paramQQAppInterface == null) {
      return;
    }
    b();
    paramString = ResMgr.a().f("AVVoiceRecogSo");
    paramConfigInfo = ResMgr.a().f("AVVoiceRecogModel");
    ResInfo localResInfo1 = ResMgr.a().f("AVGameVoiceRecogSo");
    ResInfo localResInfo2 = ResMgr.a().f("AVGameVoiceRecogModel");
    ResInfo localResInfo3 = ResMgr.a().f("AVGameVoiceRecogAILabSo");
    ResInfo localResInfo4 = ResMgr.a().f("AVGameVoiceRecogAILabModel");
    ResInfo localResInfo5 = ResMgr.a().f("AVTraeSo");
    ResInfo localResInfo6 = ResMgr.a().f("AVAINSMediaLabGruModel");
    ResInfo localResInfo7 = ResMgr.a().f("AVSDKSo");
    int i = 0;
    while (i < paramQQAppInterface.size())
    {
      ResInfo localResInfo8 = (ResInfo)paramQQAppInterface.get(i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleNewConfig. ");
      localStringBuilder.append(localResInfo8);
      QLog.i("AVResMgr", 1, localStringBuilder.toString());
      if ((paramString != null) && (paramString.resId.equalsIgnoreCase(localResInfo8.resId))) {
        ResMgr.b(ResMgr.b(localResInfo8), ResMgr.a(paramString));
      } else if ((paramConfigInfo != null) && (paramConfigInfo.resId.equalsIgnoreCase(localResInfo8.resId))) {
        ResMgr.b(ResMgr.b(localResInfo8), ResMgr.a(paramConfigInfo));
      } else if ((localResInfo1 != null) && (localResInfo1.resId.equalsIgnoreCase(localResInfo8.resId))) {
        ResMgr.b(ResMgr.b(localResInfo8), ResMgr.a(localResInfo1));
      } else if ((localResInfo2 != null) && (localResInfo2.resId.equalsIgnoreCase(localResInfo8.resId))) {
        ResMgr.b(ResMgr.b(localResInfo8), ResMgr.a(localResInfo2));
      } else if ((localResInfo3 != null) && (localResInfo3.resId.equalsIgnoreCase(localResInfo8.resId))) {
        ResMgr.b(ResMgr.b(localResInfo8), ResMgr.a(localResInfo3));
      } else if ((localResInfo4 != null) && (localResInfo4.resId.equalsIgnoreCase(localResInfo8.resId))) {
        ResMgr.b(ResMgr.b(localResInfo8), ResMgr.a(localResInfo4));
      } else if ((localResInfo5 != null) && (localResInfo5.resId.equalsIgnoreCase(localResInfo8.resId))) {
        ResMgr.b(ResMgr.b(localResInfo8), ResMgr.a(localResInfo5));
      } else if ((localResInfo6 != null) && (localResInfo6.resId.equalsIgnoreCase(localResInfo8.resId))) {
        ResMgr.b(ResMgr.b(localResInfo8), ResMgr.a(localResInfo6));
      } else if ((localResInfo7 != null) && (localResInfo7.resId.equalsIgnoreCase(localResInfo8.resId))) {
        ResMgr.b(ResMgr.b(localResInfo8), ResMgr.a(localResInfo7));
      }
      if (localResInfo8.isAutoDownload)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(ResMgr.a(localResInfo8));
        localStringBuilder.append(localResInfo8.resFileName);
        if (!ResMgr.a(localStringBuilder.toString(), localResInfo8.resMd5)) {
          a(localResInfo8);
        }
      }
      i += 1;
    }
  }
  
  boolean a(ResDownloadControl.DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo.d != null)
    {
      localObject1 = BaseApplicationImpl.sApplication.getRuntime();
      if ((localObject1 instanceof AppInterface))
      {
        localObject1 = (IHttpEngineService)((AppInterface)localObject1).getRuntimeService(IHttpEngineService.class, "all");
        if (localObject1 != null)
        {
          localObject2 = (String)paramDownloadInfo.d.getUserData();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("startDownload. cancel old download req. old res = ");
          localStringBuilder.append((String)localObject2);
          QLog.i("AVResMgr", 1, localStringBuilder.toString());
          ((IHttpEngineService)localObject1).cancelReq(paramDownloadInfo.d);
        }
      }
    }
    Object localObject1 = new HttpNetReq();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramDownloadInfo.a.resType);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(paramDownloadInfo.a.resId);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(paramDownloadInfo.a.resVersion);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(paramDownloadInfo.a.resZipMd5);
    ((HttpNetReq)localObject1).setUserData(((StringBuilder)localObject2).toString());
    ((HttpNetReq)localObject1).mReqUrl = paramDownloadInfo.a.resZipUrl;
    ((HttpNetReq)localObject1).mHttpMethod = 0;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(ResMgr.a(paramDownloadInfo.a));
    ((StringBuilder)localObject2).append(paramDownloadInfo.a.resZipMd5);
    ((StringBuilder)localObject2).append(".zip");
    ((HttpNetReq)localObject1).mOutPath = new File(((StringBuilder)localObject2).toString()).getPath();
    ((HttpNetReq)localObject1).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    ((HttpNetReq)localObject1).mCallback = new ResDownloadControl.1(this, paramDownloadInfo);
    localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject2 instanceof QQAppInterface))
    {
      localObject2 = (IHttpEngineService)((QQAppInterface)localObject2).getRuntimeService(IHttpEngineService.class, "all");
      if (localObject2 != null)
      {
        paramDownloadInfo.d = ((HttpNetReq)localObject1);
        ((IHttpEngineService)localObject2).sendReq((NetReq)localObject1);
        bool = true;
        break label362;
      }
    }
    boolean bool = false;
    label362:
    if (!bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startDownload. failed. NETWORK_ERROR. ");
      ((StringBuilder)localObject1).append(paramDownloadInfo.a);
      QLog.e("AVResMgr", 1, ((StringBuilder)localObject1).toString());
      this.a.remove(paramDownloadInfo);
      b(-2, 0, paramDownloadInfo.a);
      return bool;
    }
    paramDownloadInfo.b = 2;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("startDownload. ");
    ((StringBuilder)localObject1).append(paramDownloadInfo.a);
    QLog.i("AVResMgr", 1, ((StringBuilder)localObject1).toString());
    return bool;
  }
  
  public boolean a(ResInfo paramResInfo)
  {
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    boolean bool = localObject instanceof QQAppInterface;
    int i = 0;
    if (bool)
    {
      if (((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_NET_ENGINE) == null)
      {
        QLog.e("AVResMgr", 1, "download failed. getNetEngine is null.");
        return false;
      }
      int j = 0;
      while (i < this.a.size())
      {
        if (((ResDownloadControl.DownloadInfo)this.a.get(i)).a.resId.equalsIgnoreCase(paramResInfo.resId))
        {
          if (((ResDownloadControl.DownloadInfo)this.a.get(i)).b == 2)
          {
            paramResInfo = new StringBuilder();
            paramResInfo.append("download repeatedly. ResId = ");
            paramResInfo.append(((ResDownloadControl.DownloadInfo)this.a.get(i)).a.resId);
            QLog.i("AVResMgr", 1, paramResInfo.toString());
            return true;
          }
          j = 1;
        }
        i += 1;
      }
      if (j == 0)
      {
        localObject = new ResDownloadControl.DownloadInfo();
        ((ResDownloadControl.DownloadInfo)localObject).a = paramResInfo;
        this.a.add(localObject);
        return a((ResDownloadControl.DownloadInfo)localObject);
      }
      return true;
    }
    QLog.e("AVResMgr", 1, "download failed. appRuntime is not QQAppInterface.");
    return false;
  }
  
  public boolean a(String paramString)
  {
    ArrayList localArrayList = ResMgr.b();
    if (localArrayList == null) {
      return false;
    }
    int i = 0;
    while (i < localArrayList.size())
    {
      if (((ResInfo)localArrayList.get(i)).resId.equalsIgnoreCase(paramString))
      {
        paramString = new StringBuilder();
        paramString.append("downloadByResId. ");
        paramString.append(localArrayList.get(i));
        QLog.i("AVResMgr", 1, paramString.toString());
        return a((ResInfo)localArrayList.get(i));
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.so.ResDownloadControl
 * JD-Core Version:    0.7.0.1
 */