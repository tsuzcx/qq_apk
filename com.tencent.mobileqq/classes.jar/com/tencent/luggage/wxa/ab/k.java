package com.tencent.luggage.wxa.ab;

import android.util.SparseArray;
import com.tencent.luggage.wxa.ao.u;

public final class k
{
  private final SparseArray<u> a = new SparseArray();
  
  public u a(int paramInt)
  {
    u localu2 = (u)this.a.get(paramInt);
    u localu1 = localu2;
    if (localu2 == null)
    {
      localu1 = new u(9223372036854775807L);
      this.a.put(paramInt, localu1);
    }
    return localu1;
  }
  
  public void a()
  {
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ab.k
 * JD-Core Version:    0.7.0.1
 */