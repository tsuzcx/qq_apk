package com.tencent.biz.qqstory.model.item;

import com.tencent.biz.qqstory.utils.JsonORM.Column;

public class VideoCompInfo
{
  @JsonORM.Column(a="oa_task_id")
  public int a;
  @JsonORM.Column(a="bg_url")
  public String a;
  @JsonORM.Column(a="is_comp_able")
  public boolean a;
  @JsonORM.Column(a="comp_vid")
  public String b;
  @JsonORM.Column(a="icon_url")
  public String c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CompInfoBase{, comparedVid='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isComparedAble=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", iconUrl='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", taskId=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.VideoCompInfo
 * JD-Core Version:    0.7.0.1
 */