package com.tencent.magicbrush;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KMutableProperty1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 13})
final class v
  extends MutablePropertyReference1
{
  public static final KMutableProperty1 a = new v();
  
  @Nullable
  public Object get(@Nullable Object paramObject)
  {
    return Boolean.valueOf(((MBRuntime.MBParams)paramObject).enable_switch_thread_native_for_jsapis);
  }
  
  public String getName()
  {
    return "enable_switch_thread_native_for_jsapis";
  }
  
  public KDeclarationContainer getOwner()
  {
    return Reflection.getOrCreateKotlinClass(MBRuntime.MBParams.class);
  }
  
  public String getSignature()
  {
    return "getEnable_switch_thread_native_for_jsapis()Z";
  }
  
  public void set(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    ((MBRuntime.MBParams)paramObject1).enable_switch_thread_native_for_jsapis = ((Boolean)paramObject2).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.v
 * JD-Core Version:    0.7.0.1
 */