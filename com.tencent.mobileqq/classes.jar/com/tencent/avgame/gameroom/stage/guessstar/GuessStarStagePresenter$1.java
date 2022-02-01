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
    if ((GuessStarStagePresenter.a(this.this$0)) && (this.this$0.a != null) && (this.this$0.b != null))
    {
      if (!(this.this$0.b instanceof GuessStarStageView)) {
        return;
      }
      if (!((GuessStarStageView)this.this$0.b).isShown()) {
        return;
      }
      if (IAVGameBusinessCtrl.q()) {
        return;
      }
      Object localObject = IAVGameBusinessCtrl.p().j();
      if ((localObject != null) && (!((AVGameSession)localObject).i))
      {
        localObject = MobileQQ.sMobileQQ;
        localObject = MobileQQ.getContext().getResources().getString(2131887316);
        this.this$0.a.a().b((String)localObject);
        GuessStarStagePresenter.a(this.this$0, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarStagePresenter.1
 * JD-Core Version:    0.7.0.1
 */