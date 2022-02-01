package com.tencent.luggage.wxa.ll;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "", "name", "", "parameterTypes", "", "Ljava/lang/Class;", "(Ljava/lang/String;[Ljava/lang/Class;)V", "getName", "()Ljava/lang/String;", "getParameterTypes", "()[Ljava/lang/Class;", "[Ljava/lang/Class;", "component1", "component2", "copy", "(Ljava/lang/String;[Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "equals", "", "other", "hashCode", "", "toString", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 1, 16})
final class b$b
{
  @NotNull
  private final String a;
  @NotNull
  private final Class<? extends Object>[] b;
  
  public b$b(@NotNull String paramString, @NotNull Class<? extends Object>[] paramArrayOfClass)
  {
    this.a = paramString;
    this.b = paramArrayOfClass;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((b)this == paramObject) {
      return true;
    }
    Class localClass2 = getClass();
    Class localClass1;
    if (paramObject != null) {
      localClass1 = paramObject.getClass();
    } else {
      localClass1 = null;
    }
    if ((Intrinsics.areEqual(localClass2, localClass1) ^ true)) {
      return false;
    }
    if (paramObject != null)
    {
      paramObject = (b)paramObject;
      if ((Intrinsics.areEqual(this.a, paramObject.a) ^ true)) {
        return false;
      }
      return Arrays.equals(this.b, paramObject.b);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.model.NFCTech.MethodSignature");
  }
  
  public int hashCode()
  {
    return this.a.hashCode() * 31 + Arrays.hashCode(this.b);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MethodSignature(name=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", parameterTypes=");
    localStringBuilder.append(Arrays.toString(this.b));
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ll.b.b
 * JD-Core Version:    0.7.0.1
 */