package androidx.drawerlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout
  extends ViewGroup
{
  private static final boolean ALLOW_EDGE_LOCK = false;
  static final boolean CAN_HIDE_DESCENDANTS;
  private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
  private static final int DEFAULT_SCRIM_COLOR = -1728053248;
  private static final int DRAWER_ELEVATION = 10;
  static final int[] LAYOUT_ATTRS;
  public static final int LOCK_MODE_LOCKED_CLOSED = 1;
  public static final int LOCK_MODE_LOCKED_OPEN = 2;
  public static final int LOCK_MODE_UNDEFINED = 3;
  public static final int LOCK_MODE_UNLOCKED = 0;
  private static final int MIN_DRAWER_MARGIN = 64;
  private static final int MIN_FLING_VELOCITY = 400;
  private static final int PEEK_DELAY = 160;
  private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  private static final String TAG = "DrawerLayout";
  private static final int[] THEME_ATTRS;
  private static final float TOUCH_SLOP_SENSITIVITY = 1.0F;
  private final DrawerLayout.ChildAccessibilityDelegate mChildAccessibilityDelegate = new DrawerLayout.ChildAccessibilityDelegate();
  private Rect mChildHitRect;
  private Matrix mChildInvertedMatrix;
  private boolean mChildrenCanceledTouch;
  private boolean mDisallowInterceptRequested;
  private boolean mDrawStatusBarBackground;
  private float mDrawerElevation;
  private int mDrawerState;
  private boolean mFirstLayout = true;
  private boolean mInLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private Object mLastInsets;
  private final DrawerLayout.ViewDragCallback mLeftCallback;
  private final ViewDragHelper mLeftDragger;
  @Nullable
  private DrawerLayout.DrawerListener mListener;
  private List<DrawerLayout.DrawerListener> mListeners;
  private int mLockModeEnd = 3;
  private int mLockModeLeft = 3;
  private int mLockModeRight = 3;
  private int mLockModeStart = 3;
  private int mMinDrawerMargin;
  private final ArrayList<View> mNonDrawerViews;
  private final DrawerLayout.ViewDragCallback mRightCallback;
  private final ViewDragHelper mRightDragger;
  private int mScrimColor = -1728053248;
  private float mScrimOpacity;
  private Paint mScrimPaint = new Paint();
  private Drawable mShadowEnd = null;
  private Drawable mShadowLeft = null;
  private Drawable mShadowLeftResolved;
  private Drawable mShadowRight = null;
  private Drawable mShadowRightResolved;
  private Drawable mShadowStart = null;
  private Drawable mStatusBarBackground;
  private CharSequence mTitleLeft;
  private CharSequence mTitleRight;
  
  static
  {
    boolean bool2 = true;
    THEME_ATTRS = new int[] { 16843828 };
    LAYOUT_ATTRS = new int[] { 16842931 };
    boolean bool1;
    if (Build.VERSION.SDK_INT >= 19) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    CAN_HIDE_DESCENDANTS = bool1;
    if (Build.VERSION.SDK_INT >= 21) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    SET_DRAWER_SHADOW_FROM_ELEVATION = bool1;
  }
  
  public DrawerLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DrawerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DrawerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setDescendantFocusability(262144);
    float f1 = getResources().getDisplayMetrics().density;
    this.mMinDrawerMargin = ((int)(64.0F * f1 + 0.5F));
    float f2 = 400.0F * f1;
    this.mLeftCallback = new DrawerLayout.ViewDragCallback(this, 3);
    this.mRightCallback = new DrawerLayout.ViewDragCallback(this, 5);
    this.mLeftDragger = ViewDragHelper.create(this, 1.0F, this.mLeftCallback);
    this.mLeftDragger.setEdgeTrackingEnabled(1);
    this.mLeftDragger.setMinVelocity(f2);
    this.mLeftCallback.setDragger(this.mLeftDragger);
    this.mRightDragger = ViewDragHelper.create(this, 1.0F, this.mRightCallback);
    this.mRightDragger.setEdgeTrackingEnabled(2);
    this.mRightDragger.setMinVelocity(f2);
    this.mRightCallback.setDragger(this.mRightDragger);
    setFocusableInTouchMode(true);
    ViewCompat.setImportantForAccessibility(this, 1);
    ViewCompat.setAccessibilityDelegate(this, new DrawerLayout.AccessibilityDelegate(this));
    setMotionEventSplittingEnabled(false);
    if (ViewCompat.getFitsSystemWindows(this))
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        setOnApplyWindowInsetsListener(new DrawerLayout.1(this));
        setSystemUiVisibility(1280);
        paramContext = paramContext.obtainStyledAttributes(THEME_ATTRS);
      }
      try
      {
        this.mStatusBarBackground = paramContext.getDrawable(0);
        paramContext.recycle();
      }
      finally
      {
        paramContext.recycle();
      }
    }
    this.mDrawerElevation = (f1 * 10.0F);
    this.mNonDrawerViews = new ArrayList();
  }
  
  private boolean dispatchTransformedGenericPointerEvent(MotionEvent paramMotionEvent, View paramView)
  {
    if (!paramView.getMatrix().isIdentity())
    {
      paramMotionEvent = getTransformedMotionEvent(paramMotionEvent, paramView);
      bool = paramView.dispatchGenericMotionEvent(paramMotionEvent);
      paramMotionEvent.recycle();
      return bool;
    }
    float f1 = getScrollX() - paramView.getLeft();
    float f2 = getScrollY() - paramView.getTop();
    paramMotionEvent.offsetLocation(f1, f2);
    boolean bool = paramView.dispatchGenericMotionEvent(paramMotionEvent);
    paramMotionEvent.offsetLocation(-f1, -f2);
    return bool;
  }
  
  private MotionEvent getTransformedMotionEvent(MotionEvent paramMotionEvent, View paramView)
  {
    float f1 = getScrollX() - paramView.getLeft();
    float f2 = getScrollY() - paramView.getTop();
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.offsetLocation(f1, f2);
    paramView = paramView.getMatrix();
    if (!paramView.isIdentity())
    {
      if (this.mChildInvertedMatrix == null) {
        this.mChildInvertedMatrix = new Matrix();
      }
      paramView.invert(this.mChildInvertedMatrix);
      paramMotionEvent.transform(this.mChildInvertedMatrix);
    }
    return paramMotionEvent;
  }
  
  static String gravityToString(int paramInt)
  {
    if ((paramInt & 0x3) == 3) {
      return "LEFT";
    }
    if ((paramInt & 0x5) == 5) {
      return "RIGHT";
    }
    return Integer.toHexString(paramInt);
  }
  
  private static boolean hasOpaqueBackground(View paramView)
  {
    paramView = paramView.getBackground();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramView != null)
    {
      bool1 = bool2;
      if (paramView.getOpacity() == -1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean hasPeekingDrawer()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      if (((DrawerLayout.LayoutParams)getChildAt(i).getLayoutParams()).isPeeking) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean hasVisibleDrawer()
  {
    return findVisibleDrawer() != null;
  }
  
  static boolean includeChildForAccessibility(View paramView)
  {
    return (ViewCompat.getImportantForAccessibility(paramView) != 4) && (ViewCompat.getImportantForAccessibility(paramView) != 2);
  }
  
  private boolean isInBoundsOfChild(float paramFloat1, float paramFloat2, View paramView)
  {
    if (this.mChildHitRect == null) {
      this.mChildHitRect = new Rect();
    }
    paramView.getHitRect(this.mChildHitRect);
    return this.mChildHitRect.contains((int)paramFloat1, (int)paramFloat2);
  }
  
  private boolean mirror(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable != null) && (DrawableCompat.isAutoMirrored(paramDrawable)))
    {
      DrawableCompat.setLayoutDirection(paramDrawable, paramInt);
      return true;
    }
    return false;
  }
  
  private Drawable resolveLeftShadow()
  {
    int i = ViewCompat.getLayoutDirection(this);
    Drawable localDrawable;
    if (i == 0)
    {
      localDrawable = this.mShadowStart;
      if (localDrawable != null)
      {
        mirror(localDrawable, i);
        return this.mShadowStart;
      }
    }
    else
    {
      localDrawable = this.mShadowEnd;
      if (localDrawable != null)
      {
        mirror(localDrawable, i);
        return this.mShadowEnd;
      }
    }
    return this.mShadowLeft;
  }
  
  private Drawable resolveRightShadow()
  {
    int i = ViewCompat.getLayoutDirection(this);
    Drawable localDrawable;
    if (i == 0)
    {
      localDrawable = this.mShadowEnd;
      if (localDrawable != null)
      {
        mirror(localDrawable, i);
        return this.mShadowEnd;
      }
    }
    else
    {
      localDrawable = this.mShadowStart;
      if (localDrawable != null)
      {
        mirror(localDrawable, i);
        return this.mShadowStart;
      }
    }
    return this.mShadowRight;
  }
  
  private void resolveShadowDrawables()
  {
    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
      return;
    }
    this.mShadowLeftResolved = resolveLeftShadow();
    this.mShadowRightResolved = resolveRightShadow();
  }
  
  private void updateChildrenImportantForAccessibility(View paramView, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (((!paramBoolean) && (!isDrawerView(localView))) || ((paramBoolean) && (localView == paramView))) {
        ViewCompat.setImportantForAccessibility(localView, 1);
      } else {
        ViewCompat.setImportantForAccessibility(localView, 4);
      }
      i += 1;
    }
  }
  
  public void addDrawerListener(@NonNull DrawerLayout.DrawerListener paramDrawerListener)
  {
    if (paramDrawerListener == null) {
      return;
    }
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    this.mListeners.add(paramDrawerListener);
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if (getDescendantFocusability() == 393216) {
      return;
    }
    int m = getChildCount();
    int k = 0;
    int i = 0;
    int j = 0;
    View localView;
    while (i < m)
    {
      localView = getChildAt(i);
      if (isDrawerView(localView))
      {
        if (isDrawerOpen(localView))
        {
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          j = 1;
        }
      }
      else {
        this.mNonDrawerViews.add(localView);
      }
      i += 1;
    }
    if (j == 0)
    {
      j = this.mNonDrawerViews.size();
      i = k;
      while (i < j)
      {
        localView = (View)this.mNonDrawerViews.get(i);
        if (localView.getVisibility() == 0) {
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
        i += 1;
      }
    }
    this.mNonDrawerViews.clear();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if ((findOpenDrawer() == null) && (!isDrawerView(paramView))) {
      ViewCompat.setImportantForAccessibility(paramView, 1);
    } else {
      ViewCompat.setImportantForAccessibility(paramView, 4);
    }
    if (!CAN_HIDE_DESCENDANTS) {
      ViewCompat.setAccessibilityDelegate(paramView, this.mChildAccessibilityDelegate);
    }
  }
  
  void cancelChildViewTouch()
  {
    if (!this.mChildrenCanceledTouch)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        getChildAt(i).dispatchTouchEvent(localMotionEvent);
        i += 1;
      }
      localMotionEvent.recycle();
      this.mChildrenCanceledTouch = true;
    }
  }
  
  boolean checkDrawerViewAbsoluteGravity(View paramView, int paramInt)
  {
    return (getDrawerViewAbsoluteGravity(paramView) & paramInt) == paramInt;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof DrawerLayout.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void closeDrawer(int paramInt)
  {
    closeDrawer(paramInt, true);
  }
  
  public void closeDrawer(int paramInt, boolean paramBoolean)
  {
    Object localObject = findDrawerWithGravity(paramInt);
    if (localObject != null)
    {
      closeDrawer((View)localObject, paramBoolean);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No drawer view found with gravity ");
    ((StringBuilder)localObject).append(gravityToString(paramInt));
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void closeDrawer(@NonNull View paramView)
  {
    closeDrawer(paramView, true);
  }
  
  public void closeDrawer(@NonNull View paramView, boolean paramBoolean)
  {
    if (isDrawerView(paramView))
    {
      localObject = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
      if (this.mFirstLayout)
      {
        ((DrawerLayout.LayoutParams)localObject).onScreen = 0.0F;
        ((DrawerLayout.LayoutParams)localObject).openState = 0;
      }
      else if (paramBoolean)
      {
        ((DrawerLayout.LayoutParams)localObject).openState |= 0x4;
        if (checkDrawerViewAbsoluteGravity(paramView, 3)) {
          this.mLeftDragger.smoothSlideViewTo(paramView, -paramView.getWidth(), paramView.getTop());
        } else {
          this.mRightDragger.smoothSlideViewTo(paramView, getWidth(), paramView.getTop());
        }
      }
      else
      {
        moveDrawerToOffset(paramView, 0.0F);
        updateDrawerState(((DrawerLayout.LayoutParams)localObject).gravity, 0, paramView);
        paramView.setVisibility(4);
      }
      invalidate();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("View ");
    ((StringBuilder)localObject).append(paramView);
    ((StringBuilder)localObject).append(" is not a sliding drawer");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void closeDrawers()
  {
    closeDrawers(false);
  }
  
  void closeDrawers(boolean paramBoolean)
  {
    int m = getChildCount();
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      View localView = getChildAt(i);
      DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
      k = j;
      if (isDrawerView(localView)) {
        if ((paramBoolean) && (!localLayoutParams.isPeeking))
        {
          k = j;
        }
        else
        {
          k = localView.getWidth();
          boolean bool;
          if (checkDrawerViewAbsoluteGravity(localView, 3)) {
            bool = this.mLeftDragger.smoothSlideViewTo(localView, -k, localView.getTop());
          } else {
            bool = this.mRightDragger.smoothSlideViewTo(localView, getWidth(), localView.getTop());
          }
          k = j | bool;
          localLayoutParams.isPeeking = false;
        }
      }
      i += 1;
    }
    this.mLeftCallback.removeCallbacks();
    this.mRightCallback.removeCallbacks();
    if (j != 0) {
      invalidate();
    }
  }
  
  public void computeScroll()
  {
    int j = getChildCount();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f = Math.max(f, ((DrawerLayout.LayoutParams)getChildAt(i).getLayoutParams()).onScreen);
      i += 1;
    }
    this.mScrimOpacity = f;
    boolean bool1 = this.mLeftDragger.continueSettling(true);
    boolean bool2 = this.mRightDragger.continueSettling(true);
    if ((bool1) || (bool2)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getSource() & 0x2) != 0) && (paramMotionEvent.getAction() != 10) && (this.mScrimOpacity > 0.0F))
    {
      int i = getChildCount();
      if (i != 0)
      {
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        i -= 1;
        while (i >= 0)
        {
          View localView = getChildAt(i);
          if ((isInBoundsOfChild(f1, f2, localView)) && (!isContentView(localView)) && (dispatchTransformedGenericPointerEvent(paramMotionEvent, localView))) {
            return true;
          }
          i -= 1;
        }
      }
      return false;
    }
    return super.dispatchGenericMotionEvent(paramMotionEvent);
  }
  
  void dispatchOnDrawerClosed(View paramView)
  {
    Object localObject = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
    if ((((DrawerLayout.LayoutParams)localObject).openState & 0x1) == 1)
    {
      ((DrawerLayout.LayoutParams)localObject).openState = 0;
      localObject = this.mListeners;
      if (localObject != null)
      {
        int i = ((List)localObject).size() - 1;
        while (i >= 0)
        {
          ((DrawerLayout.DrawerListener)this.mListeners.get(i)).onDrawerClosed(paramView);
          i -= 1;
        }
      }
      updateChildrenImportantForAccessibility(paramView, false);
      if (hasWindowFocus())
      {
        paramView = getRootView();
        if (paramView != null) {
          paramView.sendAccessibilityEvent(32);
        }
      }
    }
  }
  
  void dispatchOnDrawerOpened(View paramView)
  {
    Object localObject = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
    if ((((DrawerLayout.LayoutParams)localObject).openState & 0x1) == 0)
    {
      ((DrawerLayout.LayoutParams)localObject).openState = 1;
      localObject = this.mListeners;
      if (localObject != null)
      {
        int i = ((List)localObject).size() - 1;
        while (i >= 0)
        {
          ((DrawerLayout.DrawerListener)this.mListeners.get(i)).onDrawerOpened(paramView);
          i -= 1;
        }
      }
      updateChildrenImportantForAccessibility(paramView, true);
      if (hasWindowFocus()) {
        sendAccessibilityEvent(32);
      }
    }
  }
  
  void dispatchOnDrawerSlide(View paramView, float paramFloat)
  {
    List localList = this.mListeners;
    if (localList != null)
    {
      int i = localList.size() - 1;
      while (i >= 0)
      {
        ((DrawerLayout.DrawerListener)this.mListeners.get(i)).onDrawerSlide(paramView, paramFloat);
        i -= 1;
      }
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i3 = getHeight();
    boolean bool1 = isContentView(paramView);
    int i = getWidth();
    int i2 = paramCanvas.save();
    int j = 0;
    int k;
    int m;
    if (bool1)
    {
      int i4 = getChildCount();
      k = 0;
      j = 0;
      while (k < i4)
      {
        View localView = getChildAt(k);
        m = j;
        int n = i;
        if (localView != paramView)
        {
          m = j;
          n = i;
          if (localView.getVisibility() == 0)
          {
            m = j;
            n = i;
            if (hasOpaqueBackground(localView))
            {
              m = j;
              n = i;
              if (isDrawerView(localView)) {
                if (localView.getHeight() < i3)
                {
                  m = j;
                  n = i;
                }
                else
                {
                  int i1;
                  if (checkDrawerViewAbsoluteGravity(localView, 3))
                  {
                    i1 = localView.getRight();
                    m = j;
                    n = i;
                    if (i1 > j)
                    {
                      m = i1;
                      n = i;
                    }
                  }
                  else
                  {
                    i1 = localView.getLeft();
                    m = j;
                    n = i;
                    if (i1 < i)
                    {
                      n = i1;
                      m = j;
                    }
                  }
                }
              }
            }
          }
        }
        k += 1;
        j = m;
        i = n;
      }
      paramCanvas.clipRect(j, 0, i, getHeight());
    }
    boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
    paramCanvas.restoreToCount(i2);
    float f = this.mScrimOpacity;
    if ((f > 0.0F) && (bool1))
    {
      k = this.mScrimColor;
      m = (int)(((0xFF000000 & k) >>> 24) * f);
      this.mScrimPaint.setColor(k & 0xFFFFFF | m << 24);
      paramCanvas.drawRect(j, 0.0F, i, getHeight(), this.mScrimPaint);
      return bool2;
    }
    if ((this.mShadowLeftResolved != null) && (checkDrawerViewAbsoluteGravity(paramView, 3)))
    {
      i = this.mShadowLeftResolved.getIntrinsicWidth();
      j = paramView.getRight();
      k = this.mLeftDragger.getEdgeSize();
      f = Math.max(0.0F, Math.min(j / k, 1.0F));
      this.mShadowLeftResolved.setBounds(j, paramView.getTop(), i + j, paramView.getBottom());
      this.mShadowLeftResolved.setAlpha((int)(f * 255.0F));
      this.mShadowLeftResolved.draw(paramCanvas);
      return bool2;
    }
    if ((this.mShadowRightResolved != null) && (checkDrawerViewAbsoluteGravity(paramView, 5)))
    {
      i = this.mShadowRightResolved.getIntrinsicWidth();
      j = paramView.getLeft();
      k = getWidth();
      m = this.mRightDragger.getEdgeSize();
      f = Math.max(0.0F, Math.min((k - j) / m, 1.0F));
      this.mShadowRightResolved.setBounds(j - i, paramView.getTop(), j, paramView.getBottom());
      this.mShadowRightResolved.setAlpha((int)(f * 255.0F));
      this.mShadowRightResolved.draw(paramCanvas);
    }
    return bool2;
  }
  
  View findDrawerWithGravity(int paramInt)
  {
    int i = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    int j = getChildCount();
    paramInt = 0;
    while (paramInt < j)
    {
      View localView = getChildAt(paramInt);
      if ((getDrawerViewAbsoluteGravity(localView) & 0x7) == (i & 0x7)) {
        return localView;
      }
      paramInt += 1;
    }
    return null;
  }
  
  View findOpenDrawer()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((((DrawerLayout.LayoutParams)localView.getLayoutParams()).openState & 0x1) == 1) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  View findVisibleDrawer()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((isDrawerView(localView)) && (isDrawerVisible(localView))) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new DrawerLayout.LayoutParams(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new DrawerLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof DrawerLayout.LayoutParams)) {
      return new DrawerLayout.LayoutParams((DrawerLayout.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new DrawerLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new DrawerLayout.LayoutParams(paramLayoutParams);
  }
  
  public float getDrawerElevation()
  {
    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
      return this.mDrawerElevation;
    }
    return 0.0F;
  }
  
  public int getDrawerLockMode(int paramInt)
  {
    int i = ViewCompat.getLayoutDirection(this);
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 8388611)
        {
          if (paramInt == 8388613)
          {
            paramInt = this.mLockModeEnd;
            if (paramInt != 3) {
              return paramInt;
            }
            if (i == 0) {
              paramInt = this.mLockModeRight;
            } else {
              paramInt = this.mLockModeLeft;
            }
            if (paramInt != 3) {
              return paramInt;
            }
          }
        }
        else
        {
          paramInt = this.mLockModeStart;
          if (paramInt != 3) {
            return paramInt;
          }
          if (i == 0) {
            paramInt = this.mLockModeLeft;
          } else {
            paramInt = this.mLockModeRight;
          }
          if (paramInt != 3) {
            return paramInt;
          }
        }
      }
      else
      {
        paramInt = this.mLockModeRight;
        if (paramInt != 3) {
          return paramInt;
        }
        if (i == 0) {
          paramInt = this.mLockModeEnd;
        } else {
          paramInt = this.mLockModeStart;
        }
        if (paramInt != 3) {
          return paramInt;
        }
      }
    }
    else
    {
      paramInt = this.mLockModeLeft;
      if (paramInt != 3) {
        return paramInt;
      }
      if (i == 0) {
        paramInt = this.mLockModeStart;
      } else {
        paramInt = this.mLockModeEnd;
      }
      if (paramInt != 3) {
        return paramInt;
      }
    }
    return 0;
  }
  
  public int getDrawerLockMode(@NonNull View paramView)
  {
    if (isDrawerView(paramView)) {
      return getDrawerLockMode(((DrawerLayout.LayoutParams)paramView.getLayoutParams()).gravity);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("View ");
    localStringBuilder.append(paramView);
    localStringBuilder.append(" is not a drawer");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  @Nullable
  public CharSequence getDrawerTitle(int paramInt)
  {
    paramInt = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    if (paramInt == 3) {
      return this.mTitleLeft;
    }
    if (paramInt == 5) {
      return this.mTitleRight;
    }
    return null;
  }
  
  int getDrawerViewAbsoluteGravity(View paramView)
  {
    return GravityCompat.getAbsoluteGravity(((DrawerLayout.LayoutParams)paramView.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
  }
  
  float getDrawerViewOffset(View paramView)
  {
    return ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).onScreen;
  }
  
  @Nullable
  public Drawable getStatusBarBackgroundDrawable()
  {
    return this.mStatusBarBackground;
  }
  
  boolean isContentView(View paramView)
  {
    return ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).gravity == 0;
  }
  
  public boolean isDrawerOpen(int paramInt)
  {
    View localView = findDrawerWithGravity(paramInt);
    if (localView != null) {
      return isDrawerOpen(localView);
    }
    return false;
  }
  
  public boolean isDrawerOpen(@NonNull View paramView)
  {
    if (isDrawerView(paramView)) {
      return (((DrawerLayout.LayoutParams)paramView.getLayoutParams()).openState & 0x1) == 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("View ");
    localStringBuilder.append(paramView);
    localStringBuilder.append(" is not a drawer");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  boolean isDrawerView(View paramView)
  {
    int i = GravityCompat.getAbsoluteGravity(((DrawerLayout.LayoutParams)paramView.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(paramView));
    if ((i & 0x3) != 0) {
      return true;
    }
    return (i & 0x5) != 0;
  }
  
  public boolean isDrawerVisible(int paramInt)
  {
    View localView = findDrawerWithGravity(paramInt);
    if (localView != null) {
      return isDrawerVisible(localView);
    }
    return false;
  }
  
  public boolean isDrawerVisible(@NonNull View paramView)
  {
    if (isDrawerView(paramView)) {
      return ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).onScreen > 0.0F;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("View ");
    localStringBuilder.append(paramView);
    localStringBuilder.append(" is not a drawer");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  void moveDrawerToOffset(View paramView, float paramFloat)
  {
    float f1 = getDrawerViewOffset(paramView);
    float f2 = paramView.getWidth();
    int i = (int)(f1 * f2);
    i = (int)(f2 * paramFloat) - i;
    if (!checkDrawerViewAbsoluteGravity(paramView, 3)) {
      i = -i;
    }
    paramView.offsetLeftAndRight(i);
    setDrawerViewOffset(paramView, paramFloat);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.mDrawStatusBarBackground) && (this.mStatusBarBackground != null))
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        Object localObject = this.mLastInsets;
        if (localObject != null)
        {
          i = ((WindowInsets)localObject).getSystemWindowInsetTop();
          break label49;
        }
      }
      int i = 0;
      label49:
      if (i > 0)
      {
        this.mStatusBarBackground.setBounds(0, 0, getWidth(), i);
        this.mStatusBarBackground.draw(paramCanvas);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    boolean bool3 = this.mLeftDragger.shouldInterceptTouchEvent(paramMotionEvent);
    boolean bool4 = this.mRightDragger.shouldInterceptTouchEvent(paramMotionEvent);
    boolean bool2 = true;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label98;
          }
        }
        else
        {
          if (!this.mLeftDragger.checkTouchSlop(3)) {
            break label98;
          }
          this.mLeftCallback.removeCallbacks();
          this.mRightCallback.removeCallbacks();
          break label98;
        }
      }
      closeDrawers(true);
      this.mDisallowInterceptRequested = false;
      this.mChildrenCanceledTouch = false;
      label98:
      i = 0;
    }
    else
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      if (this.mScrimOpacity > 0.0F)
      {
        paramMotionEvent = this.mLeftDragger.findTopChildUnder((int)f1, (int)f2);
        if ((paramMotionEvent != null) && (isContentView(paramMotionEvent)))
        {
          i = 1;
          break label166;
        }
      }
      i = 0;
      label166:
      this.mDisallowInterceptRequested = false;
      this.mChildrenCanceledTouch = false;
    }
    boolean bool1 = bool2;
    if (!(bool3 | bool4))
    {
      bool1 = bool2;
      if (i == 0)
      {
        bool1 = bool2;
        if (!hasPeekingDrawer())
        {
          if (this.mChildrenCanceledTouch) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (hasVisibleDrawer()))
    {
      paramKeyEvent.startTracking();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramKeyEvent = findVisibleDrawer();
      if ((paramKeyEvent != null) && (getDrawerLockMode(paramKeyEvent) == 0)) {
        closeDrawers();
      }
      return paramKeyEvent != null;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mInLayout = true;
    int m = paramInt3 - paramInt1;
    int n = getChildCount();
    paramInt3 = 0;
    while (paramInt3 < n)
    {
      View localView = getChildAt(paramInt3);
      if (localView.getVisibility() != 8)
      {
        DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if (isContentView(localView))
        {
          localView.layout(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.leftMargin + localView.getMeasuredWidth(), localLayoutParams.topMargin + localView.getMeasuredHeight());
        }
        else
        {
          int i1 = localView.getMeasuredWidth();
          int i2 = localView.getMeasuredHeight();
          float f;
          int i;
          if (checkDrawerViewAbsoluteGravity(localView, 3))
          {
            paramInt1 = -i1;
            f = i1;
            i = paramInt1 + (int)(localLayoutParams.onScreen * f);
            f = (i1 + i) / f;
          }
          else
          {
            f = i1;
            i = m - (int)(localLayoutParams.onScreen * f);
            f = (m - i) / f;
          }
          int j;
          if (f != localLayoutParams.onScreen) {
            j = 1;
          } else {
            j = 0;
          }
          paramInt1 = localLayoutParams.gravity & 0x70;
          if (paramInt1 != 16)
          {
            if (paramInt1 != 80)
            {
              localView.layout(i, localLayoutParams.topMargin, i1 + i, localLayoutParams.topMargin + i2);
            }
            else
            {
              paramInt1 = paramInt4 - paramInt2;
              localView.layout(i, paramInt1 - localLayoutParams.bottomMargin - localView.getMeasuredHeight(), i1 + i, paramInt1 - localLayoutParams.bottomMargin);
            }
          }
          else
          {
            int i3 = paramInt4 - paramInt2;
            int k = (i3 - i2) / 2;
            if (k < localLayoutParams.topMargin)
            {
              paramInt1 = localLayoutParams.topMargin;
            }
            else
            {
              paramInt1 = k;
              if (k + i2 > i3 - localLayoutParams.bottomMargin) {
                paramInt1 = i3 - localLayoutParams.bottomMargin - i2;
              }
            }
            localView.layout(i, paramInt1, i1 + i, i2 + paramInt1);
          }
          if (j != 0) {
            setDrawerViewOffset(localView, f);
          }
          if (localLayoutParams.onScreen > 0.0F) {
            paramInt1 = 0;
          } else {
            paramInt1 = 4;
          }
          if (localView.getVisibility() != paramInt1) {
            localView.setVisibility(paramInt1);
          }
        }
      }
      paramInt3 += 1;
    }
    this.mInLayout = false;
    this.mFirstLayout = false;
  }
  
  @SuppressLint({"WrongConstant"})
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    int k;
    int m;
    if (i1 == 1073741824)
    {
      k = i;
      m = j;
      if (n == 1073741824) {}
    }
    else
    {
      if (!isInEditMode()) {
        break label819;
      }
      if ((i1 != -2147483648) && (i1 == 0)) {
        i = 300;
      }
      if (n == -2147483648)
      {
        k = i;
        m = j;
      }
      else
      {
        k = i;
        m = j;
        if (n == 0)
        {
          m = 300;
          k = i;
        }
      }
    }
    setMeasuredDimension(k, m);
    if ((this.mLastInsets != null) && (ViewCompat.getFitsSystemWindows(this))) {
      n = 1;
    } else {
      n = 0;
    }
    int i3 = ViewCompat.getLayoutDirection(this);
    int i4 = getChildCount();
    i1 = 0;
    j = 0;
    i = 0;
    while (i1 < i4)
    {
      View localView = getChildAt(i1);
      DrawerLayout.LayoutParams localLayoutParams;
      int i2;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if (n != 0)
        {
          i2 = GravityCompat.getAbsoluteGravity(localLayoutParams.gravity, i3);
          WindowInsets localWindowInsets;
          if (ViewCompat.getFitsSystemWindows(localView))
          {
            if (Build.VERSION.SDK_INT >= 21)
            {
              localWindowInsets = (WindowInsets)this.mLastInsets;
              if (i2 == 3)
              {
                localObject = localWindowInsets.replaceSystemWindowInsets(localWindowInsets.getSystemWindowInsetLeft(), localWindowInsets.getSystemWindowInsetTop(), 0, localWindowInsets.getSystemWindowInsetBottom());
              }
              else
              {
                localObject = localWindowInsets;
                if (i2 == 5) {
                  localObject = localWindowInsets.replaceSystemWindowInsets(0, localWindowInsets.getSystemWindowInsetTop(), localWindowInsets.getSystemWindowInsetRight(), localWindowInsets.getSystemWindowInsetBottom());
                }
              }
              localView.dispatchApplyWindowInsets((WindowInsets)localObject);
            }
          }
          else if (Build.VERSION.SDK_INT >= 21)
          {
            localWindowInsets = (WindowInsets)this.mLastInsets;
            if (i2 == 3)
            {
              localObject = localWindowInsets.replaceSystemWindowInsets(localWindowInsets.getSystemWindowInsetLeft(), localWindowInsets.getSystemWindowInsetTop(), 0, localWindowInsets.getSystemWindowInsetBottom());
            }
            else
            {
              localObject = localWindowInsets;
              if (i2 == 5) {
                localObject = localWindowInsets.replaceSystemWindowInsets(0, localWindowInsets.getSystemWindowInsetTop(), localWindowInsets.getSystemWindowInsetRight(), localWindowInsets.getSystemWindowInsetBottom());
              }
            }
            localLayoutParams.leftMargin = ((WindowInsets)localObject).getSystemWindowInsetLeft();
            localLayoutParams.topMargin = ((WindowInsets)localObject).getSystemWindowInsetTop();
            localLayoutParams.rightMargin = ((WindowInsets)localObject).getSystemWindowInsetRight();
            localLayoutParams.bottomMargin = ((WindowInsets)localObject).getSystemWindowInsetBottom();
          }
        }
        if (isContentView(localView)) {
          localView.measure(View.MeasureSpec.makeMeasureSpec(k - localLayoutParams.leftMargin - localLayoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(m - localLayoutParams.topMargin - localLayoutParams.bottomMargin, 1073741824));
        }
      }
      else
      {
        break label735;
      }
      if (isDrawerView(localView))
      {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION)
        {
          float f1 = ViewCompat.getElevation(localView);
          float f2 = this.mDrawerElevation;
          if (f1 != f2) {
            ViewCompat.setElevation(localView, f2);
          }
        }
        int i5 = getDrawerViewAbsoluteGravity(localView) & 0x7;
        if (i5 == 3) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        if (((i2 != 0) && (j != 0)) || ((i2 == 0) && (i != 0)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Child drawer has absolute gravity ");
          ((StringBuilder)localObject).append(gravityToString(i5));
          ((StringBuilder)localObject).append(" but this ");
          ((StringBuilder)localObject).append("DrawerLayout");
          ((StringBuilder)localObject).append(" already has a ");
          ((StringBuilder)localObject).append("drawer view along that edge");
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
        if (i2 != 0) {
          j = 1;
        } else {
          i = 1;
        }
        localView.measure(getChildMeasureSpec(paramInt1, this.mMinDrawerMargin + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), getChildMeasureSpec(paramInt2, localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height));
        label735:
        i1 += 1;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Child ");
        ((StringBuilder)localObject).append(localView);
        ((StringBuilder)localObject).append(" at index ");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(" does not have a valid layout_gravity - must be Gravity.LEFT, ");
        ((StringBuilder)localObject).append("Gravity.RIGHT or Gravity.NO_GRAVITY");
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
    }
    return;
    label819:
    Object localObject = new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof DrawerLayout.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (DrawerLayout.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.openDrawerGravity != 0)
    {
      View localView = findDrawerWithGravity(paramParcelable.openDrawerGravity);
      if (localView != null) {
        openDrawer(localView);
      }
    }
    if (paramParcelable.lockModeLeft != 3) {
      setDrawerLockMode(paramParcelable.lockModeLeft, 3);
    }
    if (paramParcelable.lockModeRight != 3) {
      setDrawerLockMode(paramParcelable.lockModeRight, 5);
    }
    if (paramParcelable.lockModeStart != 3) {
      setDrawerLockMode(paramParcelable.lockModeStart, 8388611);
    }
    if (paramParcelable.lockModeEnd != 3) {
      setDrawerLockMode(paramParcelable.lockModeEnd, 8388613);
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    resolveShadowDrawables();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    DrawerLayout.SavedState localSavedState = new DrawerLayout.SavedState(super.onSaveInstanceState());
    int m = getChildCount();
    int i = 0;
    while (i < m)
    {
      DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)getChildAt(i).getLayoutParams();
      int j = localLayoutParams.openState;
      int k = 1;
      if (j == 1) {
        j = 1;
      } else {
        j = 0;
      }
      if (localLayoutParams.openState != 2) {
        k = 0;
      }
      if ((j == 0) && (k == 0)) {
        i += 1;
      } else {
        localSavedState.openDrawerGravity = localLayoutParams.gravity;
      }
    }
    localSavedState.lockModeLeft = this.mLockModeLeft;
    localSavedState.lockModeRight = this.mLockModeRight;
    localSavedState.lockModeStart = this.mLockModeStart;
    localSavedState.lockModeEnd = this.mLockModeEnd;
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.mLeftDragger.processTouchEvent(paramMotionEvent);
    this.mRightDragger.processTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3) {
          return true;
        }
        closeDrawers(true);
        this.mDisallowInterceptRequested = false;
        this.mChildrenCanceledTouch = false;
        return true;
      }
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      paramMotionEvent = this.mLeftDragger.findTopChildUnder((int)f2, (int)f1);
      if ((paramMotionEvent != null) && (isContentView(paramMotionEvent)))
      {
        f2 -= this.mInitialMotionX;
        f1 -= this.mInitialMotionY;
        i = this.mLeftDragger.getTouchSlop();
        if (f2 * f2 + f1 * f1 < i * i)
        {
          paramMotionEvent = findOpenDrawer();
          if ((paramMotionEvent != null) && (getDrawerLockMode(paramMotionEvent) != 2))
          {
            bool = false;
            break label166;
          }
        }
      }
      boolean bool = true;
      label166:
      closeDrawers(bool);
      this.mDisallowInterceptRequested = false;
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    this.mInitialMotionX = f1;
    this.mInitialMotionY = f2;
    this.mDisallowInterceptRequested = false;
    this.mChildrenCanceledTouch = false;
    return true;
  }
  
  public void openDrawer(int paramInt)
  {
    openDrawer(paramInt, true);
  }
  
  public void openDrawer(int paramInt, boolean paramBoolean)
  {
    Object localObject = findDrawerWithGravity(paramInt);
    if (localObject != null)
    {
      openDrawer((View)localObject, paramBoolean);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No drawer view found with gravity ");
    ((StringBuilder)localObject).append(gravityToString(paramInt));
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void openDrawer(@NonNull View paramView)
  {
    openDrawer(paramView, true);
  }
  
  public void openDrawer(@NonNull View paramView, boolean paramBoolean)
  {
    if (isDrawerView(paramView))
    {
      localObject = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
      if (this.mFirstLayout)
      {
        ((DrawerLayout.LayoutParams)localObject).onScreen = 1.0F;
        ((DrawerLayout.LayoutParams)localObject).openState = 1;
        updateChildrenImportantForAccessibility(paramView, true);
      }
      else if (paramBoolean)
      {
        ((DrawerLayout.LayoutParams)localObject).openState |= 0x2;
        if (checkDrawerViewAbsoluteGravity(paramView, 3)) {
          this.mLeftDragger.smoothSlideViewTo(paramView, 0, paramView.getTop());
        } else {
          this.mRightDragger.smoothSlideViewTo(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
        }
      }
      else
      {
        moveDrawerToOffset(paramView, 1.0F);
        updateDrawerState(((DrawerLayout.LayoutParams)localObject).gravity, 0, paramView);
        paramView.setVisibility(0);
      }
      invalidate();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("View ");
    ((StringBuilder)localObject).append(paramView);
    ((StringBuilder)localObject).append(" is not a sliding drawer");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void removeDrawerListener(@NonNull DrawerLayout.DrawerListener paramDrawerListener)
  {
    if (paramDrawerListener == null) {
      return;
    }
    List localList = this.mListeners;
    if (localList == null) {
      return;
    }
    localList.remove(paramDrawerListener);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    this.mDisallowInterceptRequested = paramBoolean;
    if (paramBoolean) {
      closeDrawers(true);
    }
  }
  
  public void requestLayout()
  {
    if (!this.mInLayout) {
      super.requestLayout();
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setChildInsets(Object paramObject, boolean paramBoolean)
  {
    this.mLastInsets = paramObject;
    this.mDrawStatusBarBackground = paramBoolean;
    if ((!paramBoolean) && (getBackground() == null)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    setWillNotDraw(paramBoolean);
    requestLayout();
  }
  
  public void setDrawerElevation(float paramFloat)
  {
    this.mDrawerElevation = paramFloat;
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (isDrawerView(localView)) {
        ViewCompat.setElevation(localView, this.mDrawerElevation);
      }
      i += 1;
    }
  }
  
  @Deprecated
  public void setDrawerListener(DrawerLayout.DrawerListener paramDrawerListener)
  {
    DrawerLayout.DrawerListener localDrawerListener = this.mListener;
    if (localDrawerListener != null) {
      removeDrawerListener(localDrawerListener);
    }
    if (paramDrawerListener != null) {
      addDrawerListener(paramDrawerListener);
    }
    this.mListener = paramDrawerListener;
  }
  
  public void setDrawerLockMode(int paramInt)
  {
    setDrawerLockMode(paramInt, 3);
    setDrawerLockMode(paramInt, 5);
  }
  
  public void setDrawerLockMode(int paramInt1, int paramInt2)
  {
    int i = GravityCompat.getAbsoluteGravity(paramInt2, ViewCompat.getLayoutDirection(this));
    if (paramInt2 != 3)
    {
      if (paramInt2 != 5)
      {
        if (paramInt2 != 8388611)
        {
          if (paramInt2 == 8388613) {
            this.mLockModeEnd = paramInt1;
          }
        }
        else {
          this.mLockModeStart = paramInt1;
        }
      }
      else {
        this.mLockModeRight = paramInt1;
      }
    }
    else {
      this.mLockModeLeft = paramInt1;
    }
    Object localObject;
    if (paramInt1 != 0)
    {
      if (i == 3) {
        localObject = this.mLeftDragger;
      } else {
        localObject = this.mRightDragger;
      }
      ((ViewDragHelper)localObject).cancel();
    }
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        return;
      }
      localObject = findDrawerWithGravity(i);
      if (localObject != null) {
        openDrawer((View)localObject);
      }
    }
    else
    {
      localObject = findDrawerWithGravity(i);
      if (localObject != null) {
        closeDrawer((View)localObject);
      }
    }
  }
  
  public void setDrawerLockMode(int paramInt, @NonNull View paramView)
  {
    if (isDrawerView(paramView))
    {
      setDrawerLockMode(paramInt, ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).gravity);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("View ");
    localStringBuilder.append(paramView);
    localStringBuilder.append(" is not a ");
    localStringBuilder.append("drawer with appropriate layout_gravity");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setDrawerShadow(@DrawableRes int paramInt1, int paramInt2)
  {
    setDrawerShadow(ContextCompat.getDrawable(getContext(), paramInt1), paramInt2);
  }
  
  public void setDrawerShadow(Drawable paramDrawable, int paramInt)
  {
    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
      return;
    }
    if ((paramInt & 0x800003) == 8388611)
    {
      this.mShadowStart = paramDrawable;
    }
    else if ((paramInt & 0x800005) == 8388613)
    {
      this.mShadowEnd = paramDrawable;
    }
    else if ((paramInt & 0x3) == 3)
    {
      this.mShadowLeft = paramDrawable;
    }
    else
    {
      if ((paramInt & 0x5) != 5) {
        return;
      }
      this.mShadowRight = paramDrawable;
    }
    resolveShadowDrawables();
    invalidate();
  }
  
  public void setDrawerTitle(int paramInt, @Nullable CharSequence paramCharSequence)
  {
    paramInt = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    if (paramInt == 3)
    {
      this.mTitleLeft = paramCharSequence;
      return;
    }
    if (paramInt == 5) {
      this.mTitleRight = paramCharSequence;
    }
  }
  
  void setDrawerViewOffset(View paramView, float paramFloat)
  {
    DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
    if (paramFloat == localLayoutParams.onScreen) {
      return;
    }
    localLayoutParams.onScreen = paramFloat;
    dispatchOnDrawerSlide(paramView, paramFloat);
  }
  
  public void setScrimColor(@ColorInt int paramInt)
  {
    this.mScrimColor = paramInt;
    invalidate();
  }
  
  public void setStatusBarBackground(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = ContextCompat.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    this.mStatusBarBackground = localDrawable;
    invalidate();
  }
  
  public void setStatusBarBackground(@Nullable Drawable paramDrawable)
  {
    this.mStatusBarBackground = paramDrawable;
    invalidate();
  }
  
  public void setStatusBarBackgroundColor(@ColorInt int paramInt)
  {
    this.mStatusBarBackground = new ColorDrawable(paramInt);
    invalidate();
  }
  
  void updateDrawerState(int paramInt1, int paramInt2, View paramView)
  {
    int j = this.mLeftDragger.getViewDragState();
    int k = this.mRightDragger.getViewDragState();
    int i = 2;
    if ((j != 1) && (k != 1))
    {
      paramInt1 = i;
      if (j != 2) {
        if (k == 2) {
          paramInt1 = i;
        } else {
          paramInt1 = 0;
        }
      }
    }
    else
    {
      paramInt1 = 1;
    }
    if ((paramView != null) && (paramInt2 == 0))
    {
      DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams.onScreen == 0.0F) {
        dispatchOnDrawerClosed(paramView);
      } else if (localLayoutParams.onScreen == 1.0F) {
        dispatchOnDrawerOpened(paramView);
      }
    }
    if (paramInt1 != this.mDrawerState)
    {
      this.mDrawerState = paramInt1;
      paramView = this.mListeners;
      if (paramView != null)
      {
        paramInt2 = paramView.size() - 1;
        while (paramInt2 >= 0)
        {
          ((DrawerLayout.DrawerListener)this.mListeners.get(paramInt2)).onDrawerStateChanged(paramInt1);
          paramInt2 -= 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.drawerlayout.widget.DrawerLayout
 * JD-Core Version:    0.7.0.1
 */