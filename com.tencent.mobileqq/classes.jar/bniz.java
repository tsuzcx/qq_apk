import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import dov.com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager.3.1;

public class bniz
  implements INetInfoHandler
{
  bniz(bniy parambniy) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    Thread.currentThread().getId();
    if (Looper.myLooper() == Looper.getMainLooper()) {
      bniy.a(this.a);
    }
    while (bniy.a(this.a) == null) {
      return;
    }
    bniy.a(this.a).post(new LbsFilterStatusManager.3.1(this));
  }
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bniz
 * JD-Core Version:    0.7.0.1
 */