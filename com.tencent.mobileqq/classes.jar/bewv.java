import android.content.Context;
import com.tencent.mobileqq.triton.sdk.ITTEngine;

@behk(a="InitGameRuntimeTask")
public class bewv
  extends bffk
{
  public bewv(Context paramContext, beqm parambeqm)
  {
    super(paramContext, parambeqm);
  }
  
  public void a()
  {
    String str = null;
    beuy localbeuy;
    ITTEngine localITTEngine;
    if (a() != null)
    {
      localbeuy = ((bews)a().getTask(bews.class)).a();
      localITTEngine = ((bewp)a().getTask(bewp.class)).a();
      str = bewb.a().b();
    }
    for (;;)
    {
      if ((localbeuy == null) || (localITTEngine == null))
      {
        f();
        return;
      }
      try
      {
        localbeuy.a(str);
        localbeuy.a(localITTEngine);
        c();
        return;
      }
      catch (Throwable localThrowable)
      {
        betc.d("InitGameRuntimeTask", localThrowable.getMessage(), localThrowable);
        f();
        return;
      }
      localITTEngine = null;
      localbeuy = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bewv
 * JD-Core Version:    0.7.0.1
 */