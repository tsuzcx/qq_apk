package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.graphics.Rect;
import com.tribe.async.dispatch.Dispatcher;
import uht;
import wps;
import wqj;
import wsv;

public class FeedSegment$9
  implements Runnable
{
  public FeedSegment$9(wps paramwps, Rect paramRect) {}
  
  public void run()
  {
    wqj localwqj = new wqj(this.a.top, this.a.left, this.a.right, this.a.bottom);
    uht.a().dispatch(localwqj);
    wsv.b("Q.qqstory.home:FeedSegment_animation", "发了动画时间过去了 2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.9
 * JD-Core Version:    0.7.0.1
 */