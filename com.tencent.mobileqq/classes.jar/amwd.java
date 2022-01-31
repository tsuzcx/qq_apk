import android.content.Intent;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.open.base.ToastUtil;
import dov.com.qq.im.capture.music.MusicDownloadListener;
import dov.com.qq.im.capture.music.humrecognition.HummingActivity;

public class amwd
  extends MusicDownloadListener
{
  public amwd(HummingActivity paramHummingActivity) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    ToastUtil.a().a("正在下载: " + HummingActivity.a(this.a), 0);
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (paramString != null) && (HummingActivity.a(this.a).a().equals(paramString)))
    {
      paramString = new Intent();
      paramString.putExtra("EXTRA_HUM_RECOGNITION_RESULT", HummingActivity.a(this.a));
      this.a.setResult(-1, paramString);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amwd
 * JD-Core Version:    0.7.0.1
 */