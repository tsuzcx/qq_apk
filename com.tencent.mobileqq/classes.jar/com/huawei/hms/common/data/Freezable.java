package com.huawei.hms.common.data;

public abstract interface Freezable<T>
{
  public abstract T freeze();
  
  public abstract boolean isDataValid();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.data.Freezable
 * JD-Core Version:    0.7.0.1
 */