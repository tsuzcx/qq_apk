package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.HashMap;

public class Barrier
  extends HelperWidget
{
  public static final int BOTTOM = 3;
  public static final int LEFT = 0;
  public static final int RIGHT = 1;
  public static final int TOP = 2;
  private boolean mAllowsGoneWidget = true;
  private int mBarrierType = 0;
  private int mMargin = 0;
  
  public void addToSolver(LinearSystem paramLinearSystem)
  {
    this.mListAnchors[0] = this.mLeft;
    this.mListAnchors[2] = this.mTop;
    this.mListAnchors[1] = this.mRight;
    this.mListAnchors[3] = this.mBottom;
    int i = 0;
    while (i < this.mListAnchors.length)
    {
      this.mListAnchors[i].mSolverVariable = paramLinearSystem.createObjectVariable(this.mListAnchors[i]);
      i += 1;
    }
    i = this.mBarrierType;
    if ((i >= 0) && (i < 4))
    {
      ConstraintAnchor localConstraintAnchor = this.mListAnchors[this.mBarrierType];
      i = 0;
      ConstraintWidget localConstraintWidget;
      while (i < this.mWidgetsCount)
      {
        localConstraintWidget = this.mWidgets[i];
        if ((this.mAllowsGoneWidget) || (localConstraintWidget.allowedInBarrier()))
        {
          j = this.mBarrierType;
          if (((j == 0) || (j == 1)) && (localConstraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget.mLeft.mTarget != null) && (localConstraintWidget.mRight.mTarget != null)) {}
          do
          {
            bool = true;
            break;
            j = this.mBarrierType;
          } while (((j == 2) || (j == 3)) && (localConstraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget.mTop.mTarget != null) && (localConstraintWidget.mBottom.mTarget != null));
        }
        i += 1;
      }
      boolean bool = false;
      if ((!this.mLeft.hasCenteredDependents()) && (!this.mRight.hasCenteredDependents())) {
        i = 0;
      } else {
        i = 1;
      }
      if ((!this.mTop.hasCenteredDependents()) && (!this.mBottom.hasCenteredDependents())) {
        j = 0;
      } else {
        j = 1;
      }
      if ((!bool) && (((this.mBarrierType == 0) && (i != 0)) || ((this.mBarrierType == 2) && (j != 0)) || ((this.mBarrierType == 1) && (i != 0)) || ((this.mBarrierType == 3) && (j != 0)))) {
        j = 1;
      } else {
        j = 0;
      }
      i = 5;
      if (j == 0) {
        i = 4;
      }
      int j = 0;
      while (j < this.mWidgetsCount)
      {
        localConstraintWidget = this.mWidgets[j];
        if ((this.mAllowsGoneWidget) || (localConstraintWidget.allowedInBarrier()))
        {
          SolverVariable localSolverVariable = paramLinearSystem.createObjectVariable(localConstraintWidget.mListAnchors[this.mBarrierType]);
          localConstraintWidget.mListAnchors[this.mBarrierType].mSolverVariable = localSolverVariable;
          int k;
          if ((localConstraintWidget.mListAnchors[this.mBarrierType].mTarget != null) && (localConstraintWidget.mListAnchors[this.mBarrierType].mTarget.mOwner == this)) {
            k = localConstraintWidget.mListAnchors[this.mBarrierType].mMargin + 0;
          } else {
            k = 0;
          }
          int m = this.mBarrierType;
          if ((m != 0) && (m != 2)) {
            paramLinearSystem.addGreaterBarrier(localConstraintAnchor.mSolverVariable, localSolverVariable, this.mMargin + k, bool);
          } else {
            paramLinearSystem.addLowerBarrier(localConstraintAnchor.mSolverVariable, localSolverVariable, this.mMargin - k, bool);
          }
          paramLinearSystem.addEquality(localConstraintAnchor.mSolverVariable, localSolverVariable, this.mMargin + k, i);
        }
        j += 1;
      }
      i = this.mBarrierType;
      if (i == 0)
      {
        paramLinearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
        paramLinearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
        paramLinearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
        return;
      }
      if (i == 1)
      {
        paramLinearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
        paramLinearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
        paramLinearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
        return;
      }
      if (i == 2)
      {
        paramLinearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
        paramLinearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
        paramLinearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
        return;
      }
      if (i == 3)
      {
        paramLinearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
        paramLinearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
        paramLinearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
      }
    }
  }
  
  public boolean allowedInBarrier()
  {
    return true;
  }
  
  public boolean allowsGoneWidget()
  {
    return this.mAllowsGoneWidget;
  }
  
  public void copy(ConstraintWidget paramConstraintWidget, HashMap<ConstraintWidget, ConstraintWidget> paramHashMap)
  {
    super.copy(paramConstraintWidget, paramHashMap);
    paramConstraintWidget = (Barrier)paramConstraintWidget;
    this.mBarrierType = paramConstraintWidget.mBarrierType;
    this.mAllowsGoneWidget = paramConstraintWidget.mAllowsGoneWidget;
    this.mMargin = paramConstraintWidget.mMargin;
  }
  
  public int getBarrierType()
  {
    return this.mBarrierType;
  }
  
  public int getMargin()
  {
    return this.mMargin;
  }
  
  protected void markWidgets()
  {
    int i = 0;
    while (i < this.mWidgetsCount)
    {
      ConstraintWidget localConstraintWidget = this.mWidgets[i];
      int j = this.mBarrierType;
      if ((j != 0) && (j != 1))
      {
        if ((j == 2) || (j == 3)) {
          localConstraintWidget.setInBarrier(1, true);
        }
      }
      else {
        localConstraintWidget.setInBarrier(0, true);
      }
      i += 1;
    }
  }
  
  public void setAllowsGoneWidget(boolean paramBoolean)
  {
    this.mAllowsGoneWidget = paramBoolean;
  }
  
  public void setBarrierType(int paramInt)
  {
    this.mBarrierType = paramInt;
  }
  
  public void setMargin(int paramInt)
  {
    this.mMargin = paramInt;
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[Barrier] ");
    ((StringBuilder)localObject1).append(getDebugName());
    ((StringBuilder)localObject1).append(" {");
    localObject1 = ((StringBuilder)localObject1).toString();
    int i = 0;
    while (i < this.mWidgetsCount)
    {
      ConstraintWidget localConstraintWidget = this.mWidgets[i];
      localObject2 = localObject1;
      if (i > 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(", ");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(localConstraintWidget.getDebugName());
      localObject1 = ((StringBuilder)localObject1).toString();
      i += 1;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("}");
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.Barrier
 * JD-Core Version:    0.7.0.1
 */