package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.lang.ref.WeakReference;

class WidgetGroup$MeasureResult
{
  int baseline;
  int bottom;
  int left;
  int orientation;
  int right;
  int top;
  WeakReference<ConstraintWidget> widgetRef;
  
  public WidgetGroup$MeasureResult(WidgetGroup paramWidgetGroup, ConstraintWidget paramConstraintWidget, LinearSystem paramLinearSystem, int paramInt)
  {
    this.widgetRef = new WeakReference(paramConstraintWidget);
    this.left = paramLinearSystem.getObjectVariableValue(paramConstraintWidget.mLeft);
    this.top = paramLinearSystem.getObjectVariableValue(paramConstraintWidget.mTop);
    this.right = paramLinearSystem.getObjectVariableValue(paramConstraintWidget.mRight);
    this.bottom = paramLinearSystem.getObjectVariableValue(paramConstraintWidget.mBottom);
    this.baseline = paramLinearSystem.getObjectVariableValue(paramConstraintWidget.mBaseline);
    this.orientation = paramInt;
  }
  
  public void apply()
  {
    ConstraintWidget localConstraintWidget = (ConstraintWidget)this.widgetRef.get();
    if (localConstraintWidget != null) {
      localConstraintWidget.setFinalFrame(this.left, this.top, this.right, this.bottom, this.baseline, this.orientation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup.MeasureResult
 * JD-Core Version:    0.7.0.1
 */