package androidx.constraintlayout.solver;

abstract interface LinearSystem$Row
{
  public abstract void addError(SolverVariable paramSolverVariable);
  
  public abstract void clear();
  
  public abstract SolverVariable getKey();
  
  public abstract SolverVariable getPivotCandidate(LinearSystem paramLinearSystem, boolean[] paramArrayOfBoolean);
  
  public abstract void initFromRow(Row paramRow);
  
  public abstract boolean isEmpty();
  
  public abstract void updateFromFinalVariable(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable, boolean paramBoolean);
  
  public abstract void updateFromRow(LinearSystem paramLinearSystem, ArrayRow paramArrayRow, boolean paramBoolean);
  
  public abstract void updateFromSystem(LinearSystem paramLinearSystem);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.LinearSystem.Row
 * JD-Core Version:    0.7.0.1
 */