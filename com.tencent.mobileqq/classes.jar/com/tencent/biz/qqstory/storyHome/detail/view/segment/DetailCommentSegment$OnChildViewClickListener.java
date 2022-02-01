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
    if (paramInt >= 0)
    {
      if (paramInt > this.a.a.a(DetailCommentSegment.a(this.a)).size()) {
        return;
      }
      paramObject = (CommentEntry)this.a.a.a(DetailCommentSegment.a(this.a)).get(paramInt);
      switch (paramView.getId())
      {
      default: 
      case 2131437615: 
        if (DetailCommentSegment.b(this.a) != null)
        {
          DetailCommentSegment.b(this.a).bo_();
          return;
        }
        break;
      case 2131431068: 
        if (DetailCommentSegment.b(this.a) != null)
        {
          DetailCommentSegment.b(this.a).a(paramObject, paramInt);
          return;
        }
        break;
      case 2131428988: 
      case 2131439303: 
        if (paramObject.authorRole != 1002)
        {
          if (paramObject.authorRole == 1003) {
            return;
          }
          StoryApi.a(paramView.getContext(), 12, paramObject.authorUnionId);
        }
        break;
      }
    }
  }
  
  public void b(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if (paramInt >= 0)
    {
      if (paramInt > this.a.a.a(DetailCommentSegment.a(this.a)).size()) {
        return;
      }
      paramObject = (CommentEntry)this.a.a.a(DetailCommentSegment.a(this.a)).get(paramInt);
      int i = paramView.getId();
      if (i != 2131431068)
      {
        if (i != 2131437615) {
          return;
        }
        if (DetailCommentSegment.b(this.a) != null) {
          DetailCommentSegment.b(this.a).bo_();
        }
      }
      else if (DetailCommentSegment.b(this.a) != null)
      {
        DetailCommentSegment.b(this.a).b(paramObject, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailCommentSegment.OnChildViewClickListener
 * JD-Core Version:    0.7.0.1
 */