package com.tencent.av.opengl.effects;

import android.opengl.Matrix;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class ExtraTextureRender
{
  private RenderBuffer a = null;
  private TextureRender b = null;
  private final float[] c = new float[16];
  private final float[] d;
  private int e = 0;
  
  public ExtraTextureRender()
  {
    Matrix.setIdentityM(this.c, 0);
    this.d = new float[16];
    Matrix.setIdentityM(this.d, 0);
    if (this.b == null) {
      this.b = new TextureRender();
    }
  }
  
  public GLTexture a(GLTexture paramGLTexture, int paramInt1, int paramInt2)
  {
    if ((paramGLTexture != null) && (paramGLTexture.b != -1) && (paramInt1 != 0) && (paramInt2 != 0))
    {
      RenderBuffer localRenderBuffer = this.a;
      if ((localRenderBuffer == null) || (paramInt1 != localRenderBuffer.getWidth()) || (paramInt2 != this.a.getHeight()))
      {
        localRenderBuffer = this.a;
        if (localRenderBuffer != null) {
          localRenderBuffer.destroy();
        }
        this.a = new RenderBuffer(paramInt1, paramInt2, 33984);
      }
      this.a.bind();
      this.b.drawTexture(3553, paramGLTexture.b, this.c, this.d);
      this.a.unbind();
      return GLTexture.a(0, this.a.getTexId());
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    if (this.e == paramInt) {
      return;
    }
    Matrix.setIdentityM(this.d, 0);
    if (paramInt == 1) {
      Matrix.scaleM(this.d, 0, -1.0F, 1.0F, 1.0F);
    } else if (paramInt == 2) {
      Matrix.scaleM(this.d, 0, 1.0F, -1.0F, 1.0F);
    }
    this.e = paramInt;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateMatrix, mirrorFlag[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.i("ExtraRender", 4, localStringBuilder.toString());
    }
  }
  
  public boolean a()
  {
    return this.e != 0;
  }
  
  public void b()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((RenderBuffer)localObject).destroy();
      this.a = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((TextureRender)localObject).release();
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.ExtraTextureRender
 * JD-Core Version:    0.7.0.1
 */