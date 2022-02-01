package com.tencent.luggage.wxa.fw;

import androidx.arch.core.util.Function;
import com.tencent.luggage.wxa.ny.e.a;
import com.tencent.luggage.wxa.ny.e.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "invoke"}, k=3, mv={1, 1, 16})
final class a$d
  extends Lambda
  implements Function2<Integer, String, Unit>
{
  a$d(a parama)
  {
    super(2);
  }
  
  public final void a(int paramInt, @Nullable String paramString)
  {
    e.a locala = a.a(this.a);
    paramString = locala;
    if (!(locala instanceof e.b)) {
      paramString = null;
    }
    paramString = (e.b)paramString;
    if (paramString != null) {
      paramString.a((Function)a.d.1.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fw.a.d
 * JD-Core Version:    0.7.0.1
 */