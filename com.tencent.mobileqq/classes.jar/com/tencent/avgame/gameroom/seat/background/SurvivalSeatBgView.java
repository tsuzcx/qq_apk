package com.tencent.avgame.gameroom.seat.background;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.qphone.base.util.QLog;

public class SurvivalSeatBgView
  extends GridView
{
  private SurvivalSeatBgGridAdapter a;
  private ISurvivalSeatBgPresenter b;
  
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
    this.b = new SurvivalSeatBgPresenterImp();
    this.a = new SurvivalSeatBgGridAdapter(getContext(), this.b);
  }
  
  public void a()
  {
    setAdapter(this.a);
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init SurvivalSeatBgView ");
      localStringBuilder.append(GameRoomViewLayoutParamsDef.N);
      QLog.d("SurvivalSeatBgView", 4, localStringBuilder.toString());
    }
  }
  
  public ISurvivalSeatBgPresenter getPresenter()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.background.SurvivalSeatBgView
 * JD-Core Version:    0.7.0.1
 */