import android.annotation.TargetApi;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class appx
{
  public static String a()
  {
    if (a()) {
      return bigv.a(antf.ba);
    }
    if (QLog.isColorLevel()) {
      QLog.i("AREngine_ARResouceDir", 2, "no_sdcard");
    }
    float f = bhmi.a();
    if ((f < 15728640.0F) && (QLog.isColorLevel())) {
      QLog.i("AREngine_ARResouceDir", 2, "inner memory avail may not enough : " + f);
    }
    return BaseApplicationImpl.sApplication.getFilesDir().getAbsolutePath() + File.separator;
  }
  
  public static String a(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    return paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.d + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.d + File.separator;
  }
  
  public static String a(String paramString)
  {
    return a() + "ar_cloud_transfer/" + paramString + File.separator;
  }
  
  @TargetApi(18)
  public static boolean a()
  {
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static String b()
  {
    return a() + "ar_relationship/";
  }
  
  public static String b(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    try
    {
      if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) {
        return "";
      }
      String str = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.a;
      paramArCloudConfigInfo = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.d + str + File.separator;
      return paramArCloudConfigInfo;
    }
    catch (Exception paramArCloudConfigInfo)
    {
      QLog.i("AREngine_ARResouceDir", 2, "get3DModelUnzipDir error " + paramArCloudConfigInfo.getMessage());
    }
    return "";
  }
  
  public static String c(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    try
    {
      if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) {
        return "";
      }
      String str1 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.a;
      String str2 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.d;
      paramArCloudConfigInfo = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.d + str1 + File.separator + str2;
      return paramArCloudConfigInfo;
    }
    catch (Exception paramArCloudConfigInfo)
    {
      QLog.i("AREngine_ARResouceDir", 2, "get3DModelLuaFilePath error " + paramArCloudConfigInfo.getMessage());
    }
    return "";
  }
  
  public static String d(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    try
    {
      if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) {
        return "";
      }
      String str = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.a;
      if (TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.c)) {
        return "";
      }
      paramArCloudConfigInfo = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.d + str + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.c;
      return paramArCloudConfigInfo;
    }
    catch (Exception paramArCloudConfigInfo)
    {
      QLog.i("AREngine_ARResouceDir", 2, "get3DModelMusicFilePath error " + paramArCloudConfigInfo.getMessage());
    }
    return "";
  }
  
  public static String e(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    try
    {
      paramArCloudConfigInfo = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.d + ((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).c + "_model.zip";
      return paramArCloudConfigInfo;
    }
    catch (Exception paramArCloudConfigInfo)
    {
      QLog.i("AREngine_ARResouceDir", 2, "getVideoFilePath error " + paramArCloudConfigInfo.getMessage());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appx
 * JD-Core Version:    0.7.0.1
 */