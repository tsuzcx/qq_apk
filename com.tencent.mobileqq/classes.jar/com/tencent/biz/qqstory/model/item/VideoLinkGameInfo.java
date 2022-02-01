package com.tencent.biz.qqstory.model.item;

import com.tencent.biz.qqstory.utils.JsonORM.Column;

public class VideoLinkGameInfo
{
  @JsonORM.Column(a="pkIconUrl")
  public String a;
  @JsonORM.Column(a="pkWording")
  public String b;
  @JsonORM.Column(a="pkAction")
  public String c;
  @JsonORM.Column(a="pkIconUrlSelf")
  public String d;
  @JsonORM.Column(a="pkWordingSelf")
  public String e;
  @JsonORM.Column(a="pkActionSelf")
  public String f;
  
  public String toString()
  {
    return "VideoLinkGameInfo {, pkBody='" + this.b + '\'' + ", pkIconUrl='" + this.a + '\'' + ", pkAction='" + this.c + '\'' + ", pkBodySelf='" + this.e + '\'' + ", pkIconUrlSelf='" + this.d + '\'' + ", pkActionSelf='" + this.f + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.VideoLinkGameInfo
 * JD-Core Version:    0.7.0.1
 */