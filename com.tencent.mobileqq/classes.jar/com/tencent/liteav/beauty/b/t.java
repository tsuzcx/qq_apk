package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.liteav.basic.opengl.l;
import com.tencent.liteav.basic.opengl.m;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class t
  extends j
{
  private ByteBuffer r;
  public int u = -1;
  public int v;
  public int w = -1;
  
  public t(String paramString)
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n}", paramString);
  }
  
  public t(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    a(l.a, false, true);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.w = paramInt2;
    return a(paramInt1, paramInt3, paramInt4);
  }
  
  public void a(l paraml, boolean paramBoolean1, boolean paramBoolean2)
  {
    paraml = m.a(paraml, paramBoolean1, paramBoolean2);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
    FloatBuffer localFloatBuffer = localByteBuffer.asFloatBuffer();
    localFloatBuffer.put(paraml);
    localFloatBuffer.flip();
    this.r = localByteBuffer;
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool)
    {
      this.u = GLES20.glGetAttribLocation(q(), "inputTextureCoordinate2");
      this.v = GLES20.glGetUniformLocation(q(), "inputImageTexture2");
    }
    return bool;
  }
  
  public int c(int paramInt1, int paramInt2)
  {
    this.w = paramInt2;
    return a(paramInt1, this.m, this.n);
  }
  
  public void e()
  {
    super.e();
  }
  
  protected void i()
  {
    GLES20.glActiveTexture(33987);
    GLES20.glBindTexture(3553, this.w);
    GLES20.glUniform1i(this.v, 3);
    int i = this.u;
    if (i != -1)
    {
      GLES20.glEnableVertexAttribArray(i);
      this.r.position(0);
      GLES20.glVertexAttribPointer(this.u, 2, 5126, false, 0, this.r);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.t
 * JD-Core Version:    0.7.0.1
 */