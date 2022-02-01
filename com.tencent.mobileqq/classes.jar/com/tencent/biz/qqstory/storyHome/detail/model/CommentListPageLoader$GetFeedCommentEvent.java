package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import java.util.ArrayList;
import java.util.List;

public class CommentListPageLoader$GetFeedCommentEvent
  extends BasePageLoaderEvent
{
  public String e;
  public int f;
  public String h;
  public int i;
  public int j;
  public List<CommentEntry> k = new ArrayList(0);
  
  public CommentListPageLoader$GetFeedCommentEvent(ErrorMessage paramErrorMessage, String paramString, int paramInt)
  {
    super(paramErrorMessage);
    this.e = paramString;
    this.j = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetFeedCommentEvent{feedId='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mType=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mSource=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", mCommentEntries=");
    localStringBuilder.append(this.k.size());
    localStringBuilder.append(", mTotalCount=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", isEnd=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.GetFeedCommentEvent
 * JD-Core Version:    0.7.0.1
 */