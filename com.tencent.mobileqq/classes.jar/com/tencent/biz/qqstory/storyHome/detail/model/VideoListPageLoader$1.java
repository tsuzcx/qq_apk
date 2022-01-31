package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import urr;
import wes;
import wev;
import wkv;
import wsv;

public class VideoListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((wkv)urr.a(12)).a(wes.a(this.this$0), wes.a(this.this$0));
    wev localwev = new wev(new ErrorMessage(), wes.a(this.this$0));
    localwev.d = false;
    localwev.b = true;
    localwev.c = true;
    localwev.jdField_a_of_type_Boolean = true;
    if (??? != null) {
      localwev.jdField_a_of_type_JavaUtilList = ((FeedVideoInfo)???).mVideoItemList;
    }
    synchronized (this.this$0)
    {
      if (!this.this$0.b)
      {
        wes.a(this.this$0, localwev);
        wsv.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from cache: %s", localwev);
        return;
      }
      wsv.d("Q.qqstory.home.data:VideoListPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */