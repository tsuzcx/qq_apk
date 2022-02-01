package com.tencent.av.opengl.multiplevideos.renderbase;

public abstract class RenderObject
{
  private String a;
  
  public RenderObject()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("-");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.a = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.multiplevideos.renderbase.RenderObject
 * JD-Core Version:    0.7.0.1
 */