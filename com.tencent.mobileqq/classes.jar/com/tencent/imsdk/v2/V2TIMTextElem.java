package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.TextElement;

public class V2TIMTextElem
  extends V2TIMElem
{
  private String text;
  
  public String getText()
  {
    if (getElement() == null) {
      return this.text;
    }
    return ((TextElement)getElement()).getTextContent();
  }
  
  public void setText(String paramString)
  {
    if (getElement() == null)
    {
      this.text = paramString;
      return;
    }
    ((TextElement)getElement()).setTextContent(paramString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("V2TIMTextElem--->");
    localStringBuilder.append("text:");
    localStringBuilder.append(getText());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMTextElem
 * JD-Core Version:    0.7.0.1
 */