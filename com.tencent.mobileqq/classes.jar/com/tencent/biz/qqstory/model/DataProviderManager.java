package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.support.logging.SLog;

public class DataProviderManager
  implements IManager
{
  public final DataProvider[] a = new DataProvider[2];
  
  private void a(DataProvider paramDataProvider, int paramInt)
  {
    this.a[paramInt] = paramDataProvider;
  }
  
  public DataProvider a(int paramInt)
  {
    DataProvider localDataProvider = this.a[paramInt];
    if (localDataProvider == null) {}
    for (;;)
    {
      synchronized (this.a)
      {
        localDataProvider = this.a[paramInt];
        if (localDataProvider == null) {
          break label80;
        }
        return localDataProvider;
        a(localDataProvider, paramInt);
        if (localDataProvider != null) {
          localDataProvider.c();
        }
        return localDataProvider;
      }
      Object localObject2 = new WeatherDataProvider();
      continue;
      localObject2 = new AddressDataProvider();
      continue;
      return localObject2;
      label80:
      switch (paramInt)
      {
      }
    }
  }
  
  public void a()
  {
    SLog.b("DataProviderManager", "onInit");
  }
  
  public void b()
  {
    SLog.b("DataProviderManager", "onDestroy");
    DataProvider[] arrayOfDataProvider = this.a;
    int j = arrayOfDataProvider.length;
    int i = 0;
    while (i < j)
    {
      DataProvider localDataProvider = arrayOfDataProvider[i];
      if (localDataProvider != null) {
        localDataProvider.d();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.DataProviderManager
 * JD-Core Version:    0.7.0.1
 */