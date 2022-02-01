package com.tencent.avgame.gameroom.stage.guessstar;

import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.qav.IAVGameMediaPlayerCtrl.PushDecodeMsg;
import com.tencent.qphone.base.util.QLog;

class GuessStarClickStagePresenter$2$1
  implements Runnable
{
  GuessStarClickStagePresenter$2$1(GuessStarClickStagePresenter.2 param2, IAVGameMediaPlayerCtrl.PushDecodeMsg paramPushDecodeMsg) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPushVideoFrameEnd run ,topicAnswerDuration = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStagePresenter$2.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.s());
      localStringBuilder.append(",statusPassedTime = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStagePresenter$2.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a().d());
      QLog.i("GuessStarClickStagePresenter", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStagePresenter$2.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStagePresenter.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView.b(true);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStagePresenter$2.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStagePresenter.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStagePresenter$2.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStagePresenter.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView.a(), this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStagePresenter$2.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.s() * 1000, 0L);
    GuessStarClickStagePresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStagePresenter$2.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStagePresenter, this.jdField_a_of_type_ComTencentAvgameQavIAVGameMediaPlayerCtrl$PushDecodeMsg, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarClickStagePresenter.2.1
 * JD-Core Version:    0.7.0.1
 */