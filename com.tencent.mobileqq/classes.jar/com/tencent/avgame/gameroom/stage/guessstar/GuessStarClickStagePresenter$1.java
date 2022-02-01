package com.tencent.avgame.gameroom.stage.guessstar;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.avgame.gamelogic.data.EngineData;

class GuessStarClickStagePresenter$1
  implements Runnable
{
  GuessStarClickStagePresenter$1(GuessStarClickStagePresenter paramGuessStarClickStagePresenter, EngineData paramEngineData) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView.a(this.a);
    this.this$0.jdField_a_of_type_AndroidOsHandler.post(new GuessStarClickStagePresenter.1.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarClickStagePresenter.1
 * JD-Core Version:    0.7.0.1
 */