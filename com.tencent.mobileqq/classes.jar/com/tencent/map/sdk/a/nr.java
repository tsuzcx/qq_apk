package com.tencent.map.sdk.a;

public final class nr
  implements Cloneable
{
  private static final nt<Integer> c = new no();
  private static final nt<Number> d = new nn();
  int a;
  nq b;
  private nt e;
  
  public final nr a()
  {
    try
    {
      nr localnr = (nr)super.clone();
      localnr.a = this.a;
      localnr.b = this.b.a();
      localnr.e = this.e;
      return localnr;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label37:
      break label37;
    }
    return null;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(": ");
    localStringBuilder.append(this.b.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.nr
 * JD-Core Version:    0.7.0.1
 */