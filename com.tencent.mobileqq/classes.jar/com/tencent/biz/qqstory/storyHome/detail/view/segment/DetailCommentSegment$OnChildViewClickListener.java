package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import android.view.View;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailEventCallback;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import java.util.List;

public class DetailCommentSegment$OnChildViewClickListener
  extends ChildViewClickListener
{
  public DetailCommentSegment$OnChildViewClickListener(DetailCommentSegment paramDetailCommentSegment) {}
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(DetailCommentSegment.a(this.a)).size())) {}
    do
    {
      do
      {
        do
        {
          return;
          paramObject = (CommentEntry)this.a.a.a(DetailCommentSegment.a(this.a)).get(paramInt);
          switch (paramView.getId())
          {
          default: 
            return;
          }
        } while ((paramObject.authorRole == 1002) || (paramObject.authorRole == 1003));
        StoryApi.a(paramView.getContext(), 12, paramObject.authorUnionId);
        return;
      } while (DetailCommentSegment.a(this.a) == null);
      DetailCommentSegment.a(this.a).a(paramObject, paramInt);
      return;
    } while (DetailCommentSegment.a(this.a) == null);
    DetailCommentSegment.a(this.a).L_();
  }
  
  public void b(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(DetailCommentSegment.a(this.a)).size())) {}
    do
    {
      do
      {
        return;
        paramObject = (CommentEntry)this.a.a.a(DetailCommentSegment.a(this.a)).get(paramInt);
        switch (paramView.getId())
        {
        default: 
          return;
        }
      } while (DetailCommentSegment.a(this.a) == null);
      DetailCommentSegment.a(this.a).b(paramObject, paramInt);
      return;
    } while (DetailCommentSegment.a(this.a) == null);
    DetailCommentSegment.a(this.a).L_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailCommentSegment.OnChildViewClickListener
 * JD-Core Version:    0.7.0.1
 */