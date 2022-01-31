import android.content.Context;
import com.tencent.mobileqq.triton.sdk.ITTEngine;

@bdcu(a="InitGameRuntimeTask")
public class bdqr
  extends bdyb
{
  private bdoz a;
  
  public bdqr(Context paramContext, bdlq parambdlq)
  {
    super(paramContext, parambdlq);
  }
  
  public bdoz a()
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
    ITTEngine localITTEngine = null;
    if (a() != null) {
      localITTEngine = ((bdqm)a().getTask(bdqm.class)).a();
    }
    if (localITTEngine == null)
    {
      f();
      return;
    }
    try
    {
      this.a = new bdoz();
      this.a.a(a());
      this.a.a(localITTEngine);
      c();
      return;
    }
    catch (Throwable localThrowable)
    {
      bdnw.d("InitGameRuntimeTask", localThrowable.getMessage(), localThrowable);
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdqr
 * JD-Core Version:    0.7.0.1
 */