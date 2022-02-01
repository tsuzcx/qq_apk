package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import wpm;
import ycm;
import ycp;
import yip;
import yqp;

public class VideoListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((yip)wpm.a(12)).a(ycm.a(this.this$0), ycm.a(this.this$0));
    ycp localycp = new ycp(new ErrorMessage(), ycm.a(this.this$0));
    localycp.d = false;
    localycp.b = true;
    localycp.c = true;
    localycp.jdField_a_of_type_Boolean = true;
    if (??? != null) {
      localycp.jdField_a_of_type_JavaUtilList = ((FeedVideoInfo)???).mVideoItemList;
    }
    synchronized (this.this$0)
    {
      if (!this.this$0.b)
      {
        ycm.a(this.this$0, localycp);
        yqp.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from cache: %s", localycp);
        return;
      }
      yqp.d("Q.qqstory.home.data:VideoListPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */