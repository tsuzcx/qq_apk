package com.tencent.avgame.gameroom.stage.guessstar;

import android.os.Handler;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.qav.IAVGameMediaPlayerCtrl.PushDecodeMsg;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.qphone.base.util.QLog;

class GuessStarClickStagePresenter$2
  implements IAVGameMediaPlayerCtrl.PushDecodeMsg
{
  GuessStarClickStagePresenter$2(GuessStarClickStagePresenter paramGuessStarClickStagePresenter, EngineData paramEngineData) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onPushVideoFirstFrame run ,topicAnswerDuration = ");
      paramString.append(this.a.aj());
      paramString.append(",statusPassedTime = ");
      paramString.append(this.a.h().n());
      QLog.i("GuessStarClickStagePresenter", 2, paramString.toString());
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong) {}
  
  public void b(String paramString)
  {
    AVGameHandler.a().c().post(new GuessStarClickStagePresenter.2.1(this, this));
  }
  
  public void c(String paramString) {}
  
  public void d(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarClickStagePresenter.2
 * JD-Core Version:    0.7.0.1
 */