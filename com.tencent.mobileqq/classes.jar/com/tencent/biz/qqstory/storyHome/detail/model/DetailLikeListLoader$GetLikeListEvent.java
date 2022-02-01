package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.LikeEntry;
import java.util.List;

public class DetailLikeListLoader$GetLikeListEvent
  extends BaseEvent
{
  public String a;
  public boolean b;
  public int c;
  public int d;
  public int e;
  public List<LikeEntry> f;
  public boolean h;
  public boolean i;
  
  public DetailLikeListLoader$GetLikeListEvent(ErrorMessage paramErrorMessage, String paramString)
  {
    this.g = paramErrorMessage;
    this.a = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetLikeListEvent{feedId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isForDetail=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mType=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mLikeCount=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mHasLike=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mLikeEntryList=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.GetLikeListEvent
 * JD-Core Version:    0.7.0.1
 */