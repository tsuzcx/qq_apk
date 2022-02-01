package com.tencent.avgame.gameroom;

import android.os.Handler;
import com.tencent.avgame.business.observer.NetObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class GameRoomPresenterImp$MyNetObserver
  extends NetObserver
{
  private final WeakReference<Handler> a;
  
  GameRoomPresenterImp$MyNetObserver(Handler paramHandler)
  {
    this.a = new WeakReference(paramHandler);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "onNetTypeChange, [" + paramInt1 + "-->" + paramInt2 + "]");
    }
    Handler localHandler = (Handler)this.a.get();
    if ((localHandler != null) && (paramInt2 != 1) && (paramInt1 == 1)) {
      localHandler.sendEmptyMessage(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomPresenterImp.MyNetObserver
 * JD-Core Version:    0.7.0.1
 */