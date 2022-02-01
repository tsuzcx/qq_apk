package com.tencent.imsdk.message;

import java.io.Serializable;

public class MessageBaseElement
  implements Serializable
{
  public static int UUID_TYPE_AUDIO = 3;
  public static int UUID_TYPE_FILE = 1;
  public static int UUID_TYPE_VIDEO = 2;
  public static int UUID_TYPE_VIDEO_THUMB;
  protected int elementType;
  
  public int getElementType()
  {
    return this.elementType;
  }
  
  public void setElementType(int paramInt)
  {
    this.elementType = paramInt;
  }
  
  public boolean update(MessageBaseElement paramMessageBaseElement)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.MessageBaseElement
 * JD-Core Version:    0.7.0.1
 */