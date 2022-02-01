package com.tencent.mobileqq.ar.aidl;

import android.os.IInterface;

public abstract interface IArRemoteCallback
  extends IInterface
{
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(ArConfigInfo paramArConfigInfo, ArEffectConfig paramArEffectConfig, ARCommonConfigInfo paramARCommonConfigInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.IArRemoteCallback
 * JD-Core Version:    0.7.0.1
 */