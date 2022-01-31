package com.tencent.TMG.opengl.glrenderer;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLU;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.util.Log;
import com.tencent.TMG.opengl.texture.BasicTexture;
import com.tencent.TMG.opengl.utils.IntArray;
import com.tencent.TMG.opengl.utils.Utils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;
import javax.microedition.khronos.opengles.GL11Ext;
import junit.framework.Assert;

public class GLES11Canvas
  implements GLCanvas
{
  private static final float[] BOX_COORDINATES = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  private static final int MSCALE_X = 0;
  private static final int MSCALE_Y = 5;
  private static final int MSKEW_X = 4;
  private static final int MSKEW_Y = 1;
  private static final int OFFSET_DRAW_LINE = 4;
  private static final int OFFSET_DRAW_RECT = 6;
  private static final int OFFSET_FILL_RECT = 0;
  private static final float OPAQUE_ALPHA = 0.95F;
  private static final String TAG = "GLCanvasImp";
  private static GLId mGLId = new GLES11Id();
  private static float[] sCropRect = new float[4];
  private float mAlpha;
  private boolean mBlendEnabled = true;
  private int mBoxCoords;
  int mCountDrawLine;
  int mCountDrawMesh;
  int mCountFillRect;
  int mCountTextureOES;
  int mCountTextureRect;
  private final IntArray mDeleteBuffers = new IntArray();
  private final RectF mDrawTextureSourceRect = new RectF();
  private final RectF mDrawTextureTargetRect = new RectF();
  private GL11 mGL;
  private GLES11Canvas.GLState mGLState;
  private final float[] mMapPointsBuffer = new float[4];
  private final float[] mMatrixValues = new float[16];
  private GLES11Canvas.ConfigState mRecycledRestoreAction;
  private final ArrayList<GLES11Canvas.ConfigState> mRestoreStack = new ArrayList();
  private final float[] mTempMatrix = new float[32];
  private final float[] mTextureColor = new float[4];
  private final float[] mTextureMatrixValues = new float[16];
  private final IntArray mUnboundTextures = new IntArray();
  
  public GLES11Canvas(GL11 paramGL11)
  {
    this.mGL = paramGL11;
    this.mGLState = new GLES11Canvas.GLState(paramGL11);
    FloatBuffer localFloatBuffer = allocateDirectNativeOrderBuffer(BOX_COORDINATES.length * 32 / 8).asFloatBuffer();
    localFloatBuffer.put(BOX_COORDINATES, 0, BOX_COORDINATES.length).position(0);
    int[] arrayOfInt = new int[1];
    mGLId.glGenBuffers(1, arrayOfInt, 0);
    this.mBoxCoords = arrayOfInt[0];
    paramGL11.glBindBuffer(34962, this.mBoxCoords);
    paramGL11.glBufferData(34962, localFloatBuffer.capacity() * 4, localFloatBuffer, 35044);
    paramGL11.glVertexPointer(2, 5126, 0, 0);
    paramGL11.glTexCoordPointer(2, 5126, 0, 0);
    paramGL11.glClientActiveTexture(33985);
    paramGL11.glTexCoordPointer(2, 5126, 0, 0);
    paramGL11.glClientActiveTexture(33984);
    paramGL11.glEnableClientState(32888);
  }
  
  private static ByteBuffer allocateDirectNativeOrderBuffer(int paramInt)
  {
    return ByteBuffer.allocateDirect(paramInt).order(ByteOrder.nativeOrder());
  }
  
  private boolean bindTexture(BasicTexture paramBasicTexture)
  {
    if (!paramBasicTexture.onBind(this)) {
      return false;
    }
    int i = paramBasicTexture.getTarget();
    this.mGLState.setTextureTarget(i);
    this.mGL.glBindTexture(i, paramBasicTexture.getId()[0]);
    return true;
  }
  
  private static void convertCoordinate(RectF paramRectF1, RectF paramRectF2, BasicTexture paramBasicTexture)
  {
    int i = paramBasicTexture.getTextureWidth();
    int j = paramBasicTexture.getTextureHeight();
    paramRectF1.left /= i;
    paramRectF1.right /= i;
    paramRectF1.top /= j;
    paramRectF1.bottom /= j;
  }
  
  private void drawBoundTexture(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (isMatrixRotatedOrFlipped(this.mMatrixValues))
    {
      setTextureCoords(0.0F, 0.0F, paramBasicTexture.getSourceWidth() / paramBasicTexture.getTextureWidth(), paramBasicTexture.getSourceHeight() / paramBasicTexture.getTextureHeight());
      textureRect(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    do
    {
      return;
      paramBasicTexture = mapPoints(this.mMatrixValues, paramInt1, paramInt2 + paramInt4, paramInt1 + paramInt3, paramInt2);
      paramInt1 = (int)(paramBasicTexture[0] + 0.5F);
      paramInt2 = (int)(paramBasicTexture[1] + 0.5F);
      paramInt3 = (int)(paramBasicTexture[2] + 0.5F) - paramInt1;
      paramInt4 = (int)(paramBasicTexture[3] + 0.5F) - paramInt2;
    } while ((paramInt3 <= 0) || (paramInt4 <= 0));
    ((GL11Ext)this.mGL).glDrawTexiOES(paramInt1, paramInt2, 0, paramInt3, paramInt4);
    this.mCountTextureOES += 1;
  }
  
  private void drawMixed(BasicTexture paramBasicTexture, int paramInt1, float paramFloat1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat2)
  {
    if (paramFloat1 <= 0.01F)
    {
      drawTexture(paramBasicTexture, paramInt2, paramInt3, paramInt4, paramInt5, paramFloat2);
      return;
    }
    if (paramFloat1 >= 1.0F)
    {
      fillRect(paramInt2, paramInt3, paramInt4, paramInt5, paramInt1);
      return;
    }
    GLES11Canvas.GLState localGLState = this.mGLState;
    if ((this.mBlendEnabled) && ((!paramBasicTexture.isOpaque()) || (!Utils.isOpaque(paramInt1)) || (paramFloat2 < 0.95F))) {}
    for (boolean bool = true;; bool = false)
    {
      localGLState.setBlendEnabled(bool);
      if (!bindTexture(paramBasicTexture)) {
        break;
      }
      this.mGLState.setTexEnvMode(34160);
      setMixedColor(paramInt1, paramFloat1, paramFloat2);
      drawBoundTexture(paramBasicTexture, paramInt2, paramInt3, paramInt4, paramInt5);
      this.mGLState.setTexEnvMode(7681);
      return;
    }
  }
  
  private void drawTexture(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    if ((paramInt3 <= 0) || (paramInt4 <= 0)) {
      return;
    }
    GLES11Canvas.GLState localGLState = this.mGLState;
    if ((this.mBlendEnabled) && ((!paramBasicTexture.isOpaque()) || (paramFloat < 0.95F))) {}
    for (boolean bool = true;; bool = false)
    {
      localGLState.setBlendEnabled(bool);
      if (!bindTexture(paramBasicTexture)) {
        break;
      }
      this.mGLState.setTextureAlpha(paramFloat);
      drawBoundTexture(paramBasicTexture, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
  }
  
  private void freeRestoreConfig(GLES11Canvas.ConfigState paramConfigState)
  {
    paramConfigState.mNextFree = this.mRecycledRestoreAction;
    this.mRecycledRestoreAction = paramConfigState;
  }
  
  private static boolean isMatrixRotatedOrFlipped(float[] paramArrayOfFloat)
  {
    boolean bool = false;
    if ((Math.abs(paramArrayOfFloat[4]) > 1.0E-005F) || (Math.abs(paramArrayOfFloat[1]) > 1.0E-005F) || (paramArrayOfFloat[0] < -1.0E-005F) || (paramArrayOfFloat[5] > 1.0E-005F)) {
      bool = true;
    }
    return bool;
  }
  
  private float[] mapPoints(float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float[] arrayOfFloat = this.mMapPointsBuffer;
    float f1 = paramArrayOfFloat[0];
    float f2 = paramInt1;
    float f3 = paramArrayOfFloat[4];
    float f4 = paramInt2;
    float f5 = paramArrayOfFloat[12];
    float f6 = paramArrayOfFloat[1];
    float f7 = paramInt1;
    float f8 = paramArrayOfFloat[5];
    float f9 = paramInt2;
    float f10 = paramArrayOfFloat[13];
    float f11 = paramArrayOfFloat[3] * paramInt1 + paramArrayOfFloat[7] * paramInt2 + paramArrayOfFloat[15];
    arrayOfFloat[0] = ((f1 * f2 + f3 * f4 + f5) / f11);
    arrayOfFloat[1] = ((f6 * f7 + f8 * f9 + f10) / f11);
    f1 = paramArrayOfFloat[0];
    f2 = paramInt3;
    f3 = paramArrayOfFloat[4];
    f4 = paramInt4;
    f5 = paramArrayOfFloat[12];
    f6 = paramArrayOfFloat[1];
    f7 = paramInt3;
    f8 = paramArrayOfFloat[5];
    f9 = paramInt4;
    f10 = paramArrayOfFloat[13];
    f11 = paramArrayOfFloat[3] * paramInt3 + paramArrayOfFloat[7] * paramInt4 + paramArrayOfFloat[15];
    arrayOfFloat[2] = ((f1 * f2 + f3 * f4 + f5) / f11);
    arrayOfFloat[3] = ((f6 * f7 + f8 * f9 + f10) / f11);
    return arrayOfFloat;
  }
  
  private GLES11Canvas.ConfigState obtainRestoreConfig()
  {
    if (this.mRecycledRestoreAction != null)
    {
      GLES11Canvas.ConfigState localConfigState = this.mRecycledRestoreAction;
      this.mRecycledRestoreAction = localConfigState.mNextFree;
      return localConfigState;
    }
    return new GLES11Canvas.ConfigState(null);
  }
  
  private void restoreTransform()
  {
    System.arraycopy(this.mTempMatrix, 0, this.mMatrixValues, 0, 16);
  }
  
  private void saveTransform()
  {
    System.arraycopy(this.mMatrixValues, 0, this.mTempMatrix, 0, 16);
  }
  
  private void setMixedColor(int paramInt, float paramFloat1, float paramFloat2)
  {
    float f = (1.0F - paramFloat1) * paramFloat2;
    paramFloat1 = paramFloat2 * paramFloat1 / (1.0F - f) * (paramInt >>> 24) / 65025.0F;
    setTextureColor((paramInt >>> 16 & 0xFF) * paramFloat1, (paramInt >>> 8 & 0xFF) * paramFloat1, paramFloat1 * (paramInt & 0xFF), f);
    GL11 localGL11 = this.mGL;
    localGL11.glTexEnvfv(8960, 8705, this.mTextureColor, 0);
    localGL11.glTexEnvf(8960, 34161, 34165.0F);
    localGL11.glTexEnvf(8960, 34162, 34165.0F);
    localGL11.glTexEnvf(8960, 34177, 34166.0F);
    localGL11.glTexEnvf(8960, 34193, 768.0F);
    localGL11.glTexEnvf(8960, 34185, 34166.0F);
    localGL11.glTexEnvf(8960, 34201, 770.0F);
    localGL11.glTexEnvf(8960, 34178, 34166.0F);
    localGL11.glTexEnvf(8960, 34194, 770.0F);
    localGL11.glTexEnvf(8960, 34186, 34166.0F);
    localGL11.glTexEnvf(8960, 34202, 770.0F);
  }
  
  private void setTextureColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float[] arrayOfFloat = this.mTextureColor;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    arrayOfFloat[2] = paramFloat3;
    arrayOfFloat[3] = paramFloat4;
  }
  
  private void setTextureCoords(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mGL.glMatrixMode(5890);
    this.mTextureMatrixValues[0] = (paramFloat3 - paramFloat1);
    this.mTextureMatrixValues[5] = (paramFloat4 - paramFloat2);
    this.mTextureMatrixValues[10] = 1.0F;
    this.mTextureMatrixValues[12] = paramFloat1;
    this.mTextureMatrixValues[13] = paramFloat2;
    this.mTextureMatrixValues[15] = 1.0F;
    this.mGL.glLoadMatrixf(this.mTextureMatrixValues, 0);
    this.mGL.glMatrixMode(5888);
  }
  
  private void setTextureCoords(RectF paramRectF)
  {
    setTextureCoords(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom);
  }
  
  private void setTextureCoords(float[] paramArrayOfFloat)
  {
    this.mGL.glMatrixMode(5890);
    this.mGL.glLoadMatrixf(paramArrayOfFloat, 0);
    this.mGL.glMatrixMode(5888);
  }
  
  private void textureRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    GL11 localGL11 = this.mGL;
    saveTransform();
    translate(paramFloat1, paramFloat2);
    scale(paramFloat3, paramFloat4, 1.0F);
    localGL11.glLoadMatrixf(this.mMatrixValues, 0);
    localGL11.glDrawArrays(5, 0, 4);
    restoreTransform();
    this.mCountTextureRect += 1;
  }
  
  private int uploadBuffer(Buffer paramBuffer, int paramInt)
  {
    int[] arrayOfInt = new int[1];
    mGLId.glGenBuffers(arrayOfInt.length, arrayOfInt, 0);
    int i = arrayOfInt[0];
    this.mGL.glBindBuffer(34962, i);
    this.mGL.glBufferData(34962, paramBuffer.capacity() * paramInt, paramBuffer, 35044);
    return i;
  }
  
  public void clearBuffer()
  {
    this.mGL.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    this.mGL.glClear(16384);
  }
  
  public void clearBuffer(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mGL.glClearColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    this.mGL.glClear(16384);
  }
  
  public void deleteBuffer(int paramInt)
  {
    synchronized (this.mUnboundTextures)
    {
      this.mDeleteBuffers.add(paramInt);
      return;
    }
  }
  
  public void deleteRecycledResources()
  {
    synchronized (this.mUnboundTextures)
    {
      IntArray localIntArray2 = this.mUnboundTextures;
      if (localIntArray2.size() > 0)
      {
        mGLId.glDeleteTextures(this.mGL, localIntArray2.size(), localIntArray2.getInternalArray(), 0);
        localIntArray2.clear();
      }
      localIntArray2 = this.mDeleteBuffers;
      if (localIntArray2.size() > 0)
      {
        mGLId.glDeleteBuffers(this.mGL, localIntArray2.size(), localIntArray2.getInternalArray(), 0);
        localIntArray2.clear();
      }
      return;
    }
  }
  
  public void drawLine(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint)
  {
    GL11 localGL11 = this.mGL;
    this.mGLState.setColorMode(paramGLPaint.getColor(), this.mAlpha);
    this.mGLState.setLineWidth(paramGLPaint.getLineWidth());
    saveTransform();
    translate(paramFloat1, paramFloat2);
    scale(paramFloat3 - paramFloat1, paramFloat4 - paramFloat2, 1.0F);
    localGL11.glLoadMatrixf(this.mMatrixValues, 0);
    localGL11.glDrawArrays(3, 4, 2);
    restoreTransform();
    this.mCountDrawLine += 1;
  }
  
  public void drawMesh(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    float f = this.mAlpha;
    if (!bindTexture(paramBasicTexture)) {
      return;
    }
    GLES11Canvas.GLState localGLState = this.mGLState;
    if ((this.mBlendEnabled) && ((!paramBasicTexture.isOpaque()) || (f < 0.95F))) {}
    for (boolean bool = true;; bool = false)
    {
      localGLState.setBlendEnabled(bool);
      this.mGLState.setTextureAlpha(f);
      setTextureCoords(0.0F, 0.0F, 1.0F, 1.0F);
      saveTransform();
      translate(paramInt1, paramInt2);
      this.mGL.glLoadMatrixf(this.mMatrixValues, 0);
      this.mGL.glBindBuffer(34962, paramInt3);
      this.mGL.glVertexPointer(2, 5126, 0, 0);
      this.mGL.glBindBuffer(34962, paramInt4);
      this.mGL.glTexCoordPointer(2, 5126, 0, 0);
      this.mGL.glBindBuffer(34963, paramInt5);
      this.mGL.glDrawElements(5, paramInt6, 5121, 0);
      this.mGL.glBindBuffer(34962, this.mBoxCoords);
      this.mGL.glVertexPointer(2, 5126, 0, 0);
      this.mGL.glTexCoordPointer(2, 5126, 0, 0);
      restoreTransform();
      this.mCountDrawMesh += 1;
      return;
    }
  }
  
  public void drawMixed(BasicTexture paramBasicTexture, int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    drawMixed(paramBasicTexture, paramInt1, paramFloat, paramInt2, paramInt3, paramInt4, paramInt5, this.mAlpha);
  }
  
  public void drawMixed(BasicTexture paramBasicTexture, int paramInt, float paramFloat, RectF paramRectF1, RectF paramRectF2)
  {
    if ((paramRectF2.width() <= 0.0F) || (paramRectF2.height() <= 0.0F)) {
      return;
    }
    if (paramFloat <= 0.01F)
    {
      drawTexture(paramBasicTexture, paramRectF1, paramRectF2);
      return;
    }
    if (paramFloat >= 1.0F)
    {
      fillRect(paramRectF2.left, paramRectF2.top, paramRectF2.width(), paramRectF2.height(), paramInt);
      return;
    }
    float f = this.mAlpha;
    this.mDrawTextureSourceRect.set(paramRectF1);
    this.mDrawTextureTargetRect.set(paramRectF2);
    paramRectF1 = this.mDrawTextureSourceRect;
    paramRectF2 = this.mDrawTextureTargetRect;
    GLES11Canvas.GLState localGLState = this.mGLState;
    if ((this.mBlendEnabled) && ((!paramBasicTexture.isOpaque()) || (!Utils.isOpaque(paramInt)) || (f < 0.95F))) {}
    for (boolean bool = true;; bool = false)
    {
      localGLState.setBlendEnabled(bool);
      if (!bindTexture(paramBasicTexture)) {
        break;
      }
      this.mGLState.setTexEnvMode(34160);
      setMixedColor(paramInt, paramFloat, f);
      convertCoordinate(paramRectF1, paramRectF2, paramBasicTexture);
      setTextureCoords(paramRectF1);
      textureRect(paramRectF2.left, paramRectF2.top, paramRectF2.width(), paramRectF2.height());
      this.mGLState.setTexEnvMode(7681);
      return;
    }
  }
  
  public void drawRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint)
  {
    GL11 localGL11 = this.mGL;
    this.mGLState.setColorMode(paramGLPaint.getColor(), this.mAlpha);
    this.mGLState.setLineWidth(paramGLPaint.getLineWidth());
    saveTransform();
    translate(paramFloat1, paramFloat2);
    scale(paramFloat3, paramFloat4, 1.0F);
    localGL11.glLoadMatrixf(this.mMatrixValues, 0);
    localGL11.glDrawArrays(2, 6, 4);
    restoreTransform();
    this.mCountDrawLine += 1;
  }
  
  public void drawTexture(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    drawTexture(paramBasicTexture, paramInt1, paramInt2, paramInt3, paramInt4, this.mAlpha);
  }
  
  public void drawTexture(BasicTexture paramBasicTexture, RectF paramRectF1, RectF paramRectF2)
  {
    if ((paramRectF2.width() <= 0.0F) || (paramRectF2.height() <= 0.0F)) {
      return;
    }
    this.mDrawTextureSourceRect.set(paramRectF1);
    this.mDrawTextureTargetRect.set(paramRectF2);
    paramRectF1 = this.mDrawTextureSourceRect;
    paramRectF2 = this.mDrawTextureTargetRect;
    GLES11Canvas.GLState localGLState = this.mGLState;
    if ((this.mBlendEnabled) && ((!paramBasicTexture.isOpaque()) || (this.mAlpha < 0.95F))) {}
    for (boolean bool = true;; bool = false)
    {
      localGLState.setBlendEnabled(bool);
      if (!bindTexture(paramBasicTexture)) {
        break;
      }
      convertCoordinate(paramRectF1, paramRectF2, paramBasicTexture);
      setTextureCoords(paramRectF1);
      this.mGLState.setTextureAlpha(this.mAlpha);
      textureRect(paramRectF2.left, paramRectF2.top, paramRectF2.width(), paramRectF2.height());
      return;
    }
  }
  
  public void drawTexture(BasicTexture paramBasicTexture, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GLES11Canvas.GLState localGLState = this.mGLState;
    if ((this.mBlendEnabled) && ((!paramBasicTexture.isOpaque()) || (this.mAlpha < 0.95F))) {}
    for (boolean bool = true;; bool = false)
    {
      localGLState.setBlendEnabled(bool);
      if (bindTexture(paramBasicTexture)) {
        break;
      }
      return;
    }
    setTextureCoords(paramArrayOfFloat);
    this.mGLState.setTextureAlpha(this.mAlpha);
    textureRect(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void dumpStatisticsAndClear()
  {
    String str = String.format("MESH:%d, TEX_OES:%d, TEX_RECT:%d, FILL_RECT:%d, LINE:%d", new Object[] { Integer.valueOf(this.mCountDrawMesh), Integer.valueOf(this.mCountTextureRect), Integer.valueOf(this.mCountTextureOES), Integer.valueOf(this.mCountFillRect), Integer.valueOf(this.mCountDrawLine) });
    this.mCountDrawMesh = 0;
    this.mCountTextureRect = 0;
    this.mCountTextureOES = 0;
    this.mCountFillRect = 0;
    this.mCountDrawLine = 0;
    Log.d("GLCanvasImp", str);
  }
  
  public void fillRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    this.mGLState.setColorMode(paramInt, this.mAlpha);
    GL11 localGL11 = this.mGL;
    saveTransform();
    translate(paramFloat1, paramFloat2);
    scale(paramFloat3, paramFloat4, 1.0F);
    localGL11.glLoadMatrixf(this.mMatrixValues, 0);
    localGL11.glDrawArrays(5, 0, 4);
    restoreTransform();
    this.mCountFillRect += 1;
  }
  
  public float getAlpha()
  {
    return this.mAlpha;
  }
  
  public void getBounds(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public GLId getGLId()
  {
    return mGLId;
  }
  
  public void initializeTexture(BasicTexture paramBasicTexture, Bitmap paramBitmap)
  {
    int i = paramBasicTexture.getTarget();
    this.mGL.glBindTexture(i, paramBasicTexture.getId()[0]);
    GLUtils.texImage2D(i, 0, paramBitmap, 0);
  }
  
  public void initializeTextureSize(BasicTexture paramBasicTexture, int paramInt1, int paramInt2)
  {
    int i = paramBasicTexture.getTarget();
    this.mGL.glBindTexture(i, paramBasicTexture.getId()[0]);
    int j = paramBasicTexture.getTextureWidth();
    int k = paramBasicTexture.getTextureHeight();
    this.mGL.glTexImage2D(i, 0, paramInt1, j, k, 0, paramInt1, paramInt2, null);
  }
  
  public void multiplyAlpha(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.mAlpha *= paramFloat;
      return;
    }
  }
  
  public void multiplyMatrix(float[] paramArrayOfFloat, int paramInt)
  {
    float[] arrayOfFloat = this.mTempMatrix;
    Matrix.multiplyMM(arrayOfFloat, 0, this.mMatrixValues, 0, paramArrayOfFloat, paramInt);
    System.arraycopy(arrayOfFloat, 0, this.mMatrixValues, 0, 16);
  }
  
  public void recoverFromLightCycle() {}
  
  public void restore()
  {
    if (this.mRestoreStack.isEmpty()) {
      throw new IllegalStateException();
    }
    GLES11Canvas.ConfigState localConfigState = (GLES11Canvas.ConfigState)this.mRestoreStack.remove(this.mRestoreStack.size() - 1);
    localConfigState.restore(this);
    freeRestoreConfig(localConfigState);
  }
  
  public void rotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFloat1 == 0.0F) {
      return;
    }
    float[] arrayOfFloat = this.mTempMatrix;
    Matrix.setRotateM(arrayOfFloat, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    Matrix.multiplyMM(arrayOfFloat, 16, this.mMatrixValues, 0, arrayOfFloat, 0);
    System.arraycopy(arrayOfFloat, 16, this.mMatrixValues, 0, 16);
  }
  
  public void save()
  {
    save(-1);
  }
  
  public void save(int paramInt)
  {
    GLES11Canvas.ConfigState localConfigState = obtainRestoreConfig();
    if ((paramInt & 0x1) != 0)
    {
      localConfigState.mAlpha = this.mAlpha;
      if ((paramInt & 0x2) == 0) {
        break label60;
      }
      System.arraycopy(this.mMatrixValues, 0, localConfigState.mMatrix, 0, 16);
    }
    for (;;)
    {
      this.mRestoreStack.add(localConfigState);
      return;
      localConfigState.mAlpha = -1.0F;
      break;
      label60:
      localConfigState.mMatrix[0] = (1.0F / -1.0F);
    }
  }
  
  public void scale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.scaleM(this.mMatrixValues, 0, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setAlpha(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.mAlpha = paramFloat;
      return;
    }
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.mAlpha = 1.0F;
      Object localObject = this.mGL;
      ((GL11)localObject).glViewport(0, 0, paramInt1, paramInt2);
      ((GL11)localObject).glMatrixMode(5889);
      ((GL11)localObject).glLoadIdentity();
      GLU.gluOrtho2D((GL10)localObject, 0.0F, paramInt1, 0.0F, paramInt2);
      ((GL11)localObject).glMatrixMode(5888);
      ((GL11)localObject).glLoadIdentity();
      localObject = this.mMatrixValues;
      Matrix.setIdentityM((float[])localObject, 0);
      Matrix.translateM((float[])localObject, 0, 0.0F, paramInt2, 0.0F);
      Matrix.scaleM((float[])localObject, 0, 1.0F, -1.0F, 1.0F);
      return;
    }
  }
  
  public void setTextureParameters(BasicTexture paramBasicTexture)
  {
    int i = paramBasicTexture.getSourceWidth();
    int j = paramBasicTexture.getSourceHeight();
    sCropRect[0] = 0.0F;
    sCropRect[1] = j;
    sCropRect[2] = i;
    sCropRect[3] = (-j);
    i = paramBasicTexture.getTarget();
    this.mGL.glBindTexture(i, paramBasicTexture.getId()[0]);
    this.mGL.glTexParameterfv(i, 35741, sCropRect, 0);
    this.mGL.glTexParameteri(i, 10242, 33071);
    this.mGL.glTexParameteri(i, 10243, 33071);
    this.mGL.glTexParameterf(i, 10241, 9729.0F);
    this.mGL.glTexParameterf(i, 10240, 9729.0F);
  }
  
  public void texSubImage2D(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4)
  {
    int i = paramBasicTexture.getTarget();
    this.mGL.glBindTexture(i, paramBasicTexture.getId()[0]);
    GLUtils.texSubImage2D(i, 0, paramInt1, paramInt2, paramBitmap, paramInt3, paramInt4);
  }
  
  public void translate(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = this.mMatrixValues;
    arrayOfFloat[12] += arrayOfFloat[0] * paramFloat1 + arrayOfFloat[4] * paramFloat2;
    arrayOfFloat[13] += arrayOfFloat[1] * paramFloat1 + arrayOfFloat[5] * paramFloat2;
    arrayOfFloat[14] += arrayOfFloat[2] * paramFloat1 + arrayOfFloat[6] * paramFloat2;
    arrayOfFloat[15] += arrayOfFloat[3] * paramFloat1 + arrayOfFloat[7] * paramFloat2;
  }
  
  public void translate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.translateM(this.mMatrixValues, 0, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public boolean unloadTexture(BasicTexture paramBasicTexture)
  {
    synchronized (this.mUnboundTextures)
    {
      if (!paramBasicTexture.isLoaded()) {
        return false;
      }
      this.mUnboundTextures.add(paramBasicTexture.getId()[0]);
      return true;
    }
  }
  
  public int uploadBuffer(ByteBuffer paramByteBuffer)
  {
    return uploadBuffer(paramByteBuffer, 1);
  }
  
  public int uploadBuffer(FloatBuffer paramFloatBuffer)
  {
    return uploadBuffer(paramFloatBuffer, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.opengl.glrenderer.GLES11Canvas
 * JD-Core Version:    0.7.0.1
 */