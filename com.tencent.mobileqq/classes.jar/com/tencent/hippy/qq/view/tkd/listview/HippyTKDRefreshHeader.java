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
import com.tencent.mobileqq.theme.ThemeUtil;
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
  boolean isSuccess = false;
  LinearGradient mBackGradient;
  AnimatingBall[] mBalls;
  public HippyTKDRefreshHeader.RefreshableCallback mCb;
  int mColor;
  int mColorType;
  public int mContentheight = CONTENT_HEIGHT + REFRESH_HEADER_TOP_PADDING;
  HippyTKDRefreshAnimation mCustomAnimation = null;
  String mCustomCompleteText;
  private View mCustomHippyRefreshView;
  private HippyTKDCustomRefreshHeader mCustomRefreshHeaderView = null;
  private View.OnLayoutChangeListener mCustomRefreshViewLayoutChangeListener;
  int mCustomTipBackgroundColorID = 0;
  int mCustomTipBgBeginColor = 0;
  int mCustomTipBgEndColor = 0;
  int mCustomTipTextColor;
  int mCustomTipTextSize = 0;
  String mDescriptionText;
  int mDescriptionTextColor;
  int mDescriptionTextFontSize = ImmersiveUtils.dpToPx(12.0F);
  private boolean mEnableCustomRefreshHeaderView = false;
  private IHippyTKDRefreshHeaderEventExtension[] mEventExtensions;
  private int mHideIndex = 0;
  private View mHostView = null;
  private String mIconUrl = null;
  private int mInitLayerType = 0;
  HippyTKDRefreshHeader.InternalStageCallback mInternalStageCallback = null;
  Paint mPaint = new Paint();
  private HippyTKDRefreshHeader.PendingComplete mPendingCompleteObject = null;
  Promise mPromise;
  public BitmapDrawable mPullDownToRefreshDesIcon;
  public int mPullDownToRefreshDesIconHeigth;
  public int mPullDownToRefreshDesIconWidth;
  public int mPullDownToRefreshDistanceBetweenIconText = ImmersiveUtils.dpToPx(8.0F);
  public Drawable mPullDownToRefreshFailIcon;
  public Drawable mPullDownToRefreshSucIcon;
  public String mPullDownToRefreshTextFail = ResourceUtil.getString(2131718501);
  public HippyTKDUISize mPullDownToRefreshTextFailTextSize = new HippyTKDUISize();
  public String mPullDownToRefreshTextSuc = ResourceUtil.getString(2131718502);
  public HippyTKDUISize mPullDownToRefreshTextSucTextSize = new HippyTKDUISize();
  public Drawable mRefreshDrawable;
  public int mRefreshOffset = CONTENT_HEIGHT + REFRESH_HEADER_TOP_PADDING;
  public int mRefreshState = 0;
  float mRefreshToastAlpha;
  float mRefreshToastOffsetY;
  float mRefreshToastSize;
  private boolean mShowRefreshBall = true;
  boolean mShowRefreshIcon = true;
  boolean mStatShow5p = false;
  boolean mStatShow80p = false;
  Runnable mStayRunnable = new HippyTKDRefreshHeader.1(this);
  private int mTargetRefreshType = -1;
  int mTipsBgColor;
  private Paint mToastBgPaint = new Paint();
  private RectF mToastBgRect = new RectF();
  PropertyValuesHolder offsetHolderShow;
  public int refreshBgColor = 0;
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
    this.mCb = paramRefreshableCallback;
    this.gm = new UIGdiMeasure();
    this.gm.setFontSize(ImmersiveUtils.dpToPx(12.0F));
    this.gm.getStringWidthHeight(this.mPullDownToRefreshTextSuc, this.mPullDownToRefreshTextSucTextSize);
    this.gm.getStringWidthHeight(this.mPullDownToRefreshTextFail, this.mPullDownToRefreshTextFailTextSize);
    this.mBalls = new AnimatingBall[3];
    int i = 0;
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
    this.mDescriptionTextColor = ResourceUtil.getColor(2131167273);
  }
  
  private String getStateStr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "WAIT";
    case 1: 
      return "ING";
    case 2: 
      return "SUCCESSS";
    case 6: 
      return "NOTCARE";
    case 3: 
      return "FAILED";
    case 4: 
      return "PULLING";
    }
    return "SETTLING";
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
    Log.e("QBRefreshHeader", "setRefreshState:old=" + stateToString(this.mRefreshState) + ",new=" + stateToString(paramInt));
    switch (this.mRefreshState)
    {
    }
    for (;;)
    {
      this.mRefreshState = paramInt;
      return;
      if (paramInt == 1)
      {
        int i = 0;
        while (i < this.mBalls.length)
        {
          this.mBalls[i].animateRefresh();
          i += 1;
        }
        this.mRefreshState = paramInt;
        return;
      }
      Log.d("QBRefreshHeader", "refresh notify");
    }
  }
  
  public void addExternalStageInfo(HippyTKDRefreshHeader.ExternalStageInfo paramExternalStageInfo) {}
  
  public void advancedStopRefresh()
  {
    if ((this.mRefreshState == 2) || (this.mRefreshState == 3))
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
    Log.d("HippyQBRefreshHeader", "completeRefresh state " + stateToString(this.mRefreshState));
    this.mCustomTipBgBeginColor = paramInt2;
    this.mCustomTipBgEndColor = paramInt3;
    this.mCustomTipTextColor = paramInt4;
    this.mCustomTipTextSize = paramInt5;
    this.mPromise = paramPromise;
    this.mBackGradient = null;
    this.mHideIndex = paramInt6;
    if ((this.mCustomTipBgBeginColor != 0) && (this.mCustomTipBgEndColor != 0))
    {
      this.offsetHolderShow.setFloatValues(new float[] { 0.0F, 0.0F });
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
      if (this.mRefreshState == 1) {
        break label397;
      }
      if (((this.mRefreshState != 2) && (this.mRefreshState != 3)) || ((paramInt1 != 2) && (paramInt1 != 3))) {
        break label361;
      }
      Log.d("QBRefreshHeader", "completeRefresh:already in success or fail, update toast info, mRefreshState=" + this.mRefreshState);
      if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.mCustomCompleteText)))
      {
        this.mCustomCompleteText = paramString1;
        this.mShowRefreshIcon = paramBoolean;
        paramString1 = this.gm;
        if (this.mCustomTipTextSize == 0) {
          break label352;
        }
        paramInt1 = this.mCustomTipTextSize;
        paramString1.setFontSize(paramInt1);
        this.gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextSucTextSize);
        this.gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextFailTextSize);
        postInvalidate();
      }
    }
    label352:
    label361:
    while (paramInt1 == 1) {
      for (;;)
      {
        return;
        this.offsetHolderShow.setFloatValues(new float[] { -this.mContentheight, 0.0F });
        break;
        paramInt1 = ImmersiveUtils.dpToPx(12.0F);
      }
    }
    if (this.mPendingCompleteObject == null) {
      this.mPendingCompleteObject = new HippyTKDRefreshHeader.PendingComplete();
    }
    this.mPendingCompleteObject.setPendingCompleteInfo(paramString1, paramBoolean, paramLong);
    return;
    label397:
    if (!TextUtils.isEmpty(paramString1))
    {
      this.mCustomCompleteText = paramString1;
      this.mShowRefreshIcon = paramBoolean;
      paramString1 = this.gm;
      if (this.mCustomTipTextSize != 0)
      {
        paramInt2 = this.mCustomTipTextSize;
        paramString1.setFontSize(paramInt2);
        this.gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextSucTextSize);
        this.gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextFailTextSize);
      }
    }
    else
    {
      if (this.mCb.getOffsetY() >= 0) {
        break label612;
      }
      Log.d("QBRefreshHeader", "completeRefresh offset<=0");
      if (paramInt1 != 2) {
        break label574;
      }
      setRefreshState(2);
      this.isSuccess = true;
      label503:
      this.mCb.removeCallbacksDelegate(this.mStayRunnable);
      this.mCb.removeOnScrollFinishListener();
      paramString1 = this.mCb;
      paramString2 = this.mStayRunnable;
      if (paramInt1 == 1) {
        break label606;
      }
    }
    for (;;)
    {
      paramString1.postDelayedDelegate(paramString2, paramLong);
      this.mCb.scrollToShowHeaderSmooth(this.mContentheight);
      return;
      paramInt2 = ImmersiveUtils.dpToPx(12.0F);
      break;
      label574:
      if (paramInt1 == 3)
      {
        setRefreshState(3);
        this.isSuccess = false;
        break label503;
      }
      if (paramInt1 != 1) {
        break label503;
      }
      setRefreshState(6);
      break label503;
      label606:
      paramLong = 0L;
    }
    label612:
    this.mCb.scrollToTopAtOnce();
    setRefreshState(0);
  }
  
  public void completeRefresh(int paramInt, String paramString, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    if (this.mRefreshState != 1)
    {
      if (((this.mRefreshState == 2) || (this.mRefreshState == 3)) && ((paramInt == 2) || (paramInt == 3)))
      {
        Log.d("QBRefreshHeader", "completeRefresh:already in success or fail, update toast info, mRefreshState=" + this.mRefreshState);
        if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.mCustomCompleteText)))
        {
          this.mCustomCompleteText = paramString;
          this.mShowRefreshIcon = paramBoolean1;
          paramString = this.gm;
          if (this.mCustomTipTextSize == 0) {
            break label148;
          }
          paramInt = this.mCustomTipTextSize;
          paramString.setFontSize(paramInt);
          this.gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextSucTextSize);
          this.gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextFailTextSize);
          postInvalidate();
        }
      }
      label148:
      while (paramInt == 1) {
        for (;;)
        {
          return;
          paramInt = ImmersiveUtils.dpToPx(12.0F);
        }
      }
      if (this.mPendingCompleteObject == null) {
        this.mPendingCompleteObject = new HippyTKDRefreshHeader.PendingComplete();
      }
      this.mPendingCompleteObject.setPendingCompleteInfo(paramString, paramBoolean1, paramLong);
      return;
    }
    int i;
    label304:
    Runnable localRunnable;
    if (!TextUtils.isEmpty(paramString))
    {
      this.mCustomCompleteText = paramString;
      this.mShowRefreshIcon = paramBoolean1;
      paramString = this.gm;
      if (this.mCustomTipTextSize != 0)
      {
        i = this.mCustomTipTextSize;
        paramString.setFontSize(i);
        this.gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextSucTextSize);
        this.gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextFailTextSize);
      }
    }
    else
    {
      if ((this.mCb.getOffsetY() >= 0) && (!paramBoolean2)) {
        break label401;
      }
      Log.d("QBRefreshHeader", "completeRefresh offset<=0");
      if (paramInt != 2) {
        break label363;
      }
      setRefreshState(2);
      this.isSuccess = true;
      this.mCb.removeCallbacksDelegate(this.mStayRunnable);
      this.mCb.removeOnScrollFinishListener();
      paramString = this.mCb;
      localRunnable = this.mStayRunnable;
      if (paramInt == 1) {
        break label395;
      }
    }
    for (;;)
    {
      paramString.postDelayedDelegate(localRunnable, paramLong);
      return;
      i = ImmersiveUtils.dpToPx(12.0F);
      break;
      label363:
      if (paramInt == 3)
      {
        setRefreshState(3);
        this.isSuccess = false;
        break label304;
      }
      if (paramInt != 1) {
        break label304;
      }
      setRefreshState(6);
      break label304;
      label395:
      paramLong = 0L;
    }
    label401:
    this.mCb.scrollToTopAtOnce();
    setRefreshState(0);
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
    if ((((URLDrawable)localObject).getStatus() == 2) || (((URLDrawable)localObject).getStatus() == 3))
    {
      ((URLDrawable)localObject).restartDownload();
      return;
    }
    ((URLDrawable)localObject).startDownload();
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
    }
    while (paramRunnable == null) {
      return;
    }
    paramRunnable.run();
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
    return (this.mRefreshState == 1) || (this.mRefreshState == 3) || (this.mRefreshState == 2) || (this.mRefreshState == 6);
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
    int i = 1;
    int j = 1;
    int k = 255;
    if (bool)
    {
      if ((this.mCustomRefreshHeaderView == null) || (!this.mCustomRefreshHeaderView.isShowMasterRefreshText())) {
        break label213;
      }
      i = 1;
      if ((this.mCustomRefreshHeaderView == null) || (!this.mCustomRefreshHeaderView.isShowMasterRefreshToastBg())) {
        break label219;
      }
      j = 1;
      label62:
      if (this.mCustomRefreshHeaderView == null) {
        break label225;
      }
    }
    int i1;
    label213:
    label219:
    label225:
    for (k = this.mCustomRefreshHeaderView.getMasterRefreshTextAlpha();; k = 255)
    {
      this.mCustomRefreshHeaderView.onTranslating(-this.mCb.getOffsetY());
      paramCanvas.save();
      paramCanvas.translate(0.0F, -this.mCb.getOffsetY() - this.mCustomRefreshHeaderView.getRefreshViewHeight());
      this.mCustomRefreshHeaderView.draw(paramCanvas);
      paramCanvas.restore();
      i1 = paramCanvas.save();
      if ((this.mCustomHippyRefreshView == null) || (this.mRefreshState == 0)) {
        break label233;
      }
      paramCanvas.save();
      paramCanvas.translate(0.0F, -this.mCb.getOffsetY() - this.mCustomHippyRefreshView.getHeight());
      this.mCustomHippyRefreshView.draw(paramCanvas);
      this.mCb.postInvalidate();
      paramCanvas.restore();
      paramCanvas.restoreToCount(i1);
      return;
      i = 0;
      break;
      j = 0;
      break label62;
    }
    label233:
    if (!bool)
    {
      this.mPaint.setColor(this.refreshBgColor);
      paramCanvas.drawRect(0.0F, 0.0F, this.mCb.getWidth(), -this.mCb.getOffsetY(), this.mPaint);
    }
    int n = (this.mCb.getWidth() - (AnimatingBall.BALL_SIZE * 2 + BALL_MARGIN_H * 2)) / 2;
    if ((this.mShowRefreshBall) && (this.mRefreshState != 3) && (this.mRefreshState != 2))
    {
      if (this.mCustomAnimation != null) {
        this.mCustomAnimation.draw(paramCanvas, this.mCb.getOffsetY(), 2147483647, n);
      }
      for (;;)
      {
        if ((this.mPullDownToRefreshDesIcon == null) || (this.mPullDownToRefreshDesIcon.getBitmap() == null) || (this.mPullDownToRefreshDesIcon.getBitmap().isRecycled())) {
          break label1533;
        }
        try
        {
          m = (this.mCb.getWidth() - this.mPullDownToRefreshDesIconWidth) / 2;
          n = -this.mCb.getOffsetY() - this.mContentheight - this.mPullDownToRefreshDesIconHeigth - ImmersiveUtils.dpToPx(0.0F);
          if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
            this.mPullDownToRefreshDesIcon.setColorFilter(-2147483648, PorterDuff.Mode.SRC_ATOP);
          }
          for (;;)
          {
            this.mPullDownToRefreshDesIcon.setBounds(m, n, this.mPullDownToRefreshDesIconWidth + m, this.mPullDownToRefreshDesIconHeigth + n);
            this.mPullDownToRefreshDesIcon.draw(paramCanvas);
            if ((this.mStatShow80p) || (-(this.mCb.getOffsetY() + this.mContentheight) / this.mPullDownToRefreshDesIconHeigth <= 0.8D)) {
              break label1444;
            }
            this.mStatShow80p = true;
            if (this.mEventExtensions == null) {
              break label1444;
            }
            IHippyTKDRefreshHeaderEventExtension[] arrayOfIHippyTKDRefreshHeaderEventExtension = this.mEventExtensions;
            n = arrayOfIHippyTKDRefreshHeaderEventExtension.length;
            m = 0;
            while (m < n)
            {
              arrayOfIHippyTKDRefreshHeaderEventExtension[m].onRefreshHeaderShow80P();
              m += 1;
            }
            if (bool) {
              break;
            }
            m = 0;
            while (m < this.mBalls.length)
            {
              this.mBalls[m].draw(paramCanvas, this.mCb.getOffsetY(), 2147483647, n);
              m += 1;
            }
            this.mPullDownToRefreshDesIcon.clearColorFilter();
          }
          if (this.mRefreshToastOffsetY <= -this.mContentheight) {
            break label1437;
          }
        }
        catch (Exception localException) {}
      }
    }
    int i2 = paramCanvas.saveLayerAlpha(0.0F, this.mRefreshToastOffsetY, this.mCb.getWidth(), this.mContentheight, (int)(255.0F * this.mRefreshToastAlpha), 31);
    int m = this.mPaint.getAlpha();
    label752:
    float f1;
    Object localObject1;
    float f2;
    label970:
    label986:
    label1002:
    Object localObject2;
    label1021:
    Drawable localDrawable;
    if (j != 0)
    {
      paramCanvas.translate(0.0F, this.mRefreshToastOffsetY);
      paramCanvas.clipRect(0, 0, this.mCb.getWidth(), this.mContentheight);
      if (this.mCustomTipBackgroundColorID != 0)
      {
        j = ResourceUtil.getColor(this.mCustomTipBackgroundColorID);
        paramCanvas.drawColor(j);
        this.mPaint.setAlpha(Color.alpha(this.mCustomTipBgBeginColor));
        if (this.mBackGradient == null)
        {
          f1 = this.mCb.getWidth();
          j = this.mCustomTipBgBeginColor;
          n = this.mCustomTipBgEndColor;
          localObject1 = Shader.TileMode.CLAMP;
          this.mBackGradient = new LinearGradient(0.0F, 0.0F, f1, 0.0F, new int[] { j, n }, null, (Shader.TileMode)localObject1);
        }
        this.mPaint.setShader(this.mBackGradient);
        f1 = this.mCb.getWidth() / 2;
        f2 = this.mCb.getWidth() / 2;
        float f3 = this.mRefreshToastSize;
        float f4 = this.mCb.getWidth() / 2;
        paramCanvas.drawRect(f1 - f2 * f3, 0.0F, this.mCb.getWidth() / 2 * this.mRefreshToastSize + f4, this.mContentheight, this.mPaint);
      }
    }
    else
    {
      this.mPaint.setShader(null);
      this.mPaint.setAlpha(m);
      if (TextUtils.isEmpty(this.mCustomCompleteText)) {
        break label1677;
      }
      localObject1 = this.mCustomCompleteText;
      if (this.isSuccess) {
        break label1702;
      }
      j = this.mPullDownToRefreshTextFailTextSize.mWidth;
      if (this.isSuccess) {
        break label1714;
      }
      m = this.mPullDownToRefreshTextFailTextSize.mHeight;
      localObject2 = this.mPaint;
      if (this.mCustomTipTextSize == 0) {
        break label1726;
      }
      f1 = this.mCustomTipTextSize;
      ((Paint)localObject2).setTextSize(f1);
      localObject2 = this.mPaint;
      if (this.mCustomTipTextColor == 0) {
        break label1736;
      }
      n = this.mCustomTipTextColor;
      label1046:
      ((Paint)localObject2).setColor(n);
      f1 = (this.mContentheight - REFRESH_HEADER_TOP_PADDING - m) / 2 + REFRESH_HEADER_TOP_PADDING;
      if (!this.mShowRefreshIcon) {
        break label1827;
      }
      if (i != 0)
      {
        m = paramCanvas.save();
        if (!this.isSuccess) {
          break label1754;
        }
        if (this.mPullDownToRefreshSucIcon == null)
        {
          localObject2 = ResourceUtil.getBitmap(2130851103);
          if (this.mCustomTipTextColor == 0) {
            break label1745;
          }
          i = this.mCustomTipTextColor;
          label1125:
          this.mPullDownToRefreshSucIcon = UIBitmapUtils.getColorImage((Bitmap)localObject2, i);
        }
        localObject2 = this.mPullDownToRefreshSucIcon;
        localDrawable = null;
        if (this.mTargetRefreshType == 3)
        {
          if (!ThemeUtil.isNowThemeIsNight(null, false, "")) {
            break label1811;
          }
          i = -2147483648;
          label1169:
          localDrawable = UIBitmapUtils.getColorImage(ResourceUtil.getBitmap(2130851101), i);
        }
        n = this.mCb.getWidth();
        int i3 = ((Drawable)localObject2).getIntrinsicWidth();
        int i4 = this.mPullDownToRefreshDistanceBetweenIconText;
        if (localDrawable != null) {
          break label1817;
        }
        i = 0;
        label1214:
        i = (n - i3 - i4 - j - i) / 2;
        n = (this.mContentheight - REFRESH_HEADER_TOP_PADDING - ((Drawable)localObject2).getIntrinsicHeight()) / 2 + REFRESH_HEADER_TOP_PADDING;
        ((Drawable)localObject2).setBounds(i, n, ((Drawable)localObject2).getIntrinsicWidth() + i, ((Drawable)localObject2).getIntrinsicHeight() + n);
        ((Drawable)localObject2).setAlpha(k);
        ((Drawable)localObject2).draw(paramCanvas);
        paramCanvas.restoreToCount(m);
        this.mPaint.setAlpha(k);
        UIStringUtils.drawText(paramCanvas, this.mPaint, ((Drawable)localObject2).getIntrinsicWidth() + i + this.mPullDownToRefreshDistanceBetweenIconText, f1, (String)localObject1);
        if ((this.mTargetRefreshType == 3) && (localDrawable != null))
        {
          i = (int)(((Drawable)localObject2).getIntrinsicWidth() + i + this.mPullDownToRefreshDistanceBetweenIconText + j + PixelUtil.dp2px(8.0F));
          j = (this.mContentheight - REFRESH_HEADER_TOP_PADDING - localDrawable.getIntrinsicHeight()) / 2 + REFRESH_HEADER_TOP_PADDING;
          localDrawable.setBounds(i, j, localDrawable.getIntrinsicWidth() + i, localDrawable.getIntrinsicHeight() + j);
          localDrawable.setAlpha(k);
          localDrawable.draw(paramCanvas);
        }
      }
    }
    for (;;)
    {
      paramCanvas.restoreToCount(i2);
      label1437:
      paramCanvas.restoreToCount(i1);
      return;
      label1444:
      if ((this.mStatShow5p) || (-(this.mCb.getOffsetY() + this.mContentheight) / this.mPullDownToRefreshDesIconHeigth <= 0.05D)) {
        break;
      }
      this.mStatShow5p = true;
      if (this.mEventExtensions == null) {
        break;
      }
      localObject1 = this.mEventExtensions;
      n = localObject1.length;
      m = 0;
      while (m < n)
      {
        localObject1[m].onRefreshHeaderShow5P();
        m += 1;
      }
      break;
      label1533:
      if ((TextUtils.isEmpty(this.mDescriptionText)) || (i == 0)) {
        break;
      }
      this.mPaint.setTextSize(this.mDescriptionTextFontSize);
      this.mPaint.setColor(this.mDescriptionTextColor);
      n = UIUtilBase.getTextWidth(this.mDescriptionText, this.mPaint, this.mDescriptionTextFontSize);
      m = UIUtilBase.getTextHeight(this.mPaint, this.mDescriptionTextFontSize);
      n = (this.mCb.getWidth() - n) / 2;
      this.mPaint.setAlpha(k);
      UIStringUtils.drawText(paramCanvas, this.mPaint, n, -this.mCb.getOffsetY() - this.mContentheight - m - ImmersiveUtils.dpToPx(0.0F), this.mDescriptionText);
      break;
      j = this.mTipsBgColor;
      break label752;
      label1677:
      if (this.isSuccess)
      {
        localObject1 = this.mPullDownToRefreshTextSuc;
        break label970;
      }
      localObject1 = this.mPullDownToRefreshTextFail;
      break label970;
      label1702:
      j = this.mPullDownToRefreshTextSucTextSize.mWidth;
      break label986;
      label1714:
      m = this.mPullDownToRefreshTextSucTextSize.mHeight;
      break label1002;
      label1726:
      f1 = ImmersiveUtils.dpToPx(12.0F);
      break label1021;
      label1736:
      n = this.mColor;
      break label1046;
      label1745:
      i = this.mColor;
      break label1125;
      label1754:
      if (this.mPullDownToRefreshFailIcon == null)
      {
        localObject2 = ResourceUtil.getBitmap(2130851102);
        if (this.mCustomTipTextColor == 0) {
          break label1802;
        }
      }
      label1802:
      for (i = this.mCustomTipTextColor;; i = this.mColor)
      {
        this.mPullDownToRefreshFailIcon = UIBitmapUtils.getColorImage((Bitmap)localObject2, i);
        localObject2 = this.mPullDownToRefreshFailIcon;
        break;
      }
      label1811:
      i = 0;
      break label1169;
      label1817:
      i = localDrawable.getIntrinsicWidth();
      break label1214;
      label1827:
      if (i != 0)
      {
        f2 = (this.mCb.getWidth() - j) / 2.0F;
        this.mPaint.setAlpha(k);
        UIStringUtils.drawText(paramCanvas, this.mPaint, f2, f1, (String)localObject1);
      }
    }
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
    for (;;)
    {
      if (this.mCb.getOffsetY() >= 0)
      {
        this.mStatShow80p = false;
        this.mStatShow5p = false;
      }
      return true;
      setRefreshState(0);
    }
  }
  
  public void onSwitchSkin()
  {
    if (this.mColorType != 3) {
      setRefreshBallColor(this.mColorType);
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
      if (this.mRefreshState == 4)
      {
        if (this.mCb.getOffsetY() < -this.mRefreshOffset)
        {
          Log.d("QBRefreshHeader", "onUpAction,scroll to show header");
          this.mCb.onAboutToRefresh();
          this.mCb.scrollToShowHeader(this.mRefreshOffset, new HippyTKDRefreshHeader.8(this));
          Log.d("QBRefreshHeader", "setRefreshState cc");
          setRefreshState(5);
          if (this.mInternalStageCallback != null) {
            this.mInternalStageCallback.onUpAction(1);
          }
        }
        for (;;)
        {
          return true;
          Log.d("QBRefreshHeader", "onUpAction,scrollToTop");
          this.mCb.scrollToTop(new HippyTKDRefreshHeader.9(this), 0);
          Log.d("QBRefreshHeader", "setRefreshState dd");
          setRefreshState(5);
          if (this.mInternalStageCallback != null) {
            this.mInternalStageCallback.onUpAction(0);
          }
        }
      }
      if ((this.mRefreshState == 1) || (this.mRefreshState == 2) || (this.mRefreshState == 3))
      {
        Log.d("QBRefreshHeader", "onUpAction,pulling");
        return true;
      }
      Log.d("QBRefreshHeader", "onUpAction,not pulling or settling");
      return false;
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
      if (this.mCustomAnimation == null) {
        break label25;
      }
      this.mCustomAnimation.animateRefresh();
    }
    for (;;)
    {
      return;
      label25:
      int i = 0;
      while (i < this.mBalls.length)
      {
        this.mBalls[i].animateRefresh();
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
    if (this.mCustomHippyRefreshView != null) {
      this.mCustomHippyRefreshView.removeOnLayoutChangeListener(this.mCustomRefreshViewLayoutChangeListener);
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
    if (paramInt2 == 0)
    {
      this.refreshBgColor = ResourceUtil.getColor(2131167280);
      if (paramInt3 != 0) {
        break label73;
      }
    }
    label73:
    for (this.mTipsBgColor = ResourceUtil.getColor(2131167274);; this.mTipsBgColor = paramInt3)
    {
      this.mColor = paramInt1;
      paramInt1 = 0;
      while (paramInt1 < 3)
      {
        this.mBalls[paramInt1].setInitialColor(this.mColor);
        paramInt1 += 1;
      }
      this.refreshBgColor = paramInt2;
      break;
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
    this.refreshBgColor = ResourceUtil.getColor(2131167280);
    this.mTipsBgColor = ResourceUtil.getColor(2131167274);
    switch (this.mColorType)
    {
    }
    for (;;)
    {
      paramInt = 0;
      while (paramInt < 3)
      {
        this.mBalls[paramInt].setInitialColor(this.mColor);
        paramInt += 1;
      }
      this.mColor = ResourceUtil.getColor(2131167277);
      this.refreshBgColor = ResourceUtil.getColor(2131167281);
      this.mTipsBgColor = ResourceUtil.getColor(2131167274);
      continue;
      this.mColor = ResourceUtil.getColor(2131167278);
      continue;
      this.mColor = ResourceUtil.getColor(2131167275);
      continue;
      this.mColor = ResourceUtil.getColor(2131167279);
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
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.mDescriptionText)) {
        this.mRefreshOffset = (this.mContentheight + paramInt5);
      }
      if ((TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(this.mDescriptionText))) {
        this.mRefreshOffset = this.mContentheight;
      }
      return;
      this.mPullDownToRefreshDesIcon = null;
    }
  }
  
  void setRefreshState(int paramInt)
  {
    int j = 0;
    if (paramInt == this.mRefreshState) {
      return;
    }
    LogUtils.d("QBRefreshHeader", "harryguo mRefreshState=" + getStateStr(this.mRefreshState) + ", newState=" + getStateStr(paramInt) + ",this:" + this);
    int i;
    if ((paramInt == 0) && (this.mEventExtensions != null))
    {
      IHippyTKDRefreshHeaderEventExtension[] arrayOfIHippyTKDRefreshHeaderEventExtension = this.mEventExtensions;
      int k = arrayOfIHippyTKDRefreshHeaderEventExtension.length;
      i = 0;
      while (i < k)
      {
        arrayOfIHippyTKDRefreshHeaderEventExtension[i].onRefreshWait();
        i += 1;
      }
    }
    if (isCustomRefreshMode()) {}
    switch (paramInt)
    {
    default: 
      label164:
      if ((this.mPromise != null) && (paramInt == 0)) {
        this.mPromise.resolve(Boolean.valueOf(true));
      }
      switch (this.mRefreshState)
      {
      }
      break;
    }
    for (;;)
    {
      this.mRefreshState = paramInt;
      return;
      this.mCustomRefreshHeaderView.endLoadingAnimation(this.mCustomCompleteText);
      break label164;
      this.mCustomRefreshHeaderView.startLoadingAnimation();
      break label164;
      this.mCustomRefreshHeaderView.startSettling();
      break label164;
      this.mCustomRefreshHeaderView.startPulling();
      break label164;
      this.mCustomRefreshHeaderView.onFinishing();
      this.mEnableCustomRefreshHeaderView = false;
      break label164;
      if (paramInt == 4)
      {
        stopRefresh();
        hideToast(null, false);
        this.mCb.removeCallbacksDelegate(this.mStayRunnable);
      }
      else if (paramInt == 5)
      {
        stopRefresh();
        this.mShowRefreshBall = false;
        this.mCb.scrollToTop(new HippyTKDRefreshHeader.3(this), this.mHideIndex);
        ThreadManager.getUIHandler().postDelayed(new HippyTKDRefreshHeader.4(this), 1000L);
        continue;
        if ((paramInt == 2) || (paramInt == 3))
        {
          showToast();
          this.mCb.onShowToast();
        }
        stopRefresh();
        continue;
        if (paramInt == 1)
        {
          i = j;
          if (this.mCustomAnimation != null) {
            this.mCustomAnimation.animateRefresh();
          }
          for (;;)
          {
            this.mRefreshState = paramInt;
            this.mCb.onRefresh();
            if (this.mPendingCompleteObject == null) {
              break;
            }
            this.mCb.postDelayedDelegate(new HippyTKDRefreshHeader.5(this), 50L);
            return;
            while (i < this.mBalls.length)
            {
              this.mBalls[i].animateRefresh();
              i += 1;
            }
          }
        }
        Log.d("QBRefreshHeader", "refresh notify");
      }
    }
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
    Log.d("QBRefreshHeader", "startRefresh:init=" + paramBoolean);
    if (this.mRefreshState == 0)
    {
      Log.d("QBRefreshHeader", "startRefresh:1");
      if (paramBoolean)
      {
        this.mCb.scrollToShowHeaderAtOnce(this.mRefreshOffset);
        setRefreshState(1);
      }
    }
    else
    {
      return;
    }
    this.mCb.scrollToShowHeader(this.mRefreshOffset, new HippyTKDRefreshHeader.11(this));
    Log.d("QBRefreshHeader", "setRefreshState bb");
    setRefreshState(5);
  }
  
  public void startRefreshOnlyWithAimation(boolean paramBoolean)
  {
    Log.d("QBRefreshHeader", "startRefreshOnlyWithAimation:init=" + paramBoolean);
    if (this.mRefreshState == 0)
    {
      Log.d("QBRefreshHeader", "startRefresh:1");
      if (paramBoolean)
      {
        this.mCb.scrollToShowHeaderAtOnce(this.mRefreshOffset);
        setFakeRefreshState(1);
      }
    }
    else
    {
      return;
    }
    this.mCb.scrollToShowHeader(this.mRefreshOffset, new HippyTKDRefreshHeader.12(this));
    Log.d("QBRefreshHeader", "setRefreshState bb");
    setFakeRefreshState(5);
  }
  
  public void startRefreshWithType(boolean paramBoolean)
  {
    if ((this.mCustomRefreshHeaderView != null) && (this.mRefreshState == 0))
    {
      this.mEnableCustomRefreshHeaderView = true;
      if (paramBoolean)
      {
        this.mCb.scrollToShowHeaderAtOnce(this.mCustomRefreshHeaderView.getRefreshViewHeight());
        setRefreshState(1);
      }
    }
    else
    {
      return;
    }
    this.mCb.scrollToShowHeader(this.mCustomRefreshHeaderView.getRefreshViewHeight(), new HippyTKDRefreshHeader.10(this));
    setRefreshState(5);
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
    if (this.mCustomAnimation != null) {
      this.mCustomAnimation.stopAllAnimators();
    }
    for (;;)
    {
      return;
      AnimatingBall[] arrayOfAnimatingBall = this.mBalls;
      int j = arrayOfAnimatingBall.length;
      int i = 0;
      while (i < j)
      {
        arrayOfAnimatingBall[i].stopAllAnimators();
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader
 * JD-Core Version:    0.7.0.1
 */