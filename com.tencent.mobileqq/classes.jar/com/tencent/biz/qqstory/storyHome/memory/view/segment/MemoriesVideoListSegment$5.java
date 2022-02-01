package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.view.View;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.biz.qqstory.storyHome.memory.view.MemoriesInnerListView;
import com.tribe.async.dispatch.Dispatcher;
import wjj;
import xku;
import yku;
import yuk;

public class MemoriesVideoListSegment$5
  implements Runnable
{
  public MemoriesVideoListSegment$5(yku paramyku, MemoriesInnerListView paramMemoriesInnerListView, int paramInt, String paramString) {}
  
  public void run()
  {
    View localView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewMemoriesInnerListView.getChildAt(this.jdField_a_of_type_Int);
    if (localView != null)
    {
      yuk.a("Q.qqstory.memories.MemoriesVideoListSegment", "doScrollHorizal broadcast close animation2 %s", this.jdField_a_of_type_JavaLangString);
      wjj.a().dispatch(new xku(new AnimationParam(localView), this.jdField_a_of_type_JavaLangString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment.5
 * JD-Core Version:    0.7.0.1
 */