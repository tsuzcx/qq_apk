import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import dov.com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager.3.1;

public class bjca
  implements INetInfoHandler
{
  bjca(bjbz parambjbz) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    Thread.currentThread().getId();
    if (Looper.myLooper() == Looper.getMainLooper()) {
      bjbz.a(this.a);
    }
    while (bjbz.a(this.a) == null) {
      return;
    }
    bjbz.a(this.a).post(new LbsFilterStatusManager.3.1(this));
  }
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjca
 * JD-Core Version:    0.7.0.1
 */