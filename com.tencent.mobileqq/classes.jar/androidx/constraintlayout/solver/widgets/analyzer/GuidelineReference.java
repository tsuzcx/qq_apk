package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;
import java.util.List;

class GuidelineReference
  extends WidgetRun
{
  public GuidelineReference(ConstraintWidget paramConstraintWidget)
  {
    super(paramConstraintWidget);
    paramConstraintWidget.horizontalRun.clear();
    paramConstraintWidget.verticalRun.clear();
    this.orientation = ((Guideline)paramConstraintWidget).getOrientation();
  }
  
  private void addDependency(DependencyNode paramDependencyNode)
  {
    this.start.dependencies.add(paramDependencyNode);
    paramDependencyNode.targets.add(this.start);
  }
  
  void apply()
  {
    Guideline localGuideline = (Guideline)this.widget;
    int i = localGuideline.getRelativeBegin();
    int j = localGuideline.getRelativeEnd();
    localGuideline.getRelativePercent();
    if (localGuideline.getOrientation() == 1)
    {
      if (i != -1)
      {
        this.start.targets.add(this.widget.mParent.horizontalRun.start);
        this.widget.mParent.horizontalRun.start.dependencies.add(this.start);
        this.start.margin = i;
      }
      else if (j != -1)
      {
        this.start.targets.add(this.widget.mParent.horizontalRun.end);
        this.widget.mParent.horizontalRun.end.dependencies.add(this.start);
        this.start.margin = (-j);
      }
      else
      {
        this.start.delegateToWidgetRun = true;
        this.start.targets.add(this.widget.mParent.horizontalRun.end);
        this.widget.mParent.horizontalRun.end.dependencies.add(this.start);
      }
      addDependency(this.widget.horizontalRun.start);
      addDependency(this.widget.horizontalRun.end);
      return;
    }
    if (i != -1)
    {
      this.start.targets.add(this.widget.mParent.verticalRun.start);
      this.widget.mParent.verticalRun.start.dependencies.add(this.start);
      this.start.margin = i;
    }
    else if (j != -1)
    {
      this.start.targets.add(this.widget.mParent.verticalRun.end);
      this.widget.mParent.verticalRun.end.dependencies.add(this.start);
      this.start.margin = (-j);
    }
    else
    {
      this.start.delegateToWidgetRun = true;
      this.start.targets.add(this.widget.mParent.verticalRun.end);
      this.widget.mParent.verticalRun.end.dependencies.add(this.start);
    }
    addDependency(this.widget.verticalRun.start);
    addDependency(this.widget.verticalRun.end);
  }
  
  public void applyToWidget()
  {
    if (((Guideline)this.widget).getOrientation() == 1)
    {
      this.widget.setX(this.start.value);
      return;
    }
    this.widget.setY(this.start.value);
  }
  
  void clear()
  {
    this.start.clear();
  }
  
  void reset()
  {
    this.start.resolved = false;
    this.end.resolved = false;
  }
  
  boolean supportsWrapComputation()
  {
    return false;
  }
  
  public void update(Dependency paramDependency)
  {
    if (!this.start.readyToSolve) {
      return;
    }
    if (this.start.resolved) {
      return;
    }
    paramDependency = (DependencyNode)this.start.targets.get(0);
    Guideline localGuideline = (Guideline)this.widget;
    int i = (int)(paramDependency.value * localGuideline.getRelativePercent() + 0.5F);
    this.start.resolve(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.analyzer.GuidelineReference
 * JD-Core Version:    0.7.0.1
 */