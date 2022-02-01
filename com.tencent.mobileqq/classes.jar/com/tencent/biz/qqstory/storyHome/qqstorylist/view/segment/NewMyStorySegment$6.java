package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SimpleStepExector.CompletedHandler;
import com.tencent.biz.qqstory.support.logging.SLog;

class NewMyStorySegment$6
  implements SimpleStepExector.CompletedHandler
{
  NewMyStorySegment$6(NewMyStorySegment paramNewMyStorySegment) {}
  
  public void a()
  {
    SLog.d("NewMyStorySegment", "finish get all data from server steps");
    new Handler(Looper.getMainLooper()).post(new NewMyStorySegment.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment.6
 * JD-Core Version:    0.7.0.1
 */