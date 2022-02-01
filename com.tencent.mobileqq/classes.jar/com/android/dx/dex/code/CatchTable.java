package com.android.dx.dex.code;

import com.android.dx.util.FixedSizeList;

public final class CatchTable
  extends FixedSizeList
  implements Comparable<CatchTable>
{
  public static final CatchTable EMPTY = new CatchTable(0);
  
  public CatchTable(int paramInt)
  {
    super(paramInt);
  }
  
  public int compareTo(CatchTable paramCatchTable)
  {
    if (this == paramCatchTable) {}
    int j;
    int k;
    do
    {
      return 0;
      j = size();
      k = paramCatchTable.size();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        int n = get(i).compareTo(paramCatchTable.get(i));
        if (n != 0) {
          return n;
        }
        i += 1;
      }
      if (j < k) {
        return -1;
      }
    } while (j <= k);
    return 1;
  }
  
  public CatchTable.Entry get(int paramInt)
  {
    return (CatchTable.Entry)get0(paramInt);
  }
  
  public void set(int paramInt, CatchTable.Entry paramEntry)
  {
    set0(paramInt, paramEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.CatchTable
 * JD-Core Version:    0.7.0.1
 */