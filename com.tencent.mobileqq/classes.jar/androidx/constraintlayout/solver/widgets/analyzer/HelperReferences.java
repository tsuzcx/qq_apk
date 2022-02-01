package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.Iterator;
import java.util.List;

class HelperReferences
  extends WidgetRun
{
  public HelperReferences(ConstraintWidget paramConstraintWidget)
  {
    super(paramConstraintWidget);
  }
  
  private void addDependency(DependencyNode paramDependencyNode)
  {
    this.start.dependencies.add(paramDependencyNode);
    paramDependencyNode.targets.add(this.start);
  }
  
  void apply()
  {
    if ((this.widget instanceof Barrier))
    {
      this.start.delegateToWidgetRun = true;
      Barrier localBarrier = (Barrier)this.widget;
      int n = localBarrier.getBarrierType();
      boolean bool = localBarrier.allowsGoneWidget();
      int j = 0;
      int k = 0;
      int m = 0;
      int i = 0;
      Object localObject;
      if (n != 0)
      {
        if (n != 1)
        {
          if (n != 2)
          {
            if (n != 3) {
              return;
            }
            this.start.type = DependencyNode.Type.BOTTOM;
            while (i < localBarrier.mWidgetsCount)
            {
              localObject = localBarrier.mWidgets[i];
              if ((bool) || (((ConstraintWidget)localObject).getVisibility() != 8))
              {
                localObject = ((ConstraintWidget)localObject).verticalRun.end;
                ((DependencyNode)localObject).dependencies.add(this.start);
                this.start.targets.add(localObject);
              }
              i += 1;
            }
            addDependency(this.widget.verticalRun.start);
            addDependency(this.widget.verticalRun.end);
            return;
          }
          this.start.type = DependencyNode.Type.TOP;
          i = j;
          while (i < localBarrier.mWidgetsCount)
          {
            localObject = localBarrier.mWidgets[i];
            if ((bool) || (((ConstraintWidget)localObject).getVisibility() != 8))
            {
              localObject = ((ConstraintWidget)localObject).verticalRun.start;
              ((DependencyNode)localObject).dependencies.add(this.start);
              this.start.targets.add(localObject);
            }
            i += 1;
          }
          addDependency(this.widget.verticalRun.start);
          addDependency(this.widget.verticalRun.end);
          return;
        }
        this.start.type = DependencyNode.Type.RIGHT;
        i = k;
        while (i < localBarrier.mWidgetsCount)
        {
          localObject = localBarrier.mWidgets[i];
          if ((bool) || (((ConstraintWidget)localObject).getVisibility() != 8))
          {
            localObject = ((ConstraintWidget)localObject).horizontalRun.end;
            ((DependencyNode)localObject).dependencies.add(this.start);
            this.start.targets.add(localObject);
          }
          i += 1;
        }
        addDependency(this.widget.horizontalRun.start);
        addDependency(this.widget.horizontalRun.end);
        return;
      }
      this.start.type = DependencyNode.Type.LEFT;
      i = m;
      while (i < localBarrier.mWidgetsCount)
      {
        localObject = localBarrier.mWidgets[i];
        if ((bool) || (((ConstraintWidget)localObject).getVisibility() != 8))
        {
          localObject = ((ConstraintWidget)localObject).horizontalRun.start;
          ((DependencyNode)localObject).dependencies.add(this.start);
          this.start.targets.add(localObject);
        }
        i += 1;
      }
      addDependency(this.widget.horizontalRun.start);
      addDependency(this.widget.horizontalRun.end);
    }
  }
  
  public void applyToWidget()
  {
    if ((this.widget instanceof Barrier))
    {
      int i = ((Barrier)this.widget).getBarrierType();
      if ((i != 0) && (i != 1))
      {
        this.widget.setY(this.start.value);
        return;
      }
      this.widget.setX(this.start.value);
    }
  }
  
  void clear()
  {
    this.runGroup = null;
    this.start.clear();
  }
  
  void reset()
  {
    this.start.resolved = false;
  }
  
  boolean supportsWrapComputation()
  {
    return false;
  }
  
  public void update(Dependency paramDependency)
  {
    paramDependency = (Barrier)this.widget;
    int n = paramDependency.getBarrierType();
    Iterator localIterator = this.start.targets.iterator();
    int j = -1;
    int i = 0;
    while (localIterator.hasNext())
    {
      int k = ((DependencyNode)localIterator.next()).value;
      int m;
      if (j != -1)
      {
        m = j;
        if (k >= j) {}
      }
      else
      {
        m = k;
      }
      j = m;
      if (i < k)
      {
        i = k;
        j = m;
      }
    }
    if ((n != 0) && (n != 2))
    {
      this.start.resolve(i + paramDependency.getMargin());
      return;
    }
    this.start.resolve(j + paramDependency.getMargin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.analyzer.HelperReferences
 * JD-Core Version:    0.7.0.1
 */