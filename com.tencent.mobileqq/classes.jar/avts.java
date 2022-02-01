import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime.InterceptKickListener;
import mqq.app.AppRuntime.KickParams;

class avts
  implements AppRuntime.InterceptKickListener
{
  avts(avtq paramavtq) {}
  
  public void onInterceptKicked(AppRuntime.KickParams paramKickParams)
  {
    if (avtq.a(this.a).get()) {
      avtq.a(this.a, paramKickParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avts
 * JD-Core Version:    0.7.0.1
 */