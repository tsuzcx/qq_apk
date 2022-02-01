package com.tencent.luggage.wxa.nl;

import com.tencent.luggage.wxa.qz.af;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "invoke"}, k=3, mv={1, 1, 16})
final class d$f
  extends Lambda
  implements Function3<Integer, Integer, String, Unit>
{
  d$f(d paramd)
  {
    super(3);
  }
  
  public final void a(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    Function2 localFunction2 = d.b(this.a);
    j.a locala = j.a.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('(');
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(',');
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(") ");
    localStringBuilder.append(af.b(paramString));
    localFunction2.invoke(locala, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.d.f
 * JD-Core Version:    0.7.0.1
 */