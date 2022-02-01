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
    SLog.b(MsgTabStoryNodeListManager.o(), "onLayoutChange");
    if ((paramInt4 - paramInt2 > 0) && (paramInt3 - paramInt1 > 0) && ((this.b.x) || (this.b.y)) && (!this.b.n.mForStory))
    {
      SLog.b(MsgTabStoryNodeListManager.o(), "first show node, showStoryNode");
      if (this.b.x)
      {
        this.b.x = false;
        this.a.d("first_show_node", Boolean.valueOf(false));
      }
      paramView = this.b;
      paramView.y = false;
      if (paramView.h()) {
        this.b.k.a("exp_story", 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.8
 * JD-Core Version:    0.7.0.1
 */