package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import java.util.ArrayList;

public class BasicMeasure
{
  public static final int AT_MOST = -2147483648;
  private static final boolean DEBUG = false;
  public static final int EXACTLY = 1073741824;
  public static final int FIXED = -3;
  public static final int MATCH_PARENT = -1;
  private static final int MODE_SHIFT = 30;
  public static final int UNSPECIFIED = 0;
  public static final int WRAP_CONTENT = -2;
  private ConstraintWidgetContainer constraintWidgetContainer;
  private BasicMeasure.Measure mMeasure = new BasicMeasure.Measure();
  private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList();
  
  public BasicMeasure(ConstraintWidgetContainer paramConstraintWidgetContainer)
  {
    this.constraintWidgetContainer = paramConstraintWidgetContainer;
  }
  
  private boolean measure(BasicMeasure.Measurer paramMeasurer, ConstraintWidget paramConstraintWidget, boolean paramBoolean)
  {
    this.mMeasure.horizontalBehavior = paramConstraintWidget.getHorizontalDimensionBehaviour();
    this.mMeasure.verticalBehavior = paramConstraintWidget.getVerticalDimensionBehaviour();
    this.mMeasure.horizontalDimension = paramConstraintWidget.getWidth();
    this.mMeasure.verticalDimension = paramConstraintWidget.getHeight();
    BasicMeasure.Measure localMeasure = this.mMeasure;
    localMeasure.measuredNeedsSolverPass = false;
    localMeasure.useCurrentDimensions = paramBoolean;
    int j;
    if (localMeasure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      j = 1;
    } else {
      j = 0;
    }
    int i;
    if (this.mMeasure.verticalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      i = 1;
    } else {
      i = 0;
    }
    if ((j != 0) && (paramConstraintWidget.mDimensionRatio > 0.0F)) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i != 0) && (paramConstraintWidget.mDimensionRatio > 0.0F)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((j != 0) && (paramConstraintWidget.mResolvedMatchConstraintDefault[0] == 4)) {
      this.mMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
    }
    if ((i != 0) && (paramConstraintWidget.mResolvedMatchConstraintDefault[1] == 4)) {
      this.mMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
    }
    paramMeasurer.measure(paramConstraintWidget, this.mMeasure);
    paramConstraintWidget.setWidth(this.mMeasure.measuredWidth);
    paramConstraintWidget.setHeight(this.mMeasure.measuredHeight);
    paramConstraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
    paramConstraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
    paramMeasurer = this.mMeasure;
    paramMeasurer.useCurrentDimensions = false;
    return paramMeasurer.measuredNeedsSolverPass;
  }
  
  private void measureChildren(ConstraintWidgetContainer paramConstraintWidgetContainer)
  {
    int k = paramConstraintWidgetContainer.mChildren.size();
    BasicMeasure.Measurer localMeasurer = paramConstraintWidgetContainer.getMeasurer();
    int i = 0;
    while (i < k)
    {
      Object localObject = (ConstraintWidget)paramConstraintWidgetContainer.mChildren.get(i);
      if ((!(localObject instanceof Guideline)) && ((!((ConstraintWidget)localObject).horizontalRun.dimension.resolved) || (!((ConstraintWidget)localObject).verticalRun.dimension.resolved)))
      {
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = ((ConstraintWidget)localObject).getDimensionBehaviour(0);
        int j = 1;
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = ((ConstraintWidget)localObject).getDimensionBehaviour(1);
        if ((localDimensionBehaviour1 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || (((ConstraintWidget)localObject).mMatchConstraintDefaultWidth == 1) || (localDimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || (((ConstraintWidget)localObject).mMatchConstraintDefaultHeight == 1)) {
          j = 0;
        }
        if (j == 0)
        {
          measure(localMeasurer, (ConstraintWidget)localObject, false);
          if (paramConstraintWidgetContainer.mMetrics != null)
          {
            localObject = paramConstraintWidgetContainer.mMetrics;
            ((Metrics)localObject).measuredWidgets += 1L;
          }
        }
      }
      i += 1;
    }
    localMeasurer.didMeasures();
  }
  
  private void solveLinearSystem(ConstraintWidgetContainer paramConstraintWidgetContainer, String paramString, int paramInt1, int paramInt2)
  {
    int i = paramConstraintWidgetContainer.getMinWidth();
    int j = paramConstraintWidgetContainer.getMinHeight();
    paramConstraintWidgetContainer.setMinWidth(0);
    paramConstraintWidgetContainer.setMinHeight(0);
    paramConstraintWidgetContainer.setWidth(paramInt1);
    paramConstraintWidgetContainer.setHeight(paramInt2);
    paramConstraintWidgetContainer.setMinWidth(i);
    paramConstraintWidgetContainer.setMinHeight(j);
    this.constraintWidgetContainer.layout();
  }
  
  public long solverMeasure(ConstraintWidgetContainer paramConstraintWidgetContainer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    BasicMeasure.Measurer localMeasurer = paramConstraintWidgetContainer.getMeasurer();
    paramInt9 = paramConstraintWidgetContainer.mChildren.size();
    int j = paramConstraintWidgetContainer.getWidth();
    int k = paramConstraintWidgetContainer.getHeight();
    boolean bool = Optimizer.enabled(paramInt1, 128);
    if ((!bool) && (!Optimizer.enabled(paramInt1, 64))) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    paramInt3 = paramInt1;
    Object localObject;
    if (paramInt1 != 0)
    {
      paramInt2 = 0;
      for (;;)
      {
        paramInt3 = paramInt1;
        if (paramInt2 >= paramInt9) {
          break;
        }
        localObject = (ConstraintWidget)paramConstraintWidgetContainer.mChildren.get(paramInt2);
        if (((ConstraintWidget)localObject).getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
          paramInt3 = 1;
        } else {
          paramInt3 = 0;
        }
        if (((ConstraintWidget)localObject).getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
          paramInt8 = 1;
        } else {
          paramInt8 = 0;
        }
        if ((paramInt3 != 0) && (paramInt8 != 0) && (((ConstraintWidget)localObject).getDimensionRatio() > 0.0F)) {
          paramInt3 = 1;
        } else {
          paramInt3 = 0;
        }
        if ((((ConstraintWidget)localObject).isInHorizontalChain()) && (paramInt3 != 0)) {}
        while (((((ConstraintWidget)localObject).isInVerticalChain()) && (paramInt3 != 0)) || ((localObject instanceof VirtualLayout)) || (((ConstraintWidget)localObject).isInHorizontalChain()) || (((ConstraintWidget)localObject).isInVerticalChain()))
        {
          paramInt3 = 0;
          break;
        }
        paramInt2 += 1;
      }
    }
    if ((paramInt3 != 0) && (LinearSystem.sMetrics != null))
    {
      localObject = LinearSystem.sMetrics;
      ((Metrics)localObject).measures += 1L;
    }
    if (((paramInt4 == 1073741824) && (paramInt6 == 1073741824)) || (bool)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    int i3;
    int i6;
    if ((paramInt3 & paramInt1) != 0)
    {
      paramInt1 = Math.min(paramConstraintWidgetContainer.getMaxWidth(), paramInt5);
      paramInt2 = Math.min(paramConstraintWidgetContainer.getMaxHeight(), paramInt7);
      if ((paramInt4 == 1073741824) && (paramConstraintWidgetContainer.getWidth() != paramInt1))
      {
        paramConstraintWidgetContainer.setWidth(paramInt1);
        paramConstraintWidgetContainer.invalidateGraph();
      }
      if ((paramInt6 == 1073741824) && (paramConstraintWidgetContainer.getHeight() != paramInt2))
      {
        paramConstraintWidgetContainer.setHeight(paramInt2);
        paramConstraintWidgetContainer.invalidateGraph();
      }
      if ((paramInt4 == 1073741824) && (paramInt6 == 1073741824))
      {
        i3 = paramConstraintWidgetContainer.directMeasure(bool);
        paramInt1 = 2;
      }
      else
      {
        int i4 = paramConstraintWidgetContainer.directMeasureSetup(bool);
        if (paramInt4 == 1073741824)
        {
          i4 &= paramConstraintWidgetContainer.directMeasureWithOrientation(bool, 0);
          paramInt2 = 1;
        }
        else
        {
          paramInt2 = 0;
        }
        i3 = i4;
        paramInt1 = paramInt2;
        if (paramInt6 == 1073741824)
        {
          i3 = i4 & paramConstraintWidgetContainer.directMeasureWithOrientation(bool, 1);
          paramInt1 = paramInt2 + 1;
        }
      }
      int i5 = i3;
      paramInt2 = paramInt1;
      if (i3 != 0)
      {
        if (paramInt4 == 1073741824) {
          i5 = 1;
        } else {
          i5 = 0;
        }
        if (paramInt6 == 1073741824) {
          bool = true;
        } else {
          bool = false;
        }
        paramConstraintWidgetContainer.updateFromRuns(i5, bool);
        i6 = i3;
        paramInt2 = paramInt1;
      }
    }
    else
    {
      i6 = 0;
      paramInt2 = 0;
    }
    if ((i6 == 0) || (paramInt2 != 2))
    {
      if (paramInt9 > 0) {
        measureChildren(paramConstraintWidgetContainer);
      }
      paramInt3 = paramConstraintWidgetContainer.getOptimizationLevel();
      int m = this.mVariableDimensionsWidgets.size();
      if (paramInt9 > 0) {
        solveLinearSystem(paramConstraintWidgetContainer, "First pass", j, k);
      }
      paramInt1 = paramInt3;
      if (m > 0)
      {
        if (paramConstraintWidgetContainer.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          paramInt8 = 1;
        } else {
          paramInt8 = 0;
        }
        if (paramConstraintWidgetContainer.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          paramInt9 = 1;
        } else {
          paramInt9 = 0;
        }
        paramInt2 = Math.max(paramConstraintWidgetContainer.getWidth(), this.constraintWidgetContainer.getMinWidth());
        paramInt1 = Math.max(paramConstraintWidgetContainer.getHeight(), this.constraintWidgetContainer.getMinHeight());
        int i = 0;
        paramInt6 = 0;
        paramInt4 = k;
        paramInt5 = j;
        int n;
        Metrics localMetrics;
        int i1;
        while (i < m)
        {
          localObject = (ConstraintWidget)this.mVariableDimensionsWidgets.get(i);
          if ((localObject instanceof VirtualLayout))
          {
            n = ((ConstraintWidget)localObject).getWidth();
            j = ((ConstraintWidget)localObject).getHeight();
            paramInt7 = paramInt6 | measure(localMeasurer, (ConstraintWidget)localObject, true);
            if (paramConstraintWidgetContainer.mMetrics != null)
            {
              localMetrics = paramConstraintWidgetContainer.mMetrics;
              localMetrics.measuredMatchWidgets += 1L;
            }
            i1 = ((ConstraintWidget)localObject).getWidth();
            k = ((ConstraintWidget)localObject).getHeight();
            paramInt6 = paramInt2;
            if (i1 != n)
            {
              ((ConstraintWidget)localObject).setWidth(i1);
              paramInt6 = paramInt2;
              if (paramInt8 != 0)
              {
                paramInt6 = paramInt2;
                if (((ConstraintWidget)localObject).getRight() > paramInt2) {
                  paramInt6 = Math.max(paramInt2, ((ConstraintWidget)localObject).getRight() + ((ConstraintWidget)localObject).getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                }
              }
              paramInt7 = 1;
            }
            paramInt2 = paramInt1;
            if (k != j)
            {
              ((ConstraintWidget)localObject).setHeight(k);
              paramInt2 = paramInt1;
              if (paramInt9 != 0)
              {
                paramInt2 = paramInt1;
                if (((ConstraintWidget)localObject).getBottom() > paramInt1) {
                  paramInt2 = Math.max(paramInt1, ((ConstraintWidget)localObject).getBottom() + ((ConstraintWidget)localObject).getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                }
              }
              paramInt7 = 1;
            }
            paramInt7 = ((VirtualLayout)localObject).needSolverPass() | paramInt7;
            paramInt1 = paramInt2;
            paramInt2 = paramInt6;
            paramInt6 = paramInt7;
          }
          i += 1;
        }
        k = 0;
        paramInt7 = paramInt4;
        i = paramInt5;
        j = paramInt1;
        paramInt4 = m;
        paramInt5 = k;
        while (paramInt5 < 2)
        {
          k = 0;
          paramInt1 = j;
          j = paramInt5;
          while (k < paramInt4)
          {
            localObject = (ConstraintWidget)this.mVariableDimensionsWidgets.get(k);
            if ((((localObject instanceof Helper)) && (!(localObject instanceof VirtualLayout))) || ((localObject instanceof Guideline)) || (((ConstraintWidget)localObject).getVisibility() == 8) || ((((ConstraintWidget)localObject).horizontalRun.dimension.resolved) && (((ConstraintWidget)localObject).verticalRun.dimension.resolved)) || (!(localObject instanceof VirtualLayout)))
            {
              paramInt5 = ((ConstraintWidget)localObject).getWidth();
              n = ((ConstraintWidget)localObject).getHeight();
              m = ((ConstraintWidget)localObject).getBaselineDistance();
              i3 = measure(localMeasurer, (ConstraintWidget)localObject, true);
              if (paramConstraintWidgetContainer.mMetrics != null)
              {
                localMetrics = paramConstraintWidgetContainer.mMetrics;
                localMetrics.measuredMatchWidgets += 1L;
              }
              int i2 = ((ConstraintWidget)localObject).getWidth();
              i1 = ((ConstraintWidget)localObject).getHeight();
              if (i2 != paramInt5)
              {
                ((ConstraintWidget)localObject).setWidth(i2);
                paramInt5 = paramInt2;
                if (paramInt8 != 0)
                {
                  paramInt5 = paramInt2;
                  if (((ConstraintWidget)localObject).getRight() > paramInt2) {
                    paramInt5 = Math.max(paramInt2, ((ConstraintWidget)localObject).getRight() + ((ConstraintWidget)localObject).getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                  }
                }
                paramInt6 = 1;
                paramInt2 = paramInt5;
              }
              else
              {
                paramInt6 |= i3;
              }
              paramInt5 = paramInt1;
              if (i1 != n)
              {
                ((ConstraintWidget)localObject).setHeight(i1);
                paramInt5 = paramInt1;
                if (paramInt9 != 0)
                {
                  paramInt5 = paramInt1;
                  if (((ConstraintWidget)localObject).getBottom() > paramInt1) {
                    paramInt5 = Math.max(paramInt1, ((ConstraintWidget)localObject).getBottom() + ((ConstraintWidget)localObject).getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                  }
                }
                paramInt6 = 1;
              }
              if ((((ConstraintWidget)localObject).hasBaseline()) && (m != ((ConstraintWidget)localObject).getBaselineDistance()))
              {
                paramInt6 = 1;
                paramInt1 = paramInt5;
              }
              else
              {
                paramInt1 = paramInt5;
              }
            }
            k += 1;
          }
          if (paramInt6 != 0)
          {
            solveLinearSystem(paramConstraintWidgetContainer, "intermediate pass", i, paramInt7);
            paramInt6 = 0;
          }
          paramInt5 = j + 1;
          j = paramInt1;
        }
        if (paramInt6 != 0)
        {
          solveLinearSystem(paramConstraintWidgetContainer, "2nd pass", i, paramInt7);
          if (paramConstraintWidgetContainer.getWidth() < paramInt2)
          {
            paramConstraintWidgetContainer.setWidth(paramInt2);
            paramInt1 = 1;
          }
          else
          {
            paramInt1 = 0;
          }
          if (paramConstraintWidgetContainer.getHeight() < j)
          {
            paramConstraintWidgetContainer.setHeight(j);
            paramInt1 = 1;
          }
          if (paramInt1 != 0) {
            solveLinearSystem(paramConstraintWidgetContainer, "3rd pass", i, paramInt7);
          }
        }
        paramInt1 = paramInt3;
      }
      paramConstraintWidgetContainer.setOptimizationLevel(paramInt1);
    }
    return 0L;
  }
  
  public void updateHierarchy(ConstraintWidgetContainer paramConstraintWidgetContainer)
  {
    this.mVariableDimensionsWidgets.clear();
    int j = paramConstraintWidgetContainer.mChildren.size();
    int i = 0;
    while (i < j)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)paramConstraintWidgetContainer.mChildren.get(i);
      if ((localConstraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || (localConstraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) || (localConstraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || (localConstraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)) {
        this.mVariableDimensionsWidgets.add(localConstraintWidget);
      }
      i += 1;
    }
    paramConstraintWidgetContainer.invalidateGraph();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure
 * JD-Core Version:    0.7.0.1
 */