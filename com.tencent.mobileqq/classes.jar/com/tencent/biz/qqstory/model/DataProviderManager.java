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
  
  public <T extends DataProvider> T a(int paramInt)
  {
    DataProvider[] arrayOfDataProvider = this.a;
    Object localObject = arrayOfDataProvider[paramInt];
    if (localObject == null)
    {
      label41:
      try
      {
        localObject = this.a[paramInt];
        if (localObject == null) {
          break label74;
        }
        return localObject;
      }
      finally {}
      localObject = new AddressDataProvider();
      break label49;
      localObject = new WeatherDataProvider();
    }
    for (;;)
    {
      label49:
      a((DataProvider)localObject, paramInt);
      if (localObject != null) {
        ((DataProvider)localObject).a();
      }
      return localObject;
      return ?;
      label74:
      if (paramInt == 0) {
        break label41;
      }
      if (paramInt == 1) {
        break;
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
        localDataProvider.b();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.DataProviderManager
 * JD-Core Version:    0.7.0.1
 */