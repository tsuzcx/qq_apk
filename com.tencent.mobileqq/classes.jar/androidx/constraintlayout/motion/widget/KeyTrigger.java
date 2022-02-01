package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R.styleable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

public class KeyTrigger
  extends Key
{
  public static final int KEY_TYPE = 5;
  static final String NAME = "KeyTrigger";
  private static final String TAG = "KeyTrigger";
  RectF mCollisionRect = new RectF();
  private String mCross = null;
  private int mCurveFit = -1;
  private Method mFireCross;
  private boolean mFireCrossReset = true;
  private float mFireLastPos;
  private Method mFireNegativeCross;
  private boolean mFireNegativeReset = true;
  private Method mFirePositiveCross;
  private boolean mFirePositiveReset = true;
  private float mFireThreshold = (0.0F / 0.0F);
  private String mNegativeCross = null;
  private String mPositiveCross = null;
  private boolean mPostLayout = false;
  RectF mTargetRect = new RectF();
  private int mTriggerCollisionId = UNSET;
  private View mTriggerCollisionView = null;
  private int mTriggerID = UNSET;
  private int mTriggerReceiver = UNSET;
  float mTriggerSlack = 0.1F;
  
  public KeyTrigger()
  {
    this.mType = 5;
    this.mCustomConstraints = new HashMap();
  }
  
  private void setUpRect(RectF paramRectF, View paramView, boolean paramBoolean)
  {
    paramRectF.top = paramView.getTop();
    paramRectF.bottom = paramView.getBottom();
    paramRectF.left = paramView.getLeft();
    paramRectF.right = paramView.getRight();
    if (paramBoolean) {
      paramView.getMatrix().mapRect(paramRectF);
    }
  }
  
  public void addValues(HashMap<String, SplineSet> paramHashMap) {}
  
  public void conditionallyFire(float paramFloat, View paramView)
  {
    int i = this.mTriggerCollisionId;
    int j = UNSET;
    boolean bool = true;
    if (i != j)
    {
      if (this.mTriggerCollisionView == null) {
        this.mTriggerCollisionView = ((ViewGroup)paramView.getParent()).findViewById(this.mTriggerCollisionId);
      }
      setUpRect(this.mCollisionRect, this.mTriggerCollisionView, this.mPostLayout);
      setUpRect(this.mTargetRect, paramView, this.mPostLayout);
      if (this.mCollisionRect.intersect(this.mTargetRect))
      {
        if (this.mFireCrossReset)
        {
          this.mFireCrossReset = false;
          i = 1;
        }
        else
        {
          i = 0;
        }
        if (this.mFirePositiveReset)
        {
          this.mFirePositiveReset = false;
          bool = true;
        }
        else
        {
          bool = false;
        }
        this.mFireNegativeReset = true;
        j = 0;
      }
      else
      {
        if (!this.mFireCrossReset)
        {
          this.mFireCrossReset = true;
          i = 1;
        }
        else
        {
          i = 0;
        }
        if (this.mFireNegativeReset)
        {
          this.mFireNegativeReset = false;
          j = 1;
        }
        else
        {
          j = 0;
        }
        this.mFirePositiveReset = true;
        bool = false;
      }
    }
    else
    {
      float f1;
      if (this.mFireCrossReset)
      {
        f1 = this.mFireThreshold;
        if ((paramFloat - f1) * (this.mFireLastPos - f1) < 0.0F)
        {
          this.mFireCrossReset = false;
          i = 1;
          break label258;
        }
      }
      else if (Math.abs(paramFloat - this.mFireThreshold) > this.mTriggerSlack)
      {
        this.mFireCrossReset = true;
      }
      i = 0;
      label258:
      float f2;
      if (this.mFireNegativeReset)
      {
        f1 = this.mFireThreshold;
        f2 = paramFloat - f1;
        if (((this.mFireLastPos - f1) * f2 < 0.0F) && (f2 < 0.0F))
        {
          this.mFireNegativeReset = false;
          j = 1;
          break label332;
        }
      }
      else if (Math.abs(paramFloat - this.mFireThreshold) > this.mTriggerSlack)
      {
        this.mFireNegativeReset = true;
      }
      j = 0;
      label332:
      if (this.mFirePositiveReset)
      {
        f1 = this.mFireThreshold;
        f2 = paramFloat - f1;
        if (((this.mFireLastPos - f1) * f2 < 0.0F) && (f2 > 0.0F))
        {
          this.mFirePositiveReset = false;
          break label403;
        }
      }
      else if (Math.abs(paramFloat - this.mFireThreshold) > this.mTriggerSlack)
      {
        this.mFirePositiveReset = true;
      }
      bool = false;
    }
    label403:
    this.mFireLastPos = paramFloat;
    if ((j != 0) || (i != 0) || (bool)) {
      ((MotionLayout)paramView.getParent()).fireTrigger(this.mTriggerID, bool, paramFloat);
    }
    if (this.mTriggerReceiver != UNSET) {
      paramView = ((MotionLayout)paramView.getParent()).findViewById(this.mTriggerReceiver);
    }
    if ((j == 0) || (this.mNegativeCross == null) || (this.mFireNegativeCross == null)) {}
    try
    {
      this.mFireNegativeCross = paramView.getClass().getMethod(this.mNegativeCross, new Class[0]);
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      label509:
      StringBuilder localStringBuilder;
      break label509;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Could not find method \"");
    localStringBuilder.append(this.mNegativeCross);
    localStringBuilder.append("\"on class ");
    localStringBuilder.append(paramView.getClass().getSimpleName());
    localStringBuilder.append(" ");
    localStringBuilder.append(Debug.getName(paramView));
    Log.e("KeyTrigger", localStringBuilder.toString());
    try
    {
      this.mFireNegativeCross.invoke(paramView, new Object[0]);
    }
    catch (Exception localException1)
    {
      label602:
      break label602;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Exception in call \"");
    localStringBuilder.append(this.mNegativeCross);
    localStringBuilder.append("\"on class ");
    localStringBuilder.append(paramView.getClass().getSimpleName());
    localStringBuilder.append(" ");
    localStringBuilder.append(Debug.getName(paramView));
    Log.e("KeyTrigger", localStringBuilder.toString());
    if ((!bool) || (this.mPositiveCross == null) || (this.mFirePositiveCross == null)) {}
    try
    {
      this.mFirePositiveCross = paramView.getClass().getMethod(this.mPositiveCross, new Class[0]);
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      label720:
      break label720;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Could not find method \"");
    localStringBuilder.append(this.mPositiveCross);
    localStringBuilder.append("\"on class ");
    localStringBuilder.append(paramView.getClass().getSimpleName());
    localStringBuilder.append(" ");
    localStringBuilder.append(Debug.getName(paramView));
    Log.e("KeyTrigger", localStringBuilder.toString());
    try
    {
      this.mFirePositiveCross.invoke(paramView, new Object[0]);
    }
    catch (Exception localException2)
    {
      label813:
      break label813;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Exception in call \"");
    localStringBuilder.append(this.mPositiveCross);
    localStringBuilder.append("\"on class ");
    localStringBuilder.append(paramView.getClass().getSimpleName());
    localStringBuilder.append(" ");
    localStringBuilder.append(Debug.getName(paramView));
    Log.e("KeyTrigger", localStringBuilder.toString());
    if ((i == 0) || (this.mCross == null) || (this.mFireCross == null)) {}
    try
    {
      this.mFireCross = paramView.getClass().getMethod(this.mCross, new Class[0]);
    }
    catch (NoSuchMethodException localNoSuchMethodException3)
    {
      label931:
      break label931;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Could not find method \"");
    localStringBuilder.append(this.mCross);
    localStringBuilder.append("\"on class ");
    localStringBuilder.append(paramView.getClass().getSimpleName());
    localStringBuilder.append(" ");
    localStringBuilder.append(Debug.getName(paramView));
    Log.e("KeyTrigger", localStringBuilder.toString());
    try
    {
      this.mFireCross.invoke(paramView, new Object[0]);
      return;
    }
    catch (Exception localException3)
    {
      label1022:
      break label1022;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Exception in call \"");
    localStringBuilder.append(this.mCross);
    localStringBuilder.append("\"on class ");
    localStringBuilder.append(paramView.getClass().getSimpleName());
    localStringBuilder.append(" ");
    localStringBuilder.append(Debug.getName(paramView));
    Log.e("KeyTrigger", localStringBuilder.toString());
  }
  
  public void getAttributeNames(HashSet<String> paramHashSet) {}
  
  int getCurveFit()
  {
    return this.mCurveFit;
  }
  
  public void load(Context paramContext, AttributeSet paramAttributeSet)
  {
    KeyTrigger.Loader.read(this, paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.KeyTrigger), paramContext);
  }
  
  public void setValue(String paramString, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.KeyTrigger
 * JD-Core Version:    0.7.0.1
 */