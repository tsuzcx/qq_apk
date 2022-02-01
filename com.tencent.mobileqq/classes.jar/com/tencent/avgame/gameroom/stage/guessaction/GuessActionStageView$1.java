package com.tencent.avgame.gameroom.stage.guessaction;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.avgame.gameroom.stage.IGameStageView.SwitchTopicClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GuessActionStageView$1
  implements View.OnClickListener
{
  GuessActionStageView$1(GuessActionStageView paramGuessActionStageView) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessaction.GuessActionStageView.1
 * JD-Core Version:    0.7.0.1
 */