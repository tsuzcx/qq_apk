package com.google.protobuf;

abstract interface Schema<T>
{
  public abstract int a(T paramT);
  
  public abstract T a();
  
  public abstract void a(T paramT, Reader paramReader, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract void a(T paramT, Writer paramWriter);
  
  public abstract void a(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, ArrayDecoders.Registers paramRegisters);
  
  public abstract boolean a(T paramT1, T paramT2);
  
  public abstract int b(T paramT);
  
  public abstract void b(T paramT1, T paramT2);
  
  public abstract void d(T paramT);
  
  public abstract boolean e(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Schema
 * JD-Core Version:    0.7.0.1
 */