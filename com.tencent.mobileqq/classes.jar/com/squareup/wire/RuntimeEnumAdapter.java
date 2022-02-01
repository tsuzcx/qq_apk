package com.squareup.wire;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/RuntimeEnumAdapter;", "E", "Lcom/squareup/wire/WireEnum;", "Lcom/squareup/wire/EnumAdapter;", "javaType", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "fromValueMethod", "Ljava/lang/reflect/Method;", "equals", "", "other", "", "fromValue", "value", "", "(I)Lcom/squareup/wire/WireEnum;", "getFromValueMethod", "hashCode", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class RuntimeEnumAdapter<E extends WireEnum>
  extends EnumAdapter<E>
{
  private Method fromValueMethod;
  private final Class<E> javaType;
  
  public RuntimeEnumAdapter(@NotNull Class<E> paramClass)
  {
    super(JvmClassMappingKt.getKotlinClass(paramClass));
    this.javaType = paramClass;
  }
  
  private final Method getFromValueMethod()
  {
    Method localMethod = this.fromValueMethod;
    if (localMethod != null) {
      return localMethod;
    }
    localMethod = this.javaType.getMethod("fromValue", new Class[] { Integer.TYPE });
    this.fromValueMethod = localMethod;
    Intrinsics.checkExpressionValueIsNotNull(localMethod, "javaType.getMethod(\"from…romValueMethod = it\n    }");
    return localMethod;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof RuntimeEnumAdapter)) && (Intrinsics.areEqual(((RuntimeEnumAdapter)paramObject).getType(), getType()));
  }
  
  @Nullable
  protected E fromValue(int paramInt)
  {
    Object localObject = getFromValueMethod().invoke(null, new Object[] { Integer.valueOf(paramInt) });
    if (localObject != null) {
      return (WireEnum)localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type E");
  }
  
  public int hashCode()
  {
    KClass localKClass = getType();
    if (localKClass != null) {
      return localKClass.hashCode();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.RuntimeEnumAdapter
 * JD-Core Version:    0.7.0.1
 */