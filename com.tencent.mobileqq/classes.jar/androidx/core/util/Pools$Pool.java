package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract interface Pools$Pool<T>
{
  @Nullable
  public abstract T acquire();
  
  public abstract boolean release(@NonNull T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.util.Pools.Pool
 * JD-Core Version:    0.7.0.1
 */