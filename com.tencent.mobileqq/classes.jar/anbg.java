import android.graphics.drawable.Drawable;
import cooperation.qzone.webviewwrapper.LiveVideoFeedVipIconListner;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class anbg
  implements InvocationHandler
{
  public anbg(LiveVideoFeedVipIconListner paramLiveVideoFeedVipIconListner) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (paramMethod.getName().equals("onFailed")) {
      if (this.a != null) {
        this.a.onFailed();
      }
    }
    for (;;)
    {
      return null;
      if ((paramMethod.getName().equals("onLoaded")) && (this.a != null)) {
        this.a.onLoaded((Drawable)paramArrayOfObject[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbg
 * JD-Core Version:    0.7.0.1
 */