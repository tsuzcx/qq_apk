package com.tencent.mobileqq.ar.arengine;

import aacn;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARVideoUtil;
import com.tencent.mobileqq.ar.BusinessInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ARRelationShip;
import com.tencent.mobileqq.ar.model.ArAwardInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoUtil;
import com.tencent.mobileqq.hotpic.HotVideoUtils;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

public class ARMarkerResourceManager
{
  public int a;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ARResourceManagerTools jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools;
  Object jdField_a_of_type_JavaLangObject = new Object();
  String jdField_a_of_type_JavaLangString = null;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public int b;
  public long b;
  private String b;
  int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  public int d;
  public long d;
  long e;
  long f;
  public long g;
  long h;
  long i;
  long j;
  
  public ARMarkerResourceManager(AppInterface paramAppInterface, Context paramContext)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = ARResouceDir.a();
    this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools = new ARResourceManagerTools(paramAppInterface);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private String a()
  {
    return this.jdField_b_of_type_JavaLangString + "ar_cloud_marker_config/";
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    File[] arrayOfFile = new File(a()).listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int k = 0;
    label31:
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
          break label91;
        }
      }
    }
    for (;;)
    {
      k += 1;
      break label31;
      break;
      label91:
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
    c();
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
      localObject1 = new File(this.jdField_b_of_type_JavaLangString + "pddata/app/offline/html5/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString + File.separator);
      QLog.i("AREngine_ARMarkerResourceManager", 1, "offlie  " + OfflineEnvHelper.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString));
      if (!((File)localObject1).exists())
      {
        localObject1 = new ARResourceDownload.DownloadInfo();
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 4;
        ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = String.valueOf(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString);
        localArrayList.add(localObject1);
      }
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
    if ((paramArCloudConfigInfo.jdField_d_of_type_Int == 0) || (paramArCloudConfigInfo.jdField_d_of_type_Int == 100) || (paramArCloudConfigInfo.jdField_d_of_type_Int == 7)) {
      if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) {
        break label1650;
      }
    }
    label1650:
    for (localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);; localObject1 = null)
    {
      Iterator localIterator = null;
      Object localObject2 = localIterator;
      if (localObject1 != null)
      {
        localObject2 = localIterator;
        if (((File)localObject1).exists()) {
          localObject2 = PortalUtils.a(((File)localObject1).getAbsolutePath());
        }
      }
      if ((localObject1 != null) && (((File)localObject1).exists()) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString))) {}
      for (;;)
      {
        try
        {
          localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);
          ArResourceConfigUtils.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f, ((File)localObject1).getParentFile().getAbsolutePath() + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + File.separator);
          paramARMarkerResourceCallback.a(true, 3, paramArCloudConfigInfo);
          QLog.i("AREngine_ARMarkerResourceManager", 1, "onARMarkerModelDownloadComplete  ");
          if ((paramArCloudConfigInfo.jdField_a_of_type_Int == BusinessInfo.jdField_a_of_type_Int) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo != null))
          {
            int k;
            if (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.jdField_b_of_type_JavaLangString))
            {
              k = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.jdField_b_of_type_JavaLangString.lastIndexOf("/");
              localObject1 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.jdField_b_of_type_JavaLangString.substring(k + 1);
              paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.e = (this.jdField_b_of_type_JavaLangString + "ar_marker_award/" + paramArCloudConfigInfo.jdField_a_of_type_Int + File.separator + MD5.toMD5(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.jdField_b_of_type_JavaLangString) + "_" + (String)localObject1);
            }
            if (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.jdField_a_of_type_JavaLangString))
            {
              k = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.jdField_a_of_type_JavaLangString.lastIndexOf("/");
              localObject1 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.jdField_a_of_type_JavaLangString.substring(k + 1);
              paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.f = (this.jdField_b_of_type_JavaLangString + "ar_marker_award/" + paramArCloudConfigInfo.jdField_a_of_type_Int + File.separator + MD5.toMD5(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.jdField_a_of_type_JavaLangString) + "_" + (String)localObject1);
            }
            if ((!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.e)) && (!new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.e).exists()))
            {
              localObject1 = new ARResourceDownload.DownloadInfo();
              ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 1;
              ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.jdField_b_of_type_JavaLangString;
              ((ARResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = MD5.toMD5(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.jdField_b_of_type_JavaLangString);
              ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.e;
              ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = false;
              localArrayList.add(localObject1);
              QLog.i("AREngine_ARMarkerResourceManager", 1, "logoFile not exists, download ....");
            }
            if ((!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.f)) && (!new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.f).exists()))
            {
              localObject1 = new ARResourceDownload.DownloadInfo();
              ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Int = 1;
              ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.jdField_a_of_type_JavaLangString;
              ((ARResourceDownload.DownloadInfo)localObject1).jdField_b_of_type_JavaLangString = MD5.toMD5(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.jdField_a_of_type_JavaLangString);
              ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.f;
              ((ARResourceDownload.DownloadInfo)localObject1).jdField_a_of_type_Boolean = false;
              localArrayList.add(localObject1);
              QLog.i("AREngine_ARMarkerResourceManager", 1, "bannerFile not exists, download ....");
            }
          }
          if ((paramARMarkerResourceCallback != null) && ((paramArCloudConfigInfo.a()) || (paramArCloudConfigInfo.b()))) {
            paramARMarkerResourceCallback.o();
          }
          if (localArrayList.size() <= 0) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.a(localArrayList, new aacn(this, paramARMarkerResourceCallback, paramArCloudConfigInfo, paramARCloudMarkerRecogResult));
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
          continue;
          if ((paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
          {
            localObject2 = new ArrayList();
            localIterator = paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
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
  
  /* Error */
  private void a(ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    // Byte code:
    //   0: ldc 176
    //   2: iconst_1
    //   3: ldc_w 356
    //   6: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: new 42	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 43	java/util/ArrayList:<init>	()V
    //   16: astore 6
    //   18: aload_2
    //   19: getfield 215	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArWebInfo	Lcom/tencent/mobileqq/ar/model/ArWebInfo;
    //   22: ifnull +98 -> 120
    //   25: aload_2
    //   26: getfield 215	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArWebInfo	Lcom/tencent/mobileqq/ar/model/ArWebInfo;
    //   29: invokevirtual 218	com/tencent/mobileqq/ar/model/ArWebInfo:a	()Z
    //   32: ifeq +88 -> 120
    //   35: new 75	java/io/File
    //   38: dup
    //   39: new 59	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   46: aload_0
    //   47: getfield 31	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   50: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 220
    //   55: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_2
    //   59: getfield 215	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArWebInfo	Lcom/tencent/mobileqq/ar/model/ArWebInfo;
    //   62: getfield 221	com/tencent/mobileqq/ar/model/ArWebInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   65: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: getstatic 224	java/io/File:separator	Ljava/lang/String;
    //   71: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   80: invokevirtual 124	java/io/File:exists	()Z
    //   83: ifne +37 -> 120
    //   86: new 191	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo
    //   89: dup
    //   90: invokespecial 192	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:<init>	()V
    //   93: astore_3
    //   94: aload_3
    //   95: iconst_4
    //   96: putfield 194	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Int	I
    //   99: aload_3
    //   100: aload_2
    //   101: getfield 215	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArWebInfo	Lcom/tencent/mobileqq/ar/model/ArWebInfo;
    //   104: getfield 221	com/tencent/mobileqq/ar/model/ArWebInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   107: invokestatic 235	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   110: putfield 196	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   113: aload 6
    //   115: aload_3
    //   116: invokevirtual 162	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   119: pop
    //   120: aload_2
    //   121: getfield 237	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:g	I
    //   124: iconst_1
    //   125: if_icmpne +103 -> 228
    //   128: aload_2
    //   129: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   132: ifnull +96 -> 228
    //   135: aload_2
    //   136: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   139: getfield 243	com/tencent/mobileqq/ar/model/ARRelationShip:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   142: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: ifne +83 -> 228
    //   148: new 75	java/io/File
    //   151: dup
    //   152: aload_2
    //   153: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   156: getfield 243	com/tencent/mobileqq/ar/model/ARRelationShip:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   159: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   162: invokevirtual 124	java/io/File:exists	()Z
    //   165: ifne +644 -> 809
    //   168: new 59	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   175: aload_0
    //   176: getfield 31	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   179: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: ldc_w 358
    //   185: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_2
    //   189: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   192: getfield 251	com/tencent/mobileqq/ar/model/ARRelationShip:c	Ljava/lang/String;
    //   195: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc 156
    //   200: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: astore_3
    //   207: new 75	java/io/File
    //   210: dup
    //   211: aload_3
    //   212: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   215: invokevirtual 124	java/io/File:exists	()Z
    //   218: ifeq +518 -> 736
    //   221: aload_3
    //   222: invokestatic 360	com/tencent/mobileqq/ar/arengine/ARResouceDir:c	()Ljava/lang/String;
    //   225: invokestatic 266	com/tencent/mobileqq/ar/arengine/ArResourceConfigUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload_2
    //   229: getfield 208	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_d_of_type_Int	I
    //   232: ifeq +12 -> 244
    //   235: aload_2
    //   236: getfield 208	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_d_of_type_Int	I
    //   239: bipush 7
    //   241: if_icmpne +174 -> 415
    //   244: aload_2
    //   245: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   248: ifnull +1190 -> 1438
    //   251: new 75	java/io/File
    //   254: dup
    //   255: aload_2
    //   256: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   259: getfield 131	com/tencent/mobileqq/ar/model/ArModelResource:f	Ljava/lang/String;
    //   262: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   265: astore_3
    //   266: aconst_null
    //   267: astore 5
    //   269: aload 5
    //   271: astore 4
    //   273: aload_3
    //   274: ifnull +23 -> 297
    //   277: aload 5
    //   279: astore 4
    //   281: aload_3
    //   282: invokevirtual 124	java/io/File:exists	()Z
    //   285: ifeq +12 -> 297
    //   288: aload_3
    //   289: invokevirtual 255	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   292: invokestatic 258	com/tencent/mobileqq/portal/PortalUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   295: astore 4
    //   297: aload_3
    //   298: ifnull +568 -> 866
    //   301: aload_3
    //   302: invokevirtual 124	java/io/File:exists	()Z
    //   305: ifeq +561 -> 866
    //   308: aload 4
    //   310: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   313: ifne +553 -> 866
    //   316: aload 4
    //   318: aload_2
    //   319: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   322: getfield 259	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   325: invokevirtual 171	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   328: ifeq +538 -> 866
    //   331: new 75	java/io/File
    //   334: dup
    //   335: aload_2
    //   336: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   339: getfield 131	com/tencent/mobileqq/ar/model/ArModelResource:f	Ljava/lang/String;
    //   342: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   345: astore_3
    //   346: aload_2
    //   347: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   350: getfield 131	com/tencent/mobileqq/ar/model/ArModelResource:f	Ljava/lang/String;
    //   353: new 59	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   360: aload_3
    //   361: invokevirtual 263	java/io/File:getParentFile	()Ljava/io/File;
    //   364: invokevirtual 255	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   367: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: getstatic 224	java/io/File:separator	Ljava/lang/String;
    //   373: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: aload_2
    //   377: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   380: getfield 259	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   383: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: getstatic 224	java/io/File:separator	Ljava/lang/String;
    //   389: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 266	com/tencent/mobileqq/ar/arengine/ArResourceConfigUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: aload_1
    //   399: iconst_1
    //   400: aload_2
    //   401: invokeinterface 362 3 0
    //   406: ldc 176
    //   408: iconst_1
    //   409: ldc_w 364
    //   412: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   415: aload_2
    //   416: getfield 132	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   419: ifnull +965 -> 1384
    //   422: aload_2
    //   423: getfield 132	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   426: invokevirtual 136	java/util/ArrayList:size	()I
    //   429: ifle +955 -> 1384
    //   432: new 42	java/util/ArrayList
    //   435: dup
    //   436: invokespecial 43	java/util/ArrayList:<init>	()V
    //   439: astore 4
    //   441: aload_2
    //   442: getfield 132	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   445: invokevirtual 140	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   448: astore 5
    //   450: aload 5
    //   452: invokeinterface 145 1 0
    //   457: ifeq +927 -> 1384
    //   460: aload 5
    //   462: invokeinterface 149 1 0
    //   467: checkcast 151	com/tencent/mobileqq/ar/model/ArVideoResourceInfo
    //   470: astore 7
    //   472: aload 7
    //   474: getfield 158	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:jdField_d_of_type_Int	I
    //   477: iconst_4
    //   478: if_icmpeq -28 -> 450
    //   481: new 75	java/io/File
    //   484: dup
    //   485: aload 7
    //   487: getfield 341	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:e	Ljava/lang/String;
    //   490: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   493: astore 8
    //   495: aconst_null
    //   496: astore_3
    //   497: aload 8
    //   499: invokevirtual 124	java/io/File:exists	()Z
    //   502: ifeq +12 -> 514
    //   505: aload 8
    //   507: invokevirtual 255	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   510: invokestatic 258	com/tencent/mobileqq/portal/PortalUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   513: astore_3
    //   514: aload 8
    //   516: invokevirtual 124	java/io/File:exists	()Z
    //   519: ifeq +22 -> 541
    //   522: aload_3
    //   523: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   526: ifne +15 -> 541
    //   529: aload_3
    //   530: aload 7
    //   532: getfield 154	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:c	Ljava/lang/String;
    //   535: invokevirtual 171	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   538: ifne -88 -> 450
    //   541: aload 4
    //   543: aload 7
    //   545: getfield 342	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   548: invokevirtual 345	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   551: ifne -101 -> 450
    //   554: new 191	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo
    //   557: dup
    //   558: invokespecial 192	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:<init>	()V
    //   561: astore_3
    //   562: aload_3
    //   563: iconst_3
    //   564: putfield 194	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Int	I
    //   567: aload_3
    //   568: aload 7
    //   570: getfield 342	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   573: putfield 196	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   576: aload_3
    //   577: aload 7
    //   579: getfield 154	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:c	Ljava/lang/String;
    //   582: putfield 197	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   585: aload_0
    //   586: aload 7
    //   588: getfield 346	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:jdField_a_of_type_Long	J
    //   591: ldc2_w 199
    //   594: ldiv
    //   595: putfield 338	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:f	J
    //   598: aload_3
    //   599: aload 7
    //   601: getfield 346	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:jdField_a_of_type_Long	J
    //   604: putfield 203	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Long	J
    //   607: aload_0
    //   608: aload_0
    //   609: getfield 212	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:j	J
    //   612: aload_0
    //   613: getfield 338	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:f	J
    //   616: ladd
    //   617: putfield 212	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:j	J
    //   620: aload_0
    //   621: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   624: putfield 340	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:h	J
    //   627: aload_3
    //   628: aload 7
    //   630: getfield 341	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:e	Ljava/lang/String;
    //   633: putfield 204	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:c	Ljava/lang/String;
    //   636: aload_3
    //   637: iconst_0
    //   638: putfield 207	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Boolean	Z
    //   641: aload 6
    //   643: aload_3
    //   644: invokevirtual 162	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   647: pop
    //   648: aload 4
    //   650: aload 7
    //   652: getfield 342	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   655: invokevirtual 162	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   658: pop
    //   659: goto -209 -> 450
    //   662: astore_3
    //   663: new 191	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo
    //   666: dup
    //   667: invokespecial 192	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:<init>	()V
    //   670: astore_3
    //   671: aload_3
    //   672: bipush 6
    //   674: putfield 194	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Int	I
    //   677: aload_3
    //   678: aload_2
    //   679: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   682: getfield 250	com/tencent/mobileqq/ar/model/ARRelationShip:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   685: putfield 196	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   688: aload_3
    //   689: aload_2
    //   690: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   693: getfield 251	com/tencent/mobileqq/ar/model/ARRelationShip:c	Ljava/lang/String;
    //   696: putfield 197	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   699: aload_3
    //   700: aload_2
    //   701: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   704: getfield 252	com/tencent/mobileqq/ar/model/ARRelationShip:jdField_a_of_type_Long	J
    //   707: putfield 203	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Long	J
    //   710: aload_3
    //   711: aload_2
    //   712: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   715: getfield 243	com/tencent/mobileqq/ar/model/ARRelationShip:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   718: putfield 204	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:c	Ljava/lang/String;
    //   721: aload_3
    //   722: iconst_1
    //   723: putfield 207	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Boolean	Z
    //   726: aload 6
    //   728: aload_3
    //   729: invokevirtual 162	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   732: pop
    //   733: goto -505 -> 228
    //   736: new 191	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo
    //   739: dup
    //   740: invokespecial 192	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:<init>	()V
    //   743: astore_3
    //   744: aload_3
    //   745: bipush 6
    //   747: putfield 194	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Int	I
    //   750: aload_3
    //   751: aload_2
    //   752: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   755: getfield 250	com/tencent/mobileqq/ar/model/ARRelationShip:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   758: putfield 196	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   761: aload_3
    //   762: aload_2
    //   763: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   766: getfield 251	com/tencent/mobileqq/ar/model/ARRelationShip:c	Ljava/lang/String;
    //   769: putfield 197	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   772: aload_3
    //   773: aload_2
    //   774: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   777: getfield 252	com/tencent/mobileqq/ar/model/ARRelationShip:jdField_a_of_type_Long	J
    //   780: putfield 203	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Long	J
    //   783: aload_3
    //   784: aload_2
    //   785: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   788: getfield 243	com/tencent/mobileqq/ar/model/ARRelationShip:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   791: putfield 204	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:c	Ljava/lang/String;
    //   794: aload_3
    //   795: iconst_1
    //   796: putfield 207	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Boolean	Z
    //   799: aload 6
    //   801: aload_3
    //   802: invokevirtual 162	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   805: pop
    //   806: goto -578 -> 228
    //   809: aload_2
    //   810: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   813: getfield 243	com/tencent/mobileqq/ar/model/ARRelationShip:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   816: invokestatic 360	com/tencent/mobileqq/ar/arengine/ARResouceDir:c	()Ljava/lang/String;
    //   819: invokestatic 266	com/tencent/mobileqq/ar/arengine/ArResourceConfigUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   822: goto -594 -> 228
    //   825: astore_3
    //   826: goto -598 -> 228
    //   829: astore_3
    //   830: new 75	java/io/File
    //   833: dup
    //   834: aload_2
    //   835: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   838: getfield 131	com/tencent/mobileqq/ar/model/ArModelResource:f	Ljava/lang/String;
    //   841: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   844: invokevirtual 329	java/io/File:delete	()Z
    //   847: pop
    //   848: ldc 176
    //   850: iconst_1
    //   851: ldc_w 366
    //   854: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   857: aload_1
    //   858: iconst_0
    //   859: aload_2
    //   860: invokeinterface 362 3 0
    //   865: return
    //   866: aload_2
    //   867: ifnull +399 -> 1266
    //   870: aload_2
    //   871: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   874: ifnull +392 -> 1266
    //   877: aload_2
    //   878: getfield 208	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_d_of_type_Int	I
    //   881: bipush 7
    //   883: if_icmpne +383 -> 1266
    //   886: ldc 29
    //   888: astore 4
    //   890: aload 4
    //   892: astore_3
    //   893: aload_2
    //   894: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   897: ifnull +55 -> 952
    //   900: aload 4
    //   902: astore_3
    //   903: aload_2
    //   904: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   907: getfield 259	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   910: ifnull +42 -> 952
    //   913: new 59	java/lang/StringBuilder
    //   916: dup
    //   917: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   920: aload_0
    //   921: getfield 31	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   924: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: ldc_w 358
    //   930: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: aload_2
    //   934: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   937: getfield 259	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   940: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: ldc 156
    //   945: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   951: astore_3
    //   952: new 59	java/lang/StringBuilder
    //   955: dup
    //   956: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   959: aload_0
    //   960: getfield 31	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   963: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: ldc_w 368
    //   969: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: aload_2
    //   973: getfield 208	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_d_of_type_Int	I
    //   976: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   979: getstatic 224	java/io/File:separator	Ljava/lang/String;
    //   982: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: aload_2
    //   986: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   989: getfield 259	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   992: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: getstatic 224	java/io/File:separator	Ljava/lang/String;
    //   998: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1004: astore 4
    //   1006: new 75	java/io/File
    //   1009: dup
    //   1010: aload_3
    //   1011: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   1014: invokevirtual 124	java/io/File:exists	()Z
    //   1017: ifeq +131 -> 1148
    //   1020: aload_3
    //   1021: aload 4
    //   1023: invokestatic 266	com/tencent/mobileqq/ar/arengine/ArResourceConfigUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1026: goto -611 -> 415
    //   1029: astore_3
    //   1030: aload_2
    //   1031: ifnull -616 -> 415
    //   1034: aload_2
    //   1035: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1038: ifnull -623 -> 415
    //   1041: new 191	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo
    //   1044: dup
    //   1045: invokespecial 192	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:<init>	()V
    //   1048: astore_3
    //   1049: aload_3
    //   1050: iconst_3
    //   1051: putfield 194	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Int	I
    //   1054: aload_3
    //   1055: aload_2
    //   1056: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1059: getfield 335	com/tencent/mobileqq/ar/model/ArModelResource:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1062: putfield 196	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1065: aload_3
    //   1066: aload_2
    //   1067: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1070: getfield 259	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1073: putfield 197	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1076: aload_0
    //   1077: aload_2
    //   1078: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1081: getfield 336	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_Long	J
    //   1084: ldc2_w 199
    //   1087: ldiv
    //   1088: putfield 338	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:f	J
    //   1091: aload_3
    //   1092: aload_2
    //   1093: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1096: getfield 336	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_Long	J
    //   1099: putfield 203	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Long	J
    //   1102: aload_0
    //   1103: aload_0
    //   1104: getfield 212	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:j	J
    //   1107: aload_0
    //   1108: getfield 338	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:f	J
    //   1111: ladd
    //   1112: putfield 212	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:j	J
    //   1115: aload_0
    //   1116: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   1119: putfield 340	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:h	J
    //   1122: aload_3
    //   1123: aload_2
    //   1124: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1127: getfield 131	com/tencent/mobileqq/ar/model/ArModelResource:f	Ljava/lang/String;
    //   1130: putfield 204	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:c	Ljava/lang/String;
    //   1133: aload_3
    //   1134: iconst_1
    //   1135: putfield 207	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Boolean	Z
    //   1138: aload 6
    //   1140: aload_3
    //   1141: invokevirtual 162	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1144: pop
    //   1145: goto -730 -> 415
    //   1148: aload_2
    //   1149: ifnull -734 -> 415
    //   1152: aload_2
    //   1153: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1156: ifnull -741 -> 415
    //   1159: new 191	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo
    //   1162: dup
    //   1163: invokespecial 192	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:<init>	()V
    //   1166: astore_3
    //   1167: aload_3
    //   1168: iconst_3
    //   1169: putfield 194	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Int	I
    //   1172: aload_3
    //   1173: aload_2
    //   1174: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1177: getfield 335	com/tencent/mobileqq/ar/model/ArModelResource:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1180: putfield 196	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1183: aload_3
    //   1184: aload_2
    //   1185: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1188: getfield 259	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1191: putfield 197	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1194: aload_0
    //   1195: aload_2
    //   1196: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1199: getfield 336	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_Long	J
    //   1202: ldc2_w 199
    //   1205: ldiv
    //   1206: putfield 338	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:f	J
    //   1209: aload_3
    //   1210: aload_2
    //   1211: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1214: getfield 336	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_Long	J
    //   1217: putfield 203	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Long	J
    //   1220: aload_0
    //   1221: aload_0
    //   1222: getfield 212	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:j	J
    //   1225: aload_0
    //   1226: getfield 338	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:f	J
    //   1229: ladd
    //   1230: putfield 212	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:j	J
    //   1233: aload_0
    //   1234: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   1237: putfield 340	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:h	J
    //   1240: aload_3
    //   1241: aload_2
    //   1242: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1245: getfield 131	com/tencent/mobileqq/ar/model/ArModelResource:f	Ljava/lang/String;
    //   1248: putfield 204	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:c	Ljava/lang/String;
    //   1251: aload_3
    //   1252: iconst_1
    //   1253: putfield 207	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Boolean	Z
    //   1256: aload 6
    //   1258: aload_3
    //   1259: invokevirtual 162	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1262: pop
    //   1263: goto -848 -> 415
    //   1266: aload_2
    //   1267: ifnull -852 -> 415
    //   1270: aload_2
    //   1271: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1274: ifnull -859 -> 415
    //   1277: new 191	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo
    //   1280: dup
    //   1281: invokespecial 192	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:<init>	()V
    //   1284: astore_3
    //   1285: aload_3
    //   1286: iconst_3
    //   1287: putfield 194	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Int	I
    //   1290: aload_3
    //   1291: aload_2
    //   1292: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1295: getfield 335	com/tencent/mobileqq/ar/model/ArModelResource:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1298: putfield 196	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1301: aload_3
    //   1302: aload_2
    //   1303: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1306: getfield 259	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1309: putfield 197	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1312: aload_0
    //   1313: aload_2
    //   1314: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1317: getfield 336	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_Long	J
    //   1320: ldc2_w 199
    //   1323: ldiv
    //   1324: putfield 338	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:f	J
    //   1327: aload_3
    //   1328: aload_2
    //   1329: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1332: getfield 336	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_Long	J
    //   1335: putfield 203	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Long	J
    //   1338: aload_0
    //   1339: aload_0
    //   1340: getfield 212	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:j	J
    //   1343: aload_0
    //   1344: getfield 338	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:f	J
    //   1347: ladd
    //   1348: putfield 212	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:j	J
    //   1351: aload_0
    //   1352: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   1355: putfield 340	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:h	J
    //   1358: aload_3
    //   1359: aload_2
    //   1360: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1363: getfield 131	com/tencent/mobileqq/ar/model/ArModelResource:f	Ljava/lang/String;
    //   1366: putfield 204	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:c	Ljava/lang/String;
    //   1369: aload_3
    //   1370: iconst_1
    //   1371: putfield 207	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Boolean	Z
    //   1374: aload 6
    //   1376: aload_3
    //   1377: invokevirtual 162	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1380: pop
    //   1381: goto -966 -> 415
    //   1384: aload_1
    //   1385: ifnull +16 -> 1401
    //   1388: aload_2
    //   1389: invokevirtual 315	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:b	()Z
    //   1392: ifeq +9 -> 1401
    //   1395: aload_1
    //   1396: invokeinterface 371 1 0
    //   1401: aload 6
    //   1403: invokevirtual 136	java/util/ArrayList:size	()I
    //   1406: ifle +23 -> 1429
    //   1409: aload_0
    //   1410: getfield 52	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools	Lcom/tencent/mobileqq/ar/arengine/ARResourceManagerTools;
    //   1413: aload 6
    //   1415: new 373	aaco
    //   1418: dup
    //   1419: aload_0
    //   1420: aload_1
    //   1421: aload_2
    //   1422: invokespecial 376	aaco:<init>	(Lcom/tencent/mobileqq/ar/arengine/ARMarkerResourceManager;Lcom/tencent/mobileqq/ar/arengine/ARMarkerResourceManager$ARMarkerResourceCallback;Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;)V
    //   1425: invokevirtual 326	com/tencent/mobileqq/ar/arengine/ARResourceManagerTools:a	(Ljava/util/ArrayList;Lcom/tencent/mobileqq/ar/arengine/ARResourceManagerTools$ARResourceCallback;)V
    //   1428: return
    //   1429: aload_1
    //   1430: iconst_1
    //   1431: aload_2
    //   1432: invokeinterface 362 3 0
    //   1437: return
    //   1438: aconst_null
    //   1439: astore_3
    //   1440: goto -1174 -> 266
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1443	0	this	ARMarkerResourceManager
    //   0	1443	1	paramARMarkerResourceCallback	ARMarkerResourceManager.ARMarkerResourceCallback
    //   0	1443	2	paramArCloudConfigInfo	ArCloudConfigInfo
    //   93	551	3	localObject1	Object
    //   662	1	3	localException1	Exception
    //   670	132	3	localDownloadInfo1	ARResourceDownload.DownloadInfo
    //   825	1	3	localException2	Exception
    //   829	1	3	localException3	Exception
    //   892	129	3	localObject2	Object
    //   1029	1	3	localException4	Exception
    //   1048	392	3	localDownloadInfo2	ARResourceDownload.DownloadInfo
    //   271	751	4	localObject3	Object
    //   267	194	5	localIterator	Iterator
    //   16	1398	6	localArrayList	ArrayList
    //   470	181	7	localArVideoResourceInfo	ArVideoResourceInfo
    //   493	22	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   221	228	662	java/lang/Exception
    //   809	822	825	java/lang/Exception
    //   331	415	829	java/lang/Exception
    //   1020	1026	1029	java/lang/Exception
  }
  
  private void a(boolean paramBoolean)
  {
    QLog.i("AREngine_ARMarkerResourceManager", 1, "checkAndDeleteExpiredResource  ");
    long l = System.currentTimeMillis();
    File[] arrayOfFile = new File(a()).listFiles();
    if (arrayOfFile == null) {}
    label417:
    for (;;)
    {
      return;
      int k = 0;
      for (;;)
      {
        if (k >= arrayOfFile.length) {
          break label417;
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
  
  private boolean a(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo == null) {
      return false;
    }
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null)
    {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c = (this.jdField_b_of_type_JavaLangString + "ar_cloud_marker_feature/" + paramArCloudConfigInfo.jdField_d_of_type_Int + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString + "_signature.db");
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + "ar_cloud_marker_model/" + paramArCloudConfigInfo.jdField_d_of_type_Int + File.separator);
    }
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f = (this.jdField_b_of_type_JavaLangString + "ar_cloud_marker_model/" + paramArCloudConfigInfo.jdField_d_of_type_Int + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + "_model.zip");
    }
    if ((paramArCloudConfigInfo.g == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c))) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + "ar_cloud_relationship/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c + "_relationship.zip");
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
  
  /* Error */
  private void b(ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    // Byte code:
    //   0: ldc 176
    //   2: iconst_1
    //   3: ldc_w 426
    //   6: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_2
    //   10: ifnonnull +4 -> 14
    //   13: return
    //   14: new 42	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 43	java/util/ArrayList:<init>	()V
    //   21: astore 6
    //   23: aload_2
    //   24: getfield 215	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArWebInfo	Lcom/tencent/mobileqq/ar/model/ArWebInfo;
    //   27: ifnull +98 -> 125
    //   30: aload_2
    //   31: getfield 215	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArWebInfo	Lcom/tencent/mobileqq/ar/model/ArWebInfo;
    //   34: invokevirtual 218	com/tencent/mobileqq/ar/model/ArWebInfo:a	()Z
    //   37: ifeq +88 -> 125
    //   40: new 75	java/io/File
    //   43: dup
    //   44: new 59	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   51: aload_0
    //   52: getfield 31	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   55: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 220
    //   60: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_2
    //   64: getfield 215	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArWebInfo	Lcom/tencent/mobileqq/ar/model/ArWebInfo;
    //   67: getfield 221	com/tencent/mobileqq/ar/model/ArWebInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   70: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: getstatic 224	java/io/File:separator	Ljava/lang/String;
    //   76: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   85: invokevirtual 124	java/io/File:exists	()Z
    //   88: ifne +37 -> 125
    //   91: new 191	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo
    //   94: dup
    //   95: invokespecial 192	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:<init>	()V
    //   98: astore_3
    //   99: aload_3
    //   100: iconst_4
    //   101: putfield 194	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Int	I
    //   104: aload_3
    //   105: aload_2
    //   106: getfield 215	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArWebInfo	Lcom/tencent/mobileqq/ar/model/ArWebInfo;
    //   109: getfield 221	com/tencent/mobileqq/ar/model/ArWebInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   112: invokestatic 235	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   115: putfield 196	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   118: aload 6
    //   120: aload_3
    //   121: invokevirtual 162	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   124: pop
    //   125: aload_2
    //   126: getfield 237	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:g	I
    //   129: iconst_1
    //   130: if_icmpne +103 -> 233
    //   133: aload_2
    //   134: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   137: ifnull +96 -> 233
    //   140: aload_2
    //   141: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   144: getfield 243	com/tencent/mobileqq/ar/model/ARRelationShip:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   147: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   150: ifne +83 -> 233
    //   153: new 75	java/io/File
    //   156: dup
    //   157: aload_2
    //   158: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   161: getfield 243	com/tencent/mobileqq/ar/model/ARRelationShip:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   164: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   167: invokevirtual 124	java/io/File:exists	()Z
    //   170: ifne +644 -> 814
    //   173: new 59	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   180: aload_0
    //   181: getfield 31	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   184: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc_w 358
    //   190: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_2
    //   194: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   197: getfield 251	com/tencent/mobileqq/ar/model/ARRelationShip:c	Ljava/lang/String;
    //   200: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: ldc 156
    //   205: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: astore_3
    //   212: new 75	java/io/File
    //   215: dup
    //   216: aload_3
    //   217: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   220: invokevirtual 124	java/io/File:exists	()Z
    //   223: ifeq +518 -> 741
    //   226: aload_3
    //   227: invokestatic 360	com/tencent/mobileqq/ar/arengine/ARResouceDir:c	()Ljava/lang/String;
    //   230: invokestatic 266	com/tencent/mobileqq/ar/arengine/ArResourceConfigUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload_2
    //   234: getfield 208	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_d_of_type_Int	I
    //   237: ifeq +12 -> 249
    //   240: aload_2
    //   241: getfield 208	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_d_of_type_Int	I
    //   244: bipush 7
    //   246: if_icmpne +174 -> 420
    //   249: aload_2
    //   250: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   253: ifnull +1190 -> 1443
    //   256: new 75	java/io/File
    //   259: dup
    //   260: aload_2
    //   261: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   264: getfield 131	com/tencent/mobileqq/ar/model/ArModelResource:f	Ljava/lang/String;
    //   267: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   270: astore_3
    //   271: aconst_null
    //   272: astore 5
    //   274: aload 5
    //   276: astore 4
    //   278: aload_3
    //   279: ifnull +23 -> 302
    //   282: aload 5
    //   284: astore 4
    //   286: aload_3
    //   287: invokevirtual 124	java/io/File:exists	()Z
    //   290: ifeq +12 -> 302
    //   293: aload_3
    //   294: invokevirtual 255	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   297: invokestatic 258	com/tencent/mobileqq/portal/PortalUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   300: astore 4
    //   302: aload_3
    //   303: ifnull +568 -> 871
    //   306: aload_3
    //   307: invokevirtual 124	java/io/File:exists	()Z
    //   310: ifeq +561 -> 871
    //   313: aload 4
    //   315: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   318: ifne +553 -> 871
    //   321: aload 4
    //   323: aload_2
    //   324: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   327: getfield 259	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   330: invokevirtual 171	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   333: ifeq +538 -> 871
    //   336: new 75	java/io/File
    //   339: dup
    //   340: aload_2
    //   341: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   344: getfield 131	com/tencent/mobileqq/ar/model/ArModelResource:f	Ljava/lang/String;
    //   347: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   350: astore_3
    //   351: aload_2
    //   352: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   355: getfield 131	com/tencent/mobileqq/ar/model/ArModelResource:f	Ljava/lang/String;
    //   358: new 59	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   365: aload_3
    //   366: invokevirtual 263	java/io/File:getParentFile	()Ljava/io/File;
    //   369: invokevirtual 255	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   372: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: getstatic 224	java/io/File:separator	Ljava/lang/String;
    //   378: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_2
    //   382: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   385: getfield 259	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   388: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: getstatic 224	java/io/File:separator	Ljava/lang/String;
    //   394: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 266	com/tencent/mobileqq/ar/arengine/ArResourceConfigUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   403: aload_1
    //   404: iconst_1
    //   405: aload_2
    //   406: invokeinterface 428 3 0
    //   411: ldc 176
    //   413: iconst_1
    //   414: ldc_w 430
    //   417: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   420: aload_2
    //   421: getfield 132	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   424: ifnull +965 -> 1389
    //   427: aload_2
    //   428: getfield 132	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   431: invokevirtual 136	java/util/ArrayList:size	()I
    //   434: ifle +955 -> 1389
    //   437: new 42	java/util/ArrayList
    //   440: dup
    //   441: invokespecial 43	java/util/ArrayList:<init>	()V
    //   444: astore 4
    //   446: aload_2
    //   447: getfield 132	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   450: invokevirtual 140	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   453: astore 5
    //   455: aload 5
    //   457: invokeinterface 145 1 0
    //   462: ifeq +927 -> 1389
    //   465: aload 5
    //   467: invokeinterface 149 1 0
    //   472: checkcast 151	com/tencent/mobileqq/ar/model/ArVideoResourceInfo
    //   475: astore 7
    //   477: aload 7
    //   479: getfield 158	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:jdField_d_of_type_Int	I
    //   482: iconst_4
    //   483: if_icmpeq -28 -> 455
    //   486: new 75	java/io/File
    //   489: dup
    //   490: aload 7
    //   492: getfield 341	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:e	Ljava/lang/String;
    //   495: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   498: astore 8
    //   500: aconst_null
    //   501: astore_3
    //   502: aload 8
    //   504: invokevirtual 124	java/io/File:exists	()Z
    //   507: ifeq +12 -> 519
    //   510: aload 8
    //   512: invokevirtual 255	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   515: invokestatic 258	com/tencent/mobileqq/portal/PortalUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   518: astore_3
    //   519: aload 8
    //   521: invokevirtual 124	java/io/File:exists	()Z
    //   524: ifeq +22 -> 546
    //   527: aload_3
    //   528: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   531: ifne +15 -> 546
    //   534: aload_3
    //   535: aload 7
    //   537: getfield 154	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:c	Ljava/lang/String;
    //   540: invokevirtual 171	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   543: ifne -88 -> 455
    //   546: aload 4
    //   548: aload 7
    //   550: getfield 342	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   553: invokevirtual 345	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   556: ifne -101 -> 455
    //   559: new 191	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo
    //   562: dup
    //   563: invokespecial 192	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:<init>	()V
    //   566: astore_3
    //   567: aload_3
    //   568: iconst_3
    //   569: putfield 194	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Int	I
    //   572: aload_3
    //   573: aload 7
    //   575: getfield 342	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   578: putfield 196	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   581: aload_3
    //   582: aload 7
    //   584: getfield 154	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:c	Ljava/lang/String;
    //   587: putfield 197	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   590: aload_0
    //   591: aload 7
    //   593: getfield 346	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:jdField_a_of_type_Long	J
    //   596: ldc2_w 199
    //   599: ldiv
    //   600: putfield 338	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:f	J
    //   603: aload_3
    //   604: aload 7
    //   606: getfield 346	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:jdField_a_of_type_Long	J
    //   609: putfield 203	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Long	J
    //   612: aload_0
    //   613: aload_0
    //   614: getfield 212	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:j	J
    //   617: aload_0
    //   618: getfield 338	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:f	J
    //   621: ladd
    //   622: putfield 212	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:j	J
    //   625: aload_0
    //   626: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   629: putfield 340	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:h	J
    //   632: aload_3
    //   633: aload 7
    //   635: getfield 341	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:e	Ljava/lang/String;
    //   638: putfield 204	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:c	Ljava/lang/String;
    //   641: aload_3
    //   642: iconst_0
    //   643: putfield 207	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Boolean	Z
    //   646: aload 6
    //   648: aload_3
    //   649: invokevirtual 162	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   652: pop
    //   653: aload 4
    //   655: aload 7
    //   657: getfield 342	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   660: invokevirtual 162	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   663: pop
    //   664: goto -209 -> 455
    //   667: astore_3
    //   668: new 191	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo
    //   671: dup
    //   672: invokespecial 192	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:<init>	()V
    //   675: astore_3
    //   676: aload_3
    //   677: bipush 6
    //   679: putfield 194	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Int	I
    //   682: aload_3
    //   683: aload_2
    //   684: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   687: getfield 250	com/tencent/mobileqq/ar/model/ARRelationShip:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   690: putfield 196	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   693: aload_3
    //   694: aload_2
    //   695: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   698: getfield 251	com/tencent/mobileqq/ar/model/ARRelationShip:c	Ljava/lang/String;
    //   701: putfield 197	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   704: aload_3
    //   705: aload_2
    //   706: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   709: getfield 252	com/tencent/mobileqq/ar/model/ARRelationShip:jdField_a_of_type_Long	J
    //   712: putfield 203	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Long	J
    //   715: aload_3
    //   716: aload_2
    //   717: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   720: getfield 243	com/tencent/mobileqq/ar/model/ARRelationShip:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   723: putfield 204	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:c	Ljava/lang/String;
    //   726: aload_3
    //   727: iconst_1
    //   728: putfield 207	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Boolean	Z
    //   731: aload 6
    //   733: aload_3
    //   734: invokevirtual 162	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   737: pop
    //   738: goto -505 -> 233
    //   741: new 191	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo
    //   744: dup
    //   745: invokespecial 192	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:<init>	()V
    //   748: astore_3
    //   749: aload_3
    //   750: bipush 6
    //   752: putfield 194	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Int	I
    //   755: aload_3
    //   756: aload_2
    //   757: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   760: getfield 250	com/tencent/mobileqq/ar/model/ARRelationShip:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   763: putfield 196	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   766: aload_3
    //   767: aload_2
    //   768: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   771: getfield 251	com/tencent/mobileqq/ar/model/ARRelationShip:c	Ljava/lang/String;
    //   774: putfield 197	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   777: aload_3
    //   778: aload_2
    //   779: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   782: getfield 252	com/tencent/mobileqq/ar/model/ARRelationShip:jdField_a_of_type_Long	J
    //   785: putfield 203	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Long	J
    //   788: aload_3
    //   789: aload_2
    //   790: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   793: getfield 243	com/tencent/mobileqq/ar/model/ARRelationShip:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   796: putfield 204	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:c	Ljava/lang/String;
    //   799: aload_3
    //   800: iconst_1
    //   801: putfield 207	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Boolean	Z
    //   804: aload 6
    //   806: aload_3
    //   807: invokevirtual 162	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   810: pop
    //   811: goto -578 -> 233
    //   814: aload_2
    //   815: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   818: getfield 243	com/tencent/mobileqq/ar/model/ARRelationShip:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   821: invokestatic 360	com/tencent/mobileqq/ar/arengine/ARResouceDir:c	()Ljava/lang/String;
    //   824: invokestatic 266	com/tencent/mobileqq/ar/arengine/ArResourceConfigUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   827: goto -594 -> 233
    //   830: astore_3
    //   831: goto -598 -> 233
    //   834: astore_3
    //   835: new 75	java/io/File
    //   838: dup
    //   839: aload_2
    //   840: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   843: getfield 131	com/tencent/mobileqq/ar/model/ArModelResource:f	Ljava/lang/String;
    //   846: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   849: invokevirtual 329	java/io/File:delete	()Z
    //   852: pop
    //   853: ldc 176
    //   855: iconst_1
    //   856: ldc_w 432
    //   859: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   862: aload_1
    //   863: iconst_0
    //   864: aload_2
    //   865: invokeinterface 428 3 0
    //   870: return
    //   871: aload_2
    //   872: ifnull +399 -> 1271
    //   875: aload_2
    //   876: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   879: ifnull +392 -> 1271
    //   882: aload_2
    //   883: getfield 208	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_d_of_type_Int	I
    //   886: bipush 7
    //   888: if_icmpne +383 -> 1271
    //   891: ldc 29
    //   893: astore 4
    //   895: aload 4
    //   897: astore_3
    //   898: aload_2
    //   899: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   902: ifnull +55 -> 957
    //   905: aload 4
    //   907: astore_3
    //   908: aload_2
    //   909: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   912: getfield 259	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   915: ifnull +42 -> 957
    //   918: new 59	java/lang/StringBuilder
    //   921: dup
    //   922: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   925: aload_0
    //   926: getfield 31	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   929: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   932: ldc_w 358
    //   935: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: aload_2
    //   939: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   942: getfield 259	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   945: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: ldc 156
    //   950: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   956: astore_3
    //   957: new 59	java/lang/StringBuilder
    //   960: dup
    //   961: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   964: aload_0
    //   965: getfield 31	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   968: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: ldc_w 368
    //   974: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: aload_2
    //   978: getfield 208	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_d_of_type_Int	I
    //   981: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   984: getstatic 224	java/io/File:separator	Ljava/lang/String;
    //   987: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   990: aload_2
    //   991: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   994: getfield 259	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   997: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1000: getstatic 224	java/io/File:separator	Ljava/lang/String;
    //   1003: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1009: astore 4
    //   1011: new 75	java/io/File
    //   1014: dup
    //   1015: aload_3
    //   1016: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   1019: invokevirtual 124	java/io/File:exists	()Z
    //   1022: ifeq +131 -> 1153
    //   1025: aload_3
    //   1026: aload 4
    //   1028: invokestatic 266	com/tencent/mobileqq/ar/arengine/ArResourceConfigUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1031: goto -611 -> 420
    //   1034: astore_3
    //   1035: aload_2
    //   1036: ifnull -616 -> 420
    //   1039: aload_2
    //   1040: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1043: ifnull -623 -> 420
    //   1046: new 191	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo
    //   1049: dup
    //   1050: invokespecial 192	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:<init>	()V
    //   1053: astore_3
    //   1054: aload_3
    //   1055: iconst_3
    //   1056: putfield 194	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Int	I
    //   1059: aload_3
    //   1060: aload_2
    //   1061: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1064: getfield 335	com/tencent/mobileqq/ar/model/ArModelResource:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1067: putfield 196	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1070: aload_3
    //   1071: aload_2
    //   1072: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1075: getfield 259	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1078: putfield 197	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1081: aload_0
    //   1082: aload_2
    //   1083: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1086: getfield 336	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_Long	J
    //   1089: ldc2_w 199
    //   1092: ldiv
    //   1093: putfield 338	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:f	J
    //   1096: aload_3
    //   1097: aload_2
    //   1098: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1101: getfield 336	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_Long	J
    //   1104: putfield 203	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Long	J
    //   1107: aload_0
    //   1108: aload_0
    //   1109: getfield 212	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:j	J
    //   1112: aload_0
    //   1113: getfield 338	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:f	J
    //   1116: ladd
    //   1117: putfield 212	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:j	J
    //   1120: aload_0
    //   1121: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   1124: putfield 340	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:h	J
    //   1127: aload_3
    //   1128: aload_2
    //   1129: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1132: getfield 131	com/tencent/mobileqq/ar/model/ArModelResource:f	Ljava/lang/String;
    //   1135: putfield 204	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:c	Ljava/lang/String;
    //   1138: aload_3
    //   1139: iconst_1
    //   1140: putfield 207	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Boolean	Z
    //   1143: aload 6
    //   1145: aload_3
    //   1146: invokevirtual 162	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1149: pop
    //   1150: goto -730 -> 420
    //   1153: aload_2
    //   1154: ifnull -734 -> 420
    //   1157: aload_2
    //   1158: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1161: ifnull -741 -> 420
    //   1164: new 191	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo
    //   1167: dup
    //   1168: invokespecial 192	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:<init>	()V
    //   1171: astore_3
    //   1172: aload_3
    //   1173: iconst_3
    //   1174: putfield 194	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Int	I
    //   1177: aload_3
    //   1178: aload_2
    //   1179: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1182: getfield 335	com/tencent/mobileqq/ar/model/ArModelResource:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1185: putfield 196	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1188: aload_3
    //   1189: aload_2
    //   1190: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1193: getfield 259	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1196: putfield 197	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1199: aload_0
    //   1200: aload_2
    //   1201: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1204: getfield 336	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_Long	J
    //   1207: ldc2_w 199
    //   1210: ldiv
    //   1211: putfield 338	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:f	J
    //   1214: aload_3
    //   1215: aload_2
    //   1216: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1219: getfield 336	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_Long	J
    //   1222: putfield 203	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Long	J
    //   1225: aload_0
    //   1226: aload_0
    //   1227: getfield 212	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:j	J
    //   1230: aload_0
    //   1231: getfield 338	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:f	J
    //   1234: ladd
    //   1235: putfield 212	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:j	J
    //   1238: aload_0
    //   1239: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   1242: putfield 340	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:h	J
    //   1245: aload_3
    //   1246: aload_2
    //   1247: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1250: getfield 131	com/tencent/mobileqq/ar/model/ArModelResource:f	Ljava/lang/String;
    //   1253: putfield 204	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:c	Ljava/lang/String;
    //   1256: aload_3
    //   1257: iconst_1
    //   1258: putfield 207	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Boolean	Z
    //   1261: aload 6
    //   1263: aload_3
    //   1264: invokevirtual 162	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1267: pop
    //   1268: goto -848 -> 420
    //   1271: aload_2
    //   1272: ifnull -852 -> 420
    //   1275: aload_2
    //   1276: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1279: ifnull -859 -> 420
    //   1282: new 191	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo
    //   1285: dup
    //   1286: invokespecial 192	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:<init>	()V
    //   1289: astore_3
    //   1290: aload_3
    //   1291: iconst_3
    //   1292: putfield 194	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Int	I
    //   1295: aload_3
    //   1296: aload_2
    //   1297: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1300: getfield 335	com/tencent/mobileqq/ar/model/ArModelResource:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1303: putfield 196	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1306: aload_3
    //   1307: aload_2
    //   1308: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1311: getfield 259	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1314: putfield 197	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1317: aload_0
    //   1318: aload_2
    //   1319: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1322: getfield 336	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_Long	J
    //   1325: ldc2_w 199
    //   1328: ldiv
    //   1329: putfield 338	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:f	J
    //   1332: aload_3
    //   1333: aload_2
    //   1334: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1337: getfield 336	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_Long	J
    //   1340: putfield 203	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Long	J
    //   1343: aload_0
    //   1344: aload_0
    //   1345: getfield 212	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:j	J
    //   1348: aload_0
    //   1349: getfield 338	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:f	J
    //   1352: ladd
    //   1353: putfield 212	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:j	J
    //   1356: aload_0
    //   1357: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   1360: putfield 340	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:h	J
    //   1363: aload_3
    //   1364: aload_2
    //   1365: getfield 127	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1368: getfield 131	com/tencent/mobileqq/ar/model/ArModelResource:f	Ljava/lang/String;
    //   1371: putfield 204	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:c	Ljava/lang/String;
    //   1374: aload_3
    //   1375: iconst_1
    //   1376: putfield 207	com/tencent/mobileqq/ar/arengine/ARResourceDownload$DownloadInfo:jdField_a_of_type_Boolean	Z
    //   1379: aload 6
    //   1381: aload_3
    //   1382: invokevirtual 162	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1385: pop
    //   1386: goto -966 -> 420
    //   1389: aload_1
    //   1390: ifnull +16 -> 1406
    //   1393: aload_2
    //   1394: invokevirtual 315	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:b	()Z
    //   1397: ifeq +9 -> 1406
    //   1400: aload_1
    //   1401: invokeinterface 435 1 0
    //   1406: aload 6
    //   1408: invokevirtual 136	java/util/ArrayList:size	()I
    //   1411: ifle +23 -> 1434
    //   1414: aload_0
    //   1415: getfield 52	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools	Lcom/tencent/mobileqq/ar/arengine/ARResourceManagerTools;
    //   1418: aload 6
    //   1420: new 437	aacp
    //   1423: dup
    //   1424: aload_0
    //   1425: aload_1
    //   1426: aload_2
    //   1427: invokespecial 438	aacp:<init>	(Lcom/tencent/mobileqq/ar/arengine/ARMarkerResourceManager;Lcom/tencent/mobileqq/ar/arengine/ARMarkerResourceManager$ARMarkerResourceCallback;Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;)V
    //   1430: invokevirtual 326	com/tencent/mobileqq/ar/arengine/ARResourceManagerTools:a	(Ljava/util/ArrayList;Lcom/tencent/mobileqq/ar/arengine/ARResourceManagerTools$ARResourceCallback;)V
    //   1433: return
    //   1434: aload_1
    //   1435: iconst_1
    //   1436: aload_2
    //   1437: invokeinterface 428 3 0
    //   1442: return
    //   1443: aconst_null
    //   1444: astore_3
    //   1445: goto -1174 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1448	0	this	ARMarkerResourceManager
    //   0	1448	1	paramARMarkerResourceCallback	ARMarkerResourceManager.ARMarkerResourceCallback
    //   0	1448	2	paramArCloudConfigInfo	ArCloudConfigInfo
    //   98	551	3	localObject1	Object
    //   667	1	3	localException1	Exception
    //   675	132	3	localDownloadInfo1	ARResourceDownload.DownloadInfo
    //   830	1	3	localException2	Exception
    //   834	1	3	localException3	Exception
    //   897	129	3	localObject2	Object
    //   1034	1	3	localException4	Exception
    //   1053	392	3	localDownloadInfo2	ARResourceDownload.DownloadInfo
    //   276	751	4	localObject3	Object
    //   272	194	5	localIterator	Iterator
    //   21	1398	6	localArrayList	ArrayList
    //   475	181	7	localArVideoResourceInfo	ArVideoResourceInfo
    //   498	22	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   226	233	667	java/lang/Exception
    //   814	827	830	java/lang/Exception
    //   336	420	834	java/lang/Exception
    //   1025	1031	1034	java/lang/Exception
  }
  
  private boolean b(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo == null) {
      return false;
    }
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + "ar_cloud_classfiy_model/" + paramArCloudConfigInfo.jdField_d_of_type_Int + File.separator);
    }
    if ((paramArCloudConfigInfo.g == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c))) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + "ar_cloud_relationship/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c + "_relationship.zip");
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
          localArVideoResourceInfo.e = (this.jdField_b_of_type_JavaLangString + "ar_cloud_classfiy_model/" + paramArCloudConfigInfo.jdField_d_of_type_Int + File.separator + localArVideoResourceInfo.c + "_model.zip");
        }
      }
    }
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f = (this.jdField_b_of_type_JavaLangString + "ar_cloud_classfiy_model/" + paramArCloudConfigInfo.jdField_d_of_type_Int + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + "_model.zip");
    }
    return true;
  }
  
  private boolean c(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo == null) {
      return false;
    }
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + "ar_cloud_scene_model/" + paramArCloudConfigInfo.jdField_d_of_type_Int + File.separator);
    }
    if ((paramArCloudConfigInfo.g == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c))) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + "ar_cloud_relationship/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c + "_relationship.zip");
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
          localArVideoResourceInfo.e = (this.jdField_b_of_type_JavaLangString + "ar_cloud_scene_model/" + paramArCloudConfigInfo.jdField_d_of_type_Int + File.separator + localArVideoResourceInfo.c + "_model.zip");
        }
      }
    }
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f = (this.jdField_b_of_type_JavaLangString + "ar_cloud_scene_model/" + paramArCloudConfigInfo.jdField_d_of_type_Int + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + "_model.zip");
    }
    return true;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools != null) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.b();
      }
      return;
    }
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
    do
    {
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
      if (((ArCloudConfigInfo)localObject).g != 1) {
        break;
      }
    } while (ARVideoUtil.a());
    File localFile = new File(ARResouceDir.b());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (Build.VERSION.SDK_INT >= 17) {
      HotVideoUtils.a(paramARCloudMarkerRecogResult.jdField_b_of_type_JavaLangString, 14.0F, this.jdField_a_of_type_AndroidContentContext, ARResouceDir.b(), "arcard.jpg");
    }
    while ((!paramBoolean) || ((((ArCloudConfigInfo)localObject).g == 1) && (((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_a_of_type_JavaLangString)) && (((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_a_of_type_JavaLangString.equals(???))))
    {
      QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig");
      a((ArCloudConfigInfo)localObject);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        a(paramARCloudMarkerRecogResult, paramARMarkerResourceCallback, (ArCloudConfigInfo)localObject);
        return true;
        if (!new File(paramARCloudMarkerRecogResult.jdField_b_of_type_JavaLangString).renameTo(new File(ARResouceDir.b() + "arcard.jpg"))) {
          continue;
        }
      }
    }
  }
  
  /* Error */
  public boolean a(ARCloudObjectClassifyCommonInterface arg1, ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_1
    //   7: invokeinterface 512 1 0
    //   12: astore 4
    //   14: aload 4
    //   16: ifnonnull +5 -> 21
    //   19: iconst_0
    //   20: ireturn
    //   21: new 90	java/lang/String
    //   24: dup
    //   25: aload 4
    //   27: ldc_w 413
    //   30: invokespecial 416	java/lang/String:<init>	([BLjava/lang/String;)V
    //   33: astore 4
    //   35: invokestatic 515	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   38: ifeq +30 -> 68
    //   41: ldc 176
    //   43: iconst_2
    //   44: new 59	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   51: ldc_w 458
    //   54: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload 4
    //   59: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: aload 4
    //   70: invokestatic 463	com/tencent/mobileqq/ar/arengine/ARCloudMarkerJsonParser:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   73: astore 4
    //   75: ldc 176
    //   77: iconst_1
    //   78: new 59	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 465
    //   88: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload 4
    //   93: invokevirtual 468	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: aload 4
    //   104: ifnonnull +37 -> 141
    //   107: iconst_0
    //   108: ireturn
    //   109: astore_1
    //   110: ldc 176
    //   112: iconst_1
    //   113: new 59	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 517
    //   123: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_1
    //   127: invokevirtual 424	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   130: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: iconst_0
    //   140: ireturn
    //   141: aload 4
    //   143: getfield 237	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:g	I
    //   146: iconst_1
    //   147: if_icmpne +160 -> 307
    //   150: getstatic 520	com/tencent/mobileqq/arcard/ARCardUtils:jdField_a_of_type_Boolean	Z
    //   153: ifeq +68 -> 221
    //   156: iconst_0
    //   157: istore 5
    //   159: getstatic 521	com/tencent/mobileqq/arcard/ARCardUtils:c	Ljava/lang/String;
    //   162: invokestatic 526	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   165: istore 6
    //   167: iload 6
    //   169: istore 5
    //   171: aconst_null
    //   172: ldc_w 528
    //   175: ldc 29
    //   177: ldc 29
    //   179: ldc_w 530
    //   182: ldc_w 530
    //   185: iload 5
    //   187: iconst_0
    //   188: ldc 29
    //   190: ldc 29
    //   192: ldc 29
    //   194: ldc 29
    //   196: invokestatic 535	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   199: invokestatic 476	com/tencent/mobileqq/ar/ARVideoUtil:a	()Z
    //   202: istore 7
    //   204: iload 7
    //   206: ifeq +45 -> 251
    //   209: iconst_0
    //   210: ireturn
    //   211: astore 8
    //   213: aload 8
    //   215: invokevirtual 538	java/lang/NumberFormatException:printStackTrace	()V
    //   218: goto -47 -> 171
    //   221: aconst_null
    //   222: ldc_w 528
    //   225: ldc 29
    //   227: ldc 29
    //   229: ldc_w 540
    //   232: ldc_w 540
    //   235: iconst_0
    //   236: iconst_0
    //   237: ldc 29
    //   239: ldc 29
    //   241: ldc 29
    //   243: ldc 29
    //   245: invokestatic 535	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   248: goto -49 -> 199
    //   251: new 75	java/io/File
    //   254: dup
    //   255: invokestatic 478	com/tencent/mobileqq/ar/arengine/ARResouceDir:b	()Ljava/lang/String;
    //   258: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   261: astore 8
    //   263: aload 8
    //   265: invokevirtual 124	java/io/File:exists	()Z
    //   268: ifne +9 -> 277
    //   271: aload 8
    //   273: invokevirtual 481	java/io/File:mkdirs	()Z
    //   276: pop
    //   277: getstatic 486	android/os/Build$VERSION:SDK_INT	I
    //   280: bipush 17
    //   282: if_icmplt +122 -> 404
    //   285: aload_1
    //   286: invokeinterface 541 1 0
    //   291: ldc_w 488
    //   294: aload_0
    //   295: getfield 56	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   298: invokestatic 478	com/tencent/mobileqq/ar/arengine/ARResouceDir:b	()Ljava/lang/String;
    //   301: ldc_w 490
    //   304: invokestatic 495	com/tencent/mobileqq/hotpic/HotVideoUtils:a	(Ljava/lang/String;FLandroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   307: iload_3
    //   308: ifeq +28 -> 336
    //   311: aload 4
    //   313: getfield 237	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:g	I
    //   316: iconst_1
    //   317: if_icmpne +177 -> 494
    //   320: aload 4
    //   322: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   325: ifnull +167 -> 492
    //   328: aload 4
    //   330: invokevirtual 315	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:b	()Z
    //   333: ifeq +159 -> 492
    //   336: aload_0
    //   337: aload 4
    //   339: invokespecial 543	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:b	(Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;)Z
    //   342: pop
    //   343: invokestatic 546	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   346: ifeq +26 -> 372
    //   349: aload 4
    //   351: getfield 547	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_c_of_type_Int	I
    //   354: ifne +18 -> 372
    //   357: invokestatic 553	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   360: new 555	aacl
    //   363: dup
    //   364: aload_0
    //   365: invokespecial 558	aacl:<init>	(Lcom/tencent/mobileqq/ar/arengine/ARMarkerResourceManager;)V
    //   368: invokevirtual 564	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   371: pop
    //   372: aload 4
    //   374: iconst_1
    //   375: aload 4
    //   377: getfield 547	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_c_of_type_Int	I
    //   380: invokestatic 570	java/lang/Math:max	(II)I
    //   383: putfield 547	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_c_of_type_Int	I
    //   386: aload_0
    //   387: getfield 33	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   390: astore_1
    //   391: aload_1
    //   392: monitorenter
    //   393: aload_0
    //   394: aload_2
    //   395: aload 4
    //   397: invokespecial 572	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:a	(Lcom/tencent/mobileqq/ar/arengine/ARMarkerResourceManager$ARMarkerResourceCallback;Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;)V
    //   400: aload_1
    //   401: monitorexit
    //   402: iconst_1
    //   403: ireturn
    //   404: new 75	java/io/File
    //   407: dup
    //   408: aload_1
    //   409: invokeinterface 541 1 0
    //   414: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   417: new 75	java/io/File
    //   420: dup
    //   421: new 59	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   428: invokestatic 478	com/tencent/mobileqq/ar/arengine/ARResouceDir:b	()Ljava/lang/String;
    //   431: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc_w 490
    //   437: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   446: invokevirtual 504	java/io/File:renameTo	(Ljava/io/File;)Z
    //   449: istore 7
    //   451: iload 7
    //   453: ifeq -146 -> 307
    //   456: goto -149 -> 307
    //   459: astore_1
    //   460: ldc 176
    //   462: iconst_1
    //   463: new 59	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   470: ldc_w 574
    //   473: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload_1
    //   477: invokevirtual 473	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   480: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   489: goto -182 -> 307
    //   492: iconst_0
    //   493: ireturn
    //   494: iconst_0
    //   495: ireturn
    //   496: astore_2
    //   497: aload_1
    //   498: monitorexit
    //   499: aload_2
    //   500: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	501	0	this	ARMarkerResourceManager
    //   0	501	2	paramARMarkerResourceCallback	ARMarkerResourceManager.ARMarkerResourceCallback
    //   0	501	3	paramBoolean	boolean
    //   0	501	4	paramString	String
    //   157	29	5	k	int
    //   165	3	6	m	int
    //   202	250	7	bool	boolean
    //   211	3	8	localNumberFormatException	java.lang.NumberFormatException
    //   261	11	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   21	68	109	java/io/UnsupportedEncodingException
    //   68	75	109	java/io/UnsupportedEncodingException
    //   159	167	211	java/lang/NumberFormatException
    //   199	204	459	java/lang/Exception
    //   251	277	459	java/lang/Exception
    //   277	307	459	java/lang/Exception
    //   404	451	459	java/lang/Exception
    //   393	402	496	finally
    //   497	499	496	finally
  }
  
  /* Error */
  public boolean a(ARCloudSceneRecogResult arg1, ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_1
    //   7: invokevirtual 578	com/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult:a	()[B
    //   10: astore 4
    //   12: aload 4
    //   14: ifnull -10 -> 4
    //   17: new 90	java/lang/String
    //   20: dup
    //   21: aload 4
    //   23: ldc_w 413
    //   26: invokespecial 416	java/lang/String:<init>	([BLjava/lang/String;)V
    //   29: astore 4
    //   31: invokestatic 515	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +30 -> 64
    //   37: ldc 176
    //   39: iconst_2
    //   40: new 59	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   47: ldc_w 580
    //   50: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload 4
    //   55: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload 4
    //   66: invokestatic 463	com/tencent/mobileqq/ar/arengine/ARCloudMarkerJsonParser:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   69: astore 4
    //   71: ldc 176
    //   73: iconst_1
    //   74: new 59	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 582
    //   84: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload 4
    //   89: invokevirtual 468	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload 4
    //   100: ifnull -96 -> 4
    //   103: aload 4
    //   105: getfield 237	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:g	I
    //   108: iconst_1
    //   109: if_icmpne +76 -> 185
    //   112: getstatic 520	com/tencent/mobileqq/arcard/ARCardUtils:jdField_a_of_type_Boolean	Z
    //   115: ifeq +10 -> 125
    //   118: getstatic 521	com/tencent/mobileqq/arcard/ARCardUtils:c	Ljava/lang/String;
    //   121: invokestatic 526	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   124: pop
    //   125: invokestatic 476	com/tencent/mobileqq/ar/ARVideoUtil:a	()Z
    //   128: ifne -124 -> 4
    //   131: new 75	java/io/File
    //   134: dup
    //   135: invokestatic 478	com/tencent/mobileqq/ar/arengine/ARResouceDir:b	()Ljava/lang/String;
    //   138: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   141: astore 6
    //   143: aload 6
    //   145: invokevirtual 124	java/io/File:exists	()Z
    //   148: ifne +9 -> 157
    //   151: aload 6
    //   153: invokevirtual 481	java/io/File:mkdirs	()Z
    //   156: pop
    //   157: getstatic 486	android/os/Build$VERSION:SDK_INT	I
    //   160: bipush 17
    //   162: if_icmplt +162 -> 324
    //   165: aload_1
    //   166: invokevirtual 583	com/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult:a	()Ljava/lang/String;
    //   169: ldc_w 488
    //   172: aload_0
    //   173: getfield 56	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   176: invokestatic 478	com/tencent/mobileqq/ar/arengine/ARResouceDir:b	()Ljava/lang/String;
    //   179: ldc_w 490
    //   182: invokestatic 495	com/tencent/mobileqq/hotpic/HotVideoUtils:a	(Ljava/lang/String;FLandroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   185: iload_3
    //   186: ifeq +28 -> 214
    //   189: aload 4
    //   191: getfield 237	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:g	I
    //   194: iconst_1
    //   195: if_icmpne -191 -> 4
    //   198: aload 4
    //   200: getfield 240	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelARRelationShip	Lcom/tencent/mobileqq/ar/model/ARRelationShip;
    //   203: ifnull -199 -> 4
    //   206: aload 4
    //   208: invokevirtual 315	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:b	()Z
    //   211: ifeq -207 -> 4
    //   214: aload_0
    //   215: aload 4
    //   217: invokespecial 585	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:c	(Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;)Z
    //   220: pop
    //   221: invokestatic 546	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   224: ifeq +26 -> 250
    //   227: aload 4
    //   229: getfield 547	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_c_of_type_Int	I
    //   232: ifne +18 -> 250
    //   235: invokestatic 553	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   238: new 587	aacm
    //   241: dup
    //   242: aload_0
    //   243: invokespecial 588	aacm:<init>	(Lcom/tencent/mobileqq/ar/arengine/ARMarkerResourceManager;)V
    //   246: invokevirtual 564	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   249: pop
    //   250: aload 4
    //   252: iconst_1
    //   253: aload 4
    //   255: getfield 547	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_c_of_type_Int	I
    //   258: invokestatic 570	java/lang/Math:max	(II)I
    //   261: putfield 547	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_c_of_type_Int	I
    //   264: aload_0
    //   265: getfield 33	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   268: astore_1
    //   269: aload_1
    //   270: monitorenter
    //   271: aload_0
    //   272: aload_2
    //   273: aload 4
    //   275: invokespecial 590	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:b	(Lcom/tencent/mobileqq/ar/arengine/ARMarkerResourceManager$ARMarkerResourceCallback;Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;)V
    //   278: aload_1
    //   279: monitorexit
    //   280: iconst_1
    //   281: ireturn
    //   282: astore_1
    //   283: ldc 176
    //   285: iconst_1
    //   286: new 59	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   293: ldc_w 592
    //   296: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_1
    //   300: invokevirtual 424	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   303: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: iconst_0
    //   313: ireturn
    //   314: astore 6
    //   316: aload 6
    //   318: invokevirtual 538	java/lang/NumberFormatException:printStackTrace	()V
    //   321: goto -196 -> 125
    //   324: new 75	java/io/File
    //   327: dup
    //   328: aload_1
    //   329: invokevirtual 583	com/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult:a	()Ljava/lang/String;
    //   332: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   335: new 75	java/io/File
    //   338: dup
    //   339: new 59	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   346: invokestatic 478	com/tencent/mobileqq/ar/arengine/ARResouceDir:b	()Ljava/lang/String;
    //   349: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: ldc_w 490
    //   355: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   364: invokevirtual 504	java/io/File:renameTo	(Ljava/io/File;)Z
    //   367: istore 5
    //   369: iload 5
    //   371: ifeq -186 -> 185
    //   374: goto -189 -> 185
    //   377: astore_1
    //   378: ldc 176
    //   380: iconst_1
    //   381: new 59	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   388: ldc_w 574
    //   391: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload_1
    //   395: invokevirtual 473	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   398: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   407: goto -222 -> 185
    //   410: astore_2
    //   411: aload_1
    //   412: monitorexit
    //   413: aload_2
    //   414: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	415	0	this	ARMarkerResourceManager
    //   0	415	2	paramARMarkerResourceCallback	ARMarkerResourceManager.ARMarkerResourceCallback
    //   0	415	3	paramBoolean	boolean
    //   0	415	4	paramString	String
    //   367	3	5	bool	boolean
    //   141	11	6	localFile	File
    //   314	3	6	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   17	64	282	java/io/UnsupportedEncodingException
    //   64	71	282	java/io/UnsupportedEncodingException
    //   118	125	314	java/lang/NumberFormatException
    //   125	157	377	java/lang/Exception
    //   157	185	377	java/lang/Exception
    //   324	369	377	java/lang/Exception
    //   271	280	410	finally
    //   411	413	410	finally
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.c();
    }
  }
  
  public void c()
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
  
  public void d()
  {
    QLog.i("AREngine_ARMarkerResourceManager", 1, "arCloudDownloadReport start.");
    ARReport.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Long, this.jdField_d_of_type_Long, this.jdField_a_of_type_Int, this.f, this.g, this.jdField_b_of_type_Int, this.i, this.jdField_c_of_type_Int, this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, this.j, this.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager
 * JD-Core Version:    0.7.0.1
 */