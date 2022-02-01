package com.huawei.arengine.remoteLoader;

import android.os.IInterface;

public abstract interface ILoaderProducer
  extends IInterface
{
  public abstract IDynamicLoader newDynamicLoader(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.arengine.remoteLoader.ILoaderProducer
 * JD-Core Version:    0.7.0.1
 */