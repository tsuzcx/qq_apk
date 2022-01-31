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
  protected short[] mDrawOrder = { 0, 1, 2, 2, 3, 0 };
  protected int mRenderType = -1;
  protected float[] mSquareCoords = { -mSquareSize, mSquareSize, -mSquareSize, -mSquareSize, mSquareSize, -mSquareSize, mSquareSize, mSquareSize };
  protected float[] mTextureCoords = { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  protected FloatBuffer mTextureCoordsBuffer;
  protected float[] mTextureTransform = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  protected FloatBuffer mVertexBuffer;
  
  public BaseRender() {}
  
  public BaseRender(int paramInt)
  {
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
      Logger.e("VideoPlayer|BaseRender", paramString + ": glError " + GLUtils.getEGLErrorString(i));
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
    this.mSquareCoords = new float[] { mSquareSize, -mSquareSize, -mSquareSize, -mSquareSize, -mSquareSize, mSquareSize, mSquareSize, mSquareSize };
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.render.BaseRender
 * JD-Core Version:    0.7.0.1
 */