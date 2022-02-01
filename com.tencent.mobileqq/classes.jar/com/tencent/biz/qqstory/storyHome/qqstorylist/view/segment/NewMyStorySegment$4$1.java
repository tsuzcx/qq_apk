package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.os.Handler;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryDesFromVidListStep.ReceiveDataListener;

class NewMyStorySegment$4$1
  implements GetMyStoryDesFromVidListStep.ReceiveDataListener
{
  NewMyStorySegment$4$1(NewMyStorySegment.4 param4) {}
  
  public void a(MyStorys paramMyStorys)
  {
    NewMyStorySegment.a(this.a.a).sendMessage(NewMyStorySegment.a(this.a.a).obtainMessage(0, paramMyStorys));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment.4.1
 * JD-Core Version:    0.7.0.1
 */