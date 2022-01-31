package com.tencent.av.app;

public class SessionInfoBase
{
  public long j;
  
  public long a()
  {
    return this.j;
  }
  
  public void a(long paramLong)
  {
    this.j = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (SessionInfoBase)paramObject;
    } while (this.j == paramObject.j);
    return false;
  }
  
  public int hashCode()
  {
    return (int)(this.j ^ this.j >>> 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.app.SessionInfoBase
 * JD-Core Version:    0.7.0.1
 */