package androidx.constraintlayout.solver;

import java.util.Comparator;

class PriorityGoalRow$1
  implements Comparator<SolverVariable>
{
  PriorityGoalRow$1(PriorityGoalRow paramPriorityGoalRow) {}
  
  public int compare(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2)
  {
    return paramSolverVariable1.id - paramSolverVariable2.id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.PriorityGoalRow.1
 * JD-Core Version:    0.7.0.1
 */