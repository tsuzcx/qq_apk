package com.sixgod.pluginsdk.a;

import com.sixgod.pluginsdk.log.SGLog;
import com.sixgod.pluginsdk.log.SixGodReporter;
import java.lang.reflect.Constructor;

public final class e
  extends c
{
  public Constructor b;
  
  public e(d paramd, Class[] paramArrayOfClass)
  {
    if (paramd != null) {}
    try
    {
      if (paramd.b != null)
      {
        this.b = paramd.b.getDeclaredConstructor(paramArrayOfClass);
        this.b.setAccessible(true);
        this.a = true;
        return;
      }
      SGLog.b("reflectClass == null or mClass == null");
      return;
    }
    catch (NoSuchMethodException paramd)
    {
      paramd.printStackTrace();
      SixGodReporter.reportException("ReflectExp", paramd);
    }
  }
  
  public static String a(Class paramClass)
  {
    if (paramClass == null) {
      return "null";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramClass = paramClass.getConstructors();
    if (paramClass != null)
    {
      int k = paramClass.length;
      int i = 0;
      while (i < k)
      {
        Class[] arrayOfClass = paramClass[i].getParameterTypes();
        if (arrayOfClass != null)
        {
          localStringBuffer.append("[");
          int j = 0;
          while (j < arrayOfClass.length)
          {
            localStringBuffer.append(arrayOfClass[j].getName());
            if (j != arrayOfClass.length - 1) {
              localStringBuffer.append("、");
            }
            j += 1;
          }
          localStringBuffer.append("]\r\n");
        }
        i += 1;
      }
    }
    return localStringBuffer.toString();
  }
  
  public final Object a(Object[] paramArrayOfObject)
  {
    try
    {
      paramArrayOfObject = this.b.newInstance(paramArrayOfObject);
      return paramArrayOfObject;
    }
    catch (Exception paramArrayOfObject)
    {
      SixGodReporter.reportException("ReflectExp", paramArrayOfObject);
      if (this.b != null)
      {
        SGLog.b(this.b.getName() + " newInstance failed!");
        paramArrayOfObject = this.b.getGenericParameterTypes();
        int j = paramArrayOfObject.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramArrayOfObject[i];
          SGLog.c("  " + localObject);
          i += 1;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.a.e
 * JD-Core Version:    0.7.0.1
 */