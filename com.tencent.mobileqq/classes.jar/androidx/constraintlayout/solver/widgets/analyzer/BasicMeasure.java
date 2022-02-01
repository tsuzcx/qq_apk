package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.Barrier;
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
  
  private boolean measure(BasicMeasure.Measurer paramMeasurer, ConstraintWidget paramConstraintWidget, int paramInt)
  {
    this.mMeasure.horizontalBehavior = paramConstraintWidget.getHorizontalDimensionBehaviour();
    this.mMeasure.verticalBehavior = paramConstraintWidget.getVerticalDimensionBehaviour();
    this.mMeasure.horizontalDimension = paramConstraintWidget.getWidth();
    this.mMeasure.verticalDimension = paramConstraintWidget.getHeight();
    BasicMeasure.Measure localMeasure = this.mMeasure;
    localMeasure.measuredNeedsSolverPass = false;
    localMeasure.measureStrategy = paramInt;
    int i;
    if (localMeasure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.mMeasure.verticalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((i != 0) && (paramConstraintWidget.mDimensionRatio > 0.0F)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramInt != 0) && (paramConstraintWidget.mDimensionRatio > 0.0F)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((i != 0) && (paramConstraintWidget.mResolvedMatchConstraintDefault[0] == 4)) {
      this.mMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
    }
    if ((paramInt != 0) && (paramConstraintWidget.mResolvedMatchConstraintDefault[1] == 4)) {
      this.mMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
    }
    paramMeasurer.measure(paramConstraintWidget, this.mMeasure);
    paramConstraintWidget.setWidth(this.mMeasure.measuredWidth);
    paramConstraintWidget.setHeight(this.mMeasure.measuredHeight);
    paramConstraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
    paramConstraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
    this.mMeasure.measureStrategy = BasicMeasure.Measure.SELF_DIMENSIONS;
    return this.mMeasure.measuredNeedsSolverPass;
  }
  
  private void measureChildren(ConstraintWidgetContainer paramConstraintWidgetContainer)
  {
    int m = paramConstraintWidgetContainer.mChildren.size();
    boolean bool = paramConstraintWidgetContainer.optimizeFor(64);
    BasicMeasure.Measurer localMeasurer = paramConstraintWidgetContainer.getMeasurer();
    int k = 0;
    while (k < m)
    {
      Object localObject = (ConstraintWidget)paramConstraintWidgetContainer.mChildren.get(k);
      if ((!(localObject instanceof Guideline)) && (!(localObject instanceof Barrier)) && (!((ConstraintWidget)localObject).isInVirtualLayout()) && ((!bool) || (((ConstraintWidget)localObject).horizontalRun == null) || (((ConstraintWidget)localObject).verticalRun == null) || (!((ConstraintWidget)localObject).horizontalRun.dimension.resolved) || (!((ConstraintWidget)localObject).verticalRun.dimension.resolved)))
      {
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = ((ConstraintWidget)localObject).getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = ((ConstraintWidget)localObject).getDimensionBehaviour(1);
        int i;
        if ((localDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (((ConstraintWidget)localObject).mMatchConstraintDefaultWidth != 1) && (localDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (((ConstraintWidget)localObject).mMatchConstraintDefaultHeight != 1)) {
          i = 1;
        } else {
          i = 0;
        }
        int j = i;
        if (i == 0)
        {
          j = i;
          if (paramConstraintWidgetContainer.optimizeFor(1))
          {
            j = i;
            if (!(localObject instanceof VirtualLayout))
            {
              j = i;
              if (localDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
              {
                j = i;
                if (((ConstraintWidget)localObject).mMatchConstraintDefaultWidth == 0)
                {
                  j = i;
                  if (localDimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
                  {
                    j = i;
                    if (!((ConstraintWidget)localObject).isInHorizontalChain()) {
                      j = 1;
                    }
                  }
                }
              }
              i = j;
              if (localDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
              {
                i = j;
                if (((ConstraintWidget)localObject).mMatchConstraintDefaultHeight == 0)
                {
                  i = j;
                  if (localDimensionBehaviour1 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
                  {
                    i = j;
                    if (!((ConstraintWidget)localObject).isInHorizontalChain()) {
                      i = 1;
                    }
                  }
                }
              }
              if (localDimensionBehaviour1 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
              {
                j = i;
                if (localDimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {}
              }
              else
              {
                j = i;
                if (((ConstraintWidget)localObject).mDimensionRatio > 0.0F) {
                  j = 1;
                }
              }
            }
          }
        }
        if (j == 0)
        {
          measure(localMeasurer, (ConstraintWidget)localObject, BasicMeasure.Measure.SELF_DIMENSIONS);
          if (paramConstraintWidgetContainer.mMetrics != null)
          {
            localObject = paramConstraintWidgetContainer.mMetrics;
            ((Metrics)localObject).measuredWidgets += 1L;
          }
        }
      }
      k += 1;
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
    int j = paramConstraintWidgetContainer.mChildren.size();
    paramInt9 = paramConstraintWidgetContainer.getWidth();
    int m = paramConstraintWidgetContainer.getHeight();
    boolean bool2 = Optimizer.enabled(paramInt1, 128);
    if ((!bool2) && (!Optimizer.enabled(paramInt1, 64))) {
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
        if (paramInt2 >= j) {
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
    if (((paramInt4 == 1073741824) && (paramInt6 == 1073741824)) || (bool2)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    int i = paramInt3 & paramInt1;
    if (i != 0)
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
      boolean bool1;
      if ((paramInt4 == 1073741824) && (paramInt6 == 1073741824))
      {
        bool1 = paramConstraintWidgetContainer.directMeasure(bool2);
        paramInt1 = 2;
      }
      else
      {
        bool1 = paramConstraintWidgetContainer.directMeasureSetup(bool2);
        if (paramInt4 == 1073741824)
        {
          bool1 &= paramConstraintWidgetContainer.directMeasureWithOrientation(bool2, 0);
          paramInt1 = 1;
        }
        else
        {
          paramInt1 = 0;
        }
        if (paramInt6 == 1073741824)
        {
          bool1 = paramConstraintWidgetContainer.directMeasureWithOrientation(bool2, 1) & bool1;
          paramInt1 += 1;
        }
      }
      bool2 = bool1;
      paramInt2 = paramInt1;
      if (bool1)
      {
        if (paramInt4 == 1073741824) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        boolean bool3;
        if (paramInt6 == 1073741824) {
          bool3 = true;
        } else {
          bool3 = false;
        }
        paramConstraintWidgetContainer.updateFromRuns(bool2, bool3);
        bool2 = bool1;
        paramInt2 = paramInt1;
      }
    }
    else
    {
      bool2 = false;
      paramInt2 = 0;
    }
    if ((!bool2) || (paramInt2 != 2))
    {
      paramInt4 = paramConstraintWidgetContainer.getOptimizationLevel();
      if (j > 0) {
        measureChildren(paramConstraintWidgetContainer);
      }
      updateHierarchy(paramConstraintWidgetContainer);
      int n = this.mVariableDimensionsWidgets.size();
      if (j > 0) {
        solveLinearSystem(paramConstraintWidgetContainer, "First pass", paramInt9, m);
      }
      if (n > 0)
      {
        if (paramConstraintWidgetContainer.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          j = 1;
        } else {
          j = 0;
        }
        int k;
        if (paramConstraintWidgetContainer.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          k = 1;
        } else {
          k = 0;
        }
        paramInt2 = Math.max(paramConstraintWidgetContainer.getWidth(), this.constraintWidgetContainer.getMinWidth());
        paramInt1 = Math.max(paramConstraintWidgetContainer.getHeight(), this.constraintWidgetContainer.getMinHeight());
        paramInt8 = 0;
        paramInt3 = 0;
        paramInt6 = m;
        paramInt5 = paramInt9;
        int i1;
        Metrics localMetrics;
        while (paramInt8 < n)
        {
          localObject = (ConstraintWidget)this.mVariableDimensionsWidgets.get(paramInt8);
          if ((localObject instanceof VirtualLayout))
          {
            i1 = ((ConstraintWidget)localObject).getWidth();
            paramInt9 = ((ConstraintWidget)localObject).getHeight();
            paramInt7 = measure(localMeasurer, (ConstraintWidget)localObject, BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) | paramInt3;
            if (paramConstraintWidgetContainer.mMetrics != null)
            {
              localMetrics = paramConstraintWidgetContainer.mMetrics;
              localMetrics.measuredMatchWidgets += 1L;
            }
            paramInt3 = ((ConstraintWidget)localObject).getWidth();
            m = ((ConstraintWidget)localObject).getHeight();
            if (paramInt3 != i1)
            {
              ((ConstraintWidget)localObject).setWidth(paramInt3);
              paramInt3 = paramInt2;
              if (j != 0)
              {
                paramInt3 = paramInt2;
                if (((ConstraintWidget)localObject).getRight() > paramInt2) {
                  paramInt3 = Math.max(paramInt2, ((ConstraintWidget)localObject).getRight() + ((ConstraintWidget)localObject).getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                }
              }
              paramInt7 = 1;
              paramInt2 = paramInt3;
            }
            paramInt3 = paramInt1;
            if (m != paramInt9)
            {
              ((ConstraintWidget)localObject).setHeight(m);
              paramInt3 = paramInt1;
              if (k != 0)
              {
                paramInt3 = paramInt1;
                if (((ConstraintWidget)localObject).getBottom() > paramInt1) {
                  paramInt3 = Math.max(paramInt1, ((ConstraintWidget)localObject).getBottom() + ((ConstraintWidget)localObject).getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                }
              }
              paramInt7 = 1;
            }
            paramInt7 = ((VirtualLayout)localObject).needSolverPass() | paramInt7;
            paramInt1 = paramInt3;
            paramInt3 = paramInt7;
          }
          paramInt8 += 1;
        }
        m = 0;
        paramInt9 = n;
        paramInt7 = i;
        while (m < 2)
        {
          n = 0;
          paramInt8 = paramInt3;
          paramInt3 = paramInt9;
          while (n < paramInt3)
          {
            localObject = (ConstraintWidget)this.mVariableDimensionsWidgets.get(n);
            if ((((localObject instanceof Helper)) && (!(localObject instanceof VirtualLayout))) || ((localObject instanceof Guideline)) || (((ConstraintWidget)localObject).getVisibility() == 8) || ((paramInt7 != 0) && (((ConstraintWidget)localObject).horizontalRun.dimension.resolved) && (((ConstraintWidget)localObject).verticalRun.dimension.resolved)) || ((localObject instanceof VirtualLayout)))
            {
              paramInt9 = paramInt8;
              i1 = paramInt2;
            }
            else
            {
              int i3 = ((ConstraintWidget)localObject).getWidth();
              i1 = ((ConstraintWidget)localObject).getHeight();
              int i2 = ((ConstraintWidget)localObject).getBaselineDistance();
              paramInt9 = BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS;
              if (m == 1) {
                paramInt9 = BasicMeasure.Measure.USE_GIVEN_DIMENSIONS;
              }
              i = paramInt8 | measure(localMeasurer, (ConstraintWidget)localObject, paramInt9);
              if (paramConstraintWidgetContainer.mMetrics != null)
              {
                localMetrics = paramConstraintWidgetContainer.mMetrics;
                localMetrics.measuredMatchWidgets += 1L;
              }
              int i4 = ((ConstraintWidget)localObject).getWidth();
              paramInt9 = ((ConstraintWidget)localObject).getHeight();
              paramInt8 = paramInt2;
              if (i4 != i3)
              {
                ((ConstraintWidget)localObject).setWidth(i4);
                paramInt8 = paramInt2;
                if (j != 0)
                {
                  paramInt8 = paramInt2;
                  if (((ConstraintWidget)localObject).getRight() > paramInt2) {
                    paramInt8 = Math.max(paramInt2, ((ConstraintWidget)localObject).getRight() + ((ConstraintWidget)localObject).getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                  }
                }
                i = 1;
              }
              paramInt2 = paramInt1;
              if (paramInt9 != i1)
              {
                ((ConstraintWidget)localObject).setHeight(paramInt9);
                paramInt2 = paramInt1;
                if (k != 0)
                {
                  paramInt2 = paramInt1;
                  if (((ConstraintWidget)localObject).getBottom() > paramInt1) {
                    paramInt2 = Math.max(paramInt1, ((ConstraintWidget)localObject).getBottom() + ((ConstraintWidget)localObject).getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                  }
                }
                i = 1;
              }
              paramInt9 = i;
              i1 = paramInt8;
              paramInt1 = paramInt2;
              if (((ConstraintWidget)localObject).hasBaseline())
              {
                paramInt9 = i;
                i1 = paramInt8;
                paramInt1 = paramInt2;
                if (i2 != ((ConstraintWidget)localObject).getBaselineDistance())
                {
                  paramInt9 = 1;
                  paramInt1 = paramInt2;
                  i1 = paramInt8;
                }
              }
            }
            n += 1;
            paramInt8 = paramInt9;
            paramInt2 = i1;
          }
          if (paramInt8 != 0)
          {
            solveLinearSystem(paramConstraintWidgetContainer, "intermediate pass", paramInt5, paramInt6);
            m += 1;
            paramInt8 = 0;
            paramInt9 = paramInt3;
            paramInt3 = paramInt8;
          }
          else
          {
            paramInt3 = paramInt1;
            break label1395;
          }
        }
        paramInt8 = paramInt3;
        paramInt3 = paramInt1;
        label1395:
        if (paramInt8 != 0)
        {
          solveLinearSystem(paramConstraintWidgetContainer, "2nd pass", paramInt5, paramInt6);
          if (paramConstraintWidgetContainer.getWidth() < paramInt2)
          {
            paramConstraintWidgetContainer.setWidth(paramInt2);
            paramInt1 = 1;
          }
          else
          {
            paramInt1 = 0;
          }
          if (paramConstraintWidgetContainer.getHeight() < paramInt3)
          {
            paramConstraintWidgetContainer.setHeight(paramInt3);
            paramInt1 = 1;
          }
          if (paramInt1 != 0) {
            solveLinearSystem(paramConstraintWidgetContainer, "3rd pass", paramInt5, paramInt6);
          }
        }
      }
      paramConstraintWidgetContainer.setOptimizationLevel(paramInt4);
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
      if ((localConstraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || (localConstraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) {
        this.mVariableDimensionsWidgets.add(localConstraintWidget);
      }
      i += 1;
    }
    paramConstraintWidgetContainer.invalidateGraph();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure
 * JD-Core Version:    0.7.0.1
 */