import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.view.MusicFragmentProviderView;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public class bmae
  extends blts
{
  public bmae(MusicFragmentProviderView paramMusicFragmentProviderView) {}
  
  public void a(int paramInt)
  {
    this.a.c(paramInt);
  }
  
  public void a(String paramString)
  {
    if ((MusicFragmentProviderView.a(this.a) != null) && (MusicFragmentProviderView.a(this.a).getLocalPath().equals(paramString)))
    {
      MusicFragmentProviderView.a(this.a).mProgress = -1;
      if (this.a.a != null) {
        this.a.a.sendEmptyMessage(3);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MusicFragmentProviderView", 2, "download onCancel");
    }
    MusicFragmentProviderView.a(this.a).set(false);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.a.a(paramString, paramInt);
    MusicFragmentProviderView.a(this.a).set(true);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.a.b(-115);
      MusicFragmentProviderView.a(this.a).set(false);
    }
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    this.a.b(paramInt);
    if ((paramBoolean) && (MusicFragmentProviderView.a(this.a) != null) && (MusicFragmentProviderView.a(this.a).getLocalPath().equals(paramString)))
    {
      MusicFragmentProviderView.a(this.a).musicStart = 0;
      MusicFragmentProviderView.a(this.a).musicEnd = (MusicFragmentProviderView.a(this.a).musicStart + MusicFragmentProviderView.a(this.a));
      MusicFragmentProviderView.a(this.a).musicDuration = ((int)ShortVideoUtils.a(MusicFragmentProviderView.a(this.a).getLocalPath()));
      if (MusicFragmentProviderView.a(this.a).musicEnd > MusicFragmentProviderView.a(this.a).musicDuration) {
        MusicFragmentProviderView.a(this.a).musicEnd = MusicFragmentProviderView.a(this.a).musicDuration;
      }
      MusicFragmentProviderView.a(this.a, MusicFragmentProviderView.a(this.a).musicStart);
      MusicFragmentProviderView.b(this.a, MusicFragmentProviderView.a(this.a).musicEnd);
      paramString = (QIMMusicConfigManager)blqr.a(2);
      MusicItemInfo localMusicItemInfo = paramString.a(MusicFragmentProviderView.a(this.a).mItemId);
      if (localMusicItemInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MusicFragmentProviderView", 2, "music exist name =" + localMusicItemInfo.mMusicName);
        }
        paramString.a(MusicFragmentProviderView.a(this.a), false);
      }
      if (this.a.a != null) {
        this.a.a.sendEmptyMessage(2);
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder("onFinish musicStart=").append(MusicFragmentProviderView.a(this.a).musicStart);
        paramString.append(" musicEnd=").append(MusicFragmentProviderView.a(this.a).musicEnd);
        paramString.append(" musicDuration").append(MusicFragmentProviderView.a(this.a).musicDuration);
        paramString.append(" premusicStart").append(MusicFragmentProviderView.b(this.a));
        paramString.append(" premusicEnd").append(MusicFragmentProviderView.c(this.a));
        paramString.append(" musicName").append(MusicFragmentProviderView.a(this.a).mMusicName);
        QLog.d("MusicFragmentProviderView", 2, paramString.toString());
      }
    }
    MusicFragmentProviderView.a(this.a).set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmae
 * JD-Core Version:    0.7.0.1
 */