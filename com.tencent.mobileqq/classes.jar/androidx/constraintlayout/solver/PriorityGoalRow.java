package androidx.constraintlayout.solver;

import java.util.Arrays;

public class PriorityGoalRow
  extends ArrayRow
{
  private static final boolean DEBUG = false;
  static final int NOT_FOUND = -1;
  private static final float epsilon = 1.0E-004F;
  private int TABLE_SIZE = 128;
  PriorityGoalRow.GoalVariableAccessor accessor;
  private SolverVariable[] arrayGoals;
  Cache mCache;
  private int numGoals;
  private SolverVariable[] sortArray;
  
  public PriorityGoalRow(Cache paramCache)
  {
    super(paramCache);
    int i = this.TABLE_SIZE;
    this.arrayGoals = new SolverVariable[i];
    this.sortArray = new SolverVariable[i];
    this.numGoals = 0;
    this.accessor = new PriorityGoalRow.GoalVariableAccessor(this, this);
    this.mCache = paramCache;
  }
  
  private final void addToGoal(SolverVariable paramSolverVariable)
  {
    int i = this.numGoals;
    SolverVariable[] arrayOfSolverVariable = this.arrayGoals;
    if (i + 1 > arrayOfSolverVariable.length)
    {
      this.arrayGoals = ((SolverVariable[])Arrays.copyOf(arrayOfSolverVariable, arrayOfSolverVariable.length * 2));
      arrayOfSolverVariable = this.arrayGoals;
      this.sortArray = ((SolverVariable[])Arrays.copyOf(arrayOfSolverVariable, arrayOfSolverVariable.length * 2));
    }
    arrayOfSolverVariable = this.arrayGoals;
    i = this.numGoals;
    arrayOfSolverVariable[i] = paramSolverVariable;
    this.numGoals = (i + 1);
    i = this.numGoals;
    if ((i > 1) && (arrayOfSolverVariable[(i - 1)].id > paramSolverVariable.id))
    {
      int j = 0;
      i = 0;
      int k;
      for (;;)
      {
        k = this.numGoals;
        if (i >= k) {
          break;
        }
        this.sortArray[i] = this.arrayGoals[i];
        i += 1;
      }
      Arrays.sort(this.sortArray, 0, k, new PriorityGoalRow.1(this));
      i = j;
      while (i < this.numGoals)
      {
        this.arrayGoals[i] = this.sortArray[i];
        i += 1;
      }
    }
    paramSolverVariable.inGoal = true;
    paramSolverVariable.addToRow(this);
  }
  
  private final void removeGoal(SolverVariable paramSolverVariable)
  {
    int i = 0;
    while (i < this.numGoals)
    {
      if (this.arrayGoals[i] == paramSolverVariable)
      {
        int j;
        for (;;)
        {
          j = this.numGoals;
          if (i >= j - 1) {
            break;
          }
          SolverVariable[] arrayOfSolverVariable = this.arrayGoals;
          j = i + 1;
          arrayOfSolverVariable[i] = arrayOfSolverVariable[j];
          i = j;
        }
        this.numGoals = (j - 1);
        paramSolverVariable.inGoal = false;
        return;
      }
      i += 1;
    }
  }
  
  public void addError(SolverVariable paramSolverVariable)
  {
    this.accessor.init(paramSolverVariable);
    this.accessor.reset();
    paramSolverVariable.goalStrengthVector[paramSolverVariable.strength] = 1.0F;
    addToGoal(paramSolverVariable);
  }
  
  public void clear()
  {
    this.numGoals = 0;
    this.constantValue = 0.0F;
  }
  
  public SolverVariable getPivotCandidate(LinearSystem paramLinearSystem, boolean[] paramArrayOfBoolean)
  {
    int i = 0;
    int k;
    for (int j = -1; i < this.numGoals; j = k)
    {
      paramLinearSystem = this.arrayGoals[i];
      if (paramArrayOfBoolean[paramLinearSystem.id] != 0)
      {
        k = j;
      }
      else
      {
        this.accessor.init(paramLinearSystem);
        if (j == -1)
        {
          k = j;
          if (!this.accessor.isNegative()) {
            break label91;
          }
        }
        else
        {
          k = j;
          if (!this.accessor.isSmallerThan(this.arrayGoals[j])) {
            break label91;
          }
        }
        k = i;
      }
      label91:
      i += 1;
    }
    if (j == -1) {
      return null;
    }
    return this.arrayGoals[j];
  }
  
  public boolean isEmpty()
  {
    return this.numGoals == 0;
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(" goal -> (");
    ((StringBuilder)localObject1).append(this.constantValue);
    ((StringBuilder)localObject1).append(") : ");
    localObject1 = ((StringBuilder)localObject1).toString();
    int i = 0;
    while (i < this.numGoals)
    {
      Object localObject2 = this.arrayGoals[i];
      this.accessor.init((SolverVariable)localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.accessor);
      ((StringBuilder)localObject2).append(" ");
      localObject1 = ((StringBuilder)localObject2).toString();
      i += 1;
    }
    return localObject1;
  }
  
  public void updateFromRow(LinearSystem paramLinearSystem, ArrayRow paramArrayRow, boolean paramBoolean)
  {
    paramLinearSystem = paramArrayRow.variable;
    if (paramLinearSystem == null) {
      return;
    }
    ArrayRow.ArrayRowVariables localArrayRowVariables = paramArrayRow.variables;
    int j = localArrayRowVariables.getCurrentSize();
    int i = 0;
    while (i < j)
    {
      SolverVariable localSolverVariable = localArrayRowVariables.getVariable(i);
      float f = localArrayRowVariables.getVariableValue(i);
      this.accessor.init(localSolverVariable);
      if (this.accessor.addToGoal(paramLinearSystem, f)) {
        addToGoal(localSolverVariable);
      }
      this.constantValue += paramArrayRow.constantValue * f;
      i += 1;
    }
    removeGoal(paramLinearSystem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.PriorityGoalRow
 * JD-Core Version:    0.7.0.1
 */