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
import java.util.HashMap;
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
  private static final int FILE_DESCRIPTOR = "file://".length();
  public static final int MAX_RETRYCOUNTS = 2;
  public static final int NIGHT_MODE_MASK_COLOR = -2147483648;
  public static final long RETRY_INTERVAL = 2000L;
  private Bitmap mBlurBitmap;
  private String mBlurBitmapKey;
  int mBlurRadius;
  private String mBusinessName = "";
  private int mClipBgColor = 0;
  private HippyMap mClipInfoMap;
  boolean mEnableCacheImg;
  boolean mEnableLoadingImg;
  boolean mEnableNoPicMode;
  Path mFeedsClipPath = new Path();
  private boolean mFeedsNeedClip;
  boolean mFitSystemRotation;
  private boolean mGifEnabled;
  private HippyEngineContext mHippyContext;
  HippyTKDSkinHandler mHippyTKDSkinHandler;
  private long mLastTriggerTime;
  private boolean mReported;
  protected boolean mRequestUseDnsParse;
  private int mRetryCounts;
  private Bitmap mRotationBitmap;
  private String mRotationBitmapKey;
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
    float f2 = (float)Math.sqrt(paramInt3);
    float f1 = f2;
    if (f2 > paramInt1) {
      f1 = paramInt1;
    }
    f2 = f1;
    if (f1 > paramInt2) {
      f2 = paramInt2;
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
      switch (i)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      case 3: 
        return 180;
      case 6: 
        return 90;
      }
      return 270;
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
  
  public Bitmap getBitmap()
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
  
  public Object getFetchParam()
  {
    int i = 0;
    Object localObject2 = super.getFetchParam();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new HippyMap();
    }
    int j;
    if ((localObject1 instanceof HippyMap))
    {
      localObject2 = (HippyMap)localObject1;
      if ((this.mEnableLoadingImg) || (!this.mEnableCacheImg)) {
        break label198;
      }
      ((HippyMap)localObject2).pushObject("RequestLevel", new Integer(2));
      if (this.mUseThumbnail)
      {
        RenderNode localRenderNode = this.mHippyContext.getRenderManager().getRenderNode(getId());
        if (localRenderNode == null) {
          break label216;
        }
        j = localRenderNode.getWidth();
        i = localRenderNode.getHeight();
      }
    }
    for (;;)
    {
      ((HippyMap)localObject2).pushObject("useThumbnail", Boolean.valueOf(true));
      ((HippyMap)localObject2).pushObject("viewWidth", Integer.valueOf(j));
      ((HippyMap)localObject2).pushObject("viewHeight", Integer.valueOf(i));
      ((HippyMap)localObject2).pushObject("gifEnabled", Boolean.valueOf(this.mGifEnabled));
      ((HippyMap)localObject2).pushObject("reportdata", this.mSourceFrom);
      ((HippyMap)localObject2).pushObject("businessname", "Hippy_" + this.mBusinessName);
      return localObject1;
      label198:
      ((HippyMap)localObject2).pushObject("RequestLevel", new Integer(1));
      break;
      label216:
      j = 0;
    }
  }
  
  public String getSourceFrom()
  {
    return this.mSourceFrom;
  }
  
  public void handleGetImageFail(Throwable paramThrowable)
  {
    if ((this.mUrl != null) && ((UrlUtils.isWebUrl(this.mUrl)) || (UrlUtils.isFileUrl(this.mUrl))))
    {
      long l = System.currentTimeMillis();
      if ((this.mRetryCounts < 2) && (l - this.mLastTriggerTime > 2000L))
      {
        this.mLastTriggerTime = l;
        this.mRetryCounts += 1;
        if (isAttached())
        {
          onDrawableDetached();
          doFetchImage(null, SOURCE_TYPE_SRC);
          if (paramThrowable != null) {
            break label91;
          }
        }
      }
      label91:
      do
      {
        return;
        paramThrowable.toString();
        return;
        if ((this.mRetryCounts != 2) || (l - this.mLastTriggerTime <= 2000L)) {
          break;
        }
        this.mRetryCounts += 1;
        onGetImageRetry(this.mUrl, paramThrowable);
      } while (!isAttached());
      onDrawableDetached();
      HashMap localHashMap = new HashMap();
      localHashMap.put("useDNSParse", Boolean.valueOf(this.mRequestUseDnsParse));
      doFetchImage(localHashMap, SOURCE_TYPE_SRC);
      if (paramThrowable == null) {
        return;
      }
      paramThrowable.toString();
      return;
    }
    resetRetry();
    super.handleGetImageFail(paramThrowable);
    onGetImageFailed(this.mUrl, paramThrowable);
  }
  
  public void handleGetImageStart()
  {
    super.handleGetImageStart();
    this.mStartFetchTime = System.currentTimeMillis();
  }
  
  public void handleGetImageSuccess()
  {
    super.handleGetImageSuccess();
    resetRetry();
    int j = 1;
    int i = j;
    if (this.mSourceDrawable != null)
    {
      i = j;
      if ((this.mSourceDrawable.getExtraData() instanceof Map))
      {
        localObject = ((Map)this.mSourceDrawable.getExtraData()).get("RequestLevel");
        i = j;
        if ((localObject instanceof Integer)) {
          i = ((Integer)localObject).intValue();
        }
      }
    }
    String str = this.mUrl;
    if (this.mSourceDrawable != null) {}
    for (Object localObject = this.mSourceDrawable.getBitmap();; localObject = null)
    {
      onGetImageSuccess(str, (Bitmap)localObject, System.currentTimeMillis() - this.mStartFetchTime, i);
      return;
    }
  }
  
  protected void handleNightModeMask()
  {
    if (this.mTintColors != null)
    {
      super.setTintColor(HippyTKDSkinHandler.getColor(this.mTintColors));
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
  
  public void onAttachedToWindow()
  {
    if ((!this.mEnableLoadingImg) && (!this.mEnableCacheImg) && (this.mUrl != null) && (UrlUtils.isWebUrl(this.mUrl))) {
      onFetchImage(this.mUrl);
    }
    super.onAttachedToWindow();
  }
  
  public void onFetchImage(String paramString)
  {
    Drawable localDrawable = getBackground();
    this.mContentDrawable = null;
    this.mBGDrawable = null;
    int i;
    if ((paramString != null) && ((UrlUtils.isWebUrl(paramString)) || (UrlUtils.isFileUrl(paramString))))
    {
      i = ResourceUtil.getColor(2131167242);
      if (this.mHippyTKDSkinHandler.getBackgroundColors() == null) {
        break label147;
      }
      i = HippyTKDSkinHandler.getColor(this.mHippyTKDSkinHandler.getBackgroundColors());
    }
    label147:
    for (;;)
    {
      if ((localDrawable instanceof CommonBackgroundDrawable))
      {
        ((CommonBackgroundDrawable)localDrawable).setBackgroundColor(i);
        setCustomBackgroundDrawable((CommonBackgroundDrawable)localDrawable);
      }
      for (;;)
      {
        setBackgroundColor(i);
        return;
        if (((localDrawable instanceof LayerDrawable)) && (((LayerDrawable)localDrawable).getNumberOfLayers() > 0))
        {
          paramString = ((LayerDrawable)localDrawable).getDrawable(0);
          if ((paramString instanceof CommonBackgroundDrawable))
          {
            ((CommonBackgroundDrawable)paramString).setBackgroundColor(i);
            setCustomBackgroundDrawable((CommonBackgroundDrawable)paramString);
          }
        }
      }
      resetContent();
      return;
    }
  }
  
  public void onGaussianBlurComplete(Bitmap paramBitmap, Map paramMap)
  {
    this.mBlurBitmap = paramBitmap;
    post(new HippyTKDImageView.1(this));
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
  
  public void onSetContent(String paramString)
  {
    super.setBackgroundColor(0);
  }
  
  public void resetProps()
  {
    super.resetProps();
    init();
  }
  
  public void restoreBackgroundColorAfterSetContent()
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
  
  public void setNightModeOption(HippyMap paramHippyMap)
  {
    if (paramHippyMap != null) {}
    for (boolean bool = paramHippyMap.getBoolean("enable");; bool = true)
    {
      this.mUseNightModeMask = bool;
      handleNightModeMask();
      return;
    }
  }
  
  public void setNoPicModeOption(HippyMap paramHippyMap)
  {
    boolean bool2 = true;
    if (paramHippyMap != null)
    {
      bool1 = paramHippyMap.getBoolean("enable");
      this.mEnableNoPicMode = bool1;
      bool1 = bool2;
      if (!this.mEnableLoadingImg) {
        if (this.mEnableNoPicMode) {
          break label48;
        }
      }
    }
    label48:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mEnableLoadingImg = bool1;
      return;
      bool1 = true;
      break;
    }
  }
  
  public void setReportData(HippyMap paramHippyMap)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.getString("sourceFrom");; paramHippyMap = "")
    {
      this.mSourceFrom = paramHippyMap;
      return;
    }
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
    if ((paramHippyArray == null) || (paramHippyArray.size() < 4))
    {
      this.mFeedsNeedClip = false;
      return;
    }
    this.mFeedsClipPath.reset();
    this.mFeedsClipPath.moveTo(PixelUtil.dp2px(paramHippyArray.getInt(0)), PixelUtil.dp2px(paramHippyArray.getInt(1)));
    int i = 1;
    while (i * 2 + 1 < paramHippyArray.size())
    {
      this.mFeedsClipPath.lineTo(PixelUtil.dp2px(paramHippyArray.getInt(i * 2)), PixelUtil.dp2px(paramHippyArray.getInt(i * 2 + 1)));
      i += 1;
    }
    this.mFeedsClipPath.close();
    this.mFeedsNeedClip = true;
  }
  
  public boolean shouldFetchImage()
  {
    if ((!this.mEnableLoadingImg) && (!this.mEnableCacheImg)) {
      return false;
    }
    return super.shouldFetchImage();
  }
  
  public boolean shouldSetContent()
  {
    boolean bool = true;
    Object localObject;
    if (this.mSourceDrawable != null)
    {
      localObject = this.mSourceDrawable.getSource();
      if ((localObject != null) && (!((String)localObject).equals(this.mUrl)) && (isAttached())) {
        bool = false;
      }
    }
    do
    {
      do
      {
        return bool;
        if ((this.mBlurRadius <= 0) || (this.mSourceDrawable == null) || (this.mSourceDrawable.getBitmap() == null)) {
          break;
        }
      } while ((getUrl() + "_" + this.mBlurRadius).equals(this.mBlurBitmapKey));
      return false;
      if ((!this.mFitSystemRotation) || (this.mSourceDrawable == null) || (this.mSourceDrawable.getBitmap() == null)) {
        break;
      }
      localObject = getUrl();
    } while (((String)localObject).equals(this.mRotationBitmapKey));
    this.mRotationBitmapKey = ((String)localObject);
    if (this.mUrl.startsWith("file://")) {}
    for (int i = getPicOrientation(this.mUrl.substring(7));; i = 0)
    {
      int j;
      int k;
      int m;
      if (i != 0)
      {
        localObject = new Matrix();
        j = this.mSourceDrawable.getBitmap().getWidth();
        k = this.mSourceDrawable.getBitmap().getHeight();
        if (i / 90 % 2 == 0) {
          break label394;
        }
        m = j;
      }
      for (int n = k;; n = j)
      {
        RenderNode localRenderNode = this.mHippyContext.getRenderManager().getRenderNode(getId());
        int i2;
        int i1;
        if (localRenderNode != null)
        {
          i2 = localRenderNode.getWidth();
          i1 = localRenderNode.getHeight();
        }
        for (;;)
        {
          if ((i2 > 0) && (i1 > 0))
          {
            m = Math.min(n / i2, m / i1);
            if (m > 1) {
              ((Matrix)localObject).postScale(1.0F / m, 1.0F / m);
            }
          }
          ((Matrix)localObject).postRotate(i);
          this.mRotationBitmap = Bitmap.createBitmap(this.mSourceDrawable.getBitmap(), 0, 0, j, k, (Matrix)localObject, true);
          return true;
          this.mRotationBitmap = this.mSourceDrawable.getBitmap();
          return true;
          return super.shouldSetContent();
          i1 = 0;
          i2 = 0;
        }
        label394:
        m = k;
      }
    }
  }
  
  public void updateContentDrawableProperty()
  {
    if (this.mFeedsNeedClip)
    {
      ((ContentDrawable)this.mContentDrawable).mSelfClipPath = this.mFeedsClipPath;
      setLayerType(1, null);
    }
    super.updateContentDrawableProperty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.image.HippyTKDImageView
 * JD-Core Version:    0.7.0.1
 */