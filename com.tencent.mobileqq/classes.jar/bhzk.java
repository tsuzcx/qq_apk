import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ChildDrawingOrderCallback;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper.1;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper.4;
import java.util.ArrayList;
import java.util.List;

public class bhzk
  extends RecyclerView.ItemDecoration
  implements RecyclerView.OnChildAttachStateChangeListener
{
  static final int ACTION_MODE_DRAG_MASK = 16711680;
  private static final int ACTION_MODE_IDLE_MASK = 255;
  static final int ACTION_MODE_SWIPE_MASK = 65280;
  public static final int ACTION_STATE_DRAG = 2;
  public static final int ACTION_STATE_IDLE = 0;
  public static final int ACTION_STATE_SWIPE = 1;
  static final int ACTIVE_POINTER_ID_NONE = -1;
  public static final int ANIMATION_TYPE_DRAG = 8;
  public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
  public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
  static final boolean DEBUG = false;
  static final int DIRECTION_FLAG_COUNT = 8;
  public static final int DOWN = 2;
  public static final int END = 32;
  public static final int LEFT = 4;
  private static final int PIXELS_PER_SECOND = 1000;
  public static final int RIGHT = 8;
  public static final int START = 16;
  static final String TAG = "ItemTouchHelper";
  public static final int UP = 1;
  int mActionState = 0;
  int mActivePointerId = -1;
  public bhzo mCallback;
  private RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback;
  private List<Integer> mDistances;
  private long mDragScrollStartTimeInMs;
  float mDx;
  float mDy;
  bhzf mGestureDetector;
  float mInitialTouchX;
  float mInitialTouchY;
  float mMaxSwipeVelocity;
  private final RecyclerView.OnItemTouchListener mOnItemTouchListener = new bhzl(this);
  View mOverdrawChild = null;
  int mOverdrawChildPosition = -1;
  final List<View> mPendingCleanup = new ArrayList();
  List<bhzs> mRecoverAnimations = new ArrayList();
  public RecyclerView mRecyclerView;
  public final Runnable mScrollRunnable = new ItemTouchHelper.1(this);
  public RecyclerView.ViewHolder mSelected = null;
  int mSelectedFlags;
  float mSelectedStartX;
  float mSelectedStartY;
  private int mSlop;
  private List<RecyclerView.ViewHolder> mSwapTargets;
  float mSwipeEscapeVelocity;
  private final float[] mTmpPosition = new float[2];
  private Rect mTmpRect;
  VelocityTracker mVelocityTracker;
  
  public bhzk(bhzo parambhzo)
  {
    this.mCallback = parambhzo;
  }
  
  private void addChildDrawingOrderCallback()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return;
    }
    if (this.mChildDrawingOrderCallback == null) {
      this.mChildDrawingOrderCallback = new bhzn(this);
    }
    this.mRecyclerView.setChildDrawingOrderCallback(this.mChildDrawingOrderCallback);
  }
  
  private int checkHorizontalSwipe(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int j = 8;
    if ((paramInt & 0xC) != 0)
    {
      int i;
      if (this.mDx > 0.0F)
      {
        i = 8;
        if ((this.mVelocityTracker == null) || (this.mActivePointerId <= -1)) {
          break label155;
        }
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
        f2 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        f1 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (f2 <= 0.0F) {
          break label149;
        }
      }
      for (;;)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (i != j) || (f2 < this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) || (f2 <= Math.abs(f1))) {
          break label155;
        }
        return j;
        i = 4;
        break;
        label149:
        j = 4;
      }
      label155:
      float f1 = this.mRecyclerView.getWidth();
      float f2 = this.mCallback.getSwipeThreshold(paramViewHolder);
      if (((paramInt & i) != 0) && (Math.abs(this.mDx) > f1 * f2)) {
        return i;
      }
    }
    return 0;
  }
  
  private int checkVerticalSwipe(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int j = 2;
    if ((paramInt & 0x3) != 0)
    {
      int i;
      if (this.mDy > 0.0F)
      {
        i = 2;
        if ((this.mVelocityTracker == null) || (this.mActivePointerId <= -1)) {
          break label152;
        }
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
        f1 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        f2 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (f2 <= 0.0F) {
          break label146;
        }
      }
      for (;;)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (j != i) || (f2 < this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) || (f2 <= Math.abs(f1))) {
          break label152;
        }
        return j;
        i = 1;
        break;
        label146:
        j = 1;
      }
      label152:
      float f1 = this.mRecyclerView.getHeight();
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
      bhzs localbhzs = (bhzs)this.mRecoverAnimations.get(0);
      this.mCallback.clearView(this.mRecyclerView, localbhzs.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
      i -= 1;
    }
    this.mRecoverAnimations.clear();
    this.mOverdrawChild = null;
    this.mOverdrawChildPosition = -1;
    releaseVelocityTracker();
  }
  
  private List<RecyclerView.ViewHolder> findSwapTargets(RecyclerView.ViewHolder paramViewHolder)
  {
    int i;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    label137:
    View localView;
    if (this.mSwapTargets == null)
    {
      this.mSwapTargets = new ArrayList();
      this.mDistances = new ArrayList();
      i = this.mCallback.getBoundingBoxMargin();
      m = Math.round(this.mSelectedStartX + this.mDx) - i;
      n = Math.round(this.mSelectedStartY + this.mDy) - i;
      i1 = paramViewHolder.itemView.getWidth() + m + i * 2;
      i2 = paramViewHolder.itemView.getHeight() + n + i * 2;
      i3 = (m + i1) / 2;
      i4 = (n + i2) / 2;
      RecyclerView.LayoutManager localLayoutManager = this.mRecyclerView.getLayoutManager();
      int i5 = localLayoutManager.getChildCount();
      i = 0;
      if (i >= i5) {
        break label403;
      }
      localView = localLayoutManager.getChildAt(i);
      if (localView != paramViewHolder.itemView) {
        break label188;
      }
    }
    for (;;)
    {
      i += 1;
      break label137;
      this.mSwapTargets.clear();
      this.mDistances.clear();
      break;
      label188:
      if ((localView.getBottom() >= n) && (localView.getTop() <= i2) && (localView.getRight() >= m) && (localView.getLeft() <= i1))
      {
        RecyclerView.ViewHolder localViewHolder = this.mRecyclerView.getChildViewHolder(localView);
        if (this.mCallback.canDropOver(this.mRecyclerView, this.mSelected, localViewHolder))
        {
          int j = Math.abs(i3 - (localView.getLeft() + localView.getRight()) / 2);
          int k = localView.getTop();
          k = Math.abs(i4 - (localView.getBottom() + k) / 2);
          int i6 = j * j + k * k;
          int i7 = this.mSwapTargets.size();
          k = 0;
          j = 0;
          while ((j < i7) && (i6 > ((Integer)this.mDistances.get(j)).intValue()))
          {
            k += 1;
            j += 1;
          }
          this.mSwapTargets.add(k, localViewHolder);
          this.mDistances.add(k, Integer.valueOf(i6));
        }
      }
    }
    label403:
    return this.mSwapTargets;
  }
  
  private RecyclerView.ViewHolder findSwipedView(MotionEvent paramMotionEvent)
  {
    RecyclerView.LayoutManager localLayoutManager = this.mRecyclerView.getLayoutManager();
    if (this.mActivePointerId == -1) {}
    do
    {
      float f3;
      float f1;
      do
      {
        return null;
        int i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        f3 = paramMotionEvent.getX(i);
        float f4 = this.mInitialTouchX;
        f1 = paramMotionEvent.getY(i);
        float f2 = this.mInitialTouchY;
        f3 = Math.abs(f3 - f4);
        f1 = Math.abs(f1 - f2);
      } while (((f3 < this.mSlop) && (f1 < this.mSlop)) || ((f3 > f1) && (localLayoutManager.canScrollHorizontally())) || ((f1 > f3) && (localLayoutManager.canScrollVertically())));
      paramMotionEvent = findChildView(paramMotionEvent);
    } while (paramMotionEvent == null);
    return this.mRecyclerView.getChildViewHolder(paramMotionEvent);
  }
  
  private void getSelectedDxDy(float[] paramArrayOfFloat)
  {
    if ((this.mSelectedFlags & 0xC) != 0) {
      paramArrayOfFloat[0] = (this.mSelectedStartX + this.mDx - this.mSelected.itemView.getLeft());
    }
    while ((this.mSelectedFlags & 0x3) != 0)
    {
      paramArrayOfFloat[1] = (this.mSelectedStartY + this.mDy - this.mSelected.itemView.getTop());
      return;
      paramArrayOfFloat[0] = this.mSelected.itemView.getTranslationX();
    }
    paramArrayOfFloat[1] = this.mSelected.itemView.getTranslationY();
  }
  
  private static boolean hitTest(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (paramFloat1 >= paramFloat3) && (paramFloat1 <= paramView.getWidth() + paramFloat3) && (paramFloat2 >= paramFloat4) && (paramFloat2 <= paramView.getHeight() + paramFloat4);
  }
  
  private void initGestureDetector()
  {
    if (this.mGestureDetector != null) {
      return;
    }
    this.mGestureDetector = new bhzf(this.mRecyclerView.getContext(), new bhzr(this));
  }
  
  private void releaseVelocityTracker()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  private void setupCallbacks()
  {
    this.mSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
    this.mRecyclerView.addItemDecoration(this);
    this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
    this.mRecyclerView.addOnChildAttachStateChangeListener(this);
    initGestureDetector();
  }
  
  private int swipeIfNecessary(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.mActionState == 2) {}
    int j;
    int i;
    do
    {
      do
      {
        do
        {
          return 0;
          j = this.mCallback.getMovementFlags(this.mRecyclerView, paramViewHolder);
          i = (this.mCallback.convertToAbsoluteDirection(j, ViewCompat.getLayoutDirection(this.mRecyclerView)) & 0xFF00) >> 8;
        } while (i == 0);
        j = (j & 0xFF00) >> 8;
        if (Math.abs(this.mDx) <= Math.abs(this.mDy)) {
          break;
        }
        k = checkHorizontalSwipe(paramViewHolder, i);
        if (k > 0)
        {
          if ((j & k) == 0) {
            return bhzo.convertToRelativeDirection(k, ViewCompat.getLayoutDirection(this.mRecyclerView));
          }
          return k;
        }
        i = checkVerticalSwipe(paramViewHolder, i);
      } while (i <= 0);
      return i;
      int k = checkVerticalSwipe(paramViewHolder, i);
      if (k > 0) {
        return k;
      }
      i = checkHorizontalSwipe(paramViewHolder, i);
    } while (i <= 0);
    if ((j & i) == 0) {
      return bhzo.convertToRelativeDirection(i, ViewCompat.getLayoutDirection(this.mRecyclerView));
    }
    return i;
  }
  
  public void attachToRecyclerView(@Nullable RecyclerView paramRecyclerView)
  {
    if (this.mRecyclerView == paramRecyclerView) {}
    do
    {
      return;
      if (this.mRecyclerView != null) {
        destroyCallbacks();
      }
      this.mRecyclerView = paramRecyclerView;
    } while (this.mRecyclerView == null);
    paramRecyclerView = paramRecyclerView.getResources();
    this.mSwipeEscapeVelocity = paramRecyclerView.getDimension(2131297141);
    this.mMaxSwipeVelocity = paramRecyclerView.getDimension(2131297140);
    setupCallbacks();
  }
  
  boolean checkSelectForSwipe(int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    if ((this.mSelected != null) || (paramInt1 != 2) || (this.mActionState == 2) || (!this.mCallback.isItemViewSwipeEnabled())) {}
    RecyclerView.ViewHolder localViewHolder;
    float f1;
    float f2;
    do
    {
      float f3;
      float f4;
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
            } while (this.mRecyclerView.getScrollState() == 1);
            localViewHolder = findSwipedView(paramMotionEvent);
          } while (localViewHolder == null);
          paramInt1 = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, localViewHolder) & 0xFF00) >> 8;
        } while (paramInt1 == 0);
        f1 = paramMotionEvent.getX(paramInt2);
        f2 = paramMotionEvent.getY(paramInt2);
        f1 -= this.mInitialTouchX;
        f2 -= this.mInitialTouchY;
        f3 = Math.abs(f1);
        f4 = Math.abs(f2);
      } while ((f3 < this.mSlop) && (f4 < this.mSlop));
      if (f3 <= f4) {
        break;
      }
    } while (((f1 < 0.0F) && ((paramInt1 & 0x4) == 0)) || ((f1 > 0.0F) && ((paramInt1 & 0x8) == 0)));
    do
    {
      this.mDy = 0.0F;
      this.mDx = 0.0F;
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      select(localViewHolder, 1);
      return true;
      if ((f2 < 0.0F) && ((paramInt1 & 0x1) == 0)) {
        break;
      }
    } while ((f2 <= 0.0F) || ((paramInt1 & 0x2) != 0));
    return false;
  }
  
  int endRecoverAnimation(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    int i = this.mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      bhzs localbhzs = (bhzs)this.mRecoverAnimations.get(i);
      if (localbhzs.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == paramViewHolder)
      {
        localbhzs.jdField_b_of_type_Boolean |= paramBoolean;
        if (!localbhzs.jdField_c_of_type_Boolean) {
          localbhzs.b();
        }
        this.mRecoverAnimations.remove(i);
        return localbhzs.jdField_c_of_type_Int;
      }
      i -= 1;
    }
    return 0;
  }
  
  bhzs findAnimation(MotionEvent paramMotionEvent)
  {
    if (this.mRecoverAnimations.isEmpty())
    {
      paramMotionEvent = null;
      return paramMotionEvent;
    }
    View localView = findChildView(paramMotionEvent);
    int i = this.mRecoverAnimations.size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label74;
      }
      bhzs localbhzs = (bhzs)this.mRecoverAnimations.get(i);
      paramMotionEvent = localbhzs;
      if (localbhzs.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView == localView) {
        break;
      }
      i -= 1;
    }
    label74:
    return null;
  }
  
  View findChildView(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.mSelected != null)
    {
      paramMotionEvent = this.mSelected.itemView;
      if (hitTest(paramMotionEvent, f1, f2, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy)) {
        return paramMotionEvent;
      }
    }
    int i = this.mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      paramMotionEvent = (bhzs)this.mRecoverAnimations.get(i);
      View localView = paramMotionEvent.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView;
      if (hitTest(localView, f1, f2, paramMotionEvent.e, paramMotionEvent.f)) {
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
  
  public boolean hasRunningRecoverAnim()
  {
    int j = this.mRecoverAnimations.size();
    int i = 0;
    while (i < j)
    {
      if (!((bhzs)this.mRecoverAnimations.get(i)).jdField_c_of_type_Boolean) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void moveIfNecessary(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.mRecyclerView.isLayoutRequested()) {}
    label10:
    int i;
    int j;
    Object localObject;
    int k;
    int m;
    do
    {
      do
      {
        float f;
        do
        {
          break label10;
          do
          {
            return;
          } while (this.mActionState != 2);
          f = this.mCallback.getMoveThreshold(paramViewHolder);
          i = (int)(this.mSelectedStartX + this.mDx);
          j = (int)(this.mSelectedStartY + this.mDy);
        } while ((Math.abs(j - paramViewHolder.itemView.getTop()) < paramViewHolder.itemView.getHeight() * f) && (Math.abs(i - paramViewHolder.itemView.getLeft()) < f * paramViewHolder.itemView.getWidth()));
        localObject = findSwapTargets(paramViewHolder);
      } while (((List)localObject).size() == 0);
      localObject = this.mCallback.chooseDropTarget(paramViewHolder, (List)localObject, i, j);
      if (localObject == null)
      {
        this.mSwapTargets.clear();
        this.mDistances.clear();
        return;
      }
      k = ((RecyclerView.ViewHolder)localObject).getAdapterPosition();
      m = paramViewHolder.getAdapterPosition();
    } while (!this.mCallback.onMove(this.mRecyclerView, paramViewHolder, (RecyclerView.ViewHolder)localObject));
    this.mCallback.onMoved(this.mRecyclerView, paramViewHolder, m, (RecyclerView.ViewHolder)localObject, k, i, j);
  }
  
  void obtainVelocityTracker()
  {
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.recycle();
    }
    this.mVelocityTracker = VelocityTracker.obtain();
  }
  
  public void onChildViewAttachedToWindow(View paramView) {}
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    removeChildDrawingOrderCallbackIfNecessary(paramView);
    paramView = this.mRecyclerView.getChildViewHolder(paramView);
    if (paramView == null) {}
    do
    {
      return;
      if ((this.mSelected != null) && (paramView == this.mSelected))
      {
        select(null, 0);
        return;
      }
      endRecoverAnimation(paramView, false);
    } while (!this.mPendingCleanup.remove(paramView.itemView));
    this.mCallback.clearView(this.mRecyclerView, paramView);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    float f2 = 0.0F;
    this.mOverdrawChildPosition = -1;
    float f1;
    if (this.mSelected != null)
    {
      getSelectedDxDy(this.mTmpPosition);
      f1 = this.mTmpPosition[0];
      f2 = this.mTmpPosition[1];
    }
    for (;;)
    {
      this.mCallback.onDraw(paramCanvas, paramRecyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f1, f2);
      return;
      f1 = 0.0F;
    }
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    float f2 = 0.0F;
    float f1;
    if (this.mSelected != null)
    {
      getSelectedDxDy(this.mTmpPosition);
      f1 = this.mTmpPosition[0];
      f2 = this.mTmpPosition[1];
    }
    for (;;)
    {
      this.mCallback.onDrawOver(paramCanvas, paramRecyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f1, f2);
      return;
      f1 = 0.0F;
    }
  }
  
  void postDispatchSwipe(bhzs parambhzs, int paramInt)
  {
    this.mRecyclerView.post(new ItemTouchHelper.4(this, parambhzs, paramInt));
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
  
  public boolean scrollIfNecessary()
  {
    if (this.mSelected == null)
    {
      this.mDragScrollStartTimeInMs = -9223372036854775808L;
      return false;
    }
    long l2 = System.currentTimeMillis();
    long l1;
    int j;
    int i;
    label128:
    int k;
    if (this.mDragScrollStartTimeInMs == -9223372036854775808L)
    {
      l1 = 0L;
      RecyclerView.LayoutManager localLayoutManager = this.mRecyclerView.getLayoutManager();
      if (this.mTmpRect == null) {
        this.mTmpRect = new Rect();
      }
      localLayoutManager.calculateItemDecorationsForChild(this.mSelected.itemView, this.mTmpRect);
      if (!localLayoutManager.canScrollHorizontally()) {
        break label350;
      }
      j = (int)(this.mSelectedStartX + this.mDx);
      i = j - this.mTmpRect.left - this.mRecyclerView.getPaddingLeft();
      if ((this.mDx >= 0.0F) || (i >= 0)) {
        break label298;
      }
      if (!localLayoutManager.canScrollVertically()) {
        break label407;
      }
      k = (int)(this.mSelectedStartY + this.mDy);
      j = k - this.mTmpRect.top - this.mRecyclerView.getPaddingTop();
      if ((this.mDy >= 0.0F) || (j >= 0)) {
        break label355;
      }
      label178:
      if (i == 0) {
        break label424;
      }
      i = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getWidth(), i, this.mRecyclerView.getWidth(), l1);
    }
    label407:
    label424:
    for (;;)
    {
      if (j != 0) {
        j = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getHeight(), j, this.mRecyclerView.getHeight(), l1);
      }
      for (;;)
      {
        if ((i != 0) || (j != 0))
        {
          if (this.mDragScrollStartTimeInMs == -9223372036854775808L) {
            this.mDragScrollStartTimeInMs = l2;
          }
          this.mRecyclerView.scrollBy(i, j);
          return true;
          l1 = l2 - this.mDragScrollStartTimeInMs;
          break;
          label298:
          if (this.mDx > 0.0F)
          {
            j = j + this.mSelected.itemView.getWidth() + this.mTmpRect.right - (this.mRecyclerView.getWidth() - this.mRecyclerView.getPaddingRight());
            i = j;
            if (j > 0) {
              break label128;
            }
          }
          label350:
          i = 0;
          break label128;
          label355:
          if (this.mDy > 0.0F)
          {
            k = k + this.mSelected.itemView.getHeight() + this.mTmpRect.bottom - (this.mRecyclerView.getHeight() - this.mRecyclerView.getPaddingBottom());
            j = k;
            if (k > 0) {
              break label178;
            }
          }
          j = 0;
          break label178;
        }
        this.mDragScrollStartTimeInMs = -9223372036854775808L;
        return false;
      }
    }
  }
  
  void select(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder == this.mSelected) && (paramInt == this.mActionState)) {
      return;
    }
    this.mDragScrollStartTimeInMs = -9223372036854775808L;
    int k = this.mActionState;
    endRecoverAnimation(paramViewHolder, true);
    this.mActionState = paramInt;
    if (paramInt == 2)
    {
      this.mOverdrawChild = paramViewHolder.itemView;
      addChildDrawingOrderCallback();
    }
    int i = 0;
    int j = 0;
    Object localObject;
    float f1;
    float f2;
    if (this.mSelected != null)
    {
      localObject = this.mSelected;
      if (((RecyclerView.ViewHolder)localObject).itemView.getParent() == null) {
        break label510;
      }
      if (k == 2)
      {
        j = 0;
        releaseVelocityTracker();
      }
    }
    else
    {
      switch (j)
      {
      default: 
        f1 = 0.0F;
        f2 = 0.0F;
        label169:
        if (k == 2)
        {
          i = 8;
          label179:
          getSelectedDxDy(this.mTmpPosition);
          float f3 = this.mTmpPosition[0];
          float f4 = this.mTmpPosition[1];
          localObject = new bhzm(this, (RecyclerView.ViewHolder)localObject, i, k, f3, f4, f1, f2, j, (RecyclerView.ViewHolder)localObject);
          ((bhzs)localObject).a(this.mCallback.getAnimationDuration(this.mRecyclerView, i, f1 - f3, f2 - f4));
          this.mRecoverAnimations.add(localObject);
          ((bhzs)localObject).a();
          i = 1;
          this.mSelected = null;
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
          paramViewHolder = this.mRecyclerView.getParent();
          if (paramViewHolder != null) {
            if (this.mSelected == null) {
              break label539;
            }
          }
        }
        label277:
        break;
      }
    }
    label539:
    for (boolean bool = true;; bool = false)
    {
      paramViewHolder.requestDisallowInterceptTouchEvent(bool);
      if (i == 0) {
        this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
      }
      this.mCallback.onSelectedChanged(this.mSelected, this.mActionState);
      this.mRecyclerView.invalidate();
      return;
      j = swipeIfNecessary((RecyclerView.ViewHolder)localObject);
      break;
      f2 = 0.0F;
      f1 = Math.signum(this.mDx) * this.mRecyclerView.getWidth();
      break label169;
      f1 = 0.0F;
      f2 = Math.signum(this.mDy) * this.mRecyclerView.getHeight();
      break label169;
      if (j > 0)
      {
        i = 2;
        break label179;
      }
      i = 4;
      break label179;
      label510:
      removeChildDrawingOrderCallbackIfNecessary(((RecyclerView.ViewHolder)localObject).itemView);
      this.mCallback.clearView(this.mRecyclerView, (RecyclerView.ViewHolder)localObject);
      i = j;
      break label277;
    }
  }
  
  public void startDrag(RecyclerView.ViewHolder paramViewHolder)
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
  
  public void startSwipe(RecyclerView.ViewHolder paramViewHolder)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhzk
 * JD-Core Version:    0.7.0.1
 */