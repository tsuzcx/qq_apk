package com.tencent.luggage.wxa.ll;

import com.tencent.luggage.wxa.qz.o;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$hasMethod$1$1"}, k=3, mv={1, 1, 16})
final class b$c
  extends Lambda
  implements Function0<Boolean>
{
  b$c(b.b paramb, b paramb1, String paramString, Class[] paramArrayOfClass)
  {
    super(0);
  }
  
  public final boolean a()
  {
    boolean bool;
    try
    {
      Class localClass = Class.forName(this.b.b());
      localObject1 = this.c;
      localObject2 = this.d;
      localClass.getDeclaredMethod((String)localObject1, (Class[])Arrays.copyOf((Object[])localObject2, localObject2.length));
      bool = true;
    }
    catch (Exception localException)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("get ");
      ((StringBuilder)localObject1).append(this.b.b());
      ((StringBuilder)localObject1).append('.');
      ((StringBuilder)localObject1).append(this.c);
      ((StringBuilder)localObject1).append('(');
      Object localObject2 = Arrays.toString(this.d);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "java.util.Arrays.toString(this)");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(") failed since ");
      ((StringBuilder)localObject1).append(localException);
      o.d("MicroMsg.AppBrand.NFCTech", ((StringBuilder)localObject1).toString());
      bool = false;
    }
    ((Map)b.a(this.b)).put(this.a, Boolean.valueOf(bool));
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ll.b.c
 * JD-Core Version:    0.7.0.1
 */