package com.huawei.hms.common.data;

import android.os.Bundle;
import com.huawei.hms.support.api.client.Result;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T>
  extends Result
  implements DataBuffer<T>
{
  protected final DataHolder mDataHolder;
  
  protected AbstractDataBuffer(DataHolder paramDataHolder)
  {
    this.mDataHolder = paramDataHolder;
  }
  
  @Deprecated
  public final void close()
  {
    release();
  }
  
  public abstract T get(int paramInt);
  
  public int getCount()
  {
    DataHolder localDataHolder = this.mDataHolder;
    if (localDataHolder == null) {
      return 0;
    }
    return localDataHolder.getCount();
  }
  
  public Bundle getMetadata()
  {
    return this.mDataHolder.getMetadata();
  }
  
  @Deprecated
  public boolean isClosed()
  {
    DataHolder localDataHolder = this.mDataHolder;
    if (localDataHolder == null) {
      return true;
    }
    return localDataHolder.isClosed();
  }
  
  public Iterator<T> iterator()
  {
    return new DBInnerIter(this);
  }
  
  public void release()
  {
    DataHolder localDataHolder = this.mDataHolder;
    if (localDataHolder != null) {
      localDataHolder.close();
    }
  }
  
  public Iterator<T> singleRefIterator()
  {
    return new SingleRefDBInnerIter(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.data.AbstractDataBuffer
 * JD-Core Version:    0.7.0.1
 */