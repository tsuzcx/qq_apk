package com.tencent.TMG.opengl.glrenderer;

import android.opengl.GLES20;

class GLES20Canvas$AttributeShaderParameter
  extends GLES20Canvas.ShaderParameter
{
  public GLES20Canvas$AttributeShaderParameter(String paramString)
  {
    super(paramString);
  }
  
  public void loadHandle(int paramInt)
  {
    this.handle = GLES20.glGetAttribLocation(paramInt, this.mName);
    GLES20Canvas.checkError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.opengl.glrenderer.GLES20Canvas.AttributeShaderParameter
 * JD-Core Version:    0.7.0.1
 */