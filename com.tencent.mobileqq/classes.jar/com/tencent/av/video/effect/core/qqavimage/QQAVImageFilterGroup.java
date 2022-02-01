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
  protected List<QQAVImageFilter> mFilters;
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
    } else {
      updateMergedFilters();
    }
    this.mGLCubeBuffer = ByteBuffer.allocateDirect(OpenGlUtils.CUBE8.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mGLCubeBuffer.put(OpenGlUtils.CUBE8).position(0);
    this.mGLTextureBuffer = ByteBuffer.allocateDirect(TextureRotationUtil.TEXTURE_NO_ROTATION2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mGLTextureBuffer.put(TextureRotationUtil.TEXTURE_NO_ROTATION2).position(0);
    paramList = TextureRotationUtil.getRotation(0, false, true);
    this.mGLTextureFlipBuffer = ByteBuffer.allocateDirect(paramList.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mGLTextureFlipBuffer.put(paramList).position(0);
  }
  
  private void destroyFramebuffers()
  {
    int[] arrayOfInt = this.mFrameBufferTextures;
    if (arrayOfInt != null)
    {
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      this.mFrameBufferTextures = null;
    }
    arrayOfInt = this.mFrameBuffers;
    if (arrayOfInt != null)
    {
      GLES20.glDeleteFramebuffers(arrayOfInt.length, arrayOfInt, 0);
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
    if ((isInitialized()) && (this.mFrameBuffers != null))
    {
      if (this.mFrameBufferTextures == null) {
        return;
      }
      Object localObject = this.mMergedFilters;
      if (localObject != null)
      {
        int k = ((List)localObject).size();
        int i = paramInt;
        paramInt = 0;
        while (paramInt < k)
        {
          QQAVImageFilter localQQAVImageFilter = (QQAVImageFilter)this.mMergedFilters.get(paramInt);
          int m = k - 1;
          int j;
          if (paramInt < m) {
            j = 1;
          } else {
            j = 0;
          }
          if (j != 0)
          {
            GLES20.glBindFramebuffer(36160, this.mFrameBuffers[paramInt]);
            GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          }
          if (paramInt == 0)
          {
            localQQAVImageFilter.onDraw(i, paramFloatBuffer1, paramFloatBuffer2);
          }
          else if (paramInt == m)
          {
            FloatBuffer localFloatBuffer = this.mGLCubeBuffer;
            if (k % 2 == 0) {
              localObject = this.mGLTextureFlipBuffer;
            } else {
              localObject = this.mGLTextureBuffer;
            }
            localQQAVImageFilter.onDraw(i, localFloatBuffer, (FloatBuffer)localObject);
          }
          else
          {
            localQQAVImageFilter.onDraw(i, this.mGLCubeBuffer, this.mGLTextureBuffer);
          }
          if (j != 0)
          {
            GLES20.glBindFramebuffer(36160, 0);
            i = this.mFrameBufferTextures[paramInt];
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public void onDraw2(int paramInt1, int paramInt2)
  {
    runPendingOnDrawTasks();
    Object localObject;
    if ((isInitialized()) && (this.mMergedFilters.size() == 1))
    {
      localObject = (QQAVImageFilter)this.mMergedFilters.get(0);
      GLES20.glBindFramebuffer(36160, paramInt2);
      GLES20.glViewport(0, 0, ((QQAVImageFilter)localObject).getOutputWidth(), ((QQAVImageFilter)localObject).getOutputHeight());
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16640);
      ((QQAVImageFilter)localObject).onDraw(paramInt1, this.cubeBuffer, this.textureBuffer);
      GLES20.glBindFramebuffer(36160, 0);
      return;
    }
    if ((isInitialized()) && (this.mFrameBuffers != null))
    {
      if (this.mFrameBufferTextures == null) {
        return;
      }
      localObject = this.mMergedFilters;
      if (localObject != null)
      {
        int k = ((List)localObject).size();
        int i = paramInt1;
        paramInt1 = 0;
        while (paramInt1 < k)
        {
          localObject = (QQAVImageFilter)this.mMergedFilters.get(paramInt1);
          int m = k - 1;
          int j;
          if (paramInt1 < m) {
            j = 1;
          } else {
            j = 0;
          }
          if (j != 0)
          {
            GLES20.glBindFramebuffer(36160, this.mFrameBuffers[paramInt1]);
            GLES20.glViewport(0, 0, ((QQAVImageFilter)localObject).getOutputWidth(), ((QQAVImageFilter)localObject).getOutputHeight());
            GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
            GLES20.glClear(16640);
          }
          if (paramInt1 == 0)
          {
            ((QQAVImageFilter)localObject).onDraw(i, this.cubeBuffer, this.textureBuffer);
          }
          else if (paramInt1 == m)
          {
            GLES20.glBindFramebuffer(36160, paramInt2);
            GLES20.glViewport(0, 0, ((QQAVImageFilter)localObject).getOutputWidth(), ((QQAVImageFilter)localObject).getOutputHeight());
            GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
            GLES20.glClear(16640);
            ((QQAVImageFilter)localObject).onDraw(i, this.cubeBuffer, this.textureBuffer);
            GLES20.glBindFramebuffer(36160, 0);
          }
          else
          {
            ((QQAVImageFilter)localObject).onDraw(i, this.cubeBuffer, this.textureBuffer);
          }
          if (j != 0)
          {
            GLES20.glBindFramebuffer(36160, 0);
            i = this.mFrameBufferTextures[paramInt1];
          }
          paramInt1 += 1;
        }
      }
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
    List localList = this.mMergedFilters;
    if ((localList != null) && (localList.size() > 0))
    {
      j = this.mMergedFilters.size() - 1;
      this.mFrameBuffers = new int[j];
      this.mFrameBufferTextures = new int[j];
      i = 0;
      while (i < j)
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
    if (this.mFilters == null) {
      return;
    }
    Object localObject1 = this.mMergedFilters;
    if (localObject1 == null) {
      this.mMergedFilters = new ArrayList();
    } else {
      ((List)localObject1).clear();
    }
    localObject1 = this.mFilters.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (QQAVImageFilter)((Iterator)localObject1).next();
      if ((localObject2 instanceof QQAVImageFilterGroup))
      {
        localObject2 = (QQAVImageFilterGroup)localObject2;
        ((QQAVImageFilterGroup)localObject2).updateMergedFilters();
        localObject2 = ((QQAVImageFilterGroup)localObject2).getMergedFilters();
        if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
          this.mMergedFilters.addAll((Collection)localObject2);
        }
      }
      else
      {
        this.mMergedFilters.add(localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageFilterGroup
 * JD-Core Version:    0.7.0.1
 */