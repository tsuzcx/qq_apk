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
import com.tencent.avgame.qav.IAVGameBusinessCtrl;
import com.tencent.avgame.qav.IAVGameMediaPlayerCtrl;
import com.tencent.avgame.qav.IAVGameMediaPlayerCtrl.PushDecodeMsg;
import com.tencent.avgame.video.api.IVideoRouter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class GuessStarClickStagePresenter
  implements IGameStagePresenter
{
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  IStagePresenter jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
  GuessStarClickStageView jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView;
  IAVGameMediaPlayerCtrl.PushDecodeMsg jdField_a_of_type_ComTencentAvgameQavIAVGameMediaPlayerCtrl$PushDecodeMsg;
  boolean jdField_a_of_type_Boolean = false;
  
  public GuessStarClickStagePresenter(GuessStarClickStageView paramGuessStarClickStageView)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView = paramGuessStarClickStageView;
  }
  
  private void a(IAVGameMediaPlayerCtrl.PushDecodeMsg paramPushDecodeMsg, boolean paramBoolean)
  {
    if (IAVGameBusinessCtrl.f()) {
      return;
    }
    IAVGameMediaPlayerCtrl localIAVGameMediaPlayerCtrl2 = IAVGameBusinessCtrl.a().a();
    int i;
    if ((GameEngine.a().f()) && (!GameEngine.a().g())) {
      i = 1;
    } else {
      i = 0;
    }
    IAVGameMediaPlayerCtrl localIAVGameMediaPlayerCtrl1 = localIAVGameMediaPlayerCtrl2;
    if (localIAVGameMediaPlayerCtrl2 == null)
    {
      localIAVGameMediaPlayerCtrl1 = localIAVGameMediaPlayerCtrl2;
      if (i != 0) {
        localIAVGameMediaPlayerCtrl1 = ((IVideoRouter)GameEngine.a().a(SurvivalAssistManager.b)).getAVGameMediaPlayerCtrl();
      }
    }
    if (localIAVGameMediaPlayerCtrl1 != null)
    {
      if (paramPushDecodeMsg == null) {
        return;
      }
      if (paramBoolean)
      {
        localIAVGameMediaPlayerCtrl1.a(paramPushDecodeMsg);
        if (QLog.isColorLevel()) {
          QLog.i("GuessStarClickStagePresenter", 2, "changeVideoEndListener run ,registerPushDecideMsgListener");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("GuessStarClickStagePresenter", 2, "changeVideoEndListener run ,unRegisterPushDecideMsgListener");
        }
        localIAVGameMediaPlayerCtrl1.b(paramPushDecodeMsg);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    a(this.jdField_a_of_type_ComTencentAvgameQavIAVGameMediaPlayerCtrl$PushDecodeMsg, paramBoolean);
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentAvgameQavIAVGameMediaPlayerCtrl$PushDecodeMsg = null;
    }
  }
  
  private void g(EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameQavIAVGameMediaPlayerCtrl$PushDecodeMsg = new GuessStarClickStagePresenter.2(this, paramEngineData);
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
      return "";
    }
    paramEngineData = paramContext.n;
    paramContext = paramEngineData;
    if (!TextUtils.isEmpty(paramEngineData))
    {
      paramContext = paramEngineData;
      if (paramEngineData.contains("\\n")) {
        paramContext = paramEngineData.replace("\\n", "\n");
      }
    }
    if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("getGamePrepareBottomTip result = ");
      paramEngineData.append(paramContext);
      QLog.d("GuessStarClickStagePresenter", 2, paramEngineData.toString());
    }
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
      return paramContext.getResources().getString(2131690339);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramEngineData.e() + 1);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramEngineData.f());
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView.setTitleRight((String)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRealStartGame topicDuration = ");
      ((StringBuilder)localObject).append(paramEngineData.a().f());
      ((StringBuilder)localObject).append(",statusPassedTime = ");
      ((StringBuilder)localObject).append(paramEngineData.a().d());
      QLog.i("GuessStarClickStagePresenter", 2, ((StringBuilder)localObject).toString());
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
      if (paramEngineData.a().d() > paramEngineData.a().f()) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView.a(), paramEngineData.s() * 1000, paramEngineData.a().d() - paramEngineData.a().f());
      } else {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView.a().setVisibility(4);
      }
      this.jdField_a_of_type_Boolean = true;
      ThreadManager.getSubThreadHandler().post(new GuessStarClickStagePresenter.1(this, paramEngineData));
    }
    else
    {
      b(false);
      g(paramEngineData);
      b(true);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView.b(false);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSwitchTopic topicDuration = ");
      ((StringBuilder)localObject).append(paramEngineData.a().f());
      ((StringBuilder)localObject).append(",statusPassedTime = ");
      ((StringBuilder)localObject).append(paramEngineData.a().d());
      ((StringBuilder)localObject).append("getDurationForClickPanelShow = ");
      ((StringBuilder)localObject).append(paramEngineData.s() * 1000);
      QLog.i("GuessStarClickStagePresenter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramEngineData.e() + 1);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramEngineData.f());
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarClickStageView.setTitleRight((String)localObject);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().k(paramEngineData);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarClickStagePresenter
 * JD-Core Version:    0.7.0.1
 */