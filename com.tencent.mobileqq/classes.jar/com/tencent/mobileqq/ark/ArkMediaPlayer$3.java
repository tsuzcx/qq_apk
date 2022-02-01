package com.tencent.mobileqq.ark;

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
    }
    for (;;)
    {
      ArkMediaPlayer.a(this.this$0, 0);
      return;
      if (ArkMediaPlayer.a(this.this$0) == 2) {
        this.this$0.Stop();
      } else if (ArkMediaPlayer.a(this.this$0) == 4) {
        this.this$0.Resume();
      } else if (ArkMediaPlayer.a(this.this$0) == 3) {
        this.this$0.Pause();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkMediaPlayer.3
 * JD-Core Version:    0.7.0.1
 */