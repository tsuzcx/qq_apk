import android.os.CountDownTimer;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;

public class azzd
  implements INetInfoHandler
{
  public azzd(ReciteRecordLayout paramReciteRecordLayout) {}
  
  public void onNetMobile2None()
  {
    this.a.b.cancel();
    this.a.b.start();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    this.a.b.cancel();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    this.a.b.cancel();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    this.a.b.cancel();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    this.a.b.cancel();
  }
  
  public void onNetWifi2None()
  {
    this.a.b.cancel();
    this.a.b.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azzd
 * JD-Core Version:    0.7.0.1
 */