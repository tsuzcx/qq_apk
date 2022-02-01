package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.pd.g;
import com.tencent.luggage.wxa.qz.o;
import java.lang.reflect.Method;
import org.apache.commons.lang.ArrayUtils;

final class a$8
  extends g
{
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    o.b("Luggage.AbstractMPPageViewRenderer", "DummyPullDownExtension: invoke(%s), args=%s", new Object[] { paramMethod.getName(), ArrayUtils.toString(paramArrayOfObject, "NULL") });
    return super.invoke(paramObject, paramMethod, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.8
 * JD-Core Version:    0.7.0.1
 */