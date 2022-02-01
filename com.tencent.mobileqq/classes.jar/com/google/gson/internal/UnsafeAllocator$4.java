package com.google.gson.internal;

final class UnsafeAllocator$4
  extends UnsafeAllocator
{
  public <T> T newInstance(Class<T> paramClass)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot allocate ");
    localStringBuilder.append(paramClass);
    throw new UnsupportedOperationException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.UnsafeAllocator.4
 * JD-Core Version:    0.7.0.1
 */