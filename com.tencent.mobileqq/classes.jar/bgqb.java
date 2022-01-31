import com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.log.QMLog;

public class bgqb
  implements bgqi
{
  public bgqb(AppRuntimeLoaderManager paramAppRuntimeLoaderManager, bgqi parambgqi) {}
  
  public void a(int paramInt, String paramString, bgqg parambgqg)
  {
    try
    {
      if (this.jdField_a_of_type_Bgqi != null) {
        this.jdField_a_of_type_Bgqi.a(paramInt, paramString, parambgqg);
      }
      if (paramInt != 0) {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherAppRuntimeLoaderManager.removeRuntimeLoader(parambgqg);
      }
      return;
    }
    catch (Throwable paramString)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "runtime load result exception!", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgqb
 * JD-Core Version:    0.7.0.1
 */