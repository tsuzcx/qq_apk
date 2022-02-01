package androidx.constraintlayout.solver;

import java.util.Arrays;

class PriorityGoalRow$GoalVariableAccessor
  implements Comparable
{
  PriorityGoalRow row;
  SolverVariable variable;
  
  public PriorityGoalRow$GoalVariableAccessor(PriorityGoalRow paramPriorityGoalRow1, PriorityGoalRow paramPriorityGoalRow2)
  {
    this.row = paramPriorityGoalRow2;
  }
  
  public void add(SolverVariable paramSolverVariable)
  {
    int i = 0;
    while (i < 9)
    {
      float[] arrayOfFloat = this.variable.goalStrengthVector;
      arrayOfFloat[i] += paramSolverVariable.goalStrengthVector[i];
      if (Math.abs(this.variable.goalStrengthVector[i]) < 1.0E-004F) {
        this.variable.goalStrengthVector[i] = 0.0F;
      }
      i += 1;
    }
  }
  
  public boolean addToGoal(SolverVariable paramSolverVariable, float paramFloat)
  {
    boolean bool = this.variable.inGoal;
    int j = 1;
    int i = 0;
    if (bool)
    {
      i = 0;
      while (i < 9)
      {
        float[] arrayOfFloat = this.variable.goalStrengthVector;
        arrayOfFloat[i] += paramSolverVariable.goalStrengthVector[i] * paramFloat;
        if (Math.abs(this.variable.goalStrengthVector[i]) < 1.0E-004F) {
          this.variable.goalStrengthVector[i] = 0.0F;
        } else {
          j = 0;
        }
        i += 1;
      }
      if (j != 0) {
        PriorityGoalRow.access$000(this.this$0, this.variable);
      }
      return false;
    }
    while (i < 9)
    {
      float f1 = paramSolverVariable.goalStrengthVector[i];
      if (f1 != 0.0F)
      {
        float f2 = f1 * paramFloat;
        f1 = f2;
        if (Math.abs(f2) < 1.0E-004F) {
          f1 = 0.0F;
        }
        this.variable.goalStrengthVector[i] = f1;
      }
      else
      {
        this.variable.goalStrengthVector[i] = 0.0F;
      }
      i += 1;
    }
    return true;
  }
  
  public int compareTo(Object paramObject)
  {
    paramObject = (SolverVariable)paramObject;
    return this.variable.id - paramObject.id;
  }
  
  public void init(SolverVariable paramSolverVariable)
  {
    this.variable = paramSolverVariable;
  }
  
  public final boolean isNegative()
  {
    int i = 8;
    while (i >= 0)
    {
      float f = this.variable.goalStrengthVector[i];
      if (f > 0.0F) {
        return false;
      }
      if (f < 0.0F) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public final boolean isNull()
  {
    int i = 0;
    while (i < 9)
    {
      if (this.variable.goalStrengthVector[i] != 0.0F) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final boolean isSmallerThan(SolverVariable paramSolverVariable)
  {
    int i = 8;
    while (i >= 0)
    {
      float f1 = paramSolverVariable.goalStrengthVector[i];
      float f2 = this.variable.goalStrengthVector[i];
      if (f2 == f1) {
        i -= 1;
      } else if (f2 < f1) {
        return true;
      }
    }
    return false;
  }
  
  public void reset()
  {
    Arrays.fill(this.variable.goalStrengthVector, 0.0F);
  }
  
  public String toString()
  {
    SolverVariable localSolverVariable = this.variable;
    Object localObject1 = "[ ";
    Object localObject2 = localObject1;
    if (localSolverVariable != null)
    {
      int i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= 9) {
          break;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(this.variable.goalStrengthVector[i]);
        ((StringBuilder)localObject2).append(" ");
        localObject1 = ((StringBuilder)localObject2).toString();
        i += 1;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("] ");
    ((StringBuilder)localObject1).append(this.variable);
    return ((StringBuilder)localObject1).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.PriorityGoalRow.GoalVariableAccessor
 * JD-Core Version:    0.7.0.1
 */