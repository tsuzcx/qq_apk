package androidx.constraintlayout.solver;

class Pools$SimplePool<T>
  implements Pools.Pool<T>
{
  private final Object[] mPool;
  private int mPoolSize;
  
  Pools$SimplePool(int paramInt)
  {
    if (paramInt > 0)
    {
      this.mPool = new Object[paramInt];
      return;
    }
    throw new IllegalArgumentException("The max pool size must be > 0");
  }
  
  private boolean isInPool(T paramT)
  {
    int i = 0;
    while (i < this.mPoolSize)
    {
      if (this.mPool[i] == paramT) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public T acquire()
  {
    int i = this.mPoolSize;
    if (i > 0)
    {
      int j = i - 1;
      Object[] arrayOfObject = this.mPool;
      Object localObject = arrayOfObject[j];
      arrayOfObject[j] = null;
      this.mPoolSize = (i - 1);
      return localObject;
    }
    return null;
  }
  
  public boolean release(T paramT)
  {
    int i = this.mPoolSize;
    Object[] arrayOfObject = this.mPool;
    if (i < arrayOfObject.length)
    {
      arrayOfObject[i] = paramT;
      this.mPoolSize = (i + 1);
      return true;
    }
    return false;
  }
  
  public void releaseAll(T[] paramArrayOfT, int paramInt)
  {
    int i = paramInt;
    if (paramInt > paramArrayOfT.length) {
      i = paramArrayOfT.length;
    }
    paramInt = 0;
    while (paramInt < i)
    {
      T ? = paramArrayOfT[paramInt];
      int j = this.mPoolSize;
      Object[] arrayOfObject = this.mPool;
      if (j < arrayOfObject.length)
      {
        arrayOfObject[j] = ?;
        this.mPoolSize = (j + 1);
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.Pools.SimplePool
 * JD-Core Version:    0.7.0.1
 */