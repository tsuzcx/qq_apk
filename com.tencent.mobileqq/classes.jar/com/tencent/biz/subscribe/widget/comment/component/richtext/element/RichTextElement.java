package com.tencent.biz.subscribe.widget.comment.component.richtext.element;

import android.os.Parcelable;

public abstract class RichTextElement
  implements Parcelable, Comparable<RichTextElement>
{
  protected int b;
  public int c;
  public int d;
  
  public RichTextElement(int paramInt)
  {
    this.b = paramInt;
  }
  
  public int a(RichTextElement paramRichTextElement)
  {
    if (paramRichTextElement == null) {
      return 1;
    }
    return this.c - paramRichTextElement.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.comment.component.richtext.element.RichTextElement
 * JD-Core Version:    0.7.0.1
 */