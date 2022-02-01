package com.tencent.luggage.wxa.ku;

import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.dq.d.a;
import com.tencent.luggage.wxa.qz.af;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "onReceiveValue"}, k=3, mv={1, 1, 16})
final class t$a$c<T>
  implements ValueCallback<String>
{
  t$a$c(t.b paramb, String paramString, d.a[] paramArrayOfa, boolean[] paramArrayOfBoolean, Object[] paramArrayOfObject, long paramLong) {}
  
  public final void a(@Nullable String paramString)
  {
    long l = af.d();
    paramString = this.a;
    if (paramString != null) {
      paramString.a(this.b, this.c, this.d, this.e, this.f, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.t.a.c
 * JD-Core Version:    0.7.0.1
 */