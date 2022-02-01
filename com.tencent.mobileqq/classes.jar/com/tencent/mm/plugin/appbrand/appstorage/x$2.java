package com.tencent.mm.plugin.appbrand.appstorage;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.rt.i;
import java.util.List;
import java.util.regex.Pattern;

class x$2
  implements x.a
{
  x$2(x paramx) {}
  
  @NonNull
  public j a(@NonNull i parami, Object... paramVarArgs)
  {
    if (!parami.n()) {
      return j.q;
    }
    paramVarArgs = (List)paramVarArgs[0];
    k.a(parami, new x.2.1(this, Pattern.quote(parami.l()), paramVarArgs));
    return j.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.x.2
 * JD-Core Version:    0.7.0.1
 */