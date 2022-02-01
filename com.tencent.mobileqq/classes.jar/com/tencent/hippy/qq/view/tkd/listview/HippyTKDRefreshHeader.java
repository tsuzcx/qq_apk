package com.tencent.hippy.qq.view.tkd.listview;

import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import androidx.annotation.NonNull;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.os.MqqHandler;

public class HippyTKDRefreshHeader
  implements HippyTKDInvalidateCallback, IHippyTKDRefreshHeader
{
  public static final int BALL_COLOR_CUSTOM = 3;
  public static final int BALL_COLOR_DEFAULT = -1;
  public static final int BALL_COLOR_GREEN = 1;
  public static final int BALL_COLOR_RED = 0;
  public static final int BALL_COLOR_YELLOW = 2;
  static final int BALL_COUNT = 3;
  public static final int BALL_MARGING_WITH_TEXT;
  public static final int BALL_MARGIN_H = ImmersiveUtils.dpToPx(12.0F);
  public static final int BALL_MARING_V = ImmersiveUtils.dpToPx(18.0F);
  public static final int CONTENT_HEIGHT = ImmersiveUtils.dpToPx(42.0F);
  public static final int REFRESH_HEADER_TOP_PADDING = ImmersiveUtils.dpToPx(0.0F);
  public static final int REFRESH_RESULT_FAILED = 3;
  public static final int REFRESH_RESULT_NOTCARE = 1;
  public static final int REFRESH_RESULT_SUCCESSS = 2;
  public static final int REFRESH_STATE_FAILED = 3;
  public static final int REFRESH_STATE_ING = 1;
  public static final int REFRESH_STATE_NOTCARE = 6;
  public static final int REFRESH_STATE_PULLING = 4;
  public static final int REFRESH_STATE_SETTLING = 5;
  public static final int REFRESH_STATE_SUCCESSS = 2;
  public static final int REFRESH_STATE_WAIT = 0;
  static final String TAG = "QBRefreshHeader";
  public static final int TARGET_REFRESH_TYPE_KINGCARD_USER = 3;
  public static final int TARGET_REFRESH_TYPE_NONE = -1;
  public static final int TEXT_MARGING_WITH_BALL;
  UIGdiMeasure gm;
  ObjectAnimator hideAnimator;
  boolean isSuccess;
  LinearGradient mBackGradient;
  AnimatingBall[] mBalls;
  public HippyTKDRefreshHeader.RefreshableCallback mCb;
  int mColor;
  int mColorType;
  public int mContentheight;
  HippyTKDRefreshAnimation mCustomAnimation;
  String mCustomCompleteText;
  private View mCustomHippyRefreshView;
  private HippyTKDCustomRefreshHeader mCustomRefreshHeaderView;
  private View.OnLayoutChangeListener mCustomRefreshViewLayoutChangeListener;
  int mCustomTipBackgroundColorID;
  int mCustomTipBgBeginColor;
  int mCustomTipBgEndColor;
  int mCustomTipTextColor;
  int mCustomTipTextSize;
  String mDescriptionText;
  int mDescriptionTextColor;
  int mDescriptionTextFontSize;
  private boolean mEnableCustomRefreshHeaderView;
  private IHippyTKDRefreshHeaderEventExtension[] mEventExtensions;
  private int mHideIndex;
  private View mHostView = null;
  private String mIconUrl = null;
  private int mInitLayerType = 0;
  HippyTKDRefreshHeader.InternalStageCallback mInternalStageCallback;
  Paint mPaint;
  private HippyTKDRefreshHeader.PendingComplete mPendingCompleteObject = null;
  Promise mPromise;
  public BitmapDrawable mPullDownToRefreshDesIcon;
  public int mPullDownToRefreshDesIconHeigth;
  public int mPullDownToRefreshDesIconWidth;
  public int mPullDownToRefreshDistanceBetweenIconText = ImmersiveUtils.dpToPx(8.0F);
  public Drawable mPullDownToRefreshFailIcon;
  public Drawable mPullDownToRefreshSucIcon;
  public String mPullDownToRefreshTextFail = ResourceUtil.getString(2131718166);
  public HippyTKDUISize mPullDownToRefreshTextFailTextSize = new HippyTKDUISize();
  public String mPullDownToRefreshTextSuc = ResourceUtil.getString(2131718167);
  public HippyTKDUISize mPullDownToRefreshTextSucTextSize = new HippyTKDUISize();
  public Drawable mRefreshDrawable;
  public int mRefreshOffset;
  public int mRefreshState = 0;
  float mRefreshToastAlpha;
  float mRefreshToastOffsetY;
  float mRefreshToastSize;
  private boolean mShowRefreshBall = true;
  boolean mShowRefreshIcon;
  boolean mStatShow5p;
  boolean mStatShow80p;
  Runnable mStayRunnable;
  private int mTargetRefreshType;
  int mTipsBgColor;
  private Paint mToastBgPaint = new Paint();
  private RectF mToastBgRect = new RectF();
  PropertyValuesHolder offsetHolderShow;
  public int refreshBgColor;
  ObjectAnimator showAnimator;
  
  static
  {
    BALL_MARGING_WITH_TEXT = ImmersiveUtils.dpToPx(26.0F);
    TEXT_MARGING_WITH_BALL = ImmersiveUtils.dpToPx(6.0F);
  }
  
  public HippyTKDRefreshHeader(HippyTKDRefreshHeader.RefreshableCallback paramRefreshableCallback)
  {
    this(paramRefreshableCallback, true);
    if ((paramRefreshableCallback instanceof View)) {
      this.mHostView = ((View)paramRefreshableCallback);
    }
  }
  
  public HippyTKDRefreshHeader(HippyTKDRefreshHeader.RefreshableCallback paramRefreshableCallback, boolean paramBoolean)
  {
    int i = CONTENT_HEIGHT;
    int j = REFRESH_HEADER_TOP_PADDING;
    this.mRefreshOffset = (i + j);
    this.mContentheight = (i + j);
    this.mPaint = new Paint();
    this.mShowRefreshIcon = true;
    this.mCustomAnimation = null;
    this.refreshBgColor = 0;
    this.mDescriptionTextFontSize = ImmersiveUtils.dpToPx(12.0F);
    this.mCustomTipTextSize = 0;
    this.mCustomTipBackgroundColorID = 0;
    this.mCustomTipBgBeginColor = 0;
    this.mCustomTipBgEndColor = 0;
    this.isSuccess = false;
    this.mInternalStageCallback = null;
    this.mStayRunnable = new HippyTKDRefreshHeader.1(this);
    this.mCustomRefreshHeaderView = null;
    this.mEnableCustomRefreshHeaderView = false;
    this.mTargetRefreshType = -1;
    this.mHideIndex = 0;
    this.mStatShow5p = false;
    this.mStatShow80p = false;
    this.mCb = paramRefreshableCallback;
    this.gm = new UIGdiMeasure();
    this.gm.setFontSize(ImmersiveUtils.dpToPx(12.0F));
    this.gm.getStringWidthHeight(this.mPullDownToRefreshTextSuc, this.mPullDownToRefreshTextSucTextSize);
    this.gm.getStringWidthHeight(this.mPullDownToRefreshTextFail, this.mPullDownToRefreshTextFailTextSize);
    this.mBalls = new AnimatingBall[3];
    i = 0;
    while (i < 3)
    {
      this.mBalls[i] = new AnimatingBall(this, i);
      i += 1;
    }
    setRefreshBallColor(-1);
    setRefreshToastOffsetY(-this.mContentheight);
    setRefreshToastAlpha(1.0F);
    this.offsetHolderShow = PropertyValuesHolder.ofFloat("refreshToastOffsetY", new float[] { 0.0F });
    paramRefreshableCallback = PropertyValuesHolder.ofFloat("refreshToastAlpha", new float[] { 0.5F, 1.0F });
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofFloat("refreshToastSize", new float[] { 0.0F, 1.0F });
    this.showAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { this.offsetHolderShow, paramRefreshableCallback, localPropertyValuesHolder });
    this.showAnimator.setDuration(200L);
    this.showAnimator.setEvaluator(new FloatEvaluator());
    this.showAnimator.setInterpolator(new CurvedInterpolator(2));
    this.hideAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("refreshToastOffsetY", new float[] { -this.mContentheight }), PropertyValuesHolder.ofFloat("refreshToastAlpha", new float[] { 1.0F, 0.5F }) });
    this.hideAnimator.setDuration(200L);
    this.hideAnimator.setEvaluator(new FloatEvaluator());
    this.hideAnimator.setInterpolator(new CurvedInterpolator(3));
    this.mCustomRefreshViewLayoutChangeListener = new HippyTKDRefreshHeader.2(this);
    this.mDescriptionTextColor = ResourceUtil.getColor(2131167299);
  }
  
  private String getStateStr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 6: 
      return "NOTCARE";
    case 5: 
      return "SETTLING";
    case 4: 
      return "PULLING";
    case 3: 
      return "FAILED";
    case 2: 
      return "SUCCESSS";
    case 1: 
      return "ING";
    }
    return "WAIT";
  }
  
  private boolean isCustomRefreshMode()
  {
    return this.mCustomRefreshHeaderView != null;
  }
  
  private void setFakeRefreshState(int paramInt)
  {
    if (paramInt == this.mRefreshState) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setRefreshState:old=");
    ((StringBuilder)localObject).append(stateToString(this.mRefreshState));
    ((StringBuilder)localObject).append(",new=");
    ((StringBuilder)localObject).append(stateToString(paramInt));
    Log.e("QBRefreshHeader", ((StringBuilder)localObject).toString());
    int i = this.mRefreshState;
    if ((i == 0) || (i == 5))
    {
      if (paramInt == 1)
      {
        i = 0;
        for (;;)
        {
          localObject = this.mBalls;
          if (i >= localObject.length) {
            break;
          }
          localObject[i].animateRefresh();
          i += 1;
        }
        this.mRefreshState = paramInt;
        return;
      }
      Log.d("QBRefreshHeader", "refresh notify");
    }
    this.mRefreshState = paramInt;
  }
  
  public void addExternalStageInfo(HippyTKDRefreshHeader.ExternalStageInfo paramExternalStageInfo) {}
  
  public void advancedStopRefresh()
  {
    int i = this.mRefreshState;
    if ((i == 2) || (i == 3))
    {
      stopRefresh();
      hideToast(null, false);
      this.mCb.removeCallbacksDelegate(this.mStayRunnable);
      this.mCb.postDelayedDelegate(this.mStayRunnable, 0L);
    }
  }
  
  public boolean checkRefreshState(int paramInt)
  {
    return paramInt == this.mRefreshState;
  }
  
  public void clearCompletePending()
  {
    this.mPendingCompleteObject = null;
  }
  
  public void completeRefresh(int paramInt)
  {
    completeRefresh(paramInt, null, 0, 0, 0, 0, this.mIconUrl, true, 1200L, null, 0);
  }
  
  public void completeRefresh(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, boolean paramBoolean, long paramLong, Promise paramPromise, int paramInt6)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("completeRefresh state ");
    localStringBuilder.append(stateToString(this.mRefreshState));
    Log.d("HippyQBRefreshHeader", localStringBuilder.toString());
    this.mCustomTipBgBeginColor = paramInt2;
    this.mCustomTipBgEndColor = paramInt3;
    this.mCustomTipTextColor = paramInt4;
    this.mCustomTipTextSize = paramInt5;
    this.mPromise = paramPromise;
    this.mBackGradient = null;
    this.mHideIndex = paramInt6;
    if ((this.mCustomTipBgBeginColor != 0) && (this.mCustomTipBgEndColor != 0)) {
      this.offsetHolderShow.setFloatValues(new float[] { 0.0F, 0.0F });
    } else {
      this.offsetHolderShow.setFloatValues(new float[] { -this.mContentheight, 0.0F });
    }
    if ((!TextUtils.isEmpty(paramString2)) && (this.mHostView != null) && (!TextUtils.equals(this.mIconUrl, paramString2)))
    {
      this.mIconUrl = paramString2;
      fetchImage(paramString2, new HippyTKDRefreshHeader.13(this, paramInt1));
    }
    if (TextUtils.isEmpty(paramString2))
    {
      this.mIconUrl = null;
      this.mPullDownToRefreshSucIcon = null;
      this.mPullDownToRefreshFailIcon = null;
    }
    paramInt2 = this.mRefreshState;
    if (paramInt2 != 1)
    {
      if (((paramInt2 != 2) && (paramInt2 != 3)) || ((paramInt1 != 2) && (paramInt1 != 3)))
      {
        if (paramInt1 != 1)
        {
          if (this.mPendingCompleteObject == null) {
            this.mPendingCompleteObject = new HippyTKDRefreshHeader.PendingComplete();
          }
          this.mPendingCompleteObject.setPendingCompleteInfo(paramString1, paramBoolean, paramLong);
        }
        return;
      }
      paramString2 = new StringBuilder();
      paramString2.append("completeRefresh:already in success or fail, update toast info, mRefreshState=");
      paramString2.append(this.mRefreshState);
      Log.d("QBRefreshHeader", paramString2.toString());
      if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.mCustomCompleteText)))
      {
        this.mCustomCompleteText = paramString1;
        this.mShowRefreshIcon = paramBoolean;
        paramString1 = this.gm;
        paramInt1 = this.mCustomTipTextSize;
        if (paramInt1 == 0) {
          paramInt1 = ImmersiveUtils.dpToPx(12.0F);
        }
        paramString1.setFontSize(paramInt1);
        this.gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextSucTextSize);
        this.gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextFailTextSize);
        postInvalidate();
      }
      return;
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      this.mCustomCompleteText = paramString1;
      this.mShowRefreshIcon = paramBoolean;
      paramString1 = this.gm;
      paramInt2 = this.mCustomTipTextSize;
      if (paramInt2 == 0) {
        paramInt2 = ImmersiveUtils.dpToPx(12.0F);
      }
      paramString1.setFontSize(paramInt2);
      this.gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextSucTextSize);
      this.gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextFailTextSize);
    }
    if (this.mCb.getOffsetY() < 0)
    {
      Log.d("QBRefreshHeader", "completeRefresh offset<=0");
      if (paramInt1 == 2)
      {
        setRefreshState(2);
        this.isSuccess = true;
      }
      else if (paramInt1 == 3)
      {
        setRefreshState(3);
        this.isSuccess = false;
      }
      else if (paramInt1 == 1)
      {
        setRefreshState(6);
      }
      this.mCb.removeCallbacksDelegate(this.mStayRunnable);
      this.mCb.removeOnScrollFinishListener();
      paramString1 = this.mCb;
      paramString2 = this.mStayRunnable;
      if (paramInt1 == 1) {
        paramLong = 0L;
      }
      paramString1.postDelayedDelegate(paramString2, paramLong);
      this.mCb.scrollToShowHeaderSmooth(this.mContentheight);
      return;
    }
    this.mCb.scrollToTopAtOnce();
    setRefreshState(0);
  }
  
  public void completeRefresh(int paramInt, String paramString, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    int i = this.mRefreshState;
    if (i != 1)
    {
      if (((i != 2) && (i != 3)) || ((paramInt != 2) && (paramInt != 3)))
      {
        if (paramInt != 1)
        {
          if (this.mPendingCompleteObject == null) {
            this.mPendingCompleteObject = new HippyTKDRefreshHeader.PendingComplete();
          }
          this.mPendingCompleteObject.setPendingCompleteInfo(paramString, paramBoolean1, paramLong);
        }
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("completeRefresh:already in success or fail, update toast info, mRefreshState=");
      ((StringBuilder)localObject).append(this.mRefreshState);
      Log.d("QBRefreshHeader", ((StringBuilder)localObject).toString());
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.mCustomCompleteText)))
      {
        this.mCustomCompleteText = paramString;
        this.mShowRefreshIcon = paramBoolean1;
        paramString = this.gm;
        paramInt = this.mCustomTipTextSize;
        if (paramInt == 0) {
          paramInt = ImmersiveUtils.dpToPx(12.0F);
        }
        paramString.setFontSize(paramInt);
        this.gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextSucTextSize);
        this.gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextFailTextSize);
        postInvalidate();
      }
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.mCustomCompleteText = paramString;
      this.mShowRefreshIcon = paramBoolean1;
      paramString = this.gm;
      i = this.mCustomTipTextSize;
      if (i == 0) {
        i = ImmersiveUtils.dpToPx(12.0F);
      }
      paramString.setFontSize(i);
      this.gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextSucTextSize);
      this.gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextFailTextSize);
    }
    if ((this.mCb.getOffsetY() >= 0) && (!paramBoolean2))
    {
      this.mCb.scrollToTopAtOnce();
      setRefreshState(0);
      return;
    }
    Log.d("QBRefreshHeader", "completeRefresh offset<=0");
    if (paramInt == 2)
    {
      setRefreshState(2);
      this.isSuccess = true;
    }
    else if (paramInt == 3)
    {
      setRefreshState(3);
      this.isSuccess = false;
    }
    else if (paramInt == 1)
    {
      setRefreshState(6);
    }
    this.mCb.removeCallbacksDelegate(this.mStayRunnable);
    this.mCb.removeOnScrollFinishListener();
    paramString = this.mCb;
    Object localObject = this.mStayRunnable;
    if (paramInt == 1) {
      paramLong = 0L;
    }
    paramString.postDelayedDelegate((Runnable)localObject, paramLong);
  }
  
  public void fetchImage(String paramString, @NonNull HippyTKDRefreshHeader.ImageRequestListener paramImageRequestListener)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramImageRequestListener.onRequestFail(new IllegalArgumentException("null url"), paramString);
      return;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
    localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).setURLDrawableListener(new HippyTKDRefreshHeader.14(this, paramImageRequestListener, paramString));
    if ((((URLDrawable)localObject).getStatus() != 2) && (((URLDrawable)localObject).getStatus() != 3))
    {
      ((URLDrawable)localObject).startDownload();
      return;
    }
    ((URLDrawable)localObject).restartDownload();
  }
  
  public int getRefreshState()
  {
    return this.mRefreshState;
  }
  
  public float getRefreshToastAlpha()
  {
    return this.mRefreshToastAlpha;
  }
  
  public float getRefreshToastOffsetY()
  {
    return this.mRefreshToastOffsetY;
  }
  
  public float getRefreshToastSize()
  {
    return this.mRefreshToastSize;
  }
  
  void hideToast(Runnable paramRunnable, boolean paramBoolean)
  {
    Log.d("QBRefreshHeader", "hideToast");
    this.showAnimator.cancel();
    if (!paramBoolean)
    {
      this.hideAnimator.addListener(new HippyTKDRefreshHeader.6(this, paramRunnable));
      this.hideAnimator.start();
      return;
    }
    if (paramRunnable != null) {
      paramRunnable.run();
    }
  }
  
  public boolean isInRefreshArea()
  {
    int i = this.mCb.getTotalHeight();
    return (this.mCb.getOffsetY() < 0) || (this.mCb.getHeight() > i);
  }
  
  public boolean isRefreshHeaderShowing()
  {
    return this.mRefreshState != 0;
  }
  
  public boolean isRefreshing()
  {
    int i = this.mRefreshState;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 1)
    {
      bool1 = bool2;
      if (i != 3)
      {
        bool1 = bool2;
        if (i != 2)
        {
          if (i == 6) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public void onCancelTouch()
  {
    if (this.mRefreshState == 5) {
      setRefreshState(0);
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    boolean bool = isCustomRefreshMode();
    int k = 255;
    int n = 0;
    Object localObject1;
    int i;
    int j;
    int m;
    if (bool)
    {
      localObject1 = this.mCustomRefreshHeaderView;
      if ((localObject1 != null) && (((HippyTKDCustomRefreshHeader)localObject1).isShowMasterRefreshText())) {
        i = 1;
      } else {
        i = 0;
      }
      localObject1 = this.mCustomRefreshHeaderView;
      if ((localObject1 != null) && (((HippyTKDCustomRefreshHeader)localObject1).isShowMasterRefreshToastBg())) {
        j = 1;
      } else {
        j = 0;
      }
      localObject1 = this.mCustomRefreshHeaderView;
      if (localObject1 != null) {
        k = ((HippyTKDCustomRefreshHeader)localObject1).getMasterRefreshTextAlpha();
      }
      this.mCustomRefreshHeaderView.onTranslating(-this.mCb.getOffsetY());
      paramCanvas.save();
      paramCanvas.translate(0.0F, -this.mCb.getOffsetY() - this.mCustomRefreshHeaderView.getRefreshViewHeight());
      this.mCustomRefreshHeaderView.draw(paramCanvas);
      paramCanvas.restore();
      m = j;
      j = i;
      i = k;
      k = m;
    }
    else
    {
      j = 1;
      i = 255;
      k = 1;
    }
    int i1 = paramCanvas.save();
    if ((this.mCustomHippyRefreshView != null) && (this.mRefreshState != 0))
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, -this.mCb.getOffsetY() - this.mCustomHippyRefreshView.getHeight());
      this.mCustomHippyRefreshView.draw(paramCanvas);
      this.mCb.postInvalidate();
      paramCanvas.restore();
      paramCanvas.restoreToCount(i1);
      return;
    }
    if (!bool)
    {
      this.mPaint.setColor(this.refreshBgColor);
      paramCanvas.drawRect(0.0F, 0.0F, this.mCb.getWidth(), -this.mCb.getOffsetY(), this.mPaint);
    }
    int i2 = (this.mCb.getWidth() - (AnimatingBall.BALL_SIZE * 2 + BALL_MARGIN_H * 2)) / 2;
    if (this.mShowRefreshBall)
    {
      m = this.mRefreshState;
      if ((m != 3) && (m != 2))
      {
        localObject1 = this.mCustomAnimation;
        if (localObject1 != null)
        {
          ((HippyTKDRefreshAnimation)localObject1).draw(paramCanvas, this.mCb.getOffsetY(), 2147483647, i2);
        }
        else if (!bool)
        {
          m = 0;
          for (;;)
          {
            localObject1 = this.mBalls;
            if (m >= localObject1.length) {
              break;
            }
            localObject1[m].draw(paramCanvas, this.mCb.getOffsetY(), 2147483647, i2);
            m += 1;
          }
        }
        localObject1 = this.mPullDownToRefreshDesIcon;
        if ((localObject1 == null) || (((BitmapDrawable)localObject1).getBitmap() == null) || (this.mPullDownToRefreshDesIcon.getBitmap().isRecycled())) {}
      }
    }
    try
    {
      m = (this.mCb.getWidth() - this.mPullDownToRefreshDesIconWidth) / 2;
      i2 = -this.mCb.getOffsetY() - this.mContentheight - this.mPullDownToRefreshDesIconHeigth - ImmersiveUtils.dpToPx(0.0F);
      if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
        this.mPullDownToRefreshDesIcon.setColorFilter(-2147483648, PorterDuff.Mode.SRC_ATOP);
      } else {
        this.mPullDownToRefreshDesIcon.clearColorFilter();
      }
      this.mPullDownToRefreshDesIcon.setBounds(m, i2, this.mPullDownToRefreshDesIconWidth + m, this.mPullDownToRefreshDesIconHeigth + i2);
      this.mPullDownToRefreshDesIcon.draw(paramCanvas);
      if ((!this.mStatShow80p) && (-(this.mCb.getOffsetY() + this.mContentheight) / this.mPullDownToRefreshDesIconHeigth > 0.8D))
      {
        this.mStatShow80p = true;
        if (this.mEventExtensions != null)
        {
          localObject1 = this.mEventExtensions;
          i2 = localObject1.length;
          m = 0;
          while (m < i2)
          {
            localObject1[m].onRefreshHeaderShow80P();
            m += 1;
          }
        }
      }
      if ((this.mStatShow5p) || (-(this.mCb.getOffsetY() + this.mContentheight) / this.mPullDownToRefreshDesIconHeigth <= 0.05D)) {
        break label900;
      }
      this.mStatShow5p = true;
      if (this.mEventExtensions == null) {
        break label900;
      }
      localObject1 = this.mEventExtensions;
      i2 = localObject1.length;
      m = 0;
      while (m < i2)
      {
        localObject1[m].onRefreshHeaderShow5P();
        m += 1;
      }
    }
    catch (Exception localException)
    {
      label765:
      float f1;
      int i3;
      float f2;
      float f3;
      float f4;
      Drawable localDrawable;
      Object localObject2;
      int i4;
      int i5;
      break label765;
    }
    if ((!TextUtils.isEmpty(this.mDescriptionText)) && (j != 0))
    {
      this.mPaint.setTextSize(this.mDescriptionTextFontSize);
      this.mPaint.setColor(this.mDescriptionTextColor);
      i2 = UIUtilBase.getTextWidth(this.mDescriptionText, this.mPaint, this.mDescriptionTextFontSize);
      m = UIUtilBase.getTextHeight(this.mPaint, this.mDescriptionTextFontSize);
      i2 = (this.mCb.getWidth() - i2) / 2;
      this.mPaint.setAlpha(i);
      UIStringUtils.drawText(paramCanvas, this.mPaint, i2, -this.mCb.getOffsetY() - this.mContentheight - m - ImmersiveUtils.dpToPx(0.0F), this.mDescriptionText);
    }
    label900:
    f1 = this.mRefreshToastOffsetY;
    if (f1 > -this.mContentheight)
    {
      m = paramCanvas.saveLayerAlpha(0.0F, f1, this.mCb.getWidth(), this.mContentheight, (int)(this.mRefreshToastAlpha * 255.0F), 31);
      i2 = this.mPaint.getAlpha();
      if (k != 0)
      {
        paramCanvas.translate(0.0F, this.mRefreshToastOffsetY);
        paramCanvas.clipRect(0, 0, this.mCb.getWidth(), this.mContentheight);
        k = this.mCustomTipBackgroundColorID;
        if (k != 0) {
          k = ResourceUtil.getColor(k);
        } else {
          k = this.mTipsBgColor;
        }
        paramCanvas.drawColor(k);
        this.mPaint.setAlpha(Color.alpha(this.mCustomTipBgBeginColor));
        if (this.mBackGradient == null)
        {
          f1 = this.mCb.getWidth();
          k = this.mCustomTipBgBeginColor;
          i3 = this.mCustomTipBgEndColor;
          localObject1 = Shader.TileMode.CLAMP;
          this.mBackGradient = new LinearGradient(0.0F, 0.0F, f1, 0.0F, new int[] { k, i3 }, null, (Shader.TileMode)localObject1);
        }
        this.mPaint.setShader(this.mBackGradient);
        f1 = this.mCb.getWidth() / 2;
        f2 = this.mCb.getWidth() / 2;
        f3 = this.mRefreshToastSize;
        f4 = this.mCb.getWidth() / 2;
        paramCanvas.drawRect(f1 - f2 * f3, 0.0F, this.mCb.getWidth() / 2 * this.mRefreshToastSize + f4, this.mContentheight, this.mPaint);
      }
      localObject1 = this.mPaint;
      localDrawable = null;
      ((Paint)localObject1).setShader(null);
      this.mPaint.setAlpha(i2);
      if (!TextUtils.isEmpty(this.mCustomCompleteText)) {
        localObject1 = this.mCustomCompleteText;
      } else if (this.isSuccess) {
        localObject1 = this.mPullDownToRefreshTextSuc;
      } else {
        localObject1 = this.mPullDownToRefreshTextFail;
      }
      if (!this.isSuccess) {
        localObject2 = this.mPullDownToRefreshTextFailTextSize;
      } else {
        localObject2 = this.mPullDownToRefreshTextSucTextSize;
      }
      i2 = ((HippyTKDUISize)localObject2).mWidth;
      if (!this.isSuccess) {
        localObject2 = this.mPullDownToRefreshTextFailTextSize;
      } else {
        localObject2 = this.mPullDownToRefreshTextSucTextSize;
      }
      i3 = ((HippyTKDUISize)localObject2).mHeight;
      localObject2 = this.mPaint;
      k = this.mCustomTipTextSize;
      if (k == 0) {
        k = ImmersiveUtils.dpToPx(12.0F);
      }
      ((Paint)localObject2).setTextSize(k);
      localObject2 = this.mPaint;
      k = this.mCustomTipTextColor;
      if (k == 0) {
        k = this.mColor;
      }
      ((Paint)localObject2).setColor(k);
      k = this.mContentheight;
      i4 = REFRESH_HEADER_TOP_PADDING;
      f1 = (k - i4 - i3) / 2 + i4;
      if (this.mShowRefreshIcon)
      {
        if (j != 0)
        {
          k = paramCanvas.save();
          if (this.isSuccess)
          {
            if (this.mPullDownToRefreshSucIcon == null)
            {
              localObject2 = ResourceUtil.getBitmap(2130851017);
              j = this.mCustomTipTextColor;
              if (j == 0) {
                j = this.mColor;
              }
              this.mPullDownToRefreshSucIcon = UIBitmapUtils.getColorImage((Bitmap)localObject2, j);
            }
            localObject2 = this.mPullDownToRefreshSucIcon;
          }
          else
          {
            if (this.mPullDownToRefreshFailIcon == null)
            {
              localObject2 = ResourceUtil.getBitmap(2130851016);
              j = this.mCustomTipTextColor;
              if (j == 0) {
                j = this.mColor;
              }
              this.mPullDownToRefreshFailIcon = UIBitmapUtils.getColorImage((Bitmap)localObject2, j);
            }
            localObject2 = this.mPullDownToRefreshFailIcon;
          }
          if (this.mTargetRefreshType == 3)
          {
            if (ThemeUtil.isNowThemeIsNight(null, false, "")) {
              j = -2147483648;
            } else {
              j = 0;
            }
            localDrawable = UIBitmapUtils.getColorImage(ResourceUtil.getBitmap(2130851015), j);
          }
          i3 = this.mCb.getWidth();
          i4 = ((Drawable)localObject2).getIntrinsicWidth();
          i5 = this.mPullDownToRefreshDistanceBetweenIconText;
          if (localDrawable == null) {
            j = n;
          } else {
            j = localDrawable.getIntrinsicWidth();
          }
          j = (i3 - i4 - i5 - i2 - j) / 2;
          n = (this.mContentheight - REFRESH_HEADER_TOP_PADDING - ((Drawable)localObject2).getIntrinsicHeight()) / 2 + REFRESH_HEADER_TOP_PADDING;
          ((Drawable)localObject2).setBounds(j, n, ((Drawable)localObject2).getIntrinsicWidth() + j, n + ((Drawable)localObject2).getIntrinsicHeight());
          ((Drawable)localObject2).setAlpha(i);
          ((Drawable)localObject2).draw(paramCanvas);
          paramCanvas.restoreToCount(k);
          this.mPaint.setAlpha(i);
          UIStringUtils.drawText(paramCanvas, this.mPaint, ((Drawable)localObject2).getIntrinsicWidth() + j + this.mPullDownToRefreshDistanceBetweenIconText, f1, (String)localObject1);
          if ((this.mTargetRefreshType == 3) && (localDrawable != null))
          {
            j = (int)(j + ((Drawable)localObject2).getIntrinsicWidth() + this.mPullDownToRefreshDistanceBetweenIconText + i2 + PixelUtil.dp2px(8.0F));
            k = (this.mContentheight - REFRESH_HEADER_TOP_PADDING - localDrawable.getIntrinsicHeight()) / 2 + REFRESH_HEADER_TOP_PADDING;
            localDrawable.setBounds(j, k, localDrawable.getIntrinsicWidth() + j, localDrawable.getIntrinsicHeight() + k);
            localDrawable.setAlpha(i);
            localDrawable.draw(paramCanvas);
          }
        }
      }
      else if (j != 0)
      {
        f2 = (this.mCb.getWidth() - i2) / 2.0F;
        this.mPaint.setAlpha(i);
        UIStringUtils.drawText(paramCanvas, this.mPaint, f2, f1, (String)localObject1);
      }
      paramCanvas.restoreToCount(m);
    }
    paramCanvas.restoreToCount(i1);
  }
  
  public boolean onScrolled()
  {
    if ((isInRefreshArea()) && (this.mCb.getOffsetY() != 0))
    {
      if (!this.mCb.getOverScrollEnabled()) {
        return false;
      }
      Log.d("QBRefreshHeader", "setRefreshState ee");
      setRefreshState(4);
    }
    else
    {
      setRefreshState(0);
    }
    if (this.mCb.getOffsetY() >= 0)
    {
      this.mStatShow80p = false;
      this.mStatShow5p = false;
    }
    return true;
  }
  
  public void onSwitchSkin()
  {
    int i = this.mColorType;
    if (i != 3) {
      setRefreshBallColor(i);
    }
  }
  
  public boolean onUpAction(boolean paramBoolean)
  {
    Log.d("QBRefreshHeader", "onUpAction");
    if (!paramBoolean)
    {
      Log.d("QBRefreshHeader", "onUpAction,!canGoRefresh,return early");
      return false;
    }
    if (isInRefreshArea())
    {
      int i = this.mRefreshState;
      if (i == 4)
      {
        HippyTKDRefreshHeader.InternalStageCallback localInternalStageCallback;
        if (this.mCb.getOffsetY() < -this.mRefreshOffset)
        {
          Log.d("QBRefreshHeader", "onUpAction,scroll to show header");
          this.mCb.onAboutToRefresh();
          this.mCb.scrollToShowHeader(this.mRefreshOffset, new HippyTKDRefreshHeader.8(this));
          Log.d("QBRefreshHeader", "setRefreshState cc");
          setRefreshState(5);
          localInternalStageCallback = this.mInternalStageCallback;
          if (localInternalStageCallback != null)
          {
            localInternalStageCallback.onUpAction(1);
            return true;
          }
        }
        else
        {
          Log.d("QBRefreshHeader", "onUpAction,scrollToTop");
          this.mCb.scrollToTop(new HippyTKDRefreshHeader.9(this), 0);
          Log.d("QBRefreshHeader", "setRefreshState dd");
          setRefreshState(5);
          localInternalStageCallback = this.mInternalStageCallback;
          if (localInternalStageCallback != null) {
            localInternalStageCallback.onUpAction(0);
          }
        }
        return true;
      }
      if ((i != 1) && (i != 2) && (i != 3))
      {
        Log.d("QBRefreshHeader", "onUpAction,not pulling or settling");
        return false;
      }
      Log.d("QBRefreshHeader", "onUpAction,pulling");
      return true;
    }
    Log.d("QBRefreshHeader", "onUpAction,not in overscroll area");
    return false;
  }
  
  public void postInvalidate()
  {
    this.mCb.postInvalidate();
  }
  
  public void resetRefreshState()
  {
    this.mRefreshState = 0;
  }
  
  public void restoreRefresh()
  {
    if (this.mRefreshState == 1)
    {
      Object localObject = this.mCustomAnimation;
      if (localObject != null)
      {
        ((HippyTKDRefreshAnimation)localObject).animateRefresh();
        return;
      }
      int i = 0;
      for (;;)
      {
        localObject = this.mBalls;
        if (i >= localObject.length) {
          break;
        }
        localObject[i].animateRefresh();
        i += 1;
      }
    }
  }
  
  public void setCustomAnimation(AnimatingBall paramAnimatingBall)
  {
    this.mCustomAnimation = paramAnimatingBall;
    this.mCustomAnimation.setInvalidateCallback(this);
  }
  
  public void setCustomHippyRefreshView(View paramView)
  {
    View localView = this.mCustomHippyRefreshView;
    if (localView != null) {
      localView.removeOnLayoutChangeListener(this.mCustomRefreshViewLayoutChangeListener);
    }
    this.mCustomHippyRefreshView = paramView;
    this.mCustomHippyRefreshView.addOnLayoutChangeListener(this.mCustomRefreshViewLayoutChangeListener);
  }
  
  public void setCustomRefreshBallColor(int paramInt)
  {
    setCustomRefreshBallColor(paramInt, 0, 0);
  }
  
  public void setCustomRefreshBallColor(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mColorType = 3;
    if (paramInt2 == 0) {
      this.refreshBgColor = ResourceUtil.getColor(2131167306);
    } else {
      this.refreshBgColor = paramInt2;
    }
    if (paramInt3 == 0) {
      this.mTipsBgColor = ResourceUtil.getColor(2131167300);
    } else {
      this.mTipsBgColor = paramInt3;
    }
    this.mColor = paramInt1;
    paramInt1 = 0;
    while (paramInt1 < 3)
    {
      this.mBalls[paramInt1].setInitialColor(this.mColor);
      paramInt1 += 1;
    }
    this.mPullDownToRefreshSucIcon = null;
    this.mPullDownToRefreshFailIcon = null;
  }
  
  public void setCustomRefreshHeader(HippyTKDCustomRefreshHeader paramHippyTKDCustomRefreshHeader)
  {
    this.mCustomRefreshHeaderView = paramHippyTKDCustomRefreshHeader;
  }
  
  public void setInternalStageCallback(HippyTKDRefreshHeader.InternalStageCallback paramInternalStageCallback)
  {
    this.mInternalStageCallback = paramInternalStageCallback;
  }
  
  public void setRefreshBallColor(int paramInt)
  {
    this.mColorType = paramInt;
    this.refreshBgColor = ResourceUtil.getColor(2131167306);
    this.mTipsBgColor = ResourceUtil.getColor(2131167300);
    paramInt = this.mColorType;
    if (paramInt != -1)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt == 2) {
            this.mColor = ResourceUtil.getColor(2131167305);
          }
        }
        else {
          this.mColor = ResourceUtil.getColor(2131167301);
        }
      }
      else {
        this.mColor = ResourceUtil.getColor(2131167304);
      }
    }
    else
    {
      this.mColor = ResourceUtil.getColor(2131167303);
      this.refreshBgColor = ResourceUtil.getColor(2131167307);
      this.mTipsBgColor = ResourceUtil.getColor(2131167300);
    }
    paramInt = 0;
    while (paramInt < 3)
    {
      this.mBalls[paramInt].setInitialColor(this.mColor);
      paramInt += 1;
    }
    this.mPullDownToRefreshSucIcon = null;
    this.mPullDownToRefreshFailIcon = null;
  }
  
  public void setRefreshPromptInfo(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mDescriptionText = paramString1;
    this.mDescriptionTextColor = paramInt1;
    this.mDescriptionTextFontSize = paramInt2;
    this.mPullDownToRefreshDesIconWidth = paramInt3;
    this.mPullDownToRefreshDesIconHeigth = paramInt4;
    if (!TextUtils.isEmpty(paramString2)) {
      fetchImage(paramString2, new HippyTKDRefreshHeader.7(this, paramInt5));
    } else {
      this.mPullDownToRefreshDesIcon = null;
    }
    if (!TextUtils.isEmpty(this.mDescriptionText)) {
      this.mRefreshOffset = (this.mContentheight + paramInt5);
    }
    if ((TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(this.mDescriptionText))) {
      this.mRefreshOffset = this.mContentheight;
    }
  }
  
  void setRefreshState(int paramInt)
  {
    if (paramInt == this.mRefreshState) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("harryguo mRefreshState=");
    ((StringBuilder)localObject).append(getStateStr(this.mRefreshState));
    ((StringBuilder)localObject).append(", newState=");
    ((StringBuilder)localObject).append(getStateStr(paramInt));
    ((StringBuilder)localObject).append(",this:");
    ((StringBuilder)localObject).append(this);
    LogUtils.d("QBRefreshHeader", ((StringBuilder)localObject).toString());
    int j = 0;
    if (paramInt == 0)
    {
      localObject = this.mEventExtensions;
      if (localObject != null)
      {
        int k = localObject.length;
        i = 0;
        while (i < k)
        {
          localObject[i].onRefreshWait();
          i += 1;
        }
      }
    }
    if (isCustomRefreshMode()) {
      switch (paramInt)
      {
      default: 
        break;
      case 5: 
        this.mCustomRefreshHeaderView.startSettling();
        break;
      case 4: 
        this.mCustomRefreshHeaderView.startPulling();
        break;
      case 2: 
      case 3: 
      case 6: 
        this.mCustomRefreshHeaderView.endLoadingAnimation(this.mCustomCompleteText);
        break;
      case 1: 
        this.mCustomRefreshHeaderView.startLoadingAnimation();
        break;
      case 0: 
        this.mCustomRefreshHeaderView.onFinishing();
        this.mEnableCustomRefreshHeaderView = false;
      }
    }
    localObject = this.mPromise;
    if ((localObject != null) && (paramInt == 0)) {
      ((Promise)localObject).resolve(Boolean.valueOf(true));
    }
    int i = this.mRefreshState;
    if (i != 0) {
      if (i != 1)
      {
        if ((i != 2) && (i != 3))
        {
          if (i != 5) {
            if (i != 6) {
              break label530;
            }
          }
        }
        else
        {
          if (paramInt == 4)
          {
            stopRefresh();
            hideToast(null, false);
            this.mCb.removeCallbacksDelegate(this.mStayRunnable);
            break label530;
          }
          if (paramInt != 5) {
            break label530;
          }
          stopRefresh();
          this.mShowRefreshBall = false;
          this.mCb.scrollToTop(new HippyTKDRefreshHeader.3(this), this.mHideIndex);
          ThreadManager.getUIHandler().postDelayed(new HippyTKDRefreshHeader.4(this), 1000L);
          break label530;
        }
      }
      else
      {
        if ((paramInt == 2) || (paramInt == 3))
        {
          showToast();
          this.mCb.onShowToast();
        }
        stopRefresh();
        break label530;
      }
    }
    if (paramInt == 1)
    {
      localObject = this.mCustomAnimation;
      i = j;
      if (localObject != null) {
        ((HippyTKDRefreshAnimation)localObject).animateRefresh();
      } else {
        for (;;)
        {
          localObject = this.mBalls;
          if (i >= localObject.length) {
            break;
          }
          localObject[i].animateRefresh();
          i += 1;
        }
      }
      this.mRefreshState = paramInt;
      this.mCb.onRefresh();
      if (this.mPendingCompleteObject != null) {
        this.mCb.postDelayedDelegate(new HippyTKDRefreshHeader.5(this), 50L);
      }
      return;
    }
    Log.d("QBRefreshHeader", "refresh notify");
    label530:
    this.mRefreshState = paramInt;
  }
  
  public void setRefreshToastAlpha(float paramFloat)
  {
    this.mRefreshToastAlpha = paramFloat;
    this.mCb.postInvalidate();
  }
  
  public void setRefreshToastInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != 0) {
      this.mCustomTipTextColor = ResourceUtil.getColor(paramInt1);
    }
    this.mCustomTipTextSize = paramInt2;
    this.mCustomTipBackgroundColorID = paramInt3;
  }
  
  public void setRefreshToastOffsetY(float paramFloat)
  {
    this.mRefreshToastOffsetY = paramFloat;
    this.mCb.postInvalidate();
  }
  
  public void setRefreshToastSize(float paramFloat)
  {
    this.mRefreshToastSize = paramFloat;
    this.mCb.postInvalidate();
  }
  
  public void setRefreshWithTargetType(int paramInt)
  {
    this.mTargetRefreshType = paramInt;
  }
  
  void showToast()
  {
    Log.d("QBRefreshHeader", "showAnimator");
    this.hideAnimator.cancel();
    this.showAnimator.start();
  }
  
  public void startRefresh(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startRefresh:init=");
    localStringBuilder.append(paramBoolean);
    Log.d("QBRefreshHeader", localStringBuilder.toString());
    if (this.mRefreshState == 0)
    {
      Log.d("QBRefreshHeader", "startRefresh:1");
      if (paramBoolean)
      {
        this.mCb.scrollToShowHeaderAtOnce(this.mRefreshOffset);
        setRefreshState(1);
        return;
      }
      this.mCb.scrollToShowHeader(this.mRefreshOffset, new HippyTKDRefreshHeader.11(this));
      Log.d("QBRefreshHeader", "setRefreshState bb");
      setRefreshState(5);
    }
  }
  
  public void startRefreshOnlyWithAimation(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startRefreshOnlyWithAimation:init=");
    localStringBuilder.append(paramBoolean);
    Log.d("QBRefreshHeader", localStringBuilder.toString());
    if (this.mRefreshState == 0)
    {
      Log.d("QBRefreshHeader", "startRefresh:1");
      if (paramBoolean)
      {
        this.mCb.scrollToShowHeaderAtOnce(this.mRefreshOffset);
        setFakeRefreshState(1);
        return;
      }
      this.mCb.scrollToShowHeader(this.mRefreshOffset, new HippyTKDRefreshHeader.12(this));
      Log.d("QBRefreshHeader", "setRefreshState bb");
      setFakeRefreshState(5);
    }
  }
  
  public void startRefreshWithType(boolean paramBoolean)
  {
    HippyTKDCustomRefreshHeader localHippyTKDCustomRefreshHeader = this.mCustomRefreshHeaderView;
    if ((localHippyTKDCustomRefreshHeader != null) && (this.mRefreshState == 0))
    {
      this.mEnableCustomRefreshHeaderView = true;
      if (paramBoolean)
      {
        this.mCb.scrollToShowHeaderAtOnce(localHippyTKDCustomRefreshHeader.getRefreshViewHeight());
        setRefreshState(1);
        return;
      }
      this.mCb.scrollToShowHeader(localHippyTKDCustomRefreshHeader.getRefreshViewHeight(), new HippyTKDRefreshHeader.10(this));
      setRefreshState(5);
    }
  }
  
  String stateToString(int paramInt)
  {
    if (paramInt == 3) {
      return "failed";
    }
    if (paramInt == 6) {
      return "notcare";
    }
    if (paramInt == 1) {
      return "refreshing";
    }
    if (paramInt == 4) {
      return "pulling";
    }
    if (paramInt == 2) {
      return "succ";
    }
    if (paramInt == 5) {
      return "settlling";
    }
    if (paramInt == 0) {
      return "wait";
    }
    return "";
  }
  
  public void stopRefresh()
  {
    Object localObject = this.mCustomAnimation;
    if (localObject != null)
    {
      ((HippyTKDRefreshAnimation)localObject).stopAllAnimators();
      return;
    }
    localObject = this.mBalls;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localObject[i].stopAllAnimators();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader
 * JD-Core Version:    0.7.0.1
 */