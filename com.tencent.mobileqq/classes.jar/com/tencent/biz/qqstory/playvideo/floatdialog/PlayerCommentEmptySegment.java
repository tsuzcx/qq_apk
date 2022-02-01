package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import java.util.List;

public class PlayerCommentEmptySegment
  extends SegmentView
{
  public static final String KEY = "PlayerCommentEmptySegment";
  public DetailFeedItem a;
  private CommentFloatDialogController b;
  private View c;
  private boolean d = true;
  
  public PlayerCommentEmptySegment(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean j()
  {
    CommentFloatDialogController localCommentFloatDialogController = this.b;
    return (localCommentFloatDialogController == null) || (localCommentFloatDialogController.e());
  }
  
  public int a()
  {
    if (this.m)
    {
      DetailFeedItem localDetailFeedItem = this.a;
      if ((localDetailFeedItem == null) || (localDetailFeedItem.a(j()).size() == 0)) {
        return 1;
      }
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    if (this.d) {
      this.c.setVisibility(0);
    } else {
      this.c.setVisibility(8);
    }
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.l).inflate(2131628118, paramViewGroup, false);
    this.c = paramViewGroup.findViewById(2131437664);
    if (QQStoryContext.e()) {
      this.c.setBackgroundColor(this.l.getResources().getColor(2131167383));
    }
    return new BaseViewHolder(paramViewGroup);
  }
  
  public void a(CommentFloatDialogController paramCommentFloatDialogController)
  {
    this.b = paramCommentFloatDialogController;
  }
  
  public void a(DetailFeedItem paramDetailFeedItem)
  {
    this.a = paramDetailFeedItem;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public String b()
  {
    return "PlayerCommentEmptySegment";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.PlayerCommentEmptySegment
 * JD-Core Version:    0.7.0.1
 */