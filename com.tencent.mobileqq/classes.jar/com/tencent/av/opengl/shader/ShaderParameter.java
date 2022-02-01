package com.tencent.av.opengl.shader;

public abstract class ShaderParameter
{
  public int a = -1;
  protected final String b;
  
  public ShaderParameter(String paramString)
  {
    this.b = paramString;
  }
  
  public abstract void a(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.shader.ShaderParameter
 * JD-Core Version:    0.7.0.1
 */