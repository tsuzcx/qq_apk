package androidx.viewpager2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;
import androidx.recyclerview.widget.RecyclerView.ItemAnimator;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener;
import androidx.viewpager2.R.styleable;
import androidx.viewpager2.adapter.StatefulAdapter;

public final class ViewPager2
  extends ViewGroup
{
  public static final int OFFSCREEN_PAGE_LIMIT_DEFAULT = -1;
  public static final int ORIENTATION_HORIZONTAL = 0;
  public static final int ORIENTATION_VERTICAL = 1;
  public static final int SCROLL_STATE_DRAGGING = 1;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_SETTLING = 2;
  static boolean sFeatureEnhancedA11yEnabled = true;
  ViewPager2.AccessibilityProvider mAccessibilityProvider;
  int mCurrentItem;
  private RecyclerView.AdapterDataObserver mCurrentItemDataSetChangeObserver = new ViewPager2.1(this);
  boolean mCurrentItemDirty = false;
  private CompositeOnPageChangeCallback mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
  private FakeDrag mFakeDragger;
  private LinearLayoutManager mLayoutManager;
  private int mOffscreenPageLimit = -1;
  private CompositeOnPageChangeCallback mPageChangeEventDispatcher;
  private PageTransformerAdapter mPageTransformerAdapter;
  private PagerSnapHelper mPagerSnapHelper;
  private Parcelable mPendingAdapterState;
  private int mPendingCurrentItem = -1;
  RecyclerView mRecyclerView;
  private RecyclerView.ItemAnimator mSavedItemAnimator = null;
  private boolean mSavedItemAnimatorPresent = false;
  ScrollEventAdapter mScrollEventAdapter;
  private final Rect mTmpChildRect = new Rect();
  private final Rect mTmpContainerRect = new Rect();
  private boolean mUserInputEnabled = true;
  
  public ViewPager2(@NonNull Context paramContext)
  {
    super(paramContext);
    initialize(paramContext, null);
  }
  
  public ViewPager2(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initialize(paramContext, paramAttributeSet);
  }
  
  public ViewPager2(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initialize(paramContext, paramAttributeSet);
  }
  
  @RequiresApi(21)
  public ViewPager2(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    initialize(paramContext, paramAttributeSet);
  }
  
  private RecyclerView.OnChildAttachStateChangeListener enforceChildFillListener()
  {
    return new ViewPager2.4(this);
  }
  
  private void initialize(Context paramContext, AttributeSet paramAttributeSet)
  {
    Object localObject;
    if (sFeatureEnhancedA11yEnabled) {
      localObject = new ViewPager2.PageAwareAccessibilityProvider(this);
    } else {
      localObject = new ViewPager2.BasicAccessibilityProvider(this);
    }
    this.mAccessibilityProvider = ((ViewPager2.AccessibilityProvider)localObject);
    this.mRecyclerView = new ViewPager2.RecyclerViewImpl(this, paramContext);
    this.mRecyclerView.setId(ViewCompat.generateViewId());
    this.mRecyclerView.setDescendantFocusability(131072);
    this.mLayoutManager = new ViewPager2.LinearLayoutManagerImpl(this, paramContext);
    this.mRecyclerView.setLayoutManager(this.mLayoutManager);
    this.mRecyclerView.setScrollingTouchSlop(1);
    setOrientation(paramContext, paramAttributeSet);
    this.mRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mRecyclerView.addOnChildAttachStateChangeListener(enforceChildFillListener());
    this.mScrollEventAdapter = new ScrollEventAdapter(this);
    this.mFakeDragger = new FakeDrag(this, this.mScrollEventAdapter, this.mRecyclerView);
    this.mPagerSnapHelper = new ViewPager2.PagerSnapHelperImpl(this);
    this.mPagerSnapHelper.attachToRecyclerView(this.mRecyclerView);
    this.mRecyclerView.addOnScrollListener(this.mScrollEventAdapter);
    this.mPageChangeEventDispatcher = new CompositeOnPageChangeCallback(3);
    this.mScrollEventAdapter.setOnPageChangeCallback(this.mPageChangeEventDispatcher);
    paramContext = new ViewPager2.2(this);
    paramAttributeSet = new ViewPager2.3(this);
    this.mPageChangeEventDispatcher.addOnPageChangeCallback(paramContext);
    this.mPageChangeEventDispatcher.addOnPageChangeCallback(paramAttributeSet);
    this.mAccessibilityProvider.onInitialize(this.mPageChangeEventDispatcher, this.mRecyclerView);
    this.mPageChangeEventDispatcher.addOnPageChangeCallback(this.mExternalPageChangeCallbacks);
    this.mPageTransformerAdapter = new PageTransformerAdapter(this.mLayoutManager);
    this.mPageChangeEventDispatcher.addOnPageChangeCallback(this.mPageTransformerAdapter);
    paramContext = this.mRecyclerView;
    attachViewToParent(paramContext, 0, paramContext.getLayoutParams());
  }
  
  private void registerCurrentItemDataSetTracker(@Nullable RecyclerView.Adapter<?> paramAdapter)
  {
    if (paramAdapter != null) {
      paramAdapter.registerAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
    }
  }
  
  private void restorePendingState()
  {
    if (this.mPendingCurrentItem == -1) {
      return;
    }
    RecyclerView.Adapter localAdapter = getAdapter();
    if (localAdapter == null) {
      return;
    }
    Parcelable localParcelable = this.mPendingAdapterState;
    if (localParcelable != null)
    {
      if ((localAdapter instanceof StatefulAdapter)) {
        ((StatefulAdapter)localAdapter).restoreState(localParcelable);
      }
      this.mPendingAdapterState = null;
    }
    this.mCurrentItem = Math.max(0, Math.min(this.mPendingCurrentItem, localAdapter.getItemCount() - 1));
    this.mPendingCurrentItem = -1;
    this.mRecyclerView.scrollToPosition(this.mCurrentItem);
    this.mAccessibilityProvider.onRestorePendingState();
  }
  
  private void setOrientation(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViewPager2);
    if (Build.VERSION.SDK_INT >= 29) {
      saveAttributeDataForStyleable(paramContext, R.styleable.ViewPager2, paramAttributeSet, localTypedArray, 0, 0);
    }
    try
    {
      setOrientation(localTypedArray.getInt(R.styleable.ViewPager2_android_orientation, 0));
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
  
  private void unregisterCurrentItemDataSetTracker(@Nullable RecyclerView.Adapter<?> paramAdapter)
  {
    if (paramAdapter != null) {
      paramAdapter.unregisterAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
    }
  }
  
  public void addItemDecoration(@NonNull RecyclerView.ItemDecoration paramItemDecoration)
  {
    this.mRecyclerView.addItemDecoration(paramItemDecoration);
  }
  
  public void addItemDecoration(@NonNull RecyclerView.ItemDecoration paramItemDecoration, int paramInt)
  {
    this.mRecyclerView.addItemDecoration(paramItemDecoration, paramInt);
  }
  
  public boolean beginFakeDrag()
  {
    return this.mFakeDragger.beginFakeDrag();
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return this.mRecyclerView.canScrollHorizontally(paramInt);
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return this.mRecyclerView.canScrollVertically(paramInt);
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    Parcelable localParcelable = (Parcelable)paramSparseArray.get(getId());
    if ((localParcelable instanceof ViewPager2.SavedState))
    {
      int i = ((ViewPager2.SavedState)localParcelable).mRecyclerViewId;
      paramSparseArray.put(this.mRecyclerView.getId(), paramSparseArray.get(i));
      paramSparseArray.remove(i);
    }
    super.dispatchRestoreInstanceState(paramSparseArray);
    restorePendingState();
  }
  
  public boolean endFakeDrag()
  {
    return this.mFakeDragger.endFakeDrag();
  }
  
  public boolean fakeDragBy(@SuppressLint({"SupportAnnotationUsage"}) @Px float paramFloat)
  {
    return this.mFakeDragger.fakeDragBy(paramFloat);
  }
  
  @RequiresApi(23)
  public CharSequence getAccessibilityClassName()
  {
    if (this.mAccessibilityProvider.handlesGetAccessibilityClassName()) {
      return this.mAccessibilityProvider.onGetAccessibilityClassName();
    }
    return super.getAccessibilityClassName();
  }
  
  @Nullable
  public RecyclerView.Adapter getAdapter()
  {
    return this.mRecyclerView.getAdapter();
  }
  
  public int getCurrentItem()
  {
    return this.mCurrentItem;
  }
  
  @NonNull
  public RecyclerView.ItemDecoration getItemDecorationAt(int paramInt)
  {
    return this.mRecyclerView.getItemDecorationAt(paramInt);
  }
  
  public int getItemDecorationCount()
  {
    return this.mRecyclerView.getItemDecorationCount();
  }
  
  public int getOffscreenPageLimit()
  {
    return this.mOffscreenPageLimit;
  }
  
  public int getOrientation()
  {
    return this.mLayoutManager.getOrientation();
  }
  
  int getPageSize()
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    int j;
    int i;
    if (getOrientation() == 0)
    {
      j = localRecyclerView.getWidth() - localRecyclerView.getPaddingLeft();
      i = localRecyclerView.getPaddingRight();
    }
    else
    {
      j = localRecyclerView.getHeight() - localRecyclerView.getPaddingTop();
      i = localRecyclerView.getPaddingBottom();
    }
    return j - i;
  }
  
  public int getScrollState()
  {
    return this.mScrollEventAdapter.getScrollState();
  }
  
  public void invalidateItemDecorations()
  {
    this.mRecyclerView.invalidateItemDecorations();
  }
  
  public boolean isFakeDragging()
  {
    return this.mFakeDragger.isFakeDragging();
  }
  
  boolean isRtl()
  {
    return this.mLayoutManager.getLayoutDirection() == 1;
  }
  
  public boolean isUserInputEnabled()
  {
    return this.mUserInputEnabled;
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    this.mAccessibilityProvider.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.mRecyclerView.getMeasuredWidth();
    int j = this.mRecyclerView.getMeasuredHeight();
    this.mTmpContainerRect.left = getPaddingLeft();
    this.mTmpContainerRect.right = (paramInt3 - paramInt1 - getPaddingRight());
    this.mTmpContainerRect.top = getPaddingTop();
    this.mTmpContainerRect.bottom = (paramInt4 - paramInt2 - getPaddingBottom());
    Gravity.apply(8388659, i, j, this.mTmpContainerRect, this.mTmpChildRect);
    this.mRecyclerView.layout(this.mTmpChildRect.left, this.mTmpChildRect.top, this.mTmpChildRect.right, this.mTmpChildRect.bottom);
    if (this.mCurrentItemDirty) {
      updateCurrentItem();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    measureChild(this.mRecyclerView, paramInt1, paramInt2);
    int n = this.mRecyclerView.getMeasuredWidth();
    int j = this.mRecyclerView.getMeasuredHeight();
    int i = this.mRecyclerView.getMeasuredState();
    int i1 = getPaddingLeft();
    int i2 = getPaddingRight();
    int k = getPaddingTop();
    int m = getPaddingBottom();
    n = Math.max(n + (i1 + i2), getSuggestedMinimumWidth());
    j = Math.max(j + (k + m), getSuggestedMinimumHeight());
    setMeasuredDimension(resolveSizeAndState(n, paramInt1, i), resolveSizeAndState(j, paramInt2, i << 16));
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ViewPager2.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (ViewPager2.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.mPendingCurrentItem = paramParcelable.mCurrentItem;
    this.mPendingAdapterState = paramParcelable.mAdapterState;
  }
  
  @Nullable
  protected Parcelable onSaveInstanceState()
  {
    ViewPager2.SavedState localSavedState = new ViewPager2.SavedState(super.onSaveInstanceState());
    localSavedState.mRecyclerViewId = this.mRecyclerView.getId();
    int j = this.mPendingCurrentItem;
    int i = j;
    if (j == -1) {
      i = this.mCurrentItem;
    }
    localSavedState.mCurrentItem = i;
    Object localObject = this.mPendingAdapterState;
    if (localObject != null)
    {
      localSavedState.mAdapterState = ((Parcelable)localObject);
      return localSavedState;
    }
    localObject = this.mRecyclerView.getAdapter();
    if ((localObject instanceof StatefulAdapter)) {
      localSavedState.mAdapterState = ((StatefulAdapter)localObject).saveState();
    }
    return localSavedState;
  }
  
  public void onViewAdded(View paramView)
  {
    paramView = new StringBuilder();
    paramView.append(getClass().getSimpleName());
    paramView.append(" does not support direct child views");
    throw new IllegalStateException(paramView.toString());
  }
  
  @RequiresApi(16)
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    if (this.mAccessibilityProvider.handlesPerformAccessibilityAction(paramInt, paramBundle)) {
      return this.mAccessibilityProvider.onPerformAccessibilityAction(paramInt, paramBundle);
    }
    return super.performAccessibilityAction(paramInt, paramBundle);
  }
  
  public void registerOnPageChangeCallback(@NonNull ViewPager2.OnPageChangeCallback paramOnPageChangeCallback)
  {
    this.mExternalPageChangeCallbacks.addOnPageChangeCallback(paramOnPageChangeCallback);
  }
  
  public void removeItemDecoration(@NonNull RecyclerView.ItemDecoration paramItemDecoration)
  {
    this.mRecyclerView.removeItemDecoration(paramItemDecoration);
  }
  
  public void removeItemDecorationAt(int paramInt)
  {
    this.mRecyclerView.removeItemDecorationAt(paramInt);
  }
  
  public void requestTransform()
  {
    if (this.mPageTransformerAdapter.getPageTransformer() == null) {
      return;
    }
    double d1 = this.mScrollEventAdapter.getRelativeScrollPosition();
    int i = (int)d1;
    double d2 = i;
    Double.isNaN(d2);
    float f = (float)(d1 - d2);
    int j = Math.round(getPageSize() * f);
    this.mPageTransformerAdapter.onPageScrolled(i, f, j);
  }
  
  public void setAdapter(@Nullable RecyclerView.Adapter paramAdapter)
  {
    RecyclerView.Adapter localAdapter = this.mRecyclerView.getAdapter();
    this.mAccessibilityProvider.onDetachAdapter(localAdapter);
    unregisterCurrentItemDataSetTracker(localAdapter);
    this.mRecyclerView.setAdapter(paramAdapter);
    this.mCurrentItem = 0;
    restorePendingState();
    this.mAccessibilityProvider.onAttachAdapter(paramAdapter);
    registerCurrentItemDataSetTracker(paramAdapter);
  }
  
  public void setCurrentItem(int paramInt)
  {
    setCurrentItem(paramInt, true);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    if (!isFakeDragging())
    {
      setCurrentItemInternal(paramInt, paramBoolean);
      return;
    }
    throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
  }
  
  void setCurrentItemInternal(int paramInt, boolean paramBoolean)
  {
    Object localObject = getAdapter();
    if (localObject == null)
    {
      if (this.mPendingCurrentItem != -1) {
        this.mPendingCurrentItem = Math.max(paramInt, 0);
      }
      return;
    }
    if (((RecyclerView.Adapter)localObject).getItemCount() <= 0) {
      return;
    }
    int i = Math.min(Math.max(paramInt, 0), ((RecyclerView.Adapter)localObject).getItemCount() - 1);
    if ((i == this.mCurrentItem) && (this.mScrollEventAdapter.isIdle())) {
      return;
    }
    if ((i == this.mCurrentItem) && (paramBoolean)) {
      return;
    }
    double d1 = this.mCurrentItem;
    this.mCurrentItem = i;
    this.mAccessibilityProvider.onSetNewCurrentItem();
    if (!this.mScrollEventAdapter.isIdle()) {
      d1 = this.mScrollEventAdapter.getRelativeScrollPosition();
    }
    this.mScrollEventAdapter.notifyProgrammaticScroll(i, paramBoolean);
    if (!paramBoolean)
    {
      this.mRecyclerView.scrollToPosition(i);
      return;
    }
    double d2 = i;
    Double.isNaN(d2);
    if (Math.abs(d2 - d1) > 3.0D)
    {
      localObject = this.mRecyclerView;
      if (d2 > d1) {
        paramInt = i - 3;
      } else {
        paramInt = i + 3;
      }
      ((RecyclerView)localObject).scrollToPosition(paramInt);
      localObject = this.mRecyclerView;
      ((RecyclerView)localObject).post(new ViewPager2.SmoothScrollToPosition(i, (RecyclerView)localObject));
      return;
    }
    this.mRecyclerView.smoothScrollToPosition(i);
  }
  
  @RequiresApi(17)
  public void setLayoutDirection(int paramInt)
  {
    super.setLayoutDirection(paramInt);
    this.mAccessibilityProvider.onSetLayoutDirection();
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    if ((paramInt < 1) && (paramInt != -1)) {
      throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }
    this.mOffscreenPageLimit = paramInt;
    this.mRecyclerView.requestLayout();
  }
  
  public void setOrientation(int paramInt)
  {
    this.mLayoutManager.setOrientation(paramInt);
    this.mAccessibilityProvider.onSetOrientation();
  }
  
  public void setPageTransformer(@Nullable ViewPager2.PageTransformer paramPageTransformer)
  {
    if (paramPageTransformer != null)
    {
      if (!this.mSavedItemAnimatorPresent)
      {
        this.mSavedItemAnimator = this.mRecyclerView.getItemAnimator();
        this.mSavedItemAnimatorPresent = true;
      }
      this.mRecyclerView.setItemAnimator(null);
    }
    else if (this.mSavedItemAnimatorPresent)
    {
      this.mRecyclerView.setItemAnimator(this.mSavedItemAnimator);
      this.mSavedItemAnimator = null;
      this.mSavedItemAnimatorPresent = false;
    }
    if (paramPageTransformer == this.mPageTransformerAdapter.getPageTransformer()) {
      return;
    }
    this.mPageTransformerAdapter.setPageTransformer(paramPageTransformer);
    requestTransform();
  }
  
  public void setUserInputEnabled(boolean paramBoolean)
  {
    this.mUserInputEnabled = paramBoolean;
    this.mAccessibilityProvider.onSetUserInputEnabled();
  }
  
  void snapToPage()
  {
    Object localObject = this.mPagerSnapHelper.findSnapView(this.mLayoutManager);
    if (localObject == null) {
      return;
    }
    localObject = this.mPagerSnapHelper.calculateDistanceToFinalSnap(this.mLayoutManager, (View)localObject);
    if ((localObject[0] != 0) || (localObject[1] != 0)) {
      this.mRecyclerView.smoothScrollBy(localObject[0], localObject[1]);
    }
  }
  
  public void unregisterOnPageChangeCallback(@NonNull ViewPager2.OnPageChangeCallback paramOnPageChangeCallback)
  {
    this.mExternalPageChangeCallbacks.removeOnPageChangeCallback(paramOnPageChangeCallback);
  }
  
  void updateCurrentItem()
  {
    Object localObject = this.mPagerSnapHelper;
    if (localObject != null)
    {
      localObject = ((PagerSnapHelper)localObject).findSnapView(this.mLayoutManager);
      if (localObject == null) {
        return;
      }
      int i = this.mLayoutManager.getPosition((View)localObject);
      if ((i != this.mCurrentItem) && (getScrollState() == 0)) {
        this.mPageChangeEventDispatcher.onPageSelected(i);
      }
      this.mCurrentItemDirty = false;
      return;
    }
    throw new IllegalStateException("Design assumption violated.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.viewpager2.widget.ViewPager2
 * JD-Core Version:    0.7.0.1
 */