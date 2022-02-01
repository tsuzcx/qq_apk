package com.tencent.luggage.wxa.cx;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class n$a
  extends Lambda
  implements Function0<Unit>
{
  n$a(n paramn)
  {
    super(0);
  }
  
  public final void a()
  {
    Context localContext = r.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(n.a(this.a));
    localStringBuilder.append('\n');
    localStringBuilder.append(n.b(this.a));
    Toast.makeText(localContext, (CharSequence)localStringBuilder.toString(), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.n.a
 * JD-Core Version:    0.7.0.1
 */