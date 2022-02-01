package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.notification.StoryPushMsg;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryVideoListStep.Result;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SimpleStep.GetResultSimpleStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SimpleStep.InitParamSimpleStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.Step;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UncheckedCallable;

class NewMyStorySegment$5
  extends QQStoryObserver
{
  NewMyStorySegment$5(NewMyStorySegment paramNewMyStorySegment) {}
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if ((NewMyStorySegment.a(this.a) == null) || (NewMyStorySegment.a(this.a).a == null))
    {
      SLog.e("NewMyStorySegment", "onPushMessage MyStory feed is null!");
      return;
    }
    String str = NewMyStorySegment.a(this.a).a.a;
    if (!TextUtils.equals(str, paramStoryPushMsg.d))
    {
      SLog.a("NewMyStorySegment", "onPushMessage Push feed id = %s not equal to current feed %s, ignore!", paramStoryPushMsg.d, str);
      return;
    }
    switch (paramStoryPushMsg.a)
    {
    case 16: 
    case 17: 
    default: 
      return;
    }
    this.a.a(new Step[] { new SimpleStep.InitParamSimpleStep(GetMyStoryVideoListStep.Result.a(str)), (Step)this.a.b.a(), new SimpleStep.GetResultSimpleStep(new NewMyStorySegment.5.1(this, str)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment.5
 * JD-Core Version:    0.7.0.1
 */