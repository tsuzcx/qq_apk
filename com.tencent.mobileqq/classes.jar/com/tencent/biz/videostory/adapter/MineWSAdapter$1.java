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
    if (FastClickUtils.a(MineWSAdapter.class.getName() + "clickFeed")) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      MineWSAdapter.a(this.jdField_a_of_type_ComTencentBizVideostoryAdapterMineWSAdapter).a(this.jdField_a_of_type_ComTencentBizVideostoryAdapterMineWSAdapter$NewFeedItemData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.adapter.MineWSAdapter.1
 * JD-Core Version:    0.7.0.1
 */