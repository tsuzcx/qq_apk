package com.tencent.av.opengl.effects;

import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class RGBToI420Filter
{
  protected FloatBuffer a;
  protected FloatBuffer b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  private final String k = "attribute vec4 aVertexCo;\nattribute vec2 aTextureCo;\n\nuniform mat4 uVertexMatrix;\nuniform mat4 uTextureMatrix;\n\nvarying vec2 vTextureCo;\n\nvoid main(){\n    gl_Position = uVertexMatrix*aVertexCo;\n    vTextureCo = (uTextureMatrix*vec4(aTextureCo,0,1)).xy;\n}";
  private final String l = "precision highp float;\nprecision highp int;\n\nvarying vec2 vTextureCo;\nuniform sampler2D uTexture;\n\nuniform float uWidth;\nuniform float uHeight;\n\nfloat cY(float x,float y){\n    vec4 c=texture2D(uTexture,vec2(x,y));\n    return c.r*0.257+c.g*0.504+c.b*0.098+0.0625;\n}\n\nvec4 cC(float x,float y,float dx,float dy){\n    vec4 c0=texture2D(uTexture,vec2(x,y));\n    vec4 c1=texture2D(uTexture,vec2(x+dx,y));\n    vec4 c2=texture2D(uTexture,vec2(x,y+dy));\n    vec4 c3=texture2D(uTexture,vec2(x+dx,y+dy));\n    return (c0+c1+c2+c3)/4.;\n}\n\nfloat cU(float x,float y,float dx,float dy){\n    vec4 c=cC(x,y,dx,dy);\n    return -0.148*c.r - 0.291*c.g + 0.439*c.b+0.5000;\n}\n\nfloat cV(float x,float y,float dx,float dy){\n    vec4 c=cC(x,y,dx,dy);\n    return 0.439*c.r - 0.368*c.g - 0.071*c.b+0.5000;\n}\n\nvec2 cPos(float t,float shiftx,float gy){\n    vec2 pos=vec2(floor(uWidth*vTextureCo.x),floor(uHeight*gy));\n    return vec2(mod(pos.x*shiftx,uWidth),(pos.y*shiftx+floor(pos.x*shiftx/uWidth))*t);\n}\n\nvec4 calculateY(){\n    vec2 pos=cPos(1.,4.,vTextureCo.y);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]=cY(pos.x/uWidth,textureYPos);\n    oColor[1]=cY((pos.x+1.)/uWidth,textureYPos);\n    oColor[2]=cY((pos.x+2.)/uWidth,textureYPos);\n    oColor[3]=cY((pos.x+3.)/uWidth,textureYPos);\n    return oColor;\n}\nvec4 calculateU(float gy,float dx,float dy){\n    vec2 pos=cPos(2.,8.,vTextureCo.y-gy);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[2]= cU((pos.x+4.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cU((pos.x+6.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateV(float gy,float dx,float dy){\n    vec2 pos=cPos(2.,8.,vTextureCo.y-gy);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]=cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]=cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[2]=cV((pos.x+4.)/uWidth,textureYPos,dx,dy);\n    oColor[3]=cV((pos.x+6.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateUV(float dx,float dy){\n    vec2 pos=cPos(2.,4.,vTextureCo.y-0.2500);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[2]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateVU(float dx,float dy){\n    vec2 pos=cPos(2.,4.,vTextureCo.y-0.2500);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[2]= cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvoid main() {\n    if(vTextureCo.y<0.2500){\n        gl_FragColor=calculateY();\n    }else if(vTextureCo.y<0.3125){\n        gl_FragColor=calculateU(0.2500,1./uWidth,1./uHeight);\n    }else if(vTextureCo.y<0.3750){\n        gl_FragColor=calculateV(0.3125,1./uWidth,1./uHeight);\n    }else{\n        gl_FragColor=vec4(0,0,0,0);\n    }\n}";
  private float[] m = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  private float[] n = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  private String o = "attribute vec4 aVertexCo;\nattribute vec2 aTextureCo;\n\nuniform mat4 uVertexMatrix;\nuniform mat4 uTextureMatrix;\n\nvarying vec2 vTextureCo;\n\nvoid main(){\n    gl_Position = uVertexMatrix*aVertexCo;\n    vTextureCo = (uTextureMatrix*vec4(aTextureCo,0,1)).xy;\n}";
  private String p = "precision highp float;\nprecision highp int;\n\nvarying vec2 vTextureCo;\nuniform sampler2D uTexture;\n\nuniform float uWidth;\nuniform float uHeight;\n\nfloat cY(float x,float y){\n    vec4 c=texture2D(uTexture,vec2(x,y));\n    return c.r*0.257+c.g*0.504+c.b*0.098+0.0625;\n}\n\nvec4 cC(float x,float y,float dx,float dy){\n    vec4 c0=texture2D(uTexture,vec2(x,y));\n    vec4 c1=texture2D(uTexture,vec2(x+dx,y));\n    vec4 c2=texture2D(uTexture,vec2(x,y+dy));\n    vec4 c3=texture2D(uTexture,vec2(x+dx,y+dy));\n    return (c0+c1+c2+c3)/4.;\n}\n\nfloat cU(float x,float y,float dx,float dy){\n    vec4 c=cC(x,y,dx,dy);\n    return -0.148*c.r - 0.291*c.g + 0.439*c.b+0.5000;\n}\n\nfloat cV(float x,float y,float dx,float dy){\n    vec4 c=cC(x,y,dx,dy);\n    return 0.439*c.r - 0.368*c.g - 0.071*c.b+0.5000;\n}\n\nvec2 cPos(float t,float shiftx,float gy){\n    vec2 pos=vec2(floor(uWidth*vTextureCo.x),floor(uHeight*gy));\n    return vec2(mod(pos.x*shiftx,uWidth),(pos.y*shiftx+floor(pos.x*shiftx/uWidth))*t);\n}\n\nvec4 calculateY(){\n    vec2 pos=cPos(1.,4.,vTextureCo.y);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]=cY(pos.x/uWidth,textureYPos);\n    oColor[1]=cY((pos.x+1.)/uWidth,textureYPos);\n    oColor[2]=cY((pos.x+2.)/uWidth,textureYPos);\n    oColor[3]=cY((pos.x+3.)/uWidth,textureYPos);\n    return oColor;\n}\nvec4 calculateU(float gy,float dx,float dy){\n    vec2 pos=cPos(2.,8.,vTextureCo.y-gy);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[2]= cU((pos.x+4.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cU((pos.x+6.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateV(float gy,float dx,float dy){\n    vec2 pos=cPos(2.,8.,vTextureCo.y-gy);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]=cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]=cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[2]=cV((pos.x+4.)/uWidth,textureYPos,dx,dy);\n    oColor[3]=cV((pos.x+6.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateUV(float dx,float dy){\n    vec2 pos=cPos(2.,4.,vTextureCo.y-0.2500);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[2]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateVU(float dx,float dy){\n    vec2 pos=cPos(2.,4.,vTextureCo.y-0.2500);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[2]= cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvoid main() {\n    if(vTextureCo.y<0.2500){\n        gl_FragColor=calculateY();\n    }else if(vTextureCo.y<0.3125){\n        gl_FragColor=calculateU(0.2500,1./uWidth,1./uHeight);\n    }else if(vTextureCo.y<0.3750){\n        gl_FragColor=calculateV(0.3125,1./uWidth,1./uHeight);\n    }else{\n        gl_FragColor=vec4(0,0,0,0);\n    }\n}";
  private int q;
  private int r;
  
  public RGBToI420Filter()
  {
    a();
  }
  
  public static int a(int paramInt, String paramString)
  {
    if (paramString == null)
    {
      paramString = new StringBuilder();
      paramString.append("Shader source ==null : shaderType =");
      paramString.append(paramInt);
      a(1, paramString.toString());
      return 0;
    }
    int i1 = GLES20.glCreateShader(paramInt);
    if (i1 != 0)
    {
      GLES20.glShaderSource(i1, paramString);
      GLES20.glCompileShader(i1);
      paramString = new int[1];
      GLES20.glGetShaderiv(i1, 35713, paramString, 0);
      if (paramString[0] == 0)
      {
        paramString = new StringBuilder();
        paramString.append("Could not compile shader:");
        paramString.append(paramInt);
        a(1, paramString.toString());
        paramString = new StringBuilder();
        paramString.append("GLES20 Error:");
        paramString.append(GLES20.glGetShaderInfoLog(i1));
        a(1, paramString.toString());
        GLES20.glDeleteShader(i1);
        return 0;
      }
    }
    return i1;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int i1 = a(35633, paramString1);
    if (i1 == 0) {
      return 0;
    }
    int i2 = a(35632, paramString2);
    if (i2 == 0) {
      return 0;
    }
    int i3 = GLES20.glCreateProgram();
    if (i3 != 0)
    {
      GLES20.glAttachShader(i3, i1);
      GLES20.glAttachShader(i3, i2);
      GLES20.glLinkProgram(i3);
      paramString1 = new int[1];
      GLES20.glGetProgramiv(i3, 35714, paramString1, 0);
      if (paramString1[0] != 1)
      {
        paramString1 = new StringBuilder();
        paramString1.append("Could not link program:");
        paramString1.append(GLES20.glGetProgramInfoLog(i3));
        a(1, paramString1.toString());
        GLES20.glDeleteProgram(i3);
        return 0;
      }
    }
    return i3;
  }
  
  private static void a(int paramInt, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("glError:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("---");
    localStringBuilder.append(paramObject);
    QLog.e("RGBToI420Filter", 1, localStringBuilder.toString());
  }
  
  protected void a()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(32);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.a = localByteBuffer.asFloatBuffer();
    this.a.put(new float[] { -1.0F, -1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F, 1.0F });
    this.a.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(32);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.b = localByteBuffer.asFloatBuffer();
    this.b.put(new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F });
    this.b.position(0);
  }
  
  public void a(int paramInt)
  {
    f();
    d();
    g();
    b(paramInt);
    e();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public void b()
  {
    this.e = a(this.o, this.p);
    this.f = GLES20.glGetAttribLocation(this.e, "aVertexCo");
    this.g = GLES20.glGetAttribLocation(this.e, "aTextureCo");
    this.h = GLES20.glGetUniformLocation(this.e, "uVertexMatrix");
    this.i = GLES20.glGetUniformLocation(this.e, "uTextureMatrix");
    this.j = GLES20.glGetUniformLocation(this.e, "uTexture");
    this.q = GLES20.glGetUniformLocation(this.e, "uWidth");
    this.r = GLES20.glGetUniformLocation(this.e, "uHeight");
  }
  
  protected void b(int paramInt)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt);
    GLES20.glUniform1i(this.j, 0);
  }
  
  public void c()
  {
    GLES20.glDeleteProgram(this.e);
  }
  
  protected void d()
  {
    GLES20.glUseProgram(this.e);
  }
  
  protected void e()
  {
    GLES20.glEnableVertexAttribArray(this.f);
    GLES20.glVertexAttribPointer(this.f, 2, 5126, false, 0, this.a);
    GLES20.glEnableVertexAttribArray(this.g);
    GLES20.glVertexAttribPointer(this.g, 2, 5126, false, 0, this.b);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.f);
    GLES20.glDisableVertexAttribArray(this.g);
  }
  
  protected void f()
  {
    GLES20.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
    GLES20.glClear(16640);
  }
  
  protected void g()
  {
    GLES20.glUniformMatrix4fv(this.h, 1, false, this.m, 0);
    GLES20.glUniformMatrix4fv(this.i, 1, false, this.n, 0);
    GLES20.glUniform1f(this.q, this.c);
    GLES20.glUniform1f(this.r, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.RGBToI420Filter
 * JD-Core Version:    0.7.0.1
 */