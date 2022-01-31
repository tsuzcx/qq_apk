import android.os.Handler;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.21.1;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.21.2;

public class bayx
  implements INetInfoHandler
{
  public bayx(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    TribeVideoListPlayerFragment.a.post(new TribeVideoListPlayerFragment.21.1(this));
  }
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString)
  {
    TribeVideoListPlayerFragment.a.post(new TribeVideoListPlayerFragment.21.2(this));
  }
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bayx
 * JD-Core Version:    0.7.0.1
 */