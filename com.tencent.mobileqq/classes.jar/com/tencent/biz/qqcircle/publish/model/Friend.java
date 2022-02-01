package com.tencent.biz.qqcircle.publish.model;

import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;
import com.tencent.biz.qqcircle.publish.queue.util.SmartParcelable;

public class Friend
  implements SmartParcelable
{
  @NeedParcel
  public long a = -1L;
  @NeedParcel
  public String b = "";
  @NeedParcel
  public String c = "";
  @NeedParcel
  public String d = "";
  @NeedParcel
  public int e = -1;
  @NeedParcel
  public int f = 0;
  @NeedParcel
  public String g = "";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.model.Friend
 * JD-Core Version:    0.7.0.1
 */