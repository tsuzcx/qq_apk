import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import dov.com.qq.im.capture.view.MusicFragmentProviderView;
import java.util.concurrent.atomic.AtomicInteger;

public class bjkj
  implements bjdy
{
  public bjkj(MusicFragmentProviderView paramMusicFragmentProviderView) {}
  
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
      if (paramMusicItemInfo.mType == 2) {
        this.a.a.a(true);
      }
    }
    else {
      return;
    }
    this.a.a.a(false);
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
 * Qualified Name:     bjkj
 * JD-Core Version:    0.7.0.1
 */