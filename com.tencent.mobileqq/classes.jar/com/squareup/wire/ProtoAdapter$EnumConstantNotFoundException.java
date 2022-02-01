package com.squareup.wire;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmField;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/ProtoAdapter$EnumConstantNotFoundException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "value", "", "type", "Ljava/lang/Class;", "(ILjava/lang/Class;)V", "Lkotlin/reflect/KClass;", "(ILkotlin/reflect/KClass;)V", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class ProtoAdapter$EnumConstantNotFoundException
  extends IllegalArgumentException
{
  @JvmField
  public final int value;
  
  public ProtoAdapter$EnumConstantNotFoundException(int paramInt, @NotNull Class<?> paramClass)
  {
    this(paramInt, JvmClassMappingKt.getKotlinClass(paramClass));
  }
  
  public ProtoAdapter$EnumConstantNotFoundException(int paramInt, @Nullable KClass<?> paramKClass)
  {
    super(localStringBuilder.toString());
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.ProtoAdapter.EnumConstantNotFoundException
 * JD-Core Version:    0.7.0.1
 */