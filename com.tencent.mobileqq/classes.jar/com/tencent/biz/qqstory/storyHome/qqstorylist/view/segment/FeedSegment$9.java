package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.graphics.Rect;
import com.tribe.async.dispatch.Dispatcher;
import sgi;
import uoh;
import uoy;
import urk;

public class FeedSegment$9
  implements Runnable
{
  public FeedSegment$9(uoh paramuoh, Rect paramRect) {}
  
  public void run()
  {
    uoy localuoy = new uoy(this.a.top, this.a.left, this.a.right, this.a.bottom);
    sgi.a().dispatch(localuoy);
    urk.b("Q.qqstory.home:FeedSegment_animation", "发了动画时间过去了 2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.9
 * JD-Core Version:    0.7.0.1
 */