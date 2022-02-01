package com.tencent.mm.plugin.appbrand.appstorage;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;

class x$9
  implements x.a
{
  x$9(x paramx) {}
  
  @NonNull
  public j a(@NonNull i parami, Object... paramVarArgs)
  {
    if ((!parami.o()) && (parami.j()))
    {
      if (parami.equals(x.a(this.a))) {
        return j.e;
      }
      if (((Boolean)paramVarArgs[0]).booleanValue())
      {
        o.e("MicroMsg.LuggageNonFlattenedFileSystem", "rmdir recursive");
        try
        {
          k.c(parami);
          return j.a;
        }
        catch (Exception parami)
        {
          o.b("MicroMsg.LuggageNonFlattenedFileSystem", "rmdir recursive exp = %s", new Object[] { parami });
          return j.b;
        }
      }
      paramVarArgs = parami.s();
      if (paramVarArgs.length > 0)
      {
        if (paramVarArgs.length != 1) {
          break label141;
        }
        if (paramVarArgs[0].d().equals(".nomedia")) {
          paramVarArgs[0].w();
        }
      }
      else
      {
        if (parami.w()) {
          return j.a;
        }
        return j.b;
      }
      return j.h;
      label141:
      return j.h;
    }
    return j.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.x.9
 * JD-Core Version:    0.7.0.1
 */