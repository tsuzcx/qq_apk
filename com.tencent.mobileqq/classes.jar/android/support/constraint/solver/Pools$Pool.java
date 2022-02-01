package android.support.constraint.solver;

abstract interface Pools$Pool<T>
{
  public abstract T acquire();
  
  public abstract boolean release(T paramT);
  
  public abstract void releaseAll(T[] paramArrayOfT, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.constraint.solver.Pools.Pool
 * JD-Core Version:    0.7.0.1
 */