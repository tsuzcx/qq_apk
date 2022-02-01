package com.tencent.magicbrush;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KMutableProperty1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 13})
final class af
  extends MutablePropertyReference1
{
  public static final KMutableProperty1 a = new af();
  
  @Nullable
  public Object get(@Nullable Object paramObject)
  {
    return Integer.valueOf(((MBRuntime.MBParams)paramObject).support_gfximage_share_texture);
  }
  
  public String getName()
  {
    return "support_gfximage_share_texture";
  }
  
  public KDeclarationContainer getOwner()
  {
    return Reflection.getOrCreateKotlinClass(MBRuntime.MBParams.class);
  }
  
  public String getSignature()
  {
    return "getSupport_gfximage_share_texture()I";
  }
  
  public void set(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    ((MBRuntime.MBParams)paramObject1).support_gfximage_share_texture = ((Number)paramObject2).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.af
 * JD-Core Version:    0.7.0.1
 */