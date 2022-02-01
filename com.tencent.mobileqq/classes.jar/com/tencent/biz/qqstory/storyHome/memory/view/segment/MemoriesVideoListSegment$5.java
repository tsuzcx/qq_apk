package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.view.View;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity.ClosePlayerAnimationInfoEvent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.biz.qqstory.storyHome.memory.view.MemoriesInnerListView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;

class MemoriesVideoListSegment$5
  implements Runnable
{
  MemoriesVideoListSegment$5(MemoriesVideoListSegment paramMemoriesVideoListSegment, MemoriesInnerListView paramMemoriesInnerListView, int paramInt, String paramString) {}
  
  public void run()
  {
    View localView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewMemoriesInnerListView.getChildAt(this.jdField_a_of_type_Int);
    if (localView != null)
    {
      SLog.a("Q.qqstory.memories.MemoriesVideoListSegment", "doScrollHorizal broadcast close animation2 %s", this.jdField_a_of_type_JavaLangString);
      StoryDispatcher.a().dispatch(new StoryPlayerActivity.ClosePlayerAnimationInfoEvent(new AnimationParam(localView), this.jdField_a_of_type_JavaLangString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment.5
 * JD-Core Version:    0.7.0.1
 */