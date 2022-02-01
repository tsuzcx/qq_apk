package com.tencent.ark;

class ArkPlayer$3
  implements Runnable
{
  ArkPlayer$3(ArkPlayer paramArkPlayer, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    ark.PlayerStateChange(this.this$0.mStateCallback, this.this$0.mStateUserdata, this.val$oldState, this.val$state);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkPlayer.3
 * JD-Core Version:    0.7.0.1
 */