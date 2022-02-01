package com.tencent.mobileqq.ark.component;

class ArkMediaPlayer$4
  implements Runnable
{
  ArkMediaPlayer$4(ArkMediaPlayer paramArkMediaPlayer) {}
  
  public void run()
  {
    ArkMediaPlayer.a(this.this$0, false);
    if (this.this$0.Pause()) {
      ArkMediaPlayer.a(this.this$0, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.component.ArkMediaPlayer.4
 * JD-Core Version:    0.7.0.1
 */