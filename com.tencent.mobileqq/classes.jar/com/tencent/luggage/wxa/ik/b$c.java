package com.tencent.luggage.wxa.ik;

import android.os.Process;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class b$c
  extends Lambda
  implements Function0<String>
{
  b$c(b paramb)
  {
    super(0);
  }
  
  @NotNull
  public final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append('_');
    localStringBuilder.append(this.a.hashCode());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ik.b.c
 * JD-Core Version:    0.7.0.1
 */