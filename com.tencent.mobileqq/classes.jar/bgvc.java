import android.content.Context;
import com.tencent.qqmini.sdk.log.QMLog;

@bghi(a="GameRuntimeCreateTask")
public class bgvc
  extends bhhp
{
  private bgtj a;
  
  public bgvc(Context paramContext, bgqg parambgqg)
  {
    super(paramContext, parambgqg);
  }
  
  public bgtj a()
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
      this.a = new bgtj();
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
 * Qualified Name:     bgvc
 * JD-Core Version:    0.7.0.1
 */