package com.tencent.biz.qqcircle.bizparts.danmaku.element;

import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;

public class ColorElement
  extends RichTextElement
{
  @NeedParcel
  public String a;
  @NeedParcel
  public int b;
  @NeedParcel
  public boolean c = false;
  @NeedParcel
  public boolean d = true;
  @NeedParcel
  public boolean e = false;
  @NeedParcel
  public String f;
  
  public ColorElement()
  {
    this(8);
  }
  
  public ColorElement(int paramInt)
  {
    super(paramInt);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ColorElement [text=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", color=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", startPosition=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", endPosition=");
    localStringBuilder.append(this.i);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.element.ColorElement
 * JD-Core Version:    0.7.0.1
 */