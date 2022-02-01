package com.tencent.avgame.gameresult;

import com.tencent.qphone.base.util.QLog;

class GameResultFragment$1
  implements Runnable
{
  GameResultFragment$1(GameResultFragment paramGameResultFragment, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetGameRankingListFail gameId: ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", errMsg: ");
      localStringBuilder.append(this.b);
      QLog.i("GameResultFragment", 2, localStringBuilder.toString());
    }
    GameResultFragment.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultFragment.1
 * JD-Core Version:    0.7.0.1
 */