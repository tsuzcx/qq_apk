import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import dov.com.qq.im.capture.music.MusicPlayerSceneListener;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.view.MusicFragmentProviderView;
import dov.com.qq.im.capture.view.ProviderView.ProviderViewListener;
import java.util.concurrent.atomic.AtomicInteger;

public class anxl
  implements MusicPlayerSceneListener
{
  public anxl(MusicFragmentProviderView paramMusicFragmentProviderView) {}
  
  public void a()
  {
    this.a.i();
  }
  
  public void a(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    if (paramInt != -1)
    {
      this.a.a(paramInt);
      MusicFragmentProviderView.a(this.a).set(-1);
      this.a.j();
      return;
    }
    this.a.i();
  }
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    if (this.a.a != null)
    {
      if (paramMusicItemInfo.d == 2) {
        this.a.a.c(true);
      }
    }
    else {
      return;
    }
    this.a.a.c(false);
  }
  
  public void b(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    this.a.a(paramInt);
    if (paramInt != -1)
    {
      MusicFragmentProviderView.a(this.a).set(-1);
      this.a.j();
    }
    for (;;)
    {
      if (MusicFragmentProviderView.a(this.a) != null) {
        MusicFragmentProviderView.a(this.a).f();
      }
      return;
      this.a.i();
    }
  }
  
  public void b(MusicItemInfo paramMusicItemInfo) {}
  
  public void c(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    if (paramInt != -1)
    {
      this.a.j();
      return;
    }
    this.a.i();
  }
  
  public void d(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anxl
 * JD-Core Version:    0.7.0.1
 */