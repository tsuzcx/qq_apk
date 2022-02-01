package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.Nullable;

public class FeedCommentSync
{
  public String a;
  public String b;
  public int c;
  public int d = -1;
  
  public FeedCommentSync(String paramString1, int paramInt, @Nullable String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt;
  }
  
  public FeedCommentSync(String paramString1, int paramInt1, @Nullable String paramString2, int paramInt2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public boolean a()
  {
    int i = this.c;
    boolean bool = true;
    if (i != 1)
    {
      if (i != 2) {
        return bool;
      }
      if (this.d != 0) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FeedCommentSync{feedId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mNextCookie='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSource=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedCommentSync
 * JD-Core Version:    0.7.0.1
 */