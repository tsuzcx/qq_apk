package com.qq.android.dexposed;

class DexposedBridge$AdditionalHookInfo
{
  final DexposedBridge.CopyOnWriteSortedSet<XC_MethodHook> callbacks;
  final Class<?>[] parameterTypes;
  final Class<?> returnType;
  
  private DexposedBridge$AdditionalHookInfo(DexposedBridge.CopyOnWriteSortedSet<XC_MethodHook> paramCopyOnWriteSortedSet, Class<?>[] paramArrayOfClass, Class<?> paramClass)
  {
    this.callbacks = paramCopyOnWriteSortedSet;
    this.parameterTypes = paramArrayOfClass;
    this.returnType = paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.qq.android.dexposed.DexposedBridge.AdditionalHookInfo
 * JD-Core Version:    0.7.0.1
 */