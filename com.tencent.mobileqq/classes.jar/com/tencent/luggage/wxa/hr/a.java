package com.tencent.luggage.wxa.hr;

import com.tencent.luggage.wxa.hs.b;
import java.lang.reflect.Field;

public class a<FieldType>
{
  private Class<?> a;
  private String b;
  private boolean c;
  private Field d;
  
  public a(Class<?> paramClass, String paramString)
  {
    if ((paramClass != null) && (paramString != null) && (paramString.length() != 0))
    {
      this.a = paramClass;
      this.b = paramString;
      return;
    }
    throw new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
  }
  
  private void b()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.c;
        if (bool) {
          return;
        }
        localClass = this.a;
        if (localClass == null) {
          break;
        }
      }
      finally
      {
        Class localClass;
        Field localField;
        continue;
        throw localObject;
        continue;
      }
      try
      {
        localField = localClass.getDeclaredField(this.b);
        localField.setAccessible(true);
        this.d = localField;
      }
      catch (Exception localException)
      {
        continue;
      }
      localClass = localClass.getSuperclass();
    }
    this.c = true;
  }
  
  /* Error */
  public FieldType a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: iconst_1
    //   6: invokevirtual 69	com/tencent/luggage/wxa/hr/a:a	(Z)Ljava/lang/Object;
    //   9: astore_2
    //   10: aload_2
    //   11: astore_1
    //   12: goto +61 -> 73
    //   15: astore_1
    //   16: goto +61 -> 77
    //   19: astore_2
    //   20: ldc 71
    //   22: ldc 73
    //   24: iconst_1
    //   25: anewarray 5	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: aload_2
    //   31: aastore
    //   32: invokestatic 78	com/tencent/luggage/wxa/hs/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: goto +38 -> 73
    //   38: astore_2
    //   39: ldc 71
    //   41: ldc 73
    //   43: iconst_1
    //   44: anewarray 5	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aload_2
    //   50: aastore
    //   51: invokestatic 78	com/tencent/luggage/wxa/hs/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   54: goto +19 -> 73
    //   57: astore_2
    //   58: ldc 71
    //   60: ldc 73
    //   62: iconst_1
    //   63: anewarray 5	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload_2
    //   69: aastore
    //   70: invokestatic 78	com/tencent/luggage/wxa/hs/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: areturn
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	a
    //   3	9	1	localObject1	Object
    //   15	65	1	?	FieldType
    //   9	2	2	localObject2	Object
    //   19	12	2	localIllegalArgumentException	IllegalArgumentException
    //   38	12	2	localIllegalAccessException	java.lang.IllegalAccessException
    //   57	12	2	localNoSuchFieldException	NoSuchFieldException
    // Exception table:
    //   from	to	target	type
    //   4	10	15	finally
    //   20	35	15	finally
    //   39	54	15	finally
    //   58	73	15	finally
    //   4	10	19	java/lang/IllegalArgumentException
    //   4	10	38	java/lang/IllegalAccessException
    //   4	10	57	java/lang/NoSuchFieldException
  }
  
  public FieldType a(boolean paramBoolean)
  {
    Object localObject1;
    label60:
    try
    {
      b();
      if (this.d == null)
      {
        if (paramBoolean)
        {
          b.c("SDK.ReflectStaticFieldSmith", "Field %s is no exists.", new Object[] { this.b });
          return null;
        }
        throw new NoSuchFieldException();
      }
    }
    finally {}
    try
    {
      localObject1 = this.d.get(null);
      return localObject1;
    }
    catch (ClassCastException localClassCastException)
    {
      break label60;
    }
    throw new IllegalArgumentException("unable to cast object");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hr.a
 * JD-Core Version:    0.7.0.1
 */