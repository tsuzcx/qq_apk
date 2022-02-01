package com.tencent.avgame.gameroom.stage.guesspicture;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GuessPictureStagePresenter
  implements IGameStagePresenter
{
  IGameStageView jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView;
  IStagePresenter jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
  
  public GuessPictureStagePresenter(IGameStageView paramIGameStageView)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView = paramIGameStageView;
  }
  
  public IStagePresenter a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
  }
  
  public String a(Context paramContext, EngineData paramEngineData)
  {
    paramEngineData = paramEngineData.a();
    paramContext = null;
    if (paramEngineData != null)
    {
      if (paramEngineData.a != 2) {
        break label54;
      }
      paramContext = BaseApplicationImpl.getContext().getResources().getString(2131690417);
    }
    for (;;)
    {
      paramEngineData = paramContext;
      if (TextUtils.isEmpty(paramContext)) {
        paramEngineData = BaseApplicationImpl.getContext().getResources().getString(2131690417);
      }
      return paramEngineData;
      label54:
      paramContext = paramEngineData.n;
      paramEngineData = paramContext;
      if (!TextUtils.isEmpty(paramContext))
      {
        paramEngineData = paramContext;
        if (paramContext.contains("\\n")) {
          paramEngineData = paramContext.replace("\\n", "\n");
        }
      }
      paramContext = paramEngineData;
      if (QLog.isColorLevel())
      {
        QLog.d("GuessPictureStagePresenter", 2, "getGamePrepareBottomTip result = " + paramEngineData);
        paramContext = paramEngineData;
      }
    }
  }
  
  public String a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureStagePresenter", 2, "getGameRuleAnswerTip null context");
      }
      return "";
    }
    String str = paramContext.getResources().getString(2131690418);
    EngineData localEngineData = GameEngine.a().a();
    ITopic localITopic = localEngineData.a();
    if ((localITopic != null) && ((localITopic instanceof TopicBase)) && (!TextUtils.isEmpty(((TopicBase)localITopic).c))) {
      return "";
    }
    if ((localEngineData.f()) && (localEngineData.p() == 0)) {
      return paramContext.getResources().getString(2131690414);
    }
    if (localEngineData.f()) {
      return "";
    }
    return str;
  }
  
  public void a(ITopic paramITopic)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(paramITopic);
  }
  
  public void a(EngineData paramEngineData)
  {
    a(GameEngine.a().a(), false);
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
    a(GameEngine.a().a(), true);
    a(paramEngineData.a());
    String str;
    if (this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a())
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().e(false);
      str = paramEngineData.e() + 1 + "/" + paramEngineData.f();
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.setTitleRight(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(), paramEngineData.a().a.e * 1000, paramEngineData.a().d());
      return;
      if (paramEngineData.a().a.a())
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().e(true);
        this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().a(paramEngineData.a().a.c * 1000, paramEngineData.a().e());
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().e(true);
        str = paramEngineData.e() + 1 + "/" + paramEngineData.f();
        this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().b(str);
      }
    }
  }
  
  public void c(EngineData paramEngineData)
  {
    a(GameEngine.a().a(), true);
    a(paramEngineData.a());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(), paramEngineData.a().f(), paramEngineData.a().d());
    if (this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a())
    {
      paramEngineData = paramEngineData.e() + 1 + "/" + paramEngineData.f();
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.setTitleRight(paramEngineData);
      return;
    }
    if (paramEngineData.a().a.a())
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().a(paramEngineData.a().a.c * 1000, paramEngineData.a().e());
      return;
    }
    paramEngineData = paramEngineData.e() + 1 + "/" + paramEngineData.f();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().b(paramEngineData);
  }
  
  public void d(EngineData paramEngineData) {}
  
  public void e(EngineData paramEngineData) {}
  
  public void f(EngineData paramEngineData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureStagePresenter
 * JD-Core Version:    0.7.0.1
 */