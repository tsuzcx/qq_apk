package com.tencent.mobileqq.ar;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.arengine.ArResourceConfigUtils;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ArResourceDownload
  implements INetEngineListener
{
  private long jdField_a_of_type_Long = 0L;
  public AppInterface a;
  public ArResourceManager a;
  private IHttpEngineService jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService;
  ArrayList<ArResourceDownload.DownloadInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private boolean jdField_a_of_type_Boolean = false;
  private final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private long jdField_b_of_type_Long = 0L;
  private boolean jdField_b_of_type_Boolean = false;
  
  public ArResourceDownload(AppInterface paramAppInterface, ArResourceManager paramArResourceManager)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqArArResourceManager = paramArResourceManager;
  }
  
  private void a(ArResourceDownload.DownloadInfo paramDownloadInfo)
  {
    if ((TextUtils.isEmpty(paramDownloadInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramDownloadInfo.jdField_b_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArConfig_ArResourceDownload", 2, "downLoad:url=" + paramDownloadInfo.jdField_a_of_type_JavaLangString + ",md5= " + paramDownloadInfo.jdField_b_of_type_JavaLangString);
    }
    paramDownloadInfo.jdField_b_of_type_Int += 1;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = ((IHttpEngineService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IHttpEngineService.class, "all"));
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mReqUrl = paramDownloadInfo.jdField_a_of_type_JavaLangString;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = paramDownloadInfo.c;
    localHttpNetReq.mPrioty = 1;
    localHttpNetReq.setUserData(paramDownloadInfo);
    localHttpNetReq.mSupportBreakResume = true;
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.sendReq(localHttpNetReq);
    paramDownloadInfo.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
  }
  
  private void a(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    Object localObject1;
    File localFile;
    if (paramArCloudConfigInfo.jdField_d_of_type_Int == 100)
    {
      localObject1 = "";
      if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) {
        break label449;
      }
      localFile = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);
      localObject1 = ArConfigUtils.a() + "ar_model/" + paramArCloudConfigInfo.jdField_d_of_type_Int + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + "_model.zip";
    }
    for (;;)
    {
      if (localFile == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArResourceDownload", 2, "copyAndCheckBinHai3dRes return for null zipfile");
        }
        return;
      }
      Object localObject2 = new File((String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArResourceDownload", 2, "downloadArResource:binhai:oldFilePath=" + (String)localObject1 + ", exist=" + ((File)localObject2).exists());
      }
      if ((((File)localObject2).exists()) && (!localFile.exists()))
      {
        bool1 = localFile.mkdirs();
        boolean bool2 = FileUtils.a((File)localObject2, localFile);
        QLog.d("ArConfig_ArResourceDownload", 1, "downloadArResource:binhai:copy old to new dir, ret=" + bool2 + ", mkRet=" + bool1);
      }
      localObject2 = "";
      localObject1 = localObject2;
      if (localFile.exists()) {}
      try
      {
        String str = PortalUtils.a(localFile.getAbsolutePath());
        localObject2 = str;
        if (QLog.isColorLevel())
        {
          localObject2 = str;
          QLog.d("ArConfig_ArResourceDownload", 2, "download binhai calc md5=" + str + ", modelMd5=" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString);
        }
        localObject1 = str;
        localObject2 = str;
        if (!paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString.equalsIgnoreCase(str))
        {
          localObject2 = str;
          localFile.delete();
          localObject1 = str;
        }
      }
      catch (Throwable paramArCloudConfigInfo)
      {
        for (;;)
        {
          QLog.e("ArConfig_ArResourceDownload", 1, "download binhai check md5 error", paramArCloudConfigInfo);
          localObject1 = localObject2;
          continue;
          paramArCloudConfigInfo = "0";
        }
      }
      boolean bool1 = localFile.exists();
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("md5", localObject1);
      ((HashMap)localObject2).put("uin", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      if (bool1)
      {
        paramArCloudConfigInfo = "1";
        ((HashMap)localObject2).put("exist", paramArCloudConfigInfo);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "binhai_predownload", bool1, 0L, 0L, (HashMap)localObject2, "", true);
        return;
      }
      label449:
      localFile = null;
    }
  }
  
  private boolean a(ArConfigInfo paramArConfigInfo)
  {
    if (paramArConfigInfo == null) {
      return true;
    }
    try
    {
      if (!paramArConfigInfo.mArCloudConfigInfos.isEmpty())
      {
        paramArConfigInfo = paramArConfigInfo.mArCloudConfigInfos.iterator();
        while (paramArConfigInfo.hasNext())
        {
          ArCloudConfigInfo localArCloudConfigInfo = (ArCloudConfigInfo)paramArConfigInfo.next();
          if (!FileUtils.a(localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c)) {
            return false;
          }
          if (((localArCloudConfigInfo.jdField_d_of_type_Int == 0) || (localArCloudConfigInfo.jdField_d_of_type_Int == 100)) && (localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
          {
            boolean bool = new File(localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f).exists();
            if (!bool) {
              return false;
            }
          }
        }
      }
    }
    catch (Exception paramArConfigInfo)
    {
      QLog.i("ArConfig_ArResourceDownload", 1, "isResourceReady e=" + paramArConfigInfo.getMessage());
      return true;
    }
    return true;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          ArResourceDownload.DownloadInfo localDownloadInfo = (ArResourceDownload.DownloadInfo)localIterator.next();
          if (localDownloadInfo.jdField_b_of_type_Long < localDownloadInfo.jdField_a_of_type_Long) {
            this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.cancelReq(localDownloadInfo.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
  }
  
  public void a(ArConfigInfo paramArConfigInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      for (;;)
      {
        label98:
        Object localObject4;
        int j;
        int k;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.i("ArConfig_ArResourceDownload", 2, "downloadArResource|isDownloading=" + this.jdField_a_of_type_Boolean);
          }
          paramBoolean2 = this.jdField_a_of_type_Boolean;
          if (paramBoolean2) {
            return;
          }
          synchronized (this.jdField_a_of_type_ArrayOfByte)
          {
            this.jdField_a_of_type_JavaUtilArrayList.clear();
            if (paramArConfigInfo != null)
            {
              try
              {
                if ((paramArConfigInfo.mArCloudConfigInfos != null) && (paramArConfigInfo.mArCloudConfigInfos.size() > 0))
                {
                  i = 0;
                  Iterator localIterator = paramArConfigInfo.mArCloudConfigInfos.iterator();
                  if (!localIterator.hasNext()) {
                    break label1262;
                  }
                  localObject4 = (ArCloudConfigInfo)localIterator.next();
                  if ((localObject4 != null) && (((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null) && (!TextUtils.isEmpty(((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_b_of_type_JavaLangString))) {
                    break label370;
                  }
                  QLog.i("ArConfig_ArResourceDownload", 1, "resource null continue ");
                  continue;
                }
                if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
                  break label1539;
                }
              }
              catch (Exception paramArConfigInfo)
              {
                QLog.d("ArConfig_ArResourceDownload", 2, "e" + paramArConfigInfo.getMessage());
              }
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArResourceDownload", 2, "downloadArResource|download num= " + this.jdField_a_of_type_JavaUtilArrayList.size());
              }
              this.jdField_a_of_type_Long = 0L;
              this.jdField_b_of_type_Long = 0L;
              this.jdField_a_of_type_Boolean = true;
              this.jdField_b_of_type_Boolean = false;
              j = 0;
            }
          }
        }
        finally {}
        label370:
        Object localObject1;
        label562:
        ArVideoResourceInfo localArVideoResourceInfo;
        Object localObject3;
        label730:
        Object localObject2;
        label1092:
        label1262:
        label1279:
        ArResourceDownload.DownloadTask localDownloadTask;
        label1346:
        try
        {
          i = this.jdField_a_of_type_JavaUtilArrayList.size();
          k = i - 1;
          i = 0;
          if (k < 0) {}
        }
        catch (Exception paramArConfigInfo) {}
        try
        {
          paramArConfigInfo = (ArResourceDownload.DownloadInfo)this.jdField_a_of_type_JavaUtilArrayList.get(k);
          if (!paramBoolean1) {
            break label1279;
          }
          paramArConfigInfo.jdField_b_of_type_Boolean = true;
          if (this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(paramArConfigInfo.jdField_b_of_type_JavaLangString)) {
            break label1279;
          }
          this.jdField_a_of_type_JavaUtilArrayList.remove(k);
          this.jdField_a_of_type_JavaUtilSet.remove(paramArConfigInfo.jdField_b_of_type_JavaLangString);
          if (i == 0) {
            this.jdField_a_of_type_Boolean = false;
          }
        }
        catch (Exception paramArConfigInfo)
        {
          label1539:
          for (;;)
          {
            label1416:
            j = i;
          }
          break label1416;
          localDownloadTask = null;
          break label562;
          i = j;
          break label730;
          break label730;
          localDownloadTask = null;
          break label1092;
          switch (j)
          {
          }
          j = 4;
          break label1346;
        }
      }
      paramArConfigInfo = finally;
      throw paramArConfigInfo;
      if ((!TextUtils.isEmpty(((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c)) && (!FileUtils.a(((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c)))
      {
        localObject1 = new ArResourceDownload.DownloadInfo();
        ((ArResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 2;
        ((ArResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = ((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_b_of_type_JavaLangString;
        ((ArResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = ((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString;
        ((ArResourceDownload.DownloadInfo)localObject1).c = ((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c;
        ((ArResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Long = ((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_Long;
        ((ArResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = true;
        if (!this.jdField_a_of_type_JavaUtilSet.contains(((ArResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString))
        {
          this.jdField_a_of_type_JavaUtilSet.add(((ArResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        }
      }
      a((ArCloudConfigInfo)localObject4);
      if ((((ArCloudConfigInfo)localObject4).jdField_d_of_type_Int == 0) || (((ArCloudConfigInfo)localObject4).jdField_d_of_type_Int == 100))
      {
        if (((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) {
          break label1560;
        }
        localObject1 = new File(((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);
        localArVideoResourceInfo = null;
        localObject3 = localArVideoResourceInfo;
        if (localObject1 != null)
        {
          localObject3 = localArVideoResourceInfo;
          if (((File)localObject1).exists()) {
            localObject3 = PortalUtils.a(((File)localObject1).getAbsolutePath());
          }
        }
        if ((localObject1 != null) && (((File)localObject1).exists()) && (!TextUtils.isEmpty((CharSequence)localObject3)))
        {
          paramBoolean2 = ((String)localObject3).equals(((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString);
          if (paramBoolean2)
          {
            j = i;
            try
            {
              localObject1 = new File(((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);
              j = i;
              ArResourceConfigUtils.a(((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f, ((File)localObject1).getParentFile().getAbsolutePath() + File.separator + ((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + File.separator);
              j = 1;
              QLog.i("ArConfig_ArResourceDownload", 1, "onARMarkerModelDownloadComplete  ");
              i = 1;
            }
            catch (Exception localException)
            {
              new File(((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f).delete();
              localObject2 = new ArResourceDownload.DownloadInfo();
              ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Int = 3;
              ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_JavaLangString = ((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
              ((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString = ((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
              ((ArResourceDownload.DownloadInfo)localObject2).c = ((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
              ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Long = ((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
              ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Boolean = true;
              if (this.jdField_a_of_type_JavaUtilSet.contains(((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString)) {
                break label1566;
              }
            }
            this.jdField_a_of_type_JavaUtilSet.add(((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString);
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
            break label1566;
          }
        }
        localObject2 = new ArResourceDownload.DownloadInfo();
        ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Int = 3;
        if (((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null)
        {
          ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_JavaLangString = ((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
          ((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString = ((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
          ((ArResourceDownload.DownloadInfo)localObject2).c = ((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
          ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Long = ((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
        }
        ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_JavaUtilSet.contains(((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString)) {
          break label1573;
        }
        this.jdField_a_of_type_JavaUtilSet.add(((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        break label1573;
      }
      else if ((((ArCloudConfigInfo)localObject4).jdField_a_of_type_JavaUtilArrayList != null) && (((ArCloudConfigInfo)localObject4).jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localObject3 = ((ArCloudConfigInfo)localObject4).jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (!((Iterator)localObject3).hasNext()) {
            break label98;
          }
          localArVideoResourceInfo = (ArVideoResourceInfo)((Iterator)localObject3).next();
          if (localArVideoResourceInfo.jdField_d_of_type_Int == 4) {
            break;
          }
          localObject4 = new File(localArVideoResourceInfo.e);
          paramBoolean2 = ((File)localObject4).exists();
          if (!paramBoolean2) {
            break label1576;
          }
          try
          {
            localObject2 = PortalUtils.a(((File)localObject4).getAbsolutePath());
            if (((!((File)localObject4).exists()) || (TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(localArVideoResourceInfo.c))) && (!this.jdField_a_of_type_JavaUtilSet.contains(localArVideoResourceInfo.jdField_d_of_type_JavaLangString)))
            {
              localObject2 = new ArResourceDownload.DownloadInfo();
              ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Int = 3;
              ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_JavaLangString = localArVideoResourceInfo.jdField_d_of_type_JavaLangString;
              ((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString = localArVideoResourceInfo.c;
              ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Long = localArVideoResourceInfo.jdField_a_of_type_Long;
              ((ArResourceDownload.DownloadInfo)localObject2).c = localArVideoResourceInfo.e;
              ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Boolean = true;
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
              this.jdField_a_of_type_JavaUtilSet.add(localArVideoResourceInfo.c);
            }
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
          {
            QLog.e("ArConfig_ArResourceDownload", 1, "e" + localUnsatisfiedLinkError.getMessage());
            break label1576;
          }
        }
        if (i != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(paramArConfigInfo);
          continue;
          this.jdField_a_of_type_Long += paramArConfigInfo.jdField_a_of_type_Long;
          j = ((ArResourceManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.AR_RESOURCE_MANAGER)).d();
          if (!QLog.isColorLevel()) {
            break label1582;
          }
          QLog.d("ArConfig_ArResourceDownload", 2, "dpcNet=" + j);
          break label1582;
          for (;;)
          {
            localDownloadTask = new ArResourceDownload.DownloadTask((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramArConfigInfo, this);
            paramBoolean2 = ((PreDownloadController)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2)).requestPreDownload(10067, "prd", paramArConfigInfo.jdField_b_of_type_JavaLangString, 0, paramArConfigInfo.jdField_a_of_type_JavaLangString, paramArConfigInfo.c, j, 0, true, localDownloadTask);
            if (!paramBoolean2) {
              break label1557;
            }
            i += 1;
            j = i;
            if (QLog.isColorLevel())
            {
              j = i;
              QLog.d("ArConfig_ArResourceDownload", 2, " downloadArResource.ret=" + paramBoolean2);
            }
            k -= 1;
            break;
            j = 2;
            continue;
            j = 3;
            continue;
            j = 1;
          }
          this.jdField_a_of_type_JavaUtilSet.clear();
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("ArConfig_ArResourceDownload", 2, "e= " + paramArConfigInfo.getMessage());
            i = j;
            continue;
            this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.d();
          }
        }
      }
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3)
    {
      QLog.d("ArConfig_ArResourceDownload", 1, "doOnResp is downloading...");
      return;
    }
    boolean bool1;
    label28:
    int i;
    HttpNetReq localHttpNetReq;
    boolean bool2;
    Object localObject3;
    ArResourceDownload.DownloadInfo localDownloadInfo;
    if (paramNetResp.mResult == 0)
    {
      bool1 = true;
      i = paramNetResp.mErrCode;
      localHttpNetReq = (HttpNetReq)paramNetResp.mReq;
      ??? = localHttpNetReq.getUserData();
      bool2 = bool1;
      if (??? != null)
      {
        bool2 = bool1;
        if ((??? instanceof ArResourceDownload.DownloadInfo))
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a();
          localDownloadInfo = (ArResourceDownload.DownloadInfo)???;
          if (!TextUtils.isEmpty(localHttpNetReq.mOutPath)) {
            break label1267;
          }
          QLog.d("ArConfig_ArResourceDownload", 1, "req.mOutPath is null, md5=" + localDownloadInfo.jdField_b_of_type_JavaLangString);
          if (!bool1) {
            break label766;
          }
          i = 98765;
          label136:
          bool1 = false;
        }
      }
    }
    label264:
    label291:
    label1104:
    label1115:
    label1253:
    label1259:
    label1267:
    for (;;)
    {
      int j;
      if (bool1)
      {
        ??? = new File(localHttpNetReq.mOutPath);
        ??? = PortalUtils.a(((File)???).getAbsolutePath());
        if ((!TextUtils.isEmpty((CharSequence)???)) && (!((String)???).equalsIgnoreCase(localDownloadInfo.jdField_b_of_type_JavaLangString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArResourceDownload", 2, "Md5 error|fileMD5=" + (String)??? + ", type=" + localDownloadInfo.jdField_a_of_type_Int);
          }
          j = i;
          bool2 = bool1;
          if (localDownloadInfo.jdField_a_of_type_Int != 1)
          {
            ((File)???).delete();
            bool2 = false;
            j = -100001;
          }
          if (localDownloadInfo.jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(localDownloadInfo.jdField_b_of_type_JavaLangString, true);
          }
          bool1 = bool2;
          i = j;
          if (this.jdField_a_of_type_JavaUtilSet.contains(localDownloadInfo.jdField_b_of_type_JavaLangString)) {
            this.jdField_a_of_type_JavaUtilSet.remove(localDownloadInfo.jdField_b_of_type_JavaLangString);
          }
          if (this.jdField_a_of_type_JavaUtilSet.isEmpty()) {
            this.jdField_a_of_type_Boolean = false;
          }
          if ((localDownloadInfo.jdField_a_of_type_Int != 1) && (localDownloadInfo.jdField_a_of_type_Int != 2) && (localDownloadInfo.jdField_a_of_type_Int != 3) && (localDownloadInfo.jdField_a_of_type_Int != 4)) {
            break label1104;
          }
          j = 1;
          ??? = "0";
          if (!TextUtils.isEmpty(paramNetResp.mErrDesc))
          {
            ??? = paramNetResp.mErrDesc;
            ??? = ???;
            if (QLog.isColorLevel())
            {
              QLog.d("ArConfig_ArResourceDownload", 2, "errDesc: " + (String)???);
              ??? = ???;
            }
          }
          ??? = new HashMap();
          ((HashMap)???).put("url", OlympicUtil.a(localHttpNetReq.mReqUrl));
          ((HashMap)???).put("resultCode", String.valueOf(paramNetResp.mResult));
          ((HashMap)???).put("fileSize", String.valueOf(localDownloadInfo.jdField_a_of_type_Long));
          ((HashMap)???).put("param_errorDesc", ???);
          if (!bool1) {
            break label1115;
          }
          ((HashMap)???).put("param_FailCode", "0");
          if ((j == 0) || (this.jdField_a_of_type_Boolean) || (!a((ArConfigInfo)localObject3))) {}
        }
      }
      for (;;)
      {
        synchronized (this.jdField_a_of_type_ArrayOfByte)
        {
          for (;;)
          {
            if (!this.jdField_b_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.d();
              this.jdField_b_of_type_Boolean = true;
            }
            if (QLog.isColorLevel()) {
              QLog.i("ArConfig_ArResourceDownload", 2, "onResp:downloadSuccess!");
            }
            ??? = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
            StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance((String)???, "olympic_ar_download", bool1, 0L, 0L, (HashMap)???, null);
            bool2 = bool1;
            ??? = new File(localHttpNetReq.mOutPath);
            if ((!bool2) || (!((File)???).exists())) {
              break label1253;
            }
            l = ((File)???).length();
            ??? = (PreDownloadController)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
            ??? = localHttpNetReq.mReqUrl;
            if (!bool2) {
              break label1259;
            }
            ((PreDownloadController)???).preDownloadSuccess((String)???, l);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("ArConfig_ArResourceDownload", 2, "onResp:" + localHttpNetReq.mReqUrl + ", " + paramNetResp.mResult + ", " + paramNetResp.mErrCode);
            return;
            bool1 = false;
            break label28;
            label766:
            break label136;
            j = i;
            bool2 = bool1;
            if (localDownloadInfo.jdField_a_of_type_Int != 3) {
              break label264;
            }
            try
            {
              synchronized (this.jdField_a_of_type_ArrayOfByte)
              {
                Object localObject4 = ((ArConfigInfo)localObject3).getModelResByMd5(localDownloadInfo.jdField_b_of_type_JavaLangString);
                if ((!TextUtils.isEmpty(localDownloadInfo.c)) && (localObject4 != null) && ((((ArCloudConfigInfo)localObject4).jdField_d_of_type_Int == 0) || (((ArCloudConfigInfo)localObject4).jdField_d_of_type_Int == 100)))
                {
                  localObject4 = new File(localDownloadInfo.c);
                  ArResourceConfigUtils.a(localDownloadInfo.c, ((File)localObject4).getParentFile().getAbsolutePath() + File.separator + localDownloadInfo.jdField_b_of_type_JavaLangString + File.separator);
                  this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a((ArConfigInfo)localObject3);
                }
                j = i;
                bool2 = bool1;
              }
              if (!QLog.isColorLevel()) {
                break label264;
              }
            }
            catch (Exception localException)
            {
              ((File)???).delete();
              if (localDownloadInfo.jdField_a_of_type_Boolean)
              {
                bool1 = false;
                i = -100002;
              }
              j = i;
              bool2 = bool1;
            }
          }
          QLog.d("ArConfig_ArResourceDownload", 2, "e= " + localException.getMessage());
          j = i;
          bool2 = bool1;
          break label264;
          if ((localDownloadInfo.jdField_b_of_type_Int <= 3) && (!localDownloadInfo.jdField_b_of_type_Boolean))
          {
            a(localDownloadInfo);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("ArConfig_ArResourceDownload", 2, "retry downLoad:retryUrl=" + localDownloadInfo.jdField_a_of_type_JavaLangString + ",retryMd5= " + localDownloadInfo.jdField_b_of_type_JavaLangString);
            return;
          }
          if (localDownloadInfo.jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(localDownloadInfo.jdField_b_of_type_JavaLangString, false);
          }
          break label291;
          j = 0;
        }
        localException.put("param_FailCode", String.valueOf(i));
        this.jdField_a_of_type_JavaUtilSet.clear();
        synchronized (this.jdField_a_of_type_ArrayOfByte)
        {
          this.jdField_a_of_type_Boolean = false;
          localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localDownloadInfo = (ArResourceDownload.DownloadInfo)((Iterator)localObject3).next();
            if (localDownloadInfo.jdField_b_of_type_Long < localDownloadInfo.jdField_a_of_type_Long) {
              this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.cancelReq(localDownloadInfo.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
            }
          }
        }
        if ((j != 0) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(i, paramNetResp.mResult);
          this.jdField_b_of_type_Boolean = true;
        }
        continue;
        long l = 0L;
        continue;
        l = -1L;
      }
    }
  }
  
  public void onUpdateProgeress(NetReq arg1, long paramLong1, long paramLong2)
  {
    ??? = ???.getUserData();
    if ((??? != null) && ((??? instanceof ArResourceDownload.DownloadInfo)))
    {
      ??? = (ArResourceDownload.DownloadInfo)???;
      if (???.jdField_a_of_type_Int != 1) {}
    }
    else
    {
      return;
    }
    String str = ???.jdField_b_of_type_JavaLangString;
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ArResourceDownload.DownloadInfo localDownloadInfo = (ArResourceDownload.DownloadInfo)localIterator.next();
        if (str.equals(localDownloadInfo.jdField_b_of_type_JavaLangString))
        {
          paramLong2 = localDownloadInfo.jdField_b_of_type_Long;
          localDownloadInfo.jdField_b_of_type_Long = paramLong1;
          this.jdField_b_of_type_Long += paramLong1 - paramLong2;
        }
      }
      if (!this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_Long);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArResourceDownload
 * JD-Core Version:    0.7.0.1
 */