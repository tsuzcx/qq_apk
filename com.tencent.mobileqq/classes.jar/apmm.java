import android.annotation.TargetApi;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class apmm
{
  public static String a()
  {
    if (a()) {}
    for (String str = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH);; str = BaseApplicationImpl.sApplication.getFilesDir().getAbsolutePath() + File.separator)
    {
      QLog.d("AREngine_ARResouceDir", 1, "initArResourceFilePath rootPath:=" + str);
      return str;
      if (QLog.isColorLevel()) {
        QLog.i("AREngine_ARResouceDir", 2, "no_sdcard");
      }
      float f = FileUtils.getAvailableInnernalMemorySize();
      if ((f < 15728640.0F) && (QLog.isColorLevel())) {
        QLog.i("AREngine_ARResouceDir", 2, "inner memory avail may not enough : " + f);
      }
    }
  }
  
  public static String a(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    return paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.d + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.d + File.separator;
  }
  
  public static String a(String paramString)
  {
    return a() + "ar_cloud_transfer/" + paramString + File.separator;
  }
  
  /* Error */
  public static void a(@androidx.annotation.NonNull String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 111	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   7: istore_1
    //   8: iload_1
    //   9: ifne +8 -> 17
    //   12: aload_0
    //   13: invokestatic 115	com/tencent/mobileqq/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   16: pop
    //   17: ldc 2
    //   19: monitorexit
    //   20: return
    //   21: astore_0
    //   22: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq -8 -> 17
    //   28: ldc 23
    //   30: iconst_2
    //   31: ldc 117
    //   33: aload_0
    //   34: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   37: goto -20 -> 17
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	paramString	String
    //   7	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   12	17	21	java/io/IOException
    //   3	8	40	finally
    //   12	17	40	finally
    //   22	37	40	finally
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
 * Qualified Name:     apmm
 * JD-Core Version:    0.7.0.1
 */