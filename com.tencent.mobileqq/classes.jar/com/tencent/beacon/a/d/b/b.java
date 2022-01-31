package com.tencent.beacon.a.d.b;

import com.tencent.beacon.a.h.c;
import java.util.ArrayList;

public final class b
  extends c
  implements Cloneable
{
  private static ArrayList<a> b;
  public ArrayList<a> a = null;
  
  public final void a(com.tencent.beacon.a.h.a parama)
  {
    if (b == null)
    {
      b = new ArrayList();
      a locala = new a();
      b.add(locala);
    }
    this.a = ((ArrayList)parama.a(b, 0, true));
  }
  
  public final void a(com.tencent.beacon.a.h.b paramb)
  {
    paramb.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.d.b.b
 * JD-Core Version:    0.7.0.1
 */