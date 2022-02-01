package com.tencent.mobileqq.app.face;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import anho;
import anhx;
import bfvo;
import bjuk;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.AsynLoadDrawable;
import com.tencent.qphone.base.util.QLog;

public abstract class FaceDrawable
  extends AsynLoadDrawable
  implements FaceDecodeTask.DecodeCompletionListener
{
  private static final String TAG = "Q.qqhead.FaceDrawable";
  boolean isSupportMaskView = false;
  public boolean mCancelled;
  public FaceInfo mFaceInfo;
  FaceDrawable.OnLoadingStateChangeListener mListener;
  Paint mMaskPaint;
  RectF tempRectF = new RectF();
  
  protected FaceDrawable()
  {
    super(null, null);
  }
  
  protected FaceDrawable(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, int paramInt4, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener, boolean paramBoolean2)
  {
    super(paramDrawable1, paramDrawable2);
    long l1 = System.currentTimeMillis();
    setApp(paramAppInterface);
    this.mListener = paramOnLoadingStateChangeListener;
    if ((paramInt1 == 101) || (paramInt1 == 1001)) {
      paramInt3 = 3;
    }
    this.mFaceInfo = new FaceInfo(paramInt1, paramString, false, paramByte, anho.a((byte)paramInt3), paramBoolean1, paramInt2, paramBoolean2, paramInt4);
    if ((paramInt1 == 4) && (!TroopUtils.hasSetTroopHead(paramString))) {
      this.mFaceInfo.a = 113;
    }
    if ((this instanceof anhx))
    {
      paramAppInterface = getBitmapFromCache();
      if (paramAppInterface == null) {
        break label271;
      }
      this.mCurState = 1;
      this.mLoadedDrawable = new BitmapDrawable(BaseApplicationImpl.getApplication().getResources(), paramAppInterface);
      this.mLoadedDrawable.setVisible(isVisible(), true);
      this.mLoadedDrawable.setBounds(getBounds());
    }
    for (;;)
    {
      if (this.mListener != null) {
        this.mListener.onLoadingStateChanged(-1, this.mCurState);
      }
      this.mMaskPaint = new Paint();
      this.mMaskPaint.setAntiAlias(true);
      this.mMaskPaint.setColor(ThemeUtil.NIGHTMODE_MASKCOLOR);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawable", 2, "time cost FaceDrawable:" + (l2 - l1));
      }
      return;
      paramAppInterface = getBitmapFromCache(true);
      break;
      label271:
      this.mCurState = 0;
      requestDecode();
    }
  }
  
  public static Drawable getDefaultDrawable(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 4) {
      return bfvo.c();
    }
    if ((paramInt1 == 113) || (paramInt1 == 101) || (paramInt1 == 1001)) {
      return bfvo.e();
    }
    if (paramInt1 == 115) {
      return bfvo.a(true);
    }
    if (paramInt2 == 1) {
      return new ColorDrawable(Color.parseColor("#ebe9e9"));
    }
    return bfvo.b();
  }
  
  public static FaceDrawable getFaceDrawable(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString)
  {
    Drawable localDrawable = getDefaultDrawable(paramInt1, paramInt2);
    return getFaceDrawable(paramAppInterface, paramInt1, paramString, paramInt2, localDrawable, localDrawable);
  }
  
  public static FaceDrawable getFaceDrawable(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    int i = getFaceShapeType(paramInt);
    Drawable localDrawable = getDefaultDrawable(paramInt, i);
    return getFaceDrawable(paramAppInterface, paramInt, paramString, i, localDrawable, localDrawable);
  }
  
  public static FaceDrawable getFaceDrawable(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return getFaceDrawable(paramAppInterface, paramInt1, paramString, paramInt2, paramDrawable1, paramDrawable2, null);
  }
  
  public static FaceDrawable getFaceDrawable(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener)
  {
    return getFaceDrawable(paramAppInterface, paramInt1, paramString, paramInt2, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, false);
  }
  
  public static FaceDrawable getFaceDrawable(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawable", 2, "getFaceDrawable fail, uin=" + paramString + ", type=" + paramInt1 + ",appIntf=" + paramAppInterface);
      }
    }
    do
    {
      return null;
      if ((paramAppInterface instanceof QQAppInterface)) {
        return new FaceDrawableImpl(paramAppInterface, paramInt1, 200, paramString, (byte)0, paramInt2, 100, false, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean);
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    return new anhx(paramAppInterface, paramInt1, 200, paramString, (byte)1, paramInt2, false, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean);
  }
  
  public static FaceDrawable getFaceDrawableFrom(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    int i = getFaceShapeType(paramInt1);
    Drawable localDrawable = getDefaultDrawable(paramInt1, i);
    return getFaceDrawableFrom(paramAppInterface, paramInt1, paramString, i, localDrawable, localDrawable, paramInt2);
  }
  
  public static FaceDrawable getFaceDrawableFrom(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, int paramInt3)
  {
    return getFaceDrawable(paramAppInterface, paramInt1, paramString, paramInt2, paramDrawable1, paramDrawable2, null);
  }
  
  private static byte getFaceShapeType(int paramInt)
  {
    byte b = 3;
    if (paramInt == 115) {
      b = 4;
    }
    return b;
  }
  
  public static FaceDrawable getMobileFaceDrawable(AppInterface paramAppInterface, String paramString, byte paramByte)
  {
    Drawable localDrawable = getDefaultDrawable(11, paramByte);
    return getFaceDrawable(paramAppInterface, 11, paramString, paramByte, localDrawable, localDrawable);
  }
  
  public static String getOpenIdUrl(String paramString1, String paramString2)
  {
    return "https://q.qlogo.cn/qqapp/" + paramString2 + "/" + paramString1 + "/100";
  }
  
  public static FaceDrawable getStrangerFaceDrawable(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    return getStrangerFaceDrawable(paramAppInterface, paramInt1, paramString, paramInt2, false);
  }
  
  public static FaceDrawable getStrangerFaceDrawable(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener)
  {
    return getStrangerFaceDrawable(paramAppInterface, paramInt1, paramString, paramInt2, paramOnLoadingStateChangeListener, false);
  }
  
  public static FaceDrawable getStrangerFaceDrawable(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawable", 2, "getFaceDrawable fail, uin=" + paramString + ", idType=" + paramInt1 + ",appIntf=" + paramAppInterface + ",shape=" + paramInt2);
      }
    }
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = getDefaultDrawable(32, paramInt2);
      if ((paramAppInterface instanceof QQAppInterface)) {
        return new FaceDrawableImpl(paramAppInterface, 32, paramInt1, paramString, (byte)1, paramInt2, 100, true, localDrawable, localDrawable, paramOnLoadingStateChangeListener, paramBoolean);
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    return new anhx(paramAppInterface, 32, paramInt1, paramString, (byte)1, paramInt2, true, localDrawable, localDrawable, paramOnLoadingStateChangeListener, paramBoolean);
  }
  
  public static FaceDrawable getStrangerFaceDrawable(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawable", 2, "getFaceDrawable fail, uin=" + paramString + ", idType=" + paramInt1 + ",appIntf=" + paramAppInterface + ",shape=" + paramInt2);
      }
    }
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = getDefaultDrawable(32, paramInt2);
      if ((paramAppInterface instanceof QQAppInterface)) {
        return new FaceDrawableImpl(paramAppInterface, 32, paramInt1, paramString, (byte)1, paramInt2, 100, true, localDrawable, localDrawable, null, paramBoolean);
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    return new anhx(paramAppInterface, 32, paramInt1, paramString, (byte)1, paramInt2, true, localDrawable, localDrawable, null, paramBoolean);
  }
  
  public static FaceDrawable getStrangerFaceDrawable(AppInterface paramAppInterface, int paramInt, String paramString, boolean paramBoolean)
  {
    return getStrangerFaceDrawable(paramAppInterface, paramInt, paramString, paramBoolean, false);
  }
  
  public static FaceDrawable getStrangerFaceDrawable(AppInterface paramAppInterface, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawable", 2, "getFaceDrawable fail, uin=" + paramString + ", idType=" + paramInt + ",appIntf=" + paramAppInterface);
      }
    }
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = getDefaultDrawable(32, 3);
      if ((paramAppInterface instanceof QQAppInterface)) {
        return new FaceDrawableImpl(paramAppInterface, 32, paramInt, paramString, (byte)1, 3, 100, paramBoolean1, localDrawable, localDrawable, null, paramBoolean2);
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    return new anhx(paramAppInterface, 32, paramInt, paramString, (byte)1, 3, paramBoolean1, localDrawable, localDrawable, null, paramBoolean2);
  }
  
  public static FaceDrawable getUserFaceDrawable(AppInterface paramAppInterface, String paramString, byte paramByte)
  {
    Drawable localDrawable = getDefaultDrawable(1, paramByte);
    return getFaceDrawable(paramAppInterface, 1, paramString, paramByte, localDrawable, localDrawable);
  }
  
  public void cancel()
  {
    if (!this.mCancelled)
    {
      this.mCancelled = true;
      this.mFaceInfo = null;
      this.mFailureDrawable = null;
      this.mLoadedDrawable = null;
      this.mLoadingDrawable = null;
      setCallback(null);
      this.mListener = null;
      setApp(null);
    }
    super.cancel();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.isSupportMaskView) && (bjuk.a()))
    {
      this.tempRectF.set(getBounds());
      if ((this.mFaceInfo != null) && (this.mFaceInfo.c == 1))
      {
        super.draw(paramCanvas);
        paramCanvas.drawRoundRect(this.tempRectF, 10.0F, 10.0F, this.mMaskPaint);
        return;
      }
      super.draw(paramCanvas);
      paramCanvas.drawRoundRect(this.tempRectF, this.tempRectF.centerX(), this.tempRectF.centerY(), this.mMaskPaint);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected abstract Bitmap getBitmapFromCache();
  
  protected abstract Bitmap getBitmapFromCache(boolean paramBoolean);
  
  public Drawable getDefaultDrawable()
  {
    return getDefaultDrawable(1, 3);
  }
  
  public void onDecodeTaskCompleted(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDrawable", 2, "onDecodeTaskCompleted.faceInfo=" + paramFaceInfo + ", avatrar=" + paramBitmap);
    }
    if ((this.mCancelled) || (paramFaceInfo == null) || (this.mFaceInfo == null) || (!paramFaceInfo.equals(this.mFaceInfo))) {
      return;
    }
    paramFaceInfo = null;
    int j = 0;
    if (paramBitmap != null) {
      paramFaceInfo = new BitmapDrawable(BaseApplicationImpl.getApplication().getResources(), paramBitmap);
    }
    int i;
    if (paramFaceInfo != null)
    {
      this.mLoadedDrawable = paramFaceInfo;
      i = 1;
      label107:
      if (i == 0) {
        break label247;
      }
      i = this.mCurState;
      if (this.mLoadedDrawable == null) {
        break label249;
      }
      this.mCurState = 1;
      if (this.mAlpha != -1) {
        this.mLoadedDrawable.setAlpha(this.mAlpha);
      }
      if (this.mColorFilter != null) {
        this.mLoadedDrawable.setColorFilter(this.mColorFilter);
      }
      this.mLoadedDrawable.setVisible(isVisible(), true);
      this.mLoadedDrawable.setBounds(getBounds());
    }
    for (;;)
    {
      invalidateSelf();
      if ((i == this.mCurState) || (this.mListener == null)) {
        break;
      }
      this.mListener.onLoadingStateChanged(i, this.mCurState);
      return;
      i = j;
      if (this.mLoadedDrawable != null) {
        break label107;
      }
      i = j;
      if (this.mCurState == 2) {
        break label107;
      }
      i = 1;
      break label107;
      label247:
      break;
      label249:
      this.mCurState = 2;
      if (this.mFailureDrawable != null)
      {
        if (this.mAlpha != -1) {
          this.mFailureDrawable.setAlpha(this.mAlpha);
        }
        if (this.mColorFilter != null) {
          this.mFailureDrawable.setColorFilter(this.mColorFilter);
        }
        this.mFailureDrawable.setVisible(isVisible(), true);
        this.mFailureDrawable.setBounds(getBounds());
      }
    }
  }
  
  public void onDecodeTaskCompletedNeedDownload(AppInterface paramAppInterface, FaceInfo paramFaceInfo)
  {
    if ((this.mCancelled) || (paramFaceInfo == null) || (this.mFaceInfo == null) || (!paramFaceInfo.equals(this.mFaceInfo))) {
      return;
    }
    onNeedDownload();
  }
  
  protected abstract void onNeedDownload();
  
  protected abstract boolean requestDecode();
  
  protected abstract void setApp(AppInterface paramAppInterface);
  
  public void setSupportMaskView(boolean paramBoolean)
  {
    this.isSupportMaskView = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDrawable
 * JD-Core Version:    0.7.0.1
 */