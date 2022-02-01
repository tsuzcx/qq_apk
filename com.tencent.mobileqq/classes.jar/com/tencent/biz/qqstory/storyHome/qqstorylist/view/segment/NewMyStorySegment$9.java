package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.view.View;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import java.util.ArrayList;

class NewMyStorySegment$9
  extends ChildViewClickListener
{
  NewMyStorySegment$9(NewMyStorySegment paramNewMyStorySegment) {}
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if (paramView.getId() != 2131442776)
    {
      if (NewMyStorySegment.b(this.a).b().size() > 0)
      {
        paramView = this.a;
        NewMyStorySegment.a(paramView, NewMyStorySegment.e(paramView) ^ true);
        NewMyStorySegment.f(this.a);
        if (NewMyStorySegment.e(this.a)) {
          paramView = "1";
        } else {
          paramView = "2";
        }
        StoryReportor.a("mystory", "clk_fold", 0, 0, new String[] { paramView, "2" });
        StoryReportor.a("home_page", "exp_share_day", 0, 0, new String[0]);
        return;
      }
      paramObject = this.a;
      NewMyStorySegment.a(paramObject, NewMyStorySegment.b(paramObject), paramView);
      return;
    }
    paramObject = this.a;
    NewMyStorySegment.a(paramObject, NewMyStorySegment.b(paramObject), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment.9
 * JD-Core Version:    0.7.0.1
 */