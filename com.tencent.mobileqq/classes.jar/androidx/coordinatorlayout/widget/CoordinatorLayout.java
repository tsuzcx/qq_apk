package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewTreeObserver;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.R.attr;
import androidx.coordinatorlayout.R.style;
import androidx.coordinatorlayout.R.styleable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pools.Pool;
import androidx.core.util.Pools.SynchronizedPool;
import androidx.core.view.GravityCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout
  extends ViewGroup
  implements NestedScrollingParent2, NestedScrollingParent3
{
  static final Class<?>[] CONSTRUCTOR_PARAMS = { Context.class, AttributeSet.class };
  static final int EVENT_NESTED_SCROLL = 1;
  static final int EVENT_PRE_DRAW = 0;
  static final int EVENT_VIEW_REMOVED = 2;
  static final String TAG = "CoordinatorLayout";
  static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
  private static final int TYPE_ON_INTERCEPT = 0;
  private static final int TYPE_ON_TOUCH = 1;
  static final String WIDGET_PACKAGE_NAME;
  static final ThreadLocal<Map<String, Constructor<CoordinatorLayout.Behavior>>> sConstructors = new ThreadLocal();
  private static final Pools.Pool<Rect> sRectPool = new Pools.SynchronizedPool(12);
  private OnApplyWindowInsetsListener mApplyWindowInsetsListener;
  private final int[] mBehaviorConsumed = new int[2];
  private View mBehaviorTouchView;
  private final DirectedAcyclicGraph<View> mChildDag = new DirectedAcyclicGraph();
  private final List<View> mDependencySortedChildren = new ArrayList();
  private boolean mDisallowInterceptReset;
  private boolean mDrawStatusBarBackground;
  private boolean mIsAttachedToWindow;
  private int[] mKeylines;
  private WindowInsetsCompat mLastInsets;
  private boolean mNeedsPreDrawListener;
  private final NestedScrollingParentHelper mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
  private View mNestedScrollingTarget;
  private final int[] mNestedScrollingV2ConsumedCompat = new int[2];
  ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
  private CoordinatorLayout.OnPreDrawListener mOnPreDrawListener;
  private Paint mScrimPaint;
  private Drawable mStatusBarBackground;
  private final List<View> mTempDependenciesList = new ArrayList();
  private final List<View> mTempList1 = new ArrayList();
  
  static
  {
    Object localObject = CoordinatorLayout.class.getPackage();
    if (localObject != null) {
      localObject = ((Package)localObject).getName();
    } else {
      localObject = null;
    }
    WIDGET_PACKAGE_NAME = (String)localObject;
    if (Build.VERSION.SDK_INT >= 21) {
      TOP_SORTED_CHILDREN_COMPARATOR = new CoordinatorLayout.ViewElevationComparator();
    } else {
      TOP_SORTED_CHILDREN_COMPARATOR = null;
    }
  }
  
  public CoordinatorLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CoordinatorLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.coordinatorLayoutStyle);
  }
  
  public CoordinatorLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    int i = 0;
    TypedArray localTypedArray;
    if (paramInt == 0) {
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout);
    } else {
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CoordinatorLayout, paramInt, 0);
    }
    if (Build.VERSION.SDK_INT >= 29) {
      if (paramInt == 0) {
        saveAttributeDataForStyleable(paramContext, R.styleable.CoordinatorLayout, paramAttributeSet, localTypedArray, 0, R.style.Widget_Support_CoordinatorLayout);
      } else {
        saveAttributeDataForStyleable(paramContext, R.styleable.CoordinatorLayout, paramAttributeSet, localTypedArray, paramInt, 0);
      }
    }
    paramInt = localTypedArray.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
    if (paramInt != 0)
    {
      paramContext = paramContext.getResources();
      this.mKeylines = paramContext.getIntArray(paramInt);
      float f = paramContext.getDisplayMetrics().density;
      int j = this.mKeylines.length;
      paramInt = i;
      while (paramInt < j)
      {
        paramContext = this.mKeylines;
        paramContext[paramInt] = ((int)(paramContext[paramInt] * f));
        paramInt += 1;
      }
    }
    this.mStatusBarBackground = localTypedArray.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
    localTypedArray.recycle();
    setupForInsets();
    super.setOnHierarchyChangeListener(new CoordinatorLayout.HierarchyChangeListener(this));
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
  }
  
  @NonNull
  private static Rect acquireTempRect()
  {
    Rect localRect2 = (Rect)sRectPool.acquire();
    Rect localRect1 = localRect2;
    if (localRect2 == null) {
      localRect1 = new Rect();
    }
    return localRect1;
  }
  
  private static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    return paramInt1;
  }
  
  private void constrainChildRect(CoordinatorLayout.LayoutParams paramLayoutParams, Rect paramRect, int paramInt1, int paramInt2)
  {
    int j = getWidth();
    int i = getHeight();
    j = Math.max(getPaddingLeft() + paramLayoutParams.leftMargin, Math.min(paramRect.left, j - getPaddingRight() - paramInt1 - paramLayoutParams.rightMargin));
    i = Math.max(getPaddingTop() + paramLayoutParams.topMargin, Math.min(paramRect.top, i - getPaddingBottom() - paramInt2 - paramLayoutParams.bottomMargin));
    paramRect.set(j, i, paramInt1 + j, paramInt2 + i);
  }
  
  private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat paramWindowInsetsCompat)
  {
    if (paramWindowInsetsCompat.isConsumed()) {
      return paramWindowInsetsCompat;
    }
    int i = 0;
    int j = getChildCount();
    for (WindowInsetsCompat localWindowInsetsCompat = paramWindowInsetsCompat; i < j; localWindowInsetsCompat = paramWindowInsetsCompat)
    {
      View localView = getChildAt(i);
      paramWindowInsetsCompat = localWindowInsetsCompat;
      if (ViewCompat.getFitsSystemWindows(localView))
      {
        CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)localView.getLayoutParams()).getBehavior();
        paramWindowInsetsCompat = localWindowInsetsCompat;
        if (localBehavior != null)
        {
          localWindowInsetsCompat = localBehavior.onApplyWindowInsets(this, localView, localWindowInsetsCompat);
          paramWindowInsetsCompat = localWindowInsetsCompat;
          if (localWindowInsetsCompat.isConsumed()) {
            return localWindowInsetsCompat;
          }
        }
      }
      i += 1;
    }
    return localWindowInsetsCompat;
  }
  
  private void getDesiredAnchoredChildRectWithoutConstraints(View paramView, int paramInt1, Rect paramRect1, Rect paramRect2, CoordinatorLayout.LayoutParams paramLayoutParams, int paramInt2, int paramInt3)
  {
    int i = GravityCompat.getAbsoluteGravity(resolveAnchoredChildGravity(paramLayoutParams.gravity), paramInt1);
    paramInt1 = GravityCompat.getAbsoluteGravity(resolveGravity(paramLayoutParams.anchorGravity), paramInt1);
    int m = i & 0x7;
    int k = i & 0x70;
    int j = paramInt1 & 0x7;
    i = paramInt1 & 0x70;
    if (j != 1)
    {
      if (j != 5) {
        paramInt1 = paramRect1.left;
      } else {
        paramInt1 = paramRect1.right;
      }
    }
    else {
      paramInt1 = paramRect1.left + paramRect1.width() / 2;
    }
    if (i != 16)
    {
      if (i != 80) {
        i = paramRect1.top;
      } else {
        i = paramRect1.bottom;
      }
    }
    else {
      i = paramRect1.top + paramRect1.height() / 2;
    }
    if (m != 1)
    {
      j = paramInt1;
      if (m != 5) {
        j = paramInt1 - paramInt2;
      }
    }
    else
    {
      j = paramInt1 - paramInt2 / 2;
    }
    if (k != 16)
    {
      paramInt1 = i;
      if (k != 80) {
        paramInt1 = i - paramInt3;
      }
    }
    else
    {
      paramInt1 = i - paramInt3 / 2;
    }
    paramRect2.set(j, paramInt1, paramInt2 + j, paramInt3 + paramInt1);
  }
  
  private int getKeyline(int paramInt)
  {
    Object localObject = this.mKeylines;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No keylines defined for ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" - attempted index lookup ");
      ((StringBuilder)localObject).append(paramInt);
      Log.e("CoordinatorLayout", ((StringBuilder)localObject).toString());
      return 0;
    }
    if ((paramInt >= 0) && (paramInt < localObject.length)) {
      return localObject[paramInt];
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Keyline index ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" out of range for ");
    ((StringBuilder)localObject).append(this);
    Log.e("CoordinatorLayout", ((StringBuilder)localObject).toString());
    return 0;
  }
  
  private void getTopSortedChildren(List<View> paramList)
  {
    paramList.clear();
    boolean bool = isChildrenDrawingOrderEnabled();
    int k = getChildCount();
    int i = k - 1;
    while (i >= 0)
    {
      int j;
      if (bool) {
        j = getChildDrawingOrder(k, i);
      } else {
        j = i;
      }
      paramList.add(getChildAt(j));
      i -= 1;
    }
    Comparator localComparator = TOP_SORTED_CHILDREN_COMPARATOR;
    if (localComparator != null) {
      Collections.sort(paramList, localComparator);
    }
  }
  
  private boolean hasDependencies(View paramView)
  {
    return this.mChildDag.hasOutgoingEdges(paramView);
  }
  
  private void layoutChild(View paramView, int paramInt)
  {
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
    Rect localRect1 = acquireTempRect();
    localRect1.set(getPaddingLeft() + localLayoutParams.leftMargin, getPaddingTop() + localLayoutParams.topMargin, getWidth() - getPaddingRight() - localLayoutParams.rightMargin, getHeight() - getPaddingBottom() - localLayoutParams.bottomMargin);
    if ((this.mLastInsets != null) && (ViewCompat.getFitsSystemWindows(this)) && (!ViewCompat.getFitsSystemWindows(paramView)))
    {
      localRect1.left += this.mLastInsets.getSystemWindowInsetLeft();
      localRect1.top += this.mLastInsets.getSystemWindowInsetTop();
      localRect1.right -= this.mLastInsets.getSystemWindowInsetRight();
      localRect1.bottom -= this.mLastInsets.getSystemWindowInsetBottom();
    }
    Rect localRect2 = acquireTempRect();
    GravityCompat.apply(resolveGravity(localLayoutParams.gravity), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect1, localRect2, paramInt);
    paramView.layout(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
    releaseTempRect(localRect1);
    releaseTempRect(localRect2);
  }
  
  private void layoutChildWithAnchor(View paramView1, View paramView2, int paramInt)
  {
    Rect localRect1 = acquireTempRect();
    Rect localRect2 = acquireTempRect();
    try
    {
      getDescendantRect(paramView2, localRect1);
      getDesiredAnchoredChildRect(paramView1, paramInt, localRect1, localRect2);
      paramView1.layout(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
      return;
    }
    finally
    {
      releaseTempRect(localRect1);
      releaseTempRect(localRect2);
    }
  }
  
  private void layoutChildWithKeyline(View paramView, int paramInt1, int paramInt2)
  {
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
    int i = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(localLayoutParams.gravity), paramInt2);
    int i2 = i & 0x7;
    int i1 = i & 0x70;
    int n = getWidth();
    int m = getHeight();
    int j = paramView.getMeasuredWidth();
    int k = paramView.getMeasuredHeight();
    i = paramInt1;
    if (paramInt2 == 1) {
      i = n - paramInt1;
    }
    paramInt1 = getKeyline(i) - j;
    paramInt2 = 0;
    if (i2 != 1)
    {
      if (i2 == 5) {
        paramInt1 += j;
      }
    }
    else {
      paramInt1 += j / 2;
    }
    if (i1 != 16)
    {
      if (i1 == 80) {
        paramInt2 = k + 0;
      }
    }
    else {
      paramInt2 = 0 + k / 2;
    }
    paramInt1 = Math.max(getPaddingLeft() + localLayoutParams.leftMargin, Math.min(paramInt1, n - getPaddingRight() - j - localLayoutParams.rightMargin));
    paramInt2 = Math.max(getPaddingTop() + localLayoutParams.topMargin, Math.min(paramInt2, m - getPaddingBottom() - k - localLayoutParams.bottomMargin));
    paramView.layout(paramInt1, paramInt2, j + paramInt1, k + paramInt2);
  }
  
  private void offsetChildByInset(View paramView, Rect paramRect, int paramInt)
  {
    if (!ViewCompat.isLaidOut(paramView)) {
      return;
    }
    if (paramView.getWidth() > 0)
    {
      if (paramView.getHeight() <= 0) {
        return;
      }
      CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
      CoordinatorLayout.Behavior localBehavior = localLayoutParams.getBehavior();
      Rect localRect1 = acquireTempRect();
      Rect localRect2 = acquireTempRect();
      localRect2.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
      if ((localBehavior != null) && (localBehavior.getInsetDodgeRect(this, paramView, localRect1)))
      {
        if (!localRect2.contains(localRect1))
        {
          paramView = new StringBuilder();
          paramView.append("Rect should be within the child's bounds. Rect:");
          paramView.append(localRect1.toShortString());
          paramView.append(" | Bounds:");
          paramView.append(localRect2.toShortString());
          throw new IllegalArgumentException(paramView.toString());
        }
      }
      else {
        localRect1.set(localRect2);
      }
      releaseTempRect(localRect2);
      if (localRect1.isEmpty())
      {
        releaseTempRect(localRect1);
        return;
      }
      int j = GravityCompat.getAbsoluteGravity(localLayoutParams.dodgeInsetEdges, paramInt);
      if ((j & 0x30) == 48)
      {
        paramInt = localRect1.top - localLayoutParams.topMargin - localLayoutParams.mInsetOffsetY;
        if (paramInt < paramRect.top)
        {
          setInsetOffsetY(paramView, paramRect.top - paramInt);
          paramInt = 1;
          break label247;
        }
      }
      paramInt = 0;
      label247:
      int i = paramInt;
      if ((j & 0x50) == 80)
      {
        int k = getHeight() - localRect1.bottom - localLayoutParams.bottomMargin + localLayoutParams.mInsetOffsetY;
        i = paramInt;
        if (k < paramRect.bottom)
        {
          setInsetOffsetY(paramView, k - paramRect.bottom);
          i = 1;
        }
      }
      if (i == 0) {
        setInsetOffsetY(paramView, 0);
      }
      if ((j & 0x3) == 3)
      {
        paramInt = localRect1.left - localLayoutParams.leftMargin - localLayoutParams.mInsetOffsetX;
        if (paramInt < paramRect.left)
        {
          setInsetOffsetX(paramView, paramRect.left - paramInt);
          paramInt = 1;
          break label374;
        }
      }
      paramInt = 0;
      label374:
      i = paramInt;
      if ((j & 0x5) == 5)
      {
        j = getWidth() - localRect1.right - localLayoutParams.rightMargin + localLayoutParams.mInsetOffsetX;
        i = paramInt;
        if (j < paramRect.right)
        {
          setInsetOffsetX(paramView, j - paramRect.right);
          i = 1;
        }
      }
      if (i == 0) {
        setInsetOffsetX(paramView, 0);
      }
      releaseTempRect(localRect1);
    }
  }
  
  static CoordinatorLayout.Behavior parseBehavior(Context paramContext, AttributeSet paramAttributeSet, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject1;
    if (paramString.startsWith("."))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContext.getPackageName());
      ((StringBuilder)localObject1).append(paramString);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else if (paramString.indexOf('.') >= 0)
    {
      localObject1 = paramString;
    }
    else
    {
      localObject1 = paramString;
      if (!TextUtils.isEmpty(WIDGET_PACKAGE_NAME))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(WIDGET_PACKAGE_NAME);
        ((StringBuilder)localObject1).append('.');
        ((StringBuilder)localObject1).append(paramString);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    try
    {
      Object localObject2 = (Map)sConstructors.get();
      paramString = (String)localObject2;
      if (localObject2 == null)
      {
        paramString = new HashMap();
        sConstructors.set(paramString);
      }
      Constructor localConstructor = (Constructor)paramString.get(localObject1);
      localObject2 = localConstructor;
      if (localConstructor == null)
      {
        localObject2 = Class.forName((String)localObject1, false, paramContext.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);
        ((Constructor)localObject2).setAccessible(true);
        paramString.put(localObject1, localObject2);
      }
      paramContext = (CoordinatorLayout.Behavior)((Constructor)localObject2).newInstance(new Object[] { paramContext, paramAttributeSet });
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramAttributeSet = new StringBuilder();
      paramAttributeSet.append("Could not inflate Behavior subclass ");
      paramAttributeSet.append((String)localObject1);
      throw new RuntimeException(paramAttributeSet.toString(), paramContext);
    }
  }
  
  private boolean performIntercept(MotionEvent paramMotionEvent, int paramInt)
  {
    int m = paramMotionEvent.getActionMasked();
    List localList = this.mTempList1;
    getTopSortedChildren(localList);
    int n = localList.size();
    Object localObject1 = null;
    int j = 0;
    boolean bool1 = false;
    int i = 0;
    boolean bool2;
    for (;;)
    {
      bool2 = bool1;
      if (j >= n) {
        break;
      }
      View localView = (View)localList.get(j);
      Object localObject2 = (CoordinatorLayout.LayoutParams)localView.getLayoutParams();
      CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)localObject2).getBehavior();
      int k = 1;
      if (((bool1) || (i != 0)) && (m != 0))
      {
        bool2 = bool1;
        k = i;
        localObject2 = localObject1;
        if (localBehavior != null)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            long l = SystemClock.uptimeMillis();
            localObject2 = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
          }
          if (paramInt != 0)
          {
            if (paramInt != 1)
            {
              bool2 = bool1;
              k = i;
            }
            else
            {
              localBehavior.onTouchEvent(this, localView, (MotionEvent)localObject2);
              bool2 = bool1;
              k = i;
            }
          }
          else
          {
            localBehavior.onInterceptTouchEvent(this, localView, (MotionEvent)localObject2);
            bool2 = bool1;
            k = i;
          }
        }
      }
      else
      {
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (localBehavior != null)
          {
            if (paramInt != 0)
            {
              if (paramInt == 1) {
                bool1 = localBehavior.onTouchEvent(this, localView, paramMotionEvent);
              }
            }
            else {
              bool1 = localBehavior.onInterceptTouchEvent(this, localView, paramMotionEvent);
            }
            bool2 = bool1;
            if (bool1)
            {
              this.mBehaviorTouchView = localView;
              bool2 = bool1;
            }
          }
        }
        bool1 = ((CoordinatorLayout.LayoutParams)localObject2).didBlockInteraction();
        boolean bool3 = ((CoordinatorLayout.LayoutParams)localObject2).isBlockingInteractionBelow(this, localView);
        if ((bool3) && (!bool1)) {
          i = k;
        } else {
          i = 0;
        }
        if ((bool3) && (i == 0)) {
          break;
        }
        localObject2 = localObject1;
        k = i;
      }
      j += 1;
      bool1 = bool2;
      i = k;
      localObject1 = localObject2;
    }
    localList.clear();
    return bool2;
  }
  
  private void prepareChildren()
  {
    this.mDependencySortedChildren.clear();
    this.mChildDag.clear();
    int k = getChildCount();
    int i = 0;
    while (i < k)
    {
      View localView1 = getChildAt(i);
      CoordinatorLayout.LayoutParams localLayoutParams = getResolvedLayoutParams(localView1);
      localLayoutParams.findAnchorView(this, localView1);
      this.mChildDag.addNode(localView1);
      int j = 0;
      while (j < k)
      {
        if (j != i)
        {
          View localView2 = getChildAt(j);
          if (localLayoutParams.dependsOn(this, localView1, localView2))
          {
            if (!this.mChildDag.contains(localView2)) {
              this.mChildDag.addNode(localView2);
            }
            this.mChildDag.addEdge(localView2, localView1);
          }
        }
        j += 1;
      }
      i += 1;
    }
    this.mDependencySortedChildren.addAll(this.mChildDag.getSortedList());
    Collections.reverse(this.mDependencySortedChildren);
  }
  
  private static void releaseTempRect(@NonNull Rect paramRect)
  {
    paramRect.setEmpty();
    sRectPool.release(paramRect);
  }
  
  private void resetTouchBehaviors(boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)localView.getLayoutParams()).getBehavior();
      if (localBehavior != null)
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        if (paramBoolean) {
          localBehavior.onInterceptTouchEvent(this, localView, localMotionEvent);
        } else {
          localBehavior.onTouchEvent(this, localView, localMotionEvent);
        }
        localMotionEvent.recycle();
      }
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      ((CoordinatorLayout.LayoutParams)getChildAt(i).getLayoutParams()).resetTouchBehaviorTracking();
      i += 1;
    }
    this.mBehaviorTouchView = null;
    this.mDisallowInterceptReset = false;
  }
  
  private static int resolveAnchoredChildGravity(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 17;
    }
    return i;
  }
  
  private static int resolveGravity(int paramInt)
  {
    int i = paramInt;
    if ((paramInt & 0x7) == 0) {
      i = paramInt | 0x800003;
    }
    paramInt = i;
    if ((i & 0x70) == 0) {
      paramInt = i | 0x30;
    }
    return paramInt;
  }
  
  private static int resolveKeylineGravity(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 8388661;
    }
    return i;
  }
  
  private void setInsetOffsetX(View paramView, int paramInt)
  {
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams.mInsetOffsetX != paramInt)
    {
      ViewCompat.offsetLeftAndRight(paramView, paramInt - localLayoutParams.mInsetOffsetX);
      localLayoutParams.mInsetOffsetX = paramInt;
    }
  }
  
  private void setInsetOffsetY(View paramView, int paramInt)
  {
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams.mInsetOffsetY != paramInt)
    {
      ViewCompat.offsetTopAndBottom(paramView, paramInt - localLayoutParams.mInsetOffsetY);
      localLayoutParams.mInsetOffsetY = paramInt;
    }
  }
  
  private void setupForInsets()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    if (ViewCompat.getFitsSystemWindows(this))
    {
      if (this.mApplyWindowInsetsListener == null) {
        this.mApplyWindowInsetsListener = new CoordinatorLayout.1(this);
      }
      ViewCompat.setOnApplyWindowInsetsListener(this, this.mApplyWindowInsetsListener);
      setSystemUiVisibility(1280);
      return;
    }
    ViewCompat.setOnApplyWindowInsetsListener(this, null);
  }
  
  void addPreDrawListener()
  {
    if (this.mIsAttachedToWindow)
    {
      if (this.mOnPreDrawListener == null) {
        this.mOnPreDrawListener = new CoordinatorLayout.OnPreDrawListener(this);
      }
      getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
    }
    this.mNeedsPreDrawListener = true;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof CoordinatorLayout.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void dispatchDependentViewsChanged(@NonNull View paramView)
  {
    List localList = this.mChildDag.getIncomingEdges(paramView);
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i = 0;
      while (i < localList.size())
      {
        View localView = (View)localList.get(i);
        CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)localView.getLayoutParams()).getBehavior();
        if (localBehavior != null) {
          localBehavior.onDependentViewChanged(this, localView, paramView);
        }
        i += 1;
      }
    }
  }
  
  public boolean doViewsOverlap(@NonNull View paramView1, @NonNull View paramView2)
  {
    int i = paramView1.getVisibility();
    boolean bool2 = false;
    if ((i == 0) && (paramView2.getVisibility() == 0))
    {
      Rect localRect = acquireTempRect();
      if (paramView1.getParent() != this) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      getChildRect(paramView1, bool1, localRect);
      paramView1 = acquireTempRect();
      if (paramView2.getParent() != this) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      getChildRect(paramView2, bool1, paramView1);
      boolean bool1 = bool2;
      try
      {
        if (localRect.left <= paramView1.right)
        {
          bool1 = bool2;
          if (localRect.top <= paramView1.bottom)
          {
            bool1 = bool2;
            if (localRect.right >= paramView1.left)
            {
              i = localRect.bottom;
              int j = paramView1.top;
              bool1 = bool2;
              if (i >= j) {
                bool1 = true;
              }
            }
          }
        }
        return bool1;
      }
      finally
      {
        releaseTempRect(localRect);
        releaseTempRect(paramView1);
      }
    }
    return false;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams.mBehavior != null)
    {
      float f = localLayoutParams.mBehavior.getScrimOpacity(this, paramView);
      if (f > 0.0F)
      {
        if (this.mScrimPaint == null) {
          this.mScrimPaint = new Paint();
        }
        this.mScrimPaint.setColor(localLayoutParams.mBehavior.getScrimColor(this, paramView));
        this.mScrimPaint.setAlpha(clamp(Math.round(f * 255.0F), 0, 255));
        int i = paramCanvas.save();
        if (paramView.isOpaque()) {
          paramCanvas.clipRect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom(), Region.Op.DIFFERENCE);
        }
        paramCanvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.mScrimPaint);
        paramCanvas.restoreToCount(i);
      }
    }
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable localDrawable = this.mStatusBarBackground;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = false | localDrawable.setState(arrayOfInt);
      }
    }
    if (bool1) {
      invalidate();
    }
  }
  
  void ensurePreDrawListener()
  {
    int j = getChildCount();
    int m = 0;
    int i = 0;
    int k;
    for (;;)
    {
      k = m;
      if (i >= j) {
        break;
      }
      if (hasDependencies(getChildAt(i)))
      {
        k = 1;
        break;
      }
      i += 1;
    }
    if (k != this.mNeedsPreDrawListener)
    {
      if (k != 0)
      {
        addPreDrawListener();
        return;
      }
      removePreDrawListener();
    }
  }
  
  protected CoordinatorLayout.LayoutParams generateDefaultLayoutParams()
  {
    return new CoordinatorLayout.LayoutParams(-2, -2);
  }
  
  public CoordinatorLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new CoordinatorLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected CoordinatorLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof CoordinatorLayout.LayoutParams)) {
      return new CoordinatorLayout.LayoutParams((CoordinatorLayout.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new CoordinatorLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new CoordinatorLayout.LayoutParams(paramLayoutParams);
  }
  
  void getChildRect(View paramView, boolean paramBoolean, Rect paramRect)
  {
    if ((!paramView.isLayoutRequested()) && (paramView.getVisibility() != 8))
    {
      if (paramBoolean)
      {
        getDescendantRect(paramView, paramRect);
        return;
      }
      paramRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
      return;
    }
    paramRect.setEmpty();
  }
  
  @NonNull
  public List<View> getDependencies(@NonNull View paramView)
  {
    paramView = this.mChildDag.getOutgoingEdges(paramView);
    this.mTempDependenciesList.clear();
    if (paramView != null) {
      this.mTempDependenciesList.addAll(paramView);
    }
    return this.mTempDependenciesList;
  }
  
  @VisibleForTesting
  final List<View> getDependencySortedChildren()
  {
    prepareChildren();
    return Collections.unmodifiableList(this.mDependencySortedChildren);
  }
  
  @NonNull
  public List<View> getDependents(@NonNull View paramView)
  {
    paramView = this.mChildDag.getIncomingEdges(paramView);
    this.mTempDependenciesList.clear();
    if (paramView != null) {
      this.mTempDependenciesList.addAll(paramView);
    }
    return this.mTempDependenciesList;
  }
  
  void getDescendantRect(View paramView, Rect paramRect)
  {
    ViewGroupUtils.getDescendantRect(this, paramView, paramRect);
  }
  
  void getDesiredAnchoredChildRect(View paramView, int paramInt, Rect paramRect1, Rect paramRect2)
  {
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    getDesiredAnchoredChildRectWithoutConstraints(paramView, paramInt, paramRect1, paramRect2, localLayoutParams, i, j);
    constrainChildRect(localLayoutParams, paramRect2, i, j);
  }
  
  void getLastChildRect(View paramView, Rect paramRect)
  {
    paramRect.set(((CoordinatorLayout.LayoutParams)paramView.getLayoutParams()).getLastChildRect());
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public final WindowInsetsCompat getLastWindowInsets()
  {
    return this.mLastInsets;
  }
  
  public int getNestedScrollAxes()
  {
    return this.mNestedScrollingParentHelper.getNestedScrollAxes();
  }
  
  CoordinatorLayout.LayoutParams getResolvedLayoutParams(View paramView)
  {
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.mBehaviorResolved)
    {
      if ((paramView instanceof CoordinatorLayout.AttachedBehavior))
      {
        paramView = ((CoordinatorLayout.AttachedBehavior)paramView).getBehavior();
        if (paramView == null) {
          Log.e("CoordinatorLayout", "Attached behavior class is null");
        }
        localLayoutParams.setBehavior(paramView);
        localLayoutParams.mBehaviorResolved = true;
        return localLayoutParams;
      }
      Class localClass = paramView.getClass();
      Object localObject;
      for (paramView = null; localClass != null; paramView = (View)localObject)
      {
        localObject = (CoordinatorLayout.DefaultBehavior)localClass.getAnnotation(CoordinatorLayout.DefaultBehavior.class);
        paramView = (View)localObject;
        if (localObject != null) {
          break;
        }
        localClass = localClass.getSuperclass();
      }
      if (paramView != null) {
        try
        {
          localLayoutParams.setBehavior((CoordinatorLayout.Behavior)paramView.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        catch (Exception localException)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Default behavior class ");
          ((StringBuilder)localObject).append(paramView.value().getName());
          ((StringBuilder)localObject).append(" could not be instantiated. Did you forget a default constructor?");
          Log.e("CoordinatorLayout", ((StringBuilder)localObject).toString(), localException);
        }
      }
      localLayoutParams.mBehaviorResolved = true;
    }
    return localLayoutParams;
  }
  
  @Nullable
  public Drawable getStatusBarBackground()
  {
    return this.mStatusBarBackground;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
  }
  
  protected int getSuggestedMinimumWidth()
  {
    return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
  }
  
  public boolean isPointInChildBounds(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    Rect localRect = acquireTempRect();
    getDescendantRect(paramView, localRect);
    try
    {
      boolean bool = localRect.contains(paramInt1, paramInt2);
      return bool;
    }
    finally
    {
      releaseTempRect(localRect);
    }
  }
  
  void offsetChildToAnchor(View paramView, int paramInt)
  {
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams.mAnchorView != null)
    {
      Rect localRect1 = acquireTempRect();
      Rect localRect2 = acquireTempRect();
      Rect localRect3 = acquireTempRect();
      getDescendantRect(localLayoutParams.mAnchorView, localRect1);
      int i = 0;
      getChildRect(paramView, false, localRect2);
      int j = paramView.getMeasuredWidth();
      int k = paramView.getMeasuredHeight();
      getDesiredAnchoredChildRectWithoutConstraints(paramView, paramInt, localRect1, localRect3, localLayoutParams, j, k);
      if (localRect3.left == localRect2.left)
      {
        paramInt = i;
        if (localRect3.top == localRect2.top) {}
      }
      else
      {
        paramInt = 1;
      }
      constrainChildRect(localLayoutParams, localRect3, j, k);
      i = localRect3.left - localRect2.left;
      j = localRect3.top - localRect2.top;
      if (i != 0) {
        ViewCompat.offsetLeftAndRight(paramView, i);
      }
      if (j != 0) {
        ViewCompat.offsetTopAndBottom(paramView, j);
      }
      if (paramInt != 0)
      {
        CoordinatorLayout.Behavior localBehavior = localLayoutParams.getBehavior();
        if (localBehavior != null) {
          localBehavior.onDependentViewChanged(this, paramView, localLayoutParams.mAnchorView);
        }
      }
      releaseTempRect(localRect1);
      releaseTempRect(localRect2);
      releaseTempRect(localRect3);
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    resetTouchBehaviors(false);
    if (this.mNeedsPreDrawListener)
    {
      if (this.mOnPreDrawListener == null) {
        this.mOnPreDrawListener = new CoordinatorLayout.OnPreDrawListener(this);
      }
      getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
    }
    if ((this.mLastInsets == null) && (ViewCompat.getFitsSystemWindows(this))) {
      ViewCompat.requestApplyInsets(this);
    }
    this.mIsAttachedToWindow = true;
  }
  
  final void onChildViewsChanged(int paramInt)
  {
    int k = ViewCompat.getLayoutDirection(this);
    int m = this.mDependencySortedChildren.size();
    Rect localRect1 = acquireTempRect();
    Rect localRect2 = acquireTempRect();
    Rect localRect3 = acquireTempRect();
    int i = 0;
    while (i < m)
    {
      View localView = (View)this.mDependencySortedChildren.get(i);
      Object localObject1 = (CoordinatorLayout.LayoutParams)localView.getLayoutParams();
      if ((paramInt != 0) || (localView.getVisibility() != 8))
      {
        int j = 0;
        Object localObject2;
        while (j < i)
        {
          localObject2 = (View)this.mDependencySortedChildren.get(j);
          if (((CoordinatorLayout.LayoutParams)localObject1).mAnchorDirectChild == localObject2) {
            offsetChildToAnchor(localView, k);
          }
          j += 1;
        }
        getChildRect(localView, true, localRect2);
        if ((((CoordinatorLayout.LayoutParams)localObject1).insetEdge != 0) && (!localRect2.isEmpty()))
        {
          j = GravityCompat.getAbsoluteGravity(((CoordinatorLayout.LayoutParams)localObject1).insetEdge, k);
          int n = j & 0x70;
          if (n != 48)
          {
            if (n == 80) {
              localRect1.bottom = Math.max(localRect1.bottom, getHeight() - localRect2.top);
            }
          }
          else {
            localRect1.top = Math.max(localRect1.top, localRect2.bottom);
          }
          j &= 0x7;
          if (j != 3)
          {
            if (j == 5) {
              localRect1.right = Math.max(localRect1.right, getWidth() - localRect2.left);
            }
          }
          else {
            localRect1.left = Math.max(localRect1.left, localRect2.right);
          }
        }
        if ((((CoordinatorLayout.LayoutParams)localObject1).dodgeInsetEdges != 0) && (localView.getVisibility() == 0)) {
          offsetChildByInset(localView, localRect1, k);
        }
        if (paramInt != 2)
        {
          getLastChildRect(localView, localRect3);
          if (!localRect3.equals(localRect2)) {
            recordLastChildRect(localView, localRect2);
          }
        }
        else
        {
          j = i + 1;
          while (j < m)
          {
            localObject1 = (View)this.mDependencySortedChildren.get(j);
            localObject2 = (CoordinatorLayout.LayoutParams)((View)localObject1).getLayoutParams();
            CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)localObject2).getBehavior();
            if ((localBehavior != null) && (localBehavior.layoutDependsOn(this, (View)localObject1, localView))) {
              if ((paramInt == 0) && (((CoordinatorLayout.LayoutParams)localObject2).getChangedAfterNestedScroll()))
              {
                ((CoordinatorLayout.LayoutParams)localObject2).resetChangedAfterNestedScroll();
              }
              else
              {
                boolean bool;
                if (paramInt != 2)
                {
                  bool = localBehavior.onDependentViewChanged(this, (View)localObject1, localView);
                }
                else
                {
                  localBehavior.onDependentViewRemoved(this, (View)localObject1, localView);
                  bool = true;
                }
                if (paramInt == 1) {
                  ((CoordinatorLayout.LayoutParams)localObject2).setChangedAfterNestedScroll(bool);
                }
              }
            }
            j += 1;
          }
        }
      }
      i += 1;
    }
    releaseTempRect(localRect1);
    releaseTempRect(localRect2);
    releaseTempRect(localRect3);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    resetTouchBehaviors(false);
    if ((this.mNeedsPreDrawListener) && (this.mOnPreDrawListener != null)) {
      getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
    }
    View localView = this.mNestedScrollingTarget;
    if (localView != null) {
      onStopNestedScroll(localView);
    }
    this.mIsAttachedToWindow = false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.mDrawStatusBarBackground) && (this.mStatusBarBackground != null))
    {
      WindowInsetsCompat localWindowInsetsCompat = this.mLastInsets;
      int i;
      if (localWindowInsetsCompat != null) {
        i = localWindowInsetsCompat.getSystemWindowInsetTop();
      } else {
        i = 0;
      }
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
    if (i == 0) {
      resetTouchBehaviors(true);
    }
    boolean bool = performIntercept(paramMotionEvent, 0);
    if ((i == 1) || (i == 3)) {
      resetTouchBehaviors(true);
    }
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = ViewCompat.getLayoutDirection(this);
    paramInt3 = this.mDependencySortedChildren.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = (View)this.mDependencySortedChildren.get(paramInt1);
      if (localView.getVisibility() != 8)
      {
        CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)localView.getLayoutParams()).getBehavior();
        if ((localBehavior == null) || (!localBehavior.onLayoutChild(this, localView, paramInt2))) {
          onLayoutChild(localView, paramInt2);
        }
      }
      paramInt1 += 1;
    }
  }
  
  public void onLayoutChild(@NonNull View paramView, int paramInt)
  {
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.checkAnchorChanged())
    {
      if (localLayoutParams.mAnchorView != null)
      {
        layoutChildWithAnchor(paramView, localLayoutParams.mAnchorView, paramInt);
        return;
      }
      if (localLayoutParams.keyline >= 0)
      {
        layoutChildWithKeyline(paramView, localLayoutParams.keyline, paramInt);
        return;
      }
      layoutChild(paramView, paramInt);
      return;
    }
    throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    prepareChildren();
    ensurePreDrawListener();
    int i6 = getPaddingLeft();
    int i7 = getPaddingTop();
    int i8 = getPaddingRight();
    int i9 = getPaddingBottom();
    int i10 = ViewCompat.getLayoutDirection(this);
    int k;
    if (i10 == 1) {
      k = 1;
    } else {
      k = 0;
    }
    int i11 = View.MeasureSpec.getMode(paramInt1);
    int i12 = View.MeasureSpec.getSize(paramInt1);
    int i13 = View.MeasureSpec.getMode(paramInt2);
    int i14 = View.MeasureSpec.getSize(paramInt2);
    int i3 = getSuggestedMinimumWidth();
    int j = getSuggestedMinimumHeight();
    int m;
    if ((this.mLastInsets != null) && (ViewCompat.getFitsSystemWindows(this))) {
      m = 1;
    } else {
      m = 0;
    }
    int n = this.mDependencySortedChildren.size();
    int i2 = 0;
    int i1 = 0;
    while (i1 < n)
    {
      View localView = (View)this.mDependencySortedChildren.get(i1);
      if (localView.getVisibility() != 8)
      {
        CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)localView.getLayoutParams();
        int i4;
        if ((localLayoutParams.keyline >= 0) && (i11 != 0))
        {
          i = getKeyline(localLayoutParams.keyline);
          i4 = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(localLayoutParams.gravity), i10) & 0x7;
          if (((i4 == 3) && (k == 0)) || ((i4 == 5) && (k != 0)))
          {
            i = Math.max(0, i12 - i8 - i);
            break label289;
          }
          if (((i4 == 5) && (k == 0)) || ((i4 == 3) && (k != 0)))
          {
            i = Math.max(0, i - i6);
            break label289;
          }
        }
        int i = 0;
        label289:
        int i5 = j;
        if ((m != 0) && (!ViewCompat.getFitsSystemWindows(localView)))
        {
          j = this.mLastInsets.getSystemWindowInsetLeft();
          int i16 = this.mLastInsets.getSystemWindowInsetRight();
          i4 = this.mLastInsets.getSystemWindowInsetTop();
          int i15 = this.mLastInsets.getSystemWindowInsetBottom();
          j = View.MeasureSpec.makeMeasureSpec(i12 - (j + i16), i11);
          i4 = View.MeasureSpec.makeMeasureSpec(i14 - (i4 + i15), i13);
        }
        else
        {
          j = paramInt1;
          i4 = paramInt2;
        }
        CoordinatorLayout.Behavior localBehavior = localLayoutParams.getBehavior();
        if (localBehavior != null) {
          if (localBehavior.onMeasureChild(this, localView, j, i, i4, 0)) {
            break label425;
          }
        }
        onMeasureChild(localView, j, i, i4, 0);
        label425:
        i3 = Math.max(i3, i6 + i8 + localView.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin);
        j = Math.max(i5, i7 + i9 + localView.getMeasuredHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin);
        i2 = View.combineMeasuredStates(i2, localView.getMeasuredState());
      }
      i1 += 1;
    }
    setMeasuredDimension(View.resolveSizeAndState(i3, paramInt1, 0xFF000000 & i2), View.resolveSizeAndState(j, paramInt2, i2 << 16));
  }
  
  public void onMeasureChild(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 8)
      {
        bool2 = bool1;
      }
      else
      {
        Object localObject = (CoordinatorLayout.LayoutParams)localView.getLayoutParams();
        if (!((CoordinatorLayout.LayoutParams)localObject).isNestedScrollAccepted(0))
        {
          bool2 = bool1;
        }
        else
        {
          localObject = ((CoordinatorLayout.LayoutParams)localObject).getBehavior();
          bool2 = bool1;
          if (localObject != null) {
            bool2 = bool1 | ((CoordinatorLayout.Behavior)localObject).onNestedFling(this, localView, paramView, paramFloat1, paramFloat2, paramBoolean);
          }
        }
      }
      i += 1;
    }
    if (bool1) {
      onChildViewsChanged(1);
    }
    return bool1;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    int j = getChildCount();
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 8)
      {
        bool2 = bool1;
      }
      else
      {
        Object localObject = (CoordinatorLayout.LayoutParams)localView.getLayoutParams();
        if (!((CoordinatorLayout.LayoutParams)localObject).isNestedScrollAccepted(0))
        {
          bool2 = bool1;
        }
        else
        {
          localObject = ((CoordinatorLayout.LayoutParams)localObject).getBehavior();
          bool2 = bool1;
          if (localObject != null) {
            bool2 = bool1 | ((CoordinatorLayout.Behavior)localObject).onNestedPreFling(this, localView, paramView, paramFloat1, paramFloat2);
          }
        }
      }
      i += 1;
    }
    return bool1;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    int i2 = getChildCount();
    int i1 = 0;
    int k = 0;
    int m = 0;
    int i;
    for (int j = 0; k < i2; j = i)
    {
      View localView = getChildAt(k);
      int n;
      if (localView.getVisibility() == 8)
      {
        n = m;
        i = j;
      }
      else
      {
        Object localObject = (CoordinatorLayout.LayoutParams)localView.getLayoutParams();
        if (!((CoordinatorLayout.LayoutParams)localObject).isNestedScrollAccepted(paramInt3))
        {
          n = m;
          i = j;
        }
        else
        {
          localObject = ((CoordinatorLayout.LayoutParams)localObject).getBehavior();
          n = m;
          i = j;
          if (localObject != null)
          {
            int[] arrayOfInt = this.mBehaviorConsumed;
            arrayOfInt[0] = 0;
            arrayOfInt[1] = 0;
            ((CoordinatorLayout.Behavior)localObject).onNestedPreScroll(this, localView, paramView, paramInt1, paramInt2, arrayOfInt, paramInt3);
            if (paramInt1 > 0) {
              i = Math.max(m, this.mBehaviorConsumed[0]);
            } else {
              i = Math.min(m, this.mBehaviorConsumed[0]);
            }
            if (paramInt2 > 0) {
              j = Math.max(j, this.mBehaviorConsumed[1]);
            } else {
              j = Math.min(j, this.mBehaviorConsumed[1]);
            }
            n = i;
            i = j;
            i1 = 1;
          }
        }
      }
      k += 1;
      m = n;
    }
    paramArrayOfInt[0] = m;
    paramArrayOfInt[1] = j;
    if (i1 != 0) {
      onChildViewsChanged(1);
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0, this.mNestedScrollingV2ConsumedCompat);
  }
  
  public void onNestedScroll(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @NonNull int[] paramArrayOfInt)
  {
    int i2 = getChildCount();
    int i1 = 0;
    int k = 0;
    int m = 0;
    int i;
    for (int j = 0; k < i2; j = i)
    {
      View localView = getChildAt(k);
      int n;
      if (localView.getVisibility() == 8)
      {
        n = m;
        i = j;
      }
      else
      {
        Object localObject = (CoordinatorLayout.LayoutParams)localView.getLayoutParams();
        if (!((CoordinatorLayout.LayoutParams)localObject).isNestedScrollAccepted(paramInt5))
        {
          n = m;
          i = j;
        }
        else
        {
          localObject = ((CoordinatorLayout.LayoutParams)localObject).getBehavior();
          n = m;
          i = j;
          if (localObject != null)
          {
            int[] arrayOfInt = this.mBehaviorConsumed;
            arrayOfInt[0] = 0;
            arrayOfInt[1] = 0;
            ((CoordinatorLayout.Behavior)localObject).onNestedScroll(this, localView, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, arrayOfInt);
            if (paramInt3 > 0) {
              i = Math.max(m, this.mBehaviorConsumed[0]);
            } else {
              i = Math.min(m, this.mBehaviorConsumed[0]);
            }
            if (paramInt4 > 0) {
              j = Math.max(j, this.mBehaviorConsumed[1]);
            } else {
              j = Math.min(j, this.mBehaviorConsumed[1]);
            }
            n = i;
            i = j;
            i1 = 1;
          }
        }
      }
      k += 1;
      m = n;
    }
    paramArrayOfInt[0] += m;
    paramArrayOfInt[1] += j;
    if (i1 != 0) {
      onChildViewsChanged(1);
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    onNestedScrollAccepted(paramView1, paramView2, paramInt, 0);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    this.mNestedScrollingParentHelper.onNestedScrollAccepted(paramView1, paramView2, paramInt1, paramInt2);
    this.mNestedScrollingTarget = paramView2;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      Object localObject = (CoordinatorLayout.LayoutParams)localView.getLayoutParams();
      if (((CoordinatorLayout.LayoutParams)localObject).isNestedScrollAccepted(paramInt2))
      {
        localObject = ((CoordinatorLayout.LayoutParams)localObject).getBehavior();
        if (localObject != null) {
          ((CoordinatorLayout.Behavior)localObject).onNestedScrollAccepted(this, localView, paramView1, paramView2, paramInt1, paramInt2);
        }
      }
      i += 1;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof CoordinatorLayout.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (CoordinatorLayout.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    paramParcelable = paramParcelable.behaviorStates;
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      View localView = getChildAt(i);
      int k = localView.getId();
      CoordinatorLayout.Behavior localBehavior = getResolvedLayoutParams(localView).getBehavior();
      if ((k != -1) && (localBehavior != null))
      {
        Parcelable localParcelable = (Parcelable)paramParcelable.get(k);
        if (localParcelable != null) {
          localBehavior.onRestoreInstanceState(this, localView, localParcelable);
        }
      }
      i += 1;
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    CoordinatorLayout.SavedState localSavedState = new CoordinatorLayout.SavedState(super.onSaveInstanceState());
    SparseArray localSparseArray = new SparseArray();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(i);
      int k = ((View)localObject).getId();
      CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)((View)localObject).getLayoutParams()).getBehavior();
      if ((k != -1) && (localBehavior != null))
      {
        localObject = localBehavior.onSaveInstanceState(this, (View)localObject);
        if (localObject != null) {
          localSparseArray.append(k, localObject);
        }
      }
      i += 1;
    }
    localSavedState.behaviorStates = localSparseArray;
    return localSavedState;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return onStartNestedScroll(paramView1, paramView2, paramInt, 0);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    int j = getChildCount();
    int i = 0;
    boolean bool1 = false;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() != 8)
      {
        CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)localView.getLayoutParams();
        CoordinatorLayout.Behavior localBehavior = localLayoutParams.getBehavior();
        if (localBehavior != null)
        {
          boolean bool2 = localBehavior.onStartNestedScroll(this, localView, paramView1, paramView2, paramInt1, paramInt2);
          localLayoutParams.setNestedScrollAccepted(paramInt2, bool2);
          bool1 |= bool2;
        }
        else
        {
          localLayoutParams.setNestedScrollAccepted(paramInt2, false);
        }
      }
      i += 1;
    }
    return bool1;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    onStopNestedScroll(paramView, 0);
  }
  
  public void onStopNestedScroll(View paramView, int paramInt)
  {
    this.mNestedScrollingParentHelper.onStopNestedScroll(paramView, paramInt);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.isNestedScrollAccepted(paramInt))
      {
        CoordinatorLayout.Behavior localBehavior = localLayoutParams.getBehavior();
        if (localBehavior != null) {
          localBehavior.onStopNestedScroll(this, localView, paramView, paramInt);
        }
        localLayoutParams.resetNestedScroll(paramInt);
        localLayoutParams.resetChangedAfterNestedScroll();
      }
      i += 1;
    }
    this.mNestedScrollingTarget = null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    boolean bool1;
    if (this.mBehaviorTouchView == null)
    {
      bool1 = performIntercept(paramMotionEvent, 1);
      bool2 = bool1;
      if (!bool1) {
        break label76;
      }
    }
    else
    {
      bool1 = false;
    }
    CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)this.mBehaviorTouchView.getLayoutParams()).getBehavior();
    boolean bool2 = bool1;
    boolean bool3;
    if (localBehavior != null)
    {
      bool3 = localBehavior.onTouchEvent(this, this.mBehaviorTouchView, paramMotionEvent);
      bool2 = bool1;
      bool1 = bool3;
    }
    else
    {
      label76:
      bool1 = false;
    }
    View localView = this.mBehaviorTouchView;
    localBehavior = null;
    if (localView == null)
    {
      bool3 = bool1 | super.onTouchEvent(paramMotionEvent);
      paramMotionEvent = localBehavior;
    }
    else
    {
      bool3 = bool1;
      paramMotionEvent = localBehavior;
      if (bool2)
      {
        long l = SystemClock.uptimeMillis();
        paramMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        super.onTouchEvent(paramMotionEvent);
        bool3 = bool1;
      }
    }
    if (paramMotionEvent != null) {
      paramMotionEvent.recycle();
    }
    if ((i == 1) || (i == 3)) {
      resetTouchBehaviors(false);
    }
    return bool3;
  }
  
  void recordLastChildRect(View paramView, Rect paramRect)
  {
    ((CoordinatorLayout.LayoutParams)paramView.getLayoutParams()).setLastChildRect(paramRect);
  }
  
  void removePreDrawListener()
  {
    if ((this.mIsAttachedToWindow) && (this.mOnPreDrawListener != null)) {
      getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
    }
    this.mNeedsPreDrawListener = false;
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)paramView.getLayoutParams()).getBehavior();
    if ((localBehavior != null) && (localBehavior.onRequestChildRectangleOnScreen(this, paramView, paramRect, paramBoolean))) {
      return true;
    }
    return super.requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if ((paramBoolean) && (!this.mDisallowInterceptReset))
    {
      resetTouchBehaviors(false);
      this.mDisallowInterceptReset = true;
    }
  }
  
  public void setFitsSystemWindows(boolean paramBoolean)
  {
    super.setFitsSystemWindows(paramBoolean);
    setupForInsets();
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    this.mOnHierarchyChangeListener = paramOnHierarchyChangeListener;
  }
  
  public void setStatusBarBackground(@Nullable Drawable paramDrawable)
  {
    Drawable localDrawable2 = this.mStatusBarBackground;
    if (localDrawable2 != paramDrawable)
    {
      Drawable localDrawable1 = null;
      if (localDrawable2 != null) {
        localDrawable2.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable1 = paramDrawable.mutate();
      }
      this.mStatusBarBackground = localDrawable1;
      paramDrawable = this.mStatusBarBackground;
      if (paramDrawable != null)
      {
        if (paramDrawable.isStateful()) {
          this.mStatusBarBackground.setState(getDrawableState());
        }
        DrawableCompat.setLayoutDirection(this.mStatusBarBackground, ViewCompat.getLayoutDirection(this));
        paramDrawable = this.mStatusBarBackground;
        boolean bool;
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramDrawable.setVisible(bool, false);
        this.mStatusBarBackground.setCallback(this);
      }
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void setStatusBarBackgroundColor(@ColorInt int paramInt)
  {
    setStatusBarBackground(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarBackgroundResource(@DrawableRes int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = ContextCompat.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setStatusBarBackground(localDrawable);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Drawable localDrawable = this.mStatusBarBackground;
    if ((localDrawable != null) && (localDrawable.isVisible() != bool)) {
      this.mStatusBarBackground.setVisible(bool, false);
    }
  }
  
  final WindowInsetsCompat setWindowInsets(WindowInsetsCompat paramWindowInsetsCompat)
  {
    WindowInsetsCompat localWindowInsetsCompat = paramWindowInsetsCompat;
    if (!ObjectsCompat.equals(this.mLastInsets, paramWindowInsetsCompat))
    {
      this.mLastInsets = paramWindowInsetsCompat;
      boolean bool2 = true;
      boolean bool1;
      if ((paramWindowInsetsCompat != null) && (paramWindowInsetsCompat.getSystemWindowInsetTop() > 0)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.mDrawStatusBarBackground = bool1;
      if ((!this.mDrawStatusBarBackground) && (getBackground() == null)) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      setWillNotDraw(bool1);
      localWindowInsetsCompat = dispatchApplyWindowInsetsToBehaviors(paramWindowInsetsCompat);
      requestLayout();
    }
    return localWindowInsetsCompat;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.mStatusBarBackground);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.coordinatorlayout.widget.CoordinatorLayout
 * JD-Core Version:    0.7.0.1
 */