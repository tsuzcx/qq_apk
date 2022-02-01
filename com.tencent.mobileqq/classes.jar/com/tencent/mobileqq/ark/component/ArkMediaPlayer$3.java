package com.tencent.mobileqq.ark.component;

class ArkMediaPlayer$3
  implements Runnable
{
  ArkMediaPlayer$3(ArkMediaPlayer paramArkMediaPlayer) {}
  
  public void run()
  {
    if (ArkMediaPlayer.a(this.this$0)) {
      return;
    }
    ArkMediaPlayer.a(this.this$0, true);
    if (ArkMediaPlayer.a(this.this$0) == 1) {
      this.this$0.Play();
    } else if (ArkMediaPlayer.a(this.this$0) == 2) {
      this.this$0.Stop();
    } else if (ArkMediaPlayer.a(this.this$0) == 4) {
      this.this$0.Resume();
    } else if (ArkMediaPlayer.a(this.this$0) == 3) {
      this.this$0.Pause();
    }
    ArkMediaPlayer.a(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.component.ArkMediaPlayer.3
 * JD-Core Version:    0.7.0.1
 */