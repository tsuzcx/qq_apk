package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryVideoListStep.Result;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SimpleStep.SimpleStepResultCallback;

class NewMyStorySegment$5$1
  implements SimpleStep.SimpleStepResultCallback<GetMyStoryVideoListStep.Result>
{
  NewMyStorySegment$5$1(NewMyStorySegment.5 param5, String paramString) {}
  
  public void a(GetMyStoryVideoListStep.Result paramResult)
  {
    if ((paramResult.f != null) && (TextUtils.equals(paramResult.f.a, this.a)))
    {
      NewMyStorySegment.b(this.b.a).t = paramResult.f;
      NewMyStorySegment.a(this.b.a).sendMessage(NewMyStorySegment.a(this.b.a).obtainMessage(0, NewMyStorySegment.b(this.b.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment.5.1
 * JD-Core Version:    0.7.0.1
 */