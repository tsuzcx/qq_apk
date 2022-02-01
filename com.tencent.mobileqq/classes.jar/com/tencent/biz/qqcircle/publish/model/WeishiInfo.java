package com.tencent.biz.qqcircle.publish.model;

import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;
import com.tencent.biz.qqcircle.publish.queue.util.SmartParcelable;

public class WeishiInfo
  implements SmartParcelable
{
  @NeedParcel
  public String a;
  @NeedParcel
  public String b;
  @NeedParcel
  public String c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WeishiInfo [nick_name=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", weishi_musicName=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", weishi_topicName=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.model.WeishiInfo
 * JD-Core Version:    0.7.0.1
 */