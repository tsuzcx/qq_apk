package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.TypedValue;

public class ConstraintSet$Motion
{
  private static final int ANIMATE_RELATIVE_TO = 5;
  private static final int MOTION_DRAW_PATH = 4;
  private static final int MOTION_STAGGER = 6;
  private static final int PATH_MOTION_ARC = 2;
  private static final int TRANSITION_EASING = 3;
  private static final int TRANSITION_PATH_ROTATE = 1;
  private static SparseIntArray mapToConstant = new SparseIntArray();
  public int mAnimateRelativeTo = -1;
  public boolean mApply = false;
  public int mDrawPath = 0;
  public float mMotionStagger = (0.0F / 0.0F);
  public int mPathMotionArc = -1;
  public float mPathRotate = (0.0F / 0.0F);
  public String mTransitionEasing = null;
  
  static
  {
    mapToConstant.append(R.styleable.Motion_motionPathRotate, 1);
    mapToConstant.append(R.styleable.Motion_pathMotionArc, 2);
    mapToConstant.append(R.styleable.Motion_transitionEasing, 3);
    mapToConstant.append(R.styleable.Motion_drawPath, 4);
    mapToConstant.append(R.styleable.Motion_animate_relativeTo, 5);
    mapToConstant.append(R.styleable.Motion_motionStagger, 6);
  }
  
  public void copyFrom(Motion paramMotion)
  {
    this.mApply = paramMotion.mApply;
    this.mAnimateRelativeTo = paramMotion.mAnimateRelativeTo;
    this.mTransitionEasing = paramMotion.mTransitionEasing;
    this.mPathMotionArc = paramMotion.mPathMotionArc;
    this.mDrawPath = paramMotion.mDrawPath;
    this.mPathRotate = paramMotion.mPathRotate;
    this.mMotionStagger = paramMotion.mMotionStagger;
  }
  
  void fillFromAttributeList(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Motion);
    this.mApply = true;
    int j = paramContext.getIndexCount();
    int i = 0;
    while (i < j)
    {
      int k = paramContext.getIndex(i);
      switch (mapToConstant.get(k))
      {
      default: 
        break;
      case 6: 
        this.mMotionStagger = paramContext.getFloat(k, this.mMotionStagger);
        break;
      case 5: 
        this.mAnimateRelativeTo = ConstraintSet.access$100(paramContext, k, this.mAnimateRelativeTo);
        break;
      case 4: 
        this.mDrawPath = paramContext.getInt(k, 0);
        break;
      case 3: 
        if (paramContext.peekValue(k).type == 3) {
          this.mTransitionEasing = paramContext.getString(k);
        } else {
          this.mTransitionEasing = androidx.constraintlayout.motion.utils.Easing.NAMED_EASING[paramContext.getInteger(k, 0)];
        }
        break;
      case 2: 
        this.mPathMotionArc = paramContext.getInt(k, this.mPathMotionArc);
        break;
      case 1: 
        this.mPathRotate = paramContext.getFloat(k, this.mPathRotate);
      }
      i += 1;
    }
    paramContext.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintSet.Motion
 * JD-Core Version:    0.7.0.1
 */