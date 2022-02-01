package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import vux;
import xhs;
import xhv;
import xnv;
import xvv;

public class VideoListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((xnv)vux.a(12)).a(xhs.a(this.this$0), xhs.a(this.this$0));
    xhv localxhv = new xhv(new ErrorMessage(), xhs.a(this.this$0));
    localxhv.d = false;
    localxhv.b = true;
    localxhv.c = true;
    localxhv.jdField_a_of_type_Boolean = true;
    if (??? != null) {
      localxhv.jdField_a_of_type_JavaUtilList = ((FeedVideoInfo)???).mVideoItemList;
    }
    synchronized (this.this$0)
    {
      if (!this.this$0.b)
      {
        xhs.a(this.this$0, localxhv);
        xvv.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from cache: %s", localxhv);
        return;
      }
      xvv.d("Q.qqstory.home.data:VideoListPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */