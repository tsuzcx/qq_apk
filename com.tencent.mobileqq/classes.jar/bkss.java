import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.11.1;
import mqq.os.MqqHandler;

public class bkss
  implements TVK_SDKMgr.InstallListener
{
  public bkss(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    ShortVideoPlayActivity.a(this.a, false);
    ShortVideoPlayActivity.b(this.a, System.currentTimeMillis() - ShortVideoPlayActivity.b(this.a));
    this.a.a(ajyc.a(2131714023));
    ShortVideoPlayActivity.c(this.a, 3000);
    ShortVideoPlayActivity.d(this.a, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onInstalledFailed:" + paramInt);
    }
  }
  
  public void onInstalledSuccessed()
  {
    ShortVideoPlayActivity.a(this.a, true);
    ShortVideoPlayActivity.b(this.a, System.currentTimeMillis() - ShortVideoPlayActivity.b(this.a));
    this.a.a.post(new ShortVideoPlayActivity.11.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkss
 * JD-Core Version:    0.7.0.1
 */