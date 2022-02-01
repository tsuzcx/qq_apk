package com.tencent.biz.qqstory.model.item;

import com.tencent.biz.qqstory.utils.JsonORM.Column;

public class VideoLinkInfo$VipFrwrdLinkInfo
{
  @JsonORM.Column(a="unionID")
  public String a;
  @JsonORM.Column(a="feedID")
  public String b;
  @JsonORM.Column(a="vid")
  public String c;
  @JsonORM.Column(a="fwReason")
  public String d;
  @JsonORM.Column(a="isNewFw")
  public String e;
  
  public boolean a()
  {
    return "1".equals(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.VideoLinkInfo.VipFrwrdLinkInfo
 * JD-Core Version:    0.7.0.1
 */