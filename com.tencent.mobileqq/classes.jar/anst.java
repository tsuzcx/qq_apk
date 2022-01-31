import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import mqq.os.MqqHandler;

public class anst
  implements TVK_SDKMgr.InstallListener
{
  public anst(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    ShortVideoPlayActivity.a(this.a, false);
    ShortVideoPlayActivity.b(this.a, System.currentTimeMillis() - ShortVideoPlayActivity.b(this.a));
    this.a.a("腾讯视频插件加载失败");
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
    this.a.a.post(new ansu(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anst
 * JD-Core Version:    0.7.0.1
 */