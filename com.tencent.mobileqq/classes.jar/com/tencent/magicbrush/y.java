package com.tencent.magicbrush;

import com.tencent.magicbrush.handler.fs.IMBFileSystem;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KMutableProperty1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 13})
final class y
  extends MutablePropertyReference1
{
  public static final KMutableProperty1 a = new y();
  
  @Nullable
  public Object get(@Nullable Object paramObject)
  {
    return ((MBRuntime.MBParams)paramObject).file_system_;
  }
  
  public String getName()
  {
    return "file_system_";
  }
  
  public KDeclarationContainer getOwner()
  {
    return Reflection.getOrCreateKotlinClass(MBRuntime.MBParams.class);
  }
  
  public String getSignature()
  {
    return "getFile_system_()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;";
  }
  
  public void set(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    ((MBRuntime.MBParams)paramObject1).file_system_ = ((IMBFileSystem)paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.y
 * JD-Core Version:    0.7.0.1
 */