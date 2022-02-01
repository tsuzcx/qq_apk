package com.tencent.luggage.wxa.nl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class b$a$a
{
  public static void a(b.a parama) {}
  
  public static void a(b.a parama, @NotNull j.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "request");
  }
  
  public static void a(b.a parama, @NotNull j.d paramd, @NotNull j.e parame)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "request");
    Intrinsics.checkParameterIsNotNull(parame, "response");
    j.c.a.a((j.c)parama, paramd, parame);
  }
  
  public static void b(b.a parama, @NotNull j.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "request");
    j.c.a.a((j.c)parama, paramd);
  }
  
  public static void b(b.a parama, @NotNull j.d paramd, @NotNull j.e parame)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "request");
    Intrinsics.checkParameterIsNotNull(parame, "response");
    j.c.a.b((j.c)parama, paramd, parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.b.a.a
 * JD-Core Version:    0.7.0.1
 */