package com.tencent.biz.qqcircle.bizparts.danmaku.element;

import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;
import com.tencent.biz.qqcircle.publish.queue.util.SmartParcelable;

public abstract class RichTextElement
  implements SmartParcelable, Comparable<RichTextElement>
{
  @NeedParcel
  protected int g;
  @NeedParcel
  public int h;
  @NeedParcel
  public int i;
  
  public RichTextElement() {}
  
  public RichTextElement(int paramInt)
  {
    this.g = paramInt;
  }
  
  public int a(RichTextElement paramRichTextElement)
  {
    if (paramRichTextElement == null) {
      return 1;
    }
    return this.h - paramRichTextElement.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.element.RichTextElement
 * JD-Core Version:    0.7.0.1
 */