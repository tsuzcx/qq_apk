package com.tencent.luggage.wxa.dq;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.ConcurrentHashMap;
import org.joor.Reflect;

public class a<ComponentImpType extends a.b, ComponentLogicImp extends a.a, Component extends c>
{
  private ConcurrentHashMap<String, Class<? extends ComponentLogicImp>> a = new ConcurrentHashMap(2);
  
  public ComponentLogicImp a(@NonNull ComponentImpType paramComponentImpType, @NonNull Component paramComponent)
  {
    Class localClass = (Class)this.a.get(paramComponentImpType.getClass().getName());
    if (localClass != null) {
      try
      {
        paramComponentImpType = (a.a)Reflect.on(localClass).create(new Object[] { paramComponent }).get();
        return paramComponentImpType;
      }
      catch (Exception paramComponentImpType)
      {
        o.a("Luggage.AppBrandLogicFactory", paramComponentImpType, "hy: construct failed!", new Object[0]);
        return null;
      }
    }
    o.c("Luggage.AppBrandLogicFactory", "hy: implement corresponding to type %s not found!", new Object[] { paramComponentImpType });
    return null;
  }
  
  public void a(@NonNull ComponentImpType paramComponentImpType, @NonNull Class<? extends ComponentLogicImp> paramClass)
  {
    this.a.put(paramComponentImpType.getClass().getName(), paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dq.a
 * JD-Core Version:    0.7.0.1
 */