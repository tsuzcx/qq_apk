package com.etrump.mixlayout;

import com.etrump.mixlayout.api.IETSegment;

public class ETSegment
  implements IETSegment
{
  public static final int ET_SEGMENT_TYPE_EMOJI = 1;
  public static final int ET_SEGMENT_TYPE_IMAGE = 2;
  public static final int ET_SEGMENT_TYPE_TEXT = 0;
  public int codePoint = -1;
  public int lineNum;
  public int textLength;
  public int textOffset;
  public int textSize;
  public int type;
  public int x;
  public int y;
  
  public int getCodePoint()
  {
    return this.codePoint;
  }
  
  public int getLineNum()
  {
    return this.lineNum;
  }
  
  public int getTextLength()
  {
    return this.textLength;
  }
  
  public int getTextOffset()
  {
    return this.textOffset;
  }
  
  public int getTextSize()
  {
    return this.textSize;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public int getX()
  {
    return this.x;
  }
  
  public int getY()
  {
    return this.y;
  }
  
  public void setCodePoint(int paramInt)
  {
    this.codePoint = paramInt;
  }
  
  public void setLineNum(int paramInt)
  {
    this.lineNum = paramInt;
  }
  
  public void setTextLength(int paramInt)
  {
    this.textLength = paramInt;
  }
  
  public void setTextOffset(int paramInt)
  {
    this.textOffset = paramInt;
  }
  
  public void setTextSize(int paramInt)
  {
    this.textSize = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setX(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void setY(int paramInt)
  {
    this.y = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.ETSegment
 * JD-Core Version:    0.7.0.1
 */