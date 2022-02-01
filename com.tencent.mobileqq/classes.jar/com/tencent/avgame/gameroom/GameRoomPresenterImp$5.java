package com.tencent.avgame.gameroom;

import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gameroom.pkstage.ISurvivalStagePresenter;
import com.tencent.avgame.gameroom.seat.ISeatPresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;

class GameRoomPresenterImp$5
  implements Runnable
{
  GameRoomPresenterImp$5(GameRoomPresenterImp paramGameRoomPresenterImp, EngineData paramEngineData) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(this.a);
    this.this$0.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(this.a);
    if (this.this$0.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter != null) {
      this.this$0.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomPresenterImp.5
 * JD-Core Version:    0.7.0.1
 */