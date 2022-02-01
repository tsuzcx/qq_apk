package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

class AudioPlayback$AudioThread
  extends Thread
{
  private final Object a = new Object();
  private boolean b = true;
  
  AudioPlayback$AudioThread(AudioPlayback paramAudioPlayback)
  {
    super("AudioPlayback");
  }
  
  public void a()
  {
    synchronized (this.a)
    {
      this.a.notify();
      return;
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    try
    {
      notify();
      return;
    }
    finally {}
  }
  
  public void run()
  {
    while (!isInterrupted()) {
      try
      {
        try
        {
          while (this.b) {
            wait();
          }
          synchronized (this.a)
          {
            AudioPlayback.BufferQueue.Item localItem;
            for (;;)
            {
              localItem = this.this$0.b.a();
              if (localItem != null) {
                break;
              }
              this.a.wait();
            }
            this.this$0.b(localItem.a, localItem.b);
            this.this$0.b.a(localItem);
          }
          interrupt();
        }
        finally {}
      }
      catch (InterruptedException localInterruptedException)
      {
        label98:
        break label98;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.AudioPlayback.AudioThread
 * JD-Core Version:    0.7.0.1
 */