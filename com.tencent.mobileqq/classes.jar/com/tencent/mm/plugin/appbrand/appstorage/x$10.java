package com.tencent.mm.plugin.appbrand.appstorage;

import androidx.annotation.NonNull;
import java.util.LinkedList;
import java.util.regex.Pattern;

class x$10
  implements x.a
{
  x$10(x paramx) {}
  
  @NonNull
  public j a(@NonNull com.tencent.luggage.wxa.rt.i parami, Object... paramVarArgs)
  {
    if (!parami.n()) {
      return j.i;
    }
    if (k.d(parami)) {
      return j.k;
    }
    LinkedList localLinkedList = new LinkedList();
    parami.a(new x.10.1(this, Pattern.quote(parami.l()), localLinkedList));
    ((com.tencent.luggage.wxa.pc.i)paramVarArgs[0]).a = localLinkedList;
    return j.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.x.10
 * JD-Core Version:    0.7.0.1
 */