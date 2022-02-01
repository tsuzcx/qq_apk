package com.tencent.biz.qqstory.msgTabNode.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MsgTabStoryNodeView$3
  implements View.OnClickListener
{
  MsgTabStoryNodeView$3(MsgTabStoryNodeView paramMsgTabStoryNodeView, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a.isShown()) {}
    for (int i = 1;; i = 0)
    {
      StoryReportor.a("msg_tab", "clk_all", 0, i, new String[0]);
      JumpAction localJumpAction = JumpParser.a(QQStoryContext.a(), this.jdField_a_of_type_AndroidContentContext, "qqstory://qstory/open?from=msgTab");
      AssertUtils.a(localJumpAction);
      if (localJumpAction != null) {
        localJumpAction.a();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView.3
 * JD-Core Version:    0.7.0.1
 */