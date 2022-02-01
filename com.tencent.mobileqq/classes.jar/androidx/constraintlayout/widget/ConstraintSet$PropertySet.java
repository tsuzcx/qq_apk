package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class ConstraintSet$PropertySet
{
  public float alpha = 1.0F;
  public boolean mApply = false;
  public float mProgress = (0.0F / 0.0F);
  public int mVisibilityMode = 0;
  public int visibility = 0;
  
  public void copyFrom(PropertySet paramPropertySet)
  {
    this.mApply = paramPropertySet.mApply;
    this.visibility = paramPropertySet.visibility;
    this.alpha = paramPropertySet.alpha;
    this.mProgress = paramPropertySet.mProgress;
    this.mVisibilityMode = paramPropertySet.mVisibilityMode;
  }
  
  void fillFromAttributeList(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PropertySet);
    this.mApply = true;
    int j = paramContext.getIndexCount();
    int i = 0;
    while (i < j)
    {
      int k = paramContext.getIndex(i);
      if (k == R.styleable.PropertySet_android_alpha)
      {
        this.alpha = paramContext.getFloat(k, this.alpha);
      }
      else if (k == R.styleable.PropertySet_android_visibility)
      {
        this.visibility = paramContext.getInt(k, this.visibility);
        this.visibility = ConstraintSet.access$200()[this.visibility];
      }
      else if (k == R.styleable.PropertySet_visibilityMode)
      {
        this.mVisibilityMode = paramContext.getInt(k, this.mVisibilityMode);
      }
      else if (k == R.styleable.PropertySet_motionProgress)
      {
        this.mProgress = paramContext.getFloat(k, this.mProgress);
      }
      i += 1;
    }
    paramContext.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintSet.PropertySet
 * JD-Core Version:    0.7.0.1
 */