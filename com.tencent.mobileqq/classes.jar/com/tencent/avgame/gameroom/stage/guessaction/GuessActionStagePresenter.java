package com.tencent.avgame.gameroom.stage.guessaction;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameInfo;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IGameStageView;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.util.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class GuessActionStagePresenter
  implements IGameStagePresenter
{
  IGameStageView jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView;
  IStagePresenter jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
  private boolean jdField_a_of_type_Boolean = false;
  
  public GuessActionStagePresenter(IGameStageView paramIGameStageView)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView = paramIGameStageView;
  }
  
  public IStagePresenter a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
  }
  
  public String a(Context paramContext, EngineData paramEngineData)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessActionStagePresenter", 2, "getGamePrepareBottomTip null context");
      }
      return "";
    }
    boolean bool = IGameEngine.a(paramEngineData);
    paramEngineData = paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.nick;
    if (bool) {
      return paramContext.getResources().getString(2131690265);
    }
    return String.format(paramContext.getResources().getString(2131690266), new Object[] { ContactUtils.a(paramEngineData, 8.0F) });
  }
  
  public String a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessActionStagePresenter", 2, "getGameRuleAnswerTip null context");
      }
      return "";
    }
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return paramContext.getResources().getString(2131690264);
      }
      return paramContext.getResources().getString(2131690269);
    }
    return paramContext.getResources().getString(2131690263);
  }
  
  public void a(ITopic paramITopic)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(paramITopic);
  }
  
  public void a(EngineData paramEngineData)
  {
    if ((!this.jdField_a_of_type_Boolean) && (GameEngine.a().a().a().opened_match))
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().a(this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().a().getString(2131690276));
      this.jdField_a_of_type_Boolean = true;
    }
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
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public void b(EngineData paramEngineData)
  {
    a(GameEngine.a(paramEngineData), true);
    a(paramEngineData.a());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().e(true);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().a(paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.c * 1000, paramEngineData.a().e());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(), paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.e * 1000, paramEngineData.a().d());
  }
  
  public void c(EngineData paramEngineData)
  {
    a(GameEngine.a(paramEngineData), true);
    a(paramEngineData.a());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(), paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.e * 1000, paramEngineData.a().d());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().a(paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.c * 1000, paramEngineData.a().e());
  }
  
  public void d(EngineData paramEngineData) {}
  
  public void e(EngineData paramEngineData) {}
  
  public void f(EngineData paramEngineData)
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessaction.GuessActionStagePresenter
 * JD-Core Version:    0.7.0.1
 */