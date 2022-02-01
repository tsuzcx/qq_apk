package androidx.constraintlayout.solver;

public abstract interface ArrayRow$ArrayRowVariables
{
  public abstract void add(SolverVariable paramSolverVariable, float paramFloat, boolean paramBoolean);
  
  public abstract void clear();
  
  public abstract boolean contains(SolverVariable paramSolverVariable);
  
  public abstract void display();
  
  public abstract void divideByAmount(float paramFloat);
  
  public abstract float get(SolverVariable paramSolverVariable);
  
  public abstract int getCurrentSize();
  
  public abstract SolverVariable getVariable(int paramInt);
  
  public abstract float getVariableValue(int paramInt);
  
  public abstract int indexOf(SolverVariable paramSolverVariable);
  
  public abstract void invert();
  
  public abstract void put(SolverVariable paramSolverVariable, float paramFloat);
  
  public abstract float remove(SolverVariable paramSolverVariable, boolean paramBoolean);
  
  public abstract int sizeInBytes();
  
  public abstract float use(ArrayRow paramArrayRow, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
 * JD-Core Version:    0.7.0.1
 */