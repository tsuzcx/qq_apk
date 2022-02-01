package com.tencent.mm.plugin.appbrand.appstorage;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;

class x$14
  implements x.a
{
  x$14(x paramx) {}
  
  @NonNull
  public j a(@NonNull i parami, Object... paramVarArgs)
  {
    if (!parami.j()) {
      return j.g;
    }
    int i = FileStat.a(parami.b(), (FileStructStat)paramVarArgs[0]);
    if (i != 0) {
      o.b("MicroMsg.LuggageNonFlattenedFileSystem", "stat err %d, %s", new Object[] { Integer.valueOf(i), parami.b() });
    }
    if (i == 0) {
      return j.a;
    }
    return j.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.x.14
 * JD-Core Version:    0.7.0.1
 */