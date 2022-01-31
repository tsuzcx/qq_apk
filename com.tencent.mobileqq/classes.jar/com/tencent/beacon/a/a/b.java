package com.tencent.beacon.a.a;

import java.io.Serializable;

public final class b
  implements Serializable
{
  public long a;
  public String b;
  public int c;
  public boolean d;
  public boolean e;
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while ((getClass() != paramObject.getClass()) || (!(paramObject instanceof b)));
      paramObject = (b)paramObject;
    } while ((paramObject.b == null) || (!paramObject.b.equals(this.b)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.a.b
 * JD-Core Version:    0.7.0.1
 */