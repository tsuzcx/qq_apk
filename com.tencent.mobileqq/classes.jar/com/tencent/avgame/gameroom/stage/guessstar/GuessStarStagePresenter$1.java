package com.tencent.avgame.gameroom.stage.guessstar;

import android.content.res.Resources;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.qav.IAVGameBusinessCtrl;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

class GuessStarStagePresenter$1
  implements Runnable
{
  GuessStarStagePresenter$1(GuessStarStagePresenter paramGuessStarStagePresenter) {}
  
  public void run()
  {
    if ((GuessStarStagePresenter.a(this.this$0)) && (this.this$0.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter != null) && (this.this$0.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView != null))
    {
      if (!(this.this$0.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView instanceof GuessStarStageView)) {
        return;
      }
      if (!((GuessStarStageView)this.this$0.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView).isShown()) {
        return;
      }
      if (IAVGameBusinessCtrl.f()) {
        return;
      }
      Object localObject = IAVGameBusinessCtrl.a().a();
      if ((localObject != null) && (!((AVGameSession)localObject).e))
      {
        localObject = MobileQQ.sMobileQQ;
        localObject = MobileQQ.getContext().getResources().getString(2131690405);
        this.this$0.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().a((String)localObject);
        GuessStarStagePresenter.a(this.this$0, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarStagePresenter.1
 * JD-Core Version:    0.7.0.1
 */