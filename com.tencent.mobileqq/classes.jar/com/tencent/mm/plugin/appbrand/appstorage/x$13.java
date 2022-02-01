package com.tencent.mm.plugin.appbrand.appstorage;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;

class x$13
  extends x.b
{
  x$13(x paramx)
  {
    super(paramx, null);
  }
  
  public j a(@NonNull i parami)
  {
    if (parami.n()) {
      return j.j;
    }
    if (!parami.j()) {
      return j.g;
    }
    int i = FileUnlink.a(parami.b());
    if (i != 0) {
      o.b("MicroMsg.LuggageNonFlattenedFileSystem", "unlink err %d, %s", new Object[] { Integer.valueOf(i), parami.b() });
    }
    if (i == 0) {
      return j.a;
    }
    return j.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.x.13
 * JD-Core Version:    0.7.0.1
 */