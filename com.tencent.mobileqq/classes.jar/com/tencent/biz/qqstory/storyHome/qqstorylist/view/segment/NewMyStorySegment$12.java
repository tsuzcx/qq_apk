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
      paramObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment;
      NewMyStorySegment.a(paramObject, paramInt, (StoryVideoItem)NewMyStorySegment.a(paramObject).a().get(paramInt), paramView);
      return;
    }
    if (paramView == paramBaseViewHolder.a(2131374567))
    {
      paramView = (StoryCoverView)paramBaseViewHolder.a(2131374566);
      if (this.jdField_a_of_type_Boolean)
      {
        paramObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment;
        NewMyStorySegment.a(paramObject, paramInt, (StoryVideoItem)NewMyStorySegment.a(paramObject).a().get(paramInt), paramView);
        return;
      }
      paramObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment;
      NewMyStorySegment.b(paramObject, paramInt, (StoryVideoItem)NewMyStorySegment.a(paramObject).a().get(paramInt), paramView);
      return;
    }
    if ((paramView != paramBaseViewHolder.a(2131374611)) && (paramView != paramBaseViewHolder.a(2131374569)))
    {
      if (paramView == paramBaseViewHolder.a(2131374607)) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment.a(paramBaseViewHolder, paramInt);
      }
    }
    else
    {
      paramView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment;
      NewMyStorySegment.a(paramView, paramInt, (StoryVideoItem)NewMyStorySegment.a(paramView).a().get(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment.12
 * JD-Core Version:    0.7.0.1
 */