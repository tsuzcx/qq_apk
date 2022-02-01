package com.tencent.luggage.wxa.pd;

import com.tencent.luggage.wxa.qz.o;
import java.lang.reflect.Method;
import org.apache.commons.lang.ArrayUtils;

final class g$1
  extends g
{
  g$1(String paramString) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    o.d(this.a, "dummy invoke method(%s) args(%s)", new Object[] { paramMethod.getName(), ArrayUtils.toString(paramArrayOfObject, "NULL") });
    return super.invoke(paramObject, paramMethod, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.g.1
 * JD-Core Version:    0.7.0.1
 */