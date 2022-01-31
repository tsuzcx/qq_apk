package com.tencent.biz.subscribe.widget.comment.component.richtext.element;

import android.os.Parcelable;

public abstract class RichTextElement
  implements Parcelable, Comparable<RichTextElement>
{
  protected int a;
  public int b;
  public int c;
  
  public RichTextElement(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a(RichTextElement paramRichTextElement)
  {
    if (paramRichTextElement == null) {
      return 1;
    }
    return this.b - paramRichTextElement.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.comment.component.richtext.element.RichTextElement
 * JD-Core Version:    0.7.0.1
 */