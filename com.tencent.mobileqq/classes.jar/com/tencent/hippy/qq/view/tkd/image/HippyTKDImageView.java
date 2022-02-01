package com.tencent.hippy.qq.view.tkd.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDSkinHandler;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDSkinHandler.HippyQBCommonSkin;
import com.tencent.hippy.qq.view.tkd.listview.ResourceUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.RenderManager;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.utils.UrlUtils;
import com.tencent.mtt.hippy.views.common.CommonBackgroundDrawable;
import com.tencent.mtt.hippy.views.image.HippyImageView;
import com.tencent.mtt.supportui.adapters.image.IDrawableTarget;
import com.tencent.mtt.supportui.views.asyncimage.BackgroundDrawable;
import com.tencent.mtt.supportui.views.asyncimage.ContentDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class HippyTKDImageView
  extends HippyImageView
  implements HippyTKDCommonBorderHandler.HippyQBCommonBorder, HippyTKDSkinHandler.HippyQBCommonSkin, GaussianBlurListener
{
  public static final String EXTRA_BUSINESS_NAME = "businessname";
  public static final String EXTRA_ICONTROLLER = "IController";
  public static final String EXTRA_REPORTDATA_NAME = "reportdata";
  public static final String EXTRA_REQUEST_GIF_ENABLED = "gifEnabled";
  public static final String EXTRA_REQUEST_LEVLE = "RequestLevel";
  public static final String EXTRA_REQUEST_USE_DNS_PARSE = "useDNSParse";
  public static final String EXTRA_REQUEST_USE_THUMBNAIL = "useThumbnail";
  public static final String EXTRA_REQUEST_VIEW_HEIGHT = "viewHeight";
  public static final String EXTRA_REQUEST_VIEW_WIDTH = "viewWidth";
  private static final int FILE_DESCRIPTOR = 7;
  public static final int MAX_RETRYCOUNTS = 2;
  public static final int NIGHT_MODE_MASK_COLOR = -2147483648;
  public static final long RETRY_INTERVAL = 2000L;
  private Bitmap mBlurBitmap = null;
  private String mBlurBitmapKey = null;
  int mBlurRadius;
  private String mBusinessName = "";
  private int mClipBgColor = 0;
  private HippyMap mClipInfoMap = null;
  boolean mEnableCacheImg;
  boolean mEnableLoadingImg;
  boolean mEnableNoPicMode;
  Path mFeedsClipPath = new Path();
  private boolean mFeedsNeedClip = false;
  boolean mFitSystemRotation;
  private boolean mGifEnabled;
  private HippyEngineContext mHippyContext;
  HippyTKDSkinHandler mHippyTKDSkinHandler;
  private HippyMap mInitPropMap;
  private long mLastTriggerTime;
  private boolean mReported = false;
  protected boolean mRequestUseDnsParse;
  private int mRetryCounts;
  private Bitmap mRotationBitmap = null;
  private String mRotationBitmapKey = null;
  private String mSourceFrom = "";
  HippyArray mSources;
  private long mStartFetchTime;
  HippyArray mTintColors;
  boolean mUseNightModeMask;
  private boolean mUseThumbnail;
  
  public HippyTKDImageView(Context paramContext)
  {
    super(paramContext);
    setFocusable(true);
    init();
    this.mHippyContext = ((HippyInstanceContext)paramContext).getEngineContext();
  }
  
  public HippyTKDImageView(Context paramContext, String paramString)
  {
    super(paramContext);
    this.mBusinessName = paramString;
    setFocusable(true);
    init();
    this.mHippyContext = ((HippyInstanceContext)paramContext).getEngineContext();
  }
  
  private float getBlurRate(int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = (float)Math.sqrt(paramInt3);
    float f2 = paramInt1;
    if (f1 > f2) {
      f1 = f2;
    }
    float f3 = paramInt2;
    f2 = f1;
    if (f1 > f3) {
      f2 = f3;
    }
    return f2;
  }
  
  public static int getPicOrientation(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      if (i != 3)
      {
        if (i != 6)
        {
          if (i != 8) {
            return 0;
          }
          return 270;
        }
        return 90;
      }
      return 180;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private void resetRetry()
  {
    this.mRetryCounts = 0;
    this.mLastTriggerTime = 0L;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected Bitmap getBitmap()
  {
    if (this.mBlurRadius > 0) {
      return this.mBlurBitmap;
    }
    if (this.mFitSystemRotation) {
      return this.mRotationBitmap;
    }
    return super.getBitmap();
  }
  
  public HippyMap getClipInfo()
  {
    return this.mClipInfoMap;
  }
  
  @SuppressLint({"GetContentDescriptionOverride"})
  public CharSequence getContentDescription()
  {
    return super.getContentDescription();
  }
  
  protected Object getFetchParam()
  {
    Object localObject2 = super.getFetchParam();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new HippyMap();
    }
    if ((localObject1 instanceof HippyMap))
    {
      localObject2 = (HippyMap)localObject1;
      if ((!this.mEnableLoadingImg) && (this.mEnableCacheImg)) {
        ((HippyMap)localObject2).pushObject("RequestLevel", new Integer(2));
      } else {
        ((HippyMap)localObject2).pushObject("RequestLevel", new Integer(1));
      }
      if (this.mUseThumbnail)
      {
        localObject3 = this.mHippyContext.getRenderManager().getRenderNode(getId());
        int j = 0;
        int i;
        if (localObject3 != null)
        {
          j = ((RenderNode)localObject3).getWidth();
          i = ((RenderNode)localObject3).getHeight();
        }
        else
        {
          i = 0;
        }
        ((HippyMap)localObject2).pushObject("useThumbnail", Boolean.valueOf(true));
        ((HippyMap)localObject2).pushObject("viewWidth", Integer.valueOf(j));
        ((HippyMap)localObject2).pushObject("viewHeight", Integer.valueOf(i));
      }
      ((HippyMap)localObject2).pushObject("gifEnabled", Boolean.valueOf(this.mGifEnabled));
      ((HippyMap)localObject2).pushObject("reportdata", this.mSourceFrom);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Hippy_");
      ((StringBuilder)localObject3).append(this.mBusinessName);
      ((HippyMap)localObject2).pushObject("businessname", ((StringBuilder)localObject3).toString());
      localObject3 = this.mInitPropMap;
      if (localObject3 != null) {
        ((HippyMap)localObject2).pushJSONObject(((HippyMap)localObject3).toJSONObject());
      }
    }
    return localObject1;
  }
  
  public String getSourceFrom()
  {
    return this.mSourceFrom;
  }
  
  protected void handleGetImageFail(Throwable paramThrowable)
  {
    resetRetry();
    super.handleGetImageFail(paramThrowable);
    onGetImageFailed(this.mUrl, paramThrowable);
  }
  
  protected void handleGetImageStart()
  {
    super.handleGetImageStart();
    this.mStartFetchTime = System.currentTimeMillis();
  }
  
  protected void handleGetImageSuccess()
  {
    super.handleGetImageSuccess();
    resetRetry();
    Object localObject;
    if ((this.mSourceDrawable != null) && ((this.mSourceDrawable.getExtraData() instanceof Map)))
    {
      localObject = ((Map)this.mSourceDrawable.getExtraData()).get("RequestLevel");
      if ((localObject instanceof Integer))
      {
        i = ((Integer)localObject).intValue();
        break label70;
      }
    }
    int i = 1;
    label70:
    String str = this.mUrl;
    if (this.mSourceDrawable != null) {
      localObject = this.mSourceDrawable.getBitmap();
    } else {
      localObject = null;
    }
    onGetImageSuccess(str, (Bitmap)localObject, System.currentTimeMillis() - this.mStartFetchTime, i);
  }
  
  protected void handleNightModeMask()
  {
    HippyArray localHippyArray = this.mTintColors;
    if (localHippyArray != null)
    {
      super.setTintColor(HippyTKDSkinHandler.getColor(localHippyArray));
      return;
    }
    super.setTintColor(this.mTintColor);
  }
  
  public void handleNoPicModeChange() {}
  
  public void hippySwitchSkin() {}
  
  public void init()
  {
    this.mHippyTKDSkinHandler = new HippyTKDSkinHandler();
    this.mUseNightModeMask = true;
    this.mEnableNoPicMode = true;
    this.mEnableLoadingImg = true;
    this.mEnableCacheImg = true;
    setFadeEnabled(true);
    setFadeDuration(150L);
    this.mRequestUseDnsParse = false;
    this.mFitSystemRotation = false;
    this.mBlurRadius = 0;
    this.mTintColors = null;
    this.mSources = null;
    this.mBlurBitmap = null;
    this.mBlurBitmapKey = null;
    this.mRotationBitmap = null;
    this.mRotationBitmapKey = null;
    resetFadeAnimation();
    this.mStartFetchTime = 0L;
    resetRetry();
  }
  
  protected void onAttachedToWindow()
  {
    if ((!this.mEnableLoadingImg) && (!this.mEnableCacheImg) && (this.mUrl != null) && (UrlUtils.isWebUrl(this.mUrl))) {
      onFetchImage(this.mUrl);
    }
    super.onAttachedToWindow();
  }
  
  protected void onFetchImage(String paramString)
  {
    Drawable localDrawable = getBackground();
    this.mContentDrawable = null;
    this.mBGDrawable = null;
    if ((paramString != null) && ((UrlUtils.isWebUrl(paramString)) || (UrlUtils.isFileUrl(paramString))))
    {
      int i = ResourceUtil.getColor(2131167297);
      if (this.mHippyTKDSkinHandler.getBackgroundColors() != null) {
        i = HippyTKDSkinHandler.getColor(this.mHippyTKDSkinHandler.getBackgroundColors());
      }
      if ((localDrawable instanceof CommonBackgroundDrawable))
      {
        paramString = (CommonBackgroundDrawable)localDrawable;
        paramString.setBackgroundColor(i);
        setCustomBackgroundDrawable(paramString);
      }
      else if ((localDrawable instanceof LayerDrawable))
      {
        paramString = (LayerDrawable)localDrawable;
        if (paramString.getNumberOfLayers() > 0)
        {
          paramString = paramString.getDrawable(0);
          if ((paramString instanceof CommonBackgroundDrawable))
          {
            paramString = (CommonBackgroundDrawable)paramString;
            paramString.setBackgroundColor(i);
            setCustomBackgroundDrawable(paramString);
          }
        }
      }
      setBackgroundColor(i);
      return;
    }
    resetContent();
  }
  
  public void onGaussianBlurComplete(Bitmap paramBitmap, Map paramMap)
  {
    this.mBlurBitmap = paramBitmap;
    post(new HippyTKDImageView.2(this));
  }
  
  public void onGetImageFailed(String paramString, Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return;
    }
    paramThrowable.toString();
  }
  
  public void onGetImageRetry(String paramString, Throwable paramThrowable) {}
  
  public void onGetImageSuccess(String paramString, Bitmap paramBitmap, long paramLong, int paramInt) {}
  
  protected void onSetContent(String paramString)
  {
    super.setBackgroundColor(0);
  }
  
  public void resetProps()
  {
    super.resetProps();
    init();
  }
  
  protected void restoreBackgroundColorAfterSetContent()
  {
    if ((this.mBGDrawable != null) && (this.mHippyTKDSkinHandler.getBackgroundColors() == null)) {
      this.mBGDrawable.setBackgroundColor(0);
    }
  }
  
  public void setBackgroundColors(HippyArray paramHippyArray)
  {
    this.mHippyTKDSkinHandler.setBackgroundColors(this, paramHippyArray);
  }
  
  public void setBlurRadius(int paramInt)
  {
    this.mBlurRadius = paramInt;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setBlurRadius blurRadius:");
      localStringBuilder.append(paramInt);
      QLog.d("hippyImageView", 2, localStringBuilder.toString());
    }
  }
  
  public void setBorderBottomColors(HippyArray paramHippyArray)
  {
    this.mHippyTKDSkinHandler.setBorderBottomColors(this, paramHippyArray);
  }
  
  public void setBorderColors(HippyArray paramHippyArray)
  {
    this.mHippyTKDSkinHandler.setBorderColors(this, paramHippyArray);
  }
  
  public void setBorderLeftColors(HippyArray paramHippyArray)
  {
    this.mHippyTKDSkinHandler.setBorderLeftColors(this, paramHippyArray);
  }
  
  public void setBorderRightColors(HippyArray paramHippyArray)
  {
    this.mHippyTKDSkinHandler.setBorderRightColors(this, paramHippyArray);
  }
  
  public void setBorderTopColors(HippyArray paramHippyArray)
  {
    this.mHippyTKDSkinHandler.setBorderTopColors(this, paramHippyArray);
  }
  
  public void setClipInfo(HippyMap paramHippyMap)
  {
    this.mClipInfoMap = paramHippyMap;
  }
  
  public void setFitSystemRotation(boolean paramBoolean)
  {
    this.mFitSystemRotation = paramBoolean;
  }
  
  public void setGifEnabled(boolean paramBoolean)
  {
    this.mGifEnabled = paramBoolean;
  }
  
  public void setInitProps(HippyMap paramHippyMap)
  {
    super.setInitProps(paramHippyMap);
    this.mInitPropMap = paramHippyMap;
  }
  
  public void setNightModeOption(HippyMap paramHippyMap)
  {
    boolean bool;
    if (paramHippyMap != null) {
      bool = paramHippyMap.getBoolean("enable");
    } else {
      bool = true;
    }
    this.mUseNightModeMask = bool;
    handleNightModeMask();
  }
  
  public void setNoPicModeOption(HippyMap paramHippyMap)
  {
    boolean bool2 = true;
    if (paramHippyMap != null) {
      bool1 = paramHippyMap.getBoolean("enable");
    } else {
      bool1 = true;
    }
    this.mEnableNoPicMode = bool1;
    boolean bool1 = bool2;
    if (!this.mEnableLoadingImg) {
      if (!this.mEnableNoPicMode) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    this.mEnableLoadingImg = bool1;
  }
  
  public void setReportData(HippyMap paramHippyMap)
  {
    if (paramHippyMap != null) {
      paramHippyMap = paramHippyMap.getString("sourceFrom");
    } else {
      paramHippyMap = "";
    }
    this.mSourceFrom = paramHippyMap;
  }
  
  public void setSources(HippyArray paramHippyArray)
  {
    this.mSources = paramHippyArray;
    super.setUrl(HippyTKDSkinHandler.getSource(this.mSources));
  }
  
  public void setTintColors(HippyArray paramHippyArray)
  {
    this.mTintColors = paramHippyArray;
    handleNightModeMask();
  }
  
  public void setUrl(String paramString)
  {
    if (!TextUtils.equals(paramString, this.mUrl)) {
      this.mRequestUseDnsParse = false;
    }
    super.setUrl(paramString);
  }
  
  public void setUseThumbnail(boolean paramBoolean)
  {
    this.mUseThumbnail = paramBoolean;
  }
  
  public void setpointsForCrop(HippyArray paramHippyArray)
  {
    if ((paramHippyArray != null) && (paramHippyArray.size() >= 4))
    {
      this.mFeedsClipPath.reset();
      this.mFeedsClipPath.moveTo(PixelUtil.dp2px(paramHippyArray.getInt(0)), PixelUtil.dp2px(paramHippyArray.getInt(1)));
      int i = 1;
      for (;;)
      {
        int j = i * 2;
        int k = j + 1;
        if (k >= paramHippyArray.size()) {
          break;
        }
        this.mFeedsClipPath.lineTo(PixelUtil.dp2px(paramHippyArray.getInt(j)), PixelUtil.dp2px(paramHippyArray.getInt(k)));
        i += 1;
      }
      this.mFeedsClipPath.close();
      this.mFeedsNeedClip = true;
      return;
    }
    this.mFeedsNeedClip = false;
  }
  
  protected boolean shouldFetchImage()
  {
    if ((!this.mEnableLoadingImg) && (!this.mEnableCacheImg)) {
      return false;
    }
    return super.shouldFetchImage();
  }
  
  protected boolean shouldSetContent()
  {
    Object localObject = this.mSourceDrawable;
    int i1 = 0;
    if (localObject != null)
    {
      localObject = this.mSourceDrawable.getSource();
      if ((localObject != null) && (!((String)localObject).equals(this.mUrl)) && (isAttached())) {
        return false;
      }
    }
    if ((this.mBlurRadius > 0) && (this.mSourceDrawable != null) && (this.mSourceDrawable.getBitmap() != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getUrl());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.mBlurRadius);
      localObject = ((StringBuilder)localObject).toString();
      if (((String)localObject).equals(this.mBlurBitmapKey)) {
        return true;
      }
      this.mBlurBitmapKey = ((String)localObject);
      ThreadManagerV2.excute(new HippyTKDImageView.1(this), 16, null, false);
      return false;
    }
    if ((this.mFitSystemRotation) && (this.mSourceDrawable != null) && (this.mSourceDrawable.getBitmap() != null))
    {
      localObject = getUrl();
      if (((String)localObject).equals(this.mRotationBitmapKey)) {
        return true;
      }
      this.mRotationBitmapKey = ((String)localObject);
      int i;
      if (this.mUrl.startsWith("file://")) {
        i = getPicOrientation(this.mUrl.substring(7));
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localObject = new Matrix();
        int j = this.mSourceDrawable.getBitmap().getWidth();
        int k = this.mSourceDrawable.getBitmap().getHeight();
        int n;
        int m;
        if (i / 90 % 2 != 0)
        {
          n = j;
          m = k;
        }
        else
        {
          m = j;
          n = k;
        }
        RenderNode localRenderNode = this.mHippyContext.getRenderManager().getRenderNode(getId());
        int i2;
        if (localRenderNode != null)
        {
          i1 = localRenderNode.getWidth();
          i2 = localRenderNode.getHeight();
        }
        else
        {
          i2 = 0;
        }
        if ((i1 > 0) && (i2 > 0))
        {
          m = Math.min(m / i1, n / i2);
          if (m > 1)
          {
            float f = 1.0F / m;
            ((Matrix)localObject).postScale(f, f);
          }
        }
        ((Matrix)localObject).postRotate(i);
        this.mRotationBitmap = Bitmap.createBitmap(this.mSourceDrawable.getBitmap(), 0, 0, j, k, (Matrix)localObject, true);
        return true;
      }
      this.mRotationBitmap = this.mSourceDrawable.getBitmap();
      return true;
    }
    return super.shouldSetContent();
  }
  
  protected void updateContentDrawableProperty()
  {
    if (this.mFeedsNeedClip)
    {
      ((ContentDrawable)this.mContentDrawable).mSelfClipPath = this.mFeedsClipPath;
      setLayerType(1, null);
    }
    super.updateContentDrawableProperty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.image.HippyTKDImageView
 * JD-Core Version:    0.7.0.1
 */