package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ChainHead;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Direct
{
  private static final boolean APPLY_MATCH_PARENT = false;
  private static final boolean DEBUG = false;
  private static BasicMeasure.Measure measure = new BasicMeasure.Measure();
  
  private static boolean canMeasure(ConstraintWidget paramConstraintWidget)
  {
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = paramConstraintWidget.getHorizontalDimensionBehaviour();
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = paramConstraintWidget.getVerticalDimensionBehaviour();
    if (paramConstraintWidget.getParent() != null) {
      localObject = (ConstraintWidgetContainer)paramConstraintWidget.getParent();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      ((ConstraintWidgetContainer)localObject).getHorizontalDimensionBehaviour();
      ConstraintWidget.DimensionBehaviour localDimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
    }
    if (localObject != null)
    {
      ((ConstraintWidgetContainer)localObject).getVerticalDimensionBehaviour();
      localObject = ConstraintWidget.DimensionBehaviour.FIXED;
    }
    Object localObject = ConstraintWidget.DimensionBehaviour.FIXED;
    boolean bool2 = false;
    int i;
    if ((localDimensionBehaviour1 != localObject) && (localDimensionBehaviour1 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && ((localDimensionBehaviour1 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || (paramConstraintWidget.mMatchConstraintDefaultWidth != 0) || (paramConstraintWidget.mDimensionRatio != 0.0F) || (!paramConstraintWidget.hasDanglingDimension(0))) && (!paramConstraintWidget.isResolvedHorizontally())) {
      i = 0;
    } else {
      i = 1;
    }
    int j;
    if ((localDimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.FIXED) && (localDimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && ((localDimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || (paramConstraintWidget.mMatchConstraintDefaultHeight != 0) || (paramConstraintWidget.mDimensionRatio != 0.0F) || (!paramConstraintWidget.hasDanglingDimension(1))) && (!paramConstraintWidget.isResolvedVertically())) {
      j = 0;
    } else {
      j = 1;
    }
    if ((paramConstraintWidget.mDimensionRatio > 0.0F) && ((i != 0) || (j != 0))) {
      return true;
    }
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (j != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static void horizontalSolvingPass(ConstraintWidget paramConstraintWidget, BasicMeasure.Measurer paramMeasurer, boolean paramBoolean)
  {
    if ((!(paramConstraintWidget instanceof ConstraintWidgetContainer)) && (paramConstraintWidget.isMeasureRequested()) && (canMeasure(paramConstraintWidget))) {
      ConstraintWidgetContainer.measure(paramConstraintWidget, paramMeasurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    }
    Object localObject2 = paramConstraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
    Object localObject1 = paramConstraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT);
    int k = ((ConstraintAnchor)localObject2).getFinalValue();
    int j = ((ConstraintAnchor)localObject1).getFinalValue();
    Object localObject3;
    boolean bool;
    int i;
    if ((((ConstraintAnchor)localObject2).getDependents() != null) && (((ConstraintAnchor)localObject2).hasFinalValue()))
    {
      localObject2 = ((ConstraintAnchor)localObject2).getDependents().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ConstraintAnchor)((Iterator)localObject2).next();
        ConstraintWidget localConstraintWidget = ((ConstraintAnchor)localObject3).mOwner;
        bool = canMeasure(localConstraintWidget);
        if ((localConstraintWidget.isMeasureRequested()) && (bool)) {
          ConstraintWidgetContainer.measure(localConstraintWidget, paramMeasurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        }
        if ((localConstraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (!bool))
        {
          if ((localConstraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget.mMatchConstraintMaxWidth >= 0) && (localConstraintWidget.mMatchConstraintMinWidth >= 0) && ((localConstraintWidget.getVisibility() == 8) || ((localConstraintWidget.mMatchConstraintDefaultWidth == 0) && (localConstraintWidget.getDimensionRatio() == 0.0F))) && (!localConstraintWidget.isInHorizontalChain()) && (!localConstraintWidget.isInVirtualLayout()))
          {
            if (((localObject3 == localConstraintWidget.mLeft) && (localConstraintWidget.mRight.mTarget != null) && (localConstraintWidget.mRight.mTarget.hasFinalValue())) || ((localObject3 == localConstraintWidget.mRight) && (localConstraintWidget.mLeft.mTarget != null) && (localConstraintWidget.mLeft.mTarget.hasFinalValue()))) {
              i = 1;
            } else {
              i = 0;
            }
            if ((i != 0) && (!localConstraintWidget.isInHorizontalChain())) {
              solveHorizontalMatchConstraint(paramConstraintWidget, paramMeasurer, localConstraintWidget, paramBoolean);
            }
          }
        }
        else if (!localConstraintWidget.isMeasureRequested()) {
          if ((localObject3 == localConstraintWidget.mLeft) && (localConstraintWidget.mRight.mTarget == null))
          {
            i = localConstraintWidget.mLeft.getMargin() + k;
            localConstraintWidget.setFinalHorizontal(i, localConstraintWidget.getWidth() + i);
            horizontalSolvingPass(localConstraintWidget, paramMeasurer, paramBoolean);
          }
          else if ((localObject3 == localConstraintWidget.mRight) && (localConstraintWidget.mLeft.mTarget == null))
          {
            i = k - localConstraintWidget.mRight.getMargin();
            localConstraintWidget.setFinalHorizontal(i - localConstraintWidget.getWidth(), i);
            horizontalSolvingPass(localConstraintWidget, paramMeasurer, paramBoolean);
          }
          else if ((localObject3 == localConstraintWidget.mLeft) && (localConstraintWidget.mRight.mTarget != null) && (localConstraintWidget.mRight.mTarget.hasFinalValue()) && (!localConstraintWidget.isInHorizontalChain()))
          {
            solveHorizontalCenterConstraints(paramMeasurer, localConstraintWidget, paramBoolean);
          }
        }
      }
    }
    if ((paramConstraintWidget instanceof Guideline)) {
      return;
    }
    if ((((ConstraintAnchor)localObject1).getDependents() != null) && (((ConstraintAnchor)localObject1).hasFinalValue()))
    {
      localObject1 = ((ConstraintAnchor)localObject1).getDependents().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ConstraintAnchor)((Iterator)localObject1).next();
        localObject3 = ((ConstraintAnchor)localObject2).mOwner;
        bool = canMeasure((ConstraintWidget)localObject3);
        if ((((ConstraintWidget)localObject3).isMeasureRequested()) && (bool)) {
          ConstraintWidgetContainer.measure((ConstraintWidget)localObject3, paramMeasurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        }
        if (((localObject2 == ((ConstraintWidget)localObject3).mLeft) && (((ConstraintWidget)localObject3).mRight.mTarget != null) && (((ConstraintWidget)localObject3).mRight.mTarget.hasFinalValue())) || ((localObject2 == ((ConstraintWidget)localObject3).mRight) && (((ConstraintWidget)localObject3).mLeft.mTarget != null) && (((ConstraintWidget)localObject3).mLeft.mTarget.hasFinalValue()))) {
          i = 1;
        } else {
          i = 0;
        }
        if ((((ConstraintWidget)localObject3).getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (!bool))
        {
          if ((((ConstraintWidget)localObject3).getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (((ConstraintWidget)localObject3).mMatchConstraintMaxWidth >= 0) && (((ConstraintWidget)localObject3).mMatchConstraintMinWidth >= 0) && ((((ConstraintWidget)localObject3).getVisibility() == 8) || ((((ConstraintWidget)localObject3).mMatchConstraintDefaultWidth == 0) && (((ConstraintWidget)localObject3).getDimensionRatio() == 0.0F))) && (!((ConstraintWidget)localObject3).isInHorizontalChain()) && (!((ConstraintWidget)localObject3).isInVirtualLayout()) && (i != 0) && (!((ConstraintWidget)localObject3).isInHorizontalChain())) {
            solveHorizontalMatchConstraint(paramConstraintWidget, paramMeasurer, (ConstraintWidget)localObject3, paramBoolean);
          }
        }
        else if (!((ConstraintWidget)localObject3).isMeasureRequested()) {
          if ((localObject2 == ((ConstraintWidget)localObject3).mLeft) && (((ConstraintWidget)localObject3).mRight.mTarget == null))
          {
            i = ((ConstraintWidget)localObject3).mLeft.getMargin() + j;
            ((ConstraintWidget)localObject3).setFinalHorizontal(i, ((ConstraintWidget)localObject3).getWidth() + i);
            horizontalSolvingPass((ConstraintWidget)localObject3, paramMeasurer, paramBoolean);
          }
          else if ((localObject2 == ((ConstraintWidget)localObject3).mRight) && (((ConstraintWidget)localObject3).mLeft.mTarget == null))
          {
            i = j - ((ConstraintWidget)localObject3).mRight.getMargin();
            ((ConstraintWidget)localObject3).setFinalHorizontal(i - ((ConstraintWidget)localObject3).getWidth(), i);
            horizontalSolvingPass((ConstraintWidget)localObject3, paramMeasurer, paramBoolean);
          }
          else if ((i != 0) && (!((ConstraintWidget)localObject3).isInHorizontalChain()))
          {
            solveHorizontalCenterConstraints(paramMeasurer, (ConstraintWidget)localObject3, paramBoolean);
          }
        }
      }
    }
  }
  
  private static void solveBarrier(Barrier paramBarrier, BasicMeasure.Measurer paramMeasurer, int paramInt, boolean paramBoolean)
  {
    if (paramBarrier.allSolved())
    {
      if (paramInt == 0)
      {
        horizontalSolvingPass(paramBarrier, paramMeasurer, paramBoolean);
        return;
      }
      verticalSolvingPass(paramBarrier, paramMeasurer);
    }
  }
  
  public static boolean solveChain(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt1, int paramInt2, ChainHead paramChainHead, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool1 = false;
    if (paramBoolean3) {
      return false;
    }
    if (paramInt1 == 0)
    {
      if (!paramConstraintWidgetContainer.isResolvedHorizontally()) {
        return false;
      }
    }
    else if (!paramConstraintWidgetContainer.isResolvedVertically()) {
      return false;
    }
    boolean bool2 = paramConstraintWidgetContainer.isRtl();
    Object localObject1 = paramChainHead.getFirst();
    Object localObject2 = paramChainHead.getLast();
    ConstraintWidget localConstraintWidget1 = paramChainHead.getFirstVisibleWidget();
    ConstraintWidget localConstraintWidget2 = paramChainHead.getLastVisibleWidget();
    ConstraintWidget localConstraintWidget3 = paramChainHead.getHead();
    paramChainHead = localObject1.mListAnchors[paramInt2];
    localObject2 = ((ConstraintWidget)localObject2).mListAnchors;
    int i1 = paramInt2 + 1;
    localObject2 = localObject2[i1];
    paramBoolean3 = bool1;
    if (paramChainHead.mTarget != null)
    {
      if (((ConstraintAnchor)localObject2).mTarget == null) {
        return false;
      }
      paramBoolean3 = bool1;
      if (paramChainHead.mTarget.hasFinalValue())
      {
        if (!((ConstraintAnchor)localObject2).mTarget.hasFinalValue()) {
          return false;
        }
        paramBoolean3 = bool1;
        if (localConstraintWidget1 != null)
        {
          if (localConstraintWidget2 == null) {
            return false;
          }
          int i2 = paramChainHead.mTarget.getFinalValue() + localConstraintWidget1.mListAnchors[paramInt2].getMargin();
          int i3 = ((ConstraintAnchor)localObject2).mTarget.getFinalValue() - localConstraintWidget2.mListAnchors[i1].getMargin();
          int i4 = i3 - i2;
          if (i4 <= 0) {
            return false;
          }
          BasicMeasure.Measure localMeasure = new BasicMeasure.Measure();
          localObject2 = localObject1;
          int i = 0;
          int j = 0;
          int k = 0;
          int m = 0;
          paramChainHead = (ChainHead)localObject1;
          for (;;)
          {
            Object localObject3 = null;
            if (i != 0) {
              break;
            }
            localObject1 = localObject2.mListAnchors[paramInt2];
            if (!canMeasure((ConstraintWidget)localObject2)) {
              return false;
            }
            if (localObject2.mListDimensionBehaviors[paramInt1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
              return false;
            }
            if (((ConstraintWidget)localObject2).isMeasureRequested()) {
              ConstraintWidgetContainer.measure((ConstraintWidget)localObject2, paramConstraintWidgetContainer.getMeasurer(), localMeasure, BasicMeasure.Measure.SELF_DIMENSIONS);
            }
            int i5 = localObject2.mListAnchors[paramInt2].getMargin();
            if (paramInt1 == 0) {
              n = ((ConstraintWidget)localObject2).getWidth();
            } else {
              n = ((ConstraintWidget)localObject2).getHeight();
            }
            m = m + i5 + n + localObject2.mListAnchors[i1].getMargin();
            int n = k + 1;
            k = j;
            if (((ConstraintWidget)localObject2).getVisibility() != 8) {
              k = j + 1;
            }
            Object localObject4 = localObject2.mListAnchors[i1].mTarget;
            localObject1 = localObject3;
            if (localObject4 != null)
            {
              localObject4 = ((ConstraintAnchor)localObject4).mOwner;
              localObject1 = localObject3;
              if (localObject4.mListAnchors[paramInt2].mTarget != null) {
                if (localObject4.mListAnchors[paramInt2].mTarget.mOwner != localObject2) {
                  localObject1 = localObject3;
                } else {
                  localObject1 = localObject4;
                }
              }
            }
            if (localObject1 != null) {
              localObject2 = localObject1;
            } else {
              i = 1;
            }
            j = k;
            k = n;
          }
          if (j == 0) {
            return false;
          }
          if (j != k) {
            return false;
          }
          if (i4 < m) {
            return false;
          }
          k = i4 - m;
          if (paramBoolean1) {
            i = k / (j + 1);
          }
          for (;;)
          {
            break;
            i = k;
            if (paramBoolean2)
            {
              i = k;
              if (j > 2) {
                i = k / j - 1;
              }
            }
          }
          if (j == 1)
          {
            float f;
            if (paramInt1 == 0) {
              f = localConstraintWidget3.getHorizontalBiasPercent();
            } else {
              f = localConstraintWidget3.getVerticalBiasPercent();
            }
            paramInt2 = (int)(i2 + 0.5F + i * f);
            if (paramInt1 == 0) {
              localConstraintWidget1.setFinalHorizontal(paramInt2, localConstraintWidget1.getWidth() + paramInt2);
            } else {
              localConstraintWidget1.setFinalVertical(paramInt2, localConstraintWidget1.getHeight() + paramInt2);
            }
            horizontalSolvingPass(localConstraintWidget1, paramConstraintWidgetContainer.getMeasurer(), bool2);
            return true;
          }
          if (paramBoolean1)
          {
            k = i2 + i;
            j = 0;
            localObject1 = paramChainHead;
            while (j == 0)
            {
              paramChainHead = localObject1.mListAnchors[paramInt2];
              if (((ConstraintWidget)localObject1).getVisibility() == 8) {
                if (paramInt1 == 0)
                {
                  ((ConstraintWidget)localObject1).setFinalHorizontal(k, k);
                  horizontalSolvingPass((ConstraintWidget)localObject1, paramConstraintWidgetContainer.getMeasurer(), bool2);
                }
                else
                {
                  ((ConstraintWidget)localObject1).setFinalVertical(k, k);
                  verticalSolvingPass((ConstraintWidget)localObject1, paramConstraintWidgetContainer.getMeasurer());
                }
              }
              for (;;)
              {
                break;
                m = k + localObject1.mListAnchors[paramInt2].getMargin();
                if (paramInt1 == 0)
                {
                  ((ConstraintWidget)localObject1).setFinalHorizontal(m, ((ConstraintWidget)localObject1).getWidth() + m);
                  horizontalSolvingPass((ConstraintWidget)localObject1, paramConstraintWidgetContainer.getMeasurer(), bool2);
                  k = ((ConstraintWidget)localObject1).getWidth();
                }
                else
                {
                  ((ConstraintWidget)localObject1).setFinalVertical(m, ((ConstraintWidget)localObject1).getHeight() + m);
                  verticalSolvingPass((ConstraintWidget)localObject1, paramConstraintWidgetContainer.getMeasurer());
                  k = ((ConstraintWidget)localObject1).getHeight();
                }
                k = m + k + localObject1.mListAnchors[i1].getMargin() + i;
              }
              ((ConstraintWidget)localObject1).addToSolver(paramLinearSystem, false);
              paramChainHead = localObject1.mListAnchors[i1].mTarget;
              if (paramChainHead != null)
              {
                localObject2 = paramChainHead.mOwner;
                if (localObject2.mListAnchors[paramInt2].mTarget != null)
                {
                  paramChainHead = (ChainHead)localObject2;
                  if (localObject2.mListAnchors[paramInt2].mTarget.mOwner == localObject1) {
                    break label937;
                  }
                }
              }
              paramChainHead = null;
              label937:
              if (paramChainHead != null) {
                localObject1 = paramChainHead;
              } else {
                j = 1;
              }
            }
          }
          if (paramBoolean2)
          {
            if (j == 2)
            {
              if (paramInt1 == 0)
              {
                localConstraintWidget1.setFinalHorizontal(i2, localConstraintWidget1.getWidth() + i2);
                localConstraintWidget2.setFinalHorizontal(i3 - localConstraintWidget2.getWidth(), i3);
                horizontalSolvingPass(localConstraintWidget1, paramConstraintWidgetContainer.getMeasurer(), bool2);
                horizontalSolvingPass(localConstraintWidget2, paramConstraintWidgetContainer.getMeasurer(), bool2);
              }
              else
              {
                localConstraintWidget1.setFinalVertical(i2, localConstraintWidget1.getHeight() + i2);
                localConstraintWidget2.setFinalVertical(i3 - localConstraintWidget2.getHeight(), i3);
                verticalSolvingPass(localConstraintWidget1, paramConstraintWidgetContainer.getMeasurer());
                verticalSolvingPass(localConstraintWidget2, paramConstraintWidgetContainer.getMeasurer());
              }
              return true;
            }
            return false;
          }
          paramBoolean3 = true;
        }
      }
    }
    return paramBoolean3;
  }
  
  private static void solveHorizontalCenterConstraints(BasicMeasure.Measurer paramMeasurer, ConstraintWidget paramConstraintWidget, boolean paramBoolean)
  {
    float f = paramConstraintWidget.getHorizontalBiasPercent();
    int i = paramConstraintWidget.mLeft.mTarget.getFinalValue();
    int j = paramConstraintWidget.mRight.mTarget.getFinalValue();
    int m = paramConstraintWidget.mLeft.getMargin();
    int k = paramConstraintWidget.mRight.getMargin();
    if (i == j)
    {
      f = 0.5F;
    }
    else
    {
      i = m + i;
      j -= k;
    }
    m = paramConstraintWidget.getWidth();
    k = j - i - m;
    if (i > j) {
      k = i - j - m;
    }
    int n = (int)(f * k + 0.5F) + i;
    k = n + m;
    if (i > j) {
      k = n - m;
    }
    paramConstraintWidget.setFinalHorizontal(n, k);
    horizontalSolvingPass(paramConstraintWidget, paramMeasurer, paramBoolean);
  }
  
  private static void solveHorizontalMatchConstraint(ConstraintWidget paramConstraintWidget1, BasicMeasure.Measurer paramMeasurer, ConstraintWidget paramConstraintWidget2, boolean paramBoolean)
  {
    float f = paramConstraintWidget2.getHorizontalBiasPercent();
    int k = paramConstraintWidget2.mLeft.mTarget.getFinalValue() + paramConstraintWidget2.mLeft.getMargin();
    int m = paramConstraintWidget2.mRight.mTarget.getFinalValue() - paramConstraintWidget2.mRight.getMargin();
    if (m >= k)
    {
      int j = paramConstraintWidget2.getWidth();
      int i = j;
      if (paramConstraintWidget2.getVisibility() != 8)
      {
        if (paramConstraintWidget2.mMatchConstraintDefaultWidth == 2)
        {
          if ((paramConstraintWidget1 instanceof ConstraintWidgetContainer)) {
            i = paramConstraintWidget1.getWidth();
          } else {
            i = paramConstraintWidget1.getParent().getWidth();
          }
          i = (int)(paramConstraintWidget2.getHorizontalBiasPercent() * 0.5F * i);
        }
        else
        {
          i = j;
          if (paramConstraintWidget2.mMatchConstraintDefaultWidth == 0) {
            i = m - k;
          }
        }
        j = Math.max(paramConstraintWidget2.mMatchConstraintMinWidth, i);
        i = j;
        if (paramConstraintWidget2.mMatchConstraintMaxWidth > 0) {
          i = Math.min(paramConstraintWidget2.mMatchConstraintMaxWidth, j);
        }
      }
      j = k + (int)(f * (m - k - i) + 0.5F);
      paramConstraintWidget2.setFinalHorizontal(j, i + j);
      horizontalSolvingPass(paramConstraintWidget2, paramMeasurer, paramBoolean);
    }
  }
  
  private static void solveVerticalCenterConstraints(BasicMeasure.Measurer paramMeasurer, ConstraintWidget paramConstraintWidget)
  {
    float f = paramConstraintWidget.getVerticalBiasPercent();
    int i = paramConstraintWidget.mTop.mTarget.getFinalValue();
    int j = paramConstraintWidget.mBottom.mTarget.getFinalValue();
    int m = paramConstraintWidget.mTop.getMargin();
    int k = paramConstraintWidget.mBottom.getMargin();
    if (i == j)
    {
      f = 0.5F;
    }
    else
    {
      i = m + i;
      j -= k;
    }
    int n = paramConstraintWidget.getHeight();
    k = j - i - n;
    if (i > j) {
      k = i - j - n;
    }
    int i1 = (int)(f * k + 0.5F);
    k = i + i1;
    m = k + n;
    if (i > j)
    {
      k = i - i1;
      m = k - n;
    }
    paramConstraintWidget.setFinalVertical(k, m);
    verticalSolvingPass(paramConstraintWidget, paramMeasurer);
  }
  
  private static void solveVerticalMatchConstraint(ConstraintWidget paramConstraintWidget1, BasicMeasure.Measurer paramMeasurer, ConstraintWidget paramConstraintWidget2)
  {
    float f = paramConstraintWidget2.getVerticalBiasPercent();
    int k = paramConstraintWidget2.mTop.mTarget.getFinalValue() + paramConstraintWidget2.mTop.getMargin();
    int m = paramConstraintWidget2.mBottom.mTarget.getFinalValue() - paramConstraintWidget2.mBottom.getMargin();
    if (m >= k)
    {
      int j = paramConstraintWidget2.getHeight();
      int i = j;
      if (paramConstraintWidget2.getVisibility() != 8)
      {
        if (paramConstraintWidget2.mMatchConstraintDefaultHeight == 2)
        {
          if ((paramConstraintWidget1 instanceof ConstraintWidgetContainer)) {
            i = paramConstraintWidget1.getHeight();
          } else {
            i = paramConstraintWidget1.getParent().getHeight();
          }
          i = (int)(f * 0.5F * i);
        }
        else
        {
          i = j;
          if (paramConstraintWidget2.mMatchConstraintDefaultHeight == 0) {
            i = m - k;
          }
        }
        j = Math.max(paramConstraintWidget2.mMatchConstraintMinHeight, i);
        i = j;
        if (paramConstraintWidget2.mMatchConstraintMaxHeight > 0) {
          i = Math.min(paramConstraintWidget2.mMatchConstraintMaxHeight, j);
        }
      }
      j = k + (int)(f * (m - k - i) + 0.5F);
      paramConstraintWidget2.setFinalVertical(j, i + j);
      verticalSolvingPass(paramConstraintWidget2, paramMeasurer);
    }
  }
  
  public static void solvingPass(ConstraintWidgetContainer paramConstraintWidgetContainer, BasicMeasure.Measurer paramMeasurer)
  {
    Object localObject2 = paramConstraintWidgetContainer.getHorizontalDimensionBehaviour();
    Object localObject1 = paramConstraintWidgetContainer.getVerticalDimensionBehaviour();
    paramConstraintWidgetContainer.resetFinalResolution();
    ArrayList localArrayList = paramConstraintWidgetContainer.getChildren();
    int i2 = localArrayList.size();
    int i1 = 0;
    int i = 0;
    while (i < i2)
    {
      ((ConstraintWidget)localArrayList.get(i)).resetFinalResolution();
      i += 1;
    }
    boolean bool = paramConstraintWidgetContainer.isRtl();
    if (localObject2 == ConstraintWidget.DimensionBehaviour.FIXED) {
      paramConstraintWidgetContainer.setFinalHorizontal(0, paramConstraintWidgetContainer.getWidth());
    } else {
      paramConstraintWidgetContainer.setFinalLeft(0);
    }
    int j = 0;
    int k = 0;
    int m;
    int n;
    for (i = 0; j < i2; i = n)
    {
      localObject2 = (ConstraintWidget)localArrayList.get(j);
      if ((localObject2 instanceof Guideline))
      {
        localObject2 = (Guideline)localObject2;
        m = k;
        n = i;
        if (((Guideline)localObject2).getOrientation() == 1)
        {
          if (((Guideline)localObject2).getRelativeBegin() != -1) {
            ((Guideline)localObject2).setFinalValue(((Guideline)localObject2).getRelativeBegin());
          } else if ((((Guideline)localObject2).getRelativeEnd() != -1) && (paramConstraintWidgetContainer.isResolvedHorizontally())) {
            ((Guideline)localObject2).setFinalValue(paramConstraintWidgetContainer.getWidth() - ((Guideline)localObject2).getRelativeEnd());
          } else if (paramConstraintWidgetContainer.isResolvedHorizontally()) {
            ((Guideline)localObject2).setFinalValue((int)(((Guideline)localObject2).getRelativePercent() * paramConstraintWidgetContainer.getWidth() + 0.5F));
          }
          m = 1;
          n = i;
        }
      }
      else
      {
        m = k;
        n = i;
        if ((localObject2 instanceof Barrier))
        {
          m = k;
          n = i;
          if (((Barrier)localObject2).getOrientation() == 0)
          {
            n = 1;
            m = k;
          }
        }
      }
      j += 1;
      k = m;
    }
    if (k != 0)
    {
      j = 0;
      while (j < i2)
      {
        localObject2 = (ConstraintWidget)localArrayList.get(j);
        if ((localObject2 instanceof Guideline))
        {
          localObject2 = (Guideline)localObject2;
          if (((Guideline)localObject2).getOrientation() == 1) {
            horizontalSolvingPass((ConstraintWidget)localObject2, paramMeasurer, bool);
          }
        }
        j += 1;
      }
    }
    horizontalSolvingPass(paramConstraintWidgetContainer, paramMeasurer, bool);
    if (i != 0)
    {
      i = 0;
      while (i < i2)
      {
        localObject2 = (ConstraintWidget)localArrayList.get(i);
        if ((localObject2 instanceof Barrier))
        {
          localObject2 = (Barrier)localObject2;
          if (((Barrier)localObject2).getOrientation() == 0) {
            solveBarrier((Barrier)localObject2, paramMeasurer, 0, bool);
          }
        }
        i += 1;
      }
    }
    if (localObject1 == ConstraintWidget.DimensionBehaviour.FIXED) {
      paramConstraintWidgetContainer.setFinalVertical(0, paramConstraintWidgetContainer.getHeight());
    } else {
      paramConstraintWidgetContainer.setFinalTop(0);
    }
    j = 0;
    k = 0;
    for (i = 0; j < i2; i = n)
    {
      localObject1 = (ConstraintWidget)localArrayList.get(j);
      if ((localObject1 instanceof Guideline))
      {
        localObject1 = (Guideline)localObject1;
        m = k;
        n = i;
        if (((Guideline)localObject1).getOrientation() == 0)
        {
          if (((Guideline)localObject1).getRelativeBegin() != -1) {
            ((Guideline)localObject1).setFinalValue(((Guideline)localObject1).getRelativeBegin());
          } else if ((((Guideline)localObject1).getRelativeEnd() != -1) && (paramConstraintWidgetContainer.isResolvedVertically())) {
            ((Guideline)localObject1).setFinalValue(paramConstraintWidgetContainer.getHeight() - ((Guideline)localObject1).getRelativeEnd());
          } else if (paramConstraintWidgetContainer.isResolvedVertically()) {
            ((Guideline)localObject1).setFinalValue((int)(((Guideline)localObject1).getRelativePercent() * paramConstraintWidgetContainer.getHeight() + 0.5F));
          }
          m = 1;
          n = i;
        }
      }
      else
      {
        m = k;
        n = i;
        if ((localObject1 instanceof Barrier))
        {
          m = k;
          n = i;
          if (((Barrier)localObject1).getOrientation() == 1)
          {
            n = 1;
            m = k;
          }
        }
      }
      j += 1;
      k = m;
    }
    if (k != 0)
    {
      j = 0;
      while (j < i2)
      {
        localObject1 = (ConstraintWidget)localArrayList.get(j);
        if ((localObject1 instanceof Guideline))
        {
          localObject1 = (Guideline)localObject1;
          if (((Guideline)localObject1).getOrientation() == 0) {
            verticalSolvingPass((ConstraintWidget)localObject1, paramMeasurer);
          }
        }
        j += 1;
      }
    }
    verticalSolvingPass(paramConstraintWidgetContainer, paramMeasurer);
    j = i1;
    if (i != 0)
    {
      i = 0;
      for (;;)
      {
        j = i1;
        if (i >= i2) {
          break;
        }
        paramConstraintWidgetContainer = (ConstraintWidget)localArrayList.get(i);
        if ((paramConstraintWidgetContainer instanceof Barrier))
        {
          paramConstraintWidgetContainer = (Barrier)paramConstraintWidgetContainer;
          if (paramConstraintWidgetContainer.getOrientation() == 1) {
            solveBarrier(paramConstraintWidgetContainer, paramMeasurer, 1, bool);
          }
        }
        i += 1;
      }
    }
    while (j < i2)
    {
      paramConstraintWidgetContainer = (ConstraintWidget)localArrayList.get(j);
      if ((paramConstraintWidgetContainer.isMeasureRequested()) && (canMeasure(paramConstraintWidgetContainer)))
      {
        ConstraintWidgetContainer.measure(paramConstraintWidgetContainer, paramMeasurer, measure, BasicMeasure.Measure.SELF_DIMENSIONS);
        horizontalSolvingPass(paramConstraintWidgetContainer, paramMeasurer, bool);
        verticalSolvingPass(paramConstraintWidgetContainer, paramMeasurer);
      }
      j += 1;
    }
  }
  
  private static void verticalSolvingPass(ConstraintWidget paramConstraintWidget, BasicMeasure.Measurer paramMeasurer)
  {
    if ((!(paramConstraintWidget instanceof ConstraintWidgetContainer)) && (paramConstraintWidget.isMeasureRequested()) && (canMeasure(paramConstraintWidget))) {
      ConstraintWidgetContainer.measure(paramConstraintWidget, paramMeasurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    }
    Object localObject2 = paramConstraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
    Object localObject1 = paramConstraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM);
    int k = ((ConstraintAnchor)localObject2).getFinalValue();
    int j = ((ConstraintAnchor)localObject1).getFinalValue();
    Object localObject3;
    boolean bool;
    int i;
    if ((((ConstraintAnchor)localObject2).getDependents() != null) && (((ConstraintAnchor)localObject2).hasFinalValue()))
    {
      localObject2 = ((ConstraintAnchor)localObject2).getDependents().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ConstraintAnchor)((Iterator)localObject2).next();
        ConstraintWidget localConstraintWidget = ((ConstraintAnchor)localObject3).mOwner;
        bool = canMeasure(localConstraintWidget);
        if ((localConstraintWidget.isMeasureRequested()) && (bool)) {
          ConstraintWidgetContainer.measure(localConstraintWidget, paramMeasurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        }
        if ((localConstraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (!bool))
        {
          if ((localConstraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget.mMatchConstraintMaxHeight >= 0) && (localConstraintWidget.mMatchConstraintMinHeight >= 0) && ((localConstraintWidget.getVisibility() == 8) || ((localConstraintWidget.mMatchConstraintDefaultHeight == 0) && (localConstraintWidget.getDimensionRatio() == 0.0F))) && (!localConstraintWidget.isInVerticalChain()) && (!localConstraintWidget.isInVirtualLayout()))
          {
            if (((localObject3 == localConstraintWidget.mTop) && (localConstraintWidget.mBottom.mTarget != null) && (localConstraintWidget.mBottom.mTarget.hasFinalValue())) || ((localObject3 == localConstraintWidget.mBottom) && (localConstraintWidget.mTop.mTarget != null) && (localConstraintWidget.mTop.mTarget.hasFinalValue()))) {
              i = 1;
            } else {
              i = 0;
            }
            if ((i != 0) && (!localConstraintWidget.isInVerticalChain())) {
              solveVerticalMatchConstraint(paramConstraintWidget, paramMeasurer, localConstraintWidget);
            }
          }
        }
        else if (!localConstraintWidget.isMeasureRequested()) {
          if ((localObject3 == localConstraintWidget.mTop) && (localConstraintWidget.mBottom.mTarget == null))
          {
            i = localConstraintWidget.mTop.getMargin() + k;
            localConstraintWidget.setFinalVertical(i, localConstraintWidget.getHeight() + i);
            verticalSolvingPass(localConstraintWidget, paramMeasurer);
          }
          else if ((localObject3 == localConstraintWidget.mBottom) && (localConstraintWidget.mBottom.mTarget == null))
          {
            i = k - localConstraintWidget.mBottom.getMargin();
            localConstraintWidget.setFinalVertical(i - localConstraintWidget.getHeight(), i);
            verticalSolvingPass(localConstraintWidget, paramMeasurer);
          }
          else if ((localObject3 == localConstraintWidget.mTop) && (localConstraintWidget.mBottom.mTarget != null) && (localConstraintWidget.mBottom.mTarget.hasFinalValue()))
          {
            solveVerticalCenterConstraints(paramMeasurer, localConstraintWidget);
          }
        }
      }
    }
    if ((paramConstraintWidget instanceof Guideline)) {
      return;
    }
    if ((((ConstraintAnchor)localObject1).getDependents() != null) && (((ConstraintAnchor)localObject1).hasFinalValue()))
    {
      localObject1 = ((ConstraintAnchor)localObject1).getDependents().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ConstraintAnchor)((Iterator)localObject1).next();
        localObject3 = ((ConstraintAnchor)localObject2).mOwner;
        bool = canMeasure((ConstraintWidget)localObject3);
        if ((((ConstraintWidget)localObject3).isMeasureRequested()) && (bool)) {
          ConstraintWidgetContainer.measure((ConstraintWidget)localObject3, paramMeasurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        }
        if (((localObject2 == ((ConstraintWidget)localObject3).mTop) && (((ConstraintWidget)localObject3).mBottom.mTarget != null) && (((ConstraintWidget)localObject3).mBottom.mTarget.hasFinalValue())) || ((localObject2 == ((ConstraintWidget)localObject3).mBottom) && (((ConstraintWidget)localObject3).mTop.mTarget != null) && (((ConstraintWidget)localObject3).mTop.mTarget.hasFinalValue()))) {
          i = 1;
        } else {
          i = 0;
        }
        if ((((ConstraintWidget)localObject3).getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (!bool))
        {
          if ((((ConstraintWidget)localObject3).getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (((ConstraintWidget)localObject3).mMatchConstraintMaxHeight >= 0) && (((ConstraintWidget)localObject3).mMatchConstraintMinHeight >= 0) && ((((ConstraintWidget)localObject3).getVisibility() == 8) || ((((ConstraintWidget)localObject3).mMatchConstraintDefaultHeight == 0) && (((ConstraintWidget)localObject3).getDimensionRatio() == 0.0F))) && (!((ConstraintWidget)localObject3).isInVerticalChain()) && (!((ConstraintWidget)localObject3).isInVirtualLayout()) && (i != 0) && (!((ConstraintWidget)localObject3).isInVerticalChain())) {
            solveVerticalMatchConstraint(paramConstraintWidget, paramMeasurer, (ConstraintWidget)localObject3);
          }
        }
        else if (!((ConstraintWidget)localObject3).isMeasureRequested()) {
          if ((localObject2 == ((ConstraintWidget)localObject3).mTop) && (((ConstraintWidget)localObject3).mBottom.mTarget == null))
          {
            i = ((ConstraintWidget)localObject3).mTop.getMargin() + j;
            ((ConstraintWidget)localObject3).setFinalVertical(i, ((ConstraintWidget)localObject3).getHeight() + i);
            verticalSolvingPass((ConstraintWidget)localObject3, paramMeasurer);
          }
          else if ((localObject2 == ((ConstraintWidget)localObject3).mBottom) && (((ConstraintWidget)localObject3).mTop.mTarget == null))
          {
            i = j - ((ConstraintWidget)localObject3).mBottom.getMargin();
            ((ConstraintWidget)localObject3).setFinalVertical(i - ((ConstraintWidget)localObject3).getHeight(), i);
            verticalSolvingPass((ConstraintWidget)localObject3, paramMeasurer);
          }
          else if ((i != 0) && (!((ConstraintWidget)localObject3).isInVerticalChain()))
          {
            solveVerticalCenterConstraints(paramMeasurer, (ConstraintWidget)localObject3);
          }
        }
      }
    }
    paramConstraintWidget = paramConstraintWidget.getAnchor(ConstraintAnchor.Type.BASELINE);
    if ((paramConstraintWidget.getDependents() != null) && (paramConstraintWidget.hasFinalValue()))
    {
      i = paramConstraintWidget.getFinalValue();
      paramConstraintWidget = paramConstraintWidget.getDependents().iterator();
    }
    for (;;)
    {
      if (paramConstraintWidget.hasNext())
      {
        localObject1 = (ConstraintAnchor)paramConstraintWidget.next();
        localObject2 = ((ConstraintAnchor)localObject1).mOwner;
        bool = canMeasure((ConstraintWidget)localObject2);
        if ((((ConstraintWidget)localObject2).isMeasureRequested()) && (bool)) {
          ConstraintWidgetContainer.measure((ConstraintWidget)localObject2, paramMeasurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        }
        if (((((ConstraintWidget)localObject2).getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || (bool)) && (!((ConstraintWidget)localObject2).isMeasureRequested()) && (localObject1 == ((ConstraintWidget)localObject2).mBaseline)) {
          ((ConstraintWidget)localObject2).setFinalBaseline(i);
        }
      }
      try
      {
        verticalSolvingPass((ConstraintWidget)localObject2, paramMeasurer);
      }
      catch (Throwable paramConstraintWidget)
      {
        break label1101;
      }
    }
    return;
    label1101:
    for (;;)
    {
      throw paramConstraintWidget;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.analyzer.Direct
 * JD-Core Version:    0.7.0.1
 */