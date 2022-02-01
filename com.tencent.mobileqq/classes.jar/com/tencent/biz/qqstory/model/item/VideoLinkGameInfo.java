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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoLinkGameInfo {, pkBody='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pkIconUrl='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pkAction='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pkBodySelf='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pkIconUrlSelf='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pkActionSelf='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.VideoLinkGameInfo
 * JD-Core Version:    0.7.0.1
 */