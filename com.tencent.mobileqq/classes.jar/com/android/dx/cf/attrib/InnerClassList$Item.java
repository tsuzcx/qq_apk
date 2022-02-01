package com.android.dx.cf.attrib;

import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;

public class InnerClassList$Item
{
  private final int accessFlags;
  private final CstType innerClass;
  private final CstString innerName;
  private final CstType outerClass;
  
  public InnerClassList$Item(CstType paramCstType1, CstType paramCstType2, CstString paramCstString, int paramInt)
  {
    if (paramCstType1 == null) {
      throw new NullPointerException("innerClass == null");
    }
    this.innerClass = paramCstType1;
    this.outerClass = paramCstType2;
    this.innerName = paramCstString;
    this.accessFlags = paramInt;
  }
  
  public int getAccessFlags()
  {
    return this.accessFlags;
  }
  
  public CstType getInnerClass()
  {
    return this.innerClass;
  }
  
  public CstString getInnerName()
  {
    return this.innerName;
  }
  
  public CstType getOuterClass()
  {
    return this.outerClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.attrib.InnerClassList.Item
 * JD-Core Version:    0.7.0.1
 */