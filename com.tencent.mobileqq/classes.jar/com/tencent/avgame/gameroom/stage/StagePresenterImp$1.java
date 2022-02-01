package com.tencent.avgame.gameroom.stage;

import android.os.Build.VERSION;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.av.audioprocess.api.IAudioProcessApi;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.qphone.base.util.QLog;

class StagePresenterImp$1
  implements Runnable
{
  StagePresenterImp$1(StagePresenterImp paramStagePresenterImp) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StagePresenterImp", 2, "realStartRunnale");
    }
    EngineData localEngineData = GameEngine.a().a();
    if (!localEngineData.a()) {
      return;
    }
    StagePresenterImp.a(this.this$0, localEngineData);
    if (localEngineData.d(GameEngine.a().a().getAccount()))
    {
      this.this$0.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a();
      this.this$0.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().b(this.this$0.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.a());
    }
    this.this$0.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().f();
    localEngineData.a().b();
    if (Build.VERSION.SDK_INT >= 16) {
      AudioProcess.a().updateRecogTxt(localEngineData.a().b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.StagePresenterImp.1
 * JD-Core Version:    0.7.0.1
 */