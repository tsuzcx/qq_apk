import android.os.Handler;
import com.tencent.qqmini.sdk.minigame.manager.GameReportManager.1;
import com.tencent.qqmini.sdk.minigame.manager.GameReportManager.2;

public class bevl
{
  private static bevl jdField_a_of_type_Bevl;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public static bevl a()
  {
    if (jdField_a_of_type_Bevl == null) {}
    try
    {
      if (jdField_a_of_type_Bevl == null) {
        jdField_a_of_type_Bevl = new bevl();
      }
      return jdField_a_of_type_Bevl;
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
        beyo.a().a().post(new GameReportManager.1(this));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      besl.d("GameReportManager", "onJsError", localThrowable);
    }
  }
  
  public void b()
  {
    try
    {
      beyo.a().a().post(new GameReportManager.2(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      besl.d("GameReportManager", "onFirstFrame", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bevl
 * JD-Core Version:    0.7.0.1
 */