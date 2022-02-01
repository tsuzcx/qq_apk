package androidx.constraintlayout.solver;

public class Cache
{
  Pools.Pool<ArrayRow> arrayRowPool = new Pools.SimplePool(256);
  SolverVariable[] mIndexedVariables = new SolverVariable[32];
  Pools.Pool<ArrayRow> optimizedArrayRowPool = new Pools.SimplePool(256);
  Pools.Pool<SolverVariable> solverVariablePool = new Pools.SimplePool(256);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.Cache
 * JD-Core Version:    0.7.0.1
 */