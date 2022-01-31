import android.content.Context;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qqmini.sdk.log.QMLog;

@bghi(a="InitGameRuntimeTask")
public class bgvf
  extends bhhp
{
  public bgvf(Context paramContext, bgqg parambgqg)
  {
    super(paramContext, parambgqg);
  }
  
  public void a()
  {
    ITTEngine localITTEngine = null;
    bgtj localbgtj;
    if (a() != null)
    {
      localbgtj = ((bgvc)a().getTask(bgvc.class)).a();
      localITTEngine = ((bgvl)a().getTask(bgvl.class)).a();
    }
    for (;;)
    {
      if ((localbgtj == null) || (localITTEngine == null))
      {
        e();
        return;
      }
      try
      {
        localbgtj.a(localITTEngine);
        c();
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("InitGameRuntimeTask", localThrowable.getMessage(), localThrowable);
        e();
        return;
      }
      localbgtj = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgvf
 * JD-Core Version:    0.7.0.1
 */