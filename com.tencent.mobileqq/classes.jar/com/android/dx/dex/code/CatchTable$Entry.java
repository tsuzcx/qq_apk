package com.android.dx.dex.code;

public class CatchTable$Entry
  implements Comparable<Entry>
{
  private final int end;
  private final CatchHandlerList handlers;
  private final int start;
  
  public CatchTable$Entry(int paramInt1, int paramInt2, CatchHandlerList paramCatchHandlerList)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("start < 0");
    }
    if (paramInt2 <= paramInt1) {
      throw new IllegalArgumentException("end <= start");
    }
    if (paramCatchHandlerList.isMutable()) {
      throw new IllegalArgumentException("handlers.isMutable()");
    }
    this.start = paramInt1;
    this.end = paramInt2;
    this.handlers = paramCatchHandlerList;
  }
  
  public int compareTo(Entry paramEntry)
  {
    if (this.start < paramEntry.start) {}
    do
    {
      return -1;
      if (this.start > paramEntry.start) {
        return 1;
      }
    } while (this.end < paramEntry.end);
    if (this.end > paramEntry.end) {
      return 1;
    }
    return this.handlers.compareTo(paramEntry.handlers);
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
  
  public int getEnd()
  {
    return this.end;
  }
  
  public CatchHandlerList getHandlers()
  {
    return this.handlers;
  }
  
  public int getStart()
  {
    return this.start;
  }
  
  public int hashCode()
  {
    return (this.start * 31 + this.end) * 31 + this.handlers.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.CatchTable.Entry
 * JD-Core Version:    0.7.0.1
 */