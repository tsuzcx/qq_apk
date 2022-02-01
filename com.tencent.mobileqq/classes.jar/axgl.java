import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime.InterceptKickListener;
import mqq.app.AppRuntime.KickParams;

class axgl
  implements AppRuntime.InterceptKickListener
{
  axgl(axgj paramaxgj) {}
  
  public void onInterceptKicked(AppRuntime.KickParams paramKickParams)
  {
    if (axgj.a(this.a).get()) {
      axgj.a(this.a, paramKickParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axgl
 * JD-Core Version:    0.7.0.1
 */