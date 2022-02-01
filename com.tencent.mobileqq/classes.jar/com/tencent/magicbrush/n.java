package com.tencent.magicbrush;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KMutableProperty1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 13})
final class n
  extends MutablePropertyReference1
{
  public static final KMutableProperty1 a = new n();
  
  @Nullable
  public Object get(@Nullable Object paramObject)
  {
    return Float.valueOf(((MBRuntime.MBParams)paramObject).device_pixel_ratio_);
  }
  
  public String getName()
  {
    return "device_pixel_ratio_";
  }
  
  public KDeclarationContainer getOwner()
  {
    return Reflection.getOrCreateKotlinClass(MBRuntime.MBParams.class);
  }
  
  public String getSignature()
  {
    return "getDevice_pixel_ratio_()F";
  }
  
  public void set(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    ((MBRuntime.MBParams)paramObject1).device_pixel_ratio_ = ((Number)paramObject2).floatValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.n
 * JD-Core Version:    0.7.0.1
 */