package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

class AudioPlayback$AudioThread
  extends Thread
{
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean = true;
  
  AudioPlayback$AudioThread(AudioPlayback paramAudioPlayback)
  {
    super("AudioPlayback");
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notify();
      return;
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
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
          while (this.jdField_a_of_type_Boolean) {
            wait();
          }
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            AudioPlayback.BufferQueue.Item localItem;
            for (;;)
            {
              localItem = this.this$0.a.a();
              if (localItem != null) {
                break;
              }
              this.jdField_a_of_type_JavaLangObject.wait();
            }
            this.this$0.b(localItem.jdField_a_of_type_JavaNioByteBuffer, localItem.jdField_a_of_type_Long);
            this.this$0.a.a(localItem);
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