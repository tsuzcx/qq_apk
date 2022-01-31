import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime.InterceptKickListener;
import mqq.app.AppRuntime.KickParams;

class augq
  implements AppRuntime.InterceptKickListener
{
  augq(augo paramaugo) {}
  
  public void onInterceptKicked(AppRuntime.KickParams paramKickParams)
  {
    if (augo.a(this.a).get()) {
      augo.a(this.a, paramKickParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     augq
 * JD-Core Version:    0.7.0.1
 */