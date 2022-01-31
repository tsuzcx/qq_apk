import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import dov.com.tencent.biz.qqstory.takevideo.rmw.RMWServiceProxy;

public class annh
  extends Handler
{
  private RMWServiceProxy a;
  
  public annh(RMWServiceProxy paramRMWServiceProxy)
  {
    super(Looper.getMainLooper());
    this.a = paramRMWServiceProxy;
  }
  
  public void handleMessage(Message paramMessage)
  {
    RMWServiceProxy localRMWServiceProxy = this.a;
    if (localRMWServiceProxy != null) {
      localRMWServiceProxy.a(Message.obtain(paramMessage));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     annh
 * JD-Core Version:    0.7.0.1
 */