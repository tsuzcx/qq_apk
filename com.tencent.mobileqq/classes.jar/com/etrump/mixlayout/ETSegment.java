package com.etrump.mixlayout;

public class ETSegment
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.etrump.mixlayout.ETSegment
 * JD-Core Version:    0.7.0.1
 */