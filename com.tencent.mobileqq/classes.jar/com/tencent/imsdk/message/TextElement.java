package com.tencent.imsdk.message;

public class TextElement
  extends MessageBaseElement
{
  private String textContent;
  
  public TextElement()
  {
    setElementType(1);
  }
  
  public String getTextContent()
  {
    return this.textContent;
  }
  
  public void setTextContent(String paramString)
  {
    this.textContent = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.TextElement
 * JD-Core Version:    0.7.0.1
 */