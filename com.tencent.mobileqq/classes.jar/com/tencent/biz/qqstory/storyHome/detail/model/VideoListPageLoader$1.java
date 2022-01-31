package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import tcz;
import uqa;
import uqd;
import uwd;
import ved;

public class VideoListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((uwd)tcz.a(12)).a(uqa.a(this.this$0), uqa.a(this.this$0));
    uqd localuqd = new uqd(new ErrorMessage(), uqa.a(this.this$0));
    localuqd.d = false;
    localuqd.b = true;
    localuqd.c = true;
    localuqd.jdField_a_of_type_Boolean = true;
    if (??? != null) {
      localuqd.jdField_a_of_type_JavaUtilList = ((FeedVideoInfo)???).mVideoItemList;
    }
    synchronized (this.this$0)
    {
      if (!this.this$0.b)
      {
        uqa.a(this.this$0, localuqd);
        ved.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from cache: %s", localuqd);
        return;
      }
      ved.d("Q.qqstory.home.data:VideoListPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */