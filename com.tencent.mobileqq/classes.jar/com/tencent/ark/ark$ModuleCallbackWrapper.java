package com.tencent.ark;

public abstract interface ark$ModuleCallbackWrapper
{
  public abstract void Destruct();
  
  public abstract String GetTypeName();
  
  public abstract boolean HasMenthod(String paramString);
  
  public abstract boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.ark.ModuleCallbackWrapper
 * JD-Core Version:    0.7.0.1
 */