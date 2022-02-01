package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryVideoListStep.Result;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SimpleStep.InitParamSimpleStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.Step;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UncheckedCallable;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class NewMyStorySegment$DeleteStoryVideoReceiver
  extends QQUIEventReceiver<NewMyStorySegment, DeleteStoryVideoEvent>
{
  public NewMyStorySegment$DeleteStoryVideoReceiver(@NonNull NewMyStorySegment paramNewMyStorySegment)
  {
    super(paramNewMyStorySegment);
  }
  
  public void a(@NonNull NewMyStorySegment paramNewMyStorySegment, @NonNull DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    if (paramDeleteStoryVideoEvent.g.isFail())
    {
      SLog.d(this.TAG, "deleted story failed");
      paramNewMyStorySegment.a(5, paramDeleteStoryVideoEvent.a);
      return;
    }
    paramNewMyStorySegment.a(paramDeleteStoryVideoEvent.a);
    paramNewMyStorySegment.a(new Step[] { new SimpleStep.InitParamSimpleStep(GetMyStoryVideoListStep.Result.a(NewMyStorySegment.b(paramNewMyStorySegment).t.a)), (Step)paramNewMyStorySegment.h.b() });
  }
  
  public Class acceptEventClass()
  {
    return DeleteStoryVideoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment.DeleteStoryVideoReceiver
 * JD-Core Version:    0.7.0.1
 */