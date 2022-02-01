package com.tencent.luggage.wxa.gn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class b
{
  private static b a;
  private ArrayList<com.tencent.luggage.wxa.gm.b> b = new ArrayList();
  
  public static b a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new b();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(com.tencent.luggage.wxa.gm.b paramb)
  {
    if (paramb != null) {
      try
      {
        if (paramb.d != null)
        {
          paramb.b = 0;
          paramb.a = 0;
          paramb.e.clear();
          Arrays.fill(paramb.d, 0, paramb.d.length, (byte)0);
          this.b.add(0, paramb);
          return;
        }
      }
      finally {}
    }
  }
  
  public com.tencent.luggage.wxa.gm.b b()
  {
    try
    {
      if (this.b.size() > 0)
      {
        localb = (com.tencent.luggage.wxa.gm.b)this.b.remove(this.b.size() - 1);
        return localb;
      }
      com.tencent.luggage.wxa.gm.b localb = new com.tencent.luggage.wxa.gm.b();
      return localb;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gn.b
 * JD-Core Version:    0.7.0.1
 */