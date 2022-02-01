package com.tencent.TMG.sdk;

import android.os.Handler;
import android.util.Log;

class AVContextImpl$2
  implements Runnable
{
  AVContextImpl$2(AVContextImpl paramAVContextImpl) {}
  
  public void run()
  {
    if ((AVContextImpl.access$100(this.this$0)) && (this.this$0.getRoom() != null))
    {
      Log.d("tips", this.this$0.getRoom().getQualityTips());
      AVContextImpl.access$200(this.this$0).postDelayed(this, 30000L);
    }
    while (this.this$0.getRoom() != null) {
      return;
    }
    AVContextImpl.access$300(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVContextImpl.2
 * JD-Core Version:    0.7.0.1
 */