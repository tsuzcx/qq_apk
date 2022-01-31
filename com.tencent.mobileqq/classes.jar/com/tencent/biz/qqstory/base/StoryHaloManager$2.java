package com.tencent.biz.qqstory.base;

import android.view.View;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import stc;
import tff;

public class StoryHaloManager$2
  implements Runnable
{
  public StoryHaloManager$2(stc paramstc, RecentItemChatMsgData paramRecentItemChatMsgData, View paramView) {}
  
  public void run()
  {
    tff localtff = this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemChatMsgData.a());
    if (localtff == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new StoryHaloManager.2.1(this, localtff));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.StoryHaloManager.2
 * JD-Core Version:    0.7.0.1
 */