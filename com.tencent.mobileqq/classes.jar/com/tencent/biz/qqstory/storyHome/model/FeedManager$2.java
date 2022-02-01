package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;

class FeedManager$2
  implements Runnable
{
  FeedManager$2(FeedManager paramFeedManager) {}
  
  public void run()
  {
    if (FeedManager.a(this.this$0) == 0L)
    {
      SLog.d("Q.qqstory.home.position", "cache in use");
      return;
    }
    this.this$0.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache != null) {
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache.a();
    }
    SLog.d("Q.qqstory.home.position", "release cache");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.2
 * JD-Core Version:    0.7.0.1
 */