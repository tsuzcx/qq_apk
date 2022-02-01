package com.tencent.ditto.area;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.ColorInt;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.ditto.reflect.DittoValue;
import com.tencent.ditto.reflect.MustacheParser;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.shell.DittoUIEngine.IReporter;
import com.tencent.ditto.shell.LayoutAttrDefine.Gravity;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.utils.DittoBitmapCache;
import com.tencent.ditto.utils.DittoLog;
import com.tencent.ditto.utils.DittoResourcesUtil;
import com.tencent.ditto.widget.DittoTextAreaCompat;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DittoArea
  extends MeasureCacheable
  implements DittoElement, DittoType
{
  public static LruCache<Integer, Object> mAreaCache = new LruCache(2048);
  public static LruCache<Integer, DittoBitmapCache> mBackgroundCache = new LruCache(5);
  public static int setLayoutAttrCount = 0;
  public static long total = 0L;
  private String areaIdShouldInvokeClick;
  public int borderColor = 0;
  public float[] borderRadius = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  public int borderWidth = 0;
  public DittoArea.ClickListener clickListener;
  private String cmd;
  private int cmdParamKey = -2147483648;
  private String cmdParamType;
  private int[] compassClickKey;
  private int[] compassExposureKey;
  private RectF cornerBound;
  private Path cornerPath;
  private int cornerPathHeight;
  private int cornerPathWidth;
  public int height;
  public String id;
  private boolean ignoreClick = false;
  private boolean isBgDirty = false;
  private boolean isBorderDirty = false;
  public boolean isPressed = false;
  public DittoArea.LongClickListener longClickListener;
  private float mAlpha = 255.0F;
  public Integer mAreaCacheKey = null;
  public Drawable mBackground;
  private Integer mBgCacheKey;
  private int mBgColor;
  private Integer mBorderCacheKey;
  public int mBottom;
  public Rect mBound;
  private DittoBitmapCache mCacheBackground = null;
  private DittoBitmapCache mCacheBorder = null;
  private String mContentDescription;
  public Animation mCurrentAnimation = null;
  public boolean mDrawIgnoreVisible = false;
  public RectF mFBound;
  private Paint mFillPaint;
  private String mGradientDirection;
  private int mGradientEndColor;
  private int mGradientStartColor;
  public int mGravity = 3;
  public DittoHost mHost;
  public LayoutAttrSet mLayoutAttr;
  public int mLeft;
  public Handler mMainHandler = new Handler(Looper.getMainLooper());
  public boolean mMeasureDirty = false;
  public int mMeasuredHeight;
  public int mMeasuredWidth;
  public WeakReference<DittoAreaGroup> mParent;
  private DittoArea.CheckForLongPressRunnable mPendingCheckForLongPress;
  private int mPressedAlpha = 0;
  public int mRight;
  public Drawable mShadowDrawable;
  private Paint mStrokePaint;
  public Object mTag;
  public int mTop;
  private Transformation mTransformation;
  private int mVisibility = 0;
  private WeakReference<Object> mWeakAttachedObject;
  private String onClickUri;
  public int paddingBottom;
  public int paddingLeft;
  public int paddingRight;
  public int paddingTop;
  private DittoValue postClickKey;
  private Rect shadowBound;
  public int shadowSizeBottom;
  public int shadowSizeLeft;
  public int shadowSizeRight;
  public int shadowSizeTop;
  private String silentUri;
  private String silentUriSentToast;
  private int tttReportArea = -1;
  public int width;
  
  public DittoArea(DittoHost paramDittoHost)
  {
    this(paramDittoHost, null);
  }
  
  public DittoArea(DittoHost paramDittoHost, LayoutAttrSet paramLayoutAttrSet)
  {
    this.mHost = paramDittoHost;
    this.mLayoutAttr = paramLayoutAttrSet;
  }
  
  private void checkForLongClick(MotionEvent paramMotionEvent)
  {
    if (this.mPendingCheckForLongPress == null) {
      this.mPendingCheckForLongPress = new DittoArea.CheckForLongPressRunnable(this, null);
    }
    DittoArea.CheckForLongPressRunnable localCheckForLongPressRunnable = this.mPendingCheckForLongPress;
    localCheckForLongPressRunnable.ev = paramMotionEvent;
    this.mMainHandler.removeCallbacks(localCheckForLongPressRunnable);
    this.mMainHandler.postDelayed(this.mPendingCheckForLongPress, ViewConfiguration.getLongPressTimeout());
  }
  
  private void drawBorder(Canvas paramCanvas, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.mCacheBorder = getBackgroundCache(this.mBorderCacheKey);
      Object localObject = this.mCacheBorder;
      if ((localObject == null) || (((DittoBitmapCache)localObject).getBitmap() == null))
      {
        localObject = getStrokePaint();
        ((Paint)localObject).setStrokeWidth(this.borderWidth);
        ((Paint)localObject).setColor(this.borderColor);
        float f = this.borderWidth / 2;
        localObject = new RectF(this.mBound);
        ((RectF)localObject).top += f;
        ((RectF)localObject).left += f;
        ((RectF)localObject).right -= f;
        ((RectF)localObject).bottom -= f;
        Path localPath = new Path();
        localPath.addRoundRect((RectF)localObject, this.borderRadius, Path.Direction.CW);
        paramCanvas.drawPath(localPath, getStrokePaint());
      }
    }
    paramCanvas.restoreToCount(paramInt);
    if (paramBoolean2) {
      this.mHost.postInvalidateDelayed(16L);
    }
  }
  
  private void drawContent(Canvas paramCanvas)
  {
    int i;
    if ((this.mBackground == null) && (this.mBgColor != 0)) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject;
    if (i != 0)
    {
      if ((this.isBgDirty) || (this.mBgCacheKey == null))
      {
        this.mBgCacheKey = generateBackgroundCacheKey();
        this.isBgDirty = false;
      }
      try
      {
        this.mCacheBackground = getBackgroundCache(this.mBgCacheKey);
        if ((this.mBackground != null) || ((this.mCacheBackground != null) && (this.mCacheBackground.getBitmap() != null))) {
          return;
        }
        this.mCacheBackground = new DittoBitmapCache();
        localObject = getFillPaint();
        ((Paint)localObject).setColor(this.mBgColor);
        ((Paint)localObject).setAlpha((int)this.mAlpha);
        Path localPath = new Path();
        localPath.addRoundRect(new RectF(this.mBound), this.borderRadius, Path.Direction.CW);
        paramCanvas.drawPath(localPath, (Paint)localObject);
        return;
      }
      catch (Throwable paramCanvas)
      {
        DittoLog.e("DITTO_UI", "draw background exception.", paramCanvas);
        return;
      }
    }
    else
    {
      localObject = this.mBackground;
      if (localObject != null)
      {
        ((Drawable)localObject).setBounds(this.mBound);
        this.mBackground.setAlpha((int)this.mAlpha);
        this.mBackground.draw(paramCanvas);
      }
    }
  }
  
  private void drawContentB(Canvas paramCanvas, int paramInt, boolean paramBoolean)
  {
    setGradientBackground(paramCanvas);
    int i = paramCanvas.save();
    paramCanvas.translate(getPaddingLeft(), getPaddingTop());
    if ((!hasNoRadius()) && (this.cornerPath != null))
    {
      if ((Build.VERSION.SDK_INT <= 17) && (paramCanvas.isHardwareAccelerated())) {
        paramCanvas.clipRect(0, 0, this.width - getPaddingLeft() - getPaddingRight(), this.height - getPaddingTop() - getPaddingBottom());
      } else {
        paramCanvas.clipPath(this.cornerPath);
      }
    }
    else {
      paramCanvas.clipRect(0, 0, this.width - getPaddingLeft() - getPaddingRight(), this.height - getPaddingTop() - getPaddingBottom());
    }
    onDraw(paramCanvas);
    paramCanvas.restoreToCount(i);
    boolean bool;
    if ((this.borderWidth != 0) && (this.borderColor != 0)) {
      bool = true;
    } else {
      bool = false;
    }
    if ((bool) && ((this.isBorderDirty) || (this.mBorderCacheKey == null)))
    {
      this.mBorderCacheKey = generateBorderCacheKey();
      this.isBorderDirty = false;
    }
    if (getShadowDrawable() != null)
    {
      paramCanvas.translate(this.paddingLeft - this.shadowSizeLeft, this.paddingTop - this.shadowSizeTop);
      getShadowDrawable().draw(paramCanvas);
      paramCanvas.translate(this.shadowSizeLeft - this.paddingLeft, this.shadowSizeTop - this.paddingTop);
    }
    drawBorder(paramCanvas, bool, paramInt, paramBoolean);
  }
  
  private void executeCornerPath()
  {
    if ((!hasNoRadius()) && ((this.cornerPathHeight != getContentHeight()) || (this.cornerPathWidth != getContentWidth())))
    {
      this.cornerPath.reset();
      if (needResetCornerBound()) {
        this.cornerBound = new RectF(0.0F, 0.0F, getContentWidth(), getContentHeight());
      }
      this.cornerPath.addRoundRect(this.cornerBound, getBorderRadius(), Path.Direction.CW);
      this.cornerPathHeight = getContentHeight();
      this.cornerPathWidth = getContentWidth();
    }
  }
  
  private Integer generateBackgroundCacheKey()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("canvasArea_background_");
    localStringBuilder.append(this.mBgColor);
    localStringBuilder.append("_");
    localStringBuilder.append(getWidth());
    localStringBuilder.append("_");
    localStringBuilder.append(getHeight());
    localStringBuilder.append("_");
    localStringBuilder.append(this.borderRadius);
    return Integer.valueOf(localStringBuilder.toString().hashCode());
  }
  
  private Integer generateBorderCacheKey()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("canvasArea_border_");
    localStringBuilder.append(this.borderColor);
    localStringBuilder.append("_");
    localStringBuilder.append(this.borderWidth);
    localStringBuilder.append("_");
    localStringBuilder.append(this.borderRadius);
    localStringBuilder.append("_");
    localStringBuilder.append(getWidth());
    localStringBuilder.append("_");
    localStringBuilder.append(getHeight());
    return Integer.valueOf(localStringBuilder.toString().hashCode());
  }
  
  private Paint getFillPaint()
  {
    if (this.mFillPaint == null)
    {
      this.mFillPaint = new Paint(1);
      this.mFillPaint.setDither(true);
    }
    return this.mFillPaint;
  }
  
  private Paint getStrokePaint()
  {
    if (this.mStrokePaint == null)
    {
      this.mStrokePaint = new Paint(1);
      this.mStrokePaint.setDither(true);
      this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }
    return this.mStrokePaint;
  }
  
  private boolean hasNoRadius()
  {
    float[] arrayOfFloat = this.borderRadius;
    int j = arrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfFloat[i] != 0.0F) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean isActionDownValid()
  {
    return ((!this.ignoreClick) && (clickable())) || (!TextUtils.isEmpty(this.areaIdShouldInvokeClick)) || (!TextUtils.isEmpty(getOnClickUri())) || (!TextUtils.isEmpty(getSilentUri())) || (this.clickListener != null) || (this.longClickListener != null);
  }
  
  private boolean isUIThread()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private boolean needResetCornerBound()
  {
    return (this.cornerBound == null) || (this.cornerPathHeight != getContentHeight()) || (this.cornerPathWidth != getContentWidth());
  }
  
  private void onAnimationStart() {}
  
  private void onPressedAlpha(boolean paramBoolean)
  {
    int j = this.mPressedAlpha;
    int i;
    if (j < 0)
    {
      i = 0;
    }
    else
    {
      i = j;
      if (j > 255) {
        i = 255;
      }
    }
    if (i == 0) {
      return;
    }
    if (paramBoolean) {
      setAlpha(i);
    } else {
      setAlpha(255.0F);
    }
    invalidate();
  }
  
  private void onTouchEventOutside()
  {
    onPressedAlpha(false);
  }
  
  private void parseAttr(LayoutAttrSet paramLayoutAttrSet)
  {
    if (paramLayoutAttrSet.hasAttr("gravity")) {
      setGravity(LayoutAttrDefine.Gravity.parse(paramLayoutAttrSet.getAttr("gravity", "left")));
    }
    if (paramLayoutAttrSet.hasAttr("compassExposureKey")) {
      this.compassExposureKey = paramLayoutAttrSet.getIntArrayAttr("compassExposureKey");
    }
    if (paramLayoutAttrSet.hasAttr("compassClickKey")) {
      this.compassClickKey = paramLayoutAttrSet.getIntArrayAttr("compassClickKey");
    }
    if (paramLayoutAttrSet.hasAttr("ttt_report_area")) {
      this.tttReportArea = paramLayoutAttrSet.getAttr("ttt_report_area", -1);
    }
    if (paramLayoutAttrSet.hasAttr("uri")) {
      this.onClickUri = paramLayoutAttrSet.getAttr("uri", "");
    }
    if (paramLayoutAttrSet.hasAttr("silent_uri")) {
      this.silentUri = paramLayoutAttrSet.getAttr("silent_uri", "");
    }
    if (paramLayoutAttrSet.hasAttr("silent_uri_sent_toast")) {
      this.silentUriSentToast = paramLayoutAttrSet.getAttr("silent_uri_sent_toast", null);
    }
    if (paramLayoutAttrSet.hasAttr("cmd")) {
      this.cmd = paramLayoutAttrSet.getAttr("cmd", null);
    }
    if (paramLayoutAttrSet.hasAttr("cmd_buffer")) {
      this.cmdParamKey = paramLayoutAttrSet.getAttr("cmd_buffer", -2147483648);
    }
  }
  
  private void parseAttr2(LayoutAttrSet paramLayoutAttrSet)
  {
    if (paramLayoutAttrSet.hasAttr("cmd_buffer_type")) {
      this.cmdParamType = paramLayoutAttrSet.getAttr("cmd_buffer_type", null);
    }
    if (paramLayoutAttrSet.hasAttr("post_click_key_path")) {
      this.postClickKey = MustacheParser.parse(paramLayoutAttrSet.getAttr("post_click_key_path", ""));
    }
    if (paramLayoutAttrSet.hasAttr("invoke_area_click")) {
      this.areaIdShouldInvokeClick = paramLayoutAttrSet.getAttr("invoke_area_click", null);
    }
    if (paramLayoutAttrSet.hasAttr("ignore_click")) {
      this.ignoreClick = paramLayoutAttrSet.getAttr("ignore_click", false);
    }
  }
  
  private boolean performListenerClick(MotionEvent paramMotionEvent)
  {
    DittoArea.ClickListener localClickListener = this.clickListener;
    if (localClickListener != null)
    {
      localClickListener.onClick(this, paramMotionEvent, null);
      return true;
    }
    return false;
  }
  
  private void performLongClick(MotionEvent paramMotionEvent)
  {
    DittoArea.LongClickListener localLongClickListener = this.longClickListener;
    if (localLongClickListener != null) {
      localLongClickListener.onLongClick(this, paramMotionEvent, null);
    }
  }
  
  public static final void removeAreaCache(Integer paramInteger)
  {
    if (paramInteger != null)
    {
      mAreaCache.remove(paramInteger);
      removeMeasureCache(paramInteger);
    }
  }
  
  public static final void removeBackgroundCache(Integer paramInteger)
  {
    if (paramInteger != null) {
      mBackgroundCache.remove(paramInteger);
    }
  }
  
  private void resetBgColorAndVisible(LayoutAttrSet paramLayoutAttrSet)
  {
    if ((paramLayoutAttrSet.bg_color != 0) || ((this.borderColor != 0) && (this.borderWidth != 0))) {
      setBackgroundColor(paramLayoutAttrSet.bg_color);
    }
    if (paramLayoutAttrSet.mAttrs.containsKey("visibility"))
    {
      paramLayoutAttrSet = paramLayoutAttrSet.getAttr("visibility", "visible");
      if (TextUtils.equals("visible", paramLayoutAttrSet))
      {
        setVisibility(0);
        return;
      }
      if (TextUtils.equals("gone", paramLayoutAttrSet))
      {
        setVisibility(8);
        return;
      }
      if (TextUtils.equals("invisible", paramLayoutAttrSet)) {
        setVisibility(4);
      }
    }
  }
  
  private void setGradientBackground(Canvas paramCanvas)
  {
    if (TextUtils.isEmpty(this.mGradientDirection)) {
      return;
    }
    int i = getWidth();
    int j = getHeight();
    boolean bool = "left-right".equals(this.mGradientDirection);
    int k = 0;
    int m = 0;
    int i2 = 0;
    int n = 0;
    if (bool)
    {
      m = i;
      k = 0;
    }
    int i1;
    for (;;)
    {
      i1 = 0;
      break label228;
      if (!"right-left".equals(this.mGradientDirection)) {
        break;
      }
      n = i;
      k = 0;
      label81:
      m = 0;
    }
    if ("top-bottom".equals(this.mGradientDirection))
    {
      n = k;
      label104:
      i1 = j;
      k = 0;
      m = 0;
    }
    else
    {
      if ("bottom-top".equals(this.mGradientDirection)) {}
      for (n = m;; n = i)
      {
        k = j;
        break label81;
        if ("leftTop-rightBottom".equals(this.mGradientDirection))
        {
          m = i;
          i1 = j;
          k = 0;
          n = i2;
          break label228;
        }
        if ("leftBottom-rightTop".equals(this.mGradientDirection))
        {
          m = i;
          k = j;
          break;
        }
        if ("rightTop-leftBottom".equals(this.mGradientDirection))
        {
          n = i;
          break label104;
        }
        if (!"rightBottom-leftTop".equals(this.mGradientDirection)) {
          return;
        }
      }
    }
    label228:
    Paint localPaint = new Paint();
    Path localPath = new Path();
    localPaint.setShader(new LinearGradient(n, k, m, i1, this.mGradientStartColor, this.mGradientEndColor, Shader.TileMode.CLAMP));
    localPath.addRoundRect(new RectF(0.0F, 0.0F, i, j), this.borderRadius, Path.Direction.CW);
    paramCanvas.drawPath(localPath, localPaint);
  }
  
  public final void addAreaCache(Integer paramInteger, Object paramObject)
  {
    if (paramInteger != null) {
      mAreaCache.put(paramInteger, paramObject);
    }
  }
  
  public final void addBackgroundCache(Integer paramInteger, DittoBitmapCache paramDittoBitmapCache)
  {
    if (paramInteger != null) {
      mBackgroundCache.put(paramInteger, paramDittoBitmapCache);
    }
  }
  
  public void clearAllAreaCache()
  {
    synchronized (mAreaCache)
    {
      mAreaCache.evictAll();
      synchronized (mBackgroundCache)
      {
        mBackgroundCache.evictAll();
        this.mHost = null;
        this.mShadowDrawable = null;
        this.mBackground = null;
        this.mShadowDrawable = null;
        this.mCacheBackground = null;
        this.mCacheBorder = null;
        this.mTag = null;
        this.clickListener = null;
        this.longClickListener = null;
        return;
      }
    }
  }
  
  public void clearAnimation()
  {
    if (this.mCurrentAnimation == null) {
      return;
    }
    this.mCurrentAnimation = null;
    invalidate();
  }
  
  public void clearRichTextAreaCache()
  {
    synchronized (mAreaCache)
    {
      Iterator localIterator = mAreaCache.snapshot().keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        Object localObject2 = mAreaCache.get(localInteger);
        if ((localObject2 != null) && ((localObject2 instanceof DittoTextAreaCompat))) {
          mAreaCache.remove(localInteger);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public boolean clickable()
  {
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return onTouchEvent(paramMotionEvent);
  }
  
  protected void dispatchTouchEventOutside()
  {
    onTouchEventOutside();
  }
  
  @Deprecated
  public void doneInflate()
  {
    setLayoutAttr(this.mLayoutAttr);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if ((this.mVisibility != 0) && (!this.mDrawIgnoreVisible)) {
      return;
    }
    if (getHeight() > 0)
    {
      if (getWidth() <= 0) {
        return;
      }
      int i = paramCanvas.save();
      Object localObject = this.mCurrentAnimation;
      boolean bool1 = false;
      if (localObject != null)
      {
        if (!((Animation)localObject).isInitialized())
        {
          localObject = (DittoArea)this.mParent.get();
          if (localObject == null) {
            this.mCurrentAnimation.initialize(this.mRight - this.mLeft, this.mBottom - this.mTop, 0, 0);
          } else {
            this.mCurrentAnimation.initialize(this.mRight - this.mLeft, this.mBottom - this.mTop, ((DittoArea)localObject).getWidth(), ((DittoArea)localObject).getHeight());
          }
          onAnimationStart();
        }
        if (this.mTransformation == null) {
          this.mTransformation = new Transformation();
        }
        boolean bool2 = this.mCurrentAnimation.getTransformation(System.currentTimeMillis(), this.mTransformation);
        paramCanvas.concat(this.mTransformation.getMatrix());
        bool1 = bool2;
        if ((this.mTransformation.getTransformationType() & 0x1) == 1)
        {
          paramCanvas.saveLayerAlpha(this.mFBound, (int)(this.mTransformation.getAlpha() * 255.0F), 31);
          bool1 = bool2;
        }
      }
      drawContent(paramCanvas);
      drawContentB(paramCanvas, i, bool1);
    }
  }
  
  public DittoArea findTarget(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 > getLeft()) && (paramFloat1 < getRight()) && (paramFloat2 > getTop()) && (paramFloat2 < getBottom())) {
      return this;
    }
    return null;
  }
  
  public float getAlpha()
  {
    return this.mAlpha;
  }
  
  public Animation getAnimation()
  {
    return this.mCurrentAnimation;
  }
  
  public final <T> T getAreaCache(Integer paramInteger, Class<T> paramClass)
  {
    Object localObject1 = null;
    if (paramInteger == null) {
      return null;
    }
    Object localObject2 = mAreaCache.get(paramInteger);
    paramInteger = localObject1;
    if (paramClass.isInstance(localObject2)) {
      paramInteger = paramClass.cast(localObject2);
    }
    return paramInteger;
  }
  
  public Object getAttachedObject()
  {
    WeakReference localWeakReference = this.mWeakAttachedObject;
    if (localWeakReference == null) {
      return null;
    }
    return localWeakReference.get();
  }
  
  public final DittoBitmapCache getBackgroundCache(Integer paramInteger)
  {
    if (paramInteger == null) {
      return null;
    }
    return (DittoBitmapCache)mBackgroundCache.get(paramInteger);
  }
  
  public Drawable getBackgroundDrawable()
  {
    return this.mBackground;
  }
  
  public int getBorderColor()
  {
    return this.borderColor;
  }
  
  public float[] getBorderRadius()
  {
    return this.borderRadius;
  }
  
  public int getBorderWidth()
  {
    return this.borderWidth;
  }
  
  public int getBottom()
  {
    return this.mBottom;
  }
  
  public int[] getCompassClickKey()
  {
    return this.compassClickKey;
  }
  
  public int[] getCompassExposureKey()
  {
    return this.compassExposureKey;
  }
  
  public String getContentDescription()
  {
    return this.mContentDescription;
  }
  
  public int getContentHeight()
  {
    return getHeight() - this.paddingTop - this.paddingBottom;
  }
  
  public int getContentWidth()
  {
    return getWidth() - this.paddingLeft - this.paddingRight;
  }
  
  public Context getContext()
  {
    return this.mHost.getContext();
  }
  
  public Object getData()
  {
    return null;
  }
  
  public String getGradientDirection()
  {
    return this.mGradientDirection;
  }
  
  public int getGradientEndColor()
  {
    return this.mGradientEndColor;
  }
  
  public int getGradientStartColor()
  {
    return this.mGradientStartColor;
  }
  
  public int getGravity()
  {
    return this.mGravity;
  }
  
  public int getHeight()
  {
    return this.mBottom - this.mTop;
  }
  
  public DittoHost getHost()
  {
    return this.mHost;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public LayoutAttrSet getLayoutAttr()
  {
    return this.mLayoutAttr;
  }
  
  public int getLeft()
  {
    return this.mLeft;
  }
  
  public int getMarginBottom()
  {
    return this.mLayoutAttr.bottomMargin;
  }
  
  public int getMarginLeft()
  {
    return this.mLayoutAttr.leftMargin;
  }
  
  public int getMarginRight()
  {
    return this.mLayoutAttr.rightMargin;
  }
  
  public int getMarginTop()
  {
    return this.mLayoutAttr.topMargin;
  }
  
  public int getMeasuredHeight()
  {
    return this.mMeasuredHeight;
  }
  
  public int getMeasuredWidth()
  {
    return this.mMeasuredWidth;
  }
  
  public String getOnClickUri()
  {
    return this.onClickUri;
  }
  
  public int getPaddingBottom()
  {
    return this.paddingBottom;
  }
  
  public int getPaddingLeft()
  {
    return this.paddingLeft;
  }
  
  public int getPaddingRight()
  {
    return this.paddingRight;
  }
  
  public int getPaddingTop()
  {
    return this.paddingTop;
  }
  
  public DittoArea getParent()
  {
    WeakReference localWeakReference = this.mParent;
    if (localWeakReference != null) {
      return (DittoAreaGroup)localWeakReference.get();
    }
    return null;
  }
  
  public DittoValue getPostClickKey()
  {
    return this.postClickKey;
  }
  
  public int getRight()
  {
    return this.mRight;
  }
  
  public Drawable getShadowDrawable()
  {
    return this.mShadowDrawable;
  }
  
  public String getSilentUri()
  {
    return this.silentUri;
  }
  
  public String getSilentUriSentToast()
  {
    return this.silentUriSentToast;
  }
  
  public Object getTag()
  {
    return this.mTag;
  }
  
  public int getTop()
  {
    return this.mTop;
  }
  
  public int getTttReportArea()
  {
    return this.tttReportArea;
  }
  
  public int getType()
  {
    return 0;
  }
  
  public int getVisibility()
  {
    return this.mVisibility;
  }
  
  public int getWeight()
  {
    return this.mLayoutAttr.weight;
  }
  
  public int getWidth()
  {
    return this.mRight - this.mLeft;
  }
  
  public void invalidate()
  {
    DittoHost localDittoHost = this.mHost;
    if (localDittoHost != null) {
      localDittoHost.postInvalidate();
    }
  }
  
  public void invalidateDelayed(long paramLong)
  {
    DittoHost localDittoHost = this.mHost;
    if (localDittoHost != null) {
      localDittoHost.postInvalidateDelayed(paramLong);
    }
  }
  
  public final void layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mLeft = paramInt1;
    this.mTop = paramInt2;
    this.mRight = paramInt3;
    this.mBottom = paramInt4;
    this.width = (paramInt3 - paramInt1);
    this.height = (paramInt4 - paramInt2);
    Rect localRect = this.mBound;
    if (localRect == null)
    {
      this.mBound = new Rect(0, 0, this.width, this.height);
      this.mFBound = new RectF(this.mBound);
    }
    else if ((localRect.height() != this.height) || (this.mBound.width() != this.width))
    {
      localRect = new Rect(0, 0, this.width, this.height);
      this.isBgDirty = true;
      this.isBorderDirty = true;
      Drawable localDrawable = this.mBackground;
      if (localDrawable != null) {
        localDrawable.setBounds(localRect);
      }
      this.mBound = localRect;
      this.mFBound = new RectF(this.mBound);
    }
    int i = this.width + this.shadowSizeLeft + this.shadowSizeRight - this.paddingLeft - this.paddingRight;
    int j = this.height + this.shadowSizeTop + this.shadowSizeBottom - this.paddingTop - this.paddingBottom;
    if (this.mShadowDrawable != null)
    {
      localRect = this.shadowBound;
      if ((localRect == null) || (localRect.width() != i) || (this.shadowBound.height() != j))
      {
        localRect = new Rect(0, 0, i, j);
        this.mShadowDrawable.setBounds(localRect);
        this.shadowBound = localRect;
      }
    }
    executeCornerPath();
    onLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void measure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    int m = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = j;
    if (k == 1073741824) {
      paramInt1 = j - getPaddingLeft() - getPaddingRight();
    }
    paramInt2 = i;
    if (m == 1073741824) {
      paramInt2 = i - getPaddingTop() - getPaddingBottom();
    }
    onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, k), View.MeasureSpec.makeMeasureSpec(paramInt2, m));
  }
  
  public void onDraw(Canvas paramCanvas) {}
  
  public void onLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3) {
          return false;
        }
        this.isPressed = false;
        onPressedAlpha(false);
        this.mMainHandler.removeCallbacks(this.mPendingCheckForLongPress);
        return false;
      }
      if (this.isPressed)
      {
        this.isPressed = false;
        onPressedAlpha(false);
        this.mMainHandler.removeCallbacks(this.mPendingCheckForLongPress);
        return performClick(paramMotionEvent);
      }
    }
    else if (isActionDownValid())
    {
      this.isPressed = true;
      onPressedAlpha(true);
      if (this.longClickListener != null) {
        checkForLongClick(paramMotionEvent);
      }
      return true;
    }
    return false;
  }
  
  public boolean performClick(MotionEvent paramMotionEvent)
  {
    if (!TextUtils.isEmpty(this.areaIdShouldInvokeClick))
    {
      this.mHost.invokeAreaClick(this.areaIdShouldInvokeClick, paramMotionEvent);
      return true;
    }
    if (!TextUtils.isEmpty(getOnClickUri()))
    {
      if (getCompassClickKey() != null) {
        DittoUIEngine.g().getReporter().compassReport(getCompassClickKey());
      }
      getHost().handleUri(getOnClickUri(), this, paramMotionEvent);
      return true;
    }
    if (!TextUtils.isEmpty(getSilentUri()))
    {
      if (getCompassClickKey() != null) {
        DittoUIEngine.g().getReporter().compassReport(getCompassClickKey());
      }
      getHost().handleSilentUri(getSilentUri(), this, paramMotionEvent);
      return true;
    }
    if ((!TextUtils.isEmpty(this.cmd)) && (!TextUtils.isEmpty(this.cmdParamType)) && (-2147483648 != this.cmdParamKey))
    {
      if (getCompassClickKey() != null) {
        DittoUIEngine.g().getReporter().compassReport(getCompassClickKey());
      }
      getHost().handleSilentRequest(this.cmd, this.cmdParamType, this.cmdParamKey, this, paramMotionEvent);
      return true;
    }
    return performListenerClick(paramMotionEvent);
  }
  
  public void performLongClick(MotionEvent paramMotionEvent, Object paramObject)
  {
    DittoArea.LongClickListener localLongClickListener = this.longClickListener;
    if (localLongClickListener != null) {
      localLongClickListener.onLongClick(this, paramMotionEvent, paramObject);
    }
  }
  
  public void requestLayout()
  {
    if (this.mHost != null)
    {
      if (isUIThread())
      {
        this.mHost.requestLayout();
        return;
      }
      this.mMainHandler.post(new DittoArea.1(this));
    }
  }
  
  public int resolveSize(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (j != -2147483648)
    {
      paramInt2 = paramInt1;
      if (j == 0) {
        return paramInt2;
      }
      if (j != 1073741824) {
        return paramInt1;
      }
    }
    else
    {
      paramInt2 = paramInt1;
      if (i >= paramInt1) {
        return paramInt2;
      }
    }
    paramInt2 = i;
    return paramInt2;
  }
  
  public void setAlpha(float paramFloat)
  {
    if (this.mAlpha == paramFloat) {
      return;
    }
    this.isBgDirty = true;
    this.mAlpha = paramFloat;
  }
  
  public void setAnimation(Animation paramAnimation)
  {
    this.mCurrentAnimation = paramAnimation;
    if (paramAnimation != null) {
      paramAnimation.reset();
    }
  }
  
  public void setAreaCacheKey(Integer paramInteger)
  {
    this.mAreaCacheKey = paramInteger;
  }
  
  public void setAttachedObject(Object paramObject)
  {
    this.mWeakAttachedObject = new WeakReference(paramObject);
  }
  
  public void setBackgroundColor(@ColorInt int paramInt)
  {
    if (this.mBgColor != paramInt)
    {
      this.isBgDirty = true;
      this.mBgColor = paramInt;
      this.mAlpha = Color.alpha(paramInt);
      invalidate();
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.mBackground = paramDrawable;
  }
  
  public void setBorderColor(int paramInt)
  {
    if (this.borderColor != paramInt) {
      this.isBorderDirty = true;
    }
    this.borderColor = paramInt;
    invalidate();
  }
  
  public void setBorderRadius(int paramInt)
  {
    float f = paramInt;
    setBorderRadius(new float[] { f, f, f, f, f, f, f, f });
  }
  
  public void setBorderRadius(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat != null)
    {
      if (paramArrayOfFloat.length != 8) {
        return;
      }
      float[] arrayOfFloat1 = new float[8];
      int i = 0;
      while (i < arrayOfFloat1.length)
      {
        arrayOfFloat1[i] = paramArrayOfFloat[i];
        float[] arrayOfFloat2 = this.borderRadius;
        if ((arrayOfFloat2 != null) && (arrayOfFloat1[i] != arrayOfFloat2[i]) && (!this.isBorderDirty))
        {
          this.isBgDirty = true;
          this.isBorderDirty = true;
        }
        i += 1;
      }
      this.borderRadius = arrayOfFloat1;
      paramArrayOfFloat = this.cornerPath;
      if (paramArrayOfFloat == null) {
        this.cornerPath = new Path();
      } else {
        paramArrayOfFloat.reset();
      }
      if (needResetCornerBound()) {
        this.cornerBound = new RectF(0.0F, 0.0F, getContentWidth(), getContentHeight());
      }
      this.cornerPath.addRoundRect(this.cornerBound, getBorderRadius(), Path.Direction.CW);
      this.cornerPathHeight = getContentHeight();
      this.cornerPathWidth = getContentWidth();
      invalidate();
    }
  }
  
  public void setBorderWidth(int paramInt)
  {
    if (this.borderWidth != paramInt) {
      this.isBorderDirty = true;
    }
    this.borderWidth = paramInt;
    invalidate();
  }
  
  public void setContentDescription(String paramString)
  {
    String str = this.mContentDescription;
    if (str == null)
    {
      if (paramString != null) {}
    }
    else if (str.equals(paramString)) {
      return;
    }
    this.mContentDescription = paramString;
    paramString = this.mHost;
    if (paramString != null) {
      paramString.onContentDescriptionChanged(this);
    }
  }
  
  public void setGradientDirection(String paramString)
  {
    this.mGradientDirection = paramString;
  }
  
  public void setGradientEndColor(int paramInt)
  {
    this.mGradientEndColor = paramInt;
  }
  
  public void setGradientStartColor(int paramInt)
  {
    this.mGradientStartColor = paramInt;
  }
  
  public void setGravity(int paramInt)
  {
    if (this.mGravity == paramInt) {
      return;
    }
    this.mGravity = paramInt;
  }
  
  @Deprecated
  public void setHost(DittoHost paramDittoHost)
  {
    this.mHost = paramDittoHost;
  }
  
  public void setLayoutAttr(LayoutAttrSet paramLayoutAttrSet)
  {
    this.mLayoutAttr = paramLayoutAttrSet;
    if (paramLayoutAttrSet != null)
    {
      this.id = paramLayoutAttrSet.id;
      setPadding(paramLayoutAttrSet.leftPadding, paramLayoutAttrSet.topPadding, paramLayoutAttrSet.rightPadding, paramLayoutAttrSet.bottomPadding);
      parseAttr(paramLayoutAttrSet);
      parseAttr2(paramLayoutAttrSet);
      setBorderWidth(paramLayoutAttrSet.getPostFixedAttr("border_width", 0));
      if (paramLayoutAttrSet.hasAttr("border_radii4")) {
        setBorderRadius(new float[] { paramLayoutAttrSet.topLeftRadius, paramLayoutAttrSet.topLeftRadius, paramLayoutAttrSet.topRightRadius, paramLayoutAttrSet.topRightRadius, paramLayoutAttrSet.bottomRightRadius, paramLayoutAttrSet.bottomRightRadius, paramLayoutAttrSet.bottomLeftRadius, paramLayoutAttrSet.bottomLeftRadius });
      } else {
        setBorderRadius(paramLayoutAttrSet.getPostFixedAttr("border_radius", 0));
      }
      if (paramLayoutAttrSet.getAttr("border_color", null) != null)
      {
        localObject = paramLayoutAttrSet.getAttr("border_color", null);
        try
        {
          setBorderColor(DittoResourcesUtil.parseColor((String)localObject));
        }
        catch (Throwable localThrowable)
        {
          setBorderColor(-1);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("the text ");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(" can't be parsed as color string");
          DittoLog.e("DITTO_UI", localStringBuilder.toString(), localThrowable);
        }
      }
      resetBgColorAndVisible(paramLayoutAttrSet);
      setShadowSize(paramLayoutAttrSet.leftShadowSize, paramLayoutAttrSet.topShadowSize, paramLayoutAttrSet.rightShadowSize, paramLayoutAttrSet.bottomShadowSize);
      if (paramLayoutAttrSet.shadowResourceId != 0)
      {
        localObject = this.mHost;
        if ((localObject == null) || (((DittoHost)localObject).getContext() == null) || (this.mHost.getContext().getResources() == null)) {}
      }
    }
    try
    {
      setShadowDrawable(this.mHost.getContext().getResources().getDrawable(paramLayoutAttrSet.shadowResourceId));
    }
    catch (Exception localException)
    {
      label332:
      break label332;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("can not find drawable by id ");
    ((StringBuilder)localObject).append(paramLayoutAttrSet.shadowResourceId);
    DittoLog.e("DITTO_UI", ((StringBuilder)localObject).toString());
    this.mGradientDirection = paramLayoutAttrSet.gradientDirection;
    this.mGradientStartColor = paramLayoutAttrSet.gradientStartColor;
    this.mGradientEndColor = paramLayoutAttrSet.gradientEndColor;
    this.mPressedAlpha = paramLayoutAttrSet.pressedAlpha;
  }
  
  public void setMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mLayoutAttr.setMargin(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setMeasureDirty(boolean paramBoolean)
  {
    this.mMeasureDirty = paramBoolean;
  }
  
  public void setMeasuredDimension(int paramInt1, int paramInt2)
  {
    this.mMeasuredWidth = (paramInt1 + getPaddingLeft() + getPaddingRight());
    this.mMeasuredHeight = (paramInt2 + getPaddingTop() + getPaddingBottom());
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.paddingLeft = paramInt1;
    this.paddingTop = paramInt2;
    this.paddingRight = paramInt3;
    this.paddingBottom = paramInt4;
    LayoutAttrSet localLayoutAttrSet = this.mLayoutAttr;
    localLayoutAttrSet.leftPadding = paramInt1;
    localLayoutAttrSet.topPadding = paramInt2;
    localLayoutAttrSet.rightPadding = paramInt3;
    localLayoutAttrSet.bottomPadding = paramInt4;
  }
  
  public void setPressedAlpha(int paramInt)
  {
    this.mPressedAlpha = paramInt;
  }
  
  public void setPxMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mLayoutAttr.setMargin(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setShadowDrawable(Drawable paramDrawable)
  {
    this.mShadowDrawable = paramDrawable;
    Rect localRect = this.shadowBound;
    if (localRect != null) {
      paramDrawable.setBounds(localRect);
    }
    invalidate();
  }
  
  public void setShadowSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.shadowSizeLeft = paramInt1;
    this.shadowSizeTop = paramInt2;
    this.shadowSizeRight = paramInt3;
    this.shadowSizeBottom = paramInt4;
    paramInt1 = this.width + this.shadowSizeLeft + this.shadowSizeRight - this.paddingLeft - this.paddingRight;
    paramInt2 = this.height + this.shadowSizeTop + this.shadowSizeBottom - this.paddingTop - this.paddingBottom;
    if (this.mShadowDrawable != null)
    {
      Rect localRect = this.shadowBound;
      if ((localRect == null) || (localRect.width() != paramInt1) || (this.shadowBound.height() != paramInt2))
      {
        localRect = new Rect(0, 0, paramInt1, paramInt2);
        this.mShadowDrawable.setBounds(localRect);
        this.shadowBound = localRect;
      }
    }
  }
  
  public void setTag(Object paramObject)
  {
    this.mTag = paramObject;
  }
  
  public void setVisibility(int paramInt)
  {
    if (this.mVisibility == paramInt) {
      return;
    }
    this.mVisibility = paramInt;
    requestLayout();
  }
  
  public void startAnimation(Animation paramAnimation)
  {
    paramAnimation.setStartTime(-1L);
    setAnimation(paramAnimation);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ditto.area.DittoArea
 * JD-Core Version:    0.7.0.1
 */