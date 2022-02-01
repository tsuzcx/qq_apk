package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.confess.ConfessProxy;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.qcall.QCallProxy;

public class LazyProxyClassProvider
  implements Provider<Class[]>
{
  public Class[] a()
  {
    return new Class[] { QCallProxy.class, ConfessProxy.class };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.LazyProxyClassProvider
 * JD-Core Version:    0.7.0.1
 */