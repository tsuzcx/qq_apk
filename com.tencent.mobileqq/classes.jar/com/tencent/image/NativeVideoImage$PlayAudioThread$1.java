package com.tencent.image;

import com.tencent.qphone.base.util.QLog;

class NativeVideoImage$PlayAudioThread$1
  implements Runnable
{
  NativeVideoImage$PlayAudioThread$1(NativeVideoImage.PlayAudioThread paramPlayAudioThread) {}
  
  public void run()
  {
    if (this.this$1.this$0.mPlayOnceListener != null)
    {
      this.this$1.this$0.mPlayOnceListener.onFinish();
      this.this$1.this$0.mPlayOnceListener = null;
      if (QLog.isColorLevel()) {
        QLog.e(NativeVideoImage.TAG_AUDIO, 2, "seekToNextAudioFrame, mPlayOnceListener.onFinish()");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.NativeVideoImage.PlayAudioThread.1
 * JD-Core Version:    0.7.0.1
 */