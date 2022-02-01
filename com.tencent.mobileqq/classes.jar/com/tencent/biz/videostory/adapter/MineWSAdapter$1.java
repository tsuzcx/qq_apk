package com.tencent.biz.videostory.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.videostory.FastClickUtils;
import com.tencent.biz.videostory.widget.view.MineWSPanel.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MineWSAdapter$1
  implements View.OnClickListener
{
  MineWSAdapter$1(MineWSAdapter paramMineWSAdapter, MineWSAdapter.NewFeedItemData paramNewFeedItemData) {}
  
  public void onClick(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MineWSAdapter.class.getName());
    localStringBuilder.append("clickFeed");
    if (!FastClickUtils.a(localStringBuilder.toString())) {
      MineWSAdapter.a(this.b).a(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.adapter.MineWSAdapter.1
 * JD-Core Version:    0.7.0.1
 */