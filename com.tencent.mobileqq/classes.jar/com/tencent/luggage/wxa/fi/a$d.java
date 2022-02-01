package com.tencent.luggage.wxa.fi;

import com.tencent.luggage.opensdk.a.c;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "onTerminate"}, k=3, mv={1, 1, 16})
final class a$d<T>
  implements e.c<String>
{
  a$d(a.c paramc, a.b paramb) {}
  
  public final void a(@Nullable String paramString)
  {
    int j = 1;
    int i = this.a.e;
    if (ArraysKt.contains(new Integer[] { Integer.valueOf(3), Integer.valueOf(1) }, Integer.valueOf(i)))
    {
      Object localObject = (CharSequence)paramString;
      i = j;
      if (localObject != null) {
        if (((CharSequence)localObject).length() == 0) {
          i = j;
        } else {
          i = 0;
        }
      }
      if (i == 0)
      {
        localObject = this.b;
        if (localObject != null) {
          ((a.b)localObject).a(paramString);
        }
      }
      else
      {
        paramString = this.b;
        if (paramString != null) {
          paramString.a("fail invalid result");
        }
      }
    }
    else if (Intrinsics.areEqual("ok", paramString))
    {
      paramString = this.b;
      if (paramString != null) {
        paramString.a();
      }
    }
    else
    {
      paramString = this.b;
      if (paramString != null) {
        paramString.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fi.a.d
 * JD-Core Version:    0.7.0.1
 */