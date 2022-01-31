import android.os.Handler;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin.7;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class bdtq
  implements TVK_SDKMgr.InstallListener
{
  public bdtq(HealthBusinessPlugin.7 param7) {}
  
  public void onInstallProgress(float paramFloat)
  {
    this.a.this$0.c = ((int)(100.0F * paramFloat));
    this.a.this$0.b.sendEmptyMessage(2);
  }
  
  public void onInstalledFailed(int paramInt)
  {
    this.a.this$0.d = paramInt;
    this.a.this$0.b.sendEmptyMessage(1);
  }
  
  public void onInstalledSuccessed()
  {
    this.a.this$0.b.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtq
 * JD-Core Version:    0.7.0.1
 */