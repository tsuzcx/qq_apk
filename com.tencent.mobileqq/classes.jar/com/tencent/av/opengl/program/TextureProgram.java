package com.tencent.av.opengl.program;

import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;
import lrt;
import lru;
import lrv;
import lsv;

public class TextureProgram
{
  int jdField_a_of_type_Int = -1;
  lru[] jdField_a_of_type_ArrayOfLru;
  int b = -1;
  int c = -1;
  
  public TextureProgram()
  {
    this("uniform mat4 uMatrix;uniform mat4  uTextureMatrix;attribute vec2 aPosition;varying vec2 vTextureCoord;void main() {vec4 pos = vec4(aPosition, 0.0, 1.0);gl_Position = uMatrix * pos;vTextureCoord = (uTextureMatrix * (pos+vec4(0.5,0.5,0.0,0.0))).xy;}", "precision mediump float;varying vec2 vTextureCoord;uniform float uAlpha;uniform sampler2D  uTextureSampler0;void main() {gl_FragColor = texture2D(uTextureSampler0, vTextureCoord);gl_FragColor *= uAlpha;}", new lru[] { new lrt("aPosition"), new lrv("uMatrix"), new lrv("uAlpha"), new lrv("uTextureMatrix"), new lrv("uTextureSampler0") }, false);
  }
  
  protected TextureProgram(String paramString1, String paramString2, lru[] paramArrayOflru, boolean paramBoolean)
  {
    this.b = a(35633, paramString1);
    this.c = a(35632, paramString2);
    this.jdField_a_of_type_ArrayOfLru = paramArrayOflru;
    this.jdField_a_of_type_Int = a(this.b, this.c, this.jdField_a_of_type_ArrayOfLru);
  }
  
  public static int a(int paramInt1, int paramInt2, lru[] paramArrayOflru)
  {
    int i = 0;
    int j = GLES20.glCreateProgram();
    lsv.a();
    if (j == 0)
    {
      QLog.e("TextureProgram", 2, "Cannot create GL program: = " + GLES20.glGetError());
      return 0;
    }
    GLES20.glAttachShader(j, paramInt1);
    lsv.a();
    GLES20.glAttachShader(j, paramInt2);
    lsv.a();
    GLES20.glLinkProgram(j);
    lsv.a();
    int[] arrayOfInt = new int[1];
    GLES20.glGetProgramiv(j, 35714, arrayOfInt, 0);
    paramInt1 = i;
    if (arrayOfInt[0] != 1)
    {
      GLES20.glDeleteProgram(j);
      return 0;
    }
    while (paramInt1 < paramArrayOflru.length)
    {
      paramArrayOflru[paramInt1].a(j);
      paramInt1 += 1;
    }
    return j;
  }
  
  public static int a(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    lsv.a();
    GLES20.glCompileShader(paramInt);
    lsv.a();
    return paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public lru[] a()
  {
    return this.jdField_a_of_type_ArrayOfLru;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.opengl.program.TextureProgram
 * JD-Core Version:    0.7.0.1
 */