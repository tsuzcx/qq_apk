package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;

class ProgressControler$3
  extends TimerTask
{
  ProgressControler$3(ProgressControler paramProgressControler) {}
  
  public void run()
  {
    ProgressControler localProgressControler = this.this$0;
    localProgressControler.c += 50L;
    if (this.this$0.c >= this.this$0.b)
    {
      localProgressControler = this.this$0;
      localProgressControler.c = localProgressControler.b;
      if (this.this$0.f != null) {
        this.this$0.f.cancel();
      }
    }
    this.this$0.g.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.ProgressControler.3
 * JD-Core Version:    0.7.0.1
 */