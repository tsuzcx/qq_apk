import android.content.Context;
import com.tencent.mobileqq.triton.sdk.ITTEngine;

@begt(a="InitGameRuntimeTask")
public class bewe
  extends bfet
{
  public bewe(Context paramContext, bepv parambepv)
  {
    super(paramContext, parambepv);
  }
  
  public void a()
  {
    String str = null;
    beuh localbeuh;
    ITTEngine localITTEngine;
    if (a() != null)
    {
      localbeuh = ((bewb)a().getTask(bewb.class)).a();
      localITTEngine = ((bevy)a().getTask(bevy.class)).a();
      str = bevk.a().b();
    }
    for (;;)
    {
      if ((localbeuh == null) || (localITTEngine == null))
      {
        f();
        return;
      }
      try
      {
        localbeuh.a(str);
        localbeuh.a(localITTEngine);
        c();
        return;
      }
      catch (Throwable localThrowable)
      {
        besl.d("InitGameRuntimeTask", localThrowable.getMessage(), localThrowable);
        f();
        return;
      }
      localITTEngine = null;
      localbeuh = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bewe
 * JD-Core Version:    0.7.0.1
 */