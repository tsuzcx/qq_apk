package com.etrump.mixlayout.api;

public abstract interface IETSegment
{
  public static final int ET_SEGMENT_TYPE_EMOJI = 1;
  public static final int ET_SEGMENT_TYPE_IMAGE = 2;
  public static final int ET_SEGMENT_TYPE_TEXT = 0;
  
  public abstract int getCodePoint();
  
  public abstract int getLineNum();
  
  public abstract int getTextLength();
  
  public abstract int getTextOffset();
  
  public abstract int getTextSize();
  
  public abstract int getType();
  
  public abstract int getX();
  
  public abstract int getY();
  
  public abstract void setCodePoint(int paramInt);
  
  public abstract void setLineNum(int paramInt);
  
  public abstract void setTextLength(int paramInt);
  
  public abstract void setTextOffset(int paramInt);
  
  public abstract void setTextSize(int paramInt);
  
  public abstract void setType(int paramInt);
  
  public abstract void setX(int paramInt);
  
  public abstract void setY(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.api.IETSegment
 * JD-Core Version:    0.7.0.1
 */