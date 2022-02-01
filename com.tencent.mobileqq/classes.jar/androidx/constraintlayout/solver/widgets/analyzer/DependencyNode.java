package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DependencyNode
  implements Dependency
{
  public boolean delegateToWidgetRun = false;
  List<Dependency> dependencies = new ArrayList();
  int margin;
  DimensionDependency marginDependency = null;
  int marginFactor = 1;
  public boolean readyToSolve = false;
  public boolean resolved = false;
  WidgetRun run;
  List<DependencyNode> targets = new ArrayList();
  DependencyNode.Type type = DependencyNode.Type.UNKNOWN;
  public Dependency updateDelegate = null;
  public int value;
  
  public DependencyNode(WidgetRun paramWidgetRun)
  {
    this.run = paramWidgetRun;
  }
  
  public void addDependency(Dependency paramDependency)
  {
    this.dependencies.add(paramDependency);
    if (this.resolved) {
      paramDependency.update(paramDependency);
    }
  }
  
  public void clear()
  {
    this.targets.clear();
    this.dependencies.clear();
    this.resolved = false;
    this.value = 0;
    this.readyToSolve = false;
    this.delegateToWidgetRun = false;
  }
  
  public String name()
  {
    String str = this.run.widget.getDebugName();
    if ((this.type != DependencyNode.Type.LEFT) && (this.type != DependencyNode.Type.RIGHT))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_VERTICAL");
      str = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_HORIZONTAL");
      str = localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(":");
    localStringBuilder.append(this.type.name());
    return localStringBuilder.toString();
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
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.run.widget.getDebugName());
    localStringBuilder.append(":");
    localStringBuilder.append(this.type);
    localStringBuilder.append("(");
    Object localObject;
    if (this.resolved) {
      localObject = Integer.valueOf(this.value);
    } else {
      localObject = "unresolved";
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(") <t=");
    localStringBuilder.append(this.targets.size());
    localStringBuilder.append(":d=");
    localStringBuilder.append(this.dependencies.size());
    localStringBuilder.append(">");
    return localStringBuilder.toString();
  }
  
  public void update(Dependency paramDependency)
  {
    paramDependency = this.targets.iterator();
    while (paramDependency.hasNext()) {
      if (!((DependencyNode)paramDependency.next()).resolved) {
        return;
      }
    }
    this.readyToSolve = true;
    paramDependency = this.updateDelegate;
    if (paramDependency != null) {
      paramDependency.update(this);
    }
    if (this.delegateToWidgetRun)
    {
      this.run.update(this);
      return;
    }
    paramDependency = null;
    int i = 0;
    Iterator localIterator = this.targets.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (DependencyNode)localIterator.next();
      if (!(localObject instanceof DimensionDependency))
      {
        i += 1;
        paramDependency = (Dependency)localObject;
      }
    }
    if ((paramDependency != null) && (i == 1) && (paramDependency.resolved))
    {
      localObject = this.marginDependency;
      if (localObject != null) {
        if (((DimensionDependency)localObject).resolved) {
          this.margin = (this.marginFactor * this.marginDependency.value);
        } else {
          return;
        }
      }
      resolve(paramDependency.value + this.margin);
    }
    paramDependency = this.updateDelegate;
    if (paramDependency != null) {
      paramDependency.update(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.analyzer.DependencyNode
 * JD-Core Version:    0.7.0.1
 */