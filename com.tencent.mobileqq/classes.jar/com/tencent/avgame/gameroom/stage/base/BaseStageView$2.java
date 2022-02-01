package com.tencent.avgame.gameroom.stage.base;

import android.view.View;
import com.tencent.avgame.gameroom.stage.IGameStageView.SwitchTopicClickListener;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.mobileqq.statistics.ReportController;

class BaseStageView$2
  implements IGameStageView.SwitchTopicClickListener
{
  BaseStageView$2(BaseStageView paramBaseStageView) {}
  
  public void onClick(View paramView)
  {
    this.a.a().a();
    ReportController.b(null, "dc00898", "", "", "0X800B04A", "0X800B04A", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.base.BaseStageView.2
 * JD-Core Version:    0.7.0.1
 */