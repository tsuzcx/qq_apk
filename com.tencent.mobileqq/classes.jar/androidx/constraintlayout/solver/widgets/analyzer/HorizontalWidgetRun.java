package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.Helper;
import java.util.List;

public class HorizontalWidgetRun
  extends WidgetRun
{
  private static int[] tempDimensions = new int[2];
  
  public HorizontalWidgetRun(ConstraintWidget paramConstraintWidget)
  {
    super(paramConstraintWidget);
    this.start.type = DependencyNode.Type.LEFT;
    this.end.type = DependencyNode.Type.RIGHT;
    this.orientation = 0;
  }
  
  private void computeInsetRatio(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5)
  {
    paramInt1 = paramInt2 - paramInt1;
    paramInt2 = paramInt4 - paramInt3;
    if (paramInt5 != -1)
    {
      if (paramInt5 != 0)
      {
        if (paramInt5 != 1) {
          return;
        }
        paramInt2 = (int)(paramInt1 * paramFloat + 0.5F);
        paramArrayOfInt[0] = paramInt1;
        paramArrayOfInt[1] = paramInt2;
        return;
      }
      paramArrayOfInt[0] = ((int)(paramInt2 * paramFloat + 0.5F));
      paramArrayOfInt[1] = paramInt2;
      return;
    }
    paramInt3 = (int)(paramInt2 * paramFloat + 0.5F);
    paramInt4 = (int)(paramInt1 / paramFloat + 0.5F);
    if (paramInt3 <= paramInt1)
    {
      paramArrayOfInt[0] = paramInt3;
      paramArrayOfInt[1] = paramInt2;
      return;
    }
    if (paramInt4 <= paramInt2)
    {
      paramArrayOfInt[0] = paramInt1;
      paramArrayOfInt[1] = paramInt4;
    }
  }
  
  void apply()
  {
    if (this.widget.measured) {
      this.dimension.resolve(this.widget.getWidth());
    }
    Object localObject;
    int i;
    if (!this.dimension.resolved)
    {
      this.dimensionBehavior = this.widget.getHorizontalDimensionBehaviour();
      if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
      {
        if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)
        {
          localObject = this.widget.getParent();
          if (((localObject != null) && (((ConstraintWidget)localObject).getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED)) || (((ConstraintWidget)localObject).getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
          {
            i = ((ConstraintWidget)localObject).getWidth();
            int j = this.widget.mLeft.getMargin();
            int k = this.widget.mRight.getMargin();
            addTarget(this.start, ((ConstraintWidget)localObject).horizontalRun.start, this.widget.mLeft.getMargin());
            addTarget(this.end, ((ConstraintWidget)localObject).horizontalRun.end, -this.widget.mRight.getMargin());
            this.dimension.resolve(i - j - k);
            return;
          }
        }
        if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
          this.dimension.resolve(this.widget.getWidth());
        }
      }
    }
    else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)
    {
      localObject = this.widget.getParent();
      if (((localObject != null) && (((ConstraintWidget)localObject).getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED)) || (((ConstraintWidget)localObject).getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
      {
        addTarget(this.start, ((ConstraintWidget)localObject).horizontalRun.start, this.widget.mLeft.getMargin());
        addTarget(this.end, ((ConstraintWidget)localObject).horizontalRun.end, -this.widget.mRight.getMargin());
        return;
      }
    }
    if ((this.dimension.resolved) && (this.widget.measured))
    {
      if ((this.widget.mListAnchors[0].mTarget != null) && (this.widget.mListAnchors[1].mTarget != null))
      {
        if (this.widget.isInHorizontalChain())
        {
          this.start.margin = this.widget.mListAnchors[0].getMargin();
          this.end.margin = (-this.widget.mListAnchors[1].getMargin());
          return;
        }
        localObject = getTarget(this.widget.mListAnchors[0]);
        if (localObject != null) {
          addTarget(this.start, (DependencyNode)localObject, this.widget.mListAnchors[0].getMargin());
        }
        localObject = getTarget(this.widget.mListAnchors[1]);
        if (localObject != null) {
          addTarget(this.end, (DependencyNode)localObject, -this.widget.mListAnchors[1].getMargin());
        }
        this.start.delegateToWidgetRun = true;
        this.end.delegateToWidgetRun = true;
        return;
      }
      if (this.widget.mListAnchors[0].mTarget != null)
      {
        localObject = getTarget(this.widget.mListAnchors[0]);
        if (localObject != null)
        {
          addTarget(this.start, (DependencyNode)localObject, this.widget.mListAnchors[0].getMargin());
          addTarget(this.end, this.start, this.dimension.value);
        }
      }
      else if (this.widget.mListAnchors[1].mTarget != null)
      {
        localObject = getTarget(this.widget.mListAnchors[1]);
        if (localObject != null)
        {
          addTarget(this.end, (DependencyNode)localObject, -this.widget.mListAnchors[1].getMargin());
          addTarget(this.start, this.end, -this.dimension.value);
        }
      }
      else if ((!(this.widget instanceof Helper)) && (this.widget.getParent() != null) && (this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget == null))
      {
        localObject = this.widget.getParent().horizontalRun.start;
        addTarget(this.start, (DependencyNode)localObject, this.widget.getX());
        addTarget(this.end, this.start, this.dimension.value);
      }
    }
    else
    {
      if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
      {
        i = this.widget.mMatchConstraintDefaultWidth;
        if (i != 2)
        {
          if (i == 3) {
            if (this.widget.mMatchConstraintDefaultHeight == 3)
            {
              this.start.updateDelegate = this;
              this.end.updateDelegate = this;
              this.widget.verticalRun.start.updateDelegate = this;
              this.widget.verticalRun.end.updateDelegate = this;
              this.dimension.updateDelegate = this;
              if (this.widget.isInVerticalChain())
              {
                this.dimension.targets.add(this.widget.verticalRun.dimension);
                this.widget.verticalRun.dimension.dependencies.add(this.dimension);
                this.widget.verticalRun.dimension.updateDelegate = this;
                this.dimension.targets.add(this.widget.verticalRun.start);
                this.dimension.targets.add(this.widget.verticalRun.end);
                this.widget.verticalRun.start.dependencies.add(this.dimension);
                this.widget.verticalRun.end.dependencies.add(this.dimension);
              }
              else if (this.widget.isInHorizontalChain())
              {
                this.widget.verticalRun.dimension.targets.add(this.dimension);
                this.dimension.dependencies.add(this.widget.verticalRun.dimension);
              }
              else
              {
                this.widget.verticalRun.dimension.targets.add(this.dimension);
              }
            }
            else
            {
              localObject = this.widget.verticalRun.dimension;
              this.dimension.targets.add(localObject);
              ((DependencyNode)localObject).dependencies.add(this.dimension);
              this.widget.verticalRun.start.dependencies.add(this.dimension);
              this.widget.verticalRun.end.dependencies.add(this.dimension);
              this.dimension.delegateToWidgetRun = true;
              this.dimension.dependencies.add(this.start);
              this.dimension.dependencies.add(this.end);
              this.start.targets.add(this.dimension);
              this.end.targets.add(this.dimension);
            }
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
      if ((this.widget.mListAnchors[0].mTarget != null) && (this.widget.mListAnchors[1].mTarget != null))
      {
        if (this.widget.isInHorizontalChain())
        {
          this.start.margin = this.widget.mListAnchors[0].getMargin();
          this.end.margin = (-this.widget.mListAnchors[1].getMargin());
          return;
        }
        localObject = getTarget(this.widget.mListAnchors[0]);
        DependencyNode localDependencyNode = getTarget(this.widget.mListAnchors[1]);
        ((DependencyNode)localObject).addDependency(this);
        localDependencyNode.addDependency(this);
        this.mRunType = WidgetRun.RunType.CENTER;
        return;
      }
      if (this.widget.mListAnchors[0].mTarget != null)
      {
        localObject = getTarget(this.widget.mListAnchors[0]);
        if (localObject != null)
        {
          addTarget(this.start, (DependencyNode)localObject, this.widget.mListAnchors[0].getMargin());
          addTarget(this.end, this.start, 1, this.dimension);
        }
      }
      else if (this.widget.mListAnchors[1].mTarget != null)
      {
        localObject = getTarget(this.widget.mListAnchors[1]);
        if (localObject != null)
        {
          addTarget(this.end, (DependencyNode)localObject, -this.widget.mListAnchors[1].getMargin());
          addTarget(this.start, this.end, -1, this.dimension);
        }
      }
      else if ((!(this.widget instanceof Helper)) && (this.widget.getParent() != null))
      {
        localObject = this.widget.getParent().horizontalRun.start;
        addTarget(this.start, (DependencyNode)localObject, this.widget.getX());
        addTarget(this.end, this.start, 1, this.dimension);
      }
    }
  }
  
  public void applyToWidget()
  {
    if (this.start.resolved) {
      this.widget.setX(this.start.value);
    }
  }
  
  void clear()
  {
    this.runGroup = null;
    this.start.clear();
    this.end.clear();
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
    this.dimension.resolved = false;
  }
  
  boolean supportsWrapComputation()
  {
    if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      return this.widget.mMatchConstraintDefaultWidth == 0;
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HorizontalRun ");
    localStringBuilder.append(this.widget.getDebugName());
    return localStringBuilder.toString();
  }
  
  public void update(Dependency paramDependency)
  {
    int i = HorizontalWidgetRun.1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          updateRunCenter(paramDependency, this.widget.mLeft, this.widget.mRight, 0);
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
    label247:
    label254:
    DependencyNode localDependencyNode;
    int j;
    int k;
    if ((!this.dimension.resolved) && (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))
    {
      i = this.widget.mMatchConstraintDefaultWidth;
      if (i != 2)
      {
        if (i == 3) {
          if ((this.widget.mMatchConstraintDefaultHeight != 0) && (this.widget.mMatchConstraintDefaultHeight != 3))
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
                  break label254;
                }
                f1 = this.widget.verticalRun.dimension.value;
                f2 = this.widget.getDimensionRatio();
              }
              else
              {
                f1 = this.widget.verticalRun.dimension.value / this.widget.getDimensionRatio();
                break label247;
              }
            }
            else
            {
              f1 = this.widget.verticalRun.dimension.value;
              f2 = this.widget.getDimensionRatio();
            }
            f1 *= f2;
            i = (int)(f1 + 0.5F);
            this.dimension.resolve(i);
          }
          else
          {
            paramDependency = this.widget.verticalRun.start;
            localDependencyNode = this.widget.verticalRun.end;
            if (this.widget.mLeft.mTarget != null) {
              i = 1;
            } else {
              i = 0;
            }
            if (this.widget.mTop.mTarget != null) {
              j = 1;
            } else {
              j = 0;
            }
            if (this.widget.mRight.mTarget != null) {
              k = 1;
            } else {
              k = 0;
            }
            int m;
            if (this.widget.mBottom.mTarget != null) {
              m = 1;
            } else {
              m = 0;
            }
            int n = this.widget.getDimensionRatioSide();
            if ((i != 0) && (j != 0) && (k != 0) && (m != 0))
            {
              f1 = this.widget.getDimensionRatio();
              int i1;
              int i2;
              int i3;
              int i4;
              if ((paramDependency.resolved) && (localDependencyNode.resolved))
              {
                if (this.start.readyToSolve)
                {
                  if (!this.end.readyToSolve) {
                    return;
                  }
                  i = ((DependencyNode)this.start.targets.get(0)).value;
                  j = this.start.margin;
                  k = ((DependencyNode)this.end.targets.get(0)).value;
                  m = this.end.margin;
                  i1 = paramDependency.value;
                  i2 = paramDependency.margin;
                  i3 = localDependencyNode.value;
                  i4 = localDependencyNode.margin;
                  computeInsetRatio(tempDimensions, i + j, k - m, i1 + i2, i3 - i4, f1, n);
                  this.dimension.resolve(tempDimensions[0]);
                  this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                }
                return;
              }
              if ((this.start.resolved) && (this.end.resolved)) {
                if (paramDependency.readyToSolve)
                {
                  if (!localDependencyNode.readyToSolve) {
                    return;
                  }
                  i = this.start.value;
                  j = this.start.margin;
                  k = this.end.value;
                  m = this.end.margin;
                  i1 = ((DependencyNode)paramDependency.targets.get(0)).value;
                  i2 = paramDependency.margin;
                  i3 = ((DependencyNode)localDependencyNode.targets.get(0)).value;
                  i4 = localDependencyNode.margin;
                  computeInsetRatio(tempDimensions, i + j, k - m, i1 + i2, i3 - i4, f1, n);
                  this.dimension.resolve(tempDimensions[0]);
                  this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                }
                else
                {
                  return;
                }
              }
              if ((this.start.readyToSolve) && (this.end.readyToSolve) && (paramDependency.readyToSolve))
              {
                if (!localDependencyNode.readyToSolve) {
                  return;
                }
                i = ((DependencyNode)this.start.targets.get(0)).value;
                j = this.start.margin;
                k = ((DependencyNode)this.end.targets.get(0)).value;
                m = this.end.margin;
                i1 = ((DependencyNode)paramDependency.targets.get(0)).value;
                i2 = paramDependency.margin;
                i3 = ((DependencyNode)localDependencyNode.targets.get(0)).value;
                i4 = localDependencyNode.margin;
                computeInsetRatio(tempDimensions, i + j, k - m, i1 + i2, i3 - i4, f1, n);
                this.dimension.resolve(tempDimensions[0]);
                this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
              }
            }
            else if ((i != 0) && (k != 0))
            {
              if (this.start.readyToSolve)
              {
                if (!this.end.readyToSolve) {
                  return;
                }
                f1 = this.widget.getDimensionRatio();
                i = ((DependencyNode)this.start.targets.get(0)).value + this.start.margin;
                j = ((DependencyNode)this.end.targets.get(0)).value - this.end.margin;
                if ((n != -1) && (n != 0))
                {
                  if (n == 1)
                  {
                    i = getLimitedDimension(j - i, 0);
                    k = (int)(i / f1 + 0.5F);
                    j = getLimitedDimension(k, 1);
                    if (k != j) {
                      i = (int)(j * f1 + 0.5F);
                    }
                    this.dimension.resolve(i);
                    this.widget.verticalRun.dimension.resolve(j);
                  }
                }
                else
                {
                  i = getLimitedDimension(j - i, 0);
                  k = (int)(i * f1 + 0.5F);
                  j = getLimitedDimension(k, 1);
                  if (k != j) {
                    i = (int)(j / f1 + 0.5F);
                  }
                  this.dimension.resolve(i);
                  this.widget.verticalRun.dimension.resolve(j);
                }
              }
            }
            else if ((j != 0) && (m != 0))
            {
              if (paramDependency.readyToSolve)
              {
                if (!localDependencyNode.readyToSolve) {
                  return;
                }
                f1 = this.widget.getDimensionRatio();
                i = ((DependencyNode)paramDependency.targets.get(0)).value + paramDependency.margin;
                j = ((DependencyNode)localDependencyNode.targets.get(0)).value - localDependencyNode.margin;
                if (n != -1) {
                  if (n != 0)
                  {
                    if (n != 1) {
                      break label1583;
                    }
                  }
                  else
                  {
                    i = getLimitedDimension(j - i, 1);
                    k = (int)(i * f1 + 0.5F);
                    j = getLimitedDimension(k, 0);
                    if (k != j) {
                      i = (int)(j / f1 + 0.5F);
                    }
                    this.dimension.resolve(j);
                    this.widget.verticalRun.dimension.resolve(i);
                    break label1583;
                  }
                }
                i = getLimitedDimension(j - i, 1);
                k = (int)(i / f1 + 0.5F);
                j = getLimitedDimension(k, 0);
                if (k != j) {
                  i = (int)(j * f1 + 0.5F);
                }
                this.dimension.resolve(j);
                this.widget.verticalRun.dimension.resolve(i);
              }
            }
          }
        }
      }
      else
      {
        paramDependency = this.widget.getParent();
        if ((paramDependency != null) && (paramDependency.horizontalRun.dimension.resolved))
        {
          f1 = this.widget.mMatchConstraintPercentWidth;
          i = (int)(paramDependency.horizontalRun.dimension.value * f1 + 0.5F);
          this.dimension.resolve(i);
        }
      }
    }
    label1583:
    if (this.start.readyToSolve)
    {
      if (!this.end.readyToSolve) {
        return;
      }
      if ((this.start.resolved) && (this.end.resolved) && (this.dimension.resolved)) {
        return;
      }
      if ((!this.dimension.resolved) && (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (this.widget.mMatchConstraintDefaultWidth == 0) && (!this.widget.isInHorizontalChain()))
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
        i = Math.min(localDependencyNode.value + this.end.margin - (i + j), this.dimension.wrapValue);
        k = this.widget.mMatchConstraintMaxWidth;
        j = Math.max(this.widget.mMatchConstraintMinWidth, i);
        i = j;
        if (k > 0) {
          i = Math.min(k, j);
        }
        this.dimension.resolve(i);
      }
      if (!this.dimension.resolved) {
        return;
      }
      paramDependency = (DependencyNode)this.start.targets.get(0);
      localDependencyNode = (DependencyNode)this.end.targets.get(0);
      i = paramDependency.value + this.start.margin;
      j = localDependencyNode.value + this.end.margin;
      f1 = this.widget.getHorizontalBiasPercent();
      if (paramDependency == localDependencyNode)
      {
        i = paramDependency.value;
        j = localDependencyNode.value;
        f1 = 0.5F;
      }
      k = this.dimension.value;
      this.start.resolve((int)(i + 0.5F + (j - i - k) * f1));
      this.end.resolve(this.start.value + this.dimension.value);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun
 * JD-Core Version:    0.7.0.1
 */