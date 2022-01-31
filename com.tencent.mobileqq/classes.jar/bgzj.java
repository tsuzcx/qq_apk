import android.content.Context;
import com.tencent.qqmini.sdk.log.QMLog;

@bglp(a="GameRuntimeCreateTask")
public class bgzj
  extends bhlw
{
  private bgxq a;
  
  public bgzj(Context paramContext, bgun parambgun)
  {
    super(paramContext, parambgun);
  }
  
  public bgxq a()
  {
    return this.a;
  }
  
  public void a()
  {
    if (this.a != null)
    {
      c();
      return;
    }
    try
    {
      this.a = new bgxq();
      this.a.a(a());
      c();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("GameRuntimeCreateTask", "Failed execute GameRuntimeCreateTask", localThrowable);
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgzj
 * JD-Core Version:    0.7.0.1
 */