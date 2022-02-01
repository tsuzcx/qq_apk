package com.tencent.biz.qqstory.storyHome.model;

public class BannerFeedItem$ShareInfo
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public void a()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
  }
  
  public void a(ShareInfo paramShareInfo)
  {
    String str = paramShareInfo.a;
    if (str != null) {
      this.a = str;
    }
    str = paramShareInfo.b;
    if (str != null) {
      this.b = str;
    }
    str = paramShareInfo.c;
    if (str != null) {
      this.c = str;
    }
    paramShareInfo = paramShareInfo.d;
    if (paramShareInfo != null) {
      this.d = paramShareInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.BannerFeedItem.ShareInfo
 * JD-Core Version:    0.7.0.1
 */