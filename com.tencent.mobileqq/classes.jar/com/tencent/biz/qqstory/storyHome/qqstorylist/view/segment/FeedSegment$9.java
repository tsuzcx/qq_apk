package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.graphics.Rect;
import com.tribe.async.dispatch.Dispatcher;
import wjj;
import yrh;
import yry;
import yuk;

public class FeedSegment$9
  implements Runnable
{
  public FeedSegment$9(yrh paramyrh, Rect paramRect) {}
  
  public void run()
  {
    yry localyry = new yry(this.a.top, this.a.left, this.a.right, this.a.bottom);
    wjj.a().dispatch(localyry);
    yuk.b("Q.qqstory.home:FeedSegment_animation", "发了动画时间过去了 2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.9
 * JD-Core Version:    0.7.0.1
 */