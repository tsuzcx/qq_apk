package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.util.GLMemoryManager;
import com.tencent.util.LogUtil;
import com.tencent.view.FilterDefault;
import com.tencent.view.RendererUtils;
import java.nio.ByteBuffer;

public class Frame
{
  int[] fbo = { 0 };
  public int height;
  public boolean needReleaseFrmae = false;
  public Frame nextFrame;
  boolean owntexture = false;
  int[] texture = { 0 };
  public int width;
  
  public Frame() {}
  
  public Frame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.texture[0] = paramInt2;
    this.fbo[0] = paramInt1;
    this.width = paramInt3;
    this.height = paramInt4;
  }
  
  public void bindFrame(int paramInt1, int paramInt2, int paramInt3, double paramDouble)
  {
    RendererUtils.checkGlError("before glBindFramebuffer");
    if (paramInt1 == 0)
    {
      GLES20.glBindFramebuffer(36160, 0);
      if (paramDouble <= 0.0D)
      {
        GLES20.glViewport(0, 0, paramInt2, paramInt3);
        return;
      }
      double d2 = paramInt3;
      double d3 = paramDouble * paramInt3;
      double d1 = d3;
      if (paramInt2 > d3)
      {
        d1 = paramInt2;
        d2 = paramInt2 / paramDouble;
      }
      GLES20.glViewport((int)-(d1 - paramInt2) / 2, (int)-(d2 - paramInt3) / 2, (int)d1, (int)d2);
      return;
    }
    if ((paramInt1 == -2) && (FilterDefault.currentShareIndex >= 0))
    {
      FilterDefault.currentShareIndex = GLSLRender.nativeCheckMagicEngine(5, FilterDefault.currentShareIndex);
      if (FilterDefault.currentShareIndex >= 0)
      {
        GLSLRender.nativeBeginUseEglImage(paramInt2, paramInt3, FilterDefault.currentShareIndex);
        this.texture[0] = 0;
        return;
      }
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
      GLES20.glBindTexture(3553, this.texture[0]);
      if (!GLMemoryManager.getInstance().isTextureSizeMatched(this.texture[0], this.width, this.height))
      {
        GLMemoryManager.getInstance().updateTextureSize(this.texture[0], this.width, this.height);
        GLES20.glTexImage2D(3553, 0, 6408, this.width, this.height, 0, 6408, 5121, null);
      }
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glBindFramebuffer(36160, this.fbo[0]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture[0], 0);
      GLES20.glViewport(0, 0, this.width, this.height);
      LogUtil.d("Frame", "new frame buffer");
    }
    for (;;)
    {
      RendererUtils.checkGlError("glBindFramebuffer");
      return;
      if (this.texture[0] <= 0)
      {
        this.owntexture = true;
        GLES20.glActiveTexture(33984);
        this.texture[0] = GLMemoryManager.getInstance().genTexture(this.width, this.height);
        GLES20.glBindTexture(3553, this.texture[0]);
        if (!GLMemoryManager.getInstance().isTextureSizeMatched(this.texture[0], this.width, this.height))
        {
          GLMemoryManager.getInstance().updateTextureSize(this.texture[0], this.width, this.height);
          GLES20.glTexImage2D(3553, 0, 6408, this.width, this.height, 0, 6408, 5121, null);
        }
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLES20.glBindFramebuffer(36160, this.fbo[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture[0], 0);
        GLES20.glViewport(0, 0, this.width, this.height);
        LogUtil.d("Frame", "new frame buffer auto");
      }
      else
      {
        GLES20.glBindFramebuffer(36160, this.fbo[0]);
        GLES20.glViewport(0, 0, this.width, this.height);
      }
    }
  }
  
  public void bindFrame(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    RendererUtils.checkGlError("before glBindFramebuffer");
    this.width = paramInt1;
    this.height = paramInt2;
    if (this.fbo[0] <= 0) {
      GLES20.glGenFramebuffers(1, this.fbo, 0);
    }
    if (this.texture[0] <= 0)
    {
      this.owntexture = true;
      GLES20.glActiveTexture(33984);
      this.texture[0] = GLMemoryManager.getInstance().genTexture(this.width, this.height);
    }
    GLES20.glBindTexture(3553, this.texture[0]);
    GLES20.glTexImage2D(3553, 0, 6408, this.width, this.height, 0, 6408, 5121, paramByteBuffer);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glBindFramebuffer(36160, this.fbo[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture[0], 0);
    GLES20.glViewport(0, 0, this.width, this.height);
    LogUtil.d("Frame", "new frame buffer auto");
    RendererUtils.checkGlError("glBindFramebuffer");
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
    clearSelf();
    if (this.nextFrame != null) {
      this.nextFrame.clear();
    }
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public void clearSelf()
  {
    LogUtil.d("Frame", "frame clear");
    if (this.texture[0] != 0)
    {
      if (this.owntexture) {
        GLMemoryManager.getInstance().deleteTexture(this.texture[0]);
      }
      this.texture[0] = 0;
    }
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
  
  public void setTextureId(int paramInt)
  {
    this.texture[0] = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.Frame
 * JD-Core Version:    0.7.0.1
 */