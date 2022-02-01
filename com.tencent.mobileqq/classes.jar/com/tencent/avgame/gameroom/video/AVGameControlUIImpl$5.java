package com.tencent.avgame.gameroom.video;

import android.widget.TextView;

class AVGameControlUIImpl$5
  implements Runnable
{
  AVGameControlUIImpl$5(AVGameControlUIImpl paramAVGameControlUIImpl, int paramInt, String paramString) {}
  
  public void run()
  {
    if (AVGameControlUIImpl.f(this.this$0).isShown())
    {
      String str = String.format("翻译耗时:%d ms 翻译结果:%s ", new Object[] { Integer.valueOf(this.a), this.b });
      AVGameControlUIImpl.f(this.this$0).setText(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.5
 * JD-Core Version:    0.7.0.1
 */