package com.tencent.luggage.wxa.cu;

import com.tencent.luggage.wxa.ct.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errMsg", "", "invoke"}, k=3, mv={1, 1, 16})
final class i$c
  extends Lambda
  implements Function1<String, Unit>
{
  i$c(i parami, b paramb, int paramInt)
  {
    super(1);
  }
  
  public final void a(@Nullable String paramString)
  {
    Object localObject = (CharSequence)paramString;
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      paramString = "fail";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fail_");
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
    }
    this.b.a(this.c, i.a(this.a, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cu.i.c
 * JD-Core Version:    0.7.0.1
 */