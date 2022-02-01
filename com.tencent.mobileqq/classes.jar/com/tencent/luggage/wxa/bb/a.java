package com.tencent.luggage.wxa.bb;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.o;

public class a
{
  private static a.b a;
  
  public static void a(a.a parama)
  {
    if (parama == null)
    {
      o.c("Luggage.LuggageBoot", "init component failed, initializer is null");
      return;
    }
    a.b localb = a;
    if (localb == null) {
      return;
    }
    localb.a(parama);
  }
  
  public static void a(@NonNull a.b paramb)
  {
    if (a != null)
    {
      o.b("Luggage.LuggageBoot", "do not setup more than once.");
      return;
    }
    if (paramb == null)
    {
      o.c("Luggage.LuggageBoot", "setup failed, delegate is null");
      return;
    }
    a = paramb;
    paramb.a(new a.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bb.a
 * JD-Core Version:    0.7.0.1
 */