package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.Helper;
import java.util.List;

public class VerticalWidgetRun
  extends WidgetRun
{
  public DependencyNode baseline = new DependencyNode(this);
  DimensionDependency baselineDimension = null;
  
  public VerticalWidgetRun(ConstraintWidget paramConstraintWidget)
  {
    super(paramConstraintWidget);
    this.start.type = DependencyNode.Type.TOP;
    this.end.type = DependencyNode.Type.BOTTOM;
    this.baseline.type = DependencyNode.Type.BASELINE;
    this.orientation = 1;
  }
  
  void apply()
  {
    if (this.widget.measured) {
      this.dimension.resolve(this.widget.getHeight());
    }
    Object localObject;
    int i;
    if (!this.dimension.resolved)
    {
      this.dimensionBehavior = this.widget.getVerticalDimensionBehaviour();
      if (this.widget.hasBaseline()) {
        this.baselineDimension = new BaselineDimensionDependency(this);
      }
      if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
      {
        if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)
        {
          localObject = this.widget.getParent();
          if ((localObject != null) && (((ConstraintWidget)localObject).getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED))
          {
            i = ((ConstraintWidget)localObject).getHeight();
            int j = this.widget.mTop.getMargin();
            int k = this.widget.mBottom.getMargin();
            addTarget(this.start, ((ConstraintWidget)localObject).verticalRun.start, this.widget.mTop.getMargin());
            addTarget(this.end, ((ConstraintWidget)localObject).verticalRun.end, -this.widget.mBottom.getMargin());
            this.dimension.resolve(i - j - k);
            return;
          }
        }
        if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
          this.dimension.resolve(this.widget.getHeight());
        }
      }
    }
    else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)
    {
      localObject = this.widget.getParent();
      if ((localObject != null) && (((ConstraintWidget)localObject).getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED))
      {
        addTarget(this.start, ((ConstraintWidget)localObject).verticalRun.start, this.widget.mTop.getMargin());
        addTarget(this.end, ((ConstraintWidget)localObject).verticalRun.end, -this.widget.mBottom.getMargin());
        return;
      }
    }
    if ((this.dimension.resolved) && (this.widget.measured))
    {
      if ((this.widget.mListAnchors[2].mTarget != null) && (this.widget.mListAnchors[3].mTarget != null))
      {
        if (this.widget.isInVerticalChain())
        {
          this.start.margin = this.widget.mListAnchors[2].getMargin();
          this.end.margin = (-this.widget.mListAnchors[3].getMargin());
        }
        else
        {
          localObject = getTarget(this.widget.mListAnchors[2]);
          if (localObject != null) {
            addTarget(this.start, (DependencyNode)localObject, this.widget.mListAnchors[2].getMargin());
          }
          localObject = getTarget(this.widget.mListAnchors[3]);
          if (localObject != null) {
            addTarget(this.end, (DependencyNode)localObject, -this.widget.mListAnchors[3].getMargin());
          }
          this.start.delegateToWidgetRun = true;
          this.end.delegateToWidgetRun = true;
        }
        if (this.widget.hasBaseline()) {
          addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
        }
      }
      else if (this.widget.mListAnchors[2].mTarget != null)
      {
        localObject = getTarget(this.widget.mListAnchors[2]);
        if (localObject != null)
        {
          addTarget(this.start, (DependencyNode)localObject, this.widget.mListAnchors[2].getMargin());
          addTarget(this.end, this.start, this.dimension.value);
          if (this.widget.hasBaseline()) {
            addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
          }
        }
      }
      else if (this.widget.mListAnchors[3].mTarget != null)
      {
        localObject = getTarget(this.widget.mListAnchors[3]);
        if (localObject != null)
        {
          addTarget(this.end, (DependencyNode)localObject, -this.widget.mListAnchors[3].getMargin());
          addTarget(this.start, this.end, -this.dimension.value);
        }
        if (this.widget.hasBaseline()) {
          addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
        }
      }
      else if (this.widget.mListAnchors[4].mTarget != null)
      {
        localObject = getTarget(this.widget.mListAnchors[4]);
        if (localObject != null)
        {
          addTarget(this.baseline, (DependencyNode)localObject, 0);
          addTarget(this.start, this.baseline, -this.widget.getBaselineDistance());
          addTarget(this.end, this.start, this.dimension.value);
        }
      }
      else if ((!(this.widget instanceof Helper)) && (this.widget.getParent() != null) && (this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget == null))
      {
        localObject = this.widget.getParent().verticalRun.start;
        addTarget(this.start, (DependencyNode)localObject, this.widget.getY());
        addTarget(this.end, this.start, this.dimension.value);
        if (this.widget.hasBaseline()) {
          addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
        }
      }
    }
    else
    {
      if ((!this.dimension.resolved) && (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))
      {
        i = this.widget.mMatchConstraintDefaultHeight;
        if (i != 2)
        {
          if ((i == 3) && (!this.widget.isInVerticalChain()) && (this.widget.mMatchConstraintDefaultWidth != 3))
          {
            localObject = this.widget.horizontalRun.dimension;
            this.dimension.targets.add(localObject);
            ((DependencyNode)localObject).dependencies.add(this.dimension);
            this.dimension.delegateToWidgetRun = true;
            this.dimension.dependencies.add(this.start);
            this.dimension.dependencies.add(this.end);
          }
        }
        else
        {
          localObject = this.widget.getParent();
          if (localObject != null)
          {
            localObject = ((ConstraintWidget)localObject).verticalRun.dimension;
            this.dimension.targets.add(localObject);
            ((DependencyNode)localObject).dependencies.add(this.dimension);
            this.dimension.delegateToWidgetRun = true;
            this.dimension.dependencies.add(this.start);
            this.dimension.dependencies.add(this.end);
          }
        }
      }
      else
      {
        this.dimension.addDependency(this);
      }
      if ((this.widget.mListAnchors[2].mTarget != null) && (this.widget.mListAnchors[3].mTarget != null))
      {
        if (this.widget.isInVerticalChain())
        {
          this.start.margin = this.widget.mListAnchors[2].getMargin();
          this.end.margin = (-this.widget.mListAnchors[3].getMargin());
        }
        else
        {
          localObject = getTarget(this.widget.mListAnchors[2]);
          DependencyNode localDependencyNode = getTarget(this.widget.mListAnchors[3]);
          ((DependencyNode)localObject).addDependency(this);
          localDependencyNode.addDependency(this);
          this.mRunType = WidgetRun.RunType.CENTER;
        }
        if (this.widget.hasBaseline()) {
          addTarget(this.baseline, this.start, 1, this.baselineDimension);
        }
      }
      else if (this.widget.mListAnchors[2].mTarget != null)
      {
        localObject = getTarget(this.widget.mListAnchors[2]);
        if (localObject != null)
        {
          addTarget(this.start, (DependencyNode)localObject, this.widget.mListAnchors[2].getMargin());
          addTarget(this.end, this.start, 1, this.dimension);
          if (this.widget.hasBaseline()) {
            addTarget(this.baseline, this.start, 1, this.baselineDimension);
          }
          if ((this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (this.widget.getDimensionRatio() > 0.0F) && (this.widget.horizontalRun.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))
          {
            this.widget.horizontalRun.dimension.dependencies.add(this.dimension);
            this.dimension.targets.add(this.widget.horizontalRun.dimension);
            this.dimension.updateDelegate = this;
          }
        }
      }
      else if (this.widget.mListAnchors[3].mTarget != null)
      {
        localObject = getTarget(this.widget.mListAnchors[3]);
        if (localObject != null)
        {
          addTarget(this.end, (DependencyNode)localObject, -this.widget.mListAnchors[3].getMargin());
          addTarget(this.start, this.end, -1, this.dimension);
          if (this.widget.hasBaseline()) {
            addTarget(this.baseline, this.start, 1, this.baselineDimension);
          }
        }
      }
      else if (this.widget.mListAnchors[4].mTarget != null)
      {
        localObject = getTarget(this.widget.mListAnchors[4]);
        if (localObject != null)
        {
          addTarget(this.baseline, (DependencyNode)localObject, 0);
          addTarget(this.start, this.baseline, -1, this.baselineDimension);
          addTarget(this.end, this.start, 1, this.dimension);
        }
      }
      else if ((!(this.widget instanceof Helper)) && (this.widget.getParent() != null))
      {
        localObject = this.widget.getParent().verticalRun.start;
        addTarget(this.start, (DependencyNode)localObject, this.widget.getY());
        addTarget(this.end, this.start, 1, this.dimension);
        if (this.widget.hasBaseline()) {
          addTarget(this.baseline, this.start, 1, this.baselineDimension);
        }
        if ((this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (this.widget.getDimensionRatio() > 0.0F) && (this.widget.horizontalRun.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))
        {
          this.widget.horizontalRun.dimension.dependencies.add(this.dimension);
          this.dimension.targets.add(this.widget.horizontalRun.dimension);
          this.dimension.updateDelegate = this;
        }
      }
      if (this.dimension.targets.size() == 0) {
        this.dimension.readyToSolve = true;
      }
    }
  }
  
  public void applyToWidget()
  {
    if (this.start.resolved) {
      this.widget.setY(this.start.value);
    }
  }
  
  void clear()
  {
    this.runGroup = null;
    this.start.clear();
    this.end.clear();
    this.baseline.clear();
    this.dimension.clear();
    this.resolved = false;
  }
  
  void reset()
  {
    this.resolved = false;
    this.start.clear();
    this.start.resolved = false;
    this.end.clear();
    this.end.resolved = false;
    this.baseline.clear();
    this.baseline.resolved = false;
    this.dimension.resolved = false;
  }
  
  boolean supportsWrapComputation()
  {
    if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      return this.widget.mMatchConstraintDefaultHeight == 0;
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VerticalRun ");
    localStringBuilder.append(this.widget.getDebugName());
    return localStringBuilder.toString();
  }
  
  public void update(Dependency paramDependency)
  {
    int i = VerticalWidgetRun.1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          updateRunCenter(paramDependency, this.widget.mTop, this.widget.mBottom, 1);
        }
      }
      else {
        updateRunEnd(paramDependency);
      }
    }
    else {
      updateRunStart(paramDependency);
    }
    float f1;
    if ((this.dimension.readyToSolve) && (!this.dimension.resolved) && (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))
    {
      i = this.widget.mMatchConstraintDefaultHeight;
      if (i != 2)
      {
        if ((i == 3) && (this.widget.horizontalRun.dimension.resolved))
        {
          i = this.widget.getDimensionRatioSide();
          float f2;
          if (i != -1)
          {
            if (i != 0)
            {
              if (i != 1)
              {
                i = 0;
                break label257;
              }
              f2 = this.widget.horizontalRun.dimension.value;
              f1 = this.widget.getDimensionRatio();
            }
            else
            {
              f1 = this.widget.horizontalRun.dimension.value * this.widget.getDimensionRatio();
              break label249;
            }
          }
          else
          {
            f2 = this.widget.horizontalRun.dimension.value;
            f1 = this.widget.getDimensionRatio();
          }
          f1 = f2 / f1;
          label249:
          i = (int)(f1 + 0.5F);
          label257:
          this.dimension.resolve(i);
        }
      }
      else
      {
        paramDependency = this.widget.getParent();
        if ((paramDependency != null) && (paramDependency.verticalRun.dimension.resolved))
        {
          f1 = this.widget.mMatchConstraintPercentHeight;
          i = (int)(paramDependency.verticalRun.dimension.value * f1 + 0.5F);
          this.dimension.resolve(i);
        }
      }
    }
    if (this.start.readyToSolve)
    {
      if (!this.end.readyToSolve) {
        return;
      }
      if ((this.start.resolved) && (this.end.resolved) && (this.dimension.resolved)) {
        return;
      }
      DependencyNode localDependencyNode;
      int j;
      if ((!this.dimension.resolved) && (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (this.widget.mMatchConstraintDefaultWidth == 0) && (!this.widget.isInVerticalChain()))
      {
        paramDependency = (DependencyNode)this.start.targets.get(0);
        localDependencyNode = (DependencyNode)this.end.targets.get(0);
        i = paramDependency.value + this.start.margin;
        j = localDependencyNode.value + this.end.margin;
        this.start.resolve(i);
        this.end.resolve(j);
        this.dimension.resolve(j - i);
        return;
      }
      if ((!this.dimension.resolved) && (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (this.matchConstraintsType == 1) && (this.start.targets.size() > 0) && (this.end.targets.size() > 0))
      {
        paramDependency = (DependencyNode)this.start.targets.get(0);
        localDependencyNode = (DependencyNode)this.end.targets.get(0);
        i = paramDependency.value;
        j = this.start.margin;
        i = localDependencyNode.value + this.end.margin - (i + j);
        if (i < this.dimension.wrapValue) {
          this.dimension.resolve(i);
        } else {
          this.dimension.resolve(this.dimension.wrapValue);
        }
      }
      if (!this.dimension.resolved) {
        return;
      }
      if ((this.start.targets.size() > 0) && (this.end.targets.size() > 0))
      {
        paramDependency = (DependencyNode)this.start.targets.get(0);
        localDependencyNode = (DependencyNode)this.end.targets.get(0);
        i = paramDependency.value + this.start.margin;
        j = localDependencyNode.value + this.end.margin;
        f1 = this.widget.getVerticalBiasPercent();
        if (paramDependency == localDependencyNode)
        {
          i = paramDependency.value;
          j = localDependencyNode.value;
          f1 = 0.5F;
        }
        int k = this.dimension.value;
        this.start.resolve((int)(i + 0.5F + (j - i - k) * f1));
        this.end.resolve(this.start.value + this.dimension.value);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun
 * JD-Core Version:    0.7.0.1
 */