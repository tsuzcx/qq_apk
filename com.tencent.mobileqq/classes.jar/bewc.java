import android.os.Handler;
import com.tencent.qqmini.sdk.minigame.manager.GameReportManager.1;
import com.tencent.qqmini.sdk.minigame.manager.GameReportManager.2;

public class bewc
{
  private static bewc jdField_a_of_type_Bewc;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public static bewc a()
  {
    if (jdField_a_of_type_Bewc == null) {}
    try
    {
      if (jdField_a_of_type_Bewc == null) {
        jdField_a_of_type_Bewc = new bewc();
      }
      return jdField_a_of_type_Bewc;
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      if (!this.b)
      {
        this.b = true;
        bezf.a().a().post(new GameReportManager.1(this));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      betc.d("GameReportManager", "onJsError", localThrowable);
    }
  }
  
  public void b()
  {
    try
    {
      bezf.a().a().post(new GameReportManager.2(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      betc.d("GameReportManager", "onFirstFrame", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bewc
 * JD-Core Version:    0.7.0.1
 */