package com.tencent.luggage.wxa.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class a$a
  extends a
{
  public final long aQ;
  public final List<a.b> aR;
  public final List<a> aS;
  
  public a$a(int paramInt, long paramLong)
  {
    super(paramInt);
    this.aQ = paramLong;
    this.aR = new ArrayList();
    this.aS = new ArrayList();
  }
  
  public void a(a parama)
  {
    this.aS.add(parama);
  }
  
  public void a(a.b paramb)
  {
    this.aR.add(paramb);
  }
  
  public a.b d(int paramInt)
  {
    int j = this.aR.size();
    int i = 0;
    while (i < j)
    {
      a.b localb = (a.b)this.aR.get(i);
      if (localb.aP == paramInt) {
        return localb;
      }
      i += 1;
    }
    return null;
  }
  
  public a e(int paramInt)
  {
    int j = this.aS.size();
    int i = 0;
    while (i < j)
    {
      a locala = (a)this.aS.get(i);
      if (locala.aP == paramInt) {
        return locala;
      }
      i += 1;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c(this.aP));
    localStringBuilder.append(" leaves: ");
    localStringBuilder.append(Arrays.toString(this.aR.toArray()));
    localStringBuilder.append(" containers: ");
    localStringBuilder.append(Arrays.toString(this.aS.toArray()));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.p.a.a
 * JD-Core Version:    0.7.0.1
 */