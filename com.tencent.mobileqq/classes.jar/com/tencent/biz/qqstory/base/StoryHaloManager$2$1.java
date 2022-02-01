package com.tencent.biz.qqstory.base;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;

class StoryHaloManager$2$1
  implements Runnable
{
  StoryHaloManager$2$1(StoryHaloManager.2 param2, MsgTabNodeInfo paramMsgTabNodeInfo) {}
  
  public void run()
  {
    OpenPlayerBuilder localOpenPlayerBuilder = new OpenPlayerBuilder(new MsgTabPlayInfo(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a, 1, this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryHaloManager$2.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemChatMsgData.getRecentUserUin(), "", ""), 111);
    StoryPlayerLauncher.a((Activity)this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryHaloManager$2.jdField_a_of_type_AndroidViewView.getContext(), localOpenPlayerBuilder.a(), null);
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryHaloManager$2.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemChatMsgData.haloState == -1) {
      i = 1;
    } else {
      i = 0;
    }
    StoryReportor.a("msg_tab", "circle_clk", 0, i, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryHaloManager$2.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemChatMsgData.getRecentUserUin() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.StoryHaloManager.2.1
 * JD-Core Version:    0.7.0.1
 */