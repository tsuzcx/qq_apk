package com.tencent.magicbrush;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KMutableProperty1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 13})
final class h
  extends MutablePropertyReference1
{
  public static final KMutableProperty1 a = new h();
  
  @Nullable
  public Object get(@Nullable Object paramObject)
  {
    return Boolean.valueOf(((MBRuntime.MBParams)paramObject).adjust_thread_priority);
  }
  
  public String getName()
  {
    return "adjust_thread_priority";
  }
  
  public KDeclarationContainer getOwner()
  {
    return Reflection.getOrCreateKotlinClass(MBRuntime.MBParams.class);
  }
  
  public String getSignature()
  {
    return "getAdjust_thread_priority()Z";
  }
  
  public void set(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    ((MBRuntime.MBParams)paramObject1).adjust_thread_priority = ((Boolean)paramObject2).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.h
 * JD-Core Version:    0.7.0.1
 */