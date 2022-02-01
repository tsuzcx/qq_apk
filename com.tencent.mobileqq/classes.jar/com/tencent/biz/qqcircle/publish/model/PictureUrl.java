package com.tencent.biz.qqcircle.publish.model;

import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;
import com.tencent.biz.qqcircle.publish.queue.util.SmartParcelable;

public class PictureUrl
  implements SmartParcelable
{
  @NeedParcel
  public String a;
  @NeedParcel
  public int b;
  @NeedParcel
  public int c;
  @NeedParcel
  public int d;
  @NeedParcel
  public long e = 0L;
  @NeedParcel
  public String f = "";
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PictureUrl [url=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", pictureType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", size=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", md5=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.model.PictureUrl
 * JD-Core Version:    0.7.0.1
 */