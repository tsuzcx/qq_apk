package com.tencent.avgame.gameroom.stage.base;

import android.view.View;
import com.tencent.avgame.gameroom.stage.IGameStageView.SwitchTopicClickListener;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.mobileqq.statistics.ReportController;

class BaseStageView$3
  implements IGameStageView.SwitchTopicClickListener
{
  BaseStageView$3(BaseStageView paramBaseStageView) {}
  
  public void onClick(View paramView)
  {
    this.a.a().a();
    ReportController.b(null, "dc00898", "", "", "0X800B04A", "0X800B04A", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.base.BaseStageView.3
 * JD-Core Version:    0.7.0.1
 */