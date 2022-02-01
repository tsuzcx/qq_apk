package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;

public class SwipeRefreshLayout
  extends ViewGroup
{
  private static final int ALPHA_ANIMATION_DURATION = 300;
  private static final int ANIMATE_TO_START_DURATION = 200;
  private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
  private static final int CIRCLE_BG_LIGHT = -328966;
  private static final int CIRCLE_DIAMETER = 40;
  private static final int CIRCLE_DIAMETER_LARGE = 56;
  private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0F;
  public static final int DEFAULT = 1;
  private static final int DEFAULT_CIRCLE_TARGET = 64;
  private static final float DRAG_RATE = 0.5F;
  private static final int INVALID_POINTER = -1;
  public static final int LARGE = 0;
  private static final int[] LAYOUT_ATTRS = { 16842766 };
  private static final String LOG_TAG = "SwipeRefreshLayout";
  private static final int MAX_ALPHA = 255;
  private static final float MAX_PROGRESS_ANGLE = 0.8F;
  private static final int SCALE_DOWN_DURATION = 150;
  private static final int STARTING_PROGRESS_ALPHA = 76;
  private int mActivePointerId = -1;
  private Animation mAlphaMaxAnimation;
  private Animation mAlphaStartAnimation;
  private final Animation mAnimateToCorrectPosition = new SwipeRefreshLayout.6(this);
  private final Animation mAnimateToStartPosition = new SwipeRefreshLayout.7(this);
  private int mCircleHeight;
  private CircleImageView mCircleView;
  private int mCircleViewIndex = -1;
  private int mCircleWidth;
  private int mCurrentTargetOffsetTop;
  private final DecelerateInterpolator mDecelerateInterpolator;
  protected int mFrom;
  private float mInitialDownY;
  private float mInitialMotionY;
  private boolean mIsBeingDragged;
  private SwipeRefreshLayout.OnRefreshListener mListener;
  private int mMediumAnimationDuration;
  private boolean mNotify;
  private boolean mOriginalOffsetCalculated = false;
  protected int mOriginalOffsetTop;
  private MaterialProgressDrawable mProgress;
  private Animation.AnimationListener mRefreshListener = new SwipeRefreshLayout.1(this);
  private boolean mRefreshing = false;
  private boolean mReturningToStart;
  private boolean mScale;
  private Animation mScaleAnimation;
  private Animation mScaleDownAnimation;
  private Animation mScaleDownToStartAnimation;
  private float mSpinnerFinalOffset;
  private float mStartingScale;
  private View mTarget;
  private float mTotalDragDistance = -1.0F;
  private int mTouchSlop;
  private boolean mUsingCustomStart;
  
  public SwipeRefreshLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mMediumAnimationDuration = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.mDecelerateInterpolator = new DecelerateInterpolator(2.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, LAYOUT_ATTRS);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
    paramContext = getResources().getDisplayMetrics();
    this.mCircleWidth = ((int)(paramContext.density * 40.0F));
    this.mCircleHeight = ((int)(paramContext.density * 40.0F));
    createProgressView();
    setChildrenDrawingOrderEnabled(true);
    this.mSpinnerFinalOffset = (paramContext.density * 64.0F);
    this.mTotalDragDistance = this.mSpinnerFinalOffset;
  }
  
  private void animateOffsetToCorrectPosition(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.mFrom = paramInt;
    this.mAnimateToCorrectPosition.reset();
    this.mAnimateToCorrectPosition.setDuration(200L);
    this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
    if (paramAnimationListener != null) {
      this.mCircleView.setAnimationListener(paramAnimationListener);
    }
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
  }
  
  private void animateOffsetToStartPosition(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    if (this.mScale)
    {
      startScaleDownReturnToStartAnimation(paramInt, paramAnimationListener);
      return;
    }
    this.mFrom = paramInt;
    this.mAnimateToStartPosition.reset();
    this.mAnimateToStartPosition.setDuration(200L);
    this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
    if (paramAnimationListener != null) {
      this.mCircleView.setAnimationListener(paramAnimationListener);
    }
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(this.mAnimateToStartPosition);
  }
  
  private void createProgressView()
  {
    this.mCircleView = new CircleImageView(getContext(), -328966, 20.0F);
    this.mProgress = new MaterialProgressDrawable(getContext(), this);
    this.mProgress.setBackgroundColor(-328966);
    this.mCircleView.setImageDrawable(this.mProgress);
    this.mCircleView.setVisibility(8);
    addView(this.mCircleView);
  }
  
  private void ensureTarget()
  {
    if (this.mTarget == null)
    {
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (!localView.equals(this.mCircleView))
        {
          this.mTarget = localView;
          return;
        }
        i += 1;
      }
    }
  }
  
  private float getMotionEventY(MotionEvent paramMotionEvent, int paramInt)
  {
    paramInt = paramMotionEvent.findPointerIndex(paramInt);
    if (paramInt < 0) {
      return -1.0F;
    }
    return paramMotionEvent.getY(paramInt);
  }
  
  private boolean isAlphaUsedForScale()
  {
    return Build.VERSION.SDK_INT < 11;
  }
  
  private boolean isAnimationRunning(Animation paramAnimation)
  {
    return (paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded());
  }
  
  private void moveToStart(float paramFloat)
  {
    int i = this.mFrom;
    setTargetOffsetTopAndBottom(i + (int)((this.mOriginalOffsetTop - i) * paramFloat) - this.mCircleView.getTop(), false);
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId)
    {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
    }
  }
  
  private void setAnimationProgress(float paramFloat)
  {
    if (isAlphaUsedForScale())
    {
      setColorViewAlpha((int)(paramFloat * 255.0F));
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.mCircleView.setScaleX(paramFloat);
      this.mCircleView.setScaleY(paramFloat);
    }
  }
  
  private void setColorViewAlpha(int paramInt)
  {
    this.mCircleView.getBackground().setAlpha(paramInt);
    this.mProgress.setAlpha(paramInt);
  }
  
  private void setRefreshing(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mRefreshing != paramBoolean1)
    {
      this.mNotify = paramBoolean2;
      ensureTarget();
      this.mRefreshing = paramBoolean1;
      if (this.mRefreshing)
      {
        animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
        return;
      }
      startScaleDownAnimation(this.mRefreshListener);
    }
  }
  
  private void setTargetOffsetTopAndBottom(int paramInt, boolean paramBoolean)
  {
    this.mCircleView.bringToFront();
    this.mCircleView.offsetTopAndBottom(paramInt);
    this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    if ((paramBoolean) && (Build.VERSION.SDK_INT < 11)) {
      invalidate();
    }
  }
  
  private Animation startAlphaAnimation(int paramInt1, int paramInt2)
  {
    if ((this.mScale) && (isAlphaUsedForScale())) {
      return null;
    }
    SwipeRefreshLayout.4 local4 = new SwipeRefreshLayout.4(this, paramInt1, paramInt2);
    local4.setDuration(300L);
    this.mCircleView.setAnimationListener(null);
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(local4);
    return local4;
  }
  
  private void startProgressAlphaMaxAnimation()
  {
    this.mAlphaMaxAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 255);
  }
  
  private void startProgressAlphaStartAnimation()
  {
    this.mAlphaStartAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 76);
  }
  
  private void startScaleDownAnimation(Animation.AnimationListener paramAnimationListener)
  {
    this.mScaleDownAnimation = new SwipeRefreshLayout.3(this);
    this.mScaleDownAnimation.setDuration(150L);
    this.mCircleView.setAnimationListener(paramAnimationListener);
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(this.mScaleDownAnimation);
  }
  
  private void startScaleDownReturnToStartAnimation(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.mFrom = paramInt;
    if (isAlphaUsedForScale()) {
      this.mStartingScale = this.mProgress.getAlpha();
    } else if (Build.VERSION.SDK_INT >= 11) {
      this.mStartingScale = this.mCircleView.getScaleX();
    }
    this.mScaleDownToStartAnimation = new SwipeRefreshLayout.8(this);
    this.mScaleDownToStartAnimation.setDuration(150L);
    if (paramAnimationListener != null) {
      this.mCircleView.setAnimationListener(paramAnimationListener);
    }
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
  }
  
  private void startScaleUpAnimation(Animation.AnimationListener paramAnimationListener)
  {
    this.mCircleView.setVisibility(0);
    if (Build.VERSION.SDK_INT >= 11) {
      this.mProgress.setAlpha(255);
    }
    this.mScaleAnimation = new SwipeRefreshLayout.2(this);
    this.mScaleAnimation.setDuration(this.mMediumAnimationDuration);
    if (paramAnimationListener != null) {
      this.mCircleView.setAnimationListener(paramAnimationListener);
    }
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(this.mScaleAnimation);
  }
  
  public boolean canChildScrollUp()
  {
    Object localObject = this.mTarget;
    boolean bool1 = false;
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    if (Build.VERSION.SDK_INT < 14)
    {
      localObject = this.mTarget;
      if ((localObject instanceof AbsListView))
      {
        localObject = (AbsListView)localObject;
        bool1 = bool2;
        if (((AbsListView)localObject).getChildCount() > 0) {
          if (((AbsListView)localObject).getFirstVisiblePosition() <= 0)
          {
            bool1 = bool2;
            if (((AbsListView)localObject).getChildAt(0).getTop() >= ((AbsListView)localObject).getPaddingTop()) {}
          }
          else
          {
            bool1 = true;
          }
        }
        return bool1;
      }
      if ((ViewCompat.canScrollVertically((View)localObject, -1)) || (this.mTarget.getScrollY() > 0)) {
        bool1 = true;
      }
      return bool1;
    }
    return ViewCompat.canScrollVertically(this.mTarget, -1);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = this.mCircleViewIndex;
    if (i < 0) {
      return paramInt2;
    }
    if (paramInt2 == paramInt1 - 1) {
      return i;
    }
    paramInt1 = paramInt2;
    if (paramInt2 >= i) {
      paramInt1 = paramInt2 + 1;
    }
    return paramInt1;
  }
  
  public int getProgressCircleDiameter()
  {
    CircleImageView localCircleImageView = this.mCircleView;
    if (localCircleImageView != null) {
      return localCircleImageView.getMeasuredHeight();
    }
    return 0;
  }
  
  public boolean isRefreshing()
  {
    return this.mRefreshing;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ensureTarget();
    int i = paramMotionEvent.getActionMasked();
    if ((this.mReturningToStart) && (i == 0)) {
      this.mReturningToStart = false;
    }
    if ((isEnabled()) && (!this.mReturningToStart) && (!canChildScrollUp()))
    {
      if (this.mRefreshing) {
        return false;
      }
      float f1;
      if (i != 0)
      {
        if (i != 1) {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 6) {
                break label261;
              }
              onSecondaryPointerUp(paramMotionEvent);
              break label261;
            }
          }
          else
          {
            i = this.mActivePointerId;
            if (i == -1)
            {
              Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
              return false;
            }
            f1 = getMotionEventY(paramMotionEvent, i);
            if (f1 == -1.0F) {
              return false;
            }
            float f2 = this.mInitialDownY;
            i = this.mTouchSlop;
            if ((f1 - f2 <= i) || (this.mIsBeingDragged)) {
              break label261;
            }
            this.mInitialMotionY = (f2 + i);
            this.mIsBeingDragged = true;
            this.mProgress.setAlpha(76);
            break label261;
          }
        }
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
      }
      else
      {
        setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop(), true);
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        this.mIsBeingDragged = false;
        f1 = getMotionEventY(paramMotionEvent, this.mActivePointerId);
        if (f1 == -1.0F) {
          return false;
        }
        this.mInitialDownY = f1;
      }
      label261:
      return this.mIsBeingDragged;
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if (getChildCount() == 0) {
      return;
    }
    if (this.mTarget == null) {
      ensureTarget();
    }
    Object localObject = this.mTarget;
    if (localObject == null) {
      return;
    }
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    ((View)localObject).layout(paramInt3, paramInt4, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt3, paramInt2 - getPaddingTop() - getPaddingBottom() + paramInt4);
    paramInt3 = this.mCircleView.getMeasuredWidth();
    paramInt2 = this.mCircleView.getMeasuredHeight();
    localObject = this.mCircleView;
    paramInt1 /= 2;
    paramInt3 /= 2;
    paramInt4 = this.mCurrentTargetOffsetTop;
    ((CircleImageView)localObject).layout(paramInt1 - paramInt3, paramInt4, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.mTarget == null) {
      ensureTarget();
    }
    View localView = this.mTarget;
    if (localView == null) {
      return;
    }
    localView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
    this.mCircleView.measure(View.MeasureSpec.makeMeasureSpec(this.mCircleWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCircleHeight, 1073741824));
    if ((!this.mUsingCustomStart) && (!this.mOriginalOffsetCalculated))
    {
      this.mOriginalOffsetCalculated = true;
      paramInt1 = -this.mCircleView.getMeasuredHeight();
      this.mOriginalOffsetTop = paramInt1;
      this.mCurrentTargetOffsetTop = paramInt1;
    }
    this.mCircleViewIndex = -1;
    paramInt1 = 0;
    while (paramInt1 < getChildCount())
    {
      if (getChildAt(paramInt1) == this.mCircleView)
      {
        this.mCircleViewIndex = paramInt1;
        return;
      }
      paramInt1 += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if ((this.mReturningToStart) && (i == 0)) {
      this.mReturningToStart = false;
    }
    if ((isEnabled()) && (!this.mReturningToStart))
    {
      if (canChildScrollUp()) {
        return false;
      }
      if (i != 0) {
        if (i != 1) {
          if (i != 2)
          {
            if (i == 3) {
              break label540;
            }
            if (i != 5) {
              if (i != 6) {
                return true;
              }
            }
          }
        }
      }
    }
    try
    {
      onSecondaryPointerUp(paramMotionEvent);
      return true;
    }
    catch (Exception paramMotionEvent)
    {
      float f2;
      float f1;
      float f3;
      double d1;
      float f4;
      float f5;
      float f6;
      double d2;
      int j;
      return false;
    }
    this.mActivePointerId = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
    return true;
    i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
    if (i < 0)
    {
      Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
      return false;
    }
    f2 = (paramMotionEvent.getY(i) - this.mInitialMotionY) * 0.5F;
    if (this.mIsBeingDragged)
    {
      this.mProgress.showArrow(true);
      f1 = f2 / this.mTotalDragDistance;
      if (f1 < 0.0F) {
        return false;
      }
      f3 = Math.min(1.0F, Math.abs(f1));
      d1 = f3;
      Double.isNaN(d1);
      f4 = (float)Math.max(d1 - 0.4D, 0.0D) * 5.0F / 3.0F;
      f5 = Math.abs(f2);
      f6 = this.mTotalDragDistance;
      if (this.mUsingCustomStart) {
        f1 = this.mSpinnerFinalOffset - this.mOriginalOffsetTop;
      } else {
        f1 = this.mSpinnerFinalOffset;
      }
      d1 = Math.max(0.0F, Math.min(f5 - f6, f1 * 2.0F) / f1) / 4.0F;
      d2 = Math.pow(d1, 2.0D);
      Double.isNaN(d1);
      f5 = (float)(d1 - d2) * 2.0F;
      i = this.mOriginalOffsetTop;
      j = (int)(f1 * f3 + f1 * f5 * 2.0F);
      if (this.mCircleView.getVisibility() != 0) {
        this.mCircleView.setVisibility(0);
      }
      if ((!this.mScale) && (Build.VERSION.SDK_INT >= 11))
      {
        this.mCircleView.setScaleX(1.0F);
        this.mCircleView.setScaleY(1.0F);
      }
      if (f2 < this.mTotalDragDistance)
      {
        if (this.mScale) {
          setAnimationProgress(f2 / this.mTotalDragDistance);
        }
        if ((this.mProgress.getAlpha() > 76) && (!isAnimationRunning(this.mAlphaStartAnimation))) {
          startProgressAlphaStartAnimation();
        }
        this.mProgress.setStartEndTrim(0.0F, Math.min(0.8F, f4 * 0.8F));
        this.mProgress.setArrowScale(Math.min(1.0F, f4));
      }
      else if ((this.mProgress.getAlpha() < 255) && (!isAnimationRunning(this.mAlphaMaxAnimation)))
      {
        startProgressAlphaMaxAnimation();
      }
      this.mProgress.setProgressRotation((f4 * 0.4F - 0.25F + f5 * 2.0F) * 0.5F);
      setTargetOffsetTopAndBottom(i + j - this.mCurrentTargetOffsetTop, true);
      return true;
      label540:
      if (this.mActivePointerId == -1)
      {
        if (i == 1)
        {
          Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
          return false;
        }
      }
      else
      {
        f1 = paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.mActivePointerId));
        f2 = this.mInitialMotionY;
        this.mIsBeingDragged = false;
        if ((f1 - f2) * 0.5F > this.mTotalDragDistance)
        {
          setRefreshing(true, true);
        }
        else
        {
          this.mRefreshing = false;
          this.mProgress.setStartEndTrim(0.0F, 0.0F);
          paramMotionEvent = null;
          if (!this.mScale) {
            paramMotionEvent = new SwipeRefreshLayout.5(this);
          }
          animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, paramMotionEvent);
          this.mProgress.showArrow(false);
        }
        this.mActivePointerId = -1;
        return false;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        this.mIsBeingDragged = false;
      }
    }
    else
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  @Deprecated
  public void setColorScheme(int... paramVarArgs)
  {
    setColorSchemeResources(paramVarArgs);
  }
  
  public void setColorSchemeColors(int... paramVarArgs)
  {
    ensureTarget();
    this.mProgress.setColorSchemeColors(paramVarArgs);
  }
  
  public void setColorSchemeResources(int... paramVarArgs)
  {
    Resources localResources = getResources();
    int[] arrayOfInt = new int[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfInt[i] = localResources.getColor(paramVarArgs[i]);
      i += 1;
    }
    setColorSchemeColors(arrayOfInt);
  }
  
  public void setDistanceToTriggerSync(int paramInt)
  {
    this.mTotalDragDistance = paramInt;
  }
  
  public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener paramOnRefreshListener)
  {
    this.mListener = paramOnRefreshListener;
  }
  
  @Deprecated
  public void setProgressBackgroundColor(int paramInt)
  {
    setProgressBackgroundColorSchemeResource(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeColor(int paramInt)
  {
    this.mCircleView.setBackgroundColor(paramInt);
    this.mProgress.setBackgroundColor(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeResource(int paramInt)
  {
    setProgressBackgroundColorSchemeColor(getResources().getColor(paramInt));
  }
  
  public void setProgressViewEndTarget(boolean paramBoolean, int paramInt)
  {
    this.mSpinnerFinalOffset = paramInt;
    this.mScale = paramBoolean;
    this.mCircleView.invalidate();
  }
  
  public void setProgressViewOffset(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.mScale = paramBoolean;
    this.mCircleView.setVisibility(8);
    this.mCurrentTargetOffsetTop = paramInt1;
    this.mOriginalOffsetTop = paramInt1;
    this.mSpinnerFinalOffset = paramInt2;
    this.mUsingCustomStart = true;
    this.mCircleView.invalidate();
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mRefreshing != paramBoolean))
    {
      this.mRefreshing = paramBoolean;
      float f;
      if (!this.mUsingCustomStart) {
        f = this.mSpinnerFinalOffset + this.mOriginalOffsetTop;
      } else {
        f = this.mSpinnerFinalOffset;
      }
      setTargetOffsetTopAndBottom((int)f - this.mCurrentTargetOffsetTop, true);
      this.mNotify = false;
      startScaleUpAnimation(this.mRefreshListener);
      return;
    }
    setRefreshing(paramBoolean, false);
  }
  
  public void setSize(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      return;
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    int i;
    if (paramInt == 0)
    {
      i = (int)(localDisplayMetrics.density * 56.0F);
      this.mCircleWidth = i;
      this.mCircleHeight = i;
    }
    else
    {
      i = (int)(localDisplayMetrics.density * 40.0F);
      this.mCircleWidth = i;
      this.mCircleHeight = i;
    }
    this.mCircleView.setImageDrawable(null);
    this.mProgress.updateSizes(paramInt);
    this.mCircleView.setImageDrawable(this.mProgress);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout
 * JD-Core Version:    0.7.0.1
 */