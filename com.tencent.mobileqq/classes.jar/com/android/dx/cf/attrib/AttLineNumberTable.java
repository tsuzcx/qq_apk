package com.android.dx.cf.attrib;

import com.android.dx.cf.code.LineNumberList;
import com.android.dx.util.MutabilityException;

public final class AttLineNumberTable
  extends BaseAttribute
{
  public static final String ATTRIBUTE_NAME = "LineNumberTable";
  private final LineNumberList lineNumbers;
  
  public AttLineNumberTable(LineNumberList paramLineNumberList)
  {
    super("LineNumberTable");
    try
    {
      if (paramLineNumberList.isMutable()) {
        throw new MutabilityException("lineNumbers.isMutable()");
      }
    }
    catch (NullPointerException paramLineNumberList)
    {
      throw new NullPointerException("lineNumbers == null");
    }
    this.lineNumbers = paramLineNumberList;
  }
  
  public int byteLength()
  {
    return this.lineNumbers.size() * 4 + 8;
  }
  
  public LineNumberList getLineNumbers()
  {
    return this.lineNumbers;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.attrib.AttLineNumberTable
 * JD-Core Version:    0.7.0.1
 */