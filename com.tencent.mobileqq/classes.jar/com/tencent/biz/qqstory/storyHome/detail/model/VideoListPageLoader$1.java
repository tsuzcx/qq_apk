package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import tdc;
import uqd;
import uqg;
import uwg;
import veg;

public class VideoListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((uwg)tdc.a(12)).a(uqd.a(this.this$0), uqd.a(this.this$0));
    uqg localuqg = new uqg(new ErrorMessage(), uqd.a(this.this$0));
    localuqg.d = false;
    localuqg.b = true;
    localuqg.c = true;
    localuqg.jdField_a_of_type_Boolean = true;
    if (??? != null) {
      localuqg.jdField_a_of_type_JavaUtilList = ((FeedVideoInfo)???).mVideoItemList;
    }
    synchronized (this.this$0)
    {
      if (!this.this$0.b)
      {
        uqd.a(this.this$0, localuqg);
        veg.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from cache: %s", localuqg);
        return;
      }
      veg.d("Q.qqstory.home.data:VideoListPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */