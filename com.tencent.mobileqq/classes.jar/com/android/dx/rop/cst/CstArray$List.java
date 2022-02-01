package com.android.dx.rop.cst;

import com.android.dx.util.FixedSizeList;

public final class CstArray$List
  extends FixedSizeList
  implements Comparable<List>
{
  public CstArray$List(int paramInt)
  {
    super(paramInt);
  }
  
  public int compareTo(List paramList)
  {
    int k = size();
    int m = paramList.size();
    int i;
    int j;
    if (k < m)
    {
      i = k;
      j = 0;
    }
    for (;;)
    {
      if (j >= i) {
        break label71;
      }
      int n = ((Constant)get0(j)).compareTo((Constant)paramList.get0(j));
      if (n != 0)
      {
        return n;
        i = m;
        break;
      }
      j += 1;
    }
    label71:
    if (k < m) {
      return -1;
    }
    if (k > m) {
      return 1;
    }
    return 0;
  }
  
  public Constant get(int paramInt)
  {
    return (Constant)get0(paramInt);
  }
  
  public void set(int paramInt, Constant paramConstant)
  {
    set0(paramInt, paramConstant);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstArray.List
 * JD-Core Version:    0.7.0.1
 */