import com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.log.QMLog;

public class bgui
  implements bgup
{
  public bgui(AppRuntimeLoaderManager paramAppRuntimeLoaderManager, bgup parambgup) {}
  
  public void a(int paramInt, String paramString, bgun parambgun)
  {
    try
    {
      if (this.jdField_a_of_type_Bgup != null) {
        this.jdField_a_of_type_Bgup.a(paramInt, paramString, parambgun);
      }
      if (paramInt != 0) {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherAppRuntimeLoaderManager.removeRuntimeLoader(parambgun);
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
 * Qualified Name:     bgui
 * JD-Core Version:    0.7.0.1
 */