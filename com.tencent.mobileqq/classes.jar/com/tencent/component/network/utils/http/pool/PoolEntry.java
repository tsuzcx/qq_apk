package com.tencent.component.network.utils.http.pool;

import java.util.concurrent.TimeUnit;

public abstract class PoolEntry<T, C>
{
  private final C conn;
  private final long created;
  private long expiry;
  private final String id;
  private final T route;
  private volatile Object state;
  private long updated;
  private final long validUnit;
  
  public PoolEntry(String paramString, T paramT, C paramC)
  {
    this(paramString, paramT, paramC, 0L, TimeUnit.MILLISECONDS);
  }
  
  public PoolEntry(String paramString, T paramT, C paramC, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramT != null)
    {
      if (paramC != null)
      {
        if (paramTimeUnit != null)
        {
          this.id = paramString;
          this.route = paramT;
          this.conn = paramC;
          this.created = System.currentTimeMillis();
          if (paramLong > 0L) {
            this.validUnit = (this.created + paramTimeUnit.toMillis(paramLong));
          } else {
            this.validUnit = 9223372036854775807L;
          }
          this.expiry = this.validUnit;
          return;
        }
        throw new IllegalArgumentException("Time unit may not be null");
      }
      throw new IllegalArgumentException("Connection may not be null");
    }
    throw new IllegalArgumentException("Route may not be null");
  }
  
  public abstract void close();
  
  public C getConnection()
  {
    return this.conn;
  }
  
  public long getCreated()
  {
    return this.created;
  }
  
  public long getExpiry()
  {
    try
    {
      long l = this.expiry;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public T getRoute()
  {
    return this.route;
  }
  
  public Object getState()
  {
    return this.state;
  }
  
  public long getUpdated()
  {
    try
    {
      long l = this.updated;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getValidUnit()
  {
    return this.validUnit;
  }
  
  public abstract boolean isClosed();
  
  public boolean isExpired(long paramLong)
  {
    try
    {
      long l = this.expiry;
      boolean bool;
      if (paramLong >= l) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setState(Object paramObject)
  {
    this.state = paramObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[id:");
    localStringBuilder.append(this.id);
    localStringBuilder.append("][route:");
    localStringBuilder.append(this.route);
    localStringBuilder.append("][state:");
    localStringBuilder.append(this.state);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void updateExpiry(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramTimeUnit != null) {}
    for (;;)
    {
      try
      {
        this.updated = System.currentTimeMillis();
        if (paramLong <= 0L) {
          break label66;
        }
        paramLong = this.updated + paramTimeUnit.toMillis(paramLong);
        this.expiry = Math.min(paramLong, this.validUnit);
        return;
      }
      finally
      {
        break label62;
      }
      throw new IllegalArgumentException("Time unit may not be null");
      label62:
      throw paramTimeUnit;
      label66:
      paramLong = 9223372036854775807L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.utils.http.pool.PoolEntry
 * JD-Core Version:    0.7.0.1
 */