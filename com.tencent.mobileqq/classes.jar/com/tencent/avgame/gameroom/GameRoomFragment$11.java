package com.tencent.avgame.gameroom;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class GameRoomFragment$11
  extends CountDownTimer
{
  GameRoomFragment$11(GameRoomFragment paramGameRoomFragment, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish() {}
  
  public void onTick(long paramLong)
  {
    int i = (int)(paramLong / 1000L);
    this.a.d.setText(i + "s");
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "CountDownTimer remainSeconds = " + i);
    }
    if ((i <= 10) && (i > 0)) {
      this.a.a();
    }
    if (i == 0) {
      GameRoomFragment.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.11
 * JD-Core Version:    0.7.0.1
 */