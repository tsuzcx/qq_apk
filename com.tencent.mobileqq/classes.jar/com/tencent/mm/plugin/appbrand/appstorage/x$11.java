package com.tencent.mm.plugin.appbrand.appstorage;

import androidx.annotation.NonNull;

class x$11
  implements x.a
{
  x$11(x paramx) {}
  
  @NonNull
  public j a(@NonNull com.tencent.luggage.wxa.rt.i parami, Object... paramVarArgs)
  {
    com.tencent.luggage.wxa.pc.i locali = (com.tencent.luggage.wxa.pc.i)paramVarArgs[0];
    int i = paramVarArgs.length;
    Long localLong = null;
    if (i >= 3)
    {
      localLong = (Long)paramVarArgs[1];
      paramVarArgs = (Long)paramVarArgs[2];
    }
    else
    {
      paramVarArgs = null;
    }
    if (!parami.j()) {
      return j.g;
    }
    if (!parami.o()) {
      return j.e;
    }
    if (k.d(parami)) {
      return j.k;
    }
    if (locali != null) {
      if ((localLong != null) && (paramVarArgs != null))
      {
        Object localObject = this.a.a(localLong.longValue(), paramVarArgs.longValue(), parami.q());
        if (localObject != j.a) {
          return localObject;
        }
        localObject = paramVarArgs;
        if (paramVarArgs.longValue() == 9223372036854775807L) {
          localObject = Long.valueOf(parami.q() - localLong.longValue());
        }
        locali.a = k.a(parami, localLong.longValue(), ((Long)localObject).longValue());
      }
      else
      {
        locali.a = k.b(parami);
      }
    }
    return j.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.x.11
 * JD-Core Version:    0.7.0.1
 */