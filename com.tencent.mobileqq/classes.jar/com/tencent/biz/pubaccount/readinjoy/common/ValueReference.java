package com.tencent.biz.pubaccount.readinjoy.common;

import androidx.annotation.NonNull;

public class ValueReference<V>
{
  private V a;
  
  public ValueReference(V paramV)
  {
    this.a = paramV;
  }
  
  public V a()
  {
    return this.a;
  }
  
  public void a(V paramV)
  {
    this.a = paramV;
  }
  
  @NonNull
  public String toString()
  {
    if (this.a != null) {
      return this.a.toString();
    }
    return "null";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ValueReference
 * JD-Core Version:    0.7.0.1
 */