package com.tencent.magicbrush;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KMutableProperty1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 13})
final class x
  extends MutablePropertyReference1
{
  public static final KMutableProperty1 a = new x();
  
  @Nullable
  public Object get(@Nullable Object paramObject)
  {
    return Boolean.valueOf(((MBRuntime.MBParams)paramObject).enable_wxbindcanvastexture);
  }
  
  public String getName()
  {
    return "enable_wxbindcanvastexture";
  }
  
  public KDeclarationContainer getOwner()
  {
    return Reflection.getOrCreateKotlinClass(MBRuntime.MBParams.class);
  }
  
  public String getSignature()
  {
    return "getEnable_wxbindcanvastexture()Z";
  }
  
  public void set(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    ((MBRuntime.MBParams)paramObject1).enable_wxbindcanvastexture = ((Boolean)paramObject2).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.x
 * JD-Core Version:    0.7.0.1
 */