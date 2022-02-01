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
      localStringBuilder.append(this.b.a.aj());
      localStringBuilder.append(",statusPassedTime = ");
      localStringBuilder.append(this.b.a.h().n());
      QLog.i("GuessStarClickStagePresenter", 2, localStringBuilder.toString());
    }
    this.b.b.b.b(true);
    this.b.b.a.a(this.b.b.b.getTopicClockView(), this.b.a.aj() * 1000, 0L);
    GuessStarClickStagePresenter.a(this.b.b, this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarClickStagePresenter.2.1
 * JD-Core Version:    0.7.0.1
 */