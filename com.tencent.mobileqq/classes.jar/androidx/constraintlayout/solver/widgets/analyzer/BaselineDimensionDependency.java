package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;

class BaselineDimensionDependency
  extends DimensionDependency
{
  public BaselineDimensionDependency(WidgetRun paramWidgetRun)
  {
    super(paramWidgetRun);
  }
  
  public void update(DependencyNode paramDependencyNode)
  {
    ((VerticalWidgetRun)this.run).baseline.margin = this.run.widget.getBaselineDistance();
    this.resolved = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.analyzer.BaselineDimensionDependency
 * JD-Core Version:    0.7.0.1
 */