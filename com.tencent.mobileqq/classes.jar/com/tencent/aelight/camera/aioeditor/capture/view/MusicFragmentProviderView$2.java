package com.tencent.aelight.camera.aioeditor.capture.view;

import com.tencent.aelight.camera.aioeditor.capture.music.MusicPlayerSceneListener;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import java.util.concurrent.atomic.AtomicInteger;

class MusicFragmentProviderView$2
  implements MusicPlayerSceneListener
{
  MusicFragmentProviderView$2(MusicFragmentProviderView paramMusicFragmentProviderView) {}
  
  public void a()
  {
    this.a.i();
  }
  
  public void a(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    if (paramInt != -1)
    {
      this.a.a(paramInt);
      MusicFragmentProviderView.b(this.a).set(-1);
      this.a.j();
      return;
    }
    this.a.i();
  }
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    if (this.a.F != null)
    {
      if (paramMusicItemInfo.mType == 2)
      {
        this.a.F.a(true);
        return;
      }
      this.a.F.a(false);
    }
  }
  
  public void b(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    this.a.a(paramInt);
    if (paramInt != -1)
    {
      MusicFragmentProviderView.b(this.a).set(-1);
      this.a.j();
    }
    else
    {
      this.a.i();
    }
    if (MusicFragmentProviderView.a(this.a) != null) {
      MusicFragmentProviderView.a(this.a).k();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.MusicFragmentProviderView.2
 * JD-Core Version:    0.7.0.1
 */