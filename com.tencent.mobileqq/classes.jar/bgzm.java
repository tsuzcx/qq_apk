import android.content.Context;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qqmini.sdk.log.QMLog;

@bglp(a="InitGameRuntimeTask")
public class bgzm
  extends bhlw
{
  public bgzm(Context paramContext, bgun parambgun)
  {
    super(paramContext, parambgun);
  }
  
  public void a()
  {
    ITTEngine localITTEngine = null;
    bgxq localbgxq;
    if (a() != null)
    {
      localbgxq = ((bgzj)a().getTask(bgzj.class)).a();
      localITTEngine = ((bgzs)a().getTask(bgzs.class)).a();
    }
    for (;;)
    {
      if ((localbgxq == null) || (localITTEngine == null))
      {
        e();
        return;
      }
      try
      {
        localbgxq.a(localITTEngine);
        c();
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("InitGameRuntimeTask", localThrowable.getMessage(), localThrowable);
        e();
        return;
      }
      localbgxq = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgzm
 * JD-Core Version:    0.7.0.1
 */