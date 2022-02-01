package com.tencent.luggage.wxa.de;

import android.util.SparseIntArray;
import com.tencent.luggage.wxa.qz.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/login/account/tdi/TdiCgiConfig$MAPPING$1", "Landroid/util/SparseIntArray;", "get", "", "url", "", "set", "", "funcId", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class h$a
  extends SparseIntArray
{
  public final int a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    int i = super.get(paramString.hashCode(), -1);
    if (c.a)
    {
      if (i != -1) {
        return i;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Found invalid cmdid, please register ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" in this map.");
      throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
    }
    return i;
  }
  
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    super.put(paramString.hashCode(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.h.a
 * JD-Core Version:    0.7.0.1
 */