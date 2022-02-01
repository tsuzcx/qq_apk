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
import f;
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
  private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
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
  static final Interpolator sQuinticInterpolator;
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
  private boolean mPreserveFocusAfterLayout = true;
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
  final RecyclerView.ViewFlinger mViewFlinger = new RecyclerView.ViewFlinger(this);
  private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
  final ViewInfoStore mViewInfoStore = new ViewInfoStore();
  
  static
  {
    if ((Build.VERSION.SDK_INT == 18) || (Build.VERSION.SDK_INT == 19) || (Build.VERSION.SDK_INT == 20))
    {
      bool = true;
      FORCE_INVALIDATE_DISPLAY_LIST = bool;
      if (Build.VERSION.SDK_INT < 23) {
        break label156;
      }
      bool = true;
      label51:
      ALLOW_SIZE_IN_UNSPECIFIED_SPEC = bool;
      if (Build.VERSION.SDK_INT < 16) {
        break label161;
      }
      bool = true;
      label65:
      POST_UPDATES_ON_ANIMATION = bool;
      if (Build.VERSION.SDK_INT < 21) {
        break label166;
      }
      bool = true;
      label79:
      ALLOW_THREAD_GAP_WORK = bool;
      if (Build.VERSION.SDK_INT > 15) {
        break label171;
      }
      bool = true;
      label93:
      FORCE_ABS_FOCUS_SEARCH_DIRECTION = bool;
      if (Build.VERSION.SDK_INT > 15) {
        break label176;
      }
    }
    label156:
    label161:
    label166:
    label171:
    label176:
    for (boolean bool = true;; bool = false)
    {
      IGNORE_DETACHED_FOCUSED_CHILD = bool;
      LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[] { Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE };
      sQuinticInterpolator = new RecyclerView.3();
      return;
      bool = false;
      break;
      bool = false;
      break label51;
      bool = false;
      break label65;
      bool = false;
      break label79;
      bool = false;
      break label93;
    }
  }
  
  public RecyclerView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RecyclerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131034899);
  }
  
  public RecyclerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject;
    if (ALLOW_THREAD_GAP_WORK)
    {
      localObject = new GapWorker.LayoutPrefetchRegistryImpl();
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
      localObject = ViewConfiguration.get(paramContext);
      this.mTouchSlop = ((ViewConfiguration)localObject).getScaledTouchSlop();
      this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor((ViewConfiguration)localObject, paramContext);
      this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor((ViewConfiguration)localObject, paramContext);
      this.mMinFlingVelocity = ((ViewConfiguration)localObject).getScaledMinimumFlingVelocity();
      this.mMaxFlingVelocity = ((ViewConfiguration)localObject).getScaledMaximumFlingVelocity();
      if (getOverScrollMode() != 2) {
        break label691;
      }
    }
    label691:
    for (boolean bool1 = true;; bool1 = false)
    {
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
      localObject = paramContext.obtainStyledAttributes(paramAttributeSet, f.jdField_f_of_type_ArrayOfInt, paramInt, 0);
      if (Build.VERSION.SDK_INT >= 29) {
        saveAttributeDataForStyleable(paramContext, f.jdField_f_of_type_ArrayOfInt, paramAttributeSet, (TypedArray)localObject, paramInt, 0);
      }
      String str = ((TypedArray)localObject).getString(f.i);
      if (((TypedArray)localObject).getInt(f.c, -1) == -1) {
        setDescendantFocusability(262144);
      }
      this.mClipToPadding = ((TypedArray)localObject).getBoolean(f.b, true);
      this.mEnableFastScroller = ((TypedArray)localObject).getBoolean(f.d, false);
      if (this.mEnableFastScroller) {
        initFastScroller((StateListDrawable)((TypedArray)localObject).getDrawable(f.g), ((TypedArray)localObject).getDrawable(f.h), (StateListDrawable)((TypedArray)localObject).getDrawable(f.e), ((TypedArray)localObject).getDrawable(f.jdField_f_of_type_Int));
      }
      ((TypedArray)localObject).recycle();
      createLayoutManager(paramContext, str, paramAttributeSet, paramInt, 0);
      bool1 = bool2;
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
      return;
      localObject = null;
      break;
    }
  }
  
  private void addAnimatingView(RecyclerView.ViewHolder paramViewHolder)
  {
    View localView = paramViewHolder.itemView;
    if (localView.getParent() == this) {}
    for (int i = 1;; i = 0)
    {
      this.mRecycler.unscrapView(getChildViewHolder(localView));
      if (!paramViewHolder.isTmpDetached()) {
        break;
      }
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
    Object localObject;
    if (paramViewHolder.mNestedRecyclerView != null) {
      localObject = (View)paramViewHolder.mNestedRecyclerView.get();
    }
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
          if (isInEditMode()) {}
          Class localClass;
          for (paramString = getClass().getClassLoader();; paramString = paramContext.getClassLoader())
          {
            localClass = Class.forName(str, false, paramString).asSubclass(RecyclerView.LayoutManager.class);
            try
            {
              paramString = localClass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
              Object[] arrayOfObject = new Object[4];
              arrayOfObject[0] = paramContext;
              arrayOfObject[1] = paramAttributeSet;
              arrayOfObject[2] = Integer.valueOf(paramInt1);
              arrayOfObject[3] = Integer.valueOf(paramInt2);
              paramContext = arrayOfObject;
            }
            catch (NoSuchMethodException paramContext)
            {
              try
              {
                paramString = localClass.getConstructor(new Class[0]);
                paramContext = null;
              }
              catch (NoSuchMethodException paramString)
              {
                paramString.initCause(paramContext);
                throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, paramString);
              }
            }
            paramString.setAccessible(true);
            setLayoutManager((RecyclerView.LayoutManager)paramString.newInstance(paramContext));
            return;
          }
          return;
        }
        catch (ClassNotFoundException paramContext)
        {
          throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, paramContext);
        }
        catch (InvocationTargetException paramContext)
        {
          throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, paramContext);
        }
        catch (InstantiationException paramContext)
        {
          throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, paramContext);
        }
        catch (IllegalAccessException paramContext)
        {
          throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, paramContext);
        }
        catch (ClassCastException paramContext)
        {
          throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, paramContext);
        }
      }
    }
  }
  
  private boolean didChildRangeChange(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
    if ((this.mMinMaxLayoutPositions[0] != paramInt1) || (this.mMinMaxLayoutPositions[1] != paramInt2)) {
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
    boolean bool = true;
    this.mState.assertLayoutStep(1);
    fillRemainingScrollValues(this.mState);
    this.mState.mIsMeasuring = false;
    startInterceptRequestLayout();
    this.mViewInfoStore.clear();
    onEnterLayoutOrScroll();
    processAdapterUpdatesAndSetAnimationFlags();
    saveFocusInfo();
    Object localObject = this.mState;
    int j;
    int i;
    if ((this.mState.mRunSimpleAnimations) && (this.mItemsChanged))
    {
      ((RecyclerView.State)localObject).mTrackOldChangeHolders = bool;
      this.mItemsChanged = false;
      this.mItemsAddedOrRemoved = false;
      this.mState.mInPreLayout = this.mState.mRunPredictiveAnimations;
      this.mState.mItemCount = this.mAdapter.getItemCount();
      findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
      if (!this.mState.mRunSimpleAnimations) {
        break label303;
      }
      j = this.mChildHelper.getChildCount();
      i = 0;
      label146:
      if (i >= j) {
        break label303;
      }
      localObject = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
      if ((!((RecyclerView.ViewHolder)localObject).shouldIgnore()) && ((!((RecyclerView.ViewHolder)localObject).isInvalid()) || (this.mAdapter.hasStableIds()))) {
        break label203;
      }
    }
    label203:
    RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo;
    for (;;)
    {
      i += 1;
      break label146;
      bool = false;
      break;
      localItemHolderInfo = this.mItemAnimator.recordPreLayoutInformation(this.mState, (RecyclerView.ViewHolder)localObject, RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations((RecyclerView.ViewHolder)localObject), ((RecyclerView.ViewHolder)localObject).getUnmodifiedPayloads());
      this.mViewInfoStore.addToPreLayout((RecyclerView.ViewHolder)localObject, localItemHolderInfo);
      if ((this.mState.mTrackOldChangeHolders) && (((RecyclerView.ViewHolder)localObject).isUpdated()) && (!((RecyclerView.ViewHolder)localObject).isRemoved()) && (!((RecyclerView.ViewHolder)localObject).shouldIgnore()) && (!((RecyclerView.ViewHolder)localObject).isInvalid()))
      {
        long l = getChangedHolderKey((RecyclerView.ViewHolder)localObject);
        this.mViewInfoStore.addToOldChangeHolders(l, (RecyclerView.ViewHolder)localObject);
      }
    }
    label303:
    if (this.mState.mRunPredictiveAnimations)
    {
      saveOldPositions();
      bool = this.mState.mStructureChanged;
      this.mState.mStructureChanged = false;
      this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
      this.mState.mStructureChanged = bool;
      i = 0;
      if (i < this.mChildHelper.getChildCount())
      {
        localObject = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
        if (((RecyclerView.ViewHolder)localObject).shouldIgnore()) {}
        for (;;)
        {
          i += 1;
          break;
          if (!this.mViewInfoStore.isInPreLayout((RecyclerView.ViewHolder)localObject))
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
        }
      }
      clearOldPositions();
    }
    for (;;)
    {
      onExitLayoutOrScroll();
      stopInterceptRequestLayout(false);
      this.mState.mLayoutStep = 2;
      return;
      clearOldPositions();
    }
  }
  
  private void dispatchLayoutStep2()
  {
    startInterceptRequestLayout();
    onEnterLayoutOrScroll();
    this.mState.assertLayoutStep(6);
    this.mAdapterHelper.consumeUpdatesInOnePass();
    this.mState.mItemCount = this.mAdapter.getItemCount();
    this.mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
    this.mState.mInPreLayout = false;
    this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
    this.mState.mStructureChanged = false;
    this.mPendingSavedState = null;
    RecyclerView.State localState = this.mState;
    if ((this.mState.mRunSimpleAnimations) && (this.mItemAnimator != null)) {}
    for (boolean bool = true;; bool = false)
    {
      localState.mRunSimpleAnimations = bool;
      this.mState.mLayoutStep = 4;
      onExitLayoutOrScroll();
      stopInterceptRequestLayout(false);
      return;
    }
  }
  
  private void dispatchLayoutStep3()
  {
    this.mState.assertLayoutStep(4);
    startInterceptRequestLayout();
    onEnterLayoutOrScroll();
    this.mState.mLayoutStep = 1;
    if (this.mState.mRunSimpleAnimations)
    {
      int i = this.mChildHelper.getChildCount() - 1;
      if (i >= 0)
      {
        RecyclerView.ViewHolder localViewHolder1 = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
        if (localViewHolder1.shouldIgnore()) {}
        for (;;)
        {
          i -= 1;
          break;
          long l = getChangedHolderKey(localViewHolder1);
          RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo2 = this.mItemAnimator.recordPostLayoutInformation(this.mState, localViewHolder1);
          RecyclerView.ViewHolder localViewHolder2 = this.mViewInfoStore.getFromOldChangeHolders(l);
          if ((localViewHolder2 != null) && (!localViewHolder2.shouldIgnore()))
          {
            boolean bool1 = this.mViewInfoStore.isDisappearing(localViewHolder2);
            boolean bool2 = this.mViewInfoStore.isDisappearing(localViewHolder1);
            if ((bool1) && (localViewHolder2 == localViewHolder1))
            {
              this.mViewInfoStore.addToPostLayout(localViewHolder1, localItemHolderInfo2);
            }
            else
            {
              RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo1 = this.mViewInfoStore.popFromPreLayout(localViewHolder2);
              this.mViewInfoStore.addToPostLayout(localViewHolder1, localItemHolderInfo2);
              localItemHolderInfo2 = this.mViewInfoStore.popFromPostLayout(localViewHolder1);
              if (localItemHolderInfo1 == null) {
                handleMissingPreInfoForChangeError(l, localViewHolder1, localViewHolder2);
              } else {
                animateChange(localViewHolder2, localViewHolder1, localItemHolderInfo1, localItemHolderInfo2, bool1, bool2);
              }
            }
          }
          else
          {
            this.mViewInfoStore.addToPostLayout(localViewHolder1, localItemHolderInfo2);
          }
        }
      }
      this.mViewInfoStore.process(this.mViewInfoProcessCallback);
    }
    this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
    this.mState.mPreviousLayoutItemCount = this.mState.mItemCount;
    this.mDataSetHasChangedAfterLayout = false;
    this.mDispatchItemsChangedEvent = false;
    this.mState.mRunSimpleAnimations = false;
    this.mState.mRunPredictiveAnimations = false;
    this.mLayout.mRequestedSimpleAnimations = false;
    if (this.mRecycler.mChangedScrap != null) {
      this.mRecycler.mChangedScrap.clear();
    }
    if (this.mLayout.mPrefetchMaxObservedInInitialPrefetch)
    {
      this.mLayout.mPrefetchMaxCountObserved = 0;
      this.mLayout.mPrefetchMaxObservedInInitialPrefetch = false;
      this.mRecycler.updateViewCacheSize();
    }
    this.mLayout.onLayoutCompleted(this.mState);
    onExitLayoutOrScroll();
    stopInterceptRequestLayout(false);
    this.mViewInfoStore.clear();
    if (didChildRangeChange(this.mMinMaxLayoutPositions[0], this.mMinMaxLayoutPositions[1])) {
      dispatchOnScrolled(0, 0);
    }
    recoverFocusFromState();
    resetFocusInfo();
  }
  
  private boolean dispatchToOnItemTouchListeners(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (this.mInterceptingOnItemTouchListener == null) {
      if (paramMotionEvent.getAction() == 0) {
        bool = false;
      }
    }
    int i;
    do
    {
      return bool;
      return findInterceptingOnItemTouchListener(paramMotionEvent);
      this.mInterceptingOnItemTouchListener.onTouchEvent(this, paramMotionEvent);
      i = paramMotionEvent.getAction();
    } while ((i != 3) && (i != 1));
    this.mInterceptingOnItemTouchListener = null;
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
    int i1 = this.mChildHelper.getChildCount();
    if (i1 == 0)
    {
      paramArrayOfInt[0] = -1;
      paramArrayOfInt[1] = -1;
      return;
    }
    int i = 2147483647;
    int m = -2147483648;
    int k = 0;
    RecyclerView.ViewHolder localViewHolder;
    if (k < i1)
    {
      localViewHolder = getChildViewHolderInt(this.mChildHelper.getChildAt(k));
      if (!localViewHolder.shouldIgnore()) {}
    }
    for (;;)
    {
      k += 1;
      break;
      int n = localViewHolder.getLayoutPosition();
      int j = i;
      if (n < i) {
        j = n;
      }
      if (n > m)
      {
        m = n;
        i = j;
        continue;
        paramArrayOfInt[0] = i;
        paramArrayOfInt[1] = m;
      }
      else
      {
        i = j;
      }
    }
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
    int i;
    int j;
    label29:
    RecyclerView.ViewHolder localViewHolder;
    if (this.mState.mFocusedItemPosition != -1)
    {
      i = this.mState.mFocusedItemPosition;
      int k = this.mState.getItemCount();
      j = i;
      if (j < k)
      {
        localViewHolder = findViewHolderForAdapterPosition(j);
        if (localViewHolder != null) {
          break label77;
        }
      }
      i = Math.min(k, i) - 1;
    }
    for (;;)
    {
      if (i < 0) {
        break label125;
      }
      localViewHolder = findViewHolderForAdapterPosition(i);
      if (localViewHolder == null)
      {
        return null;
        i = 0;
        break;
        label77:
        if (localViewHolder.itemView.hasFocusable()) {
          return localViewHolder.itemView;
        }
        j += 1;
        break label29;
      }
      if (localViewHolder.itemView.hasFocusable()) {
        return localViewHolder.itemView;
      }
      i -= 1;
    }
    label125:
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
    int i = paramView.getLeft();
    int j = localRect.left;
    int k = localLayoutParams.leftMargin;
    int m = paramView.getTop();
    int n = localRect.top;
    int i1 = localLayoutParams.topMargin;
    int i2 = paramView.getRight();
    int i3 = localRect.right;
    int i4 = localLayoutParams.rightMargin;
    int i5 = paramView.getBottom();
    int i6 = localRect.bottom;
    paramRect.set(i - j - k, m - n - i1, i2 + i3 + i4, localLayoutParams.bottomMargin + (i6 + i5));
  }
  
  private int getDeepestFocusedViewWithId(View paramView)
  {
    int i = paramView.getId();
    if ((!paramView.isFocused()) && ((paramView instanceof ViewGroup)) && (paramView.hasFocus()))
    {
      paramView = ((ViewGroup)paramView).getFocusedChild();
      if (paramView.getId() == -1) {
        break label52;
      }
      i = paramView.getId();
    }
    label52:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private String getFullClassName(Context paramContext, String paramString)
  {
    if (paramString.charAt(0) == '.') {
      paramContext = paramContext.getPackageName() + paramString;
    }
    do
    {
      return paramContext;
      paramContext = paramString;
    } while (paramString.contains("."));
    return RecyclerView.class.getPackage().getName() + '.' + paramString;
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
    if (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
      if (localViewHolder == paramViewHolder1) {}
      while (getChangedHolderKey(localViewHolder) != paramLong)
      {
        i += 1;
        break;
      }
      if ((this.mAdapter != null) && (this.mAdapter.hasStableIds())) {
        throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + localViewHolder + " \n View Holder 2:" + paramViewHolder1 + exceptionLabel());
      }
      throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + localViewHolder + " \n View Holder 2:" + paramViewHolder1 + exceptionLabel());
    }
    Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + paramViewHolder2 + " cannot be found but it is necessary for " + paramViewHolder1 + exceptionLabel());
  }
  
  private boolean hasUpdatedView()
  {
    boolean bool2 = false;
    int j = this.mChildHelper.getChildCount();
    int i = 0;
    boolean bool1 = bool2;
    if (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
      if ((localViewHolder == null) || (localViewHolder.shouldIgnore())) {}
      while (!localViewHolder.isUpdated())
      {
        i += 1;
        break;
      }
      bool1 = true;
    }
    return bool1;
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
    int j = -1;
    boolean bool4 = true;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1;
    if ((paramView2 == null) || (paramView2 == this)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        if (findContainingItemView(paramView2) == null) {
          return false;
        }
        bool1 = bool4;
      } while (paramView1 == null);
      bool1 = bool4;
    } while (findContainingItemView(paramView1) == null);
    this.mTempRect.set(0, 0, paramView1.getWidth(), paramView1.getHeight());
    this.mTempRect2.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
    offsetDescendantRectToMyCoords(paramView1, this.mTempRect);
    offsetDescendantRectToMyCoords(paramView2, this.mTempRect2);
    int k;
    label123:
    int i;
    if (this.mLayout.getLayoutDirection() == 1)
    {
      k = -1;
      if (((this.mTempRect.left >= this.mTempRect2.left) && (this.mTempRect.right > this.mTempRect2.left)) || (this.mTempRect.right >= this.mTempRect2.right)) {
        break label333;
      }
      i = 1;
    }
    for (;;)
    {
      label177:
      if (((this.mTempRect.top < this.mTempRect2.top) || (this.mTempRect.bottom <= this.mTempRect2.top)) && (this.mTempRect.bottom < this.mTempRect2.bottom)) {}
      for (j = 1;; j = 0) {
        label333:
        do
        {
          switch (paramInt)
          {
          default: 
            throw new IllegalArgumentException("Invalid direction: " + paramInt + exceptionLabel());
            k = 1;
            break label123;
            if (((this.mTempRect.right <= this.mTempRect2.right) && (this.mTempRect.left < this.mTempRect2.right)) || (this.mTempRect.left <= this.mTempRect2.left)) {
              break label555;
            }
            i = -1;
            break label177;
          }
        } while (((this.mTempRect.bottom > this.mTempRect2.bottom) || (this.mTempRect.top >= this.mTempRect2.bottom)) && (this.mTempRect.top > this.mTempRect2.top));
      }
      bool1 = bool4;
      if (i < 0) {
        break;
      }
      return false;
      bool1 = bool4;
      if (i > 0) {
        break;
      }
      return false;
      bool1 = bool4;
      if (j < 0) {
        break;
      }
      return false;
      bool1 = bool4;
      if (j > 0) {
        break;
      }
      return false;
      if (j <= 0)
      {
        bool1 = bool2;
        if (j == 0)
        {
          bool1 = bool2;
          if (k * i < 0) {}
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      if (j >= 0)
      {
        bool1 = bool3;
        if (j == 0)
        {
          bool1 = bool3;
          if (k * i > 0) {}
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      label555:
      i = 0;
    }
  }
  
  private void onPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mScrollPointerId) {
      if (i != 0) {
        break label75;
      }
    }
    label75:
    for (i = 1;; i = 0)
    {
      this.mScrollPointerId = paramMotionEvent.getPointerId(i);
      int j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.mLastTouchX = j;
      this.mInitialTouchX = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.mLastTouchY = i;
      this.mInitialTouchY = i;
      return;
    }
  }
  
  private boolean predictiveItemAnimationsEnabled()
  {
    return (this.mItemAnimator != null) && (this.mLayout.supportsPredictiveItemAnimations());
  }
  
  private void processAdapterUpdatesAndSetAnimationFlags()
  {
    boolean bool2 = true;
    if (this.mDataSetHasChangedAfterLayout)
    {
      this.mAdapterHelper.reset();
      if (this.mDispatchItemsChangedEvent) {
        this.mLayout.onItemsChanged(this);
      }
    }
    int i;
    label61:
    RecyclerView.State localState;
    if (predictiveItemAnimationsEnabled())
    {
      this.mAdapterHelper.preProcess();
      if ((!this.mItemsAddedOrRemoved) && (!this.mItemsChanged)) {
        break label180;
      }
      i = 1;
      localState = this.mState;
      if ((!this.mFirstLayoutComplete) || (this.mItemAnimator == null) || ((!this.mDataSetHasChangedAfterLayout) && (i == 0) && (!this.mLayout.mRequestedSimpleAnimations)) || ((this.mDataSetHasChangedAfterLayout) && (!this.mAdapter.hasStableIds()))) {
        break label185;
      }
      bool1 = true;
      label121:
      localState.mRunSimpleAnimations = bool1;
      localState = this.mState;
      if ((!this.mState.mRunSimpleAnimations) || (i == 0) || (this.mDataSetHasChangedAfterLayout) || (!predictiveItemAnimationsEnabled())) {
        break label190;
      }
    }
    label180:
    label185:
    label190:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localState.mRunPredictiveAnimations = bool1;
      return;
      this.mAdapterHelper.consumeUpdatesInOnePass();
      break;
      i = 0;
      break label61;
      bool1 = false;
      break label121;
    }
  }
  
  private void pullGlows(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int j = 1;
    int i = 0;
    if (paramFloat2 < 0.0F)
    {
      ensureLeftGlow();
      EdgeEffectCompat.onPull(this.mLeftGlow, -paramFloat2 / getWidth(), 1.0F - paramFloat3 / getHeight());
      i = 1;
      if (paramFloat4 >= 0.0F) {
        break label141;
      }
      ensureTopGlow();
      EdgeEffectCompat.onPull(this.mTopGlow, -paramFloat4 / getHeight(), paramFloat1 / getWidth());
      i = j;
    }
    for (;;)
    {
      if ((i != 0) || (paramFloat2 != 0.0F) || (paramFloat4 != 0.0F)) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return;
      if (paramFloat2 <= 0.0F) {
        break;
      }
      ensureRightGlow();
      EdgeEffectCompat.onPull(this.mRightGlow, paramFloat2 / getWidth(), paramFloat3 / getHeight());
      i = 1;
      break;
      label141:
      if (paramFloat4 > 0.0F)
      {
        ensureBottomGlow();
        EdgeEffectCompat.onPull(this.mBottomGlow, paramFloat4 / getHeight(), 1.0F - paramFloat1 / getWidth());
        i = j;
      }
    }
  }
  
  private void recoverFocusFromState()
  {
    View localView = null;
    if ((!this.mPreserveFocusAfterLayout) || (this.mAdapter == null) || (!hasFocus()) || (getDescendantFocusability() == 393216) || ((getDescendantFocusability() == 131072) && (isFocused()))) {}
    do
    {
      return;
      if (isFocused()) {
        break;
      }
      localObject = getFocusedChild();
      if ((IGNORE_DETACHED_FOCUSED_CHILD) && ((((View)localObject).getParent() == null) || (!((View)localObject).hasFocus())))
      {
        if (this.mChildHelper.getChildCount() != 0) {
          break;
        }
        requestFocus();
        return;
      }
    } while (!this.mChildHelper.isHidden((View)localObject));
    if ((this.mState.mFocusedItemId != -1L) && (this.mAdapter.hasStableIds())) {}
    for (Object localObject = findViewHolderForItemId(this.mState.mFocusedItemId);; localObject = null)
    {
      if ((localObject == null) || (this.mChildHelper.isHidden(((RecyclerView.ViewHolder)localObject).itemView)) || (!((RecyclerView.ViewHolder)localObject).itemView.hasFocusable()))
      {
        localObject = localView;
        if (this.mChildHelper.getChildCount() > 0) {
          localObject = findNextViewToFocus();
        }
        label191:
        if (localObject == null) {
          break label247;
        }
        if (this.mState.mFocusedSubChildId == -1L) {
          break label249;
        }
        localView = ((View)localObject).findViewById(this.mState.mFocusedSubChildId);
        if ((localView == null) || (!localView.isFocusable())) {
          break label249;
        }
        localObject = localView;
      }
      label247:
      label249:
      for (;;)
      {
        ((View)localObject).requestFocus();
        return;
        localObject = ((RecyclerView.ViewHolder)localObject).itemView;
        break label191;
        break;
      }
    }
  }
  
  private void releaseGlows()
  {
    boolean bool2 = false;
    if (this.mLeftGlow != null)
    {
      this.mLeftGlow.onRelease();
      bool2 = this.mLeftGlow.isFinished();
    }
    boolean bool1 = bool2;
    if (this.mTopGlow != null)
    {
      this.mTopGlow.onRelease();
      bool1 = bool2 | this.mTopGlow.isFinished();
    }
    bool2 = bool1;
    if (this.mRightGlow != null)
    {
      this.mRightGlow.onRelease();
      bool2 = bool1 | this.mRightGlow.isFinished();
    }
    bool1 = bool2;
    if (this.mBottomGlow != null)
    {
      this.mBottomGlow.onRelease();
      bool1 = bool2 | this.mBottomGlow.isFinished();
    }
    if (bool1) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private void requestChildOnScreen(@NonNull View paramView1, @Nullable View paramView2)
  {
    boolean bool2 = true;
    Object localObject;
    Rect localRect;
    boolean bool1;
    if (paramView2 != null)
    {
      localObject = paramView2;
      this.mTempRect.set(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
      localObject = ((View)localObject).getLayoutParams();
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
          int i = localRect.bottom;
          localRect.bottom = (((Rect)localObject).bottom + i);
        }
      }
      if (paramView2 != null)
      {
        offsetDescendantRectToMyCoords(paramView2, this.mTempRect);
        offsetRectIntoDescendantCoords(paramView1, this.mTempRect);
      }
      localObject = this.mLayout;
      localRect = this.mTempRect;
      if (this.mFirstLayoutComplete) {
        break label225;
      }
      bool1 = true;
      label200:
      if (paramView2 != null) {
        break label231;
      }
    }
    for (;;)
    {
      ((RecyclerView.LayoutManager)localObject).requestChildRectangleOnScreen(this, paramView1, localRect, bool1, bool2);
      return;
      localObject = paramView1;
      break;
      label225:
      bool1 = false;
      break label200;
      label231:
      bool2 = false;
    }
  }
  
  private void resetFocusInfo()
  {
    this.mState.mFocusedItemId = -1L;
    this.mState.mFocusedItemPosition = -1;
    this.mState.mFocusedSubChildId = -1;
  }
  
  private void resetScroll()
  {
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.clear();
    }
    stopNestedScroll(0);
    releaseGlows();
  }
  
  private void saveFocusInfo()
  {
    if ((this.mPreserveFocusAfterLayout) && (hasFocus()) && (this.mAdapter != null)) {}
    for (Object localObject = getFocusedChild();; localObject = null)
    {
      if (localObject == null) {}
      for (localObject = null; localObject == null; localObject = findContainingViewHolder((View)localObject))
      {
        resetFocusInfo();
        return;
      }
      RecyclerView.State localState = this.mState;
      long l;
      int i;
      if (this.mAdapter.hasStableIds())
      {
        l = ((RecyclerView.ViewHolder)localObject).getItemId();
        localState.mFocusedItemId = l;
        localState = this.mState;
        if (!this.mDataSetHasChangedAfterLayout) {
          break label129;
        }
        i = -1;
      }
      for (;;)
      {
        localState.mFocusedItemPosition = i;
        this.mState.mFocusedSubChildId = getDeepestFocusedViewWithId(((RecyclerView.ViewHolder)localObject).itemView);
        return;
        l = -1L;
        break;
        label129:
        if (((RecyclerView.ViewHolder)localObject).isRemoved()) {
          i = ((RecyclerView.ViewHolder)localObject).mOldPosition;
        } else {
          i = ((RecyclerView.ViewHolder)localObject).getAdapterPosition();
        }
      }
    }
  }
  
  private void setAdapterInternal(@Nullable RecyclerView.Adapter paramAdapter, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mAdapter != null)
    {
      this.mAdapter.unregisterAdapterDataObserver(this.mObserver);
      this.mAdapter.onDetachedFromRecyclerView(this);
    }
    if ((!paramBoolean1) || (paramBoolean2)) {
      removeAndRecycleViews();
    }
    this.mAdapterHelper.reset();
    RecyclerView.Adapter localAdapter = this.mAdapter;
    this.mAdapter = paramAdapter;
    if (paramAdapter != null)
    {
      paramAdapter.registerAdapterDataObserver(this.mObserver);
      paramAdapter.onAttachedToRecyclerView(this);
    }
    if (this.mLayout != null) {
      this.mLayout.onAdapterChanged(localAdapter, this.mAdapter);
    }
    this.mRecycler.onAdapterChanged(localAdapter, this.mAdapter, paramBoolean1);
    this.mState.mStructureChanged = true;
  }
  
  private void stopScrollersInternal()
  {
    this.mViewFlinger.stop();
    if (this.mLayout != null) {
      this.mLayout.stopSmoothScroller();
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
      if (paramInt2 >= 0) {
        break label96;
      }
      ensureTopGlow();
      if (this.mTopGlow.isFinished()) {
        this.mTopGlow.onAbsorb(-paramInt2);
      }
    }
    for (;;)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return;
      if (paramInt1 <= 0) {
        break;
      }
      ensureRightGlow();
      if (!this.mRightGlow.isFinished()) {
        break;
      }
      this.mRightGlow.onAbsorb(paramInt1);
      break;
      label96:
      if (paramInt2 > 0)
      {
        ensureBottomGlow();
        if (this.mBottomGlow.isFinished()) {
          this.mBottomGlow.onAbsorb(paramInt2);
        }
      }
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((this.mLayout == null) || (!this.mLayout.onAddFocusables(this, paramArrayList, paramInt1, paramInt2))) {
      super.addFocusables(paramArrayList, paramInt1, paramInt2);
    }
  }
  
  public void addItemDecoration(@NonNull RecyclerView.ItemDecoration paramItemDecoration)
  {
    addItemDecoration(paramItemDecoration, -1);
  }
  
  public void addItemDecoration(@NonNull RecyclerView.ItemDecoration paramItemDecoration, int paramInt)
  {
    if (this.mLayout != null) {
      this.mLayout.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
    }
    if (this.mItemDecorations.isEmpty()) {
      setWillNotDraw(false);
    }
    if (paramInt < 0) {
      this.mItemDecorations.add(paramItemDecoration);
    }
    for (;;)
    {
      markItemDecorInsetsDirty();
      requestLayout();
      return;
      this.mItemDecorations.add(paramInt, paramItemDecoration);
    }
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
      if (paramString == null) {
        throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
      }
      throw new IllegalStateException(paramString + exceptionLabel());
    }
  }
  
  void assertNotInLayoutOrScroll(String paramString)
  {
    if (isComputingLayout())
    {
      if (paramString == null) {
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
      }
      throw new IllegalStateException(paramString);
    }
    if (this.mDispatchScrollCounter > 0) {
      Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
    }
  }
  
  boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder paramViewHolder)
  {
    return (this.mItemAnimator == null) || (this.mItemAnimator.canReuseUpdatedViewHolder(paramViewHolder, paramViewHolder.getUnmodifiedPayloads()));
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
    if (this.mOnChildAttachStateListeners != null) {
      this.mOnChildAttachStateListeners.clear();
    }
  }
  
  public void clearOnScrollListeners()
  {
    if (this.mScrollListeners != null) {
      this.mScrollListeners.clear();
    }
  }
  
  public int computeHorizontalScrollExtent()
  {
    if (this.mLayout == null) {}
    while (!this.mLayout.canScrollHorizontally()) {
      return 0;
    }
    return this.mLayout.computeHorizontalScrollExtent(this.mState);
  }
  
  public int computeHorizontalScrollOffset()
  {
    if (this.mLayout == null) {}
    while (!this.mLayout.canScrollHorizontally()) {
      return 0;
    }
    return this.mLayout.computeHorizontalScrollOffset(this.mState);
  }
  
  public int computeHorizontalScrollRange()
  {
    if (this.mLayout == null) {}
    while (!this.mLayout.canScrollHorizontally()) {
      return 0;
    }
    return this.mLayout.computeHorizontalScrollRange(this.mState);
  }
  
  public int computeVerticalScrollExtent()
  {
    if (this.mLayout == null) {}
    while (!this.mLayout.canScrollVertically()) {
      return 0;
    }
    return this.mLayout.computeVerticalScrollExtent(this.mState);
  }
  
  public int computeVerticalScrollOffset()
  {
    if (this.mLayout == null) {}
    while (!this.mLayout.canScrollVertically()) {
      return 0;
    }
    return this.mLayout.computeVerticalScrollOffset(this.mState);
  }
  
  public int computeVerticalScrollRange()
  {
    if (this.mLayout == null) {}
    while (!this.mLayout.canScrollVertically()) {
      return 0;
    }
    return this.mLayout.computeVerticalScrollRange(this.mState);
  }
  
  void considerReleasingGlowsOnScroll(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mLeftGlow != null)
    {
      bool1 = bool2;
      if (!this.mLeftGlow.isFinished())
      {
        bool1 = bool2;
        if (paramInt1 > 0)
        {
          this.mLeftGlow.onRelease();
          bool1 = this.mLeftGlow.isFinished();
        }
      }
    }
    bool2 = bool1;
    if (this.mRightGlow != null)
    {
      bool2 = bool1;
      if (!this.mRightGlow.isFinished())
      {
        bool2 = bool1;
        if (paramInt1 < 0)
        {
          this.mRightGlow.onRelease();
          bool2 = bool1 | this.mRightGlow.isFinished();
        }
      }
    }
    bool1 = bool2;
    if (this.mTopGlow != null)
    {
      bool1 = bool2;
      if (!this.mTopGlow.isFinished())
      {
        bool1 = bool2;
        if (paramInt2 > 0)
        {
          this.mTopGlow.onRelease();
          bool1 = bool2 | this.mTopGlow.isFinished();
        }
      }
    }
    bool2 = bool1;
    if (this.mBottomGlow != null)
    {
      bool2 = bool1;
      if (!this.mBottomGlow.isFinished())
      {
        bool2 = bool1;
        if (paramInt2 < 0)
        {
          this.mBottomGlow.onRelease();
          bool2 = bool1 | this.mBottomGlow.isFinished();
        }
      }
    }
    if (bool2) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  void consumePendingUpdateOperations()
  {
    if ((!this.mFirstLayoutComplete) || (this.mDataSetHasChangedAfterLayout))
    {
      TraceCompat.beginSection("RV FullInvalidate");
      dispatchLayout();
      TraceCompat.endSection();
    }
    label111:
    do
    {
      do
      {
        return;
      } while (!this.mAdapterHelper.hasPendingUpdates());
      if ((this.mAdapterHelper.hasAnyUpdateTypes(4)) && (!this.mAdapterHelper.hasAnyUpdateTypes(11)))
      {
        TraceCompat.beginSection("RV PartialInvalidate");
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mAdapterHelper.preProcess();
        if (!this.mLayoutWasDefered)
        {
          if (!hasUpdatedView()) {
            break label111;
          }
          dispatchLayout();
        }
        for (;;)
        {
          stopInterceptRequestLayout(true);
          onExitLayoutOrScroll();
          TraceCompat.endSection();
          return;
          this.mAdapterHelper.consumePostponedUpdates();
        }
      }
    } while (!this.mAdapterHelper.hasPendingUpdates());
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
    RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(paramView);
    onChildAttachedToWindow(paramView);
    if ((this.mAdapter != null) && (localViewHolder != null)) {
      this.mAdapter.onViewAttachedToWindow(localViewHolder);
    }
    if (this.mOnChildAttachStateListeners != null)
    {
      int i = this.mOnChildAttachStateListeners.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.OnChildAttachStateChangeListener)this.mOnChildAttachStateListeners.get(i)).onChildViewAttachedToWindow(paramView);
        i -= 1;
      }
    }
  }
  
  void dispatchChildDetached(View paramView)
  {
    RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(paramView);
    onChildDetachedFromWindow(paramView);
    if ((this.mAdapter != null) && (localViewHolder != null)) {
      this.mAdapter.onViewDetachedFromWindow(localViewHolder);
    }
    if (this.mOnChildAttachStateListeners != null)
    {
      int i = this.mOnChildAttachStateListeners.size() - 1;
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
    this.mState.mIsMeasuring = false;
    if (this.mState.mLayoutStep == 1)
    {
      dispatchLayoutStep1();
      this.mLayout.setExactMeasureSpecsFrom(this);
      dispatchLayoutStep2();
    }
    for (;;)
    {
      dispatchLayoutStep3();
      return;
      if ((this.mAdapterHelper.hasUpdates()) || (this.mLayout.getWidth() != getWidth()) || (this.mLayout.getHeight() != getHeight()))
      {
        this.mLayout.setExactMeasureSpecsFrom(this);
        dispatchLayoutStep2();
      }
      else
      {
        this.mLayout.setExactMeasureSpecsFrom(this);
      }
    }
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
    if (this.mLayout != null) {
      this.mLayout.onScrollStateChanged(paramInt);
    }
    onScrollStateChanged(paramInt);
    if (this.mScrollListener != null) {
      this.mScrollListener.onScrollStateChanged(this, paramInt);
    }
    if (this.mScrollListeners != null)
    {
      int i = this.mScrollListeners.size() - 1;
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
    if (this.mScrollListener != null) {
      this.mScrollListener.onScrolled(this, paramInt1, paramInt2);
    }
    if (this.mScrollListeners != null)
    {
      i = this.mScrollListeners.size() - 1;
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
    if (i >= 0)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mPendingAccessibilityImportanceChange.get(i);
      if ((localViewHolder.itemView.getParent() != this) || (localViewHolder.shouldIgnore())) {}
      for (;;)
      {
        i -= 1;
        break;
        int j = localViewHolder.mPendingAccessibilityState;
        if (j != -1)
        {
          ViewCompat.setImportantForAccessibility(localViewHolder.itemView, j);
          localViewHolder.mPendingAccessibilityState = -1;
        }
      }
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
    int k = 1;
    int m = 0;
    super.draw(paramCanvas);
    int j = this.mItemDecorations.size();
    int i = 0;
    while (i < j)
    {
      ((RecyclerView.ItemDecoration)this.mItemDecorations.get(i)).onDrawOver(paramCanvas, this, this.mState);
      i += 1;
    }
    int n;
    if ((this.mLeftGlow != null) && (!this.mLeftGlow.isFinished()))
    {
      n = paramCanvas.save();
      if (this.mClipToPadding)
      {
        i = getPaddingBottom();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(i + -getHeight(), 0.0F);
        if ((this.mLeftGlow == null) || (!this.mLeftGlow.draw(paramCanvas))) {
          break label456;
        }
        j = 1;
        label128:
        paramCanvas.restoreToCount(n);
      }
    }
    for (;;)
    {
      i = j;
      if (this.mTopGlow != null)
      {
        i = j;
        if (!this.mTopGlow.isFinished())
        {
          n = paramCanvas.save();
          if (this.mClipToPadding) {
            paramCanvas.translate(getPaddingLeft(), getPaddingTop());
          }
          if ((this.mTopGlow == null) || (!this.mTopGlow.draw(paramCanvas))) {
            break label461;
          }
          i = 1;
          label202:
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      j = i;
      if (this.mRightGlow != null)
      {
        j = i;
        if (!this.mRightGlow.isFinished())
        {
          n = paramCanvas.save();
          int i1 = getWidth();
          if (!this.mClipToPadding) {
            break label466;
          }
          j = getPaddingTop();
          label257:
          paramCanvas.rotate(90.0F);
          paramCanvas.translate(-j, -i1);
          if ((this.mRightGlow == null) || (!this.mRightGlow.draw(paramCanvas))) {
            break label471;
          }
          j = 1;
          label295:
          j = i | j;
          paramCanvas.restoreToCount(n);
        }
      }
      i = j;
      if (this.mBottomGlow != null)
      {
        i = j;
        if (!this.mBottomGlow.isFinished())
        {
          n = paramCanvas.save();
          paramCanvas.rotate(180.0F);
          if (!this.mClipToPadding) {
            break label476;
          }
          paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
          label372:
          i = m;
          if (this.mBottomGlow != null)
          {
            i = m;
            if (this.mBottomGlow.draw(paramCanvas)) {
              i = 1;
            }
          }
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      if ((i == 0) && (this.mItemAnimator != null) && (this.mItemDecorations.size() > 0) && (this.mItemAnimator.isRunning())) {
        i = k;
      }
      for (;;)
      {
        if (i != 0) {
          ViewCompat.postInvalidateOnAnimation(this);
        }
        return;
        i = 0;
        break;
        label456:
        j = 0;
        break label128;
        label461:
        i = 0;
        break label202;
        label466:
        j = 0;
        break label257;
        label471:
        j = 0;
        break label295;
        label476:
        paramCanvas.translate(-getWidth(), -getHeight());
        break label372;
      }
      j = 0;
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
    return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
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
      if ((paramFloat1 >= localView.getLeft() + f1) && (paramFloat1 <= f1 + localView.getRight()) && (paramFloat2 >= localView.getTop() + f2) && (paramFloat2 <= localView.getBottom() + f2)) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  @Nullable
  public View findContainingItemView(@NonNull View paramView)
  {
    for (ViewParent localViewParent = paramView.getParent(); (localViewParent != null) && (localViewParent != this) && ((localViewParent instanceof View)); localViewParent = paramView.getParent()) {
      paramView = (View)localViewParent;
    }
    if (localViewParent == this) {
      return paramView;
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
    Object localObject = null;
    if (this.mDataSetHasChangedAfterLayout) {}
    int i;
    RecyclerView.ViewHolder localViewHolder;
    do
    {
      return localObject;
      int j = this.mChildHelper.getUnfilteredChildCount();
      i = 0;
      localObject = null;
      if (i >= j) {
        break;
      }
      localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      if ((localViewHolder == null) || (localViewHolder.isRemoved()) || (getAdapterPositionFor(localViewHolder) != paramInt)) {
        break label100;
      }
      localObject = localViewHolder;
    } while (!this.mChildHelper.isHidden(localViewHolder.itemView));
    localObject = localViewHolder;
    label100:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  public RecyclerView.ViewHolder findViewHolderForItemId(long paramLong)
  {
    RecyclerView.ViewHolder localViewHolder2 = null;
    RecyclerView.ViewHolder localViewHolder1 = localViewHolder2;
    if (this.mAdapter != null)
    {
      if (this.mAdapter.hasStableIds()) {
        break label31;
      }
      localViewHolder1 = localViewHolder2;
    }
    label31:
    int i;
    do
    {
      return localViewHolder1;
      int j = this.mChildHelper.getUnfilteredChildCount();
      i = 0;
      localViewHolder1 = null;
      if (i >= j) {
        break;
      }
      localViewHolder2 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      if ((localViewHolder2 == null) || (localViewHolder2.isRemoved()) || (localViewHolder2.getItemId() != paramLong)) {
        break label120;
      }
      localViewHolder1 = localViewHolder2;
    } while (!this.mChildHelper.isHidden(localViewHolder2.itemView));
    localViewHolder1 = localViewHolder2;
    label120:
    for (;;)
    {
      i += 1;
      break;
      return localViewHolder1;
    }
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
    int i = 0;
    Object localObject1 = null;
    if (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      Object localObject2 = localObject1;
      if (localViewHolder != null)
      {
        localObject2 = localObject1;
        if (!localViewHolder.isRemoved())
        {
          if (!paramBoolean) {
            break label82;
          }
          if (localViewHolder.mPosition == paramInt) {
            break label95;
          }
          localObject2 = localObject1;
        }
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        label82:
        localObject2 = localObject1;
        if (localViewHolder.getLayoutPosition() == paramInt)
        {
          label95:
          localObject1 = localViewHolder;
          if (!this.mChildHelper.isHidden(localViewHolder.itemView)) {
            break label121;
          }
          localObject2 = localViewHolder;
        }
      }
    }
    label121:
    return localObject1;
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    if (this.mLayout == null) {
      Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
    }
    boolean bool2;
    boolean bool3;
    int i;
    int j;
    boolean bool1;
    do
    {
      do
      {
        do
        {
          return false;
        } while (this.mLayoutSuppressed);
        bool2 = this.mLayout.canScrollHorizontally();
        bool3 = this.mLayout.canScrollVertically();
        if (bool2)
        {
          i = paramInt1;
          if (Math.abs(paramInt1) >= this.mMinFlingVelocity) {}
        }
        else
        {
          i = 0;
        }
        if (bool3)
        {
          j = paramInt2;
          if (Math.abs(paramInt2) >= this.mMinFlingVelocity) {}
        }
        else
        {
          j = 0;
        }
      } while (((i == 0) && (j == 0)) || (dispatchNestedPreFling(i, j)));
      if ((bool2) || (bool3)) {}
      for (bool1 = true;; bool1 = false)
      {
        dispatchNestedFling(i, j, bool1);
        if ((this.mOnFlingListener == null) || (!this.mOnFlingListener.onFling(i, j))) {
          break;
        }
        return true;
      }
    } while (!bool1);
    if (bool2) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramInt2 = paramInt1;
      if (bool3) {
        paramInt2 = paramInt1 | 0x2;
      }
      startNestedScroll(paramInt2, 1);
      paramInt1 = Math.max(-this.mMaxFlingVelocity, Math.min(i, this.mMaxFlingVelocity));
      paramInt2 = Math.max(-this.mMaxFlingVelocity, Math.min(j, this.mMaxFlingVelocity));
      this.mViewFlinger.fling(paramInt1, paramInt2);
      return true;
    }
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    int k = 1;
    Object localObject = this.mLayout.onInterceptFocusSearch(paramView, paramInt);
    if (localObject != null) {
      return localObject;
    }
    int i;
    int j;
    if ((this.mAdapter != null) && (this.mLayout != null) && (!isComputingLayout()) && (!this.mLayoutSuppressed))
    {
      i = 1;
      localObject = FocusFinder.getInstance();
      if ((i == 0) || ((paramInt != 2) && (paramInt != 1))) {
        break label313;
      }
      if (!this.mLayout.canScrollVertically()) {
        break label423;
      }
      if (paramInt != 2) {
        break label214;
      }
      j = 130;
      label91:
      if (((FocusFinder)localObject).findNextFocus(this, paramView, j) != null) {
        break label221;
      }
      i = 1;
      label105:
      if (!FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
        break label420;
      }
      paramInt = j;
    }
    for (;;)
    {
      if ((i == 0) && (this.mLayout.canScrollHorizontally())) {
        if (this.mLayout.getLayoutDirection() == 1)
        {
          i = 1;
          label141:
          if (paramInt != 2) {
            break label231;
          }
          j = 1;
          label149:
          if ((j ^ i) == 0) {
            break label237;
          }
          i = 66;
          label159:
          if (((FocusFinder)localObject).findNextFocus(this, paramView, i) != null) {
            break label243;
          }
          j = k;
          label174:
          k = j;
          if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
            paramInt = i;
          }
        }
      }
      for (k = j;; k = i)
      {
        if (k != 0)
        {
          consumePendingUpdateOperations();
          if (findContainingItemView(paramView) == null)
          {
            return null;
            i = 0;
            break;
            label214:
            j = 33;
            break label91;
            label221:
            i = 0;
            break label105;
            i = 0;
            break label141;
            label231:
            j = 0;
            break label149;
            label237:
            i = 17;
            break label159;
            label243:
            j = 0;
            break label174;
          }
          startInterceptRequestLayout();
          this.mLayout.onFocusSearchFailed(paramView, paramInt, this.mRecycler, this.mState);
          stopInterceptRequestLayout(false);
        }
        localObject = ((FocusFinder)localObject).findNextFocus(this, paramView, paramInt);
        for (;;)
        {
          if ((localObject != null) && (!((View)localObject).hasFocusable()))
          {
            if (getFocusedChild() == null)
            {
              return super.focusSearch(paramView, paramInt);
              label313:
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
            else
            {
              requestChildOnScreen((View)localObject, null);
              return paramView;
            }
          }
          else
          {
            if (isPreferredNextFocus(paramView, (View)localObject, paramInt)) {}
            for (;;)
            {
              return localObject;
              localObject = super.focusSearch(paramView, paramInt);
            }
          }
        }
      }
      label420:
      continue;
      label423:
      i = 0;
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    if (this.mLayout == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }
    return this.mLayout.generateDefaultLayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    if (this.mLayout == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }
    return this.mLayout.generateLayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.mLayout == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }
    return this.mLayout.generateLayoutParams(paramLayoutParams);
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
    if ((paramViewHolder.hasAnyOfTheFlags(524)) || (!paramViewHolder.isBound())) {
      return -1;
    }
    return this.mAdapterHelper.applyPendingUpdatesToPosition(paramViewHolder.mPosition);
  }
  
  public int getBaseline()
  {
    if (this.mLayout != null) {
      return this.mLayout.getBaseline();
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
    if (this.mChildDrawingOrderCallback == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return this.mChildDrawingOrderCallback.onGetChildDrawingOrder(paramInt1, paramInt2);
  }
  
  public long getChildItemId(@NonNull View paramView)
  {
    if ((this.mAdapter == null) || (!this.mAdapter.hasStableIds())) {}
    do
    {
      return -1L;
      paramView = getChildViewHolderInt(paramView);
    } while (paramView == null);
    return paramView.getItemId();
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
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && (localViewParent != this)) {
      throw new IllegalArgumentException("View " + paramView + " is not a direct child of " + this);
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
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new IndexOutOfBoundsException(paramInt + " is an invalid index for size " + i);
    }
    return (RecyclerView.ItemDecoration)this.mItemDecorations.get(paramInt);
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
    if ((paramStateListDrawable1 == null) || (paramDrawable1 == null) || (paramStateListDrawable2 == null) || (paramDrawable2 == null)) {
      throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
    }
    Resources localResources = getContext().getResources();
    new FastScroller(this, paramStateListDrawable1, paramDrawable1, paramStateListDrawable2, paramDrawable2, localResources.getDimensionPixelSize(2131296948), localResources.getDimensionPixelSize(2131296950), localResources.getDimensionPixelOffset(2131296949));
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
    if (this.mLayout != null) {
      this.mLayout.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
    }
    markItemDecorInsetsDirty();
    requestLayout();
  }
  
  boolean isAccessibilityEnabled()
  {
    return (this.mAccessibilityManager != null) && (this.mAccessibilityManager.isEnabled());
  }
  
  public boolean isAnimating()
  {
    return (this.mItemAnimator != null) && (this.mItemAnimator.isRunning());
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
    if (paramInt1 < paramInt2)
    {
      i = -1;
      j = paramInt2;
    }
    RecyclerView.ViewHolder localViewHolder;
    for (int k = paramInt1;; k = paramInt2)
    {
      int m = 0;
      for (;;)
      {
        if (m >= n) {
          break label130;
        }
        localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(m));
        if ((localViewHolder != null) && (localViewHolder.mPosition >= k) && (localViewHolder.mPosition <= j)) {
          break;
        }
        m += 1;
      }
      i = 1;
      j = paramInt1;
    }
    if (localViewHolder.mPosition == paramInt1) {
      localViewHolder.offsetPosition(paramInt2 - paramInt1, false);
    }
    for (;;)
    {
      this.mState.mStructureChanged = true;
      break;
      localViewHolder.offsetPosition(i, false);
    }
    label130:
    this.mRecycler.offsetPositionRecordsForMove(paramInt1, paramInt2);
    requestLayout();
  }
  
  void offsetPositionRecordsForRemove(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    if (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore()))
      {
        if (localViewHolder.mPosition < paramInt1 + paramInt2) {
          break label82;
        }
        localViewHolder.offsetPosition(-paramInt2, paramBoolean);
        this.mState.mStructureChanged = true;
      }
      for (;;)
      {
        i += 1;
        break;
        label82:
        if (localViewHolder.mPosition >= paramInt1)
        {
          localViewHolder.flagRemovedAndOffsetPosition(paramInt1 - 1, -paramInt2, paramBoolean);
          this.mState.mStructureChanged = true;
        }
      }
    }
    this.mRecycler.offsetPositionRecordsForRemove(paramInt1, paramInt2, paramBoolean);
    requestLayout();
  }
  
  protected void onAttachedToWindow()
  {
    boolean bool = true;
    super.onAttachedToWindow();
    this.mLayoutOrScrollCounter = 0;
    this.mIsAttached = true;
    float f;
    if ((this.mFirstLayoutComplete) && (!isLayoutRequested()))
    {
      this.mFirstLayoutComplete = bool;
      if (this.mLayout != null) {
        this.mLayout.dispatchAttachedToWindow(this);
      }
      this.mPostedAnimatorRunner = false;
      if (ALLOW_THREAD_GAP_WORK)
      {
        this.mGapWorker = ((GapWorker)GapWorker.sGapWorker.get());
        if (this.mGapWorker == null)
        {
          this.mGapWorker = new GapWorker();
          Display localDisplay = ViewCompat.getDisplay(this);
          if ((isInEditMode()) || (localDisplay == null)) {
            break label158;
          }
          f = localDisplay.getRefreshRate();
          if (f < 30.0F) {
            break label158;
          }
        }
      }
    }
    for (;;)
    {
      this.mGapWorker.mFrameIntervalNs = ((1.0E+009F / f));
      GapWorker.sGapWorker.set(this.mGapWorker);
      this.mGapWorker.add(this);
      return;
      bool = false;
      break;
      label158:
      f = 60.0F;
    }
  }
  
  public void onChildAttachedToWindow(@NonNull View paramView) {}
  
  public void onChildDetachedFromWindow(@NonNull View paramView) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mItemAnimator != null) {
      this.mItemAnimator.endAnimations();
    }
    stopScroll();
    this.mIsAttached = false;
    if (this.mLayout != null) {
      this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
    }
    this.mPendingAccessibilityImportanceChange.clear();
    removeCallbacks(this.mItemAnimatorRunner);
    this.mViewInfoStore.onDetach();
    if ((ALLOW_THREAD_GAP_WORK) && (this.mGapWorker != null))
    {
      this.mGapWorker.remove(this);
      this.mGapWorker = null;
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
    if (this.mLayout == null) {}
    label184:
    for (;;)
    {
      return false;
      if ((!this.mLayoutSuppressed) && (paramMotionEvent.getAction() == 8))
      {
        float f1;
        float f2;
        if ((paramMotionEvent.getSource() & 0x2) != 0) {
          if (this.mLayout.canScrollVertically())
          {
            f1 = -paramMotionEvent.getAxisValue(9);
            if (!this.mLayout.canScrollHorizontally()) {
              break label114;
            }
            float f3 = paramMotionEvent.getAxisValue(10);
            f2 = f1;
            f1 = f3;
          }
        }
        for (;;)
        {
          if ((f2 == 0.0F) && (f1 == 0.0F)) {
            break label184;
          }
          scrollByInternal((int)(f1 * this.mScaledHorizontalScrollFactor), (int)(this.mScaledVerticalScrollFactor * f2), paramMotionEvent);
          return false;
          f1 = 0.0F;
          break;
          label114:
          f2 = f1;
          f1 = 0.0F;
          continue;
          if ((paramMotionEvent.getSource() & 0x400000) != 0)
          {
            f1 = paramMotionEvent.getAxisValue(26);
            if (this.mLayout.canScrollVertically())
            {
              f2 = -f1;
              f1 = 0.0F;
            }
            else if (this.mLayout.canScrollHorizontally())
            {
              f2 = 0.0F;
            }
            else
            {
              f1 = 0.0F;
              f2 = 0.0F;
            }
          }
          else
          {
            f1 = 0.0F;
            f2 = 0.0F;
          }
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mLayoutSuppressed) {}
    do
    {
      return false;
      this.mInterceptingOnItemTouchListener = null;
      if (findInterceptingOnItemTouchListener(paramMotionEvent))
      {
        cancelScroll();
        return true;
      }
    } while (this.mLayout == null);
    boolean bool1 = this.mLayout.canScrollHorizontally();
    boolean bool2 = this.mLayout.canScrollVertically();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int j = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
    switch (j)
    {
    case 4: 
    default: 
      if (this.mScrollState == 1)
      {
        bool1 = true;
        return bool1;
      }
      break;
    case 0: 
      label139:
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
      this.mNestedOffsets[1] = 0;
      paramMotionEvent[0] = 0;
      if (!bool1) {}
      break;
    }
    for (i = 1;; i = 0)
    {
      j = i;
      if (bool2) {
        j = i | 0x2;
      }
      startNestedScroll(j, 0);
      break;
      this.mScrollPointerId = paramMotionEvent.getPointerId(i);
      j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.mLastTouchX = j;
      this.mInitialTouchX = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.mLastTouchY = i;
      this.mInitialTouchY = i;
      break;
      j = paramMotionEvent.findPointerIndex(this.mScrollPointerId);
      if (j < 0)
      {
        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
      }
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      int k = (int)(paramMotionEvent.getY(j) + 0.5F);
      if (this.mScrollState == 1) {
        break;
      }
      j = this.mInitialTouchX;
      int m = this.mInitialTouchY;
      if ((bool1) && (Math.abs(i - j) > this.mTouchSlop)) {
        this.mLastTouchX = i;
      }
      for (i = 1;; i = 0)
      {
        j = i;
        if (bool2)
        {
          j = i;
          if (Math.abs(k - m) > this.mTouchSlop)
          {
            this.mLastTouchY = k;
            j = 1;
          }
        }
        if (j == 0) {
          break;
        }
        setScrollState(1);
        break;
        onPointerUp(paramMotionEvent);
        break;
        this.mVelocityTracker.clear();
        stopNestedScroll(0);
        break;
        cancelScroll();
        break;
        bool1 = false;
        break label139;
      }
    }
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
    int j = 0;
    if (this.mLayout == null) {
      defaultOnMeasure(paramInt1, paramInt2);
    }
    do
    {
      int i;
      do
      {
        return;
        if (!this.mLayout.isAutoMeasureEnabled()) {
          break;
        }
        int k = View.MeasureSpec.getMode(paramInt1);
        int m = View.MeasureSpec.getMode(paramInt2);
        this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
        i = j;
        if (k == 1073741824)
        {
          i = j;
          if (m == 1073741824) {
            i = 1;
          }
        }
      } while ((i != 0) || (this.mAdapter == null));
      if (this.mState.mLayoutStep == 1) {
        dispatchLayoutStep1();
      }
      this.mLayout.setMeasureSpecs(paramInt1, paramInt2);
      this.mState.mIsMeasuring = true;
      dispatchLayoutStep2();
      this.mLayout.setMeasuredDimensionFromChildren(paramInt1, paramInt2);
    } while (!this.mLayout.shouldMeasureTwice());
    this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    this.mState.mIsMeasuring = true;
    dispatchLayoutStep2();
    this.mLayout.setMeasuredDimensionFromChildren(paramInt1, paramInt2);
    return;
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
        this.mAdapterUpdateDuringMeasure = false;
        stopInterceptRequestLayout(false);
        label271:
        if (this.mAdapter == null) {
          break label368;
        }
      }
    }
    label368:
    for (this.mState.mItemCount = this.mAdapter.getItemCount();; this.mState.mItemCount = 0)
    {
      startInterceptRequestLayout();
      this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
      stopInterceptRequestLayout(false);
      this.mState.mInPreLayout = false;
      return;
      this.mAdapterHelper.consumeUpdatesInOnePass();
      this.mState.mInPreLayout = false;
      break;
      if (!this.mState.mRunPredictiveAnimations) {
        break label271;
      }
      setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
      return;
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
    if (!(paramParcelable instanceof RecyclerView.SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    do
    {
      return;
      this.mPendingSavedState = ((RecyclerView.SavedState)paramParcelable);
      super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
    } while ((this.mLayout == null) || (this.mPendingSavedState.mLayoutState == null));
    this.mLayout.onRestoreInstanceState(this.mPendingSavedState.mLayoutState);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    RecyclerView.SavedState localSavedState = new RecyclerView.SavedState(super.onSaveInstanceState());
    if (this.mPendingSavedState != null)
    {
      localSavedState.copyFrom(this.mPendingSavedState);
      return localSavedState;
    }
    if (this.mLayout != null)
    {
      localSavedState.mLayoutState = this.mLayout.onSaveInstanceState();
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
    int i2 = 0;
    if ((this.mLayoutSuppressed) || (this.mIgnoreMotionEventTillDown)) {}
    do
    {
      return false;
      if (dispatchToOnItemTouchListeners(paramMotionEvent))
      {
        cancelScroll();
        return true;
      }
    } while (this.mLayout == null);
    boolean bool1 = this.mLayout.canScrollHorizontally();
    boolean bool2 = this.mLayout.canScrollVertically();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    int j = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
    if (j == 0)
    {
      localObject = this.mNestedOffsets;
      this.mNestedOffsets[1] = 0;
      localObject[0] = 0;
    }
    Object localObject = MotionEvent.obtain(paramMotionEvent);
    ((MotionEvent)localObject).offsetLocation(this.mNestedOffsets[0], this.mNestedOffsets[1]);
    int n = i2;
    switch (j)
    {
    default: 
      n = i2;
    case 4: 
      if (n == 0) {
        this.mVelocityTracker.addMovement((MotionEvent)localObject);
      }
      ((MotionEvent)localObject).recycle();
      return true;
    case 0: 
      this.mScrollPointerId = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.mLastTouchX = i;
      this.mInitialTouchX = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.mLastTouchY = i;
      this.mInitialTouchY = i;
      if (!bool1) {
        break;
      }
    }
    for (i = 1;; i = 0)
    {
      j = i;
      if (bool2) {
        j = i | 0x2;
      }
      startNestedScroll(j, 0);
      n = i2;
      break;
      this.mScrollPointerId = paramMotionEvent.getPointerId(i);
      j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.mLastTouchX = j;
      this.mInitialTouchX = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.mLastTouchY = i;
      this.mInitialTouchY = i;
      n = i2;
      break;
      i = paramMotionEvent.findPointerIndex(this.mScrollPointerId);
      if (i < 0)
      {
        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
      }
      int i3 = (int)(paramMotionEvent.getX(i) + 0.5F);
      int i4 = (int)(paramMotionEvent.getY(i) + 0.5F);
      i = this.mLastTouchX - i3;
      n = this.mLastTouchY - i4;
      j = n;
      int m = i;
      if (this.mScrollState != 1)
      {
        j = i;
        if (!bool1) {
          break label1036;
        }
        if (i <= 0) {
          break label849;
        }
        i = Math.max(0, i - this.mTouchSlop);
        label504:
        j = i;
        if (i == 0) {
          break label1036;
        }
      }
      int k;
      for (j = 1;; j = k)
      {
        k = n;
        int i1 = j;
        if (bool2)
        {
          if (n <= 0) {
            break label865;
          }
          m = Math.max(0, n - this.mTouchSlop);
          label547:
          k = m;
          i1 = j;
          if (m != 0)
          {
            i1 = 1;
            k = m;
          }
        }
        j = k;
        m = i;
        if (i1 != 0)
        {
          setScrollState(1);
          m = i;
          j = k;
        }
        n = i2;
        if (this.mScrollState != 1) {
          break;
        }
        this.mReusableIntPair[0] = 0;
        this.mReusableIntPair[1] = 0;
        if (bool1)
        {
          n = m;
          label628:
          if (!bool2) {
            break label887;
          }
          i1 = j;
          label637:
          k = j;
          i = m;
          if (dispatchNestedPreScroll(n, i1, this.mReusableIntPair, this.mScrollOffset, 0))
          {
            i = m - this.mReusableIntPair[0];
            k = j - this.mReusableIntPair[1];
            int[] arrayOfInt = this.mNestedOffsets;
            arrayOfInt[0] += this.mScrollOffset[0];
            arrayOfInt = this.mNestedOffsets;
            arrayOfInt[1] += this.mScrollOffset[1];
            getParent().requestDisallowInterceptTouchEvent(true);
          }
          this.mLastTouchX = (i3 - this.mScrollOffset[0]);
          this.mLastTouchY = (i4 - this.mScrollOffset[1]);
          if (!bool1) {
            break label893;
          }
          j = i;
          label774:
          if (!bool2) {
            break label899;
          }
        }
        label899:
        for (m = k;; m = 0)
        {
          if (scrollByInternal(j, m, paramMotionEvent)) {
            getParent().requestDisallowInterceptTouchEvent(true);
          }
          n = i2;
          if (this.mGapWorker == null) {
            break;
          }
          if (i == 0)
          {
            n = i2;
            if (k == 0) {
              break;
            }
          }
          this.mGapWorker.postFromTraversal(this, i, k);
          n = i2;
          break;
          label849:
          i = Math.min(0, i + this.mTouchSlop);
          break label504;
          label865:
          m = Math.min(0, n + this.mTouchSlop);
          break label547;
          n = 0;
          break label628;
          label887:
          i1 = 0;
          break label637;
          label893:
          j = 0;
          break label774;
        }
        onPointerUp(paramMotionEvent);
        n = i2;
        break;
        this.mVelocityTracker.addMovement((MotionEvent)localObject);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
        float f1;
        if (bool1)
        {
          f1 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
          label959:
          if (!bool2) {
            break label1020;
          }
        }
        label1020:
        for (float f2 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);; f2 = 0.0F)
        {
          if (((f1 == 0.0F) && (f2 == 0.0F)) || (!fling((int)f1, (int)f2))) {
            setScrollState(0);
          }
          resetScroll();
          n = 1;
          break;
          f1 = 0.0F;
          break label959;
        }
        cancelScroll();
        n = i2;
        break;
        label1036:
        k = 0;
        i = j;
      }
    }
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
    this.mDispatchItemsChangedEvent |= paramBoolean;
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
    if (this.mItemAnimator != null) {
      this.mItemAnimator.endAnimations();
    }
    if (this.mLayout != null)
    {
      this.mLayout.removeAndRecycleAllViews(this.mRecycler);
      this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
    }
    this.mRecycler.clear();
  }
  
  boolean removeAnimatingView(View paramView)
  {
    startInterceptRequestLayout();
    boolean bool2 = this.mChildHelper.removeViewIfHidden(paramView);
    if (bool2)
    {
      paramView = getChildViewHolderInt(paramView);
      this.mRecycler.unscrapView(paramView);
      this.mRecycler.recycleViewHolderInternal(paramView);
    }
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      stopInterceptRequestLayout(bool1);
      return bool2;
    }
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(paramView);
    if (localViewHolder != null)
    {
      if (!localViewHolder.isTmpDetached()) {
        break label36;
      }
      localViewHolder.clearTmpDetachFlag();
    }
    label36:
    while (localViewHolder.shouldIgnore())
    {
      paramView.clearAnimation();
      dispatchChildDetached(paramView);
      super.removeDetachedView(paramView, paramBoolean);
      return;
    }
    throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + localViewHolder + exceptionLabel());
  }
  
  public void removeItemDecoration(@NonNull RecyclerView.ItemDecoration paramItemDecoration)
  {
    if (this.mLayout != null) {
      this.mLayout.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
    }
    this.mItemDecorations.remove(paramItemDecoration);
    if (this.mItemDecorations.isEmpty()) {
      if (getOverScrollMode() != 2) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      markItemDecorInsetsDirty();
      requestLayout();
      return;
    }
  }
  
  public void removeItemDecorationAt(int paramInt)
  {
    int i = getItemDecorationCount();
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new IndexOutOfBoundsException(paramInt + " is an invalid index for size " + i);
    }
    removeItemDecoration(getItemDecorationAt(paramInt));
  }
  
  public void removeOnChildAttachStateChangeListener(@NonNull RecyclerView.OnChildAttachStateChangeListener paramOnChildAttachStateChangeListener)
  {
    if (this.mOnChildAttachStateListeners == null) {
      return;
    }
    this.mOnChildAttachStateListeners.remove(paramOnChildAttachStateChangeListener);
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
    if (this.mScrollListeners != null) {
      this.mScrollListeners.remove(paramOnScrollListener);
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
    if (this.mLayout == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      do
      {
        return;
      } while (this.mLayoutSuppressed);
      bool1 = this.mLayout.canScrollHorizontally();
      bool2 = this.mLayout.canScrollVertically();
    } while ((!bool1) && (!bool2));
    if (bool1) {
      if (!bool2) {
        break label73;
      }
    }
    for (;;)
    {
      scrollByInternal(paramInt1, paramInt2, null);
      return;
      paramInt1 = 0;
      break;
      label73:
      paramInt2 = 0;
    }
  }
  
  boolean scrollByInternal(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    consumePendingUpdateOperations();
    int i;
    int j;
    int k;
    int m;
    if (this.mAdapter != null)
    {
      this.mReusableIntPair[0] = 0;
      this.mReusableIntPair[1] = 0;
      scrollStep(paramInt1, paramInt2, this.mReusableIntPair);
      i = this.mReusableIntPair[0];
      j = this.mReusableIntPair[1];
      k = paramInt1 - i;
      m = paramInt2 - j;
    }
    for (;;)
    {
      if (!this.mItemDecorations.isEmpty()) {
        invalidate();
      }
      this.mReusableIntPair[0] = 0;
      this.mReusableIntPair[1] = 0;
      dispatchNestedScroll(i, j, k, m, this.mScrollOffset, 0, this.mReusableIntPair);
      int i1 = this.mReusableIntPair[0];
      int i2 = this.mReusableIntPair[1];
      if ((this.mReusableIntPair[0] != 0) || (this.mReusableIntPair[1] != 0)) {}
      for (int n = 1;; n = 0)
      {
        this.mLastTouchX -= this.mScrollOffset[0];
        this.mLastTouchY -= this.mScrollOffset[1];
        int[] arrayOfInt = this.mNestedOffsets;
        arrayOfInt[0] += this.mScrollOffset[0];
        arrayOfInt = this.mNestedOffsets;
        arrayOfInt[1] += this.mScrollOffset[1];
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
        if ((n != 0) || (i != 0) || (j != 0)) {
          bool = true;
        }
        return bool;
      }
      j = 0;
      i = 0;
      m = 0;
      k = 0;
    }
  }
  
  void scrollStep(int paramInt1, int paramInt2, @Nullable int[] paramArrayOfInt)
  {
    startInterceptRequestLayout();
    onEnterLayoutOrScroll();
    TraceCompat.beginSection("RV Scroll");
    fillRemainingScrollValues(this.mState);
    if (paramInt1 != 0) {}
    for (paramInt1 = this.mLayout.scrollHorizontallyBy(paramInt1, this.mRecycler, this.mState);; paramInt1 = 0)
    {
      if (paramInt2 != 0) {}
      for (paramInt2 = this.mLayout.scrollVerticallyBy(paramInt2, this.mRecycler, this.mState);; paramInt2 = 0)
      {
        TraceCompat.endSection();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt[0] = paramInt1;
          paramArrayOfInt[1] = paramInt2;
        }
        return;
      }
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
    if (this.mLayout == null)
    {
      Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    this.mLayout.scrollToPosition(paramInt);
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
    if (this.mChildDrawingOrderCallback != null) {}
    for (boolean bool = true;; bool = false)
    {
      setChildrenDrawingOrderEnabled(bool);
      return;
    }
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
    if (this.mItemAnimator != null)
    {
      this.mItemAnimator.endAnimations();
      this.mItemAnimator.setListener(null);
    }
    this.mItemAnimator = paramItemAnimator;
    if (this.mItemAnimator != null) {
      this.mItemAnimator.setListener(this.mItemAnimatorListener);
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
    if (this.mLayout != null)
    {
      if (this.mItemAnimator != null) {
        this.mItemAnimator.endAnimations();
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
    for (;;)
    {
      this.mChildHelper.removeAllViewsUnfiltered();
      this.mLayout = paramLayoutManager;
      if (paramLayoutManager == null) {
        break label195;
      }
      if (paramLayoutManager.mRecyclerView == null) {
        break;
      }
      throw new IllegalArgumentException("LayoutManager " + paramLayoutManager + " is already attached to a RecyclerView:" + paramLayoutManager.mRecyclerView.exceptionLabel());
      this.mRecycler.clear();
    }
    this.mLayout.setRecyclerView(this);
    if (this.mIsAttached) {
      this.mLayout.dispatchAttachedToWindow(this);
    }
    label195:
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
    switch (paramInt)
    {
    default: 
      Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + paramInt + "; using default value");
    case 0: 
      this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
      return;
    }
    this.mTouchSlop = localViewConfiguration.getScaledPagingTouchSlop();
  }
  
  public void setViewCacheExtension(@Nullable RecyclerView.ViewCacheExtension paramViewCacheExtension)
  {
    this.mRecycler.setViewCacheExtension(paramViewCacheExtension);
  }
  
  boolean shouldDeferAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool = false;
    int j = 0;
    if (isComputingLayout()) {
      if (paramAccessibilityEvent == null) {
        break label46;
      }
    }
    label46:
    for (int i = AccessibilityEventCompat.getContentChangeTypes(paramAccessibilityEvent);; i = 0)
    {
      if (i == 0) {
        i = j;
      }
      for (;;)
      {
        this.mEatenAccessibilityChangeFlags = (i | this.mEatenAccessibilityChangeFlags);
        bool = true;
        return bool;
      }
    }
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
    int j = 0;
    if (this.mLayout == null) {}
    int i;
    do
    {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      do
      {
        return;
      } while (this.mLayoutSuppressed);
      i = paramInt1;
      if (!this.mLayout.canScrollHorizontally()) {
        i = 0;
      }
      if (!this.mLayout.canScrollVertically()) {
        paramInt2 = 0;
      }
    } while ((i == 0) && (paramInt2 == 0));
    if ((paramInt3 == -2147483648) || (paramInt3 > 0)) {}
    for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
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
  
  public void smoothScrollToPosition(int paramInt)
  {
    if (this.mLayoutSuppressed) {
      return;
    }
    if (this.mLayout == null)
    {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    this.mLayout.smoothScrollToPosition(this, this.mState, paramInt);
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
      }
    }
    else
    {
      return;
    }
    long l = SystemClock.uptimeMillis();
    onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
    this.mLayoutSuppressed = true;
    this.mIgnoreMotionEventTillDown = true;
    stopScroll();
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
    if (i < j)
    {
      View localView = this.mChildHelper.getUnfilteredChildAt(i);
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(localView);
      if ((localViewHolder == null) || (localViewHolder.shouldIgnore())) {}
      for (;;)
      {
        i += 1;
        break;
        if ((localViewHolder.mPosition >= paramInt1) && (localViewHolder.mPosition < paramInt1 + paramInt2))
        {
          localViewHolder.addFlags(2);
          localViewHolder.addChangePayload(paramObject);
          ((RecyclerView.LayoutParams)localView.getLayoutParams()).mInsetsDirty = true;
        }
      }
    }
    this.mRecycler.viewRangeUpdate(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView
 * JD-Core Version:    0.7.0.1
 */