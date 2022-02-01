package com.tencent.liteav.beauty.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.d.f;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.List;

public class x
  extends h
{
  private static final float[] A = { 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F };
  protected static final short[] v = { 1, 2, 0, 2, 0, 3 };
  private static final float[] z = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  private String B = "GPUWatermark";
  protected x.a[] r = null;
  protected List<d.f> s = null;
  protected boolean t = false;
  protected int u = 1;
  protected ShortBuffer w = null;
  private x.a x = null;
  private int y = 1;
  
  public x()
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
  }
  
  public x(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    paramString1 = ByteBuffer.allocateDirect(v.length * 2);
    paramString1.order(ByteOrder.nativeOrder());
    this.w = paramString1.asShortBuffer();
    this.w.put(v);
    this.w.position(0);
    this.o = true;
  }
  
  private void q()
  {
    if (this.r != null)
    {
      int i = 0;
      for (;;)
      {
        x.a[] arrayOfa = this.r;
        if (i >= arrayOfa.length) {
          break;
        }
        if (arrayOfa[i] != null)
        {
          if (arrayOfa[i].d != null) {
            GLES20.glDeleteTextures(1, this.r[i].d, 0);
          }
          arrayOfa = this.r;
          arrayOfa[i].d = null;
          arrayOfa[i].c = null;
          arrayOfa[i] = null;
        }
        i += 1;
      }
    }
    this.r = null;
  }
  
  protected void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt3)
  {
    Object localObject = ByteBuffer.allocateDirect(z.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    this.r[paramInt3].a = ((ByteBuffer)localObject).asFloatBuffer();
    localObject = new float[z.length];
    float f = paramInt2 / paramInt1 * paramFloat3 * this.e / this.f;
    localObject[0] = (paramFloat1 * 2.0F - 1.0F);
    paramInt1 = 1;
    localObject[1] = (1.0F - paramFloat2 * 2.0F);
    localObject[2] = localObject[0];
    localObject[3] = (localObject[1] - f * 2.0F);
    localObject[4] = (localObject[0] + paramFloat3 * 2.0F);
    localObject[5] = localObject[3];
    localObject[6] = localObject[4];
    localObject[7] = localObject[1];
    while (paramInt1 <= 7)
    {
      localObject[paramInt1] *= -1.0F;
      paramInt1 += 2;
    }
    this.r[paramInt3].a.put((float[])localObject);
    this.r[paramInt3].a.position(0);
    localObject = ByteBuffer.allocateDirect(A.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    this.r[paramInt3].b = ((ByteBuffer)localObject).asFloatBuffer();
    this.r[paramInt3].b.put(A);
    this.r[paramInt3].b.position(0);
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.r == null) {
      this.r = new x.a[1];
    }
    x.a[] arrayOfa = this.r;
    if (arrayOfa[0] == null) {
      arrayOfa[0] = new x.a(this);
    }
    a(paramBitmap, paramFloat1, paramFloat2, paramFloat3, 0);
    this.x = this.r[0];
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    if (paramBitmap == null)
    {
      paramBitmap = this.r;
      if ((paramBitmap != null) && (paramBitmap[paramInt] != null))
      {
        paramBitmap = this.B;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("release ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" water mark!");
        Log.i(paramBitmap, ((StringBuilder)localObject).toString());
        if (this.r[paramInt].d != null) {
          GLES20.glDeleteTextures(1, this.r[paramInt].d, 0);
        }
        paramBitmap = this.r;
        paramBitmap[paramInt].d = null;
        paramBitmap[paramInt].c = null;
        paramBitmap[paramInt] = null;
      }
      return;
    }
    Object localObject = this.r;
    if ((localObject[paramInt] != null) && (paramInt < localObject.length))
    {
      a(paramBitmap.getWidth(), paramBitmap.getHeight(), paramFloat1, paramFloat2, paramFloat3, paramInt);
      if (this.r[paramInt].d == null)
      {
        localObject = this.r;
        localObject[paramInt].d = new int[1];
        GLES20.glGenTextures(1, localObject[paramInt].d, 0);
        GLES20.glBindTexture(3553, this.r[paramInt].d[0]);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
      }
      if ((this.r[paramInt].c == null) || (!this.r[paramInt].c.equals(paramBitmap)))
      {
        GLES20.glBindTexture(3553, this.r[paramInt].d[0]);
        if (!paramBitmap.isRecycled()) {
          GLUtils.texImage2D(3553, 0, paramBitmap, 0);
        } else {
          TXCLog.e(this.B, "SetWaterMark when bitmap is recycled");
        }
      }
      this.r[paramInt].c = paramBitmap;
      return;
    }
    Log.e(this.B, "index is too large for mSzWaterMark!");
  }
  
  public void c(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public void d()
  {
    super.d();
    this.t = false;
    q();
  }
  
  protected void j()
  {
    super.j();
    if (this.t)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(this.u, 771);
      GLES20.glActiveTexture(33984);
      int i = 0;
      for (;;)
      {
        x.a[] arrayOfa = this.r;
        if (i >= arrayOfa.length) {
          break;
        }
        if (arrayOfa[i] != null)
        {
          GLES20.glBindTexture(3553, arrayOfa[i].d[0]);
          GLES20.glUniform1i(this.c, 0);
          GLES20.glVertexAttribPointer(this.b, 2, 5126, false, 8, this.r[i].a);
          GLES20.glEnableVertexAttribArray(this.b);
          GLES20.glVertexAttribPointer(this.d, 4, 5126, false, 16, this.r[i].b);
          GLES20.glEnableVertexAttribArray(this.d);
          GLES20.glDrawElements(4, v.length, 5123, this.w);
          GLES20.glDisableVertexAttribArray(this.b);
          GLES20.glDisableVertexAttribArray(this.d);
        }
        i += 1;
      }
      GLES20.glDisable(3042);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.x
 * JD-Core Version:    0.7.0.1
 */