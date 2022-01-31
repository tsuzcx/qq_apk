package com.huawei.arengine.service;

import android.os.IInterface;
import android.os.ParcelFileDescriptor;

public abstract interface IAREngine
  extends IInterface
{
  public abstract int[] getMetaData();
  
  public abstract ParcelFileDescriptor getSharedFile(String paramString);
  
  public abstract int getVersionCode();
  
  public abstract String getVersionName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.arengine.service.IAREngine
 * JD-Core Version:    0.7.0.1
 */