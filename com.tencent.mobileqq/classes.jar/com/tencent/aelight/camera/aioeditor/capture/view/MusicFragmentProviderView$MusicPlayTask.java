package com.tencent.aelight.camera.aioeditor.capture.view;

import com.tencent.util.WeakReferenceHandler;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class MusicFragmentProviderView$MusicPlayTask
  extends TimerTask
{
  protected MusicFragmentProviderView$MusicPlayTask(MusicFragmentProviderView paramMusicFragmentProviderView) {}
  
  public void run()
  {
    if (MusicFragmentProviderView.a(this.this$0) != null)
    {
      MusicFragmentProviderView.a(this.this$0).incrementAndGet();
      if (this.this$0.a != null) {
        this.this$0.a.sendEmptyMessage(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.MusicFragmentProviderView.MusicPlayTask
 * JD-Core Version:    0.7.0.1
 */