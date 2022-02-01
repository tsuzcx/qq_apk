package com.tencent.biz.qqstory.msgTabNode.view;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.widget.ARMapHongBaoListView;

class MsgTabStoryNodeListManager$8
  implements View.OnLayoutChangeListener
{
  MsgTabStoryNodeListManager$8(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager, StoryConfigManager paramStoryConfigManager) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    SLog.b(MsgTabStoryNodeListManager.b(), "onLayoutChange");
    if ((paramInt4 - paramInt2 > 0) && (paramInt3 - paramInt1 > 0) && ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.d) || (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.e)) && (!this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForStory))
    {
      SLog.b(MsgTabStoryNodeListManager.b(), "first show node, showStoryNode");
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.d)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.d = false;
        this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("first_show_node", Boolean.valueOf(false));
      }
      paramView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager;
      paramView.e = false;
      if (paramView.a()) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a("exp_story", 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.8
 * JD-Core Version:    0.7.0.1
 */