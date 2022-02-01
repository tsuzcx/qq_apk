package com.tencent.biz.videostory.widget.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.videostory.FastClickUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MineWSPanel$1
  implements View.OnClickListener
{
  MineWSPanel$1(MineWSPanel paramMineWSPanel) {}
  
  public void onClick(View paramView)
  {
    if (MineWSPanel.a(this.a) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!FastClickUtils.a(MineWSPanel.class.getName() + "clickPanel")) {
        MineWSPanel.a(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.MineWSPanel.1
 * JD-Core Version:    0.7.0.1
 */