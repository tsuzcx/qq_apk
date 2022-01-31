import android.os.Handler;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.minigame.manager.GameReportManager.1;
import com.tencent.qqmini.sdk.minigame.manager.GameReportManager.2;

public class bguw
{
  private static String jdField_a_of_type_JavaLangString;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public bguw()
  {
    jdField_a_of_type_JavaLangString = toString();
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
  }
  
  public void a()
  {
    try
    {
      if (!this.b)
      {
        this.b = true;
        bgya.a().a().post(new GameReportManager.1(this));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e(jdField_a_of_type_JavaLangString, "onJsError", localThrowable);
    }
  }
  
  public void b()
  {
    try
    {
      bgya.a().a().post(new GameReportManager.2(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e(jdField_a_of_type_JavaLangString, "onFirstFrame", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bguw
 * JD-Core Version:    0.7.0.1
 */