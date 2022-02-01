package com.tencent.av.videoeffect;

import android.opengl.GLES20;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

public class FilterProcess
{
  int jdField_a_of_type_Int = -1;
  QQAVImageFilter jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = null;
  ByteBuffer jdField_a_of_type_JavaNioByteBuffer = null;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  int[] jdField_a_of_type_ArrayOfInt = new int[1];
  int jdField_b_of_type_Int = -1;
  byte[] jdField_b_of_type_ArrayOfByte = null;
  int[] jdField_b_of_type_ArrayOfInt = new int[1];
  int c = 0;
  int d = 0;
  int e = 0;
  
  public FilterProcess(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = (paramInt1 * paramInt2 * 3);
    this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(this.e);
    this.jdField_b_of_type_ArrayOfByte = new byte[this.c * this.d * 4];
    paramArrayOfByte = this.jdField_a_of_type_ArrayOfInt;
    GLES20.glGenTextures(paramArrayOfByte.length, paramArrayOfByte, 0);
    paramArrayOfByte = this.jdField_b_of_type_ArrayOfInt;
    GLES20.glGenTextures(paramArrayOfByte.length, paramArrayOfByte, 0);
    this.jdField_a_of_type_Int = AVGLUtils.initFrameBuffer(paramInt1, paramInt2, this.jdField_a_of_type_ArrayOfInt[0]);
    this.jdField_b_of_type_Int = AVGLUtils.initFrameBuffer(paramInt1, paramInt2, this.jdField_b_of_type_ArrayOfInt[0]);
    this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = new QQAVImageEffectTestFilter();
    this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter.init();
    this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter.setQQAVEffectID("filter-test");
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("mBeforeTextureId:");
      paramArrayOfByte.append(this.jdField_a_of_type_ArrayOfInt[0]);
      paramArrayOfByte.append("\nmBeforeTextureFbo:");
      paramArrayOfByte.append(this.jdField_a_of_type_Int);
      paramArrayOfByte.append("\nmAfterTextureId:");
      paramArrayOfByte.append(this.jdField_b_of_type_ArrayOfInt[0]);
      paramArrayOfByte.append("\nmAfterTextureFbo:");
      paramArrayOfByte.append(this.jdField_b_of_type_Int);
      QLog.d("FilterProcess", 2, paramArrayOfByte.toString());
    }
  }
  
  public long a()
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if ((arrayOfByte != null) && (arrayOfByte.length != 0))
    {
      if (this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter == null) {
        return -2L;
      }
      if ((this.jdField_a_of_type_ArrayOfInt[0] != 0) && (this.jdField_b_of_type_ArrayOfInt[0] != 0))
      {
        long l = System.nanoTime();
        int i = 0;
        while (i < 70)
        {
          a();
          a(a(this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt[0], this.jdField_b_of_type_Int, this.jdField_b_of_type_ArrayOfInt[0]).jdField_a_of_type_Int, this.c, this.d, 6408, this.jdField_b_of_type_ArrayOfByte);
          i += 1;
        }
        return (System.nanoTime() - l) / 1000L / 1000L;
      }
      return -3L;
    }
    return -1L;
  }
  
  FilterProcess.GLTexture a(QQAVImageFilter paramQQAVImageFilter, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramQQAVImageFilter != null)
    {
      paramQQAVImageFilter.onOutputSizeChanged(this.c, this.d);
      paramQQAVImageFilter.onDraw2(paramInt2, paramInt3);
      return new FilterProcess.GLTexture(this, paramInt3, paramInt4);
    }
    return new FilterProcess.GLTexture(this, paramInt1, paramInt2);
  }
  
  void a()
  {
    ByteBuffer localByteBuffer = this.jdField_a_of_type_JavaNioByteBuffer;
    if (localByteBuffer != null)
    {
      if (this.jdField_a_of_type_ArrayOfByte == null) {
        return;
      }
      localByteBuffer.position(0);
      this.jdField_a_of_type_JavaNioByteBuffer.put(this.jdField_a_of_type_ArrayOfByte, 0, this.e);
      this.jdField_a_of_type_JavaNioByteBuffer.position(0);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.jdField_a_of_type_ArrayOfInt[0]);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6407, this.c, this.d, 0, 6407, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    GLES20.glBindFramebuffer(36160, paramInt1);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, paramInt4, 5121, ByteBuffer.wrap(paramArrayOfByte));
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_JavaNioByteBuffer;
    if (localObject != null)
    {
      ((ByteBuffer)localObject).clear();
      this.jdField_a_of_type_JavaNioByteBuffer = null;
    }
    this.jdField_b_of_type_ArrayOfByte = null;
    GLES20.glDeleteFramebuffers(2, new int[] { this.jdField_a_of_type_Int, this.jdField_b_of_type_Int }, 0);
    localObject = this.jdField_a_of_type_ArrayOfInt;
    GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
    localObject = this.jdField_b_of_type_ArrayOfInt;
    GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
    localObject = this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter;
    if (localObject != null)
    {
      ((QQAVImageFilter)localObject).destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.videoeffect.FilterProcess
 * JD-Core Version:    0.7.0.1
 */