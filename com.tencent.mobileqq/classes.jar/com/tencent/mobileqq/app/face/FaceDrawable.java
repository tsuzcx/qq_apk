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
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.avatar.utils.AvatarUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.util.AsynLoadDrawable;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public abstract class FaceDrawable
  extends AsynLoadDrawable
  implements DecodeCompletionListener
{
  private static final int AVATAR_SQUARE_RADIUS = 10;
  private static final String TAG = "Q.qqhead.FaceDrawable";
  boolean isSupportMaskView = false;
  boolean mCancelled;
  FaceInfo mFaceInfo;
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
    if ((paramInt1 != 101) && (paramInt1 != 1001)) {
      break label62;
    }
    paramInt3 = 3;
    label62:
    this.mFaceInfo = new FaceInfo(paramInt1, paramString, false, paramByte, AvatarUtil.a((byte)paramInt3), paramBoolean1, paramInt2, paramBoolean2, paramInt4);
    if ((paramInt1 == 4) && (!((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).hasSetTroopHead(paramString))) {
      this.mFaceInfo.b = 113;
    }
    if ((this instanceof NearByFaceDrawable)) {
      paramAppInterface = getBitmapFromCache();
    } else {
      paramAppInterface = getBitmapFromCache(true);
    }
    if (paramAppInterface != null)
    {
      this.mCurState = 1;
      this.mLoadedDrawable = new BitmapDrawable(BaseApplication.getContext().getResources(), paramAppInterface);
      this.mLoadedDrawable.setVisible(isVisible(), true);
      this.mLoadedDrawable.setBounds(getBounds());
    }
    else
    {
      this.mCurState = 0;
      requestDecode();
    }
    paramAppInterface = this.mListener;
    if (paramAppInterface != null) {
      paramAppInterface.onLoadingStateChanged(-1, this.mCurState);
    }
    this.mMaskPaint = new Paint();
    this.mMaskPaint.setAntiAlias(true);
    this.mMaskPaint.setColor(ThemeUtil.NIGHTMODE_MASKCOLOR);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("time cost FaceDrawable:");
      paramAppInterface.append(l2 - l1);
      QLog.i("Q.qqhead.FaceDrawable", 2, paramAppInterface.toString());
    }
  }
  
  public static Drawable getDefaultDrawable(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 4) {
      return ((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).getDefaultTroopFaceDrawable();
    }
    if ((paramInt1 != 113) && (paramInt1 != 101) && (paramInt1 != 1001))
    {
      if (paramInt1 == 115) {
        return ((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).getDefaultFaceDrawable(true);
      }
      if (paramInt2 == 1) {
        return new ColorDrawable(Color.parseColor("#ebe9e9"));
      }
      return ((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).getDefaultFaceDrawable(true);
    }
    return ((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).getDefaultDiscusionFaceDrawable();
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
    if ((!TextUtils.isEmpty(paramString)) && (paramAppInterface != null))
    {
      if ("module_nearby".equals(paramAppInterface.getModuleId())) {
        return new NearByFaceDrawable(paramAppInterface, paramInt1, 200, paramString, (byte)1, paramInt2, false, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean);
      }
      return new FaceDrawableImpl(paramAppInterface, paramInt1, 200, paramString, (byte)0, paramInt2, 100, false, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean);
    }
    if (QLog.isColorLevel())
    {
      paramDrawable1 = new StringBuilder();
      paramDrawable1.append("getFaceDrawable fail, uin=");
      paramDrawable1.append(paramString);
      paramDrawable1.append(", type=");
      paramDrawable1.append(paramInt1);
      paramDrawable1.append(",appIntf=");
      paramDrawable1.append(paramAppInterface);
      QLog.i("Q.qqhead.FaceDrawable", 2, paramDrawable1.toString());
    }
    return null;
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
    if (paramInt == 115) {
      return 4;
    }
    return 3;
  }
  
  public static FaceDrawable getMobileFaceDrawable(AppInterface paramAppInterface, String paramString, byte paramByte)
  {
    Drawable localDrawable = getDefaultDrawable(11, paramByte);
    return getFaceDrawable(paramAppInterface, 11, paramString, paramByte, localDrawable, localDrawable);
  }
  
  public static String getOpenIdUrl(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://q.qlogo.cn/qqapp/");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("/100");
    return localStringBuilder.toString();
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
    if ((!TextUtils.isEmpty(paramString)) && (paramAppInterface != null))
    {
      Drawable localDrawable = getDefaultDrawable(32, paramInt2);
      if ("module_nearby".equals(paramAppInterface.getModuleId())) {
        return new NearByFaceDrawable(paramAppInterface, 32, paramInt1, paramString, (byte)1, paramInt2, true, localDrawable, localDrawable, paramOnLoadingStateChangeListener, paramBoolean);
      }
      return new FaceDrawableImpl(paramAppInterface, 32, paramInt1, paramString, (byte)1, paramInt2, 100, true, localDrawable, localDrawable, paramOnLoadingStateChangeListener, paramBoolean);
    }
    if (QLog.isColorLevel())
    {
      paramOnLoadingStateChangeListener = new StringBuilder();
      paramOnLoadingStateChangeListener.append("getFaceDrawable fail, uin=");
      paramOnLoadingStateChangeListener.append(paramString);
      paramOnLoadingStateChangeListener.append(", idType=");
      paramOnLoadingStateChangeListener.append(paramInt1);
      paramOnLoadingStateChangeListener.append(",appIntf=");
      paramOnLoadingStateChangeListener.append(paramAppInterface);
      paramOnLoadingStateChangeListener.append(",shape=");
      paramOnLoadingStateChangeListener.append(paramInt2);
      QLog.i("Q.qqhead.FaceDrawable", 2, paramOnLoadingStateChangeListener.toString());
    }
    return null;
  }
  
  public static FaceDrawable getStrangerFaceDrawable(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramString)) && (paramAppInterface != null))
    {
      localObject = getDefaultDrawable(32, paramInt2);
      if ("module_nearby".equals(paramAppInterface.getModuleId())) {
        return new NearByFaceDrawable(paramAppInterface, 32, paramInt1, paramString, (byte)1, paramInt2, true, (Drawable)localObject, (Drawable)localObject, null, paramBoolean);
      }
      return new FaceDrawableImpl(paramAppInterface, 32, paramInt1, paramString, (byte)1, paramInt2, 100, true, (Drawable)localObject, (Drawable)localObject, null, paramBoolean);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFaceDrawable fail, uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", idType=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",appIntf=");
      ((StringBuilder)localObject).append(paramAppInterface);
      ((StringBuilder)localObject).append(",shape=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("Q.qqhead.FaceDrawable", 2, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public static FaceDrawable getStrangerFaceDrawable(AppInterface paramAppInterface, int paramInt, String paramString, boolean paramBoolean)
  {
    return getStrangerFaceDrawable(paramAppInterface, paramInt, paramString, paramBoolean, false);
  }
  
  public static FaceDrawable getStrangerFaceDrawable(AppInterface paramAppInterface, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramString)) && (paramAppInterface != null))
    {
      localObject = getDefaultDrawable(32, 3);
      if ("module_nearby".equals(paramAppInterface.getModuleId())) {
        return new NearByFaceDrawable(paramAppInterface, 32, paramInt, paramString, (byte)1, 3, paramBoolean1, (Drawable)localObject, (Drawable)localObject, null, paramBoolean2);
      }
      return new FaceDrawableImpl(paramAppInterface, 32, paramInt, paramString, (byte)1, 3, 100, paramBoolean1, (Drawable)localObject, (Drawable)localObject, null, paramBoolean2);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFaceDrawable fail, uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", idType=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",appIntf=");
      ((StringBuilder)localObject).append(paramAppInterface);
      QLog.i("Q.qqhead.FaceDrawable", 2, ((StringBuilder)localObject).toString());
    }
    return null;
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
    if ((this.isSupportMaskView) && (ThemeUtil.isNowThemeIsNight(null, false, null)))
    {
      this.tempRectF.set(getBounds());
      Object localObject = this.mFaceInfo;
      if ((localObject != null) && (((FaceInfo)localObject).e == 1))
      {
        super.draw(paramCanvas);
        paramCanvas.drawRoundRect(this.tempRectF, 10.0F, 10.0F, this.mMaskPaint);
        return;
      }
      super.draw(paramCanvas);
      localObject = this.tempRectF;
      paramCanvas.drawRoundRect((RectF)localObject, ((RectF)localObject).centerX(), this.tempRectF.centerY(), this.mMaskPaint);
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDecodeTaskCompleted.faceInfo=");
      ((StringBuilder)localObject).append(paramFaceInfo);
      ((StringBuilder)localObject).append(", avatrar=");
      ((StringBuilder)localObject).append(paramBitmap);
      QLog.i("Q.qqhead.FaceDrawable", 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.mCancelled) && (paramFaceInfo != null))
    {
      localObject = this.mFaceInfo;
      if (localObject != null)
      {
        if (!paramFaceInfo.equals(localObject)) {
          return;
        }
        paramFaceInfo = null;
        int j = 0;
        if (paramBitmap != null) {
          paramFaceInfo = new BitmapDrawable(BaseApplication.getContext().getResources(), paramBitmap);
        }
        if (paramFaceInfo != null) {
          this.mLoadedDrawable = paramFaceInfo;
        }
        do
        {
          i = 1;
          break;
          i = j;
          if (this.mLoadedDrawable != null) {
            break;
          }
          i = j;
        } while (this.mCurState != 2);
        if (i == 0) {
          return;
        }
        int i = this.mCurState;
        if (this.mLoadedDrawable != null)
        {
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
        else
        {
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
        invalidateSelf();
        if (i != this.mCurState)
        {
          paramFaceInfo = this.mListener;
          if (paramFaceInfo != null) {
            paramFaceInfo.onLoadingStateChanged(i, this.mCurState);
          }
        }
      }
    }
  }
  
  public void onDecodeTaskCompletedNeedDownload(AppInterface paramAppInterface, FaceInfo paramFaceInfo)
  {
    if ((!this.mCancelled) && (paramFaceInfo != null))
    {
      paramAppInterface = this.mFaceInfo;
      if (paramAppInterface != null)
      {
        if (!paramFaceInfo.equals(paramAppInterface)) {
          return;
        }
        onNeedDownload();
      }
    }
  }
  
  protected abstract void onNeedDownload();
  
  protected abstract boolean requestDecode();
  
  protected abstract void setApp(AppInterface paramAppInterface);
  
  public void setSupportMaskView(boolean paramBoolean)
  {
    this.isSupportMaskView = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDrawable
 * JD-Core Version:    0.7.0.1
 */