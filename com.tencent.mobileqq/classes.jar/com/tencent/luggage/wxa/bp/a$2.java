package com.tencent.luggage.wxa.bp;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.ix.c;
import com.tencent.magicbrush.ui.i.d;
import org.jetbrains.annotations.NotNull;

class a$2
  extends i.d
{
  a$2(a parama) {}
  
  public void a(@NotNull Object paramObject)
  {
    paramObject = this.a.B();
    if ((paramObject != null) && (paramObject.al() != null))
    {
      paramObject.al().a(true);
      paramObject.al().b();
    }
  }
  
  public void a(@NotNull Object paramObject, boolean paramBoolean)
  {
    paramObject = this.a.B();
    if ((paramObject != null) && (paramObject.al() != null)) {
      paramObject.al().a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bp.a.2
 * JD-Core Version:    0.7.0.1
 */