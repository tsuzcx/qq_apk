import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.open.base.ToastUtil;
import com.tencent.util.WeakReferenceHandler;
import dov.com.qq.im.capture.music.MusicDownloadListener;
import dov.com.qq.im.capture.music.humrecognition.view.BgmRecognitionProviderView;

public class anmq
  extends MusicDownloadListener
{
  public anmq(BgmRecognitionProviderView paramBgmRecognitionProviderView) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    ToastUtil.a().a("正在下载: " + this.a.a);
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (this.a.a.a().equals(paramString))) {
      BgmRecognitionProviderView.a(this.a).sendEmptyMessage(1003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anmq
 * JD-Core Version:    0.7.0.1
 */