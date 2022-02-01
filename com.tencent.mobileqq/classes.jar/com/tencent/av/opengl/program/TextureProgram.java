package com.tencent.av.opengl.program;

import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;
import lrb;
import lrc;
import lrd;
import lsd;

public class TextureProgram
{
  int jdField_a_of_type_Int = -1;
  lrc[] jdField_a_of_type_ArrayOfLrc;
  int b = -1;
  int c = -1;
  
  public TextureProgram()
  {
    this("uniform mat4 uMatrix;uniform mat4  uTextureMatrix;attribute vec2 aPosition;varying vec2 vTextureCoord;void main() {vec4 pos = vec4(aPosition, 0.0, 1.0);gl_Position = uMatrix * pos;vTextureCoord = (uTextureMatrix * (pos+vec4(0.5,0.5,0.0,0.0))).xy;}", "precision mediump float;varying vec2 vTextureCoord;uniform float uAlpha;uniform sampler2D  uTextureSampler0;void main() {gl_FragColor = texture2D(uTextureSampler0, vTextureCoord);gl_FragColor *= uAlpha;}", new lrc[] { new lrb("aPosition"), new lrd("uMatrix"), new lrd("uAlpha"), new lrd("uTextureMatrix"), new lrd("uTextureSampler0") }, false);
  }
  
  protected TextureProgram(String paramString1, String paramString2, lrc[] paramArrayOflrc, boolean paramBoolean)
  {
    this.b = a(35633, paramString1);
    this.c = a(35632, paramString2);
    this.jdField_a_of_type_ArrayOfLrc = paramArrayOflrc;
    this.jdField_a_of_type_Int = a(this.b, this.c, this.jdField_a_of_type_ArrayOfLrc);
  }
  
  public static int a(int paramInt1, int paramInt2, lrc[] paramArrayOflrc)
  {
    int i = 0;
    int j = GLES20.glCreateProgram();
    lsd.a();
    if (j == 0)
    {
      QLog.e("TextureProgram", 2, "Cannot create GL program: = " + GLES20.glGetError());
      return 0;
    }
    GLES20.glAttachShader(j, paramInt1);
    lsd.a();
    GLES20.glAttachShader(j, paramInt2);
    lsd.a();
    GLES20.glLinkProgram(j);
    lsd.a();
    int[] arrayOfInt = new int[1];
    GLES20.glGetProgramiv(j, 35714, arrayOfInt, 0);
    paramInt1 = i;
    if (arrayOfInt[0] != 1)
    {
      GLES20.glDeleteProgram(j);
      return 0;
    }
    while (paramInt1 < paramArrayOflrc.length)
    {
      paramArrayOflrc[paramInt1].a(j);
      paramInt1 += 1;
    }
    return j;
  }
  
  public static int a(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    lsd.a();
    GLES20.glCompileShader(paramInt);
    lsd.a();
    return paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public lrc[] a()
  {
    return this.jdField_a_of_type_ArrayOfLrc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.opengl.program.TextureProgram
 * JD-Core Version:    0.7.0.1
 */