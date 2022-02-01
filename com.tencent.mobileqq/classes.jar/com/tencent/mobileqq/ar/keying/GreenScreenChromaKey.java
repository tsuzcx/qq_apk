package com.tencent.mobileqq.ar.keying;

import android.opengl.GLES20;

public class GreenScreenChromaKey
  extends KeyingBase
{
  public int a;
  public int b;
  public int c;
  
  public GreenScreenChromaKey(int paramInt)
  {
    super(paramInt);
    this.e = "uniform float u_threshold;\nuniform float u_clipBlack;\nuniform float u_clipWhite;\nfloat rgb2cb(float r, float g, float b){\n    return 0.5 + -0.168736*r - 0.331264*g + 0.5*b;\n}\nfloat rgb2cr(float r, float g, float b){\n    return 0.5 + 0.5*r - 0.418688*g - 0.081312*b;\n}\nfloat smoothclip(float low, float high, float x){\n    if (x <= low){\n        return 0.0;\n    }\n    if(x >= high){\n        return 1.0;\n    }\n    return (x-low)/(high-low);\n}\nvec4 greenscreen(vec4 color, float Cb_key,float Cr_key, float tola,float tolb, float clipBlack, float clipWhite){\n    float cb = rgb2cb(color.r,color.g,color.b);\n    float cr = rgb2cr(color.r,color.g,color.b);\n    float alpha = distance(vec2(cb, cr), vec2(Cb_key, Cr_key));\n    alpha = smoothclip(tola, tolb, alpha);\n    float r = max(gl_FragColor.r - (1.0-alpha)*u_screenColor.r, 0.0);\n    float g = max(gl_FragColor.g - (1.0-alpha)*u_screenColor.g, 0.0);\n    float b = max(gl_FragColor.b - (1.0-alpha)*u_screenColor.b, 0.0);\n    if(alpha < clipBlack){\n        alpha = r = g = b = 0.0;\n    }\n    if(alpha > clipWhite){\n        alpha = 1.0;\n    }\n    if(clipWhite < 1.0){\n        alpha = alpha/max(clipWhite, 0.9);\n    }\n    return vec4(r,g,b, alpha);\n}\n";
    this.j = "    float tola = 0.0;\n    float tolb = u_threshold/2.0;\n    float cb_key = rgb2cb(u_screenColor.r, u_screenColor.g, u_screenColor.b);\n    float cr_key = rgb2cr(u_screenColor.r, u_screenColor.g, u_screenColor.b);\n    gl_FragColor = greenscreen(gl_FragColor, cb_key, cr_key, tola, tolb, u_clipBlack, u_clipWhite);\n";
  }
  
  protected void a()
  {
    this.a = GLES20.glGetUniformLocation(this.d, "u_threshold");
    KeyingUtil.a("glGetAttribLocation u_threshold");
    this.b = GLES20.glGetUniformLocation(this.d, "u_clipBlack");
    KeyingUtil.a("glGetAttribLocation u_clipBlack");
    this.c = GLES20.glGetUniformLocation(this.d, "u_clipWhite");
    KeyingUtil.a("glGetAttribLocation u_clipWhite");
  }
  
  protected void a(KeyingParams paramKeyingParams)
  {
    if (paramKeyingParams == null) {
      return;
    }
    GLES20.glUniform1f(this.a, paramKeyingParams.f);
    GLES20.glUniform1f(this.b, paramKeyingParams.g);
    GLES20.glUniform1f(this.c, paramKeyingParams.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.keying.GreenScreenChromaKey
 * JD-Core Version:    0.7.0.1
 */