package com.tencent.avgame.gameroom;

import com.tencent.avgame.ui.IAVGameRootContainer;
import com.tencent.mobileqq.widget.QQToast;

class GameRoomFragment$13
  implements Runnable
{
  GameRoomFragment$13(GameRoomFragment paramGameRoomFragment, int paramInt, String paramString) {}
  
  public void run()
  {
    IAVGameRootContainer localIAVGameRootContainer;
    if (this.this$0.getQBaseActivity() != null) {
      localIAVGameRootContainer = (IAVGameRootContainer)this.this$0.getQBaseActivity();
    } else {
      localIAVGameRootContainer = null;
    }
    if ((localIAVGameRootContainer != null) && (!localIAVGameRootContainer.checkDestroyed())) {
      QQToast.makeText(this.this$0.getQBaseActivity(), this.a, this.b, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.13
 * JD-Core Version:    0.7.0.1
 */