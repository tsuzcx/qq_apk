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
    this.mPendingCheckForLongPress.ev = paramMotionEvent;
    this.mMainHandler.removeCallbacks(this.mPendingCheckForLongPress);
    this.mMainHandler.postDelayed(this.mPendingCheckForLongPress, ViewConfiguration.getLongPressTimeout());
  }
  
  private void drawBorder(Canvas paramCanvas, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.mCacheBorder = getBackgroundCache(this.mBorderCacheKey);
      if ((this.mCacheBorder == null) || (this.mCacheBorder.getBitmap() == null))
      {
        Object localObject = getStrokePaint();
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
    if ((this.mBackground == null) && (this.mBgColor != 0))
    {
      i = 1;
      if (i == 0) {
        break label173;
      }
      if ((this.isBgDirty) || (this.mBgCacheKey == null))
      {
        this.mBgCacheKey = generateBackgroundCacheKey();
        this.isBgDirty = false;
      }
    }
    label173:
    while (this.mBackground == null)
    {
      try
      {
        this.mCacheBackground = getBackgroundCache(this.mBgCacheKey);
        if ((this.mBackground == null) && ((this.mCacheBackground == null) || (this.mCacheBackground.getBitmap() == null)))
        {
          this.mCacheBackground = new DittoBitmapCache();
          Paint localPaint = getFillPaint();
          localPaint.setColor(this.mBgColor);
          localPaint.setAlpha((int)this.mAlpha);
          Path localPath = new Path();
          localPath.addRoundRect(new RectF(this.mBound), this.borderRadius, Path.Direction.CW);
          paramCanvas.drawPath(localPath, localPaint);
        }
        return;
      }
      catch (Throwable paramCanvas)
      {
        DittoLog.e("DITTO_UI", "draw background exception.", paramCanvas);
        return;
      }
      i = 0;
      break;
    }
    this.mBackground.setBounds(this.mBound);
    this.mBackground.setAlpha((int)this.mAlpha);
    this.mBackground.draw(paramCanvas);
  }
  
  private void drawContentB(Canvas paramCanvas, int paramInt, boolean paramBoolean)
  {
    setGradientBackground(paramCanvas);
    int i = paramCanvas.save();
    paramCanvas.translate(getPaddingLeft(), getPaddingTop());
    if ((!hasNoRadius()) && (this.cornerPath != null)) {
      if ((Build.VERSION.SDK_INT > 17) || (!paramCanvas.isHardwareAccelerated()))
      {
        paramCanvas.clipPath(this.cornerPath);
        onDraw(paramCanvas);
        paramCanvas.restoreToCount(i);
        if ((this.borderWidth == 0) || (this.borderColor == 0)) {
          break label272;
        }
      }
    }
    label272:
    for (boolean bool = true;; bool = false)
    {
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
      return;
      paramCanvas.clipRect(0, 0, this.width - getPaddingLeft() - getPaddingRight(), this.height - getPaddingTop() - getPaddingBottom());
      break;
      paramCanvas.clipRect(0, 0, this.width - getPaddingLeft() - getPaddingRight(), this.height - getPaddingTop() - getPaddingBottom());
      break;
    }
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
    return Integer.valueOf(("canvasArea_background_" + this.mBgColor + "_" + getWidth() + "_" + getHeight() + "_" + this.borderRadius).hashCode());
  }
  
  private Integer generateBorderCacheKey()
  {
    return Integer.valueOf(("canvasArea_border_" + this.borderColor + "_" + this.borderWidth + "_" + this.borderRadius + "_" + getWidth() + "_" + getHeight()).hashCode());
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
    int i = 255;
    if (this.mPressedAlpha < 0) {
      i = 0;
    }
    while (i == 0)
    {
      return;
      if (this.mPressedAlpha <= 255) {
        i = this.mPressedAlpha;
      }
    }
    if (paramBoolean) {
      setAlpha(i);
    }
    for (;;)
    {
      invalidate();
      return;
      setAlpha(255.0F);
    }
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
    if (this.clickListener != null)
    {
      this.clickListener.onClick(this, paramMotionEvent, null);
      return true;
    }
    return false;
  }
  
  private void performLongClick(MotionEvent paramMotionEvent)
  {
    if (this.longClickListener != null) {
      this.longClickListener.onLongClick(this, paramMotionEvent, null);
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
      if (!TextUtils.equals("visible", paramLayoutAttrSet)) {
        break label71;
      }
      setVisibility(0);
    }
    label71:
    do
    {
      return;
      if (TextUtils.equals("gone", paramLayoutAttrSet))
      {
        setVisibility(8);
        return;
      }
    } while (!TextUtils.equals("invisible", paramLayoutAttrSet));
    setVisibility(4);
  }
  
  private void setGradientBackground(Canvas paramCanvas)
  {
    if (TextUtils.isEmpty(this.mGradientDirection)) {
      return;
    }
    int n = getWidth();
    int i1 = getHeight();
    int m;
    int k;
    int j;
    int i;
    if ("left-right".equals(this.mGradientDirection))
    {
      m = 0;
      k = n;
      j = 0;
      i = 0;
    }
    for (;;)
    {
      Paint localPaint = new Paint();
      Path localPath = new Path();
      localPaint.setShader(new LinearGradient(i, j, k, m, this.mGradientStartColor, this.mGradientEndColor, Shader.TileMode.CLAMP));
      localPath.addRoundRect(new RectF(0.0F, 0.0F, n, i1), this.borderRadius, Path.Direction.CW);
      paramCanvas.drawPath(localPath, localPaint);
      return;
      if ("right-left".equals(this.mGradientDirection))
      {
        m = 0;
        k = 0;
        j = 0;
        i = n;
      }
      else if ("top-bottom".equals(this.mGradientDirection))
      {
        m = i1;
        k = 0;
        j = 0;
        i = 0;
      }
      else if ("bottom-top".equals(this.mGradientDirection))
      {
        m = 0;
        k = 0;
        j = i1;
        i = 0;
      }
      else if ("leftTop-rightBottom".equals(this.mGradientDirection))
      {
        m = i1;
        k = n;
        j = 0;
        i = 0;
      }
      else if ("leftBottom-rightTop".equals(this.mGradientDirection))
      {
        m = 0;
        k = n;
        j = i1;
        i = 0;
      }
      else if ("rightTop-leftBottom".equals(this.mGradientDirection))
      {
        m = i1;
        k = 0;
        j = 0;
        i = n;
      }
      else
      {
        if (!"rightBottom-leftTop".equals(this.mGradientDirection)) {
          break;
        }
        m = 0;
        k = 0;
        j = i1;
        i = n;
      }
    }
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
    }
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
      localObject1 = finally;
      throw localObject1;
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
    if ((this.mVisibility != 0) && (!this.mDrawIgnoreVisible)) {}
    while ((getHeight() <= 0) || (getWidth() <= 0)) {
      return;
    }
    int i = paramCanvas.save();
    DittoArea localDittoArea;
    boolean bool2;
    if (this.mCurrentAnimation != null) {
      if (!this.mCurrentAnimation.isInitialized())
      {
        localDittoArea = (DittoArea)this.mParent.get();
        if (localDittoArea == null)
        {
          this.mCurrentAnimation.initialize(this.mRight - this.mLeft, this.mBottom - this.mTop, 0, 0);
          onAnimationStart();
        }
      }
      else
      {
        if (this.mTransformation == null) {
          this.mTransformation = new Transformation();
        }
        bool2 = this.mCurrentAnimation.getTransformation(System.currentTimeMillis(), this.mTransformation);
        paramCanvas.concat(this.mTransformation.getMatrix());
        bool1 = bool2;
        if ((this.mTransformation.getTransformationType() & 0x1) == 1) {
          paramCanvas.saveLayerAlpha(this.mFBound, (int)(this.mTransformation.getAlpha() * 255.0F), 31);
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      drawContent(paramCanvas);
      drawContentB(paramCanvas, i, bool1);
      return;
      this.mCurrentAnimation.initialize(this.mRight - this.mLeft, this.mBottom - this.mTop, localDittoArea.getWidth(), localDittoArea.getHeight());
      break;
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
    if (paramInteger == null) {}
    do
    {
      return null;
      paramInteger = mAreaCache.get(paramInteger);
    } while (!paramClass.isInstance(paramInteger));
    return paramClass.cast(paramInteger);
  }
  
  public Object getAttachedObject()
  {
    if (this.mWeakAttachedObject == null) {
      return null;
    }
    return this.mWeakAttachedObject.get();
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
    if (this.mParent != null) {
      return (DittoAreaGroup)this.mParent.get();
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
    if (this.mHost != null) {
      this.mHost.postInvalidate();
    }
  }
  
  public void invalidateDelayed(long paramLong)
  {
    if (this.mHost != null) {
      this.mHost.postInvalidateDelayed(paramLong);
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
    if (this.mBound == null) {
      this.mBound = new Rect(0, 0, this.width, this.height);
    }
    for (this.mFBound = new RectF(this.mBound);; this.mFBound = new RectF(this.mBound))
    {
      do
      {
        int i = this.width + this.shadowSizeLeft + this.shadowSizeRight - this.paddingLeft - this.paddingRight;
        int j = this.height + this.shadowSizeTop + this.shadowSizeBottom - this.paddingTop - this.paddingBottom;
        if ((this.mShadowDrawable != null) && ((this.shadowBound == null) || (this.shadowBound.width() != i) || (this.shadowBound.height() != j)))
        {
          localRect = new Rect(0, 0, i, j);
          this.mShadowDrawable.setBounds(localRect);
          this.shadowBound = localRect;
        }
        executeCornerPath();
        onLayout(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      } while ((this.mBound.height() == this.height) && (this.mBound.width() == this.width));
      Rect localRect = new Rect(0, 0, this.width, this.height);
      this.isBgDirty = true;
      this.isBorderDirty = true;
      if (this.mBackground != null) {
        this.mBackground.setBounds(localRect);
      }
      this.mBound = localRect;
    }
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
    boolean bool = true;
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      bool = false;
      do
      {
        return bool;
        if (!this.isPressed) {
          break;
        }
        this.isPressed = false;
        onPressedAlpha(false);
        this.mMainHandler.removeCallbacks(this.mPendingCheckForLongPress);
        return performClick(paramMotionEvent);
        if (!isActionDownValid()) {
          break;
        }
        this.isPressed = true;
        onPressedAlpha(true);
      } while (this.longClickListener == null);
      checkForLongClick(paramMotionEvent);
      return true;
      this.isPressed = false;
      onPressedAlpha(false);
      this.mMainHandler.removeCallbacks(this.mPendingCheckForLongPress);
    }
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
    if (this.longClickListener != null) {
      this.longClickListener.onLongClick(this, paramMotionEvent, paramObject);
    }
  }
  
  public void requestLayout()
  {
    if (this.mHost != null)
    {
      if (isUIThread()) {
        this.mHost.requestLayout();
      }
    }
    else {
      return;
    }
    this.mMainHandler.post(new DittoArea.1(this));
  }
  
  public int resolveSize(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    switch (i)
    {
    case 0: 
    default: 
    case -2147483648: 
      do
      {
        return paramInt1;
      } while (paramInt2 >= paramInt1);
      return paramInt2;
    }
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
    setBorderRadius(new float[] { paramInt, paramInt, paramInt, paramInt, paramInt, paramInt, paramInt, paramInt });
  }
  
  public void setBorderRadius(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length != 8)) {
      return;
    }
    float[] arrayOfFloat = new float[8];
    int i = 0;
    while (i < arrayOfFloat.length)
    {
      arrayOfFloat[i] = paramArrayOfFloat[i];
      if ((this.borderRadius != null) && (arrayOfFloat[i] != this.borderRadius[i]) && (!this.isBorderDirty))
      {
        this.isBgDirty = true;
        this.isBorderDirty = true;
      }
      i += 1;
    }
    this.borderRadius = arrayOfFloat;
    if (this.cornerPath == null) {
      this.cornerPath = new Path();
    }
    for (;;)
    {
      if (needResetCornerBound()) {
        this.cornerBound = new RectF(0.0F, 0.0F, getContentWidth(), getContentHeight());
      }
      this.cornerPath.addRoundRect(this.cornerBound, getBorderRadius(), Path.Direction.CW);
      this.cornerPathHeight = getContentHeight();
      this.cornerPathWidth = getContentWidth();
      invalidate();
      return;
      this.cornerPath.reset();
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
    if (this.mContentDescription == null) {
      if (paramString != null) {
        break label23;
      }
    }
    label23:
    do
    {
      do
      {
        return;
      } while (this.mContentDescription.equals(paramString));
      this.mContentDescription = paramString;
    } while (this.mHost == null);
    this.mHost.onContentDescriptionChanged(this);
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
      if (!paramLayoutAttrSet.hasAttr("border_radii4")) {
        break label293;
      }
      setBorderRadius(new float[] { paramLayoutAttrSet.topLeftRadius, paramLayoutAttrSet.topLeftRadius, paramLayoutAttrSet.topRightRadius, paramLayoutAttrSet.topRightRadius, paramLayoutAttrSet.bottomRightRadius, paramLayoutAttrSet.bottomRightRadius, paramLayoutAttrSet.bottomLeftRadius, paramLayoutAttrSet.bottomLeftRadius });
    }
    for (;;)
    {
      String str;
      if (paramLayoutAttrSet.getAttr("border_color", null) != null) {
        str = paramLayoutAttrSet.getAttr("border_color", null);
      }
      try
      {
        setBorderColor(DittoResourcesUtil.parseColor(str));
        resetBgColorAndVisible(paramLayoutAttrSet);
        setShadowSize(paramLayoutAttrSet.leftShadowSize, paramLayoutAttrSet.topShadowSize, paramLayoutAttrSet.rightShadowSize, paramLayoutAttrSet.bottomShadowSize);
        if ((paramLayoutAttrSet.shadowResourceId == 0) || (this.mHost == null) || (this.mHost.getContext() == null) || (this.mHost.getContext().getResources() == null)) {}
      }
      catch (Throwable localThrowable)
      {
        try
        {
          setShadowDrawable(this.mHost.getContext().getResources().getDrawable(paramLayoutAttrSet.shadowResourceId));
          this.mGradientDirection = paramLayoutAttrSet.gradientDirection;
          this.mGradientStartColor = paramLayoutAttrSet.gradientStartColor;
          this.mGradientEndColor = paramLayoutAttrSet.gradientEndColor;
          this.mPressedAlpha = paramLayoutAttrSet.pressedAlpha;
          return;
          label293:
          setBorderRadius(paramLayoutAttrSet.getPostFixedAttr("border_radius", 0));
          continue;
          localThrowable = localThrowable;
          setBorderColor(-1);
          DittoLog.e("DITTO_UI", "the text " + str + " can't be parsed as color string", localThrowable);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            DittoLog.e("DITTO_UI", "can not find drawable by id " + paramLayoutAttrSet.shadowResourceId);
          }
        }
      }
    }
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
    this.mMeasuredWidth = (getPaddingLeft() + paramInt1 + getPaddingRight());
    this.mMeasuredHeight = (getPaddingTop() + paramInt2 + getPaddingBottom());
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.paddingLeft = paramInt1;
    this.paddingTop = paramInt2;
    this.paddingRight = paramInt3;
    this.paddingBottom = paramInt4;
    this.mLayoutAttr.leftPadding = paramInt1;
    this.mLayoutAttr.topPadding = paramInt2;
    this.mLayoutAttr.rightPadding = paramInt3;
    this.mLayoutAttr.bottomPadding = paramInt4;
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
    if (this.shadowBound != null) {
      paramDrawable.setBounds(this.shadowBound);
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
    if ((this.mShadowDrawable != null) && ((this.shadowBound == null) || (this.shadowBound.width() != paramInt1) || (this.shadowBound.height() != paramInt2)))
    {
      Rect localRect = new Rect(0, 0, paramInt1, paramInt2);
      this.mShadowDrawable.setBounds(localRect);
      this.shadowBound = localRect;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ditto.area.DittoArea
 * JD-Core Version:    0.7.0.1
 */