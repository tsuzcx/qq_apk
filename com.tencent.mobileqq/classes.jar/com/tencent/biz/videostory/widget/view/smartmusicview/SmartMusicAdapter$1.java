package com.tencent.biz.videostory.widget.view.smartmusicview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SmartMusicAdapter$1
  implements View.OnClickListener
{
  SmartMusicAdapter$1(SmartMusicAdapter paramSmartMusicAdapter, int paramInt, VsMusicItemInfo paramVsMusicItemInfo) {}
  
  public void onClick(View paramView)
  {
    if (SmartMusicAdapter.a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter) != null) {
      SmartMusicAdapter.a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicAdapter.1
 * JD-Core Version:    0.7.0.1
 */