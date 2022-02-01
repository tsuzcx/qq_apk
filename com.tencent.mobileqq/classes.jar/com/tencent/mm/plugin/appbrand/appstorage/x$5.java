package com.tencent.mm.plugin.appbrand.appstorage;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;

class x$5
  implements x.a
{
  x$5(x paramx) {}
  
  @NonNull
  public j a(@NonNull i parami, Object... paramVarArgs)
  {
    if (k.d(parami)) {
      return j.k;
    }
    if ((parami.o()) && (parami.j())) {
      return j.f;
    }
    paramVarArgs = (i)paramVarArgs[0];
    int i = ZipJNI.a(paramVarArgs.l(), parami.l(), null);
    o.d("MicroMsg.LuggageNonFlattenedFileSystem", "unzip zipFile(%s) iRet(%d)", new Object[] { paramVarArgs.l(), Integer.valueOf(i) });
    if (i == 0)
    {
      if ((x.b(this.a) > 0L) && (x.c(this.a) > x.b(this.a)))
      {
        k.c(parami);
        return j.p;
      }
      return j.a;
    }
    if (i != -1) {
      if (i != 1)
      {
        if (i == 2) {}
      }
      else {
        switch (i)
        {
        default: 
          return j.b;
        case -106: 
          return j.o;
          return j.e;
        }
      }
    }
    return j.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.x.5
 * JD-Core Version:    0.7.0.1
 */