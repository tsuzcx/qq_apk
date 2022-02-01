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
    if (MineWSPanel.a(this.a) != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(MineWSPanel.class.getName());
      localStringBuilder.append("clickPanel");
      if (!FastClickUtils.a(localStringBuilder.toString())) {
        MineWSPanel.a(this.a, false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.MineWSPanel.1
 * JD-Core Version:    0.7.0.1
 */