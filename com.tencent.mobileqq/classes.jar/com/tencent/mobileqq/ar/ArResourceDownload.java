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
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
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
    if (!TextUtils.isEmpty(paramDownloadInfo.jdField_a_of_type_JavaLangString))
    {
      if (TextUtils.isEmpty(paramDownloadInfo.jdField_b_of_type_JavaLangString)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("downLoad:url=");
        ((StringBuilder)localObject).append(paramDownloadInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append(",md5= ");
        ((StringBuilder)localObject).append(paramDownloadInfo.jdField_b_of_type_JavaLangString);
        QLog.i("ArConfig_ArResourceDownload", 2, ((StringBuilder)localObject).toString());
      }
      paramDownloadInfo.jdField_b_of_type_Int += 1;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService == null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = ((IHttpEngineService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IHttpEngineService.class, "all"));
      }
      Object localObject = new HttpNetReq();
      ((HttpNetReq)localObject).mCallback = this;
      ((HttpNetReq)localObject).mReqUrl = paramDownloadInfo.jdField_a_of_type_JavaLangString;
      ((HttpNetReq)localObject).mHttpMethod = 0;
      ((HttpNetReq)localObject).mOutPath = paramDownloadInfo.c;
      ((HttpNetReq)localObject).mPrioty = 1;
      ((HttpNetReq)localObject).setUserData(paramDownloadInfo);
      ((HttpNetReq)localObject).mSupportBreakResume = true;
      this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.sendReq((NetReq)localObject);
      paramDownloadInfo.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = ((HttpNetReq)localObject);
    }
  }
  
  private void a(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo.jdField_d_of_type_Int == 100)
    {
      File localFile = null;
      Object localObject2 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource;
      Object localObject1 = "";
      if (localObject2 != null)
      {
        localFile = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(ArConfigUtils.a());
        ((StringBuilder)localObject2).append("ar_model/");
        ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_d_of_type_Int);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append("_model.zip");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = "";
      }
      if (localFile == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArResourceDownload", 2, "copyAndCheckBinHai3dRes return for null zipfile");
        }
        return;
      }
      Object localObject3 = new File((String)localObject2);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("downloadArResource:binhai:oldFilePath=");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(", exist=");
        localStringBuilder.append(((File)localObject3).exists());
        QLog.d("ArConfig_ArResourceDownload", 2, localStringBuilder.toString());
      }
      if ((((File)localObject3).exists()) && (!localFile.exists()))
      {
        bool1 = localFile.mkdirs();
        boolean bool2 = FileUtils.copyFile((File)localObject3, localFile);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("downloadArResource:binhai:copy old to new dir, ret=");
        ((StringBuilder)localObject2).append(bool2);
        ((StringBuilder)localObject2).append(", mkRet=");
        ((StringBuilder)localObject2).append(bool1);
        QLog.d("ArConfig_ArResourceDownload", 1, ((StringBuilder)localObject2).toString());
      }
      localObject2 = localObject1;
      if (localFile.exists()) {
        try
        {
          localObject3 = PortalUtils.a(localFile.getAbsolutePath());
          localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            localObject1 = localObject3;
            localObject2 = new StringBuilder();
            localObject1 = localObject3;
            ((StringBuilder)localObject2).append("download binhai calc md5=");
            localObject1 = localObject3;
            ((StringBuilder)localObject2).append((String)localObject3);
            localObject1 = localObject3;
            ((StringBuilder)localObject2).append(", modelMd5=");
            localObject1 = localObject3;
            ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString);
            localObject1 = localObject3;
            QLog.d("ArConfig_ArResourceDownload", 2, ((StringBuilder)localObject2).toString());
          }
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (!paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString.equalsIgnoreCase((String)localObject3))
          {
            localObject1 = localObject3;
            localFile.delete();
            localObject2 = localObject3;
          }
        }
        catch (Throwable paramArCloudConfigInfo)
        {
          QLog.e("ArConfig_ArResourceDownload", 1, "download binhai check md5 error", paramArCloudConfigInfo);
          localObject2 = localObject1;
        }
      }
      boolean bool1 = localFile.exists();
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("md5", localObject2);
      ((HashMap)localObject1).put("uin", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      if (bool1) {
        paramArCloudConfigInfo = "1";
      } else {
        paramArCloudConfigInfo = "0";
      }
      ((HashMap)localObject1).put("exist", paramArCloudConfigInfo);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "binhai_predownload", bool1, 0L, 0L, (HashMap)localObject1, "", true);
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
          localObject = (ArCloudConfigInfo)paramArConfigInfo.next();
          if (!FileUtils.fileExists(((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c)) {
            return false;
          }
          if (((((ArCloudConfigInfo)localObject).jdField_d_of_type_Int == 0) || (((ArCloudConfigInfo)localObject).jdField_d_of_type_Int == 100)) && (((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
          {
            boolean bool = new File(((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f).exists();
            if (!bool) {
              return false;
            }
          }
        }
      }
      return true;
    }
    catch (Exception paramArConfigInfo)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isResourceReady e=");
      ((StringBuilder)localObject).append(paramArConfigInfo.getMessage());
      QLog.i("ArConfig_ArResourceDownload", 1, ((StringBuilder)localObject).toString());
    }
    return true;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
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
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilSet.clear();
        return;
      }
    }
  }
  
  public void a(ArConfigInfo paramArConfigInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("downloadArResource|isDownloading=");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
          QLog.i("ArConfig_ArResourceDownload", 2, ((StringBuilder)localObject1).toString());
        }
        paramBoolean2 = this.jdField_a_of_type_Boolean;
        if (paramBoolean2) {
          return;
        }
      }
      finally
      {
        Object localObject1;
        int i;
        Object localObject2;
        continue;
        throw paramArConfigInfo;
        continue;
        Object localObject3 = null;
        continue;
        continue;
        localObject3 = null;
        continue;
        Object localObject4 = null;
        continue;
        int j = i;
        continue;
        if (j == 1) {
          continue;
        }
        if (j == 2) {
          continue;
        }
        if (j == 3) {
          continue;
        }
        j = 4;
        continue;
        j = 1;
        continue;
        j = 3;
        continue;
        j = 2;
        continue;
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
              Iterator localIterator = paramArConfigInfo.mArCloudConfigInfos.iterator();
              j = 0;
              if (localIterator.hasNext())
              {
                localObject5 = (ArCloudConfigInfo)localIterator.next();
                if ((localObject5 != null) && (((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null) && (!TextUtils.isEmpty(((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_b_of_type_JavaLangString)))
                {
                  if ((!TextUtils.isEmpty(((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c)) && (!FileUtils.fileExists(((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c)))
                  {
                    localObject1 = new ArResourceDownload.DownloadInfo();
                    ((ArResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 2;
                    ((ArResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = ((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_b_of_type_JavaLangString;
                    ((ArResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = ((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString;
                    ((ArResourceDownload.DownloadInfo)localObject1).c = ((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c;
                    ((ArResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Long = ((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_Long;
                    ((ArResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = true;
                    if (!this.jdField_a_of_type_JavaUtilSet.contains(((ArResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString))
                    {
                      this.jdField_a_of_type_JavaUtilSet.add(((ArResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString);
                      this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
                    }
                  }
                  a((ArCloudConfigInfo)localObject5);
                  if ((((ArCloudConfigInfo)localObject5).jdField_d_of_type_Int != 0) && (((ArCloudConfigInfo)localObject5).jdField_d_of_type_Int != 100))
                  {
                    i = j;
                    if (((ArCloudConfigInfo)localObject5).jdField_a_of_type_JavaUtilArrayList == null) {
                      continue;
                    }
                    i = j;
                    if (((ArCloudConfigInfo)localObject5).jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
                      continue;
                    }
                    localObject4 = ((ArCloudConfigInfo)localObject5).jdField_a_of_type_JavaUtilArrayList.iterator();
                    i = j;
                    if (!((Iterator)localObject4).hasNext()) {
                      continue;
                    }
                    localObject5 = (ArVideoResourceInfo)((Iterator)localObject4).next();
                    if (((ArVideoResourceInfo)localObject5).jdField_d_of_type_Int == 4) {
                      continue;
                    }
                    localObject6 = new File(((ArVideoResourceInfo)localObject5).e);
                    paramBoolean2 = ((File)localObject6).exists();
                    if (!paramBoolean2) {
                      continue;
                    }
                    try
                    {
                      localObject1 = PortalUtils.a(((File)localObject6).getAbsolutePath());
                    }
                    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
                    {
                      StringBuilder localStringBuilder = new StringBuilder();
                      localStringBuilder.append("e");
                      localStringBuilder.append(localUnsatisfiedLinkError.getMessage());
                      QLog.e("ArConfig_ArResourceDownload", 1, localStringBuilder.toString());
                      continue;
                    }
                    if (((((File)localObject6).exists()) && (!TextUtils.isEmpty(localUnsatisfiedLinkError)) && (localUnsatisfiedLinkError.equals(((ArVideoResourceInfo)localObject5).c))) || (this.jdField_a_of_type_JavaUtilSet.contains(((ArVideoResourceInfo)localObject5).jdField_d_of_type_JavaLangString))) {
                      continue;
                    }
                    localObject2 = new ArResourceDownload.DownloadInfo();
                    ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Int = 3;
                    ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_JavaLangString = ((ArVideoResourceInfo)localObject5).jdField_d_of_type_JavaLangString;
                    ((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString = ((ArVideoResourceInfo)localObject5).c;
                    ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Long = ((ArVideoResourceInfo)localObject5).jdField_a_of_type_Long;
                    ((ArResourceDownload.DownloadInfo)localObject2).c = ((ArVideoResourceInfo)localObject5).e;
                    ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Boolean = true;
                    this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
                    this.jdField_a_of_type_JavaUtilSet.add(((ArVideoResourceInfo)localObject5).c);
                    continue;
                  }
                  if (((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) {
                    continue;
                  }
                  localObject2 = new File(((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);
                  if ((localObject2 == null) || (!((File)localObject2).exists())) {
                    continue;
                  }
                  localObject4 = PortalUtils.a(((File)localObject2).getAbsolutePath());
                  if ((localObject2 != null) && (((File)localObject2).exists()) && (!TextUtils.isEmpty((CharSequence)localObject4)))
                  {
                    paramBoolean2 = ((String)localObject4).equals(((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString);
                    if (!paramBoolean2) {}
                  }
                }
              }
            }
          }
          catch (Exception paramArConfigInfo)
          {
            Object localObject5;
            Object localObject6;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("e");
            ((StringBuilder)localObject2).append(paramArConfigInfo.getMessage());
            QLog.d("ArConfig_ArResourceDownload", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          try
          {
            localObject2 = new File(((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);
            localObject4 = ((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append(((File)localObject2).getParentFile().getAbsolutePath());
            ((StringBuilder)localObject6).append(File.separator);
            ((StringBuilder)localObject6).append(((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject6).append(File.separator);
            ArResourceConfigUtils.a((String)localObject4, ((StringBuilder)localObject6).toString());
          }
          catch (Exception localException1)
          {
            int k;
            continue;
          }
          try
          {
            QLog.i("ArConfig_ArResourceDownload", 1, "onARMarkerModelDownloadComplete  ");
            i = 1;
          }
          catch (Exception localException2)
          {
            continue;
          }
          j = 1;
          new File(((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f).delete();
          localObject2 = new ArResourceDownload.DownloadInfo();
          ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Int = 3;
          ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_JavaLangString = ((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
          ((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString = ((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
          ((ArResourceDownload.DownloadInfo)localObject2).c = ((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
          ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Long = ((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
          ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Boolean = true;
          i = j;
          if (this.jdField_a_of_type_JavaUtilSet.contains(((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString)) {
            continue;
          }
          this.jdField_a_of_type_JavaUtilSet.add(((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          i = j;
          continue;
          localObject2 = new ArResourceDownload.DownloadInfo();
          ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Int = 3;
          if (((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null)
          {
            ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_JavaLangString = ((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
            ((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString = ((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
            ((ArResourceDownload.DownloadInfo)localObject2).c = ((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
            ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Long = ((ArCloudConfigInfo)localObject5).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
          }
          ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Boolean = true;
          i = j;
          if (this.jdField_a_of_type_JavaUtilSet.contains(((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString)) {
            continue;
          }
          this.jdField_a_of_type_JavaUtilSet.add(((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          i = j;
          continue;
          QLog.i("ArConfig_ArResourceDownload", 1, "resource null continue ");
          i = j;
          continue;
          if (j != 0) {
            this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(paramArConfigInfo);
          }
          if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
          {
            if (QLog.isColorLevel())
            {
              paramArConfigInfo = new StringBuilder();
              paramArConfigInfo.append("downloadArResource|download num= ");
              paramArConfigInfo.append(this.jdField_a_of_type_JavaUtilArrayList.size());
              QLog.d("ArConfig_ArResourceDownload", 2, paramArConfigInfo.toString());
            }
            this.jdField_a_of_type_Long = 0L;
            this.jdField_b_of_type_Long = 0L;
            this.jdField_a_of_type_Boolean = true;
            this.jdField_b_of_type_Boolean = false;
            try
            {
              i = this.jdField_a_of_type_JavaUtilArrayList.size();
              int m = i - 1;
              i = 0;
              j = i;
              if (m < 0) {
                continue;
              }
              k = i;
              try
              {
                paramArConfigInfo = (ArResourceDownload.DownloadInfo)this.jdField_a_of_type_JavaUtilArrayList.get(m);
                if (paramBoolean1)
                {
                  k = i;
                  paramArConfigInfo.jdField_b_of_type_Boolean = true;
                  k = i;
                  if (!this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(paramArConfigInfo.jdField_b_of_type_JavaLangString))
                  {
                    k = i;
                    this.jdField_a_of_type_JavaUtilArrayList.remove(m);
                    k = i;
                    this.jdField_a_of_type_JavaUtilSet.remove(paramArConfigInfo.jdField_b_of_type_JavaLangString);
                    j = i;
                    continue;
                  }
                }
                k = i;
                this.jdField_a_of_type_Long += paramArConfigInfo.jdField_a_of_type_Long;
                k = i;
                j = ((ArResourceManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.AR_RESOURCE_MANAGER)).a();
                k = i;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                k = i;
                localObject2 = new StringBuilder();
                k = i;
                ((StringBuilder)localObject2).append("dpcNet=");
                k = i;
                ((StringBuilder)localObject2).append(j);
                k = i;
                QLog.d("ArConfig_ArResourceDownload", 2, ((StringBuilder)localObject2).toString());
              }
              catch (Exception paramArConfigInfo)
              {
                continue;
              }
              k = i;
              localObject2 = new ArResourceDownload.DownloadTask((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramArConfigInfo, this);
              k = i;
              paramBoolean2 = ((IPreDownloadController)((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getRuntimeService(IPreDownloadController.class)).requestPreDownload(10067, "prd", paramArConfigInfo.jdField_b_of_type_JavaLangString, 0, paramArConfigInfo.jdField_a_of_type_JavaLangString, paramArConfigInfo.c, j, 0, true, (AbsPreDownloadTask)localObject2);
              j = i;
              if (paramBoolean2) {
                j = i + 1;
              }
              k = j;
              if (QLog.isColorLevel())
              {
                k = j;
                paramArConfigInfo = new StringBuilder();
                k = j;
                paramArConfigInfo.append(" downloadArResource.ret=");
                k = j;
                paramArConfigInfo.append(paramBoolean2);
                k = j;
                QLog.d("ArConfig_ArResourceDownload", 2, paramArConfigInfo.toString());
              }
              m -= 1;
              i = j;
              continue;
              this.jdField_a_of_type_JavaUtilSet.clear();
            }
            catch (Exception paramArConfigInfo)
            {
              k = 0;
            }
            j = k;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("e= ");
              ((StringBuilder)localObject2).append(paramArConfigInfo.getMessage());
              QLog.d("ArConfig_ArResourceDownload", 2, ((StringBuilder)localObject2).toString());
              j = k;
            }
            if (j == 0) {
              this.jdField_a_of_type_Boolean = false;
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.c();
          }
          return;
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
    if (paramNetResp.mResult == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int i = paramNetResp.mErrCode;
    HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.mReq;
    ??? = localHttpNetReq.getUserData();
    boolean bool2 = bool1;
    Object localObject4;
    ArResourceDownload.DownloadInfo localDownloadInfo;
    boolean bool3;
    int k;
    Object localObject3;
    if (??? != null)
    {
      bool2 = bool1;
      if ((??? instanceof ArResourceDownload.DownloadInfo))
      {
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a();
        localDownloadInfo = (ArResourceDownload.DownloadInfo)???;
        if (TextUtils.isEmpty(localHttpNetReq.mOutPath))
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("req.mOutPath is null, md5=");
          ((StringBuilder)???).append(localDownloadInfo.jdField_b_of_type_JavaLangString);
          QLog.d("ArConfig_ArResourceDownload", 1, ((StringBuilder)???).toString());
          if (bool1) {
            i = 98765;
          }
          bool1 = false;
        }
        if (bool1)
        {
          ??? = new File(localHttpNetReq.mOutPath);
          ??? = PortalUtils.a(((File)???).getAbsolutePath());
          Object localObject5;
          int j;
          if ((!TextUtils.isEmpty((CharSequence)???)) && (!((String)???).equalsIgnoreCase(localDownloadInfo.jdField_b_of_type_JavaLangString)))
          {
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("Md5 error|fileMD5=");
              ((StringBuilder)localObject5).append((String)???);
              ((StringBuilder)localObject5).append(", type=");
              ((StringBuilder)localObject5).append(localDownloadInfo.jdField_a_of_type_Int);
              QLog.d("ArConfig_ArResourceDownload", 2, ((StringBuilder)localObject5).toString());
            }
            bool2 = bool1;
            j = i;
            if (localDownloadInfo.jdField_a_of_type_Int != 1)
            {
              ((File)???).delete();
              bool2 = false;
              j = -100001;
            }
          }
          else
          {
            bool2 = bool1;
            j = i;
            if (localDownloadInfo.jdField_a_of_type_Int == 3) {
              try
              {
                synchronized (this.jdField_a_of_type_ArrayOfByte)
                {
                  localObject5 = ((ArConfigInfo)localObject4).getModelResByMd5(localDownloadInfo.jdField_b_of_type_JavaLangString);
                  if ((!TextUtils.isEmpty(localDownloadInfo.c)) && (localObject5 != null) && ((((ArCloudConfigInfo)localObject5).jdField_d_of_type_Int == 0) || (((ArCloudConfigInfo)localObject5).jdField_d_of_type_Int == 100)))
                  {
                    localObject5 = new File(localDownloadInfo.c);
                    String str = localDownloadInfo.c;
                    StringBuilder localStringBuilder = new StringBuilder();
                    localStringBuilder.append(((File)localObject5).getParentFile().getAbsolutePath());
                    localStringBuilder.append(File.separator);
                    localStringBuilder.append(localDownloadInfo.jdField_b_of_type_JavaLangString);
                    localStringBuilder.append(File.separator);
                    ArResourceConfigUtils.a(str, localStringBuilder.toString());
                    this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a((ArConfigInfo)localObject4);
                  }
                  bool2 = bool1;
                  j = i;
                }
                bool3 = bool2;
              }
              catch (Exception localException)
              {
                ((File)???).delete();
                if (localDownloadInfo.jdField_a_of_type_Boolean)
                {
                  i = -100002;
                  bool1 = false;
                }
                bool2 = bool1;
                j = i;
                if (QLog.isColorLevel())
                {
                  ??? = new StringBuilder();
                  ((StringBuilder)???).append("e= ");
                  ((StringBuilder)???).append(localException.getMessage());
                  QLog.d("ArConfig_ArResourceDownload", 2, ((StringBuilder)???).toString());
                  j = i;
                  bool2 = bool1;
                }
              }
            }
          }
          k = j;
          if (localDownloadInfo.jdField_b_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(localDownloadInfo.jdField_b_of_type_JavaLangString, true);
            bool3 = bool2;
            k = j;
          }
        }
        else
        {
          if ((localDownloadInfo.jdField_b_of_type_Int <= 3) && (!localDownloadInfo.jdField_b_of_type_Boolean))
          {
            a(localDownloadInfo);
            if (QLog.isColorLevel())
            {
              paramNetResp = new StringBuilder();
              paramNetResp.append("retry downLoad:retryUrl=");
              paramNetResp.append(localDownloadInfo.jdField_a_of_type_JavaLangString);
              paramNetResp.append(",retryMd5= ");
              paramNetResp.append(localDownloadInfo.jdField_b_of_type_JavaLangString);
              QLog.i("ArConfig_ArResourceDownload", 2, paramNetResp.toString());
            }
            return;
          }
          bool3 = bool1;
          k = i;
          if (localDownloadInfo.jdField_b_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(localDownloadInfo.jdField_b_of_type_JavaLangString, false);
            k = i;
            bool3 = bool1;
          }
        }
        if (this.jdField_a_of_type_JavaUtilSet.contains(localDownloadInfo.jdField_b_of_type_JavaLangString)) {
          this.jdField_a_of_type_JavaUtilSet.remove(localDownloadInfo.jdField_b_of_type_JavaLangString);
        }
        if (this.jdField_a_of_type_JavaUtilSet.isEmpty()) {
          this.jdField_a_of_type_Boolean = false;
        }
        if ((localDownloadInfo.jdField_a_of_type_Int != 1) && (localDownloadInfo.jdField_a_of_type_Int != 2) && (localDownloadInfo.jdField_a_of_type_Int != 3) && (localDownloadInfo.jdField_a_of_type_Int != 4)) {
          i = 0;
        } else {
          i = 1;
        }
        if (!TextUtils.isEmpty(paramNetResp.mErrDesc))
        {
          localObject3 = paramNetResp.mErrDesc;
          ??? = localObject3;
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("errDesc: ");
            ((StringBuilder)???).append((String)localObject3);
            QLog.d("ArConfig_ArResourceDownload", 2, ((StringBuilder)???).toString());
            ??? = localObject3;
          }
        }
        else
        {
          ??? = "0";
        }
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("url", OlympicUtil.a(localHttpNetReq.mReqUrl));
        ((HashMap)localObject3).put("resultCode", String.valueOf(paramNetResp.mResult));
        ((HashMap)localObject3).put("fileSize", String.valueOf(localDownloadInfo.jdField_a_of_type_Long));
        ((HashMap)localObject3).put("param_errorDesc", ???);
        if (bool3)
        {
          ((HashMap)localObject3).put("param_FailCode", "0");
          if ((i != 0) && (!this.jdField_a_of_type_Boolean) && (a((ArConfigInfo)localObject4))) {
            synchronized (this.jdField_a_of_type_ArrayOfByte)
            {
              if (!this.jdField_b_of_type_Boolean)
              {
                this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.c();
                this.jdField_b_of_type_Boolean = true;
              }
              if (!QLog.isColorLevel()) {
                break label1186;
              }
              QLog.i("ArConfig_ArResourceDownload", 2, "onResp:downloadSuccess!");
            }
          }
        }
        else
        {
          ((HashMap)localObject3).put("param_FailCode", String.valueOf(k));
          this.jdField_a_of_type_JavaUtilSet.clear();
        }
      }
    }
    label1186:
    label1402:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        this.jdField_a_of_type_Boolean = false;
        localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (((Iterator)localObject4).hasNext())
        {
          localDownloadInfo = (ArResourceDownload.DownloadInfo)((Iterator)localObject4).next();
          if (localDownloadInfo.jdField_b_of_type_Long >= localDownloadInfo.jdField_a_of_type_Long) {
            break label1402;
          }
          this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.cancelReq(localDownloadInfo.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
          break label1402;
        }
        if ((i != 0) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(k, paramNetResp.mResult);
          this.jdField_b_of_type_Boolean = true;
        }
        ??? = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance((String)???, "olympic_ar_download", bool3, 0L, 0L, (HashMap)localObject3, null);
        bool2 = bool3;
      }
      ??? = new File(localHttpNetReq.mOutPath);
      long l;
      if ((bool2) && (((File)???).exists())) {
        l = ((File)???).length();
      } else {
        l = 0L;
      }
      ??? = (IPreDownloadController)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPreDownloadController.class, "");
      localObject3 = localHttpNetReq.mReqUrl;
      if (!bool2) {
        l = -1L;
      }
      ((IPreDownloadController)???).preDownloadSuccess((String)localObject3, l);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("onResp:");
        ((StringBuilder)???).append(localHttpNetReq.mReqUrl);
        ((StringBuilder)???).append(", ");
        ((StringBuilder)???).append(paramNetResp.mResult);
        ((StringBuilder)???).append(", ");
        ((StringBuilder)???).append(paramNetResp.mErrCode);
        QLog.i("ArConfig_ArResourceDownload", 2, ((StringBuilder)???).toString());
      }
      return;
    }
  }
  
  public void onUpdateProgeress(NetReq arg1, long paramLong1, long paramLong2)
  {
    ??? = ???.getUserData();
    if ((??? != null) && ((??? instanceof ArResourceDownload.DownloadInfo)))
    {
      ??? = (ArResourceDownload.DownloadInfo)???;
      if (???.jdField_a_of_type_Int == 1) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArResourceDownload
 * JD-Core Version:    0.7.0.1
 */