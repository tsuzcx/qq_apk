package com.tencent.biz.qqstory.model.item;

import com.tencent.biz.qqstory.utils.JsonORM.Column;

public class VideoCompInfo
{
  @JsonORM.Column(a="bg_url")
  public String a;
  @JsonORM.Column(a="comp_vid")
  public String b;
  @JsonORM.Column(a="is_comp_able")
  public boolean c;
  @JsonORM.Column(a="icon_url")
  public String d;
  @JsonORM.Column(a="oa_task_id")
  public int e;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CompInfoBase{, comparedVid='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isComparedAble=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", iconUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", taskId=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.VideoCompInfo
 * JD-Core Version:    0.7.0.1
 */