package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import com.tencent.biz.qqstory.base.ErrorMessage;

public class FeedVideoPreloader$CurrentVid
{
  public final long a;
  public final String b;
  public boolean c = false;
  public String d = "";
  public int e = 1000;
  
  public FeedVideoPreloader$CurrentVid(String paramString)
  {
    this.b = paramString;
    this.a = System.currentTimeMillis();
  }
  
  public ErrorMessage a()
  {
    return new ErrorMessage(this.e, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedVideoPreloader.CurrentVid
 * JD-Core Version:    0.7.0.1
 */