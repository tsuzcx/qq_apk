package com.tencent.biz.qqstory.msgTabNode.view;

import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.widget.ActionSheet.OnDismissListener;

class MsgTabStoryNodeListManager$10
  implements ActionSheet.OnDismissListener
{
  MsgTabStoryNodeListManager$10(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager, MsgTabNodeInfo paramMsgTabNodeInfo) {}
  
  public void onDismiss()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("");
    StoryReportor.a("msg_tab", "clk_press", 0, 0, new String[] { localStringBuilder.toString(), "8", "", this.a.d });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.10
 * JD-Core Version:    0.7.0.1
 */