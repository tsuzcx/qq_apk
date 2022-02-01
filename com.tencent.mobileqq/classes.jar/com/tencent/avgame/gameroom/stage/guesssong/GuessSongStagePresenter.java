package com.tencent.avgame.gameroom.stage.guesssong;

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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class GuessSongStagePresenter
  implements IGameStagePresenter
{
  IGameStageView jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView;
  IStagePresenter jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
  
  public GuessSongStagePresenter(IGameStageView paramIGameStageView)
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
      QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
      paramContext = "";
    }
    else
    {
      paramContext = paramContext.n;
    }
    Object localObject = paramContext;
    if (TextUtils.isEmpty(paramContext))
    {
      paramContext = MobileQQ.sMobileQQ;
      localObject = MobileQQ.getContext().getResources().getString(2131690344);
      QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip tips isEmpty");
    }
    paramContext = paramEngineData.c();
    if (!TextUtils.isEmpty(paramContext))
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append(paramContext);
      paramEngineData.append("\n");
      paramContext = paramEngineData.toString();
    }
    else
    {
      QLog.e("GuessPictureStagePresenter", 1, "songTypeString tips isEmpty");
    }
    if (TextUtils.isEmpty(paramContext)) {
      return localObject;
    }
    paramEngineData = new StringBuilder();
    paramEngineData.append(paramContext);
    paramEngineData.append((String)localObject);
    return paramEngineData.toString();
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
    String str = paramContext.getResources().getString(2131690343);
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
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().k(paramEngineData);
  }
  
  public void c(EngineData paramEngineData)
  {
    a(GameEngine.a(paramEngineData), true);
    a(paramEngineData.a());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(), paramEngineData.a().f(), paramEngineData.a().d());
    Object localObject;
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
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesssong.GuessSongStagePresenter
 * JD-Core Version:    0.7.0.1
 */