package com.tencent.avgame.gameresult;

import android.app.Activity;
import com.tencent.avgame.business.observer.UserInfoObserver;
import com.tencent.avgame.floatwindow.FloatWindowController;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.qav.videorecord.SimpleGameRoomStatusListener;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.qphone.base.util.QLog;

public class GameResultPKPresenterImp
  implements IGameResultPresenter
{
  protected IGameResultView a;
  protected SimpleGameRoomStatusListener b = new GameResultPKPresenterImp.2(this);
  private UserInfoObserver c = new GameResultPKPresenterImp.1(this);
  
  public GameResultPKPresenterImp(IGameResultView paramIGameResultView)
  {
    this.a = paramIGameResultView;
  }
  
  private void a()
  {
    EngineData localEngineData = GameEngine.a().s();
    GameEngine.a().a(localEngineData.n());
  }
  
  public void a(int paramInt, String paramString1, String paramString2) {}
  
  public void b()
  {
    SurvivalPkResultInfo localSurvivalPkResultInfo = GameEngine.a().s().Z();
    GameEngine.a().f().addObserver(this.c, false);
    IGameResultView localIGameResultView = this.a;
    if ((localIGameResultView instanceof GamePKResultFragment)) {
      ((GamePKResultFragment)localIGameResultView).a(localSurvivalPkResultInfo);
    }
    GameEngine.a().a(this.b);
  }
  
  public void c()
  {
    GameEngine.a().f().removeObserver(this.c);
    GameEngine.a().b(this.b);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameResultPKPresenterImp", 1, "playAgain");
    }
    GameEngine.a().s().c();
    GameEngine.a().x();
  }
  
  public boolean f()
  {
    return GameEngine.a().r();
  }
  
  public void g()
  {
    if (this.a != null) {
      FloatWindowController.c().a(this.a.d(), false, true);
    }
  }
  
  public void h()
  {
    a();
    QLog.i("GameResultPKPresenterImp", 1, "exitGameRoom from result.");
    GameEngine.a().a(false, 1);
    if (this.a.d() != null) {
      this.a.d().finish();
    }
  }
  
  public void i()
  {
    GameEngine.a().q();
    BaseAVGameAppInterface localBaseAVGameAppInterface = GameEngine.a().f();
    String str = localBaseAVGameAppInterface.getCurrentAccountUin();
    this.a.a(localBaseAVGameAppInterface, 0L, str, 0, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultPKPresenterImp
 * JD-Core Version:    0.7.0.1
 */