import android.os.Handler;
import com.tencent.qqmini.sdk.minigame.manager.GameReportManager.1;

public class bdqc
{
  private static bdqc jdField_a_of_type_Bdqc;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public static bdqc a()
  {
    if (jdField_a_of_type_Bdqc == null) {}
    try
    {
      if (jdField_a_of_type_Bdqc == null) {
        jdField_a_of_type_Bdqc = new bdqc();
      }
      return jdField_a_of_type_Bdqc;
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
        bdsr.a().a().post(new GameReportManager.1(this));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      bdnw.d("GameReportManager", "onJsError", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdqc
 * JD-Core Version:    0.7.0.1
 */