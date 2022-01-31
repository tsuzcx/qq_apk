package com.tencent.av.video.effect.core.qqavimage;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils;
import com.tencent.av.video.effect.core.qqavimage.util.TextureRotationUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class QQAVImageFilterGroup
  extends QQAVImageFilter
{
  public List<QQAVImageFilter> mFilters;
  private int[] mFrameBufferTextures;
  private int[] mFrameBuffers;
  private final FloatBuffer mGLCubeBuffer;
  private final FloatBuffer mGLTextureBuffer;
  private final FloatBuffer mGLTextureFlipBuffer;
  protected List<QQAVImageFilter> mMergedFilters;
  
  public QQAVImageFilterGroup()
  {
    this(null);
  }
  
  public QQAVImageFilterGroup(List<QQAVImageFilter> paramList)
  {
    this.mFilters = paramList;
    if (this.mFilters == null) {
      this.mFilters = new ArrayList();
    }
    for (;;)
    {
      this.mGLCubeBuffer = ByteBuffer.allocateDirect(OpenGlUtils.CUBE8.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.mGLCubeBuffer.put(OpenGlUtils.CUBE8).position(0);
      this.mGLTextureBuffer = ByteBuffer.allocateDirect(TextureRotationUtil.TEXTURE_NO_ROTATION2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.mGLTextureBuffer.put(TextureRotationUtil.TEXTURE_NO_ROTATION2).position(0);
      paramList = TextureRotationUtil.getRotation(0, false, true);
      this.mGLTextureFlipBuffer = ByteBuffer.allocateDirect(paramList.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.mGLTextureFlipBuffer.put(paramList).position(0);
      return;
      updateMergedFilters();
    }
  }
  
  private void destroyFramebuffers()
  {
    if (this.mFrameBufferTextures != null)
    {
      GLES20.glDeleteTextures(this.mFrameBufferTextures.length, this.mFrameBufferTextures, 0);
      this.mFrameBufferTextures = null;
    }
    if (this.mFrameBuffers != null)
    {
      GLES20.glDeleteFramebuffers(this.mFrameBuffers.length, this.mFrameBuffers, 0);
      this.mFrameBuffers = null;
    }
  }
  
  public void addFilter(QQAVImageFilter paramQQAVImageFilter)
  {
    if (paramQQAVImageFilter == null) {
      return;
    }
    this.mFilters.add(paramQQAVImageFilter);
    updateMergedFilters();
  }
  
  public List<QQAVImageFilter> getFilters()
  {
    return this.mFilters;
  }
  
  public List<QQAVImageFilter> getMergedFilters()
  {
    return this.mMergedFilters;
  }
  
  public void onDestroy()
  {
    destroyFramebuffers();
    Iterator localIterator = this.mFilters.iterator();
    while (localIterator.hasNext()) {
      ((QQAVImageFilter)localIterator.next()).destroy();
    }
    super.onDestroy();
  }
  
  @SuppressLint({"WrongCall"})
  public void onDraw(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    runPendingOnDrawTasks();
    if ((!isInitialized()) || (this.mFrameBuffers == null) || (this.mFrameBufferTextures == null)) {}
    while (this.mMergedFilters == null) {
      return;
    }
    int k = this.mMergedFilters.size();
    int i = 0;
    label47:
    QQAVImageFilter localQQAVImageFilter;
    int j;
    if (i < k)
    {
      localQQAVImageFilter = (QQAVImageFilter)this.mMergedFilters.get(i);
      if (i >= k - 1) {
        break label147;
      }
      j = 1;
      label82:
      if (j != 0)
      {
        GLES20.glBindFramebuffer(36160, this.mFrameBuffers[i]);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      }
      if (i != 0) {
        break label153;
      }
      localQQAVImageFilter.onDraw(paramInt, paramFloatBuffer1, paramFloatBuffer2);
      label119:
      if (j == 0) {
        break label220;
      }
      GLES20.glBindFramebuffer(36160, 0);
      paramInt = this.mFrameBufferTextures[i];
    }
    label147:
    label153:
    label220:
    for (;;)
    {
      i += 1;
      break label47;
      break;
      j = 0;
      break label82;
      if (i == k - 1)
      {
        FloatBuffer localFloatBuffer2 = this.mGLCubeBuffer;
        if (k % 2 == 0) {}
        for (FloatBuffer localFloatBuffer1 = this.mGLTextureFlipBuffer;; localFloatBuffer1 = this.mGLTextureBuffer)
        {
          localQQAVImageFilter.onDraw(paramInt, localFloatBuffer2, localFloatBuffer1);
          break;
        }
      }
      localQQAVImageFilter.onDraw(paramInt, this.mGLCubeBuffer, this.mGLTextureBuffer);
      break label119;
    }
  }
  
  public void onDraw2(int paramInt1, int paramInt2)
  {
    runPendingOnDrawTasks();
    QQAVImageFilter localQQAVImageFilter;
    if ((isInitialized()) && (this.mMergedFilters.size() == 1))
    {
      localQQAVImageFilter = (QQAVImageFilter)this.mMergedFilters.get(0);
      GLES20.glBindFramebuffer(36160, paramInt2);
      GLES20.glViewport(0, 0, localQQAVImageFilter.getOutputWidth(), localQQAVImageFilter.getOutputHeight());
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16640);
      localQQAVImageFilter.onDraw(paramInt1, this.cubeBuffer, this.textureBuffer);
      GLES20.glBindFramebuffer(36160, 0);
    }
    while ((!isInitialized()) || (this.mFrameBuffers == null) || (this.mFrameBufferTextures == null) || (this.mMergedFilters == null)) {
      return;
    }
    int k = this.mMergedFilters.size();
    int i = 0;
    label135:
    int j;
    if (i < k)
    {
      localQQAVImageFilter = (QQAVImageFilter)this.mMergedFilters.get(i);
      if (i >= k - 1) {
        break label254;
      }
      j = 1;
      label167:
      if (j != 0)
      {
        GLES20.glBindFramebuffer(36160, this.mFrameBuffers[i]);
        GLES20.glViewport(0, 0, localQQAVImageFilter.getOutputWidth(), localQQAVImageFilter.getOutputHeight());
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16640);
      }
      if (i != 0) {
        break label260;
      }
      localQQAVImageFilter.onDraw(paramInt1, this.cubeBuffer, this.textureBuffer);
      label229:
      if (j == 0) {
        break label342;
      }
      GLES20.glBindFramebuffer(36160, 0);
      paramInt1 = this.mFrameBufferTextures[i];
    }
    label260:
    label342:
    for (;;)
    {
      i += 1;
      break label135;
      break;
      label254:
      j = 0;
      break label167;
      if (i == k - 1)
      {
        GLES20.glBindFramebuffer(36160, paramInt2);
        GLES20.glViewport(0, 0, localQQAVImageFilter.getOutputWidth(), localQQAVImageFilter.getOutputHeight());
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16640);
        localQQAVImageFilter.onDraw(paramInt1, this.cubeBuffer, this.textureBuffer);
        GLES20.glBindFramebuffer(36160, 0);
        break label229;
      }
      localQQAVImageFilter.onDraw(paramInt1, this.cubeBuffer, this.textureBuffer);
      break label229;
    }
  }
  
  public void onInit()
  {
    super.onInit();
    Iterator localIterator = this.mFilters.iterator();
    while (localIterator.hasNext()) {
      ((QQAVImageFilter)localIterator.next()).init();
    }
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    if (this.mFrameBuffers != null) {
      destroyFramebuffers();
    }
    int j = this.mFilters.size();
    int i = 0;
    while (i < j)
    {
      ((QQAVImageFilter)this.mFilters.get(i)).onOutputSizeChanged(paramInt1, paramInt2);
      i += 1;
    }
    if ((this.mMergedFilters != null) && (this.mMergedFilters.size() > 0))
    {
      j = this.mMergedFilters.size();
      this.mFrameBuffers = new int[j - 1];
      this.mFrameBufferTextures = new int[j - 1];
      i = 0;
      while (i < j - 1)
      {
        GLES20.glGenFramebuffers(1, this.mFrameBuffers, i);
        GLES20.glGenTextures(1, this.mFrameBufferTextures, i);
        GLES20.glBindTexture(3553, this.mFrameBufferTextures[i]);
        GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLES20.glBindFramebuffer(36160, this.mFrameBuffers[i]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mFrameBufferTextures[i], 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        i += 1;
      }
    }
  }
  
  public void updateMergedFilters()
  {
    if (this.mFilters == null) {}
    label128:
    for (;;)
    {
      return;
      Iterator localIterator;
      if (this.mMergedFilters == null)
      {
        this.mMergedFilters = new ArrayList();
        localIterator = this.mFilters.iterator();
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label128;
        }
        Object localObject = (QQAVImageFilter)localIterator.next();
        if ((localObject instanceof QQAVImageFilterGroup))
        {
          ((QQAVImageFilterGroup)localObject).updateMergedFilters();
          localObject = ((QQAVImageFilterGroup)localObject).getMergedFilters();
          if ((localObject == null) || (((List)localObject).isEmpty())) {
            continue;
          }
          this.mMergedFilters.addAll((Collection)localObject);
          continue;
          this.mMergedFilters.clear();
          break;
        }
        this.mMergedFilters.add(localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageFilterGroup
 * JD-Core Version:    0.7.0.1
 */