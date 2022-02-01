package com.tencent.biz.qqstory.base;

import android.view.View;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class StoryHaloManager$2
  implements Runnable
{
  StoryHaloManager$2(StoryHaloManager paramStoryHaloManager, RecentItemChatMsgData paramRecentItemChatMsgData, View paramView) {}
  
  public void run()
  {
    MsgTabNodeInfo localMsgTabNodeInfo = this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemChatMsgData.getRecentUserUin());
    if (localMsgTabNodeInfo == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new StoryHaloManager.2.1(this, localMsgTabNodeInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.StoryHaloManager.2
 * JD-Core Version:    0.7.0.1
 */