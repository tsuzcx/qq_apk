import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager.1;
import com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager.2;
import com.tencent.mobileqq.ar.model.ARRelationShip;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class amyt
{
  private static String jdField_b_of_type_JavaLangString = "";
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  private amzn jdField_a_of_type_Amzn;
  private Context jdField_a_of_type_AndroidContentContext;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  Object jdField_a_of_type_JavaLangObject = new Object();
  String jdField_a_of_type_JavaLangString = null;
  private ArrayList<ArCloudConfigInfo> jdField_a_of_type_JavaUtilArrayList;
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
  
  public amyt(AppInterface paramAppInterface, Context paramContext)
  {
    jdField_b_of_type_JavaLangString = amzh.a();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Amzn = new amzn(paramAppInterface);
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
      jdField_b_of_type_JavaLangString = amzh.a();
    }
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
      localObject1 = amzr.a((String)localObject2, (String)localObject3);
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
  
  private void a(amwo paramamwo, amyx paramamyx, ArCloudConfigInfo paramArCloudConfigInfo)
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
      localObject1 = new amzm();
      ((amzm)localObject1).jdField_a_of_type_Int = 2;
      ((amzm)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_b_of_type_JavaLangString;
      ((amzm)localObject1).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString;
      this.jdField_c_of_type_Long = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_Long / 8192L);
      ((amzm)localObject1).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_Long;
      ((amzm)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c;
      ((amzm)localObject1).jdField_a_of_type_Boolean = false;
      this.jdField_c_of_type_Int = paramArCloudConfigInfo.jdField_d_of_type_Int;
      this.j += this.jdField_c_of_type_Long;
      localArrayList.add(localObject1);
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.a()))
    {
      localObject1 = new File(jdField_b_of_type_JavaLangString + "pddata/app/offline/html5/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString + File.separator);
      QLog.i("AREngine_ARMarkerResourceManager", 1, "offlie  " + ncb.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString));
      if ((!((File)localObject1).exists()) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString)))
      {
        localObject1 = new amzm();
        ((amzm)localObject1).jdField_a_of_type_Int = 4;
        ((amzm)localObject1).jdField_a_of_type_JavaLangString = String.valueOf(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString);
        localArrayList.add(localObject1);
      }
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_Amos != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_Amos.c)))
    {
      if (!new File(paramArCloudConfigInfo.jdField_a_of_type_Amos.c).exists())
      {
        localObject1 = new amzm();
        ((amzm)localObject1).jdField_a_of_type_Int = 7;
        ((amzm)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_Amos.jdField_a_of_type_JavaLangString;
        ((amzm)localObject1).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_Amos.jdField_b_of_type_JavaLangString;
        ((amzm)localObject1).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_Amos.jdField_a_of_type_Long;
        ((amzm)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_Amos.c;
        ((amzm)localObject1).jdField_a_of_type_Boolean = true;
        localArrayList.add(localObject1);
      }
    }
    else
    {
      if ((paramArCloudConfigInfo.g == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString)) && (!new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString).exists()))
      {
        localObject1 = new amzm();
        ((amzm)localObject1).jdField_a_of_type_Int = 6;
        ((amzm)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_b_of_type_JavaLangString;
        ((amzm)localObject1).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c;
        ((amzm)localObject1).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_a_of_type_Long;
        ((amzm)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString;
        ((amzm)localObject1).jdField_a_of_type_Boolean = true;
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
          localObject3 = awiz.a(((File)localObject1).getAbsolutePath());
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
            amzr.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f, ((File)localObject1).getParentFile().getAbsolutePath() + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + File.separator);
            paramamyx.a(true, 3, paramArCloudConfigInfo);
            QLog.i("AREngine_ARMarkerResourceManager", 1, "onARMarkerModelDownloadComplete  ");
            if ((paramamyx != null) && ((paramArCloudConfigInfo.a()) || (paramArCloudConfigInfo.b()))) {
              paramamyx.d();
            }
            if (localArrayList.size() <= 0) {
              break label1323;
            }
            this.jdField_a_of_type_Amzn.a(localArrayList, new amyu(this, paramamyx, paramArCloudConfigInfo, paramamwo));
            return;
          }
          catch (Exception paramamwo)
          {
            new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f).delete();
            QLog.i("AREngine_ARMarkerResourceManager", 1, "Download end. uncompressZip error. url = ");
            paramamyx.a(false, 3, paramArCloudConfigInfo);
            QLog.i("AREngine_ARMarkerResourceManager", 1, "onARMarkerModelDownloadComplete  ");
            paramamyx.a(false, paramArCloudConfigInfo);
            return;
          }
          try
          {
            amzr.a(paramArCloudConfigInfo.jdField_a_of_type_Amos.c, amzh.a(paramArCloudConfigInfo.jdField_a_of_type_Amos.jdField_b_of_type_JavaLangString));
          }
          catch (Exception localException) {}
        }
        break;
        if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
        {
          localObject2 = new amzm();
          ((amzm)localObject2).jdField_a_of_type_Int = 3;
          ((amzm)localObject2).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
          ((amzm)localObject2).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
          this.f = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long / 8192L);
          ((amzm)localObject2).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
          this.j += this.f;
          this.h = System.currentTimeMillis();
          ((amzm)localObject2).c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
          ((amzm)localObject2).jdField_a_of_type_Boolean = true;
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
                  localObject2 = awiz.a(localFile.getAbsolutePath());
                }
                if (((!localFile.exists()) || (TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(localArVideoResourceInfo.c))) && (!((ArrayList)localObject3).contains(localArVideoResourceInfo.jdField_d_of_type_JavaLangString)))
                {
                  localObject2 = new amzm();
                  ((amzm)localObject2).jdField_a_of_type_Int = 3;
                  ((amzm)localObject2).jdField_a_of_type_JavaLangString = localArVideoResourceInfo.jdField_d_of_type_JavaLangString;
                  ((amzm)localObject2).jdField_b_of_type_JavaLangString = localArVideoResourceInfo.c;
                  this.f = (localArVideoResourceInfo.jdField_a_of_type_Long / 8192L);
                  ((amzm)localObject2).jdField_a_of_type_Long = localArVideoResourceInfo.jdField_a_of_type_Long;
                  this.j += this.f;
                  this.h = System.currentTimeMillis();
                  ((amzm)localObject2).c = localArVideoResourceInfo.e;
                  ((amzm)localObject2).jdField_a_of_type_Boolean = false;
                  localArrayList.add(localObject2);
                  ((ArrayList)localObject3).add(localArVideoResourceInfo.jdField_d_of_type_JavaLangString);
                }
              }
            }
          }
        }
      }
      paramamyx.a(true, paramArCloudConfigInfo);
      if (paramArCloudConfigInfo.jdField_b_of_type_Int != 1) {
        a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, paramamwo);
      }
      a(paramArCloudConfigInfo);
      return;
    }
  }
  
  private void a(amyx paramamyx, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadObjectModelResources");
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.a()) && (!new File(jdField_b_of_type_JavaLangString + "pddata/app/offline/html5/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString + File.separator).exists()) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString)))
    {
      localObject1 = new amzm();
      ((amzm)localObject1).jdField_a_of_type_Int = 4;
      ((amzm)localObject1).jdField_a_of_type_JavaLangString = String.valueOf(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString);
      localArrayList.add(localObject1);
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_Amos != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_Amos.c)))
    {
      if (!new File(paramArCloudConfigInfo.jdField_a_of_type_Amos.c).exists())
      {
        localObject1 = new amzm();
        ((amzm)localObject1).jdField_a_of_type_Int = 7;
        ((amzm)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_Amos.jdField_a_of_type_JavaLangString;
        ((amzm)localObject1).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_Amos.jdField_b_of_type_JavaLangString;
        ((amzm)localObject1).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_Amos.jdField_a_of_type_Long;
        ((amzm)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_Amos.c;
        ((amzm)localObject1).jdField_a_of_type_Boolean = true;
        localArrayList.add(localObject1);
      }
    }
    else if ((paramArCloudConfigInfo.g == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString)))
    {
      if (new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString).exists()) {
        break label966;
      }
      localObject1 = jdField_b_of_type_JavaLangString + "ar_model/0/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c + "_model.zip";
      if (!new File((String)localObject1).exists()) {
        break label893;
      }
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        amzr.a((String)localObject1, amzh.b());
        if ((paramArCloudConfigInfo.jdField_d_of_type_Int == 0) || (paramArCloudConfigInfo.jdField_d_of_type_Int == 7) || (paramArCloudConfigInfo.jdField_d_of_type_Int == 8))
        {
          if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) {
            break label1593;
          }
          localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);
          localIterator = null;
          localObject3 = localIterator;
          if (localObject1 != null)
          {
            localObject3 = localIterator;
            if (((File)localObject1).exists()) {
              localObject3 = awiz.a(((File)localObject1).getAbsolutePath());
            }
          }
          if ((localObject1 == null) || (!((File)localObject1).exists()) || (TextUtils.isEmpty((CharSequence)localObject3)) || (!((String)localObject3).equals(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString))) {
            break label1023;
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
            amzr.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f, ((File)localObject1).getParentFile().getAbsolutePath() + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + File.separator);
            paramamyx.b(true, paramArCloudConfigInfo);
            QLog.i("AREngine_ARMarkerResourceManager", 1, "onARObjectClassifyDownloadComplete.");
            if ((paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList == null) || (paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
              break label1539;
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
                  localObject1 = awiz.a(localFile.getAbsolutePath());
                }
                if (((!localFile.exists()) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(localArVideoResourceInfo.c))) && (!((ArrayList)localObject3).contains(localArVideoResourceInfo.jdField_d_of_type_JavaLangString)))
                {
                  localObject1 = new amzm();
                  ((amzm)localObject1).jdField_a_of_type_Int = 3;
                  ((amzm)localObject1).jdField_a_of_type_JavaLangString = localArVideoResourceInfo.jdField_d_of_type_JavaLangString;
                  ((amzm)localObject1).jdField_b_of_type_JavaLangString = localArVideoResourceInfo.c;
                  this.f = (localArVideoResourceInfo.jdField_a_of_type_Long / 8192L);
                  ((amzm)localObject1).jdField_a_of_type_Long = localArVideoResourceInfo.jdField_a_of_type_Long;
                  this.j += this.f;
                  this.h = System.currentTimeMillis();
                  ((amzm)localObject1).c = localArVideoResourceInfo.e;
                  ((amzm)localObject1).jdField_a_of_type_Boolean = false;
                  localArrayList.add(localObject1);
                  ((ArrayList)localObject3).add(localArVideoResourceInfo.jdField_d_of_type_JavaLangString);
                }
              }
            }
            try
            {
              amzr.a(paramArCloudConfigInfo.jdField_a_of_type_Amos.c, amzh.a(paramArCloudConfigInfo.jdField_a_of_type_Amos.jdField_b_of_type_JavaLangString));
            }
            catch (Exception localException1) {}
          }
        }
        catch (Exception localException4)
        {
          amzm localamzm1;
          new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f).delete();
          QLog.i("AREngine_ARMarkerResourceManager", 1, "onARObjectClassifyDownloadComplete. uncompressZip error.");
          paramamyx.b(false, paramArCloudConfigInfo);
          return;
        }
        localException2 = localException2;
        localamzm1 = new amzm();
        localamzm1.jdField_a_of_type_Int = 6;
        localamzm1.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_b_of_type_JavaLangString;
        localamzm1.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c;
        localamzm1.jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_a_of_type_Long;
        localamzm1.c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString;
        localamzm1.jdField_a_of_type_Boolean = true;
        localArrayList.add(localamzm1);
        continue;
      }
      label893:
      localamzm1 = new amzm();
      localamzm1.jdField_a_of_type_Int = 6;
      localamzm1.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_b_of_type_JavaLangString;
      localamzm1.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c;
      localamzm1.jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_a_of_type_Long;
      localamzm1.c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString;
      localamzm1.jdField_a_of_type_Boolean = true;
      localArrayList.add(localamzm1);
      continue;
      try
      {
        label966:
        amzr.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString, amzh.b());
      }
      catch (Exception localException3) {}
      continue;
      label1023:
      amzm localamzm2;
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
            amzr.a((String)localObject2, (String)localObject3);
          }
          catch (Exception localException5) {}
          if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
          {
            localamzm2 = new amzm();
            localamzm2.jdField_a_of_type_Int = 3;
            localamzm2.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
            localamzm2.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
            this.f = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long / 8192L);
            localamzm2.jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
            this.j += this.f;
            this.h = System.currentTimeMillis();
            localamzm2.c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
            localamzm2.jdField_a_of_type_Boolean = true;
            localArrayList.add(localamzm2);
          }
        }
        else if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
        {
          localamzm2 = new amzm();
          localamzm2.jdField_a_of_type_Int = 3;
          localamzm2.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
          localamzm2.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
          this.f = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long / 8192L);
          localamzm2.jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
          this.j += this.f;
          this.h = System.currentTimeMillis();
          localamzm2.c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
          localamzm2.jdField_a_of_type_Boolean = true;
          localArrayList.add(localamzm2);
        }
      }
      else if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
      {
        localamzm2 = new amzm();
        localamzm2.jdField_a_of_type_Int = 3;
        localamzm2.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
        localamzm2.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
        this.f = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long / 8192L);
        localamzm2.jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
        this.j += this.f;
        this.h = System.currentTimeMillis();
        localamzm2.c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
        localamzm2.jdField_a_of_type_Boolean = true;
        localArrayList.add(localamzm2);
        continue;
        label1539:
        if ((paramamyx != null) && (paramArCloudConfigInfo.b())) {
          paramamyx.e();
        }
        if (localArrayList.size() > 0)
        {
          this.jdField_a_of_type_Amzn.a(localArrayList, new amyv(this, paramamyx, paramArCloudConfigInfo));
          return;
        }
        paramamyx.b(true, paramArCloudConfigInfo);
        return;
        label1593:
        localamzm2 = null;
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
          ArCloudConfigInfo localArCloudConfigInfo = amzr.a(a(), ((File)localObject1).getName());
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
    if ((paramArCloudConfigInfo.c()) && (paramArCloudConfigInfo.jdField_a_of_type_Amos != null)) {
      paramArCloudConfigInfo.jdField_a_of_type_Amos.c = (jdField_b_of_type_JavaLangString + "ar_cloud_transfer/" + paramArCloudConfigInfo.jdField_a_of_type_Amos.jdField_b_of_type_JavaLangString + ".zip");
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)localIterator.next();
        if (localArVideoResourceInfo.jdField_d_of_type_Int == 4) {
          localArVideoResourceInfo.e = anby.a(localArVideoResourceInfo.jdField_d_of_type_JavaLangString);
        } else if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null) {
          localArVideoResourceInfo.e = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString + localArVideoResourceInfo.c + "_model.zip");
        }
      }
    }
    return true;
  }
  
  private boolean a(String paramString, amwo paramamwo)
  {
    if (paramamwo == null) {
      return false;
    }
    try
    {
      paramamwo = new String(paramamwo.a[0].a, "utf-8");
      paramString = paramString + "_config.dat";
      return amzr.a(paramamwo, a(), paramString);
    }
    catch (UnsupportedEncodingException paramString)
    {
      QLog.i("AREngine_ARMarkerResourceManager", 1, "saveJsonConfigInfo failed. error msg = " + paramString.getMessage());
    }
    return false;
  }
  
  private void b(amyx paramamyx, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadSceneModelResources");
    if (paramArCloudConfigInfo == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.a()) && (!new File(jdField_b_of_type_JavaLangString + "pddata/app/offline/html5/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString + File.separator).exists()) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString)))
    {
      localObject1 = new amzm();
      ((amzm)localObject1).jdField_a_of_type_Int = 4;
      ((amzm)localObject1).jdField_a_of_type_JavaLangString = String.valueOf(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_JavaLangString);
      localArrayList.add(localObject1);
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_Amos != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_Amos.c)))
    {
      if (!new File(paramArCloudConfigInfo.jdField_a_of_type_Amos.c).exists())
      {
        localObject1 = new amzm();
        ((amzm)localObject1).jdField_a_of_type_Int = 7;
        ((amzm)localObject1).jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_Amos.jdField_a_of_type_JavaLangString;
        ((amzm)localObject1).jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_Amos.jdField_b_of_type_JavaLangString;
        ((amzm)localObject1).jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_Amos.jdField_a_of_type_Long;
        ((amzm)localObject1).c = paramArCloudConfigInfo.jdField_a_of_type_Amos.c;
        ((amzm)localObject1).jdField_a_of_type_Boolean = true;
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
        amzr.a((String)localObject1, amzh.b());
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
              localObject3 = awiz.a(((File)localObject1).getAbsolutePath());
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
            amzr.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f, ((File)localObject1).getParentFile().getAbsolutePath() + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + File.separator);
            paramamyx.c(true, paramArCloudConfigInfo);
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
                  localObject1 = awiz.a(localFile.getAbsolutePath());
                }
                if (((!localFile.exists()) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(localArVideoResourceInfo.c))) && (!((ArrayList)localObject3).contains(localArVideoResourceInfo.jdField_d_of_type_JavaLangString)))
                {
                  localObject1 = new amzm();
                  ((amzm)localObject1).jdField_a_of_type_Int = 3;
                  ((amzm)localObject1).jdField_a_of_type_JavaLangString = localArVideoResourceInfo.jdField_d_of_type_JavaLangString;
                  ((amzm)localObject1).jdField_b_of_type_JavaLangString = localArVideoResourceInfo.c;
                  this.f = (localArVideoResourceInfo.jdField_a_of_type_Long / 8192L);
                  ((amzm)localObject1).jdField_a_of_type_Long = localArVideoResourceInfo.jdField_a_of_type_Long;
                  this.j += this.f;
                  this.h = System.currentTimeMillis();
                  ((amzm)localObject1).c = localArVideoResourceInfo.e;
                  ((amzm)localObject1).jdField_a_of_type_Boolean = false;
                  localArrayList.add(localObject1);
                  ((ArrayList)localObject3).add(localArVideoResourceInfo.jdField_d_of_type_JavaLangString);
                }
              }
            }
            try
            {
              amzr.a(paramArCloudConfigInfo.jdField_a_of_type_Amos.c, amzh.a(paramArCloudConfigInfo.jdField_a_of_type_Amos.jdField_b_of_type_JavaLangString));
            }
            catch (Exception localException1) {}
          }
        }
        catch (Exception localException4)
        {
          amzm localamzm1;
          new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f).delete();
          QLog.i("AREngine_ARMarkerResourceManager", 1, "onARSceneRecogDownloadComplete. uncompressZip error.");
          paramamyx.c(false, paramArCloudConfigInfo);
          return;
        }
        localException2 = localException2;
        localamzm1 = new amzm();
        localamzm1.jdField_a_of_type_Int = 6;
        localamzm1.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_b_of_type_JavaLangString;
        localamzm1.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c;
        localamzm1.jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_a_of_type_Long;
        localamzm1.c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString;
        localamzm1.jdField_a_of_type_Boolean = true;
        localArrayList.add(localamzm1);
        continue;
      }
      label898:
      localamzm1 = new amzm();
      localamzm1.jdField_a_of_type_Int = 6;
      localamzm1.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_b_of_type_JavaLangString;
      localamzm1.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.c;
      localamzm1.jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_a_of_type_Long;
      localamzm1.c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString;
      localamzm1.jdField_a_of_type_Boolean = true;
      localArrayList.add(localamzm1);
      continue;
      try
      {
        label971:
        amzr.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.jdField_d_of_type_JavaLangString, amzh.b());
      }
      catch (Exception localException3) {}
      continue;
      label1028:
      amzm localamzm2;
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
            amzr.a((String)localObject2, (String)localObject3);
          }
          catch (Exception localException5) {}
          if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
          {
            localamzm2 = new amzm();
            localamzm2.jdField_a_of_type_Int = 3;
            localamzm2.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
            localamzm2.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
            this.f = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long / 8192L);
            localamzm2.jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
            this.j += this.f;
            this.h = System.currentTimeMillis();
            localamzm2.c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
            localamzm2.jdField_a_of_type_Boolean = true;
            localArrayList.add(localamzm2);
          }
        }
        else if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
        {
          localamzm2 = new amzm();
          localamzm2.jdField_a_of_type_Int = 3;
          localamzm2.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
          localamzm2.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
          this.f = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long / 8192L);
          localamzm2.jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
          this.j += this.f;
          this.h = System.currentTimeMillis();
          localamzm2.c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
          localamzm2.jdField_a_of_type_Boolean = true;
          localArrayList.add(localamzm2);
        }
      }
      else if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
      {
        localamzm2 = new amzm();
        localamzm2.jdField_a_of_type_Int = 3;
        localamzm2.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
        localamzm2.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
        this.f = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long / 8192L);
        localamzm2.jdField_a_of_type_Long = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_Long;
        this.j += this.f;
        this.h = System.currentTimeMillis();
        localamzm2.c = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f;
        localamzm2.jdField_a_of_type_Boolean = true;
        localArrayList.add(localamzm2);
        continue;
        label1544:
        if ((paramamyx != null) && (paramArCloudConfigInfo.b())) {
          paramamyx.f();
        }
        if (localArrayList.size() > 0)
        {
          this.jdField_a_of_type_Amzn.a(localArrayList, new amyw(this, paramamyx, paramArCloudConfigInfo));
          return;
        }
        paramamyx.c(true, paramArCloudConfigInfo);
        return;
        label1598:
        localamzm2 = null;
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
    if ((paramArCloudConfigInfo.c()) && (paramArCloudConfigInfo.jdField_a_of_type_Amos != null)) {
      paramArCloudConfigInfo.jdField_a_of_type_Amos.c = (jdField_b_of_type_JavaLangString + "ar_cloud_transfer/" + paramArCloudConfigInfo.jdField_a_of_type_Amos.jdField_b_of_type_JavaLangString + ".zip");
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)localIterator.next();
        if (localArVideoResourceInfo.jdField_d_of_type_Int == 4) {
          localArVideoResourceInfo.e = anby.a(localArVideoResourceInfo.jdField_d_of_type_JavaLangString);
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
    if ((paramArCloudConfigInfo.c()) && (paramArCloudConfigInfo.jdField_a_of_type_Amos != null)) {
      paramArCloudConfigInfo.jdField_a_of_type_Amos.c = (jdField_b_of_type_JavaLangString + "ar_cloud_transfer/" + paramArCloudConfigInfo.jdField_a_of_type_Amos.jdField_b_of_type_JavaLangString + ".zip");
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)localIterator.next();
        if (localArVideoResourceInfo.jdField_d_of_type_Int == 4) {
          localArVideoResourceInfo.e = anby.a(localArVideoResourceInfo.jdField_d_of_type_JavaLangString);
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
    amzf.a().b(System.currentTimeMillis() - l);
  }
  
  public boolean a(amwo paramamwo, amyx paramamyx, boolean paramBoolean, String arg4)
  {
    Object localObject;
    try
    {
      localObject = new String(paramamwo.a[0].a, "utf-8");
      QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig. jsonContent = " + (String)localObject);
      localObject = amwn.a((String)localObject);
      QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig. config = " + localObject);
      if ((localObject == null) || (((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo == null))
      {
        QLog.i("AREngine_ARMarkerResourceManager", 1, "ARCloud Marker Recog failed.");
        return false;
      }
    }
    catch (Exception paramamwo)
    {
      QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig. parse json failed. error msg = " + paramamwo.getMessage());
      return false;
    }
    if (((ArCloudConfigInfo)localObject).jdField_a_of_type_Amos != null)
    {
      if ((amsa.a()) || (!ampf.a()))
      {
        QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig pause because of device not support");
        return false;
      }
      if (((ArCloudConfigInfo)localObject).jdField_b_of_type_JavaLangString != null) {
        azmj.b(null, "CliOper", "", "", "0X80098CB", "0X80098CB", 0, 0, ((ArCloudConfigInfo)localObject).jdField_b_of_type_JavaLangString, "0", "0", "");
      }
    }
    if (((ArCloudConfigInfo)localObject).g == 1)
    {
      if (!amsa.a()) {}
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
        a(paramamwo, paramamyx, (ArCloudConfigInfo)localObject);
        return true;
      }
    }
    return false;
    label322:
    return false;
  }
  
  public boolean a(amwr arg1, amyx paramamyx, boolean paramBoolean, String paramString)
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
      paramString = amwn.a(???);
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
    if (paramString.jdField_a_of_type_Amos != null)
    {
      if ((amsa.a()) || (!ampf.a()))
      {
        QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadObjectConfig pause because of device not support");
        return false;
      }
      if (paramString.jdField_b_of_type_JavaLangString != null) {
        azmj.b(null, "CliOper", "", "", "0X80098CC", "0X80098CC", 0, 0, paramString.jdField_b_of_type_JavaLangString, "0", "0", "");
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
      a(paramamyx, paramString);
      return true;
    }
  }
  
  public boolean a(amxl paramamxl, amyx paramamyx, boolean paramBoolean, String arg4)
  {
    if (paramamxl == null) {
      return false;
    }
    paramamxl = paramamxl.a();
    if (paramamxl == null) {
      return false;
    }
    try
    {
      paramamxl = new String(paramamxl, "utf-8");
      if (QLog.isColorLevel()) {
        QLog.i("AREngine_ARMarkerResourceManager", 2, "downLoadSceneConfig. jsonContent = " + paramamxl);
      }
      paramamxl = amwn.a(paramamxl);
      QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadSceneConfig. config = " + paramamxl);
      if (paramamxl == null) {
        return false;
      }
    }
    catch (UnsupportedEncodingException paramamxl)
    {
      QLog.i("AREngine_ARMarkerResourceManager", 1, "processSceneRecogResult. parse json failed. error msg = " + paramamxl.getMessage());
      return false;
    }
    if (paramamxl.jdField_a_of_type_Amos != null)
    {
      if ((amsa.a()) || (!ampf.a()))
      {
        QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadSceneConfig pause because of device not support");
        return false;
      }
      if (paramamxl.jdField_b_of_type_JavaLangString != null) {
        azmj.b(null, "CliOper", "", "", "0X80098CC", "0X80098CC", 0, 0, paramamxl.jdField_b_of_type_JavaLangString, "0", "0", "");
      }
    }
    if (paramamxl.g == 1) {
      try
      {
        boolean bool = amsa.a();
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
      if (paramamxl.g != 1) {
        break label349;
      }
      if ((paramamxl.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip == null) || (!paramamxl.b())) {}
    }
    else
    {
      c(paramamxl);
      if ((QLog.isDebugVersion()) && (paramamxl.jdField_c_of_type_Int == 0)) {
        ThreadManager.getUIHandler().post(new ARMarkerResourceManager.2(this));
      }
      paramamxl.jdField_c_of_type_Int = Math.max(1, paramamxl.jdField_c_of_type_Int);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        b(paramamyx, paramamxl);
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
      if (this.jdField_a_of_type_Amzn != null) {
        this.jdField_a_of_type_Amzn.b();
      }
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Amzn != null) {
      this.jdField_a_of_type_Amzn.c();
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
    amzf.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Long, this.jdField_d_of_type_Long, this.jdField_a_of_type_Int, this.f, this.g, this.jdField_b_of_type_Int, this.i, this.jdField_c_of_type_Int, this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, this.j, this.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyt
 * JD-Core Version:    0.7.0.1
 */