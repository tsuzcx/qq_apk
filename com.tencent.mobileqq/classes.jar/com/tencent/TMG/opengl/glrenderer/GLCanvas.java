package com.tencent.TMG.opengl.glrenderer;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.TMG.opengl.texture.BasicTexture;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public abstract interface GLCanvas
{
  public static final int GL_TEXTURE_EXTERNAL_OES = 36197;
  public static final int SAVE_FLAG_ALL = -1;
  public static final int SAVE_FLAG_ALPHA = 1;
  public static final int SAVE_FLAG_MATRIX = 2;
  
  public abstract void clearBuffer();
  
  public abstract void clearBuffer(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract void deleteBuffer(int paramInt);
  
  public abstract void deleteRecycledResources();
  
  public abstract void drawLine(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint);
  
  public abstract void drawMesh(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public abstract void drawMixed(BasicTexture paramBasicTexture, int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void drawMixed(BasicTexture paramBasicTexture, int paramInt, float paramFloat, RectF paramRectF1, RectF paramRectF2);
  
  public abstract void drawRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint);
  
  public abstract void drawTexture(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void drawTexture(BasicTexture paramBasicTexture, RectF paramRectF1, RectF paramRectF2);
  
  public abstract void drawTexture(BasicTexture paramBasicTexture, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void dumpStatisticsAndClear();
  
  public abstract void fillRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt);
  
  public abstract float getAlpha();
  
  public abstract void getBounds(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract GLId getGLId();
  
  public abstract void initializeTexture(BasicTexture paramBasicTexture, Bitmap paramBitmap);
  
  public abstract void initializeTextureSize(BasicTexture paramBasicTexture, int paramInt1, int paramInt2);
  
  public abstract void multiplyAlpha(float paramFloat);
  
  public abstract void multiplyMatrix(float[] paramArrayOfFloat, int paramInt);
  
  public abstract void recoverFromLightCycle();
  
  public abstract void restore();
  
  public abstract void rotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract void save();
  
  public abstract void save(int paramInt);
  
  public abstract void scale(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void setAlpha(float paramFloat);
  
  public abstract void setSize(int paramInt1, int paramInt2);
  
  public abstract void setTextureParameters(BasicTexture paramBasicTexture);
  
  public abstract void texSubImage2D(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4);
  
  public abstract void translate(float paramFloat1, float paramFloat2);
  
  public abstract void translate(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract boolean unloadTexture(BasicTexture paramBasicTexture);
  
  public abstract int uploadBuffer(ByteBuffer paramByteBuffer);
  
  public abstract int uploadBuffer(FloatBuffer paramFloatBuffer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.opengl.glrenderer.GLCanvas
 * JD-Core Version:    0.7.0.1
 */