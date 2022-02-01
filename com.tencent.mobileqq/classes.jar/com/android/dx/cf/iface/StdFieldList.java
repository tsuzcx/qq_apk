package com.android.dx.cf.iface;

import com.android.dx.util.FixedSizeList;

public final class StdFieldList
  extends FixedSizeList
  implements FieldList
{
  public StdFieldList(int paramInt)
  {
    super(paramInt);
  }
  
  public Field get(int paramInt)
  {
    return (Field)get0(paramInt);
  }
  
  public void set(int paramInt, Field paramField)
  {
    set0(paramInt, paramField);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.iface.StdFieldList
 * JD-Core Version:    0.7.0.1
 */