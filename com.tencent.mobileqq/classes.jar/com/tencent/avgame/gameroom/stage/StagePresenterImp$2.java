package com.tencent.avgame.gameroom.stage;

import android.view.View;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.overlay.IOverlayPresenter;
import com.tencent.qphone.base.util.QLog;

class StagePresenterImp$2
  implements Runnable
{
  StagePresenterImp$2(StagePresenterImp paramStagePresenterImp) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StagePresenterImp", 2, "realStartRunnale");
    }
    View localView = this.this$0.b.e().b();
    this.this$0.b.g().c(localView);
    this.this$0.b.e().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.StagePresenterImp.2
 * JD-Core Version:    0.7.0.1
 */