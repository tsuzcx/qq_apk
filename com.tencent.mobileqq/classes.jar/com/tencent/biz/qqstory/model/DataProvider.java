package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class DataProvider<DATA>
{
  public static final String b = "com.tencent.biz.qqstory.model.DataProvider";
  protected DATA c;
  protected List<DataProvider.DataUpdateListener<DATA>> d = new CopyOnWriteArrayList();
  
  public void a()
  {
    SLog.b(b, "onInit");
  }
  
  public void a(@NonNull DataProvider.DataUpdateListener<DATA> paramDataUpdateListener)
  {
    if (!this.d.contains(paramDataUpdateListener)) {
      this.d.add(paramDataUpdateListener);
    }
  }
  
  protected abstract void a(BasicLocation paramBasicLocation);
  
  protected void a(boolean paramBoolean, DATA paramDATA)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((DataProvider.DataUpdateListener)localIterator.next()).a(paramBoolean, paramDATA);
    }
  }
  
  public void b()
  {
    SLog.b(b, "onDestroy");
    this.d.clear();
  }
  
  public void b(@NonNull DataProvider.DataUpdateListener<DATA> paramDataUpdateListener)
  {
    if (this.d.contains(paramDataUpdateListener)) {
      this.d.remove(paramDataUpdateListener);
    }
  }
  
  public void b(BasicLocation paramBasicLocation)
  {
    a(paramBasicLocation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.DataProvider
 * JD-Core Version:    0.7.0.1
 */