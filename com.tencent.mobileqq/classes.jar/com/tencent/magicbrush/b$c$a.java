package com.tencent.magicbrush;

import com.tencent.luggage.wxa.gi.c.c;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "beforeSwap"}, k=3, mv={1, 1, 13})
final class b$c$a
  implements MBRuntime.a
{
  b$c$a(b.c paramc) {}
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = b.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hy: is swap all window: ");
    localStringBuilder.append(paramBoolean);
    c.c.b((String)localObject, localStringBuilder.toString(), new Object[0]);
    localObject = b.a(this.a.a, this.a.b, this.a.c, this.a.d);
    this.a.a(localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.b.c.a
 * JD-Core Version:    0.7.0.1
 */