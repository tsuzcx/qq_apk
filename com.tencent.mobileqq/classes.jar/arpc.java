import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime.InterceptKickListener;
import mqq.app.AppRuntime.KickParams;

class arpc
  implements AppRuntime.InterceptKickListener
{
  arpc(arpa paramarpa) {}
  
  public void onInterceptKicked(AppRuntime.KickParams paramKickParams)
  {
    if (arpa.a(this.a).get()) {
      arpa.a(this.a, paramKickParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arpc
 * JD-Core Version:    0.7.0.1
 */