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
    StoryReportor.a("msg_tab", "clk_press", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_Int + "", "8", "", this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_JavaLangString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.10
 * JD-Core Version:    0.7.0.1
 */