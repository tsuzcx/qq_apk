package com.tencent.avgame.gameroom.stage.guessstar;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.controller.SurvivalAssistManager;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.TopicBase;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.qav.AVGameMediaPlayerCtrl;
import com.tencent.avgame.qav.AVGameMediaPlayerCtrl.PushDecodeMsg;
import com.tencent.avgame.video.VideoRouter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class GuessStarClickStagePresenter
  implements IGameStagePresenter
{
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  IStagePresenter jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
  GuessStarClickStageView jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView;
  AVGameMediaPlayerCtrl.PushDecodeMsg jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$PushDecodeMsg;
  boolean jdField_a_of_type_Boolean = false;
  
  public GuessStarClickStagePresenter(GuessStarClickStageView paramGuessStarClickStageView)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView = paramGuessStarClickStageView;
  }
  
  private void a(AVGameMediaPlayerCtrl.PushDecodeMsg paramPushDecodeMsg, boolean paramBoolean)
  {
    AVGameMediaPlayerCtrl localAVGameMediaPlayerCtrl2 = AVGameBusinessCtrl.b().a();
    int i;
    AVGameMediaPlayerCtrl localAVGameMediaPlayerCtrl1;
    if ((GameEngine.a().f()) && (!GameEngine.a().g()))
    {
      i = 1;
      localAVGameMediaPlayerCtrl1 = localAVGameMediaPlayerCtrl2;
      if (localAVGameMediaPlayerCtrl2 == null)
      {
        localAVGameMediaPlayerCtrl1 = localAVGameMediaPlayerCtrl2;
        if (i != 0) {
          localAVGameMediaPlayerCtrl1 = ((VideoRouter)GameEngine.a().a(SurvivalAssistManager.b)).a();
        }
      }
      if ((localAVGameMediaPlayerCtrl1 != null) && (paramPushDecodeMsg != null)) {
        break label77;
      }
    }
    label77:
    do
    {
      return;
      i = 0;
      break;
      if (!paramBoolean) {
        break label102;
      }
      localAVGameMediaPlayerCtrl1.a(paramPushDecodeMsg);
    } while (!QLog.isColorLevel());
    QLog.i("GuessStarClickStagePresenter", 2, "changeVideoEndListener run ,registerPushDecideMsgListener");
    return;
    label102:
    if (QLog.isColorLevel()) {
      QLog.i("GuessStarClickStagePresenter", 2, "changeVideoEndListener run ,unRegisterPushDecideMsgListener");
    }
    localAVGameMediaPlayerCtrl1.b(paramPushDecodeMsg);
  }
  
  private void b(boolean paramBoolean)
  {
    a(this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$PushDecodeMsg, paramBoolean);
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$PushDecodeMsg = null;
    }
  }
  
  private void g(EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$PushDecodeMsg = new GuessStarClickStagePresenter.2(this, paramEngineData);
  }
  
  public IStagePresenter a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
  }
  
  public String a(Context paramContext, EngineData paramEngineData)
  {
    paramContext = paramEngineData.a();
    if (paramContext == null)
    {
      QLog.d("GuessStarClickStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
      paramEngineData = "";
    }
    do
    {
      return paramEngineData;
      paramEngineData = paramContext.n;
      paramContext = paramEngineData;
      if (!TextUtils.isEmpty(paramEngineData))
      {
        paramContext = paramEngineData;
        if (paramEngineData.contains("\\n")) {
          paramContext = paramEngineData.replace("\\n", "\n");
        }
      }
      paramEngineData = paramContext;
    } while (!QLog.isColorLevel());
    QLog.d("GuessStarClickStagePresenter", 2, "getGamePrepareBottomTip result = " + paramContext);
    return paramContext;
  }
  
  public String a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessStarClickStagePresenter", 2, "getGameRuleAnswerTip null context");
      }
      return "";
    }
    EngineData localEngineData = GameEngine.a().a();
    ITopic localITopic = localEngineData.a();
    if ((localITopic != null) && ((localITopic instanceof TopicBase)) && (!TextUtils.isEmpty(((TopicBase)localITopic).c))) {
      return "";
    }
    if ((localEngineData.f()) && (localEngineData.p() == 0)) {
      return paramContext.getResources().getString(2131690415);
    }
    return "";
  }
  
  public void a(ITopic paramITopic)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView.a(paramITopic);
  }
  
  public void a(EngineData paramEngineData)
  {
    a(GameEngine.a(paramEngineData), false);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().e(false);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().m(paramEngineData);
  }
  
  public void a(IStagePresenter paramIStagePresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter = paramIStagePresenter;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView.a(paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void b(EngineData paramEngineData)
  {
    b(false);
    g(paramEngineData);
    b(true);
    a(GameEngine.a(paramEngineData), true);
    a(paramEngineData.a());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView.b(false);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().e(false);
    String str = paramEngineData.e() + 1 + "/" + paramEngineData.f();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView.setTitleRight(str);
    if (QLog.isColorLevel()) {
      QLog.i("GuessStarClickStagePresenter", 2, "onRealStartGame topicDuration = " + paramEngineData.a().f() + ",statusPassedTime = " + paramEngineData.a().d());
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().k(paramEngineData);
  }
  
  public void c(EngineData paramEngineData)
  {
    a(GameEngine.a(paramEngineData), true);
    a(paramEngineData.a());
    int i = paramEngineData.a();
    if ((!paramEngineData.h()) && ((i == 3) || (i == 4) || ((i == 2) && (paramEngineData.a().d() >= paramEngineData.a().f()))))
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView.b(true);
      if (QLog.isColorLevel()) {
        QLog.i("GuessStarClickStagePresenter", 2, "onSwitchTopic restore");
      }
      if (paramEngineData.a().d() > paramEngineData.a().f())
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView.a(), paramEngineData.s() * 1000, paramEngineData.a().d() - paramEngineData.a().f());
        this.jdField_a_of_type_Boolean = true;
        ThreadManager.getSubThreadHandler().post(new GuessStarClickStagePresenter.1(this, paramEngineData));
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GuessStarClickStagePresenter", 2, "onSwitchTopic topicDuration = " + paramEngineData.a().f() + ",statusPassedTime = " + paramEngineData.a().d() + "getDurationForClickPanelShow = " + paramEngineData.s() * 1000);
      }
      String str = paramEngineData.e() + 1 + "/" + paramEngineData.f();
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView.setTitleRight(str);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().k(paramEngineData);
      return;
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView.a().setVisibility(4);
      break;
      b(false);
      g(paramEngineData);
      b(true);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView.b(false);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void d(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessStarClickStagePresenter", 2, "onAnswerRight run");
    }
  }
  
  public void e(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessStarClickStagePresenter", 2, "onAnswerTimeOut run");
    }
  }
  
  public void f(EngineData paramEngineData)
  {
    b(false);
    if (QLog.isColorLevel()) {
      QLog.d("GuessStarClickStagePresenter", 2, "onGameOver run");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarClickStagePresenter
 * JD-Core Version:    0.7.0.1
 */