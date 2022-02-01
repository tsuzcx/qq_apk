package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameMsgBoxFragment$8
  implements View.OnClickListener
{
  GameMsgBoxFragment$8(GameMsgBoxFragment paramGameMsgBoxFragment) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameMsgBoxFragment", 2, "mAllIndicatorTv onClick");
    }
    GameMsgBoxFragment.k(this.a).setCurrentPosition(0, true);
    GameMsgBoxFragment.k(this.a).smoothScrollTo(0, GameMsgBoxFragment.k(this.a).getScrollY());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment.8
 * JD-Core Version:    0.7.0.1
 */