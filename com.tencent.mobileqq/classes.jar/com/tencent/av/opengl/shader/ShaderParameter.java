package com.tencent.av.opengl.shader;

public abstract class ShaderParameter
{
  public int a;
  protected final String a;
  
  public ShaderParameter(String paramString)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public abstract void a(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.opengl.shader.ShaderParameter
 * JD-Core Version:    0.7.0.1
 */