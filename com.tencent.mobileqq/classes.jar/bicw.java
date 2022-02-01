import android.app.Activity;
import com.sina.weibo.sdk.openapi.IWBAPI;
import mqq.util.WeakReference;

class bicw
{
  WeakReference<Activity> a;
  WeakReference<IWBAPI> b;
  
  bicw(Activity paramActivity, IWBAPI paramIWBAPI)
  {
    this.a = new WeakReference(paramActivity);
    this.b = new WeakReference(paramIWBAPI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bicw
 * JD-Core Version:    0.7.0.1
 */