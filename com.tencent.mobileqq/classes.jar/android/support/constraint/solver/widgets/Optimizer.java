package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;

public class Optimizer
{
  static void applyDirectResolutionHorizontalChain(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt, ConstraintWidget paramConstraintWidget)
  {
    Object localObject1 = paramConstraintWidget;
    Object localObject3 = null;
    int m = 0;
    float f2 = 0.0F;
    int i;
    int j;
    Object localObject2;
    for (int k = 0;; k = j)
    {
      int n = 1;
      if (localObject1 == null) {
        break;
      }
      if (((ConstraintWidget)localObject1).getVisibility() != 8) {
        n = 0;
      }
      i = m;
      f1 = f2;
      j = k;
      if (n == 0)
      {
        m += 1;
        if (((ConstraintWidget)localObject1).mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
        {
          n = ((ConstraintWidget)localObject1).getWidth();
          if (((ConstraintWidget)localObject1).mLeft.mTarget != null) {
            i = ((ConstraintWidget)localObject1).mLeft.getMargin();
          } else {
            i = 0;
          }
          if (((ConstraintWidget)localObject1).mRight.mTarget != null) {
            j = ((ConstraintWidget)localObject1).mRight.getMargin();
          } else {
            j = 0;
          }
          j = k + n + i + j;
          i = m;
          f1 = f2;
        }
        else
        {
          f1 = f2 + ((ConstraintWidget)localObject1).mHorizontalWeight;
          j = k;
          i = m;
        }
      }
      if (((ConstraintWidget)localObject1).mRight.mTarget != null) {
        localObject3 = ((ConstraintWidget)localObject1).mRight.mTarget.mOwner;
      } else {
        localObject3 = null;
      }
      localObject2 = localObject3;
      if (localObject3 != null) {
        if (((ConstraintWidget)localObject3).mLeft.mTarget != null)
        {
          localObject2 = localObject3;
          if (((ConstraintWidget)localObject3).mLeft.mTarget != null)
          {
            localObject2 = localObject3;
            if (((ConstraintWidget)localObject3).mLeft.mTarget.mOwner == localObject1) {}
          }
        }
        else
        {
          localObject2 = null;
        }
      }
      localObject3 = localObject1;
      localObject1 = localObject2;
      m = i;
      f2 = f1;
    }
    if (localObject3 != null)
    {
      if (((ConstraintWidget)localObject3).mRight.mTarget != null) {
        i = ((ConstraintWidget)localObject3).mRight.mTarget.mOwner.getX();
      } else {
        i = 0;
      }
      j = i;
      if (((ConstraintWidget)localObject3).mRight.mTarget != null)
      {
        j = i;
        if (((ConstraintWidget)localObject3).mRight.mTarget.mOwner == paramConstraintWidgetContainer) {
          j = paramConstraintWidgetContainer.getRight();
        }
      }
    }
    else
    {
      j = 0;
    }
    float f5 = j - 0 - k;
    float f1 = f5 / (m + 1);
    float f3;
    if (paramInt == 0)
    {
      f3 = f1;
    }
    else
    {
      f3 = f5 / paramInt;
      f1 = 0.0F;
    }
    while (paramConstraintWidget != null)
    {
      if (paramConstraintWidget.mLeft.mTarget != null) {
        i = paramConstraintWidget.mLeft.getMargin();
      } else {
        i = 0;
      }
      if (paramConstraintWidget.mRight.mTarget != null) {
        j = paramConstraintWidget.mRight.getMargin();
      } else {
        j = 0;
      }
      float f4;
      if (paramConstraintWidget.getVisibility() != 8)
      {
        float f6 = i;
        f4 = f1 + f6;
        paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, (int)(f4 + 0.5F));
        if (paramConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
        {
          if (f2 == 0.0F) {
            f1 = f3 - f6;
          } else {
            f1 = paramConstraintWidget.mHorizontalWeight * f5 / f2 - f6;
          }
          f1 -= j;
        }
        else
        {
          f1 = paramConstraintWidget.getWidth();
        }
        f4 += f1;
        paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, (int)(0.5F + f4));
        f1 = f4;
        if (paramInt == 0) {
          f1 = f4 + f3;
        }
        f1 += j;
      }
      else
      {
        f4 = f3 / 2.0F;
        localObject1 = paramConstraintWidget.mLeft.mSolverVariable;
        i = (int)(f1 - f4 + 0.5F);
        paramLinearSystem.addEquality((SolverVariable)localObject1, i);
        paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, i);
      }
      if (paramConstraintWidget.mRight.mTarget != null) {
        localObject1 = paramConstraintWidget.mRight.mTarget.mOwner;
      } else {
        localObject1 = null;
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((ConstraintWidget)localObject1).mLeft.mTarget != null)
        {
          localObject2 = localObject1;
          if (((ConstraintWidget)localObject1).mLeft.mTarget.mOwner != paramConstraintWidget) {
            localObject2 = null;
          }
        }
      }
      if (localObject2 == paramConstraintWidgetContainer) {
        paramConstraintWidget = null;
      } else {
        paramConstraintWidget = localObject2;
      }
    }
  }
  
  static void applyDirectResolutionVerticalChain(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt, ConstraintWidget paramConstraintWidget)
  {
    Object localObject1 = paramConstraintWidget;
    Object localObject3 = null;
    int m = 0;
    float f2 = 0.0F;
    int i;
    int j;
    Object localObject2;
    for (int k = 0;; k = j)
    {
      int n = 1;
      if (localObject1 == null) {
        break;
      }
      if (((ConstraintWidget)localObject1).getVisibility() != 8) {
        n = 0;
      }
      i = m;
      f1 = f2;
      j = k;
      if (n == 0)
      {
        m += 1;
        if (((ConstraintWidget)localObject1).mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
        {
          n = ((ConstraintWidget)localObject1).getHeight();
          if (((ConstraintWidget)localObject1).mTop.mTarget != null) {
            i = ((ConstraintWidget)localObject1).mTop.getMargin();
          } else {
            i = 0;
          }
          if (((ConstraintWidget)localObject1).mBottom.mTarget != null) {
            j = ((ConstraintWidget)localObject1).mBottom.getMargin();
          } else {
            j = 0;
          }
          j = k + n + i + j;
          i = m;
          f1 = f2;
        }
        else
        {
          f1 = f2 + ((ConstraintWidget)localObject1).mVerticalWeight;
          j = k;
          i = m;
        }
      }
      if (((ConstraintWidget)localObject1).mBottom.mTarget != null) {
        localObject3 = ((ConstraintWidget)localObject1).mBottom.mTarget.mOwner;
      } else {
        localObject3 = null;
      }
      localObject2 = localObject3;
      if (localObject3 != null) {
        if (((ConstraintWidget)localObject3).mTop.mTarget != null)
        {
          localObject2 = localObject3;
          if (((ConstraintWidget)localObject3).mTop.mTarget != null)
          {
            localObject2 = localObject3;
            if (((ConstraintWidget)localObject3).mTop.mTarget.mOwner == localObject1) {}
          }
        }
        else
        {
          localObject2 = null;
        }
      }
      localObject3 = localObject1;
      localObject1 = localObject2;
      m = i;
      f2 = f1;
    }
    if (localObject3 != null)
    {
      if (((ConstraintWidget)localObject3).mBottom.mTarget != null) {
        i = ((ConstraintWidget)localObject3).mBottom.mTarget.mOwner.getX();
      } else {
        i = 0;
      }
      j = i;
      if (((ConstraintWidget)localObject3).mBottom.mTarget != null)
      {
        j = i;
        if (((ConstraintWidget)localObject3).mBottom.mTarget.mOwner == paramConstraintWidgetContainer) {
          j = paramConstraintWidgetContainer.getBottom();
        }
      }
    }
    else
    {
      j = 0;
    }
    float f5 = j - 0 - k;
    float f1 = f5 / (m + 1);
    float f3;
    if (paramInt == 0)
    {
      f3 = f1;
    }
    else
    {
      f3 = f5 / paramInt;
      f1 = 0.0F;
    }
    while (paramConstraintWidget != null)
    {
      if (paramConstraintWidget.mTop.mTarget != null) {
        i = paramConstraintWidget.mTop.getMargin();
      } else {
        i = 0;
      }
      if (paramConstraintWidget.mBottom.mTarget != null) {
        j = paramConstraintWidget.mBottom.getMargin();
      } else {
        j = 0;
      }
      float f4;
      if (paramConstraintWidget.getVisibility() != 8)
      {
        float f6 = i;
        f4 = f1 + f6;
        paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, (int)(f4 + 0.5F));
        if (paramConstraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
        {
          if (f2 == 0.0F) {
            f1 = f3 - f6;
          } else {
            f1 = paramConstraintWidget.mVerticalWeight * f5 / f2 - f6;
          }
          f1 -= j;
        }
        else
        {
          f1 = paramConstraintWidget.getHeight();
        }
        f4 += f1;
        paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, (int)(0.5F + f4));
        f1 = f4;
        if (paramInt == 0) {
          f1 = f4 + f3;
        }
        f1 += j;
      }
      else
      {
        f4 = f3 / 2.0F;
        localObject1 = paramConstraintWidget.mTop.mSolverVariable;
        i = (int)(f1 - f4 + 0.5F);
        paramLinearSystem.addEquality((SolverVariable)localObject1, i);
        paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, i);
      }
      if (paramConstraintWidget.mBottom.mTarget != null) {
        localObject1 = paramConstraintWidget.mBottom.mTarget.mOwner;
      } else {
        localObject1 = null;
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((ConstraintWidget)localObject1).mTop.mTarget != null)
        {
          localObject2 = localObject1;
          if (((ConstraintWidget)localObject1).mTop.mTarget.mOwner != paramConstraintWidget) {
            localObject2 = null;
          }
        }
      }
      if (localObject2 == paramConstraintWidgetContainer) {
        paramConstraintWidget = null;
      } else {
        paramConstraintWidget = localObject2;
      }
    }
  }
  
  static void checkHorizontalSimpleDependency(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, ConstraintWidget paramConstraintWidget)
  {
    if (paramConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
    {
      paramConstraintWidget.mHorizontalResolution = 1;
      return;
    }
    int i;
    int j;
    if ((paramConstraintWidgetContainer.mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (paramConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
    {
      paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
      paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
      i = paramConstraintWidget.mLeft.mMargin;
      j = paramConstraintWidgetContainer.getWidth() - paramConstraintWidget.mRight.mMargin;
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, j);
      paramConstraintWidget.setHorizontalDimension(i, j);
      paramConstraintWidget.mHorizontalResolution = 2;
      return;
    }
    if ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mRight.mTarget != null))
    {
      if ((paramConstraintWidget.mLeft.mTarget.mOwner == paramConstraintWidgetContainer) && (paramConstraintWidget.mRight.mTarget.mOwner == paramConstraintWidgetContainer))
      {
        i = paramConstraintWidget.mLeft.getMargin();
        j = paramConstraintWidget.mRight.getMargin();
        if (paramConstraintWidgetContainer.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
        {
          j = paramConstraintWidgetContainer.getWidth() - j;
        }
        else
        {
          int k = paramConstraintWidget.getWidth();
          i += (int)((paramConstraintWidgetContainer.getWidth() - i - j - k) * paramConstraintWidget.mHorizontalBiasPercent + 0.5F);
          j = paramConstraintWidget.getWidth() + i;
        }
        paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
        paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
        paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
        paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, j);
        paramConstraintWidget.mHorizontalResolution = 2;
        paramConstraintWidget.setHorizontalDimension(i, j);
        return;
      }
      paramConstraintWidget.mHorizontalResolution = 1;
      return;
    }
    if ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mLeft.mTarget.mOwner == paramConstraintWidgetContainer))
    {
      i = paramConstraintWidget.mLeft.getMargin();
      j = paramConstraintWidget.getWidth() + i;
      paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
      paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, j);
      paramConstraintWidget.mHorizontalResolution = 2;
      paramConstraintWidget.setHorizontalDimension(i, j);
      return;
    }
    if ((paramConstraintWidget.mRight.mTarget != null) && (paramConstraintWidget.mRight.mTarget.mOwner == paramConstraintWidgetContainer))
    {
      paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
      paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
      i = paramConstraintWidgetContainer.getWidth() - paramConstraintWidget.mRight.getMargin();
      j = i - paramConstraintWidget.getWidth();
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, j);
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, i);
      paramConstraintWidget.mHorizontalResolution = 2;
      paramConstraintWidget.setHorizontalDimension(j, i);
      return;
    }
    if ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mLeft.mTarget.mOwner.mHorizontalResolution == 2))
    {
      paramConstraintWidgetContainer = paramConstraintWidget.mLeft.mTarget.mSolverVariable;
      paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
      paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
      i = (int)(paramConstraintWidgetContainer.computedValue + paramConstraintWidget.mLeft.getMargin() + 0.5F);
      j = paramConstraintWidget.getWidth() + i;
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, j);
      paramConstraintWidget.mHorizontalResolution = 2;
      paramConstraintWidget.setHorizontalDimension(i, j);
      return;
    }
    if ((paramConstraintWidget.mRight.mTarget != null) && (paramConstraintWidget.mRight.mTarget.mOwner.mHorizontalResolution == 2))
    {
      paramConstraintWidgetContainer = paramConstraintWidget.mRight.mTarget.mSolverVariable;
      paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
      paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
      i = (int)(paramConstraintWidgetContainer.computedValue - paramConstraintWidget.mRight.getMargin() + 0.5F);
      j = i - paramConstraintWidget.getWidth();
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, j);
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, i);
      paramConstraintWidget.mHorizontalResolution = 2;
      paramConstraintWidget.setHorizontalDimension(j, i);
      return;
    }
    if (paramConstraintWidget.mLeft.mTarget != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramConstraintWidget.mRight.mTarget != null) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i == 0) && (j == 0)) {
      if ((paramConstraintWidget instanceof Guideline))
      {
        Guideline localGuideline = (Guideline)paramConstraintWidget;
        if (localGuideline.getOrientation() == 1)
        {
          paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
          paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
          float f;
          if (localGuideline.getRelativeBegin() != -1)
          {
            f = localGuideline.getRelativeBegin();
          }
          else if (localGuideline.getRelativeEnd() != -1)
          {
            f = paramConstraintWidgetContainer.getWidth() - localGuideline.getRelativeEnd();
          }
          else
          {
            f = paramConstraintWidgetContainer.getWidth();
            f = localGuideline.getRelativePercent() * f;
          }
          i = (int)(f + 0.5F);
          paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
          paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, i);
          paramConstraintWidget.mHorizontalResolution = 2;
          paramConstraintWidget.mVerticalResolution = 2;
          paramConstraintWidget.setHorizontalDimension(i, i);
          paramConstraintWidget.setVerticalDimension(0, paramConstraintWidgetContainer.getHeight());
        }
      }
      else
      {
        paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
        paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
        i = paramConstraintWidget.getX();
        j = paramConstraintWidget.getWidth();
        paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
        paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, j + i);
        paramConstraintWidget.mHorizontalResolution = 2;
      }
    }
  }
  
  static void checkMatchParent(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, ConstraintWidget paramConstraintWidget)
  {
    int i;
    int j;
    if ((paramConstraintWidgetContainer.mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (paramConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
    {
      paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
      paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
      i = paramConstraintWidget.mLeft.mMargin;
      j = paramConstraintWidgetContainer.getWidth() - paramConstraintWidget.mRight.mMargin;
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, j);
      paramConstraintWidget.setHorizontalDimension(i, j);
      paramConstraintWidget.mHorizontalResolution = 2;
    }
    if ((paramConstraintWidgetContainer.mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (paramConstraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
    {
      paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
      paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
      i = paramConstraintWidget.mTop.mMargin;
      j = paramConstraintWidgetContainer.getHeight() - paramConstraintWidget.mBottom.mMargin;
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, j);
      if ((paramConstraintWidget.mBaselineDistance > 0) || (paramConstraintWidget.getVisibility() == 8))
      {
        paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
        paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + i);
      }
      paramConstraintWidget.setVerticalDimension(i, j);
      paramConstraintWidget.mVerticalResolution = 2;
    }
  }
  
  static void checkVerticalSimpleDependency(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, ConstraintWidget paramConstraintWidget)
  {
    Object localObject = paramConstraintWidget.mVerticalDimensionBehaviour;
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
    int k = 1;
    if (localObject == localDimensionBehaviour)
    {
      paramConstraintWidget.mVerticalResolution = 1;
      return;
    }
    int i;
    int j;
    if ((paramConstraintWidgetContainer.mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (paramConstraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
    {
      paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
      paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
      i = paramConstraintWidget.mTop.mMargin;
      j = paramConstraintWidgetContainer.getHeight() - paramConstraintWidget.mBottom.mMargin;
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, j);
      if ((paramConstraintWidget.mBaselineDistance > 0) || (paramConstraintWidget.getVisibility() == 8))
      {
        paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
        paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + i);
      }
      paramConstraintWidget.setVerticalDimension(i, j);
      paramConstraintWidget.mVerticalResolution = 2;
      return;
    }
    if ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mBottom.mTarget != null))
    {
      if ((paramConstraintWidget.mTop.mTarget.mOwner == paramConstraintWidgetContainer) && (paramConstraintWidget.mBottom.mTarget.mOwner == paramConstraintWidgetContainer))
      {
        i = paramConstraintWidget.mTop.getMargin();
        j = paramConstraintWidget.mBottom.getMargin();
        if (paramConstraintWidgetContainer.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
        {
          j = paramConstraintWidget.getHeight();
        }
        else
        {
          k = paramConstraintWidget.getHeight();
          int m = paramConstraintWidgetContainer.getHeight();
          i = (int)(i + (m - i - j - k) * paramConstraintWidget.mVerticalBiasPercent + 0.5F);
          j = paramConstraintWidget.getHeight();
        }
        j += i;
        paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
        paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
        paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
        paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, j);
        if ((paramConstraintWidget.mBaselineDistance > 0) || (paramConstraintWidget.getVisibility() == 8))
        {
          paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
          paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + i);
        }
        paramConstraintWidget.mVerticalResolution = 2;
        paramConstraintWidget.setVerticalDimension(i, j);
        return;
      }
      paramConstraintWidget.mVerticalResolution = 1;
      return;
    }
    if ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mTop.mTarget.mOwner == paramConstraintWidgetContainer))
    {
      i = paramConstraintWidget.mTop.getMargin();
      j = paramConstraintWidget.getHeight() + i;
      paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
      paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, j);
      if ((paramConstraintWidget.mBaselineDistance > 0) || (paramConstraintWidget.getVisibility() == 8))
      {
        paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
        paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + i);
      }
      paramConstraintWidget.mVerticalResolution = 2;
      paramConstraintWidget.setVerticalDimension(i, j);
      return;
    }
    if ((paramConstraintWidget.mBottom.mTarget != null) && (paramConstraintWidget.mBottom.mTarget.mOwner == paramConstraintWidgetContainer))
    {
      paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
      paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
      i = paramConstraintWidgetContainer.getHeight() - paramConstraintWidget.mBottom.getMargin();
      j = i - paramConstraintWidget.getHeight();
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, j);
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, i);
      if ((paramConstraintWidget.mBaselineDistance > 0) || (paramConstraintWidget.getVisibility() == 8))
      {
        paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
        paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + j);
      }
      paramConstraintWidget.mVerticalResolution = 2;
      paramConstraintWidget.setVerticalDimension(j, i);
      return;
    }
    if ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mTop.mTarget.mOwner.mVerticalResolution == 2))
    {
      paramConstraintWidgetContainer = paramConstraintWidget.mTop.mTarget.mSolverVariable;
      paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
      paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
      i = (int)(paramConstraintWidgetContainer.computedValue + paramConstraintWidget.mTop.getMargin() + 0.5F);
      j = paramConstraintWidget.getHeight() + i;
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, j);
      if ((paramConstraintWidget.mBaselineDistance > 0) || (paramConstraintWidget.getVisibility() == 8))
      {
        paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
        paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + i);
      }
      paramConstraintWidget.mVerticalResolution = 2;
      paramConstraintWidget.setVerticalDimension(i, j);
      return;
    }
    if ((paramConstraintWidget.mBottom.mTarget != null) && (paramConstraintWidget.mBottom.mTarget.mOwner.mVerticalResolution == 2))
    {
      paramConstraintWidgetContainer = paramConstraintWidget.mBottom.mTarget.mSolverVariable;
      paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
      paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
      i = (int)(paramConstraintWidgetContainer.computedValue - paramConstraintWidget.mBottom.getMargin() + 0.5F);
      j = i - paramConstraintWidget.getHeight();
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, j);
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, i);
      if ((paramConstraintWidget.mBaselineDistance > 0) || (paramConstraintWidget.getVisibility() == 8))
      {
        paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
        paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + j);
      }
      paramConstraintWidget.mVerticalResolution = 2;
      paramConstraintWidget.setVerticalDimension(j, i);
      return;
    }
    if ((paramConstraintWidget.mBaseline.mTarget != null) && (paramConstraintWidget.mBaseline.mTarget.mOwner.mVerticalResolution == 2))
    {
      paramConstraintWidgetContainer = paramConstraintWidget.mBaseline.mTarget.mSolverVariable;
      paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
      paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
      i = (int)(paramConstraintWidgetContainer.computedValue - paramConstraintWidget.mBaselineDistance + 0.5F);
      j = paramConstraintWidget.getHeight() + i;
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, j);
      paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
      paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + i);
      paramConstraintWidget.mVerticalResolution = 2;
      paramConstraintWidget.setVerticalDimension(i, j);
      return;
    }
    if (paramConstraintWidget.mBaseline.mTarget != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramConstraintWidget.mTop.mTarget != null) {
      j = 1;
    } else {
      j = 0;
    }
    if (paramConstraintWidget.mBottom.mTarget == null) {
      k = 0;
    }
    if ((i == 0) && (j == 0) && (k == 0)) {
      if ((paramConstraintWidget instanceof Guideline))
      {
        localObject = (Guideline)paramConstraintWidget;
        if (((Guideline)localObject).getOrientation() == 0)
        {
          paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
          paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
          float f;
          if (((Guideline)localObject).getRelativeBegin() != -1)
          {
            f = ((Guideline)localObject).getRelativeBegin();
          }
          else if (((Guideline)localObject).getRelativeEnd() != -1)
          {
            f = paramConstraintWidgetContainer.getHeight() - ((Guideline)localObject).getRelativeEnd();
          }
          else
          {
            f = paramConstraintWidgetContainer.getHeight();
            f = ((Guideline)localObject).getRelativePercent() * f;
          }
          i = (int)(f + 0.5F);
          paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
          paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, i);
          paramConstraintWidget.mVerticalResolution = 2;
          paramConstraintWidget.mHorizontalResolution = 2;
          paramConstraintWidget.setVerticalDimension(i, i);
          paramConstraintWidget.setHorizontalDimension(0, paramConstraintWidgetContainer.getWidth());
        }
      }
      else
      {
        paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
        paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
        i = paramConstraintWidget.getY();
        j = paramConstraintWidget.getHeight();
        paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
        paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, j + i);
        if ((paramConstraintWidget.mBaselineDistance > 0) || (paramConstraintWidget.getVisibility() == 8))
        {
          paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
          paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, i + paramConstraintWidget.mBaselineDistance);
        }
        paramConstraintWidget.mVerticalResolution = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.constraint.solver.widgets.Optimizer
 * JD-Core Version:    0.7.0.1
 */