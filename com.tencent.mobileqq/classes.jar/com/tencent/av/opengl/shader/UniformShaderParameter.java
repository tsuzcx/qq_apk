package com.tencent.av.opengl.shader;

import android.opengl.GLES20;
import com.tencent.av.opengl.utils.Utils;

public class UniformShaderParameter
  extends ShaderParameter
{
  public UniformShaderParameter(String paramString)
  {
    super(paramString);
  }
  
  public void a(int paramInt)
  {
    this.a = GLES20.glGetUniformLocation(paramInt, this.b);
    Utils.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.shader.UniformShaderParameter
 * JD-Core Version:    0.7.0.1
 */