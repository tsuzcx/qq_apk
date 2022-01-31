package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import sqg;
import udh;
import udk;
import ujk;
import urk;

public class VideoListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((ujk)sqg.a(12)).a(udh.a(this.this$0), udh.a(this.this$0));
    udk localudk = new udk(new ErrorMessage(), udh.a(this.this$0));
    localudk.d = false;
    localudk.b = true;
    localudk.c = true;
    localudk.jdField_a_of_type_Boolean = true;
    if (??? != null) {
      localudk.jdField_a_of_type_JavaUtilList = ((FeedVideoInfo)???).mVideoItemList;
    }
    synchronized (this.this$0)
    {
      if (!this.this$0.b)
      {
        udh.a(this.this$0, localudk);
        urk.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from cache: %s", localudk);
        return;
      }
      urk.d("Q.qqstory.home.data:VideoListPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */