package com.tencent.avgame.gameresult;

import com.tencent.qphone.base.util.QLog;

class GameResultFragment$1
  implements Runnable
{
  GameResultFragment$1(GameResultFragment paramGameResultFragment, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameResultFragment", 2, "onGetGameRankingListFail gameId: " + this.a + ", errMsg: " + this.b);
    }
    GameResultFragment.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultFragment.1
 * JD-Core Version:    0.7.0.1
 */