package com.huawei.arengine.remoteLoader;

import android.os.IInterface;

public abstract interface IDynamicLoader
  extends IInterface
{
  public abstract boolean checkUpdate(long paramLong, boolean paramBoolean);
  
  public abstract void closeLibrary(long paramLong);
  
  public abstract long openLibrary(String paramString);
  
  public abstract boolean updateResourceFromRemote(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.arengine.remoteLoader.IDynamicLoader
 * JD-Core Version:    0.7.0.1
 */