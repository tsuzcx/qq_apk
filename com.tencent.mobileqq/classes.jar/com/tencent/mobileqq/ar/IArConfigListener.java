package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;

public abstract interface IArConfigListener
{
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(ARCommonConfigInfo paramARCommonConfigInfo);
  
  public abstract void a(ArConfigInfo paramArConfigInfo);
  
  public abstract void a(ArEffectConfig paramArEffectConfig);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.IArConfigListener
 * JD-Core Version:    0.7.0.1
 */