package com.tencent.TMG.opengl.glrenderer;

import com.tencent.TMG.opengl.utils.Utils;
import javax.microedition.khronos.opengles.GL11;

class GLES11Canvas$GLState
{
  private boolean mBlendEnabled = true;
  private final GL11 mGL;
  private float mLineWidth = 1.0F;
  private int mTexEnvMode = 7681;
  private float mTextureAlpha = 1.0F;
  private int mTextureTarget = 3553;
  
  public GLES11Canvas$GLState(GL11 paramGL11)
  {
    this.mGL = paramGL11;
    paramGL11.glDisable(2896);
    paramGL11.glEnable(3024);
    paramGL11.glEnableClientState(32884);
    paramGL11.glEnableClientState(32888);
    paramGL11.glEnable(3553);
    paramGL11.glTexEnvf(8960, 8704, 7681.0F);
    paramGL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    paramGL11.glEnable(3042);
    paramGL11.glBlendFunc(1, 771);
    paramGL11.glPixelStorei(3317, 2);
  }
  
  public void setBlendEnabled(boolean paramBoolean)
  {
    if (this.mBlendEnabled == paramBoolean) {
      return;
    }
    this.mBlendEnabled = paramBoolean;
    if (paramBoolean)
    {
      this.mGL.glEnable(3042);
      return;
    }
    this.mGL.glDisable(3042);
  }
  
  public void setColorMode(int paramInt, float paramFloat)
  {
    if ((!Utils.isOpaque(paramInt)) || (paramFloat < 0.95F)) {}
    for (boolean bool = true;; bool = false)
    {
      setBlendEnabled(bool);
      this.mTextureAlpha = -1.0F;
      setTextureTarget(0);
      paramFloat = (paramInt >>> 24) * paramFloat * 65535.0F / 255.0F / 255.0F;
      this.mGL.glColor4x(Math.round((paramInt >> 16 & 0xFF) * paramFloat), Math.round((paramInt >> 8 & 0xFF) * paramFloat), Math.round((paramInt & 0xFF) * paramFloat), Math.round(paramFloat * 255.0F));
      return;
    }
  }
  
  public void setLineWidth(float paramFloat)
  {
    if (this.mLineWidth == paramFloat) {
      return;
    }
    this.mLineWidth = paramFloat;
    this.mGL.glLineWidth(paramFloat);
  }
  
  public void setTexEnvMode(int paramInt)
  {
    if (this.mTexEnvMode == paramInt) {
      return;
    }
    this.mTexEnvMode = paramInt;
    this.mGL.glTexEnvf(8960, 8704, paramInt);
  }
  
  public void setTextureAlpha(float paramFloat)
  {
    if (this.mTextureAlpha == paramFloat) {
      return;
    }
    this.mTextureAlpha = paramFloat;
    if (paramFloat >= 0.95F)
    {
      this.mGL.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      setTexEnvMode(7681);
      return;
    }
    this.mGL.glColor4f(paramFloat, paramFloat, paramFloat, paramFloat);
    setTexEnvMode(8448);
  }
  
  public void setTextureTarget(int paramInt)
  {
    if (this.mTextureTarget == paramInt) {}
    do
    {
      return;
      if (this.mTextureTarget != 0) {
        this.mGL.glDisable(this.mTextureTarget);
      }
      this.mTextureTarget = paramInt;
    } while (this.mTextureTarget == 0);
    this.mGL.glEnable(this.mTextureTarget);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.opengl.glrenderer.GLES11Canvas.GLState
 * JD-Core Version:    0.7.0.1
 */