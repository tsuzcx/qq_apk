package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import wth;
import ygh;
import ygk;
import ymk;
import yuk;

public class VideoListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((ymk)wth.a(12)).a(ygh.a(this.this$0), ygh.a(this.this$0));
    ygk localygk = new ygk(new ErrorMessage(), ygh.a(this.this$0));
    localygk.d = false;
    localygk.b = true;
    localygk.c = true;
    localygk.jdField_a_of_type_Boolean = true;
    if (??? != null) {
      localygk.jdField_a_of_type_JavaUtilList = ((FeedVideoInfo)???).mVideoItemList;
    }
    synchronized (this.this$0)
    {
      if (!this.this$0.b)
      {
        ygh.a(this.this$0, localygk);
        yuk.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from cache: %s", localygk);
        return;
      }
      yuk.d("Q.qqstory.home.data:VideoListPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */