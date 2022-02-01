package com.tencent.biz.qqstory.msgTabNode.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;

class MsgTabStoryNodeListManager$14
  implements View.OnClickListener
{
  MsgTabStoryNodeListManager$14(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager) {}
  
  public void onClick(View paramView)
  {
    this.a.a.dismiss();
    StoryReportor.a("msg_tab", "clk_tips", 0, 0, new String[] { "1", "", "", "" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.14
 * JD-Core Version:    0.7.0.1
 */