package androidx.constraintlayout.solver.widgets.analyzer;

import java.util.Iterator;
import java.util.List;

class DimensionDependency
  extends DependencyNode
{
  public int wrapValue;
  
  public DimensionDependency(WidgetRun paramWidgetRun)
  {
    super(paramWidgetRun);
    if ((paramWidgetRun instanceof HorizontalWidgetRun))
    {
      this.type = DependencyNode.Type.HORIZONTAL_DIMENSION;
      return;
    }
    this.type = DependencyNode.Type.VERTICAL_DIMENSION;
  }
  
  public void resolve(int paramInt)
  {
    if (this.resolved) {
      return;
    }
    this.resolved = true;
    this.value = paramInt;
    Iterator localIterator = this.dependencies.iterator();
    while (localIterator.hasNext())
    {
      Dependency localDependency = (Dependency)localIterator.next();
      localDependency.update(localDependency);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency
 * JD-Core Version:    0.7.0.1
 */