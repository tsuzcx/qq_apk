package com.tencent.biz.qqstory.takevideo.view.widget.colorbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HorizontalSelectColorLayout$3
  implements View.OnClickListener
{
  HorizontalSelectColorLayout$3(HorizontalSelectColorLayout paramHorizontalSelectColorLayout) {}
  
  public void onClick(View paramView)
  {
    SLog.b("SelectColorLayout", "onUndoClick: undoTypeEnable=" + this.a.jdField_a_of_type_Boolean);
    if (HorizontalSelectColorLayout.a(this.a) > System.currentTimeMillis()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$OnUndoViewClickListener != null)) {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$OnUndoViewClickListener.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout.3
 * JD-Core Version:    0.7.0.1
 */