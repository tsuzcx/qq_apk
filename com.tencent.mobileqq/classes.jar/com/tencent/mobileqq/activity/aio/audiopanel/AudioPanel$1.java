package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.mobileqq.transfile.PttInfoCollector;

class AudioPanel$1
  implements Runnable
{
  AudioPanel$1(AudioPanel paramAudioPanel, int paramInt) {}
  
  public void run()
  {
    PttInfoCollector.reportRecordCounts(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel.1
 * JD-Core Version:    0.7.0.1
 */