package com.tencent.avgame.gameroom.pkstage;

import android.graphics.Color;
import com.tencent.avgame.data.FontStyleConfig;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gameroom.IGameRoomPresenter;

public class GameSurvivalPkPresenterImpl
  implements ISurvivalStagePresenter
{
  protected EngineData a;
  private IGameRoomPresenter jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter;
  private ISurvivalStageView jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView;
  
  public GameSurvivalPkPresenterImpl(ISurvivalStageView paramISurvivalStageView)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView = paramISurvivalStageView;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.d();
  }
  
  private void a(EngineData paramEngineData, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.a(paramEngineData.l(), paramBoolean);
  }
  
  private boolean a(EngineData paramEngineData)
  {
    EngineData localEngineData = this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localEngineData != null)
    {
      if (paramEngineData == null) {
        return false;
      }
      bool1 = bool2;
      if (localEngineData != null)
      {
        bool1 = bool2;
        if (localEngineData.o() == paramEngineData.o()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.f();
  }
  
  private void b(EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.b();
  }
  
  private void c(EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.c();
  }
  
  private void d(EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.a(paramEngineData.h());
  }
  
  private void e(EngineData paramEngineData)
  {
    if (paramEngineData.a != null)
    {
      int i = 0;
      try
      {
        int j = Color.parseColor(paramEngineData.a.j);
        i = j;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.a(i);
      this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.a(paramEngineData.a.k, paramEngineData.a.l, paramEngineData.a.m, paramEngineData.a.n, paramEngineData.a.o);
    }
  }
  
  public void a(EngineData paramEngineData)
  {
    if (paramEngineData == null) {
      return;
    }
    int i = paramEngineData.o();
    this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.a(paramEngineData);
    EngineData localEngineData;
    switch (i)
    {
    case 3: 
    default: 
      break;
    case 10: 
      if (!a(paramEngineData)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.a(true);
      }
      break;
    case 8: 
    case 9: 
      if (!a(paramEngineData)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.e();
      }
      break;
    case 6: 
    case 7: 
      if (!a(paramEngineData)) {
        b(paramEngineData);
      }
      break;
    case 5: 
      if (!a(paramEngineData)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.a();
      }
      break;
    case 4: 
      if (!a(paramEngineData))
      {
        localEngineData = this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData;
        if ((localEngineData != null) && (localEngineData.o() == 9)) {
          this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.e();
        } else {
          this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.a(false);
        }
      }
      break;
    case 2: 
      if (!a(paramEngineData)) {
        a();
      }
      break;
    case 1: 
      if (a(paramEngineData))
      {
        a(paramEngineData, true);
      }
      else
      {
        localEngineData = this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData;
        if (((localEngineData != null) && (localEngineData.o() != 0)) || (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData == null) || (paramEngineData == null)) {
          c(paramEngineData);
        }
      }
      break;
    case 0: 
      if (a(paramEngineData))
      {
        a(paramEngineData, false);
        if (paramEngineData.g()) {
          d(paramEngineData);
        } else {
          b();
        }
      }
      else
      {
        if (paramEngineData.g()) {
          e(paramEngineData);
        }
        a(paramEngineData, false);
        b(paramEngineData);
      }
      break;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData = paramEngineData.a();
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter = paramIGameRoomPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.pkstage.GameSurvivalPkPresenterImpl
 * JD-Core Version:    0.7.0.1
 */