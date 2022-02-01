package com.tencent.avgame.gameroom.stage.guessstar;

import android.content.res.Resources;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

class GuessStarStagePresenter$1
  implements Runnable
{
  GuessStarStagePresenter$1(GuessStarStagePresenter paramGuessStarStagePresenter) {}
  
  public void run()
  {
    if ((!GuessStarStagePresenter.a(this.this$0)) || (this.this$0.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter == null) || (this.this$0.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView == null) || (!(this.this$0.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView instanceof GuessStarStageView))) {}
    do
    {
      do
      {
        return;
      } while (!((GuessStarStageView)this.this$0.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView).isShown());
      localObject = AVGameBusinessCtrl.b().a();
    } while ((localObject == null) || (((AVGameSession)localObject).e));
    Object localObject = BaseApplicationImpl.getContext().getResources().getString(2131690481);
    this.this$0.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().a((String)localObject);
    GuessStarStagePresenter.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarStagePresenter.1
 * JD-Core Version:    0.7.0.1
 */