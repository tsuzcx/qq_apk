package com.tencent.magicbrush;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KMutableProperty1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 13})
final class m
  extends MutablePropertyReference1
{
  public static final KMutableProperty1 a = new m();
  
  @Nullable
  public Object get(@Nullable Object paramObject)
  {
    return Integer.valueOf(((MBRuntime.MBParams)paramObject).cmd_pool_type);
  }
  
  public String getName()
  {
    return "cmd_pool_type";
  }
  
  public KDeclarationContainer getOwner()
  {
    return Reflection.getOrCreateKotlinClass(MBRuntime.MBParams.class);
  }
  
  public String getSignature()
  {
    return "getCmd_pool_type()I";
  }
  
  public void set(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    ((MBRuntime.MBParams)paramObject1).cmd_pool_type = ((Number)paramObject2).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.m
 * JD-Core Version:    0.7.0.1
 */