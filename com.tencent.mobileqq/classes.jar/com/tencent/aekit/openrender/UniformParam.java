package com.tencent.aekit.openrender;

import android.opengl.GLES20;

public abstract class UniformParam
{
  public int handle;
  public String name;
  
  public UniformParam(String paramString)
  {
    this.name = paramString;
    this.handle = -1;
  }
  
  public void clear()
  {
    this.handle = -1;
  }
  
  public void initialParams(int paramInt)
  {
    this.handle = GLES20.glGetUniformLocation(paramInt, this.name);
  }
  
  public abstract void setParams(int paramInt);
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aekit.openrender.UniformParam
 * JD-Core Version:    0.7.0.1
 */