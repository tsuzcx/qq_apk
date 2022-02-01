package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameMsgBoxFragment$3
  implements View.OnClickListener
{
  GameMsgBoxFragment$3(GameMsgBoxFragment paramGameMsgBoxFragment, TipsBar paramTipsBar) {}
  
  public void onClick(View paramView)
  {
    ((ViewGroup)GameMsgBoxFragment.c(this.b)).removeView(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment.3
 * JD-Core Version:    0.7.0.1
 */