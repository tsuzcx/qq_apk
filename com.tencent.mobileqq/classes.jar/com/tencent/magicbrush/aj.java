package com.tencent.magicbrush;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KMutableProperty1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 13})
final class aj
  extends MutablePropertyReference1
{
  public static final KMutableProperty1 a = new aj();
  
  @Nullable
  public Object get(@Nullable Object paramObject)
  {
    return ((MBRuntime.MBParams)paramObject).wasm_cache_path;
  }
  
  public String getName()
  {
    return "wasm_cache_path";
  }
  
  public KDeclarationContainer getOwner()
  {
    return Reflection.getOrCreateKotlinClass(MBRuntime.MBParams.class);
  }
  
  public String getSignature()
  {
    return "getWasm_cache_path()Ljava/lang/String;";
  }
  
  public void set(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    ((MBRuntime.MBParams)paramObject1).wasm_cache_path = ((String)paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.aj
 * JD-Core Version:    0.7.0.1
 */