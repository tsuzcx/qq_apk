package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

public class Group
  extends ConstraintHelper
{
  public Group(Context paramContext)
  {
    super(paramContext);
  }
  
  public Group(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public Group(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void init(AttributeSet paramAttributeSet)
  {
    super.init(paramAttributeSet);
    this.mUseViewMeasure = false;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    applyLayoutFeatures();
  }
  
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    applyLayoutFeatures();
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    applyLayoutFeatures();
  }
  
  public void updatePostLayout(ConstraintLayout paramConstraintLayout)
  {
    paramConstraintLayout = (ConstraintLayout.LayoutParams)getLayoutParams();
    paramConstraintLayout.widget.setWidth(0);
    paramConstraintLayout.widget.setHeight(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.widget.Group
 * JD-Core Version:    0.7.0.1
 */