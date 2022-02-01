package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.Chain;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

public class WidgetGroup
{
  private static final boolean DEBUG = false;
  static int count;
  boolean authoritative = false;
  int id = -1;
  private int moveTo = -1;
  int orientation = 0;
  ArrayList<WidgetGroup.MeasureResult> results = null;
  ArrayList<ConstraintWidget> widgets = new ArrayList();
  
  public WidgetGroup(int paramInt)
  {
    int i = count;
    count = i + 1;
    this.id = i;
    this.orientation = paramInt;
  }
  
  private boolean contains(ConstraintWidget paramConstraintWidget)
  {
    return this.widgets.contains(paramConstraintWidget);
  }
  
  private String getOrientationString()
  {
    int i = this.orientation;
    if (i == 0) {
      return "Horizontal";
    }
    if (i == 1) {
      return "Vertical";
    }
    if (i == 2) {
      return "Both";
    }
    return "Unknown";
  }
  
  private int measureWrap(int paramInt, ConstraintWidget paramConstraintWidget)
  {
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour = paramConstraintWidget.getDimensionBehaviour(paramInt);
    if ((localDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (localDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) && (localDimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED)) {
      return -1;
    }
    if (paramInt == 0) {
      return paramConstraintWidget.getWidth();
    }
    return paramConstraintWidget.getHeight();
  }
  
  private int solverMeasure(LinearSystem paramLinearSystem, ArrayList<ConstraintWidget> paramArrayList, int paramInt)
  {
    int j = 0;
    ConstraintWidgetContainer localConstraintWidgetContainer = (ConstraintWidgetContainer)((ConstraintWidget)paramArrayList.get(0)).getParent();
    paramLinearSystem.reset();
    localConstraintWidgetContainer.addToSolver(paramLinearSystem, false);
    int i = 0;
    while (i < paramArrayList.size())
    {
      ((ConstraintWidget)paramArrayList.get(i)).addToSolver(paramLinearSystem, false);
      i += 1;
    }
    if ((paramInt == 0) && (localConstraintWidgetContainer.mHorizontalChainsSize > 0)) {
      Chain.applyChainConstraints(localConstraintWidgetContainer, paramLinearSystem, paramArrayList, 0);
    }
    if ((paramInt == 1) && (localConstraintWidgetContainer.mVerticalChainsSize > 0)) {
      Chain.applyChainConstraints(localConstraintWidgetContainer, paramLinearSystem, paramArrayList, 1);
    }
    try
    {
      paramLinearSystem.minimize();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.results = new ArrayList();
    i = j;
    while (i < paramArrayList.size())
    {
      WidgetGroup.MeasureResult localMeasureResult = new WidgetGroup.MeasureResult(this, (ConstraintWidget)paramArrayList.get(i), paramLinearSystem, paramInt);
      this.results.add(localMeasureResult);
      i += 1;
    }
    if (paramInt == 0)
    {
      paramInt = paramLinearSystem.getObjectVariableValue(localConstraintWidgetContainer.mLeft);
      i = paramLinearSystem.getObjectVariableValue(localConstraintWidgetContainer.mRight);
      paramLinearSystem.reset();
    }
    for (;;)
    {
      return i - paramInt;
      paramInt = paramLinearSystem.getObjectVariableValue(localConstraintWidgetContainer.mTop);
      i = paramLinearSystem.getObjectVariableValue(localConstraintWidgetContainer.mBottom);
      paramLinearSystem.reset();
    }
  }
  
  public boolean add(ConstraintWidget paramConstraintWidget)
  {
    if (this.widgets.contains(paramConstraintWidget)) {
      return false;
    }
    this.widgets.add(paramConstraintWidget);
    return true;
  }
  
  public void apply()
  {
    if (this.results == null) {
      return;
    }
    if (!this.authoritative) {
      return;
    }
    int i = 0;
    while (i < this.results.size())
    {
      ((WidgetGroup.MeasureResult)this.results.get(i)).apply();
      i += 1;
    }
  }
  
  public void cleanup(ArrayList<WidgetGroup> paramArrayList)
  {
    int j = this.widgets.size();
    if ((this.moveTo != -1) && (j > 0))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        WidgetGroup localWidgetGroup = (WidgetGroup)paramArrayList.get(i);
        if (this.moveTo == localWidgetGroup.id) {
          moveTo(this.orientation, localWidgetGroup);
        }
        i += 1;
      }
    }
    if (j == 0) {
      paramArrayList.remove(this);
    }
  }
  
  public void clear()
  {
    this.widgets.clear();
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public int getOrientation()
  {
    return this.orientation;
  }
  
  public boolean intersectWith(WidgetGroup paramWidgetGroup)
  {
    int i = 0;
    while (i < this.widgets.size())
    {
      if (paramWidgetGroup.contains((ConstraintWidget)this.widgets.get(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isAuthoritative()
  {
    return this.authoritative;
  }
  
  public int measureWrap(LinearSystem paramLinearSystem, int paramInt)
  {
    if (this.widgets.size() == 0) {
      return 0;
    }
    return solverMeasure(paramLinearSystem, this.widgets, paramInt);
  }
  
  public void moveTo(int paramInt, WidgetGroup paramWidgetGroup)
  {
    Iterator localIterator = this.widgets.iterator();
    while (localIterator.hasNext())
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)localIterator.next();
      paramWidgetGroup.add(localConstraintWidget);
      if (paramInt == 0) {
        localConstraintWidget.horizontalGroup = paramWidgetGroup.getId();
      } else {
        localConstraintWidget.verticalGroup = paramWidgetGroup.getId();
      }
    }
    this.moveTo = paramWidgetGroup.id;
  }
  
  public void setAuthoritative(boolean paramBoolean)
  {
    this.authoritative = paramBoolean;
  }
  
  public void setOrientation(int paramInt)
  {
    this.orientation = paramInt;
  }
  
  public int size()
  {
    return this.widgets.size();
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getOrientationString());
    ((StringBuilder)localObject1).append(" [");
    ((StringBuilder)localObject1).append(this.id);
    ((StringBuilder)localObject1).append("] <");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = this.widgets.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)((Iterator)localObject2).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" ");
      localStringBuilder.append(localConstraintWidget.getDebugName());
      localObject1 = localStringBuilder.toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" >");
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup
 * JD-Core Version:    0.7.0.1
 */