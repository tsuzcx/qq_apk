package com.tencent.avgame.gameroom;

import android.os.Handler;
import bijk;
import com.tencent.qphone.base.util.QLog;
import mzl;
import ncl;

public class GameRoomPresenterImp$3
  implements Runnable
{
  public GameRoomPresenterImp$3(ncl paramncl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "mRefreshGameListRunnable run");
    }
    mzl.a().d();
    this.this$0.a.sendEmptyMessage(4);
    long l = mzl.a().a();
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "mRefreshGameListRunnable run and next nextRefreshInterval is " + l);
    }
    if (l == 0L)
    {
      ncl.a(this.this$0);
      if (ncl.b(this.this$0) < 5) {
        break label105;
      }
    }
    label105:
    while (l == 9223372036854775807L)
    {
      return;
      ncl.a(this.this$0, 0);
    }
    bijk.a().postDelayed(this, l * 1000L + 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomPresenterImp.3
 * JD-Core Version:    0.7.0.1
 */