package com.tencent.avgame.gameroom.stage.guessstar;

import android.os.Handler;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.qav.AVGameMediaPlayerCtrl.PushDecodeMsg;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.qphone.base.util.QLog;

class GuessStarClickStagePresenter$2
  implements AVGameMediaPlayerCtrl.PushDecodeMsg
{
  GuessStarClickStagePresenter$2(GuessStarClickStagePresenter paramGuessStarClickStagePresenter, EngineData paramEngineData) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GuessStarClickStagePresenter", 2, "onPushVideoFirstFrame run ,topicAnswerDuration = " + this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.s() + ",statusPassedTime = " + this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a().d());
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong) {}
  
  public void b(String paramString)
  {
    AVGameHandler.a().b().post(new GuessStarClickStagePresenter.2.1(this, this));
  }
  
  public void c(String paramString) {}
  
  public void d(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarClickStagePresenter.2
 * JD-Core Version:    0.7.0.1
 */