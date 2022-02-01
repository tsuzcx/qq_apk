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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class GuessPictureClickStagePresenter
  implements IGameStagePresenter
{
  IGameStageView jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView;
  IStagePresenter jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
  
  public GuessPictureClickStagePresenter(IGameStageView paramIGameStageView)
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
    if (paramContext != null)
    {
      if (paramContext.a == 2)
      {
        paramContext = MobileQQ.sMobileQQ;
        paramContext = MobileQQ.getContext().getResources().getString(2131690341);
      }
      else
      {
        paramContext = paramContext.n;
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
          paramContext = new StringBuilder();
          paramContext.append("getGamePrepareBottomTip result = ");
          paramContext.append(paramEngineData);
          QLog.d("GuessPictureClickStagePresenter", 2, paramContext.toString());
          paramContext = paramEngineData;
        }
      }
    }
    else {
      paramContext = null;
    }
    paramEngineData = paramContext;
    if (TextUtils.isEmpty(paramContext))
    {
      paramContext = MobileQQ.sMobileQQ;
      paramEngineData = MobileQQ.getContext().getResources().getString(2131690341);
    }
    return paramEngineData;
  }
  
  public String a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureClickStagePresenter", 2, "getGameRuleAnswerTip null context");
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
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().e(false);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramEngineData.e() + 1);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramEngineData.f());
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.setTitleRight((String)localObject);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(), paramEngineData.a().a.e * 1000, paramEngineData.a().d());
  }
  
  public void c(EngineData paramEngineData)
  {
    a(GameEngine.a().a(), true);
    a(paramEngineData.a());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(), paramEngineData.a().f(), paramEngineData.a().d());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramEngineData.e() + 1);
    localStringBuilder.append("/");
    localStringBuilder.append(paramEngineData.f());
    paramEngineData = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.setTitleRight(paramEngineData);
  }
  
  public void d(EngineData paramEngineData) {}
  
  public void e(EngineData paramEngineData) {}
  
  public void f(EngineData paramEngineData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureClickStagePresenter
 * JD-Core Version:    0.7.0.1
 */