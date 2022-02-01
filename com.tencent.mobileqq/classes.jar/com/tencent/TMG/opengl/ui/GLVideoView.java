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
    String str = this.mIdentifier;
    if ((str != null) && (str.equals(""))) {
      return false;
    }
    if ((this.mParent != null) && (getWidth() == this.mParent.getWidth()) && (getHeight() == this.mParent.getHeight()))
    {
      if (paramInt % 2 == 0) {
        return paramBoolean ^ true;
      }
      return paramBoolean;
    }
    return false;
  }
  
  public void clearRender()
  {
    if (this.mIdentifier != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mIdentifier);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.mVideoSrcType);
      localObject = ((StringBuilder)localObject).toString();
      this.mGraphicRenderMgr.setGlRender((String)localObject, null);
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
    if (this.mLoading != paramBoolean)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("enableLoading uin: ");
        ((StringBuilder)localObject).append(this.mIdentifier);
        ((StringBuilder)localObject).append(", mVideoSrcType: ");
        ((StringBuilder)localObject).append(this.mVideoSrcType);
        ((StringBuilder)localObject).append(", loading: ");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(", mLoading: ");
        ((StringBuilder)localObject).append(this.mLoading);
        QLog.d("GLVideoView", 0, ((StringBuilder)localObject).toString());
      }
      this.mLoading = paramBoolean;
      if (paramBoolean)
      {
        localObject = this.mLoadingTexture;
        localObject = getGLRootView();
        if (localObject != null) {
          ((GLRootView)localObject).post(this.loadingRunnable);
        }
      }
      else
      {
        localObject = getGLRootView();
        if (localObject != null) {
          ((GLRootView)localObject).removeCallbacks(this.loadingRunnable);
        }
      }
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    Object localObject = this.mStringTexture;
    if (localObject != null)
    {
      ((StringTexture)localObject).recycle();
      this.mStringTexture = null;
    }
    localObject = this.mLoadingTexture;
    if (localObject != null)
    {
      ((BasicTexture)localObject).recycle();
      this.mLoadingTexture = null;
    }
    localObject = this.mYuvTexture;
    if (localObject != null)
    {
      ((YUVTexture)localObject).recycle();
      this.mYuvTexture = null;
    }
    this.loadingRunnable = null;
  }
  
  public void flush()
  {
    Object localObject = this.mYuvTexture;
    if (localObject != null) {
      ((YUVTexture)localObject).flush(false);
    }
    if (this.mIdentifier != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mIdentifier);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.mVideoSrcType);
      localObject = ((StringBuilder)localObject).toString();
      this.mGraphicRenderMgr.flushGlRender((String)localObject);
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
    YUVTexture localYUVTexture = this.mYuvTexture;
    if (localYUVTexture != null) {
      return localYUVTexture.canRender();
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
    Object localObject = getPaddings();
    renderBackground(paramGLCanvas);
    int i;
    int j;
    int m;
    int n;
    int k;
    if ((this.mIdentifier != null) && (hasVideo()))
    {
      enableLoading(false);
      i = getWidth();
      j = getHeight();
      i = i - ((Rect)localObject).left - ((Rect)localObject).right;
      j = j - ((Rect)localObject).top - ((Rect)localObject).bottom;
      int i1 = this.mYuvTexture.getImgAngle();
      m = (this.mRotation + i1 + 4) % 4;
      float f1 = ((Rect)localObject).left;
      float f5 = ((Rect)localObject).top;
      float f2 = i;
      float f3 = j;
      n = m % 2;
      if (n != 0)
      {
        k = (int)f2;
        i = j;
        f4 = f2;
        f2 = f3;
        f3 = f5;
        j = k;
      }
      else
      {
        f6 = f1;
        f4 = f3;
        f1 = f5;
        f3 = f6;
      }
      float f6 = this.mYuvTexture.getImgWidth();
      float f7 = this.mYuvTexture.getImgHeight();
      float f13 = f6 / f7;
      float f12 = f2 / f4;
      boolean bool;
      if ((f6 < f7) && (i1 == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      label329:
      label343:
      float f10;
      float f11;
      if (hasBlackBorder(m, bool))
      {
        if (n == 0)
        {
          f8 = f2 / f13;
          f5 = f8;
          if (f8 > f4)
          {
            f5 = f4 * f13;
            break label329;
          }
        }
        else
        {
          f8 = f4 * f13;
          f5 = f8;
          if (f8 <= f2) {
            break label329;
          }
          f5 = f2 / f13;
        }
        f1 += (f4 - f5) / 2.0F;
        f4 = f5;
        break label343;
        f3 += (f2 - f5) / 2.0F;
        f2 = f5;
        f12 = f2 / f4;
        f8 = f3;
        f5 = f7;
        f9 = f1;
        f10 = f2;
        f11 = f4;
        f7 = f12;
      }
      else
      {
        k = (int)f6;
        f8 = f3;
        f5 = f7;
        f9 = f1;
        f10 = f2;
        f11 = f4;
        f7 = f12;
        if (k % 8 != 0)
        {
          f6 = k * k / ((k / 8 + 1) * 8);
          f5 = f6 / f13;
          f7 = f12;
          f11 = f4;
          f10 = f2;
          f9 = f1;
          f8 = f3;
        }
      }
      f3 = this.mScale;
      f1 = f8 * f3 + this.mPivotX * (1.0F - f3);
      f2 = f9 * f3 + this.mPivotY * (1.0F - f3);
      float f4 = f10 * f3;
      f3 = f11 * f3;
      if (!this.mDragging)
      {
        k = this.mPosition;
        if (k != 0)
        {
          if ((k & 0x3) == 3) {
            this.mOffsetX = (i / 2 - (f4 / 2.0F + f1));
          } else if ((k & 0x1) == 1) {
            this.mOffsetX = (-f1);
          } else if ((k & 0x2) == 2) {
            this.mOffsetX = (i - f4 - f1);
          }
          k = this.mPosition;
          if ((k & 0xC) == 12) {
            this.mOffsetY = (j / 2 - (f3 / 2.0F + f2));
          }
          for (;;)
          {
            break;
            if ((k & 0x4) == 4) {
              this.mOffsetY = (-f2);
            } else if ((k & 0x8) == 8) {
              this.mOffsetY = (j - f3 - f2);
            }
          }
          this.mPosition = 0;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("render uin: ");
            ((StringBuilder)localObject).append(this.mIdentifier);
            ((StringBuilder)localObject).append(", mVideoSrcType: ");
            ((StringBuilder)localObject).append(this.mVideoSrcType);
            ((StringBuilder)localObject).append(", width: ");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append(", height: ");
            ((StringBuilder)localObject).append(j);
            ((StringBuilder)localObject).append(", mScale: ");
            ((StringBuilder)localObject).append(this.mScale);
            ((StringBuilder)localObject).append(", mPivotX: ");
            ((StringBuilder)localObject).append(this.mPivotX);
            ((StringBuilder)localObject).append(", mPivotY: ");
            ((StringBuilder)localObject).append(this.mPivotY);
            ((StringBuilder)localObject).append(", x: ");
            ((StringBuilder)localObject).append(f1);
            ((StringBuilder)localObject).append(", y: ");
            ((StringBuilder)localObject).append(f2);
            ((StringBuilder)localObject).append(", w: ");
            ((StringBuilder)localObject).append(f4);
            ((StringBuilder)localObject).append(", h: ");
            ((StringBuilder)localObject).append(f3);
            ((StringBuilder)localObject).append(", mOffsetX: ");
            ((StringBuilder)localObject).append(this.mOffsetX);
            ((StringBuilder)localObject).append(", mOffsetY: ");
            ((StringBuilder)localObject).append(this.mOffsetY);
            ((StringBuilder)localObject).append(", mWidth: ");
            ((StringBuilder)localObject).append(this.mWidth);
            ((StringBuilder)localObject).append(", mHeight: ");
            ((StringBuilder)localObject).append(this.mHeight);
            QLog.d("GLVideoView", 0, ((StringBuilder)localObject).toString());
          }
        }
      }
      float f8 = this.mOffsetX;
      float f9 = this.mOffsetY;
      this.mX = ((int)(f1 + f8));
      this.mY = ((int)(f2 + f9));
      this.mWidth = ((int)f4);
      this.mHeight = ((int)f3);
      if (f13 > f7)
      {
        f2 = f7 * f5;
        f1 = f2;
        if (this.mGlVersion == 1) {
          f1 = f2 * f6 / Utils.nextPowerOf2((int)f6);
        }
        f2 = (f6 - f1) / 2.0F;
        this.mYuvTexture.setSourceSize((int)f1, (int)f5);
        this.mYuvTexture.setSourceLeft((int)f2);
        this.mYuvTexture.setSourceTop(0);
      }
      else
      {
        f2 = f6 / f7;
        f1 = f2;
        if (this.mGlVersion == 1) {
          f1 = f2 * f5 / Utils.nextPowerOf2((int)f5);
        }
        f2 = (f5 - f1) / 2.0F;
        this.mYuvTexture.setSourceSize((int)f6, (int)f1);
        this.mYuvTexture.setSourceLeft(0);
        this.mYuvTexture.setSourceTop((int)f2);
      }
      if (this.mGlVersion == 1)
      {
        this.mYuvTexture.setSourceSize((int)f6, (int)f5);
        this.mYuvTexture.setSourceLeft(0);
        this.mYuvTexture.setSourceTop((int)0.0F);
      }
      paramGLCanvas.save(2);
      i = getWidth() / 2;
      j = getHeight() / 2;
      paramGLCanvas.translate(i, j);
      if (this.mMirror) {
        if (this.mRotation % 2 == 0) {
          paramGLCanvas.scale(-1.0F, 1.0F, 1.0F);
        } else {
          paramGLCanvas.scale(1.0F, -1.0F, 1.0F);
        }
      }
      paramGLCanvas.rotate(m * 90, 0.0F, 0.0F, 1.0F);
      if (n != 0) {
        paramGLCanvas.translate(-j, -i);
      } else {
        paramGLCanvas.translate(-i, -j);
      }
      this.mYuvTexture.draw(paramGLCanvas, this.mX, this.mY, this.mWidth, this.mHeight);
      paramGLCanvas.restore();
    }
    if ((this.mLoading) && (this.mLoadingTexture != null))
    {
      this.mLoadingAngle %= 360;
      k = getWidth();
      m = getHeight();
      i = this.mLoadingTexture.getSourceWidth();
      j = this.mLoadingTexture.getSourceHeight();
      if (i > k) {
        i = k;
      }
      if (j > m) {
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
      if (i > k) {
        i = k;
      }
      if (j > m) {
        j = m;
      }
      n = j + 10;
      paramGLCanvas.fillRect(0.0F, m - n, k, n, this.mTextBackgroudColor);
      this.mStringTexture.draw(paramGLCanvas, k / 2 - i / 2, m - j, i, j);
    }
  }
  
  public void setMirror(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMirror uin: ");
      localStringBuilder.append(this.mIdentifier);
      localStringBuilder.append(", mVideoSrcType: ");
      localStringBuilder.append(this.mVideoSrcType);
      localStringBuilder.append(", mMirror: ");
      localStringBuilder.append(this.mMirror);
      localStringBuilder.append(", mirror: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("GLVideoView", 0, localStringBuilder.toString());
    }
    if (this.mMirror != paramBoolean)
    {
      this.mMirror = paramBoolean;
      invalidate();
    }
  }
  
  public void setRender(String paramString, int paramInt)
  {
    if ((paramString != null) && (paramInt != 0))
    {
      this.mIdentifier = paramString;
      this.mVideoSrcType = paramInt;
      paramString = new StringBuilder();
      paramString.append(this.mIdentifier);
      paramString.append("_");
      paramString.append(this.mVideoSrcType);
      paramString = paramString.toString();
      if (this.mYuvTexture == null) {
        Log.e("GLVideoView", "null == mYuvTexture");
      }
      this.mGraphicRenderMgr.setGlRender(paramString, this.mYuvTexture);
      this.mScale = 1.0F;
      this.mPivotX = 0;
      this.mPivotY = 0;
      this.mOffsetX = 0.0F;
      this.mOffsetY = 0.0F;
      return;
    }
    this.mIdentifier = null;
    this.mVideoSrcType = 0;
  }
  
  public void setRotation(int paramInt)
  {
    paramInt %= 360;
    if (paramInt != 90)
    {
      if (paramInt != 180)
      {
        if (paramInt != 270) {
          paramInt = 0;
        } else {
          paramInt = 1;
        }
      }
      else {
        paramInt = 2;
      }
    }
    else {
      paramInt = 3;
    }
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
  }
  
  public void setScale(float paramFloat, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setScale uin: ");
      localStringBuilder.append(this.mIdentifier);
      localStringBuilder.append(", mVideoSrcType: ");
      localStringBuilder.append(this.mVideoSrcType);
      localStringBuilder.append(", scale: ");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(", x: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", y: ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", isEnd: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", mOffsetX: ");
      localStringBuilder.append(this.mOffsetX);
      localStringBuilder.append(", mOffsetY: ");
      localStringBuilder.append(this.mOffsetY);
      localStringBuilder.append(", mX: ");
      localStringBuilder.append(this.mX);
      localStringBuilder.append(", mY: ");
      localStringBuilder.append(this.mY);
      localStringBuilder.append(", mWidth: ");
      localStringBuilder.append(this.mWidth);
      localStringBuilder.append(", mHeight: ");
      localStringBuilder.append(this.mHeight);
      QLog.d("GLVideoView", 0, localStringBuilder.toString());
    }
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
      if (f2 <= 4.0F) {
        break label353;
      }
      this.mPosition = 0;
      this.mPosition |= 0x1;
      this.mPosition |= 0x4;
    }
    else
    {
      if (paramFloat < 0.75F)
      {
        f1 = 0.75F;
        break label353;
      }
      f1 = paramFloat;
      if (paramFloat <= 4.0F) {
        break label353;
      }
    }
    float f1 = 4.0F;
    label353:
    int j = paramInt1;
    int i = paramInt2;
    if (this.mRotation % 2 != 0)
    {
      i = paramInt1;
      j = paramInt2;
    }
    this.mScale = f1;
    this.mPivotX = j;
    this.mPivotY = i;
    invalidate();
  }
  
  public void setText(String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setText uin: ");
      ((StringBuilder)localObject).append(this.mIdentifier);
      ((StringBuilder)localObject).append(", mVideoSrcType: ");
      ((StringBuilder)localObject).append(this.mVideoSrcType);
      ((StringBuilder)localObject).append(", text: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", textSize: ");
      ((StringBuilder)localObject).append(paramFloat);
      ((StringBuilder)localObject).append(", color: ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("GLVideoView", 0, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mStringTexture;
    if (localObject != null)
    {
      ((StringTexture)localObject).recycle();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.opengl.ui.GLVideoView
 * JD-Core Version:    0.7.0.1
 */