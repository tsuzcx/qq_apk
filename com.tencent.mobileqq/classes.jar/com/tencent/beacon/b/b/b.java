package com.tencent.beacon.b.b;

import com.tencent.beacon.e.c;
import java.util.ArrayList;

public final class b
  extends c
  implements Cloneable
{
  private static ArrayList<a> b;
  public ArrayList<a> a = null;
  
  public final void a(com.tencent.beacon.e.a parama)
  {
    if (b == null)
    {
      b = new ArrayList();
      a locala = new a();
      b.add(locala);
    }
    this.a = ((ArrayList)parama.a(b, 0, true));
  }
  
  public final void a(com.tencent.beacon.e.b paramb)
  {
    paramb.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.b.b.b
 * JD-Core Version:    0.7.0.1
 */