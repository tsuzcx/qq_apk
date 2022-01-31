package com.tencent.biz.qqstory.base;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import utx;
import vju;
import wta;

class StoryHaloManager$2$1
  implements Runnable
{
  StoryHaloManager$2$1(StoryHaloManager.2 param2, utx paramutx) {}
  
  public void run()
  {
    OpenPlayerBuilder localOpenPlayerBuilder = new OpenPlayerBuilder(new MsgTabPlayInfo(this.jdField_a_of_type_Utx.a, 1, this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryHaloManager$2.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemChatMsgData.a(), "", ""), 111);
    vju.a((Activity)this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryHaloManager$2.jdField_a_of_type_AndroidViewView.getContext(), localOpenPlayerBuilder.a(), null);
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryHaloManager$2.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemChatMsgData.haloState == -1) {}
    for (int i = 1;; i = 0)
    {
      wta.a("msg_tab", "circle_clk", 0, i, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryHaloManager$2.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemChatMsgData.a() });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.StoryHaloManager.2.1
 * JD-Core Version:    0.7.0.1
 */