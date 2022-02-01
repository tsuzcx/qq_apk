package com.android.dx.dex.code;

import com.android.dx.rop.cst.CstType;

public class CatchHandlerList$Entry
  implements Comparable<Entry>
{
  private final CstType exceptionType;
  private final int handler;
  
  public CatchHandlerList$Entry(CstType paramCstType, int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("handler < 0");
    }
    if (paramCstType == null) {
      throw new NullPointerException("exceptionType == null");
    }
    this.handler = paramInt;
    this.exceptionType = paramCstType;
  }
  
  public int compareTo(Entry paramEntry)
  {
    if (this.handler < paramEntry.handler) {
      return -1;
    }
    if (this.handler > paramEntry.handler) {
      return 1;
    }
    return this.exceptionType.compareTo(paramEntry.exceptionType);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Entry))
    {
      bool1 = bool2;
      if (compareTo((Entry)paramObject) == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public CstType getExceptionType()
  {
    return this.exceptionType;
  }
  
  public int getHandler()
  {
    return this.handler;
  }
  
  public int hashCode()
  {
    return this.handler * 31 + this.exceptionType.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.CatchHandlerList.Entry
 * JD-Core Version:    0.7.0.1
 */