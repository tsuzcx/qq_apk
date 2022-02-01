package com.tencent.av.opengl.program;

import android.opengl.GLES20;
import com.tencent.av.opengl.shader.AttributeShaderParameter;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.shader.UniformShaderParameter;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.qphone.base.util.QLog;

public class TextureProgram
{
  int a = -1;
  int b = -1;
  int c = -1;
  ShaderParameter[] d;
  
  public TextureProgram()
  {
    this("uniform mat4 uMatrix;uniform mat4  uTextureMatrix;attribute vec2 aPosition;varying vec2 vTextureCoord;void main() {vec4 pos = vec4(aPosition, 0.0, 1.0);gl_Position = uMatrix * pos;vTextureCoord = (uTextureMatrix * (pos+vec4(0.5,0.5,0.0,0.0))).xy;}", "precision mediump float;varying vec2 vTextureCoord;uniform float uAlpha;uniform sampler2D  uTextureSampler0;void main() {gl_FragColor = texture2D(uTextureSampler0, vTextureCoord);gl_FragColor *= uAlpha;}", new ShaderParameter[] { new AttributeShaderParameter("aPosition"), new UniformShaderParameter("uMatrix"), new UniformShaderParameter("uAlpha"), new UniformShaderParameter("uTextureMatrix"), new UniformShaderParameter("uTextureSampler0") }, false);
  }
  
  protected TextureProgram(String paramString1, String paramString2, ShaderParameter[] paramArrayOfShaderParameter, boolean paramBoolean)
  {
    this.b = a(35633, paramString1);
    this.c = a(35632, paramString2);
    this.d = paramArrayOfShaderParameter;
    this.a = a(this.b, this.c, this.d);
  }
  
  public static int a(int paramInt1, int paramInt2, ShaderParameter[] paramArrayOfShaderParameter)
  {
    int j = GLES20.glCreateProgram();
    Utils.a();
    int i = 0;
    if (j == 0)
    {
      paramArrayOfShaderParameter = new StringBuilder();
      paramArrayOfShaderParameter.append("Cannot create GL program: = ");
      paramArrayOfShaderParameter.append(GLES20.glGetError());
      QLog.e("TextureProgram", 2, paramArrayOfShaderParameter.toString());
      return 0;
    }
    GLES20.glAttachShader(j, paramInt1);
    Utils.a();
    GLES20.glAttachShader(j, paramInt2);
    Utils.a();
    GLES20.glLinkProgram(j);
    Utils.a();
    int[] arrayOfInt = new int[1];
    GLES20.glGetProgramiv(j, 35714, arrayOfInt, 0);
    paramInt1 = i;
    if (arrayOfInt[0] != 1)
    {
      GLES20.glDeleteProgram(j);
      return 0;
    }
    while (paramInt1 < paramArrayOfShaderParameter.length)
    {
      paramArrayOfShaderParameter[paramInt1].a(j);
      paramInt1 += 1;
    }
    return j;
  }
  
  public static int a(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    Utils.a();
    GLES20.glCompileShader(paramInt);
    Utils.a();
    return paramInt;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public ShaderParameter[] b()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.program.TextureProgram
 * JD-Core Version:    0.7.0.1
 */