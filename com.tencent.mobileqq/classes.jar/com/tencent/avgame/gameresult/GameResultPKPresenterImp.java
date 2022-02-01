package com.tencent.avgame.gameresult;

import android.app.Activity;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.observer.UserInfoObserver;
import com.tencent.avgame.floatwindow.FloatWindowController;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.videorecord.SimpleGameRoomStatusListener;
import com.tencent.qphone.base.util.QLog;

public class GameResultPKPresenterImp
  implements IGameResultPresenter
{
  private UserInfoObserver a;
  protected IGameResultView a;
  protected SimpleGameRoomStatusListener a;
  
  public GameResultPKPresenterImp(IGameResultView paramIGameResultView)
  {
    this.jdField_a_of_type_ComTencentAvgameBusinessObserverUserInfoObserver = new GameResultPKPresenterImp.1(this);
    this.jdField_a_of_type_ComTencentAvgameVideorecordSimpleGameRoomStatusListener = new GameResultPKPresenterImp.2(this);
    this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultView = paramIGameResultView;
  }
  
  private void a()
  {
    EngineData localEngineData = GameEngine.a().a();
    GameEngine.a().a(localEngineData.b());
  }
  
  public void a(int paramInt, String paramString1, String paramString2) {}
  
  public boolean a()
  {
    return GameEngine.a().d();
  }
  
  public void b()
  {
    SurvivalPkResultInfo localSurvivalPkResultInfo = GameEngine.a().a().a();
    GameEngine.a().a().addObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverUserInfoObserver, false);
    if ((this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultView instanceof GamePKResultFragment)) {
      ((GamePKResultFragment)this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultView).a(localSurvivalPkResultInfo);
    }
    GameEngine.a().a(this.jdField_a_of_type_ComTencentAvgameVideorecordSimpleGameRoomStatusListener);
  }
  
  public void c()
  {
    GameEngine.a().a().removeObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverUserInfoObserver);
    GameEngine.a().b(this.jdField_a_of_type_ComTencentAvgameVideorecordSimpleGameRoomStatusListener);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameResultPKPresenterImp", 1, "playAgain");
    }
    GameEngine.a().a().c();
    GameEngine.a().l();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultView != null) {
      FloatWindowController.a().a(this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultView.a(), false, true);
    }
  }
  
  public void f()
  {
    a();
    QLog.i("GameResultPKPresenterImp", 1, "exitGameRoom from result.");
    GameEngine.a().a(false, 1);
    if (this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultView.a() != null) {
      this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultView.a().finish();
    }
  }
  
  public void g()
  {
    GameEngine.a().d();
    AVGameAppInterface localAVGameAppInterface = GameEngine.a().a();
    String str = localAVGameAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultView.a(localAVGameAppInterface, 0L, str, 0, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultPKPresenterImp
 * JD-Core Version:    0.7.0.1
 */