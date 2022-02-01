package com.tencent.biz.qqstory.storyHome.messagenotify;

import com.tencent.biz.qqstory.network.pb.qqstory_710_message.RspStoryMessageList;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import xmm;

public class StoryMessageListActivity$3$1
  implements Runnable
{
  public StoryMessageListActivity$3$1(xmm paramxmm, ArrayList paramArrayList, qqstory_710_message.RspStoryMessageList paramRspStoryMessageList) {}
  
  public void run()
  {
    boolean bool2 = false;
    StoryMessageListActivity localStoryMessageListActivity = this.jdField_a_of_type_Xmm.a;
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((!this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_710_message$RspStoryMessageList.is_end.has()) || (this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_710_message$RspStoryMessageList.is_end.get() != 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((!this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_710_message$RspStoryMessageList.has_read_msg.has()) || (this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_710_message$RspStoryMessageList.has_read_msg.get() != 0)) {
        bool2 = true;
      }
      localStoryMessageListActivity.a(localArrayList, bool1, bool2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity.3.1
 * JD-Core Version:    0.7.0.1
 */