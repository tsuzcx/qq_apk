package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.view.View;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import java.util.List;

public class PlayerCommentSegment$OnChildViewClickListener
  extends ChildViewClickListener
{
  public PlayerCommentSegment$OnChildViewClickListener(PlayerCommentSegment paramPlayerCommentSegment) {}
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if (paramInt >= 0)
    {
      if (paramInt > this.a.a.a(PlayerCommentSegment.b(this.a)).size()) {
        return;
      }
      paramObject = (CommentEntry)this.a.a.a(PlayerCommentSegment.b(this.a)).get(paramInt);
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131431068: 
        if (PlayerCommentSegment.c(this.a) != null) {
          PlayerCommentSegment.c(this.a).a(paramObject, paramInt, PlayerCommentSegment.d(this.a).d());
        }
      case 2131437615: 
        PlayerCommentSegment.d(this.a).a(PlayerCommentSegment.d(this.a).e());
        return;
      }
      if (paramObject.authorRole != 1002)
      {
        if (paramObject.authorRole == 1003) {
          return;
        }
        StoryApi.a(paramView.getContext(), 12, paramObject.authorUnionId);
      }
    }
  }
  
  public void b(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if (paramInt >= 0)
    {
      if (paramInt > this.a.a.a(PlayerCommentSegment.b(this.a)).size()) {
        return;
      }
      paramObject = (CommentEntry)this.a.a.a(PlayerCommentSegment.b(this.a)).get(paramInt);
      int i = paramView.getId();
      if (i != 2131431068)
      {
        if (i != 2131437615) {
          return;
        }
        PlayerCommentSegment.d(this.a).a(PlayerCommentSegment.d(this.a).e());
        return;
      }
      paramView = PlayerCommentSegment.d(this.a).f();
      if ((paramView != null) && (paramView.a != null))
      {
        if (paramView.a.getOwner().isMe()) {
          paramView = "2";
        } else {
          paramView = "1";
        }
        StoryReportor.a("home_page", "press_reply", 0, 0, new String[] { paramView, StoryReportor.b(PlayerCommentSegment.e(this.a)) });
      }
      if (PlayerCommentSegment.c(this.a) != null) {
        PlayerCommentSegment.c(this.a).b(paramObject, paramInt, PlayerCommentSegment.d(this.a).d());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.PlayerCommentSegment.OnChildViewClickListener
 * JD-Core Version:    0.7.0.1
 */