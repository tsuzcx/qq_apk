import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterListDownloader.downloadListTaskListener;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;

public class aopn
  implements VideoFilterListDownloader.downloadListTaskListener
{
  public aopn(VideoFilterTools paramVideoFilterTools) {}
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    UITools.a("VideoFilterTools", "VideoFilterListDownloader onFinished sucNum: " + paramInt1 + "failed Num : " + paramInt2);
    if (paramInt1 > 0) {
      this.a.b(BaseApplicationImpl.sApplication);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aopn
 * JD-Core Version:    0.7.0.1
 */