package com.tencent.luggage.wxa.a;

import java.util.List;

class b$h
  implements b.f
{
  public boolean a(b.p paramp, h.al paramal)
  {
    boolean bool2 = paramal instanceof h.aj;
    boolean bool1 = true;
    if (bool2)
    {
      if (((h.aj)paramal).b().size() == 0) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public String toString()
  {
    return "empty";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.b.h
 * JD-Core Version:    0.7.0.1
 */