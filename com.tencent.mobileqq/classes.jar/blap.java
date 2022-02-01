import android.os.Bundle;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.1;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public class blap
  implements bmvx
{
  public blap(VideoJsProxyImpl.1 param1) {}
  
  public void callback(int paramInt, Bundle paramBundle)
  {
    boolean bool;
    if (paramInt == 0)
    {
      QLog.i("VideoJsPlugin", 1, "callback: load ok " + paramInt);
      if (VideoEnvironment.a("AVCodec", MobileQQ.sMobileQQ.getApplicationContext()) == 0)
      {
        bool = true;
        blao.a(bool);
      }
    }
    for (;;)
    {
      blao.a().compareAndSet(true, false);
      return;
      bool = false;
      break;
      QLog.w("VideoJsPlugin", 1, "callback: load failed " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blap
 * JD-Core Version:    0.7.0.1
 */