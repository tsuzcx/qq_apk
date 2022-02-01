package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class FeedInfoChangeEvent
  extends BaseEvent
{
  public final int a;
  public final String b;
  public CommentLikeFeedItem c;
  public int d = 0;
  public int e;
  
  public FeedInfoChangeEvent(int paramInt1, String paramString, int paramInt2)
  {
    this.d = paramInt2;
    this.b = paramString;
    this.a = paramInt1;
  }
  
  public FeedInfoChangeEvent(int paramInt1, String paramString, int paramInt2, CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.c = paramCommentLikeFeedItem;
    this.d = paramInt2;
    this.b = paramString;
    this.a = paramInt1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InteractionInfoChangeEvent{, feedId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", what=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", commentLikeFeedItem=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", commentId=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedInfoChangeEvent
 * JD-Core Version:    0.7.0.1
 */