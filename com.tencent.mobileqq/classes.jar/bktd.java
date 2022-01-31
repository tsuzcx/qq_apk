import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import dov.com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager.3.1;

public class bktd
  implements INetInfoHandler
{
  bktd(bktc parambktc) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    Thread.currentThread().getId();
    if (Looper.myLooper() == Looper.getMainLooper()) {
      bktc.a(this.a);
    }
    while (bktc.a(this.a) == null) {
      return;
    }
    bktc.a(this.a).post(new LbsFilterStatusManager.3.1(this));
  }
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bktd
 * JD-Core Version:    0.7.0.1
 */