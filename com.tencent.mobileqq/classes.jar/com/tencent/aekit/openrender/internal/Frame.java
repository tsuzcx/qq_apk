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
  private static final String TAG = Frame.class.getSimpleName();
  private List<String> backtracing = new ArrayList();
  private boolean canUnlock;
  private int[] fbo = new int[1];
  public int height;
  private int[] mRenderBufferDepth = new int[1];
  private boolean needDepth;
  public boolean needReleaseFrame;
  public Frame nextFrame;
  private boolean ownDepthBuffer;
  private boolean owntexture;
  protected int[] texture = new int[1];
  private Frame.Type type = Frame.Type.NEW;
  public int width;
  
  public Frame() {}
  
  public Frame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.texture[0] = paramInt2;
    this.fbo[0] = paramInt1;
    this.width = paramInt3;
    this.height = paramInt4;
  }
  
  public Frame(Frame.Type paramType)
  {
    this.type = paramType;
    if (paramType == Frame.Type.FRAME_CACHE) {}
    for (;;)
    {
      this.canUnlock = bool;
      return;
      bool = false;
    }
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
      if (this.mRenderBufferDepth[0] <= 0) {
        GLES20.glGenRenderbuffers(1, this.mRenderBufferDepth, 0);
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
      double d3 = paramInt3 * paramDouble;
      double d1 = d3;
      if (paramInt2 > d3)
      {
        d1 = paramInt2;
        d2 = paramInt2 / paramDouble;
      }
      GLES20.glViewport((int)-(d1 - paramInt2) / 2, (int)-(d2 - paramInt3) / 2, (int)d1, (int)d2);
      return;
    }
    if (((paramInt1 > 0) && (this.texture[0] != paramInt1)) || (this.width != paramInt2) || (this.height != paramInt3))
    {
      if (this.fbo[0] != 0)
      {
        GLES20.glBindFramebuffer(36160, this.fbo[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
      }
      if ((this.owntexture) && (this.texture[0] != 0)) {
        GLES20.glDeleteTextures(1, this.texture, 0);
      }
      this.texture[0] = 0;
    }
    this.width = paramInt2;
    this.height = paramInt3;
    if (this.fbo[0] <= 0) {
      GLES20.glGenFramebuffers(1, this.fbo, 0);
    }
    if ((paramInt1 > 0) && (this.texture[0] != paramInt1))
    {
      this.owntexture = false;
      this.texture[0] = paramInt1;
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
    if (this.texture[0] <= 0)
    {
      this.owntexture = true;
      GLES20.glActiveTexture(33984);
      GlUtil.glGenTextures(this.texture.length, this.texture, 0);
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
    if (this.fbo[0] <= 0) {
      GLES20.glGenFramebuffers(1, this.fbo, 0);
    }
    if (this.texture[0] <= 0)
    {
      this.owntexture = true;
      GLES20.glActiveTexture(33984);
      GlUtil.glGenTextures(this.texture.length, this.texture, 0);
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
    if (this.fbo[0] != 0)
    {
      GLES20.glBindFramebuffer(36160, this.fbo[0]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
      GLES20.glDeleteFramebuffers(1, this.fbo, 0);
      this.fbo[0] = 0;
    }
    if (this.mRenderBufferDepth[0] != 0)
    {
      GLES20.glDeleteRenderbuffers(this.mRenderBufferDepth.length, this.mRenderBufferDepth, 0);
      Arrays.fill(this.mRenderBufferDepth, 0);
    }
    clearSelf();
    if (this.nextFrame != null) {
      this.nextFrame.clear();
    }
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public void clearSelf()
  {
    if (this.texture[0] != 0)
    {
      if (this.owntexture) {
        GlUtil.glDeleteTextures(1, this.texture, 0);
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
    for (Frame localFrame = this; (localFrame.nextFrame != null) && (localFrame.nextFrame.getTextureId() != 0); localFrame = localFrame.nextFrame) {}
    return localFrame.getTextureId();
  }
  
  public int getLastTextureId()
  {
    for (Frame localFrame = this; localFrame.nextFrame != null; localFrame = localFrame.nextFrame) {}
    return localFrame.getTextureId();
  }
  
  public int getTextureId()
  {
    return this.texture[0];
  }
  
  public void printBackTracing()
  {
    StringBuilder localStringBuilder = new StringBuilder("[frame backtracing] ");
    Iterator localIterator = this.backtracing.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str + ", ");
    }
    Log.e(TAG, localStringBuilder.toString());
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
    if (this.fbo[0] <= 0) {
      GLES20.glGenFramebuffers(1, this.fbo, 0);
    }
    if ((paramInt1 > 0) && (this.texture[0] != paramInt1))
    {
      this.owntexture = false;
      this.texture[0] = paramInt1;
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
    if (this.texture[0] <= 0)
    {
      this.owntexture = true;
      GLES20.glActiveTexture(33984);
      GlUtil.glGenTextures(this.texture.length, this.texture, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aekit.openrender.internal.Frame
 * JD-Core Version:    0.7.0.1
 */