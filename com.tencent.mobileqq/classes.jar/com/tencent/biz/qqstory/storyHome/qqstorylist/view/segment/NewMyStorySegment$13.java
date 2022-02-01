package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;

class NewMyStorySegment$13
  extends ChildViewClickListener
{
  NewMyStorySegment$13(NewMyStorySegment paramNewMyStorySegment) {}
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if (UIUtils.d()) {
      return;
    }
    if (paramView.getId() == 2131447104)
    {
      StoryReportor.a("mystory", "clk_all_story", 0, 0, new String[0]);
      paramView = QQStoryContext.a().i();
      StoryApi.a(NewMyStorySegment.g(this.a), 1, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment.13
 * JD-Core Version:    0.7.0.1
 */