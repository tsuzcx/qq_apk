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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append("ar_cloud_marker_config/");
    return localStringBuilder.toString();
  }
  
  static void a()
  {
    if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
      jdField_b_of_type_JavaLangString = ARResouceDir.a();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_AR_MODEL);
    localStringBuilder.append(".nomedia");
    ARResouceDir.a(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_AR_TRANSFER);
    localStringBuilder.append(".nomedia");
    ARResouceDir.a(localStringBuilder.toString());
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    File[] arrayOfFile = new File(a()).listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int k = 0;
    while (k < arrayOfFile.length)
    {
      Object localObject1 = arrayOfFile[k];
      if (((File)localObject1).getName().endsWith("_config.dat"))
      {
        Object localObject2 = a();
        Object localObject3 = ((File)localObject1).getName();
        if (((File)localObject1).lastModified() + paramLong >= System.currentTimeMillis())
        {
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
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(((ArCloudConfigInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString);
                localStringBuilder.append(((ArVideoResourceInfo)localObject3).c);
                localStringBuilder.append("_model.zip");
                if (!new File(localStringBuilder.toString()).exists()) {
                  int m = ((ArVideoResourceInfo)localObject3).jdField_d_of_type_Int;
                }
              }
            }
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
          }
        }
      }
      k += 1;
    }
  }
  
  private void a(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo != null)
    {
      int k = 0;
      while (k < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString.equals(((ArCloudConfigInfo)this.jdField_a_of_type_JavaUtilArrayList.get(k)).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString))) {
          return;
        }
        k += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramArCloudConfigInfo);
    }
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
    Object localObject2;
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.a()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("pddata/app/offline/html5/");
      ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(File.separator);
      localObject1 = new File(((StringBuilder)localObject1).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("offlie  ");
      ((StringBuilder)localObject2).append(OfflineEnvHelper.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString));
      QLog.i("AREngine_ARMarkerResourceManager", 1, ((StringBuilder)localObject2).toString());
      if ((!((File)localObject1).exists()) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString)))
      {
        localObject1 = new ARResourceDownload.DownloadInfo();
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 4;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = String.valueOf(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString);
        localArrayList.add(localObject1);
      }
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c))) {
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
    try
    {
      ArResourceConfigUtils.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c, ARResouceDir.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_b_of_type_JavaLangString));
    }
    catch (Exception localException)
    {
      label514:
      Object localObject3;
      label1149:
      break label514;
    }
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
    if ((paramArCloudConfigInfo.jdField_d_of_type_Int != 0) && (paramArCloudConfigInfo.jdField_d_of_type_Int != 100) && (paramArCloudConfigInfo.jdField_d_of_type_Int != 7) && (paramArCloudConfigInfo.jdField_d_of_type_Int != 8))
    {
      if ((paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localObject2 = new ArrayList();
        localObject3 = paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
    }
    else {
      while (((Iterator)localObject3).hasNext())
      {
        ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)((Iterator)localObject3).next();
        if (localArVideoResourceInfo.jdField_d_of_type_Int != 4)
        {
          File localFile = new File(localArVideoResourceInfo.e);
          if (localFile.exists()) {
            localObject1 = PortalUtils.a(localFile.getAbsolutePath());
          } else {
            localObject1 = null;
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
          continue;
          if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) {
            localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);
          } else {
            localObject1 = null;
          }
          if ((localObject1 != null) && (((File)localObject1).exists())) {
            localObject2 = PortalUtils.a(((File)localObject1).getAbsolutePath());
          } else {
            localObject2 = null;
          }
          if ((localObject1 == null) || (!((File)localObject1).exists()) || (TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString))) {}
        }
        try
        {
          localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);
          localObject2 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((File)localObject1).getParentFile().getAbsolutePath());
          ((StringBuilder)localObject3).append(File.separator);
          ((StringBuilder)localObject3).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject3).append(File.separator);
          ArResourceConfigUtils.a((String)localObject2, ((StringBuilder)localObject3).toString());
          paramARMarkerResourceCallback.a(true, 3, paramArCloudConfigInfo);
          QLog.i("AREngine_ARMarkerResourceManager", 1, "onARMarkerModelDownloadComplete  ");
        }
        catch (Exception paramARCloudMarkerRecogResult)
        {
          break label1149;
        }
        new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f).delete();
        QLog.i("AREngine_ARMarkerResourceManager", 1, "Download end. uncompressZip error. url = ");
        paramARMarkerResourceCallback.a(false, 3, paramArCloudConfigInfo);
        QLog.i("AREngine_ARMarkerResourceManager", 1, "onARMarkerModelDownloadComplete  ");
        paramARMarkerResourceCallback.a(false, paramArCloudConfigInfo);
        return;
        if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
        {
          localObject1 = new ARResourceDownload.DownloadInfo();
          ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 3;
          ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
          ((ARResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
          this.f = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long / 8192L);
          ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
          this.j += this.f;
          this.h = System.currentTimeMillis();
          ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
          ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = true;
          localArrayList.add(localObject1);
        }
      }
    }
    if ((paramARMarkerResourceCallback != null) && ((paramArCloudConfigInfo.a()) || (paramArCloudConfigInfo.b()))) {
      paramARMarkerResourceCallback.d();
    }
    if (localArrayList.size() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.a(localArrayList, new ARMarkerResourceManager.3(this, paramARMarkerResourceCallback, paramArCloudConfigInfo, paramARCloudMarkerRecogResult));
      return;
    }
    paramARMarkerResourceCallback.a(true, paramArCloudConfigInfo);
    if (paramArCloudConfigInfo.jdField_b_of_type_Int != 1) {
      a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, paramARCloudMarkerRecogResult);
    }
    a(paramArCloudConfigInfo);
  }
  
  private void a(ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadObjectModelResources");
    if (paramArCloudConfigInfo == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.a()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("pddata/app/offline/html5/");
      ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(File.separator);
      if ((!new File(((StringBuilder)localObject1).toString()).exists()) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString)))
      {
        localObject1 = new ARResourceDownload.DownloadInfo();
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 4;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = String.valueOf(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString);
        localArrayList.add(localObject1);
      }
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c))) {
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
    try
    {
      ArResourceConfigUtils.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c, ARResouceDir.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_b_of_type_JavaLangString));
    }
    catch (Exception localException1)
    {
      label283:
      break label283;
    }
    if ((paramArCloudConfigInfo.g == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString))) {
      if (!new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString).exists())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject1).append("ar_model/0/");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c);
        ((StringBuilder)localObject1).append("_model.zip");
        localObject1 = ((StringBuilder)localObject1).toString();
        if (!new File((String)localObject1).exists()) {}
      }
    }
    try
    {
      ArResourceConfigUtils.a((String)localObject1, ARResouceDir.b());
    }
    catch (Exception localException2)
    {
      label403:
      break label403;
    }
    Object localObject1 = new ARResourceDownload.DownloadInfo();
    ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 6;
    ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_b_of_type_JavaLangString;
    ((ARResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c;
    ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_a_of_type_Long;
    ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString;
    ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = true;
    localArrayList.add(localObject1);
    break label565;
    localObject1 = new ARResourceDownload.DownloadInfo();
    ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 6;
    ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_b_of_type_JavaLangString;
    ((ARResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c;
    ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_a_of_type_Long;
    ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString;
    ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = true;
    localArrayList.add(localObject1);
    try
    {
      ArResourceConfigUtils.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString, ARResouceDir.b());
    }
    catch (Exception localException3)
    {
      label565:
      Object localObject2;
      break label565;
    }
    if ((paramArCloudConfigInfo.jdField_d_of_type_Int == 0) || (paramArCloudConfigInfo.jdField_d_of_type_Int == 7) || (paramArCloudConfigInfo.jdField_d_of_type_Int == 8))
    {
      if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) {
        localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);
      } else {
        localObject1 = null;
      }
      if ((localObject1 != null) && (((File)localObject1).exists())) {
        localObject2 = PortalUtils.a(((File)localObject1).getAbsolutePath());
      } else {
        localObject2 = null;
      }
      if ((localObject1 == null) || (!((File)localObject1).exists()) || (TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString))) {}
    }
    try
    {
      localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);
      localObject2 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((File)localObject1).getParentFile().getAbsolutePath());
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject3).append(File.separator);
      ArResourceConfigUtils.a((String)localObject2, ((StringBuilder)localObject3).toString());
      paramARMarkerResourceCallback.b(true, paramArCloudConfigInfo);
      QLog.i("AREngine_ARMarkerResourceManager", 1, "onARObjectClassifyDownloadComplete.");
    }
    catch (Exception localException4)
    {
      Object localObject3;
      label784:
      break label784;
    }
    new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f).delete();
    QLog.i("AREngine_ARMarkerResourceManager", 1, "onARObjectClassifyDownloadComplete. uncompressZip error.");
    paramARMarkerResourceCallback.b(false, paramArCloudConfigInfo);
    return;
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) && (paramArCloudConfigInfo.jdField_d_of_type_Int == 7))
    {
      if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject1).append("ar_model/0/");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject1).append("_model.zip");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = "";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("ar_cloud_classfiy_model/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_d_of_type_Int);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(File.separator);
      localObject2 = ((StringBuilder)localObject2).toString();
      if (!new File((String)localObject1).exists()) {}
    }
    try
    {
      ArResourceConfigUtils.a((String)localObject1, (String)localObject2);
    }
    catch (Exception localException5)
    {
      label998:
      break label998;
    }
    if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
    {
      localObject1 = new ARResourceDownload.DownloadInfo();
      ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 3;
      ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
      ((ARResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
      this.f = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long / 8192L);
      ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
      this.j += this.f;
      this.h = System.currentTimeMillis();
      ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
      ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = true;
      localArrayList.add(localObject1);
      break label1349;
      if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
      {
        localObject1 = new ARResourceDownload.DownloadInfo();
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 3;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
        this.f = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long / 8192L);
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
        this.j += this.f;
        this.h = System.currentTimeMillis();
        ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = true;
        localArrayList.add(localObject1);
        break label1349;
        if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
        {
          localObject1 = new ARResourceDownload.DownloadInfo();
          ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 3;
          ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
          ((ARResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
          this.f = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long / 8192L);
          ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
          this.j += this.f;
          this.h = System.currentTimeMillis();
          ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
          ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = true;
          localArrayList.add(localObject1);
        }
      }
    }
    label1349:
    if ((paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localObject2 = new ArrayList();
      localObject3 = paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)((Iterator)localObject3).next();
        if (localArVideoResourceInfo.jdField_d_of_type_Int != 4)
        {
          File localFile = new File(localArVideoResourceInfo.e);
          if (localFile.exists()) {
            localObject1 = PortalUtils.a(localFile.getAbsolutePath());
          } else {
            localObject1 = null;
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
    }
    if ((paramARMarkerResourceCallback != null) && (paramArCloudConfigInfo.b())) {
      paramARMarkerResourceCallback.e();
    }
    if (localArrayList.size() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.a(localArrayList, new ARMarkerResourceManager.4(this, paramARMarkerResourceCallback, paramArCloudConfigInfo));
      return;
    }
    paramARMarkerResourceCallback.b(true, paramArCloudConfigInfo);
  }
  
  private void a(boolean paramBoolean)
  {
    QLog.i("AREngine_ARMarkerResourceManager", 1, "checkAndDeleteExpiredResource  ");
    long l = System.currentTimeMillis();
    File[] arrayOfFile = new File(a()).listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int k = 0;
    while (k < arrayOfFile.length)
    {
      Object localObject1 = arrayOfFile[k];
      if ((((int)((l - ((File)localObject1).lastModified()) / 86400000L) > 7) || (paramBoolean)) && (((File)localObject1).getName().endsWith("_config.dat")))
      {
        ArCloudConfigInfo localArCloudConfigInfo = ArResourceConfigUtils.a(a(), ((File)localObject1).getName());
        if (localArCloudConfigInfo == null) {
          return;
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
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString);
            ((StringBuilder)localObject1).append(localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject1).append(File.separator);
            localObject1 = new File(((StringBuilder)localObject1).toString());
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
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString);
              localStringBuilder.append(((ArVideoResourceInfo)localObject2).c);
              localStringBuilder.append("_model.zip");
              localObject2 = new File(localStringBuilder.toString());
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
  
  public static boolean a(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo == null) {
      return false;
    }
    a();
    Object localObject1;
    Object localObject2;
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null)
    {
      localObject1 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("ar_cloud_marker_feature/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_d_of_type_Int);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("_signature.db");
      ((ArFeatureInfo)localObject1).c = ((StringBuilder)localObject2).toString();
      localObject1 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("ar_cloud_marker_model/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_d_of_type_Int);
      ((StringBuilder)localObject2).append(File.separator);
      ((ArFeatureInfo)localObject1).jdField_d_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
    }
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null)
    {
      localObject1 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("ar_cloud_marker_model/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_d_of_type_Int);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("_model.zip");
      ((ArModelResource)localObject1).f = ((StringBuilder)localObject2).toString();
    }
    if ((paramArCloudConfigInfo.g == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c)))
    {
      localObject1 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("ar_cloud_relationship/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c);
      ((StringBuilder)localObject2).append("_relationship.zip");
      ((ARRelationShip)localObject1).jdField_d_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
    }
    if ((paramArCloudConfigInfo.c()) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo != null))
    {
      localObject1 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("ar_cloud_transfer/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(".zip");
      ((ARTransferDoorConfigInfo)localObject1).c = ((StringBuilder)localObject2).toString();
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localObject1 = paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ArVideoResourceInfo)((Iterator)localObject1).next();
        if (((ArVideoResourceInfo)localObject2).jdField_d_of_type_Int == 4)
        {
          ((ArVideoResourceInfo)localObject2).e = AROnlineVideoUtil.a(((ArVideoResourceInfo)localObject2).jdField_d_of_type_JavaLangString);
        }
        else if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString);
          localStringBuilder.append(((ArVideoResourceInfo)localObject2).c);
          localStringBuilder.append("_model.zip");
          ((ArVideoResourceInfo)localObject2).e = localStringBuilder.toString();
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_config.dat");
      paramString = localStringBuilder.toString();
      return ArResourceConfigUtils.a(paramARCloudMarkerRecogResult, a(), paramString);
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramARCloudMarkerRecogResult = new StringBuilder();
      paramARCloudMarkerRecogResult.append("saveJsonConfigInfo failed. error msg = ");
      paramARCloudMarkerRecogResult.append(paramString.getMessage());
      QLog.i("AREngine_ARMarkerResourceManager", 1, paramARCloudMarkerRecogResult.toString());
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
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.a()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("pddata/app/offline/html5/");
      ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(File.separator);
      if ((!new File(((StringBuilder)localObject1).toString()).exists()) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString)))
      {
        localObject1 = new ARResourceDownload.DownloadInfo();
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 4;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = String.valueOf(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString);
        localArrayList.add(localObject1);
      }
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c))) {
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
    try
    {
      ArResourceConfigUtils.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c, ARResouceDir.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_b_of_type_JavaLangString));
    }
    catch (Exception localException1)
    {
      label283:
      break label283;
    }
    if ((paramArCloudConfigInfo.g == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString))) {
      if (!new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString).exists())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject1).append("ar_model/0/");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c);
        ((StringBuilder)localObject1).append("_model.zip");
        localObject1 = ((StringBuilder)localObject1).toString();
        if (!new File((String)localObject1).exists()) {}
      }
    }
    try
    {
      ArResourceConfigUtils.a((String)localObject1, ARResouceDir.b());
    }
    catch (Exception localException2)
    {
      label403:
      break label403;
    }
    Object localObject1 = new ARResourceDownload.DownloadInfo();
    ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 6;
    ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_b_of_type_JavaLangString;
    ((ARResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c;
    ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_a_of_type_Long;
    ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString;
    ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = true;
    localArrayList.add(localObject1);
    break label565;
    localObject1 = new ARResourceDownload.DownloadInfo();
    ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 6;
    ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_b_of_type_JavaLangString;
    ((ARResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c;
    ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_a_of_type_Long;
    ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString;
    ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = true;
    localArrayList.add(localObject1);
    try
    {
      ArResourceConfigUtils.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString, ARResouceDir.b());
    }
    catch (Exception localException3)
    {
      label565:
      Object localObject2;
      break label565;
    }
    if ((paramArCloudConfigInfo.jdField_d_of_type_Int == 0) || (paramArCloudConfigInfo.jdField_d_of_type_Int == 7) || (paramArCloudConfigInfo.jdField_d_of_type_Int == 8))
    {
      if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) {
        localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);
      } else {
        localObject1 = null;
      }
      if ((localObject1 != null) && (((File)localObject1).exists())) {
        localObject2 = PortalUtils.a(((File)localObject1).getAbsolutePath());
      } else {
        localObject2 = null;
      }
      if ((localObject1 == null) || (!((File)localObject1).exists()) || (TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString))) {}
    }
    try
    {
      localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);
      localObject2 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((File)localObject1).getParentFile().getAbsolutePath());
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject3).append(File.separator);
      ArResourceConfigUtils.a((String)localObject2, ((StringBuilder)localObject3).toString());
      paramARMarkerResourceCallback.c(true, paramArCloudConfigInfo);
      QLog.i("AREngine_ARMarkerResourceManager", 1, "onARSceneRecogDownloadComplete.");
    }
    catch (Exception localException4)
    {
      Object localObject3;
      label784:
      break label784;
    }
    new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f).delete();
    QLog.i("AREngine_ARMarkerResourceManager", 1, "onARSceneRecogDownloadComplete. uncompressZip error.");
    paramARMarkerResourceCallback.c(false, paramArCloudConfigInfo);
    return;
    if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) && (paramArCloudConfigInfo.jdField_d_of_type_Int == 7))
    {
      if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString != null))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject1).append("ar_model/0/");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject1).append("_model.zip");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = "";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("ar_cloud_classfiy_model/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_d_of_type_Int);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(File.separator);
      localObject2 = ((StringBuilder)localObject2).toString();
      if (!new File((String)localObject1).exists()) {}
    }
    try
    {
      ArResourceConfigUtils.a((String)localObject1, (String)localObject2);
    }
    catch (Exception localException5)
    {
      label1009:
      break label1009;
    }
    if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
    {
      localObject1 = new ARResourceDownload.DownloadInfo();
      ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 3;
      ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
      ((ARResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
      this.f = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long / 8192L);
      ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
      this.j += this.f;
      this.h = System.currentTimeMillis();
      ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
      ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = true;
      localArrayList.add(localObject1);
      break label1360;
      if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
      {
        localObject1 = new ARResourceDownload.DownloadInfo();
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 3;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
        this.f = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long / 8192L);
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
        this.j += this.f;
        this.h = System.currentTimeMillis();
        ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = true;
        localArrayList.add(localObject1);
        break label1360;
        if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
        {
          localObject1 = new ARResourceDownload.DownloadInfo();
          ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 3;
          ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
          ((ARResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
          this.f = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long / 8192L);
          ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
          this.j += this.f;
          this.h = System.currentTimeMillis();
          ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
          ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = true;
          localArrayList.add(localObject1);
        }
      }
    }
    label1360:
    if ((paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localObject2 = new ArrayList();
      localObject3 = paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)((Iterator)localObject3).next();
        if (localArVideoResourceInfo.jdField_d_of_type_Int != 4)
        {
          File localFile = new File(localArVideoResourceInfo.e);
          if (localFile.exists()) {
            localObject1 = PortalUtils.a(localFile.getAbsolutePath());
          } else {
            localObject1 = null;
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
    }
    if ((paramARMarkerResourceCallback != null) && (paramArCloudConfigInfo.b())) {
      paramARMarkerResourceCallback.f();
    }
    if (localArrayList.size() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.a(localArrayList, new ARMarkerResourceManager.5(this, paramARMarkerResourceCallback, paramArCloudConfigInfo));
      return;
    }
    paramARMarkerResourceCallback.c(true, paramArCloudConfigInfo);
  }
  
  private static boolean b(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo == null) {
      return false;
    }
    a();
    Object localObject1;
    Object localObject2;
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null)
    {
      localObject1 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("ar_cloud_classfiy_model/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_d_of_type_Int);
      ((StringBuilder)localObject2).append(File.separator);
      ((ArFeatureInfo)localObject1).jdField_d_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
    }
    if ((paramArCloudConfigInfo.g == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c)))
    {
      localObject1 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("ar_cloud_relationship/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c);
      ((StringBuilder)localObject2).append("_relationship.zip");
      ((ARRelationShip)localObject1).jdField_d_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
    }
    if ((paramArCloudConfigInfo.c()) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo != null))
    {
      localObject1 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("ar_cloud_transfer/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(".zip");
      ((ARTransferDoorConfigInfo)localObject1).c = ((StringBuilder)localObject2).toString();
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localObject1 = paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ArVideoResourceInfo)((Iterator)localObject1).next();
        if (((ArVideoResourceInfo)localObject2).jdField_d_of_type_Int == 4)
        {
          ((ArVideoResourceInfo)localObject2).e = AROnlineVideoUtil.a(((ArVideoResourceInfo)localObject2).jdField_d_of_type_JavaLangString);
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(jdField_b_of_type_JavaLangString);
          localStringBuilder.append("ar_cloud_classfiy_model/");
          localStringBuilder.append(paramArCloudConfigInfo.jdField_d_of_type_Int);
          localStringBuilder.append(File.separator);
          localStringBuilder.append(((ArVideoResourceInfo)localObject2).c);
          localStringBuilder.append("_model.zip");
          ((ArVideoResourceInfo)localObject2).e = localStringBuilder.toString();
        }
      }
    }
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null)
    {
      localObject1 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("ar_cloud_classfiy_model/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_d_of_type_Int);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("_model.zip");
      ((ArModelResource)localObject1).f = ((StringBuilder)localObject2).toString();
    }
    return true;
  }
  
  private static boolean c(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo == null) {
      return false;
    }
    a();
    Object localObject1;
    Object localObject2;
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null)
    {
      localObject1 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("ar_cloud_scene_model/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_d_of_type_Int);
      ((StringBuilder)localObject2).append(File.separator);
      ((ArFeatureInfo)localObject1).jdField_d_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
    }
    if ((paramArCloudConfigInfo.g == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c)))
    {
      localObject1 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("ar_cloud_relationship/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c);
      ((StringBuilder)localObject2).append("_relationship.zip");
      ((ARRelationShip)localObject1).jdField_d_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
    }
    if ((paramArCloudConfigInfo.c()) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo != null))
    {
      localObject1 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("ar_cloud_transfer/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(".zip");
      ((ARTransferDoorConfigInfo)localObject1).c = ((StringBuilder)localObject2).toString();
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localObject1 = paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ArVideoResourceInfo)((Iterator)localObject1).next();
        if (((ArVideoResourceInfo)localObject2).jdField_d_of_type_Int == 4)
        {
          ((ArVideoResourceInfo)localObject2).e = AROnlineVideoUtil.a(((ArVideoResourceInfo)localObject2).jdField_d_of_type_JavaLangString);
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(jdField_b_of_type_JavaLangString);
          localStringBuilder.append("ar_cloud_scene_model/");
          localStringBuilder.append(paramArCloudConfigInfo.jdField_d_of_type_Int);
          localStringBuilder.append(File.separator);
          localStringBuilder.append(((ArVideoResourceInfo)localObject2).c);
          localStringBuilder.append("_model.zip");
          ((ArVideoResourceInfo)localObject2).e = localStringBuilder.toString();
        }
      }
    }
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null)
    {
      localObject1 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("ar_cloud_scene_model/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_d_of_type_Int);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("_model.zip");
      ((ArModelResource)localObject1).f = ((StringBuilder)localObject2).toString();
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
    try
    {
      Object localObject = new String(paramARCloudMarkerRecogResult.a[0].a, "utf-8");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downLoadMarkerConfig. jsonContent = ");
      localStringBuilder.append((String)localObject);
      QLog.i("AREngine_ARMarkerResourceManager", 1, localStringBuilder.toString());
      localObject = ARCloudMarkerJsonParser.a((String)localObject);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("downLoadMarkerConfig. config = ");
      localStringBuilder.append(localObject);
      QLog.i("AREngine_ARMarkerResourceManager", 1, localStringBuilder.toString());
      if ((localObject != null) && (((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null))
      {
        if (((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo != null) {
          if ((!ARVideoUtil.a()) && (PromotionDevice.a()))
          {
            if (((ArCloudConfigInfo)localObject).jdField_b_of_type_JavaLangString != null) {
              ReportController.b(null, "CliOper", "", "", "0X80098CB", "0X80098CB", 0, 0, ((ArCloudConfigInfo)localObject).jdField_b_of_type_JavaLangString, "0", "0", "");
            }
          }
          else
          {
            QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig pause because of device not support");
            return false;
          }
        }
        if (((ArCloudConfigInfo)localObject).g == 1)
        {
          ARVideoUtil.a();
          return false;
        }
        if ((paramBoolean) && ((((ArCloudConfigInfo)localObject).g != 1) || (((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelARRelationShip == null) || (TextUtils.isEmpty(((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_a_of_type_JavaLangString)) || (!((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_a_of_type_JavaLangString.equals(???)))) {
          return false;
        }
        QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig");
        a((ArCloudConfigInfo)localObject);
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          a(paramARCloudMarkerRecogResult, paramARMarkerResourceCallback, (ArCloudConfigInfo)localObject);
          return true;
        }
      }
      QLog.i("AREngine_ARMarkerResourceManager", 1, "ARCloud Marker Recog failed.");
      return false;
    }
    catch (Exception paramARCloudMarkerRecogResult)
    {
      paramARMarkerResourceCallback = new StringBuilder();
      paramARMarkerResourceCallback.append("downLoadMarkerConfig. parse json failed. error msg = ");
      paramARMarkerResourceCallback.append(paramARCloudMarkerRecogResult.getMessage());
      QLog.i("AREngine_ARMarkerResourceManager", 1, paramARMarkerResourceCallback.toString());
    }
    return false;
  }
  
  public boolean a(ARCloudObjectClassifyCommonInterface paramARCloudObjectClassifyCommonInterface, ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, boolean paramBoolean, String arg4)
  {
    if (paramARCloudObjectClassifyCommonInterface == null) {
      return false;
    }
    paramARCloudObjectClassifyCommonInterface = paramARCloudObjectClassifyCommonInterface.a();
    if (paramARCloudObjectClassifyCommonInterface == null) {
      return false;
    }
    try
    {
      paramARCloudObjectClassifyCommonInterface = new String(paramARCloudObjectClassifyCommonInterface, "utf-8");
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("downLoadMarkerConfig. jsonContent = ");
        ???.append(paramARCloudObjectClassifyCommonInterface);
        QLog.i("AREngine_ARMarkerResourceManager", 2, ???.toString());
      }
      paramARCloudObjectClassifyCommonInterface = ARCloudMarkerJsonParser.a(paramARCloudObjectClassifyCommonInterface);
      ??? = new StringBuilder();
      ???.append("downLoadMarkerConfig. config = ");
      ???.append(paramARCloudObjectClassifyCommonInterface);
      QLog.i("AREngine_ARMarkerResourceManager", 1, ???.toString());
      if (paramARCloudObjectClassifyCommonInterface == null) {
        return false;
      }
      if (paramARCloudObjectClassifyCommonInterface.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo != null) {
        if ((!ARVideoUtil.a()) && (PromotionDevice.a()))
        {
          if (paramARCloudObjectClassifyCommonInterface.jdField_b_of_type_JavaLangString != null) {
            ReportController.b(null, "CliOper", "", "", "0X80098CC", "0X80098CC", 0, 0, paramARCloudObjectClassifyCommonInterface.jdField_b_of_type_JavaLangString, "0", "0", "");
          }
        }
        else
        {
          QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadObjectConfig pause because of device not support");
          return false;
        }
      }
      if ((paramARCloudObjectClassifyCommonInterface.g != 1) && (paramARCloudObjectClassifyCommonInterface.jdField_d_of_type_Int != 7))
      {
        b(paramARCloudObjectClassifyCommonInterface);
        if ((QLog.isDebugVersion()) && (paramARCloudObjectClassifyCommonInterface.jdField_c_of_type_Int == 0)) {
          ThreadManager.getUIHandler().post(new ARMarkerResourceManager.1(this));
        }
        paramARCloudObjectClassifyCommonInterface.jdField_c_of_type_Int = Math.max(1, paramARCloudObjectClassifyCommonInterface.jdField_c_of_type_Int);
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          a(paramARMarkerResourceCallback, paramARCloudObjectClassifyCommonInterface);
          return true;
        }
      }
      QLog.i("AREngine_ARMarkerResourceManager", 1, "ar card not support");
      return false;
    }
    catch (UnsupportedEncodingException paramARCloudObjectClassifyCommonInterface)
    {
      paramARMarkerResourceCallback = new StringBuilder();
      paramARMarkerResourceCallback.append("processObjectClassifyRecogResult. parse json failed. error msg = ");
      paramARMarkerResourceCallback.append(paramARCloudObjectClassifyCommonInterface.getMessage());
      QLog.i("AREngine_ARMarkerResourceManager", 1, paramARMarkerResourceCallback.toString());
    }
    return false;
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
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("downLoadSceneConfig. jsonContent = ");
        ???.append(paramARCloudSceneRecogResult);
        QLog.i("AREngine_ARMarkerResourceManager", 2, ???.toString());
      }
      paramARCloudSceneRecogResult = ARCloudMarkerJsonParser.a(paramARCloudSceneRecogResult);
      ??? = new StringBuilder();
      ???.append("downLoadSceneConfig. config = ");
      ???.append(paramARCloudSceneRecogResult);
      QLog.i("AREngine_ARMarkerResourceManager", 1, ???.toString());
      if (paramARCloudSceneRecogResult == null) {
        return false;
      }
      if (paramARCloudSceneRecogResult.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo != null) {
        if ((!ARVideoUtil.a()) && (PromotionDevice.a()))
        {
          if (paramARCloudSceneRecogResult.jdField_b_of_type_JavaLangString != null) {
            ReportController.b(null, "CliOper", "", "", "0X80098CC", "0X80098CC", 0, 0, paramARCloudSceneRecogResult.jdField_b_of_type_JavaLangString, "0", "0", "");
          }
        }
        else
        {
          QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadSceneConfig pause because of device not support");
          return false;
        }
      }
      if (paramARCloudSceneRecogResult.g == 1) {
        try
        {
          ARVideoUtil.a();
          return false;
        }
        catch (Exception ???)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" HotVideoUtils.saveBlurBitmap e = ");
          localStringBuilder.append(???.getMessage());
          QLog.i("AREngine_ARMarkerResourceManager", 1, localStringBuilder.toString());
        }
      }
      if ((paramBoolean) && ((paramARCloudSceneRecogResult.g != 1) || (paramARCloudSceneRecogResult.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip == null) || (!paramARCloudSceneRecogResult.b()))) {
        return false;
      }
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
      return false;
    }
    catch (UnsupportedEncodingException paramARCloudSceneRecogResult)
    {
      paramARMarkerResourceCallback = new StringBuilder();
      paramARMarkerResourceCallback.append("processSceneRecogResult. parse json failed. error msg = ");
      paramARMarkerResourceCallback.append(paramARCloudSceneRecogResult.getMessage());
      QLog.i("AREngine_ARMarkerResourceManager", 1, paramARMarkerResourceCallback.toString());
    }
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
    ARResourceManagerTools localARResourceManagerTools = this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools;
    if (localARResourceManagerTools != null) {
      localARResourceManagerTools.c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager
 * JD-Core Version:    0.7.0.1
 */