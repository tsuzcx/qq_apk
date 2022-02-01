package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class RunGroup
{
  public static final int BASELINE = 2;
  public static final int END = 1;
  public static final int START = 0;
  public static int index;
  int direction;
  public boolean dual = false;
  WidgetRun firstRun = null;
  int groupIndex = 0;
  WidgetRun lastRun = null;
  public int position = 0;
  ArrayList<WidgetRun> runs = new ArrayList();
  
  public RunGroup(WidgetRun paramWidgetRun, int paramInt)
  {
    int i = index;
    this.groupIndex = i;
    index = i + 1;
    this.firstRun = paramWidgetRun;
    this.lastRun = paramWidgetRun;
    this.direction = paramInt;
  }
  
  private boolean defineTerminalWidget(WidgetRun paramWidgetRun, int paramInt)
  {
    if (paramWidgetRun.widget.isTerminalWidget[paramInt] == 0) {
      return false;
    }
    Iterator localIterator1 = paramWidgetRun.start.dependencies.iterator();
    Object localObject;
    Iterator localIterator2;
    while (localIterator1.hasNext())
    {
      localObject = (Dependency)localIterator1.next();
      if ((localObject instanceof DependencyNode))
      {
        localObject = (DependencyNode)localObject;
        if ((((DependencyNode)localObject).run != paramWidgetRun) && (localObject == ((DependencyNode)localObject).run.start))
        {
          if ((paramWidgetRun instanceof ChainRun))
          {
            localIterator2 = ((ChainRun)paramWidgetRun).widgets.iterator();
            while (localIterator2.hasNext()) {
              defineTerminalWidget((WidgetRun)localIterator2.next(), paramInt);
            }
          }
          if (!(paramWidgetRun instanceof HelperReferences)) {
            paramWidgetRun.widget.isTerminalWidget[paramInt] = false;
          }
          defineTerminalWidget(((DependencyNode)localObject).run, paramInt);
        }
      }
    }
    localIterator1 = paramWidgetRun.end.dependencies.iterator();
    while (localIterator1.hasNext())
    {
      localObject = (Dependency)localIterator1.next();
      if ((localObject instanceof DependencyNode))
      {
        localObject = (DependencyNode)localObject;
        if ((((DependencyNode)localObject).run != paramWidgetRun) && (localObject == ((DependencyNode)localObject).run.start))
        {
          if ((paramWidgetRun instanceof ChainRun))
          {
            localIterator2 = ((ChainRun)paramWidgetRun).widgets.iterator();
            while (localIterator2.hasNext()) {
              defineTerminalWidget((WidgetRun)localIterator2.next(), paramInt);
            }
          }
          if (!(paramWidgetRun instanceof HelperReferences)) {
            paramWidgetRun.widget.isTerminalWidget[paramInt] = false;
          }
          defineTerminalWidget(((DependencyNode)localObject).run, paramInt);
        }
      }
    }
    return false;
  }
  
  private long traverseEnd(DependencyNode paramDependencyNode, long paramLong)
  {
    WidgetRun localWidgetRun = paramDependencyNode.run;
    if ((localWidgetRun instanceof HelperReferences)) {
      return paramLong;
    }
    int j = paramDependencyNode.dependencies.size();
    int i = 0;
    for (long l1 = paramLong; i < j; l1 = l2)
    {
      Object localObject = (Dependency)paramDependencyNode.dependencies.get(i);
      l2 = l1;
      if ((localObject instanceof DependencyNode))
      {
        localObject = (DependencyNode)localObject;
        if (((DependencyNode)localObject).run == localWidgetRun) {
          l2 = l1;
        } else {
          l2 = Math.min(l1, traverseEnd((DependencyNode)localObject, ((DependencyNode)localObject).margin + paramLong));
        }
      }
      i += 1;
    }
    long l2 = l1;
    if (paramDependencyNode == localWidgetRun.end)
    {
      l2 = localWidgetRun.getWrapDimension();
      paramDependencyNode = localWidgetRun.start;
      paramLong -= l2;
      l2 = Math.min(Math.min(l1, traverseEnd(paramDependencyNode, paramLong)), paramLong - localWidgetRun.start.margin);
    }
    return l2;
  }
  
  private long traverseStart(DependencyNode paramDependencyNode, long paramLong)
  {
    WidgetRun localWidgetRun = paramDependencyNode.run;
    if ((localWidgetRun instanceof HelperReferences)) {
      return paramLong;
    }
    int j = paramDependencyNode.dependencies.size();
    int i = 0;
    for (long l1 = paramLong; i < j; l1 = l2)
    {
      Object localObject = (Dependency)paramDependencyNode.dependencies.get(i);
      l2 = l1;
      if ((localObject instanceof DependencyNode))
      {
        localObject = (DependencyNode)localObject;
        if (((DependencyNode)localObject).run == localWidgetRun) {
          l2 = l1;
        } else {
          l2 = Math.max(l1, traverseStart((DependencyNode)localObject, ((DependencyNode)localObject).margin + paramLong));
        }
      }
      i += 1;
    }
    long l2 = l1;
    if (paramDependencyNode == localWidgetRun.start)
    {
      l2 = localWidgetRun.getWrapDimension();
      paramDependencyNode = localWidgetRun.end;
      paramLong += l2;
      l2 = Math.max(Math.max(l1, traverseStart(paramDependencyNode, paramLong)), paramLong - localWidgetRun.end.margin);
    }
    return l2;
  }
  
  public void add(WidgetRun paramWidgetRun)
  {
    this.runs.add(paramWidgetRun);
    this.lastRun = paramWidgetRun;
  }
  
  public long computeWrapSize(ConstraintWidgetContainer paramConstraintWidgetContainer, int paramInt)
  {
    Object localObject = this.firstRun;
    boolean bool1 = localObject instanceof ChainRun;
    long l3 = 0L;
    if (bool1)
    {
      if (((ChainRun)localObject).orientation != paramInt) {
        return 0L;
      }
    }
    else if (paramInt == 0)
    {
      if (!(localObject instanceof HorizontalWidgetRun)) {
        return 0L;
      }
    }
    else if (!(localObject instanceof VerticalWidgetRun)) {
      return 0L;
    }
    if (paramInt == 0) {
      localObject = paramConstraintWidgetContainer.horizontalRun.start;
    } else {
      localObject = paramConstraintWidgetContainer.verticalRun.start;
    }
    if (paramInt == 0) {
      paramConstraintWidgetContainer = paramConstraintWidgetContainer.horizontalRun.end;
    } else {
      paramConstraintWidgetContainer = paramConstraintWidgetContainer.verticalRun.end;
    }
    bool1 = this.firstRun.start.targets.contains(localObject);
    boolean bool2 = this.firstRun.end.targets.contains(paramConstraintWidgetContainer);
    long l5 = this.firstRun.getWrapDimension();
    long l1;
    long l2;
    if ((bool1) && (bool2))
    {
      l1 = traverseStart(this.firstRun.start, 0L);
      long l4 = traverseEnd(this.firstRun.end, 0L);
      l2 = l1 - l5;
      l1 = l2;
      if (l2 >= -this.firstRun.end.margin) {
        l1 = l2 + this.firstRun.end.margin;
      }
      l4 = -l4 - l5 - this.firstRun.start.margin;
      l2 = l4;
      if (l4 >= this.firstRun.start.margin) {
        l2 = l4 - this.firstRun.start.margin;
      }
      float f1 = this.firstRun.widget.getBiasPercent(paramInt);
      if (f1 > 0.0F) {
        l3 = ((float)l2 / f1 + (float)l1 / (1.0F - f1));
      }
      float f2 = (float)l3;
      l1 = (f2 * f1 + 0.5F);
      l2 = (f2 * (1.0F - f1) + 0.5F);
      l1 = this.firstRun.start.margin + (l1 + l5 + l2);
      paramInt = this.firstRun.end.margin;
    }
    else
    {
      if (bool1) {
        return Math.max(traverseStart(this.firstRun.start, this.firstRun.start.margin), this.firstRun.start.margin + l5);
      }
      if (bool2)
      {
        l1 = traverseEnd(this.firstRun.end, this.firstRun.end.margin);
        l2 = -this.firstRun.end.margin;
        return Math.max(-l1, l2 + l5);
      }
      l1 = this.firstRun.start.margin + this.firstRun.getWrapDimension();
      paramInt = this.firstRun.end.margin;
    }
    return l1 - paramInt;
  }
  
  public void defineTerminalWidgets(boolean paramBoolean1, boolean paramBoolean2)
  {
    WidgetRun localWidgetRun;
    if (paramBoolean1)
    {
      localWidgetRun = this.firstRun;
      if ((localWidgetRun instanceof HorizontalWidgetRun)) {
        defineTerminalWidget(localWidgetRun, 0);
      }
    }
    if (paramBoolean2)
    {
      localWidgetRun = this.firstRun;
      if ((localWidgetRun instanceof VerticalWidgetRun)) {
        defineTerminalWidget(localWidgetRun, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.analyzer.RunGroup
 * JD-Core Version:    0.7.0.1
 */