package com.huawei.agconnect.core;

import android.content.Context;
import java.util.List;

public abstract interface ServiceRegistrar
{
  public abstract List<Service> getServices(Context paramContext);
  
  public abstract void initialize(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.core.ServiceRegistrar
 * JD-Core Version:    0.7.0.1
 */