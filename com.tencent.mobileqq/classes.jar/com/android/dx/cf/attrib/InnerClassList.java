package com.android.dx.cf.attrib;

import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.util.FixedSizeList;

public final class InnerClassList
  extends FixedSizeList
{
  public InnerClassList(int paramInt)
  {
    super(paramInt);
  }
  
  public InnerClassList.Item get(int paramInt)
  {
    return (InnerClassList.Item)get0(paramInt);
  }
  
  public void set(int paramInt1, CstType paramCstType1, CstType paramCstType2, CstString paramCstString, int paramInt2)
  {
    set0(paramInt1, new InnerClassList.Item(paramCstType1, paramCstType2, paramCstString, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.attrib.InnerClassList
 * JD-Core Version:    0.7.0.1
 */