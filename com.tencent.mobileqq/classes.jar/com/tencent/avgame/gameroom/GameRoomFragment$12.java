package com.tencent.avgame.gameroom;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class GameRoomFragment$12
  extends CountDownTimer
{
  GameRoomFragment$12(GameRoomFragment paramGameRoomFragment, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish() {}
  
  public void onTick(long paramLong)
  {
    int i = (int)(paramLong / 1000L);
    Object localObject = this.a.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("s");
    ((TextView)localObject).setText(localStringBuilder.toString());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CountDownTimer remainSeconds = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("GameRoomFragment", 2, ((StringBuilder)localObject).toString());
    }
    if ((i <= 10) && (i > 0)) {
      this.a.a();
    }
    if (i == 0) {
      GameRoomFragment.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.12
 * JD-Core Version:    0.7.0.1
 */