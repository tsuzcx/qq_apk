package com.huawei.hms.common.data;

import android.os.Bundle;
import com.huawei.hms.common.api.Releasable;
import java.util.Iterator;

public abstract interface DataBuffer<T>
  extends Releasable, Iterable<T>
{
  @Deprecated
  public abstract void close();
  
  public abstract T get(int paramInt);
  
  public abstract int getCount();
  
  public abstract Bundle getMetadata();
  
  @Deprecated
  public abstract boolean isClosed();
  
  public abstract Iterator<T> iterator();
  
  public abstract void release();
  
  public abstract Iterator<T> singleRefIterator();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.data.DataBuffer
 * JD-Core Version:    0.7.0.1
 */