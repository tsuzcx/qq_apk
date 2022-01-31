import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.MusicDownloadListener;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.view.MusicFragmentProviderView;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public class anxk
  extends MusicDownloadListener
{
  public anxk(MusicFragmentProviderView paramMusicFragmentProviderView) {}
  
  public void a(int paramInt)
  {
    this.a.c(paramInt);
  }
  
  public void a(String paramString)
  {
    if ((MusicFragmentProviderView.a(this.a) != null) && (MusicFragmentProviderView.a(this.a).a().equals(paramString)))
    {
      MusicFragmentProviderView.a(this.a).c = -1;
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
    if ((paramBoolean) && (MusicFragmentProviderView.a(this.a) != null) && (MusicFragmentProviderView.a(this.a).a().equals(paramString)))
    {
      MusicFragmentProviderView.a(this.a).e = 0;
      MusicFragmentProviderView.a(this.a).f = (MusicFragmentProviderView.a(this.a).e + MusicFragmentProviderView.a(this.a));
      MusicFragmentProviderView.a(this.a).g = ((int)ShortVideoUtils.a(MusicFragmentProviderView.a(this.a).a()));
      if (MusicFragmentProviderView.a(this.a).f > MusicFragmentProviderView.a(this.a).g) {
        MusicFragmentProviderView.a(this.a).f = MusicFragmentProviderView.a(this.a).g;
      }
      MusicFragmentProviderView.a(this.a, MusicFragmentProviderView.a(this.a).e);
      MusicFragmentProviderView.b(this.a, MusicFragmentProviderView.a(this.a).f);
      paramString = (QIMMusicConfigManager)QIMManager.a(2);
      MusicItemInfo localMusicItemInfo = paramString.a(MusicFragmentProviderView.a(this.a).jdField_a_of_type_Int);
      if (localMusicItemInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MusicFragmentProviderView", 2, "music exist name =" + localMusicItemInfo.jdField_a_of_type_JavaLangString);
        }
        paramString.a(MusicFragmentProviderView.a(this.a), false);
      }
      if (this.a.a != null) {
        this.a.a.sendEmptyMessage(2);
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder("onFinish musicStart=").append(MusicFragmentProviderView.a(this.a).e);
        paramString.append(" musicEnd=").append(MusicFragmentProviderView.a(this.a).f);
        paramString.append(" musicDuration").append(MusicFragmentProviderView.a(this.a).g);
        paramString.append(" premusicStart").append(MusicFragmentProviderView.b(this.a));
        paramString.append(" premusicEnd").append(MusicFragmentProviderView.c(this.a));
        paramString.append(" musicName").append(MusicFragmentProviderView.a(this.a).jdField_a_of_type_JavaLangString);
        QLog.d("MusicFragmentProviderView", 2, paramString.toString());
      }
    }
    MusicFragmentProviderView.a(this.a).set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anxk
 * JD-Core Version:    0.7.0.1
 */