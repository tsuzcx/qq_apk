package com.tencent.avgame.gameroom.pkstage;

import android.graphics.Color;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.util.FontStyleConfig;

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
    if ((this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData == null) || (paramEngineData == null)) {}
    while ((this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData == null) || (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.o() != paramEngineData.o())) {
      return false;
    }
    return true;
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
    this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.a(paramEngineData.g(), paramEngineData.h());
  }
  
  private void e(EngineData paramEngineData)
  {
    int i;
    if (paramEngineData.a != null) {
      i = 0;
    }
    try
    {
      int j = Color.parseColor(paramEngineData.a.j);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.a(i);
    this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.a(paramEngineData.a.k, paramEngineData.a.l, paramEngineData.a.m, paramEngineData.a.n, paramEngineData.a.o);
  }
  
  public void a(EngineData paramEngineData)
  {
    if (paramEngineData == null) {
      return;
    }
    int i = paramEngineData.o();
    this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.a(paramEngineData);
    switch (i)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData = paramEngineData.a();
      return;
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
        continue;
        if (a(paramEngineData))
        {
          a(paramEngineData, true);
        }
        else
        {
          c(paramEngineData);
          continue;
          if (!a(paramEngineData))
          {
            a();
            continue;
            if (!a(paramEngineData))
            {
              this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.e();
              continue;
              if (!a(paramEngineData)) {
                if ((this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData != null) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.o() == 9))
                {
                  this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.e();
                }
                else
                {
                  this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.a(false);
                  continue;
                  if (!a(paramEngineData))
                  {
                    this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.a(true);
                    continue;
                    if (!a(paramEngineData))
                    {
                      this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStageView.a();
                      continue;
                      if (!a(paramEngineData)) {
                        b(paramEngineData);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter = paramIGameRoomPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.pkstage.GameSurvivalPkPresenterImpl
 * JD-Core Version:    0.7.0.1
 */