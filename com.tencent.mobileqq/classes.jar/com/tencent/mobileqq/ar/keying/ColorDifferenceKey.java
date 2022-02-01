package com.tencent.mobileqq.ar.keying;

import android.opengl.GLES20;

public class ColorDifferenceKey
  extends KeyingBase
{
  public int a;
  public int b;
  
  public ColorDifferenceKey(int paramInt)
  {
    super(paramInt);
    this.A = "uniform float uA;\nuniform float uD;\n";
    this.F = "    if(abs(gl_FragColor[0]-u_screenColor[0]) < uD && abs(gl_FragColor[1]-u_screenColor[1]) < uD  && abs(gl_FragColor[2]-u_screenColor[2]) < uD ){\n        gl_FragColor[3] = uA;\n        if(uA < 0.01){\n            gl_FragColor[0] = 0.0;\n            gl_FragColor[1] = 0.0;\n            gl_FragColor[2] = 0.0;\n        }\n    }\n";
  }
  
  protected void a()
  {
    this.a = GLES20.glGetUniformLocation(this.d, "uA");
    KeyingUtil.a("glGetAttribLocation uA");
    this.b = GLES20.glGetUniformLocation(this.d, "uD");
    KeyingUtil.a("glGetAttribLocation uD");
  }
  
  protected void a(KeyingParams paramKeyingParams)
  {
    if (paramKeyingParams == null) {
      return;
    }
    GLES20.glUniform1f(this.a, paramKeyingParams.e);
    GLES20.glUniform1f(this.b, paramKeyingParams.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.keying.ColorDifferenceKey
 * JD-Core Version:    0.7.0.1
 */