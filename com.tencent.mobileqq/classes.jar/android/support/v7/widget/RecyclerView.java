package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.os.TraceCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class RecyclerView
  extends ViewGroup
  implements NestedScrollingChild, ScrollingView
{
  private static final boolean DEBUG = false;
  private static final boolean DISPATCH_TEMP_DETACH = false;
  private static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
  public static final int HORIZONTAL = 0;
  private static final int INVALID_POINTER = -1;
  public static final int INVALID_TYPE = -1;
  private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = { Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE };
  private static final int MAX_SCROLL_DURATION = 2000;
  public static final long NO_ID = -1L;
  public static final int NO_POSITION = -1;
  public static final int SCROLL_STATE_DRAGGING = 1;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_SETTLING = 2;
  private static final String TAG = "RecyclerView";
  public static final int TOUCH_SLOP_DEFAULT = 0;
  public static final int TOUCH_SLOP_PAGING = 1;
  private static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
  private static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
  private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
  private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
  private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
  private static final String TRACE_SCROLL_TAG = "RV Scroll";
  public static final int VERTICAL = 1;
  private static final Interpolator sQuinticInterpolator = new RecyclerView.3();
  private RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
  private final AccessibilityManager mAccessibilityManager;
  private RecyclerView.OnItemTouchListener mActiveOnItemTouchListener;
  private RecyclerView.Adapter mAdapter;
  AdapterHelper mAdapterHelper;
  private boolean mAdapterUpdateDuringMeasure;
  private EdgeEffectCompat mBottomGlow;
  private RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback;
  ChildHelper mChildHelper;
  private boolean mClipToPadding;
  private boolean mDataSetHasChangedAfterLayout;
  private int mEatRequestLayout;
  private int mEatenAccessibilityChangeFlags;
  private boolean mFirstLayoutComplete;
  private boolean mHasFixedSize;
  private boolean mIgnoreMotionEventTillDown;
  private int mInitialTouchX;
  private int mInitialTouchY;
  private boolean mIsAttached;
  RecyclerView.ItemAnimator mItemAnimator;
  private RecyclerView.ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
  private Runnable mItemAnimatorRunner;
  private final ArrayList<RecyclerView.ItemDecoration> mItemDecorations = new ArrayList();
  boolean mItemsAddedOrRemoved;
  boolean mItemsChanged;
  private int mLastTouchX;
  private int mLastTouchY;
  @VisibleForTesting
  RecyclerView.LayoutManager mLayout;
  private boolean mLayoutFrozen;
  private int mLayoutOrScrollCounter;
  private boolean mLayoutRequestEaten;
  private EdgeEffectCompat mLeftGlow;
  private final int mMaxFlingVelocity;
  private final int mMinFlingVelocity;
  private final int[] mMinMaxLayoutPositions;
  private final int[] mNestedOffsets;
  private final RecyclerView.RecyclerViewDataObserver mObserver = new RecyclerView.RecyclerViewDataObserver(this, null);
  private List<RecyclerView.OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
  private final ArrayList<RecyclerView.OnItemTouchListener> mOnItemTouchListeners = new ArrayList();
  private RecyclerView.SavedState mPendingSavedState;
  private final boolean mPostUpdatesOnAnimation;
  private boolean mPostedAnimatorRunner;
  final RecyclerView.Recycler mRecycler = new RecyclerView.Recycler(this);
  private RecyclerView.RecyclerListener mRecyclerListener;
  private EdgeEffectCompat mRightGlow;
  private final int[] mScrollConsumed;
  private float mScrollFactor;
  private RecyclerView.OnScrollListener mScrollListener;
  private List<RecyclerView.OnScrollListener> mScrollListeners;
  private final int[] mScrollOffset;
  private int mScrollPointerId;
  private int mScrollState;
  private final NestedScrollingChildHelper mScrollingChildHelper;
  final RecyclerView.State mState;
  private final Rect mTempRect = new Rect();
  private EdgeEffectCompat mTopGlow;
  private int mTouchSlop;
  private final Runnable mUpdateChildViewsRunnable = new RecyclerView.1(this);
  private VelocityTracker mVelocityTracker;
  private final RecyclerView.ViewFlinger mViewFlinger;
  private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
  final ViewInfoStore mViewInfoStore = new ViewInfoStore();
  
  static
  {
    boolean bool;
    if ((Build.VERSION.SDK_INT != 18) && (Build.VERSION.SDK_INT != 19) && (Build.VERSION.SDK_INT != 20)) {
      bool = false;
    } else {
      bool = true;
    }
    FORCE_INVALIDATE_DISPLAY_LIST = bool;
  }
  
  public RecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool2 = false;
    this.mEatRequestLayout = 0;
    this.mDataSetHasChangedAfterLayout = false;
    this.mLayoutOrScrollCounter = 0;
    this.mItemAnimator = new DefaultItemAnimator();
    this.mScrollState = 0;
    this.mScrollPointerId = -1;
    this.mScrollFactor = 1.4E-45F;
    this.mViewFlinger = new RecyclerView.ViewFlinger(this);
    this.mState = new RecyclerView.State();
    this.mItemsAddedOrRemoved = false;
    this.mItemsChanged = false;
    this.mItemAnimatorListener = new RecyclerView.ItemAnimatorRestoreListener(this, null);
    this.mPostedAnimatorRunner = false;
    this.mMinMaxLayoutPositions = new int[2];
    this.mScrollOffset = new int[2];
    this.mScrollConsumed = new int[2];
    this.mNestedOffsets = new int[2];
    this.mItemAnimatorRunner = new RecyclerView.2(this);
    this.mViewInfoProcessCallback = new RecyclerView.4(this);
    setScrollContainer(true);
    setFocusableInTouchMode(true);
    if (Build.VERSION.SDK_INT >= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mPostUpdatesOnAnimation = bool1;
    paramContext = ViewConfiguration.get(paramContext);
    this.mTouchSlop = paramContext.getScaledTouchSlop();
    this.mMinFlingVelocity = paramContext.getScaledMinimumFlingVelocity();
    this.mMaxFlingVelocity = paramContext.getScaledMaximumFlingVelocity();
    boolean bool1 = bool2;
    if (ViewCompat.getOverScrollMode(this) == 2) {
      bool1 = true;
    }
    setWillNotDraw(bool1);
    this.mItemAnimator.setListener(this.mItemAnimatorListener);
    initAdapterManager();
    initChildrenHelper();
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
    this.mAccessibilityManager = ((AccessibilityManager)getContext().getSystemService("accessibility"));
    setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
    this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
    setNestedScrollingEnabled(true);
  }
  
  private void addAnimatingView(RecyclerView.ViewHolder paramViewHolder)
  {
    View localView = paramViewHolder.itemView;
    int i;
    if (localView.getParent() == this) {
      i = 1;
    } else {
      i = 0;
    }
    this.mRecycler.unscrapView(getChildViewHolder(localView));
    if (paramViewHolder.isTmpDetached())
    {
      this.mChildHelper.attachViewToParent(localView, -1, localView.getLayoutParams(), true);
      return;
    }
    if (i == 0)
    {
      this.mChildHelper.addView(localView, true);
      return;
    }
    this.mChildHelper.hide(localView);
  }
  
  private void animateAppearance(@NonNull RecyclerView.ViewHolder paramViewHolder, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    paramViewHolder.setIsRecyclable(false);
    if (this.mItemAnimator.animateAppearance(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2)) {
      postAnimationRunner();
    }
  }
  
  private void animateChange(@NonNull RecyclerView.ViewHolder paramViewHolder1, @NonNull RecyclerView.ViewHolder paramViewHolder2, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramViewHolder1.setIsRecyclable(false);
    if (paramBoolean1) {
      addAnimatingView(paramViewHolder1);
    }
    if (paramViewHolder1 != paramViewHolder2)
    {
      if (paramBoolean2) {
        addAnimatingView(paramViewHolder2);
      }
      paramViewHolder1.mShadowedHolder = paramViewHolder2;
      addAnimatingView(paramViewHolder1);
      this.mRecycler.unscrapView(paramViewHolder1);
      paramViewHolder2.setIsRecyclable(false);
      paramViewHolder2.mShadowingHolder = paramViewHolder1;
    }
    if (this.mItemAnimator.animateChange(paramViewHolder1, paramViewHolder2, paramItemHolderInfo1, paramItemHolderInfo2)) {
      postAnimationRunner();
    }
  }
  
  private void animateDisappearance(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    addAnimatingView(paramViewHolder);
    paramViewHolder.setIsRecyclable(false);
    if (this.mItemAnimator.animateDisappearance(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2)) {
      postAnimationRunner();
    }
  }
  
  private boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder paramViewHolder)
  {
    RecyclerView.ItemAnimator localItemAnimator = this.mItemAnimator;
    return (localItemAnimator == null) || (localItemAnimator.canReuseUpdatedViewHolder(paramViewHolder, paramViewHolder.getUnmodifiedPayloads()));
  }
  
  private void cancelTouch()
  {
    resetTouch();
    setScrollState(0);
  }
  
  private void considerReleasingGlowsOnScroll(int paramInt1, int paramInt2)
  {
    EdgeEffectCompat localEdgeEffectCompat = this.mLeftGlow;
    if ((localEdgeEffectCompat != null) && (!localEdgeEffectCompat.isFinished()) && (paramInt1 > 0)) {
      bool2 = this.mLeftGlow.onRelease();
    } else {
      bool2 = false;
    }
    localEdgeEffectCompat = this.mRightGlow;
    boolean bool1 = bool2;
    if (localEdgeEffectCompat != null)
    {
      bool1 = bool2;
      if (!localEdgeEffectCompat.isFinished())
      {
        bool1 = bool2;
        if (paramInt1 < 0) {
          bool1 = bool2 | this.mRightGlow.onRelease();
        }
      }
    }
    localEdgeEffectCompat = this.mTopGlow;
    boolean bool2 = bool1;
    if (localEdgeEffectCompat != null)
    {
      bool2 = bool1;
      if (!localEdgeEffectCompat.isFinished())
      {
        bool2 = bool1;
        if (paramInt2 > 0) {
          bool2 = bool1 | this.mTopGlow.onRelease();
        }
      }
    }
    localEdgeEffectCompat = this.mBottomGlow;
    bool1 = bool2;
    if (localEdgeEffectCompat != null)
    {
      bool1 = bool2;
      if (!localEdgeEffectCompat.isFinished())
      {
        bool1 = bool2;
        if (paramInt2 < 0) {
          bool1 = bool2 | this.mBottomGlow.onRelease();
        }
      }
    }
    if (bool1) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private void consumePendingUpdateOperations()
  {
    if (!this.mFirstLayoutComplete) {
      return;
    }
    if (this.mDataSetHasChangedAfterLayout)
    {
      TraceCompat.beginSection("RV FullInvalidate");
      dispatchLayout();
      TraceCompat.endSection();
      return;
    }
    if (!this.mAdapterHelper.hasPendingUpdates()) {
      return;
    }
    if ((this.mAdapterHelper.hasAnyUpdateTypes(4)) && (!this.mAdapterHelper.hasAnyUpdateTypes(11)))
    {
      TraceCompat.beginSection("RV PartialInvalidate");
      eatRequestLayout();
      this.mAdapterHelper.preProcess();
      if (!this.mLayoutRequestEaten) {
        if (hasUpdatedView()) {
          dispatchLayout();
        } else {
          this.mAdapterHelper.consumePostponedUpdates();
        }
      }
      resumeRequestLayout(true);
      TraceCompat.endSection();
      return;
    }
    if (this.mAdapterHelper.hasPendingUpdates())
    {
      TraceCompat.beginSection("RV FullInvalidate");
      dispatchLayout();
      TraceCompat.endSection();
    }
  }
  
  private void createLayoutManager(Context paramContext, String paramString, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      paramString = paramString.trim();
      if (paramString.length() != 0)
      {
        String str = getFullClassName(paramContext, paramString);
        try
        {
          if (isInEditMode()) {
            paramString = getClass().getClassLoader();
          } else {
            paramString = paramContext.getClassLoader();
          }
          Class localClass = paramString.loadClass(str).asSubclass(RecyclerView.LayoutManager.class);
          Object localObject = null;
          try
          {
            paramString = localClass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
            paramContext = new Object[] { paramContext, paramAttributeSet, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) };
          }
          catch (NoSuchMethodException paramContext) {}
          try
          {
            paramString = localClass.getConstructor(new Class[0]);
            paramContext = localObject;
            paramString.setAccessible(true);
            setLayoutManager((RecyclerView.LayoutManager)paramString.newInstance(paramContext));
            return;
          }
          catch (NoSuchMethodException paramString)
          {
            paramString.initCause(paramContext);
            paramContext = new StringBuilder();
            paramContext.append(paramAttributeSet.getPositionDescription());
            paramContext.append(": Error creating LayoutManager ");
            paramContext.append(str);
            throw new IllegalStateException(paramContext.toString(), paramString);
          }
          return;
        }
        catch (ClassCastException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(paramAttributeSet.getPositionDescription());
          paramString.append(": Class is not a LayoutManager ");
          paramString.append(str);
          throw new IllegalStateException(paramString.toString(), paramContext);
        }
        catch (IllegalAccessException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(paramAttributeSet.getPositionDescription());
          paramString.append(": Cannot access non-public constructor ");
          paramString.append(str);
          throw new IllegalStateException(paramString.toString(), paramContext);
        }
        catch (InstantiationException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(paramAttributeSet.getPositionDescription());
          paramString.append(": Could not instantiate the LayoutManager: ");
          paramString.append(str);
          throw new IllegalStateException(paramString.toString(), paramContext);
        }
        catch (InvocationTargetException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(paramAttributeSet.getPositionDescription());
          paramString.append(": Could not instantiate the LayoutManager: ");
          paramString.append(str);
          throw new IllegalStateException(paramString.toString(), paramContext);
        }
        catch (ClassNotFoundException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(paramAttributeSet.getPositionDescription());
          paramString.append(": Unable to find LayoutManager ");
          paramString.append(str);
          throw new IllegalStateException(paramString.toString(), paramContext);
        }
      }
    }
  }
  
  private void defaultOnMeasure(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    paramInt1 = j;
    if (m != -2147483648)
    {
      paramInt1 = j;
      if (m != 1073741824) {
        paramInt1 = ViewCompat.getMinimumWidth(this);
      }
    }
    paramInt2 = i;
    if (k != -2147483648)
    {
      paramInt2 = i;
      if (k != 1073741824) {
        paramInt2 = ViewCompat.getMinimumHeight(this);
      }
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  private boolean didChildRangeChange(int paramInt1, int paramInt2)
  {
    int j = this.mChildHelper.getChildCount();
    boolean bool = true;
    if (j == 0)
    {
      if (paramInt1 == 0)
      {
        if (paramInt2 != 0) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore()))
      {
        int k = localViewHolder.getLayoutPosition();
        if ((k < paramInt1) || (k > paramInt2)) {
          return true;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private void dispatchChildAttached(View paramView)
  {
    Object localObject = getChildViewHolderInt(paramView);
    onChildAttachedToWindow(paramView);
    RecyclerView.Adapter localAdapter = this.mAdapter;
    if ((localAdapter != null) && (localObject != null)) {
      localAdapter.onViewAttachedToWindow((RecyclerView.ViewHolder)localObject);
    }
    localObject = this.mOnChildAttachStateListeners;
    if (localObject != null)
    {
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.OnChildAttachStateChangeListener)this.mOnChildAttachStateListeners.get(i)).onChildViewAttachedToWindow(paramView);
        i -= 1;
      }
    }
  }
  
  private void dispatchChildDetached(View paramView)
  {
    Object localObject = getChildViewHolderInt(paramView);
    onChildDetachedFromWindow(paramView);
    RecyclerView.Adapter localAdapter = this.mAdapter;
    if ((localAdapter != null) && (localObject != null)) {
      localAdapter.onViewDetachedFromWindow((RecyclerView.ViewHolder)localObject);
    }
    localObject = this.mOnChildAttachStateListeners;
    if (localObject != null)
    {
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.OnChildAttachStateChangeListener)this.mOnChildAttachStateListeners.get(i)).onChildViewDetachedFromWindow(paramView);
        i -= 1;
      }
    }
  }
  
  private void dispatchContentChangedIfNecessary()
  {
    int i = this.mEatenAccessibilityChangeFlags;
    this.mEatenAccessibilityChangeFlags = 0;
    if ((i != 0) && (isAccessibilityEnabled()))
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
      localAccessibilityEvent.setEventType(2048);
      AccessibilityEventCompat.setContentChangeTypes(localAccessibilityEvent, i);
      sendAccessibilityEventUnchecked(localAccessibilityEvent);
    }
  }
  
  private void dispatchLayoutStep1()
  {
    Object localObject = this.mState;
    boolean bool = true;
    ((RecyclerView.State)localObject).assertLayoutStep(1);
    RecyclerView.State.access$2202(this.mState, false);
    eatRequestLayout();
    this.mViewInfoStore.clear();
    onEnterLayoutOrScroll();
    processAdapterUpdatesAndSetAnimationFlags();
    localObject = this.mState;
    if ((!RecyclerView.State.access$2500((RecyclerView.State)localObject)) || (!this.mItemsChanged)) {
      bool = false;
    }
    RecyclerView.State.access$2702((RecyclerView.State)localObject, bool);
    this.mItemsChanged = false;
    this.mItemsAddedOrRemoved = false;
    localObject = this.mState;
    RecyclerView.State.access$2402((RecyclerView.State)localObject, RecyclerView.State.access$2300((RecyclerView.State)localObject));
    this.mState.mItemCount = this.mAdapter.getItemCount();
    findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
    int j;
    int i;
    RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo;
    if (RecyclerView.State.access$2500(this.mState))
    {
      j = this.mChildHelper.getChildCount();
      i = 0;
      while (i < j)
      {
        localObject = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
        if ((localObject != null) && (!((RecyclerView.ViewHolder)localObject).shouldIgnore()) && ((!((RecyclerView.ViewHolder)localObject).isInvalid()) || (this.mAdapter.hasStableIds())))
        {
          localItemHolderInfo = this.mItemAnimator.recordPreLayoutInformation(this.mState, (RecyclerView.ViewHolder)localObject, RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations((RecyclerView.ViewHolder)localObject), ((RecyclerView.ViewHolder)localObject).getUnmodifiedPayloads());
          this.mViewInfoStore.addToPreLayout((RecyclerView.ViewHolder)localObject, localItemHolderInfo);
          if ((RecyclerView.State.access$2700(this.mState)) && (((RecyclerView.ViewHolder)localObject).isUpdated()) && (!((RecyclerView.ViewHolder)localObject).isRemoved()) && (!((RecyclerView.ViewHolder)localObject).shouldIgnore()) && (!((RecyclerView.ViewHolder)localObject).isInvalid()))
          {
            long l = getChangedHolderKey((RecyclerView.ViewHolder)localObject);
            this.mViewInfoStore.addToOldChangeHolders(l, (RecyclerView.ViewHolder)localObject);
          }
        }
        i += 1;
      }
    }
    if (RecyclerView.State.access$2300(this.mState))
    {
      saveOldPositions();
      bool = RecyclerView.State.access$1800(this.mState);
      RecyclerView.State.access$1802(this.mState, false);
      this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
      RecyclerView.State.access$1802(this.mState, bool);
      i = 0;
      while (i < this.mChildHelper.getChildCount())
      {
        localObject = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
        if ((localObject != null) && (!((RecyclerView.ViewHolder)localObject).shouldIgnore()) && (!this.mViewInfoStore.isInPreLayout((RecyclerView.ViewHolder)localObject)))
        {
          int k = RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations((RecyclerView.ViewHolder)localObject);
          bool = ((RecyclerView.ViewHolder)localObject).hasAnyOfTheFlags(8192);
          j = k;
          if (!bool) {
            j = k | 0x1000;
          }
          localItemHolderInfo = this.mItemAnimator.recordPreLayoutInformation(this.mState, (RecyclerView.ViewHolder)localObject, j, ((RecyclerView.ViewHolder)localObject).getUnmodifiedPayloads());
          if (bool) {
            recordAnimationInfoIfBouncedHiddenView((RecyclerView.ViewHolder)localObject, localItemHolderInfo);
          } else {
            this.mViewInfoStore.addToAppearedInPreLayoutHolders((RecyclerView.ViewHolder)localObject, localItemHolderInfo);
          }
        }
        i += 1;
      }
      clearOldPositions();
    }
    else
    {
      clearOldPositions();
    }
    onExitLayoutOrScroll();
    resumeRequestLayout(false);
    RecyclerView.State.access$2102(this.mState, 2);
  }
  
  private void dispatchLayoutStep2()
  {
    eatRequestLayout();
    onEnterLayoutOrScroll();
    this.mState.assertLayoutStep(6);
    this.mAdapterHelper.consumeUpdatesInOnePass();
    this.mState.mItemCount = this.mAdapter.getItemCount();
    RecyclerView.State.access$1702(this.mState, 0);
    RecyclerView.State.access$2402(this.mState, false);
    this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
    RecyclerView.State.access$1802(this.mState, false);
    this.mPendingSavedState = null;
    RecyclerView.State localState = this.mState;
    boolean bool;
    if ((RecyclerView.State.access$2500(localState)) && (this.mItemAnimator != null)) {
      bool = true;
    } else {
      bool = false;
    }
    RecyclerView.State.access$2502(localState, bool);
    RecyclerView.State.access$2102(this.mState, 4);
    onExitLayoutOrScroll();
    resumeRequestLayout(false);
  }
  
  private void dispatchLayoutStep3()
  {
    this.mState.assertLayoutStep(4);
    eatRequestLayout();
    RecyclerView.State.access$2102(this.mState, 1);
    if (RecyclerView.State.access$2500(this.mState))
    {
      int j = this.mChildHelper.getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
        if ((localObject != null) && (!((RecyclerView.ViewHolder)localObject).shouldIgnore()))
        {
          long l = getChangedHolderKey((RecyclerView.ViewHolder)localObject);
          RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo2 = this.mItemAnimator.recordPostLayoutInformation(this.mState, (RecyclerView.ViewHolder)localObject);
          RecyclerView.ViewHolder localViewHolder = this.mViewInfoStore.getFromOldChangeHolders(l);
          if ((localViewHolder != null) && (!localViewHolder.shouldIgnore()))
          {
            boolean bool1 = this.mViewInfoStore.isDisappearing(localViewHolder);
            boolean bool2 = this.mViewInfoStore.isDisappearing((RecyclerView.ViewHolder)localObject);
            RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo1 = this.mViewInfoStore.popFromPreLayout(localViewHolder);
            this.mViewInfoStore.addToPostLayout((RecyclerView.ViewHolder)localObject, localItemHolderInfo2);
            localItemHolderInfo2 = this.mViewInfoStore.popFromPostLayout((RecyclerView.ViewHolder)localObject);
            if (localItemHolderInfo1 == null) {
              handleMissingPreInfoForChangeError(l, (RecyclerView.ViewHolder)localObject, localViewHolder);
            } else {
              animateChange(localViewHolder, (RecyclerView.ViewHolder)localObject, localItemHolderInfo1, localItemHolderInfo2, bool1, bool2);
            }
          }
          else
          {
            this.mViewInfoStore.addToPostLayout((RecyclerView.ViewHolder)localObject, localItemHolderInfo2);
          }
        }
        i += 1;
      }
      this.mViewInfoStore.process(this.mViewInfoProcessCallback);
    }
    this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
    Object localObject = this.mState;
    RecyclerView.State.access$2802((RecyclerView.State)localObject, ((RecyclerView.State)localObject).mItemCount);
    this.mDataSetHasChangedAfterLayout = false;
    RecyclerView.State.access$2502(this.mState, false);
    RecyclerView.State.access$2302(this.mState, false);
    RecyclerView.LayoutManager.access$2602(this.mLayout, false);
    if (RecyclerView.Recycler.access$2900(this.mRecycler) != null) {
      RecyclerView.Recycler.access$2900(this.mRecycler).clear();
    }
    resumeRequestLayout(false);
    this.mViewInfoStore.clear();
    localObject = this.mMinMaxLayoutPositions;
    if (didChildRangeChange(localObject[0], localObject[1])) {
      dispatchOnScrolled(0, 0);
    }
  }
  
  private boolean dispatchOnItemTouch(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    RecyclerView.OnItemTouchListener localOnItemTouchListener = this.mActiveOnItemTouchListener;
    if (localOnItemTouchListener != null) {
      if (i == 0)
      {
        this.mActiveOnItemTouchListener = null;
      }
      else
      {
        localOnItemTouchListener.onTouchEvent(this, paramMotionEvent);
        if ((i == 3) || (i == 1)) {
          this.mActiveOnItemTouchListener = null;
        }
        return true;
      }
    }
    if (i != 0)
    {
      int j = this.mOnItemTouchListeners.size();
      i = 0;
      while (i < j)
      {
        localOnItemTouchListener = (RecyclerView.OnItemTouchListener)this.mOnItemTouchListeners.get(i);
        if (localOnItemTouchListener.onInterceptTouchEvent(this, paramMotionEvent))
        {
          this.mActiveOnItemTouchListener = localOnItemTouchListener;
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private boolean dispatchOnItemTouchIntercept(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction();
    if ((j == 3) || (j == 0)) {
      this.mActiveOnItemTouchListener = null;
    }
    int k = this.mOnItemTouchListeners.size();
    int i = 0;
    while (i < k)
    {
      RecyclerView.OnItemTouchListener localOnItemTouchListener = (RecyclerView.OnItemTouchListener)this.mOnItemTouchListeners.get(i);
      if ((localOnItemTouchListener.onInterceptTouchEvent(this, paramMotionEvent)) && (j != 3))
      {
        this.mActiveOnItemTouchListener = localOnItemTouchListener;
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void findMinMaxChildLayoutPositions(int[] paramArrayOfInt)
  {
    int i3 = this.mChildHelper.getChildCount();
    if (i3 == 0)
    {
      paramArrayOfInt[0] = 0;
      paramArrayOfInt[1] = 0;
      return;
    }
    int m = 0;
    int i = 2147483647;
    int i2;
    for (int k = -2147483648; m < i3; k = i2)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getChildAt(m));
      int i1 = i;
      i2 = k;
      if (localViewHolder != null) {
        if (localViewHolder.shouldIgnore())
        {
          i1 = i;
          i2 = k;
        }
        else
        {
          int n = localViewHolder.getLayoutPosition();
          int j = i;
          if (n < i) {
            j = n;
          }
          i1 = j;
          i2 = k;
          if (n > k)
          {
            i2 = n;
            i1 = j;
          }
        }
      }
      m += 1;
      i = i1;
    }
    paramArrayOfInt[0] = i;
    paramArrayOfInt[1] = k;
  }
  
  private int getAdapterPositionFor(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((!paramViewHolder.hasAnyOfTheFlags(524)) && (paramViewHolder.isBound())) {
      return this.mAdapterHelper.applyPendingUpdatesToPosition(paramViewHolder.mPosition);
    }
    return -1;
  }
  
  static RecyclerView.ViewHolder getChildViewHolderInt(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mViewHolder;
  }
  
  private String getFullClassName(Context paramContext, String paramString)
  {
    if (paramString.charAt(0) == '.')
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getPackageName());
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    if (paramString.contains(".")) {
      return paramString;
    }
    paramContext = new StringBuilder();
    paramContext.append(RecyclerView.class.getPackage().getName());
    paramContext.append('.');
    paramContext.append(paramString);
    return paramContext.toString();
  }
  
  private float getScrollFactor()
  {
    if (this.mScrollFactor == 1.4E-45F)
    {
      TypedValue localTypedValue = new TypedValue();
      if (getContext().getTheme().resolveAttribute(16842829, localTypedValue, true)) {
        this.mScrollFactor = localTypedValue.getDimension(getContext().getResources().getDisplayMetrics());
      } else {
        return 0.0F;
      }
    }
    return this.mScrollFactor;
  }
  
  private void handleMissingPreInfoForChangeError(long paramLong, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    int j = this.mChildHelper.getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
      if ((localObject != null) && (localObject != paramViewHolder1) && (getChangedHolderKey((RecyclerView.ViewHolder)localObject) == paramLong))
      {
        paramViewHolder2 = this.mAdapter;
        if ((paramViewHolder2 != null) && (paramViewHolder2.hasStableIds()))
        {
          paramViewHolder2 = new StringBuilder();
          paramViewHolder2.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
          paramViewHolder2.append(localObject);
          paramViewHolder2.append(" \n View Holder 2:");
          paramViewHolder2.append(paramViewHolder1);
          throw new IllegalStateException(paramViewHolder2.toString());
        }
        paramViewHolder2 = new StringBuilder();
        paramViewHolder2.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
        paramViewHolder2.append(localObject);
        paramViewHolder2.append(" \n View Holder 2:");
        paramViewHolder2.append(paramViewHolder1);
        throw new IllegalStateException(paramViewHolder2.toString());
      }
      i += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
    ((StringBuilder)localObject).append(paramViewHolder2);
    ((StringBuilder)localObject).append(" cannot be found but it is necessary for ");
    ((StringBuilder)localObject).append(paramViewHolder1);
    Log.e("RecyclerView", ((StringBuilder)localObject).toString());
  }
  
  private boolean hasUpdatedView()
  {
    int j = this.mChildHelper.getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore()) && (localViewHolder.isUpdated())) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void initChildrenHelper()
  {
    this.mChildHelper = new ChildHelper(new RecyclerView.5(this));
  }
  
  private void jumpToPositionForSmoothScroller(int paramInt)
  {
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager == null) {
      return;
    }
    localLayoutManager.scrollToPosition(paramInt);
    awakenScrollBars();
  }
  
  private void onEnterLayoutOrScroll()
  {
    this.mLayoutOrScrollCounter += 1;
  }
  
  private void onExitLayoutOrScroll()
  {
    this.mLayoutOrScrollCounter -= 1;
    if (this.mLayoutOrScrollCounter < 1)
    {
      this.mLayoutOrScrollCounter = 0;
      dispatchContentChangedIfNecessary();
    }
  }
  
  private void onPointerUp(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i) == this.mScrollPointerId)
    {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      this.mScrollPointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
      int j = (int)(MotionEventCompat.getX(paramMotionEvent, i) + 0.5F);
      this.mLastTouchX = j;
      this.mInitialTouchX = j;
      i = (int)(MotionEventCompat.getY(paramMotionEvent, i) + 0.5F);
      this.mLastTouchY = i;
      this.mInitialTouchY = i;
    }
  }
  
  private void postAnimationRunner()
  {
    if ((!this.mPostedAnimatorRunner) && (this.mIsAttached))
    {
      ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
      this.mPostedAnimatorRunner = true;
    }
  }
  
  private boolean predictiveItemAnimationsEnabled()
  {
    return (this.mItemAnimator != null) && (this.mLayout.supportsPredictiveItemAnimations());
  }
  
  private void processAdapterUpdatesAndSetAnimationFlags()
  {
    if (this.mDataSetHasChangedAfterLayout)
    {
      this.mAdapterHelper.reset();
      markKnownViewsInvalid();
      this.mLayout.onItemsChanged(this);
    }
    if (predictiveItemAnimationsEnabled()) {
      this.mAdapterHelper.preProcess();
    } else {
      this.mAdapterHelper.consumeUpdatesInOnePass();
    }
    boolean bool1 = this.mItemsAddedOrRemoved;
    boolean bool2 = false;
    int i;
    if ((!bool1) && (!this.mItemsChanged)) {
      i = 0;
    } else {
      i = 1;
    }
    RecyclerView.State localState = this.mState;
    if ((this.mFirstLayoutComplete) && (this.mItemAnimator != null) && ((this.mDataSetHasChangedAfterLayout) || (i != 0) || (RecyclerView.LayoutManager.access$2600(this.mLayout))) && ((!this.mDataSetHasChangedAfterLayout) || (this.mAdapter.hasStableIds()))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    RecyclerView.State.access$2502(localState, bool1);
    localState = this.mState;
    bool1 = bool2;
    if (RecyclerView.State.access$2500(localState))
    {
      bool1 = bool2;
      if (i != 0)
      {
        bool1 = bool2;
        if (!this.mDataSetHasChangedAfterLayout)
        {
          bool1 = bool2;
          if (predictiveItemAnimationsEnabled()) {
            bool1 = true;
          }
        }
      }
    }
    RecyclerView.State.access$2302(localState, bool1);
  }
  
  private void pullGlows(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int j = 1;
    if (paramFloat2 < 0.0F)
    {
      ensureLeftGlow();
      if (!this.mLeftGlow.onPull(-paramFloat2 / getWidth(), 1.0F - paramFloat3 / getHeight())) {}
    }
    else
    {
      do
      {
        i = 1;
        break label86;
        if (paramFloat2 <= 0.0F) {
          break;
        }
        ensureRightGlow();
      } while (this.mRightGlow.onPull(paramFloat2 / getWidth(), paramFloat3 / getHeight()));
    }
    int i = 0;
    label86:
    if (paramFloat4 < 0.0F)
    {
      ensureTopGlow();
      if (this.mTopGlow.onPull(-paramFloat4 / getHeight(), paramFloat1 / getWidth())) {
        i = j;
      }
    }
    else if (paramFloat4 > 0.0F)
    {
      ensureBottomGlow();
      if (this.mBottomGlow.onPull(paramFloat4 / getHeight(), 1.0F - paramFloat1 / getWidth())) {
        i = j;
      }
    }
    if ((i != 0) || (paramFloat2 != 0.0F) || (paramFloat4 != 0.0F)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private void recordAnimationInfoIfBouncedHiddenView(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    paramViewHolder.setFlags(0, 8192);
    if ((RecyclerView.State.access$2700(this.mState)) && (paramViewHolder.isUpdated()) && (!paramViewHolder.isRemoved()) && (!paramViewHolder.shouldIgnore()))
    {
      long l = getChangedHolderKey(paramViewHolder);
      this.mViewInfoStore.addToOldChangeHolders(l, paramViewHolder);
    }
    this.mViewInfoStore.addToPreLayout(paramViewHolder, paramItemHolderInfo);
  }
  
  private void releaseGlows()
  {
    EdgeEffectCompat localEdgeEffectCompat = this.mLeftGlow;
    if (localEdgeEffectCompat != null) {
      bool2 = localEdgeEffectCompat.onRelease();
    } else {
      bool2 = false;
    }
    localEdgeEffectCompat = this.mTopGlow;
    boolean bool1 = bool2;
    if (localEdgeEffectCompat != null) {
      bool1 = bool2 | localEdgeEffectCompat.onRelease();
    }
    localEdgeEffectCompat = this.mRightGlow;
    boolean bool2 = bool1;
    if (localEdgeEffectCompat != null) {
      bool2 = bool1 | localEdgeEffectCompat.onRelease();
    }
    localEdgeEffectCompat = this.mBottomGlow;
    bool1 = bool2;
    if (localEdgeEffectCompat != null) {
      bool1 = bool2 | localEdgeEffectCompat.onRelease();
    }
    if (bool1) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private boolean removeAnimatingView(View paramView)
  {
    eatRequestLayout();
    boolean bool = this.mChildHelper.removeViewIfHidden(paramView);
    if (bool)
    {
      paramView = getChildViewHolderInt(paramView);
      if (paramView != null)
      {
        this.mRecycler.unscrapView(paramView);
        this.mRecycler.recycleViewHolderInternal(paramView);
      }
    }
    resumeRequestLayout(bool ^ true);
    return bool;
  }
  
  private void repositionShadowingViews()
  {
    int j = this.mChildHelper.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.mChildHelper.getChildAt(i);
      Object localObject = getChildViewHolder(localView);
      if ((localObject != null) && (((RecyclerView.ViewHolder)localObject).mShadowingHolder != null))
      {
        localObject = ((RecyclerView.ViewHolder)localObject).mShadowingHolder.itemView;
        int k = localView.getLeft();
        int m = localView.getTop();
        if ((k != ((View)localObject).getLeft()) || (m != ((View)localObject).getTop())) {
          ((View)localObject).layout(k, m, ((View)localObject).getWidth() + k, ((View)localObject).getHeight() + m);
        }
      }
      i += 1;
    }
  }
  
  private void resetTouch()
  {
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
    stopNestedScroll();
    releaseGlows();
  }
  
  private void setAdapterInternal(RecyclerView.Adapter paramAdapter, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.mAdapter;
    if (localObject != null)
    {
      ((RecyclerView.Adapter)localObject).unregisterAdapterDataObserver(this.mObserver);
      this.mAdapter.onDetachedFromRecyclerView(this);
    }
    if ((!paramBoolean1) || (paramBoolean2))
    {
      localObject = this.mItemAnimator;
      if (localObject != null) {
        ((RecyclerView.ItemAnimator)localObject).endAnimations();
      }
      localObject = this.mLayout;
      if (localObject != null)
      {
        ((RecyclerView.LayoutManager)localObject).removeAndRecycleAllViews(this.mRecycler);
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
      }
      this.mRecycler.clear();
    }
    this.mAdapterHelper.reset();
    localObject = this.mAdapter;
    this.mAdapter = paramAdapter;
    if (paramAdapter != null)
    {
      paramAdapter.registerAdapterDataObserver(this.mObserver);
      paramAdapter.onAttachedToRecyclerView(this);
    }
    paramAdapter = this.mLayout;
    if (paramAdapter != null) {
      paramAdapter.onAdapterChanged((RecyclerView.Adapter)localObject, this.mAdapter);
    }
    this.mRecycler.onAdapterChanged((RecyclerView.Adapter)localObject, this.mAdapter, paramBoolean1);
    RecyclerView.State.access$1802(this.mState, true);
    markKnownViewsInvalid();
  }
  
  private void setDataSetChangedAfterLayout()
  {
    if (this.mDataSetHasChangedAfterLayout) {
      return;
    }
    this.mDataSetHasChangedAfterLayout = true;
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore())) {
        localViewHolder.addFlags(512);
      }
      i += 1;
    }
    this.mRecycler.setAdapterPositionsAsUnknown();
  }
  
  private void setScrollState(int paramInt)
  {
    if (paramInt == this.mScrollState) {
      return;
    }
    this.mScrollState = paramInt;
    if (paramInt != 2) {
      stopScrollersInternal();
    }
    dispatchOnScrollStateChanged(paramInt);
  }
  
  private void stopScrollersInternal()
  {
    this.mViewFlinger.stop();
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      localLayoutManager.stopSmoothScroller();
    }
  }
  
  void absorbGlows(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      ensureLeftGlow();
      this.mLeftGlow.onAbsorb(-paramInt1);
    }
    else if (paramInt1 > 0)
    {
      ensureRightGlow();
      this.mRightGlow.onAbsorb(paramInt1);
    }
    if (paramInt2 < 0)
    {
      ensureTopGlow();
      this.mTopGlow.onAbsorb(-paramInt2);
    }
    else if (paramInt2 > 0)
    {
      ensureBottomGlow();
      this.mBottomGlow.onAbsorb(paramInt2);
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    if ((localLayoutManager == null) || (!localLayoutManager.onAddFocusables(this, paramArrayList, paramInt1, paramInt2))) {
      super.addFocusables(paramArrayList, paramInt1, paramInt2);
    }
  }
  
  public void addItemDecoration(RecyclerView.ItemDecoration paramItemDecoration)
  {
    addItemDecoration(paramItemDecoration, -1);
  }
  
  public void addItemDecoration(RecyclerView.ItemDecoration paramItemDecoration, int paramInt)
  {
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      localLayoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
    }
    if (this.mItemDecorations.isEmpty()) {
      setWillNotDraw(false);
    }
    if (paramInt < 0) {
      this.mItemDecorations.add(paramItemDecoration);
    } else {
      this.mItemDecorations.add(paramInt, paramItemDecoration);
    }
    markItemDecorInsetsDirty();
    requestLayout();
  }
  
  public void addOnChildAttachStateChangeListener(RecyclerView.OnChildAttachStateChangeListener paramOnChildAttachStateChangeListener)
  {
    if (this.mOnChildAttachStateListeners == null) {
      this.mOnChildAttachStateListeners = new ArrayList();
    }
    this.mOnChildAttachStateListeners.add(paramOnChildAttachStateChangeListener);
  }
  
  public void addOnItemTouchListener(RecyclerView.OnItemTouchListener paramOnItemTouchListener)
  {
    this.mOnItemTouchListeners.add(paramOnItemTouchListener);
  }
  
  public void addOnScrollListener(RecyclerView.OnScrollListener paramOnScrollListener)
  {
    if (this.mScrollListeners == null) {
      this.mScrollListeners = new ArrayList();
    }
    this.mScrollListeners.add(paramOnScrollListener);
  }
  
  void assertInLayoutOrScroll(String paramString)
  {
    if (!isComputingLayout())
    {
      if (paramString == null) {
        throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling");
      }
      throw new IllegalStateException(paramString);
    }
  }
  
  void assertNotInLayoutOrScroll(String paramString)
  {
    if (isComputingLayout())
    {
      if (paramString == null) {
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
      }
      throw new IllegalStateException(paramString);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof RecyclerView.LayoutParams)) && (this.mLayout.checkLayoutParams((RecyclerView.LayoutParams)paramLayoutParams));
  }
  
  void clearOldPositions()
  {
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore())) {
        localViewHolder.clearOldPosition();
      }
      i += 1;
    }
    this.mRecycler.clearOldPositions();
  }
  
  public void clearOnChildAttachStateChangeListeners()
  {
    List localList = this.mOnChildAttachStateListeners;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public void clearOnScrollListeners()
  {
    List localList = this.mScrollListeners;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public int computeHorizontalScrollExtent()
  {
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (localLayoutManager.canScrollHorizontally()) {
      i = this.mLayout.computeHorizontalScrollExtent(this.mState);
    }
    return i;
  }
  
  public int computeHorizontalScrollOffset()
  {
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (localLayoutManager.canScrollHorizontally()) {
      i = this.mLayout.computeHorizontalScrollOffset(this.mState);
    }
    return i;
  }
  
  public int computeHorizontalScrollRange()
  {
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (localLayoutManager.canScrollHorizontally()) {
      i = this.mLayout.computeHorizontalScrollRange(this.mState);
    }
    return i;
  }
  
  public int computeVerticalScrollExtent()
  {
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (localLayoutManager.canScrollVertically()) {
      i = this.mLayout.computeVerticalScrollExtent(this.mState);
    }
    return i;
  }
  
  public int computeVerticalScrollOffset()
  {
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (localLayoutManager.canScrollVertically()) {
      i = this.mLayout.computeVerticalScrollOffset(this.mState);
    }
    return i;
  }
  
  public int computeVerticalScrollRange()
  {
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (localLayoutManager.canScrollVertically()) {
      i = this.mLayout.computeVerticalScrollRange(this.mState);
    }
    return i;
  }
  
  void dispatchLayout()
  {
    if (this.mAdapter == null)
    {
      Log.e("RecyclerView", "No adapter attached; skipping layout");
      return;
    }
    if (this.mLayout == null)
    {
      Log.e("RecyclerView", "No layout manager attached; skipping layout");
      return;
    }
    RecyclerView.State.access$2202(this.mState, false);
    onEnterLayoutOrScroll();
    if (RecyclerView.State.access$2100(this.mState) == 1)
    {
      dispatchLayoutStep1();
      this.mLayout.setExactMeasureSpecsFrom(this);
      dispatchLayoutStep2();
    }
    else if ((!this.mAdapterHelper.hasUpdates()) && (this.mLayout.getWidth() == getWidth()) && (this.mLayout.getHeight() == getHeight()))
    {
      this.mLayout.setExactMeasureSpecsFrom(this);
    }
    else
    {
      this.mLayout.setExactMeasureSpecsFrom(this);
      dispatchLayoutStep2();
    }
    dispatchLayoutStep3();
    onExitLayoutOrScroll();
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.mScrollingChildHelper.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.mScrollingChildHelper.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.mScrollingChildHelper.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return this.mScrollingChildHelper.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  void dispatchOnScrollStateChanged(int paramInt)
  {
    Object localObject = this.mLayout;
    if (localObject != null) {
      ((RecyclerView.LayoutManager)localObject).onScrollStateChanged(paramInt);
    }
    onScrollStateChanged(paramInt);
    localObject = this.mScrollListener;
    if (localObject != null) {
      ((RecyclerView.OnScrollListener)localObject).onScrollStateChanged(this, paramInt);
    }
    localObject = this.mScrollListeners;
    if (localObject != null)
    {
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.OnScrollListener)this.mScrollListeners.get(i)).onScrollStateChanged(this, paramInt);
        i -= 1;
      }
    }
  }
  
  void dispatchOnScrolled(int paramInt1, int paramInt2)
  {
    int i = getScrollX();
    int j = getScrollY();
    onScrollChanged(i, j, i, j);
    onScrolled(paramInt1, paramInt2);
    Object localObject = this.mScrollListener;
    if (localObject != null) {
      ((RecyclerView.OnScrollListener)localObject).onScrolled(this, paramInt1, paramInt2);
    }
    localObject = this.mScrollListeners;
    if (localObject != null)
    {
      i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.OnScrollListener)this.mScrollListeners.get(i)).onScrolled(this, paramInt1, paramInt2);
        i -= 1;
      }
    }
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int j = this.mItemDecorations.size();
    int k = 0;
    int i = 0;
    while (i < j)
    {
      ((RecyclerView.ItemDecoration)this.mItemDecorations.get(i)).onDrawOver(paramCanvas, this, this.mState);
      i += 1;
    }
    EdgeEffectCompat localEdgeEffectCompat = this.mLeftGlow;
    int m;
    if ((localEdgeEffectCompat != null) && (!localEdgeEffectCompat.isFinished()))
    {
      m = paramCanvas.save();
      if (this.mClipToPadding) {
        i = getPaddingBottom();
      } else {
        i = 0;
      }
      paramCanvas.rotate(270.0F);
      paramCanvas.translate(-getHeight() + i, 0.0F);
      localEdgeEffectCompat = this.mLeftGlow;
      if ((localEdgeEffectCompat != null) && (localEdgeEffectCompat.draw(paramCanvas))) {
        j = 1;
      } else {
        j = 0;
      }
      paramCanvas.restoreToCount(m);
    }
    else
    {
      j = 0;
    }
    localEdgeEffectCompat = this.mTopGlow;
    i = j;
    if (localEdgeEffectCompat != null)
    {
      i = j;
      if (!localEdgeEffectCompat.isFinished())
      {
        m = paramCanvas.save();
        if (this.mClipToPadding) {
          paramCanvas.translate(getPaddingLeft(), getPaddingTop());
        }
        localEdgeEffectCompat = this.mTopGlow;
        if ((localEdgeEffectCompat != null) && (localEdgeEffectCompat.draw(paramCanvas))) {
          i = 1;
        } else {
          i = 0;
        }
        i = j | i;
        paramCanvas.restoreToCount(m);
      }
    }
    localEdgeEffectCompat = this.mRightGlow;
    j = i;
    if (localEdgeEffectCompat != null)
    {
      j = i;
      if (!localEdgeEffectCompat.isFinished())
      {
        m = paramCanvas.save();
        int n = getWidth();
        if (this.mClipToPadding) {
          j = getPaddingTop();
        } else {
          j = 0;
        }
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-j, -n);
        localEdgeEffectCompat = this.mRightGlow;
        if ((localEdgeEffectCompat != null) && (localEdgeEffectCompat.draw(paramCanvas))) {
          j = 1;
        } else {
          j = 0;
        }
        j = i | j;
        paramCanvas.restoreToCount(m);
      }
    }
    localEdgeEffectCompat = this.mBottomGlow;
    if ((localEdgeEffectCompat != null) && (!localEdgeEffectCompat.isFinished()))
    {
      m = paramCanvas.save();
      paramCanvas.rotate(180.0F);
      if (this.mClipToPadding) {
        paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
      } else {
        paramCanvas.translate(-getWidth(), -getHeight());
      }
      localEdgeEffectCompat = this.mBottomGlow;
      i = k;
      if (localEdgeEffectCompat != null)
      {
        i = k;
        if (localEdgeEffectCompat.draw(paramCanvas)) {
          i = 1;
        }
      }
      i |= j;
      paramCanvas.restoreToCount(m);
    }
    else
    {
      i = j;
    }
    j = i;
    if (i == 0)
    {
      j = i;
      if (this.mItemAnimator != null)
      {
        j = i;
        if (this.mItemDecorations.size() > 0)
        {
          j = i;
          if (this.mItemAnimator.isRunning()) {
            j = 1;
          }
        }
      }
    }
    if (j != 0) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  void eatRequestLayout()
  {
    this.mEatRequestLayout += 1;
    if ((this.mEatRequestLayout == 1) && (!this.mLayoutFrozen)) {
      this.mLayoutRequestEaten = false;
    }
  }
  
  void ensureBottomGlow()
  {
    if (this.mBottomGlow != null) {
      return;
    }
    this.mBottomGlow = new EdgeEffectCompat(getContext());
    if (this.mClipToPadding)
    {
      this.mBottomGlow.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.mBottomGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  void ensureLeftGlow()
  {
    if (this.mLeftGlow != null) {
      return;
    }
    this.mLeftGlow = new EdgeEffectCompat(getContext());
    if (this.mClipToPadding)
    {
      this.mLeftGlow.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.mLeftGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  void ensureRightGlow()
  {
    if (this.mRightGlow != null) {
      return;
    }
    this.mRightGlow = new EdgeEffectCompat(getContext());
    if (this.mClipToPadding)
    {
      this.mRightGlow.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.mRightGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  void ensureTopGlow()
  {
    if (this.mTopGlow != null) {
      return;
    }
    this.mTopGlow = new EdgeEffectCompat(getContext());
    if (this.mClipToPadding)
    {
      this.mTopGlow.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.mTopGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  public View findChildViewUnder(float paramFloat1, float paramFloat2)
  {
    int i = this.mChildHelper.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.mChildHelper.getChildAt(i);
      float f1 = ViewCompat.getTranslationX(localView);
      float f2 = ViewCompat.getTranslationY(localView);
      if ((paramFloat1 >= localView.getLeft() + f1) && (paramFloat1 <= localView.getRight() + f1) && (paramFloat2 >= localView.getTop() + f2) && (paramFloat2 <= localView.getBottom() + f2)) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  @Nullable
  public View findContainingItemView(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    View localView = paramView;
    for (paramView = localViewParent; (paramView != null) && (paramView != this) && ((paramView instanceof View)); paramView = localView.getParent()) {
      localView = (View)paramView;
    }
    if (paramView == this) {
      return localView;
    }
    return null;
  }
  
  @Nullable
  public RecyclerView.ViewHolder findContainingViewHolder(View paramView)
  {
    paramView = findContainingItemView(paramView);
    if (paramView == null) {
      return null;
    }
    return getChildViewHolder(paramView);
  }
  
  public RecyclerView.ViewHolder findViewHolderForAdapterPosition(int paramInt)
  {
    if (this.mDataSetHasChangedAfterLayout) {
      return null;
    }
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      if ((localViewHolder != null) && (!localViewHolder.isRemoved()) && (getAdapterPositionFor(localViewHolder) == paramInt)) {
        return localViewHolder;
      }
      i += 1;
    }
    return null;
  }
  
  public RecyclerView.ViewHolder findViewHolderForItemId(long paramLong)
  {
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      if ((localViewHolder != null) && (localViewHolder.getItemId() == paramLong)) {
        return localViewHolder;
      }
      i += 1;
    }
    return null;
  }
  
  public RecyclerView.ViewHolder findViewHolderForLayoutPosition(int paramInt)
  {
    return findViewHolderForPosition(paramInt, false);
  }
  
  @Deprecated
  public RecyclerView.ViewHolder findViewHolderForPosition(int paramInt)
  {
    return findViewHolderForPosition(paramInt, false);
  }
  
  RecyclerView.ViewHolder findViewHolderForPosition(int paramInt, boolean paramBoolean)
  {
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      if ((localViewHolder != null) && (!localViewHolder.isRemoved())) {
        if (paramBoolean)
        {
          if (localViewHolder.mPosition == paramInt) {
            return localViewHolder;
          }
        }
        else if (localViewHolder.getLayoutPosition() == paramInt) {
          return localViewHolder;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager == null)
    {
      Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return false;
    }
    if (this.mLayoutFrozen) {
      return false;
    }
    boolean bool1 = localLayoutManager.canScrollHorizontally();
    boolean bool2 = this.mLayout.canScrollVertically();
    int i;
    if (bool1)
    {
      i = paramInt1;
      if (Math.abs(paramInt1) >= this.mMinFlingVelocity) {}
    }
    else
    {
      i = 0;
    }
    if (bool2)
    {
      paramInt1 = paramInt2;
      if (Math.abs(paramInt2) >= this.mMinFlingVelocity) {}
    }
    else
    {
      paramInt1 = 0;
    }
    if ((i == 0) && (paramInt1 == 0)) {
      return false;
    }
    float f1 = i;
    float f2 = paramInt1;
    if (!dispatchNestedPreFling(f1, f2))
    {
      if ((!bool1) && (!bool2)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      dispatchNestedFling(f1, f2, bool1);
      if (bool1)
      {
        paramInt2 = this.mMaxFlingVelocity;
        paramInt2 = Math.max(-paramInt2, Math.min(i, paramInt2));
        i = this.mMaxFlingVelocity;
        paramInt1 = Math.max(-i, Math.min(paramInt1, i));
        this.mViewFlinger.fling(paramInt2, paramInt1);
        return true;
      }
    }
    return false;
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    Object localObject = this.mLayout.onInterceptFocusSearch(paramView, paramInt);
    if (localObject != null) {
      return localObject;
    }
    View localView = FocusFinder.getInstance().findNextFocus(this, paramView, paramInt);
    localObject = localView;
    if (localView == null)
    {
      localObject = localView;
      if (this.mAdapter != null)
      {
        localObject = localView;
        if (this.mLayout != null)
        {
          localObject = localView;
          if (!isComputingLayout())
          {
            localObject = localView;
            if (!this.mLayoutFrozen)
            {
              eatRequestLayout();
              localObject = this.mLayout.onFocusSearchFailed(paramView, paramInt, this.mRecycler, this.mState);
              resumeRequestLayout(false);
            }
          }
        }
      }
    }
    if (localObject != null) {
      return localObject;
    }
    return super.focusSearch(paramView, paramInt);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      return localLayoutManager.generateDefaultLayoutParams();
    }
    throw new IllegalStateException("RecyclerView has no LayoutManager");
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      return localLayoutManager.generateLayoutParams(getContext(), paramAttributeSet);
    }
    throw new IllegalStateException("RecyclerView has no LayoutManager");
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      return localLayoutManager.generateLayoutParams(paramLayoutParams);
    }
    throw new IllegalStateException("RecyclerView has no LayoutManager");
  }
  
  public RecyclerView.Adapter getAdapter()
  {
    return this.mAdapter;
  }
  
  public int getBaseline()
  {
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      return localLayoutManager.getBaseline();
    }
    return super.getBaseline();
  }
  
  long getChangedHolderKey(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.mAdapter.hasStableIds()) {
      return paramViewHolder.getItemId();
    }
    return paramViewHolder.mPosition;
  }
  
  public int getChildAdapterPosition(View paramView)
  {
    paramView = getChildViewHolderInt(paramView);
    if (paramView != null) {
      return paramView.getAdapterPosition();
    }
    return -1;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    RecyclerView.ChildDrawingOrderCallback localChildDrawingOrderCallback = this.mChildDrawingOrderCallback;
    if (localChildDrawingOrderCallback == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return localChildDrawingOrderCallback.onGetChildDrawingOrder(paramInt1, paramInt2);
  }
  
  public long getChildItemId(View paramView)
  {
    RecyclerView.Adapter localAdapter = this.mAdapter;
    long l2 = -1L;
    long l1 = l2;
    if (localAdapter != null)
    {
      if (!localAdapter.hasStableIds()) {
        return -1L;
      }
      paramView = getChildViewHolderInt(paramView);
      l1 = l2;
      if (paramView != null) {
        l1 = paramView.getItemId();
      }
    }
    return l1;
  }
  
  public int getChildLayoutPosition(View paramView)
  {
    paramView = getChildViewHolderInt(paramView);
    if (paramView != null) {
      return paramView.getLayoutPosition();
    }
    return -1;
  }
  
  @Deprecated
  public int getChildPosition(View paramView)
  {
    return getChildAdapterPosition(paramView);
  }
  
  public RecyclerView.ViewHolder getChildViewHolder(View paramView)
  {
    Object localObject = paramView.getParent();
    if ((localObject != null) && (localObject != this))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("View ");
      ((StringBuilder)localObject).append(paramView);
      ((StringBuilder)localObject).append(" is not a direct child of ");
      ((StringBuilder)localObject).append(this);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return getChildViewHolderInt(paramView);
  }
  
  public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate()
  {
    return this.mAccessibilityDelegate;
  }
  
  public RecyclerView.ItemAnimator getItemAnimator()
  {
    return this.mItemAnimator;
  }
  
  Rect getItemDecorInsetsForChild(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.mInsetsDirty) {
      return localLayoutParams.mDecorInsets;
    }
    Rect localRect = localLayoutParams.mDecorInsets;
    localRect.set(0, 0, 0, 0);
    int j = this.mItemDecorations.size();
    int i = 0;
    while (i < j)
    {
      this.mTempRect.set(0, 0, 0, 0);
      ((RecyclerView.ItemDecoration)this.mItemDecorations.get(i)).getItemOffsets(this.mTempRect, paramView, this, this.mState);
      localRect.left += this.mTempRect.left;
      localRect.top += this.mTempRect.top;
      localRect.right += this.mTempRect.right;
      localRect.bottom += this.mTempRect.bottom;
      i += 1;
    }
    localLayoutParams.mInsetsDirty = false;
    return localRect;
  }
  
  public RecyclerView.LayoutManager getLayoutManager()
  {
    return this.mLayout;
  }
  
  public int getMaxFlingVelocity()
  {
    return this.mMaxFlingVelocity;
  }
  
  public int getMinFlingVelocity()
  {
    return this.mMinFlingVelocity;
  }
  
  public RecyclerView.RecycledViewPool getRecycledViewPool()
  {
    return this.mRecycler.getRecycledViewPool();
  }
  
  public int getScrollState()
  {
    return this.mScrollState;
  }
  
  public boolean hasFixedSize()
  {
    return this.mHasFixedSize;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return this.mScrollingChildHelper.hasNestedScrollingParent();
  }
  
  public boolean hasPendingAdapterUpdates()
  {
    return (!this.mFirstLayoutComplete) || (this.mDataSetHasChangedAfterLayout) || (this.mAdapterHelper.hasPendingUpdates());
  }
  
  void initAdapterManager()
  {
    this.mAdapterHelper = new AdapterHelper(new RecyclerView.6(this));
  }
  
  void invalidateGlows()
  {
    this.mBottomGlow = null;
    this.mTopGlow = null;
    this.mRightGlow = null;
    this.mLeftGlow = null;
  }
  
  public void invalidateItemDecorations()
  {
    if (this.mItemDecorations.size() == 0) {
      return;
    }
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      localLayoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
    }
    markItemDecorInsetsDirty();
    requestLayout();
  }
  
  boolean isAccessibilityEnabled()
  {
    AccessibilityManager localAccessibilityManager = this.mAccessibilityManager;
    return (localAccessibilityManager != null) && (localAccessibilityManager.isEnabled());
  }
  
  public boolean isAnimating()
  {
    RecyclerView.ItemAnimator localItemAnimator = this.mItemAnimator;
    return (localItemAnimator != null) && (localItemAnimator.isRunning());
  }
  
  public boolean isAttachedToWindow()
  {
    return this.mIsAttached;
  }
  
  public boolean isComputingLayout()
  {
    return this.mLayoutOrScrollCounter > 0;
  }
  
  public boolean isLayoutFrozen()
  {
    return this.mLayoutFrozen;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.mScrollingChildHelper.isNestedScrollingEnabled();
  }
  
  void markItemDecorInsetsDirty()
  {
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      ((RecyclerView.LayoutParams)this.mChildHelper.getUnfilteredChildAt(i).getLayoutParams()).mInsetsDirty = true;
      i += 1;
    }
    this.mRecycler.markItemDecorInsetsDirty();
  }
  
  void markKnownViewsInvalid()
  {
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore())) {
        localViewHolder.addFlags(6);
      }
      i += 1;
    }
    markItemDecorInsetsDirty();
    this.mRecycler.markKnownViewsInvalid();
  }
  
  public void offsetChildrenHorizontal(int paramInt)
  {
    int j = this.mChildHelper.getChildCount();
    int i = 0;
    while (i < j)
    {
      this.mChildHelper.getChildAt(i).offsetLeftAndRight(paramInt);
      i += 1;
    }
  }
  
  public void offsetChildrenVertical(int paramInt)
  {
    int j = this.mChildHelper.getChildCount();
    int i = 0;
    while (i < j)
    {
      this.mChildHelper.getChildAt(i).offsetTopAndBottom(paramInt);
      i += 1;
    }
  }
  
  void offsetPositionRecordsForInsert(int paramInt1, int paramInt2)
  {
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore()) && (localViewHolder.mPosition >= paramInt1))
      {
        localViewHolder.offsetPosition(paramInt2, false);
        RecyclerView.State.access$1802(this.mState, true);
      }
      i += 1;
    }
    this.mRecycler.offsetPositionRecordsForInsert(paramInt1, paramInt2);
    requestLayout();
  }
  
  void offsetPositionRecordsForMove(int paramInt1, int paramInt2)
  {
    int n = this.mChildHelper.getUnfilteredChildCount();
    int i;
    int j;
    int k;
    if (paramInt1 < paramInt2)
    {
      i = paramInt1;
      j = paramInt2;
      k = -1;
    }
    else
    {
      j = paramInt1;
      i = paramInt2;
      k = 1;
    }
    int m = 0;
    while (m < n)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(m));
      if ((localViewHolder != null) && (localViewHolder.mPosition >= i) && (localViewHolder.mPosition <= j))
      {
        if (localViewHolder.mPosition == paramInt1) {
          localViewHolder.offsetPosition(paramInt2 - paramInt1, false);
        } else {
          localViewHolder.offsetPosition(k, false);
        }
        RecyclerView.State.access$1802(this.mState, true);
      }
      m += 1;
    }
    this.mRecycler.offsetPositionRecordsForMove(paramInt1, paramInt2);
    requestLayout();
  }
  
  void offsetPositionRecordsForRemove(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore())) {
        if (localViewHolder.mPosition >= paramInt1 + paramInt2)
        {
          localViewHolder.offsetPosition(-paramInt2, paramBoolean);
          RecyclerView.State.access$1802(this.mState, true);
        }
        else if (localViewHolder.mPosition >= paramInt1)
        {
          localViewHolder.flagRemovedAndOffsetPosition(paramInt1 - 1, -paramInt2, paramBoolean);
          RecyclerView.State.access$1802(this.mState, true);
        }
      }
      i += 1;
    }
    this.mRecycler.offsetPositionRecordsForRemove(paramInt1, paramInt2, paramBoolean);
    requestLayout();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mLayoutOrScrollCounter = 0;
    this.mIsAttached = true;
    this.mFirstLayoutComplete = false;
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      localLayoutManager.dispatchAttachedToWindow(this);
    }
    this.mPostedAnimatorRunner = false;
  }
  
  public void onChildAttachedToWindow(View paramView) {}
  
  public void onChildDetachedFromWindow(View paramView) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.mItemAnimator;
    if (localObject != null) {
      ((RecyclerView.ItemAnimator)localObject).endAnimations();
    }
    this.mFirstLayoutComplete = false;
    stopScroll();
    this.mIsAttached = false;
    localObject = this.mLayout;
    if (localObject != null) {
      ((RecyclerView.LayoutManager)localObject).dispatchDetachedFromWindow(this, this.mRecycler);
    }
    removeCallbacks(this.mItemAnimatorRunner);
    this.mViewInfoStore.onDetach();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = this.mItemDecorations.size();
    int i = 0;
    while (i < j)
    {
      ((RecyclerView.ItemDecoration)this.mItemDecorations.get(i)).onDraw(paramCanvas, this, this.mState);
      i += 1;
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (this.mLayout == null) {
      return false;
    }
    if (this.mLayoutFrozen) {
      return false;
    }
    if (((MotionEventCompat.getSource(paramMotionEvent) & 0x2) != 0) && (paramMotionEvent.getAction() == 8))
    {
      float f1;
      if (this.mLayout.canScrollVertically()) {
        f1 = -MotionEventCompat.getAxisValue(paramMotionEvent, 9);
      } else {
        f1 = 0.0F;
      }
      float f2;
      if (this.mLayout.canScrollHorizontally()) {
        f2 = MotionEventCompat.getAxisValue(paramMotionEvent, 10);
      } else {
        f2 = 0.0F;
      }
      if ((f1 != 0.0F) || (f2 != 0.0F))
      {
        float f3 = getScrollFactor();
        scrollByInternal((int)(f2 * f3), (int)(f1 * f3), paramMotionEvent);
      }
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = this.mLayoutFrozen;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (dispatchOnItemTouchIntercept(paramMotionEvent))
    {
      cancelTouch();
      return true;
    }
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager == null) {
      return false;
    }
    bool2 = localLayoutManager.canScrollHorizontally();
    boolean bool3 = this.mLayout.canScrollVertically();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int j = MotionEventCompat.getActionMasked(paramMotionEvent);
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 5)
            {
              if (j == 6) {
                onPointerUp(paramMotionEvent);
              }
            }
            else
            {
              this.mScrollPointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
              j = (int)(MotionEventCompat.getX(paramMotionEvent, i) + 0.5F);
              this.mLastTouchX = j;
              this.mInitialTouchX = j;
              i = (int)(MotionEventCompat.getY(paramMotionEvent, i) + 0.5F);
              this.mLastTouchY = i;
              this.mInitialTouchY = i;
            }
          }
          else {
            cancelTouch();
          }
        }
        else
        {
          j = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mScrollPointerId);
          if (j < 0)
          {
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("Error processing scroll; pointer index for id ");
            paramMotionEvent.append(this.mScrollPointerId);
            paramMotionEvent.append(" not found. Did any MotionEvents get skipped?");
            Log.e("RecyclerView", paramMotionEvent.toString());
            return false;
          }
          i = (int)(MotionEventCompat.getX(paramMotionEvent, j) + 0.5F);
          j = (int)(MotionEventCompat.getY(paramMotionEvent, j) + 0.5F);
          if (this.mScrollState != 1)
          {
            i -= this.mInitialTouchX;
            int m = j - this.mInitialTouchY;
            int k = -1;
            int n;
            if (bool2)
            {
              n = Math.abs(i);
              j = this.mTouchSlop;
              if (n > j)
              {
                n = this.mInitialTouchX;
                if (i < 0) {
                  i = -1;
                } else {
                  i = 1;
                }
                this.mLastTouchX = (n + j * i);
                i = 1;
                break label355;
              }
            }
            i = 0;
            label355:
            j = i;
            if (bool3)
            {
              int i1 = Math.abs(m);
              n = this.mTouchSlop;
              j = i;
              if (i1 > n)
              {
                j = this.mInitialTouchY;
                if (m < 0) {
                  i = k;
                } else {
                  i = 1;
                }
                this.mLastTouchY = (j + n * i);
                j = 1;
              }
            }
            if (j != 0) {
              setScrollState(1);
            }
          }
        }
      }
      else
      {
        this.mVelocityTracker.clear();
        stopNestedScroll();
      }
    }
    else
    {
      if (this.mIgnoreMotionEventTillDown) {
        this.mIgnoreMotionEventTillDown = false;
      }
      this.mScrollPointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.mLastTouchX = i;
      this.mInitialTouchX = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.mLastTouchY = i;
      this.mInitialTouchY = i;
      if (this.mScrollState == 2)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
      }
      paramMotionEvent = this.mNestedOffsets;
      paramMotionEvent[1] = 0;
      paramMotionEvent[0] = 0;
      if (bool2) {
        i = 1;
      } else {
        i = 0;
      }
      j = i;
      if (bool3) {
        j = i | 0x2;
      }
      startNestedScroll(j);
    }
    if (this.mScrollState == 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TraceCompat.beginSection("RV OnLayout");
    dispatchLayout();
    TraceCompat.endSection();
    this.mFirstLayoutComplete = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject = this.mLayout;
    if (localObject == null)
    {
      defaultOnMeasure(paramInt1, paramInt2);
      return;
    }
    boolean bool = RecyclerView.LayoutManager.access$2000((RecyclerView.LayoutManager)localObject);
    int j = 0;
    if (bool)
    {
      int k = View.MeasureSpec.getMode(paramInt1);
      int m = View.MeasureSpec.getMode(paramInt2);
      int i = j;
      if (k == 1073741824)
      {
        i = j;
        if (m == 1073741824) {
          i = 1;
        }
      }
      this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
      if (i == 0)
      {
        if (this.mAdapter == null) {
          return;
        }
        if (RecyclerView.State.access$2100(this.mState) == 1) {
          dispatchLayoutStep1();
        }
        this.mLayout.setMeasureSpecs(paramInt1, paramInt2);
        RecyclerView.State.access$2202(this.mState, true);
        dispatchLayoutStep2();
        this.mLayout.setMeasuredDimensionFromChildren(paramInt1, paramInt2);
        if (!this.mLayout.shouldMeasureTwice()) {
          return;
        }
        this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        RecyclerView.State.access$2202(this.mState, true);
        dispatchLayoutStep2();
        this.mLayout.setMeasuredDimensionFromChildren(paramInt1, paramInt2);
      }
    }
    else
    {
      if (this.mHasFixedSize)
      {
        this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
        return;
      }
      if (this.mAdapterUpdateDuringMeasure)
      {
        eatRequestLayout();
        processAdapterUpdatesAndSetAnimationFlags();
        if (RecyclerView.State.access$2300(this.mState))
        {
          RecyclerView.State.access$2402(this.mState, true);
        }
        else
        {
          this.mAdapterHelper.consumeUpdatesInOnePass();
          RecyclerView.State.access$2402(this.mState, false);
        }
        this.mAdapterUpdateDuringMeasure = false;
        resumeRequestLayout(false);
      }
      localObject = this.mAdapter;
      if (localObject != null) {
        this.mState.mItemCount = ((RecyclerView.Adapter)localObject).getItemCount();
      } else {
        this.mState.mItemCount = 0;
      }
      eatRequestLayout();
      this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
      resumeRequestLayout(false);
      RecyclerView.State.access$2402(this.mState, false);
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    this.mPendingSavedState = ((RecyclerView.SavedState)paramParcelable);
    super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
    if ((this.mLayout != null) && (this.mPendingSavedState.mLayoutState != null)) {
      this.mLayout.onRestoreInstanceState(this.mPendingSavedState.mLayoutState);
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    RecyclerView.SavedState localSavedState = new RecyclerView.SavedState(super.onSaveInstanceState());
    Object localObject = this.mPendingSavedState;
    if (localObject != null)
    {
      RecyclerView.SavedState.access$1900(localSavedState, (RecyclerView.SavedState)localObject);
      return localSavedState;
    }
    localObject = this.mLayout;
    if (localObject != null)
    {
      localSavedState.mLayoutState = ((RecyclerView.LayoutManager)localObject).onSaveInstanceState();
      return localSavedState;
    }
    localSavedState.mLayoutState = null;
    return localSavedState;
  }
  
  public void onScrollStateChanged(int paramInt) {}
  
  public void onScrolled(int paramInt1, int paramInt2) {}
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      invalidateGlows();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = this.mLayoutFrozen;
    int i2 = 0;
    if (!bool1)
    {
      if (this.mIgnoreMotionEventTillDown) {
        return false;
      }
      if (dispatchOnItemTouch(paramMotionEvent))
      {
        cancelTouch();
        return true;
      }
      Object localObject = this.mLayout;
      if (localObject == null) {
        return false;
      }
      bool1 = ((RecyclerView.LayoutManager)localObject).canScrollHorizontally();
      boolean bool2 = this.mLayout.canScrollVertically();
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      localObject = MotionEvent.obtain(paramMotionEvent);
      int j = MotionEventCompat.getActionMasked(paramMotionEvent);
      int i = MotionEventCompat.getActionIndex(paramMotionEvent);
      if (j == 0)
      {
        arrayOfInt = this.mNestedOffsets;
        arrayOfInt[1] = 0;
        arrayOfInt[0] = 0;
      }
      int[] arrayOfInt = this.mNestedOffsets;
      ((MotionEvent)localObject).offsetLocation(arrayOfInt[0], arrayOfInt[1]);
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j != 5)
              {
                if (j != 6)
                {
                  i = i2;
                }
                else
                {
                  onPointerUp(paramMotionEvent);
                  i = i2;
                }
              }
              else
              {
                this.mScrollPointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
                j = (int)(MotionEventCompat.getX(paramMotionEvent, i) + 0.5F);
                this.mLastTouchX = j;
                this.mInitialTouchX = j;
                i = (int)(MotionEventCompat.getY(paramMotionEvent, i) + 0.5F);
                this.mLastTouchY = i;
                this.mInitialTouchY = i;
                i = i2;
              }
            }
            else
            {
              cancelTouch();
              i = i2;
            }
          }
          else
          {
            i = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mScrollPointerId);
            if (i < 0)
            {
              paramMotionEvent = new StringBuilder();
              paramMotionEvent.append("Error processing scroll; pointer index for id ");
              paramMotionEvent.append(this.mScrollPointerId);
              paramMotionEvent.append(" not found. Did any MotionEvents get skipped?");
              Log.e("RecyclerView", paramMotionEvent.toString());
              return false;
            }
            int i3 = (int)(MotionEventCompat.getX(paramMotionEvent, i) + 0.5F);
            int i4 = (int)(MotionEventCompat.getY(paramMotionEvent, i) + 0.5F);
            int m = this.mLastTouchX - i3;
            int k = this.mLastTouchY - i4;
            j = m;
            i = k;
            if (dispatchNestedPreScroll(m, k, this.mScrollConsumed, this.mScrollOffset))
            {
              paramMotionEvent = this.mScrollConsumed;
              j = m - paramMotionEvent[0];
              i = k - paramMotionEvent[1];
              paramMotionEvent = this.mScrollOffset;
              ((MotionEvent)localObject).offsetLocation(paramMotionEvent[0], paramMotionEvent[1]);
              paramMotionEvent = this.mNestedOffsets;
              k = paramMotionEvent[0];
              arrayOfInt = this.mScrollOffset;
              paramMotionEvent[0] = (k + arrayOfInt[0]);
              paramMotionEvent[1] += arrayOfInt[1];
            }
            int n = j;
            k = i;
            if (this.mScrollState != 1)
            {
              if (bool1)
              {
                k = Math.abs(j);
                m = this.mTouchSlop;
                if (k > m)
                {
                  if (j > 0) {
                    j -= m;
                  } else {
                    j += m;
                  }
                  k = 1;
                  break label552;
                }
              }
              k = 0;
              label552:
              m = i;
              int i1 = k;
              if (bool2)
              {
                n = Math.abs(i);
                int i5 = this.mTouchSlop;
                m = i;
                i1 = k;
                if (n > i5)
                {
                  if (i > 0) {
                    m = i - i5;
                  } else {
                    m = i + i5;
                  }
                  i1 = 1;
                }
              }
              n = j;
              k = m;
              if (i1 != 0)
              {
                setScrollState(1);
                k = m;
                n = j;
              }
            }
            i = i2;
            if (this.mScrollState == 1)
            {
              paramMotionEvent = this.mScrollOffset;
              this.mLastTouchX = (i3 - paramMotionEvent[0]);
              this.mLastTouchY = (i4 - paramMotionEvent[1]);
              if (!bool1) {
                n = 0;
              }
              if (!bool2) {
                k = 0;
              }
              i = i2;
              if (scrollByInternal(n, k, (MotionEvent)localObject))
              {
                getParent().requestDisallowInterceptTouchEvent(true);
                i = i2;
              }
            }
          }
        }
        else
        {
          this.mVelocityTracker.addMovement((MotionEvent)localObject);
          this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
          float f1;
          if (bool1) {
            f1 = -VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mScrollPointerId);
          } else {
            f1 = 0.0F;
          }
          float f2;
          if (bool2) {
            f2 = -VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mScrollPointerId);
          } else {
            f2 = 0.0F;
          }
          if (((f1 == 0.0F) && (f2 == 0.0F)) || (!fling((int)f1, (int)f2))) {
            setScrollState(0);
          }
          resetTouch();
          i = 1;
        }
      }
      else
      {
        this.mScrollPointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        i = (int)(paramMotionEvent.getX() + 0.5F);
        this.mLastTouchX = i;
        this.mInitialTouchX = i;
        i = (int)(paramMotionEvent.getY() + 0.5F);
        this.mLastTouchY = i;
        this.mInitialTouchY = i;
        if (bool1) {
          i = 1;
        } else {
          i = 0;
        }
        j = i;
        if (bool2) {
          j = i | 0x2;
        }
        startNestedScroll(j);
        i = i2;
      }
      if (i == 0) {
        this.mVelocityTracker.addMovement((MotionEvent)localObject);
      }
      ((MotionEvent)localObject).recycle();
      return true;
    }
    return false;
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(paramView);
    if (localViewHolder != null) {
      if (localViewHolder.isTmpDetached())
      {
        localViewHolder.clearTmpDetachFlag();
      }
      else if (!localViewHolder.shouldIgnore())
      {
        paramView = new StringBuilder();
        paramView.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
        paramView.append(localViewHolder);
        throw new IllegalArgumentException(paramView.toString());
      }
    }
    dispatchChildDetached(paramView);
    super.removeDetachedView(paramView, paramBoolean);
  }
  
  public void removeItemDecoration(RecyclerView.ItemDecoration paramItemDecoration)
  {
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      localLayoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
    }
    this.mItemDecorations.remove(paramItemDecoration);
    if (this.mItemDecorations.isEmpty())
    {
      boolean bool;
      if (ViewCompat.getOverScrollMode(this) == 2) {
        bool = true;
      } else {
        bool = false;
      }
      setWillNotDraw(bool);
    }
    markItemDecorInsetsDirty();
    requestLayout();
  }
  
  public void removeOnChildAttachStateChangeListener(RecyclerView.OnChildAttachStateChangeListener paramOnChildAttachStateChangeListener)
  {
    List localList = this.mOnChildAttachStateListeners;
    if (localList == null) {
      return;
    }
    localList.remove(paramOnChildAttachStateChangeListener);
  }
  
  public void removeOnItemTouchListener(RecyclerView.OnItemTouchListener paramOnItemTouchListener)
  {
    this.mOnItemTouchListeners.remove(paramOnItemTouchListener);
    if (this.mActiveOnItemTouchListener == paramOnItemTouchListener) {
      this.mActiveOnItemTouchListener = null;
    }
  }
  
  public void removeOnScrollListener(RecyclerView.OnScrollListener paramOnScrollListener)
  {
    List localList = this.mScrollListeners;
    if (localList != null) {
      localList.remove(paramOnScrollListener);
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if ((!this.mLayout.onRequestChildFocus(this, this.mState, paramView1, paramView2)) && (paramView2 != null))
    {
      this.mTempRect.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
      Object localObject = paramView2.getLayoutParams();
      if ((localObject instanceof RecyclerView.LayoutParams))
      {
        localObject = (RecyclerView.LayoutParams)localObject;
        if (!((RecyclerView.LayoutParams)localObject).mInsetsDirty)
        {
          localObject = ((RecyclerView.LayoutParams)localObject).mDecorInsets;
          Rect localRect = this.mTempRect;
          localRect.left -= ((Rect)localObject).left;
          localRect = this.mTempRect;
          localRect.right += ((Rect)localObject).right;
          localRect = this.mTempRect;
          localRect.top -= ((Rect)localObject).top;
          localRect = this.mTempRect;
          localRect.bottom += ((Rect)localObject).bottom;
        }
      }
      offsetDescendantRectToMyCoords(paramView2, this.mTempRect);
      offsetRectIntoDescendantCoords(paramView1, this.mTempRect);
      requestChildRectangleOnScreen(paramView1, this.mTempRect, this.mFirstLayoutComplete ^ true);
    }
    super.requestChildFocus(paramView1, paramView2);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    return this.mLayout.requestChildRectangleOnScreen(this, paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    int j = this.mOnItemTouchListeners.size();
    int i = 0;
    while (i < j)
    {
      ((RecyclerView.OnItemTouchListener)this.mOnItemTouchListeners.get(i)).onRequestDisallowInterceptTouchEvent(paramBoolean);
      i += 1;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((this.mEatRequestLayout == 0) && (!this.mLayoutFrozen))
    {
      super.requestLayout();
      return;
    }
    this.mLayoutRequestEaten = true;
  }
  
  void resumeRequestLayout(boolean paramBoolean)
  {
    if (this.mEatRequestLayout < 1) {
      this.mEatRequestLayout = 1;
    }
    if (!paramBoolean) {
      this.mLayoutRequestEaten = false;
    }
    if (this.mEatRequestLayout == 1)
    {
      if ((paramBoolean) && (this.mLayoutRequestEaten) && (!this.mLayoutFrozen) && (this.mLayout != null) && (this.mAdapter != null)) {
        dispatchLayout();
      }
      if (!this.mLayoutFrozen) {
        this.mLayoutRequestEaten = false;
      }
    }
    this.mEatRequestLayout -= 1;
  }
  
  void saveOldPositions()
  {
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore())) {
        localViewHolder.saveOldPosition();
      }
      i += 1;
    }
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager == null)
    {
      Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    if (this.mLayoutFrozen) {
      return;
    }
    boolean bool1 = localLayoutManager.canScrollHorizontally();
    boolean bool2 = this.mLayout.canScrollVertically();
    if ((bool1) || (bool2))
    {
      if (!bool1) {
        paramInt1 = 0;
      }
      if (!bool2) {
        paramInt2 = 0;
      }
      scrollByInternal(paramInt1, paramInt2, null);
    }
  }
  
  boolean scrollByInternal(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    consumePendingUpdateOperations();
    Object localObject = this.mAdapter;
    boolean bool = false;
    int j;
    int i;
    int m;
    int k;
    if (localObject != null)
    {
      eatRequestLayout();
      onEnterLayoutOrScroll();
      TraceCompat.beginSection("RV Scroll");
      if (paramInt1 != 0)
      {
        j = this.mLayout.scrollHorizontallyBy(paramInt1, this.mRecycler, this.mState);
        i = paramInt1 - j;
      }
      else
      {
        j = 0;
        i = 0;
      }
      if (paramInt2 != 0)
      {
        m = this.mLayout.scrollVerticallyBy(paramInt2, this.mRecycler, this.mState);
        k = paramInt2 - m;
      }
      else
      {
        m = 0;
        k = 0;
      }
      TraceCompat.endSection();
      repositionShadowingViews();
      onExitLayoutOrScroll();
      resumeRequestLayout(false);
    }
    else
    {
      j = 0;
      i = 0;
      m = 0;
      k = 0;
    }
    if (!this.mItemDecorations.isEmpty()) {
      invalidate();
    }
    if (dispatchNestedScroll(j, m, i, k, this.mScrollOffset))
    {
      paramInt1 = this.mLastTouchX;
      localObject = this.mScrollOffset;
      this.mLastTouchX = (paramInt1 - localObject[0]);
      this.mLastTouchY -= localObject[1];
      if (paramMotionEvent != null) {
        paramMotionEvent.offsetLocation(localObject[0], localObject[1]);
      }
      paramMotionEvent = this.mNestedOffsets;
      paramInt1 = paramMotionEvent[0];
      localObject = this.mScrollOffset;
      paramMotionEvent[0] = (paramInt1 + localObject[0]);
      paramMotionEvent[1] += localObject[1];
    }
    else if (ViewCompat.getOverScrollMode(this) != 2)
    {
      if (paramMotionEvent != null) {
        pullGlows(paramMotionEvent.getX(), i, paramMotionEvent.getY(), k);
      }
      considerReleasingGlowsOnScroll(paramInt1, paramInt2);
    }
    if ((j != 0) || (m != 0)) {
      dispatchOnScrolled(j, m);
    }
    if (!awakenScrollBars()) {
      invalidate();
    }
    if ((j != 0) || (m != 0)) {
      bool = true;
    }
    return bool;
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
  }
  
  public void scrollToPosition(int paramInt)
  {
    if (this.mLayoutFrozen) {
      return;
    }
    stopScroll();
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager == null)
    {
      Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    localLayoutManager.scrollToPosition(paramInt);
    awakenScrollBars();
  }
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    if (shouldDeferAccessibilityEvent(paramAccessibilityEvent)) {
      return;
    }
    super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
  }
  
  public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate paramRecyclerViewAccessibilityDelegate)
  {
    this.mAccessibilityDelegate = paramRecyclerViewAccessibilityDelegate;
    ViewCompat.setAccessibilityDelegate(this, this.mAccessibilityDelegate);
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    EventCollector.getInstance().onSetRecyclerViewAdapter(this);
    setLayoutFrozen(false);
    setAdapterInternal(paramAdapter, false, true);
    requestLayout();
  }
  
  public void setChildDrawingOrderCallback(RecyclerView.ChildDrawingOrderCallback paramChildDrawingOrderCallback)
  {
    if (paramChildDrawingOrderCallback == this.mChildDrawingOrderCallback) {
      return;
    }
    this.mChildDrawingOrderCallback = paramChildDrawingOrderCallback;
    boolean bool;
    if (this.mChildDrawingOrderCallback != null) {
      bool = true;
    } else {
      bool = false;
    }
    setChildrenDrawingOrderEnabled(bool);
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != this.mClipToPadding) {
      invalidateGlows();
    }
    this.mClipToPadding = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.mFirstLayoutComplete) {
      requestLayout();
    }
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    this.mHasFixedSize = paramBoolean;
  }
  
  public void setItemAnimator(RecyclerView.ItemAnimator paramItemAnimator)
  {
    RecyclerView.ItemAnimator localItemAnimator = this.mItemAnimator;
    if (localItemAnimator != null)
    {
      localItemAnimator.endAnimations();
      this.mItemAnimator.setListener(null);
    }
    this.mItemAnimator = paramItemAnimator;
    paramItemAnimator = this.mItemAnimator;
    if (paramItemAnimator != null) {
      paramItemAnimator.setListener(this.mItemAnimatorListener);
    }
  }
  
  public void setItemViewCacheSize(int paramInt)
  {
    this.mRecycler.setViewCacheSize(paramInt);
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    if (paramBoolean != this.mLayoutFrozen)
    {
      assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
      if (!paramBoolean)
      {
        this.mLayoutFrozen = false;
        if ((this.mLayoutRequestEaten) && (this.mLayout != null) && (this.mAdapter != null)) {
          requestLayout();
        }
        this.mLayoutRequestEaten = false;
        return;
      }
      long l = SystemClock.uptimeMillis();
      onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
      this.mLayoutFrozen = true;
      this.mIgnoreMotionEventTillDown = true;
      stopScroll();
    }
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (paramLayoutManager == this.mLayout) {
      return;
    }
    stopScroll();
    Object localObject = this.mLayout;
    if (localObject != null)
    {
      if (this.mIsAttached) {
        ((RecyclerView.LayoutManager)localObject).dispatchDetachedFromWindow(this, this.mRecycler);
      }
      this.mLayout.setRecyclerView(null);
    }
    this.mRecycler.clear();
    this.mChildHelper.removeAllViewsUnfiltered();
    this.mLayout = paramLayoutManager;
    if (paramLayoutManager != null) {
      if (paramLayoutManager.mRecyclerView == null)
      {
        this.mLayout.setRecyclerView(this);
        if (this.mIsAttached) {
          this.mLayout.dispatchAttachedToWindow(this);
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LayoutManager ");
        ((StringBuilder)localObject).append(paramLayoutManager);
        ((StringBuilder)localObject).append(" is already attached to a RecyclerView: ");
        ((StringBuilder)localObject).append(paramLayoutManager.mRecyclerView);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    requestLayout();
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    this.mScrollingChildHelper.setNestedScrollingEnabled(paramBoolean);
  }
  
  @Deprecated
  public void setOnScrollListener(RecyclerView.OnScrollListener paramOnScrollListener)
  {
    this.mScrollListener = paramOnScrollListener;
  }
  
  public void setRecycledViewPool(RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    this.mRecycler.setRecycledViewPool(paramRecycledViewPool);
  }
  
  public void setRecyclerListener(RecyclerView.RecyclerListener paramRecyclerListener)
  {
    this.mRecyclerListener = paramRecyclerListener;
  }
  
  public void setScrollingTouchSlop(int paramInt)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setScrollingTouchSlop(): bad argument constant ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("; using default value");
        Log.w("RecyclerView", localStringBuilder.toString());
      }
      else
      {
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(localViewConfiguration);
        return;
      }
    }
    this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
  }
  
  public void setViewCacheExtension(RecyclerView.ViewCacheExtension paramViewCacheExtension)
  {
    this.mRecycler.setViewCacheExtension(paramViewCacheExtension);
  }
  
  boolean shouldDeferAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (isComputingLayout())
    {
      int i;
      if (paramAccessibilityEvent != null) {
        i = AccessibilityEventCompat.getContentChangeTypes(paramAccessibilityEvent);
      } else {
        i = 0;
      }
      int j = i;
      if (i == 0) {
        j = 0;
      }
      this.mEatenAccessibilityChangeFlags = (j | this.mEatenAccessibilityChangeFlags);
      return true;
    }
    return false;
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2)
  {
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager == null)
    {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    if (this.mLayoutFrozen) {
      return;
    }
    if (!localLayoutManager.canScrollHorizontally()) {
      paramInt1 = 0;
    }
    if (!this.mLayout.canScrollVertically()) {
      paramInt2 = 0;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      this.mViewFlinger.smoothScrollBy(paramInt1, paramInt2);
    }
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    if (this.mLayoutFrozen) {
      return;
    }
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager == null)
    {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    localLayoutManager.smoothScrollToPosition(this, this.mState, paramInt);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return this.mScrollingChildHelper.startNestedScroll(paramInt);
  }
  
  public void stopNestedScroll()
  {
    this.mScrollingChildHelper.stopNestedScroll();
  }
  
  public void stopScroll()
  {
    setScrollState(0);
    stopScrollersInternal();
  }
  
  public void swapAdapter(RecyclerView.Adapter paramAdapter, boolean paramBoolean)
  {
    setLayoutFrozen(false);
    setAdapterInternal(paramAdapter, true, paramBoolean);
    setDataSetChangedAfterLayout();
    requestLayout();
  }
  
  void viewRangeUpdate(int paramInt1, int paramInt2, Object paramObject)
  {
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.mChildHelper.getUnfilteredChildAt(i);
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(localView);
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore()) && (localViewHolder.mPosition >= paramInt1) && (localViewHolder.mPosition < paramInt1 + paramInt2))
      {
        localViewHolder.addFlags(2);
        localViewHolder.addChangePayload(paramObject);
        ((RecyclerView.LayoutParams)localView.getLayoutParams()).mInsetsDirty = true;
      }
      i += 1;
    }
    this.mRecycler.viewRangeUpdate(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView
 * JD-Core Version:    0.7.0.1
 */