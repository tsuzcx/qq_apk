package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
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
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.recyclerview.R.attr;
import androidx.recyclerview.R.dimen;
import androidx.recyclerview.R.styleable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class RecyclerView
  extends ViewGroup
  implements NestedScrollingChild2, NestedScrollingChild3, ScrollingView
{
  static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
  static final boolean ALLOW_THREAD_GAP_WORK;
  static final boolean DEBUG = false;
  static final int DEFAULT_ORIENTATION = 1;
  static final boolean DISPATCH_TEMP_DETACH = false;
  private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
  static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
  static final long FOREVER_NS = 9223372036854775807L;
  public static final int HORIZONTAL = 0;
  private static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
  private static final int INVALID_POINTER = -1;
  public static final int INVALID_TYPE = -1;
  private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = { Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE };
  static final int MAX_SCROLL_DURATION = 2000;
  private static final int[] NESTED_SCROLLING_ATTRS = { 16843830 };
  public static final long NO_ID = -1L;
  public static final int NO_POSITION = -1;
  static final boolean POST_UPDATES_ON_ANIMATION;
  public static final int SCROLL_STATE_DRAGGING = 1;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_SETTLING = 2;
  static final String TAG = "RecyclerView";
  public static final int TOUCH_SLOP_DEFAULT = 0;
  public static final int TOUCH_SLOP_PAGING = 1;
  static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
  static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
  private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
  static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
  private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
  private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
  static final String TRACE_PREFETCH_TAG = "RV Prefetch";
  static final String TRACE_SCROLL_TAG = "RV Scroll";
  public static final int UNDEFINED_DURATION = -2147483648;
  static final boolean VERBOSE_TRACING = false;
  public static final int VERTICAL = 1;
  static final Interpolator sQuinticInterpolator = new RecyclerView.3();
  RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
  private final AccessibilityManager mAccessibilityManager;
  RecyclerView.Adapter mAdapter;
  AdapterHelper mAdapterHelper;
  boolean mAdapterUpdateDuringMeasure;
  private EdgeEffect mBottomGlow;
  private RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback;
  ChildHelper mChildHelper;
  boolean mClipToPadding;
  boolean mDataSetHasChangedAfterLayout = false;
  boolean mDispatchItemsChangedEvent = false;
  private int mDispatchScrollCounter = 0;
  private int mEatenAccessibilityChangeFlags;
  @NonNull
  private RecyclerView.EdgeEffectFactory mEdgeEffectFactory = new RecyclerView.EdgeEffectFactory();
  boolean mEnableFastScroller;
  @VisibleForTesting
  boolean mFirstLayoutComplete;
  GapWorker mGapWorker;
  boolean mHasFixedSize;
  private boolean mIgnoreMotionEventTillDown;
  private int mInitialTouchX;
  private int mInitialTouchY;
  private int mInterceptRequestLayoutDepth = 0;
  private RecyclerView.OnItemTouchListener mInterceptingOnItemTouchListener;
  boolean mIsAttached;
  RecyclerView.ItemAnimator mItemAnimator = new DefaultItemAnimator();
  private RecyclerView.ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
  private Runnable mItemAnimatorRunner;
  final ArrayList<RecyclerView.ItemDecoration> mItemDecorations = new ArrayList();
  boolean mItemsAddedOrRemoved;
  boolean mItemsChanged;
  private int mLastTouchX;
  private int mLastTouchY;
  @VisibleForTesting
  RecyclerView.LayoutManager mLayout;
  private int mLayoutOrScrollCounter = 0;
  boolean mLayoutSuppressed;
  boolean mLayoutWasDefered;
  private EdgeEffect mLeftGlow;
  private final int mMaxFlingVelocity;
  private final int mMinFlingVelocity;
  private final int[] mMinMaxLayoutPositions;
  private final int[] mNestedOffsets;
  private final RecyclerView.RecyclerViewDataObserver mObserver = new RecyclerView.RecyclerViewDataObserver(this);
  private List<RecyclerView.OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
  private RecyclerView.OnFlingListener mOnFlingListener;
  private final ArrayList<RecyclerView.OnItemTouchListener> mOnItemTouchListeners = new ArrayList();
  @VisibleForTesting
  final List<RecyclerView.ViewHolder> mPendingAccessibilityImportanceChange;
  private RecyclerView.SavedState mPendingSavedState;
  boolean mPostedAnimatorRunner;
  GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
  private boolean mPreserveFocusAfterLayout;
  final RecyclerView.Recycler mRecycler = new RecyclerView.Recycler(this);
  RecyclerView.RecyclerListener mRecyclerListener;
  final int[] mReusableIntPair;
  private EdgeEffect mRightGlow;
  private float mScaledHorizontalScrollFactor = 1.4E-45F;
  private float mScaledVerticalScrollFactor = 1.4E-45F;
  private RecyclerView.OnScrollListener mScrollListener;
  private List<RecyclerView.OnScrollListener> mScrollListeners;
  private final int[] mScrollOffset;
  private int mScrollPointerId = -1;
  private int mScrollState = 0;
  private NestedScrollingChildHelper mScrollingChildHelper;
  final RecyclerView.State mState;
  final Rect mTempRect = new Rect();
  private final Rect mTempRect2 = new Rect();
  final RectF mTempRectF = new RectF();
  private EdgeEffect mTopGlow;
  private int mTouchSlop;
  final Runnable mUpdateChildViewsRunnable = new RecyclerView.1(this);
  private VelocityTracker mVelocityTracker;
  final RecyclerView.ViewFlinger mViewFlinger;
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
    if (Build.VERSION.SDK_INT >= 23) {
      bool = true;
    } else {
      bool = false;
    }
    ALLOW_SIZE_IN_UNSPECIFIED_SPEC = bool;
    if (Build.VERSION.SDK_INT >= 16) {
      bool = true;
    } else {
      bool = false;
    }
    POST_UPDATES_ON_ANIMATION = bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    ALLOW_THREAD_GAP_WORK = bool;
    if (Build.VERSION.SDK_INT <= 15) {
      bool = true;
    } else {
      bool = false;
    }
    FORCE_ABS_FOCUS_SEARCH_DIRECTION = bool;
    if (Build.VERSION.SDK_INT <= 15) {
      bool = true;
    } else {
      bool = false;
    }
    IGNORE_DETACHED_FOCUSED_CHILD = bool;
  }
  
  public RecyclerView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RecyclerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.recyclerViewStyle);
  }
  
  public RecyclerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool2 = true;
    this.mPreserveFocusAfterLayout = true;
    this.mViewFlinger = new RecyclerView.ViewFlinger(this);
    if (ALLOW_THREAD_GAP_WORK) {
      localObject = new GapWorker.LayoutPrefetchRegistryImpl();
    } else {
      localObject = null;
    }
    this.mPrefetchRegistry = ((GapWorker.LayoutPrefetchRegistryImpl)localObject);
    this.mState = new RecyclerView.State();
    this.mItemsAddedOrRemoved = false;
    this.mItemsChanged = false;
    this.mItemAnimatorListener = new RecyclerView.ItemAnimatorRestoreListener(this);
    this.mPostedAnimatorRunner = false;
    this.mMinMaxLayoutPositions = new int[2];
    this.mScrollOffset = new int[2];
    this.mNestedOffsets = new int[2];
    this.mReusableIntPair = new int[2];
    this.mPendingAccessibilityImportanceChange = new ArrayList();
    this.mItemAnimatorRunner = new RecyclerView.2(this);
    this.mViewInfoProcessCallback = new RecyclerView.4(this);
    setScrollContainer(true);
    setFocusableInTouchMode(true);
    Object localObject = ViewConfiguration.get(paramContext);
    this.mTouchSlop = ((ViewConfiguration)localObject).getScaledTouchSlop();
    this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor((ViewConfiguration)localObject, paramContext);
    this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor((ViewConfiguration)localObject, paramContext);
    this.mMinFlingVelocity = ((ViewConfiguration)localObject).getScaledMinimumFlingVelocity();
    this.mMaxFlingVelocity = ((ViewConfiguration)localObject).getScaledMaximumFlingVelocity();
    if (getOverScrollMode() == 2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    setWillNotDraw(bool1);
    this.mItemAnimator.setListener(this.mItemAnimatorListener);
    initAdapterManager();
    initChildrenHelper();
    initAutofill();
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
    this.mAccessibilityManager = ((AccessibilityManager)getContext().getSystemService("accessibility"));
    setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
    localObject = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecyclerView, paramInt, 0);
    if (Build.VERSION.SDK_INT >= 29) {
      saveAttributeDataForStyleable(paramContext, R.styleable.RecyclerView, paramAttributeSet, (TypedArray)localObject, paramInt, 0);
    }
    String str = ((TypedArray)localObject).getString(R.styleable.RecyclerView_layoutManager);
    if (((TypedArray)localObject).getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
      setDescendantFocusability(262144);
    }
    this.mClipToPadding = ((TypedArray)localObject).getBoolean(R.styleable.RecyclerView_android_clipToPadding, true);
    this.mEnableFastScroller = ((TypedArray)localObject).getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
    if (this.mEnableFastScroller) {
      initFastScroller((StateListDrawable)((TypedArray)localObject).getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), ((TypedArray)localObject).getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable)((TypedArray)localObject).getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), ((TypedArray)localObject).getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
    }
    ((TypedArray)localObject).recycle();
    createLayoutManager(paramContext, str, paramAttributeSet, paramInt, 0);
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = paramContext.obtainStyledAttributes(paramAttributeSet, NESTED_SCROLLING_ATTRS, paramInt, 0);
      if (Build.VERSION.SDK_INT >= 29) {
        saveAttributeDataForStyleable(paramContext, NESTED_SCROLLING_ATTRS, paramAttributeSet, (TypedArray)localObject, paramInt, 0);
      }
      bool1 = ((TypedArray)localObject).getBoolean(0, true);
      ((TypedArray)localObject).recycle();
    }
    setNestedScrollingEnabled(bool1);
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
  
  private void cancelScroll()
  {
    resetScroll();
    setScrollState(0);
  }
  
  static void clearNestedRecyclerViewIfNotNested(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    if (paramViewHolder.mNestedRecyclerView != null)
    {
      Object localObject = (View)paramViewHolder.mNestedRecyclerView.get();
      while (localObject != null)
      {
        if (localObject == paramViewHolder.itemView) {
          return;
        }
        localObject = ((View)localObject).getParent();
        if ((localObject instanceof View)) {
          localObject = (View)localObject;
        } else {
          localObject = null;
        }
      }
      paramViewHolder.mNestedRecyclerView = null;
    }
  }
  
  private void createLayoutManager(Context paramContext, String paramString, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      paramString = paramString.trim();
      if (!paramString.isEmpty())
      {
        String str = getFullClassName(paramContext, paramString);
        try
        {
          if (isInEditMode()) {
            paramString = getClass().getClassLoader();
          } else {
            paramString = paramContext.getClassLoader();
          }
          Class localClass = Class.forName(str, false, paramString).asSubclass(RecyclerView.LayoutManager.class);
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
  
  private boolean didChildRangeChange(int paramInt1, int paramInt2)
  {
    findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
    int[] arrayOfInt = this.mMinMaxLayoutPositions;
    boolean bool = false;
    if ((arrayOfInt[0] != paramInt1) || (arrayOfInt[1] != paramInt2)) {
      bool = true;
    }
    return bool;
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
    fillRemainingScrollValues(this.mState);
    this.mState.mIsMeasuring = false;
    startInterceptRequestLayout();
    this.mViewInfoStore.clear();
    onEnterLayoutOrScroll();
    processAdapterUpdatesAndSetAnimationFlags();
    saveFocusInfo();
    localObject = this.mState;
    if ((!((RecyclerView.State)localObject).mRunSimpleAnimations) || (!this.mItemsChanged)) {
      bool = false;
    }
    ((RecyclerView.State)localObject).mTrackOldChangeHolders = bool;
    this.mItemsChanged = false;
    this.mItemsAddedOrRemoved = false;
    localObject = this.mState;
    ((RecyclerView.State)localObject).mInPreLayout = ((RecyclerView.State)localObject).mRunPredictiveAnimations;
    this.mState.mItemCount = this.mAdapter.getItemCount();
    findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
    int j;
    int i;
    RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo;
    if (this.mState.mRunSimpleAnimations)
    {
      j = this.mChildHelper.getChildCount();
      i = 0;
      while (i < j)
      {
        localObject = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
        if ((!((RecyclerView.ViewHolder)localObject).shouldIgnore()) && ((!((RecyclerView.ViewHolder)localObject).isInvalid()) || (this.mAdapter.hasStableIds())))
        {
          localItemHolderInfo = this.mItemAnimator.recordPreLayoutInformation(this.mState, (RecyclerView.ViewHolder)localObject, RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations((RecyclerView.ViewHolder)localObject), ((RecyclerView.ViewHolder)localObject).getUnmodifiedPayloads());
          this.mViewInfoStore.addToPreLayout((RecyclerView.ViewHolder)localObject, localItemHolderInfo);
          if ((this.mState.mTrackOldChangeHolders) && (((RecyclerView.ViewHolder)localObject).isUpdated()) && (!((RecyclerView.ViewHolder)localObject).isRemoved()) && (!((RecyclerView.ViewHolder)localObject).shouldIgnore()) && (!((RecyclerView.ViewHolder)localObject).isInvalid()))
          {
            long l = getChangedHolderKey((RecyclerView.ViewHolder)localObject);
            this.mViewInfoStore.addToOldChangeHolders(l, (RecyclerView.ViewHolder)localObject);
          }
        }
        i += 1;
      }
    }
    if (this.mState.mRunPredictiveAnimations)
    {
      saveOldPositions();
      bool = this.mState.mStructureChanged;
      localObject = this.mState;
      ((RecyclerView.State)localObject).mStructureChanged = false;
      this.mLayout.onLayoutChildren(this.mRecycler, (RecyclerView.State)localObject);
      this.mState.mStructureChanged = bool;
      i = 0;
      while (i < this.mChildHelper.getChildCount())
      {
        localObject = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
        if ((!((RecyclerView.ViewHolder)localObject).shouldIgnore()) && (!this.mViewInfoStore.isInPreLayout((RecyclerView.ViewHolder)localObject)))
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
    stopInterceptRequestLayout(false);
    this.mState.mLayoutStep = 2;
  }
  
  private void dispatchLayoutStep2()
  {
    startInterceptRequestLayout();
    onEnterLayoutOrScroll();
    this.mState.assertLayoutStep(6);
    this.mAdapterHelper.consumeUpdatesInOnePass();
    this.mState.mItemCount = this.mAdapter.getItemCount();
    RecyclerView.State localState = this.mState;
    localState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
    localState.mInPreLayout = false;
    this.mLayout.onLayoutChildren(this.mRecycler, localState);
    localState = this.mState;
    localState.mStructureChanged = false;
    this.mPendingSavedState = null;
    boolean bool;
    if ((localState.mRunSimpleAnimations) && (this.mItemAnimator != null)) {
      bool = true;
    } else {
      bool = false;
    }
    localState.mRunSimpleAnimations = bool;
    this.mState.mLayoutStep = 4;
    onExitLayoutOrScroll();
    stopInterceptRequestLayout(false);
  }
  
  private void dispatchLayoutStep3()
  {
    this.mState.assertLayoutStep(4);
    startInterceptRequestLayout();
    onEnterLayoutOrScroll();
    Object localObject = this.mState;
    ((RecyclerView.State)localObject).mLayoutStep = 1;
    if (((RecyclerView.State)localObject).mRunSimpleAnimations)
    {
      int i = this.mChildHelper.getChildCount() - 1;
      while (i >= 0)
      {
        localObject = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
        if (!((RecyclerView.ViewHolder)localObject).shouldIgnore())
        {
          long l = getChangedHolderKey((RecyclerView.ViewHolder)localObject);
          RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo2 = this.mItemAnimator.recordPostLayoutInformation(this.mState, (RecyclerView.ViewHolder)localObject);
          RecyclerView.ViewHolder localViewHolder = this.mViewInfoStore.getFromOldChangeHolders(l);
          if ((localViewHolder != null) && (!localViewHolder.shouldIgnore()))
          {
            boolean bool1 = this.mViewInfoStore.isDisappearing(localViewHolder);
            boolean bool2 = this.mViewInfoStore.isDisappearing((RecyclerView.ViewHolder)localObject);
            if ((bool1) && (localViewHolder == localObject))
            {
              this.mViewInfoStore.addToPostLayout((RecyclerView.ViewHolder)localObject, localItemHolderInfo2);
            }
            else
            {
              RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo1 = this.mViewInfoStore.popFromPreLayout(localViewHolder);
              this.mViewInfoStore.addToPostLayout((RecyclerView.ViewHolder)localObject, localItemHolderInfo2);
              localItemHolderInfo2 = this.mViewInfoStore.popFromPostLayout((RecyclerView.ViewHolder)localObject);
              if (localItemHolderInfo1 == null) {
                handleMissingPreInfoForChangeError(l, (RecyclerView.ViewHolder)localObject, localViewHolder);
              } else {
                animateChange(localViewHolder, (RecyclerView.ViewHolder)localObject, localItemHolderInfo1, localItemHolderInfo2, bool1, bool2);
              }
            }
          }
          else
          {
            this.mViewInfoStore.addToPostLayout((RecyclerView.ViewHolder)localObject, localItemHolderInfo2);
          }
        }
        i -= 1;
      }
      this.mViewInfoStore.process(this.mViewInfoProcessCallback);
    }
    this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
    localObject = this.mState;
    ((RecyclerView.State)localObject).mPreviousLayoutItemCount = ((RecyclerView.State)localObject).mItemCount;
    this.mDataSetHasChangedAfterLayout = false;
    this.mDispatchItemsChangedEvent = false;
    localObject = this.mState;
    ((RecyclerView.State)localObject).mRunSimpleAnimations = false;
    ((RecyclerView.State)localObject).mRunPredictiveAnimations = false;
    this.mLayout.mRequestedSimpleAnimations = false;
    if (this.mRecycler.mChangedScrap != null) {
      this.mRecycler.mChangedScrap.clear();
    }
    if (this.mLayout.mPrefetchMaxObservedInInitialPrefetch)
    {
      localObject = this.mLayout;
      ((RecyclerView.LayoutManager)localObject).mPrefetchMaxCountObserved = 0;
      ((RecyclerView.LayoutManager)localObject).mPrefetchMaxObservedInInitialPrefetch = false;
      this.mRecycler.updateViewCacheSize();
    }
    this.mLayout.onLayoutCompleted(this.mState);
    onExitLayoutOrScroll();
    stopInterceptRequestLayout(false);
    this.mViewInfoStore.clear();
    localObject = this.mMinMaxLayoutPositions;
    if (didChildRangeChange(localObject[0], localObject[1])) {
      dispatchOnScrolled(0, 0);
    }
    recoverFocusFromState();
    resetFocusInfo();
  }
  
  private boolean dispatchToOnItemTouchListeners(MotionEvent paramMotionEvent)
  {
    RecyclerView.OnItemTouchListener localOnItemTouchListener = this.mInterceptingOnItemTouchListener;
    if (localOnItemTouchListener == null)
    {
      if (paramMotionEvent.getAction() == 0) {
        return false;
      }
      return findInterceptingOnItemTouchListener(paramMotionEvent);
    }
    localOnItemTouchListener.onTouchEvent(this, paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1)) {
      this.mInterceptingOnItemTouchListener = null;
    }
    return true;
  }
  
  private boolean findInterceptingOnItemTouchListener(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction();
    int k = this.mOnItemTouchListeners.size();
    int i = 0;
    while (i < k)
    {
      RecyclerView.OnItemTouchListener localOnItemTouchListener = (RecyclerView.OnItemTouchListener)this.mOnItemTouchListeners.get(i);
      if ((localOnItemTouchListener.onInterceptTouchEvent(this, paramMotionEvent)) && (j != 3))
      {
        this.mInterceptingOnItemTouchListener = localOnItemTouchListener;
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void findMinMaxChildLayoutPositions(int[] paramArrayOfInt)
  {
    int i2 = this.mChildHelper.getChildCount();
    if (i2 == 0)
    {
      paramArrayOfInt[0] = -1;
      paramArrayOfInt[1] = -1;
      return;
    }
    int m = 0;
    int j = 2147483647;
    int i1;
    for (int k = -2147483648; m < i2; k = i1)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getChildAt(m));
      if (localViewHolder.shouldIgnore())
      {
        i1 = k;
      }
      else
      {
        int n = localViewHolder.getLayoutPosition();
        int i = j;
        if (n < j) {
          i = n;
        }
        j = i;
        i1 = k;
        if (n > k)
        {
          i1 = n;
          j = i;
        }
      }
      m += 1;
    }
    paramArrayOfInt[0] = j;
    paramArrayOfInt[1] = k;
  }
  
  @Nullable
  static RecyclerView findNestedRecyclerView(@NonNull View paramView)
  {
    if (!(paramView instanceof ViewGroup)) {
      return null;
    }
    if ((paramView instanceof RecyclerView)) {
      return (RecyclerView)paramView;
    }
    paramView = (ViewGroup)paramView;
    int j = paramView.getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView localRecyclerView = findNestedRecyclerView(paramView.getChildAt(i));
      if (localRecyclerView != null) {
        return localRecyclerView;
      }
      i += 1;
    }
    return null;
  }
  
  @Nullable
  private View findNextViewToFocus()
  {
    if (this.mState.mFocusedItemPosition != -1) {
      i = this.mState.mFocusedItemPosition;
    } else {
      i = 0;
    }
    int k = this.mState.getItemCount();
    int j = i;
    RecyclerView.ViewHolder localViewHolder;
    while (j < k)
    {
      localViewHolder = findViewHolderForAdapterPosition(j);
      if (localViewHolder == null) {
        break;
      }
      if (localViewHolder.itemView.hasFocusable()) {
        return localViewHolder.itemView;
      }
      j += 1;
    }
    int i = Math.min(k, i) - 1;
    while (i >= 0)
    {
      localViewHolder = findViewHolderForAdapterPosition(i);
      if (localViewHolder == null) {
        return null;
      }
      if (localViewHolder.itemView.hasFocusable()) {
        return localViewHolder.itemView;
      }
      i -= 1;
    }
    return null;
  }
  
  static RecyclerView.ViewHolder getChildViewHolderInt(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mViewHolder;
  }
  
  static void getDecoratedBoundsWithMarginsInt(View paramView, Rect paramRect)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.mDecorInsets;
    paramRect.set(paramView.getLeft() - localRect.left - localLayoutParams.leftMargin, paramView.getTop() - localRect.top - localLayoutParams.topMargin, paramView.getRight() + localRect.right + localLayoutParams.rightMargin, paramView.getBottom() + localRect.bottom + localLayoutParams.bottomMargin);
  }
  
  private int getDeepestFocusedViewWithId(View paramView)
  {
    int i = paramView.getId();
    while ((!paramView.isFocused()) && ((paramView instanceof ViewGroup)) && (paramView.hasFocus()))
    {
      View localView = ((ViewGroup)paramView).getFocusedChild();
      paramView = localView;
      if (localView.getId() != -1)
      {
        i = localView.getId();
        paramView = localView;
      }
    }
    return i;
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
  
  private NestedScrollingChildHelper getScrollingChildHelper()
  {
    if (this.mScrollingChildHelper == null) {
      this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
    }
    return this.mScrollingChildHelper;
  }
  
  private void handleMissingPreInfoForChangeError(long paramLong, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    int j = this.mChildHelper.getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
      if ((localObject != paramViewHolder1) && (getChangedHolderKey((RecyclerView.ViewHolder)localObject) == paramLong))
      {
        paramViewHolder2 = this.mAdapter;
        if ((paramViewHolder2 != null) && (paramViewHolder2.hasStableIds()))
        {
          paramViewHolder2 = new StringBuilder();
          paramViewHolder2.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
          paramViewHolder2.append(localObject);
          paramViewHolder2.append(" \n View Holder 2:");
          paramViewHolder2.append(paramViewHolder1);
          paramViewHolder2.append(exceptionLabel());
          throw new IllegalStateException(paramViewHolder2.toString());
        }
        paramViewHolder2 = new StringBuilder();
        paramViewHolder2.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
        paramViewHolder2.append(localObject);
        paramViewHolder2.append(" \n View Holder 2:");
        paramViewHolder2.append(paramViewHolder1);
        paramViewHolder2.append(exceptionLabel());
        throw new IllegalStateException(paramViewHolder2.toString());
      }
      i += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
    ((StringBuilder)localObject).append(paramViewHolder2);
    ((StringBuilder)localObject).append(" cannot be found but it is necessary for ");
    ((StringBuilder)localObject).append(paramViewHolder1);
    ((StringBuilder)localObject).append(exceptionLabel());
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
  
  @SuppressLint({"InlinedApi"})
  private void initAutofill()
  {
    if (ViewCompat.getImportantForAutofill(this) == 0) {
      ViewCompat.setImportantForAutofill(this, 8);
    }
  }
  
  private void initChildrenHelper()
  {
    this.mChildHelper = new ChildHelper(new RecyclerView.5(this));
  }
  
  private boolean isPreferredNextFocus(View paramView1, View paramView2, int paramInt)
  {
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool2 = false;
    boolean bool7 = false;
    boolean bool3 = false;
    boolean bool1 = bool7;
    if (paramView2 != null)
    {
      if (paramView2 == this) {
        return false;
      }
      if (findContainingItemView(paramView2) == null) {
        return false;
      }
      if (paramView1 == null) {
        return true;
      }
      if (findContainingItemView(paramView1) == null) {
        return true;
      }
      this.mTempRect.set(0, 0, paramView1.getWidth(), paramView1.getHeight());
      this.mTempRect2.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
      offsetDescendantRectToMyCoords(paramView1, this.mTempRect);
      offsetDescendantRectToMyCoords(paramView2, this.mTempRect2);
      int i = this.mLayout.getLayoutDirection();
      int j = -1;
      int k;
      if (i == 1) {
        k = -1;
      } else {
        k = 1;
      }
      if (((this.mTempRect.left < this.mTempRect2.left) || (this.mTempRect.right <= this.mTempRect2.left)) && (this.mTempRect.right < this.mTempRect2.right)) {
        i = 1;
      } else if (((this.mTempRect.right > this.mTempRect2.right) || (this.mTempRect.left >= this.mTempRect2.right)) && (this.mTempRect.left > this.mTempRect2.left)) {
        i = -1;
      } else {
        i = 0;
      }
      if (((this.mTempRect.top < this.mTempRect2.top) || (this.mTempRect.bottom <= this.mTempRect2.top)) && (this.mTempRect.bottom < this.mTempRect2.bottom)) {
        j = 1;
      } else if (((this.mTempRect.bottom <= this.mTempRect2.bottom) && (this.mTempRect.top < this.mTempRect2.bottom)) || (this.mTempRect.top <= this.mTempRect2.top)) {
        j = 0;
      }
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 17)
          {
            if (paramInt != 33)
            {
              if (paramInt != 66)
              {
                if (paramInt == 130)
                {
                  bool1 = bool3;
                  if (j > 0) {
                    bool1 = true;
                  }
                  return bool1;
                }
                paramView1 = new StringBuilder();
                paramView1.append("Invalid direction: ");
                paramView1.append(paramInt);
                paramView1.append(exceptionLabel());
                throw new IllegalArgumentException(paramView1.toString());
              }
              bool1 = bool4;
              if (i > 0) {
                bool1 = true;
              }
              return bool1;
            }
            bool1 = bool5;
            if (j < 0) {
              bool1 = true;
            }
            return bool1;
          }
          bool1 = bool6;
          if (i < 0) {
            bool1 = true;
          }
          return bool1;
        }
        if (j <= 0)
        {
          bool1 = bool2;
          if (j == 0)
          {
            bool1 = bool2;
            if (i * k < 0) {}
          }
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
      if (j >= 0)
      {
        bool1 = bool7;
        if (j == 0)
        {
          bool1 = bool7;
          if (i * k > 0) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void onPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mScrollPointerId)
    {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      this.mScrollPointerId = paramMotionEvent.getPointerId(i);
      int j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.mLastTouchX = j;
      this.mInitialTouchX = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.mLastTouchY = i;
      this.mInitialTouchY = i;
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
      if (this.mDispatchItemsChangedEvent) {
        this.mLayout.onItemsChanged(this);
      }
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
    if ((this.mFirstLayoutComplete) && (this.mItemAnimator != null) && ((this.mDataSetHasChangedAfterLayout) || (i != 0) || (this.mLayout.mRequestedSimpleAnimations)) && ((!this.mDataSetHasChangedAfterLayout) || (this.mAdapter.hasStableIds()))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localState.mRunSimpleAnimations = bool1;
    localState = this.mState;
    bool1 = bool2;
    if (localState.mRunSimpleAnimations)
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
    localState.mRunPredictiveAnimations = bool1;
  }
  
  private void pullGlows(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int j = 1;
    if (paramFloat2 < 0.0F)
    {
      ensureLeftGlow();
      EdgeEffectCompat.onPull(this.mLeftGlow, -paramFloat2 / getWidth(), 1.0F - paramFloat3 / getHeight());
    }
    for (;;)
    {
      i = 1;
      break label80;
      if (paramFloat2 <= 0.0F) {
        break;
      }
      ensureRightGlow();
      EdgeEffectCompat.onPull(this.mRightGlow, paramFloat2 / getWidth(), paramFloat3 / getHeight());
    }
    int i = 0;
    label80:
    if (paramFloat4 < 0.0F)
    {
      ensureTopGlow();
      EdgeEffectCompat.onPull(this.mTopGlow, -paramFloat4 / getHeight(), paramFloat1 / getWidth());
      i = j;
    }
    else if (paramFloat4 > 0.0F)
    {
      ensureBottomGlow();
      EdgeEffectCompat.onPull(this.mBottomGlow, paramFloat4 / getHeight(), 1.0F - paramFloat1 / getWidth());
      i = j;
    }
    if ((i != 0) || (paramFloat2 != 0.0F) || (paramFloat4 != 0.0F)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private void recoverFocusFromState()
  {
    if ((this.mPreserveFocusAfterLayout) && (this.mAdapter != null) && (hasFocus()) && (getDescendantFocusability() != 393216))
    {
      if ((getDescendantFocusability() == 131072) && (isFocused())) {
        return;
      }
      Object localObject;
      if (!isFocused())
      {
        localObject = getFocusedChild();
        if ((IGNORE_DETACHED_FOCUSED_CHILD) && ((((View)localObject).getParent() == null) || (!((View)localObject).hasFocus())))
        {
          if (this.mChildHelper.getChildCount() == 0) {
            requestFocus();
          }
        }
        else if (!this.mChildHelper.isHidden((View)localObject)) {
          return;
        }
      }
      long l = this.mState.mFocusedItemId;
      View localView = null;
      if ((l != -1L) && (this.mAdapter.hasStableIds())) {
        localObject = findViewHolderForItemId(this.mState.mFocusedItemId);
      } else {
        localObject = null;
      }
      if ((localObject != null) && (!this.mChildHelper.isHidden(((RecyclerView.ViewHolder)localObject).itemView)) && (((RecyclerView.ViewHolder)localObject).itemView.hasFocusable()))
      {
        localObject = ((RecyclerView.ViewHolder)localObject).itemView;
      }
      else
      {
        localObject = localView;
        if (this.mChildHelper.getChildCount() > 0) {
          localObject = findNextViewToFocus();
        }
      }
      if (localObject != null)
      {
        if (this.mState.mFocusedSubChildId != -1L)
        {
          localView = ((View)localObject).findViewById(this.mState.mFocusedSubChildId);
          if ((localView != null) && (localView.isFocusable())) {
            localObject = localView;
          }
        }
        ((View)localObject).requestFocus();
      }
    }
  }
  
  private void releaseGlows()
  {
    EdgeEffect localEdgeEffect = this.mLeftGlow;
    if (localEdgeEffect != null)
    {
      localEdgeEffect.onRelease();
      bool2 = this.mLeftGlow.isFinished();
    }
    else
    {
      bool2 = false;
    }
    localEdgeEffect = this.mTopGlow;
    boolean bool1 = bool2;
    if (localEdgeEffect != null)
    {
      localEdgeEffect.onRelease();
      bool1 = bool2 | this.mTopGlow.isFinished();
    }
    localEdgeEffect = this.mRightGlow;
    boolean bool2 = bool1;
    if (localEdgeEffect != null)
    {
      localEdgeEffect.onRelease();
      bool2 = bool1 | this.mRightGlow.isFinished();
    }
    localEdgeEffect = this.mBottomGlow;
    bool1 = bool2;
    if (localEdgeEffect != null)
    {
      localEdgeEffect.onRelease();
      bool1 = bool2 | this.mBottomGlow.isFinished();
    }
    if (bool1) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private void requestChildOnScreen(@NonNull View paramView1, @Nullable View paramView2)
  {
    if (paramView2 != null) {
      localObject = paramView2;
    } else {
      localObject = paramView1;
    }
    this.mTempRect.set(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
    Object localObject = ((View)localObject).getLayoutParams();
    if ((localObject instanceof RecyclerView.LayoutParams))
    {
      localObject = (RecyclerView.LayoutParams)localObject;
      if (!((RecyclerView.LayoutParams)localObject).mInsetsDirty)
      {
        localObject = ((RecyclerView.LayoutParams)localObject).mDecorInsets;
        localRect = this.mTempRect;
        localRect.left -= ((Rect)localObject).left;
        localRect = this.mTempRect;
        localRect.right += ((Rect)localObject).right;
        localRect = this.mTempRect;
        localRect.top -= ((Rect)localObject).top;
        localRect = this.mTempRect;
        localRect.bottom += ((Rect)localObject).bottom;
      }
    }
    if (paramView2 != null)
    {
      offsetDescendantRectToMyCoords(paramView2, this.mTempRect);
      offsetRectIntoDescendantCoords(paramView1, this.mTempRect);
    }
    localObject = this.mLayout;
    Rect localRect = this.mTempRect;
    boolean bool2 = this.mFirstLayoutComplete;
    boolean bool1;
    if (paramView2 == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((RecyclerView.LayoutManager)localObject).requestChildRectangleOnScreen(this, paramView1, localRect, bool2 ^ true, bool1);
  }
  
  private void resetFocusInfo()
  {
    RecyclerView.State localState = this.mState;
    localState.mFocusedItemId = -1L;
    localState.mFocusedItemPosition = -1;
    localState.mFocusedSubChildId = -1;
  }
  
  private void resetScroll()
  {
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
    stopNestedScroll(0);
    releaseGlows();
  }
  
  private void saveFocusInfo()
  {
    boolean bool = this.mPreserveFocusAfterLayout;
    RecyclerView.State localState = null;
    Object localObject;
    if ((bool) && (hasFocus()) && (this.mAdapter != null)) {
      localObject = getFocusedChild();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      localObject = localState;
    } else {
      localObject = findContainingViewHolder((View)localObject);
    }
    if (localObject == null)
    {
      resetFocusInfo();
      return;
    }
    localState = this.mState;
    long l;
    if (this.mAdapter.hasStableIds()) {
      l = ((RecyclerView.ViewHolder)localObject).getItemId();
    } else {
      l = -1L;
    }
    localState.mFocusedItemId = l;
    localState = this.mState;
    int i;
    if (this.mDataSetHasChangedAfterLayout) {
      i = -1;
    } else if (((RecyclerView.ViewHolder)localObject).isRemoved()) {
      i = ((RecyclerView.ViewHolder)localObject).mOldPosition;
    } else {
      i = ((RecyclerView.ViewHolder)localObject).getAdapterPosition();
    }
    localState.mFocusedItemPosition = i;
    this.mState.mFocusedSubChildId = getDeepestFocusedViewWithId(((RecyclerView.ViewHolder)localObject).itemView);
  }
  
  private void setAdapterInternal(@Nullable RecyclerView.Adapter paramAdapter, boolean paramBoolean1, boolean paramBoolean2)
  {
    RecyclerView.Adapter localAdapter = this.mAdapter;
    if (localAdapter != null)
    {
      localAdapter.unregisterAdapterDataObserver(this.mObserver);
      this.mAdapter.onDetachedFromRecyclerView(this);
    }
    if ((!paramBoolean1) || (paramBoolean2)) {
      removeAndRecycleViews();
    }
    this.mAdapterHelper.reset();
    localAdapter = this.mAdapter;
    this.mAdapter = paramAdapter;
    if (paramAdapter != null)
    {
      paramAdapter.registerAdapterDataObserver(this.mObserver);
      paramAdapter.onAttachedToRecyclerView(this);
    }
    paramAdapter = this.mLayout;
    if (paramAdapter != null) {
      paramAdapter.onAdapterChanged(localAdapter, this.mAdapter);
    }
    this.mRecycler.onAdapterChanged(localAdapter, this.mAdapter, paramBoolean1);
    this.mState.mStructureChanged = true;
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
      if (this.mLeftGlow.isFinished()) {
        this.mLeftGlow.onAbsorb(-paramInt1);
      }
    }
    else if (paramInt1 > 0)
    {
      ensureRightGlow();
      if (this.mRightGlow.isFinished()) {
        this.mRightGlow.onAbsorb(paramInt1);
      }
    }
    if (paramInt2 < 0)
    {
      ensureTopGlow();
      if (this.mTopGlow.isFinished()) {
        this.mTopGlow.onAbsorb(-paramInt2);
      }
    }
    else if (paramInt2 > 0)
    {
      ensureBottomGlow();
      if (this.mBottomGlow.isFinished()) {
        this.mBottomGlow.onAbsorb(paramInt2);
      }
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
  
  public void addItemDecoration(@NonNull RecyclerView.ItemDecoration paramItemDecoration)
  {
    addItemDecoration(paramItemDecoration, -1);
  }
  
  public void addItemDecoration(@NonNull RecyclerView.ItemDecoration paramItemDecoration, int paramInt)
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
  
  public void addOnChildAttachStateChangeListener(@NonNull RecyclerView.OnChildAttachStateChangeListener paramOnChildAttachStateChangeListener)
  {
    if (this.mOnChildAttachStateListeners == null) {
      this.mOnChildAttachStateListeners = new ArrayList();
    }
    this.mOnChildAttachStateListeners.add(paramOnChildAttachStateChangeListener);
  }
  
  public void addOnItemTouchListener(@NonNull RecyclerView.OnItemTouchListener paramOnItemTouchListener)
  {
    this.mOnItemTouchListeners.add(paramOnItemTouchListener);
  }
  
  public void addOnScrollListener(@NonNull RecyclerView.OnScrollListener paramOnScrollListener)
  {
    if (this.mScrollListeners == null) {
      this.mScrollListeners = new ArrayList();
    }
    this.mScrollListeners.add(paramOnScrollListener);
  }
  
  void animateAppearance(@NonNull RecyclerView.ViewHolder paramViewHolder, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    paramViewHolder.setIsRecyclable(false);
    if (this.mItemAnimator.animateAppearance(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2)) {
      postAnimationRunner();
    }
  }
  
  void animateDisappearance(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    addAnimatingView(paramViewHolder);
    paramViewHolder.setIsRecyclable(false);
    if (this.mItemAnimator.animateDisappearance(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2)) {
      postAnimationRunner();
    }
  }
  
  void assertInLayoutOrScroll(String paramString)
  {
    if (!isComputingLayout())
    {
      if (paramString == null)
      {
        paramString = new StringBuilder();
        paramString.append("Cannot call this method unless RecyclerView is computing a layout or scrolling");
        paramString.append(exceptionLabel());
        throw new IllegalStateException(paramString.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(exceptionLabel());
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  void assertNotInLayoutOrScroll(String paramString)
  {
    if (isComputingLayout())
    {
      if (paramString == null)
      {
        paramString = new StringBuilder();
        paramString.append("Cannot call this method while RecyclerView is computing a layout or scrolling");
        paramString.append(exceptionLabel());
        throw new IllegalStateException(paramString.toString());
      }
      throw new IllegalStateException(paramString);
    }
    if (this.mDispatchScrollCounter > 0)
    {
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(exceptionLabel());
      Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(paramString.toString()));
    }
  }
  
  boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder paramViewHolder)
  {
    RecyclerView.ItemAnimator localItemAnimator = this.mItemAnimator;
    return (localItemAnimator == null) || (localItemAnimator.canReuseUpdatedViewHolder(paramViewHolder, paramViewHolder.getUnmodifiedPayloads()));
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
      if (!localViewHolder.shouldIgnore()) {
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
  
  void considerReleasingGlowsOnScroll(int paramInt1, int paramInt2)
  {
    EdgeEffect localEdgeEffect = this.mLeftGlow;
    if ((localEdgeEffect != null) && (!localEdgeEffect.isFinished()) && (paramInt1 > 0))
    {
      this.mLeftGlow.onRelease();
      bool2 = this.mLeftGlow.isFinished();
    }
    else
    {
      bool2 = false;
    }
    localEdgeEffect = this.mRightGlow;
    boolean bool1 = bool2;
    if (localEdgeEffect != null)
    {
      bool1 = bool2;
      if (!localEdgeEffect.isFinished())
      {
        bool1 = bool2;
        if (paramInt1 < 0)
        {
          this.mRightGlow.onRelease();
          bool1 = bool2 | this.mRightGlow.isFinished();
        }
      }
    }
    localEdgeEffect = this.mTopGlow;
    boolean bool2 = bool1;
    if (localEdgeEffect != null)
    {
      bool2 = bool1;
      if (!localEdgeEffect.isFinished())
      {
        bool2 = bool1;
        if (paramInt2 > 0)
        {
          this.mTopGlow.onRelease();
          bool2 = bool1 | this.mTopGlow.isFinished();
        }
      }
    }
    localEdgeEffect = this.mBottomGlow;
    bool1 = bool2;
    if (localEdgeEffect != null)
    {
      bool1 = bool2;
      if (!localEdgeEffect.isFinished())
      {
        bool1 = bool2;
        if (paramInt2 < 0)
        {
          this.mBottomGlow.onRelease();
          bool1 = bool2 | this.mBottomGlow.isFinished();
        }
      }
    }
    if (bool1) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  void consumePendingUpdateOperations()
  {
    if ((this.mFirstLayoutComplete) && (!this.mDataSetHasChangedAfterLayout))
    {
      if (!this.mAdapterHelper.hasPendingUpdates()) {
        return;
      }
      if ((this.mAdapterHelper.hasAnyUpdateTypes(4)) && (!this.mAdapterHelper.hasAnyUpdateTypes(11)))
      {
        TraceCompat.beginSection("RV PartialInvalidate");
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mAdapterHelper.preProcess();
        if (!this.mLayoutWasDefered) {
          if (hasUpdatedView()) {
            dispatchLayout();
          } else {
            this.mAdapterHelper.consumePostponedUpdates();
          }
        }
        stopInterceptRequestLayout(true);
        onExitLayoutOrScroll();
        TraceCompat.endSection();
        return;
      }
      if (this.mAdapterHelper.hasPendingUpdates())
      {
        TraceCompat.beginSection("RV FullInvalidate");
        dispatchLayout();
        TraceCompat.endSection();
      }
      return;
    }
    TraceCompat.beginSection("RV FullInvalidate");
    dispatchLayout();
    TraceCompat.endSection();
  }
  
  void defaultOnMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(RecyclerView.LayoutManager.chooseSize(paramInt1, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), RecyclerView.LayoutManager.chooseSize(paramInt2, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
  }
  
  void dispatchChildAttached(View paramView)
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
  
  void dispatchChildDetached(View paramView)
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
    RecyclerView.State localState = this.mState;
    localState.mIsMeasuring = false;
    if (localState.mLayoutStep == 1)
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
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return getScrollingChildHelper().dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return getScrollingChildHelper().dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    return getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
  }
  
  public final void dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int paramInt5, @NonNull int[] paramArrayOfInt2)
  {
    getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt1, paramInt5, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    return getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5);
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
    this.mDispatchScrollCounter += 1;
    int i = getScrollX();
    int j = getScrollY();
    onScrollChanged(i, j, i - paramInt1, j - paramInt2);
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
    this.mDispatchScrollCounter -= 1;
  }
  
  void dispatchPendingImportantForAccessibilityChanges()
  {
    int i = this.mPendingAccessibilityImportanceChange.size() - 1;
    while (i >= 0)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mPendingAccessibilityImportanceChange.get(i);
      if ((localViewHolder.itemView.getParent() == this) && (!localViewHolder.shouldIgnore()))
      {
        int j = localViewHolder.mPendingAccessibilityState;
        if (j != -1)
        {
          ViewCompat.setImportantForAccessibility(localViewHolder.itemView, j);
          localViewHolder.mPendingAccessibilityState = -1;
        }
      }
      i -= 1;
    }
    this.mPendingAccessibilityImportanceChange.clear();
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    onPopulateAccessibilityEvent(paramAccessibilityEvent);
    return true;
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
    EdgeEffect localEdgeEffect = this.mLeftGlow;
    int m;
    if ((localEdgeEffect != null) && (!localEdgeEffect.isFinished()))
    {
      m = paramCanvas.save();
      if (this.mClipToPadding) {
        i = getPaddingBottom();
      } else {
        i = 0;
      }
      paramCanvas.rotate(270.0F);
      paramCanvas.translate(-getHeight() + i, 0.0F);
      localEdgeEffect = this.mLeftGlow;
      if ((localEdgeEffect != null) && (localEdgeEffect.draw(paramCanvas))) {
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
    localEdgeEffect = this.mTopGlow;
    i = j;
    if (localEdgeEffect != null)
    {
      i = j;
      if (!localEdgeEffect.isFinished())
      {
        m = paramCanvas.save();
        if (this.mClipToPadding) {
          paramCanvas.translate(getPaddingLeft(), getPaddingTop());
        }
        localEdgeEffect = this.mTopGlow;
        if ((localEdgeEffect != null) && (localEdgeEffect.draw(paramCanvas))) {
          i = 1;
        } else {
          i = 0;
        }
        i = j | i;
        paramCanvas.restoreToCount(m);
      }
    }
    localEdgeEffect = this.mRightGlow;
    j = i;
    if (localEdgeEffect != null)
    {
      j = i;
      if (!localEdgeEffect.isFinished())
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
        localEdgeEffect = this.mRightGlow;
        if ((localEdgeEffect != null) && (localEdgeEffect.draw(paramCanvas))) {
          j = 1;
        } else {
          j = 0;
        }
        j = i | j;
        paramCanvas.restoreToCount(m);
      }
    }
    localEdgeEffect = this.mBottomGlow;
    if ((localEdgeEffect != null) && (!localEdgeEffect.isFinished()))
    {
      m = paramCanvas.save();
      paramCanvas.rotate(180.0F);
      if (this.mClipToPadding) {
        paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
      } else {
        paramCanvas.translate(-getWidth(), -getHeight());
      }
      localEdgeEffect = this.mBottomGlow;
      i = k;
      if (localEdgeEffect != null)
      {
        i = k;
        if (localEdgeEffect.draw(paramCanvas)) {
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
  
  void ensureBottomGlow()
  {
    if (this.mBottomGlow != null) {
      return;
    }
    this.mBottomGlow = this.mEdgeEffectFactory.createEdgeEffect(this, 3);
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
    this.mLeftGlow = this.mEdgeEffectFactory.createEdgeEffect(this, 0);
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
    this.mRightGlow = this.mEdgeEffectFactory.createEdgeEffect(this, 2);
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
    this.mTopGlow = this.mEdgeEffectFactory.createEdgeEffect(this, 1);
    if (this.mClipToPadding)
    {
      this.mTopGlow.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.mTopGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  String exceptionLabel()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(", adapter:");
    localStringBuilder.append(this.mAdapter);
    localStringBuilder.append(", layout:");
    localStringBuilder.append(this.mLayout);
    localStringBuilder.append(", context:");
    localStringBuilder.append(getContext());
    return localStringBuilder.toString();
  }
  
  final void fillRemainingScrollValues(RecyclerView.State paramState)
  {
    if (getScrollState() == 2)
    {
      OverScroller localOverScroller = this.mViewFlinger.mOverScroller;
      paramState.mRemainingScrollHorizontal = (localOverScroller.getFinalX() - localOverScroller.getCurrX());
      paramState.mRemainingScrollVertical = (localOverScroller.getFinalY() - localOverScroller.getCurrY());
      return;
    }
    paramState.mRemainingScrollHorizontal = 0;
    paramState.mRemainingScrollVertical = 0;
  }
  
  @Nullable
  public View findChildViewUnder(float paramFloat1, float paramFloat2)
  {
    int i = this.mChildHelper.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.mChildHelper.getChildAt(i);
      float f1 = localView.getTranslationX();
      float f2 = localView.getTranslationY();
      if ((paramFloat1 >= localView.getLeft() + f1) && (paramFloat1 <= localView.getRight() + f1) && (paramFloat2 >= localView.getTop() + f2) && (paramFloat2 <= localView.getBottom() + f2)) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  @Nullable
  public View findContainingItemView(@NonNull View paramView)
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
  public RecyclerView.ViewHolder findContainingViewHolder(@NonNull View paramView)
  {
    paramView = findContainingItemView(paramView);
    if (paramView == null) {
      return null;
    }
    return getChildViewHolder(paramView);
  }
  
  @Nullable
  public RecyclerView.ViewHolder findViewHolderForAdapterPosition(int paramInt)
  {
    boolean bool = this.mDataSetHasChangedAfterLayout;
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      Object localObject2 = localObject1;
      if (localViewHolder != null)
      {
        localObject2 = localObject1;
        if (!localViewHolder.isRemoved())
        {
          localObject2 = localObject1;
          if (getAdapterPositionFor(localViewHolder) == paramInt) {
            if (this.mChildHelper.isHidden(localViewHolder.itemView)) {
              localObject2 = localViewHolder;
            } else {
              return localViewHolder;
            }
          }
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public RecyclerView.ViewHolder findViewHolderForItemId(long paramLong)
  {
    Object localObject3 = this.mAdapter;
    Object localObject2 = null;
    Object localObject1 = null;
    if (localObject3 != null)
    {
      if (!((RecyclerView.Adapter)localObject3).hasStableIds()) {
        return null;
      }
      int j = this.mChildHelper.getUnfilteredChildCount();
      int i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= j) {
          break;
        }
        localObject3 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (!((RecyclerView.ViewHolder)localObject3).isRemoved())
          {
            localObject2 = localObject1;
            if (((RecyclerView.ViewHolder)localObject3).getItemId() == paramLong) {
              if (this.mChildHelper.isHidden(((RecyclerView.ViewHolder)localObject3).itemView)) {
                localObject2 = localObject3;
              } else {
                return localObject3;
              }
            }
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    return localObject2;
  }
  
  @Nullable
  public RecyclerView.ViewHolder findViewHolderForLayoutPosition(int paramInt)
  {
    return findViewHolderForPosition(paramInt, false);
  }
  
  @Deprecated
  @Nullable
  public RecyclerView.ViewHolder findViewHolderForPosition(int paramInt)
  {
    return findViewHolderForPosition(paramInt, false);
  }
  
  @Nullable
  RecyclerView.ViewHolder findViewHolderForPosition(int paramInt, boolean paramBoolean)
  {
    int j = this.mChildHelper.getUnfilteredChildCount();
    Object localObject1 = null;
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      Object localObject2 = localObject1;
      if (localViewHolder != null)
      {
        localObject2 = localObject1;
        if (!localViewHolder.isRemoved())
        {
          if (paramBoolean)
          {
            if (localViewHolder.mPosition != paramInt)
            {
              localObject2 = localObject1;
              break label115;
            }
          }
          else if (localViewHolder.getLayoutPosition() != paramInt)
          {
            localObject2 = localObject1;
            break label115;
          }
          if (this.mChildHelper.isHidden(localViewHolder.itemView)) {
            localObject2 = localViewHolder;
          } else {
            return localViewHolder;
          }
        }
      }
      label115:
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    Object localObject = this.mLayout;
    int k = 0;
    if (localObject == null)
    {
      Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return false;
    }
    if (this.mLayoutSuppressed) {
      return false;
    }
    boolean bool2 = ((RecyclerView.LayoutManager)localObject).canScrollHorizontally();
    boolean bool3 = this.mLayout.canScrollVertically();
    int i;
    if (bool2)
    {
      i = paramInt1;
      if (Math.abs(paramInt1) >= this.mMinFlingVelocity) {}
    }
    else
    {
      i = 0;
    }
    int j;
    if (bool3)
    {
      j = paramInt2;
      if (Math.abs(paramInt2) >= this.mMinFlingVelocity) {}
    }
    else
    {
      j = 0;
    }
    if ((i == 0) && (j == 0)) {
      return false;
    }
    float f1 = i;
    float f2 = j;
    if (!dispatchNestedPreFling(f1, f2))
    {
      boolean bool1;
      if ((!bool2) && (!bool3)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      dispatchNestedFling(f1, f2, bool1);
      localObject = this.mOnFlingListener;
      if ((localObject != null) && (((RecyclerView.OnFlingListener)localObject).onFling(i, j))) {
        return true;
      }
      if (bool1)
      {
        paramInt1 = k;
        if (bool2) {
          paramInt1 = 1;
        }
        paramInt2 = paramInt1;
        if (bool3) {
          paramInt2 = paramInt1 | 0x2;
        }
        startNestedScroll(paramInt2, 1);
        paramInt1 = this.mMaxFlingVelocity;
        paramInt1 = Math.max(-paramInt1, Math.min(i, paramInt1));
        paramInt2 = this.mMaxFlingVelocity;
        paramInt2 = Math.max(-paramInt2, Math.min(j, paramInt2));
        this.mViewFlinger.fling(paramInt1, paramInt2);
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
    int i;
    if ((this.mAdapter != null) && (this.mLayout != null) && (!isComputingLayout()) && (!this.mLayoutSuppressed)) {
      i = 1;
    } else {
      i = 0;
    }
    localObject = FocusFinder.getInstance();
    if ((i != 0) && ((paramInt == 2) || (paramInt == 1)))
    {
      int j;
      if (this.mLayout.canScrollVertically())
      {
        if (paramInt == 2) {
          j = 130;
        } else {
          j = 33;
        }
        if (((FocusFinder)localObject).findNextFocus(this, paramView, j) == null) {
          k = 1;
        } else {
          k = 0;
        }
        i = k;
        if (FORCE_ABS_FOCUS_SEARCH_DIRECTION)
        {
          paramInt = j;
          i = k;
        }
      }
      else
      {
        i = 0;
      }
      int m = i;
      int k = paramInt;
      if (i == 0)
      {
        m = i;
        k = paramInt;
        if (this.mLayout.canScrollHorizontally())
        {
          if (this.mLayout.getLayoutDirection() == 1) {
            i = 1;
          } else {
            i = 0;
          }
          if (paramInt == 2) {
            j = 1;
          } else {
            j = 0;
          }
          if ((i ^ j) != 0) {
            i = 66;
          } else {
            i = 17;
          }
          if (((FocusFinder)localObject).findNextFocus(this, paramView, i) == null) {
            j = 1;
          } else {
            j = 0;
          }
          m = j;
          k = paramInt;
          if (FORCE_ABS_FOCUS_SEARCH_DIRECTION)
          {
            k = i;
            m = j;
          }
        }
      }
      if (m != 0)
      {
        consumePendingUpdateOperations();
        if (findContainingItemView(paramView) == null) {
          return null;
        }
        startInterceptRequestLayout();
        this.mLayout.onFocusSearchFailed(paramView, k, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
      }
      localObject = ((FocusFinder)localObject).findNextFocus(this, paramView, k);
      paramInt = k;
    }
    else
    {
      localObject = ((FocusFinder)localObject).findNextFocus(this, paramView, paramInt);
      if ((localObject == null) && (i != 0))
      {
        consumePendingUpdateOperations();
        if (findContainingItemView(paramView) == null) {
          return null;
        }
        startInterceptRequestLayout();
        localObject = this.mLayout.onFocusSearchFailed(paramView, paramInt, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
      }
    }
    if ((localObject != null) && (!((View)localObject).hasFocusable()))
    {
      if (getFocusedChild() == null) {
        return super.focusSearch(paramView, paramInt);
      }
      requestChildOnScreen((View)localObject, null);
      return paramView;
    }
    if (isPreferredNextFocus(paramView, (View)localObject, paramInt)) {
      return localObject;
    }
    return super.focusSearch(paramView, paramInt);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    Object localObject = this.mLayout;
    if (localObject != null) {
      return ((RecyclerView.LayoutManager)localObject).generateDefaultLayoutParams();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("RecyclerView has no LayoutManager");
    ((StringBuilder)localObject).append(exceptionLabel());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      return localLayoutManager.generateLayoutParams(getContext(), paramAttributeSet);
    }
    paramAttributeSet = new StringBuilder();
    paramAttributeSet.append("RecyclerView has no LayoutManager");
    paramAttributeSet.append(exceptionLabel());
    throw new IllegalStateException(paramAttributeSet.toString());
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      return localLayoutManager.generateLayoutParams(paramLayoutParams);
    }
    paramLayoutParams = new StringBuilder();
    paramLayoutParams.append("RecyclerView has no LayoutManager");
    paramLayoutParams.append(exceptionLabel());
    throw new IllegalStateException(paramLayoutParams.toString());
  }
  
  public CharSequence getAccessibilityClassName()
  {
    return "androidx.recyclerview.widget.RecyclerView";
  }
  
  @Nullable
  public RecyclerView.Adapter getAdapter()
  {
    return this.mAdapter;
  }
  
  int getAdapterPositionFor(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((!paramViewHolder.hasAnyOfTheFlags(524)) && (paramViewHolder.isBound())) {
      return this.mAdapterHelper.applyPendingUpdatesToPosition(paramViewHolder.mPosition);
    }
    return -1;
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
  
  public int getChildAdapterPosition(@NonNull View paramView)
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
  
  public long getChildItemId(@NonNull View paramView)
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
  
  public int getChildLayoutPosition(@NonNull View paramView)
  {
    paramView = getChildViewHolderInt(paramView);
    if (paramView != null) {
      return paramView.getLayoutPosition();
    }
    return -1;
  }
  
  @Deprecated
  public int getChildPosition(@NonNull View paramView)
  {
    return getChildAdapterPosition(paramView);
  }
  
  public RecyclerView.ViewHolder getChildViewHolder(@NonNull View paramView)
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
  
  public boolean getClipToPadding()
  {
    return this.mClipToPadding;
  }
  
  @Nullable
  public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate()
  {
    return this.mAccessibilityDelegate;
  }
  
  public void getDecoratedBoundsWithMargins(@NonNull View paramView, @NonNull Rect paramRect)
  {
    getDecoratedBoundsWithMarginsInt(paramView, paramRect);
  }
  
  @NonNull
  public RecyclerView.EdgeEffectFactory getEdgeEffectFactory()
  {
    return this.mEdgeEffectFactory;
  }
  
  @Nullable
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
    if ((this.mState.isPreLayout()) && ((localLayoutParams.isItemChanged()) || (localLayoutParams.isViewInvalid()))) {
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
  
  @NonNull
  public RecyclerView.ItemDecoration getItemDecorationAt(int paramInt)
  {
    int i = getItemDecorationCount();
    if ((paramInt >= 0) && (paramInt < i)) {
      return (RecyclerView.ItemDecoration)this.mItemDecorations.get(paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" is an invalid index for size ");
    localStringBuilder.append(i);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public int getItemDecorationCount()
  {
    return this.mItemDecorations.size();
  }
  
  @Nullable
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
  
  long getNanoTime()
  {
    if (ALLOW_THREAD_GAP_WORK) {
      return System.nanoTime();
    }
    return 0L;
  }
  
  @Nullable
  public RecyclerView.OnFlingListener getOnFlingListener()
  {
    return this.mOnFlingListener;
  }
  
  public boolean getPreserveFocusAfterLayout()
  {
    return this.mPreserveFocusAfterLayout;
  }
  
  @NonNull
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
    return getScrollingChildHelper().hasNestedScrollingParent();
  }
  
  public boolean hasNestedScrollingParent(int paramInt)
  {
    return getScrollingChildHelper().hasNestedScrollingParent(paramInt);
  }
  
  public boolean hasPendingAdapterUpdates()
  {
    return (!this.mFirstLayoutComplete) || (this.mDataSetHasChangedAfterLayout) || (this.mAdapterHelper.hasPendingUpdates());
  }
  
  void initAdapterManager()
  {
    this.mAdapterHelper = new AdapterHelper(new RecyclerView.6(this));
  }
  
  @VisibleForTesting
  void initFastScroller(StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2)
  {
    if ((paramStateListDrawable1 != null) && (paramDrawable1 != null) && (paramStateListDrawable2 != null) && (paramDrawable2 != null))
    {
      Resources localResources = getContext().getResources();
      new FastScroller(this, paramStateListDrawable1, paramDrawable1, paramStateListDrawable2, paramDrawable2, localResources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), localResources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), localResources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
      return;
    }
    paramStateListDrawable1 = new StringBuilder();
    paramStateListDrawable1.append("Trying to set fast scroller without both required drawables.");
    paramStateListDrawable1.append(exceptionLabel());
    throw new IllegalArgumentException(paramStateListDrawable1.toString());
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
  
  @Deprecated
  public boolean isLayoutFrozen()
  {
    return isLayoutSuppressed();
  }
  
  public final boolean isLayoutSuppressed()
  {
    return this.mLayoutSuppressed;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return getScrollingChildHelper().isNestedScrollingEnabled();
  }
  
  void jumpToPositionForSmoothScroller(int paramInt)
  {
    if (this.mLayout == null) {
      return;
    }
    setScrollState(2);
    this.mLayout.scrollToPosition(paramInt);
    awakenScrollBars();
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
  
  public void offsetChildrenHorizontal(@Px int paramInt)
  {
    int j = this.mChildHelper.getChildCount();
    int i = 0;
    while (i < j)
    {
      this.mChildHelper.getChildAt(i).offsetLeftAndRight(paramInt);
      i += 1;
    }
  }
  
  public void offsetChildrenVertical(@Px int paramInt)
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
        this.mState.mStructureChanged = true;
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
        this.mState.mStructureChanged = true;
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
          this.mState.mStructureChanged = true;
        }
        else if (localViewHolder.mPosition >= paramInt1)
        {
          localViewHolder.flagRemovedAndOffsetPosition(paramInt1 - 1, -paramInt2, paramBoolean);
          this.mState.mStructureChanged = true;
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
    boolean bool = true;
    this.mIsAttached = true;
    if ((!this.mFirstLayoutComplete) || (isLayoutRequested())) {
      bool = false;
    }
    this.mFirstLayoutComplete = bool;
    Object localObject = this.mLayout;
    if (localObject != null) {
      ((RecyclerView.LayoutManager)localObject).dispatchAttachedToWindow(this);
    }
    this.mPostedAnimatorRunner = false;
    if (ALLOW_THREAD_GAP_WORK)
    {
      this.mGapWorker = ((GapWorker)GapWorker.sGapWorker.get());
      if (this.mGapWorker == null)
      {
        this.mGapWorker = new GapWorker();
        localObject = ViewCompat.getDisplay(this);
        float f;
        if ((!isInEditMode()) && (localObject != null))
        {
          f = ((Display)localObject).getRefreshRate();
          if (f >= 30.0F) {}
        }
        else
        {
          f = 60.0F;
        }
        this.mGapWorker.mFrameIntervalNs = ((1.0E+009F / f));
        GapWorker.sGapWorker.set(this.mGapWorker);
      }
      this.mGapWorker.add(this);
    }
  }
  
  public void onChildAttachedToWindow(@NonNull View paramView) {}
  
  public void onChildDetachedFromWindow(@NonNull View paramView) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.mItemAnimator;
    if (localObject != null) {
      ((RecyclerView.ItemAnimator)localObject).endAnimations();
    }
    stopScroll();
    this.mIsAttached = false;
    localObject = this.mLayout;
    if (localObject != null) {
      ((RecyclerView.LayoutManager)localObject).dispatchDetachedFromWindow(this, this.mRecycler);
    }
    this.mPendingAccessibilityImportanceChange.clear();
    removeCallbacks(this.mItemAnimatorRunner);
    this.mViewInfoStore.onDetach();
    if (ALLOW_THREAD_GAP_WORK)
    {
      localObject = this.mGapWorker;
      if (localObject != null)
      {
        ((GapWorker)localObject).remove(this);
        this.mGapWorker = null;
      }
    }
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
  
  void onEnterLayoutOrScroll()
  {
    this.mLayoutOrScrollCounter += 1;
  }
  
  void onExitLayoutOrScroll()
  {
    onExitLayoutOrScroll(true);
  }
  
  void onExitLayoutOrScroll(boolean paramBoolean)
  {
    this.mLayoutOrScrollCounter -= 1;
    if (this.mLayoutOrScrollCounter < 1)
    {
      this.mLayoutOrScrollCounter = 0;
      if (paramBoolean)
      {
        dispatchContentChangedIfNecessary();
        dispatchPendingImportantForAccessibilityChanges();
      }
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (this.mLayout == null) {
      return false;
    }
    if (this.mLayoutSuppressed) {
      return false;
    }
    if (paramMotionEvent.getAction() == 8)
    {
      float f1;
      if ((paramMotionEvent.getSource() & 0x2) != 0)
      {
        if (this.mLayout.canScrollVertically()) {
          f2 = -paramMotionEvent.getAxisValue(9);
        } else {
          f2 = 0.0F;
        }
        f1 = f2;
        if (this.mLayout.canScrollHorizontally())
        {
          float f3 = paramMotionEvent.getAxisValue(10);
          f1 = f2;
          f2 = f3;
          break label140;
        }
      }
      else
      {
        if ((paramMotionEvent.getSource() & 0x400000) != 0)
        {
          f2 = paramMotionEvent.getAxisValue(26);
          if (this.mLayout.canScrollVertically())
          {
            f1 = -f2;
            break label138;
          }
          if (this.mLayout.canScrollHorizontally())
          {
            f1 = 0.0F;
            break label140;
          }
        }
        f1 = 0.0F;
      }
      label138:
      float f2 = 0.0F;
      label140:
      if ((f1 != 0.0F) || (f2 != 0.0F)) {
        scrollByInternal((int)(f2 * this.mScaledHorizontalScrollFactor), (int)(f1 * this.mScaledVerticalScrollFactor), paramMotionEvent);
      }
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = this.mLayoutSuppressed;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    this.mInterceptingOnItemTouchListener = null;
    if (findInterceptingOnItemTouchListener(paramMotionEvent))
    {
      cancelScroll();
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
    int j = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
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
              this.mScrollPointerId = paramMotionEvent.getPointerId(i);
              j = (int)(paramMotionEvent.getX(i) + 0.5F);
              this.mLastTouchX = j;
              this.mInitialTouchX = j;
              i = (int)(paramMotionEvent.getY(i) + 0.5F);
              this.mLastTouchY = i;
              this.mInitialTouchY = i;
            }
          }
          else {
            cancelScroll();
          }
        }
        else
        {
          j = paramMotionEvent.findPointerIndex(this.mScrollPointerId);
          if (j < 0)
          {
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("Error processing scroll; pointer index for id ");
            paramMotionEvent.append(this.mScrollPointerId);
            paramMotionEvent.append(" not found. Did any MotionEvents get skipped?");
            Log.e("RecyclerView", paramMotionEvent.toString());
            return false;
          }
          i = (int)(paramMotionEvent.getX(j) + 0.5F);
          int k = (int)(paramMotionEvent.getY(j) + 0.5F);
          if (this.mScrollState != 1)
          {
            j = this.mInitialTouchX;
            int m = this.mInitialTouchY;
            if ((bool2) && (Math.abs(i - j) > this.mTouchSlop))
            {
              this.mLastTouchX = i;
              i = 1;
            }
            else
            {
              i = 0;
            }
            j = i;
            if (bool3)
            {
              j = i;
              if (Math.abs(k - m) > this.mTouchSlop)
              {
                this.mLastTouchY = k;
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
        stopNestedScroll(0);
      }
    }
    else
    {
      if (this.mIgnoreMotionEventTillDown) {
        this.mIgnoreMotionEventTillDown = false;
      }
      this.mScrollPointerId = paramMotionEvent.getPointerId(0);
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
        stopNestedScroll(1);
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
      startNestedScroll(j, 0);
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
    boolean bool = ((RecyclerView.LayoutManager)localObject).isAutoMeasureEnabled();
    int j = 0;
    if (bool)
    {
      int k = View.MeasureSpec.getMode(paramInt1);
      int m = View.MeasureSpec.getMode(paramInt2);
      this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
      int i = j;
      if (k == 1073741824)
      {
        i = j;
        if (m == 1073741824) {
          i = 1;
        }
      }
      if (i == 0)
      {
        if (this.mAdapter == null) {
          return;
        }
        if (this.mState.mLayoutStep == 1) {
          dispatchLayoutStep1();
        }
        this.mLayout.setMeasureSpecs(paramInt1, paramInt2);
        this.mState.mIsMeasuring = true;
        dispatchLayoutStep2();
        this.mLayout.setMeasuredDimensionFromChildren(paramInt1, paramInt2);
        if (!this.mLayout.shouldMeasureTwice()) {
          return;
        }
        this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        this.mState.mIsMeasuring = true;
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
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        onExitLayoutOrScroll();
        if (this.mState.mRunPredictiveAnimations)
        {
          this.mState.mInPreLayout = true;
        }
        else
        {
          this.mAdapterHelper.consumeUpdatesInOnePass();
          this.mState.mInPreLayout = false;
        }
        this.mAdapterUpdateDuringMeasure = false;
        stopInterceptRequestLayout(false);
      }
      else if (this.mState.mRunPredictiveAnimations)
      {
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
        return;
      }
      localObject = this.mAdapter;
      if (localObject != null) {
        this.mState.mItemCount = ((RecyclerView.Adapter)localObject).getItemCount();
      } else {
        this.mState.mItemCount = 0;
      }
      startInterceptRequestLayout();
      this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
      stopInterceptRequestLayout(false);
      this.mState.mInPreLayout = false;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    if (isComputingLayout()) {
      return false;
    }
    return super.onRequestFocusInDescendants(paramInt, paramRect);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof RecyclerView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
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
      localSavedState.copyFrom((RecyclerView.SavedState)localObject);
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
  
  public void onScrolled(@Px int paramInt1, @Px int paramInt2) {}
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      invalidateGlows();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = this.mLayoutSuppressed;
    int i2 = 0;
    if (!bool1)
    {
      if (this.mIgnoreMotionEventTillDown) {
        return false;
      }
      if (dispatchToOnItemTouchListeners(paramMotionEvent))
      {
        cancelScroll();
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
      int j = paramMotionEvent.getActionMasked();
      int i = paramMotionEvent.getActionIndex();
      if (j == 0)
      {
        localObject = this.mNestedOffsets;
        localObject[1] = 0;
        localObject[0] = 0;
      }
      localObject = MotionEvent.obtain(paramMotionEvent);
      int[] arrayOfInt1 = this.mNestedOffsets;
      ((MotionEvent)localObject).offsetLocation(arrayOfInt1[0], arrayOfInt1[1]);
      int n;
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
                  n = i2;
                }
                else
                {
                  onPointerUp(paramMotionEvent);
                  n = i2;
                }
              }
              else
              {
                this.mScrollPointerId = paramMotionEvent.getPointerId(i);
                j = (int)(paramMotionEvent.getX(i) + 0.5F);
                this.mLastTouchX = j;
                this.mInitialTouchX = j;
                i = (int)(paramMotionEvent.getY(i) + 0.5F);
                this.mLastTouchY = i;
                this.mInitialTouchY = i;
                n = i2;
              }
            }
            else
            {
              cancelScroll();
              n = i2;
            }
          }
          else
          {
            i = paramMotionEvent.findPointerIndex(this.mScrollPointerId);
            if (i < 0)
            {
              paramMotionEvent = new StringBuilder();
              paramMotionEvent.append("Error processing scroll; pointer index for id ");
              paramMotionEvent.append(this.mScrollPointerId);
              paramMotionEvent.append(" not found. Did any MotionEvents get skipped?");
              Log.e("RecyclerView", paramMotionEvent.toString());
              return false;
            }
            int i3 = (int)(paramMotionEvent.getX(i) + 0.5F);
            int i4 = (int)(paramMotionEvent.getY(i) + 0.5F);
            i = this.mLastTouchX - i3;
            n = this.mLastTouchY - i4;
            j = i;
            int m = n;
            label458:
            int i1;
            if (this.mScrollState != 1)
            {
              k = i;
              if (bool1)
              {
                if (i > 0) {
                  i = Math.max(0, i - this.mTouchSlop);
                } else {
                  i = Math.min(0, i + this.mTouchSlop);
                }
                k = i;
                if (i != 0)
                {
                  j = 1;
                  break label458;
                }
              }
              j = 0;
              i = k;
              k = n;
              i1 = j;
              if (bool2)
              {
                if (n > 0) {
                  m = Math.max(0, n - this.mTouchSlop);
                } else {
                  m = Math.min(0, n + this.mTouchSlop);
                }
                k = m;
                i1 = j;
                if (m != 0)
                {
                  i1 = 1;
                  k = m;
                }
              }
              j = i;
              m = k;
              if (i1 != 0)
              {
                setScrollState(1);
                m = k;
                j = i;
              }
            }
            int k = j;
            n = i2;
            if (this.mScrollState == 1)
            {
              arrayOfInt1 = this.mReusableIntPair;
              arrayOfInt1[0] = 0;
              arrayOfInt1[1] = 0;
              if (bool1) {
                n = k;
              } else {
                n = 0;
              }
              if (bool2) {
                i1 = m;
              } else {
                i1 = 0;
              }
              j = k;
              i = m;
              if (dispatchNestedPreScroll(n, i1, this.mReusableIntPair, this.mScrollOffset, 0))
              {
                arrayOfInt1 = this.mReusableIntPair;
                j = k - arrayOfInt1[0];
                i = m - arrayOfInt1[1];
                arrayOfInt1 = this.mNestedOffsets;
                k = arrayOfInt1[0];
                int[] arrayOfInt2 = this.mScrollOffset;
                arrayOfInt1[0] = (k + arrayOfInt2[0]);
                arrayOfInt1[1] += arrayOfInt2[1];
                getParent().requestDisallowInterceptTouchEvent(true);
              }
              arrayOfInt1 = this.mScrollOffset;
              this.mLastTouchX = (i3 - arrayOfInt1[0]);
              this.mLastTouchY = (i4 - arrayOfInt1[1]);
              if (bool1) {
                k = j;
              } else {
                k = 0;
              }
              if (bool2) {
                m = i;
              } else {
                m = 0;
              }
              if (scrollByInternal(k, m, paramMotionEvent)) {
                getParent().requestDisallowInterceptTouchEvent(true);
              }
              n = i2;
              if (this.mGapWorker != null) {
                if (j == 0)
                {
                  n = i2;
                  if (i == 0) {}
                }
                else
                {
                  this.mGapWorker.postFromTraversal(this, j, i);
                  n = i2;
                }
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
            f1 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
          } else {
            f1 = 0.0F;
          }
          float f2;
          if (bool2) {
            f2 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);
          } else {
            f2 = 0.0F;
          }
          if (((f1 == 0.0F) && (f2 == 0.0F)) || (!fling((int)f1, (int)f2))) {
            setScrollState(0);
          }
          resetScroll();
          n = 1;
        }
      }
      else
      {
        this.mScrollPointerId = paramMotionEvent.getPointerId(0);
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
        startNestedScroll(j, 0);
        n = i2;
      }
      if (n == 0) {
        this.mVelocityTracker.addMovement((MotionEvent)localObject);
      }
      ((MotionEvent)localObject).recycle();
      return true;
    }
    return false;
  }
  
  void postAnimationRunner()
  {
    if ((!this.mPostedAnimatorRunner) && (this.mIsAttached))
    {
      ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
      this.mPostedAnimatorRunner = true;
    }
  }
  
  void processDataSetCompletelyChanged(boolean paramBoolean)
  {
    this.mDispatchItemsChangedEvent = (paramBoolean | this.mDispatchItemsChangedEvent);
    this.mDataSetHasChangedAfterLayout = true;
    markKnownViewsInvalid();
  }
  
  void recordAnimationInfoIfBouncedHiddenView(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    paramViewHolder.setFlags(0, 8192);
    if ((this.mState.mTrackOldChangeHolders) && (paramViewHolder.isUpdated()) && (!paramViewHolder.isRemoved()) && (!paramViewHolder.shouldIgnore()))
    {
      long l = getChangedHolderKey(paramViewHolder);
      this.mViewInfoStore.addToOldChangeHolders(l, paramViewHolder);
    }
    this.mViewInfoStore.addToPreLayout(paramViewHolder, paramItemHolderInfo);
  }
  
  void removeAndRecycleViews()
  {
    Object localObject = this.mItemAnimator;
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
  
  boolean removeAnimatingView(View paramView)
  {
    startInterceptRequestLayout();
    boolean bool = this.mChildHelper.removeViewIfHidden(paramView);
    if (bool)
    {
      paramView = getChildViewHolderInt(paramView);
      this.mRecycler.unscrapView(paramView);
      this.mRecycler.recycleViewHolderInternal(paramView);
    }
    stopInterceptRequestLayout(bool ^ true);
    return bool;
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
        paramView.append(exceptionLabel());
        throw new IllegalArgumentException(paramView.toString());
      }
    }
    paramView.clearAnimation();
    dispatchChildDetached(paramView);
    super.removeDetachedView(paramView, paramBoolean);
  }
  
  public void removeItemDecoration(@NonNull RecyclerView.ItemDecoration paramItemDecoration)
  {
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      localLayoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
    }
    this.mItemDecorations.remove(paramItemDecoration);
    if (this.mItemDecorations.isEmpty())
    {
      boolean bool;
      if (getOverScrollMode() == 2) {
        bool = true;
      } else {
        bool = false;
      }
      setWillNotDraw(bool);
    }
    markItemDecorInsetsDirty();
    requestLayout();
  }
  
  public void removeItemDecorationAt(int paramInt)
  {
    int i = getItemDecorationCount();
    if ((paramInt >= 0) && (paramInt < i))
    {
      removeItemDecoration(getItemDecorationAt(paramInt));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" is an invalid index for size ");
    localStringBuilder.append(i);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public void removeOnChildAttachStateChangeListener(@NonNull RecyclerView.OnChildAttachStateChangeListener paramOnChildAttachStateChangeListener)
  {
    List localList = this.mOnChildAttachStateListeners;
    if (localList == null) {
      return;
    }
    localList.remove(paramOnChildAttachStateChangeListener);
  }
  
  public void removeOnItemTouchListener(@NonNull RecyclerView.OnItemTouchListener paramOnItemTouchListener)
  {
    this.mOnItemTouchListeners.remove(paramOnItemTouchListener);
    if (this.mInterceptingOnItemTouchListener == paramOnItemTouchListener) {
      this.mInterceptingOnItemTouchListener = null;
    }
  }
  
  public void removeOnScrollListener(@NonNull RecyclerView.OnScrollListener paramOnScrollListener)
  {
    List localList = this.mScrollListeners;
    if (localList != null) {
      localList.remove(paramOnScrollListener);
    }
  }
  
  void repositionShadowingViews()
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
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if ((!this.mLayout.onRequestChildFocus(this, this.mState, paramView1, paramView2)) && (paramView2 != null)) {
      requestChildOnScreen(paramView1, paramView2);
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
    if ((this.mInterceptRequestLayoutDepth == 0) && (!this.mLayoutSuppressed))
    {
      super.requestLayout();
      return;
    }
    this.mLayoutWasDefered = true;
  }
  
  void saveOldPositions()
  {
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      if (!localViewHolder.shouldIgnore()) {
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
    if (this.mLayoutSuppressed) {
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
    boolean bool2 = true;
    int k;
    int m;
    int j;
    int i;
    if (localObject != null)
    {
      localObject = this.mReusableIntPair;
      localObject[0] = 0;
      localObject[1] = 0;
      scrollStep(paramInt1, paramInt2, (int[])localObject);
      localObject = this.mReusableIntPair;
      k = localObject[0];
      m = localObject[1];
      j = m;
      i = k;
      k = paramInt1 - k;
      m = paramInt2 - m;
    }
    else
    {
      i = 0;
      j = 0;
      k = 0;
      m = 0;
    }
    if (!this.mItemDecorations.isEmpty()) {
      invalidate();
    }
    localObject = this.mReusableIntPair;
    localObject[0] = 0;
    localObject[1] = 0;
    dispatchNestedScroll(i, j, k, m, this.mScrollOffset, 0, (int[])localObject);
    localObject = this.mReusableIntPair;
    int i1 = localObject[0];
    int i2 = localObject[1];
    int n;
    if ((localObject[0] == 0) && (localObject[1] == 0)) {
      n = 0;
    } else {
      n = 1;
    }
    int i3 = this.mLastTouchX;
    localObject = this.mScrollOffset;
    this.mLastTouchX = (i3 - localObject[0]);
    this.mLastTouchY -= localObject[1];
    int[] arrayOfInt = this.mNestedOffsets;
    arrayOfInt[0] += localObject[0];
    arrayOfInt[1] += localObject[1];
    if (getOverScrollMode() != 2)
    {
      if ((paramMotionEvent != null) && (!MotionEventCompat.isFromSource(paramMotionEvent, 8194))) {
        pullGlows(paramMotionEvent.getX(), k - i1, paramMotionEvent.getY(), m - i2);
      }
      considerReleasingGlowsOnScroll(paramInt1, paramInt2);
    }
    if ((i != 0) || (j != 0)) {
      dispatchOnScrolled(i, j);
    }
    if (!awakenScrollBars()) {
      invalidate();
    }
    boolean bool1 = bool2;
    if (n == 0)
    {
      bool1 = bool2;
      if (i == 0)
      {
        if (j != 0) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  void scrollStep(int paramInt1, int paramInt2, @Nullable int[] paramArrayOfInt)
  {
    startInterceptRequestLayout();
    onEnterLayoutOrScroll();
    TraceCompat.beginSection("RV Scroll");
    fillRemainingScrollValues(this.mState);
    if (paramInt1 != 0) {
      paramInt1 = this.mLayout.scrollHorizontallyBy(paramInt1, this.mRecycler, this.mState);
    } else {
      paramInt1 = 0;
    }
    if (paramInt2 != 0) {
      paramInt2 = this.mLayout.scrollVerticallyBy(paramInt2, this.mRecycler, this.mState);
    } else {
      paramInt2 = 0;
    }
    TraceCompat.endSection();
    repositionShadowingViews();
    onExitLayoutOrScroll();
    stopInterceptRequestLayout(false);
    if (paramArrayOfInt != null)
    {
      paramArrayOfInt[0] = paramInt1;
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
  }
  
  public void scrollToPosition(int paramInt)
  {
    if (this.mLayoutSuppressed) {
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
  
  public void setAccessibilityDelegateCompat(@Nullable RecyclerViewAccessibilityDelegate paramRecyclerViewAccessibilityDelegate)
  {
    this.mAccessibilityDelegate = paramRecyclerViewAccessibilityDelegate;
    ViewCompat.setAccessibilityDelegate(this, this.mAccessibilityDelegate);
  }
  
  public void setAdapter(@Nullable RecyclerView.Adapter paramAdapter)
  {
    setLayoutFrozen(false);
    setAdapterInternal(paramAdapter, false, true);
    processDataSetCompletelyChanged(false);
    requestLayout();
  }
  
  public void setChildDrawingOrderCallback(@Nullable RecyclerView.ChildDrawingOrderCallback paramChildDrawingOrderCallback)
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
  
  @VisibleForTesting
  boolean setChildImportantForAccessibilityInternal(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (isComputingLayout())
    {
      paramViewHolder.mPendingAccessibilityState = paramInt;
      this.mPendingAccessibilityImportanceChange.add(paramViewHolder);
      return false;
    }
    ViewCompat.setImportantForAccessibility(paramViewHolder.itemView, paramInt);
    return true;
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
  
  public void setEdgeEffectFactory(@NonNull RecyclerView.EdgeEffectFactory paramEdgeEffectFactory)
  {
    Preconditions.checkNotNull(paramEdgeEffectFactory);
    this.mEdgeEffectFactory = paramEdgeEffectFactory;
    invalidateGlows();
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    this.mHasFixedSize = paramBoolean;
  }
  
  public void setItemAnimator(@Nullable RecyclerView.ItemAnimator paramItemAnimator)
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
  
  @Deprecated
  public void setLayoutFrozen(boolean paramBoolean)
  {
    suppressLayout(paramBoolean);
  }
  
  public void setLayoutManager(@Nullable RecyclerView.LayoutManager paramLayoutManager)
  {
    if (paramLayoutManager == this.mLayout) {
      return;
    }
    stopScroll();
    Object localObject;
    if (this.mLayout != null)
    {
      localObject = this.mItemAnimator;
      if (localObject != null) {
        ((RecyclerView.ItemAnimator)localObject).endAnimations();
      }
      this.mLayout.removeAndRecycleAllViews(this.mRecycler);
      this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
      this.mRecycler.clear();
      if (this.mIsAttached) {
        this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
      }
      this.mLayout.setRecyclerView(null);
      this.mLayout = null;
    }
    else
    {
      this.mRecycler.clear();
    }
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
        ((StringBuilder)localObject).append(" is already attached to a RecyclerView:");
        ((StringBuilder)localObject).append(paramLayoutManager.mRecyclerView.exceptionLabel());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    this.mRecycler.updateViewCacheSize();
    requestLayout();
  }
  
  @Deprecated
  public void setLayoutTransition(LayoutTransition paramLayoutTransition)
  {
    if (Build.VERSION.SDK_INT < 18)
    {
      if (paramLayoutTransition == null)
      {
        suppressLayout(false);
        return;
      }
      if ((paramLayoutTransition.getAnimator(0) == null) && (paramLayoutTransition.getAnimator(1) == null) && (paramLayoutTransition.getAnimator(2) == null) && (paramLayoutTransition.getAnimator(3) == null) && (paramLayoutTransition.getAnimator(4) == null))
      {
        suppressLayout(true);
        return;
      }
    }
    if (paramLayoutTransition == null)
    {
      super.setLayoutTransition(null);
      return;
    }
    throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    getScrollingChildHelper().setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnFlingListener(@Nullable RecyclerView.OnFlingListener paramOnFlingListener)
  {
    this.mOnFlingListener = paramOnFlingListener;
  }
  
  @Deprecated
  public void setOnScrollListener(@Nullable RecyclerView.OnScrollListener paramOnScrollListener)
  {
    this.mScrollListener = paramOnScrollListener;
  }
  
  public void setPreserveFocusAfterLayout(boolean paramBoolean)
  {
    this.mPreserveFocusAfterLayout = paramBoolean;
  }
  
  public void setRecycledViewPool(@Nullable RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    this.mRecycler.setRecycledViewPool(paramRecycledViewPool);
  }
  
  public void setRecyclerListener(@Nullable RecyclerView.RecyclerListener paramRecyclerListener)
  {
    this.mRecyclerListener = paramRecyclerListener;
  }
  
  void setScrollState(int paramInt)
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
        this.mTouchSlop = localViewConfiguration.getScaledPagingTouchSlop();
        return;
      }
    }
    this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
  }
  
  public void setViewCacheExtension(@Nullable RecyclerView.ViewCacheExtension paramViewCacheExtension)
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
  
  public void smoothScrollBy(@Px int paramInt1, @Px int paramInt2)
  {
    smoothScrollBy(paramInt1, paramInt2, null);
  }
  
  public void smoothScrollBy(@Px int paramInt1, @Px int paramInt2, @Nullable Interpolator paramInterpolator)
  {
    smoothScrollBy(paramInt1, paramInt2, paramInterpolator, -2147483648);
  }
  
  public void smoothScrollBy(@Px int paramInt1, @Px int paramInt2, @Nullable Interpolator paramInterpolator, int paramInt3)
  {
    smoothScrollBy(paramInt1, paramInt2, paramInterpolator, paramInt3, false);
  }
  
  void smoothScrollBy(@Px int paramInt1, @Px int paramInt2, @Nullable Interpolator paramInterpolator, int paramInt3, boolean paramBoolean)
  {
    RecyclerView.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager == null)
    {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    if (this.mLayoutSuppressed) {
      return;
    }
    boolean bool = localLayoutManager.canScrollHorizontally();
    int j = 0;
    int i = paramInt1;
    if (!bool) {
      i = 0;
    }
    if (!this.mLayout.canScrollVertically()) {
      paramInt2 = 0;
    }
    if ((i != 0) || (paramInt2 != 0))
    {
      if ((paramInt3 != -2147483648) && (paramInt3 <= 0)) {
        paramInt1 = 0;
      } else {
        paramInt1 = 1;
      }
      if (paramInt1 != 0)
      {
        if (paramBoolean)
        {
          paramInt1 = j;
          if (i != 0) {
            paramInt1 = 1;
          }
          j = paramInt1;
          if (paramInt2 != 0) {
            j = paramInt1 | 0x2;
          }
          startNestedScroll(j, 1);
        }
        this.mViewFlinger.smoothScrollBy(i, paramInt2, paramInt3, paramInterpolator);
        return;
      }
      scrollBy(i, paramInt2);
    }
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    if (this.mLayoutSuppressed) {
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
  
  void startInterceptRequestLayout()
  {
    this.mInterceptRequestLayoutDepth += 1;
    if ((this.mInterceptRequestLayoutDepth == 1) && (!this.mLayoutSuppressed)) {
      this.mLayoutWasDefered = false;
    }
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return getScrollingChildHelper().startNestedScroll(paramInt);
  }
  
  public boolean startNestedScroll(int paramInt1, int paramInt2)
  {
    return getScrollingChildHelper().startNestedScroll(paramInt1, paramInt2);
  }
  
  void stopInterceptRequestLayout(boolean paramBoolean)
  {
    if (this.mInterceptRequestLayoutDepth < 1) {
      this.mInterceptRequestLayoutDepth = 1;
    }
    if ((!paramBoolean) && (!this.mLayoutSuppressed)) {
      this.mLayoutWasDefered = false;
    }
    if (this.mInterceptRequestLayoutDepth == 1)
    {
      if ((paramBoolean) && (this.mLayoutWasDefered) && (!this.mLayoutSuppressed) && (this.mLayout != null) && (this.mAdapter != null)) {
        dispatchLayout();
      }
      if (!this.mLayoutSuppressed) {
        this.mLayoutWasDefered = false;
      }
    }
    this.mInterceptRequestLayoutDepth -= 1;
  }
  
  public void stopNestedScroll()
  {
    getScrollingChildHelper().stopNestedScroll();
  }
  
  public void stopNestedScroll(int paramInt)
  {
    getScrollingChildHelper().stopNestedScroll(paramInt);
  }
  
  public void stopScroll()
  {
    setScrollState(0);
    stopScrollersInternal();
  }
  
  public final void suppressLayout(boolean paramBoolean)
  {
    if (paramBoolean != this.mLayoutSuppressed)
    {
      assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
      if (!paramBoolean)
      {
        this.mLayoutSuppressed = false;
        if ((this.mLayoutWasDefered) && (this.mLayout != null) && (this.mAdapter != null)) {
          requestLayout();
        }
        this.mLayoutWasDefered = false;
        return;
      }
      long l = SystemClock.uptimeMillis();
      onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
      this.mLayoutSuppressed = true;
      this.mIgnoreMotionEventTillDown = true;
      stopScroll();
    }
  }
  
  public void swapAdapter(@Nullable RecyclerView.Adapter paramAdapter, boolean paramBoolean)
  {
    setLayoutFrozen(false);
    setAdapterInternal(paramAdapter, true, paramBoolean);
    processDataSetCompletelyChanged(true);
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
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView
 * JD-Core Version:    0.7.0.1
 */