package com.tencent.avgame.gamelogic.data;

import android.os.CountDownTimer;
import android.os.SystemClock;

class Game$2
  extends CountDownTimer
{
  Game$2(Game paramGame, long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    int i = (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
    Game.b(this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame, this.jdField_a_of_type_Int - i);
  }
  
  public void onTick(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.Game.2
 * JD-Core Version:    0.7.0.1
 */