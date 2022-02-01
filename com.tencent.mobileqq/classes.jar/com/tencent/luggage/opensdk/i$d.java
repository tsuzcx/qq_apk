package com.tencent.luggage.opensdk;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"asBoolean", "", "", "invoke"}, k=3, mv={1, 1, 16})
final class i$d
  extends Lambda
  implements Function1<Object, Boolean>
{
  public static final d a = new d();
  
  i$d()
  {
    super(1);
  }
  
  public final boolean a(@Nullable Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      return ((Boolean)paramObject).booleanValue();
    }
    if ((paramObject instanceof String)) {
      return Boolean.parseBoolean((String)paramObject);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.i.d
 * JD-Core Version:    0.7.0.1
 */