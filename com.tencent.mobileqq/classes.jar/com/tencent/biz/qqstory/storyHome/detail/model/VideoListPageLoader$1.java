package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import uwa;
import wjb;
import wje;
import wpe;
import wxe;

public class VideoListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((wpe)uwa.a(12)).a(wjb.a(this.this$0), wjb.a(this.this$0));
    wje localwje = new wje(new ErrorMessage(), wjb.a(this.this$0));
    localwje.d = false;
    localwje.b = true;
    localwje.c = true;
    localwje.jdField_a_of_type_Boolean = true;
    if (??? != null) {
      localwje.jdField_a_of_type_JavaUtilList = ((FeedVideoInfo)???).mVideoItemList;
    }
    synchronized (this.this$0)
    {
      if (!this.this$0.b)
      {
        wjb.a(this.this$0, localwje);
        wxe.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from cache: %s", localwje);
        return;
      }
      wxe.d("Q.qqstory.home.data:VideoListPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */