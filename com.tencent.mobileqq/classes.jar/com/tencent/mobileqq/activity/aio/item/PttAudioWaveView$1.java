package com.tencent.mobileqq.activity.aio.item;

import android.view.View.OnLongClickListener;

class PttAudioWaveView$1
  implements Runnable
{
  PttAudioWaveView$1(PttAudioWaveView paramPttAudioWaveView) {}
  
  public void run()
  {
    PttAudioWaveView localPttAudioWaveView = this.this$0;
    localPttAudioWaveView.l = true;
    PttAudioWaveView.a(localPttAudioWaveView, false);
    if (this.this$0.b != null) {
      this.this$0.b.onLongClick(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttAudioWaveView.1
 * JD-Core Version:    0.7.0.1
 */