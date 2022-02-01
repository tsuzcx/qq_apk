package com.tencent.avgame.gameroom.seat.background;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.qphone.base.util.QLog;

public class SurvivalSeatBgView
  extends GridView
{
  private ISurvivalSeatBgPresenter jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter;
  private SurvivalSeatBgGridAdapter jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgGridAdapter;
  
  public SurvivalSeatBgView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SurvivalSeatBgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SurvivalSeatBgView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    setNumColumns(12);
    setVerticalScrollBarEnabled(false);
    setClickable(false);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter = new SurvivalSeatBgPresenterImp();
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgGridAdapter = new SurvivalSeatBgGridAdapter(getContext(), this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter);
  }
  
  public ISurvivalSeatBgPresenter a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter;
  }
  
  public void a()
  {
    setAdapter(this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgGridAdapter);
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init SurvivalSeatBgView ");
      localStringBuilder.append(GameRoomViewLayoutParamsDef.N);
      QLog.d("SurvivalSeatBgView", 4, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.background.SurvivalSeatBgView
 * JD-Core Version:    0.7.0.1
 */