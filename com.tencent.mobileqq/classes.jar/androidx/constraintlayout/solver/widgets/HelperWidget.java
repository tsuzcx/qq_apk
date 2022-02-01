package androidx.constraintlayout.solver.widgets;

import java.util.Arrays;
import java.util.HashMap;

public class HelperWidget
  extends ConstraintWidget
  implements Helper
{
  public ConstraintWidget[] mWidgets = new ConstraintWidget[4];
  public int mWidgetsCount = 0;
  
  public void add(ConstraintWidget paramConstraintWidget)
  {
    if (paramConstraintWidget != this)
    {
      if (paramConstraintWidget == null) {
        return;
      }
      int i = this.mWidgetsCount;
      ConstraintWidget[] arrayOfConstraintWidget = this.mWidgets;
      if (i + 1 > arrayOfConstraintWidget.length) {
        this.mWidgets = ((ConstraintWidget[])Arrays.copyOf(arrayOfConstraintWidget, arrayOfConstraintWidget.length * 2));
      }
      arrayOfConstraintWidget = this.mWidgets;
      i = this.mWidgetsCount;
      arrayOfConstraintWidget[i] = paramConstraintWidget;
      this.mWidgetsCount = (i + 1);
    }
  }
  
  public void copy(ConstraintWidget paramConstraintWidget, HashMap<ConstraintWidget, ConstraintWidget> paramHashMap)
  {
    super.copy(paramConstraintWidget, paramHashMap);
    paramConstraintWidget = (HelperWidget)paramConstraintWidget;
    int i = 0;
    this.mWidgetsCount = 0;
    int j = paramConstraintWidget.mWidgetsCount;
    while (i < j)
    {
      add((ConstraintWidget)paramHashMap.get(paramConstraintWidget.mWidgets[i]));
      i += 1;
    }
  }
  
  public void removeAllIds()
  {
    this.mWidgetsCount = 0;
    Arrays.fill(this.mWidgets, null);
  }
  
  public void updateConstraints(ConstraintWidgetContainer paramConstraintWidgetContainer) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.HelperWidget
 * JD-Core Version:    0.7.0.1
 */