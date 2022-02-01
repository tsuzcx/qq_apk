package androidx.recyclerview.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R.dimen;
import java.util.ArrayList;
import java.util.List;

public class ItemTouchHelper
  extends RecyclerView.ItemDecoration
  implements RecyclerView.OnChildAttachStateChangeListener
{
  static final int ACTION_MODE_DRAG_MASK = 16711680;
  private static final int ACTION_MODE_IDLE_MASK = 255;
  static final int ACTION_MODE_SWIPE_MASK = 65280;
  public static final int ACTION_STATE_DRAG = 2;
  public static final int ACTION_STATE_IDLE = 0;
  public static final int ACTION_STATE_SWIPE = 1;
  private static final int ACTIVE_POINTER_ID_NONE = -1;
  public static final int ANIMATION_TYPE_DRAG = 8;
  public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
  public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
  private static final boolean DEBUG = false;
  static final int DIRECTION_FLAG_COUNT = 8;
  public static final int DOWN = 2;
  public static final int END = 32;
  public static final int LEFT = 4;
  private static final int PIXELS_PER_SECOND = 1000;
  public static final int RIGHT = 8;
  public static final int START = 16;
  private static final String TAG = "ItemTouchHelper";
  public static final int UP = 1;
  private int mActionState = 0;
  int mActivePointerId = -1;
  @NonNull
  ItemTouchHelper.Callback mCallback;
  private RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback = null;
  private List<Integer> mDistances;
  private long mDragScrollStartTimeInMs;
  float mDx;
  float mDy;
  GestureDetectorCompat mGestureDetector;
  float mInitialTouchX;
  float mInitialTouchY;
  private ItemTouchHelper.ItemTouchHelperGestureListener mItemTouchHelperGestureListener;
  private float mMaxSwipeVelocity;
  private final RecyclerView.OnItemTouchListener mOnItemTouchListener = new ItemTouchHelper.2(this);
  View mOverdrawChild = null;
  int mOverdrawChildPosition = -1;
  final List<View> mPendingCleanup = new ArrayList();
  List<ItemTouchHelper.RecoverAnimation> mRecoverAnimations = new ArrayList();
  RecyclerView mRecyclerView;
  final Runnable mScrollRunnable = new ItemTouchHelper.1(this);
  RecyclerView.ViewHolder mSelected = null;
  int mSelectedFlags;
  private float mSelectedStartX;
  private float mSelectedStartY;
  private int mSlop;
  private List<RecyclerView.ViewHolder> mSwapTargets;
  private float mSwipeEscapeVelocity;
  private final float[] mTmpPosition = new float[2];
  private Rect mTmpRect;
  VelocityTracker mVelocityTracker;
  
  public ItemTouchHelper(@NonNull ItemTouchHelper.Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  private void addChildDrawingOrderCallback()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return;
    }
    if (this.mChildDrawingOrderCallback == null) {
      this.mChildDrawingOrderCallback = new ItemTouchHelper.5(this);
    }
    this.mRecyclerView.setChildDrawingOrderCallback(this.mChildDrawingOrderCallback);
  }
  
  private int checkHorizontalSwipe(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramInt & 0xC) != 0)
    {
      float f1 = this.mDx;
      int j = 8;
      int i;
      if (f1 > 0.0F) {
        i = 8;
      } else {
        i = 4;
      }
      VelocityTracker localVelocityTracker = this.mVelocityTracker;
      if ((localVelocityTracker != null) && (this.mActivePointerId > -1))
      {
        localVelocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
        f2 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        f1 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (f2 <= 0.0F) {
          j = 4;
        }
        f2 = Math.abs(f2);
        if (((j & paramInt) != 0) && (i == j) && (f2 >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) && (f2 > Math.abs(f1))) {
          return j;
        }
      }
      f1 = this.mRecyclerView.getWidth();
      float f2 = this.mCallback.getSwipeThreshold(paramViewHolder);
      if (((paramInt & i) != 0) && (Math.abs(this.mDx) > f1 * f2)) {
        return i;
      }
    }
    return 0;
  }
  
  private int checkVerticalSwipe(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramInt & 0x3) != 0)
    {
      float f1 = this.mDy;
      int j = 2;
      int i;
      if (f1 > 0.0F) {
        i = 2;
      } else {
        i = 1;
      }
      VelocityTracker localVelocityTracker = this.mVelocityTracker;
      if ((localVelocityTracker != null) && (this.mActivePointerId > -1))
      {
        localVelocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
        f1 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        f2 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (f2 <= 0.0F) {
          j = 1;
        }
        f2 = Math.abs(f2);
        if (((j & paramInt) != 0) && (j == i) && (f2 >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) && (f2 > Math.abs(f1))) {
          return j;
        }
      }
      f1 = this.mRecyclerView.getHeight();
      float f2 = this.mCallback.getSwipeThreshold(paramViewHolder);
      if (((paramInt & i) != 0) && (Math.abs(this.mDy) > f1 * f2)) {
        return i;
      }
    }
    return 0;
  }
  
  private void destroyCallbacks()
  {
    this.mRecyclerView.removeItemDecoration(this);
    this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
    this.mRecyclerView.removeOnChildAttachStateChangeListener(this);
    int i = this.mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      ItemTouchHelper.RecoverAnimation localRecoverAnimation = (ItemTouchHelper.RecoverAnimation)this.mRecoverAnimations.get(0);
      this.mCallback.clearView(this.mRecyclerView, localRecoverAnimation.mViewHolder);
      i -= 1;
    }
    this.mRecoverAnimations.clear();
    this.mOverdrawChild = null;
    this.mOverdrawChildPosition = -1;
    releaseVelocityTracker();
    stopGestureDetection();
  }
  
  private List<RecyclerView.ViewHolder> findSwapTargets(RecyclerView.ViewHolder paramViewHolder)
  {
    Object localObject1 = paramViewHolder;
    Object localObject2 = this.mSwapTargets;
    if (localObject2 == null)
    {
      this.mSwapTargets = new ArrayList();
      this.mDistances = new ArrayList();
    }
    else
    {
      ((List)localObject2).clear();
      this.mDistances.clear();
    }
    int j = this.mCallback.getBoundingBoxMargin();
    int m = Math.round(this.mSelectedStartX + this.mDx) - j;
    int n = Math.round(this.mSelectedStartY + this.mDy) - j;
    int i = ((RecyclerView.ViewHolder)localObject1).itemView.getWidth();
    j *= 2;
    int i1 = i + m + j;
    int i2 = ((RecyclerView.ViewHolder)localObject1).itemView.getHeight() + n + j;
    int i3 = (m + i1) / 2;
    int i4 = (n + i2) / 2;
    localObject1 = this.mRecyclerView.getLayoutManager();
    int i5 = ((RecyclerView.LayoutManager)localObject1).getChildCount();
    i = 0;
    while (i < i5)
    {
      localObject2 = ((RecyclerView.LayoutManager)localObject1).getChildAt(i);
      if ((localObject2 != paramViewHolder.itemView) && (((View)localObject2).getBottom() >= n) && (((View)localObject2).getTop() <= i2) && (((View)localObject2).getRight() >= m) && (((View)localObject2).getLeft() <= i1))
      {
        RecyclerView.ViewHolder localViewHolder = this.mRecyclerView.getChildViewHolder((View)localObject2);
        if (this.mCallback.canDropOver(this.mRecyclerView, this.mSelected, localViewHolder))
        {
          j = Math.abs(i3 - (((View)localObject2).getLeft() + ((View)localObject2).getRight()) / 2);
          int k = Math.abs(i4 - (((View)localObject2).getTop() + ((View)localObject2).getBottom()) / 2);
          int i6 = j * j + k * k;
          int i7 = this.mSwapTargets.size();
          j = 0;
          k = 0;
          while ((j < i7) && (i6 > ((Integer)this.mDistances.get(j)).intValue()))
          {
            k += 1;
            j += 1;
          }
          this.mSwapTargets.add(k, localViewHolder);
          this.mDistances.add(k, Integer.valueOf(i6));
        }
      }
      i += 1;
    }
    return this.mSwapTargets;
  }
  
  private RecyclerView.ViewHolder findSwipedView(MotionEvent paramMotionEvent)
  {
    RecyclerView.LayoutManager localLayoutManager = this.mRecyclerView.getLayoutManager();
    int i = this.mActivePointerId;
    if (i == -1) {
      return null;
    }
    i = paramMotionEvent.findPointerIndex(i);
    float f3 = paramMotionEvent.getX(i);
    float f4 = this.mInitialTouchX;
    float f1 = paramMotionEvent.getY(i);
    float f2 = this.mInitialTouchY;
    f3 = Math.abs(f3 - f4);
    f1 = Math.abs(f1 - f2);
    i = this.mSlop;
    if ((f3 < i) && (f1 < i)) {
      return null;
    }
    if ((f3 > f1) && (localLayoutManager.canScrollHorizontally())) {
      return null;
    }
    if ((f1 > f3) && (localLayoutManager.canScrollVertically())) {
      return null;
    }
    paramMotionEvent = findChildView(paramMotionEvent);
    if (paramMotionEvent == null) {
      return null;
    }
    return this.mRecyclerView.getChildViewHolder(paramMotionEvent);
  }
  
  private void getSelectedDxDy(float[] paramArrayOfFloat)
  {
    if ((this.mSelectedFlags & 0xC) != 0) {
      paramArrayOfFloat[0] = (this.mSelectedStartX + this.mDx - this.mSelected.itemView.getLeft());
    } else {
      paramArrayOfFloat[0] = this.mSelected.itemView.getTranslationX();
    }
    if ((this.mSelectedFlags & 0x3) != 0)
    {
      paramArrayOfFloat[1] = (this.mSelectedStartY + this.mDy - this.mSelected.itemView.getTop());
      return;
    }
    paramArrayOfFloat[1] = this.mSelected.itemView.getTranslationY();
  }
  
  private static boolean hitTest(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (paramFloat1 >= paramFloat3) && (paramFloat1 <= paramFloat3 + paramView.getWidth()) && (paramFloat2 >= paramFloat4) && (paramFloat2 <= paramFloat4 + paramView.getHeight());
  }
  
  private void releaseVelocityTracker()
  {
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  private void setupCallbacks()
  {
    this.mSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
    this.mRecyclerView.addItemDecoration(this);
    this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
    this.mRecyclerView.addOnChildAttachStateChangeListener(this);
    startGestureDetection();
  }
  
  private void startGestureDetection()
  {
    this.mItemTouchHelperGestureListener = new ItemTouchHelper.ItemTouchHelperGestureListener(this);
    this.mGestureDetector = new GestureDetectorCompat(this.mRecyclerView.getContext(), this.mItemTouchHelperGestureListener);
  }
  
  private void stopGestureDetection()
  {
    ItemTouchHelper.ItemTouchHelperGestureListener localItemTouchHelperGestureListener = this.mItemTouchHelperGestureListener;
    if (localItemTouchHelperGestureListener != null)
    {
      localItemTouchHelperGestureListener.doNotReactToLongPress();
      this.mItemTouchHelperGestureListener = null;
    }
    if (this.mGestureDetector != null) {
      this.mGestureDetector = null;
    }
  }
  
  private int swipeIfNecessary(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.mActionState == 2) {
      return 0;
    }
    int j = this.mCallback.getMovementFlags(this.mRecyclerView, paramViewHolder);
    int i = (this.mCallback.convertToAbsoluteDirection(j, ViewCompat.getLayoutDirection(this.mRecyclerView)) & 0xFF00) >> 8;
    if (i == 0) {
      return 0;
    }
    int k = (j & 0xFF00) >> 8;
    if (Math.abs(this.mDx) > Math.abs(this.mDy))
    {
      j = checkHorizontalSwipe(paramViewHolder, i);
      if (j > 0)
      {
        if ((k & j) == 0) {
          return ItemTouchHelper.Callback.convertToRelativeDirection(j, ViewCompat.getLayoutDirection(this.mRecyclerView));
        }
        return j;
      }
      i = checkVerticalSwipe(paramViewHolder, i);
      if (i > 0) {
        return i;
      }
    }
    else
    {
      j = checkVerticalSwipe(paramViewHolder, i);
      if (j > 0) {
        return j;
      }
      j = checkHorizontalSwipe(paramViewHolder, i);
      if (j > 0)
      {
        i = j;
        if ((k & j) == 0) {
          i = ItemTouchHelper.Callback.convertToRelativeDirection(j, ViewCompat.getLayoutDirection(this.mRecyclerView));
        }
        return i;
      }
    }
    return 0;
  }
  
  public void attachToRecyclerView(@Nullable RecyclerView paramRecyclerView)
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView == paramRecyclerView) {
      return;
    }
    if (localRecyclerView != null) {
      destroyCallbacks();
    }
    this.mRecyclerView = paramRecyclerView;
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.getResources();
      this.mSwipeEscapeVelocity = paramRecyclerView.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
      this.mMaxSwipeVelocity = paramRecyclerView.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
      setupCallbacks();
    }
  }
  
  void checkSelectForSwipe(int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    if ((this.mSelected == null) && (paramInt1 == 2) && (this.mActionState != 2))
    {
      if (!this.mCallback.isItemViewSwipeEnabled()) {
        return;
      }
      if (this.mRecyclerView.getScrollState() == 1) {
        return;
      }
      RecyclerView.ViewHolder localViewHolder = findSwipedView(paramMotionEvent);
      if (localViewHolder == null) {
        return;
      }
      paramInt1 = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, localViewHolder) & 0xFF00) >> 8;
      if (paramInt1 == 0) {
        return;
      }
      float f1 = paramMotionEvent.getX(paramInt2);
      float f2 = paramMotionEvent.getY(paramInt2);
      f1 -= this.mInitialTouchX;
      f2 -= this.mInitialTouchY;
      float f3 = Math.abs(f1);
      float f4 = Math.abs(f2);
      paramInt2 = this.mSlop;
      if ((f3 < paramInt2) && (f4 < paramInt2)) {
        return;
      }
      if (f3 > f4)
      {
        if ((f1 < 0.0F) && ((paramInt1 & 0x4) == 0)) {
          return;
        }
        if ((f1 <= 0.0F) || ((paramInt1 & 0x8) != 0)) {}
      }
      else
      {
        if ((f2 < 0.0F) && ((paramInt1 & 0x1) == 0)) {
          return;
        }
        if ((f2 > 0.0F) && ((paramInt1 & 0x2) == 0)) {
          return;
        }
      }
      this.mDy = 0.0F;
      this.mDx = 0.0F;
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      select(localViewHolder, 1);
    }
  }
  
  void endRecoverAnimation(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    int i = this.mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      ItemTouchHelper.RecoverAnimation localRecoverAnimation = (ItemTouchHelper.RecoverAnimation)this.mRecoverAnimations.get(i);
      if (localRecoverAnimation.mViewHolder == paramViewHolder)
      {
        localRecoverAnimation.mOverridden |= paramBoolean;
        if (!localRecoverAnimation.mEnded) {
          localRecoverAnimation.cancel();
        }
        this.mRecoverAnimations.remove(i);
        return;
      }
      i -= 1;
    }
  }
  
  ItemTouchHelper.RecoverAnimation findAnimation(MotionEvent paramMotionEvent)
  {
    if (this.mRecoverAnimations.isEmpty()) {
      return null;
    }
    paramMotionEvent = findChildView(paramMotionEvent);
    int i = this.mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      ItemTouchHelper.RecoverAnimation localRecoverAnimation = (ItemTouchHelper.RecoverAnimation)this.mRecoverAnimations.get(i);
      if (localRecoverAnimation.mViewHolder.itemView == paramMotionEvent) {
        return localRecoverAnimation;
      }
      i -= 1;
    }
    return null;
  }
  
  View findChildView(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    paramMotionEvent = this.mSelected;
    if (paramMotionEvent != null)
    {
      paramMotionEvent = paramMotionEvent.itemView;
      if (hitTest(paramMotionEvent, f1, f2, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy)) {
        return paramMotionEvent;
      }
    }
    int i = this.mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      paramMotionEvent = (ItemTouchHelper.RecoverAnimation)this.mRecoverAnimations.get(i);
      View localView = paramMotionEvent.mViewHolder.itemView;
      if (hitTest(localView, f1, f2, paramMotionEvent.mX, paramMotionEvent.mY)) {
        return localView;
      }
      i -= 1;
    }
    return this.mRecyclerView.findChildViewUnder(f1, f2);
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.setEmpty();
  }
  
  boolean hasRunningRecoverAnim()
  {
    int j = this.mRecoverAnimations.size();
    int i = 0;
    while (i < j)
    {
      if (!((ItemTouchHelper.RecoverAnimation)this.mRecoverAnimations.get(i)).mEnded) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  void moveIfNecessary(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.mRecyclerView.isLayoutRequested()) {
      return;
    }
    if (this.mActionState != 2) {
      return;
    }
    float f = this.mCallback.getMoveThreshold(paramViewHolder);
    int i = (int)(this.mSelectedStartX + this.mDx);
    int j = (int)(this.mSelectedStartY + this.mDy);
    if ((Math.abs(j - paramViewHolder.itemView.getTop()) < paramViewHolder.itemView.getHeight() * f) && (Math.abs(i - paramViewHolder.itemView.getLeft()) < paramViewHolder.itemView.getWidth() * f)) {
      return;
    }
    Object localObject = findSwapTargets(paramViewHolder);
    if (((List)localObject).size() == 0) {
      return;
    }
    localObject = this.mCallback.chooseDropTarget(paramViewHolder, (List)localObject, i, j);
    if (localObject == null)
    {
      this.mSwapTargets.clear();
      this.mDistances.clear();
      return;
    }
    int k = ((RecyclerView.ViewHolder)localObject).getAdapterPosition();
    int m = paramViewHolder.getAdapterPosition();
    if (this.mCallback.onMove(this.mRecyclerView, paramViewHolder, (RecyclerView.ViewHolder)localObject)) {
      this.mCallback.onMoved(this.mRecyclerView, paramViewHolder, m, (RecyclerView.ViewHolder)localObject, k, i, j);
    }
  }
  
  void obtainVelocityTracker()
  {
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.recycle();
    }
    this.mVelocityTracker = VelocityTracker.obtain();
  }
  
  public void onChildViewAttachedToWindow(@NonNull View paramView) {}
  
  public void onChildViewDetachedFromWindow(@NonNull View paramView)
  {
    removeChildDrawingOrderCallbackIfNecessary(paramView);
    paramView = this.mRecyclerView.getChildViewHolder(paramView);
    if (paramView == null) {
      return;
    }
    RecyclerView.ViewHolder localViewHolder = this.mSelected;
    if ((localViewHolder != null) && (paramView == localViewHolder))
    {
      select(null, 0);
      return;
    }
    endRecoverAnimation(paramView, false);
    if (this.mPendingCleanup.remove(paramView.itemView)) {
      this.mCallback.clearView(this.mRecyclerView, paramView);
    }
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    this.mOverdrawChildPosition = -1;
    float f1;
    float f2;
    if (this.mSelected != null)
    {
      getSelectedDxDy(this.mTmpPosition);
      paramState = this.mTmpPosition;
      f1 = paramState[0];
      f2 = paramState[1];
    }
    else
    {
      f1 = 0.0F;
      f2 = 0.0F;
    }
    this.mCallback.onDraw(paramCanvas, paramRecyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f1, f2);
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    float f1;
    float f2;
    if (this.mSelected != null)
    {
      getSelectedDxDy(this.mTmpPosition);
      paramState = this.mTmpPosition;
      f1 = paramState[0];
      f2 = paramState[1];
    }
    else
    {
      f1 = 0.0F;
      f2 = 0.0F;
    }
    this.mCallback.onDrawOver(paramCanvas, paramRecyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f1, f2);
  }
  
  void postDispatchSwipe(ItemTouchHelper.RecoverAnimation paramRecoverAnimation, int paramInt)
  {
    this.mRecyclerView.post(new ItemTouchHelper.4(this, paramRecoverAnimation, paramInt));
  }
  
  void removeChildDrawingOrderCallbackIfNecessary(View paramView)
  {
    if (paramView == this.mOverdrawChild)
    {
      this.mOverdrawChild = null;
      if (this.mChildDrawingOrderCallback != null) {
        this.mRecyclerView.setChildDrawingOrderCallback(null);
      }
    }
  }
  
  boolean scrollIfNecessary()
  {
    if (this.mSelected == null)
    {
      this.mDragScrollStartTimeInMs = -9223372036854775808L;
      return false;
    }
    long l2 = System.currentTimeMillis();
    long l1 = this.mDragScrollStartTimeInMs;
    if (l1 == -9223372036854775808L) {
      l1 = 0L;
    } else {
      l1 = l2 - l1;
    }
    RecyclerView.LayoutManager localLayoutManager = this.mRecyclerView.getLayoutManager();
    if (this.mTmpRect == null) {
      this.mTmpRect = new Rect();
    }
    localLayoutManager.calculateItemDecorationsForChild(this.mSelected.itemView, this.mTmpRect);
    if (localLayoutManager.canScrollHorizontally())
    {
      j = (int)(this.mSelectedStartX + this.mDx);
      i = j - this.mTmpRect.left - this.mRecyclerView.getPaddingLeft();
      if ((this.mDx < 0.0F) && (i < 0)) {
        break label200;
      }
      if (this.mDx > 0.0F)
      {
        i = j + this.mSelected.itemView.getWidth() + this.mTmpRect.right - (this.mRecyclerView.getWidth() - this.mRecyclerView.getPaddingRight());
        if (i > 0) {
          break label200;
        }
      }
    }
    int i = 0;
    label200:
    if (localLayoutManager.canScrollVertically())
    {
      k = (int)(this.mSelectedStartY + this.mDy);
      j = k - this.mTmpRect.top - this.mRecyclerView.getPaddingTop();
      if ((this.mDy < 0.0F) && (j < 0)) {
        break label308;
      }
      if (this.mDy > 0.0F)
      {
        j = k + this.mSelected.itemView.getHeight() + this.mTmpRect.bottom - (this.mRecyclerView.getHeight() - this.mRecyclerView.getPaddingBottom());
        if (j > 0) {
          break label308;
        }
      }
    }
    int j = 0;
    label308:
    int k = i;
    if (i != 0) {
      k = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getWidth(), i, this.mRecyclerView.getWidth(), l1);
    }
    if (j != 0) {
      j = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getHeight(), j, this.mRecyclerView.getHeight(), l1);
    }
    if ((k == 0) && (j == 0))
    {
      this.mDragScrollStartTimeInMs = -9223372036854775808L;
      return false;
    }
    if (this.mDragScrollStartTimeInMs == -9223372036854775808L) {
      this.mDragScrollStartTimeInMs = l2;
    }
    this.mRecyclerView.scrollBy(k, j);
    return true;
  }
  
  void select(@Nullable RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder == this.mSelected) && (paramInt == this.mActionState)) {
      return;
    }
    this.mDragScrollStartTimeInMs = -9223372036854775808L;
    int k = this.mActionState;
    endRecoverAnimation(paramViewHolder, true);
    this.mActionState = paramInt;
    if (paramInt == 2) {
      if (paramViewHolder != null)
      {
        this.mOverdrawChild = paramViewHolder.itemView;
        addChildDrawingOrderCallback();
      }
      else
      {
        throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
      }
    }
    Object localObject = this.mSelected;
    int i;
    if (localObject != null)
    {
      if (((RecyclerView.ViewHolder)localObject).itemView.getParent() != null)
      {
        int j;
        if (k == 2) {
          j = 0;
        } else {
          j = swipeIfNecessary((RecyclerView.ViewHolder)localObject);
        }
        releaseVelocityTracker();
        if ((j != 1) && (j != 2))
        {
          if ((j != 4) && (j != 8) && (j != 16) && (j != 32)) {}
          for (f1 = 0.0F;; f1 = Math.signum(this.mDx) * this.mRecyclerView.getWidth())
          {
            f2 = 0.0F;
            break;
          }
        }
        float f2 = Math.signum(this.mDy) * this.mRecyclerView.getHeight();
        float f1 = 0.0F;
        if (k == 2) {
          i = 8;
        } else if (j > 0) {
          i = 2;
        } else {
          i = 4;
        }
        getSelectedDxDy(this.mTmpPosition);
        float[] arrayOfFloat = this.mTmpPosition;
        float f3 = arrayOfFloat[0];
        float f4 = arrayOfFloat[1];
        localObject = new ItemTouchHelper.3(this, (RecyclerView.ViewHolder)localObject, i, k, f3, f4, f1, f2, j, (RecyclerView.ViewHolder)localObject);
        ((ItemTouchHelper.RecoverAnimation)localObject).setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, i, f1 - f3, f2 - f4));
        this.mRecoverAnimations.add(localObject);
        ((ItemTouchHelper.RecoverAnimation)localObject).start();
        i = 1;
      }
      else
      {
        removeChildDrawingOrderCallbackIfNecessary(((RecyclerView.ViewHolder)localObject).itemView);
        this.mCallback.clearView(this.mRecyclerView, (RecyclerView.ViewHolder)localObject);
        i = 0;
      }
      this.mSelected = null;
    }
    else
    {
      i = 0;
    }
    if (paramViewHolder != null)
    {
      this.mSelectedFlags = ((this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, paramViewHolder) & (1 << paramInt * 8 + 8) - 1) >> this.mActionState * 8);
      this.mSelectedStartX = paramViewHolder.itemView.getLeft();
      this.mSelectedStartY = paramViewHolder.itemView.getTop();
      this.mSelected = paramViewHolder;
      if (paramInt == 2) {
        this.mSelected.itemView.performHapticFeedback(0);
      }
    }
    boolean bool = false;
    paramViewHolder = this.mRecyclerView.getParent();
    if (paramViewHolder != null)
    {
      if (this.mSelected != null) {
        bool = true;
      }
      paramViewHolder.requestDisallowInterceptTouchEvent(bool);
    }
    if (i == 0) {
      this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
    }
    this.mCallback.onSelectedChanged(this.mSelected, this.mActionState);
    this.mRecyclerView.invalidate();
  }
  
  public void startDrag(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    if (!this.mCallback.hasDragFlag(this.mRecyclerView, paramViewHolder))
    {
      Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
      return;
    }
    if (paramViewHolder.itemView.getParent() != this.mRecyclerView)
    {
      Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
      return;
    }
    obtainVelocityTracker();
    this.mDy = 0.0F;
    this.mDx = 0.0F;
    select(paramViewHolder, 2);
  }
  
  public void startSwipe(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    if (!this.mCallback.hasSwipeFlag(this.mRecyclerView, paramViewHolder))
    {
      Log.e("ItemTouchHelper", "Start swipe has been called but swiping is not enabled");
      return;
    }
    if (paramViewHolder.itemView.getParent() != this.mRecyclerView)
    {
      Log.e("ItemTouchHelper", "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
      return;
    }
    obtainVelocityTracker();
    this.mDy = 0.0F;
    this.mDx = 0.0F;
    select(paramViewHolder, 1);
  }
  
  void updateDxDy(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    float f1 = paramMotionEvent.getX(paramInt2);
    float f2 = paramMotionEvent.getY(paramInt2);
    this.mDx = (f1 - this.mInitialTouchX);
    this.mDy = (f2 - this.mInitialTouchY);
    if ((paramInt1 & 0x4) == 0) {
      this.mDx = Math.max(0.0F, this.mDx);
    }
    if ((paramInt1 & 0x8) == 0) {
      this.mDx = Math.min(0.0F, this.mDx);
    }
    if ((paramInt1 & 0x1) == 0) {
      this.mDy = Math.max(0.0F, this.mDy);
    }
    if ((paramInt1 & 0x2) == 0) {
      this.mDy = Math.min(0.0F, this.mDy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.ItemTouchHelper
 * JD-Core Version:    0.7.0.1
 */