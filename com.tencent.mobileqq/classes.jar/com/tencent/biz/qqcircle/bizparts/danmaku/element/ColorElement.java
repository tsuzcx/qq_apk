package com.tencent.biz.qqcircle.bizparts.danmaku.element;

import com.tencent.component.annotation.NeedParcel;

public class ColorElement
  extends RichTextElement
{
  @NeedParcel
  public int color;
  @NeedParcel
  public String fontFamilyUrl;
  @NeedParcel
  public boolean isBold;
  @NeedParcel
  public String text;
  @NeedParcel
  public boolean useDefaultFont;
  @NeedParcel
  public boolean useSuperFont = true;
  
  public ColorElement()
  {
    this(8);
  }
  
  public ColorElement(int paramInt)
  {
    super(paramInt);
  }
  
  public int replace(StringBuilder paramStringBuilder, int paramInt)
  {
    this.startPosition -= paramInt;
    this.endPosition -= paramInt;
    if (this.startPosition < 0) {
      return 0;
    }
    paramStringBuilder.replace(this.startPosition, this.endPosition, this.text);
    this.endPosition = (this.startPosition + this.text.length());
    return this.offset;
  }
  
  public String toString()
  {
    return "ColorElement [text=" + this.text + ", color=" + this.color + ", startPosition=" + this.startPosition + ", endPosition=" + this.endPosition + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.element.ColorElement
 * JD-Core Version:    0.7.0.1
 */