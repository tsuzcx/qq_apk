package com.sixgod.pluginsdk.a;

import com.sixgod.pluginsdk.log.SGLog;
import com.sixgod.pluginsdk.log.SixGodReporter;
import java.lang.reflect.Field;

public final class f
  extends c
{
  public Field b;
  public String c;
  public String d;
  
  public f(Class paramClass, String paramString)
  {
    this.c = paramString;
    this.d = paramClass.getName();
    Class localClass;
    if (paramClass != null) {
      localClass = paramClass;
    }
    for (;;)
    {
      if (localClass != Object.class) {}
      try
      {
        this.b = localClass.getDeclaredField(paramString);
        this.b.setAccessible(true);
        this.a = true;
        if (this.b == null)
        {
          paramClass = "field not found fieldName = " + paramString + " ; className = " + paramClass.getName();
          SixGodReporter.reportException("ReflectExp", new Exception(paramClass));
          SGLog.c(paramClass);
        }
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localClass = localClass.getSuperclass();
      }
    }
  }
  
  public final Object a(Object paramObject)
  {
    if (this.b == null)
    {
      SGLog.b("getValue field null:" + this.d + ", " + this.c);
      return null;
    }
    try
    {
      paramObject = this.b.get(paramObject);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
      SixGodReporter.reportException("ReflectExp", paramObject);
    }
    return null;
  }
  
  public final void a(Object paramObject1, Object paramObject2)
  {
    if (this.b == null)
    {
      SGLog.b("setValue field null:" + this.d + ", " + this.c);
      return;
    }
    try
    {
      this.b.set(paramObject1, paramObject2);
      return;
    }
    catch (Exception paramObject1)
    {
      paramObject1.printStackTrace();
      SixGodReporter.reportException("ReflectExp", paramObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.a.f
 * JD-Core Version:    0.7.0.1
 */