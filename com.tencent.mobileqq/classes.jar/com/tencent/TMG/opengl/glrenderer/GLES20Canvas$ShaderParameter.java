package com.tencent.TMG.opengl.glrenderer;

abstract class GLES20Canvas$ShaderParameter
{
  public int handle;
  protected final String mName;
  
  public GLES20Canvas$ShaderParameter(String paramString)
  {
    this.mName = paramString;
  }
  
  public abstract void loadHandle(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.opengl.glrenderer.GLES20Canvas.ShaderParameter
 * JD-Core Version:    0.7.0.1
 */