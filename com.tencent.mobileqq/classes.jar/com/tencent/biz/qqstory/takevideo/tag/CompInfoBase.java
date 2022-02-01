package com.tencent.biz.qqstory.takevideo.tag;

import com.tencent.biz.qqstory.network.pb.qqstory_struct.CompInfoBase;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class CompInfoBase
{
  public final String a;
  public final String b;
  public final String c;
  public final boolean d;
  public final String e;
  public final int f;
  
  public CompInfoBase(qqstory_struct.CompInfoBase paramCompInfoBase)
  {
    this.a = paramCompInfoBase.title.get();
    this.b = paramCompInfoBase.backgroud_url.get();
    this.c = paramCompInfoBase.compared_vid.get();
    int i = paramCompInfoBase.is_compared_able.get();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.d = bool;
    this.e = paramCompInfoBase.icon_url.get();
    this.f = paramCompInfoBase.oa_task_id.get();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CompInfoBase{title='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", linkUrl='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", comparedVid='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isComparedAble=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", iconUrl='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", taskId=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.tag.CompInfoBase
 * JD-Core Version:    0.7.0.1
 */