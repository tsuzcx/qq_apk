package com.tencent.biz.qqstory.msgTabNode.view;

import android.view.View;
import com.tencent.widget.ARMapHongBaoListView;
import uwn;
import uwu;

public class MsgTabStoryNodeListManager$7$1
  implements Runnable
{
  public MsgTabStoryNodeListManager$7$1(uwu paramuwu) {}
  
  public void run()
  {
    int i = this.a.a.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getFirstVisiblePosition();
    if (i < this.a.a.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getHeaderViewsCount())
    {
      View localView = this.a.a.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getChildAt(0);
      if (localView == this.a.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView)
      {
        int j = localView.getTop();
        if ((j < 0) && (j > -localView.getHeight())) {
          this.a.a.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setSelection(i + 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.7.1
 * JD-Core Version:    0.7.0.1
 */