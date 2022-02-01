package com.tencent.av.videoeffect;

import android.opengl.GLES20;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

public class FilterProcess
{
  int[] a = new int[1];
  int b = -1;
  int[] c = new int[1];
  int d = -1;
  byte[] e = null;
  int f = 0;
  int g = 0;
  int h = 0;
  byte[] i = null;
  ByteBuffer j = null;
  QQAVImageFilter k = null;
  
  public FilterProcess(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.e = paramArrayOfByte;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = (paramInt1 * paramInt2 * 3);
    this.j = ByteBuffer.allocate(this.h);
    this.i = new byte[this.f * this.g * 4];
    paramArrayOfByte = this.a;
    GLES20.glGenTextures(paramArrayOfByte.length, paramArrayOfByte, 0);
    paramArrayOfByte = this.c;
    GLES20.glGenTextures(paramArrayOfByte.length, paramArrayOfByte, 0);
    this.b = AVGLUtils.initFrameBuffer(paramInt1, paramInt2, this.a[0]);
    this.d = AVGLUtils.initFrameBuffer(paramInt1, paramInt2, this.c[0]);
    this.k = new QQAVImageEffectTestFilter();
    this.k.init();
    this.k.setQQAVEffectID("filter-test");
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("mBeforeTextureId:");
      paramArrayOfByte.append(this.a[0]);
      paramArrayOfByte.append("\nmBeforeTextureFbo:");
      paramArrayOfByte.append(this.b);
      paramArrayOfByte.append("\nmAfterTextureId:");
      paramArrayOfByte.append(this.c[0]);
      paramArrayOfByte.append("\nmAfterTextureFbo:");
      paramArrayOfByte.append(this.d);
      QLog.d("FilterProcess", 2, paramArrayOfByte.toString());
    }
  }
  
  FilterProcess.GLTexture a(QQAVImageFilter paramQQAVImageFilter, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramQQAVImageFilter != null)
    {
      paramQQAVImageFilter.onOutputSizeChanged(this.f, this.g);
      paramQQAVImageFilter.onDraw2(paramInt2, paramInt3);
      return new FilterProcess.GLTexture(this, paramInt3, paramInt4);
    }
    return new FilterProcess.GLTexture(this, paramInt1, paramInt2);
  }
  
  void a()
  {
    ByteBuffer localByteBuffer = this.j;
    if (localByteBuffer != null)
    {
      if (this.e == null) {
        return;
      }
      localByteBuffer.position(0);
      this.j.put(this.e, 0, this.h);
      this.j.position(0);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.a[0]);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6407, this.f, this.g, 0, 6407, 5121, this.j);
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    GLES20.glBindFramebuffer(36160, paramInt1);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, paramInt4, 5121, ByteBuffer.wrap(paramArrayOfByte));
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public long b()
  {
    byte[] arrayOfByte = this.e;
    if ((arrayOfByte != null) && (arrayOfByte.length != 0))
    {
      if (this.k == null) {
        return -2L;
      }
      if ((this.a[0] != 0) && (this.c[0] != 0))
      {
        long l = System.nanoTime();
        int m = 0;
        while (m < 70)
        {
          a();
          a(a(this.k, this.b, this.a[0], this.d, this.c[0]).a, this.f, this.g, 6408, this.i);
          m += 1;
        }
        return (System.nanoTime() - l) / 1000L / 1000L;
      }
      return -3L;
    }
    return -1L;
  }
  
  public void c()
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      ((ByteBuffer)localObject).clear();
      this.j = null;
    }
    this.i = null;
    GLES20.glDeleteFramebuffers(2, new int[] { this.b, this.d }, 0);
    localObject = this.a;
    GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
    localObject = this.c;
    GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
    localObject = this.k;
    if (localObject != null)
    {
      ((QQAVImageFilter)localObject).destroy();
      this.k = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.videoeffect.FilterProcess
 * JD-Core Version:    0.7.0.1
 */