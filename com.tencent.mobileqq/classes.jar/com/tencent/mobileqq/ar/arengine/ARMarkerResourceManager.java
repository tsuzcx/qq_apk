package com.tencent.mobileqq.ar.arengine;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorConfigInfo;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionDevice;
import com.tencent.mobileqq.ar.ARVideoUtil;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ARRelationShip;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoUtil;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class ARMarkerResourceManager
{
  private static String jdField_b_of_type_JavaLangString = "";
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext = null;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ARResourceManagerTools jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools;
  Object jdField_a_of_type_JavaLangObject = new Object();
  String jdField_a_of_type_JavaLangString = null;
  private ArrayList<ArCloudConfigInfo> jdField_a_of_type_JavaUtilArrayList = null;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  int jdField_d_of_type_Int;
  long jdField_d_of_type_Long;
  long e;
  long f;
  long g;
  long h;
  long i;
  long j;
  
  public ARMarkerResourceManager(AppInterface paramAppInterface, Context paramContext)
  {
    jdField_b_of_type_JavaLangString = ARResouceDir.a();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools = new ARResourceManagerTools(paramAppInterface);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private static String a()
  {
    a();
    return jdField_b_of_type_JavaLangString + "ar_cloud_marker_config/";
  }
  
  static void a()
  {
    if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
      jdField_b_of_type_JavaLangString = ARResouceDir.a();
    }
    ARResouceDir.a(AppConstants.SDCARD_AR_MODEL + ".nomedia");
    ARResouceDir.a(AppConstants.SDCARD_AR_TRANSFER + ".nomedia");
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    File[] arrayOfFile = new File(a()).listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int k = 0;
    label30:
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (k < arrayOfFile.length)
    {
      localObject1 = arrayOfFile[k];
      if (((File)localObject1).getName().endsWith("_config.dat"))
      {
        localObject2 = a();
        localObject3 = ((File)localObject1).getName();
        if (((File)localObject1).lastModified() + paramLong >= System.currentTimeMillis()) {
          break label89;
        }
      }
    }
    for (;;)
    {
      k += 1;
      break label30;
      break;
      label89:
      localObject1 = ArResourceConfigUtils.a((String)localObject2, (String)localObject3);
      a((ArCloudConfigInfo)localObject1);
      if (((localObject1 == null) || (((ArCloudConfigInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo == null) || (new File(((ArCloudConfigInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c).exists())) && ((localObject1 == null) || (((ArCloudConfigInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) || (new File(((ArCloudConfigInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f).exists())))
      {
        if ((localObject1 != null) && (((ArCloudConfigInfo)localObject1).jdField_a_of_type_JavaUtilArrayList != null) && (((ArCloudConfigInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.size() > 0) && (((ArCloudConfigInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null))
        {
          localObject2 = ((ArCloudConfigInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ArVideoResourceInfo)((Iterator)localObject2).next();
            if ((new File(((ArCloudConfigInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString + ((ArVideoResourceInfo)localObject3).c + "_model.zip").exists()) || (((ArVideoResourceInfo)localObject3).jdField_d_of_type_Int == 4)) {}
          }
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
      }
    }
  }
  
  private void a(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    int k;
    if (paramArCloudConfigInfo != null) {
      k = 0;
    }
    while (k < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString.equals(((ArCloudConfigInfo)this.jdField_a_of_type_JavaUtilArrayList.get(k)).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString))) {
        return;
      }
      k += 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramArCloudConfigInfo);
  }
  
  private void a(ARCloudMarkerRecogResult paramARCloudMarkerRecogResult, ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerModelResources");
    Object localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c);
    d();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString;
    if ((!((File)localObject1).exists()) && (!paramArCloudConfigInfo.a()))
    {
      localObject1 = new ARResourceDownload.DownloadInfo();
      ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 2;
      ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_b_of_type_JavaLangString;
      ((ARResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString;
      this.jdField_c_of_type_Long = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_Long / 8192L);
      ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_Long;
      ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c;
      ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = false;
      this.jdField_c_of_type_Int = paramArCloudConfigInfo.jdField_d_of_type_Int;
      this.j += this.jdField_c_of_type_Long;
      localArrayList.add(localObject1);
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.a()))
    {
      localObject1 = new File(jdField_b_of_type_JavaLangString + "pddata/app/offline/html5/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString + File.separator);
      QLog.i("AREngine_ARMarkerResourceManager", 1, "offlie  " + OfflineEnvHelper.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString));
      if ((!((File)localObject1).exists()) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString)))
      {
        localObject1 = new ARResourceDownload.DownloadInfo();
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 4;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = String.valueOf(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString);
        localArrayList.add(localObject1);
      }
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c)))
    {
      if (!new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c).exists())
      {
        localObject1 = new ARResourceDownload.DownloadInfo();
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 7;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_a_of_type_JavaLangString;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_b_of_type_JavaLangString;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_a_of_type_Long;
        ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = true;
        localArrayList.add(localObject1);
      }
    }
    else
    {
      if ((paramArCloudConfigInfo.g == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString)) && (!new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString).exists()))
      {
        localObject1 = new ARResourceDownload.DownloadInfo();
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 6;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_b_of_type_JavaLangString;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_a_of_type_Long;
        ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = true;
        localArrayList.add(localObject1);
      }
      if ((paramArCloudConfigInfo.jdField_d_of_type_Int != 0) && (paramArCloudConfigInfo.jdField_d_of_type_Int != 100) && (paramArCloudConfigInfo.jdField_d_of_type_Int != 7) && (paramArCloudConfigInfo.jdField_d_of_type_Int != 8)) {
        break label1064;
      }
      if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) {
        break label1358;
      }
    }
    Object localObject2;
    label1064:
    label1323:
    label1358:
    for (localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);; localObject2 = null)
    {
      Iterator localIterator = null;
      Object localObject3 = localIterator;
      if (localObject1 != null)
      {
        localObject3 = localIterator;
        if (((File)localObject1).exists()) {
          localObject3 = PortalUtils.a(((File)localObject1).getAbsolutePath());
        }
      }
      if ((localObject1 != null) && (((File)localObject1).exists()) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).equals(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString))) {}
      for (;;)
      {
        for (;;)
        {
          try
          {
            localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);
            ArResourceConfigUtils.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f, ((File)localObject1).getParentFile().getAbsolutePath() + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + File.separator);
            paramARMarkerResourceCallback.a(true, 3, paramArCloudConfigInfo);
            QLog.i("AREngine_ARMarkerResourceManager", 1, "onARMarkerModelDownloadComplete  ");
            if ((paramARMarkerResourceCallback != null) && ((paramArCloudConfigInfo.a()) || (paramArCloudConfigInfo.b()))) {
              paramARMarkerResourceCallback.d();
            }
            if (localArrayList.size() <= 0) {
              break label1323;
            }
            this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.a(localArrayList, new ARMarkerResourceManager.3(this, paramARMarkerResourceCallback, paramArCloudConfigInfo, paramARCloudMarkerRecogResult));
            return;
          }
          catch (Exception paramARCloudMarkerRecogResult)
          {
            new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f).delete();
            QLog.i("AREngine_ARMarkerResourceManager", 1, "Download end. uncompressZip error. url = ");
            paramARMarkerResourceCallback.a(false, 3, paramArCloudConfigInfo);
            QLog.i("AREngine_ARMarkerResourceManager", 1, "onARMarkerModelDownloadComplete  ");
            paramARMarkerResourceCallback.a(false, paramArCloudConfigInfo);
            return;
          }
          try
          {
            ArResourceConfigUtils.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c, ARResouceDir.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_b_of_type_JavaLangString));
          }
          catch (Exception localException) {}
        }
        break;
        if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
        {
          localObject2 = new ARResourceDownload.DownloadInfo();
          ((ARResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Int = 3;
          ((ARResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
          ((ARResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
          this.f = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long / 8192L);
          ((ARResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
          this.j += this.f;
          this.h = System.currentTimeMillis();
          ((ARResourceDownload.DownloadInfo)localObject2).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
          ((ARResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Boolean = true;
          localArrayList.add(localObject2);
          continue;
          if ((paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
          {
            localObject3 = new ArrayList();
            localIterator = paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext())
            {
              ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)localIterator.next();
              if (localArVideoResourceInfo.jdField_d_of_type_Int != 4)
              {
                File localFile = new File(localArVideoResourceInfo.e);
                localObject2 = null;
                if (localFile.exists()) {
                  localObject2 = PortalUtils.a(localFile.getAbsolutePath());
                }
                if (((!localFile.exists()) || (TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(localArVideoResourceInfo.c))) && (!((ArrayList)localObject3).contains(localArVideoResourceInfo.jdField_d_of_type_JavaLangString)))
                {
                  localObject2 = new ARResourceDownload.DownloadInfo();
                  ((ARResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Int = 3;
                  ((ARResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_JavaLangString = localArVideoResourceInfo.jdField_d_of_type_JavaLangString;
                  ((ARResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString = localArVideoResourceInfo.c;
                  this.f = (localArVideoResourceInfo.jdField_a_of_type_Long / 8192L);
                  ((ARResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Long = localArVideoResourceInfo.jdField_a_of_type_Long;
                  this.j += this.f;
                  this.h = System.currentTimeMillis();
                  ((ARResourceDownload.DownloadInfo)localObject2).c = localArVideoResourceInfo.e;
                  ((ARResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Boolean = false;
                  localArrayList.add(localObject2);
                  ((ArrayList)localObject3).add(localArVideoResourceInfo.jdField_d_of_type_JavaLangString);
                }
              }
            }
          }
        }
      }
      paramARMarkerResourceCallback.a(true, paramArCloudConfigInfo);
      if (paramArCloudConfigInfo.jdField_b_of_type_Int != 1) {
        a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, paramARCloudMarkerRecogResult);
      }
      a(paramArCloudConfigInfo);
      return;
    }
  }
  
  private void a(ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadObjectModelResources");
    if (paramArCloudConfigInfo == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.a()) && (!new File(jdField_b_of_type_JavaLangString + "pddata/app/offline/html5/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString + File.separator).exists()) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString)))
    {
      localObject1 = new ARResourceDownload.DownloadInfo();
      ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 4;
      ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = String.valueOf(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString);
      localArrayList.add(localObject1);
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c)))
    {
      if (!new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c).exists())
      {
        localObject1 = new ARResourceDownload.DownloadInfo();
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 7;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_a_of_type_JavaLangString;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_b_of_type_JavaLangString;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_a_of_type_Long;
        ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = true;
        localArrayList.add(localObject1);
      }
    }
    else if ((paramArCloudConfigInfo.g == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString)))
    {
      if (new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString).exists()) {
        break label971;
      }
      localObject1 = jdField_b_of_type_JavaLangString + "ar_model/0/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c + "_model.zip";
      if (!new File((String)localObject1).exists()) {
        break label898;
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        ArResourceConfigUtils.a((String)localObject1, ARResouceDir.b());
        if ((paramArCloudConfigInfo.jdField_d_of_type_Int == 0) || (paramArCloudConfigInfo.jdField_d_of_type_Int == 7) || (paramArCloudConfigInfo.jdField_d_of_type_Int == 8))
        {
          if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) {
            break label1580;
          }
          localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);
          localIterator = null;
          localObject2 = localIterator;
          if (localObject1 != null)
          {
            localObject2 = localIterator;
            if (((File)localObject1).exists()) {
              localObject2 = PortalUtils.a(((File)localObject1).getAbsolutePath());
            }
          }
          if ((localObject1 == null) || (!((File)localObject1).exists()) || (TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString))) {
            break label1028;
          }
        }
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);
            ArResourceConfigUtils.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f, ((File)localObject1).getParentFile().getAbsolutePath() + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + File.separator);
            paramARMarkerResourceCallback.b(true, paramArCloudConfigInfo);
            QLog.i("AREngine_ARMarkerResourceManager", 1, "onARObjectClassifyDownloadComplete.");
            if ((paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList == null) || (paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
              break label1526;
            }
            localObject2 = new ArrayList();
            Iterator localIterator = paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext())
            {
              ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)localIterator.next();
              if (localArVideoResourceInfo.jdField_d_of_type_Int != 4)
              {
                File localFile = new File(localArVideoResourceInfo.e);
                localObject1 = null;
                if (localFile.exists()) {
                  localObject1 = PortalUtils.a(localFile.getAbsolutePath());
                }
                if (((!localFile.exists()) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(localArVideoResourceInfo.c))) && (!((ArrayList)localObject2).contains(localArVideoResourceInfo.jdField_d_of_type_JavaLangString)))
                {
                  localObject1 = new ARResourceDownload.DownloadInfo();
                  ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 3;
                  ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = localArVideoResourceInfo.jdField_d_of_type_JavaLangString;
                  ((ARResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = localArVideoResourceInfo.c;
                  this.f = (localArVideoResourceInfo.jdField_a_of_type_Long / 8192L);
                  ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Long = localArVideoResourceInfo.jdField_a_of_type_Long;
                  this.j += this.f;
                  this.h = System.currentTimeMillis();
                  ((ARResourceDownload.DownloadInfo)localObject1).c = localArVideoResourceInfo.e;
                  ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = false;
                  localArrayList.add(localObject1);
                  ((ArrayList)localObject2).add(localArVideoResourceInfo.jdField_d_of_type_JavaLangString);
                }
              }
            }
            try
            {
              ArResourceConfigUtils.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c, ARResouceDir.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_b_of_type_JavaLangString));
            }
            catch (Exception localException1) {}
          }
        }
        catch (Exception localException4)
        {
          ARResourceDownload.DownloadInfo localDownloadInfo1;
          new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f).delete();
          QLog.i("AREngine_ARMarkerResourceManager", 1, "onARObjectClassifyDownloadComplete. uncompressZip error.");
          paramARMarkerResourceCallback.b(false, paramArCloudConfigInfo);
          return;
        }
        localException2 = localException2;
        localDownloadInfo1 = new ARResourceDownload.DownloadInfo();
        localDownloadInfo1.jdField_a_of_type_Int = 6;
        localDownloadInfo1.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_b_of_type_JavaLangString;
        localDownloadInfo1.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c;
        localDownloadInfo1.jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_a_of_type_Long;
        localDownloadInfo1.c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString;
        localDownloadInfo1.jdField_a_of_type_Boolean = true;
        localArrayList.add(localDownloadInfo1);
        continue;
      }
      label898:
      localDownloadInfo1 = new ARResourceDownload.DownloadInfo();
      localDownloadInfo1.jdField_a_of_type_Int = 6;
      localDownloadInfo1.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_b_of_type_JavaLangString;
      localDownloadInfo1.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c;
      localDownloadInfo1.jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_a_of_type_Long;
      localDownloadInfo1.c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString;
      localDownloadInfo1.jdField_a_of_type_Boolean = true;
      localArrayList.add(localDownloadInfo1);
      continue;
      try
      {
        label971:
        ArResourceConfigUtils.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString, ARResouceDir.b());
      }
      catch (Exception localException3) {}
      continue;
      label1028:
      ARResourceDownload.DownloadInfo localDownloadInfo2;
      if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) && (paramArCloudConfigInfo.jdField_d_of_type_Int == 7))
      {
        String str = "";
        if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString != null) {
          str = jdField_b_of_type_JavaLangString + "ar_model/0/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + "_model.zip";
        }
        localObject2 = jdField_b_of_type_JavaLangString + "ar_cloud_classfiy_model/" + paramArCloudConfigInfo.jdField_d_of_type_Int + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + File.separator;
        if (new File(str).exists())
        {
          try
          {
            ArResourceConfigUtils.a(str, (String)localObject2);
          }
          catch (Exception localException5) {}
          if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
          {
            localDownloadInfo2 = new ARResourceDownload.DownloadInfo();
            localDownloadInfo2.jdField_a_of_type_Int = 3;
            localDownloadInfo2.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
            localDownloadInfo2.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
            this.f = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long / 8192L);
            localDownloadInfo2.jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
            this.j += this.f;
            this.h = System.currentTimeMillis();
            localDownloadInfo2.c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
            localDownloadInfo2.jdField_a_of_type_Boolean = true;
            localArrayList.add(localDownloadInfo2);
          }
        }
        else if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
        {
          localDownloadInfo2 = new ARResourceDownload.DownloadInfo();
          localDownloadInfo2.jdField_a_of_type_Int = 3;
          localDownloadInfo2.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
          localDownloadInfo2.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
          this.f = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long / 8192L);
          localDownloadInfo2.jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
          this.j += this.f;
          this.h = System.currentTimeMillis();
          localDownloadInfo2.c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
          localDownloadInfo2.jdField_a_of_type_Boolean = true;
          localArrayList.add(localDownloadInfo2);
        }
      }
      else if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
      {
        localDownloadInfo2 = new ARResourceDownload.DownloadInfo();
        localDownloadInfo2.jdField_a_of_type_Int = 3;
        localDownloadInfo2.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
        localDownloadInfo2.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
        this.f = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long / 8192L);
        localDownloadInfo2.jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
        this.j += this.f;
        this.h = System.currentTimeMillis();
        localDownloadInfo2.c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
        localDownloadInfo2.jdField_a_of_type_Boolean = true;
        localArrayList.add(localDownloadInfo2);
        continue;
        label1526:
        if ((paramARMarkerResourceCallback != null) && (paramArCloudConfigInfo.b())) {
          paramARMarkerResourceCallback.e();
        }
        if (localArrayList.size() > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.a(localArrayList, new ARMarkerResourceManager.4(this, paramARMarkerResourceCallback, paramArCloudConfigInfo));
          return;
        }
        paramARMarkerResourceCallback.b(true, paramArCloudConfigInfo);
        return;
        label1580:
        localDownloadInfo2 = null;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    QLog.i("AREngine_ARMarkerResourceManager", 1, "checkAndDeleteExpiredResource  ");
    long l = System.currentTimeMillis();
    File[] arrayOfFile = new File(a()).listFiles();
    if (arrayOfFile == null) {}
    label414:
    for (;;)
    {
      return;
      int k = 0;
      for (;;)
      {
        if (k >= arrayOfFile.length) {
          break label414;
        }
        Object localObject1 = arrayOfFile[k];
        if ((((int)((l - ((File)localObject1).lastModified()) / 86400000L) > 7) || (paramBoolean)) && (((File)localObject1).getName().endsWith("_config.dat")))
        {
          ArCloudConfigInfo localArCloudConfigInfo = ArResourceConfigUtils.a(a(), ((File)localObject1).getName());
          if (localArCloudConfigInfo == null) {
            break;
          }
          a(localArCloudConfigInfo);
          ((File)localObject1).delete();
          if (localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null)
          {
            localObject1 = new File(localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c);
            if (((File)localObject1).exists()) {
              ((File)localObject1).delete();
            }
            Object localObject2;
            if (localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null)
            {
              localObject1 = new File(localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);
              if (((File)localObject1).exists()) {
                ((File)localObject1).delete();
              }
              localObject1 = new File(localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString + localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + File.separator);
              if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
              {
                localObject2 = ((File)localObject1).listFiles();
                if (localObject2 != null)
                {
                  int m = 0;
                  while (m < localObject2.length)
                  {
                    localObject2[m].delete();
                    m += 1;
                  }
                }
                ((File)localObject1).delete();
              }
            }
            if ((localArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList != null) && (localArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
            {
              localObject1 = localArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (ArVideoResourceInfo)((Iterator)localObject1).next();
                localObject2 = new File(localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString + ((ArVideoResourceInfo)localObject2).c + "_model.zip");
                if (((File)localObject2).exists()) {
                  ((File)localObject2).delete();
                }
              }
            }
          }
        }
        k += 1;
      }
    }
  }
  
  public static boolean a(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo == null) {
      return false;
    }
    a();
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null)
    {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c = (jdField_b_of_type_JavaLangString + "ar_cloud_marker_feature/" + paramArCloudConfigInfo.jdField_d_of_type_Int + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString + "_signature.db");
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString = (jdField_b_of_type_JavaLangString + "ar_cloud_marker_model/" + paramArCloudConfigInfo.jdField_d_of_type_Int + File.separator);
    }
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f = (jdField_b_of_type_JavaLangString + "ar_cloud_marker_model/" + paramArCloudConfigInfo.jdField_d_of_type_Int + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + "_model.zip");
    }
    if ((paramArCloudConfigInfo.g == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c))) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString = (jdField_b_of_type_JavaLangString + "ar_cloud_relationship/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c + "_relationship.zip");
    }
    if ((paramArCloudConfigInfo.c()) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo != null)) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c = (jdField_b_of_type_JavaLangString + "ar_cloud_transfer/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_b_of_type_JavaLangString + ".zip");
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)localIterator.next();
        if (localArVideoResourceInfo.jdField_d_of_type_Int == 4) {
          localArVideoResourceInfo.e = AROnlineVideoUtil.a(localArVideoResourceInfo.jdField_d_of_type_JavaLangString);
        } else if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null) {
          localArVideoResourceInfo.e = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString + localArVideoResourceInfo.c + "_model.zip");
        }
      }
    }
    return true;
  }
  
  private boolean a(String paramString, ARCloudMarkerRecogResult paramARCloudMarkerRecogResult)
  {
    if (paramARCloudMarkerRecogResult == null) {
      return false;
    }
    try
    {
      paramARCloudMarkerRecogResult = new String(paramARCloudMarkerRecogResult.a[0].a, "utf-8");
      paramString = paramString + "_config.dat";
      return ArResourceConfigUtils.a(paramARCloudMarkerRecogResult, a(), paramString);
    }
    catch (UnsupportedEncodingException paramString)
    {
      QLog.i("AREngine_ARMarkerResourceManager", 1, "saveJsonConfigInfo failed. error msg = " + paramString.getMessage());
    }
    return false;
  }
  
  private void b(ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadSceneModelResources");
    if (paramArCloudConfigInfo == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.a()) && (!new File(jdField_b_of_type_JavaLangString + "pddata/app/offline/html5/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString + File.separator).exists()) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString)))
    {
      localObject1 = new ARResourceDownload.DownloadInfo();
      ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 4;
      ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = String.valueOf(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString);
      localArrayList.add(localObject1);
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c)))
    {
      if (!new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c).exists())
      {
        localObject1 = new ARResourceDownload.DownloadInfo();
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 7;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_a_of_type_JavaLangString;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_b_of_type_JavaLangString;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_a_of_type_Long;
        ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = true;
        localArrayList.add(localObject1);
      }
    }
    else if ((paramArCloudConfigInfo.g == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString)))
    {
      if (new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString).exists()) {
        break label971;
      }
      localObject1 = jdField_b_of_type_JavaLangString + "ar_model/0/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c + "_model.zip";
      if (!new File((String)localObject1).exists()) {
        break label898;
      }
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        ArResourceConfigUtils.a((String)localObject1, ARResouceDir.b());
        if ((paramArCloudConfigInfo.jdField_d_of_type_Int == 0) || (paramArCloudConfigInfo.jdField_d_of_type_Int == 7) || (paramArCloudConfigInfo.jdField_d_of_type_Int == 8))
        {
          if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) {
            break label1598;
          }
          localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);
          localIterator = null;
          localObject3 = localIterator;
          if (localObject1 != null)
          {
            localObject3 = localIterator;
            if (((File)localObject1).exists()) {
              localObject3 = PortalUtils.a(((File)localObject1).getAbsolutePath());
            }
          }
          if ((localObject1 == null) || (!((File)localObject1).exists()) || (TextUtils.isEmpty((CharSequence)localObject3)) || (!((String)localObject3).equals(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString))) {
            break label1028;
          }
        }
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);
            ArResourceConfigUtils.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f, ((File)localObject1).getParentFile().getAbsolutePath() + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + File.separator);
            paramARMarkerResourceCallback.c(true, paramArCloudConfigInfo);
            QLog.i("AREngine_ARMarkerResourceManager", 1, "onARSceneRecogDownloadComplete.");
            if ((paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList == null) || (paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
              break label1544;
            }
            localObject3 = new ArrayList();
            Iterator localIterator = paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext())
            {
              ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)localIterator.next();
              if (localArVideoResourceInfo.jdField_d_of_type_Int != 4)
              {
                File localFile = new File(localArVideoResourceInfo.e);
                localObject1 = null;
                if (localFile.exists()) {
                  localObject1 = PortalUtils.a(localFile.getAbsolutePath());
                }
                if (((!localFile.exists()) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(localArVideoResourceInfo.c))) && (!((ArrayList)localObject3).contains(localArVideoResourceInfo.jdField_d_of_type_JavaLangString)))
                {
                  localObject1 = new ARResourceDownload.DownloadInfo();
                  ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 3;
                  ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = localArVideoResourceInfo.jdField_d_of_type_JavaLangString;
                  ((ARResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = localArVideoResourceInfo.c;
                  this.f = (localArVideoResourceInfo.jdField_a_of_type_Long / 8192L);
                  ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Long = localArVideoResourceInfo.jdField_a_of_type_Long;
                  this.j += this.f;
                  this.h = System.currentTimeMillis();
                  ((ARResourceDownload.DownloadInfo)localObject1).c = localArVideoResourceInfo.e;
                  ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = false;
                  localArrayList.add(localObject1);
                  ((ArrayList)localObject3).add(localArVideoResourceInfo.jdField_d_of_type_JavaLangString);
                }
              }
            }
            try
            {
              ArResourceConfigUtils.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c, ARResouceDir.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_b_of_type_JavaLangString));
            }
            catch (Exception localException1) {}
          }
        }
        catch (Exception localException4)
        {
          ARResourceDownload.DownloadInfo localDownloadInfo1;
          new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f).delete();
          QLog.i("AREngine_ARMarkerResourceManager", 1, "onARSceneRecogDownloadComplete. uncompressZip error.");
          paramARMarkerResourceCallback.c(false, paramArCloudConfigInfo);
          return;
        }
        localException2 = localException2;
        localDownloadInfo1 = new ARResourceDownload.DownloadInfo();
        localDownloadInfo1.jdField_a_of_type_Int = 6;
        localDownloadInfo1.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_b_of_type_JavaLangString;
        localDownloadInfo1.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c;
        localDownloadInfo1.jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_a_of_type_Long;
        localDownloadInfo1.c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString;
        localDownloadInfo1.jdField_a_of_type_Boolean = true;
        localArrayList.add(localDownloadInfo1);
        continue;
      }
      label898:
      localDownloadInfo1 = new ARResourceDownload.DownloadInfo();
      localDownloadInfo1.jdField_a_of_type_Int = 6;
      localDownloadInfo1.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_b_of_type_JavaLangString;
      localDownloadInfo1.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c;
      localDownloadInfo1.jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_a_of_type_Long;
      localDownloadInfo1.c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString;
      localDownloadInfo1.jdField_a_of_type_Boolean = true;
      localArrayList.add(localDownloadInfo1);
      continue;
      try
      {
        label971:
        ArResourceConfigUtils.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString, ARResouceDir.b());
      }
      catch (Exception localException3) {}
      continue;
      label1028:
      ARResourceDownload.DownloadInfo localDownloadInfo2;
      if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) && (paramArCloudConfigInfo.jdField_d_of_type_Int == 7))
      {
        localObject3 = "";
        Object localObject2 = localObject3;
        if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null)
        {
          localObject2 = localObject3;
          if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString != null) {
            localObject2 = jdField_b_of_type_JavaLangString + "ar_model/0/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + "_model.zip";
          }
        }
        localObject3 = jdField_b_of_type_JavaLangString + "ar_cloud_classfiy_model/" + paramArCloudConfigInfo.jdField_d_of_type_Int + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + File.separator;
        if (new File((String)localObject2).exists())
        {
          try
          {
            ArResourceConfigUtils.a((String)localObject2, (String)localObject3);
          }
          catch (Exception localException5) {}
          if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
          {
            localDownloadInfo2 = new ARResourceDownload.DownloadInfo();
            localDownloadInfo2.jdField_a_of_type_Int = 3;
            localDownloadInfo2.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
            localDownloadInfo2.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
            this.f = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long / 8192L);
            localDownloadInfo2.jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
            this.j += this.f;
            this.h = System.currentTimeMillis();
            localDownloadInfo2.c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
            localDownloadInfo2.jdField_a_of_type_Boolean = true;
            localArrayList.add(localDownloadInfo2);
          }
        }
        else if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
        {
          localDownloadInfo2 = new ARResourceDownload.DownloadInfo();
          localDownloadInfo2.jdField_a_of_type_Int = 3;
          localDownloadInfo2.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
          localDownloadInfo2.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
          this.f = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long / 8192L);
          localDownloadInfo2.jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
          this.j += this.f;
          this.h = System.currentTimeMillis();
          localDownloadInfo2.c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
          localDownloadInfo2.jdField_a_of_type_Boolean = true;
          localArrayList.add(localDownloadInfo2);
        }
      }
      else if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
      {
        localDownloadInfo2 = new ARResourceDownload.DownloadInfo();
        localDownloadInfo2.jdField_a_of_type_Int = 3;
        localDownloadInfo2.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
        localDownloadInfo2.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
        this.f = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long / 8192L);
        localDownloadInfo2.jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
        this.j += this.f;
        this.h = System.currentTimeMillis();
        localDownloadInfo2.c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
        localDownloadInfo2.jdField_a_of_type_Boolean = true;
        localArrayList.add(localDownloadInfo2);
        continue;
        label1544:
        if ((paramARMarkerResourceCallback != null) && (paramArCloudConfigInfo.b())) {
          paramARMarkerResourceCallback.f();
        }
        if (localArrayList.size() > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.a(localArrayList, new ARMarkerResourceManager.5(this, paramARMarkerResourceCallback, paramArCloudConfigInfo));
          return;
        }
        paramARMarkerResourceCallback.c(true, paramArCloudConfigInfo);
        return;
        label1598:
        localDownloadInfo2 = null;
      }
    }
  }
  
  private static boolean b(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo == null) {
      return false;
    }
    a();
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString = (jdField_b_of_type_JavaLangString + "ar_cloud_classfiy_model/" + paramArCloudConfigInfo.jdField_d_of_type_Int + File.separator);
    }
    if ((paramArCloudConfigInfo.g == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c))) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString = (jdField_b_of_type_JavaLangString + "ar_cloud_relationship/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c + "_relationship.zip");
    }
    if ((paramArCloudConfigInfo.c()) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo != null)) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c = (jdField_b_of_type_JavaLangString + "ar_cloud_transfer/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_b_of_type_JavaLangString + ".zip");
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)localIterator.next();
        if (localArVideoResourceInfo.jdField_d_of_type_Int == 4) {
          localArVideoResourceInfo.e = AROnlineVideoUtil.a(localArVideoResourceInfo.jdField_d_of_type_JavaLangString);
        } else {
          localArVideoResourceInfo.e = (jdField_b_of_type_JavaLangString + "ar_cloud_classfiy_model/" + paramArCloudConfigInfo.jdField_d_of_type_Int + File.separator + localArVideoResourceInfo.c + "_model.zip");
        }
      }
    }
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f = (jdField_b_of_type_JavaLangString + "ar_cloud_classfiy_model/" + paramArCloudConfigInfo.jdField_d_of_type_Int + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + "_model.zip");
    }
    return true;
  }
  
  private static boolean c(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo == null) {
      return false;
    }
    a();
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString = (jdField_b_of_type_JavaLangString + "ar_cloud_scene_model/" + paramArCloudConfigInfo.jdField_d_of_type_Int + File.separator);
    }
    if ((paramArCloudConfigInfo.g == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c))) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString = (jdField_b_of_type_JavaLangString + "ar_cloud_relationship/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c + "_relationship.zip");
    }
    if ((paramArCloudConfigInfo.c()) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo != null)) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c = (jdField_b_of_type_JavaLangString + "ar_cloud_transfer/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_b_of_type_JavaLangString + ".zip");
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)localIterator.next();
        if (localArVideoResourceInfo.jdField_d_of_type_Int == 4) {
          localArVideoResourceInfo.e = AROnlineVideoUtil.a(localArVideoResourceInfo.jdField_d_of_type_JavaLangString);
        } else {
          localArVideoResourceInfo.e = (jdField_b_of_type_JavaLangString + "ar_cloud_scene_model/" + paramArCloudConfigInfo.jdField_d_of_type_Int + File.separator + localArVideoResourceInfo.c + "_model.zip");
        }
      }
    }
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f = (jdField_b_of_type_JavaLangString + "ar_cloud_scene_model/" + paramArCloudConfigInfo.jdField_d_of_type_Int + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + "_model.zip");
    }
    return true;
  }
  
  public ArrayList<ArCloudConfigInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    a(paramLong);
    a(paramBoolean);
    ARReport.a().b(System.currentTimeMillis() - l);
  }
  
  public boolean a(ARCloudMarkerRecogResult paramARCloudMarkerRecogResult, ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, boolean paramBoolean, String arg4)
  {
    Object localObject;
    try
    {
      localObject = new String(paramARCloudMarkerRecogResult.a[0].a, "utf-8");
      QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig. jsonContent = " + (String)localObject);
      localObject = ARCloudMarkerJsonParser.a((String)localObject);
      QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig. config = " + localObject);
      if ((localObject == null) || (((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo == null))
      {
        QLog.i("AREngine_ARMarkerResourceManager", 1, "ARCloud Marker Recog failed.");
        return false;
      }
    }
    catch (Exception paramARCloudMarkerRecogResult)
    {
      QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig. parse json failed. error msg = " + paramARCloudMarkerRecogResult.getMessage());
      return false;
    }
    if (((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo != null)
    {
      if ((ARVideoUtil.a()) || (!PromotionDevice.a()))
      {
        QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig pause because of device not support");
        return false;
      }
      if (((ArCloudConfigInfo)localObject).jdField_b_of_type_JavaLangString != null) {
        ReportController.b(null, "CliOper", "", "", "0X80098CB", "0X80098CB", 0, 0, ((ArCloudConfigInfo)localObject).jdField_b_of_type_JavaLangString, "0", "0", "");
      }
    }
    if (((ArCloudConfigInfo)localObject).g == 1)
    {
      if (!ARVideoUtil.a()) {}
      return false;
    }
    if (paramBoolean)
    {
      if (((ArCloudConfigInfo)localObject).g != 1) {
        break label322;
      }
      if ((((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelARRelationShip == null) || (TextUtils.isEmpty(((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_a_of_type_JavaLangString)) || (!((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_a_of_type_JavaLangString.equals(???))) {}
    }
    else
    {
      QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig");
      a((ArCloudConfigInfo)localObject);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        a(paramARCloudMarkerRecogResult, paramARMarkerResourceCallback, (ArCloudConfigInfo)localObject);
        return true;
      }
    }
    return false;
    label322:
    return false;
  }
  
  public boolean a(ARCloudObjectClassifyCommonInterface arg1, ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, boolean paramBoolean, String paramString)
  {
    if (??? == null) {
      return false;
    }
    ??? = ???.a();
    if (??? == null) {
      return false;
    }
    try
    {
      ??? = new String(???, "utf-8");
      if (QLog.isColorLevel()) {
        QLog.i("AREngine_ARMarkerResourceManager", 2, "downLoadMarkerConfig. jsonContent = " + ???);
      }
      paramString = ARCloudMarkerJsonParser.a(???);
      QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig. config = " + paramString);
      if (paramString == null) {
        return false;
      }
    }
    catch (UnsupportedEncodingException ???)
    {
      QLog.i("AREngine_ARMarkerResourceManager", 1, "processObjectClassifyRecogResult. parse json failed. error msg = " + ???.getMessage());
      return false;
    }
    if (paramString.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo != null)
    {
      if ((ARVideoUtil.a()) || (!PromotionDevice.a()))
      {
        QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadObjectConfig pause because of device not support");
        return false;
      }
      if (paramString.jdField_b_of_type_JavaLangString != null) {
        ReportController.b(null, "CliOper", "", "", "0X80098CC", "0X80098CC", 0, 0, paramString.jdField_b_of_type_JavaLangString, "0", "0", "");
      }
    }
    if ((paramString.g == 1) || (paramString.jdField_d_of_type_Int == 7))
    {
      QLog.i("AREngine_ARMarkerResourceManager", 1, "ar card not support");
      return false;
    }
    b(paramString);
    if ((QLog.isDebugVersion()) && (paramString.jdField_c_of_type_Int == 0)) {
      ThreadManager.getUIHandler().post(new ARMarkerResourceManager.1(this));
    }
    paramString.jdField_c_of_type_Int = Math.max(1, paramString.jdField_c_of_type_Int);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      a(paramARMarkerResourceCallback, paramString);
      return true;
    }
  }
  
  public boolean a(ARCloudSceneRecogResult paramARCloudSceneRecogResult, ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, boolean paramBoolean, String arg4)
  {
    if (paramARCloudSceneRecogResult == null) {
      return false;
    }
    paramARCloudSceneRecogResult = paramARCloudSceneRecogResult.a();
    if (paramARCloudSceneRecogResult == null) {
      return false;
    }
    try
    {
      paramARCloudSceneRecogResult = new String(paramARCloudSceneRecogResult, "utf-8");
      if (QLog.isColorLevel()) {
        QLog.i("AREngine_ARMarkerResourceManager", 2, "downLoadSceneConfig. jsonContent = " + paramARCloudSceneRecogResult);
      }
      paramARCloudSceneRecogResult = ARCloudMarkerJsonParser.a(paramARCloudSceneRecogResult);
      QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadSceneConfig. config = " + paramARCloudSceneRecogResult);
      if (paramARCloudSceneRecogResult == null) {
        return false;
      }
    }
    catch (UnsupportedEncodingException paramARCloudSceneRecogResult)
    {
      QLog.i("AREngine_ARMarkerResourceManager", 1, "processSceneRecogResult. parse json failed. error msg = " + paramARCloudSceneRecogResult.getMessage());
      return false;
    }
    if (paramARCloudSceneRecogResult.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo != null)
    {
      if ((ARVideoUtil.a()) || (!PromotionDevice.a()))
      {
        QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadSceneConfig pause because of device not support");
        return false;
      }
      if (paramARCloudSceneRecogResult.jdField_b_of_type_JavaLangString != null) {
        ReportController.b(null, "CliOper", "", "", "0X80098CC", "0X80098CC", 0, 0, paramARCloudSceneRecogResult.jdField_b_of_type_JavaLangString, "0", "0", "");
      }
    }
    if (paramARCloudSceneRecogResult.g == 1) {
      try
      {
        boolean bool = ARVideoUtil.a();
        if (!bool) {}
        return false;
      }
      catch (Exception ???)
      {
        QLog.i("AREngine_ARMarkerResourceManager", 1, " HotVideoUtils.saveBlurBitmap e = " + ???.getMessage());
      }
    }
    if (paramBoolean)
    {
      if (paramARCloudSceneRecogResult.g != 1) {
        break label349;
      }
      if ((paramARCloudSceneRecogResult.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip == null) || (!paramARCloudSceneRecogResult.b())) {}
    }
    else
    {
      c(paramARCloudSceneRecogResult);
      if ((QLog.isDebugVersion()) && (paramARCloudSceneRecogResult.jdField_c_of_type_Int == 0)) {
        ThreadManager.getUIHandler().post(new ARMarkerResourceManager.2(this));
      }
      paramARCloudSceneRecogResult.jdField_c_of_type_Int = Math.max(1, paramARCloudSceneRecogResult.jdField_c_of_type_Int);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        b(paramARMarkerResourceCallback, paramARCloudSceneRecogResult);
        return true;
      }
    }
    return false;
    label349:
    return false;
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools != null) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.b();
      }
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.c();
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.e = 0L;
    this.jdField_a_of_type_Int = -1;
    this.f = 0L;
    this.g = 0L;
    this.h = 0L;
    this.jdField_b_of_type_Int = -1;
    this.i = 0L;
    this.jdField_c_of_type_Int = -1;
    this.j = 0L;
    this.jdField_d_of_type_Int = -1;
  }
  
  public void e()
  {
    QLog.i("AREngine_ARMarkerResourceManager", 1, "arCloudDownloadReport start.");
    ARReport.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Long, this.jdField_d_of_type_Long, this.jdField_a_of_type_Int, this.f, this.g, this.jdField_b_of_type_Int, this.i, this.jdField_c_of_type_Int, this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, this.j, this.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager
 * JD-Core Version:    0.7.0.1
 */