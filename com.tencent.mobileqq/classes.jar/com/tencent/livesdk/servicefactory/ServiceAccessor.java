package com.tencent.livesdk.servicefactory;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import java.util.Map;

public abstract interface ServiceAccessor
{
  public abstract Map<Class<? extends ServiceBaseInterface>, ServiceBaseInterface> getAllAvailableService();
  
  public abstract <T extends ServiceBaseInterface> T getService(Class<? extends T> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.ServiceAccessor
 * JD-Core Version:    0.7.0.1
 */