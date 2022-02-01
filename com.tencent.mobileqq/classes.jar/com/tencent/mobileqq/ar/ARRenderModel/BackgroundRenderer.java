package com.tencent.mobileqq.ar.ARRenderModel;

import android.content.Context;
import android.opengl.GLES20;
import com.tencent.mobileqq.ar.utils.ShaderHelper;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class BackgroundRenderer
{
  private static final String c = "BackgroundRenderer";
  public final float[] a = { -1.0F, -1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F, 1.0F };
  public final float[] b = { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  private final String d = "attribute vec4 a_Position;\nattribute vec2 a_TexCoord;\n\nvarying vec2 v_TexCoord;\n\nvoid main() {\n   gl_Position = a_Position;\n   v_TexCoord = a_TexCoord;\n}";
  private final String e = "\n#extension GL_OES_EGL_image_external : require\n\nprecision mediump float;\nvarying vec2 v_TexCoord;\nuniform samplerExternalOES sTexture;\n\n\nvoid main() {\n    gl_FragColor = texture2D(sTexture, v_TexCoord);\n}";
  private FloatBuffer f;
  private FloatBuffer g;
  private FloatBuffer h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m = -1;
  private int n = 36197;
  private boolean o = false;
  
  public int a()
  {
    return this.m;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.o) {
      return;
    }
    this.o = true;
    float f1 = paramInt1 / paramInt2;
    float f2 = paramInt3 / paramInt4;
    if (f1 < f2)
    {
      f1 = f2 / f1;
      localObject = this.a;
      localObject[1] *= f1;
      localObject[3] *= f1;
      localObject[5] *= f1;
      localObject[7] *= f1;
    }
    else
    {
      f1 /= f2;
      localObject = this.a;
      localObject[0] *= f1;
      localObject[2] *= f1;
      localObject[4] *= f1;
      localObject[6] *= f1;
    }
    Object localObject = ByteBuffer.allocateDirect(this.a.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    this.f = ((ByteBuffer)localObject).asFloatBuffer();
    this.f.put(this.a);
    this.f.position(0);
    localObject = ByteBuffer.allocateDirect(32);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    this.g = ((ByteBuffer)localObject).asFloatBuffer();
    this.g.put(this.b);
    this.g.position(0);
  }
  
  public void a(Context paramContext)
  {
    Object localObject = new int[1];
    GLES20.glGenTextures(1, (int[])localObject, 0);
    this.m = localObject[0];
    GLES20.glBindTexture(this.n, this.m);
    GLES20.glTexParameteri(this.n, 10242, 33071);
    GLES20.glTexParameteri(this.n, 10243, 33071);
    GLES20.glTexParameteri(this.n, 10241, 9728);
    GLES20.glTexParameteri(this.n, 10240, 9728);
    if (4 == this.a.length / 2)
    {
      localObject = ByteBuffer.allocateDirect(32);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      this.h = ((ByteBuffer)localObject).asFloatBuffer();
      int i1 = ShaderHelper.a(c, paramContext, 35633, "attribute vec4 a_Position;\nattribute vec2 a_TexCoord;\n\nvarying vec2 v_TexCoord;\n\nvoid main() {\n   gl_Position = a_Position;\n   v_TexCoord = a_TexCoord;\n}");
      int i2 = ShaderHelper.a(c, paramContext, 35632, "\n#extension GL_OES_EGL_image_external : require\n\nprecision mediump float;\nvarying vec2 v_TexCoord;\nuniform samplerExternalOES sTexture;\n\n\nvoid main() {\n    gl_FragColor = texture2D(sTexture, v_TexCoord);\n}");
      this.i = GLES20.glCreateProgram();
      GLES20.glAttachShader(this.i, i1);
      GLES20.glAttachShader(this.i, i2);
      GLES20.glLinkProgram(this.i);
      GLES20.glUseProgram(this.i);
      ShaderHelper.a(c, "program creation");
      this.j = GLES20.glGetAttribLocation(this.i, "a_Position");
      this.k = GLES20.glGetAttribLocation(this.i, "a_TexCoord");
      this.l = GLES20.glGetAttribLocation(this.i, "sTexture");
      ShaderHelper.a(c, "program parameters");
      return;
    }
    throw new RuntimeException("Unexpected number of vertices in BackgroundRenderer.");
  }
  
  public void a(FloatBuffer paramFloatBuffer)
  {
    ShaderHelper.a(c, "before draw");
    this.h = paramFloatBuffer;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glColorMask(true, true, true, true);
    GLES20.glClear(16640);
    GLES20.glDepthMask(false);
    GLES20.glDisable(2929);
    GLES20.glDisable(3042);
    GLES20.glUseProgram(this.i);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, this.m);
    GLES20.glUniform1i(this.l, 0);
    GLES20.glVertexAttribPointer(this.j, 2, 5126, false, 0, this.f);
    GLES20.glVertexAttribPointer(this.k, 2, 5126, false, 0, this.h);
    GLES20.glEnableVertexAttribArray(this.j);
    GLES20.glEnableVertexAttribArray(this.k);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.j);
    GLES20.glDisableVertexAttribArray(this.k);
    GLES20.glEnable(2929);
    ShaderHelper.a(c, "after draw");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.BackgroundRenderer
 * JD-Core Version:    0.7.0.1
 */