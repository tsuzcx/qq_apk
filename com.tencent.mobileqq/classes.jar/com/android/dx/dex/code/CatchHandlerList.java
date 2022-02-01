package com.android.dx.dex.code;

import com.android.dx.rop.cst.CstType;
import com.android.dx.util.FixedSizeList;
import com.android.dx.util.Hex;

public final class CatchHandlerList
  extends FixedSizeList
  implements Comparable<CatchHandlerList>
{
  public static final CatchHandlerList EMPTY = new CatchHandlerList(0);
  
  public CatchHandlerList(int paramInt)
  {
    super(paramInt);
  }
  
  public boolean catchesAll()
  {
    int i = size();
    if (i == 0) {
      return false;
    }
    return get(i - 1).getExceptionType().equals(CstType.OBJECT);
  }
  
  public int compareTo(CatchHandlerList paramCatchHandlerList)
  {
    if (this == paramCatchHandlerList) {}
    int j;
    int k;
    do
    {
      return 0;
      j = size();
      k = paramCatchHandlerList.size();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        int n = get(i).compareTo(paramCatchHandlerList.get(i));
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
  
  public CatchHandlerList.Entry get(int paramInt)
  {
    return (CatchHandlerList.Entry)get0(paramInt);
  }
  
  public void set(int paramInt, CatchHandlerList.Entry paramEntry)
  {
    set0(paramInt, paramEntry);
  }
  
  public void set(int paramInt1, CstType paramCstType, int paramInt2)
  {
    set0(paramInt1, new CatchHandlerList.Entry(paramCstType, paramInt2));
  }
  
  public String toHuman()
  {
    return toHuman("", "");
  }
  
  public String toHuman(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    int j = size();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    localStringBuilder.append("catch ");
    int i = 0;
    if (i < j)
    {
      paramString2 = get(i);
      if (i != 0)
      {
        localStringBuilder.append(",\n");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("  ");
      }
      if ((i == j - 1) && (catchesAll())) {
        localStringBuilder.append("<any>");
      }
      for (;;)
      {
        localStringBuilder.append(" -> ");
        localStringBuilder.append(Hex.u2or4(paramString2.getHandler()));
        i += 1;
        break;
        localStringBuilder.append(paramString2.getExceptionType().toHuman());
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.CatchHandlerList
 * JD-Core Version:    0.7.0.1
 */