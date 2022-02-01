package com.tencent.avgame.gameroom.stage.guessstar;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameInfo;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.TopicBase;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IGameStageView;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.qphone.base.util.QLog;

public class GuessStarStagePresenter
  implements IGameStagePresenter
{
  IGameStageView jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView;
  IStagePresenter jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GuessStarStagePresenter.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  
  public GuessStarStagePresenter(IGameStageView paramIGameStageView)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView = paramIGameStageView;
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
      QLog.d("GuessStarStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
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
      QLog.d("GuessStarStagePresenter", 2, paramEngineData.toString());
    }
    return paramContext;
  }
  
  public String a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessStarStagePresenter", 2, "getGameRuleAnswerTip null context");
      }
      return "";
    }
    String str = paramContext.getResources().getString(2131690263);
    EngineData localEngineData = GameEngine.a().a();
    ITopic localITopic = localEngineData.a();
    if ((localITopic != null) && ((localITopic instanceof TopicBase)) && (!TextUtils.isEmpty(((TopicBase)localITopic).c))) {
      return "";
    }
    if ((localEngineData.f()) && (localEngineData.p() == 0)) {
      return paramContext.getResources().getString(2131690338);
    }
    if (localEngineData.f()) {
      return "";
    }
    return str;
  }
  
  public void a()
  {
    AVGameHandler.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(int paramInt)
  {
    AVGameHandler.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    AVGameHandler.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramInt);
  }
  
  public void a(ITopic paramITopic)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(paramITopic);
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
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(paramBoolean1, paramBoolean2);
    if (!paramBoolean2) {
      a();
    }
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
    a(GameEngine.a(paramEngineData), true);
    a(paramEngineData.a());
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a())
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().e(false);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramEngineData.e() + 1);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramEngineData.f());
      localObject = ((StringBuilder)localObject).toString();
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.setTitleRight((String)localObject);
    }
    else if (paramEngineData.a().a.a())
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().e(true);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().a(paramEngineData.a().a.c * 1000, paramEngineData.a().e());
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().e(true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramEngineData.e() + 1);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramEngineData.f());
      localObject = ((StringBuilder)localObject).toString();
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().b((String)localObject);
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(), paramEngineData.a().f(), paramEngineData.a().d());
    this.jdField_a_of_type_Boolean = true;
    int i = paramEngineData.a().f() - paramEngineData.a().d() - 5000;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRealStartGame delayMs = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",topicDuration = ");
      ((StringBuilder)localObject).append(paramEngineData.a().f());
      ((StringBuilder)localObject).append(",statusPassedTime = ");
      ((StringBuilder)localObject).append(paramEngineData.a().d());
      QLog.i("GuessStarStagePresenter", 2, ((StringBuilder)localObject).toString());
    }
    if (i > 0) {
      a(i);
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().k(paramEngineData);
  }
  
  public void c(EngineData paramEngineData)
  {
    a(GameEngine.a(paramEngineData), true);
    a(paramEngineData.a());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(), paramEngineData.a().f(), paramEngineData.a().d());
    int i = paramEngineData.a().f() - paramEngineData.a().d() - 5000;
    if ((i > 0) && (this.jdField_a_of_type_Boolean)) {
      a(i);
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSwitchTopic delayMs = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",topicDuration = ");
      ((StringBuilder)localObject).append(paramEngineData.a().f());
      ((StringBuilder)localObject).append(",statusPassedTime = ");
      ((StringBuilder)localObject).append(paramEngineData.a().d());
      QLog.i("GuessStarStagePresenter", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramEngineData.e() + 1);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramEngineData.f());
      localObject = ((StringBuilder)localObject).toString();
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.setTitleRight((String)localObject);
    }
    else if (paramEngineData.a().a.a())
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().a(paramEngineData.a().a.c * 1000, paramEngineData.a().e());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramEngineData.e() + 1);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramEngineData.f());
      localObject = ((StringBuilder)localObject).toString();
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().b((String)localObject);
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().k(paramEngineData);
  }
  
  public void d(EngineData paramEngineData) {}
  
  public void e(EngineData paramEngineData) {}
  
  public void f(EngineData paramEngineData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarStagePresenter
 * JD-Core Version:    0.7.0.1
 */