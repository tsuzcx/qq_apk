package com.tencent.magicbrush;

import android.content.res.AssetManager;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KMutableProperty1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 13})
final class j
  extends MutablePropertyReference1
{
  public static final KMutableProperty1 a = new j();
  
  @Nullable
  public Object get(@Nullable Object paramObject)
  {
    return ((MBRuntime.MBParams)paramObject).asset_manager;
  }
  
  public String getName()
  {
    return "asset_manager";
  }
  
  public KDeclarationContainer getOwner()
  {
    return Reflection.getOrCreateKotlinClass(MBRuntime.MBParams.class);
  }
  
  public String getSignature()
  {
    return "getAsset_manager()Landroid/content/res/AssetManager;";
  }
  
  public void set(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    ((MBRuntime.MBParams)paramObject1).asset_manager = ((AssetManager)paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.j
 * JD-Core Version:    0.7.0.1
 */