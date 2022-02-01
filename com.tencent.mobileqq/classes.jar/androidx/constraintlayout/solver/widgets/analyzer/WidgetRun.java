package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import java.util.List;

public abstract class WidgetRun
  implements Dependency
{
  DimensionDependency dimension = new DimensionDependency(this);
  protected ConstraintWidget.DimensionBehaviour dimensionBehavior;
  public DependencyNode end = new DependencyNode(this);
  protected WidgetRun.RunType mRunType = WidgetRun.RunType.NONE;
  public int matchConstraintsType;
  public int orientation = 0;
  boolean resolved = false;
  RunGroup runGroup;
  public DependencyNode start = new DependencyNode(this);
  ConstraintWidget widget;
  
  public WidgetRun(ConstraintWidget paramConstraintWidget)
  {
    this.widget = paramConstraintWidget;
  }
  
  private void resolveDimension(int paramInt1, int paramInt2)
  {
    int i = this.matchConstraintsType;
    if (i != 0)
    {
      if (i != 1)
      {
        Object localObject;
        float f;
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          if ((this.widget.horizontalRun.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (this.widget.horizontalRun.matchConstraintsType == 3) && (this.widget.verticalRun.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (this.widget.verticalRun.matchConstraintsType == 3)) {
            return;
          }
          if (paramInt1 == 0) {
            localObject = this.widget.verticalRun;
          } else {
            localObject = this.widget.horizontalRun;
          }
          if (((WidgetRun)localObject).dimension.resolved)
          {
            f = this.widget.getDimensionRatio();
            if (paramInt1 == 1) {
              paramInt1 = (int)(((WidgetRun)localObject).dimension.value / f + 0.5F);
            } else {
              paramInt1 = (int)(f * ((WidgetRun)localObject).dimension.value + 0.5F);
            }
            this.dimension.resolve(paramInt1);
          }
        }
        else
        {
          localObject = this.widget.getParent();
          if (localObject != null)
          {
            if (paramInt1 == 0) {
              localObject = ((ConstraintWidget)localObject).horizontalRun;
            } else {
              localObject = ((ConstraintWidget)localObject).verticalRun;
            }
            if (((WidgetRun)localObject).dimension.resolved)
            {
              if (paramInt1 == 0) {
                f = this.widget.mMatchConstraintPercentWidth;
              } else {
                f = this.widget.mMatchConstraintPercentHeight;
              }
              paramInt2 = (int)(((WidgetRun)localObject).dimension.value * f + 0.5F);
              this.dimension.resolve(getLimitedDimension(paramInt2, paramInt1));
            }
          }
        }
      }
      else
      {
        paramInt1 = getLimitedDimension(this.dimension.wrapValue, paramInt1);
        this.dimension.resolve(Math.min(paramInt1, paramInt2));
      }
    }
    else {
      this.dimension.resolve(getLimitedDimension(paramInt2, paramInt1));
    }
  }
  
  protected final void addTarget(DependencyNode paramDependencyNode1, DependencyNode paramDependencyNode2, int paramInt)
  {
    paramDependencyNode1.targets.add(paramDependencyNode2);
    paramDependencyNode1.margin = paramInt;
    paramDependencyNode2.dependencies.add(paramDependencyNode1);
  }
  
  protected final void addTarget(DependencyNode paramDependencyNode1, DependencyNode paramDependencyNode2, int paramInt, DimensionDependency paramDimensionDependency)
  {
    paramDependencyNode1.targets.add(paramDependencyNode2);
    paramDependencyNode1.targets.add(this.dimension);
    paramDependencyNode1.marginFactor = paramInt;
    paramDependencyNode1.marginDependency = paramDimensionDependency;
    paramDependencyNode2.dependencies.add(paramDependencyNode1);
    paramDimensionDependency.dependencies.add(paramDependencyNode1);
  }
  
  abstract void apply();
  
  abstract void applyToWidget();
  
  abstract void clear();
  
  protected final int getLimitedDimension(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt2 == 0)
    {
      i = this.widget.mMatchConstraintMaxWidth;
      paramInt2 = Math.max(this.widget.mMatchConstraintMinWidth, paramInt1);
      if (i > 0) {
        paramInt2 = Math.min(i, paramInt1);
      }
      i = paramInt1;
      if (paramInt2 != paramInt1) {
        return paramInt2;
      }
    }
    else
    {
      i = this.widget.mMatchConstraintMaxHeight;
      paramInt2 = Math.max(this.widget.mMatchConstraintMinHeight, paramInt1);
      if (i > 0) {
        paramInt2 = Math.min(i, paramInt1);
      }
      i = paramInt1;
      if (paramInt2 != paramInt1) {
        i = paramInt2;
      }
    }
    return i;
  }
  
  protected final DependencyNode getTarget(ConstraintAnchor paramConstraintAnchor)
  {
    if (paramConstraintAnchor.mTarget == null) {
      return null;
    }
    ConstraintWidget localConstraintWidget = paramConstraintAnchor.mTarget.mOwner;
    paramConstraintAnchor = paramConstraintAnchor.mTarget.mType;
    int i = WidgetRun.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[paramConstraintAnchor.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return null;
            }
            return localConstraintWidget.verticalRun.end;
          }
          return localConstraintWidget.verticalRun.baseline;
        }
        return localConstraintWidget.verticalRun.start;
      }
      return localConstraintWidget.horizontalRun.end;
    }
    return localConstraintWidget.horizontalRun.start;
  }
  
  protected final DependencyNode getTarget(ConstraintAnchor paramConstraintAnchor, int paramInt)
  {
    if (paramConstraintAnchor.mTarget == null) {
      return null;
    }
    Object localObject = paramConstraintAnchor.mTarget.mOwner;
    if (paramInt == 0) {
      localObject = ((ConstraintWidget)localObject).horizontalRun;
    } else {
      localObject = ((ConstraintWidget)localObject).verticalRun;
    }
    paramConstraintAnchor = paramConstraintAnchor.mTarget.mType;
    paramInt = WidgetRun.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[paramConstraintAnchor.ordinal()];
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3) {
          break label78;
        }
        if (paramInt != 5) {
          return null;
        }
      }
      return ((WidgetRun)localObject).end;
    }
    label78:
    return ((WidgetRun)localObject).start;
  }
  
  public long getWrapDimension()
  {
    if (this.dimension.resolved) {
      return this.dimension.value;
    }
    return 0L;
  }
  
  public boolean isCenterConnection()
  {
    int m = this.start.targets.size();
    boolean bool = false;
    int j = 0;
    for (int i = 0; j < m; i = k)
    {
      k = i;
      if (((DependencyNode)this.start.targets.get(j)).run != this) {
        k = i + 1;
      }
      j += 1;
    }
    m = this.end.targets.size();
    int k = 0;
    j = i;
    i = k;
    while (i < m)
    {
      k = j;
      if (((DependencyNode)this.end.targets.get(i)).run != this) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    if (j >= 2) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isDimensionResolved()
  {
    return this.dimension.resolved;
  }
  
  public boolean isResolved()
  {
    return this.resolved;
  }
  
  abstract void reset();
  
  abstract boolean supportsWrapComputation();
  
  public void update(Dependency paramDependency) {}
  
  protected void updateRunCenter(Dependency paramDependency, ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt)
  {
    paramDependency = getTarget(paramConstraintAnchor1);
    DependencyNode localDependencyNode = getTarget(paramConstraintAnchor2);
    if (paramDependency.resolved)
    {
      if (!localDependencyNode.resolved) {
        return;
      }
      int j = paramDependency.value + paramConstraintAnchor1.getMargin();
      int i = localDependencyNode.value - paramConstraintAnchor2.getMargin();
      int k = i - j;
      if ((!this.dimension.resolved) && (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) {
        resolveDimension(paramInt, k);
      }
      if (!this.dimension.resolved) {
        return;
      }
      if (this.dimension.value == k)
      {
        this.start.resolve(j);
        this.end.resolve(i);
        return;
      }
      float f;
      if (paramInt == 0) {
        f = this.widget.getHorizontalBiasPercent();
      } else {
        f = this.widget.getVerticalBiasPercent();
      }
      paramInt = j;
      if (paramDependency == localDependencyNode)
      {
        paramInt = paramDependency.value;
        i = localDependencyNode.value;
        f = 0.5F;
      }
      j = this.dimension.value;
      this.start.resolve((int)(paramInt + 0.5F + (i - paramInt - j) * f));
      this.end.resolve(this.start.value + this.dimension.value);
    }
  }
  
  protected void updateRunEnd(Dependency paramDependency) {}
  
  protected void updateRunStart(Dependency paramDependency) {}
  
  public long wrapSize(int paramInt)
  {
    if (this.dimension.resolved)
    {
      long l = this.dimension.value;
      if (isCenterConnection()) {}
      for (paramInt = this.start.margin - this.end.margin;; paramInt = this.start.margin)
      {
        return l + paramInt;
        if (paramInt != 0) {
          break;
        }
      }
      return l - this.end.margin;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
 * JD-Core Version:    0.7.0.1
 */