package com.android.dx.cf.iface;

public abstract interface AttributeList
{
  public abstract int byteLength();
  
  public abstract Attribute findFirst(String paramString);
  
  public abstract Attribute findNext(Attribute paramAttribute);
  
  public abstract Attribute get(int paramInt);
  
  public abstract boolean isMutable();
  
  public abstract int size();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.iface.AttributeList
 * JD-Core Version:    0.7.0.1
 */