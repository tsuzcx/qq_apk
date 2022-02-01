package com.tencent.avgame.gameroom.stage.guesssong;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.TopicBase;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IGameStageView;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GuessSongClickStagePresenter
  implements IGameStagePresenter
{
  IGameStageView jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView;
  IStagePresenter jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
  
  public GuessSongClickStagePresenter(IGameStageView paramIGameStageView)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView = paramIGameStageView;
  }
  
  public IStagePresenter a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
  }
  
  public String a(Context paramContext, EngineData paramEngineData)
  {
    paramContext = "";
    Object localObject = paramEngineData.a();
    if (localObject == null)
    {
      QLog.e("GuessSongHBStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localObject = BaseApplicationImpl.getContext().getResources().getString(2131690420);
        QLog.e("GuessSongHBStagePresenter", 1, "getGamePrepareBottomTip tips isEmpty");
      }
      paramContext = paramEngineData.c();
      if (TextUtils.isEmpty(paramContext)) {
        break label98;
      }
      paramContext = paramContext + "\n";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramContext)) {
        break label109;
      }
      return localObject;
      paramContext = ((GameItem)localObject).n;
      break;
      label98:
      QLog.e("GuessSongHBStagePresenter", 1, "songTypeString tips isEmpty");
    }
    label109:
    return paramContext + (String)localObject;
  }
  
  public String a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessSongHBStagePresenter", 2, "getGameRuleAnswerTip null context");
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
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(paramITopic);
  }
  
  public void a(EngineData paramEngineData)
  {
    a(GameEngine.a(paramEngineData), false);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().e(false);
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
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().e(false);
    String str = paramEngineData.e() + 1 + "/" + paramEngineData.f();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.setTitleRight(str);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(), paramEngineData.a().f(), paramEngineData.a().d());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().k(paramEngineData);
  }
  
  public void c(EngineData paramEngineData)
  {
    a(GameEngine.a(paramEngineData), true);
    a(paramEngineData.a());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(), paramEngineData.a().f(), paramEngineData.a().d());
    String str = paramEngineData.e() + 1 + "/" + paramEngineData.f();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.setTitleRight(str);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().k(paramEngineData);
  }
  
  public void d(EngineData paramEngineData) {}
  
  public void e(EngineData paramEngineData) {}
  
  public void f(EngineData paramEngineData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesssong.GuessSongClickStagePresenter
 * JD-Core Version:    0.7.0.1
 */