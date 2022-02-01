package com.tencent.falco.base.libapi.apm;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface APMInterface
  extends ServiceBaseInterface
{
  public abstract void init(APMConfiguration paramAPMConfiguration);
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.apm.APMInterface
 * JD-Core Version:    0.7.0.1
 */