package com.tencent.avgame.gameroom;

import android.os.Handler;
import bjum;
import com.tencent.qphone.base.util.QLog;
import nfc;
import nii;

public class GameRoomPresenterImp$3
  implements Runnable
{
  public GameRoomPresenterImp$3(nii paramnii) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "mRefreshGameListRunnable run");
    }
    nfc.a().d();
    this.this$0.a.sendEmptyMessage(4);
    long l = nfc.a().a();
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "mRefreshGameListRunnable run and next nextRefreshInterval is " + l);
    }
    if (l == 0L)
    {
      nii.a(this.this$0);
      if (nii.b(this.this$0) < 5) {
        break label105;
      }
    }
    label105:
    while (l == 9223372036854775807L)
    {
      return;
      nii.a(this.this$0, 0);
    }
    bjum.a().postDelayed(this, l * 1000L + 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomPresenterImp.3
 * JD-Core Version:    0.7.0.1
 */