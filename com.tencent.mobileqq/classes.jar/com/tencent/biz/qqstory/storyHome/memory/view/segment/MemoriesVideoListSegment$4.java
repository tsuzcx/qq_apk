package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.view.View;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.biz.qqstory.storyHome.memory.view.MemoriesInnerListView;
import com.tribe.async.dispatch.Dispatcher;
import sgi;
import thu;
import uhu;
import urk;

public class MemoriesVideoListSegment$4
  implements Runnable
{
  public MemoriesVideoListSegment$4(uhu paramuhu, MemoriesInnerListView paramMemoriesInnerListView, int paramInt, String paramString) {}
  
  public void run()
  {
    View localView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewMemoriesInnerListView.getChildAt(this.jdField_a_of_type_Int);
    if (localView != null)
    {
      urk.a("Q.qqstory.memories.MemoriesVideoListSegment", "doScrollHorizal broadcast close animation %s", this.jdField_a_of_type_JavaLangString);
      sgi.a().dispatch(new thu(new AnimationParam(localView), this.jdField_a_of_type_JavaLangString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment.4
 * JD-Core Version:    0.7.0.1
 */