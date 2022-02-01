package com.tencent.jalpha.videoplayer.render;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.view.Surface;
import com.tencent.jalpha.common.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public abstract class BaseRender
{
  private static final String TAG = "VideoPlayer|BaseRender";
  private static float mSquareSize = 1.0F;
  protected ShortBuffer mDrawListBuffer;
  protected short[] mDrawOrder;
  protected int mRenderType;
  protected float[] mSquareCoords;
  protected float[] mTextureCoords;
  protected FloatBuffer mTextureCoordsBuffer;
  protected float[] mTextureTransform;
  protected FloatBuffer mVertexBuffer;
  
  public BaseRender()
  {
    float f = mSquareSize;
    this.mSquareCoords = new float[] { -f, f, -f, -f, f, -f, f, f };
    this.mDrawOrder = new short[] { 0, 1, 2, 2, 3, 0 };
    this.mTextureCoords = new float[] { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F };
    this.mTextureTransform = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
    this.mRenderType = -1;
  }
  
  public BaseRender(int paramInt)
  {
    float f = mSquareSize;
    this.mSquareCoords = new float[] { -f, f, -f, -f, f, -f, f, f };
    this.mDrawOrder = new short[] { 0, 1, 2, 2, 3, 0 };
    this.mTextureCoords = new float[] { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F };
    this.mTextureTransform = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
    this.mRenderType = -1;
    this.mRenderType = paramInt;
  }
  
  public void checkGlError(String paramString)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError ");
      localStringBuilder.append(GLUtils.getEGLErrorString(i));
      Logger.e("VideoPlayer|BaseRender", localStringBuilder.toString());
    }
  }
  
  public abstract void destroy();
  
  public abstract void draw(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public int getRenderType()
  {
    if (this.mRenderType == -1) {
      Logger.v("VideoPlayer|BaseRender", "mRenderType  Error, need initDecodeType ");
    }
    return this.mRenderType;
  }
  
  public abstract Surface getSurface();
  
  public abstract SurfaceTexture getVideoTexture();
  
  public void setRoteTexture()
  {
    float f = mSquareSize;
    this.mSquareCoords = new float[] { f, -f, -f, -f, -f, f, f, f };
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(this.mSquareCoords.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.mVertexBuffer = localByteBuffer.asFloatBuffer();
    this.mVertexBuffer.put(this.mSquareCoords);
    this.mVertexBuffer.position(0);
  }
  
  public abstract void setup();
  
  public void setupTextureCoordsBuffer()
  {
    Logger.v("VideoPlayer|BaseRender", "setupTexture");
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(this.mTextureCoords.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.mTextureCoordsBuffer = localByteBuffer.asFloatBuffer();
    this.mTextureCoordsBuffer.put(this.mTextureCoords);
    this.mTextureCoordsBuffer.position(0);
  }
  
  public void setupVertexBuffer()
  {
    Logger.v("VideoPlayer|BaseRender", "setupVertexBuffer");
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(this.mDrawOrder.length * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.mDrawListBuffer = localByteBuffer.asShortBuffer();
    this.mDrawListBuffer.put(this.mDrawOrder);
    this.mDrawListBuffer.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(this.mSquareCoords.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.mVertexBuffer = localByteBuffer.asFloatBuffer();
    this.mVertexBuffer.put(this.mSquareCoords);
    this.mVertexBuffer.position(0);
  }
  
  public abstract void updateSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.render.BaseRender
 * JD-Core Version:    0.7.0.1
 */