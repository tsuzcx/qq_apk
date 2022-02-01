package com.bumptech.glide.load.data;

import android.support.annotation.NonNull;
import com.bumptech.glide.util.Preconditions;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DataRewinderRegistry
{
  private static final DataRewinder.Factory<?> b = new DataRewinderRegistry.1();
  private final Map<Class<?>, DataRewinder.Factory<?>> a = new HashMap();
  
  @NonNull
  public <T> DataRewinder<T> a(@NonNull T paramT)
  {
    try
    {
      Preconditions.a(paramT);
      Object localObject2 = (DataRewinder.Factory)this.a.get(paramT.getClass());
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        Iterator localIterator = this.a.values().iterator();
        do
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (DataRewinder.Factory)localIterator.next();
        } while (!((DataRewinder.Factory)localObject1).a().isAssignableFrom(paramT.getClass()));
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = b;
      }
      paramT = ((DataRewinder.Factory)localObject2).a(paramT);
      return paramT;
    }
    finally {}
    for (;;)
    {
      throw paramT;
    }
  }
  
  public void a(@NonNull DataRewinder.Factory<?> paramFactory)
  {
    try
    {
      this.a.put(paramFactory.a(), paramFactory);
      return;
    }
    finally
    {
      paramFactory = finally;
      throw paramFactory;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.data.DataRewinderRegistry
 * JD-Core Version:    0.7.0.1
 */