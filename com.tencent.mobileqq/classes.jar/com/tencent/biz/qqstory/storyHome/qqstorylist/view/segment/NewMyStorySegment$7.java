package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SimpleStepExector.ErrorHandler;
import com.tencent.biz.qqstory.support.logging.SLog;

class NewMyStorySegment$7
  implements SimpleStepExector.ErrorHandler
{
  NewMyStorySegment$7(NewMyStorySegment paramNewMyStorySegment) {}
  
  public void a(ErrorMessage paramErrorMessage)
  {
    SLog.e("NewMyStorySegment", "error occur when get friends data from server steps=%s,error=%s", new Object[] { paramErrorMessage.extraMsg, paramErrorMessage.getErrorMessage() });
    new Handler(Looper.getMainLooper()).post(new NewMyStorySegment.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment.7
 * JD-Core Version:    0.7.0.1
 */