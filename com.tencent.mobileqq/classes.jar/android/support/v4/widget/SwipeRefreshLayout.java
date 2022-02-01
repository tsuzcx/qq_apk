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
  private static final String LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
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
    int i;
    if (this.mTarget == null) {
      i = 0;
    }
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (!localView.equals(this.mCircleView)) {
          this.mTarget = localView;
        }
      }
      else
      {
        return;
      }
      i += 1;
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
    setTargetOffsetTopAndBottom(this.mFrom + (int)((this.mOriginalOffsetTop - this.mFrom) * paramFloat) - this.mCircleView.getTop(), false);
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId) {
      if (i != 0) {
        break label33;
      }
    }
    label33:
    for (i = 1;; i = 0)
    {
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      return;
    }
  }
  
  private void setAnimationProgress(float paramFloat)
  {
    if (isAlphaUsedForScale()) {
      setColorViewAlpha((int)(255.0F * paramFloat));
    }
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    this.mCircleView.setScaleX(paramFloat);
    this.mCircleView.setScaleY(paramFloat);
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
      if (this.mRefreshing) {
        animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
      }
    }
    else
    {
      return;
    }
    startScaleDownAnimation(this.mRefreshListener);
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
    }
    for (;;)
    {
      this.mScaleDownToStartAnimation = new SwipeRefreshLayout.8(this);
      this.mScaleDownToStartAnimation.setDuration(150L);
      if (paramAnimationListener != null) {
        this.mCircleView.setAnimationListener(paramAnimationListener);
      }
      this.mCircleView.clearAnimation();
      this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
      return;
      if (Build.VERSION.SDK_INT >= 11) {
        this.mStartingScale = this.mCircleView.getScaleX();
      }
    }
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
    if (this.mTarget == null) {}
    do
    {
      return false;
      if (Build.VERSION.SDK_INT >= 14) {
        break;
      }
      if ((this.mTarget instanceof AbsListView))
      {
        AbsListView localAbsListView = (AbsListView)this.mTarget;
        if ((localAbsListView.getChildCount() > 0) && ((localAbsListView.getFirstVisiblePosition() > 0) || (localAbsListView.getChildAt(0).getTop() < localAbsListView.getPaddingTop()))) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
    } while ((!ViewCompat.canScrollVertically(this.mTarget, -1)) && (this.mTarget.getScrollY() <= 0));
    return true;
    return ViewCompat.canScrollVertically(this.mTarget, -1);
  }
  
  public int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.mCircleViewIndex < 0) {}
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1) {
        return this.mCircleViewIndex;
      }
    } while (paramInt2 < this.mCircleViewIndex);
    return paramInt2 + 1;
  }
  
  public int getProgressCircleDiameter()
  {
    if (this.mCircleView != null) {
      return this.mCircleView.getMeasuredHeight();
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
    if ((!isEnabled()) || (this.mReturningToStart) || (canChildScrollUp()) || (this.mRefreshing)) {
      return false;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return this.mIsBeingDragged;
      setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop(), true);
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      this.mIsBeingDragged = false;
      float f = getMotionEventY(paramMotionEvent, this.mActivePointerId);
      if (f == -1.0F) {
        break;
      }
      this.mInitialDownY = f;
      continue;
      if (this.mActivePointerId == -1)
      {
        Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
        return false;
      }
      f = getMotionEventY(paramMotionEvent, this.mActivePointerId);
      if (f == -1.0F) {
        break;
      }
      if ((f - this.mInitialDownY > this.mTouchSlop) && (!this.mIsBeingDragged))
      {
        this.mInitialMotionY = (this.mInitialDownY + this.mTouchSlop);
        this.mIsBeingDragged = true;
        this.mProgress.setAlpha(76);
        continue;
        onSecondaryPointerUp(paramMotionEvent);
        continue;
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if (getChildCount() == 0) {}
    do
    {
      return;
      if (this.mTarget == null) {
        ensureTarget();
      }
    } while (this.mTarget == null);
    View localView = this.mTarget;
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    localView.layout(paramInt3, paramInt4, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt3, paramInt2 - getPaddingTop() - getPaddingBottom() + paramInt4);
    paramInt2 = this.mCircleView.getMeasuredWidth();
    paramInt3 = this.mCircleView.getMeasuredHeight();
    this.mCircleView.layout(paramInt1 / 2 - paramInt2 / 2, this.mCurrentTargetOffsetTop, paramInt1 / 2 + paramInt2 / 2, this.mCurrentTargetOffsetTop + paramInt3);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.mTarget == null) {
      ensureTarget();
    }
    if (this.mTarget == null) {}
    for (;;)
    {
      return;
      this.mTarget.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
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
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if ((this.mReturningToStart) && (i == 0)) {
      this.mReturningToStart = false;
    }
    if ((!isEnabled()) || (this.mReturningToStart) || (canChildScrollUp())) {}
    label243:
    do
    {
      return false;
      switch (i)
      {
      case 4: 
      default: 
      case 0: 
      case 2: 
      case 5: 
      case 6: 
        for (;;)
        {
          return true;
          try
          {
            this.mActivePointerId = paramMotionEvent.getPointerId(0);
            this.mIsBeingDragged = false;
          }
          catch (Exception paramMotionEvent) {}
          i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          if (i < 0)
          {
            Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
            return false;
          }
          f2 = 0.5F * (paramMotionEvent.getY(i) - this.mInitialMotionY);
          if (this.mIsBeingDragged)
          {
            this.mProgress.showArrow(true);
            f1 = f2 / this.mTotalDragDistance;
            if (f1 < 0.0F) {
              break;
            }
            float f3 = Math.min(1.0F, Math.abs(f1));
            float f4 = (float)Math.max(f3 - 0.4D, 0.0D) * 5.0F / 3.0F;
            float f5 = Math.abs(f2);
            float f6 = this.mTotalDragDistance;
            int j;
            if (this.mUsingCustomStart)
            {
              f1 = this.mSpinnerFinalOffset - this.mOriginalOffsetTop;
              f5 = Math.max(0.0F, Math.min(f5 - f6, f1 * 2.0F) / f1);
              f5 = (float)(f5 / 4.0F - Math.pow(f5 / 4.0F, 2.0D)) * 2.0F;
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
              if (f2 >= this.mTotalDragDistance) {
                break label492;
              }
              if (this.mScale) {
                setAnimationProgress(f2 / this.mTotalDragDistance);
              }
              if ((this.mProgress.getAlpha() > 76) && (!isAnimationRunning(this.mAlphaStartAnimation))) {
                startProgressAlphaStartAnimation();
              }
              this.mProgress.setStartEndTrim(0.0F, Math.min(0.8F, 0.8F * f4));
              this.mProgress.setArrowScale(Math.min(1.0F, f4));
            }
            for (;;)
            {
              this.mProgress.setProgressRotation((-0.25F + 0.4F * f4 + f5 * 2.0F) * 0.5F);
              setTargetOffsetTopAndBottom(j + i - this.mCurrentTargetOffsetTop, true);
              break;
              f1 = this.mSpinnerFinalOffset;
              break label243;
              if ((this.mProgress.getAlpha() < 255) && (!isAnimationRunning(this.mAlphaMaxAnimation))) {
                startProgressAlphaMaxAnimation();
              }
            }
            this.mActivePointerId = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
            continue;
            onSecondaryPointerUp(paramMotionEvent);
          }
        }
      }
      if (this.mActivePointerId != -1) {
        break;
      }
    } while (i != 1);
    label492:
    Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
    return false;
    float f1 = paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.mActivePointerId));
    float f2 = this.mInitialMotionY;
    this.mIsBeingDragged = false;
    if ((f1 - f2) * 0.5F > this.mTotalDragDistance) {
      setRefreshing(true, true);
    }
    for (;;)
    {
      this.mActivePointerId = -1;
      return false;
      this.mRefreshing = false;
      this.mProgress.setStartEndTrim(0.0F, 0.0F);
      paramMotionEvent = null;
      if (!this.mScale) {
        paramMotionEvent = new SwipeRefreshLayout.5(this);
      }
      animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, paramMotionEvent);
      this.mProgress.showArrow(false);
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
      if (!this.mUsingCustomStart) {}
      for (int i = (int)(this.mSpinnerFinalOffset + this.mOriginalOffsetTop);; i = (int)this.mSpinnerFinalOffset)
      {
        setTargetOffsetTopAndBottom(i - this.mCurrentTargetOffsetTop, true);
        this.mNotify = false;
        startScaleUpAnimation(this.mRefreshListener);
        return;
      }
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
    }
    for (this.mCircleHeight = i;; this.mCircleHeight = i)
    {
      this.mCircleView.setImageDrawable(null);
      this.mProgress.updateSizes(paramInt);
      this.mCircleView.setImageDrawable(this.mProgress);
      return;
      i = (int)(localDisplayMetrics.density * 40.0F);
      this.mCircleWidth = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout
 * JD-Core Version:    0.7.0.1
 */