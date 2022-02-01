package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class Constraints
  extends ViewGroup
{
  public static final String TAG = "Constraints";
  ConstraintSet myConstraintSet;
  
  public Constraints(Context paramContext)
  {
    super(paramContext);
    super.setVisibility(8);
  }
  
  public Constraints(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
    super.setVisibility(8);
  }
  
  public Constraints(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
    super.setVisibility(8);
  }
  
  private void init(AttributeSet paramAttributeSet)
  {
    Log.v("Constraints", " ################# init");
  }
  
  protected Constraints.LayoutParams generateDefaultLayoutParams()
  {
    return new Constraints.LayoutParams(-2, -2);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ConstraintLayout.LayoutParams(paramLayoutParams);
  }
  
  public Constraints.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new Constraints.LayoutParams(getContext(), paramAttributeSet);
  }
  
  public ConstraintSet getConstraintSet()
  {
    if (this.myConstraintSet == null) {
      this.myConstraintSet = new ConstraintSet();
    }
    this.myConstraintSet.clone(this);
    return this.myConstraintSet;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.widget.Constraints
 * JD-Core Version:    0.7.0.1
 */