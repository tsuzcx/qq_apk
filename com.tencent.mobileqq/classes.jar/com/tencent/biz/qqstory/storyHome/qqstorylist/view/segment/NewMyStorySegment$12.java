package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import java.util.ArrayList;

class NewMyStorySegment$12
  extends ChildViewClickListener
{
  NewMyStorySegment$12(NewMyStorySegment paramNewMyStorySegment, boolean paramBoolean) {}
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if (paramView == paramBaseViewHolder.a())
    {
      paramObject = this.b;
      NewMyStorySegment.a(paramObject, paramInt, (StoryVideoItem)NewMyStorySegment.b(paramObject).b().get(paramInt), paramView);
      return;
    }
    if (paramView == paramBaseViewHolder.a(2131442737))
    {
      paramView = (StoryCoverView)paramBaseViewHolder.a(2131442736);
      if (this.a)
      {
        paramObject = this.b;
        NewMyStorySegment.a(paramObject, paramInt, (StoryVideoItem)NewMyStorySegment.b(paramObject).b().get(paramInt), paramView);
        return;
      }
      paramObject = this.b;
      NewMyStorySegment.b(paramObject, paramInt, (StoryVideoItem)NewMyStorySegment.b(paramObject).b().get(paramInt), paramView);
      return;
    }
    if ((paramView != paramBaseViewHolder.a(2131442781)) && (paramView != paramBaseViewHolder.a(2131442739)))
    {
      if (paramView == paramBaseViewHolder.a(2131442777)) {
        this.b.a(paramBaseViewHolder, paramInt);
      }
    }
    else
    {
      paramView = this.b;
      NewMyStorySegment.a(paramView, paramInt, (StoryVideoItem)NewMyStorySegment.b(paramView).b().get(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment.12
 * JD-Core Version:    0.7.0.1
 */