package com.tencent.biz.qqcircle.bizparts.danmaku.element;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

public abstract class RichTextElement
  implements SmartParcelable, Comparable<RichTextElement>
{
  public static final int RICH_TEXT_ELEMENT_AT = 5;
  public static final int RICH_TEXT_ELEMENT_COLOR = 8;
  public static final int RICH_TEXT_ELEMENT_COMMENT = 7;
  public static final int RICH_TEXT_ELEMENT_CONTENT = 4;
  public static final int RICH_TEXT_ELEMENT_CUSTOM_URL = 6;
  public static final int RICH_TEXT_ELEMENT_HIGHLIGHT = 9;
  public static final int RICH_TEXT_ELEMENT_LOCAL_SMILEY = 2;
  public static final int RICH_TEXT_ELEMENT_NET_SMILEY = 3;
  public static final int RICH_TEXT_ELEMENT_NICK_NAME = 1;
  @NeedParcel
  public int endPosition;
  public int offset;
  @NeedParcel
  public int startPosition;
  @NeedParcel
  protected int type;
  
  public RichTextElement() {}
  
  public RichTextElement(int paramInt)
  {
    this.type = paramInt;
  }
  
  public int compareTo(RichTextElement paramRichTextElement)
  {
    if (paramRichTextElement == null) {
      return 1;
    }
    return this.startPosition - paramRichTextElement.startPosition;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public int replace(StringBuilder paramStringBuilder, int paramInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.element.RichTextElement
 * JD-Core Version:    0.7.0.1
 */