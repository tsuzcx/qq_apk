package com.tencent.biz.qqcircle.publish.model;

import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;
import com.tencent.biz.qqcircle.publish.queue.util.SmartParcelable;

public class VideoUrl
  implements SmartParcelable
{
  @NeedParcel
  public String a;
  @NeedParcel
  public int b;
  @NeedParcel
  public int c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoUrl [url=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", decoderType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", videoRate=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.model.VideoUrl
 * JD-Core Version:    0.7.0.1
 */