package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

public class Optimizer
{
  static final int FLAG_CHAIN_DANGLING = 1;
  static final int FLAG_RECOMPUTE_BOUNDS = 2;
  static final int FLAG_USE_OPTIMIZE = 0;
  public static final int OPTIMIZATION_BARRIER = 2;
  public static final int OPTIMIZATION_CHAIN = 4;
  public static final int OPTIMIZATION_DIMENSIONS = 8;
  public static final int OPTIMIZATION_DIRECT = 1;
  public static final int OPTIMIZATION_ENGINE = 256;
  public static final int OPTIMIZATION_GRAPH = 64;
  public static final int OPTIMIZATION_GRAPH_WRAP = 128;
  public static final int OPTIMIZATION_GROUPS = 32;
  public static final int OPTIMIZATION_NONE = 0;
  public static final int OPTIMIZATION_RATIO = 16;
  public static final int OPTIMIZATION_STANDARD = 263;
  static boolean[] flags = new boolean[3];
  
  static void checkMatchParent(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, ConstraintWidget paramConstraintWidget)
  {
    paramConstraintWidget.mHorizontalResolution = -1;
    paramConstraintWidget.mVerticalResolution = -1;
    int i;
    int j;
    if ((paramConstraintWidgetContainer.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (paramConstraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
    {
      i = paramConstraintWidget.mLeft.mMargin;
      j = paramConstraintWidgetContainer.getWidth() - paramConstraintWidget.mRight.mMargin;
      paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
      paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, j);
      paramConstraintWidget.mHorizontalResolution = 2;
      paramConstraintWidget.setHorizontalDimension(i, j);
    }
    if ((paramConstraintWidgetContainer.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (paramConstraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
    {
      i = paramConstraintWidget.mTop.mMargin;
      j = paramConstraintWidgetContainer.getHeight() - paramConstraintWidget.mBottom.mMargin;
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
    }
  }
  
  public static final boolean enabled(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.Optimizer
 * JD-Core Version:    0.7.0.1
 */