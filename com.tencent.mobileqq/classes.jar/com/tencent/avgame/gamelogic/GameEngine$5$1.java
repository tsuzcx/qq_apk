package com.tencent.avgame.gamelogic;

import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.app.MobileQQ;

class GameEngine$5$1
  implements Runnable
{
  GameEngine$5$1(GameEngine.5 param5) {}
  
  public void run()
  {
    int i;
    if (NetworkUtil.isNetworkAvailable()) {
      i = 2131690331;
    } else {
      i = 2131690403;
    }
    String str = MobileQQ.sMobileQQ.getString(i);
    this.a.a.a(10, str, this.a.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.GameEngine.5.1
 * JD-Core Version:    0.7.0.1
 */