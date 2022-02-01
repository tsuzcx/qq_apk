package com.android.dx.cf.code;

import com.android.dx.util.FixedSizeList;

public final class LineNumberList
  extends FixedSizeList
{
  public static final LineNumberList EMPTY = new LineNumberList(0);
  
  public LineNumberList(int paramInt)
  {
    super(paramInt);
  }
  
  public static LineNumberList concat(LineNumberList paramLineNumberList1, LineNumberList paramLineNumberList2)
  {
    int k = 0;
    if (paramLineNumberList1 == EMPTY) {
      return paramLineNumberList2;
    }
    int m = paramLineNumberList1.size();
    int n = paramLineNumberList2.size();
    LineNumberList localLineNumberList = new LineNumberList(m + n);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      localLineNumberList.set(i, paramLineNumberList1.get(i));
      i += 1;
    }
    while (j < n)
    {
      localLineNumberList.set(m + j, paramLineNumberList2.get(j));
      j += 1;
    }
    return localLineNumberList;
  }
  
  public LineNumberList.Item get(int paramInt)
  {
    return (LineNumberList.Item)get0(paramInt);
  }
  
  public int pcToLine(int paramInt)
  {
    int i1 = size();
    int k = 0;
    int j = -1;
    int i = -1;
    for (;;)
    {
      int m = i;
      if (k < i1)
      {
        LineNumberList.Item localItem = get(k);
        int n = localItem.getStartPc();
        if ((n <= paramInt) && (n > j))
        {
          m = localItem.getLineNumber();
          i = m;
          j = n;
          if (n != paramInt) {}
        }
      }
      else
      {
        return m;
      }
      k += 1;
    }
  }
  
  public void set(int paramInt1, int paramInt2, int paramInt3)
  {
    set0(paramInt1, new LineNumberList.Item(paramInt2, paramInt3));
  }
  
  public void set(int paramInt, LineNumberList.Item paramItem)
  {
    if (paramItem == null) {
      throw new NullPointerException("item == null");
    }
    set0(paramInt, paramItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.LineNumberList
 * JD-Core Version:    0.7.0.1
 */