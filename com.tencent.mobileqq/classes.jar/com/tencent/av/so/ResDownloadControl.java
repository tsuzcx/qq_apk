package com.tencent.av.so;

import android.content.Intent;
import android.text.TextUtils;
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
  private static volatile ResDownloadControl jdField_a_of_type_ComTencentAvSoResDownloadControl;
  private ArrayList<ResDownloadControl.DownloadInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  ResDownloadControl()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    QLog.i("AVResMgr", 1, "ResDownloadControl for " + localBaseApplicationImpl.getQQProcessName());
  }
  
  public static ResDownloadControl a()
  {
    if (jdField_a_of_type_ComTencentAvSoResDownloadControl == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvSoResDownloadControl == null) {
        jdField_a_of_type_ComTencentAvSoResDownloadControl = new ResDownloadControl();
      }
      return jdField_a_of_type_ComTencentAvSoResDownloadControl;
    }
    finally {}
  }
  
  private static void a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("ACTION_QAV_RES_NEW_CONFIG_NOTIFY");
    localIntent.setPackage(localBaseApplicationImpl.getPackageName());
    localBaseApplicationImpl.sendBroadcast(localIntent);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    String str = paramString2;
    if (paramString2.endsWith(File.separator)) {
      str = paramString2.substring(0, paramString2.length() - 1);
    }
    return b(paramString1, str);
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
  
  private boolean b(String paramString1, String paramString2)
  {
    int i = 0;
    QLog.i("AVResMgr", 1, "deleteDir. dir = " + paramString1 + ", excludeSubDirOrFile = " + paramString2);
    paramString1 = new File(paramString1).listFiles();
    if (paramString1 == null) {
      return false;
    }
    boolean bool = false;
    if (i < paramString1.length)
    {
      Object localObject = paramString1[i];
      if (!localObject.getAbsolutePath().equalsIgnoreCase(paramString2)) {
        if (localObject.isDirectory())
        {
          bool = b(localObject.getAbsolutePath(), paramString2);
          if (bool)
          {
            QLog.i("AVResMgr", 1, "deleteDir. do not delete excludeSubDirOrFile. curSubDirOrFile  = " + localObject.getAbsolutePath());
            bool = true;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        QLog.i("AVResMgr", 1, "deleteDir. delete dir or file = " + localObject.getAbsolutePath());
        localObject.delete();
        continue;
        QLog.i("AVResMgr", 1, "deleteDir. delete dir or file = " + localObject.getAbsolutePath());
        localObject.delete();
        continue;
        QLog.i("AVResMgr", 1, "deleteDir. do not delete excludeSubDirOrFile. curSubDirOrFile  = " + localObject.getAbsolutePath());
        bool = true;
      }
    }
    return bool;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, ConfigInfo paramConfigInfo)
  {
    paramQQAppInterface = ResMgr.a();
    if (paramQQAppInterface == null) {
      return;
    }
    a();
    paramString = ResMgr.a().a("AVVoiceRecogSo");
    paramConfigInfo = ResMgr.a().a("AVVoiceRecogModel");
    ResInfo localResInfo1 = ResMgr.a().a("AVGameVoiceRecogSo");
    ResInfo localResInfo2 = ResMgr.a().a("AVGameVoiceRecogModel");
    ResInfo localResInfo3 = ResMgr.a().a("AVGameVoiceRecogAILabSo");
    ResInfo localResInfo4 = ResMgr.a().a("AVGameVoiceRecogAILabModel");
    ResInfo localResInfo5 = ResMgr.a().a("AVAINSMediaLabModel");
    int i = 0;
    label83:
    ResInfo localResInfo6;
    if (i < paramQQAppInterface.size())
    {
      localResInfo6 = (ResInfo)paramQQAppInterface.get(i);
      QLog.i("AVResMgr", 1, "handleNewConfig. " + localResInfo6);
      if ((paramString == null) || (!paramString.resId.equalsIgnoreCase(localResInfo6.resId))) {
        break label223;
      }
      a(ResMgr.b(localResInfo6), ResMgr.a(paramString));
    }
    for (;;)
    {
      if ((localResInfo6.isAutoDownload) && (!ResMgr.a(ResMgr.a(localResInfo6) + localResInfo6.resFileName, localResInfo6.resMd5))) {
        a(localResInfo6);
      }
      i += 1;
      break label83;
      break;
      label223:
      if ((paramConfigInfo != null) && (paramConfigInfo.resId.equalsIgnoreCase(localResInfo6.resId))) {
        a(ResMgr.b(localResInfo6), ResMgr.a(paramConfigInfo));
      } else if ((localResInfo1 != null) && (localResInfo1.resId.equalsIgnoreCase(localResInfo6.resId))) {
        a(ResMgr.b(localResInfo6), ResMgr.a(localResInfo1));
      } else if ((localResInfo2 != null) && (localResInfo2.resId.equalsIgnoreCase(localResInfo6.resId))) {
        a(ResMgr.b(localResInfo6), ResMgr.a(localResInfo2));
      } else if ((localResInfo3 != null) && (localResInfo3.resId.equalsIgnoreCase(localResInfo6.resId))) {
        a(ResMgr.b(localResInfo6), ResMgr.a(localResInfo3));
      } else if ((localResInfo4 != null) && (localResInfo4.resId.equalsIgnoreCase(localResInfo6.resId))) {
        a(ResMgr.b(localResInfo6), ResMgr.a(localResInfo4));
      } else if ((localResInfo5 != null) && (localResInfo5.resId.equalsIgnoreCase(localResInfo6.resId))) {
        a(ResMgr.b(localResInfo6), ResMgr.a(localResInfo5));
      }
    }
  }
  
  boolean a(ResDownloadControl.DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq != null)
    {
      localObject1 = BaseApplicationImpl.sApplication.getRuntime();
      if ((localObject1 instanceof AppInterface))
      {
        localObject1 = (IHttpEngineService)((AppInterface)localObject1).getRuntimeService(IHttpEngineService.class, "all");
        if (localObject1 != null)
        {
          localObject2 = (String)paramDownloadInfo.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.getUserData();
          QLog.i("AVResMgr", 1, "startDownload. cancel old download req. old res = " + (String)localObject2);
          ((IHttpEngineService)localObject1).cancelReq(paramDownloadInfo.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
        }
      }
    }
    Object localObject1 = new HttpNetReq();
    ((HttpNetReq)localObject1).setUserData(paramDownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo.resType + "_" + paramDownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo.resId + "_" + paramDownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo.resVersion + "_" + paramDownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo.resZipMd5);
    ((HttpNetReq)localObject1).mReqUrl = paramDownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo.resZipUrl;
    ((HttpNetReq)localObject1).mHttpMethod = 0;
    ((HttpNetReq)localObject1).mOutPath = new File(ResMgr.a(paramDownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo) + paramDownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo.resZipMd5 + ".zip").getPath();
    ((HttpNetReq)localObject1).mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
    ((HttpNetReq)localObject1).mCallback = new ResDownloadControl.1(this, paramDownloadInfo);
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject2 instanceof QQAppInterface))
    {
      localObject2 = (IHttpEngineService)((QQAppInterface)localObject2).getRuntimeService(IHttpEngineService.class, "all");
      if (localObject2 != null)
      {
        paramDownloadInfo.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = ((HttpNetReq)localObject1);
        ((IHttpEngineService)localObject2).sendReq((NetReq)localObject1);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (!bool)
      {
        QLog.e("AVResMgr", 1, "startDownload. failed. NETWORK_ERROR. " + paramDownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo);
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramDownloadInfo);
        b(-2, 0, paramDownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo);
        return bool;
      }
      paramDownloadInfo.jdField_a_of_type_Int = 2;
      QLog.i("AVResMgr", 1, "startDownload. " + paramDownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo);
      return bool;
    }
  }
  
  public boolean a(ResInfo paramResInfo)
  {
    int i = 0;
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      if (((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_NET_ENGINE) == null)
      {
        QLog.e("AVResMgr", 1, "download failed. getNetEngine is null.");
        return false;
      }
    }
    else
    {
      QLog.e("AVResMgr", 1, "download failed. appRuntime is not QQAppInterface.");
      return false;
    }
    int j = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((ResDownloadControl.DownloadInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentAvSoResInfo.resId.equalsIgnoreCase(paramResInfo.resId))
      {
        if (((ResDownloadControl.DownloadInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int == 2)
        {
          QLog.i("AVResMgr", 1, "download repeatedly. ResId = " + ((ResDownloadControl.DownloadInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentAvSoResInfo.resId);
          return true;
        }
        j = 1;
      }
      i += 1;
    }
    if (j == 0)
    {
      localObject = new ResDownloadControl.DownloadInfo();
      ((ResDownloadControl.DownloadInfo)localObject).jdField_a_of_type_ComTencentAvSoResInfo = paramResInfo;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      return a((ResDownloadControl.DownloadInfo)localObject);
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    ArrayList localArrayList = ResMgr.a();
    if (localArrayList == null) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < localArrayList.size())
      {
        if (((ResInfo)localArrayList.get(i)).resId.equalsIgnoreCase(paramString))
        {
          QLog.i("AVResMgr", 1, "downloadByResId. " + localArrayList.get(i));
          return a((ResInfo)localArrayList.get(i));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.so.ResDownloadControl
 * JD-Core Version:    0.7.0.1
 */