package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R.styleable;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.view.NestedScrollingParent3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MotionLayout
  extends ConstraintLayout
  implements NestedScrollingParent3
{
  private static final boolean DEBUG = false;
  public static final int DEBUG_SHOW_NONE = 0;
  public static final int DEBUG_SHOW_PATH = 2;
  public static final int DEBUG_SHOW_PROGRESS = 1;
  private static final float EPSILON = 1.0E-005F;
  public static boolean IS_IN_EDIT_MODE = false;
  static final int MAX_KEY_FRAMES = 50;
  static final String TAG = "MotionLayout";
  public static final int TOUCH_UP_COMPLETE = 0;
  public static final int TOUCH_UP_COMPLETE_TO_END = 2;
  public static final int TOUCH_UP_COMPLETE_TO_START = 1;
  public static final int TOUCH_UP_DECELERATE = 4;
  public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
  public static final int TOUCH_UP_STOP = 3;
  public static final int VELOCITY_LAYOUT = 1;
  public static final int VELOCITY_POST_LAYOUT = 0;
  public static final int VELOCITY_STATIC_LAYOUT = 3;
  public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
  boolean firstDown = true;
  private float lastPos;
  private float lastY;
  private long mAnimationStartTime = 0L;
  private int mBeginState = -1;
  private RectF mBoundsCheck = new RectF();
  int mCurrentState = -1;
  int mDebugPath = 0;
  private MotionLayout.DecelerateInterpolator mDecelerateLogic = new MotionLayout.DecelerateInterpolator(this);
  private DesignTool mDesignTool;
  MotionLayout.DevModeDraw mDevModeDraw;
  private int mEndState = -1;
  int mEndWrapHeight;
  int mEndWrapWidth;
  HashMap<View, MotionController> mFrameArrayList = new HashMap();
  private int mFrames = 0;
  int mHeightMeasureMode;
  private boolean mInLayout = false;
  boolean mInTransition = false;
  boolean mIndirectTransition = false;
  private boolean mInteractionEnabled = true;
  Interpolator mInterpolator;
  boolean mIsAnimating = false;
  private boolean mKeepAnimating = false;
  private KeyCache mKeyCache = new KeyCache();
  private long mLastDrawTime = -1L;
  private float mLastFps = 0.0F;
  private int mLastHeightMeasureSpec = 0;
  int mLastLayoutHeight;
  int mLastLayoutWidth;
  float mLastVelocity = 0.0F;
  private int mLastWidthMeasureSpec = 0;
  private float mListenerPosition = 0.0F;
  private int mListenerState = 0;
  protected boolean mMeasureDuringTransition = false;
  MotionLayout.Model mModel = new MotionLayout.Model(this);
  private boolean mNeedsFireTransitionCompleted = false;
  int mOldHeight;
  int mOldWidth;
  private ArrayList<MotionHelper> mOnHideHelpers = null;
  private ArrayList<MotionHelper> mOnShowHelpers = null;
  float mPostInterpolationPosition;
  private View mRegionView = null;
  MotionScene mScene;
  float mScrollTargetDT;
  float mScrollTargetDX;
  float mScrollTargetDY;
  long mScrollTargetTime;
  int mStartWrapHeight;
  int mStartWrapWidth;
  private MotionLayout.StateCache mStateCache;
  private StopLogic mStopLogic = new StopLogic();
  private boolean mTemporalInterpolator = false;
  ArrayList<Integer> mTransitionCompleted = new ArrayList();
  private float mTransitionDuration = 1.0F;
  float mTransitionGoalPosition = 0.0F;
  private boolean mTransitionInstantly;
  float mTransitionLastPosition = 0.0F;
  private long mTransitionLastTime;
  private MotionLayout.TransitionListener mTransitionListener;
  private ArrayList<MotionLayout.TransitionListener> mTransitionListeners = null;
  float mTransitionPosition = 0.0F;
  MotionLayout.TransitionState mTransitionState = MotionLayout.TransitionState.UNDEFINED;
  boolean mUndergoingMotion = false;
  int mWidthMeasureMode;
  
  public MotionLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    init(null);
  }
  
  public MotionLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }
  
  public MotionLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }
  
  private void checkStructure()
  {
    Object localObject1 = this.mScene;
    if (localObject1 == null)
    {
      Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
      return;
    }
    int i = ((MotionScene)localObject1).getStartId();
    localObject1 = this.mScene;
    checkStructure(i, ((MotionScene)localObject1).getConstraintSet(((MotionScene)localObject1).getStartId()));
    localObject1 = new SparseIntArray();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    Iterator localIterator = this.mScene.getDefinedTransitions().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (MotionScene.Transition)localIterator.next();
      if (localObject2 == this.mScene.mCurrentTransition) {
        Log.v("MotionLayout", "CHECK: CURRENT");
      }
      checkStructure((MotionScene.Transition)localObject2);
      i = ((MotionScene.Transition)localObject2).getStartConstraintSetId();
      int j = ((MotionScene.Transition)localObject2).getEndConstraintSetId();
      localObject2 = Debug.getName(getContext(), i);
      Object localObject3 = Debug.getName(getContext(), j);
      StringBuilder localStringBuilder;
      if (((SparseIntArray)localObject1).get(i) == j)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("CHECK: two transitions with the same start and end ");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("->");
        localStringBuilder.append((String)localObject3);
        Log.e("MotionLayout", localStringBuilder.toString());
      }
      if (localSparseIntArray.get(j) == i)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("CHECK: you can't have reverse transitions");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("->");
        localStringBuilder.append((String)localObject3);
        Log.e("MotionLayout", localStringBuilder.toString());
      }
      ((SparseIntArray)localObject1).put(i, j);
      localSparseIntArray.put(j, i);
      if (this.mScene.getConstraintSet(i) == null)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(" no such constraintSetStart ");
        ((StringBuilder)localObject3).append((String)localObject2);
        Log.e("MotionLayout", ((StringBuilder)localObject3).toString());
      }
      if (this.mScene.getConstraintSet(j) == null)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(" no such constraintSetEnd ");
        ((StringBuilder)localObject3).append((String)localObject2);
        Log.e("MotionLayout", ((StringBuilder)localObject3).toString());
      }
    }
  }
  
  private void checkStructure(int paramInt, ConstraintSet paramConstraintSet)
  {
    String str = Debug.getName(getContext(), paramInt);
    int j = getChildCount();
    int i = 0;
    paramInt = 0;
    Object localObject2;
    while (paramInt < j)
    {
      localObject1 = getChildAt(paramInt);
      int k = ((View)localObject1).getId();
      if (k == -1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("CHECK: ");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(" ALL VIEWS SHOULD HAVE ID's ");
        ((StringBuilder)localObject2).append(localObject1.getClass().getName());
        ((StringBuilder)localObject2).append(" does not!");
        Log.w("MotionLayout", ((StringBuilder)localObject2).toString());
      }
      if (paramConstraintSet.getConstraint(k) == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("CHECK: ");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(" NO CONSTRAINTS for ");
        ((StringBuilder)localObject2).append(Debug.getName((View)localObject1));
        Log.w("MotionLayout", ((StringBuilder)localObject2).toString());
      }
      paramInt += 1;
    }
    Object localObject1 = paramConstraintSet.getKnownIds();
    paramInt = i;
    while (paramInt < localObject1.length)
    {
      i = localObject1[paramInt];
      localObject2 = Debug.getName(getContext(), i);
      StringBuilder localStringBuilder;
      if (findViewById(localObject1[paramInt]) == null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("CHECK: ");
        localStringBuilder.append(str);
        localStringBuilder.append(" NO View matches id ");
        localStringBuilder.append((String)localObject2);
        Log.w("MotionLayout", localStringBuilder.toString());
      }
      if (paramConstraintSet.getHeight(i) == -1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("CHECK: ");
        localStringBuilder.append(str);
        localStringBuilder.append("(");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(") no LAYOUT_HEIGHT");
        Log.w("MotionLayout", localStringBuilder.toString());
      }
      if (paramConstraintSet.getWidth(i) == -1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("CHECK: ");
        localStringBuilder.append(str);
        localStringBuilder.append("(");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(") no LAYOUT_HEIGHT");
        Log.w("MotionLayout", localStringBuilder.toString());
      }
      paramInt += 1;
    }
  }
  
  private void checkStructure(MotionScene.Transition paramTransition)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CHECK: transition = ");
    localStringBuilder.append(paramTransition.debugString(getContext()));
    Log.v("MotionLayout", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("CHECK: transition.setDuration = ");
    localStringBuilder.append(paramTransition.getDuration());
    Log.v("MotionLayout", localStringBuilder.toString());
    if (paramTransition.getStartConstraintSetId() == paramTransition.getEndConstraintSetId()) {
      Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
    }
  }
  
  private void computeCurrentPositions()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      MotionController localMotionController = (MotionController)this.mFrameArrayList.get(localView);
      if (localMotionController != null) {
        localMotionController.setStartCurrentState(localView);
      }
      i += 1;
    }
  }
  
  private void debugPos()
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" ");
      localStringBuilder.append(Debug.getLocation());
      localStringBuilder.append(" ");
      localStringBuilder.append(Debug.getName(this));
      localStringBuilder.append(" ");
      localStringBuilder.append(Debug.getName(getContext(), this.mCurrentState));
      localStringBuilder.append(" ");
      localStringBuilder.append(Debug.getName(localView));
      localStringBuilder.append(localView.getLeft());
      localStringBuilder.append(" ");
      localStringBuilder.append(localView.getTop());
      Log.v("MotionLayout", localStringBuilder.toString());
      i += 1;
    }
  }
  
  private void evaluateLayout()
  {
    float f3 = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
    long l = getNanoTime();
    if (!(this.mInterpolator instanceof StopLogic)) {
      f1 = (float)(l - this.mTransitionLastTime) * f3 * 1.0E-009F / this.mTransitionDuration;
    } else {
      f1 = 0.0F;
    }
    float f2 = this.mTransitionLastPosition + f1;
    if (this.mTransitionInstantly) {
      f2 = this.mTransitionGoalPosition;
    }
    int j = 0;
    if (((f3 > 0.0F) && (f2 >= this.mTransitionGoalPosition)) || ((f3 <= 0.0F) && (f2 <= this.mTransitionGoalPosition)))
    {
      f2 = this.mTransitionGoalPosition;
      i = 1;
    }
    else
    {
      i = 0;
    }
    Object localObject = this.mInterpolator;
    float f1 = f2;
    if (localObject != null)
    {
      f1 = f2;
      if (i == 0) {
        if (this.mTemporalInterpolator) {
          f1 = ((Interpolator)localObject).getInterpolation((float)(l - this.mAnimationStartTime) * 1.0E-009F);
        } else {
          f1 = ((Interpolator)localObject).getInterpolation(f2);
        }
      }
    }
    if ((f3 <= 0.0F) || (f1 < this.mTransitionGoalPosition))
    {
      f2 = f1;
      if (f3 <= 0.0F)
      {
        f2 = f1;
        if (f1 > this.mTransitionGoalPosition) {}
      }
    }
    else
    {
      f2 = this.mTransitionGoalPosition;
    }
    this.mPostInterpolationPosition = f2;
    int k = getChildCount();
    l = getNanoTime();
    int i = j;
    while (i < k)
    {
      localObject = getChildAt(i);
      MotionController localMotionController = (MotionController)this.mFrameArrayList.get(localObject);
      if (localMotionController != null) {
        localMotionController.interpolate((View)localObject, f2, l, this.mKeyCache);
      }
      i += 1;
    }
    if (this.mMeasureDuringTransition) {
      requestLayout();
    }
  }
  
  private void fireTransitionChange()
  {
    Object localObject;
    if (this.mTransitionListener == null)
    {
      localObject = this.mTransitionListeners;
      if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {}
    }
    else if (this.mListenerPosition != this.mTransitionPosition)
    {
      if (this.mListenerState != -1)
      {
        localObject = this.mTransitionListener;
        if (localObject != null) {
          ((MotionLayout.TransitionListener)localObject).onTransitionStarted(this, this.mBeginState, this.mEndState);
        }
        localObject = this.mTransitionListeners;
        if (localObject != null)
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            ((MotionLayout.TransitionListener)((Iterator)localObject).next()).onTransitionStarted(this, this.mBeginState, this.mEndState);
          }
        }
        this.mIsAnimating = true;
      }
      this.mListenerState = -1;
      float f = this.mTransitionPosition;
      this.mListenerPosition = f;
      localObject = this.mTransitionListener;
      if (localObject != null) {
        ((MotionLayout.TransitionListener)localObject).onTransitionChange(this, this.mBeginState, this.mEndState, f);
      }
      localObject = this.mTransitionListeners;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((MotionLayout.TransitionListener)((Iterator)localObject).next()).onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
        }
      }
      this.mIsAnimating = true;
    }
  }
  
  private void fireTransitionStarted(MotionLayout paramMotionLayout, int paramInt1, int paramInt2)
  {
    Object localObject = this.mTransitionListener;
    if (localObject != null) {
      ((MotionLayout.TransitionListener)localObject).onTransitionStarted(this, paramInt1, paramInt2);
    }
    localObject = this.mTransitionListeners;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MotionLayout.TransitionListener)((Iterator)localObject).next()).onTransitionStarted(paramMotionLayout, paramInt1, paramInt2);
      }
    }
  }
  
  private boolean handlesTouchEvent(float paramFloat1, float paramFloat2, View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = localViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = localViewGroup.getChildAt(i);
        if (handlesTouchEvent(paramView.getLeft() + paramFloat1, paramView.getTop() + paramFloat2, localView, paramMotionEvent)) {
          return true;
        }
        i += 1;
      }
    }
    this.mBoundsCheck.set(paramView.getLeft() + paramFloat1, paramView.getTop() + paramFloat2, paramFloat1 + paramView.getRight(), paramFloat2 + paramView.getBottom());
    if (paramMotionEvent.getAction() == 0)
    {
      if ((this.mBoundsCheck.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) && (paramView.onTouchEvent(paramMotionEvent))) {
        return true;
      }
    }
    else if (paramView.onTouchEvent(paramMotionEvent)) {
      return true;
    }
    return false;
  }
  
  private void init(AttributeSet paramAttributeSet)
  {
    IS_IN_EDIT_MODE = isInEditMode();
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.MotionLayout);
      int k = paramAttributeSet.getIndexCount();
      int i = 0;
      boolean bool2;
      for (boolean bool1 = true; i < k; bool1 = bool2)
      {
        int j = paramAttributeSet.getIndex(i);
        if (j == R.styleable.MotionLayout_layoutDescription)
        {
          j = paramAttributeSet.getResourceId(j, -1);
          this.mScene = new MotionScene(getContext(), this, j);
          bool2 = bool1;
        }
        else if (j == R.styleable.MotionLayout_currentState)
        {
          this.mCurrentState = paramAttributeSet.getResourceId(j, -1);
          bool2 = bool1;
        }
        else if (j == R.styleable.MotionLayout_motionProgress)
        {
          this.mTransitionGoalPosition = paramAttributeSet.getFloat(j, 0.0F);
          this.mInTransition = true;
          bool2 = bool1;
        }
        else if (j == R.styleable.MotionLayout_applyMotionScene)
        {
          bool2 = paramAttributeSet.getBoolean(j, bool1);
        }
        else if (j == R.styleable.MotionLayout_showPaths)
        {
          bool2 = bool1;
          if (this.mDebugPath == 0)
          {
            if (paramAttributeSet.getBoolean(j, false)) {
              j = 2;
            } else {
              j = 0;
            }
            this.mDebugPath = j;
            bool2 = bool1;
          }
        }
        else
        {
          bool2 = bool1;
          if (j == R.styleable.MotionLayout_motionDebug)
          {
            this.mDebugPath = paramAttributeSet.getInt(j, 0);
            bool2 = bool1;
          }
        }
        i += 1;
      }
      paramAttributeSet.recycle();
      if (this.mScene == null) {
        Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
      }
      if (!bool1) {
        this.mScene = null;
      }
    }
    if (this.mDebugPath != 0) {
      checkStructure();
    }
    if (this.mCurrentState == -1)
    {
      paramAttributeSet = this.mScene;
      if (paramAttributeSet != null)
      {
        this.mCurrentState = paramAttributeSet.getStartId();
        this.mBeginState = this.mScene.getStartId();
        this.mEndState = this.mScene.getEndId();
      }
    }
  }
  
  private void processTransitionCompleted()
  {
    if (this.mTransitionListener == null)
    {
      localObject1 = this.mTransitionListeners;
      if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty())) {
        return;
      }
    }
    this.mIsAnimating = false;
    Object localObject1 = this.mTransitionCompleted.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject1).next();
      Object localObject2 = this.mTransitionListener;
      if (localObject2 != null) {
        ((MotionLayout.TransitionListener)localObject2).onTransitionCompleted(this, localInteger.intValue());
      }
      localObject2 = this.mTransitionListeners;
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((MotionLayout.TransitionListener)((Iterator)localObject2).next()).onTransitionCompleted(this, localInteger.intValue());
        }
      }
    }
    this.mTransitionCompleted.clear();
  }
  
  private void setupMotionViews()
  {
    int i1 = getChildCount();
    this.mModel.build();
    int n = 1;
    this.mInTransition = true;
    int j = getWidth();
    int i2 = getHeight();
    int i3 = this.mScene.gatPathMotionArc();
    int k = 0;
    int m = 0;
    MotionController localMotionController;
    if (i3 != -1)
    {
      i = 0;
      while (i < i1)
      {
        localMotionController = (MotionController)this.mFrameArrayList.get(getChildAt(i));
        if (localMotionController != null) {
          localMotionController.setPathMotionArc(i3);
        }
        i += 1;
      }
    }
    int i = 0;
    while (i < i1)
    {
      localMotionController = (MotionController)this.mFrameArrayList.get(getChildAt(i));
      if (localMotionController != null)
      {
        this.mScene.getKeyFrames(localMotionController);
        localMotionController.setup(j, i2, this.mTransitionDuration, getNanoTime());
      }
      i += 1;
    }
    float f1 = this.mScene.getStaggered();
    if (f1 != 0.0F)
    {
      if (f1 < 0.0D) {
        i = 1;
      } else {
        i = 0;
      }
      float f6 = Math.abs(f1);
      float f4 = -3.402824E+038F;
      float f5 = 3.4028235E+38F;
      j = 0;
      float f2 = 3.4028235E+38F;
      f1 = -3.402824E+038F;
      float f3;
      while (j < i1)
      {
        localMotionController = (MotionController)this.mFrameArrayList.get(getChildAt(j));
        if (!Float.isNaN(localMotionController.mMotionStagger))
        {
          j = n;
          break label326;
        }
        f3 = localMotionController.getFinalX();
        float f7 = localMotionController.getFinalY();
        if (i != 0) {
          f3 = f7 - f3;
        } else {
          f3 = f7 + f3;
        }
        f2 = Math.min(f2, f3);
        f1 = Math.max(f1, f3);
        j += 1;
      }
      j = 0;
      label326:
      if (j != 0)
      {
        j = 0;
        f2 = f5;
        f1 = f4;
        for (;;)
        {
          k = m;
          if (j >= i1) {
            break;
          }
          localMotionController = (MotionController)this.mFrameArrayList.get(getChildAt(j));
          f4 = f1;
          f3 = f2;
          if (!Float.isNaN(localMotionController.mMotionStagger))
          {
            f3 = Math.min(f2, localMotionController.mMotionStagger);
            f4 = Math.max(f1, localMotionController.mMotionStagger);
          }
          j += 1;
          f1 = f4;
          f2 = f3;
        }
        while (k < i1)
        {
          localMotionController = (MotionController)this.mFrameArrayList.get(getChildAt(k));
          if (!Float.isNaN(localMotionController.mMotionStagger))
          {
            localMotionController.mStaggerScale = (1.0F / (1.0F - f6));
            if (i != 0) {
              localMotionController.mStaggerOffset = (f6 - (f1 - localMotionController.mMotionStagger) / (f1 - f2) * f6);
            } else {
              localMotionController.mStaggerOffset = (f6 - (localMotionController.mMotionStagger - f2) * f6 / (f1 - f2));
            }
          }
          k += 1;
        }
      }
      while (k < i1)
      {
        localMotionController = (MotionController)this.mFrameArrayList.get(getChildAt(k));
        f3 = localMotionController.getFinalX();
        f4 = localMotionController.getFinalY();
        if (i != 0) {
          f3 = f4 - f3;
        } else {
          f3 = f4 + f3;
        }
        localMotionController.mStaggerScale = (1.0F / (1.0F - f6));
        localMotionController.mStaggerOffset = (f6 - (f3 - f2) * f6 / (f1 - f2));
        k += 1;
      }
    }
  }
  
  private static boolean willJump(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > 0.0F)
    {
      f = paramFloat1 / paramFloat3;
      return paramFloat2 + (paramFloat1 * f - paramFloat3 * f * f / 2.0F) > 1.0F;
    }
    float f = -paramFloat1 / paramFloat3;
    return paramFloat2 + (paramFloat1 * f + paramFloat3 * f * f / 2.0F) < 0.0F;
  }
  
  public void addTransitionListener(MotionLayout.TransitionListener paramTransitionListener)
  {
    if (this.mTransitionListeners == null) {
      this.mTransitionListeners = new ArrayList();
    }
    this.mTransitionListeners.add(paramTransitionListener);
  }
  
  void animateTo(float paramFloat)
  {
    if (this.mScene == null) {
      return;
    }
    float f1 = this.mTransitionLastPosition;
    float f2 = this.mTransitionPosition;
    if ((f1 != f2) && (this.mTransitionInstantly)) {
      this.mTransitionLastPosition = f2;
    }
    f1 = this.mTransitionLastPosition;
    if (f1 == paramFloat) {
      return;
    }
    this.mTemporalInterpolator = false;
    this.mTransitionGoalPosition = paramFloat;
    this.mTransitionDuration = (this.mScene.getDuration() / 1000.0F);
    setProgress(this.mTransitionGoalPosition);
    this.mInterpolator = this.mScene.getInterpolator();
    this.mTransitionInstantly = false;
    this.mAnimationStartTime = getNanoTime();
    this.mInTransition = true;
    this.mTransitionPosition = f1;
    this.mTransitionLastPosition = f1;
    invalidate();
  }
  
  void disableAutoTransition(boolean paramBoolean)
  {
    MotionScene localMotionScene = this.mScene;
    if (localMotionScene == null) {
      return;
    }
    localMotionScene.disableAutoTransition(paramBoolean);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    evaluate(false);
    super.dispatchDraw(paramCanvas);
    if (this.mScene == null) {
      return;
    }
    if (((this.mDebugPath & 0x1) == 1) && (!isInEditMode()))
    {
      this.mFrames += 1;
      long l1 = getNanoTime();
      long l2 = this.mLastDrawTime;
      if (l2 != -1L)
      {
        l2 = l1 - l2;
        if (l2 > 200000000L)
        {
          this.mLastFps = ((int)(this.mFrames / ((float)l2 * 1.0E-009F) * 100.0F) / 100.0F);
          this.mFrames = 0;
          this.mLastDrawTime = l1;
        }
      }
      else
      {
        this.mLastDrawTime = l1;
      }
      Paint localPaint = new Paint();
      localPaint.setTextSize(42.0F);
      float f = (int)(getProgress() * 1000.0F) / 10.0F;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mLastFps);
      ((StringBuilder)localObject).append(" fps ");
      ((StringBuilder)localObject).append(Debug.getState(this, this.mBeginState));
      ((StringBuilder)localObject).append(" -> ");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(Debug.getState(this, this.mEndState));
      localStringBuilder.append(" (progress: ");
      localStringBuilder.append(f);
      localStringBuilder.append(" ) state=");
      int i = this.mCurrentState;
      if (i == -1) {
        localObject = "undefined";
      } else {
        localObject = Debug.getState(this, i);
      }
      localStringBuilder.append((String)localObject);
      localObject = localStringBuilder.toString();
      localPaint.setColor(-16777216);
      paramCanvas.drawText((String)localObject, 11.0F, getHeight() - 29, localPaint);
      localPaint.setColor(-7864184);
      paramCanvas.drawText((String)localObject, 10.0F, getHeight() - 30, localPaint);
    }
    if (this.mDebugPath > 1)
    {
      if (this.mDevModeDraw == null) {
        this.mDevModeDraw = new MotionLayout.DevModeDraw(this);
      }
      this.mDevModeDraw.draw(paramCanvas, this.mFrameArrayList, this.mScene.getDuration(), this.mDebugPath);
    }
  }
  
  public void enableTransition(int paramInt, boolean paramBoolean)
  {
    MotionScene.Transition localTransition1 = getTransition(paramInt);
    if (paramBoolean)
    {
      localTransition1.setEnable(true);
      return;
    }
    if (localTransition1 == this.mScene.mCurrentTransition)
    {
      Iterator localIterator = this.mScene.getTransitionsWithState(this.mCurrentState).iterator();
      while (localIterator.hasNext())
      {
        MotionScene.Transition localTransition2 = (MotionScene.Transition)localIterator.next();
        if (localTransition2.isEnabled()) {
          this.mScene.mCurrentTransition = localTransition2;
        }
      }
    }
    localTransition1.setEnable(false);
  }
  
  void evaluate(boolean paramBoolean)
  {
    if (this.mTransitionLastTime == -1L) {
      this.mTransitionLastTime = getNanoTime();
    }
    float f1 = this.mTransitionLastPosition;
    if ((f1 > 0.0F) && (f1 < 1.0F)) {
      this.mCurrentState = -1;
    }
    boolean bool = this.mKeepAnimating;
    int k = 0;
    int j = 0;
    if (!bool)
    {
      i = k;
      if (!this.mInTransition) {
        break label1000;
      }
      if (!paramBoolean)
      {
        i = k;
        if (this.mTransitionGoalPosition == this.mTransitionLastPosition) {
          break label1000;
        }
      }
    }
    float f4 = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
    long l = getNanoTime();
    float f3;
    if (!(this.mInterpolator instanceof MotionInterpolator))
    {
      f3 = (float)(l - this.mTransitionLastTime) * f4 * 1.0E-009F / this.mTransitionDuration;
      this.mLastVelocity = f3;
    }
    else
    {
      f3 = 0.0F;
    }
    float f2 = this.mTransitionLastPosition + f3;
    if (this.mTransitionInstantly) {
      f2 = this.mTransitionGoalPosition;
    }
    if (((f4 > 0.0F) && (f2 >= this.mTransitionGoalPosition)) || ((f4 <= 0.0F) && (f2 <= this.mTransitionGoalPosition)))
    {
      f2 = this.mTransitionGoalPosition;
      this.mInTransition = false;
      i = 1;
    }
    else
    {
      i = 0;
    }
    this.mTransitionLastPosition = f2;
    this.mTransitionPosition = f2;
    this.mTransitionLastTime = l;
    Object localObject = this.mInterpolator;
    f1 = f2;
    if (localObject != null)
    {
      f1 = f2;
      if (i == 0) {
        if (this.mTemporalInterpolator)
        {
          f3 = ((Interpolator)localObject).getInterpolation((float)(l - this.mAnimationStartTime) * 1.0E-009F);
          this.mTransitionLastPosition = f3;
          this.mTransitionLastTime = l;
          localObject = this.mInterpolator;
          f2 = f3;
          if ((localObject instanceof MotionInterpolator))
          {
            float f5 = ((MotionInterpolator)localObject).getVelocity();
            this.mLastVelocity = f5;
            if (Math.abs(f5) * this.mTransitionDuration <= 1.0E-005F) {
              this.mInTransition = false;
            }
            f1 = f3;
            if (f5 > 0.0F)
            {
              f1 = f3;
              if (f3 >= 1.0F)
              {
                this.mTransitionLastPosition = 1.0F;
                this.mInTransition = false;
                f1 = 1.0F;
              }
            }
            f2 = f1;
            if (f5 < 0.0F)
            {
              f2 = f1;
              if (f1 <= 0.0F)
              {
                this.mTransitionLastPosition = 0.0F;
                this.mInTransition = false;
                f1 = 0.0F;
                break label484;
              }
            }
          }
          f1 = f2;
        }
        else
        {
          f1 = ((Interpolator)localObject).getInterpolation(f2);
          localObject = this.mInterpolator;
          if ((localObject instanceof MotionInterpolator)) {
            this.mLastVelocity = ((MotionInterpolator)localObject).getVelocity();
          } else {
            this.mLastVelocity = ((((Interpolator)localObject).getInterpolation(f2 + f3) - f1) * f4 / f3);
          }
        }
      }
    }
    label484:
    if (Math.abs(this.mLastVelocity) > 1.0E-005F) {
      setState(MotionLayout.TransitionState.MOVING);
    }
    if ((f4 <= 0.0F) || (f1 < this.mTransitionGoalPosition))
    {
      f2 = f1;
      if (f4 <= 0.0F)
      {
        f2 = f1;
        if (f1 > this.mTransitionGoalPosition) {}
      }
    }
    else
    {
      f2 = this.mTransitionGoalPosition;
      this.mInTransition = false;
    }
    if ((f2 >= 1.0F) || (f2 <= 0.0F))
    {
      this.mInTransition = false;
      setState(MotionLayout.TransitionState.FINISHED);
    }
    k = getChildCount();
    this.mKeepAnimating = false;
    l = getNanoTime();
    this.mPostInterpolationPosition = f2;
    int i = 0;
    while (i < k)
    {
      localObject = getChildAt(i);
      MotionController localMotionController = (MotionController)this.mFrameArrayList.get(localObject);
      if (localMotionController != null) {
        this.mKeepAnimating |= localMotionController.interpolate((View)localObject, f2, l, this.mKeyCache);
      }
      i += 1;
    }
    if (((f4 > 0.0F) && (f2 >= this.mTransitionGoalPosition)) || ((f4 <= 0.0F) && (f2 <= this.mTransitionGoalPosition))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((!this.mKeepAnimating) && (!this.mInTransition) && (i != 0)) {
      setState(MotionLayout.TransitionState.FINISHED);
    }
    if (this.mMeasureDuringTransition) {
      requestLayout();
    }
    this.mKeepAnimating = (i ^ 0x1 | this.mKeepAnimating);
    i = j;
    if (f2 <= 0.0F)
    {
      k = this.mBeginState;
      i = j;
      if (k != -1)
      {
        i = j;
        if (this.mCurrentState != k)
        {
          this.mCurrentState = k;
          this.mScene.getConstraintSet(k).applyCustomAttributes(this);
          setState(MotionLayout.TransitionState.FINISHED);
          i = 1;
        }
      }
    }
    j = i;
    if (f2 >= 1.0D)
    {
      k = this.mCurrentState;
      int m = this.mEndState;
      j = i;
      if (k != m)
      {
        this.mCurrentState = m;
        this.mScene.getConstraintSet(m).applyCustomAttributes(this);
        setState(MotionLayout.TransitionState.FINISHED);
        j = 1;
      }
    }
    if ((!this.mKeepAnimating) && (!this.mInTransition))
    {
      if (((f4 > 0.0F) && (f2 == 1.0F)) || ((f4 < 0.0F) && (f2 == 0.0F))) {
        setState(MotionLayout.TransitionState.FINISHED);
      }
    }
    else {
      invalidate();
    }
    if ((this.mKeepAnimating) || (!this.mInTransition) || (f4 <= 0.0F) || (f2 != 1.0F))
    {
      i = j;
      if (f4 < 0.0F)
      {
        i = j;
        if (f2 != 0.0F) {}
      }
    }
    else
    {
      onNewStateAttachHandlers();
      i = j;
    }
    label1000:
    f1 = this.mTransitionLastPosition;
    if (f1 >= 1.0F)
    {
      if (this.mCurrentState != this.mEndState) {
        i = 1;
      }
      this.mCurrentState = this.mEndState;
      j = i;
    }
    else
    {
      j = i;
      if (f1 <= 0.0F)
      {
        if (this.mCurrentState != this.mBeginState) {
          i = 1;
        }
        this.mCurrentState = this.mBeginState;
        j = i;
      }
    }
    this.mNeedsFireTransitionCompleted |= j;
    if ((j != 0) && (!this.mInLayout)) {
      requestLayout();
    }
    this.mTransitionPosition = this.mTransitionLastPosition;
  }
  
  protected void fireTransitionCompleted()
  {
    ArrayList localArrayList;
    if (this.mTransitionListener == null)
    {
      localArrayList = this.mTransitionListeners;
      if ((localArrayList == null) || (localArrayList.isEmpty())) {}
    }
    else if (this.mListenerState == -1)
    {
      this.mListenerState = this.mCurrentState;
      int i;
      if (!this.mTransitionCompleted.isEmpty())
      {
        localArrayList = this.mTransitionCompleted;
        i = ((Integer)localArrayList.get(localArrayList.size() - 1)).intValue();
      }
      else
      {
        i = -1;
      }
      int j = this.mCurrentState;
      if ((i != j) && (j != -1)) {
        this.mTransitionCompleted.add(Integer.valueOf(j));
      }
    }
    processTransitionCompleted();
  }
  
  public void fireTrigger(int paramInt, boolean paramBoolean, float paramFloat)
  {
    Object localObject = this.mTransitionListener;
    if (localObject != null) {
      ((MotionLayout.TransitionListener)localObject).onTransitionTrigger(this, paramInt, paramBoolean, paramFloat);
    }
    localObject = this.mTransitionListeners;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MotionLayout.TransitionListener)((Iterator)localObject).next()).onTransitionTrigger(this, paramInt, paramBoolean, paramFloat);
      }
    }
  }
  
  void getAnchorDpDt(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat)
  {
    Object localObject2 = this.mFrameArrayList;
    Object localObject1 = getViewById(paramInt);
    localObject2 = (MotionController)((HashMap)localObject2).get(localObject1);
    if (localObject2 != null)
    {
      ((MotionController)localObject2).getDpDt(paramFloat1, paramFloat2, paramFloat3, paramArrayOfFloat);
      paramFloat2 = ((View)localObject1).getY();
      paramFloat3 = this.lastPos;
      paramFloat3 = this.lastY;
      this.lastPos = paramFloat1;
      this.lastY = paramFloat2;
      return;
    }
    if (localObject1 == null)
    {
      paramArrayOfFloat = new StringBuilder();
      paramArrayOfFloat.append("");
      paramArrayOfFloat.append(paramInt);
      paramArrayOfFloat = paramArrayOfFloat.toString();
    }
    else
    {
      paramArrayOfFloat = ((View)localObject1).getContext().getResources().getResourceName(paramInt);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("WARNING could not find view id ");
    ((StringBuilder)localObject1).append(paramArrayOfFloat);
    Log.w("MotionLayout", ((StringBuilder)localObject1).toString());
  }
  
  public ConstraintSet getConstraintSet(int paramInt)
  {
    MotionScene localMotionScene = this.mScene;
    if (localMotionScene == null) {
      return null;
    }
    return localMotionScene.getConstraintSet(paramInt);
  }
  
  public int[] getConstraintSetIds()
  {
    MotionScene localMotionScene = this.mScene;
    if (localMotionScene == null) {
      return null;
    }
    return localMotionScene.getConstraintSetIds();
  }
  
  String getConstraintSetNames(int paramInt)
  {
    MotionScene localMotionScene = this.mScene;
    if (localMotionScene == null) {
      return null;
    }
    return localMotionScene.lookUpConstraintName(paramInt);
  }
  
  public int getCurrentState()
  {
    return this.mCurrentState;
  }
  
  public void getDebugMode(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    this.mDebugPath = i;
    invalidate();
  }
  
  public ArrayList<MotionScene.Transition> getDefinedTransitions()
  {
    MotionScene localMotionScene = this.mScene;
    if (localMotionScene == null) {
      return null;
    }
    return localMotionScene.getDefinedTransitions();
  }
  
  public DesignTool getDesignTool()
  {
    if (this.mDesignTool == null) {
      this.mDesignTool = new DesignTool(this);
    }
    return this.mDesignTool;
  }
  
  public int getEndState()
  {
    return this.mEndState;
  }
  
  protected long getNanoTime()
  {
    return System.nanoTime();
  }
  
  public float getProgress()
  {
    return this.mTransitionLastPosition;
  }
  
  public int getStartState()
  {
    return this.mBeginState;
  }
  
  public float getTargetPosition()
  {
    return this.mTransitionGoalPosition;
  }
  
  public MotionScene.Transition getTransition(int paramInt)
  {
    return this.mScene.getTransitionById(paramInt);
  }
  
  public Bundle getTransitionState()
  {
    if (this.mStateCache == null) {
      this.mStateCache = new MotionLayout.StateCache(this);
    }
    this.mStateCache.recordState();
    return this.mStateCache.getTransitionState();
  }
  
  public long getTransitionTimeMs()
  {
    MotionScene localMotionScene = this.mScene;
    if (localMotionScene != null) {
      this.mTransitionDuration = (localMotionScene.getDuration() / 1000.0F);
    }
    return (this.mTransitionDuration * 1000.0F);
  }
  
  public float getVelocity()
  {
    return this.mLastVelocity;
  }
  
  public void getViewVelocity(View paramView, float paramFloat1, float paramFloat2, float[] paramArrayOfFloat, int paramInt)
  {
    float f1 = this.mLastVelocity;
    float f3 = this.mTransitionLastPosition;
    float f2 = f3;
    if (this.mInterpolator != null)
    {
      f1 = Math.signum(this.mTransitionGoalPosition - f3);
      f3 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + 1.0E-005F);
      f2 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
      f1 = f1 * ((f3 - f2) / 1.0E-005F) / this.mTransitionDuration;
    }
    Object localObject = this.mInterpolator;
    if ((localObject instanceof MotionInterpolator)) {
      f1 = ((MotionInterpolator)localObject).getVelocity();
    }
    localObject = (MotionController)this.mFrameArrayList.get(paramView);
    if ((paramInt & 0x1) == 0) {
      ((MotionController)localObject).getPostLayoutDvDp(f2, paramView.getWidth(), paramView.getHeight(), paramFloat1, paramFloat2, paramArrayOfFloat);
    } else {
      ((MotionController)localObject).getDpDt(f2, paramFloat1, paramFloat2, paramArrayOfFloat);
    }
    if (paramInt < 2)
    {
      paramArrayOfFloat[0] *= f1;
      paramArrayOfFloat[1] *= f1;
    }
  }
  
  public boolean isAttachedToWindow()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return super.isAttachedToWindow();
    }
    return getWindowToken() != null;
  }
  
  public boolean isInteractionEnabled()
  {
    return this.mInteractionEnabled;
  }
  
  public void loadLayoutDescription(int paramInt)
  {
    if (paramInt != 0) {
      try
      {
        this.mScene = new MotionScene(getContext(), this, paramInt);
        if ((Build.VERSION.SDK_INT >= 19) && (!isAttachedToWindow())) {
          return;
        }
        this.mScene.readFallback(this);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        rebuildScene();
        this.mScene.setRtl(isRtl());
        return;
      }
      catch (Exception localException)
      {
        throw new IllegalArgumentException("unable to parse MotionScene file", localException);
      }
    } else {
      this.mScene = null;
    }
  }
  
  int lookUpConstraintId(String paramString)
  {
    MotionScene localMotionScene = this.mScene;
    if (localMotionScene == null) {
      return 0;
    }
    return localMotionScene.lookUpConstraintId(paramString);
  }
  
  protected MotionLayout.MotionTracker obtainVelocityTracker()
  {
    return MotionLayout.MyTracker.obtain();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = this.mScene;
    if (localObject != null)
    {
      int i = this.mCurrentState;
      if (i != -1)
      {
        localObject = ((MotionScene)localObject).getConstraintSet(i);
        this.mScene.readFallback(this);
        if (localObject != null) {
          ((ConstraintSet)localObject).applyTo(this);
        }
        this.mBeginState = this.mCurrentState;
      }
    }
    onNewStateAttachHandlers();
    localObject = this.mStateCache;
    if (localObject != null)
    {
      ((MotionLayout.StateCache)localObject).apply();
      return;
    }
    localObject = this.mScene;
    if ((localObject != null) && (((MotionScene)localObject).mCurrentTransition != null) && (this.mScene.mCurrentTransition.getAutoTransition() == 4))
    {
      transitionToEnd();
      setState(MotionLayout.TransitionState.SETUP);
      setState(MotionLayout.TransitionState.MOVING);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = this.mScene;
    if (localObject != null)
    {
      if (!this.mInteractionEnabled) {
        return false;
      }
      localObject = ((MotionScene)localObject).mCurrentTransition;
      if ((localObject != null) && (((MotionScene.Transition)localObject).isEnabled()))
      {
        localObject = ((MotionScene.Transition)localObject).getTouchResponse();
        if (localObject != null)
        {
          if (paramMotionEvent.getAction() == 0)
          {
            RectF localRectF = ((TouchResponse)localObject).getTouchRegion(this, new RectF());
            if ((localRectF != null) && (!localRectF.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))) {
              return false;
            }
          }
          int i = ((TouchResponse)localObject).getTouchRegionId();
          if (i != -1)
          {
            localObject = this.mRegionView;
            if ((localObject == null) || (((View)localObject).getId() != i)) {
              this.mRegionView = findViewById(i);
            }
            localObject = this.mRegionView;
            if (localObject != null)
            {
              this.mBoundsCheck.set(((View)localObject).getLeft(), this.mRegionView.getTop(), this.mRegionView.getRight(), this.mRegionView.getBottom());
              if ((this.mBoundsCheck.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) && (!handlesTouchEvent(0.0F, 0.0F, this.mRegionView, paramMotionEvent))) {
                return onTouchEvent(paramMotionEvent);
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mInLayout = true;
    try
    {
      if (this.mScene == null)
      {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      paramInt1 = paramInt3 - paramInt1;
      paramInt2 = paramInt4 - paramInt2;
      if ((this.mLastLayoutWidth != paramInt1) || (this.mLastLayoutHeight != paramInt2))
      {
        rebuildScene();
        evaluate(true);
      }
      this.mLastLayoutWidth = paramInt1;
      this.mLastLayoutHeight = paramInt2;
      this.mOldWidth = paramInt1;
      this.mOldHeight = paramInt2;
      return;
    }
    finally
    {
      this.mInLayout = false;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mScene == null)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i = this.mLastWidthMeasureSpec;
    int j = 0;
    if ((i == paramInt1) && (this.mLastHeightMeasureSpec == paramInt2)) {
      i = 0;
    } else {
      i = 1;
    }
    if (this.mNeedsFireTransitionCompleted)
    {
      this.mNeedsFireTransitionCompleted = false;
      onNewStateAttachHandlers();
      processTransitionCompleted();
      i = 1;
    }
    if (this.mDirtyHierarchy) {
      i = 1;
    }
    this.mLastWidthMeasureSpec = paramInt1;
    this.mLastHeightMeasureSpec = paramInt2;
    int k = this.mScene.getStartId();
    int m = this.mScene.getEndId();
    if (((i != 0) || (this.mModel.isNotConfiguredWith(k, m))) && (this.mBeginState != -1))
    {
      super.onMeasure(paramInt1, paramInt2);
      this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(k), this.mScene.getConstraintSet(m));
      this.mModel.reEvaluateState();
      this.mModel.setMeasuredId(k, m);
      paramInt1 = j;
    }
    else
    {
      paramInt1 = 1;
    }
    if ((this.mMeasureDuringTransition) || (paramInt1 != 0))
    {
      paramInt2 = getPaddingTop();
      i = getPaddingBottom();
      paramInt1 = getPaddingLeft();
      j = getPaddingRight();
      paramInt1 = this.mLayoutWidget.getWidth() + (paramInt1 + j);
      paramInt2 = this.mLayoutWidget.getHeight() + (paramInt2 + i);
      i = this.mWidthMeasureMode;
      if ((i == -2147483648) || (i == 0))
      {
        paramInt1 = this.mStartWrapWidth;
        paramInt1 = (int)(paramInt1 + this.mPostInterpolationPosition * (this.mEndWrapWidth - paramInt1));
        requestLayout();
      }
      i = this.mHeightMeasureMode;
      if ((i == -2147483648) || (i == 0))
      {
        paramInt2 = this.mStartWrapHeight;
        paramInt2 = (int)(paramInt2 + this.mPostInterpolationPosition * (this.mEndWrapHeight - paramInt2));
        requestLayout();
      }
      setMeasuredDimension(paramInt1, paramInt2);
    }
    evaluateLayout();
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    Object localObject1 = this.mScene;
    if (localObject1 != null)
    {
      if (((MotionScene)localObject1).mCurrentTransition == null) {
        return;
      }
      if (!this.mScene.mCurrentTransition.isEnabled()) {
        return;
      }
      localObject1 = this.mScene.mCurrentTransition;
      if ((localObject1 != null) && (((MotionScene.Transition)localObject1).isEnabled()))
      {
        localObject2 = ((MotionScene.Transition)localObject1).getTouchResponse();
        if (localObject2 != null)
        {
          paramInt3 = ((TouchResponse)localObject2).getTouchRegionId();
          if ((paramInt3 != -1) && (paramView.getId() != paramInt3)) {
            return;
          }
        }
      }
      Object localObject2 = this.mScene;
      if ((localObject2 != null) && (((MotionScene)localObject2).getMoveWhenScrollAtTop()))
      {
        f1 = this.mTransitionPosition;
        if (((f1 == 1.0F) || (f1 == 0.0F)) && (paramView.canScrollVertically(-1))) {
          return;
        }
      }
      if ((((MotionScene.Transition)localObject1).getTouchResponse() != null) && ((this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 0x1) != 0))
      {
        f1 = this.mScene.getProgressDirection(paramInt1, paramInt2);
        if (((this.mTransitionLastPosition <= 0.0F) && (f1 < 0.0F)) || ((this.mTransitionLastPosition >= 1.0F) && (f1 > 0.0F)))
        {
          if (Build.VERSION.SDK_INT >= 21)
          {
            paramView.setNestedScrollingEnabled(false);
            paramView.post(new MotionLayout.1(this, paramView));
          }
          return;
        }
      }
      float f1 = this.mTransitionPosition;
      long l = getNanoTime();
      float f2 = paramInt1;
      this.mScrollTargetDX = f2;
      float f3 = paramInt2;
      this.mScrollTargetDY = f3;
      double d = l - this.mScrollTargetTime;
      Double.isNaN(d);
      this.mScrollTargetDT = ((float)(d * 1.E-009D));
      this.mScrollTargetTime = l;
      this.mScene.processScrollMove(f2, f3);
      if (f1 != this.mTransitionPosition)
      {
        paramArrayOfInt[0] = paramInt1;
        paramArrayOfInt[1] = paramInt2;
      }
      evaluate(false);
      if ((paramArrayOfInt[0] != 0) || (paramArrayOfInt[1] != 0)) {
        this.mUndergoingMotion = true;
      }
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
  {
    if ((this.mUndergoingMotion) || (paramInt1 != 0) || (paramInt2 != 0))
    {
      paramArrayOfInt[0] += paramInt3;
      paramArrayOfInt[1] += paramInt4;
    }
    this.mUndergoingMotion = false;
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt1, int paramInt2) {}
  
  void onNewStateAttachHandlers()
  {
    MotionScene localMotionScene = this.mScene;
    if (localMotionScene == null) {
      return;
    }
    if (localMotionScene.autoTransition(this, this.mCurrentState))
    {
      requestLayout();
      return;
    }
    int i = this.mCurrentState;
    if (i != -1) {
      this.mScene.addOnClickListeners(this, i);
    }
    if (this.mScene.supportTouch()) {
      this.mScene.setupTouch();
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    MotionScene localMotionScene = this.mScene;
    if (localMotionScene != null) {
      localMotionScene.setRtl(isRtl());
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    paramView1 = this.mScene;
    return (paramView1 != null) && (paramView1.mCurrentTransition != null) && (this.mScene.mCurrentTransition.getTouchResponse() != null) && ((this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 0x2) == 0);
  }
  
  public void onStopNestedScroll(View paramView, int paramInt)
  {
    paramView = this.mScene;
    if (paramView == null) {
      return;
    }
    float f1 = this.mScrollTargetDX;
    float f2 = this.mScrollTargetDT;
    paramView.processScrollUp(f1 / f2, this.mScrollTargetDY / f2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = this.mScene;
    if ((localObject != null) && (this.mInteractionEnabled) && (((MotionScene)localObject).supportTouch()))
    {
      localObject = this.mScene.mCurrentTransition;
      if ((localObject != null) && (!((MotionScene.Transition)localObject).isEnabled())) {
        return super.onTouchEvent(paramMotionEvent);
      }
      this.mScene.processTouchEvent(paramMotionEvent, getCurrentState(), this);
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onViewAdded(View paramView)
  {
    super.onViewAdded(paramView);
    if ((paramView instanceof MotionHelper))
    {
      paramView = (MotionHelper)paramView;
      if (this.mTransitionListeners == null) {
        this.mTransitionListeners = new ArrayList();
      }
      this.mTransitionListeners.add(paramView);
      if (paramView.isUsedOnShow())
      {
        if (this.mOnShowHelpers == null) {
          this.mOnShowHelpers = new ArrayList();
        }
        this.mOnShowHelpers.add(paramView);
      }
      if (paramView.isUseOnHide())
      {
        if (this.mOnHideHelpers == null) {
          this.mOnHideHelpers = new ArrayList();
        }
        this.mOnHideHelpers.add(paramView);
      }
    }
  }
  
  public void onViewRemoved(View paramView)
  {
    super.onViewRemoved(paramView);
    ArrayList localArrayList = this.mOnShowHelpers;
    if (localArrayList != null) {
      localArrayList.remove(paramView);
    }
    localArrayList = this.mOnHideHelpers;
    if (localArrayList != null) {
      localArrayList.remove(paramView);
    }
  }
  
  protected void parseLayoutDescription(int paramInt)
  {
    this.mConstraintLayoutSpec = null;
  }
  
  @Deprecated
  public void rebuildMotion()
  {
    Log.e("MotionLayout", "This method is deprecated. Please call rebuildScene() instead.");
    rebuildScene();
  }
  
  public void rebuildScene()
  {
    this.mModel.reEvaluateState();
    invalidate();
  }
  
  public boolean removeTransitionListener(MotionLayout.TransitionListener paramTransitionListener)
  {
    ArrayList localArrayList = this.mTransitionListeners;
    if (localArrayList == null) {
      return false;
    }
    return localArrayList.remove(paramTransitionListener);
  }
  
  public void requestLayout()
  {
    if ((!this.mMeasureDuringTransition) && (this.mCurrentState == -1))
    {
      MotionScene localMotionScene = this.mScene;
      if ((localMotionScene != null) && (localMotionScene.mCurrentTransition != null) && (this.mScene.mCurrentTransition.getLayoutDuringTransition() == 0)) {
        return;
      }
    }
    super.requestLayout();
  }
  
  public void setDebugMode(int paramInt)
  {
    this.mDebugPath = paramInt;
    invalidate();
  }
  
  public void setInteractionEnabled(boolean paramBoolean)
  {
    this.mInteractionEnabled = paramBoolean;
  }
  
  public void setInterpolatedProgress(float paramFloat)
  {
    if (this.mScene != null)
    {
      setState(MotionLayout.TransitionState.MOVING);
      Interpolator localInterpolator = this.mScene.getInterpolator();
      if (localInterpolator != null)
      {
        setProgress(localInterpolator.getInterpolation(paramFloat));
        return;
      }
    }
    setProgress(paramFloat);
  }
  
  public void setOnHide(float paramFloat)
  {
    ArrayList localArrayList = this.mOnHideHelpers;
    if (localArrayList != null)
    {
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((MotionHelper)this.mOnHideHelpers.get(i)).setProgress(paramFloat);
        i += 1;
      }
    }
  }
  
  public void setOnShow(float paramFloat)
  {
    ArrayList localArrayList = this.mOnShowHelpers;
    if (localArrayList != null)
    {
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((MotionHelper)this.mOnShowHelpers.get(i)).setProgress(paramFloat);
        i += 1;
      }
    }
  }
  
  public void setProgress(float paramFloat)
  {
    if ((paramFloat < 0.0F) || (paramFloat > 1.0F)) {
      Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
    }
    if (!isAttachedToWindow())
    {
      if (this.mStateCache == null) {
        this.mStateCache = new MotionLayout.StateCache(this);
      }
      this.mStateCache.setProgress(paramFloat);
      return;
    }
    if (paramFloat <= 0.0F)
    {
      this.mCurrentState = this.mBeginState;
      if (this.mTransitionLastPosition == 0.0F) {
        setState(MotionLayout.TransitionState.FINISHED);
      }
    }
    else if (paramFloat >= 1.0F)
    {
      this.mCurrentState = this.mEndState;
      if (this.mTransitionLastPosition == 1.0F) {
        setState(MotionLayout.TransitionState.FINISHED);
      }
    }
    else
    {
      this.mCurrentState = -1;
      setState(MotionLayout.TransitionState.MOVING);
    }
    if (this.mScene == null) {
      return;
    }
    this.mTransitionInstantly = true;
    this.mTransitionGoalPosition = paramFloat;
    this.mTransitionPosition = paramFloat;
    this.mTransitionLastTime = -1L;
    this.mAnimationStartTime = -1L;
    this.mInterpolator = null;
    this.mInTransition = true;
    invalidate();
  }
  
  public void setProgress(float paramFloat1, float paramFloat2)
  {
    if (!isAttachedToWindow())
    {
      if (this.mStateCache == null) {
        this.mStateCache = new MotionLayout.StateCache(this);
      }
      this.mStateCache.setProgress(paramFloat1);
      this.mStateCache.setVelocity(paramFloat2);
      return;
    }
    setProgress(paramFloat1);
    setState(MotionLayout.TransitionState.MOVING);
    this.mLastVelocity = paramFloat2;
    animateTo(1.0F);
  }
  
  public void setScene(MotionScene paramMotionScene)
  {
    this.mScene = paramMotionScene;
    this.mScene.setRtl(isRtl());
    rebuildScene();
  }
  
  public void setState(int paramInt1, int paramInt2, int paramInt3)
  {
    setState(MotionLayout.TransitionState.SETUP);
    this.mCurrentState = paramInt1;
    this.mBeginState = -1;
    this.mEndState = -1;
    if (this.mConstraintLayoutSpec != null)
    {
      this.mConstraintLayoutSpec.updateConstraints(paramInt1, paramInt2, paramInt3);
      return;
    }
    MotionScene localMotionScene = this.mScene;
    if (localMotionScene != null) {
      localMotionScene.getConstraintSet(paramInt1).applyTo(this);
    }
  }
  
  void setState(MotionLayout.TransitionState paramTransitionState)
  {
    if ((paramTransitionState == MotionLayout.TransitionState.FINISHED) && (this.mCurrentState == -1)) {
      return;
    }
    MotionLayout.TransitionState localTransitionState = this.mTransitionState;
    this.mTransitionState = paramTransitionState;
    if ((localTransitionState == MotionLayout.TransitionState.MOVING) && (paramTransitionState == MotionLayout.TransitionState.MOVING)) {
      fireTransitionChange();
    }
    int i = MotionLayout.2.$SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[localTransitionState.ordinal()];
    if ((i != 1) && (i != 2))
    {
      if (i != 3) {
        return;
      }
      if (paramTransitionState == MotionLayout.TransitionState.FINISHED) {
        fireTransitionCompleted();
      }
    }
    else
    {
      if (paramTransitionState == MotionLayout.TransitionState.MOVING) {
        fireTransitionChange();
      }
      if (paramTransitionState == MotionLayout.TransitionState.FINISHED) {
        fireTransitionCompleted();
      }
    }
  }
  
  public void setTransition(int paramInt)
  {
    if (this.mScene != null)
    {
      Object localObject = getTransition(paramInt);
      paramInt = this.mCurrentState;
      this.mBeginState = ((MotionScene.Transition)localObject).getStartConstraintSetId();
      this.mEndState = ((MotionScene.Transition)localObject).getEndConstraintSetId();
      if (!isAttachedToWindow())
      {
        if (this.mStateCache == null) {
          this.mStateCache = new MotionLayout.StateCache(this);
        }
        this.mStateCache.setStartState(this.mBeginState);
        this.mStateCache.setEndState(this.mEndState);
        return;
      }
      float f1 = (0.0F / 0.0F);
      paramInt = this.mCurrentState;
      int i = this.mBeginState;
      float f2 = 0.0F;
      if (paramInt == i) {
        f1 = 0.0F;
      } else if (paramInt == this.mEndState) {
        f1 = 1.0F;
      }
      this.mScene.setTransition((MotionScene.Transition)localObject);
      this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
      rebuildScene();
      if (!Float.isNaN(f1)) {
        f2 = f1;
      }
      this.mTransitionLastPosition = f2;
      if (Float.isNaN(f1))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(Debug.getLocation());
        ((StringBuilder)localObject).append(" transitionToStart ");
        Log.v("MotionLayout", ((StringBuilder)localObject).toString());
        transitionToStart();
        return;
      }
      setProgress(f1);
    }
  }
  
  public void setTransition(int paramInt1, int paramInt2)
  {
    if (!isAttachedToWindow())
    {
      if (this.mStateCache == null) {
        this.mStateCache = new MotionLayout.StateCache(this);
      }
      this.mStateCache.setStartState(paramInt1);
      this.mStateCache.setEndState(paramInt2);
      return;
    }
    MotionScene localMotionScene = this.mScene;
    if (localMotionScene != null)
    {
      this.mBeginState = paramInt1;
      this.mEndState = paramInt2;
      localMotionScene.setTransition(paramInt1, paramInt2);
      this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(paramInt1), this.mScene.getConstraintSet(paramInt2));
      rebuildScene();
      this.mTransitionLastPosition = 0.0F;
      transitionToStart();
    }
  }
  
  protected void setTransition(MotionScene.Transition paramTransition)
  {
    this.mScene.setTransition(paramTransition);
    setState(MotionLayout.TransitionState.SETUP);
    if (this.mCurrentState == this.mScene.getEndId())
    {
      this.mTransitionLastPosition = 1.0F;
      this.mTransitionPosition = 1.0F;
      this.mTransitionGoalPosition = 1.0F;
    }
    else
    {
      this.mTransitionLastPosition = 0.0F;
      this.mTransitionPosition = 0.0F;
      this.mTransitionGoalPosition = 0.0F;
    }
    long l;
    if (paramTransition.isTransitionFlag(1)) {
      l = -1L;
    } else {
      l = getNanoTime();
    }
    this.mTransitionLastTime = l;
    int i = this.mScene.getStartId();
    int j = this.mScene.getEndId();
    if ((i == this.mBeginState) && (j == this.mEndState)) {
      return;
    }
    this.mBeginState = i;
    this.mEndState = j;
    this.mScene.setTransition(this.mBeginState, this.mEndState);
    this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
    this.mModel.setMeasuredId(this.mBeginState, this.mEndState);
    this.mModel.reEvaluateState();
    rebuildScene();
  }
  
  public void setTransitionDuration(int paramInt)
  {
    MotionScene localMotionScene = this.mScene;
    if (localMotionScene == null)
    {
      Log.e("MotionLayout", "MotionScene not defined");
      return;
    }
    localMotionScene.setDuration(paramInt);
  }
  
  public void setTransitionListener(MotionLayout.TransitionListener paramTransitionListener)
  {
    this.mTransitionListener = paramTransitionListener;
  }
  
  public void setTransitionState(Bundle paramBundle)
  {
    if (this.mStateCache == null) {
      this.mStateCache = new MotionLayout.StateCache(this);
    }
    this.mStateCache.setTransitionState(paramBundle);
    if (isAttachedToWindow()) {
      this.mStateCache.apply();
    }
  }
  
  public String toString()
  {
    Context localContext = getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Debug.getName(localContext, this.mBeginState));
    localStringBuilder.append("->");
    localStringBuilder.append(Debug.getName(localContext, this.mEndState));
    localStringBuilder.append(" (pos:");
    localStringBuilder.append(this.mTransitionLastPosition);
    localStringBuilder.append(" Dpos/Dt:");
    localStringBuilder.append(this.mLastVelocity);
    return localStringBuilder.toString();
  }
  
  public void touchAnimateTo(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (this.mScene == null) {
      return;
    }
    if (this.mTransitionLastPosition == paramFloat1) {
      return;
    }
    this.mTemporalInterpolator = true;
    this.mAnimationStartTime = getNanoTime();
    this.mTransitionDuration = (this.mScene.getDuration() / 1000.0F);
    this.mTransitionGoalPosition = paramFloat1;
    this.mInTransition = true;
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3) {
        if (paramInt != 4)
        {
          if (paramInt == 5) {
            if (willJump(paramFloat2, this.mTransitionLastPosition, this.mScene.getMaxAcceleration()))
            {
              this.mDecelerateLogic.config(paramFloat2, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
              this.mInterpolator = this.mDecelerateLogic;
            }
            else
            {
              this.mStopLogic.config(this.mTransitionLastPosition, paramFloat1, paramFloat2, this.mTransitionDuration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
              this.mLastVelocity = 0.0F;
              paramInt = this.mCurrentState;
              this.mTransitionGoalPosition = paramFloat1;
              this.mCurrentState = paramInt;
              this.mInterpolator = this.mStopLogic;
            }
          }
        }
        else
        {
          this.mDecelerateLogic.config(paramFloat2, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
          this.mInterpolator = this.mDecelerateLogic;
        }
      }
    }
    else
    {
      if (paramInt == 1) {
        paramFloat1 = 0.0F;
      } else if (paramInt == 2) {
        paramFloat1 = 1.0F;
      }
      this.mStopLogic.config(this.mTransitionLastPosition, paramFloat1, paramFloat2, this.mTransitionDuration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
      paramInt = this.mCurrentState;
      this.mTransitionGoalPosition = paramFloat1;
      this.mCurrentState = paramInt;
      this.mInterpolator = this.mStopLogic;
    }
    this.mTransitionInstantly = false;
    this.mAnimationStartTime = getNanoTime();
    invalidate();
  }
  
  public void transitionToEnd()
  {
    animateTo(1.0F);
  }
  
  public void transitionToStart()
  {
    animateTo(0.0F);
  }
  
  public void transitionToState(int paramInt)
  {
    if (!isAttachedToWindow())
    {
      if (this.mStateCache == null) {
        this.mStateCache = new MotionLayout.StateCache(this);
      }
      this.mStateCache.setEndState(paramInt);
      return;
    }
    transitionToState(paramInt, -1, -1);
  }
  
  public void transitionToState(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.mScene;
    int i = paramInt1;
    if (localObject != null)
    {
      i = paramInt1;
      if (((MotionScene)localObject).mStateSet != null)
      {
        paramInt2 = this.mScene.mStateSet.convertToConstraintSet(this.mCurrentState, paramInt1, paramInt2, paramInt3);
        i = paramInt1;
        if (paramInt2 != -1) {
          i = paramInt2;
        }
      }
    }
    paramInt1 = this.mCurrentState;
    if (paramInt1 == i) {
      return;
    }
    if (this.mBeginState == i)
    {
      animateTo(0.0F);
      return;
    }
    if (this.mEndState == i)
    {
      animateTo(1.0F);
      return;
    }
    this.mEndState = i;
    if (paramInt1 != -1)
    {
      setTransition(paramInt1, i);
      animateTo(1.0F);
      this.mTransitionLastPosition = 0.0F;
      transitionToEnd();
      return;
    }
    paramInt3 = 0;
    this.mTemporalInterpolator = false;
    this.mTransitionGoalPosition = 1.0F;
    this.mTransitionPosition = 0.0F;
    this.mTransitionLastPosition = 0.0F;
    this.mTransitionLastTime = getNanoTime();
    this.mAnimationStartTime = getNanoTime();
    this.mTransitionInstantly = false;
    this.mInterpolator = null;
    this.mTransitionDuration = (this.mScene.getDuration() / 1000.0F);
    this.mBeginState = -1;
    this.mScene.setTransition(this.mBeginState, this.mEndState);
    this.mScene.getStartId();
    int j = getChildCount();
    this.mFrameArrayList.clear();
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      localObject = getChildAt(paramInt1);
      MotionController localMotionController = new MotionController((View)localObject);
      this.mFrameArrayList.put(localObject, localMotionController);
      paramInt1 += 1;
    }
    this.mInTransition = true;
    this.mModel.initFrom(this.mLayoutWidget, null, this.mScene.getConstraintSet(i));
    rebuildScene();
    this.mModel.build();
    computeCurrentPositions();
    paramInt2 = getWidth();
    i = getHeight();
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      localObject = (MotionController)this.mFrameArrayList.get(getChildAt(paramInt1));
      this.mScene.getKeyFrames((MotionController)localObject);
      ((MotionController)localObject).setup(paramInt2, i, this.mTransitionDuration, getNanoTime());
      paramInt1 += 1;
    }
    float f3 = this.mScene.getStaggered();
    if (f3 != 0.0F)
    {
      paramInt1 = 0;
      float f2 = 3.4028235E+38F;
      float f1 = -3.402824E+038F;
      float f4;
      for (;;)
      {
        paramInt2 = paramInt3;
        if (paramInt1 >= j) {
          break;
        }
        localObject = (MotionController)this.mFrameArrayList.get(getChildAt(paramInt1));
        f4 = ((MotionController)localObject).getFinalX();
        f4 = ((MotionController)localObject).getFinalY() + f4;
        f2 = Math.min(f2, f4);
        f1 = Math.max(f1, f4);
        paramInt1 += 1;
      }
      while (paramInt2 < j)
      {
        localObject = (MotionController)this.mFrameArrayList.get(getChildAt(paramInt2));
        f4 = ((MotionController)localObject).getFinalX();
        float f5 = ((MotionController)localObject).getFinalY();
        ((MotionController)localObject).mStaggerScale = (1.0F / (1.0F - f3));
        ((MotionController)localObject).mStaggerOffset = (f3 - (f4 + f5 - f2) * f3 / (f1 - f2));
        paramInt2 += 1;
      }
    }
    this.mTransitionPosition = 0.0F;
    this.mTransitionLastPosition = 0.0F;
    this.mInTransition = true;
    invalidate();
  }
  
  public void updateState()
  {
    this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
    rebuildScene();
  }
  
  public void updateState(int paramInt, ConstraintSet paramConstraintSet)
  {
    MotionScene localMotionScene = this.mScene;
    if (localMotionScene != null) {
      localMotionScene.setConstraintSet(paramInt, paramConstraintSet);
    }
    updateState();
    if (this.mCurrentState == paramInt) {
      paramConstraintSet.applyTo(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.MotionLayout
 * JD-Core Version:    0.7.0.1
 */