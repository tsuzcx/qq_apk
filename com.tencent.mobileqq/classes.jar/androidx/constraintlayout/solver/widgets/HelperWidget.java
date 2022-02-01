package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.analyzer.Grouping;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
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
  
  public void addDependents(ArrayList<WidgetGroup> paramArrayList, int paramInt, WidgetGroup paramWidgetGroup)
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.mWidgetsCount) {
        break;
      }
      paramWidgetGroup.add(this.mWidgets[i]);
      i += 1;
    }
    while (j < this.mWidgetsCount)
    {
      Grouping.findDependents(this.mWidgets[j], paramInt, paramArrayList, paramWidgetGroup);
      j += 1;
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
  
  public int findGroupInDependents(int paramInt)
  {
    int i = 0;
    while (i < this.mWidgetsCount)
    {
      ConstraintWidget localConstraintWidget = this.mWidgets[i];
      if ((paramInt == 0) && (localConstraintWidget.horizontalGroup != -1)) {
        return localConstraintWidget.horizontalGroup;
      }
      if ((paramInt == 1) && (localConstraintWidget.verticalGroup != -1)) {
        return localConstraintWidget.verticalGroup;
      }
      i += 1;
    }
    return -1;
  }
  
  public void removeAllIds()
  {
    this.mWidgetsCount = 0;
    Arrays.fill(this.mWidgets, null);
  }
  
  public void updateConstraints(ConstraintWidgetContainer paramConstraintWidgetContainer) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.HelperWidget
 * JD-Core Version:    0.7.0.1
 */