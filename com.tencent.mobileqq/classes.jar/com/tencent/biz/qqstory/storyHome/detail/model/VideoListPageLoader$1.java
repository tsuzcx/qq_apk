package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import wjs;
import xwn;
import xwq;
import ycq;
import ykq;

public class VideoListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((ycq)wjs.a(12)).a(xwn.a(this.this$0), xwn.a(this.this$0));
    xwq localxwq = new xwq(new ErrorMessage(), xwn.a(this.this$0));
    localxwq.d = false;
    localxwq.b = true;
    localxwq.c = true;
    localxwq.jdField_a_of_type_Boolean = true;
    if (??? != null) {
      localxwq.jdField_a_of_type_JavaUtilList = ((FeedVideoInfo)???).mVideoItemList;
    }
    synchronized (this.this$0)
    {
      if (!this.this$0.b)
      {
        xwn.a(this.this$0, localxwq);
        ykq.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from cache: %s", localxwq);
        return;
      }
      ykq.d("Q.qqstory.home.data:VideoListPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */