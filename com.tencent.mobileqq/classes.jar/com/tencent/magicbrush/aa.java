package com.tencent.magicbrush;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KMutableProperty1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 13})
final class aa
  extends MutablePropertyReference1
{
  public static final KMutableProperty1 a = new aa();
  
  @Nullable
  public Object get(@Nullable Object paramObject)
  {
    return Boolean.valueOf(((MBRuntime.MBParams)paramObject).is_game);
  }
  
  public String getName()
  {
    return "is_game";
  }
  
  public KDeclarationContainer getOwner()
  {
    return Reflection.getOrCreateKotlinClass(MBRuntime.MBParams.class);
  }
  
  public String getSignature()
  {
    return "is_game()Z";
  }
  
  public void set(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    ((MBRuntime.MBParams)paramObject1).is_game = ((Boolean)paramObject2).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.aa
 * JD-Core Version:    0.7.0.1
 */