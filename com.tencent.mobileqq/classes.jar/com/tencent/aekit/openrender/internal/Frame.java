package com.tencent.aekit.openrender.internal;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.aekit.openrender.util.GlUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Frame
{
  private static final String TAG = "Frame";
  private List<String> backtracing;
  private boolean canUnlock;
  private int[] fbo;
  public int height;
  private int[] mRenderBufferDepth;
  private boolean needDepth;
  public boolean needReleaseFrame;
  public Frame nextFrame;
  private boolean ownDepthBuffer;
  private boolean owntexture;
  protected int[] texture;
  private Frame.Type type;
  public int width;
  
  public Frame()
  {
    this.texture = new int[1];
    this.fbo = new int[1];
    this.mRenderBufferDepth = new int[1];
    this.type = Frame.Type.NEW;
    this.backtracing = new ArrayList();
  }
  
  public Frame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.texture = new int[1];
    this.fbo = new int[1];
    this.mRenderBufferDepth = new int[1];
    this.type = Frame.Type.NEW;
    this.backtracing = new ArrayList();
    this.texture[0] = paramInt2;
    this.fbo[0] = paramInt1;
    this.width = paramInt3;
    this.height = paramInt4;
  }
  
  public Frame(Frame.Type paramType)
  {
    boolean bool = true;
    this.texture = new int[1];
    this.fbo = new int[1];
    this.mRenderBufferDepth = new int[1];
    this.type = Frame.Type.NEW;
    this.backtracing = new ArrayList();
    this.type = paramType;
    if (paramType != Frame.Type.FRAME_CACHE) {
      bool = false;
    }
    this.canUnlock = bool;
  }
  
  public void addBackTracing(String paramString)
  {
    this.backtracing.add(paramString);
  }
  
  public void bindDepthBuffer(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.width) || (paramInt2 != this.height)) {
      this.ownDepthBuffer = false;
    }
    if ((this.needDepth) && (!this.ownDepthBuffer))
    {
      this.ownDepthBuffer = true;
      int[] arrayOfInt = this.mRenderBufferDepth;
      if (arrayOfInt[0] <= 0) {
        GLES20.glGenRenderbuffers(1, arrayOfInt, 0);
      }
      GLES20.glBindRenderbuffer(36161, this.mRenderBufferDepth[0]);
      GLES20.glRenderbufferStorage(36161, 33189, paramInt1, paramInt2);
      GLES20.glBindFramebuffer(36160, this.fbo[0]);
      GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.mRenderBufferDepth[0]);
    }
  }
  
  public void bindFrame(int paramInt1, int paramInt2, int paramInt3, double paramDouble)
  {
    if (paramInt1 == 0)
    {
      GLES20.glBindFramebuffer(36160, 0);
      if (paramDouble <= 0.0D)
      {
        GLES20.glViewport(0, 0, paramInt2, paramInt3);
        return;
      }
      double d2 = paramInt3;
      Double.isNaN(d2);
      double d4 = paramDouble * d2;
      double d3 = paramInt2;
      double d1;
      if (d3 > d4)
      {
        Double.isNaN(d3);
        d1 = d3 / paramDouble;
        paramDouble = d3;
      }
      else
      {
        d1 = d2;
        paramDouble = d4;
      }
      Double.isNaN(d3);
      paramInt1 = (int)-(paramDouble - d3) / 2;
      Double.isNaN(d2);
      GLES20.glViewport(paramInt1, (int)-(d1 - d2) / 2, (int)paramDouble, (int)d1);
      return;
    }
    if (((paramInt1 > 0) && (this.texture[0] != paramInt1)) || (this.width != paramInt2) || (this.height != paramInt3))
    {
      arrayOfInt = this.fbo;
      if (arrayOfInt[0] != 0)
      {
        GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
      }
      if (this.owntexture)
      {
        arrayOfInt = this.texture;
        if (arrayOfInt[0] != 0) {
          GLES20.glDeleteTextures(1, arrayOfInt, 0);
        }
      }
      this.texture[0] = 0;
    }
    this.width = paramInt2;
    this.height = paramInt3;
    int[] arrayOfInt = this.fbo;
    if (arrayOfInt[0] <= 0) {
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    }
    if (paramInt1 > 0)
    {
      arrayOfInt = this.texture;
      if (arrayOfInt[0] != paramInt1)
      {
        this.owntexture = false;
        arrayOfInt[0] = paramInt1;
        GLES20.glActiveTexture(33984);
        GlUtil.glBindTexture(3553, this.texture[0]);
        GlUtil.glTexImage2D(3553, 0, 6408, this.width, this.height, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLES20.glBindFramebuffer(36160, this.fbo[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture[0], 0);
        bindDepthBuffer(this.width, this.height);
        GLES20.glViewport(0, 0, this.width, this.height);
        return;
      }
    }
    if (this.texture[0] <= 0)
    {
      this.owntexture = true;
      GLES20.glActiveTexture(33984);
      arrayOfInt = this.texture;
      GlUtil.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
      GlUtil.glBindTexture(3553, this.texture[0]);
      GlUtil.glTexImage2D(3553, 0, 6408, this.width, this.height, 0, 6408, 5121, null);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glBindFramebuffer(36160, this.fbo[0]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture[0], 0);
      bindDepthBuffer(this.width, this.height);
      GLES20.glViewport(0, 0, this.width, this.height);
      return;
    }
    GLES20.glBindFramebuffer(36160, this.fbo[0]);
    GLES20.glViewport(0, 0, this.width, this.height);
  }
  
  public void bindFrame(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    int[] arrayOfInt = this.fbo;
    if (arrayOfInt[0] <= 0) {
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    }
    if (this.texture[0] <= 0)
    {
      this.owntexture = true;
      GLES20.glActiveTexture(33984);
      arrayOfInt = this.texture;
      GlUtil.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    }
    GlUtil.glBindTexture(3553, this.texture[0]);
    GlUtil.glTexImage2D(3553, 0, 6408, this.width, this.height, 0, 6408, 5121, paramByteBuffer);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glBindFramebuffer(36160, this.fbo[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture[0], 0);
    GLES20.glViewport(0, 0, this.width, this.height);
    Log.d("Frame", "new frame buffer auto");
  }
  
  public void clear()
  {
    Object localObject = this.fbo;
    if (localObject[0] != 0)
    {
      GLES20.glBindFramebuffer(36160, localObject[0]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
      GLES20.glDeleteFramebuffers(1, this.fbo, 0);
      this.fbo[0] = 0;
    }
    localObject = this.mRenderBufferDepth;
    if (localObject[0] != 0)
    {
      GLES20.glDeleteRenderbuffers(localObject.length, (int[])localObject, 0);
      Arrays.fill(this.mRenderBufferDepth, 0);
    }
    clearSelf();
    localObject = this.nextFrame;
    if (localObject != null) {
      ((Frame)localObject).clear();
    }
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public void clearSelf()
  {
    int[] arrayOfInt = this.texture;
    if (arrayOfInt[0] != 0)
    {
      if (this.owntexture) {
        GlUtil.glDeleteTextures(1, arrayOfInt, 0);
      }
      this.texture[0] = 0;
    }
  }
  
  public boolean getCouldLockState()
  {
    return this.canUnlock;
  }
  
  public int getFBO()
  {
    return this.fbo[0];
  }
  
  public int getLastRenderTextureId()
  {
    for (Frame localFrame1 = this;; localFrame1 = localFrame1.nextFrame)
    {
      Frame localFrame2 = localFrame1.nextFrame;
      if ((localFrame2 == null) || (localFrame2.getTextureId() == 0)) {
        break;
      }
    }
    return localFrame1.getTextureId();
  }
  
  public int getLastTextureId()
  {
    Frame localFrame;
    for (Object localObject = this;; localObject = localFrame)
    {
      localFrame = ((Frame)localObject).nextFrame;
      if (localFrame == null) {
        break;
      }
    }
    return ((Frame)localObject).getTextureId();
  }
  
  public int getTextureId()
  {
    return this.texture[0];
  }
  
  public void printBackTracing()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("[frame backtracing] ");
    Iterator localIterator = this.backtracing.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(str);
      localStringBuilder2.append(", ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    Log.e(TAG, localStringBuilder1.toString());
  }
  
  public void setCanUnlock(boolean paramBoolean)
  {
    this.canUnlock = paramBoolean;
  }
  
  public void setNeedDepth(boolean paramBoolean)
  {
    this.needDepth = paramBoolean;
  }
  
  public void setSizedTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    this.width = paramInt2;
    this.height = paramInt3;
    int[] arrayOfInt = this.fbo;
    if (arrayOfInt[0] <= 0) {
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    }
    if (paramInt1 > 0)
    {
      arrayOfInt = this.texture;
      if (arrayOfInt[0] != paramInt1)
      {
        this.owntexture = false;
        arrayOfInt[0] = paramInt1;
        GLES20.glActiveTexture(33984);
        GlUtil.glBindTexture(3553, this.texture[0]);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLES20.glBindFramebuffer(36160, this.fbo[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture[0], 0);
        GLES20.glViewport(0, 0, this.width, this.height);
        return;
      }
    }
    if (this.texture[0] <= 0)
    {
      this.owntexture = true;
      GLES20.glActiveTexture(33984);
      arrayOfInt = this.texture;
      GlUtil.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
      GlUtil.glBindTexture(3553, this.texture[0]);
      GlUtil.glTexImage2D(3553, 0, 6408, this.width, this.height, 0, 6408, 5121, null);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glBindFramebuffer(36160, this.fbo[0]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture[0], 0);
      GLES20.glViewport(0, 0, this.width, this.height);
      return;
    }
    GLES20.glBindFramebuffer(36160, this.fbo[0]);
    GLES20.glViewport(0, 0, this.width, this.height);
  }
  
  public void setTextureId(int paramInt)
  {
    this.texture[0] = paramInt;
  }
  
  public boolean unlock()
  {
    if ((this.owntexture) && (this.type == Frame.Type.FRAME_CACHE) && (this.canUnlock)) {
      return FrameBufferCache.getInstance().put(this);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.openrender.internal.Frame
 * JD-Core Version:    0.7.0.1
 */