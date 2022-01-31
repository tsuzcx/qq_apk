package com.tencent.TMG.opengl.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.opengl.glrenderer.GLCanvas;
import com.tencent.TMG.opengl.texture.BasicTexture;
import com.tencent.TMG.opengl.texture.StringTexture;
import com.tencent.TMG.opengl.texture.YUVTexture;
import com.tencent.TMG.opengl.utils.Utils;
import com.tencent.TMG.utils.QLog;

public class GLVideoView
  extends GLView
{
  private static final int BOTTOM = 8;
  private static final int LEFT = 1;
  private static final long LOADING_ELAPSE = 80L;
  public static final float MAX_SCALE = 4.0F;
  public static final float MIN_SCALE = 0.75F;
  private static final int NONE = 0;
  private static final int RIGHT = 2;
  private static final String TAG = "GLVideoView";
  private static final int TOP = 4;
  private Runnable loadingRunnable = new GLVideoView.2(this);
  private Context mContext;
  private boolean mDragging = false;
  int mGlVersion = -1;
  private GraphicRendererMgr mGraphicRenderMgr = null;
  private int mHeight = 0;
  private String mIdentifier = null;
  private long mLastLoadingTime = 0L;
  private boolean mLoading = false;
  private int mLoadingAngle = 0;
  private BasicTexture mLoadingTexture;
  private boolean mMirror = false;
  private float mOffsetX = 0.0F;
  private float mOffsetY = 0.0F;
  private int mPivotX = 0;
  private int mPivotY = 0;
  private int mPosition = 0;
  private int mRotation = 0;
  private float mScale = 1.0F;
  private StringTexture mStringTexture;
  private int mTextBackgroudColor = 0;
  private int mVideoSrcType = 0;
  private int mWidth = 0;
  private int mX = 0;
  private int mY = 0;
  private YUVTexture mYuvTexture;
  
  public GLVideoView(Context paramContext, GraphicRendererMgr paramGraphicRendererMgr)
  {
    this.mContext = paramContext;
    this.mGlVersion = Utils.getGLVersion(this.mContext);
    this.mYuvTexture = new YUVTexture(this.mContext);
    this.mYuvTexture.setGLRenderListener(new GLVideoView.1(this));
    this.mGraphicRenderMgr = paramGraphicRendererMgr;
  }
  
  private boolean hasBlackBorder(int paramInt, boolean paramBoolean)
  {
    if ((this.mIdentifier != null) && (this.mIdentifier.equals(""))) {}
    do
    {
      do
      {
        return false;
      } while ((this.mParent == null) || (getWidth() != this.mParent.getWidth()) || (getHeight() != this.mParent.getHeight()));
      if (paramInt % 2 != 0) {
        break;
      }
    } while (paramBoolean);
    return true;
    return paramBoolean;
  }
  
  public void clearRender()
  {
    if (this.mIdentifier != null)
    {
      String str = this.mIdentifier + "_" + this.mVideoSrcType;
      this.mGraphicRenderMgr.setGlRender(str, null);
    }
    this.mIdentifier = null;
    this.mVideoSrcType = 0;
    this.mScale = 1.0F;
    this.mPivotX = 0;
    this.mPivotY = 0;
    this.mOffsetX = 0.0F;
    this.mOffsetY = 0.0F;
  }
  
  public void enableLoading(boolean paramBoolean)
  {
    GLRootView localGLRootView;
    if (this.mLoading != paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GLVideoView", 0, "enableLoading uin: " + this.mIdentifier + ", mVideoSrcType: " + this.mVideoSrcType + ", loading: " + paramBoolean + ", mLoading: " + this.mLoading);
      }
      this.mLoading = paramBoolean;
      if (!paramBoolean) {
        break label110;
      }
      if (this.mLoadingTexture == null) {}
      localGLRootView = getGLRootView();
      if (localGLRootView != null) {
        localGLRootView.post(this.loadingRunnable);
      }
    }
    label110:
    do
    {
      return;
      localGLRootView = getGLRootView();
    } while (localGLRootView == null);
    localGLRootView.removeCallbacks(this.loadingRunnable);
  }
  
  protected void finalize()
  {
    super.finalize();
    if (this.mStringTexture != null)
    {
      this.mStringTexture.recycle();
      this.mStringTexture = null;
    }
    if (this.mLoadingTexture != null)
    {
      this.mLoadingTexture.recycle();
      this.mLoadingTexture = null;
    }
    if (this.mYuvTexture != null)
    {
      this.mYuvTexture.recycle();
      this.mYuvTexture = null;
    }
    this.loadingRunnable = null;
  }
  
  public void flush()
  {
    if (this.mYuvTexture != null) {
      this.mYuvTexture.flush(false);
    }
    if (this.mIdentifier != null)
    {
      String str = this.mIdentifier + "_" + this.mVideoSrcType;
      this.mGraphicRenderMgr.flushGlRender(str);
    }
  }
  
  public String getIdentifier()
  {
    return this.mIdentifier;
  }
  
  public int getRotation()
  {
    return this.mRotation;
  }
  
  public float getScale()
  {
    return this.mScale;
  }
  
  public int getVideoSrcType()
  {
    return this.mVideoSrcType;
  }
  
  public boolean hasVideo()
  {
    if (this.mYuvTexture != null) {
      return this.mYuvTexture.canRender();
    }
    return false;
  }
  
  public boolean isLoading()
  {
    return this.mLoading;
  }
  
  public boolean isMirror()
  {
    return this.mMirror;
  }
  
  protected void onDetachFromRoot()
  {
    GLRootView localGLRootView = getGLRootView();
    if (localGLRootView != null) {
      localGLRootView.removeCallbacks(this.loadingRunnable);
    }
    super.onDetachFromRoot();
  }
  
  protected void render(GLCanvas paramGLCanvas)
  {
    if (this.mGlVersion == -1) {
      this.mGlVersion = Utils.getGLVersion(this.mContext);
    }
    Rect localRect = getPaddings();
    renderBackground(paramGLCanvas);
    int j;
    int i;
    int n;
    int m;
    float f2;
    float f5;
    float f6;
    int k;
    float f4;
    float f3;
    if ((this.mIdentifier != null) && (hasVideo()))
    {
      enableLoading(false);
      j = getWidth();
      i = getHeight();
      j = j - localRect.left - localRect.right;
      i = i - localRect.top - localRect.bottom;
      n = this.mYuvTexture.getImgAngle();
      m = (this.mRotation + n + 4) % 4;
      f2 = localRect.left;
      f1 = localRect.top;
      f5 = j;
      f6 = i;
      if (m % 2 == 0) {
        break label1641;
      }
      k = (int)j;
      j = i;
      i = k;
      f4 = f1;
      f3 = f6;
    }
    for (float f1 = f5;; f1 = f6)
    {
      f5 = this.mYuvTexture.getImgWidth();
      f6 = this.mYuvTexture.getImgHeight();
      float f10 = f5 / f6;
      float f7 = f3 / f1;
      boolean bool;
      label273:
      float f8;
      float f9;
      if ((f5 < f6) && (n == 0))
      {
        bool = true;
        if (!hasBlackBorder(m, bool)) {
          break label1328;
        }
        if (m % 2 != 0) {
          break label1273;
        }
        f7 = f3 / f10;
        if (f7 <= f1) {
          break label1258;
        }
        f7 = f1 * f10;
        f4 += (f3 - f7) / 2.0F;
        f3 = f7;
        f8 = f3 / f1;
        f9 = f2;
        f2 = f5;
        f5 = f3;
        f3 = f6;
        f7 = f4;
        f6 = f9;
        f4 = f1;
        f1 = f3;
        f3 = f8;
      }
      for (;;)
      {
        label311:
        f7 = f7 * this.mScale + this.mPivotX * (1.0F - this.mScale);
        f6 = f6 * this.mScale + this.mPivotY * (1.0F - this.mScale);
        f5 *= this.mScale;
        f4 *= this.mScale;
        if ((!this.mDragging) && (this.mPosition != 0))
        {
          if ((this.mPosition & 0x3) != 3) {
            break label1399;
          }
          this.mOffsetX = (j / 2 - (f5 / 2.0F + f7));
          label414:
          if ((this.mPosition & 0xC) != 12) {
            break label1445;
          }
          this.mOffsetY = (i / 2 - (f4 / 2.0F + f6));
          label443:
          this.mPosition = 0;
          if (QLog.isColorLevel()) {
            QLog.d("GLVideoView", 0, "render uin: " + this.mIdentifier + ", mVideoSrcType: " + this.mVideoSrcType + ", width: " + j + ", height: " + i + ", mScale: " + this.mScale + ", mPivotX: " + this.mPivotX + ", mPivotY: " + this.mPivotY + ", x: " + f7 + ", y: " + f6 + ", w: " + f5 + ", h: " + f4 + ", mOffsetX: " + this.mOffsetX + ", mOffsetY: " + this.mOffsetY + ", mWidth: " + this.mWidth + ", mHeight: " + this.mHeight);
          }
        }
        f8 = this.mOffsetX;
        f9 = this.mOffsetY;
        this.mX = ((int)(f8 + f7));
        this.mY = ((int)(f9 + f6));
        this.mWidth = ((int)f5);
        this.mHeight = ((int)f4);
        if (f10 > f3)
        {
          f4 = f3 * f1;
          f3 = f4;
          if (this.mGlVersion == 1) {
            f3 = f4 * f2 / Utils.nextPowerOf2((int)f2);
          }
          f4 = (f2 - f3) / 2.0F;
          this.mYuvTexture.setSourceSize((int)f3, (int)f1);
          this.mYuvTexture.setSourceLeft((int)f4);
          this.mYuvTexture.setSourceTop(0);
          label775:
          if (this.mGlVersion == 1)
          {
            this.mYuvTexture.setSourceSize((int)f2, (int)f1);
            this.mYuvTexture.setSourceLeft(0);
            this.mYuvTexture.setSourceTop((int)0.0F);
          }
          paramGLCanvas.save(2);
          i = getWidth() / 2;
          j = getHeight() / 2;
          paramGLCanvas.translate(i, j);
          if (this.mMirror)
          {
            if (this.mRotation % 2 != 0) {
              break label1565;
            }
            paramGLCanvas.scale(-1.0F, 1.0F, 1.0F);
          }
          label873:
          paramGLCanvas.rotate(m * 90, 0.0F, 0.0F, 1.0F);
          if (m % 2 == 0) {
            break label1579;
          }
          paramGLCanvas.translate(-j, -i);
          label909:
          this.mYuvTexture.draw(paramGLCanvas, this.mX, this.mY, this.mWidth, this.mHeight);
          paramGLCanvas.restore();
          if ((this.mLoading) && (this.mLoadingTexture != null))
          {
            this.mLoadingAngle %= 360;
            k = getWidth();
            m = getHeight();
            j = this.mLoadingTexture.getSourceWidth();
            n = this.mLoadingTexture.getSourceHeight();
            i = j;
            if (j > k) {
              i = k;
            }
            j = n;
            if (n > m) {
              j = m;
            }
            paramGLCanvas.save(2);
            paramGLCanvas.translate(k / 2, m / 2);
            paramGLCanvas.rotate(this.mLoadingAngle, 0.0F, 0.0F, 1.0F);
            paramGLCanvas.translate(-i / 2, -j / 2);
            this.mLoadingTexture.draw(paramGLCanvas, 0, 0, i, j);
            paramGLCanvas.restore();
            long l = System.currentTimeMillis();
            if (l - this.mLastLoadingTime >= 80L)
            {
              this.mLastLoadingTime = l;
              this.mLoadingAngle += 8;
            }
          }
          if (this.mStringTexture != null)
          {
            k = getWidth();
            m = getHeight();
            i = this.mStringTexture.getSourceWidth();
            j = this.mStringTexture.getSourceHeight();
            if (i <= k) {
              break label1599;
            }
            i = k;
          }
        }
        label1328:
        label1599:
        for (;;)
        {
          if (j > m) {
            j = m;
          }
          for (;;)
          {
            n = j + 10;
            paramGLCanvas.fillRect(0.0F, m - n, k, n, this.mTextBackgroudColor);
            this.mStringTexture.draw(paramGLCanvas, k / 2 - i / 2, m - j, i, j);
            return;
            bool = false;
            break;
            label1258:
            f2 += (f1 - f7) / 2.0F;
            f1 = f7;
            break label273;
            label1273:
            f7 = f1 * f10;
            if (f7 > f3)
            {
              f7 = f3 / f10;
              f2 += (f1 - f7) / 2.0F;
              f1 = f7;
              break label273;
            }
            f4 += (f3 - f7) / 2.0F;
            f3 = f7;
            break label273;
            k = (int)f5;
            if (k % 8 == 0) {
              break label1602;
            }
            f8 = k * k / ((k / 8 + 1) * 8);
            f5 = f8 / f10;
            f6 = f2;
            f2 = f8;
            f8 = f4;
            f4 = f1;
            f1 = f5;
            f5 = f3;
            f3 = f7;
            f7 = f8;
            break label311;
            label1399:
            if ((this.mPosition & 0x1) == 1)
            {
              this.mOffsetX = (-f7);
              break label414;
            }
            if ((this.mPosition & 0x2) != 2) {
              break label414;
            }
            this.mOffsetX = (j - f5 - f7);
            break label414;
            if ((this.mPosition & 0x4) == 4)
            {
              this.mOffsetY = (-f6);
              break label443;
            }
            if ((this.mPosition & 0x8) != 8) {
              break label443;
            }
            this.mOffsetY = (i - f4 - f6);
            break label443;
            f4 = f2 / f3;
            f3 = f4;
            if (this.mGlVersion == 1) {
              f3 = f4 * f1 / Utils.nextPowerOf2((int)f1);
            }
            f4 = (f1 - f3) / 2.0F;
            this.mYuvTexture.setSourceSize((int)f2, (int)f3);
            this.mYuvTexture.setSourceLeft(0);
            this.mYuvTexture.setSourceTop((int)f4);
            break label775;
            paramGLCanvas.scale(1.0F, -1.0F, 1.0F);
            break label873;
            paramGLCanvas.translate(-i, -j);
            break label909;
          }
        }
        label1445:
        label1579:
        label1602:
        f8 = f3;
        label1565:
        f9 = f4;
        f4 = f1;
        f3 = f7;
        f7 = f2;
        f2 = f5;
        f1 = f6;
        f5 = f8;
        f6 = f7;
        f7 = f9;
      }
      label1641:
      f3 = f5;
      f4 = f2;
      f2 = f1;
    }
  }
  
  public void setMirror(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLVideoView", 0, "setMirror uin: " + this.mIdentifier + ", mVideoSrcType: " + this.mVideoSrcType + ", mMirror: " + this.mMirror + ", mirror: " + paramBoolean);
    }
    if (this.mMirror != paramBoolean)
    {
      this.mMirror = paramBoolean;
      invalidate();
    }
  }
  
  public void setRender(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramInt == 0))
    {
      this.mIdentifier = null;
      this.mVideoSrcType = 0;
      return;
    }
    this.mIdentifier = paramString;
    this.mVideoSrcType = paramInt;
    paramString = this.mIdentifier + "_" + this.mVideoSrcType;
    if (this.mYuvTexture == null) {
      Log.e("GLVideoView", "null == mYuvTexture");
    }
    this.mGraphicRenderMgr.setGlRender(paramString, this.mYuvTexture);
    this.mScale = 1.0F;
    this.mPivotX = 0;
    this.mPivotY = 0;
    this.mOffsetX = 0.0F;
    this.mOffsetY = 0.0F;
  }
  
  public void setRotation(int paramInt)
  {
    switch (paramInt % 360)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      if (this.mRotation != paramInt)
      {
        this.mRotation = paramInt;
        this.mScale = 1.0F;
        this.mPivotX = 0;
        this.mPivotY = 0;
        this.mOffsetX = 0.0F;
        this.mOffsetY = 0.0F;
        if (getVisibility() == 0) {
          invalidate();
        }
      }
      return;
      paramInt = 1;
      continue;
      paramInt = 2;
      continue;
      paramInt = 3;
    }
  }
  
  public void setScale(float paramFloat, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLVideoView", 0, "setScale uin: " + this.mIdentifier + ", mVideoSrcType: " + this.mVideoSrcType + ", scale: " + paramFloat + ", x: " + paramInt1 + ", y: " + paramInt2 + ", isEnd: " + paramBoolean + ", mOffsetX: " + this.mOffsetX + ", mOffsetY: " + this.mOffsetY + ", mX: " + this.mX + ", mY: " + this.mY + ", mWidth: " + this.mWidth + ", mHeight: " + this.mHeight);
    }
    float f1;
    int i;
    if (paramBoolean)
    {
      float f2 = paramFloat;
      if (paramFloat < 1.0F)
      {
        this.mPosition = 0;
        this.mPosition |= 0x3;
        this.mPosition |= 0xC;
        f2 = 1.0F;
      }
      f1 = f2;
      if (f2 > 4.0F)
      {
        this.mPosition = 0;
        this.mPosition |= 0x1;
        this.mPosition |= 0x4;
        f1 = 4.0F;
      }
      if (this.mRotation % 2 == 0) {
        break label317;
      }
      i = paramInt2;
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      this.mScale = f1;
      this.mPivotX = i;
      this.mPivotY = paramInt2;
      invalidate();
      return;
      if (paramFloat < 0.75F)
      {
        f1 = 0.75F;
        break;
      }
      f1 = paramFloat;
      if (paramFloat <= 4.0F) {
        break;
      }
      f1 = 4.0F;
      break;
      label317:
      i = paramInt1;
    }
  }
  
  public void setText(String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLVideoView", 0, "setText uin: " + this.mIdentifier + ", mVideoSrcType: " + this.mVideoSrcType + ", text: " + paramString + ", textSize: " + paramFloat + ", color: " + paramInt1);
    }
    if (this.mStringTexture != null)
    {
      this.mStringTexture.recycle();
      this.mStringTexture = null;
    }
    this.mTextBackgroudColor = 0;
    if (paramString != null)
    {
      this.mStringTexture = StringTexture.newInstance(paramString, paramFloat, paramInt1);
      this.mTextBackgroudColor = paramInt2;
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.opengl.ui.GLVideoView
 * JD-Core Version:    0.7.0.1
 */